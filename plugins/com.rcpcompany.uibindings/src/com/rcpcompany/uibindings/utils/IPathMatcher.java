package com.rcpcompany.uibindings.utils;

import com.rcpcompany.uibindings.internal.utils.PathMatcher;

/**
 * Path matcher functions.
 * <p>
 * {@link IPathMatcher} objects are retrieved as follows:
 * <p>
 * <code>IPathMatcher pm = IPathMatcher.Factory.getPathMatcher(pattern);</code>
 * <p>
 * The matcher can then match a path using
 * <p>
 * <code>if(pm.matches(pathName)) { ... }</code>
 * <p>
 * Pattern specifies the path name to match and conform to the glob rules a specified <a
 * href="http://java.sun.com/docs/books/tutorial/essential/io/fileOps.html#glob">here</a>.
 * 
 * <blockquote>
 * <table border="0">
 * <tr>
 * <td><code>*.java</code></td>
 * <td>Matches a path that represents a file name ending in <code>.java</code></td>
 * </tr>
 * <tr>
 * <td><code>*.*</code></td>
 * <td>Matches file names containing a dot</td>
 * </tr>
 * <tr>
 * <tr>
 * <td><code>*.{java,class}</code></td>
 * <td>Matches file names ending with <code>.java</code> or <code>.class</code></td>
 * </tr>
 * <tr>
 * <td><code>foo.?</code></td>
 * <td>Matches file names starting with <code>foo.</code> and a single character extension</td>
 * </tr>
 * <tr>
 * <td><tt>&#47;home&#47;*&#47;*</tt>
 * <td>Matches <tt>&#47;home&#47;gus&#47;data</tt> on UNIX platforms</td>
 * </tr>
 * <tr>
 * <td><tt>&#47;home&#47;**</tt>
 * <td>Matches <tt>&#47;home&#47;gus</tt> and <tt>&#47;home&#47;gus&#47;data</tt> on UNIX platforms</td>
 * </tr>
 * <tr>
 * <td><tt>C:&#92;&#92;*</tt>
 * <td>Matches <tt>C:&#92;foo</tt> and <tt>C:&#92;bar</tt> on the Windows platform (note that the
 * backslash is escaped; as a string literal in the Java Language the pattern would be
 * <tt>"C:&#92;&#92;&#92;&#92*"</tt>)</td>
 * </tr>
 * 
 * </table>
 * </blockquote>
 * 
 * <p>
 * The following rules are used to interpret glob patterns:
 * 
 * <p>
 * <ul>
 * <li>
 * <p>
 * The <code>*</code> character matches zero or more <A
 * HREF="http://download.java.net/jdk7/docs/api/java/lang/Character.html?is-external=true"
 * title="class or interface in java.lang"><CODE>characters</CODE></A> of a <A
 * HREF="../../../java/nio/file/Path.html#getName(int)"><CODE>name</CODE></A> component without
 * crossing directory boundaries.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * The <code>**</code> characters matches zero or more <A
 * HREF="http://download.java.net/jdk7/docs/api/java/lang/Character.html?is-external=true"
 * title="class or interface in java.lang"><CODE>characters</CODE></A> crossing directory
 * boundaries.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * The <code>?</code> character matches exactly one character of a name component.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * The backslash character (<code>\</code>) is used to escape characters that would otherwise be
 * interpreted as special characters. The expression <code>\\</code> matches a single backslash and
 * "\{" matches a left brace for example.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * The <code>[ ]</code> characters are a <i>bracket expression</i> that match a single character of
 * a name component out of a set of characters. For example, <code>[abc]</code> matches
 * <code>"a"</code>, <code>"b"</code>, or <code>"c"</code>. The hyphen (<code>-</code>) may be used
 * to specify a range so <code>[a-z]</code> specifies a range that matches from <code>"a"</code> to
 * <code>"z"</code> (inclusive). These forms can be mixed so [abce-g] matches <code>"a"</code>,
 * <code>"b"</code>, <code>"c"</code>, <code>"e"</code>, <code>"f"</code> or <code>"g"</code>. If
 * the character after the <code>[</code> is a <code>!</code> then it is used for negation so
 * <code>[!a-c]</code> matches any character except <code>"a"</code>, <code>"b"</code>, or
 * <code>"c"</code>.
 * <p>
 * Within a bracket expression the <code>*</code>, <code>?</code> and <code>\</code> characters
 * match themselves. The (<code>-</code>) character matches itself if it is the first character
 * within the brackets, or the first character after the <code>!</code> if negating.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * The <code>{ }</code> characters are a group of subpatterns, where the group matches if any
 * subpattern in the group matches. The <code>","</code> character is used to separate the
 * subpatterns. Groups cannot be nested.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * All other characters match themselves in an implementation dependent manner. This includes
 * characters representing any <A HREF="../../../java/nio/file/FileSystem.html#getSeparator()">
 * <CODE>name-separators</CODE></A>.
 * </p>
 * </li>
 * 
 * <li>
 * <p>
 * The matching of <A HREF="../../../java/nio/file/Path.html#getRoot()"><CODE>root</CODE></A>
 * components is highly implementation-dependent and is not specified.
 * </p>
 * </li>
 * 
 * </ul>
 * 
 * <p>
 * When the syntax is "<code>regex</code>" then the pattern component is a regular expression as
 * defined by the <A
 * HREF="http://download.java.net/jdk7/docs/api/java/util/regex/Pattern.html?is-external=true"
 * title="class or interface in java.util.regex"><CODE>Pattern</CODE></A> class.
 * 
 * <p>
 * For both the glob and regex syntaxes, the matching details, such as whether the matching is case
 * sensitive, are implementation-dependent and therefore not specified.
 * <p>
 * {@link IPathMatcher} objects are immutable.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IPathMatcher {
	/**
	 * Factory methods for {@link IPathMatcher}.
	 */
	public static final class Factory {
		/**
		 * Should not be instantiated.
		 */
		private Factory() {
			// Do nothing
		}

		/**
		 * Returns a {@link IPathMatcher} for the specified pattern.
		 * <p>
		 * The returned object is immutable and can be reused.
		 * 
		 * @param pattern the pattern of the wanted path matcher
		 * @return the matcher
		 */
		public static IPathMatcher getPathMatcher(String pattern) {
			return PathMatcher.getPathMatcher(pattern);
		}
	}

	/**
	 * Returns whether the given path matches this path matcher.
	 * 
	 * @param path the path to match
	 * @return <code>true</code> if path matches the path matcher
	 */
	boolean matches(String path);

	/**
	 * Returns whether the given path matches this path matcher, or - if the patch had just been
	 * longer - might have matched.
	 * <p>
	 * E.g.
	 * <code>IPathMatcher.Factory.getPathMatcher("/usr/tmp/*").matches("/usr/tm") == false</code>
	 * but
	 * <code>IPathMatcher.Factory.getPathMatcher("/usr/tmp/*").partiallyMatches("/usr/tm") == true</code>.
	 * 
	 * @param path the path to match
	 * @return <code>true</code> if path matches the path matcher or could have
	 */
	boolean partiallyMatches(String path);
}
