package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests the use of {@link Constants#ARG_ITEM_DELETOR}.
 * <p>
 * Depends on:
 * <ul>
 * <li>Country has a deletor (GenericDeletor)</li>
 * <li>Shop Item does not</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerItemDeletorTest {
	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private ShopItem myShopItem1;

	private TestView myView;
	private Composite myBody;

	private TableViewer myTableViewer1;
	private Table myTable1;
	private TableViewerColumn myNameColumn1;

	private TableViewer myTableViewer2;
	private TableViewerColumn myNameColumn2;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding1;
	private IViewerBinding myViewerBinding2;

	@Before
	public void before() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
		myBody.layout();
	}

	@After
	public void after() {
		IManager.Factory.getManager().setEditCellSingleClick(true);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setName("1");
		myShop.getCountries().add(myCountry1);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setName("2");
		myShop.getCountries().add(myCountry2);

		myShopItem1 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem1.setName("si1");
		myShop.getShopItems().add(myShopItem1);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myTableViewer1 = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		myTable1 = myTableViewer1.getTable();
		myTable1.setLayoutData(new TableWrapData(TableWrapData.FILL));
		myTable1.setHeaderVisible(true);

		myNameColumn1 = new TableViewerColumn(myTableViewer1, SWT.NONE);
		myNameColumn1.getColumn().setWidth(100);

		myTableViewer2 = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		final Table table = myTableViewer1.getTable();
		table.setLayoutData(new TableWrapData(TableWrapData.FILL));
		table.setHeaderVisible(true);

		myNameColumn2 = new TableViewerColumn(myTableViewer2, SWT.NONE);
		myNameColumn2.getColumn().setWidth(100);
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
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myViewerBinding1 = myContext.addViewer(myTableViewer1, myShop, ShopPackage.Literals.SHOP__COUNTRIES);
		myViewerBinding1.addColumn(myNameColumn1, ShopPackage.Literals.COUNTRY__NAME);

		myViewerBinding2 = myContext.addViewer(myTableViewer2, myShop, ShopPackage.Literals.SHOP__SHOP_ITEMS);
		myViewerBinding2.addColumn(myNameColumn2, ShopPackage.Literals.SHOP_ITEM__NAME);

		myContext.finish();
		yield();
	}

	/**
	 * Checks that the shop item table does have an enabled delete operation
	 */
	@Test
	public void testEnablement() {
		try {
			IManager.Factory.getManager().setEditCellSingleClick(false);
			final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);

			final ParameterizedCommand deleteCommand = cs.deserialize(ActionFactory.DELETE.getCommandId());
			assertTrue(deleteCommand.getCommand().isDefined());

			// myTableViewer1.getTable().setFocus();
			postMouse(myTableViewer1.getTable(), 0 + myViewerBinding1.getFirstTableColumnOffset(), 1);
			yield();

			assertTrue(deleteCommand.getCommand().isHandled());

			myTableViewer2.getTable().setFocus();
			postMouse(myTableViewer2.getTable(), 0 + myViewerBinding2.getFirstTableColumnOffset(), 0);
			yield();

			assertTrue(!deleteCommand.getCommand().isHandled());
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * Checks that the first item is deleted on request.
	 */
	@Test
	@Ignore
	public void testFunction() {
		try {
			final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);
			final IHandlerService hs = (IHandlerService) myView.getSite().getService(IHandlerService.class);

			final ParameterizedCommand deleteCommand = cs.deserialize(ActionFactory.DELETE.getCommandId());

			// myTableViewer1.getTable().setFocus();
			postMouse(myTableViewer1.getTable(), 0 + myViewerBinding1.getFirstTableColumnOffset(), 0);
			yield();

			assertEquals(2, myShop.getCountries().size());
			hs.executeCommand(deleteCommand, null);
			assertEquals(1, myShop.getCountries().size());
			assertTrue(myShop.getCountries().contains(myCountry2));
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}
}
