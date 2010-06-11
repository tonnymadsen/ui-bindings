package com.rcpcompany.uibindings.extests.observables.getset;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests that when the model is changed, then the ValueBinding is changed as well.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BasicSetTestValue {

	private Shop myShop;
	private TestView myView;
	private Composite myBody;
	private Text myShopName;
	protected IBindingContext myContext;

	@Before
	public void before() {
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("NoName");
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myShopName = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myShopName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myShopName.setText("");
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Binds the UI
	 */
	public void bindUI() {
		assertNoLog(new Runnable() {
			public void run() {
				myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

				myContext.addBinding(myShopName, myShop, ShopPackage.Literals.SHOP__NAME);
				myContext.finish();
				yield();
			}
		});
	}

	@Test
	public void testSetName() {
		final String oldName = myShop.getName();

		assertEquals(myShop.getName(), myShopName.getText());

		myShop.setName(oldName + "--");
		assertEquals(oldName + "--", myShop.getName());
		assertEquals(oldName + "--", myShopName.getText());

		myShop.setName(oldName);
	}
}
