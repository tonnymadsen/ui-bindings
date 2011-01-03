/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Rhino code, released
 * May 6, 1999.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by the Initial Developer are Copyright (C) 1997-1999
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Norris Boyd
 *   Igor Bukanov
 *   Frank Mitchell
 *   Mike Shaver
 *   Kemal Bayram
 *
 * Alternatively, the contents of this file may be used under the terms of
 * the GNU General Public License Version 2 or later (the "GPL"), in which
 * case the provisions of the GPL are applicable instead of those above. If
 * you wish to allow use of your version of this file only under the terms of
 * the GPL and not to allow others to use your version of this file under the
 * MPL, indicate your decision by deleting the provisions above and replacing
 * them with the notice and other provisions required by the GPL. If you do
 * not delete the provisions above, a recipient may use your version of this
 * file under either the MPL or the GPL.
 *
 * ***** END LICENSE BLOCK ***** */

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
		if ("length".equals(name)) return true;
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
		if (hint == null || hint == ScriptRuntime.StringClass) return myList.toString();
		if (hint == ScriptRuntime.BooleanClass) return Boolean.TRUE;
		if (hint == ScriptRuntime.NumberClass) return ScriptRuntime.NaNobj;
		return this;
	}

	@Override
	public boolean hasInstance(Scriptable instance) {
		return false;
	}
}
