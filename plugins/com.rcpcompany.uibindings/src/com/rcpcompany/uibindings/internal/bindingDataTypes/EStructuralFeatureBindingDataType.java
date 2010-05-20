package com.rcpcompany.uibindings.internal.bindingDataTypes;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IArgumentProvider;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.BindingDataTypeImpl;

/**
 * An {@link IBindingDataType} for {@link EStructuralFeature}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EStructuralFeatureBindingDataType extends BindingDataTypeImpl {

	private final EStructuralFeature myStructuralFeature;
	private IBindingDataType myParent = null;

	/**
	 * Constructs and returns a new data type for the specified feature.
	 * 
	 * @param sf the feature
	 */
	public EStructuralFeatureBindingDataType(EStructuralFeature sf) {
		myStructuralFeature = sf;
	}

	@Override
	public Class<?> getDataType() {
		return getEType().getInstanceClass();
	}

	@Override
	public EAnnotation getEAnnotation() {
		return myStructuralFeature.getEAnnotation(Constants.EMF_ANNOTATION_SOURCE);
	}

	@Override
	public IArgumentProvider getArgumentProvider() {
		final IManager manager = IManager.Factory.getManager();
		manager.runModelArgumentMediators(myStructuralFeature.getEContainingClass());
		return manager.getModelFeatureInfo(myStructuralFeature.getContainerClass().getName(), myStructuralFeature
				.getName(), false);
	}

	@Override
	public Object getValueType() {
		return myStructuralFeature;
	}

	@Override
	public EClassifier getEType() {
		return myStructuralFeature.getEType();
	}

	@Override
	public String getName() {
		return myStructuralFeature.getName();
	}

	@Override
	public IBindingDataType getParentDataType() {
		if (myParent == null) {
			myParent = BindingDataTypeFactory.create(getEType());
		}
		return myParent;
	}

	@Override
	public boolean isRequired() {
		return myStructuralFeature.isRequired();
	}

	@Override
	public boolean isChangeable() {
		return myStructuralFeature.isChangeable();
	}

	@Override
	public boolean isUnsettable() {
		return myStructuralFeature.isUnsettable();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" + myStructuralFeature.getContainerClass().getName() + "." //$NON-NLS-1$ //$NON-NLS-2$
				+ myStructuralFeature.getName() + "]"; //$NON-NLS-1$
	}
}
