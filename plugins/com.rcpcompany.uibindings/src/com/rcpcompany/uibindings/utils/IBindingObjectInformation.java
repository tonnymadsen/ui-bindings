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
package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.BindingObjectInformation;

/**
 * Utility class that returns information about a specific object using bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IBindingObjectInformation extends IBindingObjectLongName, IDisposable {
	/**
	 * Factory for {@link IBindingObjectInformation}.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * Returns the long name for the specified object - or "&lt;null&gt;" if <code>null</code>.
		 * 
		 * @param obj the object
		 * @return the name or "&lt;null&gt;"
		 */
		public static String getLongName(EObject obj) {
			final IBindingObjectInformation ln = createObjectInformation(obj, Constants.TYPE_LONG_NAME);
			final String name = ln.getName();
			ln.dispose();
			return name;
		}

		/**
		 * Returns a qualified name for the specified object - or "&lt;null&gt;" if
		 * <code>null</code>.
		 * <p>
		 * A qualified name consists of the type of the object as well as the long name.
		 * 
		 * @param obj the object
		 * @return the name or "&lt;null&gt;"
		 */
		public static String getQualifiedName(EObject obj) {
			final IBindingObjectInformation ln = createObjectInformation(obj, Constants.TYPE_LONG_NAME);
			final String name = ln.getLabel() + " " + ln.getName();
			ln.dispose();
			return name;
		}

		/**
		 * Returns a new long name object for the specified object with the specified binding type.
		 * 
		 * @param obj the object
		 * @param type the binding type
		 * @return long name object
		 */
		public static IBindingObjectInformation createObjectInformation(EObject obj, String type) {
			if (obj == null) return NULL_OI;
			if (Realm.getDefault() == null) return UNKNOWN_OI;
			return new BindingObjectInformation(obj, obj.eClass(), type);
		}

		/**
		 * Returns a new long name object for the specified class.
		 * 
		 * @param cls the class of the information object
		 * @return long name object
		 */
		public static IBindingObjectInformation createObjectInformation(EClass cls) {
			return new BindingObjectInformation(null, cls, null);
		}

		/**
		 * Returns the label for the specified class.
		 * 
		 * @param cls the class
		 * @return the name
		 */
		public static String getLabel(EClass cls) {
			final IBindingObjectInformation ln = new BindingObjectInformation(null, cls, Constants.TYPE_LONG_NAME);
			final String name = ln.getLabel();
			ln.dispose();
			return name;
		}

		/**
		 * Returns the long name for the objects in the specified selection concatenated together.
		 * <p>
		 * If the selection is not a structured selection or it is empty, an empty string is
		 * returned.
		 * <p>
		 * Any objects in the selection that is not an {@link EObject EMF object} is silently
		 * ignored.
		 * 
		 * @param selection the selection
		 * @return the name
		 */
		public static String getLongName(ISelection selection) {
			if (!(selection instanceof IStructuredSelection)) return "";
			final IStructuredSelection s = (IStructuredSelection) selection;
			final StringBuilder sb = new StringBuilder(500);
			for (final Object o : s.toArray()) {
				if (!(o instanceof EObject)) {
					continue;
				}
				final String name = getLongName((EObject) o);
				if (name == null || name.equals("<null>")) {
					continue;
				}
				if (sb.length() > 0) {
					sb.append(", ");
				}
				sb.append(name);
			}
			return sb.toString();
		}
	}

	/**
	 * Returns the current name for this object.
	 * 
	 * @return the name
	 */
	@Override
	String getName();

	/**
	 * Returns the label for the class of this object.
	 * 
	 * @return the name
	 */
	String getLabel();

	/**
	 * Returns the image for this object.
	 * 
	 * @return the image or <code>null</code>
	 */
	Image getImage();

	/**
	 * {@link IBindingObjectInformation} object used for <code>null</code> objects.
	 */
	IBindingObjectInformation NULL_OI = new IBindingObjectInformation() {
		@Override
		public void dispose() {
		}

		@Override
		public String getName() {
			return "<null>";
		}

		@Override
		public String getLabel() {
			return "<null>";
		}

		@Override
		public Image getImage() {
			return null;
		}
	};

	/**
	 * {@link IBindingObjectInformation} object used for <code>unknown</code> objects.
	 * <p>
	 * Also used in thread that does not have a Realm.
	 */
	IBindingObjectInformation UNKNOWN_OI = new IBindingObjectInformation() {
		@Override
		public void dispose() {
		}

		@Override
		public String getName() {
			return "<unknown>";
		}

		@Override
		public String getLabel() {
			return "<unknown>";
		}

		@Override
		public Image getImage() {
			return null;
		}
	};

}
