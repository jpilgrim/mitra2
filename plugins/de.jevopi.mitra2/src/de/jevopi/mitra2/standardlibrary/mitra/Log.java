package de.jevopi.mitra2.standardlibrary.mitra;

import java.io.PrintStream;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.api.IJavaMitraRule;
import de.jevopi.mitra2.api.IMitraContext;
import de.jevopi.mitra2.message.MessageFormatter;

public class Log implements IJavaMitraRule {

	private IMitraContext mitraContext = null;
	private PrintStream out = System.out;
	private PrintStream err = System.err;

	@Override
	public void setContext(IMitraContext context) {
		mitraContext = context;
		out = mitraContext.getProjectContext().log;
		err = mitraContext.getProjectContext().err;
	}

	public void info(Object s) {
		doLog(out, s);
	}

	public void severe(Object s) {
		doLog(err, s);
	}

	void doLog(PrintStream log, Object s) {
		try {
			StringBuilder strb = new StringBuilder();
			strb.append(s);
			int offset = 0;
			if (strb.length() < 80) {
				offset = strb.length();
			} else {
				strb.append("\n");
			}
			for (int i = offset; i < 80; i++) {
				strb.append(' ');
			}
			strb.append(locationString());
			log.println(strb.toString());
		} catch (Exception ex) {
			err.println("Error logging message");
		}
	}

	String locationString() {
		EObject currentElement = mitraContext.getElementStack().get(mitraContext.getElementStack().size()-1);
		return MessageFormatter.stackTraceLikeLocation(currentElement);
	}

}
