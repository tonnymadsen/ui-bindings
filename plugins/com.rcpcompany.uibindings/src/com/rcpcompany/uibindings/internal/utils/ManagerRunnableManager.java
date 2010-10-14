package com.rcpcompany.uibindings.internal.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.PlatformUI;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.uibindings.utils.IManagerRunnableManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link IManagerRunnableManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerRunnableManager implements IManagerRunnableManager {

	public ManagerRunnableManager() {
		IManager.Factory.getManager().registerService(this);
	}

	@Override
	public void dispose() {
		/*
		 * Cancel all...
		 */
		for (final Record r : myRecords.toArray(new Record[myRecords.size()])) {
			r.cancel();
		}
		IManager.Factory.getManager().unregisterService(this);
	}

	@Override
	public void asyncExec(String type, Object key, Runnable runnable) {
		Record r = findRecord(type, key);

		if (r != null) {
			r.replaceRunnable(runnable);
			return;
		}
		r = new Record(type, key, runnable);

		startDisplayRunnable();
	}

	@Override
	public boolean isEmpty() {
		return myRecords.isEmpty();
	}

	/**
	 * Starts a new Display runnable if needed.
	 */
	private void startDisplayRunnable() {
		if (displayRunnableAdded) return;

		displayRunnableAdded = true;
		PlatformUI.getWorkbench().getDisplay().asyncExec(displayRunnable);
	}

	boolean displayRunnableAdded = false;

	Runnable displayRunnable = new Runnable() {
		@Override
		public void run() {
			displayRunnableAdded = false;
			final long start = System.currentTimeMillis();

			while (!isEmpty() && (System.currentTimeMillis() - start < MAX_TIME)) {
				final Record r = myRecords.get(0);
				try {
					r.run();
				} catch (final Exception ex) {
					LogUtils.error(r.runnable, ex);
				}
			}

			if (!isEmpty()) {
				startDisplayRunnable();
			}
		}
	};

	@Override
	public void cancelAsyncExec(String type, Object key) {
		final Record r = findRecord(type, key);
		if (r != null) {
			r.cancel();
		}
	}

	private Record findRecord(String type, Object key) {
		if (type == null) return null;
		for (final Record r : myRecords) {
			if (UIBindingsUtils.equals(type, r.type) && UIBindingsUtils.equals(key, r.key)) return r;
		}

		return null;
	}

	/**
	 * All registered records.
	 */
	private final List<Record> myRecords = new ArrayList<Record>();

	/**
	 * Record of a singæle registered {@link Runnable}.
	 */
	public class Record {
		String type;
		Object key;
		Runnable runnable;

		public Record(String type, Object key, Runnable runnable) {
			this.type = type;
			this.key = key;
			this.runnable = runnable;

			myRecords.add(this);
		}

		/**
		 * Cancels this record.
		 */
		public void run() {
			myRecords.remove(this);

			try {
				runnable.run();
			} catch (final Exception ex) {
				LogUtils.error(runnable, ex);
			}

			if (runnable instanceof IManagerRunnable) {

			}
		}

		/**
		 * Replaces the current {@link Runnable} with a new.
		 * 
		 * @param newRunnable the new runnable
		 */
		public void replaceRunnable(Runnable newRunnable) {
			final Runnable oldRunnable = runnable;

			runnable = newRunnable;

			if (oldRunnable instanceof IManagerRunnable) {

			}
		}

		/**
		 * Cancels this record.
		 */
		public void cancel() {
			myRecords.remove(this);

			if (runnable instanceof IManagerRunnable) {

			}
		}
	}

}
