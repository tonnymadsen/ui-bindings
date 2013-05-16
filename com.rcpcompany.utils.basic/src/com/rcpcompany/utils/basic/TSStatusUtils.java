/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.basic;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * This utility class provides a number of static functions that can ease formatting of data.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class TSStatusUtils {
	/**
	 * Returns a generic <code>toString</code> representation for {@link IStatus}.
	 * 
	 * @param status
	 *            the status object
	 * @return the string for the status object
	 */
	public static String toString(IStatus status) {
		return toString(status, "");
	}

	public static String toString(IStatus status, String prefix) {
		if (status == Status.OK_STATUS)
			return "STATUS[OK]";
		if (status == Status.CANCEL_STATUS)
			return "STATUS[CANCEL]";

		final StringBuilder sb = new StringBuilder();

		sb.append(ClassUtils.getLastClassName(status));
		sb.append("[").append(status.getPlugin()).append(", ");
		switch (status.getSeverity()) {
		case IStatus.CANCEL:
			sb.append("CANCEL");
			break;
		case IStatus.OK:
			sb.append("OK");
			break;
		case IStatus.INFO:
			sb.append("INFO");
			break;
		case IStatus.WARNING:
			sb.append("WARNING");
			break;
		case IStatus.ERROR:
			sb.append("ERROR");
			break;
		default:
			sb.append("#").append(status.getSeverity());
			break;
		}
		sb.append(", \"").append(status.getMessage()).append("\", ").append(status.getCode());

		final Throwable ex = status.getException();
		if (ex != null) {
			sb.append(", ").append(ex.toString());
			final StackTraceElement[] stackTrace = ex.getStackTrace();
			if (stackTrace != null && stackTrace.length > 0) {
				final StackTraceElement ste = stackTrace[0];
				sb.append(" (").append(ste.getFileName()).append(":").append(ste.getLineNumber()).append(") ");
			}
		}
		sb.append("]");

		final IStatus[] children = status.getChildren();
		if (children != null && children.length > 0) {
			final String p = prefix + "  ";
			sb.append(" contains {\n");
			for (final IStatus cs : children) {
				sb.append(p).append(TSStatusUtils.toString(cs, p)).append("\n");
			}
			sb.append(prefix).append("}");
		}

		return sb.toString();
	}
}
