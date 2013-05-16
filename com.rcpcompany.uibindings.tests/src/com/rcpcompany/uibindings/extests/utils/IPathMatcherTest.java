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
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.utils.IPathMatcher;

/**
 * Tests for {@link IPathMatcher}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class IPathMatcherTest {
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
		assertTrue(m1.partiallyMatches("c:\\tmp\\abc.ja"));

		assertFalse(m1.matches("a.java"));
		assertFalse(m1.partiallyMatches("a.ja"));
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
		assertTrue(m1.partiallyMatches("c:\\tmp\\ccc.java"));
		assertTrue(m1.partiallyMatches("c:\\tmp\\ccc"));

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
		assertTrue(m1.partiallyMatches("c:\\tmp\\ccc.java.c"));
		assertTrue(m1.partiallyMatches("c:\\tmp\\ccc.java.c"));
		assertTrue(m1.partiallyMatches("c:\\tmp\\c"));

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
		assertTrue(m1.partiallyMatches("c:\\a\\t\\c"));

		assertFalse(m1.matches("abc.java"));
		assertFalse(m1.matches("/a/b/abc.java"));
		assertFalse(m1.matches("/a/b.java/t"));
	}

	/**
	 * Tests a directory part "**" match..
	 */
	@Test
	public void dirStarStarMatch() {
		final IPathMatcher m1 = IPathMatcher.Factory.getPathMatcher("glob:/**/*.java");

		assertTrue(m1.matches("/tmp/a.java"));
		assertTrue(m1.matches("/a/a.java"));
		assertTrue(m1.matches("/a/b/abc.java"));
		assertTrue(m1.matches("c:\\a\\ccc.java"));

		assertFalse(m1.matches("abc.java"));
		assertFalse(m1.matches("/a/b.java/t"));

		final IPathMatcher m2 = IPathMatcher.Factory.getPathMatcher("glob:/windows/**");

		assertTrue(m2.matches("/windows"));
		assertTrue(m2.matches("/windows/"));
		assertTrue(m2.matches("/windows/temp"));
		assertTrue(m2.matches("C:\\Windows"));
		assertTrue(m2.matches("C:\\Windows\\"));
		assertTrue(m2.matches("C:\\Windows\\temp"));
		assertTrue(m2.matches("c:\\windows\\ccc.java"));

		assertFalse(m2.matches("abc.java"));
		assertFalse(m2.matches("/a/b/abc.java"));
		assertFalse(m2.matches("/a/b.java/t"));
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
