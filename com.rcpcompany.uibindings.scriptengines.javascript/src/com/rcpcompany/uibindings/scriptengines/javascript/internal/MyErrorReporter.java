/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
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
