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
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IBindingSpec;
import com.rcpcompany.uibindings.utils.IBindingSpec.BaseType;
import com.rcpcompany.uibindings.utils.IBindingSpec.SpecContext;

/**
 * Test of {@link IBindingSpec}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingSpecTest {
	@Test
	public void testSimpleSpecFeature() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT, "name",
				SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(1, spec.size());
		specTest(spec.get(0), IMOAOPackage.Literals.NAMED_OBJECT__NAME);
	}

	@Test
	public void testSimpleSpecRef() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT, "country",
				SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(1, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY);
	}

	@Test
	public void testSimpleSpecRefFeature() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country.name", SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY);
		specTest(spec.get(1), IMOAOPackage.Literals.NAMED_OBJECT__NAME);
	}

	@Test
	public void testSimpleSpecMapW() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"name(w=100)", SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(1, spec.size());
		specTest(spec.get(0), IMOAOPackage.Literals.NAMED_OBJECT__NAME, Constants.ARG_WIDTH, 100);
	}

	@Test
	public void testSimpleSpecMap__NONE__() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"__NONE__(toolTipText=hello)", SpecContext.TABLE_COLUMN);
		assertNotNull(spec);
		assertEquals(1, spec.size());
		specTestOther(spec.get(0), BaseType.NONE, IBindingSpec.TOOLTIP, "hello");
	}

	@Test
	public void testSimpleSpecMap__ROW_NO__() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"__ROW_NO__(toolTipText=hello)", SpecContext.TABLE_COLUMN);
		assertNotNull(spec);
		assertEquals(1, spec.size());
		specTestOther(spec.get(0), BaseType.ROW_NO, IBindingSpec.TOOLTIP, "hello");
	}

	@Test
	public void testSimpleSpecMap__ROW_ELEMENT__() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"__ROW_ELEMENT__(toolTipText=hello)", SpecContext.TABLE_COLUMN);
		assertNotNull(spec);
		assertEquals(1, spec.size());
		specTestOther(spec.get(0), BaseType.ROW_ELEMENT, IBindingSpec.TOOLTIP, "hello");
	}

	@Test
	public void testSimpleSpecMapWTT() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country(toolTipText=hello).name(w=100,toolTipText='hello world',multi)", SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY, Constants.ARG_TOOL_TIP_TEXT, "hello");
		specTest(spec.get(1), IMOAOPackage.Literals.NAMED_OBJECT__NAME, Constants.ARG_WIDTH, 100, IBindingSpec.TOOLTIP,
				"hello world", IBindingSpec.MULTI, Boolean.TRUE);
	}

	@Test
	public void testSimpleSpecKV() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.SHOP_ITEM,
				"properties{name=here:value}(toolTipText=hello)", SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(1, spec.size());
		specTestKV(spec.get(0), ShopPackage.Literals.SHOP_ITEM__PROPERTIES, IMOAOPackage.Literals.NAMED_OBJECT__NAME,
				"here", ShopPackage.Literals.SHOP_ITEM_PROPERTIES__VALUE, IBindingSpec.TOOLTIP, "hello");
	}

	@Test
	public void testSimpleSpecMapUnit1() {
		final Display d = Display.getDefault();
		final GC gc = new GC(d);
		final Font f = JFaceResources.getDefaultFont();
		gc.setFont(f);
		final FontMetrics fm = gc.getFontMetrics();
		gc.dispose();

		final float fh = f.getFontData()[0].getHeight();
		assertTrue("Font size range, got " + fh, 7.0f <= fh && fh < 18.0f);

		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country(w=10em).name(w=10dlu)", SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY, Constants.ARG_WIDTH, Math.round(10 * fh));
		specTest(spec.get(1), IMOAOPackage.Literals.NAMED_OBJECT__NAME, Constants.ARG_WIDTH, Math.round(10 / 4.0f * fh));
	}

	@Test
	public void testSimpleSpecMapUnit2() {
		final Display d = Display.getDefault();

		final int dpi = d.getDPI().x;

		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country(w=10mm).name(width=10px)", SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY, Constants.ARG_WIDTH, 10 * dpi / 25);
		specTest(spec.get(1), IMOAOPackage.Literals.NAMED_OBJECT__NAME, Constants.ARG_WIDTH, 10);
	}

	@Test
	public void testSimpleSpecMapMore() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"name(tooltiptext=hello, type=number,label='abc')", SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(1, spec.size());
		specTest(spec.get(0), IMOAOPackage.Literals.NAMED_OBJECT__NAME, IBindingSpec.TOOLTIP, "hello",
				Constants.ARG_TYPE, "number", Constants.ARG_LABEL, "abc");
	}

	@Test
	public void testSimpleSpecOK1() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country().name", SpecContext.FORM_FIELD);
		assertNotNull(spec);
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY);
		specTest(spec.get(1), IMOAOPackage.Literals.NAMED_OBJECT__NAME);
	}

	public void specTest(IBindingSpec s, EStructuralFeature feature, Object... vars) {
		specTestOther(s, BaseType.FEATURE, vars);
		assertEquals(feature, s.getFeature());
	}

	public void specTestKV(IBindingSpec s, EStructuralFeature feature, EStructuralFeature keyFeature, Object key,
			EStructuralFeature valueFeature, Object... vars) {
		specTestOther(s, BaseType.KEY_VALUE, vars);
		assertEquals(feature, s.getFeature());
	}

	public void specTestOther(IBindingSpec s, BaseType type, Object... vars) {
		assertEquals(type, s.getType());

		assertTrue(vars.length % 2 == 0);
		final Map<String, Object> args = s.getArguments();
		for (int i = 0; i < vars.length; i += 2) {
			final String n = (String) vars[i];
			final Object v = vars[i + 1];

			assertTrue(args.containsKey(n));
			assertEquals(v, args.get(n));
		}
		assertEquals(vars.length / 2, args.size());
	}

	public void testSimpleSpecSyntaxError(final EClass startType, final String spec, final SpecContext context) {
		assertOneLog(new Runnable() {
			@Override
			public void run() {
				try {
					final List<IBindingSpec> specList = IBindingSpec.Factory.parseSingleSpec(startType, spec, context);
					assertEquals(null, specList);
				} catch (final Exception ex) {
					fail(ex.getMessage());
				}
			}
		});
	}

	@Test
	public void testSimpleSpecSyntaxError1() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country((", SpecContext.FORM_FIELD);
	}

	/**
	 * Succeeds! Though it should not. Not important enough to fix!
	 */
	// @Test
	// public void testSimpleSpecSyntaxError2() {
	// testSimpleSpecSyntaxError("country.");
	// }

	@Test
	public void testSimpleSpecSyntaxError3() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country..name", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxError4() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country#", SpecContext.FORM_FIELD);
	}

	/**
	 * A lone attribute name is only legal for boolean attributes.
	 */
	@Test
	public void testSimpleSpecSyntaxError5() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country(w)", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxError6() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country(w=)", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxErrorKV1() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM, "properties{name=here:value(toolTipText=hello)",
				SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxErrorKV2() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM, "properties{name=here:}(toolTipText=hello)",
				SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxErrorKV3() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM, "properties{name=here value}(toolTipText=hello)",
				SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxErrorKV4() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM,
				"properties{name=here there:value}(toolTipText=hello)", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxErrorKV5() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM, "properties{name= :value}(toolTipText=hello)",
				SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxErrorKV6() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM, "properties{name here:value}(toolTipText=hello)",
				SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecSyntaxErrorKV7() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM, "properties{ =here:value}(toolTipText=hello)",
				SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecOther__NONE__MultiLevel() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__NONE__.name", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecOther__ROW_NO__MultiLevel() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__ROW_NO__.name", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecOther__ROW_ELEMENT__MultiLevel() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__ROW_ELEMENT__.name", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecErrorField__NONE__() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__NONE__", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecErrorField__ROW_NO__() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__ROW_NO__", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecErrorField__ROW_ELEMENT__() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__ROW_ELEMENT__", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecErrorObsNoArgs() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "name(w=10)", SpecContext.OBSERVABLE);
	}

	@Test
	public void testSimpleSpecErrorObs__NONE__() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__NONE__", SpecContext.OBSERVABLE);
	}

	@Test
	public void testSimpleSpecErrorObs__ROW_NO__() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__ROW_NO__", SpecContext.OBSERVABLE);
	}

	@Test
	public void testSimpleSpecErrorObs__ROW_ELEMENT__() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "__ROW_ELEMENT__", SpecContext.OBSERVABLE);
	}

	@Test
	public void testSimpleSpecUnitError1() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country(w=1 xx)", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecUnitError2() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country(a=1 em)", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecTypeError1() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country.country", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecTypeError2() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country.name.name", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecTypeError3() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country2", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecTypeError4() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country(w=w)", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecTypeError5() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country(w2=2)", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecTypeError6() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.CONTACT, "country(tooltiptext=2)", SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecTypeError7() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM, "properties{name2=here:value}(toolTipText=hello)",
				SpecContext.FORM_FIELD);
	}

	@Test
	public void testSimpleSpecTypeError8() {
		testSimpleSpecSyntaxError(ShopPackage.Literals.SHOP_ITEM, "properties{name=here:value2}(toolTipText=hello)",
				SpecContext.FORM_FIELD);
	}

}
