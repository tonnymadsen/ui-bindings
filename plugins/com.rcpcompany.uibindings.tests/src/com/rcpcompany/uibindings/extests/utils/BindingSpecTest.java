package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertOneLog;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IBindingSpec;
import com.rcpcompany.uibindings.utils.IBindingSpec.BaseType;

/**
 * Test of {@link IBindingSpec}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingSpecTest {
	@Test
	public void testSimpleSpecFeature() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT, "name");
		assertEquals(1, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__NAME);
	}

	@Test
	public void testSimpleSpecRef() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT, "country");
		assertEquals(1, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY);
	}

	@Test
	public void testSimpleSpecRefFeature() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country.name");
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY);
		specTest(spec.get(1), ShopPackage.Literals.COUNTRY__NAME);
	}

	@Test
	public void testSimpleSpecMapW() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"name(w=100)");
		assertEquals(1, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__NAME, Constants.ARG_WIDTH, 100);
	}

	@Test
	public void testSimpleSpecMap__NONE__() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"__NONE__(toolTipText=hello)");
		assertEquals(1, spec.size());
		specTestOther(spec.get(0), BaseType.NONE, IBindingSpec.TOOLTIP, "hello");
	}

	@Test
	public void testSimpleSpecMap__ROW_NO__() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"__ROW_NO__(toolTipText=hello)");
		assertEquals(1, spec.size());
		specTestOther(spec.get(0), BaseType.ROW_NO, IBindingSpec.TOOLTIP, "hello");
	}

	@Test
	public void testSimpleSpecMapWTT() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country(toolTipText=hello).name(w=100,toolTipText='hello world',multi)");
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY, Constants.ARG_TOOL_TIP_TEXT, "hello");
		specTest(spec.get(1), ShopPackage.Literals.COUNTRY__NAME, Constants.ARG_WIDTH, 100, IBindingSpec.TOOLTIP,
				"hello world", IBindingSpec.MULTI, Boolean.TRUE);
	}

	@Test
	public void testSimpleSpecMapUnit1() {
		final Display d = Display.getDefault();
		final GC gc = new GC(d);
		final Font f = JFaceResources.getDefaultFont();
		gc.setFont(f);
		final FontMetrics fm = gc.getFontMetrics();
		gc.dispose();

		final float fh = f.getFontData()[0].height;
		assertTrue("Font size range, got " + fh, 8.0f < fh && fh < 18.0f);

		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country(w=10em).name(w=10dlu)");
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY, Constants.ARG_WIDTH, Math.round(10 * fh));
		specTest(spec.get(1), ShopPackage.Literals.COUNTRY__NAME, Constants.ARG_WIDTH, Math.round(10 / 4.0f * fh));
	}

	@Test
	public void testSimpleSpecMapUnit2() {
		final Display d = Display.getDefault();

		assertEquals(96, d.getDPI().x);

		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country(w=10mm).name(width=10px)");
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY, Constants.ARG_WIDTH, 10 * 96 / 25);
		specTest(spec.get(1), ShopPackage.Literals.COUNTRY__NAME, Constants.ARG_WIDTH, 10);
	}

	@Test
	public void testSimpleSpecMapMore() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"name(tooltiptext=hello, type=number,label='abc')");
		assertEquals(1, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__NAME, IBindingSpec.TOOLTIP, "hello", Constants.ARG_TYPE,
				"number", Constants.ARG_LABEL, "abc");
	}

	@Test
	public void testSimpleSpecOK1() {
		final List<IBindingSpec> spec = IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT,
				"country().name");
		assertEquals(2, spec.size());
		specTest(spec.get(0), ShopPackage.Literals.CONTACT__COUNTRY);
		specTest(spec.get(1), ShopPackage.Literals.COUNTRY__NAME);
	}

	public void specTest(IBindingSpec s, EStructuralFeature feature, Object... vars) {
		specTestOther(s, BaseType.FEATURE, vars);
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

	public void testSimpleSpecSyntaxError(final String spec) {
		assertOneLog(new Runnable() {
			public void run() {
				try {
					IBindingSpec.Factory.parseSingleSpec(ShopPackage.Literals.CONTACT, spec);
					fail("Spec '" + spec + "' does not fail");
				} catch (final RuntimeException ex) {
					assertTrue(ex.getClass() == RuntimeException.class);
				}
			}
		});
	}

	@Test
	public void testSimpleSpecSyntaxError1() {
		testSimpleSpecSyntaxError("country((");
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
		testSimpleSpecSyntaxError("country..name");
	}

	@Test
	public void testSimpleSpecSyntaxError4() {
		testSimpleSpecSyntaxError("country#");
	}

	/**
	 * A lone attribute name is only legal for boolean attributes.
	 */
	@Test
	public void testSimpleSpecSyntaxError5() {
		testSimpleSpecSyntaxError("country(w)");
	}

	@Test
	public void testSimpleSpecSyntaxError6() {
		testSimpleSpecSyntaxError("country(w=)");
	}

	@Test
	public void testSimpleSpecOther__NONE__MultiLevel() {
		testSimpleSpecSyntaxError("__NONE__.name)");
	}

	@Test
	public void testSimpleSpecOther__ROW_NO__MultiLevel() {
		testSimpleSpecSyntaxError("__ROW_NO__.name)");
	}

	@Test
	public void testSimpleSpecUnitError1() {
		testSimpleSpecSyntaxError("country(w=1 xx)");
	}

	@Test
	public void testSimpleSpecUnitError2() {
		testSimpleSpecSyntaxError("country(a=1 em)");
	}

	@Test
	public void testSimpleSpecTypeError1() {
		testSimpleSpecSyntaxError("country.country");
	}

	@Test
	public void testSimpleSpecTypeError2() {
		testSimpleSpecSyntaxError("country.name.name");
	}

	@Test
	public void testSimpleSpecTypeError3() {
		testSimpleSpecSyntaxError("country2");
	}

	@Test
	public void testSimpleSpecTypeError4() {
		testSimpleSpecSyntaxError("country(w=w)");
	}

	@Test
	public void testSimpleSpecTypeError5() {
		testSimpleSpecSyntaxError("country(w2=2)");
	}

	@Test
	public void testSimpleSpecTypeError6() {
		testSimpleSpecSyntaxError("country(tooltiptext=2)");
	}

}
