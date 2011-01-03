package com.rcpcompany.uibindings.scriptengines.javascript.internal.wrappers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import com.rcpcompany.uibindings.scriptengines.javascript.internal.JSScriptEngine;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;

/**
 * {@link Scriptable} wrapper for {@link EObject}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EObjectWrapper implements Scriptable {

	private final EObject myEObject;
	private Scriptable myPrototype = null;
	private Scriptable myParentScope = null;

	public EObjectWrapper(Scriptable scope, EObject eObject, Class<?> staticType) {
		myEObject = eObject;
		myParentScope = scope;
	}

	@Override
	public String getClassName() {
		return myEObject.eClass().getName(); // Or instance-name
	}

	@Override
	public Object get(String name, Scriptable start) {
		final EStructuralFeature sf = findFeature(name);
		if (sf == null) return NOT_FOUND;

		final Object v = myEObject.eGet(sf);

		final Context cx = Context.getCurrentContext();
		JSScriptEngine.addDependency(myEObject, sf);
		return cx.getWrapFactory().wrap(cx, this, v, v != null ? v.getClass() : null);
	}

	/**
	 * Returns the structural feature with the specified name or <code>null</code>.-
	 * 
	 * @param name the name of the wanted feature
	 * @return the feature or <code>null</code>
	 */
	private EStructuralFeature findFeature(String name) {
		for (final EStructuralFeature sf : myEObject.eClass().getEAllStructuralFeatures()) {
			if (sf.getName().equals(name)) return sf;
		}
		return null;
	}

	@Override
	public Object get(int index, Scriptable start) {
		return NOT_FOUND;
	}

	@Override
	public boolean has(String name, Scriptable start) {
		final EStructuralFeature sf = findFeature(name);
		return sf != null;
	}

	@Override
	public boolean has(int index, Scriptable start) {
		return false;
	}

	@Override
	public void put(String name, Scriptable start, Object value) {
		// read-only
	}

	@Override
	public void put(int index, Scriptable start, Object value) {
		// read-only
	}

	@Override
	public void delete(String name) {
		// read-only
	}

	@Override
	public void delete(int index) {
		// read-only
	}

	@Override
	public Scriptable getPrototype() {
		if (myPrototype == null) {
			myPrototype = ScriptableObject.getClassPrototype(this.getParentScope(), "Array");
		}
		return myPrototype;
	}

	@Override
	public void setPrototype(final Scriptable prototype) {
		myPrototype = prototype;
	}

	@Override
	public Scriptable getParentScope() {
		return myParentScope;
	}

	@Override
	public void setParentScope(Scriptable parent) {
		myParentScope = parent;
	}

	@Override
	public Object[] getIds() {
		final EList<EStructuralFeature> features = myEObject.eClass().getEAllStructuralFeatures();
		final Object[] ids = new Object[features.size()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = features.get(i).getName();
		}
		return ids;
	}

	@Override
	public Object getDefaultValue(Class<?> hint) {
		final Object value;
		if (hint == null) {
			if (myEObject.eClass() == EcorePackage.Literals.EBOOLEAN) {
				hint = ScriptRuntime.BooleanClass;
			}
		}
		if (hint == null || hint == ScriptRuntime.StringClass)
			return IBindingObjectInformation.Factory.getLongName(myEObject);
		if (hint == ScriptRuntime.BooleanClass) return Boolean.TRUE;
		if (hint == ScriptRuntime.NumberClass) return ScriptRuntime.NaNobj;
		return this;
	}

	@Override
	public boolean hasInstance(Scriptable instance) {
		return false;
	}
}
