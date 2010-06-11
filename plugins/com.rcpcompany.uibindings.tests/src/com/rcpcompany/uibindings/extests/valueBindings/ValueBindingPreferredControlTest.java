package com.rcpcompany.uibindings.extests.valueBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.views.TestView;

/**
 * Tests that when the model is changed, then the widget is changed as well.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ValueBindingPreferredControlTest {

	private final EStructuralFeature myFeature;
	private final int myStyles;
	private final Class<? extends Control> myControlClass;
	private final String what;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ TestModelPackage.Literals.TEST_OBJECT__NUMBER, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__B, Button.class, SWT.CHECK },

		{ TestModelPackage.Literals.TEST_OBJECT__TIME_UNIT, CCombo.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__BIG_DECIMAL, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__BIG_INTEGER, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__BYTE, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__F, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__D, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__DATE, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__LONG, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__PARENT, Text.class, SWT.NONE },

		{ TestModelPackage.Literals.TEST_OBJECT__TEXT, Text.class, SWT.NONE },

		});
	}

	public ValueBindingPreferredControlTest(EStructuralFeature feature, Class<? extends Control> controlClass,
			int styles) {
		myFeature = feature;
		myControlClass = controlClass;
		myStyles = styles;

		what = "Feature " + feature.getName();
	}

	private TestView myView;
	private TestObject myObject;
	private IValueBinding myBinding;

	@Before
	public void setup() {
		createModel();
		createView();
	}

	private void createModel() {
		myObject = TestModelFactory.eINSTANCE.createTestObject();
	}

	private void createView() {
		myView = createTestView(this);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testValue() {

		assertNoLog(new Runnable() {
			public void run() {
				final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

				myBinding = context.addBinding().model(myObject, myFeature);

				final Control control = myBinding.createPreferredControl(myView.getBody(), SWT.NONE);

				assertNotNull(what, control);
				assertTrue(what, myControlClass.isInstance(control));

				final int style = control.getStyle();
				assertTrue(what, (style & myStyles) == myStyles);

				myBinding.ui(control);

				context.finish();
				yield();
			}
		}, new String[] { ".*Binding cannot be changed.*" });
	}
}