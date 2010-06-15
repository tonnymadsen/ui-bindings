package com.rcpcompany.uibindings.internal.observables.properties;

import org.eclipse.core.databinding.property.IProperty;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.NativePropertyListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;

class MySelectionChangedListener extends NativePropertyListener implements ISelectionChangedListener {
	MySelectionChangedListener(IProperty property, ISimplePropertyListener listener) {
		super(property, listener);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		fireChange(event.getSource(), null);
	}

	@Override
	public void doAddTo(Object source) {
		((ISelectionProvider) source).addSelectionChangedListener(this);
	}

	@Override
	public void doRemoveFrom(Object source) {
		((ISelectionProvider) source).removeSelectionChangedListener(this);
	}
}
