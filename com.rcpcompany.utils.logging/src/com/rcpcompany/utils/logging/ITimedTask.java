package com.rcpcompany.utils.logging;

import java.util.HashMap;
import java.util.Map;

import com.rcpcompany.utils.logging.internal.TimedTask;

/**
 * To be documented...
 * 
 * TODO: make configurable
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ITimedTask {
	public static class Factory {
		private Factory() {
		}

		private static Map<String, Long> accumulatedTimes = new HashMap<String, Long>();

		public static ITimedTask start(Object... name) {
			if (!ENABLED)
				return TimedTask.NULL_TASK;
			return new TimedTask(name);
		}
	}

	/**
	 * Used to disable the generation of timed reports.
	 */
	public boolean ENABLED = false;

	ITimedTask subTask(Object... name);

	void end();
}
