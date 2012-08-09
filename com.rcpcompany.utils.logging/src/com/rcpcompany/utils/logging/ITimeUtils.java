package com.rcpcompany.utils.logging;

import java.util.HashMap;
import java.util.Map;

/**
 * To be decomented...
 * 
 * @author "Tonny Madsen, The RCP Company�
 */
public interface ITimeUtils {
	public static class Factory {
		private Factory() {
		}

		private static int i = 0;

		public static void run(Runnable r) {
			final String ANON = "anon" + (i++);
			start(ANON);
			run(ANON, r);
			end(ANON);
		}

		private static Map<String, Long> accumulatedTimes = new HashMap<String, Long>();

		public static void start(String name) {
			accumulatedTimes.put(name, Long.valueOf(0));
		}

		public static void run(String name, Runnable r) {
			Long l = accumulatedTimes.get(name);
			if (l == null) {
				start(name);
				l = accumulatedTimes.get(name);
			}
			final long startTime = System.nanoTime();
			try {
				r.run();
			} finally {
				final long endTime = System.nanoTime();
				l += (endTime - startTime);
				accumulatedTimes.put(name, l);
			}
		}

		public static void end(String name) {
			final Long l = accumulatedTimes.remove(name);
			if (l == null) // LogUtils.error(null, "No time by name '" + name +
							// "'");
				return;
			final int oldLevels = LogUtils.DEBUG_STRACK_LEVELS;
			LogUtils.DEBUG_STRACK_LEVELS = 0;
			// LogUtils.debug(null, name + ": " + l + " ns");
			LogUtils.DEBUG_STRACK_LEVELS = oldLevels;
		}
	}
}
