package com.rcpcompany.uibindings.navigator;

/**
 * Abstract {@link IEditorPartFactory}.
 * <p>
 * This class is used to isolate sub-classes from trivial changes,.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractEditorPartFactory implements IEditorPartFactory {
	@Override
	public abstract IEditorPart createEditorPart(IEditorPartContext context);
}
