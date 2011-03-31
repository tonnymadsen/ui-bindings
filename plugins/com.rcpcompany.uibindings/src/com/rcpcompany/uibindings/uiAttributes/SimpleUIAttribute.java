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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.internal.observables.ControlCursorObservableValue;
import com.rcpcompany.uibindings.internal.observables.StyledTextRangesObservableList;

/**
 * Simple {@link IUIAttribute} implementations used when control, attribute and observable value is
 * known at construct time.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SimpleUIAttribute extends AbstractUIAttribute {
	final Widget myWidget;
	private final IObservableValue myValue;
	Listener myControlListener = null;

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

	@Override
	public final void dispose() {
		super.dispose();
		if (myControlListener != null) {
			myWidget.removeListener(SWT.Resize, myControlListener);
			myControlListener = null;
		}
		super.dispose();
	}

	/**
	 * Calculates the inner and out bounds of the control of this attribute and updates the
	 * decorations.
	 */
	private void updateImageDecorations() {
		if (!(getWidget() instanceof Control)) return;
		final Control c = (Control) getWidget();

		final Point size = c.getSize();
		int bw = c.getBorderWidth();
		if (bw == 0) {
			bw = 1;
		}

		final Rectangle innerBounds = new Rectangle(0, 0, size.x, size.y);
		/*
		 * Special cases...
		 */
		if (c instanceof Text) {
			if (Util.isWindows()) {
				innerBounds.width -= 4;
				innerBounds.height -= 4;
				if (bw == 1) {
					bw = 2;
				}
			}
		} else if (c instanceof CCombo) {
			if (Util.isMac()) {
				innerBounds.height -= 2;
				innerBounds.width -= 18;
			} else if (Util.isWindows()) {
				innerBounds.height -= 5;
				innerBounds.width -= 9;
			}
		} else if (c instanceof Combo) {
			if (Util.isMac()) {
				innerBounds.x += 1;
				innerBounds.y += 2;
				innerBounds.width -= 1 + 21;
				innerBounds.height -= 2 + 5;
			} else if (Util.isWindows()) {
				// innerBounds.x += 1 + 5;
				// innerBounds.y += 1 + 5;
				// innerBounds.width -= 16 + 2 + 10;
				// innerBounds.height -= 2 + 10;
			}
		} else if (c instanceof StyledText) {
			if (Util.isMac()) {
				innerBounds.width -= 3;
				innerBounds.height -= 2;
			} else if (Util.isWindows()) {
				innerBounds.height -= 4;
				innerBounds.width -= 4;
			}
		} else if (c instanceof Button) {
			if (Util.isMac()) {
				innerBounds.x += 14;
				innerBounds.y += 5;
				innerBounds.width -= 14 + 14;
				innerBounds.height -= 5 + 9;
			} else if (Util.isWindows()) {
				innerBounds.x += 4;
				innerBounds.y += 2;
				innerBounds.width -= 4 + 8;
				innerBounds.height -= 2 + 9;
			}
		} else if (c instanceof Composite) {
			if (Util.isMac()) {
				innerBounds.width -= 2;
				innerBounds.height -= 2;
			} else if (Util.isWindows()) {
				innerBounds.width -= 5;
				innerBounds.height -= 4;
			}
		}

		final Rectangle outerBounds;
		if (c instanceof Scrollable) {
			final Rectangle trim = ((Scrollable) c).computeTrim(0, innerBounds.y, size.x, innerBounds.height);
			outerBounds = new Rectangle(trim.x, innerBounds.y - bw, trim.width, innerBounds.height + 2 * bw);
		} else {
			outerBounds = new Rectangle(0 - bw, innerBounds.y - bw, size.x + 2 * bw, innerBounds.height + 2 * bw);
		}

		/*
		 * Special cases...
		 */
		if (c instanceof Text) {
			if (Util.isWindows()) {
				outerBounds.x = -bw;
				outerBounds.width = innerBounds.width + 2 * bw;
			}
		} else if (c instanceof Button) {
			if (Util.isMac()) {
				outerBounds.x += 6;
				outerBounds.width -= 6 + 6;
			} else if (Util.isWindows()) {
				outerBounds.width -= 4;
			}
		} else if (c instanceof StyledText) {
			if (Util.isWindows()) {
				outerBounds.width -= 4;
			}
		}

		// IPaintDecoration.Factory.paintRectangle((Control) myWidget, innerBounds,
		// c.getDisplay().getSystemColor(SWT.COLOR_GREEN));
		// IPaintDecoration.Factory.paintRectangle((Control) myWidget, outerBounds,
		// c.getDisplay().getSystemColor(SWT.COLOR_CYAN));

		updateImageDecorations(c, innerBounds, outerBounds);
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
