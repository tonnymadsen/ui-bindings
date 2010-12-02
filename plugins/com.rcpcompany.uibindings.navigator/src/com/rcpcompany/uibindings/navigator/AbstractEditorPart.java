package com.rcpcompany.uibindings.navigator;

/**
 * Abstract version of {@link IEditorPart} used to isolate the sub-class from small future changes.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractEditorPart implements IEditorPart {
	@Override
	public void dispose() {
	}

	@Override
	public boolean canAcceptObjectChanges() {
		return true;
	}
}
