package com.rcpcompany.uibindings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Special Binding</b></em>', and utility methods for working with them. <!-- end-user-doc
 * -->
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getSpecialBinding()
 * @generated
 */
public enum SpecialBinding implements Enumerator {
	/**
	 * The '<em><b>ROW NO</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #ROW_NO_VALUE
	 * @generated
	 * @ordered
	 */
	ROW_NO(0, "ROW_NO", "ROW_NO"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>TREE ITEM</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TREE_ITEM_VALUE
	 * @generated
	 * @ordered
	 */
	TREE_ITEM(1, "TREE_ITEM", "TREE_ITEM"),

	/**
	 * The '<em><b>ROW ELEMENT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #ROW_ELEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ROW_ELEMENT(2, "ROW_ELEMENT", "ROW_ELEMENT"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ROW NO</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROW NO</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ROW_NO
	 * @generated
	 * @ordered
	 */
	public static final int ROW_NO_VALUE = 0;

	/**
	 * The '<em><b>TREE ITEM</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TREE ITEM</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TREE_ITEM
	 * @generated
	 * @ordered
	 */
	public static final int TREE_ITEM_VALUE = 1;

	/**
	 * The '<em><b>ROW ELEMENT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROW ELEMENT</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ROW_ELEMENT
	 * @generated
	 * @ordered
	 */
	public static final int ROW_ELEMENT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Special Binding</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final SpecialBinding[] VALUES_ARRAY = new SpecialBinding[] { ROW_NO, TREE_ITEM, ROW_ELEMENT, };

	/**
	 * A public read-only list of all the '<em><b>Special Binding</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<SpecialBinding> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Special Binding</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SpecialBinding get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final SpecialBinding result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Special Binding</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SpecialBinding getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final SpecialBinding result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Special Binding</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SpecialBinding get(int value) {
		switch (value) {
		case ROW_NO_VALUE:
			return ROW_NO;
		case TREE_ITEM_VALUE:
			return TREE_ITEM;
		case ROW_ELEMENT_VALUE:
			return ROW_ELEMENT;
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
	private SpecialBinding(int value, String name, String literal) {
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

} // SpecialBinding
