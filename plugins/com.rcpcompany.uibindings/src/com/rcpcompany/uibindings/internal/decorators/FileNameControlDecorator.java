package com.rcpcompany.uibindings.internal.decorators;

import java.io.File;
import java.util.Arrays;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.decorators.BaseUIBindingDecorator;
import com.rcpcompany.uibindings.utils.IPathMatcher;
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
	 * Allowed extensions.
	 */
	protected String[] myFilters;

	/**
	 * Whether only existing file and directories are allowed.
	 */
	protected boolean myExistingOnly;

	/**
	 * Whether directories or files are managed.
	 */
	protected boolean myDirectoryMode = false;

	private String[] myFilterNames;

	@Override
	public void init(IValueBinding binding) {
		super.init(binding);

		initForValidation(binding);
	}

	/**
	 * Special version of init when the decorator is only used for validation.
	 * 
	 * @param binding the binding
	 */
	public void initForValidation(IValueBinding binding) {
		setBinding(binding);

		myExistingOnly = getBinding().getArgument(Constants.ARG_NEW_ALLOWED, Boolean.class, true);

		final String extensions = getBinding().getArgument(Constants.ARG_EXTENSIONS, String.class, null);

		if (extensions != null) {
			final String[] groups = extensions.split("///");

			myFilters = new String[groups.length];
			myFilterNames = new String[groups.length];
			boolean namesSeen = false;

			for (int j = 0; j < groups.length; j++) {
				final String g = groups[j];
				final int i = g.indexOf(':');
				if (i == -1) {
					myFilters[j] = g;
				} else if (i == 0) {
					LogUtils.debug(this, "Extensions '" + extensions + "' is malformed: empty labels");
					myFilters[j] = g.substring(i + 1);
				} else if (i == g.length() - 1) {
					LogUtils.debug(this, "Extensions '" + extensions + "' is malformed: empty filters");
					namesSeen = true;
					myFilterNames[j] = g.substring(0, i);
					myFilters[j] = "*.*";
				} else {
					namesSeen = true;
					myFilterNames[j] = g.substring(0, i);
					myFilters[j] = g.substring(i + 1);
				}
			}
			if (namesSeen) {
				for (final String s : myFilterNames) {
					if (s == null) {
						LogUtils.debug(this, "Extensions '" + extensions
								+ "' is malformed: some, but not all groups have labels");
						myFilterNames = null;
						break;
					}
				}
			} else {
				myFilterNames = null;
			}
		}
	}

	@Override
	public void decorateMisc() {
		super.decorateMisc();

		if (getBinding().getControl() instanceof FileNameControl) {
			final FileNameControl fnw = (FileNameControl) getBinding().getControl();
			fnw.setDirectoryMode(myDirectoryMode);
			fnw.setExtensions(myFilterNames, myFilters);
			fnw.setDialogTitle(getBinding().getLabel());
			fnw.setExistingOnly(myExistingOnly);
		}
	}

	@Override
	public void decorateAssist() {
		/*
		 * Bind field assist
		 */
		final IContentProposalProvider proposalProvider = new FileNameContentProposalProvider(myDirectoryMode,
				myFilters);

		setupContentProposalProvider(proposalProvider);
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
					if (!file.exists())
						return UIBindingsUtils.error(IManager.Factory.getManager().isValidationErrorsAreFatal(),
								FILE_NAME_ERROR_CODE, "File does not exist");
				}

				/*
				 * Check type (file/directory)
				 */
				if (myDirectoryMode && !file.isDirectory())
					return UIBindingsUtils.error(IManager.Factory.getManager().isValidationErrorsAreFatal(),
							FILE_NAME_ERROR_CODE, "Directory expected");
				else if (!myDirectoryMode && !file.isFile())
					return UIBindingsUtils.error(IManager.Factory.getManager().isValidationErrorsAreFatal(),
							FILE_NAME_ERROR_CODE, "File expected");

				/*
				 * - Check extension
				 */
				if (myFilters != null) {
					final String extString = Arrays.toString(myFilters);
					final String fv = file.getName();
					LogUtils.debug(this, "Check '" + v + "' (" + fv + ") against " + extString);
					boolean f = false;
					for (final String es : myFilters) {
						for (final String e : es.split(";")) {
							if (IPathMatcher.Factory.getPathMatcher("glob:" + e).matches(fv)) {
								f = true;
								break;
							}
						}
						if (f) {
							break;
						}
					}
					if (!f)
						return UIBindingsUtils.error(IManager.Factory.getManager().isValidationErrorsAreFatal(),
								FILE_NAME_ERROR_CODE, "File should end with one of " + extString);
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
