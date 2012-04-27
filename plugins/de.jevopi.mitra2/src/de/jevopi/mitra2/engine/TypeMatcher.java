package de.jevopi.mitra2.engine;

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.InferredVarDeclaration;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.ReturnParameter;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;

/**
 * Matches parameter types of a given rule declaration with another rule
 * declaration's parameter types of with actual arguments. In most cases, only
 * the formal parameters, i.e. the input parameters, are evaluated.
 * 
 * @author Jens von Pilgrim
 */
public abstract class TypeMatcher {
	ProjectContext projectContext;

	public TypeMatcher(ProjectContext projectContext) {
		this.projectContext = projectContext;
	}

	protected MetamodelManager getMetamodelManager() {
		return projectContext.getMetamodelManager();
	}

	/**
	 * Convenience method, as {@link VarDeclaration#getType()} may return null
	 * in case of {@link InferredVarDeclaration}.
	 * 
	 * @param varDeclaration
	 * @return
	 */
	protected Type getType(VarDeclaration varDeclaration) {
		return projectContext.getTypeResolver().getType(varDeclaration);
	}

	/**
	 * @param parameters
	 * @return -1 if types do not match, a value >=0 otherwise.
	 * @throws MetamodelNotFoundException
	 */
	public final float match(List<FormalParameter> formalParameters,
			List<ReturnParameter> returnParameters)
			throws MetamodelNotFoundException {

		if (formalParameters.size() != getNumberOfArguments()) {
			// if (allParameters.size() != getNumberOfArguments())
			return -1;
		}
		float fResult = 0;

		for (int i = 0; i < getNumberOfArguments(); i++) {
			Parameter par = formalParameters.get(i);
			Type pType = getType(par.getVardecl());
			Type argType = getTypeOfArgument(i);
			IMetamodel metamodel = getMetamodelManager().getMetamodel(argType);
			int iDist = metamodel.typeDistance(argType, pType);
			if (iDist < 0) {
				return -1;
			}
			fResult += 1 / ((float) (iDist + 1));
		}

		for (int i = 0; i < getNumberOfRetArgs(); i++) {
			Parameter par = returnParameters.get(i);
			Type pType = getType(par.getVardecl());
			IMetamodel metamodel = getMetamodelManager().getMetamodel(pType);
			Type argType = getTypeOfRetArg(i);
			int iDist = metamodel.typeDistance(argType, pType);
			if (iDist < 0) {
				return -1;
			}
			fResult += 1 / ((float) (iDist + 1));
		}

		return fResult;
	}

	public final float calcBestMatch() {
		float floatBestMatch = getNumberOfArguments();
		if (getNumberOfRetArgs() > 0) {
			floatBestMatch += getNumberOfRetArgs();
		}
		return floatBestMatch;
	}

	/**
	 * Returns the actual type of an argument at given index.
	 * 
	 * @param index
	 * @return
	 */
	public abstract Type getTypeOfArgument(int index);

	/**
	 * Returns the actual type of an return argument at given index.
	 * 
	 * @param index
	 * @return
	 */
	public abstract Type getTypeOfRetArg(int index);

	/**
	 * Returns the number of input arguments/parameters, used for quickly
	 * pre-filter rules based on number of input parameters
	 */
	public abstract int getNumberOfArguments();

	public int getNumberOfRetArgs() {
		return -1;
	}

}