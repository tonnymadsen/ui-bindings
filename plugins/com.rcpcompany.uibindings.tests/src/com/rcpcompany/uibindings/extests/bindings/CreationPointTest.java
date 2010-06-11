package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertOneLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;

/**
 * Test that {@link IBinding#getCreationPoint()} is handled correctly.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CreationPointTest {
	private Shop myShop;

	private TestView myView;
	private Composite myBody;
	private FormToolkit myToolkit;

	private Text myText;

	@Before
	public void before() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
		myBody.layout();
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myToolkit = myView.getToolkit();
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myText = myToolkit.createText(myBody, "", SWT.NONE);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	protected int lineNumber;
	protected IBindingContext context;
	protected IValueBinding binding;

	/**
	 * Binds the UI
	 */
	@Test
	public void testValue() {
		assertNoLog(new Runnable() {
			public void run() {
				context = IBindingContext.Factory.createContext(myView.getScrolledForm());

				final Throwable t = new Throwable();
				t.fillInStackTrace();
				lineNumber = t.getStackTrace()[0].getLineNumber() + 2;
				binding = context.addBinding();
				assertNotNull(binding);
				assertNotNull(binding.getCreationPoint());
				assertEquals(lineNumber, binding.getCreationPoint().getStackTrace()[0].getLineNumber());

				binding.ui(myText);
				assertNotNull(binding.getCreationPoint());
				assertEquals(lineNumber, binding.getCreationPoint().getStackTrace()[0].getLineNumber());
			}
		});

		/*
		 * When we finish below, the model side of the binding has not been made, so it will result in an exception
		 */
		final IStatus status = assertOneLog(new Runnable() {
			public void run() {
				context.finish();
				yield();
			}
		});
		Throwable exception = status.getException();
		assertNotNull(exception);
		exception = exception.getCause();
		assertNotNull(exception);
		assertEquals(lineNumber, exception.getStackTrace()[0].getLineNumber());

		// assertEquals(null, binding.getCreationPoint());
	}
}
