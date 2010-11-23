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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingContext.FinishOption;
import com.rcpcompany.uibindings.utils.IFormChooser;
import com.rcpcompany.uibindings.utils.IFormChooserCreator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The implementation of {@link IFormChooser}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormChooser implements IFormChooser {
	/**
	 * The contaxt passed on to the choosers.
	 */
	protected final IBindingContext myContext;

	/**
	 * The discriminant {@link IObservableValue}.
	 */
	protected final IObservableValue myDiscriminant;

	/**
	 * Proxy for {@link #myDiscriminant}, that prevents propergation of dispose.
	 */
	protected IObservableValue myChildDiscriminant;

	/**
	 * The top {@link Composite} for all children created by the choosers.
	 */
	protected final Composite myTop;

	private final IFormChooserCreator theDummyCreator = new IFormChooserCreator() {
		@Override
		public void createForm(IBindingContext context, IObservableValue discriminant, Composite parent) {
		}
	};

	/**
	 * The current creator
	 */
	protected IFormChooserCreator myCurrentCreator = theDummyCreator;

	/**
	 * Map with all registered form creators.
	 */
	private final Map<IFormChooserTester, IFormChooserCreator> myMap = new HashMap<IFormChooserTester, IFormChooserCreator>();

	/**
	 * Dispose listener
	 */
	private final DisposeListener myDisposeListener = new DisposeListener() {
		@Override
		public void widgetDisposed(DisposeEvent e) {
			dispose();
		}
	};

	/**
	 * Constructs and returns a new form creator
	 * 
	 * @param context the context
	 * @param discriminant the discriminant used to decide on the chosen form
	 * @param top the top level {@link Composite} that will parent all forms created by the chooser
	 */
	public FormChooser(IBindingContext context, IObservableValue discriminant, Composite top) {
		myContext = context;
		myDiscriminant = discriminant;
		myTop = top;
		myTop.setLayout(new FillLayout());

		myDiscriminant.addValueChangeListener(myValueListener);
		myTop.addDisposeListener(myDisposeListener);
		updateChild();
	}

	@Override
	public void dispose() {
		myDiscriminant.removeValueChangeListener(myValueListener);
		if (!myTop.isDisposed()) {
			removeChild();
			myTop.removeDisposeListener(myDisposeListener);
		}
	}

	private final IValueChangeListener myValueListener = new IValueChangeListener() {
		@Override
		public void handleValueChange(ValueChangeEvent event) {
			updateChild();
		}
	};

	/**
	 * Finds and returns the form creator to use based on the current value of the discriminant.
	 * 
	 * @return the form creator or <code>null</code>
	 */
	protected IFormChooserCreator findCreator() {
		final Object value = myDiscriminant.getValue();
		for (final Map.Entry<IFormChooserTester, IFormChooserCreator> t : myMap.entrySet()) {
			if (t.getKey().isSelected(value)) return t.getValue();
		}
		return null;
	}

	/**
	 * Updates the sole child of the top Composite based on the current creator.
	 */
	protected void updateChild() {
		final IFormChooserCreator creator = findCreator();
		if (creator == myCurrentCreator) {
			if (myChildDiscriminant != null) {
				myChildDiscriminant.setValue(myDiscriminant.getValue());
			}
			return;
		}

		myTop.setLayoutDeferred(true);
		removeChild();
		myCurrentCreator = creator;
		if (myCurrentCreator != null) {
			try {
				myChildDiscriminant = WritableValue.withValueType(myDiscriminant.getValueType());
				myChildDiscriminant.setValue(myDiscriminant.getValue());
				myCurrentCreator.createForm(myContext, myChildDiscriminant, myTop);
			} catch (final Exception ex) {
				LogUtils.error(myCurrentCreator, ex);
			}

			myContext.finish(FinishOption.IF_ALREADY_FINISHED);

			/*
			 * Common mistake: the layout data is not null or a FillData!
			 * 
			 * Note: FillData is package protected - therefore the getClass... below
			 */
			final Control[] children = myTop.getChildren();
			switch (children.length) {
			case 0:
				break;
			case 1:
				final Object layoutData = children[0].getLayoutData();
				if (layoutData != null && !layoutData.getClass().getName().equals("org.eclipse.swt.layout.FillData")) {
					children[0].setLayoutData(null);
					LogUtils.debug(myCurrentCreator, "Child has layout ('" + layoutData + "'). Removed!");
				}
				break;
			default:
				LogUtils.throwException(myCurrentCreator, "Creator created multiple children", null);
			}
		} else {
			createEmptyComposite();
		}
		myTop.setLayoutDeferred(false);
		if (myContext != null && myContext.getState() == BindingState.OK) {
			myContext.reflow();
		}
		myTop.update();

		/*
		 * Hmmm?
		 * 
		 * We make sure all outstanding asyncExecs are executed at this point...
		 */
		// final Listener l = new Listener() {
		// @Override
		// public void handleEvent(Event event) {
		// LogUtils.debug(this, ToStringUtils.toString(event));
		// }
		// };
		// for (int i = SWT.None; i < SWT.ImeComposition; i++) {
		// Display.getCurrent().addFilter(i, l);
		// }
		// while (myTop.getDisplay().readAndDispatch()) {
		// // Do nothing
		// LogUtils.debug(this, "readAndDispatch");
		// }
		// for (int i = SWT.None; i < SWT.ImeComposition; i++) {
		// Display.getCurrent().removeFilter(i, l);
		// }
		// LogUtils.debug(this, "readAndDispatch ok");
	}

	private void createEmptyComposite() {
		// final Label c = new Label(myTop, SWT.NONE);
		// c.setText("");

		final Composite c = new Composite(myTop, SWT.NONE);
		c.setSize(new Point(1, 1));
		// c.setBackground(c.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		c.setLayout(new Layout() {

			@Override
			protected void layout(Composite composite, boolean flushCache) {
			}

			@Override
			protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
				return new Point(1, 1);
			}
		});
	}

	/**
	 * Removes all children from the top composite.
	 */
	protected void removeChild() {
		final Control[] children = myTop.getChildren();
		for (int i = children.length - 1; i >= 0; i--) {
			children[i].dispose();
		}
		myCurrentCreator = null;
		if (myChildDiscriminant != null) {
			myChildDiscriminant.dispose();
			myChildDiscriminant = null;
		}
	}

	@Override
	public void addFormInstanceof(final Class<?> clz, IFormChooserCreator creator) {
		addForm(new IFormChooserTester() {
			@Override
			public boolean isSelected(Object value) {
				return clz.isInstance(value);
			}
		}, creator);
	}

	@Override
	public void addFormEClass(final EClass clz, IFormChooserCreator creator) {
		addFormInstanceof(clz.getInstanceClass(), creator);
	}

	@Override
	public void addFormExactEClass(final EClass clz, IFormChooserCreator creator) {
		addForm(new IFormChooserTester() {
			@Override
			public boolean isSelected(Object value) {
				if (value == null) return false;
				if (!(value instanceof EObject)) return false;
				return clz == ((EObject) value).eClass();
			}
		}, creator);
	}

	@Override
	public void addFormValue(final Object value, IFormChooserCreator creator) {
		addForm(new IFormChooserTester() {
			@Override
			public boolean isSelected(Object v) {
				return value == null ? v == null : value.equals(v);
			}
		}, creator);
	}

	@Override
	public void addForm(IFormChooserTester tester, IFormChooserCreator creator) {
		myMap.put(tester, creator);
		updateChild();
	}
}
