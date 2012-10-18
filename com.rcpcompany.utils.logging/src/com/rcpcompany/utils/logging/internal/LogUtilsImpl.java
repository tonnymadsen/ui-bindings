package com.rcpcompany.utils.logging.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.equinox.log.ExtendedLogService;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.log.LogService;

import com.rcpcompany.utils.basic.ClassUtils;
import com.rcpcompany.utils.basic.TSRegistryUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Internal implementation for {@link LogUtils}.
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
public class LogUtilsImpl {
	/**
	 * The basic OSGi log service if defined.
	 */
	private LogService myLogService = null;

	/**
	 * The extended Equinox log service if defined.
	 */
	private ExtendedLogService myExtendedLogService = null;

	/**
	 * The handler instance (singleton).
	 */
	private final static LogUtilsImpl INSTANCE = new LogUtilsImpl();

	/**
	 * Returns this hander singleton instance.
	 * 
	 * @return the singleton
	 */
	public static LogUtilsImpl getInstance() {
		return INSTANCE;
	}

	/**
	 * Constructs and returns a new {@link LogUtils} handler.
	 */
	private LogUtilsImpl() {
	}

	/**
	 * The string used for the plug-in if it cannot be deduced.
	 */
	public static final String UNKNOWN_PLUGIN = "<unknown>";

	/* ======================================================================== */

	private Throwable lastException;

	/**
	 * Whether the last log message used {@link System#err}.
	 */
	private boolean lastMessageUsedStdErr = false;

	/**
	 * Logs the specified message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param logLevel
	 *            the severity of the log message
	 * @param message
	 *            the message to print
	 * @param exception
	 *            any exception associated with the log message or
	 *            <code>null</code>
	 */
	public void log(Object context, int logLevel, String message,
			Throwable exception) {

		if (exception instanceof InvocationTargetException) {
			exception = ((InvocationTargetException) exception)
					.getTargetException();
		}
		/*
		 * Special case: if the exception is the same as last time!! So don't
		 * report it again...
		 */
		if (exception != null && exception == lastException)
			return;
		lastException = exception;
		String bundleID = UNKNOWN_PLUGIN;
		String messagePrefix = null;
		if (context instanceof IConfigurationElement) {
			final IConfigurationElement ce = (IConfigurationElement) context;
			bundleID = ce.getContributor().getName();
			messagePrefix = TSRegistryUtils.toString(ce);
		} else if (context instanceof String) {
			bundleID = (String) context;
		} else if (context != null) {
			final String b = findBundleID(context);
			if (b != null) {
				bundleID = b;
			}
		}
		if (bundleID == null || bundleID.length() == 0) {
			bundleID = UNKNOWN_PLUGIN;
		}

		if (message == null && exception != null) {
			message = exception.getMessage();
			if (message == null) {
				message = ClassUtils.getLastClassName(exception);
			}
		}
		if (messagePrefix != null) {
			message = messagePrefix + ": " + message;
		}
		message = logMessage(message);

		if (myExtendedLogService != null) {
			Logger log = myExtendedLogService;
			if (bundleID != null) {
				Bundle bundle = null;

				final BundleContext bc = Activator.getDefault().getContext();
				if (bc != null) {
					for (final Bundle b : bc.getBundles()) {
						if (b.getSymbolicName().equals(bundleID)) {
							bundle = b;
							break;
						}
					}
				}
				if (bundle != null) {
					log = myExtendedLogService.getLogger(bundle,
							"org.eclipse.equinox.logger"); // TODO which logger
															// name to use
				}
			}
			lastMessageUsedStdErr = false;
			log.log(context, logLevel, message, exception);
		} else if (myLogService != null) {
			lastMessageUsedStdErr = false;
			myLogService.log(logLevel, message, exception);
		} else {
			if (!lastMessageUsedStdErr) {
				System.err.println("LOG [no current OSGi log service]");
				lastMessageUsedStdErr = true;
			}
			System.err.println("LOG>>> " + message);
		}
	}

	/**
	 * Returns the ID of the bundle that loaded the class of the specified
	 * object.
	 * 
	 * @param obj
	 *            the object in question
	 * @return the bundle ID or <code>null</code> if not known
	 */
	@Nullable
	public String findBundleID(Object obj) {
		final Bundle bundle = FrameworkUtil.getBundle(obj.getClass());
		if (bundle == null)
			return null;
		return bundle.getSymbolicName();
	}

	/* ======================================================================== */

	/**
	 * Calculates and returns a log message based on the specified string.
	 * 
	 * @param message
	 *            the message to print
	 * @return the calculated log message string
	 */
	public String logMessage(String message) {
		final StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		// TODO Change format!
		// buffer.append(new Date(System.currentTimeMillis()));
		//
		// buffer.append(" - ");
		buffer.append(Thread.currentThread().getName());

		buffer.append(" ");
		final RuntimeException ex = new RuntimeException();
		ex.fillInStackTrace();
		int level = 0;
		final StackTraceElement[] stackTrace = ex.getStackTrace();
		while (level < stackTrace.length) {
			final StackTraceElement st = stackTrace[level++];
			// Skip Utilities methods
			final String className = st.getClassName();
			if (className.startsWith(LogUtils.class.getName())) {
				continue;
			}
			if (className.startsWith(LogUtilsImpl.class.getName())) {
				continue;
			}
			buffer.append(ClassUtils.getLastClassName(className)).append('.')
					.append(st.getMethodName()).append(" (")
					.append(st.getFileName()).append(':')
					.append(st.getLineNumber()).append(")");
			break;
		}

		buffer.append("] ");
		buffer.append(message);

		if (LogUtils.DEBUG_STRACK_LEVELS > 0) {
			int n = LogUtils.DEBUG_STRACK_LEVELS;
			level--;
			while (level < stackTrace.length && 0 < n) {
				final StackTraceElement st = stackTrace[level++];
				n--;

				buffer.append("\n    ").append(st);
			}
		}
		return buffer.toString();
	}

	/* ======================================================================== */

	/**
	 * OSGi DS Interface.
	 * 
	 * @param server
	 *            the new server to bind to
	 */
	public void bindLogService(LogService server) {
		myLogService = server;
	}

	/**
	 * OSGi DS Interface.
	 * 
	 * @param server
	 *            the new server to bind to
	 */
	public void bindExtendedLogService(ExtendedLogService server) {
		myExtendedLogService = server;
	}
}
