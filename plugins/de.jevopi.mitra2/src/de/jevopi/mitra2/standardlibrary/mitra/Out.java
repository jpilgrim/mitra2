package de.jevopi.mitra2.standardlibrary.mitra;

import java.io.PrintStream;

import de.jevopi.mitra2.api.IJavaMitraRule;
import de.jevopi.mitra2.api.IMitraContext;

public class Out implements IJavaMitraRule {

	
	private IMitraContext mitraContext = null;
	private PrintStream ps = System.out;

	@Override
	public void setContext(IMitraContext context) {
		mitraContext  = context;
		ps = mitraContext.getProjectContext().out;
	}
	
	
	public void println(Object s) {
		ps.println(String.valueOf(s));
	}

	
	
}
