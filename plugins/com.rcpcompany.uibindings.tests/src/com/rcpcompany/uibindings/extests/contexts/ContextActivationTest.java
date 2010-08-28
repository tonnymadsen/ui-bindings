package com.rcpcompany.uibindings.extests.contexts;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Collection;

import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.commands.contexts.Context;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests that the UI contexts exist, are related and are activated correctly.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ContextActivationTest {

	private Shop myShop;
	private TestView myView;
	private Composite myBody;

	private Contact myContact;
	private IBindingContext myContext;

	private IValueBinding myNameBinding;

	private Text myText;
	private Text myNameText;
	private Table myTable;
	private TableColumn myTableColumn;
	private IViewerBinding myViewerBinding;
	private IContextService myCS;

	@Before
	public void setup() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();

		myCS = (IContextService) PlatformUI.getWorkbench().getService(IContextService.class);
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myContact = ShopFactory.eINSTANCE.createContact();
		myShop.getContacts().add(myContact);
	}

	private void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myNameText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myTable = new Table(myBody, SWT.FULL_SELECTION);
		myTableColumn = new TableColumn(myTable, SWT.NONE);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myNameBinding = myContext.addBinding(myNameText, myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		myViewerBinding = myContext.addViewer(myTable, myShop, ShopPackage.Literals.SHOP__CONTACTS);
		myViewerBinding.addColumn(myTableColumn, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		myContext.finish();
		yield();
	}

	@Test
	public void testExistence() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final Collection ids = myCS.getDefinedContextIds();
				assertTrue(ids.contains(Constants.COMMON_CONTEXT_ID));
				assertTrue(ids.contains(Constants.WIDGET_CONTEXT_ID));
				assertTrue(ids.contains(Constants.CONTAINER_CONTEXT_ID));

				final Context commonContext = myCS.getContext(Constants.COMMON_CONTEXT_ID);
				final Context widgetContext = myCS.getContext(Constants.WIDGET_CONTEXT_ID);
				final Context tableContext = myCS.getContext(Constants.CONTAINER_CONTEXT_ID);

				try {
					assertEquals(Constants.COMMON_CONTEXT_ID, widgetContext.getParentId());
				} catch (final NotDefinedException ex) {
					fail(ex.getMessage());
				}
				try {
					assertEquals(Constants.COMMON_CONTEXT_ID, tableContext.getParentId());
				} catch (final NotDefinedException ex) {
					fail(ex.getMessage());
				}
			}
		});
	}

	@Test
	public void testNotContext() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myText.setFocus();
				final Collection ids = myCS.getActiveContextIds();
				assertTrue(!ids.contains(Constants.COMMON_CONTEXT_ID));
				assertTrue(!ids.contains(Constants.WIDGET_CONTEXT_ID));
				assertTrue(!ids.contains(Constants.CONTAINER_CONTEXT_ID));
			}
		});
	}

	@Test
	public void testValueContext() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myText.setFocus();
				myNameText.setFocus();
				final Collection ids = myCS.getActiveContextIds();
				assertTrue(!ids.contains(Constants.COMMON_CONTEXT_ID));
				assertTrue(ids.contains(Constants.WIDGET_CONTEXT_ID));
				assertTrue(!ids.contains(Constants.CONTAINER_CONTEXT_ID));
			}
		});
	}

	@Test
	public void testViewerContext() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myText.setFocus();
				myTable.setFocus();
				final Collection ids = myCS.getActiveContextIds();
				assertTrue(!ids.contains(Constants.COMMON_CONTEXT_ID));
				assertTrue(!ids.contains(Constants.WIDGET_CONTEXT_ID));
				assertTrue(ids.contains(Constants.CONTAINER_CONTEXT_ID));
			}
		});
	}

	/**
	 * Tests that the used contexts are legal
	 */
	@Test
	public void testUsedContexts() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		for (final IConfigurationElement ce : registry.getConfigurationElementsFor("org.eclipse.ui.bindings")) {
			if (!ce.getContributor().getName().equals(Activator.ID)) {
				continue;
			}
			if (!ce.getName().equals("key")) {
				continue;
			}
			final String attribute = ce.getAttribute("contextId");
			if (attribute != null && attribute.length() != 0) {
				if (attribute.startsWith(Constants.PREFIX)) {
					if (attribute.equals(Constants.COMMON_CONTEXT_ID) || attribute.equals(Constants.WIDGET_CONTEXT_ID)
							|| attribute.equals(Constants.CONTAINER_CONTEXT_ID)) {
						continue;
					}
					fail(attribute + " not present");
				}
			}
		}
	}
}
