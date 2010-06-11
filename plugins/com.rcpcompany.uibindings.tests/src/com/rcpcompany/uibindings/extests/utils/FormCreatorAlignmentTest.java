package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Test of {@link IFormCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormCreatorAlignmentTest {
	private Contact myContact;

	private TestView myView;

	private Shop myShop;
	private IFormCreator myForm;
	private IValueBinding myShopName;
	private IFormCreator myContactSection;
	private IValueBinding myContactName;

	@Before
	public void before() {
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("my shop");

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("John Doe");
		myContact.setShop(myShop);

	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myForm = myView.createFormCreator(myShop);
		myShopName = myForm.addField("name(label='Shop Name')");

		myContactSection = myForm.addSection("contact", myContact);
		myContactName = myContactSection.addField("name(label='Contact Name')");

		final IFormCreator[] columns = myForm.addColumns(true, true);
		for (final IFormCreator c : columns) {
			c.addField("name(label='Shop Name')");
		}

		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testAlignment() {
		yield();
		final int shopNameLeft = getLeft(myShopName);
		final int contactNameLeft = getLeft(myContactName);

		assertEquals(shopNameLeft, contactNameLeft);
	}

	private int getLeft(IValueBinding b) {
		final Control c = b.getControl();
		final Composite top = myForm.getTop();
		final Rectangle r = top.getDisplay().map(c.getParent(), top, c.getBounds());
		return r.x;
	}
}