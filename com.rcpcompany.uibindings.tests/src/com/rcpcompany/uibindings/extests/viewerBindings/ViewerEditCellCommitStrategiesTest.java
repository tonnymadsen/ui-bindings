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
package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.utils.basic.ui.TSSWTUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests that the cell editor leaves the value current after an edit.
 * <p>
 * Also see <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-857">SIMA-857</a>: Esc commits
 * values in table cells and combos
 * <p>
 * Tests the functionality of {@link IManager#setTextCommitStrategy(TextCommitStrategy)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerEditCellCommitStrategiesTest {
	private static final String ITEM_NAME = "a";
	private static final int DELAY = 1000;

	public final IManager manager = IManager.Factory.getManager();

	private Shop myShop;
	private ShopItem myItem;

	private UIBTestView myView;
	private Composite myBody;

	private TableViewer myTableViewer;
	private Table myTable;
	private TableViewerColumn myNameColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		manager.setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		manager.setEditCellAnyKey(false);
		manager.setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
		myBody.layout();

		final Listener listener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				LogUtils.debug(this, TSSWTUtils.toString(event));
			}
		};
		for (int i = SWT.None; i <= SWT.ImeComposition; i++) {
			// myTable.getDisplay().addFilter(i, listener);
		}

		myTableViewer.getColumnViewerEditor().addEditorActivationListener(new ColumnViewerEditorActivationListener() {
			@Override
			public void beforeEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
				// LogUtils.debug(this, "");
			}

			@Override
			public void beforeEditorActivated(ColumnViewerEditorActivationEvent event) {
				// LogUtils.debug(this, "");
			}

			@Override
			public void afterEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
				// LogUtils.debug(this, "");
			}

			@Override
			public void afterEditorActivated(ColumnViewerEditorActivationEvent event) {
				// LogUtils.debug(this, "");
			}
		});
	}

	@After
	public void after() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(false);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myItem = ShopFactory.eINSTANCE.createShopItem();
		myItem.setName(ITEM_NAME);
		myShop.getShopItems().add(myItem);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);

		myBody = myView.getBody();

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(100);
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

		myViewerBinding = myContext.addViewer(myTableViewer, myShop, ShopPackage.Literals.SHOP__SHOP_ITEMS);
		myViewerBinding.addColumn(myNameColumn, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		myContext.finish();
		yield();
	}

	/**
	 * Tests that getDelayedChange and getValue is correct for all strategies for the sequence
	 * <nl>
	 * <li>set name to "a" (reset)</li>
	 * <li>"ENTER" - to get edit cell</li>
	 * <li>set value to "b"</li>
	 * <li>do stroke</li>
	 * </nl>
	 * 
	 * @param strategy the strategy to test
	 * @param b1 expected value after setting the value
	 * @param stroke the key to press
	 * @param b2 expected value after 2*DELAY
	 * @param expectDelayChangeEvents <code>true</code> if a {@link DelayedChangeEvent} event is
	 *            expected
	 * @param getValue TODO
	 */
	public void testKeyStrategy(TextCommitStrategy strategy, String b1, final String stroke, String b2) {
		manager.setTextCommitStrategy(strategy);
		manager.setTextCommitStrategyDelay(DELAY);

		final String initial = "a";

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myItem.setName(initial);
				yield();
			}
		});

		performChange(initial, initial, new Runnable() {
			@Override
			public void run() {
				postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
				postKeyStroke(myTable, "ENTER");
				yield();
			}
		});

		performChange(initial, b1, new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myTable, "b"); // <<<<
			}
		});

		performChange(b1, b1, new Runnable() {
			@Override
			public void run() {
				sleep(DELAY / 2); // <<<<
			}
		});

		performChange(b1, b2, new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myTable, stroke); // <<<<
			}
		});
	}

	/**
	 * Executes the specified runnable and monitors whether the specified value change occurs and
	 * whether the value changes.
	 * <p>
	 * <em>NOTE:</em> There are a special case with multi-line Text widgets: when the complete
	 * selected text is changed, it happens in two parts: First the text of the widget is changed to
	 * "" and then it is changed to the new text.
	 * 
	 * @param changeFromValue the from value expect in a change event
	 * @param changeToValue the to value expect in a change event
	 * @param change the {@link Runnable} to execute
	 */
	public void performChange(final String changeFromValue, final String changeToValue, Runnable change) {

		final boolean[] changeExpected = new boolean[] { !(changeToValue.equals(changeFromValue)) };

		final Adapter changeListener = new AdapterImpl() {
			String fromValue = changeFromValue;
			String toValue = changeToValue;

			@Override
			public void notifyChanged(Notification msg) {
				if (msg.isTouch()) return;
				// LogUtils.debug(this, "'" + event.diff.getOldValue() + "' -> '" +
				// event.diff.getNewValue() + "'");
				assertTrue("No value change expected", changeExpected[0]);
				assertEquals(fromValue, msg.getOldValue());
				if (msg.getNewValue().equals("")) {
					fromValue = "";
					return;
				}
				assertEquals(toValue, msg.getNewValue());
				changeExpected[0] = false;
			}
		};

		try {
			myItem.eAdapters().add(changeListener);

			if (change != null) {
				change.run();
			}
			yield();
		} finally {
			myItem.eAdapters().remove(changeListener);
		}

		assertEquals(false, changeExpected[0]);

		assertEquals(changeToValue, myItem.getName());
	}

	@Test
	public void testModifyEnterStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_MODIFY, "b", "ENTER", "b");
	}

	@Test
	public void testModifyDelayEnterStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_MODIFY_DELAY, "a", "ENTER", "b");
	}

	@Test
	public void testFocusOutEnterStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_FOCUS_OUT, "a", "ENTER", "b");
	}

	@Test
	public void testModifyEscapeStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_MODIFY, "b", "ESCAPE", "a");
	}

	@Test
	public void testModifyDelayEscapeStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_MODIFY_DELAY, "a", "ESCAPE", "a");
	}

	@Test
	public void testFocusOutEscapeStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_FOCUS_OUT, "a", "ESCAPE", "a");
	}
}
