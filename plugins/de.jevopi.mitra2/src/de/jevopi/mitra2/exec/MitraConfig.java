package de.jevopi.mitra2.exec;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @todo refactor all configuration related things into this class (or let them
 *       implement an interface according to this class)
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 23, 2012
 */
public class MitraConfig implements IMitraConfig {

	public final List<String> modulePaths;
	public final List<String> metamodelPaths;
	public final List<String> modelPaths;
	public String savedModelsPath;

	public boolean saveTraces;
	public boolean overwriteTraces;
	public String traceModelFilename;

	/**
	 * 
	 */
	public MitraConfig() {
		modulePaths = new ArrayList<String>(5);
		metamodelPaths = new ArrayList<String>(5);
		modelPaths = new ArrayList<String>(5);
		traceModelFilename = "";
		savedModelsPath = "";
		saveTraces = false;
		overwriteTraces = false;
	}
	
	@Override
	public List<String> getMetamodelPaths() {
		return metamodelPaths;
	}
	
	@Override
	public List<String> getModelPaths() {
		return modelPaths;
	}
	
	@Override
	public List<String> getModulePaths() {
		return modulePaths;
	}
	
	@Override
	public String getSavedModelsPath() {
		return savedModelsPath;
	}
	
	@Override
	public String getTraceModelFilename() {
		return traceModelFilename;
	}
	
	@Override
	public boolean isOverwriteTraces() {
		return overwriteTraces;
	}
	
	@Override
	public boolean isSaveTraces() {
		return saveTraces;
	}

	/** 
	 * @return
	 */
	@Override
	public String toString() {
		final int maxLen = 4;
		StringBuilder builder = new StringBuilder();
		builder.append("MitraConfig [modulePaths=");
		builder.append(modulePaths != null ? modulePaths.subList(0,
				Math.min(modulePaths.size(), maxLen)) : null);
		builder.append(", metamodelPaths=");
		builder.append(metamodelPaths != null ? metamodelPaths.subList(0,
				Math.min(metamodelPaths.size(), maxLen)) : null);
		builder.append(", modelPaths=");
		builder.append(modelPaths != null ? modelPaths.subList(0,
				Math.min(modelPaths.size(), maxLen)) : null);
		builder.append(", savedModelsPath=");
		builder.append(savedModelsPath);
		builder.append(", saveTraces=");
		builder.append(saveTraces);
		builder.append(", overwriteTraces=");
		builder.append(overwriteTraces);
		builder.append(", traceModelFilename=");
		builder.append(traceModelFilename);
		builder.append("]");
		return builder.toString();
	}
	
	

}
