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

/**
 * This utility class provides a number of static functions that can ease
 * handling of classes.
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
	 * @param clsName
	 *            the full class name
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
	 * Returns the final class name of the specified full class name.
	 * <p>
	 * For anonymous classes the containing class is included as well.
	 * 
	 * @param cls
	 *            the class
	 * @return the class name
	 */
	public static String getLastClassName(Class<?> cls) {
		String clsName = cls.getName();
		final Class<?> c = cls.getEnclosingClass();
		if (c == null) {
			clsName = clsName.substring(clsName.lastIndexOf('.') + 1);
		} else {
			clsName = clsName.substring(c.getPackage().getName().length());
			if (clsName.length() > 0 && clsName.charAt(0) == '.') {
				clsName = clsName.substring(1);
			}
			final int i = clsName.indexOf('$');
			if (i >= 0 && !Character.isDigit(clsName.charAt(i + 1))) {
				clsName = clsName.substring(i + 1);
			}
		}
		return clsName;
	}

	/**
	 * Returns the final class name of the object.
	 * 
	 * @param object
	 *            the object
	 * @return the class name
	 */
	public static String getLastClassName(Object object) {
		return getLastClassName(object.getClass());
	}
}
