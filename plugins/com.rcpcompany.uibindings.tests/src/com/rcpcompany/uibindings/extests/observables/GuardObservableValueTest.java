package com.rcpcompany.uibindings.extests.observables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.observables.GuardObservableValue;

/**
 * Test of {@link GuardObservableValue}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class GuardObservableValueTest {

	private final boolean myNegate;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		// negate

				{ false },

				{ true }

		});
	}

	public GuardObservableValueTest(boolean negate) {
		myNegate = negate;
	}

	protected int changeCount = 0;

	@Test
	public void testValue() {
		final IObservableValue decorated = WritableValue.withValueType(String.class);
		decorated.setValue("");
		final GuardObservableValue v = new GuardObservableValue(decorated, "hello", myNegate);

		assertEquals(EcorePackage.Literals.EBOOLEAN, v.getValueType());
		assertEquals(myNegate, v.getValue());
		final IValueChangeListener listener = new IValueChangeListener() {
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				changeCount++;
			}
		};
		v.addValueChangeListener(listener);
		assertEquals(0, changeCount);

		decorated.setValue("hello");
		assertEquals(1, changeCount);
		assertEquals(!myNegate, v.getValue());

		decorated.setValue("hello 2");
		assertEquals(2, changeCount);
		assertEquals(myNegate, v.getValue());

		v.setValue(!myNegate);
		assertEquals(3, changeCount);
		assertEquals(!myNegate, v.getValue());
		assertEquals("hello", decorated.getValue());

		try {
			v.setValue("hello 4");
			fail("Exception expected");
		} catch (final IllegalStateException ex) {
			// OK
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		assertEquals(3, changeCount);
		assertEquals(!myNegate, v.getValue());
		assertEquals("hello", decorated.getValue());

		v.removeValueChangeListener(listener);
	}
}
