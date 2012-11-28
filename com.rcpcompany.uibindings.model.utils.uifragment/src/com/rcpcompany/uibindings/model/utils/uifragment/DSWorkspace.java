package com.rcpcompany.uibindings.model.utils.uifragment;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.ui.IWorkbench;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.rcpcompany.uibindings.model.utils.UIBindingRealm;

@Component
public class DSWorkspace {
	@Reference
	public void setWorkbench(IWorkbench w) {
		final Realm realm = SWTObservables.getRealm(w.getDisplay());
		UIBindingRealm.setUIRealm(realm);
	}
}
