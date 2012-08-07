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
 * Exception for {@link IScriptEngineDescriptor} relation exceptions.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScriptEngineException extends ScriptException {
	private static final long serialVersionUID = -3671207730868829327L;

	public ScriptEngineException() {
		super();
	}

	public ScriptEngineException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScriptEngineException(String message) {
		super(message);
	}

	public ScriptEngineException(Throwable cause) {
		super(cause);
	}
}
