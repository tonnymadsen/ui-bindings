package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Test of {@link IFormCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormCreatorTest {
	private ShopItem myShopItem;
	private Contact myContact;

	private FormToolkit myToolkit;
	private TestView myView;
	private Composite myBody;

	private Composite myComposite;

	private IBindingContext myContext;
	private Shop myShop;

	@Before
	public void before() {
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("my shop");

		myShopItem = ShopFactory.eINSTANCE.createShopItem();
		myShopItem.setName("Wellknown dummy");
		myShopItem.setShop(myShop);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("John Doe");
		myContact.setShop(myShop);

	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();
		myToolkit = myView.getToolkit();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests the basic get/set functionality
	 */
	@Test
	public void testBasicGetSet() {
		myContext = IBindingContext.Factory.createContext(myBody);
		final IFormCreator form = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);

		assertEquals(myBody, form.getTop().getParent());
		assertEquals(myContext, form.getContext());
		assertEquals(myToolkit, form.getToolkit());
		assertEquals(myShopItem, form.getObject());
	}

	/**
	 * Tests the scrolled form behavior
	 */
	@Test
	public void testCreateScrolledform() {
		final IFormCreator form = IFormCreator.Factory.createScrolledForm(myShop, myBody, "Body");

		assertEquals(myBody, form.getTop().getParent().getParent().getParent());
	}

	/**
	 * Tests the basic get/set functionality for sub-forms - part I
	 */
	@Test
	public void testBasicSubformGetSet() {

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IFormCreator form = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);
				final IFormCreator subform = form.addSection("Basics");

				assertEquals(form.getTop(), subform.getTop().getParent().getParent());
				assertEquals(form.getContext(), subform.getContext());
				assertEquals(form.getToolkit(), subform.getToolkit());
				assertEquals(form.getObject(), subform.getObject());
			}
		});
	}

	/**
	 * Tests the basic get/set functionality for sub-forms - part II
	 */
	@Test
	public void testBasicSubformObjGetSet() {

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IFormCreator form = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);
				final IFormCreator subform = form.addSection("Basics", myContact);

				assertEquals(form.getTop(), subform.getTop().getParent().getParent());
				assertEquals(form.getContext(), subform.getContext());
				assertEquals(form.getToolkit(), subform.getToolkit());
				assertEquals(myContact, subform.getObject());
			}
		});
	}

	protected IFormCreator myForm;
	protected IFormCreator mySubform;

	/**
	 * Tests {@link IFormCreator#addComposite()}.
	 */
	@Test
	public void testAddComposite() {
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				myForm = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);

				myComposite = myForm.addComposite();

				myForm.finish();
			}
		});

		final Composite top = myForm.getTop();
		assertNotNull(top);

		final Control[] children = top.getChildren();
		assertEquals(1, children.length);

		assertEquals(myComposite, children[0]);
		assertTrue(myComposite.getLayout() instanceof FillLayout);
		// TODO: composite covers all columns
	}

	/**
	 * Tests {@link IFormCreator#addSeparator()}.
	 */
	@Test
	public void testAddSeparator() {
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				myForm = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);

				myForm.addSeparator();

				myForm.finish();
			}
		});

		final Composite top = myForm.getTop();
		assertNotNull(top);

		final Control[] children = top.getChildren();
		assertEquals(1, children.length);

		assertTrue(children[0] instanceof Label);
		final Label label = (Label) children[0];
		assertEquals("", label.getText());
		assertTrue((label.getStyle() & SWT.SEPARATOR) == SWT.SEPARATOR);
		assertTrue((label.getStyle() & SWT.HORIZONTAL) == SWT.HORIZONTAL);
		// TODO: composite covers all columns
	}

	/**
	 * Tests {@link IFormCreator#addComposite()}.
	 */
	@Test
	public void testAddConstantField() {
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				myForm = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);

				myForm.addConstantField("Label", "Value", SWT.MULTI);

				myForm.finish();
			}
		});

		final Composite top = myForm.getTop();
		assertNotNull(top);

		Control[] children = top.getChildren();
		assertEquals(1, children.length);

		children = ((Composite) children[0]).getChildren();
		assertEquals(2, children.length);

		assertTrue(children[0] instanceof Label);
		final Label label = (Label) children[0];
		assertEquals("Label:", label.getText());
		// TODO: label covers first column

		assertTrue(children[1] instanceof Text);
		final Text text = (Text) children[1];
		assertEquals("Value", text.getText());
		assertTrue((text.getStyle() & SWT.MULTI) == SWT.MULTI);
		// TODO: label covers last column
	}

	protected IValueBinding myField1;
	protected IValueBinding myField2;

	/**
	 * Tests the creation of a basic field in a section
	 */
	@Test
	public void testBasicField() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myForm = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);

				mySubform = myForm.addSection("Basics");
				myField1 = mySubform.addField(IMOAOPackage.Literals.NAMED_OBJECT__NAME);

				myForm.finish();
			}
		});

		final Composite top = myForm.getTop();
		assertNotNull(top);

		Control[] children = top.getChildren();
		assertEquals(1, children.length);

		assertTrue(children[0] instanceof Section);
		children = ((Section) children[0]).getChildren();
		assertEquals(3, children.length);

		assertTrue(children[1] instanceof Label);
		assertEquals("Basics", ((Label) children[1]).getText());

		assertTrue(children[2] instanceof Composite);
		children = ((Composite) children[2]).getChildren();
		assertEquals(1, children.length);

		testFieldLayout((Composite) children[0], 0, myField1, "Name:", myShopItem.getName());
	}

	/**
	 * Tests that the creation of a basic field uses the {@link IValueBinding#arg(String, Object)}
	 * information properly
	 */
	@Test
	public void testBasicFieldArgLabel() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myForm = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);

				myField1 = myForm.addField(IMOAOPackage.Literals.NAMED_OBJECT__NAME).label("hello");

				myForm.finish();
			}
		});

		testFieldLayout((Composite) myForm.getTop().getChildren()[0], 0, myField1, "hello:", myShopItem.getName());
	}

	/**
	 * Tests that the creation of a basic field uses the {@link IValueBinding#arg(String, Object)}
	 * information properly. With focus on {@link Constants#ARG_PREFERRED_CONTROL}.
	 */
	@Test
	public void testBasicFieldArgPreferredControl() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myForm = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);

				myField1 = myForm.addField(IMOAOPackage.Literals.NAMED_OBJECT__NAME).arg(Constants.ARG_PREFERRED_CONTROL,
						StyledText.class.getName());

				myForm.finish();
			}
		});

		// Assumes Text widget testFieldLayout(myForm.getTop(), 0, myField1, "Name:",
		// myShopItem.getName());
		final Composite top = (Composite) myForm.getTop().getChildren()[0];
		final Control control = top.getChildren()[1];
		assertTrue(control instanceof StyledText);
	}

	/**
	 * Tests the creation of fields via specs
	 */
	@Test
	public void testBasicFieldSpec() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myForm = IFormCreator.Factory.createForm(myContext, myContact, myToolkit, myBody);

				myField1 = myForm.addField("name");
				myField2 = myForm.addField("shop.name");

				myForm.finish();
			}
		});

		testFieldLayout((Composite) myForm.getTop().getChildren()[0], 0, myField1, "Name:", myContact.getName());
		testFieldLayout((Composite) myForm.getTop().getChildren()[0], 1, myField2, "Name:", myShop.getName());
	}

	/**
	 * Tests the creation of RO field via specs
	 */
	@Test
	public void testSpecRO() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myForm = IFormCreator.Factory.createForm(myContext, myContact, myToolkit, myBody);

				myField1 = myForm.addField("name(readonly=true)");

				myForm.finish();
			}
		});

		final int style = myField1.getControl().getStyle();
		assertTrue((style & SWT.READ_ONLY) == SWT.READ_ONLY);
	}

	/**
	 * Tests the creation of password field via specs
	 */
	@Test
	public void testSpecPASSWORD() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myForm = IFormCreator.Factory.createForm(myContext, myContact, myToolkit, myBody);

				myField1 = myForm.addField("name(password=true)");

				myForm.finish();
			}
		});

		final int style = myField1.getControl().getStyle();
		assertTrue((style & SWT.PASSWORD) == SWT.PASSWORD);
	}

	/**
	 * Tests the creation of center aligned field via specs
	 */
	@Test
	public void testSpecAlignment() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myForm = IFormCreator.Factory.createForm(myContext, myContact, myToolkit, myBody);

				myField1 = myForm.addField("name(a=c)");

				myForm.finish();
			}
		});

		final int style = myField1.getControl().getStyle();
		assertTrue((style & SWT.CENTER) == SWT.CENTER);
	}

	protected Text myFocusText;

	/**
	 * Tests the correct control regains focus when {@link IFormCreator#setFocus()} is called
	 */
	@Test
	public void testFocusManagement() {
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myFocusText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
				myFocusText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				myFocusText.setText("hello");

				myForm = IFormCreator.Factory.createForm(myContext, myContact, myToolkit, myBody);

				myField1 = myForm.addField("name");
				myField2 = myForm.addField("shop.name");

				myForm.finish();
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myForm.setFocus();

				assertTrue(myField1.getControl().isFocusControl());
				assertTrue(myField2.getControl().setFocus());
				assertTrue(myField2.getControl().isFocusControl());
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertTrue(myFocusText.setFocus());
				assertTrue(!myField1.getControl().isFocusControl());
				assertTrue(!myField2.getControl().isFocusControl());
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myForm.setFocus();

				assertTrue(myField2.getControl().isFocusControl());
			}
		});
	}

	/**
	 * @param parent TODO
	 * @param fieldNo TODO
	 * @param binding TODO
	 * @param expectedLabelText TODO
	 * @param expectedTextText TODO
	 * 
	 */
	private void testFieldLayout(Composite parent, int fieldNo, IValueBinding binding, String expectedLabelText,
			String expectedTextText) {
		final Control[] children = parent.getChildren();
		assertTrue(children.length >= 2 * (fieldNo + 1));

		assertTrue(children[2 * fieldNo + 0] instanceof Label);
		final Label label = (Label) children[2 * fieldNo + 0];
		assertEquals(expectedLabelText, label.getText());
		// TODO: label covers first column

		assertTrue(children[2 * fieldNo + 1] instanceof Text);
		final Text text = (Text) children[2 * fieldNo + 1];
		assertEquals(binding, IBindingContext.Factory.getBindingForWidget(text));
		assertEquals(expectedTextText, text.getText());
		assertTrue((text.getStyle() & SWT.READ_ONLY) != SWT.READ_ONLY);
		// TODO: label covers last column
	}

	/**
	 * Tests the style argument of
	 * {@link IFormCreator#addField(String, org.eclipse.emf.ecore.EStructuralFeature, int)}.
	 */
	@Test
	public void testBasicFieldStyle() {
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myBody);
				myForm = IFormCreator.Factory.createForm(myContext, myShopItem, myToolkit, myBody);

				myField1 = myForm.addField(IMOAOPackage.Literals.NAMED_OBJECT__NAME, SWT.MULTI);

				myForm.finish();
			}
		});

		final Composite top = (Composite) myForm.getTop().getChildren()[0];

		final Text t = (Text) (top.getChildren())[1];
		assertTrue((t.getStyle() & SWT.MULTI) == SWT.MULTI);
	}
}
