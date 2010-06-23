package com.rcpcompany.uibindings.navigator.internal.views;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartConstants;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager.IGetSelectionTarget;
import com.rcpcompany.utils.logging.LogUtils;
import com.rcpcompany.utils.selection.SelectionUtils;

/**
 * The base view for editor parts.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BaseEditorView extends ViewPart implements ISetSelectionTarget, IGetSelectionTarget, IEditorPartView {
	/**
	 * The parent Composite for all the editor parts.
	 */
	/* package */Composite myParent;

	/**
	 * Whether this editor is currently pinned.
	 * <p>
	 * If the editor is pinned, it will not react to selection changes and a new editor is created
	 * instead of reusing an existing editor.
	 */
	/* package */boolean myIsPinned = false;

	/**
	 * The current editor part descriptor.
	 */
	/* package */IEditorPartDescriptor myCurrentDesciptor;

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
			return myCurrentDesciptor;
		}
	};

	/**
	 * Constructs and returns a editor container.
	 */
	public BaseEditorView() {
	}

	@Override
	public String getPartName() {
		if (myCurrentDesciptor != null) return myCurrentDesciptor.getName();
		return super.getPartName();
	}

	@Override
	public Image getTitleImage() {
		if (myCurrentDesciptor != null) {
			final Image image = myCurrentDesciptor.getImage().getImage();
			if (image != null) return image;
		}
		// TODO the model type image
		return super.getTitleImage();
	}

	@Override
	public void createPartControl(Composite parent) {
		myParent = parent;

		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.addPostSelectionListener(mySelectionListener);
		selectReveal(ss.getSelection());
	}

	@Override
	public void dispose() {
		setCurrentObject(null);
		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.removePostSelectionListener(mySelectionListener);
		super.dispose();
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void selectReveal(ISelection selection) {
		if (myCurrentEditorPart != null && isPinned()) return;
		final List<EObject> list = SelectionUtils.computeSelection(selection, EObject.class);
		if (list.isEmpty()) return;

		setCurrentObject(list.get(0));
	}

	@Override
	public ISelection getCurrentSelection() {
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
		final IEditorPartDescriptor desc = findEditorPartDescriptor(obj);
		if (desc == myCurrentEditorPart) {
			/*
			 * The editor part itself did not change... just update the observable value.
			 */
			if (myCurrentValue != null) {
				myCurrentValue.setValue(obj);
			}
			return;
		}

		/*
		 * Clean up after the previous editor part
		 */
		if (myCurrentEditorPart != null) {
			myCurrentEditorPart.dispose();
			if (!myParent.isDisposed()) {
				for (final Control c : myParent.getChildren()) {
					c.dispose();
				}
			}
		}
		if (myCurrentValue != null && !myCurrentValue.isDisposed()) {
			myCurrentValue.dispose();
		}
		myCurrentValue = null;
		myCurrentEditorPart = null;
		myCurrentDesciptor = null;

		/*
		 * Setup the new editor part
		 */
		if (desc == null) return;

		/*
		 * - create the observable value for the editor part based on the type of the editor
		 * descriptor
		 */
		final EClassifier cls = desc.getModelType().getModelTypeEClassifier();
		if (cls == null) {
			LogUtils.error(desc, "Classifier for " + desc.getModelType().getModelType() + " not set");
		}
		myCurrentValue = new WritableValue(obj, cls);
		myCurrentDesciptor = desc;

		/*
		 * - create the editor part itself
		 * 
		 * If it fails, the clean up again...
		 */
		final IEditorPartFactory factory = desc.getFactory().getObject();
		try {
			if (factory != null) {
				myCurrentEditorPart = factory.createEditorPart(myFactoryContext);
			}
			if (myCurrentDesciptor == null) {
				LogUtils.error(factory, "Editor Part Factory returned null");
			}
		} catch (final Exception ex) {
			LogUtils.error(factory, ex);
		}

		if (myCurrentEditorPart == null) {
			myCurrentValue.dispose();
			myCurrentValue = null;
			myCurrentDesciptor = null;
			return;
		}

		/*
		 * - Update the view part info
		 */
		firePropertyChange(IWorkbenchPartConstants.PROP_PART_NAME);
		firePropertyChange(IWorkbenchPartConstants.PROP_TITLE);
	}

	/**
	 * Find the the editor descriptor to use in this editor based on the current object.
	 * 
	 * @param obj the object for the editor
	 * 
	 * @return the descriptor
	 */
	private IEditorPartDescriptor findEditorPartDescriptor(EObject obj) {
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();
		return manager.getEditorPartDescriptor(obj);
	}

	@Override
	public void setPinned(boolean pinned) {
		myIsPinned = pinned;
	}

	@Override
	public boolean isPinned() {
		return myIsPinned;
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
}
