package com.rcpcompany.uibindings.internal;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.ui.IWorkbench;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.rcpcompany.uibindings.model.utils.UIBindingRealm;

/**
 * This class is used with Declarative Services to initialize the workbench related parts of
 * UI-Bindings, when the workbench is present.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@Component
public class DSWorkbench {
	@Reference(unbind = "-")
	public void setWorkbench(IWorkbench workbench) {
		UIBindingRealm.setUIRealm(SWTObservables.getRealm(workbench.getDisplay()));
	}
}
