package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rcpcompany.uibindings.utils.IPathMatcher;

/**
 * Tests for {@link IPathMatcher}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class IPathMatcherTests {
	/**
	 * Tests that the matcher is immutable and the same matcher is returned every time.
	 */
	@Test
	public void matcherIsImmutable() {
		final IPathMatcher m1 = IPathMatcher.Factory.getPathMatcher("glob:*.*");
		final IPathMatcher m2 = IPathMatcher.Factory.getPathMatcher("glob:*.a");
		final IPathMatcher m3 = IPathMatcher.Factory.getPathMatcher("glob:*.*");

		assertEquals(m1, m3);
		assertNotSame(m1, m2);
	}

	/**
	 * Tests a constant match..
	 */
	@Test
	public void constantMatch() {
		final IPathMatcher m1 = IPathMatcher.Factory.getPathMatcher("glob:abc.java");

		assertTrue(m1.matches("abc.java"));
		assertTrue(m1.matches("/tmp/abc.java"));
		assertTrue(m1.matches("c:\\tmp\\abc.java"));

		assertFalse(m1.matches("a.java"));
	}

	/**
	 * Tests a file part star match..
	 */
	@Test
	public void fileStarMatch() {
		final IPathMatcher m1 = IPathMatcher.Factory.getPathMatcher("glob:*.java");

		assertTrue(m1.matches("abc.java"));
		assertTrue(m1.matches("/tmp/a.java"));
		assertTrue(m1.matches("c:\\tmp\\ccc.java"));

		assertFalse(m1.matches("a.java.c"));
	}

	/**
	 * Tests a file part star match..
	 */
	@Test
	public void fileStar2Match() {
		final IPathMatcher m1 = IPathMatcher.Factory.getPathMatcher("glob:*.java*");

		assertTrue(m1.matches("abc.java"));
		assertTrue(m1.matches("/tmp/a.java2"));
		assertTrue(m1.matches("c:\\tmp\\ccc.java.c"));

		assertFalse(m1.matches("a.jav.c"));
	}

	/**
	 * Tests a directory part "*" match..
	 */
	@Test
	public void dirStarMatch() {
		final IPathMatcher m1 = IPathMatcher.Factory.getPathMatcher("glob:/*/t/*.java");

		assertTrue(m1.matches("/tmp/t/a.java"));
		assertTrue(m1.matches("/a/t/a.java"));
		assertTrue(m1.matches("c:\\a\\t\\ccc.java"));

		assertFalse(m1.matches("abc.java"));
		assertFalse(m1.matches("/a/b/abc.java"));
		assertFalse(m1.matches("/a/b.java/t"));
	}

	/**
	 * Tests a directory part "**" match..
	 */
	@Test
	public void dirStarStarMatch() {
		final IPathMatcher m1 = IPathMatcher.Factory.getPathMatcher("glob:/*/*.java");

		assertTrue(m1.matches("/tmp/a.java"));
		assertTrue(m1.matches("/a/a.java"));
		assertTrue(m1.matches("c:\\a\\ccc.java"));

		assertFalse(m1.matches("abc.java"));
		assertFalse(m1.matches("/a/b/abc.java"));
		assertFalse(m1.matches("/a/b.java/t"));
	}

	/**
	 * Tests a ? match..
	 */
	@Test
	public void fileQuestionMatch() {
		final IPathMatcher m1 = IPathMatcher.Factory.getPathMatcher("glob:?.java*");

		assertTrue(m1.matches("c.java"));
		assertTrue(m1.matches("/tmp/a.java"));
		assertTrue(m1.matches("c:\\tmp\\c.java"));

		assertFalse(m1.matches("aa.java"));
	}
}
