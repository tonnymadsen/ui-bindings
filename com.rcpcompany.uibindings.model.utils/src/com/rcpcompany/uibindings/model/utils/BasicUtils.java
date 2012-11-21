package com.rcpcompany.uibindings.model.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;

/**
 * Various utility methods.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BasicUtils {
	/**
	 * Variant of {@link EqualityHelper} that ignores containing references...
	 */
	@SuppressWarnings("serial")
	private static class MyEqualityHelper extends EqualityHelper {
		@Override
		public boolean equals(EObject a, EObject b) {
			final boolean res = super.equals(a, b);
			// if (a != null && b != null) {
			// LogUtils.debug(this, "" + ClassUtils.getLastClassName(a) + "@" +
			// System.identityHashCode(a) + " <> "
			// + ClassUtils.getLastClassName(b) + "@" + System.identityHashCode(b) + " ==== " +
			// res);
			// }
			return res;
		}

		@Override
		protected boolean haveEqualReference(EObject eObject1, EObject eObject2, EReference reference) {
			if (reference.isContainer()) return true;
			return super.haveEqualReference(eObject1, eObject2, reference);
		}
	}

	public static final Comparator<Object> OBJECT_COMPARATOR = new Comparator<Object>() {
		@Override
		public int compare(Object sf1, Object sf2) {
			return System.identityHashCode(sf1) - System.identityHashCode(sf2);
		}
	};

	/**
	 * Version of {@link Collections#sort(List, Comparator)} that can be used with {@link EList}
	 * with the unique property.
	 * 
	 * @param list the list to be sorted.
	 * @param c the comparator to determine the order of the list. A <tt>null</tt> value indicates
	 *            that the elements' <i>natural ordering</i> should be used.
	 * @throws ClassCastException if the list contains elements that are not <i>mutually
	 *             comparable</i> using the specified comparator.
	 * @throws UnsupportedOperationException if the specified list's list-iterator does not support
	 *             the <tt>set</tt> operation.
	 * @see Comparator
	 */
	public static <T> void sort(EList<T> list, Comparator<? super T> c) {
		ECollections.sort(list, c);
	}

	/**
	 * Returns whether the two objects are equal or both <code>null</code>.
	 * <p>
	 * See Objects of Guava
	 * 
	 * @param a object a
	 * @param b object b
	 * @return true if a and b are equal or both are <code>null</code>
	 */
	public static boolean equals(Object a, Object b) {
		if (a == b) return true;
		if (a == null) return false;
		return a.equals(b);
	}

	/**
	 * Returns whether the two objects are deeply equal or both <code>null</code>.
	 * <p>
	 * Note that two arrays of the same length, base type and with equals elements are considered
	 * equal.
	 * <p>
	 * Also two collections of the same size and with equal elements are also considered equal.
	 * <p>
	 * And two {@link EObject} are compared using {@link EcoreUtil#equals(EObject, EObject)}.
	 * 
	 * @param a object a
	 * @param b object b
	 * @return true if a and b are equal or both are <code>null</code>
	 */
	public static boolean deepEquals(Object a, Object b) {
		if (a == b) return true;
		if (a == null) return false;
		if (a.getClass().isArray() && b.getClass().isArray()) {
			if (a.getClass() != b.getClass()) return false;
			if (a instanceof Object[] && b instanceof Object[])
				return Arrays.deepEquals((Object[]) a, (Object[]) b);
			else if (a instanceof byte[] && b instanceof byte[])
				return Arrays.equals((byte[]) a, (byte[]) b);
			else if (a instanceof short[] && b instanceof short[])
				return Arrays.equals((short[]) a, (short[]) b);
			else if (a instanceof int[] && b instanceof int[])
				return Arrays.equals((int[]) a, (int[]) b);
			else if (a instanceof long[] && b instanceof long[])
				return Arrays.equals((long[]) a, (long[]) b);
			else if (a instanceof char[] && b instanceof char[])
				return Arrays.equals((char[]) a, (char[]) b);
			else if (a instanceof float[] && b instanceof float[])
				return Arrays.equals((float[]) a, (float[]) b);
			else if (a instanceof double[] && b instanceof double[])
				return Arrays.equals((double[]) a, (double[]) b);
			else if (a instanceof boolean[] && b instanceof boolean[])
				return Arrays.equals((boolean[]) a, (boolean[]) b);
			else
				return false;
		}
		if (a instanceof Collection && b instanceof Collection) {
			final Collection<?> aData = (Collection<?>) a;
			final Collection<?> bData = (Collection<?>) b;
			if (aData.size() != bData.size()) return false;
			final Iterator<?> aIterator = aData.iterator();
			final Iterator<?> bIterator = bData.iterator();
			while (aIterator.hasNext()) {
				if (!deepEquals(aIterator.next(), bIterator.next())) return false;
			}
			return true;
		}
		if (a instanceof EObject && b instanceof EObject) {
			final EqualityHelper equalityHelper = new MyEqualityHelper();
			return equalityHelper.equals(((EObject) a), ((EObject) b));
		}
		return a.equals(b);
	}

	/**
	 * Returns whether the two EObjects are equal or both <code>null</code>.
	 * <p>
	 * This version uses the equality concept from EMF with object keys. I.e. if <code>key</code> is
	 * non-<code>null</code>, it also tests if the key attribute of the objects are
	 * {@link #equals(Object, Object)}. So two objects are "equal" if just the keys are equal.
	 * 
	 * @param a object a
	 * @param b object b
	 * @param key key attribute in objects
	 * @return true if a and b are equal or both are <code>null</code>
	 */
	public static boolean equals(EObject a, EObject b, EAttribute key) {
		if (a == b) return true;
		if (key != null && a != null && b != null) return equals(a.eGet(key), b.eGet(key));
		return deepEquals(a, b);
	}

	/**
	 * Returns whether the two {@link Diagnostic} objects are equal or both <code>null</code>.
	 * 
	 * @param a {@link Diagnostic} object a
	 * @param b {@link Diagnostic} object b
	 * @return true if a and b represent the same {@link Diagnostic} or both are <code>null</code>
	 */
	public static boolean equals(Diagnostic a, Diagnostic b) {
		if (a == b) return true;
		if (a == null) return false;

		if (a.getSeverity() != b.getSeverity()) return false;

		if (!equals(a.getSource(), b.getSource())) return false;
		if (a.getCode() != b.getCode()) return false;

		if (!equals(a.getMessage(), b.getMessage())) return false;
		if (!equals(a.getException(), b.getException())) return false;

		if (!deepEquals(a.getChildren(), b.getChildren())) return false;
		if (!deepEquals(a.getData(), b.getData())) return false;

		return true;
	}

}
