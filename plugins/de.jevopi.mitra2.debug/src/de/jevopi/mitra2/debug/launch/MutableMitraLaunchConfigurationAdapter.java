package de.jevopi.mitra2.debug.launch;

import java.util.Map;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;


public class MutableMitraLaunchConfigurationAdapter extends
		MitraLaunchConfigurationAdapter {

	public MutableMitraLaunchConfigurationAdapter(
			ILaunchConfigurationWorkingCopy adaptedConfiguration) {
		super(adaptedConfiguration);
	}
	
	protected final ILaunchConfigurationWorkingCopy wc() {
		return (ILaunchConfigurationWorkingCopy) adaptedConfiguration;
	}
	
	public void setModulePath(String modulePath) {
		wc().setAttribute(MODULE_PATH, modulePath);
	}

	public void setRuleName(String ruleName) {
		wc().setAttribute(RULE_NAME, ruleName);
	}

	public void setOverwriteOutput(boolean overwrite) {
		wc().setAttribute(OVERWRITE_OUTPUT, overwrite);
	}
		

	public void setOverwriteTraces(boolean overwriteTraces) {
		wc().setAttribute(OVERWRITE_TRACES, overwriteTraces);
	}

	public void setSaveTraces(boolean saveTraces)  {
		wc().setAttribute(SAVE_TRACES, saveTraces);
	}

	public void setTraceModelFilename(String traceModelFileName) {
		wc().setAttribute(TRACE_MODEL, traceModelFileName);
	}
	

	public void setOutputModelFilenames(Map<String, String> outputModelFilenames) {
		wc().setAttribute(OUTPUT_MODELS, outputModelFilenames);
	}

	public void setInputModelFilenames(Map<String, String> inputModelFilenames) {
		wc().setAttribute(INPUT_MODELS, inputModelFilenames);
	}
	
}
