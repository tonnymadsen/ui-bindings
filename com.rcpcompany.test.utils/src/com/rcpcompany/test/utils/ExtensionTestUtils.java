package com.rcpcompany.test.utils;

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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * Various test methods for the extension registry.
 * <p>
 * Provides a number of convenience methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ExtensionTestUtils {
	private ExtensionTestUtils() {
	}

	/**
	 * Returns a list of the configuration element with the specific name.
	 * 
	 * @param epName
	 *            the extension point name
	 * @param elementName
	 *            the name
	 * @return the list of found elements
	 */
	public static List<IConfigurationElement> getElements(String epName,
			String elementName) {
		final List<IConfigurationElement> list = new ArrayList<IConfigurationElement>();

		final IExtensionRegistry extensionRegistry = Platform
				.getExtensionRegistry();
		for (final IConfigurationElement element : extensionRegistry
				.getConfigurationElementsFor(epName)) {
			if (element.getName().equals(elementName)) {
				list.add(element);
			}
		}

		return list;
	}
}
