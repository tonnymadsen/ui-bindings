package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * Tests that {@link IBinding#dispose()} works correctly.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingDisposeTest {

	private Shop myShop;
	private TestView myView;

	@Before
	public void setup() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("NWS");
	}

	private void createView() {
		myView = createTestView(this);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testCurrentValueDispose() {
		final int noInitAdapters = myShop.eAdapters().size();

		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		final WritableValue ov = new WritableValue("", String.class);
		final IUIAttribute attribute = new SimpleUIAttribute(null, null, ov, true);
		final IValueBinding binding = context.addBinding().model(myShop, ShopPackage.Literals.SHOP__NAME).ui(attribute);
		context.finish();
		yield();

		ov.setValue("New");

		binding.dispose();

		assertEquals(0, context.getBindings().size());
		assertEquals("New", myShop.getName());
		assertTrue(ov.isDisposed());
		assertEquals(noInitAdapters, myShop.eAdapters().size());
	}
}