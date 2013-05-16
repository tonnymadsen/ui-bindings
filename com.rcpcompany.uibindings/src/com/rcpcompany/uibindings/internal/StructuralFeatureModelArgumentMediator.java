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
package com.rcpcompany.uibindings.internal;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IModelArgumentMediator;
import com.rcpcompany.uibindings.IModelFeatureInfo;

/**
 * {@link IModelArgumentMediator} that will convert annotations on the form
 * "&lt;feature-name&gt;.&lt;argument&gt;=&lt;value&gt;" on the specified class to the corresponding
 * "&lt;argument&gt;=&lt;value&gt;" on the named feature.
 * <p>
 * If the feature does not exist, this is silently ignored.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class StructuralFeatureModelArgumentMediator implements IModelArgumentMediator {

	@Override
	public void mediateArguments(EClassifier classifier) {
		if (!(classifier instanceof EClass)) return;
		final EClass c = (EClass) classifier;
		final EAnnotation annotation = c.getEAnnotation(Constants.EMF_ANNOTATION_SOURCE);
		if (annotation == null) return;
		for (final Entry<String, String> entry : annotation.getDetails().entrySet()) {
			final String key = entry.getKey();
			final int period = key.indexOf('.');
			if (period == -1) {
				continue;
			}
			final String name = key.substring(0, period);
			final EStructuralFeature sf = c.getEStructuralFeature(name);
			if (sf == null) {
				continue;
			}

			final String argName = key.substring(period + 1);
			if (argName.length() == 0) {
				continue;
			}

			final IModelFeatureInfo info = IManager.Factory.getManager().getModelFeatureInfo(c.getInstanceClassName(),
					name, null, true);
			info.getArguments().put(argName.intern(), entry.getValue());
		}
	}
}
