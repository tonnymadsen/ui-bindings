package com.rcpcompany.uibindings.extests.widgets;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.resetAll;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;
import com.rcpcompany.uibindings.widgets.FileNameControl;

/**
 * Test of {@link FileNameControl}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class FileNameWidgetTest {
	protected final String myType;
	protected final boolean myNewAllowed;
	protected final String myExtensions;
	protected final String myInitValue;

	int VD = 50;

	public FileNameWidgetTest(String type, boolean newAllowed, String extensions, String initValue) {
		myType = type;
		myNewAllowed = newAllowed;
		myExtensions = extensions;
		myInitValue = initValue;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ Constants.TYPE_FILE_NAME, false, null, "" }

		});
	}

	private TestView myView;
	private Shop myShop;
	private IFormCreator myForm;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setValidationDelay(VD);

		myView = createTestView(this);

		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName(myInitValue);

		myForm = myView.createFormCreator(myShop);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	IValueBinding b = null;

	/**
	 * Test for file widget creation
	 */
	@Test
	public void testValueBindingWidgetCreation() {
		assertNoLog(new Runnable() {

			public void run() {
				b = myForm.addField("name").type(myType).arg(Constants.ARG_NEW_ALLOWED, myNewAllowed).arg(
						Constants.ARG_EXTENSIONS, myExtensions);
				myForm.finish();
			}
		});

		assertTrue(b.getControl() instanceof FileNameControl);

		testFunction(b);
	}

	/**
	 * Test for binding to a Text
	 */
	@Test
	public void testValueBindingText() {
		assertNoLog(new Runnable() {
			public void run() {
				final Text w = new Text(myForm.addComposite(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
				w.setText("");

				b = myForm.getContext().addBinding(w, myShop, ShopPackage.Literals.SHOP__NAME).type(myType).arg(
						Constants.ARG_NEW_ALLOWED, myNewAllowed).arg(Constants.ARG_EXTENSIONS, myExtensions);
				myForm.finish();
			}
		});

		testFunction(b);
	}

	/**
	 * Test for binding to a {@link FileNameControl}
	 */
	@Test
	public void testValueBindingFNW() {
		assertNoLog(new Runnable() {
			public void run() {
				final FileNameControl w = new FileNameControl(myForm.addComposite(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
				w.setText("");

				b = myForm.getContext().addBinding(w, myShop, ShopPackage.Literals.SHOP__NAME).type(myType).arg(
						Constants.ARG_NEW_ALLOWED, myNewAllowed).arg(Constants.ARG_EXTENSIONS, myExtensions);
				myForm.finish();
			}
		});

		testFunction(b);
	}

	private void testFunction(IValueBinding b) {
		final boolean isFNW = b.getControl() instanceof FileNameControl;
		final Text text;
		if (isFNW) {
			text = ((FileNameControl) b.getControl()).getTextControl();
		} else {
			text = (Text) b.getControl();
		}

		final IValidatorAdapterManager vam = IValidatorAdapterManager.Factory.getManager();

		sleep(VD * 2);

		assertEquals(myInitValue, text.getText());
		assertEquals(0, vam.getUnboundMessages().size());

		// TODO
	}
}