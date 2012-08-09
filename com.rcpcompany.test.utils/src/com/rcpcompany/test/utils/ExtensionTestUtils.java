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
import java.util.Map;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * Base class for all tests.
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

	/**
	 * 
	 * @param sourceName
	 */
	public static void dumpBindingSourceState(String sourceName) {
		final ISourceProviderService sourceProviders = (ISourceProviderService) PlatformUI
				.getWorkbench().getService(ISourceProviderService.class);
		final ISourceProvider provider = sourceProviders
				.getSourceProvider(sourceName);
		@SuppressWarnings("unchecked")
		final Map<String, Object> currentState = provider.getCurrentState();

		final StringBuilder sb = new StringBuilder("Binding sources state:");
		for (final Map.Entry<String, Object> i : currentState.entrySet()) {
			final String s = i.getKey();
			sb.append("\n  ").append(s).append("='");
			final Object v = i.getValue();
			if (v == null) {
				sb.append("<null>");
			} else if (v == IEvaluationContext.UNDEFINED_VARIABLE) {
				sb.append("<undef>");
			} else {
				sb.append(v.toString());
			}
			sb.append("'");
		}
		LogUtils.debug(provider, sb.toString());
	}
}
