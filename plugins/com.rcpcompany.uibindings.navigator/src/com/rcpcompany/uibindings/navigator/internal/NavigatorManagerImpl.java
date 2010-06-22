/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.navigator.IEditiorModelType;
import com.rcpcompany.uibindings.navigator.IEditorDescriptor;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Manager</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.NavigatorManagerImpl#getModelTypes <em>
 * Model Types</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NavigatorManagerImpl extends EObjectImpl implements INavigatorManager {
	/**
	 * The cached value of the '{@link #getModelTypes() <em>Model Types</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelTypes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, IEditiorModelType> modelTypes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected NavigatorManagerImpl() {
		super();

		extensionReader();
	}

	private void extensionReader() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();

		final List<IConfigurationElement> relations = new ArrayList<IConfigurationElement>();
		for (final IConfigurationElement ce : registry
				.getConfigurationElementsFor(NavigatorConstants.EDITORS_EXTENSION_POINT)) {
			final String elementName = ce.getName();
			if (NavigatorConstants.EDITOR_TAG.equals(elementName)) {
				String id = ce.getAttribute(NavigatorConstants.ID_TAG);
				if (id == null || id.length() == 0) {
					id = "<unspecified>"; //$NON-NLS-1$
				}

				final String modelType = ce.getAttribute(NavigatorConstants.MODEL_TYPE_TAG);
				if (modelType == null || modelType.length() == 0) {
					LogUtils.error(ce, NavigatorConstants.MODEL_TYPE_TAG + " must be specified. Ignored"); //$NON-NLS-1$
					continue;
				}

				IEditiorModelType emt = getModelTypes().get(modelType);
				if (emt == null) {
					emt = INavigatorModelFactory.eINSTANCE.createEditiorModelType();
					emt.setModelType(modelType);

					getModelTypes().put(modelType, emt);
				}

				final String name = ce.getAttribute(NavigatorConstants.NAME_TAG);
				if (name == null || name.length() == 0) {
					LogUtils.error(ce, NavigatorConstants.NAME_TAG + " must be specified. Ignored"); //$NON-NLS-1$
					continue;
				}

				final IEditorDescriptor descriptor = INavigatorModelFactory.eINSTANCE.createEditorDescriptor();
				emt.getEditors().add(descriptor);
				descriptor.setId(id);
				descriptor.setName(name);
				descriptor.setImage(new CEResourceHolder(ce, NavigatorConstants.IMAGE_TAG));
				descriptor.setFactory(new CEObjectHolder<IEditorPartFactory>(ce));

				final String priority = ce.getAttribute(NavigatorConstants.PRIORITY_TAG);
				if (priority != null && priority.length() > 0) {
					try {
						descriptor.setPriority(Integer.parseInt(priority));
					} catch (final NumberFormatException ex) {
						LogUtils.error(ce, ex);
						continue;
					}
				} else {
					descriptor.setPriority(1000);
				}
			} else {
				LogUtils.error(ce, "Unknown element name: '" + elementName + "'"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		/*
		 * Sort the editors of model types
		 */
		final Comparator<IEditorDescriptor> comparator = new Comparator<IEditorDescriptor>() {
			@Override
			public int compare(IEditorDescriptor o1, IEditorDescriptor o2) {
				return o2.getPriority() - o1.getPriority();
			}
		};
		for (final IEditiorModelType tid : getModelTypes().values()) {
			UIBindingsUtils.sort(tid.getEditors(), comparator);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return INavigatorModelPackage.Literals.NAVIGATOR_MANAGER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, IEditiorModelType> getModelTypes() {
		if (modelTypes == null) {
			modelTypes = new EcoreEMap<String, IEditiorModelType>(
					INavigatorModelPackage.Literals.STRING_TO_MODEL_TYPE_MAP_ENTRY,
					StringToModelTypeMapEntryImpl.class, this, INavigatorModelPackage.NAVIGATOR_MANAGER__MODEL_TYPES);
		}
		return modelTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case INavigatorModelPackage.NAVIGATOR_MANAGER__MODEL_TYPES:
			return ((InternalEList<?>) getModelTypes()).basicRemove(otherEnd, msgs);
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
		case INavigatorModelPackage.NAVIGATOR_MANAGER__MODEL_TYPES:
			if (coreType)
				return getModelTypes();
			else
				return getModelTypes().map();
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
		case INavigatorModelPackage.NAVIGATOR_MANAGER__MODEL_TYPES:
			((EStructuralFeature.Setting) getModelTypes()).set(newValue);
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
		case INavigatorModelPackage.NAVIGATOR_MANAGER__MODEL_TYPES:
			getModelTypes().clear();
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
		case INavigatorModelPackage.NAVIGATOR_MANAGER__MODEL_TYPES:
			return modelTypes != null && !modelTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // NavigatorManagerImpl
