package com.rcpcompany.utils.logging.internal;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.osgi.framework.Bundle;

/**
 * {@link ILog} that prints the error messages on the standard output.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ConsoleLog implements ILog {
	@Override
	public Bundle getBundle() {
		return null;
	}

	@Override
	public void log(IStatus status) {
		if (status.getException() != null) {
			status.getException().printStackTrace();
		} else {
			System.out.println(status);
		}
	}

	@Override
	public void addLogListener(ILogListener listener) {
	}

	@Override
	public void removeLogListener(ILogListener listener) {
	}
}
