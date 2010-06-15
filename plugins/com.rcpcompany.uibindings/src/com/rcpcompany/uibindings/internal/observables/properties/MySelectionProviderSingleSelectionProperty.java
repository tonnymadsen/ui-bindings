package com.rcpcompany.uibindings.internal.observables.properties;

import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.jface.databinding.viewers.ViewerValueProperty;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;

/**
 * 
 */
public class MySelectionProviderSingleSelectionProperty extends ViewerValueProperty {
	@Override
	public Object getValueType() {
		return null;
	}

	@Override
	protected Object doGetValue(Object source) {
		final ISelection selection = ((ISelectionProvider) source).getSelection();
		if (selection instanceof IStructuredSelection) return ((IStructuredSelection) selection).getFirstElement();
		return null;
	}

	@Override
	protected void doSetValue(Object source, Object value) {
		final IStructuredSelection selection = value == null ? StructuredSelection.EMPTY : new StructuredSelection(
				value);
		if (source instanceof Viewer) {
			((Viewer) source).setSelection(selection, true);
		} else {
			((ISelectionProvider) source).setSelection(selection);
		}
	}

	@Override
	public INativePropertyListener adaptListener(ISimplePropertyListener listener) {
		return new MySelectionChangedListener(this, listener);
	}

	@Override
	public String toString() {
		return "ISelectionProvider.selection"; //$NON-NLS-1$
	}
}
