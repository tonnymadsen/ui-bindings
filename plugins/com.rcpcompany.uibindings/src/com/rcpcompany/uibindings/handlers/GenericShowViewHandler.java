package com.rcpcompany.uibindings.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This handler shows a specific view that is specified as the extension data for the handler class.
 * <p>
 * If the created view supports the {@link ISetSelectionTarget} interface, then the current cell
 * element is set as the new selection.
 * <p>
 * E.g.
 * 
 * <pre>
 * &lt;extension point=&quot;org.eclipse.ui.handlers&quot;&gt;
 *     &lt;handler
 *             class=&quot;com.rcpcompany.uibindings.utils.GenericCommandHandler:org.eclipse.ui.views.showView(org.eclipse.ui.views.showView.viewId=com.rcpcompany.uibindings.example.application.views.InventoryView)&quot;
 *             commandId=&quot;com.rcpcompany.uibindings.commands.open&quot;&gt;
 *         &lt;activeWhen&gt;
 *             &lt;with variable=&quot;com.rcpcompany.uibindings.sourceProviders.currentCellValue&quot;&gt;
 *                 &lt;instanceof value=&quot;com.rcpcompany.uibindings.tests.shop.Country&quot; /&gt;
 *             &lt;/with&gt;
 *         &lt;/activeWhen&gt;
 *     &lt;/handler&gt;
 * &lt;/extension&gt;
 * </pre>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericShowViewHandler extends AbstractHandler implements IHandler, IExecutableExtension {
	@Override
	public Object execute(ExecutionEvent ee) throws ExecutionException {
		String sourceVariable = ee.getParameter("sourceVariable"); //$NON-NLS-1$
		if (sourceVariable == null) {
			sourceVariable = Constants.SOURCES_ACTIVE_BINDING_VALUE;
		}
		final Object selectedObject = HandlerUtil.getVariable(ee, sourceVariable);

		ISelection selection = null;
		if (selectedObject != null) {
			selection = new StructuredSelection(selectedObject);
		} else {
			selection = HandlerUtil.getCurrentSelection(ee);
		}

		if (selection == null || selection.isEmpty()) throw new ExecutionException("No selection found"); //$NON-NLS-1$

		String viewID = myViewID;
		if (viewID == null) {
			viewID = ee.getParameter("viewId"); //$NON-NLS-1$
		}
		if (viewID == null || viewID.length() == 0) throw new ExecutionException("No view ID specified"); //$NON-NLS-1$

		IGlobalNavigationManager.Factory.addLocation();
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "open view: " + viewID //$NON-NLS-1$
					+ (selectedObject != null ? ("\ncurrentCell: " + selectedObject) : "")); //$NON-NLS-1$ //$NON-NLS-2$
		}
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(ee);
		if (window == null) {
			window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		}

		try {
			final IViewPart view = window.getActivePage().showView(viewID);
			if (view instanceof ISetSelectionTarget && !selection.isEmpty()) {
				final ISetSelectionTarget selectionTarget = (ISetSelectionTarget) view;

				selectionTarget.selectReveal(selection);
			}
		} catch (final PartInitException ex) {
			LogUtils.error(this, ex);
		}

		return null;
	}

	/**
	 * The view to show.
	 */
	private String myViewID;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		myViewID = (String) data;
	}
}
