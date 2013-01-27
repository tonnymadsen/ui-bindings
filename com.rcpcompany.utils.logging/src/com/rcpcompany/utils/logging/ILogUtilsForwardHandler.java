package com.rcpcompany.utils.logging;

/**
 * Interface used to forward log messages.
 * <p>
 * When {@link LogUtils} is initialized, it will look up and instantiate a class named
 * <code>com.rcpcompany.utils.logging.forwarder.ForwardHandler</code>. This class must implement to this interface.
 * <p>
 * All log messages will then be sent via this forwarder.
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
public interface ILogUtilsForwardHandler {
	/**
	 * Forwards a single log message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param logLevel
	 *            the severity of the log message
	 * @param message
	 *            the message to print
	 * @param exception
	 *            any exception associated with the log message or <code>null</code>
	 */
	void log(Object context, int logLevel, String message, Throwable exception);
}
