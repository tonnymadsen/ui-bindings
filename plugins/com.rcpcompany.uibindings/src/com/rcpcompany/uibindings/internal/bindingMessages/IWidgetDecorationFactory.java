package com.rcpcompany.uibindings.internal.bindingMessages;

/**
 * Factory to create a {@link IWidgetDecoration}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IWidgetDecorationFactory {
	/**
	 * Constructs and returns a new decoration.
	 * 
	 * @param position the position of the new decoration - TODO
	 * @return the new decoration
	 */
	IWidgetDecoration create(int position);
}
