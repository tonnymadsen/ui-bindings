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
package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests that {@link IValueBinding#setFocus()} works correctly.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class BindingSetFocusTest {
	protected final Creator myCreator;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// Container

				{ new TabFolderCreator() },

				{ new CTabFolderCreator() },

				{ new SectionCreator() },

				{ new ExpandableCompositeCreator() },

		});
	}

	public BindingSetFocusTest(Creator creator) {
		myCreator = creator;
	}

	private Shop myShop;
	private UIBTestView myView;
	private Contact myContact;
	private IFormCreator myForm;
	private IValueBinding myNameBinding;
	private ITableCreator myTableCreator;
	private IColumnBinding myColumnBinding;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();

		myView.getSite().getPage().activate(myView);
		yield();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("noname");

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("NN");
		myContact.setShop(myShop);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myForm = myView.createFormCreator(myShop);

		/*
		 * Create the specific type of container
		 */
		myCreator.setForm(myForm);
		myCreator.createComposite();

		/*
		 * Create the wanted type of control
		 */
		final IFormCreator subForm = myCreator.getSubForm();
		myNameBinding = subForm.addField("name");
		myTableCreator = subForm.addTableCreator(ShopPackage.Literals.SHOP__CONTACTS, true, SWT.NONE);
		myColumnBinding = myTableCreator.addColumn("name");

		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testValueBinding() {
		final Control control = myNameBinding.getControl();
		// LogUtils.debug(this, "b=" + control.getBounds());
		assertEquals(false, control.isFocusControl());
		// assertEquals(false, control.isVisible());

		myNameBinding.setFocus();

		assertEquals(true, control.isFocusControl());
		assertEquals(true, control.isVisible());
		myCreator.testState();
	}

	public static abstract class Creator {
		protected IFormCreator myForm;
		protected IFormCreator subForm;

		public void setForm(IFormCreator form) {
			myForm = form;
		}

		public abstract void createComposite();

		public IFormCreator getSubForm() {
			return subForm;
		}

		public abstract void testState();
	}

	protected static class TabFolderCreator extends Creator {
		private TabFolder tabFolder;
		private TabItem correctTabItem;
		private TabItem wrongTabItem;

		@Override
		public void createComposite() {
			final Composite composite = myForm.addComposite();
			tabFolder = new TabFolder(composite, SWT.TOP);
			tabFolder.setLayout(new FillLayout());

			correctTabItem = new TabItem(tabFolder, SWT.NONE);
			correctTabItem.setText("Correct");
			final Composite c = new Composite(tabFolder, SWT.NONE);
			correctTabItem.setControl(c);

			subForm = myForm.subForm(c);

			wrongTabItem = new TabItem(tabFolder, SWT.NONE);
			wrongTabItem.setText("Wrong");
			final Composite c2 = new Composite(tabFolder, SWT.NONE);
			wrongTabItem.setControl(c2);

			tabFolder.setSelection(1);
		}

		@Override
		public void testState() {
			assertEquals(0, tabFolder.getSelectionIndex());
		}
	}

	protected static class CTabFolderCreator extends Creator {
		private CTabFolder tabFolder;
		private CTabItem correctTabItem;
		private CTabItem wrongTabItem;

		@Override
		public void createComposite() {
			final Composite composite = myForm.addComposite();
			tabFolder = new CTabFolder(composite, SWT.TOP);
			tabFolder.setLayout(new FillLayout());

			correctTabItem = new CTabItem(tabFolder, SWT.NONE);
			correctTabItem.setText("Correct");
			final Composite c = new Composite(tabFolder, SWT.NONE);
			correctTabItem.setControl(c);

			subForm = myForm.subForm(c);

			wrongTabItem = new CTabItem(tabFolder, SWT.NONE);
			wrongTabItem.setText("Wrong");
			final Composite c2 = new Composite(tabFolder, SWT.NONE);
			wrongTabItem.setControl(c2);

			tabFolder.setSelection(1);
		}

		@Override
		public void testState() {
			assertEquals(0, tabFolder.getSelectionIndex());
		}
	}

	protected static class SectionCreator extends Creator {
		private Section mySection;

		@Override
		public void createComposite() {
			final Composite composite = myForm.addComposite();

			mySection = myForm.getToolkit().createSection(composite,
					ExpandableComposite.TITLE_BAR | ExpandableComposite.TWISTIE);
			mySection.clientVerticalSpacing = 6;
			mySection.setText("label");

			// mySection.setExpanded(false);

			final Composite c = new Composite(mySection, SWT.NONE);
			c.setLayout(new FillLayout());

			mySection.setClient(c);

			subForm = myForm.subForm(c);
		}

		@Override
		public void testState() {
			assertEquals(true, mySection.isExpanded());
		}
	}

	protected static class ExpandableCompositeCreator extends Creator {
		private ExpandableComposite myEC;

		@Override
		public void createComposite() {
			final Composite composite = myForm.addComposite();

			myEC = new ExpandableComposite(composite, SWT.NONE);
			myEC.clientVerticalSpacing = 6;
			myEC.setText("label");

			myEC.setExpanded(false);

			final Composite c = new Composite(myEC, SWT.NONE);
			c.setLayout(new FillLayout());

			myEC.setClient(c);

			subForm = myForm.subForm(c);
		}

		@Override
		public void testState() {
			assertEquals(true, myEC.isExpanded());
		}
	}
}
