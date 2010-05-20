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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Binding State</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingState()
 * @generated
 */
public enum BindingState implements Enumerator {
	/**
	 * The '<em><b>INIT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #INIT_VALUE
	 * @generated
	 * @ordered
	 */
	INIT(0, "INIT", "INIT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>PHASE1</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PHASE1_VALUE
	 * @generated
	 * @ordered
	 */
	PHASE1(1, "PHASE1", "PHASE1"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>PHASE2</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PHASE2_VALUE
	 * @generated
	 * @ordered
	 */
	PHASE2(2, "PHASE2", "PHASE2"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>PHASE3</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PHASE3_VALUE
	 * @generated
	 * @ordered
	 */
	PHASE3(3, "PHASE3", "PHASE3"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>OK</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #OK_VALUE
	 * @generated
	 * @ordered
	 */
	OK(4, "OK", "OK"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DISPOSED</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DISPOSED_VALUE
	 * @generated
	 * @ordered
	 */
	DISPOSED(5, "DISPOSED", "DISPOSED"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DISPOSE PENDING</b></em>' literal object. <!-- begin-user-doc -->A binding can get this state if an
	 * error occurs during {@link IBindingContext#finish()}.<!-- end-user-doc -->
	 * 
	 * @see #DISPOSE_PENDING_VALUE
	 * @generated
	 * @ordered
	 */
	DISPOSE_PENDING(6, "DISPOSE_PENDING", "DISPOSE_PENDING"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>INIT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INIT</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INIT
	 * @generated
	 * @ordered
	 */
	public static final int INIT_VALUE = 0;

	/**
	 * The '<em><b>PHASE1</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHASE1</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PHASE1
	 * @generated
	 * @ordered
	 */
	public static final int PHASE1_VALUE = 1;

	/**
	 * The '<em><b>PHASE2</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHASE2</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PHASE2
	 * @generated
	 * @ordered
	 */
	public static final int PHASE2_VALUE = 2;

	/**
	 * The '<em><b>PHASE3</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHASE3</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PHASE3
	 * @generated
	 * @ordered
	 */
	public static final int PHASE3_VALUE = 3;

	/**
	 * The '<em><b>OK</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OK</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #OK
	 * @generated
	 * @ordered
	 */
	public static final int OK_VALUE = 4;

	/**
	 * The '<em><b>DISPOSED</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISPOSED</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DISPOSED
	 * @generated
	 * @ordered
	 */
	public static final int DISPOSED_VALUE = 5;

	/**
	 * The '<em><b>DISPOSE PENDING</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISPOSE PENDING</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DISPOSE_PENDING
	 * @generated
	 * @ordered
	 */
	public static final int DISPOSE_PENDING_VALUE = 6;

	/**
	 * An array of all the '<em><b>Binding State</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final BindingState[] VALUES_ARRAY = new BindingState[] { INIT, PHASE1, PHASE2, PHASE3, OK, DISPOSED,
			DISPOSE_PENDING, };

	/**
	 * A public read-only list of all the '<em><b>Binding State</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<BindingState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Binding State</b></em>' literal with the specified literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static BindingState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final BindingState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Binding State</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static BindingState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final BindingState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Binding State</b></em>' literal with the specified integer value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static BindingState get(int value) {
		switch (value) {
		case INIT_VALUE:
			return INIT;
		case PHASE1_VALUE:
			return PHASE1;
		case PHASE2_VALUE:
			return PHASE2;
		case PHASE3_VALUE:
			return PHASE3;
		case OK_VALUE:
			return OK;
		case DISPOSED_VALUE:
			return DISPOSED;
		case DISPOSE_PENDING_VALUE:
			return DISPOSE_PENDING;
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
	private BindingState(int value, String name, String literal) {
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

} // BindingState
