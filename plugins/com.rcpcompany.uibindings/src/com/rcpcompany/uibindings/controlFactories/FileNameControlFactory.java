package com.rcpcompany.uibindings.controlFactories;

import java.io.File;
import java.lang.reflect.Array;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IControlFactory;
import com.rcpcompany.uibindings.IControlFactoryContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link IControlFactory} for file names
 * 
 * @author Lasse Bjermeland lasse.bjermeland@marintek.sintef.no
 */
public class FileNameControlFactory implements IControlFactory {

	@Override
	public Control create(final IControlFactoryContext context) {
		final EStructuralFeature feature = context.getBinding().getModelFeature();
		if (!feature.getEType().getInstanceClass().isAssignableFrom(String.class)) {
			LogUtils.error(this, "Feature must be of type string"); //$NON-NLS-1$
		}

		final IManager manager = IManager.Factory.getManager();
		final FormToolkit toolkit = manager.getFormToolkit();
		final Composite chooserComposite = toolkit.createComposite(context.getParent(), SWT.FILL);
		final GridLayout chooserLayout = new GridLayout(2, false);
		chooserLayout.marginTop = 0;
		chooserLayout.marginWidth = 0;
		chooserComposite.setLayout(chooserLayout);

		final Text fileNameField = toolkit.createText(chooserComposite, "", SWT.READ_ONLY); //$NON-NLS-1$
		final GridData layoutData = new GridData(SWT.LEFT, SWT.TOP, true, false);
		fileNameField.setLayoutData(layoutData);

		final Button dllButton = toolkit.createButton(chooserComposite, "...", SWT.PUSH); //$NON-NLS-1$
		dllButton.setToolTipText("Browse"); //$NON-NLS-1$
		dllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final FileDialog dialog = new FileDialog(context.getParent().getShell(), SWT.NULL);
				final Object ext = context.getBinding().getArgument(Constants.ARG_EXTENSIONS, Array.class, null);
				if (ext instanceof String[]) {
					final String[] extensions = (String[]) ext;
					dialog.setFilterExtensions(extensions);
				}
				final String path = dialog.open();
				if (path != null) {
					final File file = new File(path);
					if (file.isFile()) {
						final Runnable runnable = new Runnable() {
							public void run() {
								final EObject object = context.getBinding().getModelObject();
								if (object == null) {
									LogUtils.error(this, "Binding object is null"); //$NON-NLS-1$
								}
								final EStructuralFeature feature = context.getBinding().getModelFeature();

								final EditingDomain ed = context.getBinding().getContext().getEditingDomain();
								SetCommand.create(ed, object, feature, file.toString());
							}
						};
						context.getParent().getDisplay().syncExec(runnable);
					}
				}
			}
		});
		return fileNameField;
	}
}
