/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.compositeform;

/**
 * Factory interface for {@link ICompositeFormPart}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ICompositeFormPartFactory {
	/**
	 * Creates and returns a new set of operations for the specified part.
	 * <p>
	 * The operations will be set on the part automatically.
	 * 
	 * @param part the part
	 * @return the created operations
	 */
	ICompositeFormPartOperations create(ICompositeFormPart part);
}
