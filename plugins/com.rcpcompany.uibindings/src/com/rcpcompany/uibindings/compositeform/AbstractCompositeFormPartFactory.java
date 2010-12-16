package com.rcpcompany.uibindings.compositeform;

/**
 * Abstract base class for {@link ICompositeFormPartFactory}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractCompositeFormPartFactory implements ICompositeFormPartFactory {
	@Override
	public abstract ICompositeFormPartOperations create(ICompositeFormPart part);
}
