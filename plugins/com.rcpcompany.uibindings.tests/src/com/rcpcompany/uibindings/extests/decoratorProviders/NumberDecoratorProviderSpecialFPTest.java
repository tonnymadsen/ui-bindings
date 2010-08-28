package com.rcpcompany.uibindings.extests.decoratorProviders;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IFormatter;
import com.rcpcompany.uibindings.IFormatterProvider;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.INumberDecoratorProvider;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests that the {@link IManager#getFormatterProvider()} is used by
 * {@link INumberDecoratorProvider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NumberDecoratorProviderSpecialFPTest {
	private TestView myView;
	private Composite myBody;

	private IBindingContext myContext;

	private Text myText;
	private IValueBinding myBinding;

	private TestObject myTestObject;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(500);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
	}

	private void createModel() {
		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
	}

	private void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myBinding = myContext.addBinding(myText, myTestObject, TestModelPackage.Literals.TEST_OBJECT__D).type("NULL");

		myContext.finish();
		yield();
	}

	@Test
	public void testDefaultFP() {
		IManager.Factory.getManager().setFormatterProvider(null);

		bindUI();
		/*
		 * The format is "ULL" via the number binding decoration declaration...
		 */
		testOne(45.0, "NULL format");
	}

	@Test
	public void testSpecialFP() {
		IManager.Factory.getManager().setFormatterProvider(new SpecialFP());

		bindUI();
		testOne(45.0, "NULL value");
	}

	/**
	 * Tests one specific value with a specific result.
	 * 
	 * @param value the value to test
	 * @param expectedResult the expected result
	 */
	private void testOne(final double value, final String expectedResult) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myTestObject.setD(value);
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				yield();
			}
		});
		assertEquals(expectedResult, myText.getText());
	}

	public class SpecialFP implements IFormatterProvider {

		@Override
		public IFormatter getFormatter(final Appendable dest, String format) {
			assertEquals("NULL format", format);
			return new IFormatter() {

				@Override
				public void format(Object... args) {
					try {
						dest.append("NULL value");
					} catch (final IOException ex) {
						LogUtils.error(this, ex);
					}
				}
			};
		}
	}
}
