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

import static de.jevopi.mitra2.MitraUtils.collectRuleParameters;
import static de.jevopi.mitra2.MitraUtils.fqn;
import static de.jevopi.mitra2.MitraUtils.isTraced;
import static de.jevopi.mitra2.MitraUtils.retrieveContainingRule;
import static de.jevopi.mitra2.MitraUtils.retrieveModule;
import static java.util.Collections.emptyList;

import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.api.IJavaMitraRule;
import de.jevopi.mitra2.api.IMultiReturn;
import de.jevopi.mitra2.context.ContextAwareTraversingVisitor;
import de.jevopi.mitra2.engine.debug.DebugEventType;
import de.jevopi.mitra2.engine.interpreter.TraceRegistry.DeclTracePair;
import de.jevopi.mitra2.message.MessageFormatter;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.mitra.Assignment;
import de.jevopi.mitra2.mitra.Block;
import de.jevopi.mitra2.mitra.BlockStatement;
import de.jevopi.mitra2.mitra.BooleanExpression;
import de.jevopi.mitra2.mitra.BooleanLiteral;
import de.jevopi.mitra2.mitra.BreakStatement;
import de.jevopi.mitra2.mitra.ClassInstanceCreationExpression;
import de.jevopi.mitra2.mitra.DoStatement;
import de.jevopi.mitra2.mitra.EmptyStatement;
import de.jevopi.mitra2.mitra.EqualityExpression;
import de.jevopi.mitra2.mitra.ExpressionStatement;
import de.jevopi.mitra2.mitra.ForStatement;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.IfStatement;
import de.jevopi.mitra2.mitra.InferredVarDeclaration;
import de.jevopi.mitra2.mitra.InstanceOfExpression;
import de.jevopi.mitra2.mitra.IntLiteral;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.JavaSpec;
import de.jevopi.mitra2.mitra.LocalVariableDeclaration;
import de.jevopi.mitra2.mitra.MathExpression;
import de.jevopi.mitra2.mitra.MitraFactory;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.NullLiteral;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.ParameterModifier;
import de.jevopi.mitra2.mitra.Property;
import de.jevopi.mitra2.mitra.QualifiedParameterReference;
import de.jevopi.mitra2.mitra.QualifiedRuleReference;
import de.jevopi.mitra2.mitra.RealLiteral;
import de.jevopi.mitra2.mitra.RelationalExpression;
import de.jevopi.mitra2.mitra.ReturnParameter;
import de.jevopi.mitra2.mitra.ReturnStatement;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleInvocation;
import de.jevopi.mitra2.mitra.RuleInvocationSuper;
import de.jevopi.mitra2.mitra.RuleReference;
import de.jevopi.mitra2.mitra.Statement;
import de.jevopi.mitra2.mitra.StatementExpression;
import de.jevopi.mitra2.mitra.StaticAccess;
import de.jevopi.mitra2.mitra.StringLiteral;
import de.jevopi.mitra2.mitra.Trigger;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.UnaryBooleanExpression;
import de.jevopi.mitra2.mitra.UnaryCastExpression;
import de.jevopi.mitra2.mitra.UnaryMathExpression;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;
import de.jevopi.mitra2.mitra.WhileStatement;
import de.jevopi.mitra2.mitra.weak.WeakMitraFactory;
import de.jevopi.mitra2.traces.Trace;
import de.jevopi.mitra2.traces.TraceElement;
import de.jevopi.mitra2.traces.TraceRecord;
import de.jevopi.mitra2.traces.TracesFactory;
import de.jevopi.utils.ComposedIterable;

/**
 * Interpreter There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class Interpreter extends ContextAwareTraversingVisitor<MObject[]> {

	/*
	 * Constant values and logger
	 */

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(Interpreter.class
		.getName());

	public final static MObject[] A_VOID = new MObject[] {
		MObject.NOT_INITIALIZED
	};

	public final static MObject[] A_NULL = new MObject[] {
		MObject.NULL
	};

	public final static MObject[] A_TRUE = new MObject[] {
		MObject.TRUE
	};

	public final static MObject[] A_FALSE = new MObject[] {
		MObject.FALSE
	};

	public final static String NAME = "EXECUTION";

	/*
	 * Policies and Helpers
	 */

	/**
	 * Helper for matching triggers.
	 */
	TriggerMatcher triggerMatcher;

	DynamicRuleResolver resolver;

	OperationsPolicy operations;

	StatementsPolicy statementsPolicy;

	ExpressionsPolicy expressionsPolicy;

	MObjectAccessPolicy mobjectAccessPolicy;

	TracePolicy tracePolicy;

	int visitDepth = 0;

	/*
	 * *************************************************************************
	 * Per configuration
	 * **********************************************************************
	 */

	protected SessionContext sessionContext;

	protected ExecutionContext executionContext;

	/*
	 * *************************************************************************
	 * Per run:
	 * **********************************************************************
	 */

	/**
	 * Internal state
	 */
	ExecutionStack executionStack;

	private StackFrame currentStackFrame;

	private Stack<EObject> currentElementStack;

	private EObject currentElement;

	//
	/**
	 * flag used during loops and block to indicate a break statement
	 */
	boolean bBreak = false;

	/**
	 * flag used during rule execution to indicate a return statement
	 */
	boolean bReturn = false;

	/*
	 * *************************************************************************
	 * **********************************************************************
	 */

	public Interpreter(SessionContext sessionContext,
			ExecutionContext executionContext) {
		super(sessionContext.getProjectContext(), A_VOID);
		this.sessionContext = sessionContext;
		this.executionContext = executionContext;

		createPolicies();

		currentElementStack = new Stack<EObject>();
		executionStack = new ExecutionStack();
		currentStackFrame = null;
		currentElement = null;

		resolver = new DynamicRuleResolver(getProjectContext());
		if (getProjectContext().getInterpreter() != null) {
			throw new IllegalArgumentException(
				"Wrong interpreter set in project context");
		}
		getProjectContext().setInterpreter(this);

	}

	public void runtimeError(String message, Throwable ex) {
		runtimeError(message, currentElement, ex);
	}

	public void runtimeError(String message) {
		runtimeError(message, currentElement);
	}

	public EObject getCurrentElement() {
		return currentElement;
	}

	/**
	 * Convenience method, as {@link VarDeclaration#getType()} may return null
	 * in case of {@link InferredVarDeclaration}.
	 * 
	 * @param varDeclaration
	 * @return
	 * @since Feb 6, 2012
	 */
	protected Type getType(VarDeclaration varDeclaration) {
		Type type = varDeclaration.getType();
		if (type == null) {
			type = getTypeResolver().caseVarDeclaration(varDeclaration)[0];
		}
		return type;
	}

	/**
	 * 
	 */
	protected void createPolicies() {
		statementsPolicy = new StatementsPolicy(this);
		expressionsPolicy = new ExpressionsPolicy(this);
		mobjectAccessPolicy = new MObjectAccessPolicy(this);
		operations = new OperationsPolicy(this);
		tracePolicy = new TracePolicy(this);
	}

	/*
	 * *************************************************************************
	 * **********************************************************************
	 */

	/**
	 * 
	 */
	public void run() {
		try {
			final MObject[] parameters =
				new MObject[executionContext.getArguments().size()];
			executionContext.getArguments().toArray(parameters);

			TransactionalEditingDomain domain =
				findTransactionalDomain(parameters);
			if (domain != null) {
				if (log.isLoggable(Level.INFO)) {
					log.info("At least one argument is part of a transaction, running Mitra in that transaction (" + domain.getID() + ")."); //$NON-NLS-1$
				}

				IUndoableOperation operation =
					new AbstractEMFOperation(domain, "Mitra Interpreter") {
						@Override
						protected IStatus doExecute(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							doRun(parameters);
							return Status.OK_STATUS;
						}
					};
				try {
					operation.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException ex) {
					runtimeError("Error executing in transaction", ex);
					throw new MitraError();
				}
			} else {
				// run w/o domain and operation stuff
				doRun(parameters);
			}
		} catch (Throwable ex) {
			runtimeError("Unexpected error: " + ex, ex);
			ex.printStackTrace();
		}
	}

	private TransactionalEditingDomain findTransactionalDomain(
			MObject[] parameters) {
		TransactionalEditingDomain domain = null;
		int i = 0;
		for (FormalParameter fpar : executionContext.getInvokedRule()
			.getFormalParameters()) {
			if (fpar.getModifier() != ParameterModifier.FROM
				&& parameters[i].getValue() instanceof EObject) {
				domain =
					TransactionUtil.getEditingDomain(parameters[i].getValue());
				if (domain != null) {
					break;
				}
			}
			i++;
		}
		if (domain == null) {
			for (MObject mobj : parameters) {
				if (mobj.getValue() instanceof EObject) {
					domain = TransactionUtil.getEditingDomain(mobj.getValue());
					if (domain != null) {
						break;
					}
				}
			}
		}
		return domain;
	}

	public void doRun(MObject[] arguments) {

		RuleDeclaration invokedRule = executionContext.getInvokedRule();

		StackFrame initStackFrame = new StackFrame(invokedRule, null); // ExecutionStack
		// .
		// ROOT)
		// ;
		pushStackFrame(initStackFrame);
		initStackFrame.enterBlock();

		RuleInvocation invoc = initRuleInvocation(invokedRule, arguments);

		if (log.isLoggable(Level.INFO)) {
			log.info("Execute rule " + invoc.getRuleDeclaration());
			// log.info(String.valueOf(executionStack.getCurrentScopeStack()));
		}

		try {
			MObject[] returnValues = visit(invoc);

			// copy results to executionContext
			Map<String, MObject> results = executionContext.getResults();
			List<ReturnParameter> retParams =
				invoc.getRuleDeclaration().getReturnParameters();
			for (int i = 0; i < returnValues.length; i++) {
				results.put(retParams.get(i).getVardecl().getName(),
						returnValues[i]);
			}

			initStackFrame.leaveBlock();

			if (log.isLoggable(Level.INFO)) {
				log.info("Results:");
				log.info(String.valueOf(executionStack));
			}

		} catch (MitraError mitraError) {
			throw mitraError;
		} catch (Throwable ex) {
			runtimeError("Unexpecteded error: " + ex, ex);
			throw new MitraError();
		}

	}

	protected void waitForNextStep() {
		// only implemented in debuggable interpreter
	}

	protected void confirm(@SuppressWarnings("unused") DebugEventType event) {
		// only implemented in debuggable interpreter
	}

	/*
	 * *************************************************************************
	 * **********************************************************************
	 */

	@Override
	public MObject[] visit(EObject i_element) {
		visitDepth++;
		try {
			if (i_element != null) {
				pushCurrentElement(i_element);

				if (visitDepth == 400) {
					checkCallCycle();
				}

				if (waitAt(i_element)) {
					waitForNextStep();
				}

				if (i_element instanceof Block) {
					confirm(DebugEventType.block_enter);
				}

				MObject[] returnValues;
				try {
					if (delegator != this) {
						returnValues = delegator.doSwitch(i_element);
					} else {
						// directly call doSwitch(int,EObject) method to reduce stack load
						returnValues =
							doSwitch(i_element.eClass().getClassifierID(),
									i_element);
					}
				} catch (Throwable ex) {
					if (ex instanceof MitraError) {
						throw (MitraError) ex;
					}
					runtimeError(ex.getMessage(), ex);
					throw new MitraError();
				}

				if (i_element instanceof Block) {
					confirm(DebugEventType.block_left);
				}
				popCurrentElement();
				return returnValues;

			}
			return getDefaultReturnValue();
		} finally {
			if (visitDepth > 0) visitDepth--;
		}
	}

	private void checkCallCycle() {
		Map<Integer, Entry<RuleDeclaration, Integer>> countOccurrences =
			new HashMap<Integer, Map.Entry<RuleDeclaration, Integer>>();
		for (StackFrame sf : executionStack.getStackFrames()) {
			int code = sf.getIDCode();
			Entry<RuleDeclaration, Integer> entry = countOccurrences.get(code);
			if (entry == null) {
				entry =
					new AbstractMap.SimpleEntry<RuleDeclaration, Integer>(
						sf.getRuleDeclaration(), 1);
				countOccurrences.put(code, entry);
			} else {
				entry.setValue(entry.getValue() + 1);
			}
		}

		List<Map.Entry<RuleDeclaration, Integer>> mostOften =
			new ArrayList<Map.Entry<RuleDeclaration, Integer>>();
		for (Map.Entry<RuleDeclaration, Integer> e : countOccurrences.values()) {
			if (e.getValue() > 5) {
				mostOften.add(e);
			}
		}
		Collections.sort(mostOften,
				new Comparator<Map.Entry<RuleDeclaration, Integer>>() {

					@Override
					public int compare(Entry<RuleDeclaration, Integer> o1,
							Entry<RuleDeclaration, Integer> o2) {
						return o2.getValue() - o1.getValue();
					}
				});

		int max = Math.min(10, mostOften.size());
		StringBuilder strb = new StringBuilder();
		strb.append("Found possible cyle in call graph, most often called rules with same parameters: ");
		for (int i = 0; i < max; i++) {
			strb.append("\n  ")
				.append(mostOften.get(i).getValue())
				.append("x ")
				.append(MessageFormatter.stackTraceLikeLocation(mostOften
					.get(i).getKey()));
		}

		strb.append("\n");
		strb.append(executionStack.toString());
		strb.append("\nHint: Replace return parameter with create parameter.\nCycle detected ");
		runtimeWarning(strb.toString(), currentElement);
		visitDepth = 0;
	}

	private boolean waitAt(EObject element) {
		if (element instanceof Statement) {
			return !(element instanceof EmptyStatement);
		}
		if (element instanceof StatementExpression) {
			if (element instanceof VariableAccess) {
				return false;

				//				for (Feature feature : ((VariableAccess) element).getFeatures()) {
				//					if (!(feature instanceof FeatureField)) return true;
				//				}
				//				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Sub-method of {@link #visit(EObject)}.
	 */
	private void popCurrentElement() {
		currentElement = currentElementStack.pop();
		getProjectContext().setCurrentInterpreterLocation(currentElement);
	}

	/**
	 * Sub-method of {@link #visit(EObject)}.
	 */
	private void pushCurrentElement(EObject i_element) {
		currentElementStack.push(currentElement);
		currentElement = i_element;
		getProjectContext().setCurrentInterpreterLocation(currentElement);
	}

	List<EObject> getElementStack() {
		return Collections.unmodifiableList(currentElementStack);
	}

	/**
	 * Returns unmofifiable list of stackframes, delegates to
	 * {@link ExecutionStack#getStackFrames()}.
	 * 
	 * @see de.feu.mitra.engine.debugapi.IDebuggable#getStackFrames()
	 */
	public List<StackFrame> getStackFrames() {
		return executionStack.getStackFrames();
	}

	/**
	 * @see de.feu.mitra.engine.debugapi.IDebuggable#getStackFrame(de.feu.mitra.RuleDeclaration)
	 */
	public StackFrame getStackFrame(int id) {
		for (StackFrame stackFrame : executionStack.getStackFrames()) {
			if (stackFrame.getID() == id) {
				return stackFrame;
			}
		}
		return null;
	}

	/**
	 * Returns the current stackframe. This method is only to be used by
	 * policies and native methods.
	 * 
	 * @return
	 */
	public StackFrame currentStackFrame() {
		return currentStackFrame;
	}

	private void pushStackFrame(StackFrame newFrame) {
		executionStack.push(newFrame);
		currentStackFrame = newFrame;
	}

	private void popStackFrame() {
		executionStack.pop();
		currentStackFrame = executionStack.peek();
	}

	/**
	 * This method is only to be used by policies and native methods.
	 */
	public void enterBlock() {
		currentStackFrame.enterBlock();
	}

	/**
	 * This method is only to be used by policies and native methods.
	 */
	public void leaveBlock() {
		currentStackFrame.leaveBlock();
	}

	/**
	 * Convenience method, returns {@link MetamodelManager#getMetamodel(Type)}.
	 * 
	 * @param actualtype
	 * @return
	 * @throws MetamodelNotFoundException
	 */
	protected IMetamodel getMetamodel(Type type)
			throws MetamodelNotFoundException {
		return getMetamodelManager().getMetamodel(type);
	}

	/**
	 * Sub-method of {@link #doRun(MObject[])}, called to simulate initial rule
	 * invocation.
	 * 
	 * Precondition: Current stackframe is prepared. Called by
	 * {@link #doRun(MObject[])}, declares (externally defined) parameters as
	 * arg0...argN.
	 * 
	 * @param rule
	 * @param args
	 * @return
	 */
	private RuleInvocation initRuleInvocation(RuleDeclaration rule,
			MObject[] args) {
		RuleInvocation invoc = MitraFactory.eINSTANCE.createRuleInvocation();

		invoc.setRuleDeclaration(rule);
		int i = 0;
		for (MObject arg : args) {

			VarDeclaration varDeclaration =
				WeakMitraFactory.createVarDeclaration();
			varDeclaration.setName("arg" + i);
			varDeclaration.setType(arg.getActualType());

			VariableAccess variableAccess =
				MitraFactory.eINSTANCE.createVariableAccess();
			variableAccess.setVariable(varDeclaration);

			invoc.getArguments().add(variableAccess);

			currentStackFrame().declareVariable(varDeclaration);
			currentStackFrame().setValue(varDeclaration, arg);
			i++;
		}
		return invoc;
	}

	/**
	 * Invokes a rule which is simply called by name. If the rule is overloaded,
	 * the best matching super rule is invoked. The actual invocation is
	 * performed by
	 * {@link #invokeRule(RuleInvocation, RuleDeclaration, MObject[])}.
	 * 
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseRuleInvocation(de.jevopi.mitra2.mitra.RuleInvocation)
	 */
	@Override
	public MObject[] caseRuleInvocation(RuleInvocation ruleInvocation) {

		RuleDeclaration decl = ruleInvocation.getRuleDeclaration();
		// if (log.isLoggable(Level.INFO)) {
		//			log.info("call rule " + decl); //$NON-NLS-1$
		// }

		MObject[] parameters = evaluateRuleInvocationParameters(ruleInvocation);

		// resolve called rule dynamically, handle dynamic binding:
		if (getOverridingRules(decl) != null) {
			RuleDeclaration dynamicDecl =
				resolver.resolveRuleDynamically(ruleInvocation, parameters);

			if (dynamicDecl != null) {
				decl = dynamicDecl;
			}
		}

		return invokeRule(decl, parameters);

	}

	@Override
	public MObject[] caseExpressionStatement(
			ExpressionStatement expressionStatement) {
		return visit(expressionStatement.getStatementExpression());
	}

	/**
	 * Invokes a super rule from an overloading rule. If the overloading rule
	 * overloads several rules, the actual super rule is calculated bases on the
	 * name used when invoking the overloading rule. The actual invocation is
	 * performed by
	 * {@link #invokeRule(RuleInvocation, RuleDeclaration, MObject[])}.
	 * 
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseRuleInvocationSuper(de.feu.mitra.RuleInvocationSuper)
	 */
	@Override
	public MObject[] caseRuleInvocationSuper(
			RuleInvocationSuper ruleInvocationSuper) {

		RuleDeclaration currentRuleDecl =
			retrieveContainingRule(ruleInvocationSuper);

		MObject[] parameters =
			new MObject[currentRuleDecl.getFormalParameters().size()];
		for (int i = 0; i < currentRuleDecl.getFormalParameters().size(); i++) {
			parameters[i] =
				currentStackFrame.getValue(currentRuleDecl
					.getFormalParameters().get(i).getVardecl());
		}
		MObject[] returnParameters =
			new MObject[currentRuleDecl.getReturnParameters().size()];
		for (int i = 0; i < currentRuleDecl.getReturnParameters().size(); i++) {
			returnParameters[i] =
				currentStackFrame.getValue(currentRuleDecl
					.getReturnParameters().get(i).getVardecl());
		}

		RuleDeclaration superRuleDecl =
			currentRuleDecl.getOverriddenRule().getRuleDeclaration();
		if (superRuleDecl == null) {
			runtimeError("Cannot find super rule");
			throw new MitraError();
		}
		MObject[] rets =
			executeSuperRule(superRuleDecl, parameters, returnParameters);

		for (int i = 0; i < currentRuleDecl.getReturnParameters().size(); i++) {
			currentStackFrame.setValue(currentRuleDecl.getReturnParameters()
				.get(i).getVardecl(), rets[i]);

		}

		return getDefaultReturnValue();

	}

	/**
	 * Sub-method of {@link #caseRuleInvocation(RuleInvocation)}, set parameters
	 * (also used for resolving rule dynamically) of a rule invocation. Note: We
	 * can use the initial declaration for retrieving all arguments and also for
	 * return and create parameters, since the latter two cannot be changed by
	 * overloaded rules.
	 * 
	 * @todo refactor MObject: distinguish between declared and actual
	 *       actualtype!
	 * @param ruleInvocation
	 * @return
	 */
	private MObject[] evaluateRuleInvocationParameters(
			RuleInvocation ruleInvocation) {

		// only formal parameters are checked, not return parameters
		// since actualtype of receiving variables is not known here
		MObject[] parameters =
			new MObject[ruleInvocation.getArguments().size()];
		for (int i = 0; i < ruleInvocation.getArguments().size(); i++) {
			MObject[] values = visit(ruleInvocation.getArguments().get(i));

			if (values.length != 1) {
				runtimeError("Argument " + i + " actually is " + values.length
					+ " objects, only one object can be used as argument",
						ruleInvocation);
				throw new MitraError();
			}

			parameters[i] = values[0];

		}
		return parameters;
	}

	/**
	 * Actually invokes a rule, called by
	 * {@link #caseRuleInvocationByName(RuleInvocationByName)} and
	 * {@link #caseRuleInvocationSuper(RuleInvocationSuper)}
	 * 
	 * @param decl
	 * @param parameters
	 * @return
	 */
	private MObject[] invokeRule(RuleDeclaration decl, MObject[] parameters) {
		// is rule cached?

		MObject[] cachedResult = findCachedRuleResult(decl, parameters);
		if (cachedResult != null) return cachedResult;

		checkExcluded(decl, parameters);

		// no cached results found, actually execute called rule
		MObject[] rets = executeCalledRule(decl, parameters);

		return rets;
	}

	private void checkExcluded(RuleDeclaration decl, MObject[] parameters) {
		for (RuleReference refExclude : decl.getExcludingRules()) {
			RuleDeclaration excludedRuleDecl = refExclude.getRuleDeclaration();
			// set in RuleHierachyCreator
			List<Trace> excludingTraces =
				sessionContext.getTraceRegistry().getTraces(excludedRuleDecl);
			if (excludingTraces != null && !excludingTraces.isEmpty()) {
				int parPos = 0;
				for (Trace trace : excludingTraces) {
					parPos = 0;
					for (TraceElement element : trace.getElements()) {
						MObject mObject =
							tracePolicy.getTraceElementValue(element);
						switch (element.getTraceType()) {
						case SOURCE:
						case USED:
							if (mObject.equals(parameters[parPos])) {
								parPos++;
							} else {
								parPos = -1;
							}
							break;

						}
						if (parPos < 0) {
							break;
						}
					}
					if (parPos >= 0) {
						break;
					}
				}
				if (parPos >= 0) {
					// found excluding rule
					runtimeError("Rule cannot be executed since excluding rule "
						+ excludedRuleDecl + " has been executed before");
					throw new MitraError();
				}
			}
		}
	}

	private MObject[] findCachedRuleResult(RuleDeclaration decl,
			MObject[] parameters) {
		List<Trace> traces = sessionContext.getTraceRegistry().getTraces(decl);
		if (traces != null && !traces.isEmpty()) {
			MObject[] cachedResult =
				new MObject[decl.getReturnParameters().size()];
			int parPos = 0;
			int resultPos = 0;
			for (Trace trace : traces) {
				parPos = 0;
				resultPos = 0;
				for (TraceElement element : trace.getElements()) {
					MObject mObject = tracePolicy.getTraceElementValue(element);
					switch (element.getTraceType()) {
					case SOURCE:
					case USED:
						if (mObject.equals(parameters[parPos])) {
							parPos++;
						} else {
							parPos = -1;
						}
						break;
					case TARGET:
						if (resultPos < cachedResult.length) {
							cachedResult[resultPos] = mObject;
							resultPos++;
						} else {
							parPos = -1;
						}
					}
					if (parPos < 0) {
						break;
					}
				}
				if (parPos >= 0) {
					break;
				}
			}
			if (parPos >= 0 && resultPos == cachedResult.length) {
				// found cached result
				return cachedResult;
			}
		}
		return null;

	}

	/**
	 * <p>
	 * Called by {@link #caseRuleInvocation(RuleInvocation)} and
	 * {@link #caseTrigger(Trigger)}.
	 * 
	 * @param location ruleinvocation or trigger
	 * @param decl the rule to be executed
	 */
	private MObject[] executeCalledRule(RuleDeclaration decl,
			MObject[] parameters) {

		// TODO test number of parameters equals formal parameters
		confirm(DebugEventType.rule_enter);

		pushStackFrame(new StackFrame(decl, currentElement));
		currentStackFrame().enterBlock();

		// 1) Copy parameters on stack
		// push parameters on stack (with names of actual rule parameters)
		for (int i = 0; i < parameters.length; i++) {
			Parameter fpar = decl.getFormalParameters().get(i);
			currentStackFrame().declareVariable(fpar.getVardecl());
			currentStackFrame().setValue(fpar.getVardecl(), parameters[i]);
		}

		MObject[] rets = visitBodyAndHandleTracing(decl);

		// leave called rule
		popStackFrame();

		confirm(DebugEventType.rule_left);

		return rets;

	}

	/**
	 * @param decl
	 * @return
	 * @throws MitraError
	 */
	private MObject[] visitBodyAndHandleTracing(RuleDeclaration decl)
			throws MitraError {
		// 2) Create return parameters on stack
		boolean bAllInitialized = pushReturnParametersOnStack(decl);
		boolean traced = isTraced(decl);
		List<DeclTracePair> createdTraces = emptyList();
		if (traced && bAllInitialized) {
			createdTraces = createTraceWithParametersFromStack(decl);
		}

		// 3) visit rule:
		bReturn = false;

		if (decl.getBody() != null) {
			visit(decl.getBody());
		} else if (decl.getJavaSpec() != null) {
			visit(decl.getJavaSpec());
		} else {
			runtimeError("Cannot execute rule " + decl);
			throw new MitraError();
		}

		bReturn = false;

		// return values
		MObject[] rets = retrieveReturnValuesFromStack(decl);

		// 4) tracing
		if (traced) {
			if (!bAllInitialized) {
				createdTraces = createTraceWithParametersFromStack(decl);
			}
			triggerRulesAfterBody(createdTraces);
		}

		return rets;
	}

	/**
	 * Sub-method of
	 * {@link #executeCalledRule(EObject, RuleDeclaration, MObject[])}.
	 * 
	 * @param decl
	 * @return
	 * @throws MitraError
	 */
	private MObject[] retrieveReturnValuesFromStack(RuleDeclaration decl)
			throws MitraError {
		MObject[] rets = new MObject[decl.getReturnParameters().size()];
		for (int i = 0; i < rets.length; i++) {
			Parameter rpar = decl.getReturnParameters().get(i);
			rets[i] = currentStackFrame().getValue(rpar.getVardecl());
			if (rets[i] == MObject.NOT_INITIALIZED) {
				runtimeError("Parameter " + rpar + " not set");
				throw new MitraError();
			}
		}
		return rets;
	}

	/**
	 * <p>
	 * Called by {@link #caseRuleInvocationSuper(RuleInvocation)} and
	 * {@link #caseTrigger(Trigger)}.
	 * 
	 */
	private MObject[] executeSuperRule(RuleDeclaration decl,
			MObject[] parameters, MObject[] returnParameters) {

		// TODO test number of parameters equals formal parameters
		confirm(DebugEventType.rule_enter);

		pushStackFrame(new StackFrame(decl, currentElement));
		currentStackFrame().enterBlock();

		// 1) Copy parameters on stack
		// push parameters on stack (with names of actual rule parameters)
		for (int i = 0; i < parameters.length; i++) {
			FormalParameter fpar = decl.getFormalParameters().get(i);
			currentStackFrame().declareVariable(fpar.getVardecl());
			currentStackFrame().setValue(fpar.getVardecl(), parameters[i]);
		}

		// 2) Create return parameters on stack
		for (int i = 0; i < returnParameters.length; i++) {
			ReturnParameter rpar = decl.getReturnParameters().get(i);
			currentStackFrame().declareVariable(rpar.getVardecl());
			currentStackFrame()
				.setValue(rpar.getVardecl(), returnParameters[i]);

			if (rpar.getModifier() == ParameterModifier.CREATE
				&& returnParameters[i] == MObject.NOT_INITIALIZED) {
				// implicitly create new instances for create parameters
				Type type = getType(rpar.getVardecl());
				IMetamodel metamodel;
				try {
					metamodel = getMetamodel(type);
				} catch (MetamodelNotFoundException ex) {
					runtimeError("Error initializing return parameter " + rpar,
							decl, ex);
					throw new MitraError();
				}
				MObject newInstance = metamodel.createInstance(type);
				currentStackFrame().setValue(rpar.getVardecl(), newInstance);
			}
		}

		// 3) visit rule:
		bReturn = false;

		if (decl.getBody() != null) {
			visit(decl.getBody());
		} else if (decl.getJavaSpec() != null) {
			visit(decl.getJavaSpec());
		} else {
			runtimeError("Cannot execute rule " + decl);
			throw new MitraError();
		}

		bReturn = false;

		// return values
		MObject[] rets = new MObject[decl.getReturnParameters().size()];
		for (int i = 0; i < rets.length; i++) {
			Parameter rpar = decl.getReturnParameters().get(i);
			rets[i] = currentStackFrame().getValue(rpar.getVardecl());
			// if (returnValue.getValue() == null) {
			// throw new CompileError(location, "Parameter {0} not set", rpar);
			// }
		}

		// no tracing, tracing is handled by overloading rule
		// handleTracing(location, decl);

		// leave called rule
		popStackFrame();

		confirm(DebugEventType.rule_left);

		return rets;

	}

	/**
	 * @param decl
	 * @throws IllegalArgumentException
	 * @throws MetamodelNotFoundException
	 */
	private List<DeclTracePair> createTraceWithParametersFromStack(
			RuleDeclaration decl) throws IllegalArgumentException,
			MetamodelNotFoundException {

		if (isTraced(decl)) {
			// 4) Save trace record, using formal parameters
			// TODO Check that parameters are defined in when or with
			Trace trace = createTrace(decl, currentStackFrame());
			if (trace != null) {
				List<DeclTracePair> allTraces =
					sessionContext.getTraceRegistry().registerTrace(trace);
				allTraces.add(0, new DeclTracePair(decl, trace));
				return allTraces;
			}
		}
		return emptyList();
	}

	/**
	 * @param decl
	 * @param trace
	 * @param registryAlradyInStealthMode
	 */
	private void triggerRulesAfterBody(List<DeclTracePair> createdTraces) {
		if (!createdTraces.isEmpty()) {
			RuleDeclaration currentDecl = createdTraces.get(0).decl;
			boolean registryAlradyInStealthMode =
				sessionContext.getTraceRegistry().isInStealthMode();
			if (currentDecl.isStealth() && !registryAlradyInStealthMode) {
				sessionContext.getTraceRegistry().activateStealthMode();
			}
			try {
				// directly triggered rules are called first, since the first
				// entry in the list is the trace created by the current rule,
				// derive traces follow
				for (DeclTracePair pair : createdTraces) {
					for (RuleDeclaration triggeredRule : getTriggeredRules(pair.decl)) {
						triggerRule(triggeredRule.getTrigger(), pair.trace);
					}
				}
			} finally {
				if (currentDecl.isStealth() && !registryAlradyInStealthMode) {
					sessionContext.getTraceRegistry().deactivateStealthMode();
				}
			}
		}
	}

	/**
	 * Precondition: Interpreter Stack is prepared, i.e. parameters are still on
	 * stack. Rule has been successfully executed.
	 * <p>
	 * Called by {@link #createTraceWithParametersFromStack(RuleDeclaration)}
	 * 
	 * @param location ruleinvocation or trigger, used for warnings only
	 * @param decl
	 * @param bHasReturnParameters
	 * @param bHasFromParameters
	 * @throws IllegalArgumentException
	 * @throws MetamodelNotFoundException
	 * @return Trace or null, if no trace stack is declared
	 */
	private Trace createTrace(RuleDeclaration decl, StackFrame ruleStack)
			throws IllegalArgumentException, MetamodelNotFoundException {
		// create trace if rule has from and return/create parameters
		Trace trace = null;

		TraceRecord traceRecord = sessionContext.getTraceRecord();
		if (traceRecord == null) {
			if (getTriggeredRules(decl).size() > 0) { // avoid
														// too
														// much
				warning("Cannot save trace, no trace record available. "
					+ "Triggered rules cannot be invoked",
						decl,
						decl.eClass().getEStructuralFeature(
								MitraPackage.RULE_DECLARATION__TRACED), -1);
			}
		} else {
			trace = TracesFactory.eINSTANCE.createTrace();
			trace.setRuleName(fqn(decl));
			trace.setTimestamp(System.currentTimeMillis());
			if (decl.getExec() != null) {
				trace.setRuleInfo(decl.getExec().getName());
			}

			for (Parameter fpar : collectRuleParameters(decl)) {
				MObject value = ruleStack.getValue(fpar.getVardecl());
				TraceElement traceElement =
					tracePolicy.createTraceElement(fpar, value);
				trace.getElements().add(traceElement);
			} // end fpar loop
			traceRecord.getTraces().add(trace);
		}

		return trace;
	}

	/**
	 * Called by {@link #caseRuleInvocation(RuleInvocation)}.
	 * 
	 * @param trigger a possibly triggered rule, i.e. its trigger declaration,
	 *            this rule contains the rule of the triggeringTrace
	 * @param triggeringTrace the trace which caused this call
	 * @param tiggeringDecl the rule (viz. declaration) which triggered the
	 *            process
	 * @return
	 */
	public void triggerRule(Trigger trigger, Trace triggeringTrace) {

		// the declaration of the rule which is possibly triggered:
		RuleDeclaration decl = (RuleDeclaration) trigger.eContainer();

		List<List<Trace>> results =
			triggerMatcher.resolveTriggerValues(trigger, triggeringTrace);

		for (List<Trace> traces : results) {
			// new stack frame for invocation:
			pushStackFrame(new StackFrame(decl, currentElement));

			// push parameters on stack (with names of actual rule parameters)
			// these paramaters are yet all null, of course
			for (Parameter fpar : decl.getFormalParameters()) {
				currentStackFrame().declareVariable(fpar.getVardecl());
			}

			// put all rule ref parameters on called Stack:
			// values are retrieved from trace, names from rule ref

			if (traces.size() != trigger.getTriggerRules().size()) {
				runtimeError("Found " + traces.size() + " traces, but "
					+ trigger.getTriggerRules().size()
					+ " triggering rules found", trigger);
				throw new MitraError();
			}

			// TODO: Important: order of triggers shouldn't matter, currently it
			// does, that is a bug!

			for (int i = 0; i < traces.size(); i++) {
				QualifiedRuleReference qruleRef =
					trigger.getTriggerRules().get(i);
				RuleDeclaration triggerRule = qruleRef.getRuleDeclaration();
				final int numberOfParameters =
					qruleRef.getParameterReferences().size()
						+ qruleRef.getReturnReferences().size();

				Trace trace = traces.get(i);

				if (trace.getElements().size() != numberOfParameters) {
					log.warning("Error in result:");
					log.warning(String.valueOf(triggerMatcher));

					runtimeError("Trace contains " + trace.getElements().size()
						+ " elements, need " + numberOfParameters
						+ "  parameters. Trace: " + trace + "@ trigger "
						+ triggerRule.getName(), trigger);
					throw new MitraError();
				}

				@SuppressWarnings("unchecked")
				Iterable<? extends QualifiedParameterReference> parameterReferences =
					ComposedIterable.compose(qruleRef.getParameterReferences(),
							qruleRef.getReturnReferences());

				int p = 0;
				for (QualifiedParameterReference pref : parameterReferences) {
					TraceElement traceElement = trace.getElements().get(p);
					MObject mobject =
						tracePolicy.getTraceElementValue(traceElement);

					// maybe this parameter was previously defined
					VarDeclaration vardecl =
						currentStackFrame.findVariableByName(pref.getVardecl()
							.getName());
					if (vardecl == null) {
						vardecl = pref.getVardecl();
						currentStackFrame().declareVariable(vardecl);
					}
					currentStackFrame().setValue(vardecl, mobject);
					p++;
				}
			}

			// evaluate with clause
			if (trigger.getWith() != null) {

				confirm(DebugEventType.rule_enter);

				visit(trigger.getWith());
			}

			// evaluate when clause
			MObject when = MObject.TRUE;
			if (trigger.getWhen() != null) {
				confirm(DebugEventType.block_enter);

				when = visit(trigger.getWhen())[0];
				confirm(DebugEventType.block_left);
			}

			if (when == MObject.TRUE) {
				confirm(DebugEventType.block_enter);

				// pushStackFrame(new StackFrame(this, decl));
				currentStackFrame().enterBlock();

				//copy parameters on stack no necessary, stack is prepared

				visitBodyAndHandleTracing(decl);

			} else { // when == FALSE

				if (log.isLoggable(Level.INFO)) {
					log.info("When evaluated to false for " + traces); //$NON-NLS-1$
				}
			}
			// leave called rule
			popStackFrame();

			confirm(DebugEventType.rule_left);

		}
	}

	/**
	 * 
	 * @param calledRuleDecl
	 * @return true, if no return parameter is not created
	 */
	private boolean pushReturnParametersOnStack(RuleDeclaration calledRuleDecl) {
		boolean allCreated = true;
		for (ReturnParameter rpar : calledRuleDecl.getReturnParameters()) {
			currentStackFrame().declareVariable(rpar.getVardecl());
			if (rpar.getModifier() == ParameterModifier.CREATE) {
				// implicitly create new instances for create parameters
				Type type = getType(rpar.getVardecl());
				IMetamodel metamodel;
				try {
					metamodel = getMetamodel(type);
				} catch (MetamodelNotFoundException ex) {
					runtimeError("Error initializing return parameter " + rpar,
							calledRuleDecl, ex);
					throw new MitraError();
				}
				MObject newInstance = metamodel.createInstance(type);
				currentStackFrame().setValue(rpar.getVardecl(), newInstance);
			} else {
				allCreated = false;
			}
		}
		return allCreated;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseNativeSpec(de.feu.mitra.NativeSpec)
	 */
	@Override
	public MObject[] caseJavaSpec(JavaSpec javaSpec) {
		currentStackFrame().enterBlock();
		// for faster access:
		StackFrame currentScope = currentStackFrame();
		RuleDeclaration decl = (RuleDeclaration) javaSpec.eContainer();

		String strClass = null;
		String strMethod = decl.getName();

		for (Property prop : javaSpec.getProperties()) {
			String strName = prop.getName();
			if (strName.equals("class")) {
				strClass = prop.getValue();
			} else if (strName.equals("method")) {
				strMethod = prop.getValue();
			}
			// TODO add warnings if name isn't recognized
		}

		// auto resolve class and METHOD name:
		if (strClass == null) {
			Module module = retrieveModule(javaSpec);
			strClass = module.getName().toString();
		}

		try {
			Class<?> javaClass = Class.forName(strClass);
			Object javaObject = javaClass.newInstance();
			if (javaObject instanceof IJavaMitraRule) {
				IJavaMitraRule javaMitraRule = (IJavaMitraRule) javaObject;
				javaMitraRule.setContext(new InterpreterMitraContext(this));
			}

			Class<?>[] ptypes = new Class[decl.getFormalParameters().size()];
			Object[] args = new Object[decl.getFormalParameters().size()];
			for (int i = 0; i < args.length; i++) {
				Parameter par = decl.getFormalParameters().get(i);
				args[i] = currentScope.getValue(par.getVardecl()).getValue();
				// ptypes[i] = args[i].getClass();
				IMetamodel manager = getMetamodel(getType(par.getVardecl()));
				ptypes[i] =
					manager.getJavaClassForType(getType(par.getVardecl()));
			}
			Method m = javaObject.getClass().getMethod(strMethod, ptypes);

			// invoke
			Object ret = m.invoke(javaObject, args);

			currentScope.leaveBlock();

			if (ret == null) {
				return A_NULL;
			}

			if (ret instanceof IMultiReturn) {
				IMultiReturn mr = (IMultiReturn) ret;
				MObject[] rets = new MObject[mr.size()];

				if (rets.length != decl.getReturnParameters().size()) {
					runtimeError("Number of returned values (" + rets.length
						+ ") does not match declaration ("
						+ decl.getReturnParameters().size() + ")", decl);
					throw new MitraError();
				}

				for (int i = 0; i < rets.length; i++) {
					Object r = mr.get(i);
					if (r instanceof MObject) {
						rets[i] = (MObject) r;
					} else {
						rets[i] = getMetamodelManager().wrap(r); // ,
																	// decl.getReturnParameters().get(i).getType());
					}
				}
				return rets;
			}
			if (decl.getReturnParameters().size() > 1) {
				runtimeError(
						"Native rule returned a single result, rule declares"
							+ decl.getReturnParameters().size(), decl);
				throw new MitraError();
			}

			if (ret instanceof MObject) {
				// TODO check actualtype of returned mobject and declaration
				return new MObject[] {
					(MObject) ret
				};
			}
			return new MObject[] {
				getMetamodelManager().wrap(ret)
			};

		} catch (Exception ex) {
			StringBuffer strb = new StringBuffer();
			for (Parameter par : decl.getFormalParameters()) {
				if (strb.length() > 0) {
					strb.append(", ");
				}
				strb.append(par);
				strb.append("=");
				strb.append(currentStackFrame().getValue(par.getVardecl()));
			}

			runtimeError("Error executing native operation " + decl + " with "
				+ strb.toString(), javaSpec, ex);
			throw new MitraError();
		}

	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseBlock(de.feu.mitra.Block)
	 */
	@Override
	public MObject[] caseBlock(Block block) {
		MObject[] returnValue = getDefaultReturnValue();
		currentStackFrame().enterBlock();
		for (BlockStatement statement : block.getStatements()) {
			returnValue = visit(statement);
			if (bBreak || bReturn) {
				break;
			}
		}
		currentStackFrame().leaveBlock();
		return returnValue;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseReturnStatement(de.feu.mitra.ReturnStatement)
	 */
	@Override
	public MObject[] caseReturnStatement(ReturnStatement returnStatement) {
		MObject[] returnValue = getDefaultReturnValue();
		if (returnStatement.getExpression() != null) {
			returnValue = visit(returnStatement.getExpression());

			RuleDeclaration rule =
				MitraUtils.retrieveContainingRule(returnStatement);
			List<ReturnParameter> returnParameters = rule.getReturnParameters();
			if (returnParameters.size() != returnValue.length) {
				runtimeError("Return expression contains " + returnValue.length
					+ " objects, but rule requires " + returnParameters.size()
					+ " parameters", returnStatement);
				throw new MitraError();
			}

			for (int i = 0; i < returnValue.length; i++) {
				currentStackFrame().setValue(
						returnParameters.get(i).getVardecl(), returnValue[i]);
			}
		}

		bReturn = true;
		return returnValue;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseBreakStatement(de.feu.mitra.BreakStatement)
	 */
	@Override
	public MObject[] caseBreakStatement(BreakStatement object) {
		bBreak = true;
		return getDefaultReturnValue();
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseBooleanLiteral(de.feu.mitra.BooleanLiteral)
	 */
	@Override
	public MObject[] caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return (booleanLiteral.isBooleanValue()) ? A_TRUE : A_FALSE;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseIntLiteral(de.feu.mitra.IntLiteral)
	 */
	@Override
	public MObject[] caseIntLiteral(IntLiteral intLiteral) {
		return new MObject[] {
			getMetamodelManager().getPrimitiveMetamodel().wrap(
					intLiteral.getIntValue())
		}; // , PrimitiveMetamodel.INT)
			// };
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseRealLiteral(de.feu.mitra.RealLiteral)
	 */
	@Override
	public MObject[] caseRealLiteral(RealLiteral realLiteral) {
		return new MObject[] {
			getMetamodelManager().getPrimitiveMetamodel().wrap(
					(MitraUtils.toFloat(realLiteral)))
		};
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseStringLiteral(de.feu.mitra.StringLiteral)
	 */
	@Override
	public MObject[] caseStringLiteral(StringLiteral stringLiteral) {
		return new MObject[] {
			getMetamodelManager().getPrimitiveMetamodel().wrap(
					stringLiteral.getStringValue())
		};
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseNullLiteral(de.feu.mitra.NullLiteral)
	 */
	@Override
	public MObject[] caseNullLiteral(NullLiteral nullLiteral) {
		return A_NULL;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseAssignment(de.feu.mitra.Assignment)
	 */
	@Override
	public MObject[] caseAssignment(Assignment assignment) {
		return mobjectAccessPolicy.caseAssignment(assignment);
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseClassInstanceCreationExpression(de.feu.mitra.ClassInstanceCreationExpression)
	 */
	@Override
	public MObject[] caseClassInstanceCreationExpression(
			ClassInstanceCreationExpression classInstanceCreationExpression) {
		Type type = classInstanceCreationExpression.getType();
		try {
			IMetamodel metamodel = getMetamodel(type);
			MObject newInstance = metamodel.createInstance(type);
			return new MObject[] {
				newInstance
			};
		} catch (Exception ex) {
			runtimeError("Error creating instance",
					classInstanceCreationExpression, ex);
			throw new MitraError();
		}
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseIfStatement(de.feu.mitra.IfStatement)
	 */
	@Override
	public MObject[] caseIfStatement(IfStatement ifStatement) {
		return statementsPolicy.caseIfStatement(ifStatement);
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseDoStatement(de.feu.mitra.DoStatement)
	 */
	@Override
	public MObject[] caseDoStatement(DoStatement doStatement) {
		return statementsPolicy.caseDoStatement(doStatement);
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseWhileStatement(de.feu.mitra.WhileStatement)
	 */
	@Override
	public MObject[] caseWhileStatement(WhileStatement whileStatement) {
		return statementsPolicy.caseWhileStatement(whileStatement);
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseForStatement(de.feu.mitra.ForStatement)
	 */
	@Override
	public MObject[] caseForStatement(ForStatement forStatement) {
		return statementsPolicy.caseForStatement(forStatement);
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseIteratorExpression(de.jevopi.mitra2.mitra.IteratorExpression)
	 */
	@Override
	public MObject[] caseIteratorExpression(
			IteratorExpression i_iteratorExpression) {
		// variable is assumed to be already declared and set
		// by calling native operation
		return visit(i_iteratorExpression.getExpression());
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseVariableAccess(de.jevopi.mitra2.mitra.VariableAccess)
	 */
	@Override
	public MObject[] caseVariableAccess(VariableAccess i_variableAccess) {
		return mobjectAccessPolicy.caseVariableAccess(i_variableAccess);
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseFeatureAccess(de.feu.mitra.FeatureAccess)
	 */
	@Override
	public MObject[] caseStaticAccess(StaticAccess staticAccess) {
		return mobjectAccessPolicy.caseStaticAccess(staticAccess);
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseLocalVariableDeclaration(de.feu.mitra.LocalVariableDeclaration)
	 */
	@Override
	public MObject[] caseLocalVariableDeclaration(
			LocalVariableDeclaration localVariableDeclaration) {
		currentStackFrame().declareVariable(
				localVariableDeclaration.getVardecl());

		if (localVariableDeclaration.getExpression() != null) {

			// evaluate right hand side
			MObject[] newValue =
				visit(localVariableDeclaration.getExpression());

			if (newValue == null || newValue.length != 1
				|| newValue[0].getValue() == PrimitiveMetamodel.VOID) {
				throw new IllegalStateException(
					"Right hand side of assignment must not be void");
			}

			// new variable assignment
			// TODO check actualtype
			currentStackFrame().setValue(localVariableDeclaration.getVardecl(),
					newValue[0]);
		}

		return getDefaultReturnValue();
	}

	@Override
	public MObject[] caseBooleanExpression(BooleanExpression booleanExpression) {
		return expressionsPolicy.caseBooleanExpression(booleanExpression);
	}

	@Override
	public MObject[] caseEqualityExpression(
			EqualityExpression equalityExpression) {
		return expressionsPolicy.caseEqualityExpression(equalityExpression);
	}

	@Override
	public MObject[] caseRelationalExpression(
			RelationalExpression relationalExpression) {
		return expressionsPolicy.caseRelationalExpression(relationalExpression);
	}

	@Override
	public MObject[] caseMathExpression(MathExpression mathExpression) {
		return expressionsPolicy.caseMathExpression(mathExpression);
	}

	@Override
	public MObject[] caseUnaryMathExpression(
			UnaryMathExpression unaryMathExpression) {
		return expressionsPolicy.caseUnaryMathExpression(unaryMathExpression);
	}

	@Override
	public MObject[] caseInstanceOfExpression(
			InstanceOfExpression instanceOfExpression) {
		return expressionsPolicy.caseInstanceOfExpression(instanceOfExpression);
	}

	@Override
	public MObject[] caseUnaryBooleanExpression(
			UnaryBooleanExpression unaryBooleanExpression) {
		return expressionsPolicy
			.caseUnaryBooleanExpression(unaryBooleanExpression);
	}

	@Override
	public MObject[] caseUnaryCastExpression(
			UnaryCastExpression unaryCastExpression) {
		return expressionsPolicy.caseUnaryCastExpression(unaryCastExpression);
	}

}
