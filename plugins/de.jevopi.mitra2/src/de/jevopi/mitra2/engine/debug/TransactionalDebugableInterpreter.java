package de.jevopi.mitra2.engine.debug;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.internal.EMFTransactionPlugin;

import de.jevopi.mitra2.engine.interpreter.ExecutionContext;
import de.jevopi.mitra2.engine.interpreter.SessionContext;

/**
 * TransactionalDebugableInterpreter There should really be more documentation
 * here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision: 964 $
 * @since May 9, 2010
 */
@SuppressWarnings("restriction")
public final class TransactionalDebugableInterpreter extends
		DebugableInterpreter {

	/**
	 * @param i_sessionContext
	 * @param i_executionContext
	 */
	public TransactionalDebugableInterpreter(SessionContext i_sessionContext,
			ExecutionContext i_executionContext) {
		super(i_sessionContext, i_executionContext);
	}

	/**
	 * {@inheritDoc} Note: running the interpreter and firing the termination
	 * event must be executed in two separate recordings commands in order to
	 * ensure possible newly created elements are created <em>before</em> event
	 * is fired.
	 * 
	 * @see de.feu.mitra.engine.execution.DebugableInterpreter#run()
	 */
	@Override
	public void run() {

		final TransactionalEditingDomain domain;
		// TODO JUnit test:
		if (EMFTransactionPlugin.getPlugin() == null) {
			domain = null;
		} else {
			domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.eclipse.gef3d.ext.multieditor");
		}
		if (domain != null) {
			try {
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						doRunInterpreter();

					}
				});

			} finally {
				doFireTerminationEvent();
				// domain.getCommandStack().execute(
				// new RecordingCommand(domain) {
				// protected void doExecute() {
				//
				// }
				// });
			}
		} else {
			super.run();
		}
	}

}