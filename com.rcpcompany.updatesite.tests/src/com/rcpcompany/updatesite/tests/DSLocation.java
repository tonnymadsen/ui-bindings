package com.rcpcompany.updatesite.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.rcpcompany.utils.basic.DSStore;

@Component
public class DSLocation {
	private static DSStore<Location> store = DSStore.create(Location.class);

	/**
	 * @return the factory
	 */
	public static Location get() {
		return store.get();
	}

	@Reference(target = "(type=osgi.instance.area)", unbind = "-")
	public static void setManager(@NonNull Location obj) {
		store.set(obj);
	}
}
