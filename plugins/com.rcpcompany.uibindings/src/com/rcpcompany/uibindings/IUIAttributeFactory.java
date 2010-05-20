package com.rcpcompany.uibindings;

import org.eclipse.swt.widgets.Widget;

/**
 * Factory that can create an {@link IUIAttribute} from a specific {@link Widget} and attribute.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IUIAttributeFactory {
	/**
	 * Constructs and returns a new UI Attribute object for the specified widget and attribute.
	 * 
	 * @param widget the widget
	 * @param attribute the attribute of the widget
	 * @return the UI Attribute object
	 */
	public IUIAttribute create(Widget widget, String attribute);
}
