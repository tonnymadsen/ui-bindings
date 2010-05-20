package com.rcpcompany.uibindings.uiAttributes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
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
 * This implementation cache the returned values and return the same values again, contrary to the decoration in
 * {@link IUIAttribute}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class VirtualUIAttribute extends AbstractUIAttribute {
	private final IObservableValue myValue;
	private final List<IObservable> myObservables = new ArrayList<IObservable>();
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

	/**
	 * Constructs and returns a new UI Attribute
	 * 
	 * @param valueType the value type
	 */
	public VirtualUIAttribute(Object valueType) {
		myValue = addObservable(WritableValue.withValueType(valueType));
	}

	@Override
	public Widget getWidget() {
		return null;
	}

	@Override
	public final void dispose() {
		for (final IObservable v : myObservables) {
			v.dispose();
		}
		super.dispose();
	}

	protected final IObservableValue addObservable(IObservableValue observable) {
		myObservables.add(observable);
		return observable;
	}

	protected final IObservableList addObservable(IObservableList observable) {
		myObservables.add(observable);
		return observable;
	}

	@Override
	public final IObservableValue getCurrentValue() {
		return myValue;
	}

	@Override
	public IObservableValue getTooltipValue() {
		if (myTooltipValue == null) {
			myTooltipValue = addObservable(WritableValue.withValueType(String.class));
		}
		return myTooltipValue;
	}

	@Override
	public IObservableValue getFontValue() {
		if (myFontValue == null) {
			myFontValue = addObservable(WritableValue.withValueType(Font.class));
		}
		return myFontValue;
	}

	@Override
	public IObservableValue getCursorValue() {
		if (myCursorValue == null) {
			myCursorValue = addObservable(WritableValue.withValueType(Cursor.class));
		}
		return myCursorValue;
	}

	@Override
	public IObservableValue getImageValue() {
		if (myImageValue == null) {
			myImageValue = addObservable(WritableValue.withValueType(Image.class));
		}
		return myImageValue;
	}

	@Override
	public IObservableValue getForegroundValue() {
		if (myForegroundValue == null) {
			myForegroundValue = addObservable(WritableValue.withValueType(Color.class));
		}
		return myForegroundValue;
	}

	@Override
	public IObservableValue getBackgroundValue() {
		if (myBackgroundValue == null) {
			myBackgroundValue = addObservable(WritableValue.withValueType(Color.class));
		}
		return myBackgroundValue;
	}

	@Override
	public IObservableValue getEnabledValue() {
		if (myEnabledValue == null) {
			myEnabledValue = addObservable(WritableValue.withValueType(Boolean.TYPE));
		}
		return myEnabledValue;
	}

	@Override
	public IObservableValue getMinValue() {
		if (myMinValue == null) {
			myMinValue = addObservable(WritableValue.withValueType(Integer.TYPE));
		}
		return myMinValue;
	}

	@Override
	public IObservableValue getMaxValue() {
		if (myMaxValue == null) {
			myMaxValue = addObservable(WritableValue.withValueType(Integer.TYPE));
		}
		return myMaxValue;
	}

	@Override
	public IObservableList getStyleRangeList() {
		if (myStyleRangeList == null) {
			myStyleRangeList = addObservable(WritableList.withElementType(StyleRange.class));
		}
		return myStyleRangeList;
	}
}
