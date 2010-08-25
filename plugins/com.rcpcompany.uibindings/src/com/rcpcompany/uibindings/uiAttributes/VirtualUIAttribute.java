package com.rcpcompany.uibindings.uiAttributes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
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

//	private final IDisposeListener myDisposeListener = new IDisposeListener() {
//		@Override
//		public void handleDispose(DisposeEvent event) {
//			LogUtils.debug(event.getSource(), "disposed");
//		}
//	};

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
		Assert.isTrue(!isDisposed());
		return null;
	}

	@Override
	public final void dispose() {
		for (final IObservable v : myObservables) {
//			v.removeDisposeListener(myDisposeListener);
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

	/**
	 * Adds a new observable to the list of observables managed by this attribute.
	 * 
	 * @param observable the new observable
	 * @return the observable
	 */
	protected final IObservableValue addObservable(IObservableValue observable) {
		myObservables.add(observable);
//		observable.addDisposeListener(myDisposeListener);
		if (myListeners != null) {
			for (final IChangeListener myListener : myListeners) {
				if (myListener != null) {
					observable.addChangeListener(myListener);
				}
			}
		}
		return observable;
	}

	/**
	 * Adds a new observable to the list of observables managed by this attribute.
	 * 
	 * @param observable the new observable
	 * @return the observable
	 */
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
