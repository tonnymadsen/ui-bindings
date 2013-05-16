/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.bindingDataTypes;

import java.util.ArrayList;
import java.util.List;

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
	protected <ArgumentType> void addEAnnotationArguments(IArgumentContext<ArgumentType> context) {
		final EClass ctype = mySF.getEContainingClass();
		if (myCls == ctype) {
			super.addEAnnotationArguments(context);
			return;
		}

		/*
		 * Look for the annotations on the class with the combined name "<sf>.<argument>".
		 */
		final EAnnotation annotation = myCls.getEAnnotation(Constants.EMF_ANNOTATION_SOURCE);
		if (annotation == null) return;
		final String value = annotation.getDetails().get(mySF.getName() + "." + context.getName());
		if (value == null) return;

		IManager.Factory.getManager().addArgumentValue(context, this, null, null, value);
	}

	@Override
	public <ArgumentType> void addParentDataTypeArguments(IArgumentContext<ArgumentType> context) {
		if (mySF instanceof EAttribute && !context.getArgumentInformation().isLookupAttributeContainingClass()) return;
		if (mySF instanceof EReference && !context.getArgumentInformation().isLookupReferenceContainingClass()) return;
		super.addParentDataTypeArguments(context);
	}

	@Override
	public <ArgumentType> void addSuperDataTypeArguments(IArgumentContext<ArgumentType> context) {
		if (mySF instanceof EAttribute && !context.getArgumentInformation().isLookupAttributeTargetType()) return;
		if (mySF instanceof EReference && !context.getArgumentInformation().isLookupReferenceTargetType()) return;
		super.addSuperDataTypeArguments(context);
	}

	private List<IBindingDataType> mySuperClassesDTs = null;

	@Override
	public <ArgumentType> void addSFSuperContainingClassArguments(IArgumentContext<ArgumentType> context) {
		final EClass ctype = mySF.getEContainingClass();
		if (myCls == ctype) return;
		if (mySuperClassesDTs == null) {
			mySuperClassesDTs = new ArrayList<IBindingDataType>();
			/*
			 * If the class of this data type is not the containing class for the structural
			 * feature, then we go through the super classes of the class of this data type and add
			 * then as arguments, if the containing class is a super class of the class.
			 * 
			 * So assume we have the classes A sub-class of B sub-class of C and the attribute
			 * C.attr. Then the data type for A.attr will add arguments for A.attr, B.attr and
			 * C.attr in that sequence.
			 */
			final IBindingDataType clsDT = IBindingDataType.Factory.create(null, myCls);
			final IBindingDataType[] superTypes = IBindingDataType.Factory.getSuperTypes(clsDT);
			for (final IBindingDataType dt : superTypes) {
				if (dt == clsDT) {
					continue;
				}

				if (!(dt.getEType() instanceof EClass)) {
					continue;
				}
				final EClass stype = (EClass) dt.getEType();
				if (!ctype.isSuperTypeOf(stype)) {
					continue;
				}

				mySuperClassesDTs.add(IBindingDataType.Factory.create(stype, mySF));
			}
		}
		for (final IBindingDataType dt : mySuperClassesDTs) {
			dt.addArguments(context);
			if (context.isResultFound()) return;
		}

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
	public String getBaseType() {
		return myCls.getName() + "." + mySF.getName(); //$NON-NLS-1$ 
	}
}
