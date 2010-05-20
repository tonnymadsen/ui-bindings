package com.rcpcompany.uibindings.utils;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

/**
 * Abstact base class for {@link IControlDecoration}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractControlDecoration implements IControlDecoration {

	@Override
	public abstract Control getControl();

	@Override
	public abstract Image getImage();

	@Override
	public abstract Point getLocation();

	@Override
	public String getTooltip() {
		return null;
	}
}
