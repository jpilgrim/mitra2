package de.jevopi.mitra2.debug.launch.standalone;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.ui.console.FileLink;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.console.IHyperlink;
import org.eclipse.ui.console.IPatternMatchListener;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.mitra.Module;

public class MitraConsoleTracker implements IPatternMatchListener {

	protected TextConsole console;
	private ProjectContext projectContext;
	
	public MitraConsoleTracker(ProjectContext projectContext) {
		this.projectContext = projectContext;
	}

	@Override
	public void connect(TextConsole console) {
		this.console = console;

	}

	@Override
	public void disconnect() {
		console = null;
	}

	@Override
	public void matchFound(PatternMatchEvent event) {
		try {
            int offset = event.getOffset();
            int length = event.getLength();
            
            String match = console.getDocument().get(offset, length);
            String moduleName = extractModuleNameFromMatch(match);
            int line = extractLineNumberFromMatch(match);
            
            Module module = projectContext.getAllModules().get(moduleName);
            URI uri = module.eResource().getURI();
            
            IWorkspace workspace= ResourcesPlugin.getWorkspace(); 
            IPath location= Path.fromOSString(uri.toFileString()); 
            IFile file= workspace.getRoot().getFileForLocation(location);
            
            
            IHyperlink link = new FileLink(file, null, -1, -1, line);
            console.addHyperlink(link, offset+1, length-2);   
        } catch (Exception e) {
        }

	}

	private int extractLineNumberFromMatch(String match) {
		int pos = match.lastIndexOf(".mitra:");
		String l = match.substring(pos+".mitra:".length(), match.length()-1);
		return Integer.parseInt(l);
	}

	private String extractModuleNameFromMatch(String match) {
		int pos = match.lastIndexOf(".mitra");
		return match.substring(1, pos);
	}

	@Override
	public String getPattern() {
		return "\\(\\S*\\.mitra:\\S*\\)";
	}

	@Override
	public int getCompilerFlags() {
		return 0;
	}

	@Override
	public String getLineQualifier() {
		return "\\.mitra:";
	}

}
