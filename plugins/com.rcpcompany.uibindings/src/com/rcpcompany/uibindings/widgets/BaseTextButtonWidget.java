package com.rcpcompany.uibindings.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.rcpcompany.uibindings.IManager;

/**
 * Base composite widget with a text and a button.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class BaseTextButtonWidget extends Composite {
	/**
	 * Request the opening of a dialog for the widget.
	 * <p>
	 * The current value of the widget can be get/set using {@link BaseTextButtonWidget#setText()}
	 * 
	 * @param e the mouse event
	 */
	public abstract void open(MouseEvent e);

	private Text myText;
	private Label myDialogButton;

	public BaseTextButtonWidget(Composite parent, int style, Image buttonImage) {
		super(parent, style);

		buildWidget(buttonImage);
	}

	private void buildWidget(Image buttonImage) {
		final FormToolkit toolkit = IManager.Factory.getManager().getFormToolkit();

		final GridLayout filterLayout = new GridLayout(2, false);
		filterLayout.marginHeight = 0;
		filterLayout.marginWidth = 0;
		setLayout(filterLayout);

		myText = new Text(this, SWT.SINGLE);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		myDialogButton = toolkit.createLabel(this, "");
		myDialogButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		myDialogButton.setImage(buttonImage);
		myDialogButton.setBackground(getBackground());
		myDialogButton.setToolTipText("Browse");
		myDialogButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				open(e);
			}
		});
	}

	/**
	 * Returns the Text sub-widget of this widget
	 * 
	 * @return the Text
	 */
	public Text getTextControl() {
		return myText;
	}

	/**
	 * Returns the current text of the widget
	 * 
	 * @return the current text
	 */
	public String getText() {
		return myText.getText();
	}

	/**
	 * Sets the text of the widget
	 * 
	 * @param text the new text of the widget
	 */
	public void setText(String text) {
		myText.setText(text);
	}

	public Point getCaretLocation() {
		return myText.getCaretLocation();
	}

	public int getCaretPosition() {
		return myText.getCaretPosition();
	}

	public char getEchoChar() {
		return myText.getEchoChar();
	}

	public int getOrientation() {
		return myText.getOrientation();
	}

	public Point getSelection() {
		return myText.getSelection();
	}

	public String getSelectionText() {
		return myText.getSelectionText();
	}

	public String getText(int start, int end) {
		return myText.getText(start, end);
	}

	public int getTextLimit() {
		return myText.getTextLimit();
	}

	@Override
	public String getToolTipText() {
		return myText.getToolTipText();
	}

	public void insert(String string) {
		myText.insert(string);
	}

	@Override
	public boolean isFocusControl() {
		return myText.isFocusControl();
	}

	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
		myText.setBackground(color);
		myDialogButton.setBackground(color);
	}

	@Override
	public void setCursor(Cursor cursor) {
		super.setCursor(cursor);
		myText.setCursor(cursor);
		myDialogButton.setCursor(cursor);
	}

	public void setEchoChar(char echo) {
		myText.setEchoChar(echo);
	}

	@Override
	public boolean setFocus() {
		return myText.setFocus();
	}

	@Override
	public void setFont(Font font) {
		super.setFont(font);
		myText.setFont(font);
		myDialogButton.setFont(font);
	}

	@Override
	public void setForeground(Color color) {
		super.setForeground(color);
		myText.setForeground(color);
		myDialogButton.setForeground(color);
	}

	@Override
	public void setMenu(Menu menu) {
		super.setMenu(menu);
		myText.setMenu(menu);
		myDialogButton.setMenu(menu);
	}

	public void setOrientation(int orientation) {
		myText.setOrientation(orientation);
	}

	public void setSelection(int start, int end) {
		myText.setSelection(start, end);
	}

	public void setSelection(int start) {
		myText.setSelection(start);
	}

	public void setSelection(Point selection) {
		myText.setSelection(selection);
	}

	@Override
	public void setToolTipText(String string) {
		super.setToolTipText(string);
		myText.setToolTipText(string);
	}
}
