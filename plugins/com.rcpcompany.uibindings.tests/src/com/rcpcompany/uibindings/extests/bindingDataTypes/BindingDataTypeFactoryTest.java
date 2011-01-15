/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
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

import com.rcpcompany.uibinding.tests.model.AmountAndCurrencyOld;
import com.rcpcompany.uibinding.tests.model.SubTestObject;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibinding.tests.model.TimeUnit;
import com.rcpcompany.uibindings.IBindingDataType;
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
				TestObject.class, null);
	}

	@Test
	public void testCreateInteger() {
		testCreate(null, Integer.class, EClassifierBindingDataType.class,
				EcorePackage.Literals.EINTEGER_OBJECT.getName(), EcorePackage.Literals.EINTEGER_OBJECT, Integer.class,
				null);
	}

	enum COLOR {
		RED, GREEN, BLUE
	};

	@Test
	public void testCreateNativeEnum() {
		testCreate(null, COLOR.class, JavaClassBindingDataType.class, COLOR.class.getName(), null, COLOR.class, null);
	}

	@Test
	public void testCreateEnumLiteral() {
		final EEnumLiteral literal = TestModelPackage.Literals.TIME_UNIT.getEEnumLiteralByLiteral("MIN");
		assertNotNull(literal);
		testCreate(null, literal, EEnumLiteralBindingDataType.class, "MIN", TestModelPackage.Literals.TIME_UNIT,
				TimeUnit.class, TestModelPackage.Literals.TIME_UNIT);
	}

	@Test
	public void testCreateFeature() {
		testCreate(null, TestModelPackage.Literals.TEST_OBJECT__NUMBER, EStructuralFeatureBindingDataType.class,
				"number", EcorePackage.Literals.EINT, Integer.TYPE, TestModelPackage.Literals.TEST_OBJECT);
	}

	@Test
	public void testCreateSubObjectFeature() {
		testCreate(SubTestObject.class, TestModelPackage.Literals.TEST_OBJECT__TEXT,
				EStructuralFeatureBindingDataType.class, "text", EcorePackage.Literals.ESTRING, String.class,
				TestModelPackage.Literals.SUB_TEST_OBJECT);
	}

	@Test
	public void testCreateSubObjectObjFeature() {
		final SubTestObject o = TestModelFactory.eINSTANCE.createSubTestObject();
		testCreate(o, TestModelPackage.Literals.TEST_OBJECT__TEXT, EStructuralFeatureBindingDataType.class, "text",
				EcorePackage.Literals.ESTRING, String.class, TestModelPackage.Literals.SUB_TEST_OBJECT);
	}

	public void testCreate(Object context, Object element, Class<? extends IBindingDataType> dtClass, String name,
			EClassifier classifier, Class<?> cls, EClassifier parentClassifier) {
		final IBindingDataType dt = IBindingDataType.Factory.create(context, element);

		assertNotNull(dt);
		assertTrue(dtClass.isInstance(dt));
		if (classifier != null) {
			assertEquals(classifier.getEPackage(), dt.getEType().getEPackage());
		}
		assertEquals(classifier, dt.getEType());
		assertEquals(name, dt.getName());
		assertEquals(cls, dt.getDataType());
		final IBindingDataType parentDT = dt.getParentDataType();
		if (parentClassifier != null) {
			assertEquals(parentClassifier, parentDT.getEType());
		} else {
			assertEquals(null, parentDT);
		}
	}

	/* =================================================================== */

	@Test
	public void testSuperTypesEClass() {
		testSuperType(TestModelPackage.Literals.TEST_OBJECT, TestObject.class, EObject.class, Notifier.class);
	}

	@Test
	public void testSuperTypesEnum() {
		testSuperType(TestModelPackage.Literals.TIME_UNIT, TimeUnit.class, Enumerator.class, Enum.class, Object.class,
				Comparable.class, Serializable.class);
	}

	@Test
	public void testSuperTypesDT() {
		testSuperType(TestModelPackage.Literals.AMOUNT_AND_CURRENCY_STRUCT, AmountAndCurrencyOld.class, Object.class);
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
			final IBindingDataType d = types[i];
			// System.out.println(d.getDataType().getSimpleName() + ": " + d.getEType());
			assertEquals(memberClasses[i], d.getDataType());
		}
	}
}
