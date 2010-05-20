package com.rcpcompany.utils.logging;

public class ContextException extends RuntimeException {

	public ContextException() {
		super();
	}

	public ContextException(String message) {
		super(message);
	}

	public ContextException(Throwable cause) {
		super(cause);
	}

	public ContextException(String message, Throwable cause) {
		super(message, cause);
	}

}
