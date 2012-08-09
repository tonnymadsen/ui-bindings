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
package com.rcpcompany.uibindings.extests.sourceProviders;

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.ISourceProviderListener;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Tests of the defined sources in {@link BindingSourceProvider} and well as the value of these.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingSourceProviderTest {
	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private Country myCountry3;
	private Country myCountry4;
	private Contact myContact1;
	private Contact myContact2;

	private UIBTestView myView;
	private Composite myBody;

	private Text myEmptyText;

	private TableViewer myTableViewer;
	private Table myTable;
	private TableViewerColumn myNameColumn;
	private TableViewerColumn myCountryColumn;
	private TableViewerColumn myCountryNameColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private ISourceProvider myProvider;
	private IValueBinding myNameBinding;

	private Text myNameText;
	private IColumnBinding myNameColumnBinding;
	private IColumnBinding myCountryColumnBinding;
	private IColumnBinding myCountryNameColumnBinding;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();

		final IServiceLocator locator = myContext.getServiceLocator();

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);

		myProvider = sourceProviders.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);

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
		myCountry1.setName("n1");
		myCountry1.setAbbreviation("1");
		myShop.getCountries().add(myCountry1);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setName("n2");
		myCountry2.setAbbreviation("2");
		myShop.getCountries().add(myCountry2);

		myCountry3 = ShopFactory.eINSTANCE.createCountry();
		myCountry3.setName("n3");
		myCountry3.setAbbreviation("3");
		myShop.getCountries().add(myCountry3);

		myCountry4 = ShopFactory.eINSTANCE.createCountry();
		myCountry4.setName("n4");
		myCountry4.setAbbreviation("4");
		myShop.getCountries().add(myCountry4);

		myContact1 = ShopFactory.eINSTANCE.createContact();
		myContact1.setName("a");
		myContact1.setCountry(myCountry1);
		myShop.getContacts().add(myContact1);

		myContact2 = ShopFactory.eINSTANCE.createContact();
		myContact2.setName("b");
		myContact2.setCountry(myCountry2);
		myShop.getContacts().add(myContact2);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myEmptyText = myView.getToolkit().createText(myBody, "");

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new TableWrapData(TableWrapData.FILL));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(100);

		myCountryColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myCountryColumn.getColumn().setWidth(100);

		myCountryNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myCountryNameColumn.getColumn().setWidth(100);

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

		myViewerBinding = myContext.addViewer(myTableViewer, myShop, ShopPackage.Literals.SHOP__CONTACTS);
		myNameColumnBinding = myViewerBinding.addColumn(myNameColumn, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		myCountryColumnBinding = myViewerBinding.addColumn(myCountryColumn, ShopPackage.Literals.CONTACT__COUNTRY)
				.arg(Constants.ARG_FEATURE_NAME, "abbreviation")
				.validValues(myShop, ShopPackage.Literals.SHOP__COUNTRIES);
		myCountryNameColumnBinding = myCountryColumnBinding.addColumn(myCountryNameColumn,
				IMOAOPackage.Literals.NAMED_OBJECT__NAME).readonly();

		final IObservableValue selection = myViewerBinding.getSingleSelection();

		myNameBinding = myContext.addBinding(myNameText, selection, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		myContext.finish();
		yield();
	}

	/**
	 * Tests that the services extension point for {@link BindingSourceProvider} is correct.
	 */
	@Test
	public void testServicesExtension() {
		boolean found = false;
		final Map<String, Object> currentState = myProvider.getCurrentState();
		final List<String> providedSourceNames = Arrays.asList(myProvider.getProvidedSourceNames());

		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		for (final IConfigurationElement ce : registry.getConfigurationElementsFor("org.eclipse.ui.services")) {
			if (!ce.getContributor().getName().equals(Activator.ID)) {
				continue;
			}
			assertEquals("sourceProvider", ce.getName());
			if (!ce.getAttribute("provider").equals(BindingSourceProvider.class.getName())) {
				continue;
			}

			/*
			 * Only one declaration
			 */
			assertTrue(!found);
			found = true;

			final IConfigurationElement[] children = ce.getChildren("variable");
			final List<String> childrenVariables = new ArrayList<String>();
			for (final IConfigurationElement cce : children) {
				final String name = cce.getAttribute("name");
				assertFalse(name + " listed twice", childrenVariables.contains(name));
				childrenVariables.add(name);
				assertTrue(name + " not in current state", currentState.containsKey(name));
				if (name.equals(Constants.SOURCES_THE_MANAGER)) {
					assertEquals(name + " priority", "workbench", cce.getAttribute("priorityLevel"));
				} else {
					assertEquals(name + " priority", "activeSite", cce.getAttribute("priorityLevel"));
				}
			}
			for (final String name : childrenVariables) {
				assertTrue(name + " not in provider names", providedSourceNames.contains(name));
			}
			assertEquals(providedSourceNames.size(), children.length);
		}

		assertTrue(found);
	}

	/**
	 * Tests that the names in the current state are exactly the same as the ones in the reported
	 * sources.
	 */
	@Test
	public void testNames() {
		final Map<String, Object> currentState = myProvider.getCurrentState();
		final List<String> providedSourceNames = Arrays.asList(myProvider.getProvidedSourceNames());
		for (final String n : providedSourceNames) {
			assertTrue("Variable " + n, currentState.containsKey(n));
		}
		for (final String n : currentState.keySet()) {
			assertTrue("Variable " + n, providedSourceNames.contains(n));
		}
		assertEquals(providedSourceNames.size(), currentState.size());
	}

	/**
	 * Tests that the {@link ISourceProviderService} return the correct source provider for all the
	 * sources offered.
	 */
	@Test
	public void testISourceProviderServiceNames() {
		final Map<String, Object> currentState = myProvider.getCurrentState();
		final IServiceLocator locator = myContext.getServiceLocator();

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);

		for (final String n : myProvider.getProvidedSourceNames()) {
			assertEquals("Wrong source provider for " + n, myProvider, sourceProviders.getSourceProvider(n));
		}
	}

	/**
	 * Source values for a non-binding widget
	 */
	@Test
	public void testNoBinding() {
		myEmptyText.setFocus();
		// postMouse(myEmptyText, myEmptyText.getBounds());

		assertSource(Constants.SOURCES_THE_MANAGER, IManager.Factory.getManager());

		assertSource(Constants.SOURCES_ACTIVE_CONTEXT, IEvaluationContext.UNDEFINED_VARIABLE);

		assertSource(Constants.SOURCES_ACTIVE_BINDING, IEvaluationContext.UNDEFINED_VARIABLE);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE, IEvaluationContext.UNDEFINED_VARIABLE);
	}

	/**
	 * Source values for a value binding widget
	 */
	@Test
	public void testValueBinding() {
		myNameText.setFocus();
		// postMouse(myNameText, myNameText.getBounds());

		assertSource(Constants.SOURCES_THE_MANAGER, IManager.Factory.getManager());

		assertSource(Constants.SOURCES_ACTIVE_CONTEXT, myContext);

		assertSource(Constants.SOURCES_ACTIVE_BINDING, myNameBinding);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_RO, false);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE, false);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE, myContact1.getName());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, myContact1.getName());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_TYPE, "");
		assertSource(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, myContact1);
	}

	/**
	 * Source values for a column binding for a simple feature
	 */
	@Test
	public void testSimpleColumnBinding() {
		postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 1);

		final IColumnBindingCellInformation ci = myViewerBinding.getCell(0, myViewerBinding.getList().get(1));
		assertNotNull(ci);

		assertSource(Constants.SOURCES_THE_MANAGER, IManager.Factory.getManager());

		assertSource(Constants.SOURCES_ACTIVE_CONTEXT, myContext);

		assertSource(Constants.SOURCES_ACTIVE_CONTAINER_BINDING, myViewerBinding);
		assertSource(Constants.SOURCES_ACTIVE_BINDING, ci.getLabelBinding());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_RO, false);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_TYPE, "");
		assertSource(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, myContact2);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_FEATURE, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE, myContact2.getName());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, myContact2.getName());
	}

	/**
	 * Source values for a column binding for a simple feature after the previous column has been
	 * deleted.
	 */
	@Test
	public void testSimpleColumnBindingAfterDelete() {
		postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);

		final IColumnBindingCellInformation ci = myViewerBinding.getCell(0, myViewerBinding.getList().get(1));
		assertNotNull(ci);

		/*
		 * When the element is deleted, the current selected cell is changed, and this must be
		 * monitored.
		 */
		final MySourceProviderListener listener = new MySourceProviderListener();
		try {
			myProvider.addSourceProviderListener(listener);
			myContact1.setShop(null);
			yield();
		} finally {
			myProvider.removeSourceProviderListener(listener);
		}

		assertSource(Constants.SOURCES_THE_MANAGER, IManager.Factory.getManager());

		assertSource(Constants.SOURCES_ACTIVE_CONTEXT, myContext);

		assertSource(Constants.SOURCES_ACTIVE_CONTAINER_BINDING, myViewerBinding);
		assertSource(Constants.SOURCES_ACTIVE_BINDING, ci.getLabelBinding());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_RO, false);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_TYPE, "");
		assertSource(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, myContact2);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_FEATURE, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE, myContact2.getName());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, myContact2.getName());
	}

	private final class MySourceProviderListener implements ISourceProviderListener {
		public int changes = 0;

		@Override
		public void sourceChanged(int sourcePriority, String sourceName, Object sourceValue) {
			changes++;
		}

		@Override
		public void sourceChanged(int sourcePriority, Map sourceValuesByName) {
			changes++;
		}
	}

	/**
	 * Source values for a column binding for a reference feature
	 */
	@Test
	public void testReferenceColumnBinding() {
		postMouse(myTable, 1 + myViewerBinding.getFirstTableColumnOffset(), 0);

		final IColumnBindingCellInformation ci = myViewerBinding.getCell(1, myViewerBinding.getList().get(0));
		assertNotNull(ci);

		assertSource(Constants.SOURCES_THE_MANAGER, IManager.Factory.getManager());

		assertSource(Constants.SOURCES_ACTIVE_CONTEXT, myContext);

		assertSource(Constants.SOURCES_ACTIVE_CONTAINER_BINDING, myViewerBinding);
		assertSource(Constants.SOURCES_ACTIVE_BINDING, ci.getLabelBinding());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_RO, false);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_FEATURE, ShopPackage.Literals.CONTACT__COUNTRY);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_TYPE, "");
		assertSource(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, myContact1);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE, myCountry1);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, myCountry1.getAbbreviation());
	}

	/**
	 * Source values for a column binding for a simple feature
	 */
	@Test
	public void testROColumnBinding() {
		postMouse(myTable, 2 + myViewerBinding.getFirstTableColumnOffset(), 1);

		final IColumnBindingCellInformation ci = myViewerBinding.getCell(2, myViewerBinding.getList().get(1));
		assertNotNull(ci);

		assertSource(Constants.SOURCES_THE_MANAGER, IManager.Factory.getManager());

		assertSource(Constants.SOURCES_ACTIVE_CONTEXT, myContext);

		assertSource(Constants.SOURCES_ACTIVE_CONTAINER_BINDING, myViewerBinding);
		assertSource(Constants.SOURCES_ACTIVE_BINDING, ci.getLabelBinding());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_RO, true);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_FEATURE, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_TYPE, "");
		assertSource(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, myCountry2);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE, myCountry2.getName());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, myCountry2.getName());
	}

	// TODO: ALL relevant ContainerCellTypes

	public void assertSource(String name, Object value) {
		final Map<String, Object> currentState = myProvider.getCurrentState();

		assertEquals("variable " + name, value, currentState.get(name));
	}
}
