/*******************************************************************************
 * Copyright (c) 2007, 2011 The RCP Company and others.
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
 * <!-- begin-user-doc --> This enumeration specify the possible cell types in a container. The
 * primary use is as a source variable that can be used in expressions to filter commands and
 * handlers. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getContainerCellType()
 * @generated
 */
public enum ContainerCellType implements Enumerator {
	/**
	 * The '<em><b>TOP LEFT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TOP_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_LEFT(0, "TOP_LEFT", "TOP_LEFT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>TOP RIGHT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TOP_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_RIGHT(1, "TOP_RIGHT", "TOP_RIGHT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>COLUMN HEADER</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #COLUMN_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	COLUMN_HEADER(2, "COLUMN_HEADER", "COLUMN_HEADER"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ROW HEADER</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #ROW_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	ROW_HEADER(3, "ROW_HEADER", "ROW_HEADER"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DATA</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DATA_VALUE
	 * @generated
	 * @ordered
	 */
	DATA(4, "DATA", "DATA"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>BOTTOM LEFT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #BOTTOM_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_LEFT(5, "BOTTOM_LEFT", "BOTTOM_LEFT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>BOTTOM RIGHT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #BOTTOM_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_RIGHT(6, "BOTTOM_RIGHT", "BOTTOM_RIGHT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>COLUMN TRAILER</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #COLUMN_TRAILER_VALUE
	 * @generated
	 * @ordered
	 */
	COLUMN_TRAILER(7, "COLUMN_TRAILER", "COLUMN_TRAILER"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ROW TRAILER</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #ROW_TRAILER_VALUE
	 * @generated
	 * @ordered
	 */
	ROW_TRAILER(8, "ROW_TRAILER", "ROW_TRAILER"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>TOP LEFT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOP LEFT</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TOP_LEFT
	 * @generated
	 * @ordered
	 */
	public static final int TOP_LEFT_VALUE = 0;

	/**
	 * The '<em><b>TOP RIGHT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOP RIGHT</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TOP_RIGHT
	 * @generated
	 * @ordered
	 */
	public static final int TOP_RIGHT_VALUE = 1;

	/**
	 * The '<em><b>COLUMN HEADER</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLUMN HEADER</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #COLUMN_HEADER
	 * @generated
	 * @ordered
	 */
	public static final int COLUMN_HEADER_VALUE = 2;

	/**
	 * The '<em><b>ROW HEADER</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROW HEADER</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ROW_HEADER
	 * @generated
	 * @ordered
	 */
	public static final int ROW_HEADER_VALUE = 3;

	/**
	 * The '<em><b>DATA</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATA</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DATA
	 * @generated
	 * @ordered
	 */
	public static final int DATA_VALUE = 4;

	/**
	 * The '<em><b>BOTTOM LEFT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOTTOM LEFT</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BOTTOM_LEFT
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_LEFT_VALUE = 5;

	/**
	 * The '<em><b>BOTTOM RIGHT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOTTOM RIGHT</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BOTTOM_RIGHT
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_RIGHT_VALUE = 6;

	/**
	 * The '<em><b>COLUMN TRAILER</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLUMN TRAILER</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #COLUMN_TRAILER
	 * @generated
	 * @ordered
	 */
	public static final int COLUMN_TRAILER_VALUE = 7;

	/**
	 * The '<em><b>ROW TRAILER</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROW TRAILER</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ROW_TRAILER
	 * @generated
	 * @ordered
	 */
	public static final int ROW_TRAILER_VALUE = 8;

	/**
	 * An array of all the '<em><b>Container Cell Type</b></em>' enumerators. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ContainerCellType[] VALUES_ARRAY = new ContainerCellType[] { TOP_LEFT, TOP_RIGHT,
			COLUMN_HEADER, ROW_HEADER, DATA, BOTTOM_LEFT, BOTTOM_RIGHT, COLUMN_TRAILER, ROW_TRAILER, };

	/**
	 * A public read-only list of all the '<em><b>Container Cell Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<ContainerCellType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Container Cell Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ContainerCellType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final ContainerCellType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Container Cell Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ContainerCellType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			final ContainerCellType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) return result;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Container Cell Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ContainerCellType get(int value) {
		switch (value) {
		case TOP_LEFT_VALUE:
			return TOP_LEFT;
		case TOP_RIGHT_VALUE:
			return TOP_RIGHT;
		case COLUMN_HEADER_VALUE:
			return COLUMN_HEADER;
		case ROW_HEADER_VALUE:
			return ROW_HEADER;
		case DATA_VALUE:
			return DATA;
		case BOTTOM_LEFT_VALUE:
			return BOTTOM_LEFT;
		case BOTTOM_RIGHT_VALUE:
			return BOTTOM_RIGHT;
		case COLUMN_TRAILER_VALUE:
			return COLUMN_TRAILER;
		case ROW_TRAILER_VALUE:
			return ROW_TRAILER;
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
	private ContainerCellType(int value, String name, String literal) {
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

} // ContainerCellType
