/*******************************************************************************
 * Copyright (c) 2008, 2009 The RCP Company and Others
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.basic;

/**
 * This utility class provides a number of static functions that can ease handling of classes.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class ClassUtils {
	private ClassUtils() {
	}

	/**
	 * Returns the final class name of the specified full class name.
	 * <p>
	 * For anonymous classes the containing class is included as well.
	 * 
	 * @param clsName the full class name
	 * @return the class name
	 */
	public static String getLastClassName(String clsName) {
		clsName = clsName.substring(clsName.lastIndexOf('.') + 1);
		final int i = clsName.indexOf('$');
		if (i >= 0 && !Character.isDigit(clsName.charAt(i + 1))) {
			clsName = clsName.substring(i + 1);
		}
		return clsName;
	}

	/**
	 * Returns the final class name of the object.
	 * 
	 * @param object the object
	 * @return the class name
	 */
	public static String getLastClassName(Object object) {
		return getLastClassName(object.getClass().getName());
	}
}
