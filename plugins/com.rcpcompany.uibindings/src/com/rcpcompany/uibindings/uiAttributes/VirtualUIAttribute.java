/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.uiAttributes;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;

/**
 * Virtual {@link IUIAttribute} implementations used when no control exists.
 * <p>
 * This implementation cache the returned values and return the same values again, contrary to the
 * decoration in {@link IUIAttribute}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class VirtualUIAttribute extends AbstractUIAttribute {
	private final IObservableValue myValue;
	private IObservableValue myTooltipValue;
	private IObservableValue myFontValue;
	private IObservableValue myCursorValue;
	private IObservableValue myImageValue;
	private IObservableValue myForegroundValue;
	private IObservableValue myBackgroundValue;
	private IObservableValue myEnabledValue;
	private IObservableValue myMinValue;
	private IObservableValue myMaxValue;
	private IObservableList myStyleRangeList;

	// private final IDisposeListener myDisposeListener = new IDisposeListener() {
	// @Override
	// public void handleDispose(DisposeEvent event) {
	// LogUtils.debug(event.getSource(), "disposed");
	// }
	// };

	/**
	 * Constructs and returns a new UI Attribute.
	 * 
	 * @param valueType the value type
	 */
	public VirtualUIAttribute(Object valueType) {
		myValue = addObservable(WritableValue.withValueType(valueType));
		setChangeable(true);
	}

	@Override
	public Widget getWidget() {
		Assert.isTrue(!isDisposed());
		return null;
	}

	@Override
	public final IObservableValue getCurrentValue() {
		Assert.isTrue(!isDisposed());
		return myValue;
	}

	@Override
	public IObservableValue getTooltipValue() {
		Assert.isTrue(!isDisposed());
		if (myTooltipValue == null) {
			myTooltipValue = addObservable(WritableValue.withValueType(String.class));
		}
		Assert.isTrue(!myTooltipValue.isDisposed());
		return myTooltipValue;
	}

	@Override
	public String getTooltip() {
		Assert.isTrue(!isDisposed());
		if (myTooltipValue == null) return null;
		Assert.isTrue(!myTooltipValue.isDisposed());
		return (String) myTooltipValue.getValue();
	}

	@Override
	public IObservableValue getFontValue() {
		Assert.isTrue(!isDisposed());
		if (myFontValue == null) {
			myFontValue = addObservable(WritableValue.withValueType(Font.class));
		}
		Assert.isTrue(!myFontValue.isDisposed());
		return myFontValue;
	}

	@Override
	public Font getFont() {
		Assert.isTrue(!isDisposed());
		if (myFontValue == null) return null;
		Assert.isTrue(!myFontValue.isDisposed());
		return (Font) myFontValue.getValue();
	}

	@Override
	public IObservableValue getCursorValue() {
		Assert.isTrue(!isDisposed());
		if (myCursorValue == null) {
			myCursorValue = addObservable(WritableValue.withValueType(Cursor.class));
		}
		Assert.isTrue(!myCursorValue.isDisposed());
		return myCursorValue;
	}

	@Override
	public Cursor getCursor() {
		Assert.isTrue(!isDisposed());
		if (myCursorValue == null) return null;
		return (Cursor) myCursorValue.getValue();
	}

	@Override
	public IObservableValue getImageValue() {
		Assert.isTrue(!isDisposed());
		if (myImageValue == null) {
			myImageValue = addObservable(WritableValue.withValueType(Image.class));
		}
		Assert.isTrue(!myImageValue.isDisposed());
		return myImageValue;
	}

	@Override
	public Image getImage() {
		Assert.isTrue(!isDisposed());
		if (myImageValue == null) return null;
		Assert.isTrue(!myImageValue.isDisposed());
		return (Image) myImageValue.getValue();
	}

	@Override
	public IObservableValue getForegroundValue() {
		Assert.isTrue(!isDisposed());
		if (myForegroundValue == null) {
			myForegroundValue = addObservable(WritableValue.withValueType(Color.class));
		}
		Assert.isTrue(!myForegroundValue.isDisposed());
		return myForegroundValue;
	}

	@Override
	public Color getForeground() {
		Assert.isTrue(!isDisposed());
		if (myForegroundValue == null) return null;
		return (Color) myForegroundValue.getValue();
	}

	@Override
	public IObservableValue getBackgroundValue() {
		Assert.isTrue(!isDisposed());
		if (myBackgroundValue == null) {
			myBackgroundValue = addObservable(WritableValue.withValueType(Color.class));
		}
		Assert.isTrue(!myBackgroundValue.isDisposed());
		return myBackgroundValue;
	}

	@Override
	public Color getBackground() {
		Assert.isTrue(!isDisposed());
		if (myBackgroundValue == null) return null;
		return (Color) myBackgroundValue.getValue();
	}

	@Override
	public IObservableValue getEnabledValue() {
		Assert.isTrue(!isDisposed());
		if (myEnabledValue == null) {
			myEnabledValue = addObservable(WritableValue.withValueType(Boolean.TYPE));
		}
		Assert.isTrue(!myEnabledValue.isDisposed());
		return myEnabledValue;
	}

	@Override
	public Boolean isEnabled() {
		Assert.isTrue(!isDisposed());
		if (myEnabledValue == null) return null;
		return (Boolean) myEnabledValue.getValue();
	}

	@Override
	public IObservableValue getMinValue() {
		Assert.isTrue(!isDisposed());
		if (myMinValue == null) {
			myMinValue = addObservable(WritableValue.withValueType(Integer.TYPE));
		}
		Assert.isTrue(!myMinValue.isDisposed());
		return myMinValue;
	}

	@Override
	public IObservableValue getMaxValue() {
		Assert.isTrue(!isDisposed());
		if (myMaxValue == null) {
			myMaxValue = addObservable(WritableValue.withValueType(Integer.TYPE));
		}
		Assert.isTrue(!myMaxValue.isDisposed());
		return myMaxValue;
	}

	@Override
	public IObservableList getStyleRangeList() {
		Assert.isTrue(!isDisposed());
		if (myStyleRangeList == null) {
			myStyleRangeList = addObservable(WritableList.withElementType(StyleRange.class));
		}
		Assert.isTrue(!myStyleRangeList.isDisposed());
		return myStyleRangeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StyleRange> getStyleRanges() {
		Assert.isTrue(!isDisposed());
		if (myStyleRangeList == null) return null;
		return myStyleRangeList;
	}
}
