/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> Possible decoration positions in relation to a Control. <!-- end-user-doc
 * -->
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecorationPosition()
 * @generated
 */
public enum DecorationPosition implements Enumerator {
	/**
	 * The '<em><b>Top Left</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TOP_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_LEFT(16512, "TopLeft", "TOP_LEFT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Center Left</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CENTER_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	CENTER_LEFT(16793600, "CenterLeft", "CENTER_LEFT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Bottom Left</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #BOTTOM_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_LEFT(17408, "BottomLeft", "BOTTOM_LEFT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Top Right</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TOP_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_RIGHT(131200, "TopRight", "TOP_RIGHT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Center Right</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CENTER_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	CENTER_RIGHT(16908288, "CenterRight", "CENTER_RIGHT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Bottom Right</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #BOTTOM_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_RIGHT(132096, "BottomRight", "BOTTOM_RIGHT"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Top Left</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Top Left</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TOP_LEFT
	 * @generated
	 * @ordered
	 */
	public static final int TOP_LEFT_VALUE = 16512;

	/**
	 * The '<em><b>Center Left</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Center Left</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CENTER_LEFT
	 * @generated
	 * @ordered
	 */
	public static final int CENTER_LEFT_VALUE = 16793600;

	/**
	 * The '<em><b>Bottom Left</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bottom Left</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BOTTOM_LEFT
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_LEFT_VALUE = 17408;

	/**
	 * The '<em><b>Top Right</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Top Right</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TOP_RIGHT
	 * @generated
	 * @ordered
	 */
	public static final int TOP_RIGHT_VALUE = 131200;

	/**
	 * The '<em><b>Center Right</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Center Right</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CENTER_RIGHT
	 * @generated
	 * @ordered
	 */
	public static final int CENTER_RIGHT_VALUE = 16908288;

	/**
	 * The '<em><b>Bottom Right</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bottom Right</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BOTTOM_RIGHT
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_RIGHT_VALUE = 132096;

	/**
	 * An array of all the '<em><b>Decoration Position</b></em>' enumerators. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DecorationPosition[] VALUES_ARRAY = new DecorationPosition[] { TOP_LEFT, CENTER_LEFT,
			BOTTOM_LEFT, TOP_RIGHT, CENTER_RIGHT, BOTTOM_RIGHT, };

	/**
	 * A public read-only list of all the '<em><b>Decoration Position</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<DecorationPosition> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Message Decoration Position</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DecorationPosition get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final DecorationPosition result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Decoration Position</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DecorationPosition getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final DecorationPosition result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Message Decoration Position</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DecorationPosition get(int value) {
		switch (value) {
		case TOP_LEFT_VALUE:
			return TOP_LEFT;
		case CENTER_LEFT_VALUE:
			return CENTER_LEFT;
		case BOTTOM_LEFT_VALUE:
			return BOTTOM_LEFT;
		case TOP_RIGHT_VALUE:
			return TOP_RIGHT;
		case CENTER_RIGHT_VALUE:
			return CENTER_RIGHT;
		case BOTTOM_RIGHT_VALUE:
			return BOTTOM_RIGHT;
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
	private DecorationPosition(int value, String name, String literal) {
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

} // MessageDecorationPosition
