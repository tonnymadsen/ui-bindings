package com.rcpcompany.test.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.IProgressMonitor;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * Test {@link IProgressMonitor}.
 * 
 * @author Tonny Madsen, tonny.madsen@gmail.com
 */
public class MonitoredMonitor implements IProgressMonitor {

	public MonitoredMonitor() {
		this(false);
	}

	public MonitoredMonitor(boolean sysout) {
		doSysout = sysout;
		myPrefix = getClass().getSimpleName() + "@" + System.identityHashCode(this);
	}

	private final String myPrefix;
	MonitorState myState = MonitorState.INIT;
	private int myTotalWork;
	private int myWorkDone = 0;
	private boolean myCanceled = false;
	private int mySubTasks = 0;
	private final boolean doSysout;

	enum MonitorState {
		INIT, OPEN, DONE
	}

	@Override
	public void beginTask(String name, int totalWork) {
		assertEquals(MonitorState.INIT, myState);
		myState = MonitorState.OPEN;
		myTotalWork = totalWork;
		if (doSysout) {
			LogUtils.debug(this, myPrefix + ": '" + name + "' (" + totalWork + ")");
		}
	}

	public void checkOK() {
		assertEquals(MonitorState.DONE, myState);
	}

	@Override
	public void done() {
		assertEquals(MonitorState.OPEN, myState);
		myState = MonitorState.DONE;
		if (doSysout) {
			LogUtils.debug(this, myPrefix);
		}
	}

	@Override
	public void internalWorked(double work) {
		assertEquals(MonitorState.OPEN, myState);
	}

	@Override
	public boolean isCanceled() {
		return myCanceled;
	}

	@Override
	public void setCanceled(boolean value) {
		myCanceled = value;
	}

	@Override
	public void setTaskName(String name) {
		if (doSysout) {
			LogUtils.debug(this, myPrefix + ": '" + name + "'");
		}
		assertEquals(MonitorState.OPEN, myState);
	}

	@Override
	public void subTask(String name) {
		if (doSysout) {
			LogUtils.debug(this, myPrefix + ": '" + name + "'");
		}
		mySubTasks++;
		assertEquals(MonitorState.OPEN, myState);
	}

	@Override
	public void worked(int work) {
		assertEquals(MonitorState.OPEN, myState);
		myWorkDone += work;
		if (myTotalWork != IProgressMonitor.UNKNOWN) {
			assertTrue(myWorkDone <= myTotalWork);
		}
		if (doSysout) {
			LogUtils.debug(this, myPrefix + ": " + myWorkDone + "/"
					+ (myTotalWork == IProgressMonitor.UNKNOWN ? "unknown" : "" + myTotalWork));
		}
	}

	public int getSubTasks() {
		return mySubTasks;
	}
}