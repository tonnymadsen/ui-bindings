package com.rcpcompany.uibindings.compositeform;

/**
 * Abstract base class for {@link ICompositeFormPartOperations}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractCompositeFormPartOperations implements ICompositeFormPartOperations {
	@Override
	public abstract void createUI(ICompositeFormPart part);
}
