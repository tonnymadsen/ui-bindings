/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SearchPattern;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.utils.IFilteringTableAdapter;
import com.rcpcompany.uibindings.utils.IManagerRunnable;

/**
 * Column filter based on an {@link IViewerBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FilteringTableAdapter implements IFilteringTableAdapter, DisposeListener {

	/**
	 * Initial text for filter Text widget.
	 */
	public static final String TYPE_FILTER_TEXT = "type filter text";

	/**
	 * Image descriptor for enabled clear button.
	 */
	private static final String CLEAR_ICON = "org.eclipse.ui.internal.dialogs.CLEAR_ICON"; //$NON-NLS-1$

	/**
	 * Image descriptor for disabled clear button.
	 */
	private static final String DCLEAR_ICON = "org.eclipse.ui.internal.dialogs.DCLEAR_ICON"; //$NON-NLS-1$

	/**
	 * Constructs and initializes a new filter...
	 * 
	 * @param viewer the binding
	 * @param filter the filter observable
	 * @param text the Text widget that holds the current filter
	 */
	public FilteringTableAdapter(IViewerBinding viewer, IObservableValue filter, Text text) {
		myViewerBinding = viewer;
		myFilter = filter;
		myText = text;
		Assert.isLegal(myViewerBinding.getViewer() instanceof TableViewer, "The filter only accepts tables");
		myTableViewer = (TableViewer) myViewerBinding.getViewer();
		myTable = myTableViewer.getTable();
		init();
	}

	/**
	 * Initializes this filter.
	 */
	protected void init() {
		myViewerBinding.registerService(this);
		myFilter.addValueChangeListener(myFilterListener);
		myFilterListener.handleValueChange(null);
		myTable.addDisposeListener(this);

		if (myText != null) {
			// if we're using a field with built in cancel we need to listen for
			// default selection changes (which tell us the cancel button has been
			// pressed)
			if ((myText.getStyle() & SWT.CANCEL) != 0) {
				myText.addSelectionListener(myFilterClearListener);
			}
			myText.addFocusListener(myFilterFocusListener);
			myText.addKeyListener(myFilterKeylistener);
			myTable.addKeyListener(myTableKeylistener);
		}
	}

	/**
	 * Removes the filtering functionality again.
	 */
	@Override
	public void dispose() {
		if (myText != null && !myText.isDisposed()) {
			if ((myText.getStyle() & SWT.CANCEL) != 0) {
				myText.removeSelectionListener(myFilterClearListener);
			}
			myText.removeFocusListener(myFilterFocusListener);
			myText.removeKeyListener(myFilterKeylistener);
			myTable.removeKeyListener(myTableKeylistener);
		}
		myFilter.removeValueChangeListener(myFilterListener);
		myTableViewer.removeFilter(myViewerFilter);
		myTable.removeDisposeListener(this);
		myViewerBinding.unregisterService(this);
	}

	/**
	 * The binding.
	 */
	protected final IViewerBinding myViewerBinding;

	/**
	 * The table viewer in play.
	 */
	protected final TableViewer myTableViewer;

	/**
	 * The table itself.
	 */
	protected final Table myTable;

	/**
	 * An observable value for the current filter.
	 */
	protected final IObservableValue myFilter;

	/**
	 * The text field with the filter string - can be <code>null</code>.
	 */
	protected final Text myText;

	/**
	 * A search pattern with the current value of the filter.
	 */
	protected SearchPattern mySearchPattern = new SearchPattern();

	/**
	 * Viewer filter used for the table.
	 */
	protected ViewerFilter myViewerFilter = new ViewerFilter() {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			for (final IColumnBinding cb : myViewerBinding.getColumns()) {
				final String value = cb.getDisplayText(element);
				if (mySearchPattern.matches(value)) return true;
			}
			return false;
		}
	};

	/**
	 * Filter Focus listener: selects all text of the filter when it gets focus.
	 */
	protected FocusAdapter myFilterFocusListener = new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			/*
			 * Running in an asyncExec because the selectAll() does not appear to work when using
			 * mouse to give focus to text.
			 */
			IManagerRunnable.Factory.asyncExec(null, this, new Runnable() {
				@Override
				public void run() {
					if (!myText.isDisposed()) {
						if (TYPE_FILTER_TEXT.equals(myText.getText().trim())) {
							myText.selectAll();
						}
					}
				}
			});
		}
	};

	/**
	 * Filter Key listener: arrow down should go to the table itself...
	 */
	protected KeyAdapter myFilterKeylistener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if ((myTable.getItemCount() > 0) && (e.keyCode == SWT.ARROW_DOWN || e.character == SWT.CR)) {
				myTable.setFocus();
				if (myTable.getSelectionIndex() == -1) {
					myTable.setSelection(0);
				}
			}
		}
	};

	/**
	 * Table Key listener: arrow up in the first row should go to the filter.
	 */
	protected KeyAdapter myTableKeylistener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if ((myTable.getSelectionIndex() == 0) && (e.keyCode == SWT.ARROW_UP)) {
				myText.setFocus();
			}
		}
	};

	/**
	 * Filter Clear listener: clears the filter when canceled.
	 */
	SelectionAdapter myFilterClearListener = new SelectionAdapter() {
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			if (e.detail == SWT.CANCEL) {
				myText.setText("");
			}
		}
	};

	/**
	 * Listener used on the filter observable to track changes to this.
	 */
	protected IValueChangeListener myFilterListener = new IValueChangeListener() {
		private boolean filterAdded = false;

		@Override
		public void handleValueChange(ValueChangeEvent event) {
			String filterString = (String) myFilter.getValue();
			if (filterString == null) {
				filterString = "";
			}
			mySearchPattern.setPattern(filterString);
			final boolean filterWanted = filterString.length() > 0;
			if (filterWanted && !filterAdded) {
				myTableViewer.addFilter(myViewerFilter);
			} else if (!filterWanted && filterAdded) {
				myTableViewer.removeFilter(myViewerFilter);
			} else {
				if (filterAdded) {
					myTableViewer.refresh();
				}
			}
			filterAdded = filterWanted;

		}
	};

	/**
	 * @see IFilteringTableAdapter.Factory#createFilter(Composite)
	 * 
	 * @param parent the parent composite
	 * @return the Text field
	 */
	public static Text createFilter(Composite parent) {
		final FormToolkit toolkit = IManager.Factory.getManager().getFormToolkit();
		final Composite top = toolkit.createComposite(parent, SWT.BORDER);
		top.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		final GridLayout filterLayout = new GridLayout(2, false);
		filterLayout.marginHeight = 0;
		filterLayout.marginWidth = 0;
		top.setLayout(filterLayout);

		// final Label label = toolkit.createLabel(top, "");
		// label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		// if (filterString == null) {
		// filterString = "Filter:";
		// }
		// label.setText(filterString);

		final Text filterText = new Text(top, SWT.SINGLE);
		filterText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		filterText.setMessage(TYPE_FILTER_TEXT);

		// final Image inactiveImage =
		// JFaceResources.getImageRegistry().get(ISharedImages.IMG_ETOOL_CLEAR_DISABLED);
		// final Image activeImage =
		// JFaceResources.getImageRegistry().get(ISharedImages.IMG_ETOOL_CLEAR);
		final Image inactiveImage = PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_ETOOL_CLEAR_DISABLED);
		final Image activeImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ETOOL_CLEAR);
		final Image pressedImage = new Image(parent.getDisplay(), activeImage, SWT.IMAGE_GRAY);

		final Label clearButton = toolkit.createLabel(top, "");
		clearButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		clearButton.setImage(inactiveImage);
		clearButton.setBackground(parent.getBackground()); // getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND)
		clearButton.setToolTipText("Clear filter");
		clearButton.addMouseListener(new MouseAdapter() {
			private MouseMoveListener fMoveListener;

			@Override
			public void mouseDown(MouseEvent e) {
				clearButton.setImage(pressedImage);
				fMoveListener = new MouseMoveListener() {
					private boolean fMouseInButton = true;

					@Override
					public void mouseMove(MouseEvent e) {
						final boolean mouseInButton = isMouseInButton(e);
						if (mouseInButton != fMouseInButton) {
							fMouseInButton = mouseInButton;
							clearButton.setImage(mouseInButton ? pressedImage : inactiveImage);
						}
					}
				};
				clearButton.addMouseMoveListener(fMoveListener);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				if (fMoveListener != null) {
					clearButton.removeMouseMoveListener(fMoveListener);
					fMoveListener = null;
					final boolean mouseInButton = isMouseInButton(e);
					clearButton.setImage(mouseInButton ? activeImage : inactiveImage);
					if (mouseInButton) {
						filterText.setText("");
						filterText.setFocus();
					}
				}
			}

			private boolean isMouseInButton(MouseEvent e) {
				final Point buttonSize = clearButton.getSize();
				return 0 <= e.x && e.x < buttonSize.x && 0 <= e.y && e.y < buttonSize.y;
			}
		});

		return filterText;
	}

	private static Boolean useNativeSearchField;

	private static boolean useNativeSearchField(Composite composite) {
		if (useNativeSearchField == null) {
			useNativeSearchField = Boolean.FALSE;
			Text testText = null;
			try {
				testText = new Text(composite, SWT.SEARCH | SWT.ICON_CANCEL);
				useNativeSearchField = Boolean.valueOf((testText.getStyle() & SWT.ICON_CANCEL) != 0);
			} finally {
				if (testText != null) {
					testText.dispose();
				}
			}

		}
		return useNativeSearchField.booleanValue();
	}

	@Override
	public void widgetDisposed(DisposeEvent e) {
		dispose();
	}

	@Override
	public Text getText() {
		return myText;
	}
}
