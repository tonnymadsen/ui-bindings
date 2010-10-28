package com.rcpcompany.uibindings.internal.utils.dnd;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.utils.AbstractContextMonitor;
import com.rcpcompany.uibindings.utils.IDnDSupport;

/**
 * Implementation of {@link IDnDSupport}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DnDSupport extends AbstractContextMonitor implements IDnDSupport {
	public static IDnDSupport installOn(IBindingContext context) {
		IDnDSupport support = context.getService(IDnDSupport.class);
		if (support == null) {
			support = new DnDSupport(context);
		}
		return support;
	}

	/**
	 * The supported transfer types...
	 */
	private final Transfer[] myTransferTypes = new Transfer[] { BindingTransfer.getInstance() };

	/**
	 * Constructs and returns a new support object.
	 * 
	 * @param context the context the drag 'n drop support
	 */
	public DnDSupport(IBindingContext context) {
		super(context);

		init();
	}

	@Override
	protected void bindingAdded(IBinding binding) {
		final Control control = binding.getControl();
		if (control == null) return;

		/*
		 * Only when the object of the binding is capable
		 */
		DragSourceListener dragListener = null;
		dragListener = new BindingDragAdapter();
		if (dragListener != null) {
			final DragSource dragSource = new DragSource(control, DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK);
			dragSource.setTransfer(myTransferTypes);
			dragSource.addDragListener(dragListener);
			binding.registerService(dragListener);
		}

		DropTargetListener dropListener = null;
		if (binding instanceof IViewerBinding) {
			final IViewerBinding vb = (IViewerBinding) binding;
			dropListener = new ViewerBindingDropAdapter(vb);
		}

		if (dropListener != null) {
			final DropTarget dropTarget = new DropTarget(control, DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK);
			dropTarget.setTransfer(myTransferTypes);
			dropTarget.addDropListener(dropListener);
			binding.registerService(dropListener);
		}
	}

	@Override
	protected void bindingRemoved(IBinding binding) {
		// TODO Auto-generated method stub
		super.bindingRemoved(binding);
	}

}
