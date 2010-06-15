package com.rcpcompany.uibindings.extests.bindingMessages;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.resetAll;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.sleep;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationContext;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator;
import com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator.IPropagationAdapter;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Test of {@link ValidationLabelDecorator}.
 * <p>
 * Tests that the provider reacts on changes in the model.
 * <p>
 * Both the events and the values are tested
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class LabelDecoratorTest {
	private static final int VD = 200;

	private Shop myShop;
	private Country c0;
	private Country c1;

	final private EValidatorAdapter validationAdapter = new EValidatorAdapter();
	final private IValidatorAdapterManager myValidatorManager = IValidatorAdapterManager.Factory.getManager();
	private ValidationLabelDecorator myLabelDecorator;

	@Before
	public void before() {
		resetAll();
		IValidatorAdapterManager.Factory.getManager().reset();
		IManager.Factory.getManager().setValidationDelay(VD);

		createModel();

		myValidatorManager.addRoot(myShop, validationAdapter);

		myLabelDecorator = new ValidationLabelDecorator();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("Hello");

		c0 = ShopFactory.eINSTANCE.createCountry();
		c0.setName("DK");
		c0.setAbbreviation("DK");
		myShop.getCountries().add(c0);

		c1 = ShopFactory.eINSTANCE.createCountry();
		c1.setName("NO");
		c1.setAbbreviation("NO");
		myShop.getCountries().add(c1);
	}

	@After
	public void after() {
		if (myLabelDecorator != null) {
			myLabelDecorator.dispose();
		}

		myValidatorManager.removeRoot(myShop, validationAdapter);
	}

	/**
	 * Test with no propagation of status
	 */
	@Test
	public void decoratorNoPropagateTest() {
		// Reset to no errors
		c0.setAbbreviation("AA");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD);

		testLD(myLabelDecorator, c0, IMessageProvider.NONE, -1);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, -1);

		// Change with no event
		c0.setAbbreviation("CC");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD);

		testLD(myLabelDecorator, c0, IMessageProvider.NONE, -1);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, -1);

		// !uppercase => warning
		c0.setAbbreviation("aa");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD, c0);

		testLD(myLabelDecorator, c0, IMessageProvider.WARNING, -1);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, -1);

		// length != 2 => error
		c0.setAbbreviation("ABC");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD, c0);

		testLD(myLabelDecorator, c0, IMessageProvider.ERROR, -1);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, -1);

		// length != 2 & !uppercase => error
		c0.setAbbreviation("abc");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD); // no change!

		testLD(myLabelDecorator, c0, IMessageProvider.ERROR, -1);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, -1);

		// Reset to no errors
		c0.setAbbreviation("AA");
		c1.setAbbreviation("DD");
		sleepWithEvents(myLabelDecorator, 2 * VD, c0);

		testLD(myLabelDecorator, c0, IMessageProvider.NONE, -1);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, -1);
	}

	/**
	 * Test with propagation of status
	 * <p>
	 * The tree is given as shop->folder->{c0, c1}
	 */
	@Test
	public void testDecoratorePropagateTest() {
		final Object folder = new Object() {
			@Override
			public String toString() {
				return "FOLDER";
			}
		};
		final IPropagationAdapter myAdapter = new IPropagationAdapter() {
			@Override
			public Object getParent(Object object) {
				if (object == c0 || object == c1) return folder;
				if (object == folder) return myShop;
				return null;
			}
		};

		myLabelDecorator.setPropagationAdapter(myAdapter);

		// Reset to no errors
		c0.setAbbreviation("AA");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD);

		testLD(myLabelDecorator, myShop, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, folder, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, c0, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, IMessageProvider.NONE);

		// Change with no event
		c0.setAbbreviation("CC");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD);

		testLD(myLabelDecorator, myShop, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, folder, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, c0, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, IMessageProvider.NONE);

		// !uppercase => warning
		c0.setAbbreviation("aa");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD, myShop, folder, c0);

		testLD(myLabelDecorator, myShop, IMessageProvider.NONE, IMessageProvider.WARNING);
		testLD(myLabelDecorator, folder, IMessageProvider.NONE, IMessageProvider.WARNING);
		testLD(myLabelDecorator, c0, IMessageProvider.WARNING, IMessageProvider.WARNING);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, IMessageProvider.NONE);

		// !uppercase && length != 2 => error
		c0.setAbbreviation("aa");
		c1.setAbbreviation("ABC");
		sleepWithEvents(myLabelDecorator, 2 * VD, myShop, folder, c1);

		testLD(myLabelDecorator, myShop, IMessageProvider.NONE, IMessageProvider.ERROR);
		testLD(myLabelDecorator, folder, IMessageProvider.NONE, IMessageProvider.ERROR);
		testLD(myLabelDecorator, c0, IMessageProvider.WARNING, IMessageProvider.WARNING);
		testLD(myLabelDecorator, c1, IMessageProvider.ERROR, IMessageProvider.ERROR);

		// shop no name && !uppercase => warning+error
		myShop.setName("");
		c0.setAbbreviation("aa");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD, folder, c1);

		testLD(myLabelDecorator, myShop, IMessageProvider.ERROR, IMessageProvider.ERROR);
		testLD(myLabelDecorator, folder, IMessageProvider.NONE, IMessageProvider.WARNING);
		testLD(myLabelDecorator, c0, IMessageProvider.WARNING, IMessageProvider.WARNING);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, IMessageProvider.NONE);

		// length != 2 => error
		myShop.setName("hello");
		c0.setAbbreviation("ABC");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD, folder, c0);

		testLD(myLabelDecorator, myShop, IMessageProvider.NONE, IMessageProvider.ERROR);
		testLD(myLabelDecorator, folder, IMessageProvider.NONE, IMessageProvider.ERROR);
		testLD(myLabelDecorator, c0, IMessageProvider.ERROR, IMessageProvider.ERROR);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, IMessageProvider.NONE);

		// length != 2 & !uppercase => error
		c0.setAbbreviation("abc");
		c1.setAbbreviation("BB");
		sleepWithEvents(myLabelDecorator, 2 * VD); // no change!

		testLD(myLabelDecorator, myShop, IMessageProvider.NONE, IMessageProvider.ERROR);
		testLD(myLabelDecorator, folder, IMessageProvider.NONE, IMessageProvider.ERROR);
		testLD(myLabelDecorator, c0, IMessageProvider.ERROR, IMessageProvider.ERROR);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, IMessageProvider.NONE);

		// Reset to no errors
		c0.setAbbreviation("AA");
		c1.setAbbreviation("DD");
		sleepWithEvents(myLabelDecorator, 2 * VD, myShop, folder, c0);

		testLD(myLabelDecorator, myShop, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, folder, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, c0, IMessageProvider.NONE, IMessageProvider.NONE);
		testLD(myLabelDecorator, c1, IMessageProvider.NONE, IMessageProvider.NONE);
	}

	boolean eventSeen;

	/**
	 * Sleeps for a specified time and will then test if the specified label decorator fired an
	 * event with the specified objects as the changed elements
	 * 
	 * @param labelDecorator the decorator
	 * @param period the period to sleep
	 * @param objects the expected changed objects
	 */
	private void sleepWithEvents(ValidationLabelDecorator labelDecorator, int period, final Object... objects) {
		final ILabelProviderListener l = new ILabelProviderListener() {
			Comparator<Object> comparator = new Comparator<Object>() {
				@Override
				public int compare(Object o1, Object o2) {
					return o1.hashCode() - o2.hashCode();
				}
			};

			@Override
			public void labelProviderChanged(LabelProviderChangedEvent event) {
				assertEquals(false, eventSeen);
				eventSeen = true;
				Arrays.sort(objects, comparator);
				Arrays.sort(event.getElements(), comparator);

				assertArrayEquals(objects, event.getElements());
			}
		};

		eventSeen = false;
		labelDecorator.addListener(l);
		sleep(period);
		labelDecorator.removeListener(l);
		if (objects.length > 0) {
			assertEquals(true, eventSeen);
		} else {
			assertEquals(false, eventSeen);
		}
	}

	/**
	 * The overlay of the last label decorator
	 */
	protected ImageDescriptor myCurrentOverlay;

	/**
	 * Tests whether the element - if it is an {@link EObject} - has the specified message type and
	 * whether the specified decorator has the specified decoration.
	 * 
	 * @param labelDecorator the decorator
	 * @param element the element in question
	 * @param messageType the expected message for the element
	 * @param decorationType the expected decoration for the element
	 */
	private void testLD(ValidationLabelDecorator labelDecorator, Object element, int messageType, int decorationType) {
		if (element instanceof EObject) {
			assertEquals(messageType, myValidatorManager.getObjectSeverity((EObject) element));
		}
		if (decorationType == -1) {
			decorationType = messageType;
		}

		myCurrentOverlay = null;
		final IDecoration decoration = new IDecoration() {

			@Override
			public void setForegroundColor(Color color) {
				fail();
			}

			@Override
			public void setFont(Font font) {
				fail();
			}

			@Override
			public void setBackgroundColor(Color color) {
				fail();
			}

			@Override
			public IDecorationContext getDecorationContext() {
				return DecorationContext.DEFAULT_CONTEXT;
			}

			@Override
			public void addSuffix(String suffix) {
				fail();
			}

			@Override
			public void addPrefix(String prefix) {
				fail();
			}

			@Override
			public void addOverlay(ImageDescriptor overlay, int quadrant) {
				fail();
			}

			@Override
			public void addOverlay(ImageDescriptor overlay) {
				assertEquals(null, myCurrentOverlay);
				assertNotNull(overlay);
				myCurrentOverlay = overlay;
			}
		};
		labelDecorator.decorate(element, decoration);
		assertEquals(decorationType, labelDecorator.getElementSeverity(element));
		switch (decorationType) {
		case IMessageProvider.NONE:
			// No overlay expected
			assertEquals(null, myCurrentOverlay);
			break;
		case IMessageProvider.INFORMATION:
			// No overlay expected
			assertEquals(null, myCurrentOverlay);
			break;
		case IMessageProvider.WARNING:
			assertEquals(ValidationLabelDecorator.WARNING_IMAGE, myCurrentOverlay);
			break;
		case IMessageProvider.ERROR:
			assertEquals(ValidationLabelDecorator.ERROR_IMAGE, myCurrentOverlay);
			break;
		}
	}
}
