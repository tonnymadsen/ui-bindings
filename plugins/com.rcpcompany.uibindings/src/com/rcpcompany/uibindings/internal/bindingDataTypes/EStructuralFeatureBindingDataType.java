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
package com.rcpcompany.uibindings.internal.bindingDataTypes;

import java.util.Collection;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IArgumentContext;
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
	public <ArgumentType> void addParentDataTypeArguments(IArgumentContext<ArgumentType> context,
			Collection<IBindingDataType> visitedDataTypes) {
		if (myStructuralFeature instanceof EAttribute
				&& !context.getArgumentInformation().isLookupAttributeContainingClass()) return;
		if (myStructuralFeature instanceof EReference
				&& !context.getArgumentInformation().isLookupReferenceContainingClass()) return;
		super.addParentDataTypeArguments(context, visitedDataTypes);
	}

	@Override
	public <ArgumentType> void addSuperDataTypeArguments(IArgumentContext<ArgumentType> context,
			Collection<IBindingDataType> visitedDataTypes) {
		if (myStructuralFeature instanceof EAttribute
				&& !context.getArgumentInformation().isLookupAttributeTargetType()) return;
		if (myStructuralFeature instanceof EReference
				&& !context.getArgumentInformation().isLookupReferenceTargetType()) return;
		super.addSuperDataTypeArguments(context, visitedDataTypes);
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
	public IArgumentProvider getArgumentProvider(String type) {
		final IManager manager = IManager.Factory.getManager();
		final EClass eClass = myStructuralFeature.getEContainingClass();
		manager.runModelArgumentMediators(eClass);
		return manager.getModelFeatureInfo(eClass.getInstanceClassName(), myStructuralFeature.getName(), type, false);
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
			myParent = BindingDataTypeFactory.create(myStructuralFeature.getEContainingClass());
		}
		return myParent;
	}

	@Override
	public boolean isRequired() {
		return myStructuralFeature.isRequired();
	}

	@Override
	public boolean isChangeable() {
		return myStructuralFeature.isChangeable()
				&& !EcoreUtil.isSuppressedVisibility(myStructuralFeature, EcoreUtil.SET);
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
