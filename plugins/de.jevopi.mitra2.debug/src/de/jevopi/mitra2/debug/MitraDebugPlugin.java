package de.jevopi.mitra2.debug;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 *
 * @author 	Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */	
public class MitraDebugPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.jevopi.mitra2.debug"; //$NON-NLS-1$

	// The shared instance
	private static MitraDebugPlugin plugin;

	/**
	 * The constructor
	 */
	public MitraDebugPlugin() {
	}

	/** 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/** 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static MitraDebugPlugin getDefault() {
		return plugin;
	}

}
