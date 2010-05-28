package com.rcpcompany.uibindings.extests.uiAttributes;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createWidget;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.nebula.widgets.radiogroup.RadioGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.widgets.FileNameControl;

@RunWith(Parameterized.class)
public class UIAttributeFactoryTest<T extends Widget> extends BaseUIAttributeFactoryTest<T> {
	protected final Class<T> myWidgetClass;
	protected final String myAttribute;
	protected final Class<?> myExpectedValueType;
	protected final int myStyle;
	protected final String myPropertyName;
	private final String what;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				{ Button.class, SWT.PUSH, "", String.class, "text" },
				{ Button.class, SWT.PUSH, "text", String.class, "text" },
				{ Button.class, SWT.PUSH, "background", Color.class, "background" },
				{ Button.class, SWT.PUSH, "enabled", Boolean.TYPE, "enabled" },
				{ Button.class, SWT.PUSH, "cursor", Cursor.class, "cursor" },
				{ Button.class, SWT.PUSH, "font", Font.class, "font" },
				{ Button.class, SWT.PUSH, "foreground", Color.class, "foreground" },
				{ Button.class, SWT.PUSH, "foreground", Color.class, "foreground" },
				{ Button.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Button.class, SWT.PUSH, "visible", Boolean.TYPE, "visible" },

				{ Button.class, SWT.CHECK, "", Boolean.TYPE, null },
				{ Button.class, SWT.CHECK, "selection", Boolean.TYPE, "selection" },

				{ Button.class, SWT.RADIO, "", Boolean.TYPE, null },
				{ Button.class, SWT.RADIO, "selection", Boolean.TYPE, "selection" },

				{ Button.class, SWT.TOGGLE, "", Boolean.TYPE, null },
				{ Button.class, SWT.TOGGLE, "selection", Boolean.TYPE, "selection" },

				{ CCombo.class, SWT.NONE, "", String.class, "text" },
				{ CCombo.class, SWT.NONE, "selection", Point.class, "selection" },
				{ CCombo.class, SWT.NONE, "text", String.class, "text" },
				{ CCombo.class, SWT.NONE, "background", Color.class, "background" },
				{ CCombo.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ CCombo.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ CCombo.class, SWT.NONE, "font", Font.class, "font" },
				{ CCombo.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ CCombo.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ CCombo.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ CCombo.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ CLabel.class, SWT.NONE, "", String.class, "text" },
				{ CLabel.class, SWT.NONE, "text", String.class, "text" },
				{ CLabel.class, SWT.NONE, "background", Color.class, "background" },
				{ CLabel.class, SWT.NONE, "image", Image.class, "image" },
				{ CLabel.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ CLabel.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ CLabel.class, SWT.NONE, "font", Font.class, "font" },
				{ CLabel.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ CLabel.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ CLabel.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ CLabel.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Combo.class, SWT.NONE, "", String.class, "text" },
				{ Combo.class, SWT.NONE, "selection", Point.class, "selection" },
				{ Combo.class, SWT.NONE, "text", String.class, "text" },
				{ Combo.class, SWT.NONE, "background", Color.class, "background" },
				{ Combo.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Combo.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Combo.class, SWT.NONE, "font", Font.class, "font" },
				{ Combo.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Combo.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Combo.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Combo.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ DateTime.class, SWT.NONE, "", Date.class, null }, /* composite value */
				{ DateTime.class, SWT.NONE, "date", Date.class, null }, /* composite value */
				{ DateTime.class, SWT.NONE, "background", Color.class, "background" },
				{ DateTime.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ DateTime.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ DateTime.class, SWT.NONE, "font", Font.class, "font" },
				{ DateTime.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ DateTime.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ DateTime.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ DateTime.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Form.class, SWT.NONE, "", String.class, "text" },
				{ Form.class, SWT.NONE, "text", String.class, "text" },
				{ Form.class, SWT.NONE, "background", Color.class, "background" },
				{ Form.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Form.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Form.class, SWT.NONE, "font", Font.class, "font" },
				{ Form.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Form.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Form.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Form.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Hyperlink.class, SWT.NONE, "", String.class, "text" },
				{ Hyperlink.class, SWT.NONE, "text", String.class, "text" },
				{ Hyperlink.class, SWT.NONE, "background", Color.class, "background" },
				{ Hyperlink.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Hyperlink.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Hyperlink.class, SWT.NONE, "font", Font.class, "font" },
				{ Hyperlink.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Hyperlink.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Hyperlink.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Hyperlink.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Label.class, SWT.NONE, "", String.class, "text" },
				{ Label.class, SWT.NONE, "text", String.class, "text" },
				{ Label.class, SWT.NONE, "image", Image.class, "image" },
				{ Label.class, SWT.NONE, "background", Color.class, "background" },
				{ Label.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Label.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Label.class, SWT.NONE, "font", Font.class, "font" },
				{ Label.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Label.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Label.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Label.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Link.class, SWT.NONE, "", String.class, "text" },
				{ Link.class, SWT.NONE, "text", String.class, "text" },
				{ Link.class, SWT.NONE, "background", Color.class, "background" },
				{ Link.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Link.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Link.class, SWT.NONE, "font", Font.class, "font" },
				{ Link.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Link.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Link.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Link.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ List.class, SWT.NONE, "", String.class, null }, // Calculated property
				{ List.class, SWT.NONE, "selection", String.class, null }, // Calculated property
				{ List.class, SWT.NONE, "background", Color.class, "background" },
				{ List.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ List.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ List.class, SWT.NONE, "font", Font.class, "font" },
				{ List.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ List.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ List.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ List.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Scale.class, SWT.NONE, "", Integer.TYPE, "selection" },
				{ Scale.class, SWT.NONE, "max", Integer.TYPE, "maximum" },
				{ Scale.class, SWT.NONE, "min", Integer.TYPE, "minimum" },
				{ Scale.class, SWT.NONE, "selection", Integer.TYPE, "selection" },
				{ Scale.class, SWT.NONE, "background", Color.class, "background" },
				{ Scale.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Scale.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Scale.class, SWT.NONE, "font", Font.class, "font" },
				{ Scale.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Scale.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Scale.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ ScrolledForm.class, SWT.NONE, "", String.class, "text" },
				{ ScrolledForm.class, SWT.NONE, "text", String.class, "text" },
				{ ScrolledForm.class, SWT.NONE, "background", Color.class, "background" },
				{ ScrolledForm.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ ScrolledForm.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ ScrolledForm.class, SWT.NONE, "font", Font.class, "font" },
				{ ScrolledForm.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ ScrolledForm.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ ScrolledForm.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ ScrolledForm.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Section.class, SWT.NONE, "text", String.class, "text" },
				{ Section.class, SWT.NONE, "background", Color.class, "background" },
				{ Section.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Section.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Section.class, SWT.NONE, "font", Font.class, "font" },
				{ Section.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Section.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Section.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Section.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Shell.class, SWT.NONE, "text", String.class, "text" },
				{ Shell.class, SWT.NONE, "background", Color.class, "background" },
				{ Shell.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Shell.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Shell.class, SWT.NONE, "font", Font.class, "font" },
				{ Shell.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Shell.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Shell.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Slider.class, SWT.NONE, "", Integer.TYPE, "selection" },
				{ Slider.class, SWT.NONE, "max", Integer.TYPE, "maximum" },
				{ Slider.class, SWT.NONE, "min", Integer.TYPE, "minimum" },
				{ Slider.class, SWT.NONE, "selection", Integer.TYPE, "selection" },
				{ Slider.class, SWT.NONE, "background", Color.class, "background" },
				{ Slider.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Slider.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Slider.class, SWT.NONE, "font", Font.class, "font" },
				{ Slider.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Slider.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Slider.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Slider.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ Spinner.class, SWT.NONE, "", Integer.TYPE, "selection" },
				{ Spinner.class, SWT.NONE, "max", Integer.TYPE, "maximum" },
				{ Spinner.class, SWT.NONE, "min", Integer.TYPE, "minimum" },
				{ Spinner.class, SWT.NONE, "selection", Integer.TYPE, "selection" },
				{ Spinner.class, SWT.NONE, "background", Color.class, "background" },
				{ Spinner.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Spinner.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Spinner.class, SWT.NONE, "font", Font.class, "font" },
				{ Spinner.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Spinner.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Spinner.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Spinner.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ StyledText.class, SWT.NONE, "", String.class, "text" },
				{ StyledText.class, SWT.NONE, "text", String.class, "text" },
				{ StyledText.class, SWT.NONE, "background", Color.class, "background" },
				{ StyledText.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ StyledText.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ StyledText.class, SWT.NONE, "font", Font.class, "font" },
				{ StyledText.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ StyledText.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ StyledText.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ StyledText.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ TableColumn.class, SWT.NONE, "alignment", Integer.TYPE, "alignment" },
				{ TableColumn.class, SWT.NONE, "image", Image.class, "image" },
				{ TableColumn.class, SWT.NONE, "text", String.class, "text" },
				{ TableColumn.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ TableColumn.class, SWT.NONE, "width", Integer.TYPE, "width" },

				{ Text.class, SWT.NONE, "", String.class, "text" },
				{ Text.class, SWT.NONE, "editable", Boolean.TYPE, "editable" },
				{ Text.class, SWT.NONE, "text", String.class, "text" },
				{ Text.class, SWT.NONE, "background", Color.class, "background" },
				{ Text.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ Text.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ Text.class, SWT.NONE, "font", Font.class, "font" },
				{ Text.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Text.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ Text.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ Text.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ TreeColumn.class, SWT.NONE, "alignment", Integer.TYPE, "alignment" },
				{ TreeColumn.class, SWT.NONE, "image", Image.class, "image" },
				{ TreeColumn.class, SWT.NONE, "text", String.class, "text" },
				{ TreeColumn.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ TreeColumn.class, SWT.NONE, "width", Integer.TYPE, "width" },

				{ TabItem.class, SWT.NONE, "", String.class, "text" },
				{ TabItem.class, SWT.NONE, "image", Image.class, "image" },
				{ TabItem.class, SWT.NONE, "text", String.class, "text" },
				{ TabItem.class, SWT.NONE, "tooltip", String.class, "toolTipText" },

				{ ToolItem.class, SWT.NONE, "", String.class, "text" },
				{ ToolItem.class, SWT.NONE, "image", Image.class, "image" },
				{ ToolItem.class, SWT.NONE, "text", String.class, "text" },
				{ ToolItem.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ ToolItem.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				/* { ToolItem.class, SWT.NONE, "width", Integer.TYPE, "width" }, */

				{ RadioGroup.class, SWT.NONE, "", String.class, null },
				{ RadioGroup.class, SWT.NONE, "text", String.class, null },
				{ RadioGroup.class, SWT.NONE, "background", Color.class, "background" },
				{ RadioGroup.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ RadioGroup.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ RadioGroup.class, SWT.NONE, "font", Font.class, "font" },
				{ RadioGroup.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ RadioGroup.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ RadioGroup.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ RadioGroup.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

				{ FileNameControl.class, SWT.NONE, "", String.class, null },
				{ FileNameControl.class, SWT.NONE, "text", String.class, null },
				{ FileNameControl.class, SWT.NONE, "background", Color.class, "background" },
				{ FileNameControl.class, SWT.NONE, "enabled", Boolean.TYPE, "enabled" },
				{ FileNameControl.class, SWT.NONE, "cursor", Cursor.class, "cursor" },
				{ FileNameControl.class, SWT.NONE, "font", Font.class, "font" },
				{ FileNameControl.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ FileNameControl.class, SWT.NONE, "foreground", Color.class, "foreground" },
				{ FileNameControl.class, SWT.NONE, "tooltip", String.class, "toolTipText" },
				{ FileNameControl.class, SWT.NONE, "visible", Boolean.TYPE, "visible" },

		});
	}

	public UIAttributeFactoryTest(Class<T> widgetType, int style, final String attribute,
			final Class<?> expectedValueType, String property) {
		myWidgetClass = widgetType;
		myStyle = style;
		myAttribute = attribute;
		myExpectedValueType = expectedValueType;
		myPropertyName = property;
		what = myWidgetClass.getSimpleName() + " attribute '" + myAttribute + "'";
	}

	protected IUIAttribute uiAttribute = null;

	@Test
	public void test() {
		assertNoLog(new Runnable() {
			public void run() {
				final T widget = createWidget(myWidgetClass, myStyle);

				assertNoLog(new Runnable() {
					public void run() {
						uiAttribute = IManager.Factory.getManager().createUIAttribute(widget, myAttribute);
					}
				});
				assertNotNull(what + ": Cannot create attribute", uiAttribute);
				assertEquals(what, myAttribute, uiAttribute.getAttribute());
				assertNotNull(what, uiAttribute.getWidget());
				assertEquals(what, myWidgetClass, uiAttribute.getWidget().getClass());

				final IObservableValue value = uiAttribute.getCurrentValue();
				assertNotNull(what + ": Cannot get IOV", value);
				assertEquals(what, myExpectedValueType, value.getValueType());

				testObservableValue(widget, myAttribute, value, myExpectedValueType, myPropertyName);
			}
		});
	}

}
