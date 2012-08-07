package com.rcpcompany.utils.logging.internal;

import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * Bridge from {@link Logger} to {@link LogUtils}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class Log4JBridge implements ILogBridge {
	private final Appender myAppender = new MyAppender();

	@Override
	public void init() {
		Logger.getRootLogger().addAppender(myAppender);
	}

	@Override
	public void dispose() {
		Logger.getRootLogger().removeAppender(myAppender);
	}

	private class MyAppender extends AppenderSkeleton {
		@Override
		public void close() {
		}

		@Override
		public boolean requiresLayout() {
			return false;
		}

		@Override
		protected void append(LoggingEvent event) {
			if (event.getLevel() == Level.WARN || event.getLevel() == Level.ERROR || event.getLevel() == Level.FATAL) {
				LogUtils.error(event.getLogger(), "" + event.getMessage(), event.getThrowableInformation()
						.getThrowable());
			} else {
				LogUtils.debug(event.getLogger(), "" + event.getMessage());
			}
		}
	}
}
