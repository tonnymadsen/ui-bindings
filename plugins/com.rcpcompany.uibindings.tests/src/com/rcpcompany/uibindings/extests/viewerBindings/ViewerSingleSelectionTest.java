package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests that selections works for viewers. Also that a selection change event is issued properly.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerSingleSelectionTest {
	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private Country myCountry3;
	private Country myCountry4;

	private TestView myView;
	private Composite myBody;

	private Text myEmptyText;

	private TableViewer myTableViewer;
	private Table myTable;
	private TableViewerColumn myNameColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Text myNameText;

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

		myCountry3 = ShopFactory.eINSTANCE.createCountry();
		myCountry3.setName("3");
		myShop.getCountries().add(myCountry3);

		myCountry4 = ShopFactory.eINSTANCE.createCountry();
		myCountry4.setName("4");
		myShop.getCountries().add(myCountry4);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myEmptyText = myView.getToolkit().createText(myBody, "");

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new TableWrapData(TableWrapData.FILL));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(100);

		myNameText = myView.getToolkit().createText(myBody, "");
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

		myViewerBinding = myContext.addViewer(myTableViewer, myShop, ShopPackage.Literals.SHOP__COUNTRIES);
		myViewerBinding.addColumn(myNameColumn, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		final IObservableValue selection = myViewerBinding.getSingleSelection();

		myContext.addBinding(myNameText, selection, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		myContext.finish();
		yield();
	}

	/**
	 * Checks the initial selection
	 */
	@Test
	public void testInitialSelection() {
		checkSelection(myCountry1, null);
	}

	/**
	 * Checks the change of the selection of the {@link Table}.
	 */
	@Test
	public void testChangeOfTableSelection() {
		checkSelection(myCountry3, new Runnable() {
			@Override
			public void run() {
				myTable.setSelection(2);

			}
		});
	}

	/**
	 * Checks the change of the selection of the {@link TableViewer}.
	 */
	@Test
	public void testChangeOfTableViewerSelection() {
		checkSelection(myCountry4, new Runnable() {
			@Override
			public void run() {
				myTableViewer.setSelection(new StructuredSelection(myCountry4));

			}
		});
	}

	/**
	 * Checks the change of the selection of the {@link TableViewer}.
	 */
	@Test
	public void testChangeOfTableViewerRevealSelection() {
		checkSelection(myCountry4, new Runnable() {
			@Override
			public void run() {
				myTableViewer.setSelection(new StructuredSelection(myCountry4), true);

			}
		});
	}

	/**
	 * @param c the expected selected country
	 * @param runnable a {@link Runnable} that will perform the selection
	 */
	protected void checkSelection(Country c, Runnable runnable) {
		yield();
		if (runnable != null) {
			final boolean[] selectionChangedSeen = new boolean[] { false };
			final ISelectionChangedListener listener = new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					// LogUtils.debug(this, "");
					selectionChangedSeen[0] = true;
				}
			};
			myTableViewer.addSelectionChangedListener(listener);
			assertNoLog(runnable);
			yield();
			myTableViewer.removeSelectionChangedListener(listener);
			assertTrue(selectionChangedSeen[0]);
		}
		final int i = myShop.getCountries().indexOf(c);
		assertEquals(i, myTable.getSelectionIndex());
		assertArrayEquals(new Object[] { c }, ((IStructuredSelection) myTableViewer.getSelection()).toArray());

		assertEquals(c.getName(), myNameText.getText());

		final ColumnViewerEditor columnViewerEditor = myTableViewer.getColumnViewerEditor();
		assertNotNull(columnViewerEditor);
		final ViewerCell focusCell = columnViewerEditor.getFocusCell();
		assertNotNull(focusCell);
		final ViewerRow viewerRow = focusCell.getViewerRow();
		assertNotNull(viewerRow);
		assertEquals(c, viewerRow.getElement());
	}
}
