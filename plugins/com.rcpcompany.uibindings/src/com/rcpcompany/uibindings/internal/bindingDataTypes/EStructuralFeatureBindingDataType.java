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
	private IBindingDataType myParent = null;

	private final EClass myCls;
	private final EStructuralFeature mySF;

	/**
	 * Constructs and returns a new data type for the specified feature.
	 * 
	 * @param cls the containing class or a sub-class or this
	 * @param sf the feature
	 */
	public EStructuralFeatureBindingDataType(EClass cls, EStructuralFeature sf) {
		if (cls != null && sf.getEContainingClass().isSuperTypeOf(cls)) {
			myCls = cls;
		} else {
			myCls = sf.getEContainingClass();
		}
		mySF = sf;
	}

	@Override
	public <ArgumentType> void addParentDataTypeArguments(IArgumentContext<ArgumentType> context,
			Collection<IBindingDataType> visitedDataTypes) {
		if (mySF instanceof EAttribute && !context.getArgumentInformation().isLookupAttributeContainingClass()) return;
		if (mySF instanceof EReference && !context.getArgumentInformation().isLookupReferenceContainingClass()) return;
		super.addParentDataTypeArguments(context, visitedDataTypes);
	}

	@Override
	public <ArgumentType> void addSuperDataTypeArguments(IArgumentContext<ArgumentType> context,
			Collection<IBindingDataType> visitedDataTypes) {
		if (mySF instanceof EAttribute && !context.getArgumentInformation().isLookupAttributeTargetType()) return;
		if (mySF instanceof EReference && !context.getArgumentInformation().isLookupReferenceTargetType()) return;
		super.addSuperDataTypeArguments(context, visitedDataTypes);
	}

	@Override
	public Class<?> getDataType() {
		return getEType().getInstanceClass();
	}

	@Override
	public EAnnotation getEAnnotation() {
		return mySF.getEAnnotation(Constants.EMF_ANNOTATION_SOURCE);
	}

	@Override
	public IArgumentProvider getArgumentProvider(String type) {
		final IManager manager = IManager.Factory.getManager();
		manager.runModelArgumentMediators(myCls);
		return manager.getModelFeatureInfo(myCls.getInstanceClassName(), mySF.getName(), type, false);
	}

	@Override
	public Object getValueType() {
		return mySF;
	}

	@Override
	public EClassifier getEType() {
		return mySF.getEType();
	}

	@Override
	public String getName() {
		return mySF.getName();
	}

	@Override
	public IBindingDataType getParentDataType() {
		if (myParent == null) {
			myParent = IBindingDataType.Factory.create(null, myCls);
		}
		return myParent;
	}

	@Override
	public boolean isRequired() {
		return mySF.isRequired();
	}

	@Override
	public boolean isChangeable() {
		return mySF.isChangeable() && !EcoreUtil.isSuppressedVisibility(mySF, EcoreUtil.SET);
	}

	@Override
	public boolean isUnsettable() {
		return mySF.isUnsettable();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" + mySF.getContainerClass().getName() + "." //$NON-NLS-1$ //$NON-NLS-2$
				+ mySF.getName() + "]"; //$NON-NLS-1$
	}
}
