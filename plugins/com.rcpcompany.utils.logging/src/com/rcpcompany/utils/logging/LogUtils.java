/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.logging;

import java.util.ArrayList;
import java.util.Dictionary;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Constants;
import org.osgi.service.packageadmin.RequiredBundle;

import com.rcpcompany.utils.basic.ClassUtils;
import com.rcpcompany.utils.logging.internal.Activator;

/**
 * This utility class provides a number of static functions that can ease logging of information.
 * <p>
 * Almost all of the log utility methods have an object as the first object. This object is used to
 * determine the plug-in that is responsible for a specific message. The object is handled as
 * follows depending on the type/Class:
 * <dl>
 * <dt>{@link IConfigurationElement}</dt>
 * <dd>The contributor is used as the plug-in name</dd>
 * <dt>{@link String}</dt>
 * <dd>Used directly as the plug-in name</dd>
 * <dt><code>null</code></dt>
 * <dd><code>{@link #UNKNOWN_PLUGIN &lt;unknown&gt;}</code> used</dd>
 * <dt>all other</dt>
 * <dd>The OSGi Admin service is used to query for the plug-in that defined the class</dd>
 * </dl>
 * <h2>Some Possible Enhancements</h2>
 * <ul>
 * <li>Could get the log to use from bundle in question and only use the current log of this plug-in
 * for the unknown cases...</li>
 * <li>Change the format of the time stamp</li>
 * </ul>
 */

public final class LogUtils {
	private LogUtils() {
	}

	/**
	 * The string used for the plug-in if it cannot be deduced.
	 */
	public static final String UNKNOWN_PLUGIN = "<unknown>";

	/**
	 * The log used for all messages.
	 */
	private static final ILog LOG = Activator.getDefault().getLog();

	/**
	 * Logs the specified debug message.
	 * 
	 * @param context the context related to the message
	 * @param message the message to print
	 */
	public static void debug(Object context, String message) {
		LogUtils.log(context, IStatus.INFO, message, null);
	}

	/**
	 * List of log listeners.
	 */
	private static ArrayList<ILogListener> listeners = new ArrayList<ILogListener>();

	/**
	 * Adds a new log listener to this utility class.
	 * 
	 * @param listener the listener to add
	 */
	public static void addListener(ILogListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes an existing log listener from this utility class.
	 * 
	 * @param listener the listener to remove
	 */
	public static void removeListener(ILogListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Logs the specified error message.
	 * 
	 * @param context the context related to the message
	 * @param message the message to print
	 */
	public static void error(Object context, String message) {
		LogUtils.log(context, IStatus.ERROR, message, null);
	}

	/**
	 * Logs the specified error message.
	 * 
	 * @param context the context related to the message
	 * @param exception any exception associated with the log message or <code>null</code>
	 */
	public static void error(Object context, Throwable exception) {
		LogUtils.log(context, IStatus.ERROR, null, exception);
	}

	/**
	 * Logs the specified error message.
	 * 
	 * @param context the context related to the message
	 * @param message the message
	 * @param exception any exception associated with the log message or <code>null</code>
	 */
	public static void error(Object context, String message, Throwable exception) {
		LogUtils.log(context, IStatus.ERROR, message, exception != null ? new RuntimeException(message, exception)
				: null);
	}

	/**
	 * Logs and <em>throws</em> the specified error message as an {@link IllegalArgumentException}.
	 * 
	 * @param context the context related to the message
	 * @param message the message
	 * @param exception any exception associated with the log message or <code>null</code>
	 */
	public static void throwException(Object context, String message, Throwable exception) {
		final RuntimeException ex = new RuntimeException(message);
		ex.fillInStackTrace();
		ex.initCause(exception);
		LogUtils.log(context, IStatus.ERROR, message, ex);
		throw ex;
	}

	/* ======================================================================== */

	private static final String[] ID_ATTRIBUTES = { "id", "name", "class", "type" };

	private static Throwable lastException;

	/**
	 * Logs the specified message.
	 * 
	 * @param context the context related to the message
	 * @param severity the severity of the log message
	 * @param message the message to print
	 * @param exception any exception associated with the log message or <code>null</code>
	 */
	protected static void log(Object context, int severity, String message, Throwable exception) {
		/*
		 * Special case: if the exception is the same as last time!! So don't report it again...
		 */
		if (exception != null && exception == lastException) return;
		lastException = exception;
		String pluginID = UNKNOWN_PLUGIN;
		String messagePrefix = null;
		if (context instanceof IConfigurationElement) {
			final IConfigurationElement ce = (IConfigurationElement) context;
			pluginID = ce.getContributor().getName();
			IConfigurationElement c = null;

			for (Object o = ce; o instanceof IConfigurationElement; o = c.getParent()) {
				c = (IConfigurationElement) o;
				String m = c.getName();
				for (final String a : ID_ATTRIBUTES) {
					final String av = c.getAttribute(a);
					if (av != null) {
						m = m + "[" + a + "=" + av + "]";
						break;
					}
				}
				if (messagePrefix == null) {
					messagePrefix = m;
				} else {
					messagePrefix = m + "/" + messagePrefix;
				}
			}
			messagePrefix = "{" + ce.getContributor().getName() + "/" + messagePrefix + "}";
		} else if (context instanceof String) {
			pluginID = (String) context;
		} else if (context != null) {
			if (Activator.getDefault() != null) {
				pluginID = Activator.getDefault().getBundleId(context);
			}
		}
		if (pluginID == null || pluginID.length() == 0) {
			pluginID = UNKNOWN_PLUGIN;
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

		final Status status = new Status(severity, pluginID, message, exception);
		LOG.log(status);
		for (final ILogListener listener : listeners) {
			try {
				listener.logging(status, status.getPlugin());
			} catch (final Exception ex) {
				LogUtils.error(listener, ex);
			}
		}
	}

	/* ======================================================================== */

	/**
	 * Logs information about all the plug-ins installed.
	 */
	public static void logPluginVersions() {
		final Activator activator = Activator.getDefault();

		final RequiredBundle[] requiredBundles = activator.getBundleAdmin().getRequiredBundles(null);
		final StringBuilder sb = new StringBuilder();
		for (final RequiredBundle bundle : requiredBundles) {
			final Dictionary<String, String> dic = bundle.getBundle().getHeaders();
			sb.append("\n");
			sb.append("     ");
			sb.append(dic.get(Constants.BUNDLE_SYMBOLICNAME));
			sb.append(" - ");
			sb.append(dic.get(Constants.BUNDLE_VERSION));
		}
		debug(activator, "Plugin versions:" + sb.toString());
	}

	/* ======================================================================== */

	/**
	 * Calculates and returns a log message based on the specified string.
	 * 
	 * @param message the message to print
	 * @return the calculated log message string
	 */
	public static String logMessage(String message) {
		final StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		// TODO Change format!
		// buffer.append(new Date(System.currentTimeMillis()));
		//
		// buffer.append(" - ");
		buffer.append(Thread.currentThread().getName());

		buffer.append(" - ");
		final RuntimeException ex = new RuntimeException();
		ex.fillInStackTrace();
		int level = 0;
		final StackTraceElement[] stackTrace = ex.getStackTrace();
		while (level < stackTrace.length) {
			final StackTraceElement st = stackTrace[level++];
			// Skip Utilities methods
			if (st.getClassName().startsWith(LogUtils.class.getName())) {
				continue;
			}
			buffer.append(ClassUtils.getLastClassName(st.getClassName())).append('.').append(st.getMethodName())
					.append(" (").append(st.getFileName()).append(':').append(st.getLineNumber()).append(")");
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

	/**
	 * The number of stack levels to include in log messages.
	 */
	public static int DEBUG_STRACK_LEVELS;
}
