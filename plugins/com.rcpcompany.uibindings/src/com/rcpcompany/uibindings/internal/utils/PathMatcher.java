/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rcpcompany.uibindings.utils.IPathMatcher;

/**
 * Implementation of {@link IPathMatcher}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PathMatcher implements IPathMatcher {
	/**
	 * Map with all matchers index by pattern.
	 */
	private static final Map<String, IPathMatcher> MATCHERS = new HashMap<String, IPathMatcher>();

	/**
	 * Returns an {@link IPathMatcher} for the specified pattern.
	 * 
	 * @param pattern the pattern for the matcher
	 * @return the matcher
	 */
	public static IPathMatcher getPathMatcher(String pattern) {
		IPathMatcher matcher = MATCHERS.get(pattern);
		if (matcher == null) {
			matcher = new PathMatcher(pattern);
			MATCHERS.put(pattern, matcher);
		}
		return matcher;
	}

	/**
	 * Constructs and returns a new {@link IPathMatcher} for the specified pattern.
	 * 
	 * @param pattern the pattern of this matcher
	 */
	public PathMatcher(String pattern) {
		String regexp = null;
		if (pattern.startsWith("glob:")) {
			regexp = translateGlob(pattern.substring("glob:".length()));
		} else if (pattern.startsWith("regex:")) {
			regexp = pattern.substring("regex:".length());
		} else
			throw new IllegalArgumentException("Pattern must start with 'glob:' or 'regex:'. Was: '" + pattern + "'");

		// LogUtils.debug(null, pattern + " -> " + regexp);
		myPattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * Translates a Glob pattern into a corresponding regexp.
	 * 
	 * @param pattern the global pattern
	 * @return the regexp pattern
	 */
	private String translateGlob(String pattern) {
		String p = pattern;
		// final char separator = File.separatorChar;

		/*
		 * Translate all "\\" into "/", to make the rest easier
		 */
		p = p.replaceAll("\\\\", "/");

		/*
		 * "." -> "\." to get a verbatim match
		 */
		p = p.replaceAll("\\.", "\\\\.");

		/*
		 * "?" -> "[^/]"
		 */
		p = p.replaceAll("[?]", "[^/]");

		/*
		 * "[!...]" -> "[^...]"
		 */
		p = p.replaceAll("^\\[!", "[^");
		p = p.replaceAll("(?<!\\\\)\\[!", "[^");

		/*
		 * "*" -> "[^/]*"
		 */
		p = p.replaceAll("[*]", "[^/]*");

		/*
		 * "**" -> "[^/]*(/[^/]*)*"
		 */
		final String dss = "[^/]*(/[^/]*)*";
		p = p.replace("[^/]*[^/]*", dss);

		/*
		 * "/**" at the end of the string -> "([^/]*(/[^/]*)*)?"
		 */
		if (p.endsWith("/" + dss)) {
			p = p.substring(0, p.length() - dss.length() - 1) + "(" + dss + ")?";
		}

		/*
		 * "{...,...}" -> "(...|...)" - not suported yet
		 */
		// if (pattern.matches(pattern))
		// pattern.replaceAll("\\*", ".*");

		/*
		 * No start separator: then we match both a file name and a path name with a matching last
		 * part
		 */
		if (p.charAt(0) != '/') {
			p = "((/[^/]*)*/)?" + p;
		}

		/*
		 * Translate all '/' to the native separator (if different from '/')
		 */
		// if (separator == '\\') {
		// For unknown reasons replaceAll does not do the trick
		for (int i = p.indexOf('/'); i >= 0; i = p.indexOf('/', i + 4)) {
			p = p.substring(0, i) + "[/\\\\]" + p.substring(i + 1);
		}
		for (int i = p.indexOf("[^[/\\\\]]"); i >= 0; i = p.indexOf("[^[/\\\\]]")) {
			p = p.substring(0, i) + "[^/\\\\]" + p.substring(i + 8);
		}
		// } else if (separator != '/') {
		// p = p.replace('/', separator);
		// }

		/*
		 * For Windows (separator == '\'), add drive letter and network drive support
		 */
		// if (separator == '\\') {
		p = "([a-z]:|[/\\\\][^/\\\\]+)?" + p;
		// }

		// LogUtils.debug(this, "translate '" + pattern + "' -> '" + p + "'");
		return p;
	}

	private final Pattern myPattern;

	@Override
	public boolean matches(String path) {
		return myPattern.matcher(path).matches();
	}

	@Override
	public boolean partiallyMatches(String path) {
		final Matcher matcher = myPattern.matcher(path);
		return matcher.matches() || matcher.hitEnd();
	}
}
