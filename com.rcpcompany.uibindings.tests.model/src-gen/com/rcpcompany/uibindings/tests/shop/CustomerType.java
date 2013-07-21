/**
 */
package com.rcpcompany.uibindings.tests.shop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Customer Type</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomerType()
 * @generated
 */
public enum CustomerType implements Enumerator {
	/**
	 * The '<em><b>BRONCE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #BRONCE_VALUE
	 * @generated
	 * @ordered
	 */
	BRONCE(0, "BRONCE", "Bronce"), /**
	 * The '<em><b>SILVER</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SILVER_VALUE
	 * @generated
	 * @ordered
	 */
	SILVER(1, "SILVER", "Silver"), /**
	 * The '<em><b>GOLD</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #GOLD_VALUE
	 * @generated
	 * @ordered
	 */
	GOLD(2, "GOLD", "Gold");

	/**
	 * The '<em><b>BRONCE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BRONCE</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BRONCE
	 * @generated
	 * @ordered
	 */
	public static final int BRONCE_VALUE = 0;

	/**
	 * The '<em><b>SILVER</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SILVER</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SILVER
	 * @generated
	 * @ordered
	 */
	public static final int SILVER_VALUE = 1;

	/**
	 * The '<em><b>GOLD</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GOLD</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #GOLD
	 * @generated
	 * @ordered
	 */
	public static final int GOLD_VALUE = 2;

	/**
	 * An array of all the '<em><b>Customer Type</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private static final CustomerType[] VALUES_ARRAY = new CustomerType[] { BRONCE, SILVER, GOLD, };

	/**
	 * A public read-only list of all the '<em><b>Customer Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<CustomerType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Customer Type</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static CustomerType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CustomerType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) { return result; }
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Customer Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static CustomerType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CustomerType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) { return result; }
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Customer Type</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static CustomerType get(int value) {
		switch (value) {
		case BRONCE_VALUE:
			return BRONCE;
		case SILVER_VALUE:
			return SILVER;
		case GOLD_VALUE:
			return GOLD;
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
	private CustomerType(int value, String name, String literal) {
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

} // CustomerType
