package com.rcpcompany.uibindings.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.BindingObjectLongName;

/**
 * Utility class that returns the long name for a specific object using bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IBindingObjectLongName extends IDisposable {
	/**
	 * Factory for {@link IBindingObjectLongName}.
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Returns the long name for the specified object - or "&lt;null&gt;" if <code>null</code>.
		 * 
		 * @param obj the object
		 * @return the name or "&lt;null&gt;"
		 */
		public static String getLongName(EObject obj) {
			final IBindingObjectLongName ln = createLongName(obj, Constants.TYPE_LONG_NAME);
			final String name = ln.getName();
			ln.dispose();
			return name;
		}

		/**
		 * Returns a new long name object for the specified object with the specified binding type
		 * 
		 * @param obj the object
		 * @param type the binding type
		 * @return long name object
		 */
		public static IBindingObjectLongName createLongName(EObject obj, String type) {
			return new BindingObjectLongName(obj, type);
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
			final StringBuilder sb = new StringBuilder();
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
	public String getName();
}
