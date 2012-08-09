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
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.test.utils.UITestUtils.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.AbstractControlDecoration;
import com.rcpcompany.uibindings.utils.IControlDecoration;

/**
 * Test of the basic {@link IControlDecoration} functionality.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ControlDecorationTest {
	private static final int SQUARE_SIZE = 10;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createView();

		myView.getSite().getPage().activate(myView);
	}

	private UIBTestView myView;
	private Composite myBody;

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		final GridData ld = new GridData(SWT.CENTER, SWT.CENTER, true, true);
		ld.widthHint = 100;
		ld.heightHint = 20;
		myText.setLayoutData(ld);
		myText.setText("");

		myBody.layout();
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
	private Text myText;

	@Test
	public void testLocationInsideCorner() {
		testALocation(3, 3, true);
	}

	@Test
	public void testLocationOutsideCorner() {
		testALocation(-2 * SQUARE_SIZE, -2 * SQUARE_SIZE, true);
	}

	@Test
	@Ignore
	public void testLocationIntersect() {
		testALocation(-SQUARE_SIZE / 2, -SQUARE_SIZE / 2, false);
	}

	protected class CD extends AbstractControlDecoration {
		private Point myLocation;
		private Image myImage;

		@Override
		public Point getLocation() {
			return myLocation;
		}

		@Override
		public Image getImage() {
			return myImage;
		}

		@Override
		public Control getControl() {
			return myText;
		}

		public void setLocation(int x, int y) {
			myLocation = new Point(x, y);
		}

		public void setImage(Image image) {
			myImage = image;
		}
	}

	private void testALocation(final int x, final int y, boolean testWhite) {
		final CD cd = new CD();
		cd.setImage(myImage1);
		cd.setLocation(x, y);

		/*
		 * No decoration
		 */
		if (testWhite) {
			testSquare(x, y, white);
		}

		/*
		 * Add the decoration
		 */
		IControlDecoration.Factory.addDecoration(cd);
		testSquare(x, y, rgb1);

		/*
		 * Move the decoration
		 */
		cd.setLocation(x + 3, y);
		IControlDecoration.Factory.addDecoration(cd);
		testSquare(x + 3, y, rgb1);
		assertTranslatedPixel(x, y, white);

		/*
		 * Change the image of the decoration
		 */
		cd.setImage(myImage2);
		IControlDecoration.Factory.addDecoration(cd);
		testSquare(x + 3, y, rgb2);
		assertTranslatedPixel(x, y, white);

		/*
		 * Remove it again
		 */
		IControlDecoration.Factory.removeDecoration(cd);
		if (testWhite) {
			testSquare(x, y, white);
		}
	}

	/**
	 * @param x
	 * @param y
	 * @param rgb TODO
	 */
	private void testSquare(final int x, final int y, RGB rgb) {
		yield();
		sleep(100);

		assertPixelColor("", myBody, 0, 0, white);
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
		final Point p = myText.getDisplay().map(myText, myBody, x, y);
		assertPixelColor("", myBody, p.x, p.y, rgb);
	}
}
