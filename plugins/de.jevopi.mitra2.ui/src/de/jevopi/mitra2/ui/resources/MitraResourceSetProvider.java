package de.jevopi.mitra2.ui.resources;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import de.jevopi.mitra2.context.MitraResourceSet;
import de.jevopi.mitra2.context.PathHandler;
import de.jevopi.mitra2.context.PathHandler.ResourceType;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.exec.MitraConfig;

public class MitraResourceSetProvider implements IResourceSetProvider {

	@Override
	public ResourceSet get(IProject project) {
		
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IPath wsraw = ws.getRoot().getRawLocation();
		
		
		String absolutePath = wsraw.toFile().toString() + project.getFullPath().toString();
		
		URI projectURI = URI.createFileURI(absolutePath);
		
		
		ProjectContext projectContext = new ProjectContext();
		PathHandler pathHandler = projectContext.getPathHandler();
		pathHandler.addPath(ResourceType.METAMODEL, projectURI);
		pathHandler.addPath(ResourceType.MODEL, projectURI);
		pathHandler.addPath(ResourceType.MODULE, projectURI);
		pathHandler.setModelSavePath(projectURI);
		return new MitraResourceSet(projectContext);
	}

}
