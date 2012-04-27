
package de.jevopi.mitra2;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MitraStandaloneSetup extends MitraStandaloneSetupGenerated{

	public static void doSetup() {
		new MitraStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

