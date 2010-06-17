package com.rcpcompany.uibindings.uiAttributes;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.FormColors;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;

/**
 * A painter for {@link IUIAttribute}.
 * <p>
 * Used to paint a single virtual {@link IUIAttribute} for a label provider, a grid renderer or
 * similar.
 * <p>
 * Kept as close as possible to StyledCellLabelProvider.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIAttributePainter {
	/**
	 * Extra cell height used on XP to ensure the cells that the correct space around checkboxes.
	 */
	private static final int EXTRA_CELL_HEIGHT = 3;

	/**
	 * The margin around the image and text of a cell.
	 */
	public static final int MARGIN = 3;

	/**
	 * The parent control of this painter.
	 * <p>
	 * Certain attributes of the control is used...
	 */
	private final Control myParentControl;

	/**
	 * The minimum height for a cell to accommodate the check box images.
	 */
	private static int myMinHeight;

	/**
	 * Returns the minimum height for a cell to accommodate the check box images.
	 * 
	 * @return the minimum height
	 */
	public static int getMinHeight() {
		return myMinHeight;
	}

	private static final String CHECKED_KEY = UIAttributePainter.class.getName() + "$CHECKED";
	private static final String UNCHECKED_KEY = UIAttributePainter.class.getName() + "$UNCHECKED";

	/**
	 * Constructs and returns a new UI Attribute painter for the specified parent control.
	 * 
	 * @param parentControl the parent control
	 * @param attribute the UI attribute
	 */
	public UIAttributePainter(Control parentControl, IUIAttribute attribute) {
		myParentControl = parentControl;
		myAttribute = attribute;

		/*
		 * Here - and not static - as the Display may not be setup correctly before now
		 */
		if (JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY) == null) {
			final Image shot = makeShot(parentControl, false);
			final int height = shot.getBounds().height;
			if (height + EXTRA_CELL_HEIGHT > myMinHeight) {
				myMinHeight = height + EXTRA_CELL_HEIGHT;
			}
			JFaceResources.getImageRegistry().put(UNCHECKED_KEY, shot);
			JFaceResources.getImageRegistry().put(CHECKED_KEY, makeShot(parentControl, true));
		}
		final FormColors colors = IManager.Factory.getManager().getFormToolkit().getColors();

		mySelectionBackground = JFaceResources.getColorRegistry().get(Constants.COLOR_SELECTION_FOCUS_BACKGROUND);
		mySelectionNoFocusBackground = JFaceResources.getColorRegistry().get(
				Constants.COLOR_SELECTION_NO_FOCUS_BACKGROUND);
		mySelectionForeground = myParentControl.getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT);

		myFocusBorder = colors.getBorderColor();
	}

	/**
	 * The attribute painted by this painter.
	 */
	private IUIAttribute myAttribute = null;

	/**
	 * The horizontal alignment.
	 */
	private int myHorizontalAlignment = SWT.NONE;
	private Color myDefaultBackground = null;
	private boolean myFocus = false;
	private boolean mySelected = false;

	/**
	 * Whether to use the internal values for the painter.
	 */
	private boolean myInternalValues = false;
	private String myInternalText = null;
	private Image myInternalImage = null;

	/*
	 * Cached results from preparePainter(...)
	 */
	private Image myPreparedImage = null;
	private Rectangle myPreparedImageBounds = null;
	private TextLayout myPreparedTextLayout = null;
	private Rectangle myPreparedTextBounds = null;
	private int myPreparedTotalX = 0;
	private int myPreparedTextWidthDelta;

	/**
	 * Prepared the painter..
	 * 
	 * @param gc the GC to use
	 */
	protected void preparePainter(GC gc) {
		myPreparedImage = null;
		myPreparedImageBounds = null;
		myPreparedTextBounds = null;
		myPreparedTotalX = 0;

		IObservableValue value;
		/*
		 * Image
		 */
		myPreparedImage = getDisplayImage();
		if (myPreparedImage != null) {
			myPreparedImageBounds = myPreparedImage.getBounds();

			// center the image in the given space
			myPreparedTotalX += myPreparedImageBounds.width;
		}
		/*
		 * Text
		 */

		final String t = getDisplayText();
		if (t != null) {
			if (myPreparedTextLayout == null) {
				myPreparedTextLayout = new TextLayout(myParentControl.getDisplay());
				myPreparedTextLayout.setOrientation(myParentControl.getStyle()
						& (SWT.LEFT_TO_RIGHT | SWT.RIGHT_TO_LEFT));
			}

			/*
			 * Set to two different values, to make sure the styles are reset...
			 */
			myPreparedTextLayout.setText("");
			myPreparedTextLayout.setText(t);

			value = getAttribute().getFontValue();
			if (value != null && value.getValue() instanceof Font) {
				myPreparedTextLayout.setFont((Font) value.getValue());
			} else {
				myPreparedTextLayout.setFont(null);
			}

			// text width without any styles
			final int originalTextWidth = myPreparedTextLayout.getBounds().width;
			boolean containsOtherFont = false;

			@SuppressWarnings("unchecked")
			final List<StyleRange> styleRanges = getAttribute().getStyleRangeList();
			if (!styleRanges.isEmpty()) { // user filled styled ranges
				for (final StyleRange styleRange : styleRanges) {
					myPreparedTextLayout.setStyle(styleRange, styleRange.start, styleRange.start + styleRange.length
							- 1);
					if (styleRange.font != null) {
						containsOtherFont = true;
					}
				}
			}
			if (containsOtherFont) {
				myPreparedTextWidthDelta = myPreparedTextLayout.getBounds().width - originalTextWidth;
			} else {
				myPreparedTextWidthDelta = 0;
			}
			myPreparedTextBounds = myPreparedTextLayout.getBounds();

			if (myPreparedImageBounds != null) {
				myPreparedTotalX += MARGIN;
				myPreparedTextBounds.x += myPreparedImageBounds.width + MARGIN;
			}

			myPreparedTotalX += myPreparedTextBounds.width;
		}
	}

	/**
	 * Measures and updates the bounds needed to paint this UI attribute.
	 * 
	 * @param gc the GC to use
	 * @param bounds the current bounds for the attribute
	 */
	public void measure(GC gc, Rectangle bounds) {
		preparePainter(gc);
		bounds.width += myPreparedTextWidthDelta;
	}

	/**
	 * Returns the width difference for text of this cell when applying fonts to the text.
	 * 
	 * @param gc the GC to use for the calculation
	 * @return the size difference
	 */
	public int getTextWidthDelta(GC gc) {
		preparePainter(gc);
		return myPreparedTextWidthDelta;
	}

	/**
	 * Paints this UI attribute within the specified bounds.
	 * 
	 * @param gc the GC to use
	 * @param areaBounds the bounds of the area
	 */
	public void paint(GC gc, Rectangle areaBounds) {
		paintTextAndImage(gc, areaBounds);
	}

	private void paintTextAndImage(GC gc, Rectangle areaBounds) {
		preparePainter(gc);
		// Remember colors to restore the GC later
		final Color oldForeground = gc.getForeground();
		final Color oldBackground = gc.getBackground();

		IObservableValue value;
		/*
		 * Colors
		 */
		Color foreground = oldForeground;
		value = getAttribute().getForegroundValue();
		if (value != null && value.getValue() instanceof Color) {
			foreground = (Color) value.getValue();
		}
		value = getAttribute().getEnabledValue();
		if (value != null && value.getValue() != null) {
			if (value.getValue() == Boolean.FALSE) {
				foreground = Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
			}
		}

		Color background = getDefaultBackground();
		value = getAttribute().getBackgroundValue();
		if (value != null && value.getValue() instanceof Color) {
			background = (Color) value.getValue();
		}

		if (isSelected() || hasFocus()) {
			if (myParentControl.isFocusControl()) {
				background = mySelectionBackground;
				foreground = mySelectionForeground;
			} else {
				background = mySelectionNoFocusBackground;
			}
		}

		if (background != null) {
			gc.setBackground(background);
		}

		// LogUtils.debug(this, "\nf=" + gc.getForeground() + " " + foreground +
		// "\nb=" + gc.getBackground() + " "
		// + background);
		gc.fillRectangle(areaBounds);

		/*
		 * Border
		 */
		if (hasFocus() && myParentControl.isFocusControl()) {
			gc.setForeground(myFocusBorder);
			// gc.drawFocus(areaBounds.x, areaBounds.y, areaBounds.width,
			// areaBounds.height);
			final int oldLineWidth = gc.getLineWidth();
			gc.setLineWidth(2);
			gc.drawRectangle(areaBounds.x + 1, areaBounds.y + 1, areaBounds.width - 2, areaBounds.height - 2);
			gc.setLineWidth(oldLineWidth);
		}

		gc.setForeground(foreground);

		int offsetX = 0;

		switch (getHorizontalAlignment()) {
		case SWT.NONE:
		case SWT.LEFT:
		default:
			offsetX = MARGIN;
			break;
		case SWT.CENTER:
			offsetX = Math.max(0, (areaBounds.width - myPreparedTotalX) / 2);
			break;
		case SWT.RIGHT:
			offsetX = Math.max(0, areaBounds.width - myPreparedTotalX - MARGIN);
			break;
		}

		if (myPreparedImageBounds != null) {
			final int x = myPreparedImageBounds.x + areaBounds.x + offsetX;
			final int y = myPreparedImageBounds.y + areaBounds.y
					+ Math.max(0, (areaBounds.height - myPreparedImageBounds.height) / 2);
			gc.drawImage(myPreparedImage, x, y);
		}
		if (myPreparedTextBounds != null) {
			final int x = myPreparedTextBounds.x + areaBounds.x + offsetX;
			final int y = myPreparedTextBounds.y + areaBounds.y
					+ Math.max(0, (areaBounds.height - myPreparedTextBounds.height) / 2);
			myPreparedTextLayout.draw(gc, x, y);
		}

		gc.setForeground(oldForeground);
		gc.setBackground(oldBackground);
	}

	private final Color mySelectionBackground;
	private final Color mySelectionNoFocusBackground;

	private final Color mySelectionForeground;

	private final Color myFocusBorder;

	/**
	 * Returns the text used for the current attribute if any.
	 * 
	 * @return the display text or null
	 * 
	 */
	public String getDisplayText() {
		if (myInternalValues) return myInternalText;
		final IObservableValue displayValue = getAttribute().getCurrentValue();
		if (displayValue == null) return null;

		final Object value = displayValue.getValue();
		if (value == null) return null;
		return value.toString();
	}

	/**
	 * Returns the image used for the current attribute if any.
	 * 
	 * @return the display image or null
	 * 
	 */
	public Image getDisplayImage() {
		if (myInternalValues) return myInternalImage;
		final IObservableValue displayValue = getAttribute().getImageValue();
		if (displayValue == null) return null;

		final Object value = displayValue.getValue();
		if (value == null) return null;
		if (!(value instanceof Image)) return null;
		return (Image) value;
	}

	/**
	 * Return the current attribute of the painter.
	 * 
	 * @return the attribute
	 */
	public IUIAttribute getAttribute() {
		return myAttribute;
	}

	/**
	 * Returns the current horizontal alignment.
	 * 
	 * @return the alignment
	 */
	public int getHorizontalAlignment() {
		return myHorizontalAlignment;
	}

	/**
	 * Sets the horizontal alignment of the painter - one or {@link SWT#LEAD}, {@link SWT#CENTER},
	 * or {@link SWT#TRAIL}.
	 * 
	 * @param alignment the new alignment
	 */
	public void setHorizontalAlignment(int alignment) {
		myHorizontalAlignment = alignment;
	}

	/**
	 * Sets the default background of the painter area.
	 * 
	 * @param defaultBackground the background or <code>null</code>
	 */
	public void setDefaultBackground(Color defaultBackground) {
		myDefaultBackground = defaultBackground;
	}

	/**
	 * Returns the current default background color.
	 * 
	 * @return the color or <code>null</code>
	 */
	public Color getDefaultBackground() {
		return myDefaultBackground;
	}

	/**
	 * Makes an image of a Check button in selected or un-selected mode.
	 * 
	 * @param control the parent control
	 * @param type selected or not
	 * @return the image
	 */
	private Image makeShot(Control control, boolean type) {
		// Hopefully no platform uses exactly this color because we'll make
		// it transparent in the image.
		final Color greenScreen = new Color(control.getDisplay(), 222, 223, 224);

		final Shell shell = new Shell(control.getShell(), SWT.NO_TRIM);

		// otherwise we have a default gray color
		shell.setBackground(greenScreen);

		if (Util.isMac()) {
			final Button button2 = new Button(shell, SWT.CHECK);
			final Point bsize = button2.computeSize(SWT.DEFAULT, SWT.DEFAULT);

			// otherwise an image is stretched by width
			bsize.x = Math.max(bsize.x - 1, bsize.y - 1);
			bsize.y = Math.max(bsize.x - 1, bsize.y - 1);
			button2.setSize(bsize);
			button2.setLocation(100, 100);
		}

		final Button button = new Button(shell, SWT.CHECK);
		button.setBackground(greenScreen);
		button.setSelection(type);

		// otherwise an image is located in a corner
		button.setLocation(1, 1);
		final Point bsize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		// otherwise an image is stretched by width
		bsize.x = Math.max(bsize.x - 1, bsize.y - 1);
		bsize.y = Math.max(bsize.x - 1, bsize.y - 1);
		button.setSize(bsize);

		shell.setSize(bsize);

		shell.open();

		final GC gc = new GC(shell);
		final Image image = new Image(control.getDisplay(), bsize.x, bsize.y);
		gc.copyArea(image, 0, 0);
		gc.dispose();
		shell.getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				shell.close();
			}
		});

		final ImageData imageData = image.getImageData();
		imageData.transparentPixel = imageData.palette.getPixel(greenScreen.getRGB());

		final Image img = new Image(control.getDisplay(), imageData);
		image.dispose();

		return img;
	}

	/**
	 * Sets the painter to paint a image only based on the checked state.
	 * <p>
	 * Three states based on value:
	 * <dl>
	 * <dt><code>true</code></dt>
	 * <dd>The painter will show a check in checked state</dd>
	 * <dt><code>false</code></dt>
	 * <dd>The painter will show a check in unchecked state</dd>
	 * <dt><code>null</code></dt>
	 * <dd>The painter will <em>not</em> show a check</dd>
	 * </dl>
	 * 
	 * @param checked the wanted state
	 */
	public void setCheckbox(Boolean checked) {
		if (checked == null) {
			setInternalValues(null, null);
			return;
		}
		if (checked) {
			setInternalValues(JFaceResources.getImageRegistry().get(CHECKED_KEY), null);
		} else {
			setInternalValues(JFaceResources.getImageRegistry().get(UNCHECKED_KEY), null);
		}
	}

	public void setInternalValues(Image image, String text) {
		myInternalImage = image;
		myInternalText = text;
		myInternalValues = (image != null) || (text != null);
	}

	/**
	 * Sets whether the painter has focus or not.
	 * 
	 * @param hasFocus if it has focus
	 */
	public void setFocus(boolean hasFocus) {
		myFocus = hasFocus;
	}

	/**
	 * Whether the painter has focus or not.
	 * 
	 * @return <code>true</code> if the painter has focus
	 */
	public boolean hasFocus() {
		return myFocus;
	}

	/**
	 * Sets whether the painter is selected or not.
	 * 
	 * @param isSelected the new selected state
	 */
	public void setSelected(boolean isSelected) {
		mySelected = isSelected;
	}

	/**
	 * Whether the painter is selected.
	 * 
	 * @return <code>true</code> if selected
	 */
	public boolean isSelected() {
		return mySelected;
	}

	/**
	 * Returns the size of the area for this cell.
	 * 
	 * @param gc the GC used for ther cell
	 * @return the size of the needed area
	 */
	public Point getSize(GC gc) {
		preparePainter(gc);
		final Rectangle a = new Rectangle(0, 0, 0, 0);
		if (myPreparedImageBounds != null) {
			a.add(myPreparedImageBounds);
		}
		if (myPreparedTextBounds != null) {
			a.add(myPreparedTextBounds);
		}
		/*
		 * Make sure the minimum eight is the same as the
		 * 
		 * Was: For Windows XP, we must add a little to the size as cells otherwise gets too small.
		 */
		if (a.height < getMinHeight()) {
			a.height = getMinHeight();
		}
		return new Point(a.width, a.height);
	}
}
