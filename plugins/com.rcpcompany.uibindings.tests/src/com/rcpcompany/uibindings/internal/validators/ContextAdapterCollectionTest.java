package com.rcpcompany.uibindings.internal.validators;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests that messages are added to the context header at the right time..
 * <p>
 * Depends on:
 * <ul>
 * <li>{@link ShopItem#priceOK(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)}</li>
 * <li>{@link ShopItem#nameOK(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)}</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ContextAdapterCollectionTest {

	private static final int VD = 500;
	private Shop myShop;
	private TestView myView;
	private Composite myBody;
	private ShopItem myItem;
	private String myOldName;
	private float myOldPrice;
	private IBindingContext myContext;
	private IValueBinding myNameBinding;
	private IValueBinding myPriceBinding;
	private ValidatorAdapterManager myValidatorManager;
	private final IValidatorAdapter myValidationAdapter = new ConstraintValidatorAdapter();

	@Before
	public void before() {
		IValidatorAdapterManager.Factory.getManager().reset();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(VD);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		myShop = ShopFactory.eINSTANCE.getShop();
		myItem = myShop.getShopItems().get(0);
		myOldName = myItem.getName();
		myOldPrice = myItem.getPrice();

		myView = createTestView(this);
		myBody = myView.getBody();

		final Text nameText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Text priceText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		priceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myValidatorManager = (ValidatorAdapterManager) IValidatorAdapterManager.Factory.getManager();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myNameBinding = myContext.addBinding(nameText, myItem, ShopPackage.Literals.SHOP_ITEM__NAME);
		myPriceBinding = myContext.addBinding(priceText, myItem, ShopPackage.Literals.SHOP_ITEM__PRICE);

		myContext.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@After
	public void after() {
		myItem.setName(myOldName);
		myItem.setPrice(myOldPrice);
		myValidatorManager.removeRoot(myShop, myValidationAdapter);
	}

	@Test
	public void testValue() {
		assertNotNull(myValidatorManager);

		final int initNoMessageFactories = myValidatorManager.getUnboundMessages().size();
		final int initValidationAdapters = myValidatorManager.myValidationRoots.size();

		final int shopAdapterCount = myShop.eAdapters().size();
		final int itemAdapterCount = myItem.eAdapters().size();
		myValidatorManager.addRoot(myShop, myValidationAdapter);
		assertTrue(shopAdapterCount < myShop.eAdapters().size());
		assertTrue(itemAdapterCount < myItem.eAdapters().size());
		assertEquals(initValidationAdapters + 1, myValidatorManager.myValidationRoots.size());

		final int noMessageFactories = myValidatorManager.getUnboundMessages().size();
		assertTrue(noMessageFactories >= initNoMessageFactories);

		myItem.setPrice(-1.0f);
		assertEquals(noMessageFactories, myValidatorManager.getUnboundMessages().size());

		// Test before the validation delay
		sleep(VD - 100);
		assertEquals(noMessageFactories, myValidatorManager.getUnboundMessages().size());

		// Test after the validation delay
		sleep(300);
		assertEquals(noMessageFactories + 1, myValidatorManager.getUnboundMessages().size());

		myItem.setPrice(myOldPrice);
		assertEquals(noMessageFactories + 1, myValidatorManager.getUnboundMessages().size());

		// Test before the validation delay
		sleep(VD - 100);
		assertEquals(noMessageFactories + 1, myValidatorManager.getUnboundMessages().size());

		// Test after the validation delay
		sleep(300);
		assertEquals(noMessageFactories, myValidatorManager.getUnboundMessages().size());

		myValidatorManager.removeRoot(myShop, myValidationAdapter);
		assertEquals(shopAdapterCount, myShop.eAdapters().size());
		assertEquals(itemAdapterCount, myItem.eAdapters().size());
		assertEquals(initNoMessageFactories, myValidatorManager.getUnboundMessages().size());
		assertEquals(initValidationAdapters, myValidatorManager.myValidationRoots.size());
	}
}
