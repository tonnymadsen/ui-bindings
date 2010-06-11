package com.rcpcompany.uibindings.extests.quickfixes;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.sleep;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests that the correct nameing quickfixes are generated
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NamingQuickfixTest {

	private static final int VD = 200;
	private Shop myShop;
	private TestView myView;
	private Composite myBody;
	private Contact myContact;
	private Country myOldCountry;
	private IBindingContext myContext;
	private IValueBinding myBinding;
	private ValueBindingMessageImageDecorator myMessageDecorator;
	private IValidatorAdapterManager myValidatorManager;
	private final EValidatorAdapter myValidationAdapter = new EValidatorAdapter();
	private IObservableList myCountries;
	private Text myText;

	@Before
	public void setup() {
		IValidatorAdapterManager.Factory.getManager().reset();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(VD);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		myShop = ShopFactory.eINSTANCE.getShop();
		myContact = myShop.getContacts().get(0);
		myOldCountry = myContact.getCountry();

		myView = createTestView(this);
		myBody = myView.getBody();

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myValidatorManager = IValidatorAdapterManager.Factory.getManager();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myCountries = UIBindingsEMFObservables.observeList(myContext.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__COUNTRIES);
		myBinding = myContext.addBinding(myText, myContact, ShopPackage.Literals.CONTACT__COUNTRY).validValues(
				myCountries);

		myContext.finish();
		yield();

		myMessageDecorator = myBinding.getService(ValueBindingMessageImageDecorator.class);

		myValidatorManager.addRoot(myShop, myValidationAdapter);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@After
	public void after() {
		myContact.setCountry(myOldCountry);
		myValidatorManager.removeRoot(myShop, myValidationAdapter);
	}

	@Test
	public void testValue() {
		final List<IQuickfixProposal> quickfixes = myMessageDecorator.getQuickfixes();
		assertNotNull(quickfixes);

		assertEquals(0, quickfixes.size());

		// No quickfixes
		myText.setText("n");
		sleep(VD + 200);
		assertEquals(0, quickfixes.size());

		// Case
		myText.setText("no");
		sleep(VD + 200);
		assertEquals(1, quickfixes.size());
		assertEquals("Change case", quickfixes.get(0).getLabel());

		// extra letter
		myText.setText("NOt");
		sleep(VD + 200);
		assertEquals(1, quickfixes.size());
		assertEquals("Remove extra letter", quickfixes.get(0).getLabel());

		// extra letter
		myText.setText("NxO");
		sleep(VD + 200);
		assertEquals(1, quickfixes.size());
		assertEquals("Remove extra letter", quickfixes.get(0).getLabel());

		// missing letter
		myText.setText("O");
		sleep(VD + 200);
		assertEquals(1, quickfixes.size());
		assertEquals("Add missing letter", quickfixes.get(0).getLabel());

		// transposed
		myText.setText("ON");
		sleep(VD + 200);
		assertEquals(1, quickfixes.size());
		assertEquals("Transposed letters", quickfixes.get(0).getLabel());

		// no quick fixes
		myText.setText("NO");
		sleep(VD + 200);
		assertEquals(0, quickfixes.size());
	}
}
