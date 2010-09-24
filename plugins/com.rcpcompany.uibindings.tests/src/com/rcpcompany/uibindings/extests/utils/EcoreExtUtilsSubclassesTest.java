package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;

import com.rcpcompany.uibindings.EcoreExtUtils;
import com.rcpcompany.uibindings.extests.BaseTestUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests {@link EcoreExtUtils#getSubClasses(EClass)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EcoreExtUtilsSubclassesTest {
	@Test
	public void testResults() {
		testOneResult(EcorePackage.Literals.ECLASS);
		testOneResult(EcorePackage.Literals.ESTRUCTURAL_FEATURE, EcorePackage.Literals.EATTRIBUTE,
				EcorePackage.Literals.EREFERENCE);
	}

	public void testOneResult(EClass sc, EClass... expectedSubClasses) {
		final Collection<EClass> subClasses = EcoreExtUtils.getSubClasses(sc);
		LogUtils.debug(this, sc.getName() + ": " + subClasses);
		if (expectedSubClasses.length == 0) {
			assertEquals(null, subClasses);
			return;
		}
		final EClass[] foundSubClasses = subClasses.toArray(new EClass[subClasses.size()]);
		Arrays.sort(expectedSubClasses, BaseTestUtils.OBJECT_COMPARATOR);
		Arrays.sort(foundSubClasses, BaseTestUtils.OBJECT_COMPARATOR);

		assertArrayEquals(expectedSubClasses, foundSubClasses);
	}
}
