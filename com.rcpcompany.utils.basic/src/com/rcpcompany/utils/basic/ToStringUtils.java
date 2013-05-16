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

import java.util.List;

/**
 * This utility class provides a number of static functions that can ease
 * formatting of data.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class ToStringUtils {

	/**
	 * Formats the source string to be a human readable name.
	 * <p>
	 * The source string is expected to be on the usual mixed-case format as
	 * used for Java method and class names.
	 * <p>
	 * Some examples:
	 * <ul>
	 * <li>"shopName" becomes "Shop Name"</li>
	 * <li>"currentRowNo" becomes "Current Row No"</li>
	 * <li>"id" becomes "Id"</li>
	 * <li>"activeZ" becomes "Active Z"</li>
	 * <li>"ActiveZ" becomes "Active Z"</li>
	 * <li>"ActiveZZ" becomes "Active ZZ"</li>
	 * <li>"isDNAAvailable" becomes "Is DNA Available"</li>
	 * <li>"ShopItemDescription" becomes "Shop Item Description"</li>
	 * <li>"eShop" becomes "E Shop"</li>
	 * <li>"eDNA" becomes "E DNA"</li>
	 * </ul>
	 * <p>
	 * The algorithm:
	 * <ul>
	 * <li>Divide in groups "(l*)(U(U*|l*))*" where U = uppercase letter and l
	 * is everything else</li>
	 * <li>Uppercase the first letter of each group</li>
	 * <li>Append the non-empty groups separated with space</li>
	 * </ul>
	 * 
	 * @param source
	 *            the source name
	 * @return the human readable version
	 */
	public static String formatHumanReadable(String source) {
		// System.out.println("==" + source);
		final StringBuilder sb = new StringBuilder();
		final int len = source.length();
		int i = 0;
		char ch;
		/*
		 * At "!!(l*)(U(U*|l*))*"
		 */
		// System.out.println("  >> " + i);
		while (i < len && !Character.isUpperCase(ch = source.charAt(i))) {
			if (i == 0) {
				ch = Character.toUpperCase(ch);
			}
			sb.append(ch);
			i++;
		}

		/*
		 * At "(l*)!!(U(U*|l*))*"
		 */
		while (i < len) {
			if (i != 0) {
				sb.append(' ');
			}
			// System.out.println("  >> " + i);
			ch = source.charAt(i++);
			sb.append(ch);
			/*
			 * At "(l*)(U!!(U*|l*))*"
			 */
			if (i >= len) {
				break;
			}
			if (Character.isUpperCase(source.charAt(i))) {
				/*
				 * At "(l*)(U(!!U*|l*))*"
				 */
				while (i < len) {
					ch = source.charAt(i++);
					if (Character.isUpperCase(ch)
							&& (i < len && !Character.isUpperCase(source
									.charAt(i)))) {
						i--;
						break;
					}
					sb.append(ch);
				}
			} else {
				/*
				 * At "(l*)(U(U*|!!l*))*"
				 */
				while (i < len && !Character.isUpperCase(ch = source.charAt(i))) {
					sb.append(ch);
					i++;
				}
			}
			/*
			 * At "(l*)(U(U*|l*)!!)*"
			 */
		}

		final String res = sb.toString();
		// System.out.println(" =" + res);
		return res;
	}

	/**
	 * Returns a string with all the possible choices from the specified array.
	 * E.g. if the array is {@code ["red",
	 * "yellow", "green"]}, the result is the string
	 * {@code "red", "yellow" or "green"}.
	 * 
	 * @param array
	 *            the array
	 * @return the constructed string
	 */
	public static String toOrString(Object[] array) {
		if (array == null)
			return "<null>"; //$NON-NLS-1$
		if (array.length == 0)
			return ""; //$NON-NLS-1$

		final StringBuffer sb = new StringBuffer();
		String delimiter = null;
		final Object first = array[0];
		final Object last = array[array.length - 1];
		for (final Object r : array) {
			if (delimiter != null) {
				sb.append(delimiter);
			}
			if (r == first) {
				// nothing
			} else if (r == last) {
				sb.append(" or "); //$NON-NLS-1$
			} else {
				sb.append(", "); //$NON-NLS-1$
			}

			final String s = r.toString();
			if (s.indexOf(' ') != -1 || s.indexOf('\t') != -1) {
				delimiter = "\""; //$NON-NLS-1$
			} else {
				delimiter = ""; //$NON-NLS-1$
			}
			sb.append(delimiter);
			sb.append(s);
		}
		sb.append(delimiter);
		return sb.toString();
	}

	/**
	 * Returns a string with all the possible choices from the specified list.
	 * E.g. if the list is {@code ["red",
	 * "yellow", "green"]}, the result is the string
	 * {@code "red", "yellow" or "green"}.
	 * 
	 * @param <T>
	 *            the type of the elements
	 * @param list
	 *            the list
	 * @return the constructed string
	 */
	public static <T extends Object> String toOrString(List<T> list) {
		if (list == null)
			return "<null>"; //$NON-NLS-1$
		if (list.size() == 0)
			return ""; //$NON-NLS-1$

		final StringBuffer sb = new StringBuffer();
		String delimiter = null;
		final Object first = list.get(0);
		final Object last = list.get(list.size() - 1);
		for (final Object r : list) {
			if (delimiter != null) {
				sb.append(delimiter);
			}
			if (r == first) {
				// nothing
			} else if (r == last) {
				sb.append(" or "); //$NON-NLS-1$
			} else {
				sb.append(", "); //$NON-NLS-1$
			}

			final String s = r.toString();
			if (s.indexOf(' ') != -1 || s.indexOf('\t') != -1) {
				delimiter = "\""; //$NON-NLS-1$
			} else {
				delimiter = ""; //$NON-NLS-1$
			}
			sb.append(delimiter);
			sb.append(s);
		}
		sb.append(delimiter);
		return sb.toString();
	}
}
