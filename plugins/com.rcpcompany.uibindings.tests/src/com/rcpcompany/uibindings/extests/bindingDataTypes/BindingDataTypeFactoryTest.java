/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.bindingDataTypes;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.AmountAndCurrency;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibinding.tests.model.TimeUnit;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.internal.bindingDataTypes.BindingDataTypeFactory;
import com.rcpcompany.uibindings.internal.bindingDataTypes.EClassifierBindingDataType;
import com.rcpcompany.uibindings.internal.bindingDataTypes.EEnumLiteralBindingDataType;
import com.rcpcompany.uibindings.internal.bindingDataTypes.EStructuralFeatureBindingDataType;
import com.rcpcompany.uibindings.internal.bindingDataTypes.JavaClassBindingDataType;

/**
 * Tests various aspects of {@link BindingDataTypeFactory}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingDataTypeFactoryTest {
	@Test
	public void testCreateEClass() {
		testCreate(null, TestModelPackage.Literals.TEST_OBJECT, EClassifierBindingDataType.class,
				TestModelPackage.Literals.TEST_OBJECT.getName(), TestModelPackage.Literals.TEST_OBJECT,
				TestObject.class);
	}

	@Test
	public void testCreateInteger() {
		testCreate(null, Integer.class, EClassifierBindingDataType.class,
				EcorePackage.Literals.EINTEGER_OBJECT.getName(), EcorePackage.Literals.EINTEGER_OBJECT, Integer.class);
	}

	enum COLOR {
		RED, GREEN, BLUE
	};

	@Test
	public void testCreateNativeEnum() {
		testCreate(null, COLOR.class, JavaClassBindingDataType.class, COLOR.class.getName(), null, COLOR.class);
	}

	@Test
	public void testCreateEnumLiteral() {
		final EEnumLiteral literal = TestModelPackage.Literals.TIME_UNIT.getEEnumLiteralByLiteral("MIN");
		assertNotNull(literal);
		testCreate(null, literal, EEnumLiteralBindingDataType.class, "MIN", TestModelPackage.Literals.TIME_UNIT,
				TimeUnit.class);
	}

	@Test
	public void testCreateFeature() {
		testCreate(null, TestModelPackage.Literals.TEST_OBJECT__NUMBER, EStructuralFeatureBindingDataType.class,
				"number", EcorePackage.Literals.EINT, Integer.TYPE);
	}

	public void testCreate(Object context, Object element, Class<? extends IBindingDataType> dtClass, String name,
			EClassifier classifier, Class<?> cls) {
		final IBindingDataType dt = IBindingDataType.Factory.create(context, element);

		assertNotNull(dt);
		assertTrue(dtClass.isInstance(dt));
		if (classifier != null) {
			assertEquals(classifier.getEPackage(), dt.getEType().getEPackage());
		}
		assertEquals(classifier, dt.getEType());
		assertEquals(name, dt.getName());
		assertEquals(cls, dt.getDataType());
	}

	/* =================================================================== */

	@Test
	public void testSuperTypesEClass() {
		testSuperType(TestModelPackage.Literals.TEST_OBJECT, TestObject.class, EObject.class, Notifier.class);
	}

	@Test
	public void testSuperTypesEnum() {
		testSuperType(TestModelPackage.Literals.TIME_UNIT, TimeUnit.class, Enum.class, Object.class, Enumerator.class,
				Comparable.class, Serializable.class);
	}

	@Test
	public void testSuperTypesDT() {
		testSuperType(TestModelPackage.Literals.AMOUNT_AND_CURRENCY_STRUCT, AmountAndCurrency.class, EObject.class,
				Notifier.class);
	}

	/*
	 * TODO: add context
	 */
	private void testSuperType(EClassifier testClass, Class<?>... memberClasses) {
		final IBindingDataType dt = IBindingDataType.Factory.create(null, testClass);
		assertEquals(testClass, dt.getEType());
		final IBindingDataType[] types = IBindingDataType.Factory.getSuperTypes(dt);
		// for (final IBindingDataType t : types) {
		// System.out.println(testClass.getName() + ": " + t.getDataType().getName());
		// }
		assertEquals(memberClasses.length, types.length);
		for (int i = 0; i < memberClasses.length; i++) {
			assertEquals(memberClasses[i], types[i].getDataType());
		}
	}
}
