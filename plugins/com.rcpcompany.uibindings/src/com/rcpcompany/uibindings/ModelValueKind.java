/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Model Value Kind</b></em>', and utility methods for working with them. <!-- end-user-doc
 * -->
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getModelValueKind()
 * @generated
 */
public enum ModelValueKind implements Enumerator {
	/**
	 * The '<em><b>VALUE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE(0, "VALUE", "VALUE"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>LIST</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #LIST_VALUE
	 * @generated
	 * @ordered
	 */
	LIST(1, "LIST", "LIST"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>VALUE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #VALUE
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_VALUE = 0;

	/**
	 * The '<em><b>LIST</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIST</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #LIST
	 * @generated
	 * @ordered
	 */
	public static final int LIST_VALUE = 1;

	/**
	 * An array of all the '<em><b>Model Value Kind</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ModelValueKind[] VALUES_ARRAY = new ModelValueKind[] { VALUE, LIST, };

	/**
	 * A public read-only list of all the '<em><b>Model Value Kind</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<ModelValueKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Model Value Kind</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ModelValueKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final ModelValueKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Model Value Kind</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ModelValueKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final ModelValueKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Model Value Kind</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ModelValueKind get(int value) {
		switch (value) {
		case VALUE_VALUE:
			return VALUE;
		case LIST_VALUE:
			return LIST;
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
	private ModelValueKind(int value, String name, String literal) {
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

} // ModelValueKind
