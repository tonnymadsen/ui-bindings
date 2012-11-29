package com.rcpcompany.uibindings.model.utils;

import java.util.concurrent.TimeUnit;

import org.eclipse.core.databinding.observable.Realm;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Simple Utility class that can provide a useful {@link Realm}.
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
public class UIBindingRealm {
	private static SettableFuture<Realm> theUIRealm = SettableFuture.create();

	/**
	 * Returns the default realm for use with databinding
	 * 
	 * @return the realm
	 */
	public static Realm getUIRealm() {
		try {
			final Realm realm = theUIRealm.get(10, TimeUnit.SECONDS);
			LogUtils.debug(theUIRealm, "" + realm);
			return realm;
		} catch (final Exception ex) {
			LogUtils.error(theUIRealm, ex);
			return null;
		}
	}

	public static void setUIRealm(Realm r) {
		LogUtils.debug(theUIRealm, "" + r);
		theUIRealm.set(r);
	}

	/**
	 * Executes the specified {@link Runnable} in the {@link Realm} when it is available.
	 * 
	 * @param runnable the runnable to execute
	 */
	public static void asyncExec(final Runnable runnable) {
		theUIRealm.addListener(new Runnable() {
			@Override
			public void run() {
				LogUtils.debug(theUIRealm, "" + runnable);
				getUIRealm().asyncExec(runnable);
			}
		}, MoreExecutors.sameThreadExecutor());
	}
}
