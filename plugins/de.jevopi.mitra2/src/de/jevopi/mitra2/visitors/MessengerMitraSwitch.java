package de.jevopi.mitra2.visitors;

import static de.jevopi.mitra2.message.IMessageAcceptor.Level.DEBUG;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.ERROR;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.INFO;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.RUNTIME_ERROR;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.RUNTIME_WARNING;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.WARNING;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.message.IMessenger;
import de.jevopi.mitra2.mitra.util.MitraSwitch;

/**
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @param <T>
 * @since Feb 10, 2012
 */
public class MessengerMitraSwitch<T> extends MitraSwitch<T> implements
		IMessenger {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger
		.getLogger(MessengerMitraSwitch.class.getName());

	/**
	 * Returns the message acceptor, by default the
	 * {@link IMessageAcceptor#JDK_LOGGING_ACCEPTOR JDK logging acceptor} is
	 * returned. The acceptor instance is not stored in the switch, in order to
	 * enable better delegation. E.g., all subclasses using a
	 * {@link ProjectContext project context} can then simply delegate to the
	 * {@link ProjectContext#getMessageAcceptor() context's acceptor} by
	 * overriding this method.
	 * 
	 * @return must not return null
	 */
	public IMessageAcceptor getMessageAcceptor() {
		return IMessageAcceptor.EMPTY;
	}

	public void message(IMessageAcceptor.Level level, String message,
			EObject astElement, EStructuralFeature structuralFeature, int index, Throwable ex, String code,
			String... issueData) {
		try {
			getMessageAcceptor().message(level, message, astElement, structuralFeature, index,
					ex, code, issueData);
		} catch (Throwable t) {
			log.warning("Error writing message: " + String.valueOf(message)
				+ ". Error: " + t);
		}
	}

	@Override
	public final void error(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex, String code, String... issueData) {
		message(ERROR, message, astElement, structuralFeature, index, ex, code, issueData);
	}

	@Override
	public final void error(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, String code, String... issueData) {
		message(ERROR, message, astElement, structuralFeature, index, null, code,
				issueData);
	}

	@Override
	public final void error(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index) {
		message(ERROR, message, astElement, structuralFeature, index, null, null);
	}
	
	@Override
	public final void error(String message, EObject astElement) {
		message(ERROR, message, astElement, astElement.eContainingFeature(), -1, null, null);
	}

	@Override
	public final void warning(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex, String code, String... issueData) {
		message(WARNING, message, astElement, structuralFeature, index, ex, code,
				issueData);
	}

	@Override
	public final void warning(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, String code) {
		message(WARNING, message, astElement, structuralFeature, index, null, code);
	}

	@Override
	public final void warning(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index) {
		message(WARNING, message, astElement, structuralFeature, index, null, null);
	}
	
	@Override
	public final void warning(String message, EObject astElement) {
		message(WARNING, message, astElement, astElement.eContainingFeature(), -1, null, null);
	}

	@Override
	public final void info(String message, EObject astElement, Throwable ex) {
		message(INFO, message, astElement, astElement.eContainingFeature(), -1, ex, null);
	}

	@Override
	public final void info(String message, EObject astElement) {
		message(INFO, message, astElement, astElement.eContainingFeature(), -1, null, null);
	}

	@Override
	public final void info(String message) {
		message(INFO, message, null, null, -1, null, null);
	}

	
	@Override
	public final void debug(String message, EObject astElement) {
		message(DEBUG, message, astElement, astElement.eContainingFeature(), -1, null, null);
	}

	@Override
	public final void debug(String message) {
		message(DEBUG, message, null, null, -1, null, null);
	}

	@Override
	public final void runtimeError(String message, EObject astElement,
			Throwable ex, String code, String... issueData) {
		message(RUNTIME_ERROR, message, astElement, astElement.eContainingFeature(), -1, ex, code, issueData);
	}

	@Override
	public final void runtimeError(String message, EObject astElement,
			String code, String... issueData) {
		message(RUNTIME_ERROR, message, astElement, astElement.eContainingFeature(), -1, null, code, issueData);
	}

	@Override
	public final void runtimeError(String message, EObject astElement,
			Throwable ex) {
		message(RUNTIME_ERROR, message, astElement, astElement.eContainingFeature(), -1, ex, null);
	}

	@Override
	public final void runtimeError(String message, EObject astElement) {
		message(RUNTIME_ERROR, message, astElement, astElement.eContainingFeature(), -1, null, null);
	}

	@Override
	public final void runtimeWarning(String message, EObject astElement,
			Throwable ex, String code, String... issueData) {
		message(RUNTIME_WARNING, message, astElement, astElement.eContainingFeature(), -1, ex, code, issueData);
	}

	@Override
	public final void runtimeWarning(String message, EObject astElement,
			String code, String... issueData) {
		message(RUNTIME_WARNING, message, astElement, astElement.eContainingFeature(), -1, null, code,
				issueData);
	}

	@Override
	public final void runtimeWarning(String message, EObject astElement) {
		message(RUNTIME_WARNING, message, astElement, astElement.eContainingFeature(), -1, null, null);
	}

}
