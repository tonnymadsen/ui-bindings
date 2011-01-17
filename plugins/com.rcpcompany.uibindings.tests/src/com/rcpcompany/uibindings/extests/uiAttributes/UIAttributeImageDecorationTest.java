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
package com.rcpcompany.uibindings.extests.uiAttributes;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeImageDecoration;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;
import com.rcpcompany.uibindings.utils.IPaintDecoration;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Test of image decorations.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class UIAttributeImageDecorationTest<T extends Control> {
	private final DecorationPosition myPosition;
	private final boolean myOutside;
	private final int myX;
	private final int myY;
	private final float myAddWidthFactor;
	private final float myAddHeightFactor;
	private final Class<T> myWidgetClass;
	private final String what;
	private final int myBorderWidth;

	@Parameters
	public static Collection<Object[]> data() {
		final List<Object[]> filtered = new ArrayList<Object[]>();

		final List<Object[]> c = Arrays.asList(new Object[][] {

				/*
				 * widgetClass, outside, xLeft, xRight, yTop, yCenter, yBottom, borderWidth,
				 * isEnabled
				 */

				// Text

				{ Text.class, false, 0, 0, 0, 0, 0, 0, true },

				{ Text.class, true, 0, 0, 0, 0, 0, 0, Util.isMac() },
				{ Text.class, true, 6, -6, 1, 0, -1, 0, Util.isWindows() },

				// Combo

				/*
				 * INNER on Windows: does not seem to work!
				 */
				{ Combo.class, false, 1, -21, 2, -1, -5, 0, Util.isMac() },
				{ Combo.class, true, 0, 0, 2, -1, -5, 0, Util.isMac() },
				{ Combo.class, true, 0, 0, 0, 0, 0, 0, Util.isWindows() },

				// CCombo

				/*
				 * INNER NOT POSSIBLE due to the way the inner controls are protected, so we cannot
				 * add a paint listsner
				 */
				// { CCombo.class, false, 0, 0, 0, 0, 0, 0, true },
				{ CCombo.class, true, 0, 0, 0, -1, -2, 0, Util.isMac() },
				{ CCombo.class, true, 2, 2, 1, 0, -2, 0, Util.isWindows() },

				// StyledText

				{ StyledText.class, false, 0, -3, 0, -1, -2, 0, Util.isMac() },
				{ StyledText.class, false, 0, 0, 0, 0, 0, 0, Util.isWindows() },
				{ StyledText.class, true, 0, 0, 0, -1, -2, 0, Util.isMac() },
				{ StyledText.class, true, 2, -2, 1, 0, -1, 0, Util.isWindows() },

				// Button

				{ Button.class, false, 14, -14, 5, -2, -9, 0, Util.isMac() },
				{ Button.class, false, 4, -4, 2, -1, -5, 0, Util.isWindows() },
				{ Button.class, true, 5, -5, 5, -2, -9, 0, Util.isMac() },
				{ Button.class, true, 0, 0, 3, -1, -6, 0, Util.isWindows() },

				// Composite

				{ Composite.class, false, 0, -2, 0, -1, -2, 0, Util.isMac() },
				{ Composite.class, false, 0, -1, 0, 0, 0, 0, Util.isWindows() },
				{ Composite.class, true, 0, 0, 0, -1, -2, 0, Util.isMac() },
				{ Composite.class, true, 2, 2, 1, 0, -1, 0, Util.isWindows() },

		});

		for (final Object[] e : c) {
			if (e[8] == Boolean.FALSE) {
				continue;
			}
			final Class<?> widgetClass = (Class<?>) e[0];
			final boolean outside = (Boolean) e[1];
			final int xLeft = (Integer) e[2];
			final int xRight = (Integer) e[3];
			final int yTop = (Integer) e[4];
			final int yCenter = (Integer) e[5];
			final int yBottom = (Integer) e[6];
			final int borderWidth = (Integer) e[7];

			if (!outside) {
				filtered.add(new Object[] { widgetClass, DecorationPosition.TOP_LEFT, outside, xLeft - 0, yTop, 0.0f,
						0.0f, borderWidth, true });
				filtered.add(new Object[] { widgetClass, DecorationPosition.TOP_RIGHT, outside,
						-SQUARE_SIZE + xRight + 0, yTop, 1.0f, 0.0f, borderWidth, true });

				filtered.add(new Object[] { widgetClass, DecorationPosition.CENTER_LEFT, outside, xLeft - 0,
						-SQUARE_SIZE / 2 + yCenter, 0.0f, 0.5f, borderWidth, true });
				filtered.add(new Object[] { widgetClass, DecorationPosition.CENTER_RIGHT, outside,
						-SQUARE_SIZE + xRight + 0, -SQUARE_SIZE / 2 + yCenter, 1.0f, 0.5f, borderWidth, true });

				filtered.add(new Object[] { widgetClass, DecorationPosition.BOTTOM_LEFT, outside, xLeft - 0,
						-SQUARE_SIZE + yBottom, 0.0f, 1.0f, borderWidth, true });
				filtered.add(new Object[] { widgetClass, DecorationPosition.BOTTOM_RIGHT, outside,
						-SQUARE_SIZE + xRight + 0, -SQUARE_SIZE + yBottom, 1.0f, 1.0f, borderWidth, true });
			} else {
				filtered.add(new Object[] { widgetClass, DecorationPosition.TOP_LEFT, outside,
						xLeft - SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, yTop, 0.0f, 0.0f,
						borderWidth, true });
				filtered.add(new Object[] { widgetClass, DecorationPosition.TOP_RIGHT, outside,
						xRight + IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, yTop, 1.0f, 0.0f, borderWidth, true });

				filtered.add(new Object[] { widgetClass, DecorationPosition.CENTER_LEFT, outside,
						xLeft - SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH,
						-SQUARE_SIZE / 2 + yCenter, 0.0f, 0.5f, borderWidth, true });
				filtered.add(new Object[] { widgetClass, DecorationPosition.CENTER_RIGHT, outside,
						xRight + IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2 + yCenter, 1.0f,
						0.5f, borderWidth, true });

				filtered.add(new Object[] { widgetClass, DecorationPosition.BOTTOM_LEFT, outside,
						xLeft - SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE + yBottom,
						0.0f, 1.0f, borderWidth, true });
				filtered.add(new Object[] { widgetClass, DecorationPosition.BOTTOM_RIGHT, outside,
						xRight + IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE + yBottom, 1.0f, 1.0f,
						borderWidth, true });
			}
		}

		final List<Object[]> l = Arrays.asList(new Object[][] {

		/*
		 * widgetClass, position, outside, x, y, addWidthFactor, addHeightFactor, borderWidth,
		 * isEnabled
		 */

		});

		for (final Object[] e : l) {
			if (e[8] == Boolean.FALSE) {
				continue;
			}
			filtered.add(e);
		}

		return filtered;
	}

	public UIAttributeImageDecorationTest(Class<T> widgetClass, final DecorationPosition position,
			final boolean outside, final int x, final int y, final float addWidth, final float addHeight,
			final int borderWidth, boolean isEnabled) {
		myWidgetClass = widgetClass;
		myPosition = position;
		myOutside = outside;
		myX = x;
		myY = y;
		myAddWidthFactor = addWidth;
		myAddHeightFactor = addHeight;
		myBorderWidth = borderWidth;

		what = myWidgetClass.getSimpleName() + ": p=" + myPosition + " outside=" + myOutside + " [" + myX + ";" + myY
				+ "] bw=" + myBorderWidth;

		LogUtils.debug(this, "========== " + what);
	}

	private static final int SQUARE_SIZE = 8;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createView();
		yield();

		myOV = WritableValue.withValueType(String.class);
		myAttribute = new SimpleUIAttribute(myWidget, null, myOV);

		myView.getSite().getPage().activate(myView);
	}

	private TestView myView;
	private Composite myBody;
	private T myWidget;

	private WritableValue myOV;
	private IUIAttribute myAttribute;

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		try {
			final Constructor<T> constructor = myWidgetClass.getConstructor(Composite.class, Integer.TYPE);
			assertNotNull(what, constructor);

			myWidget = constructor.newInstance(myBody, SWT.BORDER);

			final GridData ld = new GridData(SWT.CENTER, SWT.CENTER, true, true);
			ld.widthHint = 100;
			// ld.heightHint = 20;
			myWidget.setLayoutData(ld);

			myBody.layout();
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	protected final RGB white = new RGB(255, 255, 255);

	protected final RGB rgb1 = new RGB(90, 100, 110);
	protected final RGB rgb2 = new RGB(190, 100, 110);
	protected final Image myImage1 = UIBindingsUtils.getSquareImage(rgb1, SQUARE_SIZE);
	protected final Image myImage2 = UIBindingsUtils.getSquareImage(rgb2, SQUARE_SIZE);

	@Test
	public void testOneImage() {
		int x = myX;
		int y = myY;

		final Point size = myWidget.getSize();
		final int bw = myWidget.getBorderWidth();

		// LogUtils.debug(myWidget, myAttribute + ": s=" + size + ", trim=" + bw + ", ca="
		// + (myWidget instanceof Scrollable ? ((Scrollable) myWidget).getClientArea() : null));

		if (myOutside) {
			if (myWidget instanceof Scrollable) {
				final Scrollable s = (Scrollable) myWidget;

				final Rectangle r = s.computeTrim(0, 0, size.x, size.y);
				x += r.x;
				size.x = r.width;
			}
			size.y += 2;

			x -= bw;
			y -= bw + 1;
		} else {
			size.x -= 2 * bw;
			size.y -= 2 * bw;
		}

		x += myAddWidthFactor * size.x;
		y += myAddHeightFactor * size.y;

		final Display display = myWidget.getDisplay();
		final Rectangle r2 = new Rectangle(x - 1, y - 1, SQUARE_SIZE + 1, SQUARE_SIZE + 1);
		IPaintDecoration.Factory.paintRectangle(myWidget, r2, display.getSystemColor(SWT.COLOR_DARK_RED));

		testImage(myPosition, myOutside, x, y);
	}

	public void testImage(DecorationPosition position, boolean outside, int x, int y) {
		final IUIAttributeImageDecoration decoration = myAttribute.getImageDecoration(position, outside);

		decoration.getImageValue().setValue(myImage1);
		sleep(100);
		testSquare(x, y, rgb1);

		decoration.getImageValue().setValue(myImage2);
		sleep(100);
		testSquare(x, y, rgb2);
	}

	/**
	 * @param x
	 * @param y
	 * @param rgb TODO
	 */
	private void testSquare(final int x, final int y, RGB rgb) {
		yield();

		/*
		 * Test that the background color is white - the top-left corner
		 */
		assertPixelColor(what + " - body", myBody, 0, 0, white);

		/*
		 * Test that the complete square is visible
		 */
		for (int dx = 0; dx < SQUARE_SIZE; dx++) {
			for (int dy = 0; dy < SQUARE_SIZE; dy++) {
				assertTranslatedPixel(x + dx, y + dy, rgb);
			}
		}
	}

	/**
	 * @param x
	 * @param y
	 * @param rgb
	 */
	private void assertTranslatedPixel(final int x, final int y, RGB rgb) {
		final Point p = myWidget.getDisplay().map(myWidget, myBody, x, y);
		assertPixelColor(what + " - inner", myBody, p.x, p.y, rgb);
	}
}
