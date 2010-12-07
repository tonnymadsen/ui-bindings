package com.rcpcompany.uibindings.scripting;

/**
 * Exception for {@link IScriptEngineDescriptor} relation exceptions.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScriptEngineException extends ScriptException {
	private static final long serialVersionUID = -3671207730868829327L;

	public ScriptEngineException() {
		super();
	}

	public ScriptEngineException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScriptEngineException(String message) {
		super(message);
	}

	public ScriptEngineException(Throwable cause) {
		super(cause);
	}
}
