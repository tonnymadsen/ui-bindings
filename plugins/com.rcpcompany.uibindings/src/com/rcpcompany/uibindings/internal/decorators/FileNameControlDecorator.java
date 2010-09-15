package com.rcpcompany.uibindings.internal.decorators;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingMessage;
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
	private String[] myFilters;

	/**
	 * Whether only existing file and directories are allowed.
	 */
	private boolean myExistingOnly;

	/**
	 * Whether directories or files are managed.
	 * <p>
	 * <code>true</code> if only directories are acceptable.
	 */
	private boolean myDirectoryMode = false;

	private String[] myFilterNames;

	@Override
	public void init(IValueBinding binding) {
		super.init(binding);

		initForValidation(binding);
	}

	/**
	 * Validates the specified value and returns a coresponding status.
	 * 
	 * @param value the {@link String} value to validate
	 * @return the status value
	 */
	public IStatus validateValue(Object value) {
		final String v = (String) value;
		final File file = new File(v);
		final String fv = file.getAbsolutePath();
//		LogUtils.debug(this, "f='" + value + "' (" + fv + ")");

		/*
		 * - Check existance
		 */
		if (myExistingOnly) {
			if (!file.exists()) return validationError("File does not exist");
		}

		/*
		 * Check type (file/directory)
		 */
		if (myDirectoryMode && !file.isDirectory())
			return validationError("Directory expected");
		else if (!myDirectoryMode && !file.isFile()) return validationError("File expected");

		/*
		 * - Check extension
		 */
		if (myFilters != null) {
			// LogUtils.debug(this, "Check '" + v + "' (" + fv + ") against " + extString);
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
			if (!f) return validationError("File should match one of " + Arrays.toString(myFilters));
		}

		return Status.OK_STATUS;
	}

	/**
	 * Returns a new error {@link IStatus} with the specified message.
	 * 
	 * @param m the message of the status
	 * @return the status object
	 */
	private IStatus validationError(final String m) {
//		LogUtils.debug(this, "-- " + m);
		return UIBindingsUtils.error(FILE_NAME_ERROR_CODE, m);
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
		final IContentProposalProvider proposalProvider = new FileNameContentProposalProvider();

		setupContentProposalProvider(proposalProvider);
	}

	/**
	 * {@link IContentProposalProvider} for file and directory names.
	 */
	private class FileNameContentProposalProvider implements IContentProposalProvider {
		/*
		 * A single file name proposal.
		 */
		private final class FileNameContentProposal implements IContentProposal {
			private final String myNewText;

			private FileNameContentProposal(String existingText) {
				myNewText = existingText;
			}

			@Override
			public String getLabel() {
				return null;
			}

			@Override
			public String getDescription() {
				return null;
			}

			@Override
			public int getCursorPosition() {
				return myNewText.length();
			}

			@Override
			public String getContent() {
				return myNewText;
			}
		}

		private final String separator = "" + File.separatorChar;
		private List<IContentProposal> myProposals;
		private String myExistingText;

		@Override
		public IContentProposal[] getProposals(String contents, int position) {
			myExistingText = contents.substring(0, position);
			myProposals = new ArrayList<IContentProposal>();

			calculateProposals();

			return myProposals.toArray(new IContentProposal[myProposals.size()]);
		}

		private void calculateProposals() {
			/*
			 * Test if the current text is a good proposal...
			 */
			if (validateValue(myExistingText) == Status.OK_STATUS) {
				addProposal(myExistingText);
			}

			/*
			 * If the current text cannot even be a partial match, then don't bother
			 */
			if (!pmatches(myExistingText)) return;

			/*
			 * Split the current name into a directory name and a last part.
			 */
			final int lastSeparator = myExistingText.lastIndexOf(File.separatorChar);
			final String dirName;
			final String lastName;
			if (lastSeparator == -1) {
				lastName = myExistingText.toLowerCase();
				dirName = separator;
			} else {
				lastName = myExistingText.substring(lastSeparator + 1).toLowerCase();
				dirName = myExistingText.substring(0, lastSeparator + 1);
			}
			final String[] names = new File(dirName).list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().startsWith(lastName);
				}
			});
			if (names != null) {
				for (final String n : names) {
					final String path = dirName + n;
					if (new File(path).isDirectory() && pmatches(path + separator)) {
						addProposal(path + separator);
					} else if (!myDirectoryMode && pmatches(path)) {
						addProposal(path);
					}
				}
			}

			/*
			 * See if the existing text is a directory, and than directory could be a valid start of
			 * a file name...
			 */
			if (new File(myExistingText).isDirectory()) {
				if (myExistingText.endsWith(separator)) {
					final String[] names2 = new File(myExistingText).list();
					if (names2 != null) {
						for (final String n : names2) {
							final String path = myExistingText + n;
							if (new File(path).isDirectory() && pmatches(path + separator)) {
								addProposal(path + separator);
							} else if (!myDirectoryMode && pmatches(path)) {
								addProposal(path);
							}
						}
					}
				} else {
					addProposal(myExistingText + separator);
				}
			}
		}

		/**
		 * Adds a new proposal to the list of proposals.
		 * 
		 * @param s proposed file name
		 */
		private void addProposal(final String s) {
			myProposals.add(new FileNameContentProposal(s));
		}

		private boolean pmatches(String path) {
			for (final String es : myFilters) {
				for (final String e : es.split(";")) {
					if (IPathMatcher.Factory.getPathMatcher("glob:" + e).partiallyMatches(path)) return true;
				}
			}
			return false;
		}
	}

	@Override
	public IValidator getUIToModelAfterConvertValidator() {
		return new IValidator() {
			@Override
			public IStatus validate(Object value) {
				return validateValue(value);
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
}
