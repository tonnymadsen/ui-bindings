package com.rcpcompany.uibindings.internal.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.rcpcompany.uibindings.utils.IPathMatcher;
import com.rcpcompany.utils.logging.LogUtils;

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
		if (pattern.startsWith("glob:")) {
			pattern = translateGlob(pattern.substring("glob:".length()));
		} else if (pattern.startsWith("regex:")) {
			pattern = pattern.substring("regex:".length());
		} else
			throw new IllegalArgumentException("Pattern must start with 'glob:' or 'regex:'. Was: '" + pattern + "'");

		myPattern = Pattern.compile(pattern);
	}

	/**
	 * Translates a Glob pattern into a corresponding regexp.
	 * 
	 * @param pattern the global pattern
	 * @return the regexp pattern
	 */
	private String translateGlob(String pattern) {
		String p = pattern;
		final char separator = File.separatorChar;
		System.out.println(">>>" + p + "<<<");

		/*
		 * Translate all "\\" into "/", to make the rest easier
		 */
		p = p.replaceAll("\\\\", "/");
		System.out.println(">>>" + p + "<<<");

		/*
		 * "." -> "\." to get a verbatim match
		 */
		p = p.replaceAll("\\.", "\\\\.");
		System.out.println(">>>" + p + "<<<");

		/*
		 * "?" -> "[^/]"
		 */
		p = p.replaceAll("[?]", "[^/]");
		System.out.println(">>>" + p + "<<<");

		/*
		 * "[!...]" -> "[^...]"
		 */
		p = p.replaceAll("^\\[!", "[^");
		p = p.replaceAll("(?<!\\\\)\\[!", "[^");
		System.out.println(">>>" + p + "<<<");

		/*
		 * "*" -> "[^/]*"
		 */
		p = p.replaceAll("[*]", "[^/]*");
		System.out.println("*>>>" + p + "<<<");

		/*
		 * "**" -> "[^/]*(/[^/]*)*"
		 */
		p = p.replaceAll("\\[^/]\\*\\[^/]\\*", "[^/]*(/[^/]*)*");
		System.out.println(">>>" + p + "<<<");

		/*
		 * "{...,...}" -> "(...|...)" - not suported yet
		 */
//		if (pattern.matches(pattern))
//		pattern.replaceAll("\\*", ".*");

		/*
		 * No start separator: then we match both a file name and a path name with a matching last
		 * part
		 */
		if (p.charAt(0) != '/') {
			p = "(/[^/]*)*/" + p;
		}
		System.out.println(">>>" + p + "<<<");

		/*
		 * Translate all '/' to the native separator (if different from '/')
		 */
		if (separator == '\\') {
			p = p.replaceAll("/", "\\\\");
		} else if (separator != '/') {
			p = p.replace('/', separator);
		}
		System.out.println(">>>" + p + "<<<");

		/*
		 * For Windows (separator == '\'), add drive letter and network drive support
		 */
		if (separator == '\\') {
			p = "([a-z]:|\\\\[^\\]+)" + p;
		}
		System.out.println(">>>" + p + "<<<");

		LogUtils.debug(this, "translate '" + pattern + "' -> '" + p + "'");
		return p;
	}

	private final Pattern myPattern;

	@Override
	public boolean matches(String path) {
		return myPattern.matcher(path).matches();
	}
}
