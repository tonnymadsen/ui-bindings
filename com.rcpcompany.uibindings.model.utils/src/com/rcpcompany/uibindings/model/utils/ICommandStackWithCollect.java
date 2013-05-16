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
package com.rcpcompany.uibindings.model.utils;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CompoundCommand;

/**
 * Extension to {@link BasicCommandStack} that allows for collection of commands into a single
 * {@link CompoundCommand}.
 * 
 * @author "Tonny Madsen, The RCP Company“
 */
public interface ICommandStackWithCollect {

	/**
	 * Sets whether the executed commands should be collected in a single {@link CompoundCommand
	 * compound command} that can be collectively undone and redone.
	 * 
	 * @param collect <code>true</code> if collecting commands
	 */
	public abstract void setCollectCommandMode(boolean collect);

}
