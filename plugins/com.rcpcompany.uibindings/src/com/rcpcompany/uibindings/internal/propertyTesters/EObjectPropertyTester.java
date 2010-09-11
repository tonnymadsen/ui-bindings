package com.rcpcompany.uibindings.internal.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Property tester for {@link EObject}.
 * 
 * TODO TEST
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EObjectPropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
			LogUtils.debug(this, Constants.PREFIX + property + "(" + receiver + ")");
		}
		if (!(receiver instanceof EObject)) return false;
		final EObject obj = (EObject) receiver;

		if (Constants.PROPERTY_CAN_DELETE.equals(property)) {
			final EditingDomain ed = IManager.Factory.getManager().getEditingDomain();
			final Command cmd = DeleteCommand.create(ed, obj);
			return cmd.canExecute();
		}

		return false;
	}

}
