/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.uiAttributes;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Scale;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;

/**
 * This test checks the properties of the default UI attributes for a {@link Scale} widget - those
 * with attribute = "".
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIAttributeScaleFactoryPropertiesTest extends BaseUIAttributeFactoryTest<Scale> {
	protected IUIAttribute attribute = null;

	@Test
	public void testUIAttribute() {
		final Scale widget = createWidget(Scale.class, SWT.NONE);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				attribute = IManager.Factory.getManager().createUIAttribute(widget, "");
			}
		});

		assertNotNull(attribute);

		assertEquals("", attribute.getAttribute());
		assertEquals(widget, attribute.getWidget());

		testObservableValue(widget, "", attribute.getBackgroundValue(), Color.class, "background");
		testObservableValue(widget, "", attribute.getForegroundValue(), Color.class, "foreground");
		testObservableValue(widget, "", attribute.getFontValue(), Font.class, "font");
		testObservableValue(widget, "", attribute.getCursorValue(), Cursor.class, "cursor");
		testObservableValue(widget, "", attribute.getCurrentValue(), Integer.TYPE, "selection");
		testObservableValue(widget, "", attribute.getEnabledValue(), Boolean.TYPE, "enabled");
		testObservableValue(widget, "", attribute.getTooltipValue(), String.class, "toolTipText");
		testObservableValue(widget, "", attribute.getMinValue(), Integer.TYPE, "minimum");
		attribute.getMinValue().setValue(0);
		testObservableValue(widget, "", attribute.getMaxValue(), Integer.TYPE, "maximum");
		assertEquals(null, attribute.getFieldAssistAdapter());
		assertEquals(null, attribute.getPossibleValuesList());
		assertEquals(null, attribute.getStyleRangeList());

		widget.dispose();
	}
}
