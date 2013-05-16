package com.rcpcompany.test.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.Severity;

/**
 * Various test utilities for {@link IMOAO}
 * 
 * @author Tonny Madsen, tonny.madsen@gmail.com
 */
public class MOAOTestUtils {
	/**
	 * Asserts that the specified object has an {@link IMOAOMessage} for the specified feature, severity and message
	 * (regexp).
	 * 
	 * @param obj
	 *            the object
	 * @param sf
	 *            the feature of the object
	 * @param severity
	 *            the severity
	 * @param messageRE
	 *            the message (an regexp)
	 */
	public static void assertMOAOMessage(IMOAO obj, EStructuralFeature sf, Severity severity, String messageRE) {
		assertTrue("No messages/facets for " + obj, obj.eIsSet(IMOAOPackage.Literals.MOAO__FACETS));

		String s = "";
		for (final IMOAOFacet f : obj.getFacets()) {
			if (!(f instanceof IMOAOMessage)) {
				continue;
			}

			final IMOAOMessage m = (IMOAOMessage) f;
			final EStructuralFeature msf = m.getFeature();
			s += "\n    " + (msf != null ? msf.getName() : "<no feature>") + " - " + m.getSeverity() + ": '"
					+ m.getDescription() + "'";
			if (msf != sf) {
				continue;
			}
			if (m.getSeverity() != severity) {
				continue;
			}
			final String description = m.getDescription();
			if (description == null) {
				continue;
			}
			if (!description.matches(messageRE)) {
				continue;
			}

			return;
		}

		fail("Expected message not found for " + obj + "\nFeature: " + sf + "\nSeverity: " + severity + "\nMessage: '"
				+ messageRE + "'\nHave:" + s);
	}

	/**
	 * Asserts that there are no messages in the containment tree with the specified root.
	 * 
	 * @param root
	 *            the root of the three
	 */
	public static void assertNoMOAOMessages(IMOAO root) {
		assertNoMOAOMessagesOne(root);
		for (final TreeIterator<EObject> ti = root.eAllContents(); ti.hasNext();) {
			assertNoMOAOMessagesOne(ti.next());
		}
	}

	private static void assertNoMOAOMessagesOne(EObject obj) {
		if (!(obj instanceof IMOAO))
			return;
		if (!(obj.eIsSet(IMOAOPackage.Literals.MOAO__FACETS)))
			return;
		final IMOAO m = (IMOAO) obj;
		for (final IMOAOFacet f : m.getFacets()) {
			assertTrue(obj + " has message", !(f instanceof IMOAOMessage));
		}
	}
}
