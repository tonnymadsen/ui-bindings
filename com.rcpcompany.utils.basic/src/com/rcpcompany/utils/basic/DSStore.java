package com.rcpcompany.utils.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Simple data store used to make the various adapters more simple and get a common behavior in case of errors.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 * @param <T>
 *            the data type of the store
 */
public class DSStore<T> {
	private final Class<T> myClass;

	/**
	 * Constructs and returns a new DS Store object.
	 * 
	 * @param cls
	 *            the clas of the store
	 * @return the store
	 */
	public static <T> DSStore<T> create(Class<T> cls) {
		return new DSStore<T>(cls);
	}

	private DSStore(Class<T> cls) {
		myClass = cls;
	}

	private final CountDownLatch latch = new CountDownLatch(1);
	private T myObject = null;

	/**
	 * @return the stored object
	 */
	public T get() {
		try {
			if (latch.getCount() > 0 && Thread.currentThread().getName().equals("Component Resolve Thread")) {
				System.err.println("FATAL ERROR");
				System.err.println("FATAL ERROR: Cannot aquire " + myClass.getName() + " in the '"
						+ Thread.currentThread().getName() + "'!");
				System.err.println("FATAL ERROR");

				final Exception exception = new Exception("Stack Trace");
				exception.fillInStackTrace();
				exception.printStackTrace(System.err);

				return null;
			}
			if (!latch.await(10, TimeUnit.SECONDS)) {
				System.err.println("Timeout: Could not get " + myClass.getName());
			}
			return myObject;
		} catch (final Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Sets the stored object.
	 * <p>
	 * May only be called once
	 * 
	 * @param obj
	 *            the object to store - may not be <code>null</code>
	 */
	public void set(T obj) {
		myObject = obj;
		latch.countDown();
	}
}