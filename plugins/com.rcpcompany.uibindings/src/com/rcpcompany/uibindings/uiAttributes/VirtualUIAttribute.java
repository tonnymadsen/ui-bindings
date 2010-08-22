package com.rcpcompany.uibindings.uiAttributes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.IChangeListener;
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
 * This implementation cache the returned values and return the same values again, contrary to the
 * decoration in {@link IUIAttribute}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class VirtualUIAttribute extends AbstractUIAttribute {
	private final IObservableValue myValue;
	// TODO consider changing this to array
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
	 * Constructs and returns a new UI Attribute.
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
			if (myListeners != null) {
				for (final IChangeListener myListener : myListeners) {
					if (myListener != null) {
						v.removeChangeListener(myListener);
					}
				}
			}
		}
		super.dispose();
	}

	/**
	 * All observable listeners for this object goes via this...
	 */
	private IChangeListener[] myListeners = null;

	/**
	 * Adds the specified change listener to all the observable values of this attribute.
	 * 
	 * @param listener the listener to add
	 */
	public void addChangeListener(IChangeListener listener) {
		int i = -1;
		if (myListeners == null) {
			// The standard case is exactly one listener
			myListeners = new IChangeListener[1];
			i = 0;
		} else {
			final int l = myListeners.length;
			for (int n = 0; n < l; n++) {
				if (myListeners[n] == null) {
					i = n;
					break;
				}
			}
			if (i == -1) {
				final IChangeListener[] newListeners = new IChangeListener[l + 2];
				System.arraycopy(myListeners, 0, newListeners, 0, l);
				myListeners = newListeners;
				i = l;
			}
		}

		myListeners[i] = listener;
		for (final IObservable o : myObservables) {
			o.addChangeListener(listener);
		}
	}

	/**
	 * Removes the specified change listener from all the observable values of this attribute.
	 * 
	 * @param listener the listener to remove
	 */
	public void removeChangeListener(IChangeListener listener) {
		if (myListeners == null) return;
		for (int n = 0; n < myListeners.length; n++) {
			if (myListeners[n] == listener) {
				myListeners[n] = null;
				break;
			}
		}
		for (final IObservable o : myObservables) {
			o.removeChangeListener(listener);
		}
	};

	protected final IObservableValue addObservable(IObservableValue observable) {
		myObservables.add(observable);
		if (myListeners != null) {
			for (final IChangeListener myListener : myListeners) {
				if (myListener != null) {
					observable.addChangeListener(myListener);
				}
			}
		}
		return observable;
	}

	protected final IObservableList addObservable(IObservableList observable) {
		myObservables.add(observable);
		if (myListeners != null) {
			for (final IChangeListener myListener : myListeners) {
				if (myListener != null) {
					observable.addChangeListener(myListener);
				}
			}
		}
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
	public Cursor getCursor() {
		if (myCursorValue == null) return null;
		return (Cursor) myCursorValue.getValue();
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
	public Color getForeground() {
		if (myForegroundValue == null) return null;
		return (Color) myForegroundValue.getValue();
	}

	@Override
	public IObservableValue getBackgroundValue() {
		if (myBackgroundValue == null) {
			myBackgroundValue = addObservable(WritableValue.withValueType(Color.class));
		}
		return myBackgroundValue;
	}

	@Override
	public Color getBackground() {
		if (myBackgroundValue == null) return null;
		return (Color) myBackgroundValue.getValue();
	}

	@Override
	public IObservableValue getEnabledValue() {
		if (myEnabledValue == null) {
			myEnabledValue = addObservable(WritableValue.withValueType(Boolean.TYPE));
		}
		return myEnabledValue;
	}

	@Override
	public Boolean isEnabled() {
		if (myEnabledValue == null) return null;
		return (Boolean) myEnabledValue.getValue();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<StyleRange> getStyleRanges() {
		if (myStyleRangeList == null) return null;
		return myStyleRangeList;
	}
}
