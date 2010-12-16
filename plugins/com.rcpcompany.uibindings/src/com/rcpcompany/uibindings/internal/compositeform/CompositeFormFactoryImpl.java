/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal.compositeform;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.rcpcompany.uibindings.compositeform.ICompositeForm;
import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormManager;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CompositeFormFactoryImpl extends EFactoryImpl implements ICompositeFormFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ICompositeFormFactory init() {
		try {
			final ICompositeFormFactory theCompositeFormFactory = (ICompositeFormFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcp-company.com/schemas/uibindings/compositeForm.ecore");
			if (theCompositeFormFactory != null) return theCompositeFormFactory;
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompositeFormFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompositeFormFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ICompositeFormPackage.COMPOSITE_FORM_MANAGER:
			return createCompositeFormManager();
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR:
			return createCompositeFormDescriptor();
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR:
			return createCompositeFormPartDescriptor();
		case ICompositeFormPackage.COMPOSITE_FORM:
			return createCompositeForm();
		case ICompositeFormPackage.COMPOSITE_FORM_PART:
			return createCompositeFormPart();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormManager createCompositeFormManager() {
		final CompositeFormManagerImpl compositeFormManager = new CompositeFormManagerImpl();
		return compositeFormManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormDescriptor createCompositeFormDescriptor() {
		final CompositeFormDescriptorImpl compositeFormDescriptor = new CompositeFormDescriptorImpl();
		return compositeFormDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeForm createCompositeForm() {
		final CompositeFormImpl compositeForm = new CompositeFormImpl();
		return compositeForm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormPartDescriptor createCompositeFormPartDescriptor() {
		final CompositeFormPartDescriptorImpl compositeFormPartDescriptor = new CompositeFormPartDescriptorImpl();
		return compositeFormPartDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormPart createCompositeFormPart() {
		final CompositeFormPartImpl compositeFormPart = new CompositeFormPartImpl();
		return compositeFormPart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormPackage getCompositeFormPackage() {
		return (ICompositeFormPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ICompositeFormPackage getPackage() {
		return ICompositeFormPackage.eINSTANCE;
	}

} // CompositeFormFactoryImpl
