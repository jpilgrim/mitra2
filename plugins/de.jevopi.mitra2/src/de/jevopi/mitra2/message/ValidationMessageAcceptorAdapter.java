package de.jevopi.mitra2.message;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

public class ValidationMessageAcceptorAdapter implements IMessageAcceptor {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger
		.getLogger(ValidationMessageAcceptorAdapter.class.getName());

	ValidationMessageAcceptor acceptor;
	MessageFormatter messageFormatter;

	protected final static String[] EMPTY_STRING_ARRAY = new String[0];

	/**
	 * @param acceptor
	 */
	public ValidationMessageAcceptorAdapter(ValidationMessageAcceptor acceptor) {
		this.acceptor = acceptor;
		messageFormatter = new MessageFormatter();
	}

	@Override
	public void message(Level level, String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex,
			String code, String... issueData) {

		switch (level) {
		case ERROR:
			acceptor.acceptError(message, astElement, structuralFeature, index,
					code, toStringArray(issueData));
			break;
		case WARNING:
			acceptor.acceptWarning(message, astElement, structuralFeature,
					index, code, toStringArray(issueData));
			break;
		}

		log(level, message, astElement, structuralFeature, index, ex, code);

	}

	public static String[] toStringArray(Object[] issueData) {
		if (issueData == null || issueData.length == 0)
			return EMPTY_STRING_ARRAY;
		if (issueData instanceof String[]) return (String[]) issueData;
		String[] asStrings = new String[issueData.length];
		for (int i = 0; i < issueData.length; i++) {
			asStrings[i] = issueData[i] == null ? "" : issueData[i].toString();
		}
		return asStrings;
	}

	protected void log(Level level, String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex,
			String code) {

		if (log.isLoggable(level.jdkLevel())) {
			String s =
				messageFormatter.format(level, message, astElement,
						structuralFeature, index, ex, code);
			log.log(level.jdkLevel(), s);
		}
	}

}
