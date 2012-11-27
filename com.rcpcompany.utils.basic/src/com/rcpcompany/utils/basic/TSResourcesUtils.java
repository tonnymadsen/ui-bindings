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
package com.rcpcompany.utils.basic;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

/**
 * This utility class provides a number of static functions that can ease formatting of data.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class TSResourcesUtils {
	/**
	 * Returns a generic <code>toString</code> representation for {@link IResourceDelta}.
	 * 
	 * @param delta
	 *            the delta to be described
	 * @return the string for the delta
	 */
	public static String toString(IResourceDelta delta) {
		final StringBuilder sb = new StringBuilder(1000);
		sb.append("\n");
		try {
			delta.accept(new IResourceDeltaVisitor() {
				@Override
				public boolean visit(IResourceDelta delta) throws CoreException {
					for (int i = 0; i < delta.getFullPath().segmentCount(); i++) {
						sb.append("  ");
					}
					sb.append(delta.getFullPath()).append(" - ");
					switch (delta.getKind()) {
					case IResourceDelta.ADDED:
						sb.append("ADDED");
						break;
					case IResourceDelta.CHANGED:
						sb.append("CHANGED");
						break;
					case IResourceDelta.REMOVED:
						sb.append("REMOVED");
						break;
					default:
						sb.append("UNKNOWN[").append(delta.getKind()).append("]");
						break;
					}
					sb.append(": ");
					int d = delta.getFlags();
					if ((d & IResourceDelta.CONTENT) == IResourceDelta.CONTENT) {
						sb.append("CONTENT+"); //$NON-NLS-1$
						d &= ~IResourceDelta.CONTENT;
					}
					if ((d & IResourceDelta.DERIVED_CHANGED) == IResourceDelta.DERIVED_CHANGED) {
						sb.append("DERIVED_CHANGED+"); //$NON-NLS-1$
						d &= ~IResourceDelta.DERIVED_CHANGED;
					}
					if ((d & IResourceDelta.DESCRIPTION) == IResourceDelta.DESCRIPTION) {
						sb.append("DESCRIPTION+"); //$NON-NLS-1$
						d &= ~IResourceDelta.DESCRIPTION;
					}
					if ((d & IResourceDelta.ENCODING) == IResourceDelta.ENCODING) {
						sb.append("ENCODING+"); //$NON-NLS-1$
						d &= ~IResourceDelta.ENCODING;
					}
					if ((d & IResourceDelta.LOCAL_CHANGED) == IResourceDelta.LOCAL_CHANGED) {
						sb.append("LOCAL_CHANGED+"); //$NON-NLS-1$
						d &= ~IResourceDelta.LOCAL_CHANGED;
					}
					if ((d & IResourceDelta.OPEN) == IResourceDelta.OPEN) {
						sb.append("OPEN+"); //$NON-NLS-1$
						d &= ~IResourceDelta.OPEN;
					}
					if ((d & IResourceDelta.MOVED_TO) == IResourceDelta.MOVED_TO) {
						sb.append("MOVED_TO[" + delta.getMovedToPath() + "]+"); //$NON-NLS-1$
						d &= ~IResourceDelta.MOVED_TO;
					}
					if ((d & IResourceDelta.MOVED_FROM) == IResourceDelta.MOVED_FROM) {
						sb.append("MOVED_FROM[" + delta.getMovedFromPath() + "]+"); //$NON-NLS-1$
						d &= ~IResourceDelta.MOVED_FROM;
					}
					if ((d & IResourceDelta.COPIED_FROM) == IResourceDelta.COPIED_FROM) {
						sb.append("COPIED_FROM[" + delta.getMovedFromPath() + "]+"); //$NON-NLS-1$
						d &= ~IResourceDelta.COPIED_FROM;
					}
					if ((d & IResourceDelta.TYPE) == IResourceDelta.TYPE) {
						sb.append("TYPE+"); //$NON-NLS-1$
						d &= ~IResourceDelta.TYPE;
					}
					if ((d & IResourceDelta.SYNC) == IResourceDelta.SYNC) {
						sb.append("SYNC+"); //$NON-NLS-1$
						d &= ~IResourceDelta.SYNC;
					}
					if ((d & IResourceDelta.MARKERS) == IResourceDelta.MARKERS) {
						sb.append("MARKERS+"); //$NON-NLS-1$
						d &= ~IResourceDelta.MARKERS;
					}
					if ((d & IResourceDelta.CONTENT) == IResourceDelta.CONTENT) {
						sb.append("CONTENT+"); //$NON-NLS-1$
						d &= ~IResourceDelta.CONTENT;
					}

					if (d == 0 && delta.getFlags() != 0) {
						sb.deleteCharAt(sb.length() - 1);
					} else {
						sb.append(d);
					}

					// TODO delta.getMarkerDeltas()
					sb.append("\n");

					return true;
				}
			});
		} catch (final CoreException ex) {
			sb.append("" + ex);
		}

		return sb.toString();
	}
}
