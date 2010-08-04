package com.rcpcompany.uibindings.extests.uiAttributes;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
	private final float myAddWidth;
	private final float myAddHeight;
	private final Class<T> myWidgetClass;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] {

						/*
						 * widgetClass, position, outside, x, y, addWidth, addHeight
						 */

						// Text - Inner

						{ Text.class, DecorationPosition.TOP_LEFT, false, 0, 0, 0.0f, 0.0f },
						{ Text.class, DecorationPosition.TOP_RIGHT, false, -SQUARE_SIZE, 0, 1.0f, 0.0f },

						{ Text.class, DecorationPosition.CENTER_LEFT, false, 0, -SQUARE_SIZE / 2, 0.0f, 0.5f },
						{ Text.class, DecorationPosition.CENTER_RIGHT, false, -SQUARE_SIZE, -SQUARE_SIZE / 2, 1.0f,
								0.5f },

						{ Text.class, DecorationPosition.BOTTOM_LEFT, false, 0, -SQUARE_SIZE, 0.0f, 1.0f },
						{ Text.class, DecorationPosition.BOTTOM_RIGHT, false, -SQUARE_SIZE, -SQUARE_SIZE, 1.0f, 1.0f },

						// Text - Outer

						{ Text.class, DecorationPosition.TOP_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 0.0f, 0.0f },
						{ Text.class, DecorationPosition.TOP_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 1.0f, 0.0f },

						{ Text.class, DecorationPosition.CENTER_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 0.0f,
								0.5f },
						{ Text.class, DecorationPosition.CENTER_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 1.0f, 0.5f },

						{ Text.class, DecorationPosition.BOTTOM_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 0.0f, 1.0f },
						{ Text.class, DecorationPosition.BOTTOM_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 1.0f, 1.0f },

						// Combo - inner

						// { Combo.class, DecorationPosition.TOP_LEFT, false, 0, 0, 0.0f, 0.0f },
						// { Combo.class, DecorationPosition.TOP_RIGHT, false, -SQUARE_SIZE, 0,
						// 1.0f, 0.0f },
						//
						// { Combo.class, DecorationPosition.CENTER_LEFT, false, 0, -SQUARE_SIZE /
						// 2, 0.0f, 0.5f },
						// { Combo.class, DecorationPosition.CENTER_RIGHT, false, -SQUARE_SIZE,
						// -SQUARE_SIZE / 2, 1.0f,
						// 0.5f },
						//
						// { Combo.class, DecorationPosition.BOTTOM_LEFT, false, 0, -SQUARE_SIZE,
						// 0.0f, 1.0f },
						// { Combo.class, DecorationPosition.BOTTOM_RIGHT, false, -SQUARE_SIZE,
						// -SQUARE_SIZE, 1.0f, 1.0f
						// },

						// Combo - outer

						{ Combo.class, DecorationPosition.TOP_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 0.0f, 0.0f },
						{ Combo.class, DecorationPosition.TOP_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 1.0f, 0.0f },

						{ Combo.class, DecorationPosition.CENTER_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 0.0f,
								0.5f },
						{ Combo.class, DecorationPosition.CENTER_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 1.0f, 0.5f },

						{ Combo.class, DecorationPosition.BOTTOM_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 0.0f, 1.0f },
						{ Combo.class, DecorationPosition.BOTTOM_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 1.0f, 1.0f },

						// CCombo - inner

						// { CCombo.class, DecorationPosition.TOP_LEFT, false, 0, 0, 0.0f, 0.0f },
						// { CCombo.class, DecorationPosition.TOP_RIGHT, false, -SQUARE_SIZE, 0,
						// 1.0f, 0.0f },
						//
						// { CCombo.class, DecorationPosition.CENTER_LEFT, false, 0, -SQUARE_SIZE /
						// 2, 0.0f, 0.5f },
						// { CCombo.class, DecorationPosition.CENTER_RIGHT, false, -SQUARE_SIZE,
						// -SQUARE_SIZE / 2, 1.0f,
						// 0.5f },
						//
						// { CCombo.class, DecorationPosition.BOTTOM_LEFT, false, 0, -SQUARE_SIZE,
						// 0.0f, 1.0f },
						// { CCombo.class, DecorationPosition.BOTTOM_RIGHT, false, -SQUARE_SIZE,
						// -SQUARE_SIZE, 1.0f,
						// 1.0f },

						// CCombo - outer

						{ CCombo.class, DecorationPosition.TOP_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 0.0f, 0.0f },
						{ CCombo.class, DecorationPosition.TOP_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 1.0f, 0.0f },

						{ CCombo.class, DecorationPosition.CENTER_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 0.0f,
								0.5f },
						{ CCombo.class, DecorationPosition.CENTER_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 1.0f, 0.5f },

						{ CCombo.class, DecorationPosition.BOTTOM_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 0.0f, 1.0f },
						{ CCombo.class, DecorationPosition.BOTTOM_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 1.0f, 1.0f },

						// StyledText - inner

						{ StyledText.class, DecorationPosition.TOP_LEFT, false, 0, 0, 0.0f, 0.0f },
						{ StyledText.class, DecorationPosition.TOP_RIGHT, false, -SQUARE_SIZE, 0, 1.0f, 0.0f },

						{ StyledText.class, DecorationPosition.CENTER_LEFT, false, 0, -SQUARE_SIZE / 2, 0.0f, 0.5f },
						{ StyledText.class, DecorationPosition.CENTER_RIGHT, false, -SQUARE_SIZE, -SQUARE_SIZE / 2,
								1.0f, 0.5f },

						{ StyledText.class, DecorationPosition.BOTTOM_LEFT, false, 0, -SQUARE_SIZE, 0.0f, 1.0f },
						{ StyledText.class, DecorationPosition.BOTTOM_RIGHT, false, -SQUARE_SIZE, -SQUARE_SIZE, 1.0f,
								1.0f },

						// StyledText - outer

						{ StyledText.class, DecorationPosition.TOP_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 0.0f, 0.0f },
						{ StyledText.class, DecorationPosition.TOP_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 1.0f, 0.0f },

						{ StyledText.class, DecorationPosition.CENTER_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 0.0f,
								0.5f },
						{ StyledText.class, DecorationPosition.CENTER_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 1.0f, 0.5f },

						{ StyledText.class, DecorationPosition.BOTTOM_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 0.0f, 1.0f },
						{ StyledText.class, DecorationPosition.BOTTOM_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 1.0f, 1.0f },

						// Button - inner

						{ Button.class, DecorationPosition.TOP_LEFT, false, 0, 0, 0.0f, 0.0f },
						{ Button.class, DecorationPosition.TOP_RIGHT, false, -SQUARE_SIZE, 0, 1.0f, 0.0f },

						{ Button.class, DecorationPosition.CENTER_LEFT, false, 0, -SQUARE_SIZE / 2, 0.0f, 0.5f },
						{ Button.class, DecorationPosition.CENTER_RIGHT, false, -SQUARE_SIZE, -SQUARE_SIZE / 2, 1.0f,
								0.5f },

						{ Button.class, DecorationPosition.BOTTOM_LEFT, false, 0, -SQUARE_SIZE, 0.0f, 1.0f },
						{ Button.class, DecorationPosition.BOTTOM_RIGHT, false, -SQUARE_SIZE, -SQUARE_SIZE, 1.0f, 1.0f },

						// Button - outer

						{ Button.class, DecorationPosition.TOP_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 0.0f, 0.0f },
						{ Button.class, DecorationPosition.TOP_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 1.0f, 0.0f },

						{ Button.class, DecorationPosition.CENTER_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 0.0f,
								0.5f },
						{ Button.class, DecorationPosition.CENTER_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 1.0f, 0.5f },

						{ Button.class, DecorationPosition.BOTTOM_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 0.0f, 1.0f },
						{ Button.class, DecorationPosition.BOTTOM_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 1.0f, 1.0f },

						// Composite - inner

						{ Composite.class, DecorationPosition.TOP_LEFT, false, 0, 0, 0.0f, 0.0f },
						{ Composite.class, DecorationPosition.TOP_RIGHT, false, -SQUARE_SIZE, 0, 1.0f, 0.0f },

						{ Composite.class, DecorationPosition.CENTER_LEFT, false, 0, -SQUARE_SIZE / 2, 0.0f, 0.5f },
						{ Composite.class, DecorationPosition.CENTER_RIGHT, false, -SQUARE_SIZE, -SQUARE_SIZE / 2,
								1.0f, 0.5f },

						{ Composite.class, DecorationPosition.BOTTOM_LEFT, false, 0, -SQUARE_SIZE, 0.0f, 1.0f },
						{ Composite.class, DecorationPosition.BOTTOM_RIGHT, false, -SQUARE_SIZE, -SQUARE_SIZE, 1.0f,
								1.0f },

						// Composite - outer

						{ Composite.class, DecorationPosition.TOP_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 0.0f, 0.0f },
						{ Composite.class, DecorationPosition.TOP_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, 0, 1.0f, 0.0f },

						{ Composite.class, DecorationPosition.CENTER_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 0.0f,
								0.5f },
						{ Composite.class, DecorationPosition.CENTER_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE / 2, 1.0f, 0.5f },

						{ Composite.class, DecorationPosition.BOTTOM_LEFT, true,
								-SQUARE_SIZE - IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 0.0f, 1.0f },
						{ Composite.class, DecorationPosition.BOTTOM_RIGHT, true,
								IUIAttributeImageDecoration.OUTER_MARGIN_WIDTH, -SQUARE_SIZE, 1.0f, 1.0f },

				});
	}

	public UIAttributeImageDecorationTest(Class<T> widgetClass, final DecorationPosition position,
			final boolean outside, final int x, final int y, final float addWidth, final float addHeight) {
		myWidgetClass = widgetClass;
		myPosition = position;
		myOutside = outside;
		myX = x;
		myY = y;
		myAddWidth = addWidth;
		myAddHeight = addHeight;
	}

	private static final int SQUARE_SIZE = 8;

	@Before
	public void before() {
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createView();

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
			assertNotNull(constructor);

			myWidget = constructor.newInstance(myBody, SWT.BORDER);
			final GridData ld = new GridData(SWT.CENTER, SWT.CENTER, true, true);
			ld.widthHint = 100;
			ld.heightHint = 20;
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
		final int trim = myWidget.getBorderWidth();

		if (myOutside) {
			x -= trim;
			y -= trim;
		} else {
			size.x -= 2 * trim;
			size.y -= 2 * trim;
		}

		x += myAddWidth * size.x;
		y += myAddHeight * size.y;
		testImage(myPosition, myOutside, x, y);
	}

	public void testImage(DecorationPosition position, boolean outside, int x, int y) {
		final IUIAttributeImageDecoration decoration = myAttribute.getImageDecoration(position, outside);

		decoration.getImageValue().setValue(myImage1);
		testSquare(x, y, rgb1);

		decoration.getImageValue().setValue(myImage2);
		testSquare(x, y, rgb2);
	}

	/**
	 * @param x
	 * @param y
	 * @param rgb TODO
	 */
	private void testSquare(final int x, final int y, RGB rgb) {
		yield();
		sleep(300); // TODO

		assertPixelColor(myBody, 0, 0, white);
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
		assertPixelColor(myBody, p.x, p.y, rgb);
	}
}
