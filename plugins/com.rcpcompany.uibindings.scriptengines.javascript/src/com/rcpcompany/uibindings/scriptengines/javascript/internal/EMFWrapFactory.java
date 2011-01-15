/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.scriptengines.javascript.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.WrapFactory;

import com.rcpcompany.uibindings.scriptengines.javascript.internal.wrappers.EObjectWrapper;
import com.rcpcompany.uibindings.scriptengines.javascript.internal.wrappers.EcoreEListWrapper;

/**
 * Special Wrap Factory that handles EMF objects specially
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EMFWrapFactory extends WrapFactory {

	public EMFWrapFactory() {
		setJavaPrimitiveWrap(true);
	}

	@Override
	public Scriptable wrapAsJavaObject(Context cx, Scriptable scope, Object javaObject, Class<?> staticType) {
		if (javaObject instanceof EcoreEList<?>) {
			return new EcoreEListWrapper(scope, (EcoreEList<?>) javaObject, staticType);
		}
		if (javaObject instanceof EObject) {
			return new EObjectWrapper(scope, (EObject) javaObject, staticType);
		}
		return super.wrapAsJavaObject(cx, scope, javaObject, staticType);
	}
}
