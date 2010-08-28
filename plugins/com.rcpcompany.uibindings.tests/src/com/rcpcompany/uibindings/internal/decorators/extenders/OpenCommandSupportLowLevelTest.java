package com.rcpcompany.uibindings.internal.decorators.extenders;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.utils.ShowViewSelectionTestView;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.decorators.extenders.OpenCommandSupport.ContextData;
import com.rcpcompany.uibindings.internal.decorators.extenders.OpenCommandSupport.ManagerData;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests the correct selection is used in the "show view" command and handler.
 * <p>
 * Depends on:
 * <ul>
 * <li>{@link ShowViewSelectionTestView}</li>
 * <li>openCommand</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenCommandSupportLowLevelTest {
	public final static String TEST_VIEW_ID = ShowViewSelectionTestView.class.getName();

	private TestView myView;

	private Shop myShop;

	private IFormCreator myForm;
	private IValueBinding myNameField;

	private Text myText;

	private ManagerData myManagerData;

	private KeyStroke myKeyStroke;

	@Before
	public void before() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();

		yield();

		myKeyStroke = null;
		try {
			myKeyStroke = KeyStroke.getInstance("CTRL+SPACE");
		} catch (final ParseException ex) {
			fail(ex.getMessage());
		}

		myManagerData = OpenCommandSupport.ManagerData.theData;

		myView.getSite().getPage().activate(myView);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("Helo");
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);

		myForm = myView.createFormCreator(myShop);

		myNameField = myForm.addField(myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME, SWT.NONE);

		myText = new Text(myForm.addComposite(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setText("Outside");

		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Checks that the basic - and internal - data objects exists
	 */
	@Test
	public void createdTest() {
		assertNotNull(myManagerData);
		ContextData cd = myForm.getContext().getService(OpenCommandSupport.ContextData.class);
		assertSame(null, cd);

		myNameField.getControl().setFocus();
		yield();

		cd = myForm.getContext().getService(OpenCommandSupport.ContextData.class);
		assertNotNull(cd);
	}

	/**
	 * Test CTRL in a binding widget
	 */
	@Test
	public void bindingWidgetTest() {
		testOneWidget(myNameField.getControl());
	}

	/**
	 * Test CTRL in a non-binding widget
	 */
	@Test
	public void textWidgetTest() {
		testOneWidget(myText);
	}

	/**
	 * Test CTRL in a Composite
	 */
	@Test
	public void compositeTest() {
		testOneWidget(myForm.getTop());
	}

	/**
	 * Tests that the hover listener is installed correctly for the specified widget
	 * 
	 * @param c the control
	 */
	private void testOneWidget(final Control c) {
		c.forceFocus();
		yield();

		assertEquals(false, myManagerData.isHoverListenerInstalled);

		postModifierKeys(c, myKeyStroke, true);
		yield();

		assertEquals(true, myManagerData.isHoverListenerInstalled);

		postModifierKeys(c, myKeyStroke, false);
		yield();

		assertEquals(false, myManagerData.isHoverListenerInstalled);
	}

	/**
	 * Test CTRL outside the application and then move mouse inside
	 */
	// @Test
	// public void moveInfoApplicationTest() {
	// postMouseMove(myText.getShell(), new Point(-20, 0));
	// yield();
	// sleep(4000);
	//
	// assertEquals(false, myManagerData.isHoverListenerInstalled);
	//
	// postModifierKeys(c, myKeyStroke, true);
	// yield();
	//
	// assertEquals(true, myManagerData.isHoverListenerInstalled);
	//
	// postModifierKeys(c, myKeyStroke, false);
	// yield();
	//
	// assertEquals(true, myManagerData.isHoverListenerInstalled);
	// }
}
