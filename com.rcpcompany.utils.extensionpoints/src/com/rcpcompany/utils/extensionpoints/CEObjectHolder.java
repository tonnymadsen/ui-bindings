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
package com.rcpcompany.utils.extensionpoints;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.osgi.framework.Bundle;

import com.rcpcompany.utils.extensionpoints.internals.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Simple holder pattern.
 * <p>
 * Used to hold a reference to an object that is created via the extension
 * registry.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 * @param <X>
 *            the concrete type of the wanted objects
 */
public class CEObjectHolder<X> {
	private final IConfigurationElement myCE;

	/**
	 * Returns the Configuration Element of this holder object.
	 * 
	 * @return the ConfigurationElement
	 */
	public IConfigurationElement getConfigurationElement() {
		return myCE;
	}

	private X myObject = null;
	private final String myAttrName;

	/**
	 * Constructs and returns a new holder object for the specified
	 * configuration element.
	 * <p>
	 * Short for <code>CEObjectHolder(ce, "class")</code>
	 * 
	 * @param ce
	 *            the configuration element
	 */
	public CEObjectHolder(IConfigurationElement ce) {
		this(ce, "class");
	}

	/**
	 * Constructs and returns a new holder object for the specified
	 * configuration element.
	 * 
	 * @param ce
	 *            the configuration element
	 * @param attrName
	 *            the attribute name
	 */
	public CEObjectHolder(IConfigurationElement ce, String attrName) {
		myCE = ce;
		myAttrName = attrName;
	}

	/**
	 * Constructs and returns a new holder object for the specified object.
	 * <p>
	 * This can be considered a constant holder object.
	 * 
	 * @param obj
	 *            the constant holder value
	 * 
	 */
	public CEObjectHolder(X obj) {
		myCE = null;
		myAttrName = null;
		myObject = obj;
	}

	/**
	 * Returns the object for the holder object.
	 * 
	 * @return the object or <code>null</code>
	 */
	@SuppressWarnings("unchecked")
	public X getObject() {
		if (myObject == null) {
			try {
				myObject = (X) myCE.createExecutableExtension(myAttrName);
			} catch (final CoreException ex) {
				LogUtils.error(myCE, ex);
			}
		}
		return myObject;
	}

	/**
	 * Returns the object for the holder object.
	 * 
	 * @return the object or <code>null</code>
	 */
	@SuppressWarnings("unchecked")
	public Class<X> getObjectClass() {
		final String name = myCE.getContributor().getName();
		final String className = myCE.getAttribute(myAttrName);
		final Bundle bundle = Activator.getDefault().getBundle(name);
		if (bundle == null) {
			LogUtils.error(myCE, myAttrName
					+ ": cannot find bundle configuration element");
			return null;
		}
		try {
			return (Class<X>) bundle.loadClass(className);
		} catch (final ClassNotFoundException ex) {
			LogUtils.error(myCE, myAttrName + ": class cannot be loaded: "
					+ className, ex);
			return null;
		}
	}
}
