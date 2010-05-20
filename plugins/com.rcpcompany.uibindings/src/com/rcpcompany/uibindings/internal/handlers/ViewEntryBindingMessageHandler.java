package com.rcpcompany.uibindings.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Shows a single {@link IBindingMessage} in a popup dialog.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewEntryBindingMessageHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell shell = HandlerUtil.getActiveShellChecked(event);
		final ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);

		// final List<IBindingMessage> selectedList = SelectionUtils.computeSelection(selection, IBindingMessage.class);
		// if (selectedList.size() == 0)
		// return null;

		if (!(selection instanceof IStructuredSelection)) {
			return null;
		}
		final IStructuredSelection ss = (IStructuredSelection) selection;
		final Object element = ss.getFirstElement();
		if (!(element instanceof IBindingMessage)) {
			return null;
		}
		final IBindingMessage message = (IBindingMessage) element;

		final MyDialog dialog = new MyDialog(shell, message);
		dialog.open();

		return null;
	}

	/**
	 * Dialog used to show one message.
	 */
	protected static class MyDialog extends PopupDialog {
		private final IBindingMessage myMessage;
		private IFormCreator myForm;

		/**
		 * Constructs and returns a new dialog
		 * 
		 * @param shell the shell
		 * @param message the message to show
		 */
		public MyDialog(Shell shell, IBindingMessage message) {
			super(shell, SWT.ON_TOP | SWT.RESIZE, true, true, false, false, false, null, "Press 'Escape' to close");
			// super(shell);
			myMessage = message;
		}

		/**
		 * ID used for the {@link IDialogSettings} of this dialog.
		 */
		public final String ID = ViewEntryBindingMessageHandler.class.getName();

		@Override
		protected IDialogSettings getDialogSettings() {
			final IDialogSettings settings = Activator.getDefault().getDialogSettings();
			IDialogSettings result = settings.getSection(ID);
			if (result == null) {
				result = settings.addNewSection(ID);
			}
			return result;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			final Composite top = (Composite) super.createDialogArea(parent);

			myForm = IFormCreator.Factory.createScrolledForm(myMessage, top, "");

			myForm.getToolkit().adapt(top);
			myForm.setReadOnly(true);

			myForm.getContext().addBinding(myForm.getScrolledForm(), myMessage,
					IUIBindingsPackage.Literals.BINDING_MESSAGE__MESSAGE);

			myForm.addField("severity").arg(Constants.ARG_PREFERRED_CONTROL, CLabel.class.getName());
			final EList<IBindingMessageTarget> targets = myMessage.getTargets();
			switch (targets.size()) {
			case 0:
				myForm.addLabel("No targets for message");
				break;
			case 1:
				final WritableValue firstTarget = WritableValue
						.withValueType(IUIBindingsPackage.Literals.BINDING_MESSAGE_TARGET);
				firstTarget.setValue(targets.get(0));
				final IFormCreator subForm = myForm.subForm(myForm.addComposite(), firstTarget);
				subForm.addField("modelObject(label='Object')").dynamic().type(Constants.TYPE_LONG_NAME).arg(
						Constants.ARG_PREFERRED_CONTROL, CLabel.class.getName());
				subForm.addField("modelFeature(label='Feature')");
				break;
			default:
				final ITableCreator tableCreator = myForm.addTableCreator(
						IUIBindingsPackage.Literals.BINDING_MESSAGE__TARGETS, false, SWT.NONE);
				tableCreator.getBinding().readonly();
				tableCreator.addColumn("modelObject(w=200,label='Object')").dynamic().type(Constants.TYPE_LONG_NAME);
				tableCreator.addColumn("modelFeature(w=200,label='Feature')");
				break;
			}
			myForm.addField("message");
			myForm.addField("details(multi,sb=v)");

			myForm.finish();
			// TODO: ContextSelectionProvider.adapt(myForm.getContext(), getSite());

			return top;
		}

		@Override
		protected Color getForeground() {
			return myForm.getToolkit().getColors().getForeground();
		}

		@Override
		protected Color getBackground() {
			return myForm.getToolkit().getColors().getBackground();
		}
	}
}
