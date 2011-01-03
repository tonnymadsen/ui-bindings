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
		if (javaObject instanceof EcoreEList<?>)
			return new EcoreEListWrapper(scope, (EcoreEList<?>) javaObject, staticType);
		if (javaObject instanceof EObject) return new EObjectWrapper(scope, (EObject) javaObject, staticType);
		return super.wrapAsJavaObject(cx, scope, javaObject, staticType);
	}
}
