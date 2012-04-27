package de.jevopi.mitra2.exec;

import java.util.List;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mar 4, 2012
 */
public interface IMitraConfig {

	List<String> getModulePaths();
	List<String> getMetamodelPaths();
	List<String> getModelPaths();
	String getSavedModelsPath();
	
//	boolean isOverwriteOutput();
//	Map<String, String> getOutputModelFilenames();
//	Map<String, String> getInputModelFilenames();
	
	boolean isSaveTraces();
	boolean isOverwriteTraces();
	String getTraceModelFilename();
}
