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
package com.rcpcompany.uibindings.extests.widgets;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

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
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;
import com.rcpcompany.uibindings.widgets.FileNameControl;

/**
 * Test of {@link FileNameControl}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class FileNameControlTest {
	protected final String myType;
	protected final boolean myNewAllowed;
	protected final String myExtensions;
	protected final String myInitValue;

	int VD = 50;

	public FileNameControlTest(String type, boolean newAllowed, String extensions, String initValue) {
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

	private UIBTestView myView;
	private Shop myShop;
	private IFormCreator myForm;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setValidationDelay(VD);

		myView = BaseUIBTestUtils.createUIBTestView(this);

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

			@Override
			public void run() {
				b = myForm.addField("name").type(myType).arg(Constants.ARG_NEW_ALLOWED, myNewAllowed)
						.arg(Constants.ARG_EXTENSIONS, myExtensions);
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
			@Override
			public void run() {
				final Text w = new Text(myForm.addComposite(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
				w.setText("");

				b = myForm.getContext().addBinding(w, myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME).type(myType)
						.arg(Constants.ARG_NEW_ALLOWED, myNewAllowed).arg(Constants.ARG_EXTENSIONS, myExtensions);
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
			@Override
			public void run() {
				final FileNameControl w = new FileNameControl(myForm.addComposite(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
				w.setText("");

				b = myForm.getContext().addBinding(w, myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME).type(myType)
						.arg(Constants.ARG_NEW_ALLOWED, myNewAllowed).arg(Constants.ARG_EXTENSIONS, myExtensions);
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
