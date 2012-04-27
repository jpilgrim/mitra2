package de.jevopi.mitra2.debug.launch.standalone;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.message.MessageFormatter;

public class ConsoleMessageAcceptor implements IMessageAcceptor {

	final MessageConsole console;
	MessageFormatter messageFormatter = new MessageFormatter();

	MessageConsoleStream out;
	MessageConsoleStream err;

	public ConsoleMessageAcceptor(MessageConsole i_console) {
		this.console = i_console;

		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				out = console.newMessageStream();
				out.setColor(PlatformUI.getWorkbench().getDisplay()
					.getSystemColor(SWT.COLOR_GRAY));
				err = console.newMessageStream();
				err.setColor(PlatformUI.getWorkbench().getDisplay()
					.getSystemColor(SWT.COLOR_RED));
			}
		});

	}

	@Override
	public void message(Level level, String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex,
			String code, String... issueData) {
		String s =
			messageFormatter.format(level, message, astElement,
					structuralFeature, index, ex, code);

		if (ex != null) {
			ex.printStackTrace();
		}

		MessageConsoleStream stream = out;
		switch (level) {
		case ERROR:
		case RUNTIME_ERROR:
			stream = err;
		}
		stream.println(s);
	}

}
