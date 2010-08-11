package com.rcpcompany.uibindings.internal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.IBindingContext.FinishOption;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.uibindings.utils.IBindingSpec;
import com.rcpcompany.uibindings.utils.IFormChooser;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link IFormCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormCreator implements IFormCreator {
	/**
	 * The used context.
	 */
	private final IBindingContext myContext;

	/**
	 * The top level {@link Composite}. Has a {@link TableWrapLayout} with 1 column and contains a
	 * number of sections.
	 */
	private final Composite myTop;

	/**
	 * The toolkit used to create all widgets.
	 */
	private final FormToolkit myToolkit;

	/**
	 * The current value of this form.
	 */
	private final IObservableValue myObservableValue;

	/**
	 * For a hierarchy of forms, the top form.
	 */
	private final FormCreator myTopForm;

	// TODO move to the top form?
	private Map<IObservableValue, Map<EStructuralFeature, IObservableValue>> myObservables;

	/**
	 * Whether this form - and all sub-forms - are readonly.
	 */
	private boolean myReadOnly;

	/**
	 * My {@link ScrolledForm} UI object - can be <code>null</code>.
	 */
	private ScrolledForm myScrolledForm = null;

	/**
	 * My {@link Section} UI object - can be <code>null</code>.
	 */
	private Section mySection = null;

	/**
	 * List of all sub forms - including sections.
	 */
	private List<FormCreator> mySubForms = null;

	@Override
	public boolean isTopForm() {
		return myTopForm == this;
	}

	/**
	 * List with all bindings of this form that have not yet been finalized - see
	 * {@link #createFieldReally(BindingDescription)}.
	 */
	private final List<BindingDescription> myBindings = new ArrayList<BindingDescription>();

	/**
	 * Adapter used to ensure the form is finished when the context is...
	 * <p>
	 * Only used in the top form.
	 */
	protected Adapter myContextListener = null;

	/**
	 * Listener used to track the current focus widget.
	 * <p>
	 * Only used in the top form.
	 */
	protected Listener myFocusListener;

	/**
	 * The control that last held focus in this form.
	 * <p>
	 * Only used in the top form.
	 */
	protected Control myLastFocusControl;

	/**
	 * Constructs and returns a new form creator.
	 * 
	 * @param context the context
	 * @param obj the main object
	 * @param toolkit the used Forms UI Toolkit
	 * @param top the top level Composite
	 * @param formHeader the header text used for the form
	 */
	public FormCreator(IBindingContext context, EObject obj, FormToolkit toolkit, Composite top, String formHeader) {
		this(context, createIOV(top, obj), toolkit, top, formHeader);
	}

	/**
	 * Constructs and returns a new form creator.
	 * 
	 * @param context the context
	 * @param value the observable value
	 * @param toolkit the used Forms UI Toolkit
	 * @param top the top level Composite
	 * @param formHeader the header text used for the form
	 */
	public FormCreator(IBindingContext context, IObservableValue value, FormToolkit toolkit, Composite top,
			String formHeader) {
		this(null, context, value, toolkit, top, formHeader);
	}

	/**
	 * Constructs and returns a new form creator.
	 * 
	 * @param topForm the top-level creator for this form creator - <code>null</code> for a
	 *            top-level creator
	 * @param context the context
	 * @param value the observable value
	 * @param toolkit the used Forms UI Toolkit
	 * @param top the top level Composite
	 * @param formHeader the header text used for the form
	 */
	public FormCreator(FormCreator topForm, IBindingContext context, IObservableValue value, FormToolkit toolkit,
			Composite top, String formHeader) {
		if (toolkit == null) {
			toolkit = IManager.Factory.getManager().getFormToolkit();
		}
		myToolkit = toolkit;
		if (topForm == null) {
			myTopForm = this;

			myFocusListener = new Listener() {
				@Override
				public void handleEvent(Event event) {
					myLastFocusControl = (Control) event.widget;
				}
			};
		} else {
			myTopForm = topForm;
			setReadOnly(myTopForm.isReadOnly());
		}
		if (top instanceof Section) {
			mySection = (Section) top;
		}
		if (context == null) {
			if (formHeader != null) {
				myScrolledForm = createScrolledForm(top, formHeader);
				top = myScrolledForm.getBody();
				context = IBindingContext.Factory.createContext(myScrolledForm);
			} else {
				top = createTopComposite(top);
				context = IBindingContext.Factory.createContext(top);
			}
		} else {
			top = createTopComposite(top);
		}
		myContext = context;
		myObservableValue = value;
		myTop = top;
	}

	public FormCreator(final EObject obj, WizardPage page, Composite parent) {
		this(obj, page, IManager.Factory.getManager().getFormToolkit(), parent);
	}

	public FormCreator(final EObject obj, WizardPage page, FormToolkit toolkit, Composite parent) {
		myToolkit = toolkit;
		myTopForm = this;

		myFocusListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				myLastFocusControl = (Control) event.widget;
			}
		};
		myContext = IBindingContext.Factory.createContext(page);
		myObservableValue = createIOV(parent, obj);
		myTop = createTopComposite(parent);

		final IValidatorAdapterManager vam = IValidatorAdapterManager.Factory.getManager();
		final EValidatorAdapter validationAdapter = new EValidatorAdapter();
		vam.addRoot(obj, validationAdapter);

		/*
		 * Make sure the validation adapter is removed again when the page is disposed...
		 * 
		 * Page is disposed ==> top composite is disposed => context is disposed ==> dispose is
		 * called on all services
		 */
		final IDisposable adapterDisposer = new IDisposable() {
			@Override
			public void dispose() {
				vam.removeRoot(obj, validationAdapter);
			}
		};
		getContext().registerService(adapterDisposer);
	}

	@Override
	public void dispose() {

	}

	private static IObservableValue createIOV(Composite top, EObject obj) {
		Assert.isNotNull(obj);
		return new WritableValue(SWTObservables.getRealm(top.getDisplay()), obj, obj.eClass());
	}

	@Override
	public void setObject(EObject main) {
		myObservableValue.setValue(main);
	}

	@Override
	public boolean isReadOnly() {
		return myReadOnly;
	}

	@Override
	public void setReadOnly(boolean readonly) {
		myReadOnly = readonly;
	}

	@Override
	public EObject getObject() {
		return (EObject) myObservableValue.getValue();
	}

	@Override
	public IObservableValue getObservableValue() {
		return myObservableValue;
	}

	@Override
	public void setHeading(String heading) {
		if (myScrolledForm != null) {
			myScrolledForm.setText(heading);
		}
		if (mySection != null) {
			mySection.setText(heading);
		}
	}

	@Override
	public IFormCreator subForm(Composite parent, IObservableValue obj) {
		return subForm(parent, obj, 0);
	}

	/**
	 * Creates a sub form for the specified parent and new base object.
	 * 
	 * @param parent the parent composite
	 * @param obj the new base object
	 * @param indent whether the new form is indented
	 * @return the new sub form
	 */
	protected IFormCreator subForm(Composite parent, IObservableValue obj, int indent) {
		final FormCreator form = new FormCreator(myTopForm, myContext, obj, myToolkit, parent, (String) null);
		form.setFieldsAligned(areFieldsAligned());

		if (mySubForms == null) {
			mySubForms = new ArrayList<FormCreator>();
		}
		mySubForms.add(form);

		final TableWrapLayout layout = (TableWrapLayout) form.getTop().getLayout();
		layout.leftMargin = layout.rightMargin = indent;
		layout.topMargin = layout.bottomMargin = 3;

		return form;
	}

	@Override
	public IFormCreator subForm(Composite parent) {
		return subForm(parent, myObservableValue, 0);
	}

	@Override
	public void addLabel(String labelText) {
		final Label label = myToolkit.createLabel(myTop, labelText, SWT.NONE);

		final TableWrapData ld = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		label.setLayoutData(ld);
	}

	@Override
	public IValueBinding addField(EStructuralFeature feature) {
		return addField(myObservableValue, feature, SWT.NONE);
	}

	@Override
	public IValueBinding addField(EStructuralFeature feature, int style) {
		return addField(myObservableValue, feature, style);
	}

	@Override
	public IValueBinding addField(EObject object, EStructuralFeature feature, int style) {
		/*
		 * We create the binding first here!
		 * 
		 * This allows us to access all the needed arguments of the binding :-)
		 */
		if (myContext == null) {
			LogUtils.throwException(this, "No context specified for IFormCreator", null);
		}
		final IValueBinding binding = myContext.addBinding().model(object, feature);
		createField(binding, style);

		return binding;
	};

	@Override
	public IValueBinding addField(IObservableValue value, EStructuralFeature feature, int style) {
		/*
		 * We create the binding first here!
		 * 
		 * This allows us to access all the needed arguments of the binding :-)
		 */
		if (myContext == null) {
			LogUtils.throwException(this, "No context specified for IFormCreator", null);
		}
		final IValueBinding binding = myContext.addBinding().model(value, feature);
		createField(binding, style);

		return binding;
	};

	@Override
	public IValueBinding addField(IObservableValue value, int style) {
		/*
		 * We create the binding first here!
		 * 
		 * This allows use to access all the needed arguments of the binding :-)
		 */
		if (myContext == null) {
			LogUtils.throwException(this, "No context specified for IFormCreator", null);
		}
		final IValueBinding binding = myContext.addBinding().model(value);
		createField(binding, style);

		return binding;
	}

	private static final Object FIELDS_COMPOSITE_MARKER = new Object();

	/**
	 * Creates the field based on the label and the binding...
	 * 
	 * @param binding the binding
	 * @param style additional styles to use for the value Control
	 */
	private void createField(final IValueBinding binding, int style) {
		final Composite fieldComp = getFieldsComposite();
		final Label labelControl = myToolkit.createLabel(fieldComp, "");
		labelControl.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		final Label placeholderControl = new Label(fieldComp, SWT.NONE);
		myBindings.add(new BindingDescription(binding, labelControl, placeholderControl, style));

		delayContextFinish();
	}

	/**
	 * 
	 */
	private void delayContextFinish() {
		if (isTopForm()) {
			if (myContextListener == null && myContext != null) {
				myContextListener = new AdapterImpl() {
					@Override
					public void notifyChanged(Notification msg) {
						if (msg.isTouch()) return;
						if (msg.getFeature() != IUIBindingsPackage.Literals.BINDING_CONTEXT__STATE) return;

						finish();
					}
				};
				myContext.eAdapters().add(myContextListener);
			}
		}
	}

	/**
	 * Check if the last control of {@link #myTop} is a {@link Composite} with the data
	 * {@link #FIELDS_COMPOSITE_MARKER} .
	 * 
	 * @return a suitable Composite for the fields
	 */
	private Composite getFieldsComposite() {
		final Control[] children = myTop.getChildren();
		if (children.length == 0) return createFieldsComposite();
		final Control last = children[children.length - 1];
		if (!(last instanceof Composite)) return createFieldsComposite();
		final Composite fc = (Composite) last;

		if (fc.getData() != FIELDS_COMPOSITE_MARKER) return createFieldsComposite();

		return fc;
	}

	/**
	 * Creates a new suitable fields {@link Composite}.
	 * 
	 * @return the a new fields composite
	 */
	private Composite createFieldsComposite() {
		final Composite fc = myToolkit.createComposite(myTop, SWT.NONE);
		fc.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP));
		final GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = layout.marginWidth = 0;
		layout.horizontalSpacing = 10;
		fc.setLayout(layout);

		fc.setData(FIELDS_COMPOSITE_MARKER);

		return fc;
	}

	/**
	 * Fixes the binding based on the binding description.
	 * 
	 * @param description the description of the wanted binding
	 */
	private void createFieldReally(BindingDescription description) {
		String label = description.binding.getLabel();
		if (label.length() > 0 && label.charAt(label.length() - 1) != ':') {
			label = label + ":";
		}

		description.labelControl.setText(label);
		description.labelControl.setToolTipText(description.binding.getArgument(Constants.ARG_TOOL_TIP_TEXT,
				String.class, null));

		int style = description.placeholderStyle;
		if (myReadOnly || !description.binding.isChangeable()) {
			style |= SWT.READ_ONLY;
		}

		/*
		 * Create the real control/controls
		 */
		final Composite parent = description.placeholderControl.getParent();
		final Control c;

		c = description.binding.createPreferredControl(parent, style | myToolkit.getBorderStyle());

		/*
		 * Figure out the layout to use
		 */
		if (c instanceof Button) {
			// No layout for buttons
		} else {
			final boolean b = (style & SWT.V_SCROLL) == SWT.V_SCROLL;
			final GridData ld = new GridData(SWT.LEFT, b ? SWT.FILL : SWT.TOP, false, b);
			ld.widthHint = description.binding.getArgument(Constants.ARG_WIDTH, Integer.class, 200);
			if (c instanceof StyledText) {
				ld.heightHint = description.binding.getArgument(Constants.ARG_HEIGHT, Integer.class, 80);
				ld.widthHint += 7; // missing trim in StyledText compared to Text
			}
			if ((style & SWT.MULTI) == SWT.MULTI) {
				ld.heightHint = description.binding.getArgument(Constants.ARG_HEIGHT, Integer.class, 80);
			}

			c.setLayoutData(ld);
		}
		myTopForm.decorateControl(c);
		/*
		 * Assign it as the ui of the binding
		 */
		description.binding.ui(c);

		/*
		 * Replace the old place holder
		 */
		c.moveAbove(description.placeholderControl);
		description.placeholderControl.dispose();
		description.placeholderControl = c;
	}

	protected void decorateControl(Control c) {
		c.addListener(SWT.FocusIn, myFocusListener);
	}

	@Override
	public void addConstantField(String label, Object value, int style) {
		IObservableValue ov;
		if (value instanceof EEnumLiteral) {
			ov = WritableValue.withValueType(((EEnumLiteral) value).getEEnum());
		} else if (value instanceof EObject) {
			ov = WritableValue.withValueType(((EObject) value).eClass());
		} else {
			ov = WritableValue.withValueType(String.class);
			value = value == null ? "<null>" : value.toString();
		}
		ov.setValue(value);
		addField(ov, style).label(label);
	}

	@Override
	public void setFocus() {
		if (!isTopForm()) {
			myTopForm.setFocus();
			return;
		}
		/*
		 * Set the focus to the first focusable widget of the top composite
		 */
		if (myLastFocusControl != null && !myLastFocusControl.isDisposed()) {
			myLastFocusControl.setFocus();
		} else {
			getTop().setFocus();
		}
	}

	@Override
	public Composite addComposite() {
		return addComposite(true, false);
	}

	@Override
	public Composite addComposite(boolean grabHorizontal, boolean grabVertical) {
		final Composite c = myToolkit.createComposite(myTop);
		setLayoutData(c, grabHorizontal, grabVertical);
		c.setLayout(new FillLayout());
		return c;
	}

	/**
	 * @deprecated use {@link #addTableCreator(EReference, boolean, int)}
	 */
	@Override
	@Deprecated
	public ITableCreator addTableCreator(boolean grabHorizontal, int style) {
		final Composite parent = addComposite(grabHorizontal, false);
		final ITableCreator table = ITableCreator.Factory.create(getContext(), parent, style);
		if (isReadOnly()) {
			table.getBinding().readonly();
		}
		return table;
	}

	@Override
	public ITableCreator addTableCreator(EReference ref, boolean grabHorizontal, int style) {
		final Composite parent = addComposite(grabHorizontal, false);
		final ITableCreator table = ITableCreator.Factory.create(getContext(), parent, style, myObservableValue, ref);
		if (isReadOnly()) {
			table.getBinding().readonly();
		}
		return table;
	}

	@Override
	public IFormCreator addSection(String label, EObject obj) {
		return addSection(label, createIOV(myTop, obj));
	}

	@Override
	public IFormCreator addSection(String label, IObservableValue ov) {
		return addSection(label, ov, false);
	}

	@Override
	public IFormCreator addSection(String label, boolean grabVertical) {
		return addSection(label, myObservableValue, grabVertical);
	}

	@Override
	public IFormCreator addSection(String label, IObservableValue ov, boolean grabVertical) {
		final Section section = myToolkit.createSection(myTop, label != null ? ExpandableComposite.TITLE_BAR
				| ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED : ExpandableComposite.NO_TITLE);
		section.clientVerticalSpacing = 6;
		if (label != null) {
			section.setText(label);
		}
		setLayoutData(section, true, grabVertical);

		final IFormCreator subForm = subForm(section, ov, 5);
		setLayoutData(subForm.getTop(), true, grabVertical);
		section.setClient(subForm.getTop());

		return subForm;
	}

	@Override
	public IFormCreator addSection(String label) {
		return addSection(label, myObservableValue);
	}

	@Override
	public void addSeparator() {
		final Label label = myToolkit.createLabel(myTop, "", SWT.SEPARATOR | SWT.HORIZONTAL);

		final TableWrapData ld = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		label.setLayoutData(ld);
	}

	@Override
	public void addSeparator(Separator type) {
		int height = SWT.DEFAULT;
		int style = SWT.NONE;
		switch (type) {
		case LINE:
			style = SWT.SEPARATOR | SWT.HORIZONTAL;
			break;
		case MICRO:
			height = 1;
			break;
		case TINY:
			height = 4;
			break;
		case SMALL:
			height = 8;
			break;
		case BIG:
			height = 16;
			break;
		}
		final Label sep = myToolkit.createLabel(myTop, "", style);

		final TableWrapData ld = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		ld.heightHint = height;
		sep.setLayoutData(ld);
	}

	/**
	 * Creates and returns a new form composite.
	 * 
	 * @param parent the parent composite
	 * @param formHeader the header text used for the form
	 * @return the new composite
	 */
	protected ScrolledForm createScrolledForm(final Composite parent, String formHeader) {
		final ScrolledForm form = myToolkit.createScrolledForm(parent);
		myToolkit.decorateFormHeading(form.getForm());
		form.setText(formHeader);

		final Composite c = form.getBody();
		myToolkit.paintBordersFor(c);
		if (parent.getLayout() instanceof GridLayout) {
			final GridLayout g = (GridLayout) parent.getLayout();
			final GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, g.numColumns, 1);
			form.setLayoutData(gd);
		} else if (parent.getLayout() instanceof TableWrapLayout) {
			final TableWrapLayout g = (TableWrapLayout) parent.getLayout();
			final TableWrapData gd = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB, 1,
					g.numColumns);
			form.setLayoutData(gd);
		} else if (parent.getLayout() instanceof ColumnLayout) {
			// Nothing!
		} else {
			// Nothing?
		}
		setTopLayout(c);
		return form;
	}

	/**
	 * Sets the layout of a top composite.
	 * 
	 * @param c the composite
	 */
	protected void setTopLayout(final Composite c) {
		final TableWrapLayout l = new TableWrapLayout();
		l.verticalSpacing = 10;
		l.leftMargin = l.rightMargin = 5;
		l.topMargin = l.bottomMargin = 5;
		c.setLayout(l);
	}

	/**
	 * Creates and returns a new form composite.
	 * 
	 * @param parent the parent composite
	 * @return the new composite
	 */
	protected Composite createTopComposite(final Composite parent) {
		final Composite c = myToolkit.createComposite(parent, SWT.NONE);
		final Layout l = parent.getLayout();
		if (l == null) {
			parent.setLayout(new FillLayout());
		} else if (l instanceof GridLayout) {
			final GridLayout g = (GridLayout) l;
			final GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, g.numColumns, 1);
			c.setLayoutData(gd);
		} else if (l instanceof TableWrapLayout) {
			final TableWrapLayout g = (TableWrapLayout) l;
			final TableWrapData gd = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB, 1,
					g.numColumns);
			c.setLayoutData(gd);
		} else if (l instanceof ColumnLayout) {
			// Nothing!
		} else {
			// Nothing?
		}
		myToolkit.paintBordersFor(c);
		setTopLayout(c);
		return c;
	}

	@Override
	public void setLayoutData(Control ctl, boolean grabHorizontal, boolean grabVertical) {
		final TableWrapData ld = new TableWrapData(grabHorizontal ? TableWrapData.FILL_GRAB : TableWrapData.LEFT,
				grabVertical ? TableWrapData.FILL_GRAB : TableWrapData.TOP);
		ctl.setLayoutData(ld);
	}

	@Override
	public void finish() {
		/*
		 * Delegate to the top-level form
		 */
		if (!isTopForm()) {
			myTopForm.finish();
			return;
		}
		if (myContext == null) return;

		if (myContextListener != null) {
			myContext.eAdapters().remove(myContextListener);
			myContextListener = null;
		}

		myTop.setLayoutDeferred(true);
		final List<BindingDescription> fields = new ArrayList<BindingDescription>();
		finishAllfields(fields);
		myTop.setLayoutDeferred(false);

		/*
		 * Now left align all the fields
		 */
		myTop.layout(true);
		final Map<Label, Rectangle> labels = new HashMap<Label, Rectangle>();
		int right = 0;
		for (final BindingDescription bd : fields) {
			final Label label = bd.labelControl;
			if (label == null) {
				continue;
			}
			final Rectangle rect = label.getDisplay().map(label, getTop(), label.getBounds());
			final int myright = rect.x + rect.width;
			labels.put(label, rect);
			if (right < myright) {
				right = myright;
			}
		}
		myTop.setLayoutDeferred(true);
		for (final Entry<Label, Rectangle> entry : labels.entrySet()) {
			final Rectangle rect = entry.getValue();
			final int wantedWidth = right - rect.x;
			if (wantedWidth <= rect.width) {
				continue;
			}
			final Label label = entry.getKey();
			final Object ld = label.getLayoutData();
			if (!(ld instanceof GridData)) {
				continue;
			}
			final GridData gd = (GridData) ld;
			gd.widthHint = wantedWidth;
			label.getParent().layout(true);
		}
		myTop.setLayoutDeferred(false);

		myContext.finish(FinishOption.LAZY);

		// myTop.layout();
		// dumpControl(myTop, "");
	}

	private void dumpControl(Control c, String prefix) {
		System.out.println(prefix + c + ": " + c.getBounds() + " " + c.getLayoutData());
		if (c instanceof Composite) {
			final Composite comp = (Composite) c;
			System.out.println(prefix + "      " + comp.getLayout());
			for (final Control ch : comp.getChildren()) {
				dumpControl(ch, prefix + "| ");
			}
		}
	}

	/**
	 * Creates all fields in this form and all sub forms.
	 * 
	 * @param fields list to which all fields must be added if this form is aligned
	 */
	public void finishAllfields(List<BindingDescription> fields) {
		for (final BindingDescription bd : myBindings) {
			createFieldReally(bd);
			if (areFieldsAligned()) {
				fields.add(bd);
			}
		}
		myBindings.clear();
		if (mySubForms != null) {
			for (final FormCreator c : mySubForms) {
				c.finishAllfields(fields);
			}
		}
	}

	@Override
	public IBindingContext getContext() {
		return myContext;
	}

	@Override
	public Composite getTop() {
		return myTop;
	}

	@Override
	public FormToolkit getToolkit() {
		return myToolkit;
	}

	@Override
	public ScrolledForm getScrolledForm() {
		return myScrolledForm;
	}

	@Override
	public IValueBinding addField(String spec) {
		return addField(myObservableValue, spec);
	}

	@Override
	public IValueBinding addField(IObservableValue ov, String spec) {
		final IObservableValue currentValue = getObservableValue(ov, spec);

		final Object valueType = ov.getValueType();
		EClass valueEClass = null;
		if (valueType instanceof EClass) {
			valueEClass = (EClass) valueType;
		} else if (valueType instanceof EReference) {
			valueEClass = ((EReference) valueType).getEReferenceType();
		} else {
			LogUtils.throwException(this, "The current value type must be a class or a reference to one: '" + valueType
					+ "'", null);
		}
		final List<IBindingSpec> specList = IBindingSpec.Factory.parseSingleSpec(valueEClass, spec);
		final Map<String, Object> arguments = specList.get(specList.size() - 1).getArguments();

		/*
		 * Figure out the style to use
		 */
		int style = SWT.NONE;
		final String a = (String) arguments.get(Constants.ARG_ALIGNMENT);
		if (a != null) {
			if (a.equals("l")) {
				style |= SWT.LEAD;
			} else if (a.equals("c")) {
				style |= SWT.CENTER;
			} else if (a.equals("r")) {
				style |= SWT.TRAIL;
			} else {
				LogUtils.throwException(this, "Alignment must be one of 'l', 'c' or 'r', got '" + a + "'", null);
			}
		} else {
			style |= UIBindingsUtils.defaultAlignment(currentValue.getValueType());
		}

		/*
		 * Figure out the scrollbars to use
		 */
		final String sb = (String) arguments.get(IBindingSpec.SCROLLBARS);
		if (sb != null) {
			if (sb.equals("h")) {
				style |= SWT.H_SCROLL;
			} else if (sb.equals("v")) {
				style |= SWT.V_SCROLL;
			} else if (sb.equals("b")) {
				style |= SWT.H_SCROLL | SWT.V_SCROLL;
			} else {
				LogUtils.throwException(this, "Scrollbars must be one of 'h', 'v' or 'b', got '" + sb + "'", null);
			}
		}

		/*
		 * Fish out read-only
		 */
		final Boolean ro = (Boolean) arguments.get(Constants.ARG_READONLY);
		if (ro != null && ro) {
			style |= SWT.READ_ONLY;
		}

		/*
		 * Fish out multi-line
		 */
		final Boolean multi = (Boolean) arguments.get(IBindingSpec.MULTI);
		if (multi != null && multi) {
			style |= SWT.MULTI;
		}

		/*
		 * Create the field
		 */
		final IValueBinding binding = addField(currentValue, style);

		/*
		 * Add any arguments
		 */
		// final Control control = binding.getControl();
		for (final Entry<String, Object> entry : arguments.entrySet()) {
			if (Constants.ARG_ALIGNMENT.equals(entry.getKey())) {
				// Done above
			} else {
				binding.arg(entry.getKey(), entry.getValue());
			}
		}

		return binding;
	}

	/**
	 * The description of a single binding of this form.
	 */
	private static class BindingDescription {

		public BindingDescription(IValueBinding binding, Label labelControl, Control placeholderControl,
				int placeholderStyle) {
			super();
			this.binding = binding;
			this.labelControl = labelControl;
			this.placeholderControl = placeholderControl;
			this.placeholderStyle = placeholderStyle;
		}

		public final IValueBinding binding;
		public final Label labelControl;
		public Control placeholderControl;
		public final int placeholderStyle;
	}

	@Override
	public IFormCreator[] addColumns(boolean... grab) {
		final List<GridData> data = new ArrayList<GridData>();
		for (final boolean e : grab) {
			data.add(new GridData(SWT.FILL, SWT.FILL, e, false));
		}
		return addColumns(data.toArray(new GridData[data.size()]));
	}

	@Override
	public IFormCreator[] addColumns(GridData... layoutData) {
		final List<IFormCreator> forms = new ArrayList<IFormCreator>();
		boolean grabVertical = false;
		for (final GridData gd : layoutData) {
			if (gd.grabExcessVerticalSpace) {
				grabVertical = true;
			}
		}

		final Composite parent = addComposite(true, grabVertical);
		final GridLayout l = new GridLayout(layoutData.length, false);
		l.marginHeight = l.marginWidth = 0;
		parent.setLayout(l);
		for (final GridData gd : layoutData) {
			final Composite child = new Composite(parent, SWT.NONE);
			child.setLayoutData(gd);
			final IFormCreator s = subForm(child);
			s.setFieldsAligned(false);
			forms.add(s);
		}
		return forms.toArray(new IFormCreator[forms.size()]);
	}

	@Override
	public IFormChooser addFormChooser(IValueBinding discriminant) {
		return IFormChooser.Factory.create(getContext(), discriminant.getModelObservableValue(), addComposite());
	}

	@Override
	public IFormChooser addFormChooser(IObservableValue discriminant) {
		return IFormChooser.Factory.create(getContext(), discriminant, addComposite());
	}

	@Override
	public IObservableValue getObservableValue(String spec) {
		return getObservableValue(myObservableValue, spec);
	}

	@Override
	public IObservableValue getObservableValue(IObservableValue ov, String spec) {
		final Object valueType = ov.getValueType();
		EClass valueEClass = null;
		if (valueType instanceof EClass) {
			valueEClass = (EClass) valueType;
		} else if (valueType instanceof EReference) {
			valueEClass = ((EReference) valueType).getEReferenceType();
		} else {
			LogUtils.throwException(this, "The current value type must be a class or a reference to one: '" + valueType
					+ "'", null);
		}
		final List<IBindingSpec> specList = IBindingSpec.Factory.parseSingleSpec(valueEClass, spec);

		if (myObservables == null) {
			myObservables = new HashMap<IObservableValue, Map<EStructuralFeature, IObservableValue>>();
		}
		IObservableValue currentValue = ov;
		for (final IBindingSpec s : specList) {
			Map<EStructuralFeature, IObservableValue> features = myObservables.get(currentValue);
			if (features == null) {
				features = new HashMap<EStructuralFeature, IObservableValue>();
				myObservables.put(currentValue, features);
			}

			final EStructuralFeature feature = s.getFeature();
			IObservableValue value = features.get(feature);
			if (value == null) {
				value = UIBindingsEMFObservables.observeDetailValue(getContext().getEditingDomain(), currentValue,
						feature);
				features.put(feature, value);
			}

			currentValue = value;
		}

		return currentValue;
	}

	private boolean myFieldsAligned = true;

	@Override
	public boolean areFieldsAligned() {
		return myFieldsAligned;
	}

	@Override
	public void setFieldsAligned(boolean align) {
		myFieldsAligned = align;
	}

	@Override
	public Section getSection() {
		return mySection;
	}

	@Override
	public void addObjectMessages() {
		addObjectMessages(getObservableValue());
	}

	@Override
	public void addObjectMessages(String spec) {
		addObjectMessages(getObservableValue(spec));
	}

	private Set<IObservableValue> myObjectMessageObjects = null;

	@Override
	public void addObjectMessages(final IObservableValue value) {
		if (!isTopForm()) {
			myTopForm.addObjectMessages(value);
			return;
		}
		if (myObjectMessageObjects == null) {
			myObjectMessageObjects = new HashSet<IObservableValue>();
		}
		if (myObjectMessageObjects.contains(value)) return;
		myContext.addBinding().model(value).ui(new VirtualUIAttribute(String.class)).arg(
				Constants.ARG_VALUE_OBJECT_MESSAGES, true);
		myObjectMessageObjects.add(value);
	}
}
