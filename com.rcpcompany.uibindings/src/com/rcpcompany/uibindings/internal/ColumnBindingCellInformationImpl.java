/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingContext.FinishOption;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.observables.MyDetailObservableValue;
import com.rcpcompany.uibindings.observables.ProxyObservableValue;
import com.rcpcompany.uibindings.uiAttributes.UIAttributePainter;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.utils.logging.ITimedTask;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Column Binding Cell Information</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getColumn <em>
 * Column</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getElement <em>
 * Element</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getLabelBinding
 * <em>Label Binding</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getLabelUIAttribute
 * <em>Label UI Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getLabelPainter
 * <em>Label Painter</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getObjectValue
 * <em>Object Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getSourceValue
 * <em>Source Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#isChangeable <em>
 * Changeable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getDisplayText
 * <em>Display Text</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getValueType <em>
 * Value Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#getToolTipText
 * <em>Tool Tip Text</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl#isEnabled <em>
 * Enabled</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ColumnBindingCellInformationImpl extends EObjectImpl implements IColumnBindingCellInformation {
	@Override
	public void init(IColumnBinding column, Object element) {
		final ITimedTask task = ITimedTask.Factory.start("init");
		setColumn(column);
		final Object baseElement = element;

		setElement((EObject) baseElement);

		getColumn().getCells().put(getElement(), this);

		if (Activator.getDefault().TRACE_LIFECYCLE_CI) {
			LogUtils.debug(this, this + " constructed"); //$NON-NLS-1$
		}

		if (column.getBaseColumn() == null) {
			setSourceValue(Observables.constantObservableValue(getElement(), getElement().eClass()));
		} else {
			final IColumnBindingCellInformation parentCI = column.getBaseColumn().getCellInformation(getElement());
			setSourceValue(new ProxyObservableValue(parentCI.getObjectValue()));
		}

		/**
		 * Find the value...
		 * 
		 * Note that the source value can change(!) so a master-detail is needed!
		 * 
		 * Another note: the valueTypes EJAVE_OBJECT and Object.class are passed to the observable
		 * as null, as this means the result will not be checked.
		 */
		Object valueType = column.getDataType().getValueType();
		if (valueType == EcorePackage.Literals.EJAVA_OBJECT) {
			valueType = null;
		} else if (valueType == Object.class) {
			valueType = null;
		}
		MyDetailObservableValue newObjectValue = null;
		String errorText = null;
		try {
			newObjectValue = new MyDetailObservableValue(getSourceValue(), column.getFactory(), valueType);
		} catch (final Exception ex) {
			LogUtils.error(column.getFactory(), "Cannot create the detail", ex);
			errorText = "Cannot create the detail: " + ex;
			newObjectValue = null;
		}
		setObjectValue(newObjectValue);

		/*
		 * We will use a UI binding to convert from myValue to myLabelUIAttribute...
		 * 
		 * The attribute is NOT changeable, so paste must make it own changeable binding first.
		 */
		final VirtualUIAttribute attribute = new VirtualUIAttribute(String.class);
		setLabelUIAttribute(attribute);

		final UIAttributePainter painter = new UIAttributePainter(column.getViewerBinding().getControl(),
				getLabelUIAttribute());
		setLabelPainter(painter);

		final IBindingContext context = getColumn().getContext();
		final IValueBinding lb = context.addBinding().model(newObjectValue).ui(attribute);
		if (errorText != null) {
			lb.addErrorCondition(errorText);
		}
		/*
		 * The column is not added as an extra argument provider as it is already the parent
		 */
		if (column.eIsSet(IUIBindingsPackage.Literals.BINDING__EXTRA_ARGUMENT_PROVIDERS)) {
			lb.getExtraArgumentProviders().addAll(column.getExtraArgumentProviders());
		}
		setLabelBinding(lb);
		lb.setCell(this);
		/*
		 * For constant tree items we add an extra argument provider with the descriptor
		 */
		if (element instanceof IConstantTreeItem) {
			lb.getExtraArgumentProviders().add(((IConstantTreeItem) element).getDescriptor());
		}
		/*
		 * For the tree columns, we also add the model type of the row element as an extra argument
		 * provider...
		 * 
		 * This is primary used for the image...
		 */
		// if (getColumn().getSpecialBindingType() == SpecialBinding.TREE_ITEM) {
		// final IBindingDataType dataType = IBindingDataType.Factory.create(null,
		// getElement().eClass());
		// if (dataType != null) {
		// final String type = lb.getType();
		// if (type != null && type.length() > 0) {
		// final IArgumentProvider ap = dataType.getArgumentProvider(type);
		// if (ap != null) {
		// if (Activator.getDefault().TRACE_TREE) {
		// LogUtils.debug(this, lb + ": added data type argument provider(binding type: " + type
		// + "): " + dataType);
		// }
		// lb.getExtraArgumentProviders().add(ap);
		// }
		// }
		// final IArgumentProvider ap = dataType.getArgumentProvider(null);
		// if (ap != null) {
		// if (Activator.getDefault().TRACE_TREE) {
		// LogUtils.debug(this, lb + ": added data type argument provider: " + dataType);
		// }
		// lb.getExtraArgumentProviders().add(ap);
		// }
		// }
		// }

		/*
		 * We added a new binding so call finish as well...
		 */
		task.subTask("finish");
		context.finish(FinishOption.IF_ALREADY_FINISHED);
		task.subTask("finish done");

		attribute.addChangeListener(myAttributeValueListener);
		// task.end();
	}

	@Override
	public IContainerBinding getContainer() {
		return getColumn().getViewerBinding();
	}

	@Override
	public Point getPosition(boolean visualModel) {
		final IColumnBinding col = getColumn();
		final IViewerBinding viewer = col.getViewerBinding();

		final int columnNo = col.getIndex(visualModel);
		final int rowNo = viewer.getList().indexOf(getElement());

		return new Point(columnNo, rowNo);
	}

	/**
	 * Listener used to on the {@link IUIAttribute} to monitor for changes that should provoke an
	 * update of the cell.
	 */
	protected final IChangeListener myAttributeValueListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			getColumn().getViewerBinding().updateCellsForElement(getElement());
		}
	};

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected IColumnBinding column;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EObject element;

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
	 * The default value of the '{@link #getLabelPainter() <em>Label Painter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLabelPainter()
	 * @generated
	 * @ordered
	 */
	protected static final UIAttributePainter LABEL_PAINTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabelPainter() <em>Label Painter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLabelPainter()
	 * @generated
	 * @ordered
	 */
	protected UIAttributePainter labelPainter = LABEL_PAINTER_EDEFAULT;

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
	 * The default value of the '{@link #getSourceValue() <em>Source Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue SOURCE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceValue() <em>Source Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceValue()
	 * @generated
	 * @ordered
	 */
	protected IObservableValue sourceValue = SOURCE_VALUE_EDEFAULT;

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
	 * The default value of the '{@link #getToolTipText() <em>Tool Tip Text</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getToolTipText()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOL_TIP_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToolTipText() <em>Tool Tip Text</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getToolTipText()
	 * @generated
	 * @ordered
	 */
	protected String toolTipText = TOOL_TIP_TEXT_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ColumnBindingCellInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.COLUMN_BINDING_CELL_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IColumnBinding getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setColumn(IColumnBinding newColumn) {
		final IColumnBinding oldColumn = column;
		column = newColumn;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__COLUMN, oldColumn, column));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElement(EObject newElement) {
		final EObject oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ELEMENT, oldElement, element));
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
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_BINDING, oldLabelBinding, labelBinding));
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
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE, oldLabelUIAttribute,
					labelUIAttribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public UIAttributePainter getLabelPainter() {
		return labelPainter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLabelPainter(UIAttributePainter newLabelPainter) {
		final UIAttributePainter oldLabelPainter = labelPainter;
		labelPainter = newLabelPainter;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_PAINTER, oldLabelPainter, labelPainter));
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
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__OBJECT_VALUE, oldObjectValue, objectValue));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IObservableValue getSourceValue() {
		return sourceValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSourceValue(IObservableValue newSourceValue) {
		final IObservableValue oldSourceValue = sourceValue;
		sourceValue = newSourceValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__SOURCE_VALUE, oldSourceValue, sourceValue));
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
		if (!getColumn().getViewerBinding().isChangeable()) return false;

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
			value = ""; //$NON-NLS-1$
		}
		return value.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Class<?> getValueType() {
		return getLabelBinding().getDataType().getDataType();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getToolTipText() {
		return toolTipText;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setToolTipText(String newToolTipText) {
		final String oldToolTipText = toolTipText;
		toolTipText = newToolTipText;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__TOOL_TIP_TEXT, oldToolTipText, toolTipText));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ENABLED, oldEnabled, enabled));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__COLUMN:
			return getColumn();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ELEMENT:
			return getElement();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_BINDING:
			return getLabelBinding();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
			return getLabelUIAttribute();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_PAINTER:
			return getLabelPainter();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__OBJECT_VALUE:
			return getObjectValue();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__SOURCE_VALUE:
			return getSourceValue();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__CHANGEABLE:
			return isChangeable();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__DISPLAY_TEXT:
			return getDisplayText();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__VALUE_TYPE:
			return getValueType();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__TOOL_TIP_TEXT:
			return getToolTipText();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ENABLED:
			return isEnabled();
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
		switch (featureID) {
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__COLUMN:
			setColumn((IColumnBinding) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ELEMENT:
			setElement((EObject) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_BINDING:
			setLabelBinding((IValueBinding) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
			setLabelUIAttribute((IUIAttribute) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_PAINTER:
			setLabelPainter((UIAttributePainter) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__OBJECT_VALUE:
			setObjectValue((IObservableValue) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__SOURCE_VALUE:
			setSourceValue((IObservableValue) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__TOOL_TIP_TEXT:
			setToolTipText((String) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ENABLED:
			setEnabled((Boolean) newValue);
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
		switch (featureID) {
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__COLUMN:
			setColumn((IColumnBinding) null);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ELEMENT:
			setElement((EObject) null);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_BINDING:
			setLabelBinding((IValueBinding) null);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
			setLabelUIAttribute((IUIAttribute) null);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_PAINTER:
			setLabelPainter(LABEL_PAINTER_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__OBJECT_VALUE:
			setObjectValue(OBJECT_VALUE_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__SOURCE_VALUE:
			setSourceValue(SOURCE_VALUE_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__TOOL_TIP_TEXT:
			setToolTipText(TOOL_TIP_TEXT_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
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
		switch (featureID) {
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__COLUMN:
			return column != null;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ELEMENT:
			return element != null;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_BINDING:
			return labelBinding != null;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE:
			return labelUIAttribute != null;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__LABEL_PAINTER:
			return LABEL_PAINTER_EDEFAULT == null ? labelPainter != null : !LABEL_PAINTER_EDEFAULT.equals(labelPainter);
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__OBJECT_VALUE:
			return OBJECT_VALUE_EDEFAULT == null ? objectValue != null : !OBJECT_VALUE_EDEFAULT.equals(objectValue);
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__SOURCE_VALUE:
			return SOURCE_VALUE_EDEFAULT == null ? sourceValue != null : !SOURCE_VALUE_EDEFAULT.equals(sourceValue);
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__CHANGEABLE:
			return isChangeable() != CHANGEABLE_EDEFAULT;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__DISPLAY_TEXT:
			return DISPLAY_TEXT_EDEFAULT == null ? getDisplayText() != null : !DISPLAY_TEXT_EDEFAULT
					.equals(getDisplayText());
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__VALUE_TYPE:
			return getValueType() != null;
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__TOOL_TIP_TEXT:
			return TOOL_TIP_TEXT_EDEFAULT == null ? toolTipText != null : !TOOL_TIP_TEXT_EDEFAULT.equals(toolTipText);
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return "CI[" + hashCode() + "]: " + getColumn() + "," + getElement(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public void dispose() {
		if (Activator.getDefault().TRACE_LIFECYCLE_CI) {
			LogUtils.debug(this, this + " disposed"); //$NON-NLS-1$
		}

		if (getLabelUIAttribute() instanceof VirtualUIAttribute) {
			((VirtualUIAttribute) getLabelUIAttribute()).removeChangeListener(myAttributeValueListener);
		}
		getLabelBinding().dispose();
		// getLabelUIAttribute().dispose();

		/*
		 * We created this, so we must dispose as well..
		 */
		getObjectValue().dispose();
		// mySourceValue is handled in the base column...

		getColumn().getCells().removeKey(getElement());
	}

	@Override
	public Control setFocus() {
		final IColumnBinding column = getColumn();
		final IViewerBinding viewer = column.getViewerBinding();
		final Control c = viewer.getControl();
		c.setFocus();
		viewer.setFocus(viewer.getColumns().indexOf(column) + viewer.getFirstTableColumnOffset(), getElement());

		return c;
	}

	@Override
	public String getMessagePrefix() {
		/*
		 * For now, we just use the column header for the cell
		 * 
		 * TODO extend this with a description of the object itself
		 */
		final IColumnBinding column = getColumn();
		return column.getColumnAdapter().getText() + ": "; //$NON-NLS-1$
	}

	@Override
	public IColumnBinding getColumnBinding() {
		return getColumn();
	}

} // ColumnBindingCellInformationImpl
