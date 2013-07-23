package com.rcpcompany.updatesite.tests;

import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.agetor.core.utils.ds.DSStore;

@Component
public class DSAgent {
	private static DSStore<IProvisioningAgentProvider> store = DSStore.create(IProvisioningAgentProvider.class);

	/**
	 * @return the factory
	 */
	public static IProvisioningAgentProvider get() {
		return store.get();
	}

	@Reference(unbind = "-")
	public static void setManager(@NonNull IProvisioningAgentProvider obj) {
		store.set(obj);
	}
}
