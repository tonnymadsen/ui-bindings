package com.rcpcompany.uibindings.internal.utils.dnd;

import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.utils.IDnDSupport;

/**
 * Implementation of {@link IDnDSupport}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DnDSupport implements IDnDSupport {

	/**
	 * Constructs and returns a new support object.
	 * 
	 * @param vb the viewer of the drag 'n drop support
	 */
	public DnDSupport(IViewerBinding vb) {
		final Transfer[] transferTypes = new Transfer[] { BindingTransfer.getInstance() };
		final Control control = vb.getControl();

//		final DragSource dragSource = new DragSource(control, DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK);
//		dragSource.setTransfer(transferTypes);
//		dragSource.addDragListener(new ViewerDragAdapter(vb.getViewer()));
//
//		final DropTarget dropTarget = new DropTarget(control, DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK);
//		dropTarget.setTransfer(transferTypes);
//		dropTarget.addDropListener(new EditingDomainViewerDropAdapter(vb.getEditingDomain(), null));
	}

	@Override
	public void dispose() {
	}

}
