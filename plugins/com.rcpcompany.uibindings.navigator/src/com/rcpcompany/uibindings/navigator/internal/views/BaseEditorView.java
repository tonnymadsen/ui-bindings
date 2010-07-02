package com.rcpcompany.uibindings.navigator.internal.views;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.internal.Activator;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager.IGetSelectionTarget;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;
import com.rcpcompany.utils.logging.LogUtils;
import com.rcpcompany.utils.selection.SelectionUtils;

/**
 * The base view for editor parts.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BaseEditorView extends ViewPart implements ISetSelectionTarget, IGetSelectionTarget, IEditorPartView {
	/**
	 * The parent Composite for the current editor part - if any
	 */
	/* package */Composite myParent;

	/**
	 * The parent Composite from {@link IViewPart#createPartControl(Composite)}.
	 */
	/* package */Composite myViewPartParent;

	/**
	 * Whether this editor is currently pinned.
	 * <p>
	 * If the editor is pinned, it will not react to selection changes and a new editor is created
	 * instead of reusing an existing editor.
	 */
	/* package */boolean myIsPinned = INavigatorManager.Factory.getManager().isPinEditorByDefault();

	/**
	 * The current editor part descriptor.
	 */
	private/* package */IEditorPartDescriptor myCurrentDescriptor;

	/**
	 * The current editor part for this editor.
	 */
	/* package */IEditorPart myCurrentEditorPart = null;

	/**
	 * The current base observable value of the editor.
	 * <p>
	 * The type of the value is based on the model type of the current editor descriptor.
	 */
	/* package */IObservableValue myCurrentValue;

	/**
	 * The factory context used in {@link IEditorPartFactory}.
	 */
	private final IEditorPartContext myFactoryContext = new IEditorPartContext() {
		@Override
		public IWorkbenchPart getWorkbenchPart() {
			return BaseEditorView.this;
		}

		@Override
		public Composite getParent() {
			return myParent;
		};

		@Override
		public IObservableValue getCurrentValue() {
			return myCurrentValue;
		}

		@Override
		public IEditorPartDescriptor getDescriptor() {
			return getCurrentDescriptor();
		}
	};

	/**
	 * Constructs and returns a editor container.
	 */
	public BaseEditorView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		myViewPartParent = parent;

		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.addPostSelectionListener(mySelectionListener);
		selectReveal(ss.getSelection());

		createToolbarContributions();
	}

	private void createToolbarContributions() {
		final IToolBarManager toolbar = getViewSite().getActionBars().getToolBarManager();

		toolbar.add(new PinEditorContributionItem());
		mySelectEditorPartFactoryContributionItem = new SelectEditorPartFactoryContributionItem();
		toolbar.add(mySelectEditorPartFactoryContributionItem);
	}

	@Override
	public void dispose() {
		cleanEditorPart();
		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.removePostSelectionListener(mySelectionListener);
		super.dispose();
	}

	@Override
	public void activateView() {
		getSite().getPage().activate(this);
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void selectReveal(ISelection selection) {
		if (Activator.getDefault().TRACE_EDITOR_PARTS_LIFECYCLE) {
			LogUtils.debug(this, IBindingObjectInformation.Factory.getLongName(selection));
		}
		if (myCurrentEditorPart != null && isPinned()) return;
		final List<EObject> list = SelectionUtils.computeSelection(selection, EObject.class);
		if (list.isEmpty()) return;

		setCurrentObject(list.get(0));
	}

	@Override
	public ISelection getCurrentSelection() {
		if (myCurrentValue == null) return StructuredSelection.EMPTY;

		return new StructuredSelection(myCurrentValue.getValue());
	}

	@Override
	public EObject getCurrentObject() {
		if (myCurrentValue != null) return (EObject) myCurrentValue.getValue();
		return null;
	}

	/**
	 * Updates the editor when the current object changes
	 * 
	 * @param obj the new current object of the editor
	 */
	@Override
	public void setCurrentObject(EObject obj) {
		final IEditorPartDescriptor desc = INavigatorManager.Factory.getManager().getEditorPartDescriptor(obj);
		if (Activator.getDefault().TRACE_EDITOR_PARTS_LIFECYCLE) {
			LogUtils.debug(this, "Descriptor found: " + obj + "\n-> " + desc);
		}
		if (desc == myCurrentEditorPart) {
			/*
			 * The editor part itself did not change... just update the observable value.
			 */
			if (myCurrentValue != null) {
				if (Activator.getDefault().TRACE_EDITOR_PARTS_LIFECYCLE) {
					LogUtils.debug(this, "Editor part value changed to " + obj);
				}
				myCurrentValue.setValue(obj);
			}
			return;
		}

		if (desc == null) return;

		if (Activator.getDefault().TRACE_EDITOR_PARTS_LIFECYCLE) {
			LogUtils.debug(this, "Editor part description\n" + myCurrentEditorPart + "\n-> " + desc);
		}

		cleanEditorPart();

		/*
		 * - create the observable value for the editor part based on the type of the editor
		 * descriptor
		 */
		myCurrentValue = new WritableValue(obj, obj.eClass());
		setCurrentDescriptor(desc);

		/*
		 * - create the editor part itself
		 * 
		 * If it fails, the clean up again...
		 */
		final IEditorPartFactory factory = desc.getFactory().getObject();
		try {
			if (factory != null) {
				myParent = new Composite(myViewPartParent, SWT.NONE);
				myParent.setLayout(new FillLayout());
				myCurrentEditorPart = factory.createEditorPart(myFactoryContext);
				myViewPartParent.layout(true);
			}
			if (getCurrentDescriptor() == null) {
				LogUtils.error(factory, "Editor Part Factory returned null");
			}
		} catch (final Exception ex) {
			LogUtils.error(factory, ex);
		}

		if (myCurrentEditorPart == null) {
			if (Activator.getDefault().TRACE_EDITOR_PARTS_LIFECYCLE) {
				LogUtils.debug(this, "Failed");
			}
			cleanEditorPart();
			setPartName("");
			setTitleImage(null);
			return;
		}

		/*
		 * - Update the view part info
		 */
		setPartName(getCurrentDescriptor().getName());
		Image image = null;
		if (image == null && getCurrentDescriptor().getImage() != null) {
			getCurrentDescriptor().getImage().getImage();
		}
		if (image == null) {
			final IBindingObjectInformation information = IBindingObjectInformation.Factory.createLongName(
					(EObject) myCurrentValue.getValue(), "");
			if (information != null) {
				image = information.getImage();
			}
		}
		setTitleImage(image);
	}

	/**
	 * 
	 */
	private void cleanEditorPart() {
		/*
		 * - Clean up after the previous editor part
		 */
		if (myCurrentEditorPart != null) {
			myCurrentEditorPart.dispose();
			if (!myViewPartParent.isDisposed()) {
				for (final Control c : myViewPartParent.getChildren()) {
					c.dispose();
				}
			}
		}
		if (myCurrentValue != null && !myCurrentValue.isDisposed()) {
			myCurrentValue.dispose();
		}
		myCurrentValue = null;
		myCurrentEditorPart = null;
		setCurrentDescriptor(null);
	}

	@Override
	public void setPinned(boolean pinned) {
		myIsPinned = pinned;
		LogUtils.debug(this, "pinned=" + myIsPinned);
	}

	@Override
	public boolean isPinned() {
		return myIsPinned;
	}

	/**
	 * Sets the current descriptor.
	 * 
	 * @param desciptor the current descriptor to set
	 */
	public void setCurrentDescriptor(IEditorPartDescriptor desciptor) {
		myCurrentDescriptor = desciptor;
		if (mySelectEditorPartFactoryContributionItem != null) {
			mySelectEditorPartFactoryContributionItem.update();
		}
	}

	/**
	 * Returns the current descriptor.
	 * 
	 * @return the current descriptor
	 */
	public IEditorPartDescriptor getCurrentDescriptor() {
		return myCurrentDescriptor;
	}

	/**
	 * Selection lister that simply updated the current selection of the editor.
	 */
	private final ISelectionListener mySelectionListener = new ISelectionListener() {
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			selectReveal(selection);
		}
	};

	private SelectEditorPartFactoryContributionItem mySelectEditorPartFactoryContributionItem;

	/**
	 * {@link IContributionItem} for "Pin Editor ".
	 */
	public class PinEditorContributionItem extends ContributionItem {
		private ToolItem myItem;

		@Override
		public void fill(ToolBar parent, int index) {
			myItem = new ToolItem(parent, SWT.CHECK, index);
			final ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
			myItem.setImage(sharedImages.getImage("IMG_ETOOL_PIN_EDITOR"));
			myItem.setDisabledImage(sharedImages.getImage("IMG_ETOOL_PIN_EDITOR_DISABLED"));
			myItem.setToolTipText("Pin editor");

			myItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setPinned(!isPinned());
					update();
				}
			});
		}

		@Override
		public void update() {
			myItem.setEnabled(getCurrentObject() != null);
			myItem.setSelection(isPinned());
		}
	}

	/**
	 * {@link IContributionItem} for "Select editor".
	 */
	public class SelectEditorPartFactoryContributionItem extends ContributionItem {
		private ToolItem myItem;
		private final Image myFallBackImage;

		public SelectEditorPartFactoryContributionItem() {
			myFallBackImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}

		@Override
		public void fill(ToolBar parent, int index) {
			myItem = new ToolItem(parent, SWT.DROP_DOWN, index);
			myItem.setToolTipText("Selects the format of the editor");
			update();

			myItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					final Menu menu = new Menu(myItem.getParent());
					// if (workbenchHelpSystem != null) {
					// workbenchHelpSystem.setHelp(menu, helpContextId);
					// }
					final IEditorModelType mt = INavigatorManager.Factory.getManager().getModelType(getCurrentObject());
					for (final IEditorPartDescriptor d : mt.getEditors()) {
						final MenuItem item = new MenuItem(menu, SWT.NONE);
						item.setText(d.getName());
						final CEResourceHolder image = d.getImage();
						if (image != null) {
							item.setImage(image.getImage());
						}

						item.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
								d.getModelType().setPreferredEditor(d);
								setCurrentObject(getCurrentObject());
								update();
							}
						});
					}

					// position the menu below the drop down item
					final Point point = myItem.getParent().toDisplay(new Point(event.x, event.y));
					menu.setLocation(point.x, point.y);
					menu.setVisible(true);

					update();
				}
			});
		}

		@Override
		public void update() {
			if (myItem.isDisposed()) return;
			final boolean enabled = getCurrentDescriptor() != null;
			myItem.setEnabled(enabled);
			Image image = myFallBackImage;
			if (enabled) {
				final CEResourceHolder imageHolder = getCurrentDescriptor().getImage();
				if (imageHolder != null) {
					image = imageHolder.getImage();
				}
			}
			myItem.setImage(image);
			/*
			 * Adding the text does not work when the next selected item has a longer text... Then
			 * the item disappears altogether
			 */

			// myItem.setText(getCurrentDescriptor() == null ? "<none>" :
			// getCurrentDescriptor().getName());
		}
	}
}
