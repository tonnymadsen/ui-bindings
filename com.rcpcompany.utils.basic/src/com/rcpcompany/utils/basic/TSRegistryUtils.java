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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

/**
 * This utility class provides a number of static functions that can ease formatting of data.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class TSRegistryUtils {
	/**
	 * Returns a generic <code>toString</code> representation for {@link IConfigurationElement}.
	 * <p>
	 * The output is to a large extend decided via heuristics. E.g which attributes of an element that are likely to be
	 * the key for the element.
	 * 
	 * @param ce
	 *            the element
	 * @return the string for the element
	 */
	public static String toString(final IConfigurationElement ce) {
		String str = null;
		IConfigurationElement c = null;
		Object o = null;

		for (o = ce; o instanceof IConfigurationElement; o = c.getParent()) {
			c = (IConfigurationElement) o;
			String m = c.getName();
			for (final String a : ID_ATTRIBUTES) {
				final String av = c.getAttribute(a);
				if (av != null) {
					m = m + "[" + a + "=" + av + "]";
					break;
				}
			}
			if (str == null) {
				str = m;
			} else {
				str = m + "/" + str;
			}
		}
		if (o instanceof IExtension) {
			final IExtension e = (IExtension) o;
			String m = e.getExtensionPointUniqueIdentifier();
			if (e.getLabel() != null && e.getLabel().length() > 0) {
				m = m + "[label=" + e.getLabel() + "]";
			} else if (e.getUniqueIdentifier() != null) {
				m = m + "[id=" + e.getUniqueIdentifier() + "]";
			} else if (e.getSimpleIdentifier() != null) {
				m = m + "[id=" + e.getSimpleIdentifier() + "]";
			}
			str = m + "/" + str;
		}
		str = "CE{" + ce.getContributor().getName() + "/" + str + "}";
		return str;
	}

	private static final String[] ID_ATTRIBUTES = { "id", "name", "class", "type" };
}
