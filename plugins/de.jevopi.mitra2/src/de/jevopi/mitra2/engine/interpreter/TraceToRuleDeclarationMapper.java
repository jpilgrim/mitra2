package de.jevopi.mitra2.engine.interpreter;

import org.eclipse.emf.common.util.EList;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.traces.ParameterType;
import de.jevopi.mitra2.traces.Trace;
import de.jevopi.mitra2.traces.TraceElement;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mar 4, 2012
 */
public class TraceToRuleDeclarationMapper {

	protected DynamicRuleResolver dynamicRuleResolver;

	protected ProjectContext projectContext;

	public TraceToRuleDeclarationMapper(ProjectContext projectContext) {
		this.projectContext = projectContext;
		dynamicRuleResolver = new DynamicRuleResolver(projectContext);
	}

	/**
	 * @param trace
	 * @return
	 */
	public RuleDeclaration findRuleDeclarationForTrace(Trace trace) {
		// resolve rule of this trace
		String fqnName = trace.getRuleName();
		if (!MitraUtils.isFqnRulename(fqnName)) {
			throw new IllegalArgumentException(
				"Rule name in trace is expected to be fqn, was " + fqnName);
		}

		Type[] types = resolveTypes(trace.getElements());

		// int numberOfInputParameters = 0;
		int noa = 0;
		for (TraceElement te : trace.getElements()) {
			if (te.getTraceType() != ParameterType.TARGET) {
				noa++;
			}
		}
		Type[] argTypes = new Type[noa];
		int j = 0;
		for (TraceElement te : trace.getElements()) {
			if (te.getTraceType() != ParameterType.TARGET) {
				argTypes[j] = types[j];
				j++;
			}
		}

		// finds best matching declaration:
		RuleDeclaration decl =
			dynamicRuleResolver.resolveRuleDynamically(fqnName, argTypes);
		return decl;
	}

	/**
	 * Resolve all types by the names of the trace elements.
	 * 
	 * @param elements
	 * @return
	 */
	protected Type[] resolveTypes(EList<TraceElement> elements) {
		Type[] types = new Type[elements.size()];
		int i = 0;
		for (TraceElement te : elements) {
			Type t = getMetamodelManager().getTypeForName(te.getTypeName());
			types[i] = t;
			i++;
		}
		return types;
	}

	/**
	 * Convenience method, returns {@link ProjectContext#getMetamodelManager()
	 * projects context's metamodel manager}.
	 */
	protected MetamodelManager getMetamodelManager() {
		return projectContext.getMetamodelManager();
	}

}
