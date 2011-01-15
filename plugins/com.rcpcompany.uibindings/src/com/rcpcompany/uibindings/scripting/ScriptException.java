/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.scripting;

/**
 * Common top-level exception for all script-related exceptioons.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class ScriptException extends Exception {
	private static final long serialVersionUID = 7739754446385917917L;

	public ScriptException() {
		super();
	}

	public ScriptException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScriptException(String message) {
		super(message);
	}

	public ScriptException(Throwable cause) {
		super(cause);
	}
}
