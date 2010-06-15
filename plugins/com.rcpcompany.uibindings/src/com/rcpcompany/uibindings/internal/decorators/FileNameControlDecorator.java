package com.rcpcompany.uibindings.internal.decorators;

import java.io.File;
import java.util.Arrays;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.decorators.BaseUIBindingDecorator;
import com.rcpcompany.uibindings.widgets.FileNameControl;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This is a binding decorator for {@link Constants#TYPE_FILE_NAME}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FileNameControlDecorator extends BaseUIBindingDecorator implements IUIBindingDecorator,
		IExecutableExtension {
	/**
	 * The error code used in {@link IBindingMessage messages} for number errors.
	 */
	public static final int FILE_NAME_ERROR_CODE = 1010;

	/**
	 * Allowed extension as specified in {@link FileNameControl#setExtensions(String[])}
	 */
	protected String[] myExtensions;

	/**
	 * Whether only existing file and directories are allowed
	 */
	protected boolean myExistingOnly;
	protected boolean myDirectoryMode = false;

	@Override
	public void init(IValueBinding binding) {
		super.init(binding);

		initForValidation(binding);
	}

	/**
	 * Special version of init when the decorator is only used for validation
	 * 
	 * @param binding the binding
	 */
	public void initForValidation(IValueBinding binding) {
		setBinding(binding);

		final String a = getBinding().getArgument(Constants.ARG_EXTENSIONS, String.class, null);
		if (a == null) {
			myExtensions = null;
		} else if (a instanceof String) {
			myExtensions = FileNameControl.parseExtensions(a);
		} else {
			LogUtils.error(this, Constants.ARG_EXTENSIONS + " in invalid format '" + a + "'");
		}
		myExistingOnly = getBinding().getArgument(Constants.ARG_NEW_ALLOWED, Boolean.class, true);
	}

	@Override
	public void decorateMisc() {
		super.decorateMisc();

		if (getBinding().getControl() instanceof FileNameControl) {
			final FileNameControl fnw = (FileNameControl) getBinding().getControl();
			fnw.setDirectoryMode(myDirectoryMode);
			fnw.setExtensions(myExtensions);
			fnw.setDialogTitle(getBinding().getLabel());
			fnw.setExistingOnly(myExistingOnly);
		}
	}

	@Override
	public void decorateAssist() {
		// TODO: install file completer
	}

	@Override
	public IValidator getUIToModelAfterConvertValidator() {
		return new IValidator() {
			@Override
			public IStatus validate(Object value) {
				final String v = (String) value;
				final File file = new File(v);

				/*
				 * - Check existance
				 */
				if (myExistingOnly) {
					if (!file.exists()) {
						return UIBindingsUtils.error(IManager.Factory.getManager().isValidationErrorsAreFatal(),
								FILE_NAME_ERROR_CODE, "File does not exist");
					}
				}

				/*
				 * Check type (file/directory)
				 */
				if (myDirectoryMode && !file.isDirectory()) {
					return UIBindingsUtils.error(IManager.Factory.getManager().isValidationErrorsAreFatal(),
							FILE_NAME_ERROR_CODE, "Directory expected");
				} else if (!myDirectoryMode && !file.isFile()) {
					return UIBindingsUtils.error(IManager.Factory.getManager().isValidationErrorsAreFatal(),
							FILE_NAME_ERROR_CODE, "File expected");
				}

				/*
				 * - Check extension
				 */
				if (myExtensions != null) {
					final int i = file.getName().lastIndexOf('.');
					if (i == -1) {
						return UIBindingsUtils.warning(FILE_NAME_ERROR_CODE, "File does not have an extension");
					}
					final String ext = file.getName().substring(i + 1);
					LogUtils.debug(this, "Check '" + v + "' (" + ext + ") against " + Arrays.toString(myExtensions));
					boolean f = false;
					for (final String myExtension : myExtensions) {
						String s = myExtension;
						if (s.startsWith("*.")) {
							s = s.substring(2);
						}
						if (ext.equals(s)) {
							f = true;
							break;
						}
					}
					if (!f) {
						return UIBindingsUtils.error(IManager.Factory.getManager().isValidationErrorsAreFatal(),
								FILE_NAME_ERROR_CODE, "File should end with one of " + Arrays.toString(myExtensions));
					}
				}

				return Status.OK_STATUS;
			}
		};
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		if ("file".equals(data)) {
			myDirectoryMode = false;
		} else if ("directory".equals(data)) {
			myDirectoryMode = true;
		} else {
			myDirectoryMode = false;
		}
	}

	public String checkValue(Object value) {
		return null;
	}
}
