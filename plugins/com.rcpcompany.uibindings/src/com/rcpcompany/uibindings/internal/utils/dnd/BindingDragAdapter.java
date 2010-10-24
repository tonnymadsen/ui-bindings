package com.rcpcompany.uibindings.internal.utils.dnd;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;

/**
 * Implementation of {@link DragSourceListener} for bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class BindingDragAdapter implements DragSourceListener {
	/**
	 * The selection at the start of the drag operation.
	 */
	protected Collection<EObject> mySelection = null;

	/**
	 * This creates an instance for the given viewer.
	 */
	public BindingDragAdapter() {
		super();
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		final IBinding binding = IBindingContext.Factory.getBindingForWidget(event.widget);
		if (binding == null) {
			event.doit = false;
			return;
		}
		mySelection = binding.getSelection();
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		mySelection = null;
		BindingTransfer.getInstance().javaToNative(null, null);
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		if (BindingTransfer.getInstance().isSupportedType(event.dataType)) {
			event.data = mySelection;
		}
	}
}
