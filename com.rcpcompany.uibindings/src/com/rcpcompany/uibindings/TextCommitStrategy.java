/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Text Commit Strategy</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTextCommitStrategy()
 * @generated
 */
public enum TextCommitStrategy implements Enumerator {
	/**
	 * The '<em><b>ON MODIFY</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #ON_MODIFY_VALUE
	 * @generated
	 * @ordered
	 */
	ON_MODIFY(0, "ON_MODIFY", "ON_MODIFY"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ON FOCUS OUT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #ON_FOCUS_OUT_VALUE
	 * @generated
	 * @ordered
	 */
	ON_FOCUS_OUT(1, "ON_FOCUS_OUT", "ON_FOCUS_OUT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ON MODIFY DELAY</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #ON_MODIFY_DELAY_VALUE
	 * @generated
	 * @ordered
	 */
	ON_MODIFY_DELAY(2, "ON_MODIFY_DELAY", "ON_MODIFY_DELAY"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ON MODIFY</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ON MODIFY</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ON_MODIFY
	 * @generated
	 * @ordered
	 */
	public static final int ON_MODIFY_VALUE = 0;

	/**
	 * The '<em><b>ON FOCUS OUT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ON FOCUS OUT</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ON_FOCUS_OUT
	 * @generated
	 * @ordered
	 */
	public static final int ON_FOCUS_OUT_VALUE = 1;

	/**
	 * The '<em><b>ON MODIFY DELAY</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ON MODIFY DELAY</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ON_MODIFY_DELAY
	 * @generated
	 * @ordered
	 */
	public static final int ON_MODIFY_DELAY_VALUE = 2;

	/**
	 * An array of all the '<em><b>Text Commit Strategy</b></em>' enumerators. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final TextCommitStrategy[] VALUES_ARRAY = new TextCommitStrategy[] { ON_MODIFY, ON_FOCUS_OUT,
			ON_MODIFY_DELAY, };

	/**
	 * A public read-only list of all the '<em><b>Text Commit Strategy</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<TextCommitStrategy> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Text Commit Strategy</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static TextCommitStrategy get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final TextCommitStrategy result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Text Commit Strategy</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static TextCommitStrategy getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final TextCommitStrategy result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Text Commit Strategy</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static TextCommitStrategy get(int value) {
		switch (value) {
		case ON_MODIFY_VALUE:
			return ON_MODIFY;
		case ON_FOCUS_OUT_VALUE:
			return ON_FOCUS_OUT;
		case ON_MODIFY_DELAY_VALUE:
			return ON_MODIFY_DELAY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private TextCommitStrategy(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // TextCommitStrategy
