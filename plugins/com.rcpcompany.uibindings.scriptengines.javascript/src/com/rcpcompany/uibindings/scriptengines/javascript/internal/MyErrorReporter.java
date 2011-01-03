package com.rcpcompany.uibindings.scriptengines.javascript.internal;

import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link ErrorReporter} used by UI Bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MyErrorReporter implements ErrorReporter {
	@Override
	public void warning(String message, String sourceName, int line, String lineSource, int lineOffset) {
		// TODO make use of String sourceName, int line, String lineSource, int lineOffset
		LogUtils.error(this, message);
	}

	@Override
	public void error(String message, String sourceName, int line, String lineSource, int lineOffset) {
		// TODO make use of String sourceName, int line, String lineSource, int lineOffset
		LogUtils.error(this, message);
	}

	@Override
	public EvaluatorException runtimeError(String message, String sourceName, int line, String lineSource,
			int lineOffset) {
		return new EvaluatorException(message, sourceName, line, lineSource, lineOffset);
	}
}
