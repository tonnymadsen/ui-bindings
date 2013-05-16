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

package com.rcpcompany.uibindings.scriptengines.javascript.internal.wrappers;

import org.eclipse.emf.ecore.util.EcoreEList;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeJavaArray;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

import com.rcpcompany.uibindings.scriptengines.javascript.internal.JSScriptEngine;

/**
 * JavaScript wrapper of read-only {@link EcoreEList}.
 * <p>
 * Loosely based on {@link NativeJavaArray}.
 */
public class EcoreEListWrapper implements Scriptable {
	/**
	 * The list wrapped by this wrapper
	 */
	private final EcoreEList<?> myList;
	private Scriptable myPrototype = null;
	private Scriptable myParentScope;

	public EcoreEListWrapper(Scriptable scope, EcoreEList<?> javaObject, Class<?> staticType) {
		myList = javaObject;
		myParentScope = scope;
	}

	@Override
	public String getClassName() {
		return "EList";
	}

	@Override
	public Object get(String name, Scriptable start) {
		if ("length".equals(name)) {
			JSScriptEngine.addDependency(myList.getEObject(), myList.getEStructuralFeature());
			return myList.size();
		}
		return NOT_FOUND;
	}

	@Override
	public Object get(int index, Scriptable start) {
		try {
			final Context cx = Context.getCurrentContext();
			final Object obj = myList.get(index);
			JSScriptEngine.addDependency(myList.getEObject(), myList.getEStructuralFeature(), index);
			return cx.getWrapFactory().wrap(cx, this, obj, obj != null ? obj.getClass() : null);
		} catch (final IndexOutOfBoundsException ex) {
			return Undefined.instance;
		}
	}

	@Override
	public boolean has(String name, Scriptable start) {
		if ("length".equals(name)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean has(int index, Scriptable start) {
		return (0 <= index && index < myList.size());
	}

	@Override
	public void put(String name, Scriptable start, Object value) {
		// Read-only
	}

	@Override
	public void put(int index, Scriptable start, Object value) {
		// Read-only
	}

	@Override
	public void delete(String name) {
		// Read-only
	}

	@Override
	public void delete(int index) {
		// Read-only
	}

	@Override
	public Scriptable getPrototype() {
		if (myPrototype == null) {
			myPrototype = ScriptableObject.getClassPrototype(this.getParentScope(), "Array");
		}
		return myPrototype;
	}

	@Override
	public void setPrototype(Scriptable prototype) {
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
		final Object[] result = new Object[myList.size()];
		int i = myList.size();
		while (--i >= 0) {
			result[i] = new Integer(i);
		}
		return result;
	}

	@Override
	public Object getDefaultValue(Class<?> hint) {
		if (hint == null || hint == ScriptRuntime.StringClass) {
			return myList.toString();
		}
		if (hint == ScriptRuntime.BooleanClass) {
			return Boolean.TRUE;
		}
		if (hint == ScriptRuntime.NumberClass) {
			return ScriptRuntime.NaNobj;
		}
		return this;
	}

	@Override
	public boolean hasInstance(Scriptable instance) {
		return false;
	}
}
