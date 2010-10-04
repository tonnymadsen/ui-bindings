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
package com.rcpcompany.uibindings.internal.bindingDataTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Factory for {@link IBindingDataType} objects.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class BindingDataTypeFactory {
	private BindingDataTypeFactory() {
		// TODO Auto-generated constructor stub
	}

	private static final Map<Object, IBindingDataType> DATA_TYPE_MAPPING = new HashMap<Object, IBindingDataType>();

	/**
	 * Creates and returns a new {@link IBindingDataType binding data type} appropriate for the
	 * specified element.
	 * <p>
	 * The result is cached and reused.
	 * 
	 * @param element the element to return a data type for
	 * @return the data type object or <code>null</code>
	 */
	public static IBindingDataType create(Object element) {
		if (DATA_TYPE_MAPPING.containsKey(element)) return DATA_TYPE_MAPPING.get(element);

		EClassifier classifier = null;
		IBindingDataType dt = null;
		if (element instanceof EClassifier) {
			dt = new EClassifierBindingDataType((EClassifier) element);
		} else if (element instanceof EStructuralFeature) {
			dt = new EStructuralFeatureBindingDataType((EStructuralFeature) element);
		} else if (element instanceof EEnumLiteral) {
			dt = new EEnumLiteralBindingDataType((EEnumLiteral) element);
		} else if (element instanceof Class<?>) {
			/*
			 * Try to look up the instance class to find a proper EClassifier
			 */
			classifier = IBindingDataType.Factory.convertToClassifier((Class<?>) element);
			if (classifier != null) {
				dt = create(classifier);
			} else {
				dt = new JavaClassBindingDataType((Class<?>) element);
			}
		} else if (element == null) {
			dt = create(EcorePackage.Literals.EJAVA_OBJECT);
		} else {
			LogUtils.error(element, "No IBindingDataType for " + element); //$NON-NLS-1$
			dt = null;
		}
		DATA_TYPE_MAPPING.put(element, dt);
		if (classifier != null) {
			DATA_TYPE_MAPPING.put(classifier, dt);
		}
		return dt;
	}

	/**
	 * Tries to convert a Java class to the corresponding {@link EClassifier}.
	 * <p>
	 * All registered EMF packages are searched.
	 * 
	 * @param cls the class to convert
	 * @return the corresponding classifier or <code>null</code> if not found
	 */
	public static EClassifier convertToClassifier(Class<?> cls) {
		/*
		 * The interface class that corresponds to clss - if any exist
		 */
		Class<?> ifCls = null;
		if (!cls.isInterface()) {
			final Class<?>[] interfaces = cls.getInterfaces();
			if (interfaces.length > 0) {
				ifCls = interfaces[0];
			}
		}

		/*
		 * To check the ecore package first! Otherwise the XML Type package
		 * [http://www.eclipse.org/emf/2003/XMLType] will overshadow the basic Java types.
		 */
		for (final EClassifier c : EcorePackage.eINSTANCE.getEClassifiers()) {
			if (c.getInstanceClass() == cls) return c;
			if (ifCls != null && c.getInstanceClass() == ifCls) return c;
		}

		/*
		 * Now try all the packages
		 */
		final Registry registry = EPackage.Registry.INSTANCE;
		for (final Object v : registry.values()) {
			if (!(v instanceof EPackage)) {
				continue;
			}
			if (v == EcorePackage.eINSTANCE) {
				continue;
			}
			final EPackage ep = (EPackage) v;

			for (final EClassifier c : ep.getEClassifiers()) {
				if (c.getInstanceClass() == cls) return c;
				if (ifCls != null && c.getInstanceClass() == ifCls) return c;
			}
		}

		return null;
	}

	/**
	 * Mapping from class to the set of super classes as defined by
	 * {@link IAdapterManager#computeClassOrder(Class)}.
	 */
	private static final Map<IBindingDataType, IBindingDataType[]> SUPER_TYPE_MAPPING = new HashMap<IBindingDataType, IBindingDataType[]>();

	/**
	 * Returns a list of the {@link IBindingDataType} objects that defines all the super types of
	 * the specified data type.
	 * <p>
	 * If not already calculated, then do that by creating an array with
	 * <ul>
	 * <li>IBDTs for all super types (ECore classes)</li>
	 * <li>IBDTs for all super classes (Java classes) not already added from their Ecore
	 * counterparts</li>
	 * </ul>
	 * 
	 * @param dt the data type to test
	 * @return the super types
	 */
	public static IBindingDataType[] getSuperTypes(IBindingDataType dt) {
		IBindingDataType[] dts = SUPER_TYPE_MAPPING.get(dt);
		if (dts == null) {
			final List<IBindingDataType> dtList = new ArrayList<IBindingDataType>();
			final EClassifier classifier = dt.getEType();
			if (classifier != null) {
				dtList.add(BindingDataTypeFactory.create(classifier));
				if (classifier instanceof EClass) {
					for (final EClass e : ((EClass) classifier).getEAllSuperTypes()) {
						dtList.add(BindingDataTypeFactory.create(e));
					}
				}
			}
			final Class<?>[] superClasses = Platform.getAdapterManager().computeClassOrder(dt.getDataType());
			for (final Class<?> c : superClasses) {
				boolean drop = false;
				for (final IBindingDataType d : dtList) {
					if (d.getDataType() == c) {
						drop = true;
						break;
					}
				}
				if (drop) {
					continue;
				}
				dtList.add(BindingDataTypeFactory.create(c));
			}
			dts = dtList.toArray(new IBindingDataType[dtList.size()]);
			SUPER_TYPE_MAPPING.put(dt, dts);
		}
		return dts;
	}
}
