package com.rcpcompany.test.utils.xml;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Matcher that tests whether the string under test is similar to the specified XML.
 * 
 * @author Tonny Madsen, tonny.madsen@gmail.com
 */
public class XMLSimilar extends TypeSafeMatcher<String> {
	private final String myXML;

	/**
	 * @param xml
	 *            the XML to test again
	 */
	public XMLSimilar(String xml) {
		myXML = xml;
	}

	@Override
	public boolean matchesSafely(String item) {
		final XMLDiff diff = new XMLDiff();
		final List<String> diffs = new ArrayList<String>();
		try {
			return !diff.diff(myXML, item, diffs);
		} catch (final Exception ex) {
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("an XML document similar to ").appendText(myXML);
	}

	@Override
	protected void describeMismatchSafely(String item, Description mismatchDescription) {
		final XMLDiff diff = new XMLDiff();
		final List<String> diffs = new ArrayList<String>();
		try {
			if (!diff.diff(myXML, item, diffs))
				return;
		} catch (final Exception ex) {
			mismatchDescription.appendText("with exception " + ex);
			return;
		}

		mismatchDescription.appendText("has differences:");
		for (final String d : diffs) {
			mismatchDescription.appendText("\n      * " + d);
		}
	}

	@Factory
	public static Matcher<String> hasSimilarXML(String xml) {
		return new XMLSimilar(xml);
	}
}
