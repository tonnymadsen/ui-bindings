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
