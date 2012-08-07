package com.rcpcompany.utils.logging.internal;

import java.util.ArrayList;
import java.util.List;

import com.rcpcompany.utils.logging.ITimedTask;
import com.rcpcompany.utils.logging.LogUtils;

public class TimedTask implements ITimedTask {
	private final Object[] myName;
	private final long myStartTime;
	private List<TimedTask> myChildren = null;

	public TimedTask(Object... name) {
		this.myName = name;
		myStartTime = System.nanoTime();
	}

	public String getName() {
		if (myName.length == 1) {
			final Object n = myName[0];
			if (n == null) return "<null>";
			return n.toString();
		}
		final StringBuilder sb = new StringBuilder(200);
		for (final Object n : myName) {
			sb.append(n);
		}
		return sb.toString();
	}

	public ITimedTask subTask(Object... name) {
		final TimedTask child = new TimedTask(name);
		if (myChildren == null) {
			myChildren = new ArrayList<TimedTask>();
		}
		myChildren.add(child);

		return child;
	}

	public void end() {
		final long endTime = System.nanoTime();

		final StringBuilder sb = new StringBuilder(500);

		sb.append('\n');
		sb.append(">> ").append(getName()).append(": 0 ns").append('\n');
		appendChildren(sb, "   ");
		sb.append(">> ").append(getName()).append(": +").append(endTime - myStartTime).append(" ns");

		LogUtils.debug(this, sb.toString());
	}

	private void appendChildren(StringBuilder sb, String prefix) {
		if (myChildren == null) return;

		long prevTime = myStartTime;

		for (final TimedTask c : myChildren) {
			sb.append(prefix).append(">> ").append(c.getName()).append(": +").append(c.myStartTime - myStartTime)
					.append('/').append(c.myStartTime - prevTime).append(" ns\n");
			prevTime = c.myStartTime;
			c.appendChildren(sb, prefix + "   ");
		}
	}
}
