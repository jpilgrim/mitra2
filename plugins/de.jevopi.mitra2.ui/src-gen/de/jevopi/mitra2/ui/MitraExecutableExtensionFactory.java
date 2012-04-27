/*
 * generated by Xtext
 */
package de.jevopi.mitra2.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import de.jevopi.mitra2.ui.internal.MitraActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MitraExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return MitraActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return MitraActivator.getInstance().getInjector(MitraActivator.DE_JEVOPI_MITRA2_MITRA);
	}
	
}
