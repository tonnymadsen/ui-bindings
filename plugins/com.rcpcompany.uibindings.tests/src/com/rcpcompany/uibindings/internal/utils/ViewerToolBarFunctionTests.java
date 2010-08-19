package com.rcpcompany.uibindings.internal.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.uibindings.utils.IViewerToolBar;

/**
 * Tests of the {@link ToolBar} item functionality of {@link IViewerToolBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerToolBarFunctionTests {
	private TestView myView;

	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;

	private IFormCreator myForm;

	private ITableCreator myTable;

	private IViewerBinding myTableBinding;

	@Before
	public void before() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setAbbreviation("AB");
		myCountry1.setShop(myShop);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setAbbreviation("AB");
		myCountry2.setShop(myShop);

		myView = createTestView(this);
		myForm = myView.createFormCreator(myShop);

		myTable = myForm.addTableCreator(ShopPackage.Literals.SHOP__COUNTRIES, true, SWT.NONE);
		myTableBinding = myTable.getBinding();

		myForm.finish();
	}

	/**
	 * Tests that the correct command is executed for ADD.
	 */
	@Test
	public void testButtonFunctionADD() {
		testButton(IViewerToolBar.ADD, "");
	}

	/**
	 * Tests that the correct command is executed for DELETE.
	 */
	@Test
	public void testButtonFunctionDELETE() {
		testButton(IViewerToolBar.DELETE, "org.eclipse.ui.edit.delete");
	}

	/**
	 * Tests that the correct command is executed for UP.
	 */
	@Test
	public void testButtonFunctionUP() {
		testButton(IViewerToolBar.UP, "com.rcpcompany.uibindings.commands.moveItemUp");
	}

	/**
	 * Tests that the correct command is executed for DOWN.
	 */
	@Test
	public void testButtonFunctiondOWN() {
		testButton(IViewerToolBar.DOWN, "com.rcpcompany.uibindings.commands.moveItemDown");
	}

	/**
	 * Tests that the specified button executes the specified command.
	 * 
	 * @param itemID the button ID
	 * @param commandID the command string
	 */
	private void testButton(int itemID, String commandID) {
		final IViewerToolBar bb = IViewerToolBar.Factory.addToolBar(myTableBinding, itemID);

		final ToolItem button = bb.getItem(itemID);
		//button.se
	}
}
