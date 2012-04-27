/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package de.jevopi.mitra2.engine.interpreter;

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.VOID;
import static de.jevopi.mitra2.nativeoperations.NativeOperationResolver.containsIteratorExpression;
import static de.jevopi.mitra2.nativeoperations.NativeOperationResolver.getIteratorExpressionLoopVariable;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.metamodel.FeatureAccessPath;
import de.jevopi.mitra2.metamodel.FeatureDescription;
import de.jevopi.mitra2.metamodel.FeatureFieldDescription;
import de.jevopi.mitra2.metamodel.FeaturePathItem;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.metamodel.StaticAccessPath;
import de.jevopi.mitra2.metamodel.VariableAccessPath;
import de.jevopi.mitra2.mitra.Assignment;
import de.jevopi.mitra2.mitra.AssignmentOperator;
import de.jevopi.mitra2.mitra.ClassInstanceCreationExpression;
import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.FeatureField;
import de.jevopi.mitra2.mitra.FeatureMethodInvocation;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.PPOperator;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.StaticAccess;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;
import de.jevopi.mitra2.nativeoperations.NativeOperationResolver;

/**
 * MObjectAccessPolicy There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class MObjectAccessPolicy extends ExecutionPolicy {

	static List<Type> NO_TYPES = emptyList();

	/**
	 * @param host
	 */
	public MObjectAccessPolicy(Interpreter host) {
		super(host);
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseAssignment(Assignment)
	 */
	public MObject[] caseAssignment(Assignment assignment) {
		List<VariableAccess> faLHS = assignment.getLhs();
		AssignmentOperator op = assignment.getOperator();

		// evaluate right hand side
		// todo this becomes an array, i.e visit returns an array!
		MObject[] newValues = host.visit(assignment.getExpression());

		if (faLHS.size() != newValues.length) {
			runtimeError("Error setting feature, expected " + faLHS.size()
				+ " objects, but right hand side returned " + newValues.length,
					assignment);
			throw new MitraError();
		}

		if (faLHS.size() != 1 && op != AssignmentOperator.SET) {
			runtimeError(
					"Error setting feature, list operation can handle only one object, were "
						+ faLHS.size(), assignment);
			throw new MitraError();
		}

		MObject[] result = new MObject[newValues.length];

		for (int i = 0; i < newValues.length; i++) {

			VarDeclaration variable = faLHS.get(i).getVariable();
			MObject varValue = host.currentStackFrame().getValue(variable);

			// convert left hand side to feature path,
			// i.e. evaluate all expressions (in METHOD invocations or ITEM
			// accesses
			VariableAccessPath<MObject> featurePath =
				evaluateToFeaturePath(faLHS.get(i));

			if (featurePath.size() == 0) {
				if (op == AssignmentOperator.SET) {
					// simple variable access (x = ..)
					host.currentStackFrame().setValue(variable, newValues[i]);
					result[i] = newValues[i];
				} else {
					result[i] =
						host.getMetamodelManager().setFeature(varValue,
								featurePath, newValues[i], op);
					host.currentStackFrame().setValue(variable, result[i]);

				}
			} else {
				result[i] =
					host.getMetamodelManager().setFeature(varValue,
							featurePath, newValues[i], op);

			}

			watchContainment(varValue, featurePath, newValues[i], assignment);
		}

		return result;
	}

	private void watchContainment(MObject receiver,
			VariableAccessPath<MObject> featurePath, MObject newValue,
			Assignment assignment) {
		if (newValue.getValue() instanceof EObject) {
			EObject eobj = (EObject) newValue.getValue();
			if (eobj.eContainer() == null
				&& !(assignment.getExpression() instanceof ClassInstanceCreationExpression)) {
				runtimeWarning("Set " + featurePath
					+ " to uncontained element " + eobj, assignment);
			}
		}

	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseVariableAccess(VariableAccess)
	 */
	public MObject[] caseVariableAccess(VariableAccess featureAccess) {

		VariableAccessPath<MObject> featurePath =
			evaluateToFeaturePath(featureAccess);
		VarDeclaration variable = featureAccess.getVariable();

		MObject obj = host.currentStackFrame().getValue(variable);

		MObject value = evaluateFeaturePath(featurePath, obj);
		if (featureAccess.getPrefixOperator() != PPOperator.NULL) {
			value =
				host.operations.evalPrePostfixOperation(
						featureAccess.getPrefixOperator(), value);
			host.currentStackFrame().setValue(variable, value);
		}
		if (featureAccess.getPostfixOperator() != PPOperator.NULL) {
			MObject varValue =
				host.operations.evalPrePostfixOperation(
						featureAccess.getPostfixOperator(), value);
			host.currentStackFrame().setValue(variable, varValue);
		}
		return new MObject[] {
			value
		};
	}

	/**
	 * @param i_staticAccess
	 * @return
	 */
	public MObject[] caseStaticAccess(StaticAccess staticAccess) {

		StaticAccessPath<MObject> featurePath =
			evaluateToFeaturePath(staticAccess);

		MObject value = evaluateStaticPath(featurePath);
		return new MObject[] {
			value
		};

	}

	/**
	 * @see {@link StaticRuleBinder#caseFeatureAccess(VariableAccess)}
	 */
	protected StaticAccessPath<MObject> evaluateToFeaturePath(
			StaticAccess staticAccess) {

		Type receiverType = null;
		if (staticAccess.getType() == null) { // => expression!=null
			MObject dynType = visitSingleton(staticAccess.getExpression());

			if (dynType.getActualType() != PrimitiveMetamodel.TYPE) {
				runtimeError(
						"expression must evaluate to Type, was "
							+ dynType.getActualType(), staticAccess);
				throw new MitraError();
			}
			if (dynType.getValue() instanceof ReferenceType) {
				receiverType = (ReferenceType) dynType.getValue();
			} else {
				runtimeError(
						"Type must be a ReferenceType, was "
							+ dynType.getActualType(), staticAccess);
				throw new MitraError();
			}
		} 

		StaticAccessPath<MObject> featurePath =
			new StaticAccessPath<MObject>(staticAccess, receiverType);
		List<Feature> features = staticAccess.getFeatures();
		evaluateToFeaturePath(features, featurePath, false);
		return featurePath;
	}

	/**
	 * @see {@link StaticRuleBinder#caseFeatureAccess(VariableAccess)}
	 */
	protected VariableAccessPath<MObject> evaluateToFeaturePath(
			VariableAccess featureAccess) {
		VariableAccessPath<MObject> featurePath =
			new VariableAccessPath<MObject>(host.getProjectContext(),
				featureAccess);
		List<Feature> features = featureAccess.getFeatures();
		evaluateToFeaturePath(features, featurePath, false);
		return featurePath;
	}

	protected void evaluateToFeaturePath(List<Feature> features,
			FeatureAccessPath<MObject> io_featurePath, boolean isStatic) {

		if (features.size() == 0) {
			return;
		}

		Feature feature = features.get(0);
		FeaturePathItem<MObject> pathItem;
		Type receiverType = io_featurePath.getReceiverType();

		for (int i = 0; i < features.size(); i++) {
			feature = features.get(i);

			if (feature instanceof FeatureField) {
				FeatureFieldDescription fieldDescription =
					(FeatureFieldDescription) host.getMetamodelManager()
						.evalFeature(receiverType, feature, NO_TYPES,
								PrimitiveMetamodel.VOID);

				pathItem =
					new FeaturePathItem<MObject>(feature, fieldDescription);
				io_featurePath.add(pathItem);
				receiverType = fieldDescription.getType();
			} else if (feature instanceof FeatureMethodInvocation
				|| feature instanceof NativeOperationInvocation) {

				List<Expression> arguments;
				Type iteratorLoopVarType;
				IteratorExpression iteratorExpression;
				if (feature instanceof NativeOperationInvocation) {
					NativeOperationInvocation nativeOperationInvocation =
						(NativeOperationInvocation) feature;
					if (containsIteratorExpression(nativeOperationInvocation)) {
						iteratorExpression =
							(IteratorExpression) nativeOperationInvocation
								.getArguments().get(0);
						arguments =
							singletonList(iteratorExpression.getExpression());
						iteratorLoopVarType =
							getTypeResolver()
								.visitSingleton(
										getIteratorExpressionLoopVariable(nativeOperationInvocation));

					} else {
						arguments = nativeOperationInvocation.getArguments();
						iteratorLoopVarType = VOID;
						iteratorExpression = null;
					}
				} else {
					FeatureMethodInvocation featureMethodInvocation =
						(FeatureMethodInvocation) feature;
					arguments = featureMethodInvocation.getArguments();
					iteratorLoopVarType = VOID;
					iteratorExpression = null;
				}

				List<MObject> args = new ArrayList<MObject>(arguments.size());
				List<Type> argumentOrIteratorExpTypes;

				if (iteratorExpression != null) {
					argumentOrIteratorExpTypes =
						asList(host.getTypeResolver().visitList(arguments));
				} else {
					argumentOrIteratorExpTypes =
						new ArrayList<Type>(arguments.size());
					for (Expression arg : arguments) {
						MObject[] argument = host.visit(arg);
						if (argument.length != 1) {
							runtimeError(
									"Each argument must contain one object, were "
										+ argument.length,
									io_featurePath.getLocation());
							throw new MitraError();
						}

						args.add(argument[0]);
						argumentOrIteratorExpTypes.add(argument[0]
							.getActualType());
					}
				}
				FeatureDescription fieldDescription =
					host.getMetamodelManager().evalFeature(receiverType,
							feature, argumentOrIteratorExpTypes,
							iteratorLoopVarType);
				pathItem =
					new FeaturePathItem<MObject>(feature, fieldDescription,
						args, iteratorExpression);
				io_featurePath.add(pathItem);
				receiverType = fieldDescription.getType();
			}

		} // end for

	}

	private MObject evaluateFeaturePath(
			VariableAccessPath<MObject> featurePath, MObject i_mobj) {

		MObject mobj =
			host.getMetamodelManager().getFeature(i_mobj, featurePath);

		return mobj;
	}

	private MObject evaluateStaticPath(StaticAccessPath<MObject> featurePath) {
		MObject mobj = host.getMetamodelManager().getStaticFeature(featurePath);
		return mobj;
	}

}
