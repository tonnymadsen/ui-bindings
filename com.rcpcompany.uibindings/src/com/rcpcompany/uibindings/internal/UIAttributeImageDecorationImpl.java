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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeImageDecoration;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.utils.IControlDecoration;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>UI Attribute Image Decoration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl#isOutside <em>
 * Outside</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl#getImageValue <em>
 * Image Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl#getTooltipValue <em>
 * Tooltip Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl#getPosition <em>
 * Position</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl#getAttribute <em>
 * Attribute</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UIAttributeImageDecorationImpl extends EObjectImpl implements IUIAttributeImageDecoration {
	/**
	 * The default value of the '{@link #isOutside() <em>Outside</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isOutside()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OUTSIDE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOutside() <em>Outside</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isOutside()
	 * @generated
	 * @ordered
	 */
	protected boolean outside = OUTSIDE_EDEFAULT;

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
	 * The cached value of the '{@link #getImageValue() <em>Image Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImageValue()
	 * @generated
	 * @ordered
	 */
	protected IObservableValue imageValue = IMAGE_VALUE_EDEFAULT;

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
	 * The cached value of the '{@link #getTooltipValue() <em>Tooltip Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTooltipValue()
	 * @generated
	 * @ordered
	 */
	protected IObservableValue tooltipValue = TOOLTIP_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final DecorationPosition POSITION_EDEFAULT = DecorationPosition.TOP_LEFT;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected DecorationPosition position = POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIAttributeImageDecorationImpl() {
		super();
	}

	@Override
	public void dispose() {
		if (myControlDecoration != null) {
			IControlDecoration.Factory.removeDecoration(myControlDecoration);
			myControlDecoration = null;
		}
		if (imageValue != null) {
			imageValue.dispose();
			imageValue = null;
		}
		if (tooltipValue != null) {
			tooltipValue.dispose();
			tooltipValue = null;
		}
	}

	private IControlDecoration myControlDecoration = null;
	/**
	 * The control of this image decoration. May not change, when set
	 */
	private Control myControl = null;

	/**
	 * The last location of this image decoration.
	 */
	private final Point myLocation = new Point(0, 0);

	@Override
	public void updateImageDecorations(Control control, Rectangle innerBounds, Rectangle outerBounds) {
		if (myControl == null) {
			myControl = control;
		} else {
			Assert.isTrue(control == myControl, "Control may not change"); //$NON-NLS-1$
		}
		if (Activator.getDefault().TRACE_ATTRIBUTE_IMAGE_DECORATORS) {
			LogUtils.debug(
					this,
					this
							+ ": t=" + getTooltipValue().getValue() + ", i/o=" + innerBounds + "/" + outerBounds + ", rect=" + control.getBounds()); //$NON-NLS-1$ //$NON-NLS-2$
		}

		final Object v = getImageValue().getValue();
		if (v == null) {
			if (myControlDecoration != null) {
				IControlDecoration.Factory.removeDecoration(myControlDecoration);
			}
			return;
		}
		if (!(v instanceof Image)) {
			LogUtils.error(v, "Expected Image, got " + v.getClass().getName()); //$NON-NLS-1$
			if (myControlDecoration != null) {
				IControlDecoration.Factory.removeDecoration(myControlDecoration);
			}
			return;
		}

		/*
		 * Find the location of the image
		 */
		final Image i = (Image) v;
		final Rectangle imageBounds = i.getBounds();
		final Rectangle bounds = isOutside() ? outerBounds : innerBounds;
		if (bounds.width == 0 || bounds.height == 0) {
			LogUtils.debug(this, "zero size bounds: " + bounds);
			return;
		}

		myLocation.x = bounds.x;
		myLocation.y = bounds.y;
		if (isOutside()) {
			switch (getPosition()) {
			case TOP_LEFT:
			case CENTER_LEFT:
			case BOTTOM_LEFT:
				myLocation.x += -imageBounds.width - OUTER_MARGIN_WIDTH;
				break;
			case TOP_RIGHT:
			case CENTER_RIGHT:
			case BOTTOM_RIGHT:
				myLocation.x += bounds.width + OUTER_MARGIN_WIDTH;
				break;
			default:
				LogUtils.error(this, "Unknown position: " + getPosition());
				break;
			}
		} else {
			switch (getPosition()) {
			case TOP_LEFT:
			case CENTER_LEFT:
			case BOTTOM_LEFT:
				myLocation.x += 0;
				break;
			case TOP_RIGHT:
			case CENTER_RIGHT:
			case BOTTOM_RIGHT:
				myLocation.x += bounds.width - imageBounds.width;
				break;
			default:
				LogUtils.error(this, "Unknown position: " + getPosition());
				break;
			}
		}
		switch (getPosition()) {
		case TOP_LEFT:
		case TOP_RIGHT:
			myLocation.y += 0;
			break;
		case CENTER_LEFT:
		case CENTER_RIGHT:
			myLocation.y += bounds.height / 2 - imageBounds.height / 2;
			break;
		case BOTTOM_LEFT:
		case BOTTOM_RIGHT:
			myLocation.y += bounds.height - imageBounds.height;
			break;
		default:
			LogUtils.error(this, "Unknown position: " + getPosition());
			break;
		}
		if (Activator.getDefault().TRACE_ATTRIBUTE_IMAGE_DECORATORS) {
			LogUtils.debug(this, this + ": image " + myLocation + ": " + innerBounds); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (myControlDecoration == null) {
			myControlDecoration = new ControlDecoration();
		}
		IControlDecoration.Factory.addDecoration(myControlDecoration);
	}

	protected class ControlDecoration implements IControlDecoration {
		@Override
		public Control getControl() {
			return myControl;
		}

		@Override
		public Image getImage() {
			if (imageValue == null) return null;
			return (Image) imageValue.getValue();
		}

		@Override
		public Point getLocation() {
			return myLocation;
		}

		@Override
		public String getTooltip() {
			if (tooltipValue == null) return null;
			return (String) tooltipValue.getValue();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.UI_ATTRIBUTE_IMAGE_DECORATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isOutside() {
		return outside;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOutside(boolean newOutside) {
		final boolean oldOutside = outside;
		outside = newOutside;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE, oldOutside, outside));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableValue getImageValue() {
		if (imageValue == null) {
			imageValue = WritableValue.withValueType(Image.class);
		}
		return imageValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableValue getTooltipValue() {
		if (tooltipValue == null) {
			tooltipValue = WritableValue.withValueType(String.class);
		}
		return tooltipValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public DecorationPosition getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPosition(DecorationPosition newPosition) {
		final DecorationPosition oldPosition = position;
		position = newPosition == null ? POSITION_EDEFAULT : newPosition;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__POSITION, oldPosition, position));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IUIAttribute getAttribute() {
		if (eContainerFeatureID() != IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE) return null;
		return (IUIAttribute) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAttribute(IUIAttribute newAttribute, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newAttribute,
				IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAttribute(IUIAttribute newAttribute) {
		if (newAttribute != eInternalContainer()
				|| (eContainerFeatureID() != IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE && newAttribute != null)) {
			if (EcoreUtil.isAncestor(this, newAttribute))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newAttribute != null) {
				msgs = ((InternalEObject) newAttribute).eInverseAdd(this,
						IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS, IUIAttribute.class, msgs);
			}
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE, newAttribute, newAttribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetAttribute((IUIAttribute) otherEnd, msgs);
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
		switch (featureID) {
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE:
			return basicSetAttribute(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE:
			return eInternalContainer().eInverseRemove(this, IUIBindingsPackage.UI_ATTRIBUTE__IMAGE_DECORATIONS,
					IUIAttribute.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE:
			return isOutside();
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__IMAGE_VALUE:
			return getImageValue();
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__TOOLTIP_VALUE:
			return getTooltipValue();
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__POSITION:
			return getPosition();
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE:
			return getAttribute();
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
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE:
			setOutside((Boolean) newValue);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__POSITION:
			setPosition((DecorationPosition) newValue);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE:
			setAttribute((IUIAttribute) newValue);
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
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE:
			setOutside(OUTSIDE_EDEFAULT);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__POSITION:
			setPosition(POSITION_EDEFAULT);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE:
			setAttribute((IUIAttribute) null);
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
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE:
			return outside != OUTSIDE_EDEFAULT;
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__IMAGE_VALUE:
			return IMAGE_VALUE_EDEFAULT == null ? imageValue != null : !IMAGE_VALUE_EDEFAULT.equals(imageValue);
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__TOOLTIP_VALUE:
			return TOOLTIP_VALUE_EDEFAULT == null ? tooltipValue != null : !TOOLTIP_VALUE_EDEFAULT.equals(tooltipValue);
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__POSITION:
			return position != POSITION_EDEFAULT;
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE:
			return getAttribute() != null;
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
		return eContainer + ": " + getPosition() + "/" + (isOutside() ? "outside" : "inside"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
} // UIAttributeImageDecorationImpl
