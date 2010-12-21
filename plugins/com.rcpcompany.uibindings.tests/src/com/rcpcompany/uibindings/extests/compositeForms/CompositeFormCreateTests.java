package com.rcpcompany.uibindings.extests.compositeForms;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.compositeform.AbstractCompositeFormPartFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeForm.Factory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartOperations;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests of the creation and management of form for {@link ICompositeFormManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CompositeFormCreateTests {
	private TestView myView;
	private Shop myShop;
	private IFormCreator myForm;

	@Before
	public void before() {
		resetAll();

		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("my name...");
		myShop.setNextCustomerNo(100);
		myShop.setNextOrderNo(1);

		myView = createTestView(this);
		myForm = myView.createFormCreator(myShop);
	}

	@After
	public void after() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests all parts are created when enabled or disabled...
	 */
	@Test
	public void testCreate() {
		final IBindingContext context = myForm.getContext();
		assertNotNull(context);
		assertEquals(0, context.getBindings().size());

		myForm.addField("name");

		Factory.createForm(myForm, "com.rcpcompany.uibindings.tests.compositeForms.create");
		myForm.finish();
		yield();

		/*
		 * Everything properly created?
		 */
		assertEquals(4, context.getBindings().size());
		assertNotNull(myPart1);
		assertNotNull(myPart2);
		assertNotNull(myPart3);
		assertEquals(1, myPart1Called);
		assertEquals(1, myPart2Called);
		assertEquals(1, myPart3Called);

		/*
		 * Disable part 2
		 */
		myPart2.setEnabled(false);
		yield();
		assertEquals(3, context.getBindings().size());
		assertEquals(1, myPart1Called);
		assertEquals(1, myPart2Called);
		assertEquals(1, myPart3Called);

		/*
		 * Ensable part 2
		 */
		myPart2.setEnabled(true);
		yield();
		assertEquals(4, context.getBindings().size());
		assertEquals(1, myPart1Called);
		assertEquals(2, myPart2Called);
		assertEquals(1, myPart3Called);

		/*
		 * Re-open part 3 (ignored)
		 */
		myPart3.setOpen(true);
		yield();
		assertEquals(4, context.getBindings().size());
		assertEquals(1, myPart1Called);
		assertEquals(2, myPart2Called);
		assertEquals(1, myPart3Called);

		/*
		 * Close part 3
		 */
		myPart3.setOpen(false);
		yield();
		assertEquals(3, context.getBindings().size());
		assertEquals(1, myPart1Called);
		assertEquals(2, myPart2Called);
		assertEquals(2, myPart3Called);

		/*
		 * Re-open part 3 (NOT ignored)
		 */
		myPart3.setOpen(true);
		yield();
		assertEquals(4, context.getBindings().size());
		assertEquals(1, myPart1Called);
		assertEquals(2, myPart2Called);
		assertEquals(3, myPart3Called);

		// sleep(30000);
	}

	protected static ICompositeFormPart myPart1 = null;
	protected static ICompositeFormPart myPart2 = null;
	protected static ICompositeFormPart myPart3 = null;

	protected static int myPart1Called = 0;
	protected static int myPart2Called = 0;
	protected static int myPart3Called = 0;

	public static class Factory1 extends AbstractCompositeFormPartFactory implements ICompositeFormPartFactory {

		@Override
		public ICompositeFormPartOperations create(ICompositeFormPart part) {
			return new ICompositeFormPartOperations() {
				@Override
				public void createUI(ICompositeFormPart part) {
					myPart1 = part;
					myPart1Called++;
					final IFormCreator creator = part.getFormCreator();
					creator.addField("nextCustomerNo");
				}
			};
		}
	}

	public static class Factory2 extends AbstractCompositeFormPartFactory implements ICompositeFormPartFactory {
		@Override
		public ICompositeFormPartOperations create(ICompositeFormPart part) {
			return new ICompositeFormPartOperations() {
				@Override
				public void createUI(ICompositeFormPart part) {
					myPart2 = part;
					myPart2Called++;
					final IFormCreator creator = part.getFormCreator();
					creator.addField("nextCustomerNo");
				}
			};
		}
	}

	public static class Factory3 extends AbstractCompositeFormPartFactory implements ICompositeFormPartFactory {
		@Override
		public ICompositeFormPartOperations create(ICompositeFormPart part) {
			return new ICompositeFormPartOperations() {
				@Override
				public void createUI(ICompositeFormPart part) {
					myPart3 = part;
					myPart3Called++;
					final IFormCreator creator = part.getFormCreator();
					if (part.isOpen()) {
						creator.addField("nextCustomerNo");
					}
				}
			};
		}
	}
}
