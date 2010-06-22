/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.rcpcompany.uibindings.navigator.IEditiorModelType;
import com.rcpcompany.uibindings.navigator.IEditorDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class NavigatorModelFactoryImpl extends EFactoryImpl implements INavigatorModelFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static INavigatorModelFactory init() {
		try {
			final INavigatorModelFactory theNavigatorModelFactory = (INavigatorModelFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcpcompany.com/schemas/uibindings/navigator");
			if (theNavigatorModelFactory != null) return theNavigatorModelFactory;
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NavigatorModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NavigatorModelFactoryImpl() {
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
		case INavigatorModelPackage.NAVIGATOR_MANAGER:
			return createNavigatorManager();
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE:
			return createEditiorModelType();
		case INavigatorModelPackage.EDITOR_DESCRIPTOR:
			return createEditorDescriptor();
		case INavigatorModelPackage.STRING_TO_MODEL_TYPE_MAP_ENTRY:
			return (EObject) createStringToModelTypeMapEntry();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	private INavigatorManager theManager = null;

	@Override
	public INavigatorManager getManager() {
		if (theManager == null) {
			theManager = createNavigatorManager();
		}
		return theManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public INavigatorManager createNavigatorManager() {
		final NavigatorManagerImpl navigatorManager = new NavigatorManagerImpl();
		return navigatorManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IEditiorModelType createEditiorModelType() {
		final EditiorModelTypeImpl editiorModelType = new EditiorModelTypeImpl();
		return editiorModelType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IEditorDescriptor createEditorDescriptor() {
		final EditorDescriptorImpl editorDescriptor = new EditorDescriptorImpl();
		return editorDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, IEditiorModelType> createStringToModelTypeMapEntry() {
		final StringToModelTypeMapEntryImpl stringToModelTypeMapEntry = new StringToModelTypeMapEntryImpl();
		return stringToModelTypeMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public INavigatorModelPackage getNavigatorModelPackage() {
		return (INavigatorModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static INavigatorModelPackage getPackage() {
		return INavigatorModelPackage.eINSTANCE;
	}

} // NavigatorModelFactoryImpl
