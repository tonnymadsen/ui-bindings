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
package com.rcpcompany.uibindings.tests.utils;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;
import com.rcpcompany.uibindings.tests.utils.views.EmptyView;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.uibindings.utils.IManagerRunnableManager;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Base class for all tests.
 * <p>
 * Provides a number of convenience methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BaseUIBTestUtils {
	private BaseUIBTestUtils() {
	}

	/**
	 * Opens and returns a new test view.
	 * 
	 * @param creatingObject the object of the caller - used to name the new view
	 * 
	 * @return the new view
	 */
	public static UIBTestView createUIBTestView(Object creatingObject) {
		UIBTestView view = null;
		try {
			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			view = (UIBTestView) page.showView("com.rcpcompany.uibindings.extests.views.TestView",
					"" + (testViewSeq++), IWorkbenchPage.VIEW_ACTIVATE);
			assertNotNull(view);
			final String partName = "Test View: " + creatingObject.getClass().getSimpleName();
			view.setPartName(partName);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		view.getSite().getPage().activate(view);
		return view;
	}

	static int testViewSeq = 0;

	/**
	 * Resets the complete test environment.
	 */
	public static void resetAll() {
		final IManager mng = IManager.Factory.getManager();
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__ALTERNATE_ROW_COLORS);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__ALTERNATIVE_DECORATION_POSITION);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__AUTO_APPLY_SINGLE_QUICKFIX);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__EDIT_CELL_ANY_KEY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__EDIT_CELL_SINGLE_CLICK);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__MESSAGE_DECORATION_POSITION);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__TEXT_COMMIT_STRATEGY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__TEXT_COMMIT_STRATEGY_DELAY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__VALIDATION_DELAY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__VALIDATION_DELAY_WINDOW);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__VALIDATION_ERRORS_ARE_FATAL);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__FORMATTER_PROVIDER);

		/*
		 * Flush the command stack
		 */
		final CommandStack cs = mng.getEditingDomain().getCommandStack();
		cs.flush();
		assertEquals(false, cs.canUndo());
		assertEquals(false, cs.canRedo());

		/*
		 * Remove all resources...
		 */
		final ResourceSet rs = mng.getEditingDomain().getResourceSet();
		rs.getResources().clear();
		// for (final Resource r : rs.getResources().toArray(new
		// Resource[rs.getResources().size()])) {
		// try {
		// r.delete(null);
		// } catch (final IOException ex) {
		// LogUtils.error(r, ex);
		// }
		// }
		assertTrue(rs.getResources().isEmpty());

		IValidatorAdapterManager.Factory.getManager().reset();

		/*
		 * Dispose all the navigation managers - there can be one for each
		 * window...
		 */
		IGlobalNavigationManager navMng = null;
		while ((navMng = mng.getService(IGlobalNavigationManager.class)) != null) {
			navMng.dispose();
		}

		/*
		 * Remove and dispose the IManagerRunnableManager
		 */
		final IManagerRunnableManager managerRunnableManager = mng
				.getService(IManagerRunnableManager.class);
		if (managerRunnableManager != null) {
			managerRunnableManager.dispose();

			assertEquals(null, mng.getService(IManagerRunnableManager.class));
		}

		/*
		 * Script engine
		 */
		final IScriptManager manager = IScriptManager.Factory.getManager();

		final IScriptEvaluationContext globalEvaluationContext = manager
				.getGlobalEvaluationContext();
		globalEvaluationContext.getVariables().clear();

		final Set<IScriptEvaluationContext> contexts = new HashSet<IScriptEvaluationContext>();
		contexts.add(globalEvaluationContext);

		while (!contexts.isEmpty()) {
			final IScriptEvaluationContext ec = contexts.iterator().next();
			contexts.remove(ec);

			contexts.addAll(ec.getChildren());
			ec.setParent(null);
			for (final IScriptExpression sc : ec.getExpressions().toArray(
					new IScriptExpression[ec.getExpressions().size()])) {
				sc.dispose();
			}
		}

		manager.getRegisteredEvaluationContexts().clear();
		manager.getDependencies().clear();

		resetUI();
	}

	/**
	 * Constructs and returns a widget of the specified type
	 * 
	 * @param <T>
	 *            the widget type
	 * @param widgetType
	 *            the widget type
	 * @param style
	 *            the style argument
	 * @return the widget
	 */
	public static <T extends Widget> T createWidget(final Class<T> widgetType,
			final int style) {
		try {
			final IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			final EmptyView emptyView = (EmptyView) page.showView(
					"com.rcpcompany.uibindings.extests.views.EmptyView", null,
					IWorkbenchPage.VIEW_ACTIVATE);
			assertNotNull(emptyView);
			if (widgetType == Shell.class) {
				final Constructor<T> constructor = widgetType
						.getConstructor(Integer.TYPE);
				assertNotNull(constructor);

				return constructor.newInstance(style);
			}
			if (widgetType == TableColumn.class) {
				final Constructor<T> constructor = widgetType.getConstructor(
						Table.class, Integer.TYPE);
				assertNotNull(constructor);

				final Table table = emptyView.getTable();
				assertNotNull(table);

				final T w = constructor.newInstance(table, style);
				((TableColumn) w).setWidth(50);
				yield();
				return w;
			}
			if (widgetType == TreeColumn.class) {
				final Constructor<T> constructor = widgetType.getConstructor(
						Tree.class, Integer.TYPE);
				assertNotNull(constructor);

				final Tree tree = emptyView.getTree();
				assertNotNull(tree);

				final T w = constructor.newInstance(tree, style);
				((TreeColumn) w).setWidth(50);
				yield();
				return w;
			}
			if (widgetType == ToolItem.class) {
				final Constructor<T> constructor = widgetType.getConstructor(
						ToolBar.class, Integer.TYPE);
				assertNotNull(constructor);

				final ToolBar tb = emptyView.getToolBar();
				assertNotNull(tb);

				final T w = constructor.newInstance(tb, style);
				yield();
				return w;
			}
			if (widgetType == TabItem.class) {
				final Constructor<T> constructor = widgetType.getConstructor(
						TabFolder.class, Integer.TYPE);
				assertNotNull(constructor);

				final TabFolder tb = emptyView.getTabFolder();
				assertNotNull(tb);

				final T w = constructor.newInstance(tb, style);
				yield();
				return w;
			}

			final Composite top = emptyView.getTop();
			assertNotNull(top);

			final Constructor<T> constructor = widgetType.getConstructor(
					Composite.class, Integer.TYPE);
			assertNotNull(constructor);

			final T w = constructor.newInstance(top, style);

			if (widgetType == Hyperlink.class) {
				/*
				 * Special case: a hyper link cannot be layed out without a text
				 */
				((Hyperlink) w).setText("");
			}

			((Control) w).setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING,
					true, false));

			emptyView.getSite().getPage().activate(emptyView);
			emptyView.getTop().layout();
			yield();
			return w;
		} catch (final Exception ex) {
			ex.printStackTrace();
			fail(ex.getMessage());
		}
		return null;
	}

	protected static boolean cont = false;

	/**
	 * Tests that the values in the validUIList are exactly as specified.
	 * 
	 * @param binding
	 *            the binding
	 * @param values
	 *            the exact values
	 */
	public static void testUIValidList(IValueBinding binding, String... values) {
		final IObservableList list = binding.getDecorator().getValidUIList();
		assertEquals(values.length, list.size());
		for (final String v : values) {
			assertTrue("list contains '" + v + "'", list.contains(v));
		}
	}

}
