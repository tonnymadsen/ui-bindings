package com.rcpcompany.utils.logging;

import java.util.HashMap;
import java.util.Map;

import com.rcpcompany.utils.logging.internal.TimedTask;

/**
 * To be decomented...
 * 
 * @author "Tonny Madsen, The RCP Company�
 */
public interface ITimedTask {
	public static class Factory {
		private Factory() {
		}

		private static Map<String, Long> accumulatedTimes = new HashMap<String, Long>();

		public static ITimedTask start(Object... name) {
			return new TimedTask(name);
		}
	}

	ITimedTask subTask(Object... name);

	void end();
}
