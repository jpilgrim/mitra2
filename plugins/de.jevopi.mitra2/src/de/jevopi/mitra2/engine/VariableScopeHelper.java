package de.jevopi.mitra2.engine;

import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.Block;
import de.jevopi.mitra2.mitra.BlockStatement;
import de.jevopi.mitra2.mitra.Catch;
import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.ForStatement;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.LocalVariableDeclaration;
import de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.QualifiedParameterReference;
import de.jevopi.mitra2.mitra.QualifiedRuleReference;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.Trigger;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.util.MitraSwitch;
import de.jevopi.utils.UnmodifiableComposedMap;

public class VariableScopeHelper {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger
			.getLogger(VariableScopeHelper.class.getName());

	/**
	 * Returns all variables visible at a given location, mapped by their name.
	 * If no variables are visible, an empty map is returned
	 * 
	 * @param location
	 * @param metamodelManager
	 * @return variables mapped by name, may be empty nut not null
	 */
	public static Map<String, VarDeclaration> getVisibleVariablesAtLocation(
			EObject location, MetamodelManager metamodelManager) {
		return new AllVariableCollector(metamodelManager).doSwitch(location);
	}

	public static Map<String, VarDeclaration> getVisibleVariablesBeforeLocation(
			EObject location, MetamodelManager metamodelManager) {

		BlockStatement blockStatement = retrieveContainingBlockStatement(location);

		if (blockStatement == null) {
			if (log.isLoggable(Level.INFO)) {
				log.info("No statement block found: location=" + location); //$NON-NLS-1$
			}
		}

		return new AllVariableCollector(metamodelManager, blockStatement)
				.doSwitch(location);
	}

	protected static BlockStatement retrieveContainingBlockStatement(
			EObject i_location) {
		if (i_location == null)
			return null;
		if (i_location instanceof BlockStatement)
			return (BlockStatement) i_location;

		return retrieveContainingBlockStatement(i_location.eContainer());

	}

	public static class VariableCollector extends
			MitraSwitch<Map<String, VarDeclaration>> {

		protected BlockStatement breakAt;

		public VariableCollector() {
			this(null);
		}

		public VariableCollector(BlockStatement i_breakAt) {
			breakAt = i_breakAt;
		}

		@Override
		public Map<String, VarDeclaration> defaultCase(EObject i_object) {
			return emptyMap();
		}

		@Override
		public Map<String, VarDeclaration> caseBlock(Block block) {
			Map<String, VarDeclaration> map = new HashMap<String, VarDeclaration>();

			for (BlockStatement blockStatement : block.getStatements()) {
				if (blockStatement instanceof LocalVariableDeclarationStatement) {
					VarDeclaration varDeclaration = ((LocalVariableDeclarationStatement) blockStatement)
							.getLocalVariableDeclaration().getVardecl();
					varDeclaration = map.put(varDeclaration.getName(),
							varDeclaration);
					if (varDeclaration != null) { // already contained, add
													// first occurrence again
						map.put(varDeclaration.getName(), varDeclaration);
					}
				}
				if (blockStatement == breakAt) {
					breakAt = retrieveContainingBlockStatement(block);
					break;
				}
			}
			return map;
		}

		@Override
		public Map<String, VarDeclaration> caseForStatement(
				ForStatement forStatement) {
			if (forStatement.getLoopVariable() != null) {
				VarDeclaration varDeclaration = forStatement.getLoopVariable()
						.getVardecl();
				return singletonMap(varDeclaration.getName(), varDeclaration);
			}
			if (forStatement.getForInit() != null) {
				Map<String, VarDeclaration> map = new HashMap<String, VarDeclaration>();
				for (LocalVariableDeclaration locals : forStatement
						.getForInit().getVarDeclarations()) {
					VarDeclaration varDeclaration = locals.getVardecl();
					map.put(varDeclaration.getName(), varDeclaration);
				}
				return map;
			}
			return emptyMap();
		}

		@Override
		public Map<String, VarDeclaration> caseIteratorExpression(
				IteratorExpression iteratorExpression) {
			VarDeclaration varDeclaration = iteratorExpression.getVariable()
					.getVardecl();
			return singletonMap(varDeclaration.getName(), varDeclaration);
		}

		@Override
		public Map<String, VarDeclaration> caseCatch(Catch _catch) {
			VarDeclaration varDeclaration = _catch.getFormalParameter()
					.getVardecl();
			return singletonMap(varDeclaration.getName(), varDeclaration);
		}

		@Override
		public Map<String, VarDeclaration> caseRuleDeclaration(
				RuleDeclaration ruleDeclaration) {
			Map<String, VarDeclaration> map = new HashMap<String, VarDeclaration>();
			for (Parameter par : ruleDeclaration.getFormalParameters()) {
				map.put(par.getVardecl().getName(), par.getVardecl());
			}
			for (Parameter par : ruleDeclaration.getReturnParameters()) {
				map.put(par.getVardecl().getName(), par.getVardecl());
			}
			return map;
		}

		@Override
		public Map<String, VarDeclaration> caseQualifiedRuleReference(
				QualifiedRuleReference qRuleReference) {
			Map<String, VarDeclaration> map = new HashMap<String, VarDeclaration>();
			for (QualifiedParameterReference par : qRuleReference
					.getParameterReferences()) {
				map.put(par.getVardecl().getName(), par.getVardecl());
			}
			for (QualifiedParameterReference par : qRuleReference
					.getReturnReferences()) {
				map.put(par.getVardecl().getName(), par.getVardecl());
			}
			return map;
		}
	}

	public static class AllVariableCollector extends VariableCollector {

		MetamodelManager metamodelManager;

		public AllVariableCollector(MetamodelManager i_metamodelManager) {
			this(i_metamodelManager, null);
		}

		public AllVariableCollector(MetamodelManager i_metamodelManager,
				BlockStatement breakAt) {
			super(breakAt);
			metamodelManager = i_metamodelManager;
		}

		@Override
		public Map<String, VarDeclaration> doSwitch(EObject i_object) {

			Map<String, VarDeclaration> thisVars = super.doSwitch(i_object);
			if (i_object instanceof RuleDeclaration
					|| i_object instanceof Trigger) {
				return thisVars;
			}

			Map<String, VarDeclaration> containerVars = doSwitch(i_object
					.eContainer());
			if (containerVars.isEmpty())
				return thisVars;
			if (thisVars.isEmpty())
				return containerVars;
			UnmodifiableComposedMap<String, VarDeclaration> composed = new UnmodifiableComposedMap<String, VarDeclaration>();
			composed.nestMap(thisVars);
			composed.nestMap(containerVars);
			return composed;
		}

		@Override
		public Map<String, VarDeclaration> caseExpression(Expression expression) {
			if (expression.eContainer() instanceof Trigger) {
				Trigger trigger = (Trigger) expression.eContainer();
				if (trigger.getWith() != null) {
					return doSwitch(trigger.getWith());
				}
			}
			return emptyMap();
		}

		@Override
		public Map<String, VarDeclaration> caseTrigger(Trigger trigger) {
			Map<String, VarDeclaration> map = caseRuleDeclaration((RuleDeclaration) trigger
					.eContainer());
			for (QualifiedRuleReference triggerRule : trigger.getTriggerRules()) {
				Map<String, VarDeclaration> refPars = caseQualifiedRuleReference(triggerRule);
				for (Entry<String, VarDeclaration> entry : refPars.entrySet()) {
					VarDeclaration duplicate = map.get(entry.getKey());
					if (duplicate == null
							|| (!MetamodelManager.equals(entry.getValue()
									.getType(), duplicate.getType()) && metamodelManager
									.isSubType(entry.getValue().getType(),
											duplicate.getType()))) {
						map.put(entry.getKey(), entry.getValue());
					}
				}
			}
			return map;
		}
	}
}
