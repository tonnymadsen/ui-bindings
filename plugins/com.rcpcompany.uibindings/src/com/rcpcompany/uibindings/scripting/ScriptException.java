package com.rcpcompany.uibindings.scripting;

/**
 * Common top-level exception for all script-related exceptioons.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class ScriptException extends Exception {
	private static final long serialVersionUID = 7739754446385917917L;

	public ScriptException() {
		super();
	}

	public ScriptException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScriptException(String message) {
		super(message);
	}

	public ScriptException(Throwable cause) {
		super(cause);
	}
}
