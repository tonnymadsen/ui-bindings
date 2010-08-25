/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import java.util.Collection;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeImageDecoration;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.basic.ClassUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>UI Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getWidget <em>Widget</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getAttribute <em>Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getCurrentValue <em>Current Value
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getPossibleValuesList <em>Possible
 * Values List</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getMinValue <em>Min Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getMaxValue <em>Max Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getTooltipValue <em>Tooltip Value
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getFontValue <em>Font Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getImageValue <em>Image Value</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getForegroundValue <em>Foreground
 * Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getBackgroundValue <em>Background
 * Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getEnabledValue <em>Enabled Value
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getCursorValue <em>Cursor Value
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getStyleRangeList <em>Style Range
 * List</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#isChangeable <em>Changeable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getFieldAssistAdapter <em>Field
 * Assist Adapter</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImpl#getImageDecorations <em>Image
 * Decorations</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class UIAttributeImpl extends EObjectImpl implements IUIAttribute {
	/**
	 * The default value of the '{@link #getWidget() <em>Widget</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWidget()
	 * @generated
	 * @ordered
	 */
	protected static final Widget WIDGET_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_EDEFAULT = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected String attribute = ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentValue() <em>Current Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCurrentValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue CURRENT_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getPossibleValuesList() <em>Possible Values List</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPossibleValuesList()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableList POSSIBLE_VALUES_LIST_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue MIN_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue MAX_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTooltipValue() <em>Tooltip Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTooltipValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue TOOLTIP_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getFontValue() <em>Font Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFontValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue FONT_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getImageValue() <em>Image Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImageValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue IMAGE_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getForegroundValue() <em>Foreground Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getForegroundValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue FOREGROUND_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getBackgroundValue() <em>Background Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBackgroundValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue BACKGROUND_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getEnabledValue() <em>Enabled Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEnabledValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue ENABLED_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCursorValue() <em>Cursor Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCursorValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue CURSOR_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getStyleRangeList() <em>Style Range List</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStyleRangeList()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableList STYLE_RANGE_LIST_EDEFAULT = null;

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
	 * The cached value of the '{@link #isChangeable() <em>Changeable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isChangeable()
	 * @generated
	 * @ordered
	 */
	protected boolean changeable = CHANGEABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFieldAssistAdapter() <em>Field Assist Adapter</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFieldAssistAdapter()
	 * @generated
	 * @ordered
	 */
	protected static final IControlContentAdapter FIELD_ASSIST_ADAPTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageDecorations() <em>Image Decorations</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImageDecorations()
	 * @generated
	 * @ordered
	 */
	protected EList<IUIAttributeImageDecoration> imageDecorations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIAttributeImpl() {
		super();
	}

	@Override
	public void dispose() {
		for (final IUIAttributeImageDecoration id : getImageDecorations()) {
			id.dispose();
		}
		setAttribute(ATTRIBUTE_EDEFAULT);
	}

	@Override
	public boolean isDisposed() {
		return getAttribute() == null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.UI_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract Widget getWidget();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAttribute(String newAttribute) {
		final String oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.UI_ATTRIBUTE__ATTRIBUTE,
					oldAttribute, attribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getCurrentValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableList getPossibleValuesList();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getMinValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getMaxValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getTooltipValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getFontValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getImageValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getForegroundValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getBackgroundValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getEnabledValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableValue getCursorValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableList getStyleRangeList();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isChangeable() {
		return changeable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setChangeable(boolean newChangeable) {
		final boolean oldChangeable = changeable;
		changeable = newChangeable;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.UI_ATTRIBUTE__CHANGEABLE,
					oldChangeable, changeable));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IControlContentAdapter getFieldAssistAdapter();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IUIAttributeImageDecoration> getImageDecorationsGen() {
		if (imageDecorations == null) {
			imageDecorations = new EObjectContainmentWithInverseEList<IUIAttributeImageDecoration>(
					IUIAttributeImageDecoration.class, this, IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS,
					IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE);
		}
		return imageDecorations;
	}

	private Adapter myImageDecorationsAdapter = null;

	protected IValueChangeListener myImageDecorationChangeListener = null;

	/**
	 * The last control used for image decorations.
	 */
	protected Control myLastImageDecorationsControl = null;

	/**
	 * The last <em>inner</em> bounds used for image decorations.
	 */
	protected Rectangle myLastImageDecorationsInnerBounds = null;

	/**
	 * The last <em>outer</em> bounds used for image decorations.
	 */
	protected Rectangle myLastImageDecorationsOuterBounds;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<IUIAttributeImageDecoration> getImageDecorations() {
		if (myImageDecorationsAdapter == null) {
			myImageDecorationsAdapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (msg.isTouch()) return;
					if (myImageDecorationChangeListener == null) {
						myImageDecorationChangeListener = new IValueChangeListener() {
							@Override
							public void handleValueChange(ValueChangeEvent event) {
								if (Activator.getDefault().TRACE_ATTRIBUTE_IMAGE_DECORATORS) {
									LogUtils.debug(this, UIAttributeImpl.this + ": image or text updated"); //$NON-NLS-1$
								}
								updateImageDecorationData();
							}
						};
					}

					if (msg.getFeature() == IUIBindingsPackage.Literals.UI_ATTRIBUTE__IMAGE_DECORATIONS) {
						switch (msg.getEventType()) {
						case Notification.REMOVE:
						case Notification.SET:
							final IUIAttributeImageDecoration id = (IUIAttributeImageDecoration) msg.getOldValue();
							id.getImageValue().removeValueChangeListener(myImageDecorationChangeListener);
							id.getTooltipValue().removeValueChangeListener(myImageDecorationChangeListener);
						}

						switch (msg.getEventType()) {
						case Notification.ADD:
						case Notification.SET:
							final IUIAttributeImageDecoration id = (IUIAttributeImageDecoration) msg.getNewValue();
							id.getImageValue().addValueChangeListener(myImageDecorationChangeListener);
							id.getTooltipValue().addValueChangeListener(myImageDecorationChangeListener);
						}
						myImageDecorationChangeListener.handleValueChange(null);
					}
					if (msg.getFeature() == IUIBindingsPackage.Literals.UI_ATTRIBUTE_IMAGE_DECORATION__POSITION) {
						if (Activator.getDefault().TRACE_ATTRIBUTE_IMAGE_DECORATORS) {
							LogUtils.debug(this, UIAttributeImpl.this + ": position updated"); //$NON-NLS-1$
						}
						updateImageDecorationData();
					}
					if (msg.getFeature() == IUIBindingsPackage.Literals.UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE) {
						if (Activator.getDefault().TRACE_ATTRIBUTE_IMAGE_DECORATORS) {
							LogUtils.debug(this, UIAttributeImpl.this + ": outside updated"); //$NON-NLS-1$
						}
						updateImageDecorationData();
					}
				};
			};
			eAdapters().add(myImageDecorationsAdapter);
		}
		return getImageDecorationsGen();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getImageDecorations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public IUIAttributeImageDecoration getImageDecoration(DecorationPosition position, boolean outside) {
		for (final IUIAttributeImageDecoration d : getImageDecorations()) {
			if (d.getPosition() == position && d.isOutside() == outside) return d;
		}
		final IUIAttributeImageDecoration d = IUIBindingsFactory.eINSTANCE.createUIAttributeImageDecoration();
		d.setPosition(position);
		d.setOutside(outside);
		getImageDecorations().add(d);
		return d;
	}

	@Override
	public void updateImageDecorations(Control control, Rectangle innerBounds, Rectangle outerBounds) {
		if (control.equals(myLastImageDecorationsControl) && innerBounds.equals(myLastImageDecorationsInnerBounds)
				&& outerBounds.equals(myLastImageDecorationsOuterBounds)) return;
		if (Activator.getDefault().TRACE_ATTRIBUTE_IMAGE_DECORATORS) {
			LogUtils.debug(this, toString() + ": c=" + control + ", bounds=" + innerBounds + "/" + outerBounds); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		myLastImageDecorationsControl = control;
		myLastImageDecorationsOuterBounds = outerBounds;
		myLastImageDecorationsInnerBounds = innerBounds;

		updateImageDecorationData();
	}

	/**
	 * Updates the list of {@link IUIAttributeImageDecoration image decorations} if any...
	 */
	protected void updateImageDecorationData() {
		/*
		 * No decorations? Use reflection to avoid creating the list ;-)
		 */
		if (!eIsSet(IUIBindingsPackage.Literals.UI_ATTRIBUTE__IMAGE_DECORATIONS)) return;
		if (Activator.getDefault().TRACE_ATTRIBUTE_IMAGE_DECORATORS) {
			LogUtils.debug(this, toString());
		}
		/*
		 * No parent control or bounds?
		 */
		if (myLastImageDecorationsControl == null || myLastImageDecorationsInnerBounds == null
				|| myLastImageDecorationsOuterBounds == null) return;

		for (final IUIAttributeImageDecoration id : getImageDecorations()) {
			id.updateImageDecorations(myLastImageDecorationsControl, myLastImageDecorationsInnerBounds,
					myLastImageDecorationsOuterBounds);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS:
			return ((InternalEList<?>) getImageDecorations()).basicRemove(otherEnd, msgs);
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
		switch (featureID) {
		case IUIBindingsPackage.UI_ATTRIBUTE__WIDGET:
			return getWidget();
		case IUIBindingsPackage.UI_ATTRIBUTE__ATTRIBUTE:
			return getAttribute();
		case IUIBindingsPackage.UI_ATTRIBUTE__CURRENT_VALUE:
			return getCurrentValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__POSSIBLE_VALUES_LIST:
			return getPossibleValuesList();
		case IUIBindingsPackage.UI_ATTRIBUTE__MIN_VALUE:
			return getMinValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__MAX_VALUE:
			return getMaxValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__TOOLTIP_VALUE:
			return getTooltipValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__FONT_VALUE:
			return getFontValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_VALUE:
			return getImageValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__FOREGROUND_VALUE:
			return getForegroundValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__BACKGROUND_VALUE:
			return getBackgroundValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__ENABLED_VALUE:
			return getEnabledValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__CURSOR_VALUE:
			return getCursorValue();
		case IUIBindingsPackage.UI_ATTRIBUTE__STYLE_RANGE_LIST:
			return getStyleRangeList();
		case IUIBindingsPackage.UI_ATTRIBUTE__CHANGEABLE:
			return isChangeable();
		case IUIBindingsPackage.UI_ATTRIBUTE__FIELD_ASSIST_ADAPTER:
			return getFieldAssistAdapter();
		case IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS:
			return getImageDecorations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IUIBindingsPackage.UI_ATTRIBUTE__ATTRIBUTE:
			setAttribute((String) newValue);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE__CHANGEABLE:
			setChangeable((Boolean) newValue);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS:
			getImageDecorations().clear();
			getImageDecorations().addAll((Collection<? extends IUIAttributeImageDecoration>) newValue);
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
		case IUIBindingsPackage.UI_ATTRIBUTE__ATTRIBUTE:
			setAttribute(ATTRIBUTE_EDEFAULT);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE__CHANGEABLE:
			setChangeable(CHANGEABLE_EDEFAULT);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS:
			getImageDecorations().clear();
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
		case IUIBindingsPackage.UI_ATTRIBUTE__WIDGET:
			return WIDGET_EDEFAULT == null ? getWidget() != null : !WIDGET_EDEFAULT.equals(getWidget());
		case IUIBindingsPackage.UI_ATTRIBUTE__ATTRIBUTE:
			return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals(attribute);
		case IUIBindingsPackage.UI_ATTRIBUTE__CURRENT_VALUE:
			return CURRENT_VALUE_EDEFAULT == null ? getCurrentValue() != null : !CURRENT_VALUE_EDEFAULT
					.equals(getCurrentValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__POSSIBLE_VALUES_LIST:
			return POSSIBLE_VALUES_LIST_EDEFAULT == null ? getPossibleValuesList() != null
					: !POSSIBLE_VALUES_LIST_EDEFAULT.equals(getPossibleValuesList());
		case IUIBindingsPackage.UI_ATTRIBUTE__MIN_VALUE:
			return MIN_VALUE_EDEFAULT == null ? getMinValue() != null : !MIN_VALUE_EDEFAULT.equals(getMinValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__MAX_VALUE:
			return MAX_VALUE_EDEFAULT == null ? getMaxValue() != null : !MAX_VALUE_EDEFAULT.equals(getMaxValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__TOOLTIP_VALUE:
			return TOOLTIP_VALUE_EDEFAULT == null ? getTooltipValue() != null : !TOOLTIP_VALUE_EDEFAULT
					.equals(getTooltipValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__FONT_VALUE:
			return FONT_VALUE_EDEFAULT == null ? getFontValue() != null : !FONT_VALUE_EDEFAULT.equals(getFontValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_VALUE:
			return IMAGE_VALUE_EDEFAULT == null ? getImageValue() != null : !IMAGE_VALUE_EDEFAULT
					.equals(getImageValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__FOREGROUND_VALUE:
			return FOREGROUND_VALUE_EDEFAULT == null ? getForegroundValue() != null : !FOREGROUND_VALUE_EDEFAULT
					.equals(getForegroundValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__BACKGROUND_VALUE:
			return BACKGROUND_VALUE_EDEFAULT == null ? getBackgroundValue() != null : !BACKGROUND_VALUE_EDEFAULT
					.equals(getBackgroundValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__ENABLED_VALUE:
			return ENABLED_VALUE_EDEFAULT == null ? getEnabledValue() != null : !ENABLED_VALUE_EDEFAULT
					.equals(getEnabledValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__CURSOR_VALUE:
			return CURSOR_VALUE_EDEFAULT == null ? getCursorValue() != null : !CURSOR_VALUE_EDEFAULT
					.equals(getCursorValue());
		case IUIBindingsPackage.UI_ATTRIBUTE__STYLE_RANGE_LIST:
			return STYLE_RANGE_LIST_EDEFAULT == null ? getStyleRangeList() != null : !STYLE_RANGE_LIST_EDEFAULT
					.equals(getStyleRangeList());
		case IUIBindingsPackage.UI_ATTRIBUTE__CHANGEABLE:
			return changeable != CHANGEABLE_EDEFAULT;
		case IUIBindingsPackage.UI_ATTRIBUTE__FIELD_ASSIST_ADAPTER:
			return FIELD_ASSIST_ADAPTER_EDEFAULT == null ? getFieldAssistAdapter() != null
					: !FIELD_ASSIST_ADAPTER_EDEFAULT.equals(getFieldAssistAdapter());
		case IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS:
			return imageDecorations != null && !imageDecorations.isEmpty();
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
		return ClassUtils.getLastClassName(this) + "[" + getWidget() + ", " + getAttribute() + "]@" + hashCode(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

} // UIAttributeImpl
