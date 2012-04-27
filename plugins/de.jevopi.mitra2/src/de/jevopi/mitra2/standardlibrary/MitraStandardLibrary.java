package de.jevopi.mitra2.standardlibrary;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;

public class MitraStandardLibrary {

	public static URI createMSLPath() {
		URL url = MitraStandardLibrary.class.getResource("");
		
		String uriString;
		try {
			url = FileLocator.resolve(url);
			uriString = url.toURI().toString();
		} catch (Exception ex) {
			uriString = url.toString();
		}
		URI uri = URI.createURI(uriString);

		return uri;
	}
	
}
