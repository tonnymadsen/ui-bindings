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
package com.rcpcompany.uibindings.grid.internal;

import java.util.Map;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.MyViewerCell;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingContext.FinishOption;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridBindingColumnInformation;
import com.rcpcompany.uibindings.grid.IGridBindingRowInformation;
import com.rcpcompany.uibindings.grid.IGridCell;
import com.rcpcompany.uibindings.grid.IGridModel;
import com.rcpcompany.uibindings.grid.IGridPackage;
import com.rcpcompany.uibindings.uiAttributes.UIAttributePainter;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Binding Cell Information</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getColumn <em>
 * Column</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getRow <em>Row
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getDataType
 * <em>Data Type</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getLabelBinding
 * <em>Label Binding</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getLabelUIAttribute
 * <em>Label UI Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getObjectValue
 * <em>Object Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#isChangeable
 * <em>Changeable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getDisplayText
 * <em>Display Text</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getValueType
 * <em>Value Type</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getPasteUIAttribute
 * <em>Paste UI Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#isEnabled <em>
 * Enabled</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl#getPainter <em>
 * Painter</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GridBindingCellInformationImpl extends EObjectImpl implements IGridBindingCellInformation {

	/**
	 * Returns the grid binding of this cell.
	 * 
	 * @return the grid binding
	 */
	public IGridBinding getGrid() {
		return getColumn().getGrid();
	}

	@Override
	public IContainerBinding getContainer() {
		return getGrid();
	}

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected IGridBindingColumnInformation column;

	/**
	 * The cached value of the '{@link #getRow() <em>Row</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRow()
	 * @generated
	 * @ordered
	 */
	protected IGridBindingRowInformation row;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected IBindingDataType dataType;

	/**
	 * The cached value of the '{@link #getLabelBinding() <em>Label Binding</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLabelBinding()
	 * @generated
	 * @ordered
	 */
	protected IValueBinding labelBinding;

	/**
	 * The cached value of the '{@link #getLabelUIAttribute() <em>Label UI Attribute</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLabelUIAttribute()
	 * @generated
	 * @ordered
	 */
	protected IUIAttribute labelUIAttribute;

	/**
	 * The default value of the '{@link #getObjectValue() <em>Object Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getObjectValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue OBJECT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectValue() <em>Object Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getObjectValue()
	 * @generated
	 * @ordered
	 */
	protected IObservableValue objectValue = OBJECT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isChangeable() <em>Changeable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isChangeable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHANGEABLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getDisplayText() <em>Display Text</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDisplayText()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPasteUIAttribute() <em>Paste UI Attribute</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPasteUIAttribute()
	 * @generated
	 * @ordered
	 */
	protected IUIAttribute pasteUIAttribute;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPainter() <em>Painter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPainter()
	 * @generated
	 * @ordered
	 */
	protected static final UIAttributePainter PAINTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPainter() <em>Painter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPainter()
	 * @generated
	 * @ordered
	 */
	protected UIAttributePainter painter = PAINTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION = IGridPackage.Literals.GRID_BINDING_CELL_INFORMATION
			.getFeatureID(IGridPackage.Literals.GRID_BINDING_CELL_INFORMATION__COLUMN)
			- IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION_COLUMN_OPPOSITE = IGridPackage.Literals.GRID_BINDING_COLUMN_INFORMATION
			.getFeatureID(IGridPackage.Literals.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS)
			- IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION_ROW_OPPOSITE = IGridPackage.Literals.GRID_BINDING_ROW_INFORMATION
			.getFeatureID(IGridPackage.Literals.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS)
			- IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	private static final int EOFFSET_CORRECTION_COLUMN_CELLS_OPPOSITE = EOFFSET_CORRECTION_COLUMN_OPPOSITE;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	private static final int EOFFSET_CORRECTION_ROW_CELLS_OPPOSITE = EOFFSET_CORRECTION_ROW_OPPOSITE;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GridBindingCellInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IGridPackage.Literals.GRID_BINDING_CELL_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridBindingColumnInformation getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetColumn(IGridBindingColumnInformation newColumn, NotificationChain msgs) {
		final IGridBindingColumnInformation oldColumn = column;
		column = newColumn;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN + EOFFSET_CORRECTION, oldColumn, newColumn);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setColumn(IGridBindingColumnInformation newColumn) {
		if (newColumn != column) {
			NotificationChain msgs = null;
			if (column != null) {
				msgs = ((InternalEObject) column).eInverseRemove(this,
						IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS + EOFFSET_CORRECTION_COLUMN_OPPOSITE,
						IGridBindingColumnInformation.class, msgs);
			}
			if (newColumn != null) {
				msgs = ((InternalEObject) newColumn).eInverseAdd(this,
						IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS + EOFFSET_CORRECTION_COLUMN_OPPOSITE,
						IGridBindingColumnInformation.class, msgs);
			}
			msgs = basicSetColumn(newColumn, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN
					+ EOFFSET_CORRECTION, newColumn, newColumn));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridBindingRowInformation getRow() {
		return row;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRow(IGridBindingRowInformation newRow, NotificationChain msgs) {
		final IGridBindingRowInformation oldRow = row;
		row = newRow;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW + EOFFSET_CORRECTION, oldRow, newRow);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRow(IGridBindingRowInformation newRow) {
		if (newRow != row) {
			NotificationChain msgs = null;
			if (row != null) {
				msgs = ((InternalEObject) row).eInverseRemove(this,
						IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS + EOFFSET_CORRECTION_ROW_OPPOSITE,
						IGridBindingRowInformation.class, msgs);
			}
			if (newRow != null) {
				msgs = ((InternalEObject) newRow).eInverseAdd(this,
						IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS + EOFFSET_CORRECTION_ROW_OPPOSITE,
						IGridBindingRowInformation.class, msgs);
			}
			msgs = basicSetRow(newRow, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW
					+ EOFFSET_CORRECTION, newRow, newRow));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IBindingDataType getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDataType(IBindingDataType newDataType) {
		final IBindingDataType oldDataType = dataType;
		dataType = newDataType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_CELL_INFORMATION__DATA_TYPE
					+ EOFFSET_CORRECTION, oldDataType, dataType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IValueBinding getLabelBinding() {
		return labelBinding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLabelBinding(IValueBinding newLabelBinding) {
		final IValueBinding oldLabelBinding = labelBinding;
		labelBinding = newLabelBinding;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_BINDING + EOFFSET_CORRECTION, oldLabelBinding,
					labelBinding));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IUIAttribute getLabelUIAttribute() {
		return labelUIAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLabelUIAttribute(IUIAttribute newLabelUIAttribute) {
		final IUIAttribute oldLabelUIAttribute = labelUIAttribute;
		labelUIAttribute = newLabelUIAttribute;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE + EOFFSET_CORRECTION,
					oldLabelUIAttribute, labelUIAttribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IObservableValue getObjectValue() {
		return objectValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setObjectValue(IObservableValue newObjectValue) {
		final IObservableValue oldObjectValue = objectValue;
		objectValue = newObjectValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE + EOFFSET_CORRECTION, oldObjectValue,
					objectValue));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean isChangeable() {
		if (!isEnabled()) return false;
		final IValueBinding b = getLabelBinding();
		if (b == null) return false;
		if (!b.isChangeable()) return false;
		if (b.eIsSet(IUIBindingsPackage.Literals.BINDING__ERROR_CONDITIONS) && b.getErrorConditions().size() > 0)
			return false;
		if (!getGrid().isChangeable()) return false;

		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getDisplayText() {
		Object value = null;
		final IObservableValue displayValue = getLabelUIAttribute().getCurrentValue();
		if (displayValue != null) {
			value = displayValue.getValue();
		}

		if (value == null) {
			value = "";
		}
		return value.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Class<?> getValueType() {
		// TODO: implement this method to return the 'Value Type' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IUIAttribute getPasteUIAttribute() {
		return pasteUIAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPasteUIAttribute(IUIAttribute newPasteUIAttribute) {
		final IUIAttribute oldPasteUIAttribute = pasteUIAttribute;
		pasteUIAttribute = newPasteUIAttribute;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE + EOFFSET_CORRECTION,
					oldPasteUIAttribute, pasteUIAttribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled) {
		final boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_CELL_INFORMATION__ENABLED
					+ EOFFSET_CORRECTION, oldEnabled, enabled));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public UIAttributePainter getPainter() {
		return painter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPainter(UIAttributePainter newPainter) {
		final UIAttributePainter oldPainter = painter;
		painter = newPainter;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_CELL_INFORMATION__PAINTER
					+ EOFFSET_CORRECTION, oldPainter, painter));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN:
			if (column != null) {
				msgs = ((InternalEObject) column).eInverseRemove(this,
						IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS + EOFFSET_CORRECTION_COLUMN_OPPOSITE,
						IGridBindingColumnInformation.class, msgs);
			}
			return basicSetColumn((IGridBindingColumnInformation) otherEnd, msgs);
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW:
			if (row != null) {
				msgs = ((InternalEObject) row).eInverseRemove(this,
						IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS + EOFFSET_CORRECTION_ROW_OPPOSITE,
						IGridBindingRowInformation.class, msgs);
			}
			return basicSetRow((IGridBindingRowInformation) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN:
			return basicSetColumn(null, msgs);
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW:
			return basicSetRow(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN:
			return getColumn();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW:
			return getRow();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__DATA_TYPE:
			return getDataType();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_BINDING:
			return getLabelBinding();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
			return getLabelUIAttribute();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE:
			return getObjectValue();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__CHANGEABLE:
			return isChangeable();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__DISPLAY_TEXT:
			return getDisplayText();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__VALUE_TYPE:
			return getValueType();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE:
			return getPasteUIAttribute();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ENABLED:
			return isEnabled();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__PAINTER:
			return getPainter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN:
			setColumn((IGridBindingColumnInformation) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW:
			setRow((IGridBindingRowInformation) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__DATA_TYPE:
			setDataType((IBindingDataType) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_BINDING:
			setLabelBinding((IValueBinding) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
			setLabelUIAttribute((IUIAttribute) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE:
			setObjectValue((IObservableValue) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE:
			setPasteUIAttribute((IUIAttribute) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__PAINTER:
			setPainter((UIAttributePainter) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN:
			setColumn((IGridBindingColumnInformation) null);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW:
			setRow((IGridBindingRowInformation) null);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__DATA_TYPE:
			setDataType((IBindingDataType) null);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_BINDING:
			setLabelBinding((IValueBinding) null);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
			setLabelUIAttribute((IUIAttribute) null);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE:
			setObjectValue(OBJECT_VALUE_EDEFAULT);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE:
			setPasteUIAttribute((IUIAttribute) null);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__PAINTER:
			setPainter(PAINTER_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN:
			return column != null;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW:
			return row != null;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__DATA_TYPE:
			return dataType != null;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_BINDING:
			return labelBinding != null;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
			return labelUIAttribute != null;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE:
			return OBJECT_VALUE_EDEFAULT == null ? objectValue != null : !OBJECT_VALUE_EDEFAULT.equals(objectValue);
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__CHANGEABLE:
			return isChangeable() != CHANGEABLE_EDEFAULT;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__DISPLAY_TEXT:
			return DISPLAY_TEXT_EDEFAULT == null ? getDisplayText() != null : !DISPLAY_TEXT_EDEFAULT
					.equals(getDisplayText());
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__VALUE_TYPE:
			return getValueType() != null;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE:
			return pasteUIAttribute != null;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case IGridPackage.GRID_BINDING_CELL_INFORMATION__PAINTER:
			return PAINTER_EDEFAULT == null ? painter != null : !PAINTER_EDEFAULT.equals(painter);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IValueBindingCell.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == IGridBindingCellInformation.class) {
			switch (baseFeatureID - EOFFSET_CORRECTION) {
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__DATA_TYPE:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__DATA_TYPE + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_BINDING:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_BINDING + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__CHANGEABLE:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__CHANGEABLE + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__DISPLAY_TEXT:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__DISPLAY_TEXT + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__VALUE_TYPE:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__VALUE_TYPE + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__ENABLED:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__ENABLED + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_CELL_INFORMATION__PAINTER:
				return IGridPackage.GRID_BINDING_CELL_INFORMATION__PAINTER + EOFFSET_CORRECTION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (objectValue: ");
		result.append(objectValue);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", painter: ");
		result.append(painter);
		result.append(')');
		return result.toString();
	}

	@Override
	public void dispose() {
		if (Activator.getDefault().TRACE_SOURCE_MODEL) {
			LogUtils.debug(getGrid().getModel(), "Model[" + getGrid().getGrid().hashCode() + "]: dispose["
					+ getColumn().getId() + ", " + getRow().getId() + "]@" + hashCode());
		}

		if (getLabelUIAttribute() instanceof VirtualUIAttribute) {
			((VirtualUIAttribute) getLabelUIAttribute()).removeChangeListener(myPropertyValueListener);
		}

		getLabelBinding().dispose();

		/*
		 * Before we break the connection
		 */
		if (getGrid().getFocusCell() == this) {
			getGrid().setFocusCell((IGridBindingCellInformation) null);
		}
		setColumn(null);
		setRow(null);
	}

	/**
	 * Initializes the cell with the information from the model.
	 * 
	 * @param column the column
	 * @param row the row
	 */
	public void init(IGridBindingColumnInformation column, IGridBindingRowInformation row) {
		setColumn(column);
		setRow(row);

		final IGridBinding grid = getGrid();
		final IBindingContext context = grid.getContext();
		final IGridModel model = grid.getModel();
		final Object columnID = column.getId();
		final Object rowID = row.getId();

		// LogUtils.debug(this, "\ncolumn=" + columnID + "\nrow=" + rowID);
		IGridCell cell = null;
		try {
			if (Activator.getDefault().TRACE_SOURCE_MODEL) {
				LogUtils.debug(model, "Model[" + grid.getGrid().hashCode() + "]: getcell(" + columnID + ", " + rowID
						+ ")");
			}
			cell = model.getCell(columnID, rowID);
			if (Activator.getDefault().TRACE_SOURCE_MODEL) {
				LogUtils.debug(model, "Model: >>> " + cell);
			}
		} catch (final Exception ex) {
			LogUtils.throwException(this, "Cannot get cell", ex);
		}
		try {
			if (Activator.getDefault().TRACE_SOURCE_MODEL) {
				LogUtils.debug(model, "Model[" + grid.getGrid().hashCode() + "]: getValue");
			}
			final IObservableValue value = cell.getValue();
			if (Activator.getDefault().TRACE_SOURCE_MODEL) {
				LogUtils.debug(model, "Model: >>> " + value);
			}
			/*
			 * Retrieve the wanted information
			 */
			setObjectValue(value);

			/*
			 * If we didn't get a IOV, then just ignore it...
			 */
			if (value == null) return;

			// TODO: set the renderer: final item.s

			setDataType(IBindingDataType.Factory.create(value.getValue(), value.getValueType()));

			/*
			 * We will use a UI binding to convert from myValue to myLabelUIAttribute...
			 */
			final VirtualUIAttribute attribute = new VirtualUIAttribute(String.class);
			setLabelUIAttribute(attribute);

			final IValueBinding lb = context.addBinding().model(value).ui(attribute);
			final Map<String, Object> args = cell.getArguments();
			if (args != null) {
				lb.args(args);
			}
			// TODO: make common super class: lb.setCell(this);
			setLabelBinding(lb);

			/*
			 * Set up the painter
			 */
			final Grid gridControl = grid.getGrid();
			final UIAttributePainter p = new UIAttributePainter(gridControl, attribute);
			p.setDefaultBackground(gridControl.getBackground());
			setPainter(p);

			/*
			 * The column header sets the column width based on the arguments of the label binding
			 */
			if (rowID == IGridModel.HEADER1) {
				final GridColumn gridColumn = column.getGridColumn();
				gridColumn.setWidth(lb.getArgument(Constants.ARG_WIDTH, Integer.class, 100));

				// TODO: cell renderer
				// TODO: alignment
			}

			/*
			 * We added a new binding so call finish as well...
			 */
			context.finish(FinishOption.IF_ALREADY_FINISHED);

			attribute.addChangeListener(myPropertyValueListener);

			// An immediate update
			updateCellValuesDelayed();
		} catch (final Exception ex) {
			LogUtils.error(this, ex);
		} finally {
			cell.dispose();
		}
	}

	/**
	 * Updates this cell.
	 */
	protected void updateCellValues() {
		if (getColumn() == null) {
			LogUtils.debug(this, "cell disposed! @" + hashCode());
			return;
		}
		IManagerRunnable.Factory.asyncExec("update", this, new Runnable() {
			@Override
			public void run() {
				updateCellValuesDelayed();
			}
		});
	}

	/**
	 * Updates this cell - delayed.
	 */
	protected void updateCellValuesDelayed() {
		/*
		 * Check if the cell has been disposed
		 */
		if (getColumn() == null) return;
		// LogUtils.debug(GridBindingCellInformationImpl.this, "");
		final IGridBinding grid = getGrid();
		final GridColumn gridColumn = getColumn().getGridColumn();
		final GridItem gridItem = getRow().getGridItem();

		/*
		 * Update the cell
		 */
		final IUIAttribute attr = getLabelUIAttribute();
		final IObservableValue currentValue = attr.getCurrentValue();
		if (currentValue.isDisposed()) return;
		final IObservableValue v = getObjectValue();

		final String text = (String) currentValue.getValue();
		final Color foreground = attr.getForeground();
		final Color background = attr.getBackground();
		final Image image = attr.getImage();
		final Font font = attr.getFont();
		final String tooltip = attr.getTooltip();
		// TODO: the rest: cursor, enabled, style range
		if (gridItem == null) {
			/*
			 * Column header:
			 */
			gridColumn.setText(text == null ? "" : text);
			gridColumn.setImage(image);
			// TODO gridColumn.set
			/*
			 * The changes in the column name and image only take effect when the table is redrawn
			 */
			grid.getGrid().redraw();
		} else if (gridColumn == null) {
			/*
			 * Row Header
			 */
			gridItem.setHeaderText(text == null ? "" : text);
			gridItem.setHeaderImage(image);
			gridItem.setHeaderForeground(foreground);
			gridItem.setHeaderBackground(background);
		} else {
			/*
			 * Normal cell
			 */
			final int index = grid.getGrid().indexOf(gridColumn);
			Assert.isTrue(index != -1);

			// gridItem.setChecked(index, v.getValue() == Boolean.TRUE);
			// gridItem.setText(index, null);
			// gridItem.setImage(index, null);
			// gridItem.setFont(index, null);

			gridItem.setText(index, text == null ? "" : text);
			gridItem.setImage(index, image);
			gridItem.setFont(index, font);
			gridItem.setForeground(index, foreground);
			gridItem.setBackground(index, background);
			gridItem.setToolTipText(index, tooltip);
		}
	}

	@Override
	public void handleEvent(Event event) {
		// LogUtils.debug(this, "event=" + ToStringUtils.toString(event));

		if (!isChangeable()) return;

		final IObservableValue v = getObjectValue();
		final Object modelType = v.getValueType();

		switch (event.type) {
		case SWT.Selection:
			if (event.detail == SWT.CHECK) {
				// TODO: changeable
				final boolean checkable = modelType == Boolean.class || modelType == Boolean.TYPE;
				if (checkable) {
					v.setValue(v.getValue() != Boolean.TRUE);
				}
			}
			break;
		case SWT.MouseDown:
			getGrid().editCell(this,
					new ColumnViewerEditorActivationEvent(MyViewerCell.INSTANCE, new MouseEvent(event)));
			break;
		case SWT.MouseDoubleClick:
			getGrid().editCell(this,
					new ColumnViewerEditorActivationEvent(MyViewerCell.INSTANCE, new MouseEvent(event)));
			break;
		case SWT.KeyDown:
			getGrid().editCell(this, new ColumnViewerEditorActivationEvent(MyViewerCell.INSTANCE, new KeyEvent(event)));
			event.doit = false;
			break;
		default:
			break;
		}
	}

	/**
	 * Listener for changes in the {@link #getLabelUIAttribute()}.
	 */
	protected IChangeListener myPropertyValueListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			// LogUtils.debug(GridBindingCellInformationImpl.this, "");
			updateCellValues();
		}
	};

	@Override
	public Control setFocus() {
		getGrid().setFocusCell(this);

		return getGrid().getGrid();
	}

	@Override
	public String getMessagePrefix() {
		return null;
	}

	@Override
	public IColumnBinding getColumnBinding() {
		return null;
	}

	@Override
	public Point getPosition(boolean visualModel) {
		// No visual model
		final int x = getColumn().getRowCells().indexOf(this);
		final int y = getRow().getColumnCells().indexOf(this);
		return new Point(x, y);
	}
} // GridBindingCellInformationImpl
