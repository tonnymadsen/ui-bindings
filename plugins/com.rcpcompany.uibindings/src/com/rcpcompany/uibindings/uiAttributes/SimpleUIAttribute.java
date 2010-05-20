package com.rcpcompany.uibindings.uiAttributes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.internal.observables.ControlCursorObservableValue;
import com.rcpcompany.uibindings.internal.observables.StyledTextRangesObservableList;

/**
 * Simple {@link IUIAttribute} implementations used when control, attribute and observable value is known at construct
 * time.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SimpleUIAttribute extends AbstractUIAttribute {
	private final Widget myWidget;
	private final IObservableValue myValue;
	private final List<IObservable> myObservables = new ArrayList<IObservable>();

	private Listener myControlListener = null;

	/**
	 * Constructs and returns new attribute.
	 * <p>
	 * The attribute is marked as not changeable.
	 * 
	 * @param widget the widget
	 * @param attribute the attribute
	 * @param value the observable value
	 */
	public SimpleUIAttribute(Widget widget, String attribute, IObservableValue value) {
		this(widget, attribute, value, false);
	}

	/**
	 * Constructs and returns new attribute.
	 * 
	 * @param widget the widget
	 * @param attribute the attribute
	 * @param value the observable value for the current value of the widget
	 * @param isChangeable the attribute can be changed via the UI
	 */
	public SimpleUIAttribute(Widget widget, String attribute, IObservableValue value, boolean isChangeable) {
		myWidget = widget;
		setAttribute(attribute);
		myValue = value;
		setChangeable(isChangeable);
		addObservable(myValue);

		if (widget instanceof Control) {
			myControlListener = new Listener() {
				@Override
				public void handleEvent(Event event) {
					updateImageDecorations();
				}
			};
			myWidget.addListener(SWT.Resize, myControlListener);

			if (((Control) widget).getSize().x > 0) {
				updateImageDecorations();
			}
		}
	}

	private void updateImageDecorations() {
		if (!(getWidget() instanceof Control)) {
			return;
		}
		final Control c = (Control) getWidget();

		final Point size = c.getSize();
		final int trim = c.getBorderWidth();

		final Rectangle innerBounds = new Rectangle(0, 0, size.x - 2 * trim, size.y - 2 * trim);
		final Rectangle outerBounds = new Rectangle(-trim, -trim, size.x, size.y);

		/*
		 * Special cases...
		 */
		if (c instanceof Combo) {
			innerBounds.x += 1 + 5;
			innerBounds.y += 1 + 5;
			innerBounds.width -= 16 + 2 + 10;
			innerBounds.height -= 2 + 10;
		}

		updateImageDecorations(c, innerBounds, outerBounds);
	}

	@Override
	public final void dispose() {
		for (final IObservable v : myObservables) {
			v.dispose();
		}
		if (myControlListener != null) {
			myWidget.removeListener(SWT.Resize, myControlListener);
		}
		super.dispose();
	}

	/**
	 * Adds an observable that must be disposed when this attribute is disposed.
	 * 
	 * @param observable the observable to dispose
	 * @return the observable itself
	 */
	protected final IObservableValue addObservable(IObservableValue observable) {
		myObservables.add(observable);
		return observable;
	}

	/**
	 * Adds an observable that must be disposed when this attribute is disposed.
	 * 
	 * @param observable the observable to dispose
	 * @return the observable itself
	 */
	protected final IObservableList addObservable(IObservableList observable) {
		myObservables.add(observable);
		return observable;
	}

	@Override
	public Widget getWidget() {
		return myWidget;
	}

	@Override
	public final IObservableValue getCurrentValue() {
		return myValue;
	}

	@Override
	public IObservableValue getTooltipValue() {
		if (myWidget instanceof Control) {
			final Control c = (Control) myWidget;
			return addObservable(SWTObservables.observeTooltipText(c));
		}
		return null;
	}

	@Override
	public IObservableValue getFontValue() {
		if (myWidget instanceof Control) {
			final Control c = (Control) myWidget;
			return addObservable(SWTObservables.observeFont(c));
		}
		return null;
	}

	@Override
	public IObservableValue getCursorValue() {
		if (myWidget instanceof Control) {
			final Control c = (Control) myWidget;
			return addObservable(new ControlCursorObservableValue(c));
		}
		return null;
	}

	@Override
	public IObservableList getStyleRangeList() {
		if (myWidget instanceof StyledText) {
			final StyledText c = (StyledText) myWidget;
			return addObservable(new StyledTextRangesObservableList(c));
		}
		return null;
	}

	@Override
	public IObservableValue getImageValue() {
		if (myWidget instanceof Button) {
			final Button c = (Button) myWidget;
			return addObservable(SWTObservables.observeImage(c));
		}
		if (myWidget instanceof Item) {
			final Item c = (Item) myWidget;
			return addObservable(SWTObservables.observeImage(c));
		}
		if (myWidget instanceof Label) {
			final Label c = (Label) myWidget;
			return addObservable(SWTObservables.observeImage(c));
		}
		if (myWidget instanceof CLabel) {
			final CLabel c = (CLabel) myWidget;
			return addObservable(SWTObservables.observeImage(c));
		}
		return null;
	}

	@Override
	public IObservableValue getForegroundValue() {
		if (myWidget instanceof Control) {
			final Control c = (Control) myWidget;
			return addObservable(SWTObservables.observeForeground(c));
		}
		return null;
	}

	@Override
	public IObservableValue getBackgroundValue() {
		if (myWidget instanceof Control) {
			final Control c = (Control) myWidget;
			return addObservable(SWTObservables.observeBackground(c));
		}
		return null;
	}

	@Override
	public IObservableValue getEnabledValue() {
		if (myWidget instanceof Control) {
			final Control c = (Control) myWidget;
			return addObservable(SWTObservables.observeEnabled(c));
		}
		return null;
	}
}
