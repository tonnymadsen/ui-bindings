/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IArgumentContext;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IControlFactory;
import com.rcpcompany.uibindings.IControlFactoryContext;
import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ISourceProviderStateContext;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.internal.bindingMessages.IContextMessageProvider;
import com.rcpcompany.uibindings.observables.DisposePendingEvent;
import com.rcpcompany.uibindings.observables.IDisposePendingListener;
import com.rcpcompany.uibindings.observables.IDisposePendingObservable;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Value Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getModelObservable <em>Model
 * Observable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getModelObservableValue <em>Model
 * Observable Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getModelObject <em>Model Object
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getModelFeature <em>Model Feature
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getDecoratorProvider <em>Decorator
 * Provider</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getDecorator <em>Decorator</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getUIAttribute <em>UI Attribute
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getUIObservable <em>UI Observable
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getCell <em>Cell</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#getMessagePrefix <em>Message
 * Prefix</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ValueBindingImpl#isDynamic <em>Dynamic</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ValueBindingImpl extends BindingImpl implements IValueBinding {
	/**
	 * Whether this is a dynamic binding or not.
	 */
	private boolean isDynamic = false;

	@Override
	public boolean isDynamic() {
		return isDynamic;
	}

	@Override
	public IBindingDataType getDataType() {
		if (!isDynamic()) return super.getDataType();
		final IObservableValue ov = getModelObservableValue();
		if (ov != null && !ov.isDisposed()) {
			/*
			 * Find the data type based on the OV:
			 * 
			 * This will use the value type of the inner observable, if set...
			 */
			IBindingDataType dt = null;
			final Object v = ov.getValue();
			dt = IBindingDataType.Factory.create(ov);

			/*
			 * If we have both a value and the data type from the OV, AND the two agree exactly,
			 * then use the data type from the OV, as this is more rich.
			 * 
			 * Also automatically used for Strings, etc...
			 */
			if (v != null && dt != null && v.getClass() == dt.getDataType()) return dt;

			/*
			 * Use the real type of the current value... if set...
			 */
			if (v != null) return IBindingDataType.Factory.create(null, v.getClass());

			/*
			 * If we have the data type, then use this...
			 */
			if (dt != null) return dt;
		}

		/*
		 * No observable? We fall back on the static type
		 */
		return super.getDataType();
	}

	/**
	 * Listener used to monitor dynamic bindings for changes in the basic observable value.
	 */
	private IChangeListener myTypeListener = null;

	@Override
	public void updateUI() {
		/*
		 * We have to update the values backward to handle the chains set up in
		 * BaseUIBindingDecorator.decorate()
		 */
		final ListIterator<Binding> iterator = getDBBindings().listIterator(getDBBindings().size());
		while (iterator.hasPrevious()) {
			final Binding b = iterator.previous();
			/*
			 * A binding might have been disposed... we don't see that, so lazily update the list
			 */
			if (b.isDisposed()) {
				iterator.remove();
				continue;
			}
			b.updateModelToTarget();
		}
	}

	@Override
	public void setFocus() {
		Control con = getControl();
		if (con == null) {
			final IValueBindingCell ci = getCell();
			if (ci != null) {
				con = ci.setFocus();
			}
		}
		if (con == null) return;

		/*
		 * Make sure all Sections and ExpandableComposite are expanded
		 */
		final Composite top = getContext().getTop();
		Control c = con;
		while (c != null && !(c instanceof Shell) && c != top) {
			if (c instanceof ExpandableComposite) {
				final ExpandableComposite comp = (ExpandableComposite) c;
				comp.setExpanded(true);
			} else if (c instanceof Section) {
				final Section comp = (Section) c;
				comp.setExpanded(true);
			}
			final Composite p = c.getParent();
			if (p != null) {
				if (p instanceof TabFolder) {
					final TabFolder comp = (TabFolder) p;
					for (final TabItem ti : comp.getItems()) {
						if (ti.getControl() == c) {
							comp.setSelection(ti);
							break;
						}
					}
				} else if (p instanceof CTabFolder) {
					final CTabFolder comp = (CTabFolder) p;
					for (final CTabItem ti : comp.getItems()) {
						if (ti.getControl() == c) {
							comp.setSelection(ti);
							break;
						}
					}
				}
			}
			c = p;
		}
		con.setFocus();
	}

	@Override
	public void addErrorCondition(String error) {
		super.addErrorCondition(error);

		final Control c = getControl();
		if (c == null) return;

		final List<String> ecs = getErrorConditions();
		final StringBuilder sb = new StringBuilder(300);
		for (final String e : ecs) {
			sb.append(e).append('\n');
		}
		c.setBackground(c.getDisplay().getSystemColor(SWT.COLOR_RED));
		c.setToolTipText(sb.toString());
	}

	/**
	 * The generic "simple" {@link Control} factory.
	 */
	private static final IControlFactory SIMPLE_CONTROL_FACTORY = new IControlFactory() {
		@Override
		public Control create(IControlFactoryContext context) {
			int style = context.getStyle();
			String className = null;

			if (context.isCellEditor()) {
				className = context.getBinding().getArgument(Constants.ARG_PREFERRED_CELL_EDITOR, String.class, null);
			}
			if (className == null || className.equals(Control.class.getName())
					|| className.equals(Dialog.class.getName())) {
				className = context.getBinding().getArgument(Constants.ARG_PREFERRED_CONTROL, String.class, null);
			}
			if (className == null || className.equals(Control.class.getName())
					|| className.equals(Dialog.class.getName())) {
				className = Text.class.getName();
			}
			Class<?> controlClass = null;
			try {
				controlClass = Class.forName(className);
			} catch (final ClassNotFoundException ex) {
				LogUtils.throwException(this, "Cannot find class for '" + className + "'", context.getBinding() //$NON-NLS-1$ //$NON-NLS-2$
						.getCreationPoint());
			}
			if (!Control.class.isAssignableFrom(controlClass)) {
				LogUtils.throwException(this, "Class not sub-class of Control: '" + className + "'", context //$NON-NLS-1$ //$NON-NLS-2$
						.getBinding().getCreationPoint());
			}
			Constructor<?> constructor = null;
			try {
				constructor = controlClass.getConstructor(Composite.class, Integer.TYPE);
			} catch (final SecurityException ex) {
				LogUtils.throwException(this, ex.getMessage() + ": '" + className + "'", context.getBinding() //$NON-NLS-1$ //$NON-NLS-2$
						.getCreationPoint());
			} catch (final NoSuchMethodException ex) {
				LogUtils.throwException(this, "Class does not have (Composite, int) constructor: '" + className + "'", //$NON-NLS-1$ //$NON-NLS-2$
						context.getBinding().getCreationPoint());
			}

			/*
			 * A little special case code to handle a few corner cases...
			 */
			if (className.equals("org.eclipse.nebula.widgets.radiogroup.RadioGroup")) { //$NON-NLS-1$
				style &= ~SWT.BORDER;
			}
			if (controlClass.equals(Label.class)) {
				style &= ~SWT.BORDER;
			}

			/*
			 * Create the control itself..
			 */
			try {
				final Control c = (Control) constructor.newInstance(context.getParent(), style);
				final FormToolkit formToolkit = IManager.Factory.getManager().getFormToolkit();
				formToolkit.adapt(c, false, true);
				return c;
			} catch (final Exception ex) {
				LogUtils.throwException(this, ex.getClass().getSimpleName()
						+ ": " + ex.getMessage() + ": '" + className + "'", context.getBinding() //$NON-NLS-1$ //$NON-NLS-2$
						.getCreationPoint());
			}
			return null;
		}
	};

	@Override
	public Control createPreferredControl(final Composite parent, final int style, final boolean cellEditor) {
		final IControlFactory factory = getArgument(Constants.ARG_PREFERRED_CONTROL_FACTORY, IControlFactory.class,
				SIMPLE_CONTROL_FACTORY);

		return factory.create(new IControlFactoryContext() {
			@Override
			public IValueBinding getBinding() {
				return ValueBindingImpl.this;
			}

			@Override
			public Composite getParent() {
				return parent;
			}

			@Override
			public int getStyle() {
				return style;
			}

			@Override
			public boolean isCellEditor() {
				return cellEditor;
			}
		});
	}

	@Override
	public IValueBinding model(IObservableValue observable) {
		setModelObservable(observable);
		setStaticDataType(IBindingDataType.Factory.create(observable));
		assertTrue(getStaticDataType() != null, "Observable not supported, got value type: " //$NON-NLS-1$
				+ observable.getValueType());
		// assertTrue(getDataType().getEType() != null,
		// "Observable not supported, need EType, got value type: "
		// + observable.getValueType());
		myModelObservableDispose = false;
		return this;
	}

	@Override
	public IValueBinding model(EObject object, EStructuralFeature feature) {
		assertTrue(object != null, "Object must be non-null");
		assertTrue(feature != null, "Feature must be non-null");
		setStaticDataType(IBindingDataType.Factory.create(object.eClass(), feature));
		if (!feature.isMany()) {
			setModelObservable(UIBindingsEMFObservables.observeValue(null, getEditingDomain(), object, feature));
		} else {
			// TODO myModelObservable(UIBindingsEMFObservables.observeList(object, feature));
			LogUtils.throwException(this, "Many valued feature not supported yet", getCreationPoint()); //$NON-NLS-1$
		}
		return this;
	}

	@Override
	public IValueBinding model(IObservableValue value, EStructuralFeature feature) {
		assertTrue(value != null, "Value must be non-null");
		assertTrue(feature != null, "Feature must be non-null");
		setStaticDataType(IBindingDataType.Factory.create(value, feature));
		if (!feature.isMany()) {
			setModelObservable(UIBindingsEMFObservables.observeDetailValue(value.getRealm(), getEditingDomain(), value,
					feature));
		} else {
			// TODO setModelObservable( UIBindingsEMFObservables.observeDetailList(modelObject,
			// feature));
			LogUtils.throwException(this, "Many valued feature not supported yet", getCreationPoint()); //$NON-NLS-1$
		}
		return this;
	}

	@Override
	public IValueBinding ui(IUIAttribute attribute) {
		setUIAttribute(attribute);
		return this;
	}

	@Override
	public IValueBinding ui(ISWTObservableValue observable) {
		return ui(new SimpleUIAttribute(observable.getWidget(), null, observable));
	}

	@Override
	public IValueBinding ui(Widget widget) {
		return ui(widget, ""); //$NON-NLS-1$
	}

	@Override
	public IValueBinding ui(Widget widget, String attribute) {
		return ui(IManager.Factory.getManager().createUIAttribute(widget, attribute));
	}

	@Override
	public IValueBinding arg(String name, Object value) {
		assertTrue(name != null, "name must be non-null"); //$NON-NLS-1$
		getArguments().put(name.intern(), value);
		return this;
	}

	@Override
	public IValueBinding args(Map<String, Object> arguments) {
		setArguments(arguments);
		return this;
	}

	@Override
	public IValueBinding readonly() {
		return arg(Constants.ARG_READONLY, true);
	}

	@Override
	public IValueBinding id(String id) {
		setId(id);
		return this;
	}

	@Override
	public IValueBinding dynamic() {
		return arg(Constants.ARG_DYNAMIC, true);
	}

	@Override
	public IValueBinding label(String label) {
		return arg(Constants.ARG_LABEL, label);
	}

	@Override
	public IValueBinding validValues(IObservableList list) {
		return arg(Constants.ARG_VALID_VALUES, list);
	}

	@Override
	public IValueBinding validValues(List<?> list, Object type) {
		return validValues(Observables.staticObservableList(list, type));
	}

	@Override
	public IValueBinding validValues(EObject obj, EReference ref) {
		return validValues(UIBindingsEMFObservables.observeList(getEditingDomain(), obj, ref));
	}

	@Override
	public IValueBinding type(String type) {
		return arg(Constants.ARG_TYPE, type);
	}

	@Override
	public Class<?> getUIType() {
		if (getUIAttribute() == null) return null;
		return (Class<?>) getUIAttribute().getCurrentValue().getValueType();
	}

	@Override
	public void finish1() {
		assertTrue(getStaticDataType() != null, "No data type set"); //$NON-NLS-1$
		assertTrue(getUIAttribute() != null, "No UI attribute set"); //$NON-NLS-1$
		assertTrue(getModelObservable() != null, "No model observable set"); //$NON-NLS-1$
		assertTrue(!getModelObservable().isDisposed(), "Model observable disposed"); //$NON-NLS-1$

		isDynamic = getArgument(ARG_DYNAMIC, Boolean.class, false);

		final IObservableValue ov = getModelObservableValue();
		if (ov != null && isDynamic) {
			myTypeListener = new IChangeListener() {
				@Override
				public void handleChange(ChangeEvent event) {
					decorateIfNeeded();
				}
			};
			ov.addChangeListener(myTypeListener);
		}

		final Control control = getControl();
		if (control != null) {
			final String attribute = getUIAttribute().getAttribute();
			if (attribute == null || attribute.length() == 0) {
				registerWidget(control);
			}

			if (Activator.getDefault().ASSERTS_CONTROLS) {
				control.addDisposeListener(new DisposeListener() {
					@Override
					public void widgetDisposed(DisposeEvent e) {
						control.removeDisposeListener(this);

						switch (getState()) {
						case DISPOSE_PENDING:
						case DISPOSED:
							break;
						default:
							LogUtils.debug(ValueBindingImpl.this, ValueBindingImpl.this + ": control disposed");
							break;
						}
					}
				});
			}
		}

		decorateIfNeeded();

		/*
		 * This need to be as late in the process as possible! And only for the observables we want
		 * to dispose later.
		 */
		if (getModelObservable() != null) {
			IManager.Factory.getManager().startMonitorObservableDispose(getModelObservable(), this);
		}
		/*
		 * If we have a model observable that implement the pending interface, we add a listener
		 * that will dispose the binding as needed...
		 */
		if (getModelObservable() instanceof IDisposePendingObservable) {
			final IDisposePendingObservable dpov = (IDisposePendingObservable) getModelObservable();
			dpov.addDisposePendingListener(new IDisposePendingListener() {
				@Override
				public void disposePending(DisposePendingEvent event) {
					dpov.removeDisposePendingListener(this);
					dispose();
				}
			});
		}
	}

	/**
	 * The previous type data type for this binding.
	 */
	private IBindingDataType myPreviousDynamicDataType = null;

	/**
	 * Decorates the binding.
	 * <p>
	 * Re-decorates if the {@link #getDynamicDataType() type data type} changes.
	 */
	protected void decorateIfNeeded() {
		final IBindingDataType newDynamicDataType = getDataType();
		if (myPreviousDynamicDataType == newDynamicDataType) return;

		/*
		 * Clean up the old decoration as well as the old cached argument
		 */
		if (getDecorator() != null) {
			getDecorator().dispose();
			clearCachedArguments();
		}

		final Class<?> modelValueType = getModelType();
		final Class<?> uiValueType = getUIType();
		final String type = getType();

		final IDecoratorProvider provider = IManager.Factory.getManager()
				.getProvider(modelValueType, uiValueType, type);

		myPreviousDynamicDataType = newDynamicDataType;

		/*
		 * Add a note about missing support
		 */
		if (provider == null) {
			setDecorator(null);
			LogUtils.debug(this, "model: " + modelValueType + " ui: " + uiValueType + " type: " + type //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ " --> no decorator"); //$NON-NLS-1$
			addErrorCondition("Binding decorator not found"); //$NON-NLS-1$
			return;
		}

		setDecoratorProvider(provider);
		setDecorator(provider.getDecorator());

		if (getDecorator() == null) {
			LogUtils.debug(this, "model: " + modelValueType + " ui: " + uiValueType + " type: " + type //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ " --> no decorator created"); //$NON-NLS-1$
			addErrorCondition("Binding decorator cannot be created"); //$NON-NLS-1$
			return;
		}

		/*
		 * Initialize the decorator. If anything goes wrong, reset to null..
		 */
		try {
			getDecorator().init(this);
		} catch (final RuntimeException ex) {
			setDecorator(null);
			return;
		} catch (final Exception ex) {
			setDecorator(null);
			LogUtils.error(this, ex);
			return;
		}
		getDecorator().decorate();
	}

	@Override
	public boolean isChangeable() {
		String sb = null;
		boolean res = false;
		try {
			/*
			 * Can now be called before in state OK - e.g. from the form creator
			 */
			// assertTrue(getDecorator() != null, "Called before in OK state"); //$NON-NLS-1$

			/*
			 * TODO Not sure about this! In general, the reaction to non-changeable fields stinks!
			 */
			// if (eIsSet(IUIBindingsPackage.Literals.BINDING__ERROR_CONDITIONS))
			// return false;

			final IUIAttribute attribute = getUIAttribute();
			if (attribute != null) {
				if (!attribute.isChangeable()) {
					if (Activator.getDefault().TRACE_ISCHANGEABLE) {
						sb = attribute + ": not changeable";
					}
					return false;
				}
				final Widget widget = attribute.getWidget();
				if (widget != null && (!widget.isDisposed() && (widget.getStyle() & SWT.READ_ONLY) == SWT.READ_ONLY)) {
					if (Activator.getDefault().TRACE_ISCHANGEABLE) {
						sb = widget + " r/o";
					}
					return false;
				}
			}
			if (!getStaticDataType().isChangeable()) {
				if (Activator.getDefault().TRACE_ISCHANGEABLE) {
					sb = getStaticDataType() + ": not changeable";
				}
				return false;
			}
			if (!getDataType().isChangeable()) {
				if (Activator.getDefault().TRACE_ISCHANGEABLE) {
					sb = getDataType() + ": not changeable";
				}
				return false;
			}

			/*
			 * If the model observable is a constant IOV, then this binding must be constant.
			 */
			final IObservableValue ov = getModelObservableValue();
			final String ovClassName = ov.getClass().getName();
			if (ovClassName.equals("org.eclipse.core.internal.databinding.observable.ConstantObservableValue")) {
				if (Activator.getDefault().TRACE_ISCHANGEABLE) {
					sb = ov + ": constant";
				}
				return false;
			}
			if (ovClassName.equals("org.eclipse.core.internal.databinding.observable.UnmodifiableObservableValue")) {
				if (Activator.getDefault().TRACE_ISCHANGEABLE) {
					sb = ov + ": unmodifiable";
				}
				return false;
			}

			if (getArgument(Constants.ARG_READONLY, Boolean.class, Boolean.FALSE)) {
				if (Activator.getDefault().TRACE_ISCHANGEABLE) {
					sb = "READONLY";
				}
				return false;
			}

			final IUIBindingDecorator d = getDecorator();
			if (d != null && !d.isChangeable()) {
				if (Activator.getDefault().TRACE_ISCHANGEABLE) {
					sb = d + ": not changeable";
				}
				return false;
			}

			res = true;
			return res;
		} finally {
			if (Activator.getDefault().TRACE_ISCHANGEABLE) {
				LogUtils.debug(this, this + "=" + res + (sb != null ? (": " + sb) : ""));
			}
		}
	}

	@Override
	public void dispose() {
		switch (getState()) {
		case DISPOSED:
			return;
		default:
			break;
		}
		setState(BindingState.DISPOSE_PENDING);
		disposeServices();
		final Control control = getControl();
		if (control != null) {
			// TODO: move to separate if(widget...)
			final String attribute = getUIAttribute().getAttribute();
			if (attribute == null || attribute.length() == 0) {
				unregisterWidget(control);
			}
		}

		if (getDecorator() != null) {
			getDecorator().dispose();
		}
		if (dbBindings != null) {
			for (final Binding b : dbBindings) {
				b.dispose();
			}
			dbBindings.clear();
		}
		super.dispose();
		final IObservableValue ov = getModelObservableValue();
		if (myTypeListener != null && ov != null) {
			ov.removeChangeListener(myTypeListener);
			myTypeListener = null;
		}

		if (getModelObservable() != null) {
			IManager.Factory.getManager().stopMonitorObservableDispose(getModelObservable());
		}
		if (getModelObservable() != null && myModelObservableDispose) {
			getModelObservable().dispose();
		}
		setModelObservable(null);

		if (getUIAttribute() != null) {
			getUIAttribute().dispose();
		}
	}

	/**
	 * The default value of the '{@link #getModelObservable() <em>Model Observable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelObservable()
	 * @generated
	 * @ordered
	 */
	protected static final IObservable MODEL_OBSERVABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelObservable() <em>Model Observable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelObservable()
	 * @generated
	 * @ordered
	 */
	protected IObservable modelObservable = MODEL_OBSERVABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelObservableValue() <em>Model Observable Value</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelObservableValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue MODEL_OBSERVABLE_VALUE_EDEFAULT = null;

	/**
	 * <code>true</code> if {@link #modelObservable} should be disposed by {@link #dispose()}.
	 */
	private boolean myModelObservableDispose = true;

	/**
	 * The cached value of the '{@link #getDecoratorProvider() <em>Decorator Provider</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDecoratorProvider()
	 * @generated
	 * @ordered
	 */
	protected IDecoratorProvider decoratorProvider;

	/**
	 * The cached value of the '{@link #getDecorator() <em>Decorator</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDecorator()
	 * @generated
	 * @ordered
	 */
	protected IUIBindingDecorator decorator;

	/**
	 * The cached value of the '{@link #getUIAttribute() <em>UI Attribute</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUIAttribute()
	 * @generated
	 * @ordered
	 */
	protected IUIAttribute uiAttribute;

	/**
	 * The default value of the '{@link #getUIObservable() <em>UI Observable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUIObservable()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue UI_OBSERVABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCell() <em>Cell</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCell()
	 * @generated
	 * @ordered
	 */
	protected IValueBindingCell cell;

	/**
	 * The default value of the '{@link #getMessagePrefix() <em>Message Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMessagePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_PREFIX_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ValueBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.VALUE_BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IObservable getModelObservable() {
		return modelObservable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setModelObservable(IObservable newModelObservable) {
		final IObservable oldModelObservable = modelObservable;
		modelObservable = newModelObservable;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE,
					oldModelObservable, modelObservable));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableValue getModelObservableValue() {
		final IObservable observable = getModelObservable();
		if (!(observable instanceof IObservableValue)) return null;
		return (IObservableValue) observable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setModelObservableValue(IObservableValue newModelObservableValue) {
		setModelObservable(newModelObservableValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EObject getModelObject() {
		if (isDisposed()) {
			LogUtils.debug(this, "disposed");
			return null;
		}
		if (getModelObservable() instanceof IObserving) {
			final Object observed = ((IObserving) getModelObservable()).getObserved();
			if (observed instanceof EObject) return (EObject) observed;
		}
		final IObservableValue ov = getModelObservableValue();
		if (ov == null || ov.isDisposed()) return null;
		final Object observed = ov.getValue();
		if (!(observed instanceof EObject)) return null;
		return (EObject) observed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EStructuralFeature getModelFeature() {
		final Object valueType = getDataType().getValueType();
		if (valueType instanceof EStructuralFeature) return (EStructuralFeature) valueType;
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IDecoratorProvider getDecoratorProvider() {
		return decoratorProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDecoratorProvider(IDecoratorProvider newDecoratorProvider) {
		final IDecoratorProvider oldDecoratorProvider = decoratorProvider;
		decoratorProvider = newDecoratorProvider;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.VALUE_BINDING__DECORATOR_PROVIDER,
					oldDecoratorProvider, decoratorProvider));
		}
	}

	/**
	 * Used to prevent a recursive all to {@link #getArgument(String, Class, Object)}.
	 * <p>
	 * Can otherwise happen when {@link IUIBindingDecoratorExtender#isEnabled(IValueBinding)} uses
	 * {@link #getArgument(String, Class, Object)} to decide whether the extender is enablewd.
	 */
	private boolean addDecoratorExtenderArgumentsInvoked = false;

	@Override
	public <ArgumentType> void addDecoratorExtenderArguments(IArgumentContext<ArgumentType> context) {
		if (addDecoratorExtenderArgumentsInvoked) return;
		try {
			addDecoratorExtenderArgumentsInvoked = true;

			for (final IUIBindingDecoratorExtenderDescriptor d : IManager.Factory.getManager().getDecoratorExtenders()) {
				/*
				 * Optimalization: not many extenders will have arguments
				 */
				if (!d.hasArguments()) {
					continue;
				}
				final CEObjectHolder<IUIBindingDecoratorExtender> factory = d.getFactory();
				final IUIBindingDecoratorExtender extender = factory.getObject();
				if (extender == null) {
					LogUtils.error(factory.getConfigurationElement(), "Cannot create extender"); //$NON-NLS-1$
					continue;
				}

				if (!extender.isEnabled(this)) {
					continue;
				}
				IManager.Factory.getManager().addArgumentProviderArguments(d, context);
				if (context.isResultFound()) return;
			}

		} finally {
			addDecoratorExtenderArgumentsInvoked = false;
		}
	}

	@Override
	public <ArgumentType> void addDecoratorProviderArguments(IArgumentContext<ArgumentType> context) {
		IManager.Factory.getManager().addArgumentProviderArguments(getDecoratorProvider(), context);
	}

	@Override
	public IBinding getParentBinding() {
		if (getCell() != null && getCell().getColumnBinding() != null) return getCell().getColumnBinding();
		return super.getParentBinding();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IUIBindingDecorator getDecorator() {
		return decorator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDecorator(IUIBindingDecorator newDecorator) {
		final IUIBindingDecorator oldDecorator = decorator;
		decorator = newDecorator;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.VALUE_BINDING__DECORATOR,
					oldDecorator, decorator));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IUIAttribute getUIAttribute() {
		return uiAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setUIAttribute(IUIAttribute newUIAttribute) {
		final IUIAttribute oldUIAttribute = uiAttribute;
		uiAttribute = newUIAttribute;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.VALUE_BINDING__UI_ATTRIBUTE,
					oldUIAttribute, uiAttribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableValue getUIObservable() {
		return getUIAttribute().getCurrentValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IValueBindingCell getCell() {
		return cell;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCell(IValueBindingCell newCell) {
		final IValueBindingCell oldCell = cell;
		cell = newCell;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.VALUE_BINDING__CELL, oldCell, cell));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getMessagePrefix() {
		String messagePrefix = null;
		/*
		 * If this binding has a control, then look for the previous label widget and use the text
		 * of that
		 */
		final Control c = getControl();
		if (c != null) {
			final Composite parent = c.getParent();
			final Control[] siblings = parent.getChildren();
			for (int i = 0; i < siblings.length; i++) {
				if (siblings[i] == c) {
					// this is us - go backward until you hit a label-like widget
					for (int j = i - 1; j >= 0; j--) {
						final Control label = siblings[j];
						String ltext = null;
						if (label instanceof Label) {
							ltext = ((Label) label).getText();
						} else if (label instanceof Hyperlink) {
							ltext = ((Hyperlink) label).getText();
						} else if (label instanceof CLabel) {
							ltext = ((CLabel) label).getText();
						}
						if (ltext != null) {
							if (!ltext.endsWith(":")) { //$NON-NLS-1$
								messagePrefix = ltext + ": "; //$NON-NLS-1$
							} else {
								messagePrefix = ltext + " "; //$NON-NLS-1$
							}
							return messagePrefix;
						}
					}
					break;
				}
			}
		}

		final IValueBindingCell ci = getCell();
		if (ci != null) {
			messagePrefix = ci.getMessagePrefix();
			if (messagePrefix != null) return messagePrefix;
		}

		/*
		 * Fall back on nothing!
		 */
		messagePrefix = ""; //$NON-NLS-1$
		return messagePrefix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE:
			return getModelObservable();
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE_VALUE:
			return getModelObservableValue();
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBJECT:
			return getModelObject();
		case IUIBindingsPackage.VALUE_BINDING__MODEL_FEATURE:
			return getModelFeature();
		case IUIBindingsPackage.VALUE_BINDING__DECORATOR_PROVIDER:
			return getDecoratorProvider();
		case IUIBindingsPackage.VALUE_BINDING__DECORATOR:
			return getDecorator();
		case IUIBindingsPackage.VALUE_BINDING__UI_ATTRIBUTE:
			return getUIAttribute();
		case IUIBindingsPackage.VALUE_BINDING__UI_OBSERVABLE:
			return getUIObservable();
		case IUIBindingsPackage.VALUE_BINDING__CELL:
			return getCell();
		case IUIBindingsPackage.VALUE_BINDING__MESSAGE_PREFIX:
			return getMessagePrefix();
		case IUIBindingsPackage.VALUE_BINDING__DYNAMIC:
			return isDynamic();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE:
			setModelObservable((IObservable) newValue);
			return;
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE_VALUE:
			setModelObservableValue((IObservableValue) newValue);
			return;
		case IUIBindingsPackage.VALUE_BINDING__DECORATOR_PROVIDER:
			setDecoratorProvider((IDecoratorProvider) newValue);
			return;
		case IUIBindingsPackage.VALUE_BINDING__DECORATOR:
			setDecorator((IUIBindingDecorator) newValue);
			return;
		case IUIBindingsPackage.VALUE_BINDING__UI_ATTRIBUTE:
			setUIAttribute((IUIAttribute) newValue);
			return;
		case IUIBindingsPackage.VALUE_BINDING__CELL:
			setCell((IValueBindingCell) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE:
			setModelObservable(MODEL_OBSERVABLE_EDEFAULT);
			return;
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE_VALUE:
			setModelObservableValue(MODEL_OBSERVABLE_VALUE_EDEFAULT);
			return;
		case IUIBindingsPackage.VALUE_BINDING__DECORATOR_PROVIDER:
			setDecoratorProvider((IDecoratorProvider) null);
			return;
		case IUIBindingsPackage.VALUE_BINDING__DECORATOR:
			setDecorator((IUIBindingDecorator) null);
			return;
		case IUIBindingsPackage.VALUE_BINDING__UI_ATTRIBUTE:
			setUIAttribute((IUIAttribute) null);
			return;
		case IUIBindingsPackage.VALUE_BINDING__CELL:
			setCell((IValueBindingCell) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE:
			return MODEL_OBSERVABLE_EDEFAULT == null ? modelObservable != null : !MODEL_OBSERVABLE_EDEFAULT
					.equals(modelObservable);
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBSERVABLE_VALUE:
			return MODEL_OBSERVABLE_VALUE_EDEFAULT == null ? getModelObservableValue() != null
					: !MODEL_OBSERVABLE_VALUE_EDEFAULT.equals(getModelObservableValue());
		case IUIBindingsPackage.VALUE_BINDING__MODEL_OBJECT:
			return getModelObject() != null;
		case IUIBindingsPackage.VALUE_BINDING__MODEL_FEATURE:
			return getModelFeature() != null;
		case IUIBindingsPackage.VALUE_BINDING__DECORATOR_PROVIDER:
			return decoratorProvider != null;
		case IUIBindingsPackage.VALUE_BINDING__DECORATOR:
			return decorator != null;
		case IUIBindingsPackage.VALUE_BINDING__UI_ATTRIBUTE:
			return uiAttribute != null;
		case IUIBindingsPackage.VALUE_BINDING__UI_OBSERVABLE:
			return UI_OBSERVABLE_EDEFAULT == null ? getUIObservable() != null : !UI_OBSERVABLE_EDEFAULT
					.equals(getUIObservable());
		case IUIBindingsPackage.VALUE_BINDING__CELL:
			return cell != null;
		case IUIBindingsPackage.VALUE_BINDING__MESSAGE_PREFIX:
			return MESSAGE_PREFIX_EDEFAULT == null ? getMessagePrefix() != null : !MESSAGE_PREFIX_EDEFAULT
					.equals(getMessagePrefix());
		case IUIBindingsPackage.VALUE_BINDING__DYNAMIC:
			return isDynamic() != DYNAMIC_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public Widget getWidget() {
		final IUIAttribute attribute = getUIAttribute();
		if (attribute == null) return null;
		return attribute.getWidget();
	}

	@Override
	public Control getControl() {
		final Widget widget = getWidget();
		if (widget instanceof Control) return (Control) widget;
		return null;
	}

	@Override
	protected String getBaseType() {
		String baseType = getDataType().getBaseType();
		final Widget w = getWidget();
		if (w != null) {
			baseType += "<=>" + w;
			final String attribute = getUIAttribute().getAttribute();
			if (attribute != null && attribute.length() > 0) {
				baseType += "(" + attribute + ")";
			}
		} else if (getUIAttribute() instanceof VirtualUIAttribute) {
			baseType += "<=>VIRTUAL";
		}
		return baseType;
	}

	@Override
	public void updateBinding() {
		final IUIBindingDecorator d = getDecorator();
		if (d != null) {
			d.update();
		}
	}

	@Override
	public void updateBinding(Object[] objects) {
		if (objects != null) {
			boolean found = false;
			final EObject modelObject = getModelObject();
			for (final Object object : objects) {
				if (object == modelObject) {
					found = true;
					break;
				}
			}
			if (!found) return;
		}
		updateBinding();
	}

	@Override
	public void updateSourceProviderState(ISourceProviderStateContext context) {
		context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING, this);
		context.setSelectionProvider(null);

		final IObservableValue v = getModelObservableValue();
		if (v != null) {
			final IBindingDataType dataType = getDataType();
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_TYPE, getType());
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, getModelObject());
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_FEATURE, getModelFeature());
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_RO, !isChangeable()); // TODO ??
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE, dataType.isUnsettable());

			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_VALUE, v.getValue());
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, getUIAttribute().getCurrentValue()
					.getValue());
		}
		context.addObservedValue(getUIAttribute().getCurrentValue());
	}

	@Override
	public boolean isEClassFeature(Class<? extends EObject> objClass, EStructuralFeature sf) {
		if (sf != getModelFeature()) return false;
		if (objClass != null && !objClass.isInstance(getModelObject())) return false;
		return true;
	}

	@Override
	public Collection<EObject> getSelection() {
		final EObject object = getModelObject();
		if (object == null) return Collections.emptyList();
		return Collections.singletonList(object);
	}

	@Override
	public List<String> getErrors() {
		final IContextMessageProvider messageProvider = getService(IContextMessageProvider.class);
		final List<String> errors = new ArrayList<String>();
		if (messageProvider != null) {
			for (final Object mo : messageProvider.getMessages()) {
				final IBindingMessage m = (IBindingMessage) mo;
				if (m.getSeverity() != BindingMessageSeverity.ERROR) {
					continue;
				}
				errors.add(m.getMessage());
			}
		} else {
			for (final Binding b : getDBBindings()) {
				final IStatus status = (IStatus) b.getValidationStatus().getValue();
				if (status.getSeverity() != IStatus.ERROR) {
					continue;
				}
				errors.add(status.getMessage());
			}
		}
		return errors;
	}
} // ValueBindingImpl
