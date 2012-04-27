package de.jevopi.mitra2.debug.launch;

import static java.util.Collections.emptyMap;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.exec.MitraConfig;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.Type;

/**
 * Adapts a {@link ILaunchConfiguration} for providing type and property save
 * setters and getters (instead of using property names and casts outside).
 * Validation is provided as well.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 21, 2012
 */
public class MitraLaunchConfigurationAdapter {

	protected final static String MODULE_PATH = "MODULE_PATH";
	protected final static String OUTPUT_MODELS = "OUTPUT_MODELS";
	protected final static String INPUT_MODELS = "INPUT_MODELS";
	protected final static String OVERWRITE_OUTPUT = "OVERWRITE_OUTPUT";
	protected final static String OVERWRITE_TRACES = "OVERWRITE_TRACES";
	protected final static String RULE_NAME = "RULE_NAME";
	protected final static String SAVE_TRACES = "SAVE_TRACES";
	protected final static String TRACE_MODEL = "TRACE_MODEL";

	ILaunchConfiguration adaptedConfiguration;
	private String lastErrorMessage;

	/**
	 * @param adaptedConfiguration
	 */
	public MitraLaunchConfigurationAdapter(
			ILaunchConfiguration adaptedConfiguration) {
		this.adaptedConfiguration = adaptedConfiguration;
	}

	/**
	 * @return
	 * @see org.eclipse.debug.core.ILaunchConfiguration#getName()
	 */
	public String getName() {
		return adaptedConfiguration.getName();
	}

	public String getModulePath() throws CoreException {
		return adaptedConfiguration.getAttribute(MODULE_PATH, "");
	}

	public String getRuleName() throws CoreException {
		return adaptedConfiguration.getAttribute(RULE_NAME, "");

	}

	public boolean isOverwriteOutput() throws CoreException {
		return adaptedConfiguration.getAttribute(OVERWRITE_OUTPUT, false);
	}

	public boolean isOverwriteTraces() throws CoreException {
		return adaptedConfiguration.getAttribute(OVERWRITE_TRACES, false);
	}

	public boolean isSaveTraces() throws CoreException {
		return adaptedConfiguration.getAttribute(SAVE_TRACES, false);
	}

	public String getTraceModelFilename() throws CoreException {
		return adaptedConfiguration.getAttribute(TRACE_MODEL, "");
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getOutputModelFilenames() throws CoreException {
		return Collections.unmodifiableMap(adaptedConfiguration.getAttribute(
				OUTPUT_MODELS, emptyMap()));
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getInputModelFilenames() throws CoreException {
		return Collections.unmodifiableMap(adaptedConfiguration.getAttribute(
				INPUT_MODELS, emptyMap()));
	}

	public String getLastErrorMessage() {
		return lastErrorMessage;
	}

	protected void setErrorMessage(String errorMessage) {
		lastErrorMessage = errorMessage;
	}

	/**
	 * Derived from module path and fully qualified name of rule.
	 * 
	 * @return
	 * @throws CoreException
	 */
	public String getModuleFilename() throws CoreException {
		String fqnRule = getRuleName();
		if (fqnRule.isEmpty()) return "";
		String fqnModule = MitraUtils.getFQModuleName(fqnRule);
		String fileName =
			getModulePath() + fqnModule.replaceAll(":", File.separator)
				+ ".mitra";
		return fileName;
	}

	public boolean validate() {
		try {
			lastErrorMessage = "";

			if (getModulePath().isEmpty()) {
				setErrorMessage("No module or module path defined yet");
				return false;
			}

			String fqnRule = getRuleName();
			if (fqnRule.isEmpty()) {
				setErrorMessage("A rule must be selected.");
				return false;
			}

			String moduleFilename = getModuleFilename();
			if (!checkExists(moduleFilename, "Module")) {
				return false;
			}

			MitraConfig mitraConfig = new MitraConfig();
			mitraConfig.modulePaths.add(getModulePath());
			mitraConfig.metamodelPaths.add(getModulePath());
			mitraConfig.saveTraces = isSaveTraces();
			mitraConfig.traceModelFilename = getTraceModelFilename();
			mitraConfig.overwriteTraces = isOverwriteTraces();
			
			ProjectContext projectContext = new ProjectContext();
			projectContext.getPathHandler().setPaths(mitraConfig);

			ResourceSet resourceSet = projectContext.getResourceSet();
			Module module = loadModel(resourceSet, moduleFilename);
			if (module == null) {
				return false;
			}
			if (module.eIsProxy()) {
				EcoreUtil.resolveAll(module);
			}

			if (!loadMetamodels(module)) {
				return false;
			}

			RuleDeclaration rule = retrieveRule(module, fqnRule);
			if (rule == null) {
				setErrorMessage("Rule " + fqnRule + " not found in module.");
				return false;
			}

			if (!validateInputModels(projectContext, rule)) return false;

			for (Entry<String, String> e : getOutputModelFilenames().entrySet()) {
				String parName = e.getKey();
				Parameter parameter =
					MitraUtils.getParameterByName(rule, parName);
				if (parameter == null) {
					setErrorMessage("Rule contains no parameter " + parName);
					return false;
				}
				String fileName = e.getValue();
				if (fileName.isEmpty()) {
					setErrorMessage("No filename for return parameter "
						+ parName + " specified");
					return false;
				}
			}

			boolean saveTraces = isSaveTraces();
			if (saveTraces) {
				if (getTraceModelFilename().isEmpty()) {
					setErrorMessage("No filename for trace model specified");
					return false;
				}

			}
		} catch (Exception ex) {
			setErrorMessage(ex.getMessage());
			return false;
		}

		return true;
	}

	private boolean validateInputModels(ProjectContext projectContext,
			RuleDeclaration rule) throws Exception {
		ResourceSet resourceSet = projectContext.getResourceSet();

		if (rule.getFormalParameters().size() < getInputModelFilenames().size()) {
			setErrorMessage("All input parameters must be set");
			return false;
		}
		if (rule.getFormalParameters().size() > getInputModelFilenames().size()) {
			setErrorMessage("Wrong input parameters set");
			return false;
		}

		for (Entry<String, String> e : getInputModelFilenames().entrySet()) {

			String parName = e.getKey();
			Parameter parameter = MitraUtils.getParameterByName(rule, parName);
			if (parameter == null) {
				setErrorMessage("Rule contains no parameter " + parName);
				return false;
			}

			String fileName = e.getValue();
			if (!checkExists(fileName, "Input model " + parName)) {
				return false;
			}

			EObject eobject = loadModel(resourceSet, fileName);
			if (eobject == null) {
				setErrorMessage("Cannot set " + parName
					+ ", no element found in " + fileName);
				return false;
			}
			if (eobject.eIsProxy()) {
				EcoreUtil.resolve(eobject, eobject.eResource());
			}

			MObject arg0 = projectContext.getMetamodelManager().wrap(eobject);
			if (arg0 == null) {
				setErrorMessage("Cannot handle content type "
					+ eobject.eClass().getName());
				return false;
			}
			Type argType = arg0.getActualType();
			Type parType = parameter.getVardecl().getType();
			if (!projectContext.getMetamodelManager().isSubType(argType,
					parType)) {
				setErrorMessage("Type mismatched, cannot convert " + argType
					+ " to " + parType);
				return false;
			}
		}
		return true;

	}

	/**
	 * @param i_moduleFilename
	 * @return
	 */
	private boolean checkExists(String filename, String fileDescription) {
		if (filename == null || filename.isEmpty()) {
			if (fileDescription != null) {
				setErrorMessage(fileDescription + " file must be set.");
			}
			return false;
		}
		File f = new File(filename);
		if (!f.exists()) {
			if (fileDescription != null) {
				setErrorMessage(fileDescription + " file not found.");
			}
			return false;
		}
		return true;
	}

	public <T extends EObject> T loadModel(ResourceSet resourceSet,
			String filename) throws Exception {
		Resource resource =
			resourceSet.createResource(URI.createFileURI(filename));

		if (!resource.isLoaded()) {
			resource.load(null);
		}
		@SuppressWarnings("unchecked")
		T content = (T) resource.getContents().get(0);
		return content;
	}

	public static RuleDeclaration retrieveRule(Module module, String i_fqnRule) {
		for (RuleDeclaration ruleDeclaration : module.getRuleDeclarations()) {
			if (MitraUtils.fqn(ruleDeclaration).equals(i_fqnRule)) {
				return ruleDeclaration;
			}
		}
		return null;
	}

	private boolean loadMetamodels(Module module) {
		ProjectContext context = ProjectContext.getProjectContext(module);
		MetamodelManager metamodelManager = context.getMetamodelManager();
		try {
			for (MetamodelDeclaration metamodelDeclaration : module
				.getMetamodelDeclarations()) {

				IMetamodel metamodel =
					metamodelManager.getMetamodel(metamodelDeclaration);
				if (metamodel == null) {
					setErrorMessage("Cannot load metamodel "
						+ metamodelDeclaration);
					return false;
				}
			}
			return true;
		} catch (Exception ex) {
			setErrorMessage("Error loading metamodels: " + ex.getMessage());
			return false;
		}

	}

	@Override
	public String toString() {
		try {
			StringBuilder strb =
				new StringBuilder("Mitra Launch Configuration:");
			strb.append("\nModule: ").append(getModuleFilename());
			strb.append("\nRule:   ").append(getRuleName());
			strb.append("\nInput models:");
			for (Entry<String, String> e : getInputModelFilenames().entrySet()) {
				strb.append("\n  ").append(e.getKey()).append("= ")
					.append(e.getValue());
			}
			strb.append("\nOutput models: ");
			if (isOverwriteOutput()) strb.append("(overwritten)");
			for (Entry<String, String> e : getOutputModelFilenames().entrySet()) {
				strb.append("\n  ").append(e.getKey()).append("= ")
					.append(e.getValue());
			}
			strb.append("\nTrace model: ").append(getTraceModelFilename());
			if (isSaveTraces()) strb.append(" (saved)");
			if (isOverwriteTraces()) strb.append(" (overwritten)");

			return strb.toString();

		} catch (Exception ex) {
			return "Error retrieving data for Mitra Launch Configuration: "
				+ ex;
		}
	}
}
