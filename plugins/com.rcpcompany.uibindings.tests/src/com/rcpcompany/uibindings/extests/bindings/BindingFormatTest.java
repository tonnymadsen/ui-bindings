package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests that {@link IBinding#ARG_MESSAGE_FORMAT} works correctly.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingFormatTest {

	private Shop myShop;
	private TestView myView;
	private Composite myBody;
	private Contact myContact;
	private IBindingContext myContext;
	private IValueBinding myBinding;
	private Text myText;
	private Country myCountry1;
	private Country myCountry2;
	private Country myCountry3;

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setAbbreviation("DK");
		myShop.getCountries().add(myCountry1);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setAbbreviation("NO");
		myShop.getCountries().add(myCountry2);

		myCountry3 = ShopFactory.eINSTANCE.createCountry();
		myCountry3.setAbbreviation("SE");
		myShop.getCountries().add(myCountry3);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setCountry(myCountry2);
		myShop.getContacts().add(myContact);
	}

	private void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER | SWT.READ_ONLY);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		final IObservableList countries = UIBindingsEMFObservables.observeList(myContext.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__COUNTRIES);

		myBinding = myContext.addBinding(myText, myContact, ShopPackage.Literals.CONTACT__COUNTRY)
				.arg(Constants.ARG_MESSAGE_FORMAT, "{0} is it").readonly().validValues(countries);

		myContext.finish();
		yield();
	}

	@Test
	public void testValue() {
		assertEquals(myContact.getCountry().getAbbreviation() + " is it", myText.getText());
	}
}
