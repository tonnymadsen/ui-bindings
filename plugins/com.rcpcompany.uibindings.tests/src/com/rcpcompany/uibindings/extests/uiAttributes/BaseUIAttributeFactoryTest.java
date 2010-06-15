package com.rcpcompany.uibindings.extests.uiAttributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;

import com.rcpcompany.uibindings.Constants;

public class BaseUIAttributeFactoryTest<T> {

	protected void testObservableValue(final T widget, String attribute, final IObservableValue value,
			Class<?> expectedValueType, String propertyName) {
		assertEquals(expectedValueType, value.getValueType());
		if (propertyName == null) return;
		final PropertyDescriptor descriptor = getPropertyDescriptor(widget.getClass(), propertyName);
		assertNotNull(descriptor);
		assertEquals(expectedValueType, descriptor.getPropertyType());

		if (expectedValueType == Boolean.TYPE) {
			testObservableValue2P(widget, attribute, descriptor, value, true);
			testObservableValue2P(widget, attribute, descriptor, value, false);
		} else if (expectedValueType == Integer.TYPE) {
			if (propertyName.equals(Constants.ATTR_MAX)) {
				testObservableValue2P(widget, attribute, descriptor, value, 100);
				testObservableValue2P(widget, attribute, descriptor, value, 2000);
				testObservableValue2P(widget, attribute, descriptor, value, 101);
			} else if (propertyName.equals(Constants.ATTR_WIDTH)) {
				testObservableValue2P(widget, attribute, descriptor, value, 16);
				testObservableValue2P(widget, attribute, descriptor, value, 32);
				testObservableValue2P(widget, attribute, descriptor, value, 64);
			} else if (propertyName.equals(Constants.ATTR_ALIGNMENT)) {
				testObservableValue2P(widget, attribute, descriptor, value, SWT.CENTER);
				testObservableValue2P(widget, attribute, descriptor, value, SWT.LEFT);
				testObservableValue2P(widget, attribute, descriptor, value, SWT.RIGHT);
			} else {
				testObservableValue2P(widget, attribute, descriptor, value, 1);
				testObservableValue2P(widget, attribute, descriptor, value, 3);
				testObservableValue2P(widget, attribute, descriptor, value, 2);
			}
		} else if (expectedValueType == String.class) {
			testObservableValue2P(widget, attribute, descriptor, value, "hello");
			testObservableValue2P(widget, attribute, descriptor, value, "foo");
			testObservableValue2P(widget, attribute, descriptor, value, "bar");
		} else {
			// TODO
		}
	}

	private void testObservableValue2P(T widget, String attribute, PropertyDescriptor descriptor,
			IObservableValue value, Object v) {
		value.setValue(v);
		final Object valueV = value.getValue();
		assertEquals(widget.getClass().getName() + " attribute '" + attribute + "' property '" + descriptor.getName()
				+ "': ", v, valueV);

		final Method readMethod = descriptor.getReadMethod();
		if (readMethod == null) {
			fail(descriptor.getName() + " property does not have a read method.");
		}
		if (!readMethod.isAccessible()) {
			readMethod.setAccessible(true);
		}
		Object actualV = null;
		try {
			actualV = readMethod.invoke(widget, null);
		} catch (final Exception ex) {
			fail(descriptor.getName() + " failed with exception: " + ex.getMessage());
		}
		assertEquals(widget.getClass().getName() + " attribute '" + attribute + "' property '" + descriptor.getName()
				+ "': ", v, actualV);
	}

	protected void testObservableList(T widget, String attribute, IObservableList list, Class<?> expectedElementType,
			String propertyName) {
		assertEquals(expectedElementType, list.getElementType());
		if (propertyName == null) return;
		final PropertyDescriptor descriptor = getPropertyDescriptor(widget.getClass(), propertyName);
		assertNotNull(descriptor);

		if (expectedElementType == String.class) {
			testObservableList2P(widget, attribute, descriptor, list, "hello", "foo", "bar");
		} else if (expectedElementType == StyleRange.class) {
			final StyleRange s1 = new StyleRange();
			s1.start = 0;
			s1.length = 1;
			s1.foreground = null;
			s1.background = null;
			s1.fontStyle = SWT.NORMAL;

			final StyleRange s2 = new StyleRange();
			s2.start = 1;
			s2.length = 0;
			s2.foreground = null;
			s2.background = null;
			s2.fontStyle = SWT.NORMAL;

			testObservableList2P(widget, attribute, descriptor, list, s1, s2);
		} else {
			fail("TODO");
		}
	}

	private void testObservableList2P(T widget, String attribute, PropertyDescriptor descriptor, IObservableList list,
			Object... a) {

		list.clear();
		for (final Object o : a) {
			list.add(o);
		}
		// assertEquals(widget.getClass().getName() + " attribute '" + attribute + "': expected <" +
		// v + "> but was <"
		// + valueV + ">", v, valueV);

		final Method readMethod = descriptor.getReadMethod();
		if (readMethod == null) {
			fail(descriptor.getName() + " property does not have a read method.");
		}
		if (!readMethod.isAccessible()) {
			readMethod.setAccessible(true);
		}

		try {
			final Object v = readMethod.invoke(widget, (Object[]) null);
			assertNotNull(v);
			final Class<?> vc = v.getClass();
			if (vc.isArray()) {
				for (int i = 0; i < a.length; i++) {
					assertEquals(a[i], Array.get(v, i));
				}
			} else if (v instanceof List<?>) {
				for (int i = 0; i < a.length; i++) {
					assertEquals(a[i], ((List<?>) v).get(i));
				}
			}
		} catch (final Exception ex) {
			fail(descriptor.getName() + " failed with exception: " + ex.getMessage());
		}
	}

	protected PropertyDescriptor getPropertyDescriptor(Class<?> beanClass, String propertyName) {
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(beanClass);
		} catch (final IntrospectionException e) {
			fail("Cannot introspect " + beanClass.getName() + " property '" + propertyName + "'");
		}
		final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (final PropertyDescriptor descriptor : propertyDescriptors) {
			if (descriptor.getName().equals(propertyName)) return descriptor;
		}
		fail("Cannot find " + beanClass.getName() + " property '" + propertyName + "'");
		return null;
	}

}
