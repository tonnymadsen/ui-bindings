package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertOneLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.postKeyStroke;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.postMouse;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.sleep;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Test that {@link IBinding#ARG_READONLY} is handled correctly.
 * <p>
 * It does not test whether the different ways of setting arguments works - that is done in {@link ArgumentsScopeTest}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ReadonlyTest {
	private Shop myShop;
	private ShopItem mySI;

	private TestView myView;
	private Composite myBody;
	private FormToolkit myToolkit;

	private Text myRWText;
	private Text mySWTROText;
	private Text myARGROText;

	private TableViewer myTableViewerMixed;
	private TableViewerColumn myNameColumnRW;
	private TableViewerColumn myPriceColumnRO;

	private TableViewer myTableViewerRO;
	private TableViewerColumn myNameColumnVRO;
	private TableViewerColumn myPriceColumnVRO;

	@Before
	public void before() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
		myBody.layout();
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();
		mySI = ShopFactory.eINSTANCE.createShopItem();
		mySI.setName("item 1");
		mySI.setPrice(1f);
		myShop.getShopItems().add(mySI);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myToolkit = myView.getToolkit();
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myRWText = myToolkit.createText(myBody, "", SWT.NONE);
		mySWTROText = myToolkit.createText(myBody, "", SWT.READ_ONLY);
		myARGROText = myToolkit.createText(myBody, "", SWT.NONE);

		myTableViewerMixed = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		Table table = myTableViewerMixed.getTable();
		table.setLayoutData(new TableWrapData(TableWrapData.FILL));
		table.setHeaderVisible(true);

		myNameColumnRW = new TableViewerColumn(myTableViewerMixed, SWT.NONE);
		myNameColumnRW.getColumn().setWidth(100);

		myPriceColumnRO = new TableViewerColumn(myTableViewerMixed, SWT.NONE);
		myPriceColumnRO.getColumn().setWidth(100);

		myTableViewerRO = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		table = myTableViewerRO.getTable();
		table.setLayoutData(new TableWrapData(TableWrapData.FILL));
		table.setHeaderVisible(true);

		myNameColumnVRO = new TableViewerColumn(myTableViewerRO, SWT.NONE);
		myNameColumnVRO.getColumn().setWidth(100);

		myPriceColumnVRO = new TableViewerColumn(myTableViewerRO, SWT.NONE);
		myPriceColumnVRO.getColumn().setWidth(100);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	protected IViewerBinding myViewer;

	/**
	 * Binds the UI
	 */
	public void bindUI() {
		assertOneLog(new Runnable() {
			public void run() {
				final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

				context.addBinding(myRWText, mySI, ShopPackage.Literals.SHOP_ITEM__NAME);
				context.addBinding(mySWTROText, mySI, ShopPackage.Literals.SHOP_ITEM__NAME);
				context.addBinding(myARGROText, mySI, ShopPackage.Literals.SHOP_ITEM__NAME).readonly();

				myViewer = context.addViewer(myTableViewerMixed, myShop, ShopPackage.Literals.SHOP__SHOP_ITEMS);
				myViewer.addColumn(myNameColumnRW, ShopPackage.Literals.SHOP_ITEM__NAME);
				myViewer.addColumn(myPriceColumnRO, ShopPackage.Literals.SHOP_ITEM__NAME).readonly();

				myViewer = context.addViewer(myTableViewerRO, myShop, ShopPackage.Literals.SHOP__SHOP_ITEMS).readonly();
				myViewer.addColumn(myNameColumnVRO, ShopPackage.Literals.SHOP_ITEM__NAME);
				myViewer.addColumn(myPriceColumnVRO, ShopPackage.Literals.SHOP_ITEM__NAME).readonly();

				context.finish();
				yield();
			}
		});
	}

	private void testText(final Text text, final String expected) {
		assertNoLog(new Runnable() {
			public void run() {
				postKeyStroke(text, "a");
				yield();
				assertEquals(expected, mySI.getName());
			}
		});
	}

	@Test
	public void testValueBindingsRW() {
		testText(myRWText, "aitem 1");
	}

	@Test
	public void testValueBindingsSWTRO() {
		testText(mySWTROText, "item 1");
	}

	@Test
	public void testValueBindingsARGRO() {
		testText(myARGROText, "item 1");
	}

	@Test
	public void testColumnBindingsRW() {
		testColumn(myTableViewerMixed, 0, true);
	}

	@Test
	public void testColumnBindingsRO() {
		testColumn(myTableViewerMixed, 1, false);
	}

	@Test
	public void testColumnBindingsVRO1() {
		testColumn(myTableViewerRO, 0, false);
	}

	@Test
	public void testColumnBindingsVRO2() {
		testColumn(myTableViewerRO, 1, false);
	}

	private void testColumn(final TableViewer viewer, final int colNo, final boolean editExpected) {

		assertNoLog(new Runnable() {
			public void run() {
				final Table table = viewer.getTable();
				postMouse(table, colNo + myViewer.getFirstTableColumnOffset(), 0, 2);
				yield();

				assertEquals(editExpected, viewer.isCellEditorActive());

				if (editExpected) {
					postKeyStroke(table, "ESCAPE");
					sleep(100);
					assertEquals(false, viewer.isCellEditorActive());
				}
			}
		});
	}
}
