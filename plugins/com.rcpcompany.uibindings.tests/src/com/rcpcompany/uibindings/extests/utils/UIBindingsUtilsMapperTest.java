package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.UIBindingsUtils.IClassIdentiferMapper;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests
 * {@link UIBindingsUtils#createClassIdentiferMapper(com.rcpcompany.uibindings.IBinding, org.eclipse.emf.ecore.EClass)
 * }
 * functions.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class UIBindingsUtilsMapperTest {
	private Shop myShop;
	private Contact myContact;
	private TestView myView;
	private IValueBinding myBinding;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// String fn, String result

				{ null, "contact.name" }, { "address", "contact.address" }, { "shop.name", "shop.name" },

		});
	}

	protected String myFN;
	protected Object myResult;

	public UIBindingsUtilsMapperTest(String fn, String result) {
		myFN = fn;
		myResult = result;
	}

	@Before
	public void before() {
		resetAll();

		createModel();
		createView();
	}

	private void createView() {
		myView = createTestView(this);

		final Text text = new Text(myView.getBody(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setText("");

		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myBinding = context.addBinding().ui(text)
				.model(Observables.constantObservableValue(myContact, ShopPackage.Literals.CONTACT));
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("shop.name");

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("contact.name");
		myContact.setAddress("contact.address");
		myContact.setShop(myShop);
	}

	protected int changeCount = 0;

	@Test
	public void mapperTest() {

		assertNoLog(new Runnable() {

			@Override
			public void run() {
				myBinding.arg(Constants.ARG_FEATURE_NAME, myFN);
				final IClassIdentiferMapper mapper = UIBindingsUtils.createClassIdentiferMapper(myBinding,
						ShopPackage.Literals.CONTACT);

				assertNotNull(mapper);
				assertEquals(myResult, mapper.map(myContact));
				final IObservableValue value = mapper.getObservableValue(myBinding.getModelObservableValue(), myBinding
						.getContext().getEditingDomain());
				assertNotNull(value);
				assertEquals(myResult, value.getValue());

				final IValueChangeListener listener = new IValueChangeListener() {

					@Override
					public void handleValueChange(ValueChangeEvent event) {
						changeCount++;
					}
				};
				value.addValueChangeListener(listener);

				myShop.setName("shop.name-2");
				myContact.setName("contact.name-2");
				myContact.setAddress("contact.address-2");

				value.removeValueChangeListener(listener);

				assertEquals(1, changeCount);

				assertEquals(myResult + "-2", mapper.map(myContact));
				assertEquals(myResult + "-2", value.getValue());
			}
		});
	}
}
