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
	 * Creates and returns a new part for the specified form.
	 * <p>
	 * the part will be added to the part automatically.
	 * 
	 * @param form the form of the new part
	 * @return the created part
	 */
	ICompositeFormPart create(ICompositeForm form);
}
