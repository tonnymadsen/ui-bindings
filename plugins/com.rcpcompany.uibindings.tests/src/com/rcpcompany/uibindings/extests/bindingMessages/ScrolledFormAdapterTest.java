/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.bindingMessages;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.internal.validators.BindingMessageCollectionTest;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests the behavior of {@link IValidatorAdapterManager} in {@link ScrolledForm}.
 * <p>
 * The basic behavior of the manager is tested in {@link BindingMessageCollectionTest}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScrolledFormAdapterTest {

	private Shop myShop;
	private TestView myView;
	private Composite myBody;

	private IBindingContext myContext;
	private IValueBinding myBinding;
	private ValueBindingMessageImageDecorator myMessageDecorator;
	private Text myText;

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(500);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		myShop = ShopFactory.eINSTANCE.getShop(IManager.Factory.getManager().getEditingDomain());

		myView = createTestView(this);
		myBody = myView.getBody();

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myBinding = myContext.addBinding(myText, myShop, ShopPackage.Literals.SHOP__NEXT_ORDER_NO);

		myContext.finish();
		yield();

		myMessageDecorator = myBinding.getService(ValueBindingMessageImageDecorator.class);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testValue() {
		final List<IBindingMessage> messages = myMessageDecorator.getMessages();
		assertNotNull(messages);

		final Form form = myView.getScrolledForm().getForm();
		assertNotNull(form);
		assertEquals(null, form.getHeadClient());

		myText.setText("");
		yield(); // Decorator updates are made in an asyncExec

		assertEquals(1, messages.size()); // Missing "required value"
		final IBindingMessage message = messages.get(0);
		assertNotNull(message);
		assertEquals(IMessageProvider.ERROR, message.getMessageType());

		assertEquals(message.getPrefix() + message.getMessage(), form.getMessage());

		final List<Hyperlink> widgets = findWidgets(form, Hyperlink.class);
		assertEquals(1, widgets.size());
		final Hyperlink link = widgets.get(0);
		assertEquals(message.getPrefix() + message.getMessage(), link.getText());

		// assertTrue(headClient.setFocus());
		// final Event event = new Event();
		// event.type = SWT.KeyDown;
		// event.keyCode = SWT.CR;
		// headClient.getDisplay().post(event);
	}

	/**
	 * Returns a list of al widgets of the specific class in the specified tree.
	 * 
	 * @param <T> the wanted widget type
	 * @param w the root
	 * @param widgetType the widget type class
	 * @return a list of widgets
	 */
	public static <T extends Widget> List<T> findWidgets(Widget w, Class<T> widgetType) {
		final List<T> l = new ArrayList<T>();
		if (widgetType.isInstance(w)) {
			l.add((T) w);
		}
		if (w instanceof Composite) {
			final Composite comp = (Composite) w;
			for (final Control c : comp.getChildren()) {
				l.addAll(findWidgets(c, widgetType));
			}
		}
		return l;
	}
}
