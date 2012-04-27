package de.jevopi.mitra2.message;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class JDKLoggingAcceptor implements IMessageAcceptor {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(JDKLoggingAcceptor.class
		.getName());

	protected MessageFormatter messageFormatter = new MessageFormatter();

	@Override
	public void message(Level level, String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex, String code, String... issueData) {
		if (log.isLoggable(level.jdkLevel())) {
			
			String s =
				messageFormatter.format(level, message, astElement, structuralFeature, index,
						ex, code);
			log.log(level.jdkLevel(), s, ex);		
		}
	}

}
