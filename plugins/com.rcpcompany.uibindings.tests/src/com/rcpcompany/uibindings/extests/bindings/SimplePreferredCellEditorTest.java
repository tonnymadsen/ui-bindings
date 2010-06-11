package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.postKeyStroke;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.postMouse;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;

/**
 * Tests that the correct simple cell editor widget is used for the simple data types.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @see PreferredCellEditorFactoryTest
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class SimplePreferredCellEditorTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ TestModelPackage.Literals.TEST_OBJECT__TEXT, Text.class },
				{ TestModelPackage.Literals.TEST_OBJECT__B, null },
				{ TestModelPackage.Literals.TEST_OBJECT__UNIT, CCombo.class },
				{ TestModelPackage.Literals.TEST_OBJECT__NUMBER, Text.class },
				{ TestModelPackage.Literals.TEST_OBJECT__F, Text.class },
				{ TestModelPackage.Literals.TEST_OBJECT__BIG_DECIMAL, StyledText.class },

		});
	}

	private WritableList myList;
	private TestObject myTestObject;

	private TestView myView;
	private Composite myBody;
	private TableViewer myViewer;
	private TableViewerColumn myColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private final EStructuralFeature myFeature;
	private final Class<? extends Control> myExpectedCellEditor;

	public SimplePreferredCellEditorTest(EStructuralFeature feature, Class<? extends Control> expectedCellEditor) {
		myFeature = feature;
		myExpectedCellEditor = expectedCellEditor;
	}

	@Before
	public void setup() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();
	}

	private void createModel() {
		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
		myList = WritableList.withElementType(myTestObject.eClass());
		myList.add(myTestObject);
	}

	private void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myViewer = new TableViewer(myBody, SWT.FULL_SELECTION);
		myViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		myColumn = new TableViewerColumn(myViewer, SWT.NONE);
		myColumn.getColumn().setWidth(100);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myViewerBinding = myContext.addViewer(myViewer, myList);
		myViewerBinding.addColumn(myColumn, myFeature);

		myContext.finish();
		yield();
	}

	@Test
	public void testCellEditor() {
		final Table table = myViewer.getTable();

		postMouse(table, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
		yield();

		postKeyStroke(table, "ENTER");
		yield();

		if (myExpectedCellEditor == null) {
			assertTrue(!myViewer.isCellEditorActive());
		} else {
			assertTrue(myViewer.isCellEditorActive());

			final EList<IBinding> bindings = myContext.getBindings();
			final IBinding binding = bindings.get(bindings.size() - 1);

			final Control control = binding.getControl();
			assertTrue(myExpectedCellEditor.isInstance(control));
		}
		myViewer.cancelEditing();
	}
}
