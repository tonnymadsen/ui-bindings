package com.rcpcompany.uibindings.internal.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;

/**
 * Property tester for the manager state
 * 
 * TODO TEST
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerPropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Constants.PROPERTY_CAN_UNDO.equals(property)) {
			final EditingDomain ed = IManager.Factory.getManager().getEditingDomain();
			final CommandStack cs = ed.getCommandStack();
			return cs.canUndo();
		}
		if (Constants.PROPERTY_CAN_REDO.equals(property)) {
			final EditingDomain ed = IManager.Factory.getManager().getEditingDomain();
			final CommandStack cs = ed.getCommandStack();
			return cs.canRedo();
		}

		return false;
	}

}
