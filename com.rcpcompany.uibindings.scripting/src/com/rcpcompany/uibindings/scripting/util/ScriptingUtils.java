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
package com.rcpcompany.uibindings.scripting.util;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.scripting.IFeatureScript;
import com.rcpcompany.uibindings.scripting.IScriptingFactory;

/**
 * Various utility method for scripting...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class ScriptingUtils {
	private ScriptingUtils() {
	}

	/**
	 * Returns the feature script for the specified object and feature - optionally create it if needed.
	 * 
	 * @param moao the object of the feature script
	 * @param feature the feature of the feature script
	 * @return the script if it exists or should be created or <code>null</code> otherwise
	 */
	public static IFeatureScript getFeatureScript(final IMOAO moao, EStructuralFeature feature, boolean create) {

		if (moao.eIsSet(IMOAOPackage.Literals.MOAO__FACETS)) {
			for (final IMOAOFacet f : moao.getFacets()) {
				if (!(f instanceof IFeatureScript)) {
					continue;
				}
				final IFeatureScript fs = (IFeatureScript) f;
				if (fs.getFeature() != feature) {
					break;
				}

				return fs;
			}
		}

		if (!create) {
			return null;
		}

		final IFeatureScript fs = IScriptingFactory.eINSTANCE.createFeatureScript();
		fs.setObject(moao);
		fs.setFeature(feature);

		return fs;
	}
}
