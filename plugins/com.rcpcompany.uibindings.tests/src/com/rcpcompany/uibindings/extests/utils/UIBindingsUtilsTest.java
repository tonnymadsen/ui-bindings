package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.junit.Test;

import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests {@link UIBindingsUtils} functions.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIBindingsUtilsTest {
	@Test
	public void cornerImageTests() {
		for (final DecorationPosition dp : DecorationPosition.values()) {
			final Image image = UIBindingsUtils.getCornerImage(dp, new RGB(255, 0, 0));
			testOneImage(image);
			// Check that the images are property cached
			assertEquals(image, UIBindingsUtils.getCornerImage(dp, new RGB(255, 0, 0)));
			assertNotSame(image, UIBindingsUtils.getCornerImage(dp, new RGB(255, 0, 1)));
		}
	}

	private void testOneImage(final Image image) {
		assertNotNull(image);
		assertEquals(5, image.getBounds().width);
		assertEquals(5, image.getBounds().height);
	}

	@Test
	public void defaultAlignmentTest() {
		assertEquals(SWT.NONE, UIBindingsUtils.defaultAlignment(Integer.class));

		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.EBYTE));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.EBYTE_OBJECT));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.ESHORT));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.ESHORT_OBJECT));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.EINT));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.EINTEGER_OBJECT));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.EFLOAT));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.EFLOAT_OBJECT));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.EDOUBLE));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.EDOUBLE_OBJECT));

		assertEquals(SWT.NONE, UIBindingsUtils.defaultAlignment(EcorePackage.Literals.ESTRING));

		assertEquals(SWT.NONE, UIBindingsUtils.defaultAlignment(ShopPackage.Literals.SHOP_ITEM__NAME));
		assertEquals(SWT.RIGHT, UIBindingsUtils.defaultAlignment(ShopPackage.Literals.SHOP_ITEM__PRICE));
	}
}
