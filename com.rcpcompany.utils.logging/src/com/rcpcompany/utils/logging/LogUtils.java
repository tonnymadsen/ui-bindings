/*******************************************************************************
 * Copyright (c) 2006-2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.logging;

import java.util.Dictionary;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.log.LogService;

import com.rcpcompany.utils.logging.internal.LogUtilsImpl;

/**
 * This utility class provides a number of static functions that can ease
 * logging of information.
 * <p>
 * Almost all of the log utility methods have an object as the first object.
 * This object is used to determine the plug-in that is responsible for a
 * specific message. The object is handled as follows depending on the
 * type/Class:
 * <dl>
 * <dt>{@link IConfigurationElement}</dt>
 * <dd>The contributor is used as the plug-in name</dd>
 * <dt>{@link String}</dt>
 * <dd>Used directly as the plug-in name</dd>
 * <dt><code>null</code></dt>
 * <dd><code>{@link #UNKNOWN_PLUGIN &lt;unknown&gt;}</code> used</dd>
 * <dt>all other</dt>
 * <dd>The OSGi Admin service is used to query for the plug-in that defined the
 * class</dd>
 * </dl>
 * <h2>Some Possible Enhancements</h2>
 * <ul>
 * <li>Could get the log to use from bundle in question and only use the current
 * log of this plug-in for the unknown cases...</li>
 * <li>Change the format of the time stamp</li>
 * </ul>
 * <p>
 * This class is named "LogUtils" and not "ILogUtils" for historical reasons...
 */

public final class LogUtils {
	private LogUtils() {
	}

	/**
	 * Logs the specified debug message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param message
	 *            the message to print
	 */
	public static void debug(Object context, String message) {
		LogUtilsImpl.getInstance().log(context, LogService.LOG_INFO, message,
				null);
	}

	/**
	 * Logs the specified warning message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param message
	 *            the message to print
	 */
	public static void warning(Object context, String message) {
		LogUtilsImpl.getInstance().log(context, LogService.LOG_ERROR, message,
				null);
	}

	/**
	 * Logs the specified warning message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param exception
	 *            any exception associated with the log message or
	 *            <code>null</code>
	 */
	public static void warning(Object context, Throwable exception) {
		LogUtilsImpl.getInstance().log(context, LogService.LOG_WARNING, null,
				exception);
	}

	/**
	 * Logs the specified warning message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param message
	 *            the message
	 * @param exception
	 *            any exception associated with the log message or
	 *            <code>null</code>
	 */
	public static void warning(Object context, String message,
			Throwable exception) {
		LogUtilsImpl.getInstance().log(
				context,
				LogService.LOG_WARNING,
				message,
				exception != null ? new RuntimeException(message, exception)
						: null);
	}

	/**
	 * Logs the specified error message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param message
	 *            the message to print
	 */
	public static void error(Object context, String message) {
		LogUtilsImpl.getInstance().log(context, LogService.LOG_ERROR, message,
				null);
	}

	/**
	 * Logs the specified error message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param exception
	 *            any exception associated with the log message or
	 *            <code>null</code>
	 */
	public static void error(Object context, Throwable exception) {
		LogUtilsImpl.getInstance().log(context, LogService.LOG_ERROR, null,
				exception);
	}

	/**
	 * Logs the specified error message.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param message
	 *            the message
	 * @param exception
	 *            any exception associated with the log message or
	 *            <code>null</code>
	 */
	public static void error(Object context, String message, Throwable exception) {
		LogUtilsImpl.getInstance().log(
				context,
				LogService.LOG_ERROR,
				message,
				exception != null ? new RuntimeException(message, exception)
						: null);
	}

	/**
	 * Logs and <em>throws</em> the specified error message as an
	 * {@link RuntimeException}.
	 * 
	 * @param context
	 *            the context related to the message
	 * @param message
	 *            the message
	 * @param exception
	 *            any exception associated with the log message or
	 *            <code>null</code>
	 */
	public static void throwException(Object context, String message,
			Throwable exception) {
		final RuntimeException ex = new RuntimeException(message);
		ex.fillInStackTrace();
		ex.initCause(exception);
		LogUtilsImpl.getInstance().log(context, LogService.LOG_ERROR, message,
				ex);
		throw ex;
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
	public static String findBundleID(Object obj) {
		return LogUtilsImpl.getInstance().findBundleID(obj);
	}

	/**
	 * The number of stack levels to include in log messages.
	 */
	public static int DEBUG_STRACK_LEVELS;

	/**
	 * Logs information about all the plug-ins installed.
	 * 
	 * @param context
	 *            the bundle context
	 */
	public static void logBundleVersions(BundleContext context) {
		final Bundle[] bundles = context.getBundles();

		final StringBuilder sb = new StringBuilder();
		for (final Bundle bundle : bundles) {
			final Dictionary<String, String> dic = bundle.getHeaders();
			sb.append("\n");
			sb.append("     ");
			sb.append(dic.get(Constants.BUNDLE_SYMBOLICNAME));
			sb.append(" - ");
			sb.append(dic.get(Constants.BUNDLE_VERSION));
			switch (bundle.getState()) {
			case Bundle.ACTIVE:
				sb.append(" (ACTIVE)");
				break;
			case Bundle.INSTALLED:
				sb.append(" (INSTALLED)");
				break;
			case Bundle.RESOLVED:
				sb.append(" (RESOLVED)");
				break;
			case Bundle.STARTING:
				sb.append(" (STARTING)");
				break;
			case Bundle.STOPPING:
				sb.append(" (STOPPING)");
				break;
			case Bundle.UNINSTALLED:
				sb.append(" (UNINSTALLED)");
				break;
			}
		}
		debug(context.getBundle().getSymbolicName(),
				"Plugin versions:" + sb.toString());
	}
}
