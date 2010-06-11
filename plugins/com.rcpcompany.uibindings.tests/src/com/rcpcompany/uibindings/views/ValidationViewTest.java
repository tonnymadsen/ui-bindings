package com.rcpcompany.uibindings.views;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.showView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Test of the {@link ValidationView}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValidationViewTest {
	public static final String VIEW_ID = ValidationView.class.getName();

	@Before
	public void before() {

	}

	/**
	 * Tests that the showView command can show the view
	 */
	@Test
	public void testShowViewCommand() {
		final IWorkbench wb = PlatformUI.getWorkbench();
		final IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();

		IViewPart view = page.findView(VIEW_ID);
		if (view != null) {
			page.hideView(view);
		}
		view = page.findView(VIEW_ID);
		assertNull(view);

		yield();

		final ICommandService cs = (ICommandService) wb.getService(ICommandService.class);
		final IHandlerService hs = (IHandlerService) wb.getService(IHandlerService.class);

		assertNotNull(cs);
		assertNotNull(hs);

		ParameterizedCommand command;
		try {
			command = cs.deserialize("org.eclipse.ui.views.showView(org.eclipse.ui.views.showView.viewId=" + VIEW_ID
					+ ")");
			assertNotNull(command);

			hs.executeCommand(command, null);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}

		view = page.findView(VIEW_ID);
		assertNotNull(view);
		assertTrue(view instanceof ValidationView);
	}

	/**
	 * Tests that the validation view have all the needed widgets...
	 * <p>
	 * Top{Composite{Label,Text,...},Table{}}
	 */
	@Test
	public void testLayout() {
		final ValidationView view = (ValidationView) showView(VIEW_ID);

		final Composite top = view.myTop;
		assertNotNull(top);

		Control[] children = null;

		children = top.getChildren();
		assertEquals(1, children.length);
		assertTrue(children[0] instanceof Composite);

		children = ((Composite) children[0]).getChildren();
		assertEquals(2, children.length);
		assertTrue(children[1] instanceof Table);

		final Table t = (Table) children[1];

		final TableColumn[] columns = t.getColumns();
		final ITableCreator tableCreator = view.myTable;
		assertEquals(4 + tableCreator.getBinding().getFirstTableColumnOffset(), columns.length);

		testOneColumn(columns[0 + tableCreator.getBinding().getFirstTableColumnOffset()], "");
		testOneColumn(columns[1 + tableCreator.getBinding().getFirstTableColumnOffset()], "Object");
		testOneColumn(columns[2 + tableCreator.getBinding().getFirstTableColumnOffset()], "Feature");
		testOneColumn(columns[3 + tableCreator.getBinding().getFirstTableColumnOffset()], "Message");
	}

	private void testOneColumn(TableColumn col, String heading) {
		assertNotNull(col);
		assertEquals(heading, col.getText());
	}
}
