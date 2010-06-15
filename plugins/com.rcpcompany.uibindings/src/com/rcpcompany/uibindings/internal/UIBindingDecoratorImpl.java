/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>UI Binding Decorator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl#getBinding <em>Binding</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl#isChangeable <em>Changeable
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl#getModelToUIConverter <em>
 * Model To UI Converter </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl#getUIToModelConverter <em>UI
 * To Model Converter </em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl#getUIToModelAfterConvertValidator
 * <em>UI To Model After Convert Validator</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl#getValidUIList <em>Valid UI
 * List</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class UIBindingDecoratorImpl extends EObjectImpl implements IUIBindingDecorator {
	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected IValueBinding binding;

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
	 * The default value of the '{@link #getModelToUIConverter() <em>Model To UI Converter</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelToUIConverter()
	 * @generated
	 * @ordered
	 */
	protected static final IConverter MODEL_TO_UI_CONVERTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelToUIConverter() <em>Model To UI Converter</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelToUIConverter()
	 * @generated
	 * @ordered
	 */
	protected IConverter modelToUIConverter = MODEL_TO_UI_CONVERTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUIToModelConverter() <em>UI To Model Converter</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUIToModelConverter()
	 * @generated
	 * @ordered
	 */
	protected static final IConverter UI_TO_MODEL_CONVERTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUIToModelConverter() <em>UI To Model Converter</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUIToModelConverter()
	 * @generated
	 * @ordered
	 */
	protected IConverter uiToModelConverter = UI_TO_MODEL_CONVERTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUIToModelAfterConvertValidator()
	 * <em>UI To Model After Convert Validator</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getUIToModelAfterConvertValidator()
	 * @generated
	 * @ordered
	 */
	protected static final IValidator UI_TO_MODEL_AFTER_CONVERT_VALIDATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUIToModelAfterConvertValidator()
	 * <em>UI To Model After Convert Validator</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getUIToModelAfterConvertValidator()
	 * @generated
	 * @ordered
	 */
	protected IValidator uiToModelAfterConvertValidator = UI_TO_MODEL_AFTER_CONVERT_VALIDATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidUIList() <em>Valid UI List</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValidUIList()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableList VALID_UI_LIST_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIBindingDecoratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.UI_BINDING_DECORATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IValueBinding getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setBinding(IValueBinding newBinding) {
		final IValueBinding oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.UI_BINDING_DECORATOR__BINDING,
					oldBinding, binding));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean isChangeable() {
		return getBinding().getDataType().isChangeable();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IConverter getModelToUIConverter() {
		return modelToUIConverter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IConverter getUIToModelConverter() {
		return uiToModelConverter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IValidator getUIToModelAfterConvertValidator() {
		return uiToModelAfterConvertValidator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IObservableList getValidUIList();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.UI_BINDING_DECORATOR__BINDING:
			return getBinding();
		case IUIBindingsPackage.UI_BINDING_DECORATOR__CHANGEABLE:
			return isChangeable();
		case IUIBindingsPackage.UI_BINDING_DECORATOR__MODEL_TO_UI_CONVERTER:
			return getModelToUIConverter();
		case IUIBindingsPackage.UI_BINDING_DECORATOR__UI_TO_MODEL_CONVERTER:
			return getUIToModelConverter();
		case IUIBindingsPackage.UI_BINDING_DECORATOR__UI_TO_MODEL_AFTER_CONVERT_VALIDATOR:
			return getUIToModelAfterConvertValidator();
		case IUIBindingsPackage.UI_BINDING_DECORATOR__VALID_UI_LIST:
			return getValidUIList();
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR__BINDING:
			setBinding((IValueBinding) newValue);
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR__BINDING:
			setBinding((IValueBinding) null);
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR__BINDING:
			return binding != null;
		case IUIBindingsPackage.UI_BINDING_DECORATOR__CHANGEABLE:
			return isChangeable() != CHANGEABLE_EDEFAULT;
		case IUIBindingsPackage.UI_BINDING_DECORATOR__MODEL_TO_UI_CONVERTER:
			return MODEL_TO_UI_CONVERTER_EDEFAULT == null ? modelToUIConverter != null
					: !MODEL_TO_UI_CONVERTER_EDEFAULT.equals(modelToUIConverter);
		case IUIBindingsPackage.UI_BINDING_DECORATOR__UI_TO_MODEL_CONVERTER:
			return UI_TO_MODEL_CONVERTER_EDEFAULT == null ? uiToModelConverter != null
					: !UI_TO_MODEL_CONVERTER_EDEFAULT.equals(uiToModelConverter);
		case IUIBindingsPackage.UI_BINDING_DECORATOR__UI_TO_MODEL_AFTER_CONVERT_VALIDATOR:
			return UI_TO_MODEL_AFTER_CONVERT_VALIDATOR_EDEFAULT == null ? uiToModelAfterConvertValidator != null
					: !UI_TO_MODEL_AFTER_CONVERT_VALIDATOR_EDEFAULT.equals(uiToModelAfterConvertValidator);
		case IUIBindingsPackage.UI_BINDING_DECORATOR__VALID_UI_LIST:
			return VALID_UI_LIST_EDEFAULT == null ? getValidUIList() != null : !VALID_UI_LIST_EDEFAULT
					.equals(getValidUIList());
		}
		return super.eIsSet(featureID);
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
		result.append(" (modelToUIConverter: "); //$NON-NLS-1$
		result.append(modelToUIConverter);
		result.append(", UIToModelConverter: "); //$NON-NLS-1$
		result.append(uiToModelConverter);
		result.append(", UIToModelAfterConvertValidator: "); //$NON-NLS-1$
		result.append(uiToModelAfterConvertValidator);
		result.append(')');
		return result.toString();
	}

} // UIBindingDecoratorImpl
