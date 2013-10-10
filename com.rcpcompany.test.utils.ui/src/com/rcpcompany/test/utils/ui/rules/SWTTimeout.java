package com.rcpcompany.test.utils.ui.rules;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.eclipse.swt.widgets.Display;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * The SWTTimeout Rule applies the same timeout to all test methods in a class in exactly the same way as
 * {@link org.junit.rules.Timeout Timeout}.
 * <p>
 * The difference is that this rule works with SWT by evaluating the original statement in the original {@link Thread},
 * whereas {@link org.junit.rules.Timeout Timeout} creates a special {@link Thread} for this. This version requires
 * {@link Display#getDefault()} returns a display.
 * <p>
 * This rule works by
 * <ul>
 * <li>using {@link Display#timerExec(int, Runnable)} to interrupt the UI queue</li>
 * <li>creating a special {@link Thread} to interrupt wait and IO operations</li>
 * </ul>
 * This rule can hang in the same cases as {@link org.junit.rules.Timeout} - if tested {@link Statement} involves an
 * endless loop or a similar operation that never terminates.
 */
public class SWTTimeout implements TestRule {
	/**
	 * The timeout in milliseconds.
	 */
	protected final int myTimeout;

	/**
	 * @param millis
	 *            the millisecond timeout
	 */
	public SWTTimeout(int millis) {
		myTimeout = millis;
	}

	/**
	 * @param timeout
	 *            the timeout
	 * @param unit
	 *            the unit
	 */
	public SWTTimeout(int timeout, TimeUnit unit) {
		this((int) unit.toMillis(timeout));
	}

	@Override
	public Statement apply(Statement base, Description description) {
		return new SWTTimeoutStatement(base, description);
	}

	private class SWTTimeoutStatement extends Statement {
		private final Statement myOriginalStatement;
		private final Description myDescription;
		protected Display myDisplay = null;
		protected volatile boolean inEval = false;

		public SWTTimeoutStatement(Statement originalStatement, Description description) {
			myOriginalStatement = originalStatement;
			myDescription = description;
		}

		@Override
		public void evaluate() throws Throwable {
			myDisplay = Display.getDefault();
			assertNotNull("No Display found. Make sure you run this test in RAP or SWT", myDisplay);
			myDisplay.timerExec(myTimeout, new Runnable() {
				@Override
				public void run() {
					if (inEval)
						throw new TimeoutException();
				}
			});
			final Thread timeoutThread = new Thread() {
				@Override
				public void run() {
					try {
						sleep(myTimeout);
					} catch (final InterruptedException ex) {
						/*
						 * The timeout thread is interrupted when the original statement has been evaluated
						 */
						return;
					}
					final Thread displayThread = myDisplay.getThread();
					if (!inEval || displayThread == null || !displayThread.isAlive())
						return;
					displayThread.interrupt();
				};
			};
			timeoutThread.start();
			try {
				try {
					inEval = true;
					myOriginalStatement.evaluate();
				} finally {
					inEval = false;
					timeoutThread.interrupt();
					timeoutThread.join();
				}
			} catch (final TimeoutException ex) {
				throwTimeoutException(ex, "ui event queue");
			} catch (final InterruptedException ex) {
				throwTimeoutException(ex, "thread interrupted");
			}
		}

		/**
		 * Throws a new exception based on the specified {@link Throwable}.
		 * <p>
		 * Copies over the stack trace.
		 * 
		 * @param ex
		 *            the original exception
		 * @param reason
		 *            the reason for the timeout
		 * @throws Exception
		 *             the new exception
		 */
		private void throwTimeoutException(final Throwable ex, String reason) throws Exception {
			final Exception exception = new Exception(String.format("test timed out after %d milliseconds (%s)",
					myTimeout, reason));
			exception.setStackTrace(ex.getStackTrace());
			throw exception;
		}

		/**
		 * Local exception class used to signal timeout in the UI thread.
		 */
		@SuppressWarnings("serial")
		protected class TimeoutException extends RuntimeException {
		}
	}
}