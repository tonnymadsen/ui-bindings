/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Weight Unit</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getWeightUnit()
 * @model
 * @generated
 */
public enum WeightUnit implements Enumerator {
	/**
	 * The '<em><b>G</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #G_VALUE
	 * @generated
	 * @ordered
	 */
	G(0, "G", "G"),

	/**
	 * The '<em><b>KG</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #KG_VALUE
	 * @generated
	 * @ordered
	 */
	KG(0, "KG", "KG"),

	/**
	 * The '<em><b>Tonne</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TONNE_VALUE
	 * @generated
	 * @ordered
	 */
	TONNE(0, "Tonne", "TONNE");

	/**
	 * The '<em><b>G</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>G</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #G
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int G_VALUE = 0;

	/**
	 * The '<em><b>KG</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KG</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #KG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KG_VALUE = 0;

	/**
	 * The '<em><b>Tonne</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tonne</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TONNE
	 * @model name="Tonne" literal="TONNE"
	 * @generated
	 * @ordered
	 */
	public static final int TONNE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Weight Unit</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WeightUnit[] VALUES_ARRAY = new WeightUnit[] { G, KG, TONNE, };

	/**
	 * A public read-only list of all the '<em><b>Weight Unit</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<WeightUnit> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Weight Unit</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static WeightUnit get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final WeightUnit result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Weight Unit</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static WeightUnit getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final WeightUnit result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Weight Unit</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static WeightUnit get(int value) {
		switch (value) {
		case G_VALUE:
			return G;
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
	private WeightUnit(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // WeightUnit
