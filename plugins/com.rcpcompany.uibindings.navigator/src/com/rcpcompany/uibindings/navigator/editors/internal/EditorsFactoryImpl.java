/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.editors.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.rcpcompany.uibindings.navigator.editors.IEditiorModelType;
import com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor;
import com.rcpcompany.uibindings.navigator.editors.IEditorManager;
import com.rcpcompany.uibindings.navigator.editors.IEditorsFactory;
import com.rcpcompany.uibindings.navigator.editors.IEditorsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class EditorsFactoryImpl extends EFactoryImpl implements IEditorsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static IEditorsFactory init() {
		try {
			IEditorsFactory theEditorsFactory = (IEditorsFactory)EPackage.Registry.INSTANCE.getEFactory("http://rcpcompany.com/schemas/uibindings/editors"); 
			if (theEditorsFactory != null) {
				return theEditorsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EditorsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EditorsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IEditorsPackage.EDITOR_MANAGER: return createEditorManager();
			case IEditorsPackage.EDITIOR_MODEL_TYPE: return createEditiorModelType();
			case IEditorsPackage.EDITOR_DESCRIPTOR: return createEditorDescriptor();
			case IEditorsPackage.STRING_TO_MODEL_TYPE_MAP_ENTRY: return (EObject)createStringToModelTypeMapEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IEditorManager createEditorManager() {
		EditorManagerImpl editorManager = new EditorManagerImpl();
		return editorManager;
	}

	private final IEditorManager theManager = createEditorManager();

	@Override
	public IEditorManager getEditorManager() {
		return theManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IEditiorModelType createEditiorModelType() {
		EditiorModelTypeImpl editiorModelType = new EditiorModelTypeImpl();
		return editiorModelType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IEditorDescriptor createEditorDescriptor() {
		EditorDescriptorImpl editorDescriptor = new EditorDescriptorImpl();
		return editorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, IEditiorModelType> createStringToModelTypeMapEntry() {
		StringToModelTypeMapEntryImpl stringToModelTypeMapEntry = new StringToModelTypeMapEntryImpl();
		return stringToModelTypeMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IEditorsPackage getEditorsPackage() {
		return (IEditorsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IEditorsPackage getPackage() {
		return IEditorsPackage.eINSTANCE;
	}

} // EditorsFactoryImpl
