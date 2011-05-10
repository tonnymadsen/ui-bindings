package com.rcpcompany.utils.logging.internal;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * Bridge from {@link Logger} to {@link LogUtils}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class LoggerBridge implements ILogBridge {
	private final Handler myLoggerBridge = new LoggerHandler();

	@Override
	public void init() {
		final Logger l = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		l.addHandler(myLoggerBridge);
	}

	@Override
	public void dispose() {
		final Logger l = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		l.removeHandler(myLoggerBridge);
	}

	private class LoggerHandler extends Handler {
		@Override
		public void publish(LogRecord record) {
			if (record.getLevel() == Level.WARNING || record.getLevel() == Level.SEVERE) {
				LogUtils.error(this, record.getMessage(), record.getThrown());
			} else {
				LogUtils.debug(this, record.getMessage());
			}
		}

		@Override
		public void flush() {
		}

		@Override
		public void close() throws SecurityException {
		}
	}

}
