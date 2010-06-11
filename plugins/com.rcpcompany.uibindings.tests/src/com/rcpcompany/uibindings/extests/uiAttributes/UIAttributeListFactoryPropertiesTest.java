package com.rcpcompany.uibindings.extests.uiAttributes;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createWidget;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.List;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;

/**
 * This test checks the properties of the default UI attributes for a {@link List} widget - those with attribute = "".
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIAttributeListFactoryPropertiesTest extends BaseUIAttributeFactoryTest<List> {
	protected IUIAttribute attribute = null;

	@Test
	public void testUIAttribute() {
		final List widget = createWidget(List.class, SWT.SINGLE);

		assertNoLog(new Runnable() {
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
		testObservableValue(widget, "", attribute.getCurrentValue(), String.class, null); // not a direct property
		testObservableValue(widget, "", attribute.getEnabledValue(), Boolean.TYPE, "enabled");
		testObservableValue(widget, "", attribute.getTooltipValue(), String.class, "toolTipText");
		assertEquals(null, attribute.getMinValue());
		assertEquals(null, attribute.getMaxValue());
		assertEquals(null, attribute.getFieldAssistAdapter());
		testObservableList(widget, "", attribute.getPossibleValuesList(), String.class, "items");
		assertEquals(null, attribute.getStyleRangeList());
	}

}
