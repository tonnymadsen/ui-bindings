package com.rcpcompany.uibindings.extests.uiAttributes;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.widgets.FileNameControl;

/**
 * This test checks the properties of the default UI attributes for a {@link FileNameControl} widget
 * - those with attribute = "".
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIAttributeFileNameControlFactoryPropertiesTest extends BaseUIAttributeFactoryTest<FileNameControl> {
	protected IUIAttribute attribute = null;

	@Test
	public void testUIAttribute() {
		final FileNameControl widget = createWidget(FileNameControl.class, SWT.NONE);

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
		testObservableValue(widget, "", attribute.getCurrentValue(), String.class, "text");
		testObservableValue(widget, "", attribute.getEnabledValue(), Boolean.TYPE, "enabled");
		testObservableValue(widget, "", attribute.getTooltipValue(), String.class, "toolTipText");
		assertEquals(null, attribute.getMinValue());
		assertEquals(null, attribute.getMaxValue());
		assertNotNull(attribute.getFieldAssistAdapter());
		assertEquals(null, attribute.getPossibleValuesList());
		assertEquals(null, attribute.getStyleRangeList());
	}
}
