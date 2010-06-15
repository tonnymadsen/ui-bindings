package com.rcpcompany.uibindings.tests.views;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;

/**
 * Test view for the primitive widgets
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PrimitiveWidgetsView extends ViewPart {

	private final FormToolkit myToolkit = IManager.Factory.getManager().getFormToolkit();

	private final IObservableValue myTestObject;
	private final TestContainer myTestContainer;

	private List myEnumerationList;
	private CCombo myEnumerationCCombo;
	private Combo myEnumerationCombo;
	private Text myEnumerationText;
	private Text myDatesText;
	private Text myBooleanText;
	private Text myNameSingleText;
	private Text myIntegerText;
	private ScrolledForm myForm;
	private Spinner myIntegerSpinner;
	private Scale myIntegerScale;
	private Slider myIntegerSlider;
	private Label myIntegerLabel;
	private Label myStringLabel;
	private Link myStringLink;
	private Label myBooleanLabel;
	private Button myBooleanCheckbox;
	private DateTime myDatesDate;
	private Label myDatesLabel;
	private Label myEnumerationLabel;
	private Label myByteLabel;
	private Text myByteText;
	private Spinner myByteSpinner;
	private Scale myByteScale;
	private Slider myByteSlider;

	private Label myReferenceLabel;

	private Text myReferenceText;

	private Combo myReferenceCombo;

	private CCombo myReferenceCCombo;

	private List myReferenceList;

	private Text myNameMultiText;

	/**
	 * Constructs and returns a new view.
	 */
	public PrimitiveWidgetsView() {
		myTestContainer = TestModelFactory.eINSTANCE.getTestContainer();
		if (myTestContainer.getCurrent() == null) {
			myTestContainer.setCurrent(myTestContainer.getChildren().get(0));
		}
		myTestObject = EMFObservables.observeValue(myTestContainer, TestModelPackage.Literals.TEST_CONTAINER__CURRENT);
	}

	@Override
	public void createPartControl(Composite parent) {
		System.currentTimeMillis();
		myForm = myToolkit.createScrolledForm(parent);
		final Composite body = myForm.getBody();
		body.setLayout(new GridLayout());
		myToolkit.paintBordersFor(body);

		createReferencesSection(body);

		createStringsSection(body);

		createIntegersSection(body);

		createBytesSection(body);

		createBooleansSection(body);

		createDatesSection(body);

		createEnumerationsSection(body);

		bindUI();
		initializeToolBar();
	}

	private void createEnumerationsSection(final Composite body) {
		final Section enumerationsSection = myToolkit.createSection(body, ExpandableComposite.TITLE_BAR
				| ExpandableComposite.EXPANDED | ExpandableComposite.TWISTIE);
		enumerationsSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		enumerationsSection.setText("Enumerations");

		final Composite enumerationsComposite = myToolkit.createComposite(enumerationsSection, SWT.NONE);
		final GridLayout gridLayout_4 = new GridLayout();
		gridLayout_4.numColumns = 2;
		enumerationsComposite.setLayout(gridLayout_4);
		myToolkit.paintBordersFor(enumerationsComposite);
		enumerationsSection.setClient(enumerationsComposite);

		final Label label_2 = myToolkit.createLabel(enumerationsComposite, "Label", SWT.NONE);
		label_2.setLayoutData(new GridData());

		myEnumerationLabel = myToolkit.createLabel(enumerationsComposite, "new Forms Label", SWT.NONE);

		final Label textLabel_3 = myToolkit.createLabel(enumerationsComposite, "Text", SWT.NONE);
		final GridData gd_textLabel_3 = new GridData();
		textLabel_3.setLayoutData(gd_textLabel_3);

		myEnumerationText = myToolkit.createText(enumerationsComposite, null, SWT.NONE);
		final GridData gd_enumerationText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myEnumerationText.setLayoutData(gd_enumerationText);

		final Label comboLabel = myToolkit.createLabel(enumerationsComposite, "Combo", SWT.NONE);
		final GridData gd_comboLabel = new GridData();
		comboLabel.setLayoutData(gd_comboLabel);

		myEnumerationCombo = new Combo(enumerationsComposite, SWT.NONE);
		myToolkit.adapt(myEnumerationCombo, true, true);
		final GridData gd_enumerationCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myEnumerationCombo.setLayoutData(gd_enumerationCombo);

		final Label label_3 = myToolkit.createLabel(enumerationsComposite, "CCombo", SWT.NONE);
		label_3.setLayoutData(new GridData());

		myEnumerationCCombo = new CCombo(enumerationsComposite, SWT.NONE);
		myEnumerationCCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		myToolkit.adapt(myEnumerationCCombo, true, true);

		myToolkit.createLabel(enumerationsComposite, "List", SWT.NONE);

		myEnumerationList = new List(enumerationsComposite, SWT.BORDER);
		final GridData gd_enumerationList = new GridData(SWT.FILL, SWT.CENTER, false, false);
		myEnumerationList.setLayoutData(gd_enumerationList);
		myToolkit.adapt(myEnumerationList, true, true);
		myForm.setText("Test Form");
	}

	private void createReferencesSection(final Composite body) {
		final Section mySection = myToolkit.createSection(body, ExpandableComposite.TITLE_BAR
				| ExpandableComposite.EXPANDED | ExpandableComposite.TWISTIE);
		mySection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		mySection.setText("References");

		final Composite myComposite = myToolkit.createComposite(mySection, SWT.NONE);
		final GridLayout gridLayout_4 = new GridLayout();
		gridLayout_4.numColumns = 2;
		myComposite.setLayout(gridLayout_4);
		myToolkit.paintBordersFor(myComposite);
		mySection.setClient(myComposite);

		final Label label_2 = myToolkit.createLabel(myComposite, "Label", SWT.NONE);
		label_2.setLayoutData(new GridData());

		myReferenceLabel = myToolkit.createLabel(myComposite, "new Forms Label", SWT.NONE);

		final Label textLabel_3 = myToolkit.createLabel(myComposite, "Text", SWT.NONE);
		final GridData gd_textLabel_3 = new GridData();
		textLabel_3.setLayoutData(gd_textLabel_3);

		myReferenceText = myToolkit.createText(myComposite, null, SWT.NONE);
		final GridData gd_enumerationText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myReferenceText.setLayoutData(gd_enumerationText);

		final Label comboLabel = myToolkit.createLabel(myComposite, "Combo", SWT.NONE);
		final GridData gd_comboLabel = new GridData();
		comboLabel.setLayoutData(gd_comboLabel);

		myReferenceCombo = new Combo(myComposite, SWT.NONE);
		myToolkit.adapt(myReferenceCombo, true, true);
		final GridData gd_enumerationCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myReferenceCombo.setLayoutData(gd_enumerationCombo);

		final Label label_3 = myToolkit.createLabel(myComposite, "CCombo", SWT.NONE);
		label_3.setLayoutData(new GridData());

		myReferenceCCombo = new CCombo(myComposite, SWT.NONE);
		myReferenceCCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		myToolkit.adapt(myReferenceCCombo, true, true);

		myToolkit.createLabel(myComposite, "List", SWT.NONE);

		myReferenceList = new List(myComposite, SWT.BORDER);
		final GridData gd_enumerationList = new GridData(SWT.FILL, SWT.CENTER, false, false);
		myReferenceList.setLayoutData(gd_enumerationList);
		myToolkit.adapt(myReferenceList, true, true);
		myForm.setText("Test Form");
	}

	private void createDatesSection(final Composite body) {
		final Section datesSection = myToolkit.createSection(body, ExpandableComposite.TITLE_BAR
				| ExpandableComposite.EXPANDED | ExpandableComposite.TWISTIE);
		datesSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		datesSection.setText("Dates");

		final Composite datesComposite = myToolkit.createComposite(datesSection, SWT.NONE);
		final GridLayout gridLayout_3 = new GridLayout();
		gridLayout_3.numColumns = 2;
		datesComposite.setLayout(gridLayout_3);
		myToolkit.paintBordersFor(datesComposite);
		datesSection.setClient(datesComposite);

		myToolkit.createLabel(datesComposite, "Label", SWT.NONE);

		myDatesLabel = myToolkit.createLabel(datesComposite, "new Forms Label", SWT.NONE);

		final Label textLabel_2 = myToolkit.createLabel(datesComposite, "Text", SWT.NONE);
		final GridData gd_textLabel_2 = new GridData();
		textLabel_2.setLayoutData(gd_textLabel_2);

		myDatesText = myToolkit.createText(datesComposite, null, SWT.NONE);
		myDatesText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myToolkit.createLabel(datesComposite, "DateTime", SWT.NONE);

		myDatesDate = new DateTime(datesComposite, SWT.NONE);
		myToolkit.adapt(myDatesDate, true, true);
	}

	private void createBooleansSection(final Composite body) {
		final Section booleansSection = myToolkit.createSection(body, ExpandableComposite.TITLE_BAR
				| ExpandableComposite.EXPANDED | ExpandableComposite.TWISTIE);
		booleansSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		booleansSection.setText("Booleans");

		final Composite booleansComposite = myToolkit.createComposite(booleansSection, SWT.NONE);
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.numColumns = 2;
		booleansComposite.setLayout(gridLayout_2);
		myToolkit.paintBordersFor(booleansComposite);
		booleansSection.setClient(booleansComposite);

		myToolkit.createLabel(booleansComposite, "Label", SWT.NONE);

		myBooleanLabel = myToolkit.createLabel(booleansComposite, "new Forms Label", SWT.NONE);

		myToolkit.createLabel(booleansComposite, "Text", SWT.NONE);

		myBooleanText = myToolkit.createText(booleansComposite, null, SWT.NONE);
		final GridData gd_booleanText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myBooleanText.setLayoutData(gd_booleanText);

		final Label checkboxLabel = myToolkit.createLabel(booleansComposite, "Checkbox", SWT.NONE);
		final GridData gd_checkboxLabel = new GridData();
		checkboxLabel.setLayoutData(gd_checkboxLabel);

		myBooleanCheckbox = myToolkit.createButton(booleansComposite, "Check Button", SWT.CHECK);
		final GridData gd_booleanCheckbox = new GridData();
		myBooleanCheckbox.setLayoutData(gd_booleanCheckbox);
	}

	private void createBytesSection(final Composite body) {
		final Section byteSection = myToolkit.createSection(body, ExpandableComposite.TITLE_BAR
				| ExpandableComposite.EXPANDED | ExpandableComposite.TWISTIE);
		byteSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		byteSection.setText("Byte");

		final Composite byteComposite = myToolkit.createComposite(byteSection, SWT.NONE);
		final GridLayout gridLayout_11 = new GridLayout();
		gridLayout_11.numColumns = 2;
		byteComposite.setLayout(gridLayout_11);
		myToolkit.paintBordersFor(byteComposite);
		byteSection.setClient(byteComposite);

		myToolkit.createLabel(byteComposite, "Label", SWT.NONE);

		myByteLabel = myToolkit.createLabel(byteComposite, "new Forms Label", SWT.NONE);
		final GridData gd_byteLabel = new GridData(SWT.FILL, SWT.CENTER, false, false);
		myByteLabel.setLayoutData(gd_byteLabel);

		myToolkit.createLabel(byteComposite, "Text", SWT.NONE);

		myByteText = myToolkit.createText(byteComposite, null, SWT.NONE);
		final GridData gd_byteText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myByteText.setLayoutData(gd_byteText);

		myToolkit.createLabel(byteComposite, "Spinner", SWT.NONE);

		myByteSpinner = new Spinner(byteComposite, SWT.BORDER);
		final GridData gd_byteSpinner = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myByteSpinner.setLayoutData(gd_byteSpinner);
		myToolkit.adapt(myByteSpinner, true, true);

		myToolkit.createLabel(byteComposite, "Scale", SWT.NONE);

		myByteScale = new Scale(byteComposite, SWT.NONE);
		final GridData gd_byteScale = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myByteScale.setLayoutData(gd_byteScale);
		myToolkit.adapt(myByteScale, true, true);

		myToolkit.createLabel(byteComposite, "Slider", SWT.NONE);

		myByteSlider = new Slider(byteComposite, SWT.NONE);
		final GridData gd_byteSlider = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myByteSlider.setLayoutData(gd_byteSlider);
		myToolkit.adapt(myByteSlider, true, true);
	}

	private void createIntegersSection(final Composite body) {
		final Section integersSection = myToolkit.createSection(body, ExpandableComposite.TITLE_BAR
				| ExpandableComposite.EXPANDED | ExpandableComposite.TWISTIE);
		integersSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		integersSection.setText("Integers");

		final Composite integersComposite = myToolkit.createComposite(integersSection, SWT.NONE);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 2;
		integersComposite.setLayout(gridLayout_1);
		myToolkit.paintBordersFor(integersComposite);
		integersSection.setClient(integersComposite);

		final Label label = myToolkit.createLabel(integersComposite, "Label", SWT.NONE);
		label.setLayoutData(new GridData());

		myIntegerLabel = myToolkit.createLabel(integersComposite, "new Forms Label", SWT.NONE);
		final GridData gd_integerLabel = new GridData(SWT.FILL, SWT.CENTER, false, false);
		myIntegerLabel.setLayoutData(gd_integerLabel);

		final Label textLabel = myToolkit.createLabel(integersComposite, "Text", SWT.NONE);
		final GridData gd_textLabel = new GridData();
		textLabel.setLayoutData(gd_textLabel);

		myIntegerText = myToolkit.createText(integersComposite, null, SWT.NONE);
		final GridData gd_integerText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myIntegerText.setLayoutData(gd_integerText);

		final Label label_1 = myToolkit.createLabel(integersComposite, "Spinner", SWT.NONE);
		label_1.setLayoutData(new GridData());

		myIntegerSpinner = new Spinner(integersComposite, SWT.BORDER);
		final GridData gd_integerSpinner = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myIntegerSpinner.setLayoutData(gd_integerSpinner);
		myToolkit.adapt(myIntegerSpinner, true, true);

		myToolkit.createLabel(integersComposite, "Scale", SWT.NONE);

		myIntegerScale = new Scale(integersComposite, SWT.NONE);
		final GridData gd_integerScale = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myIntegerScale.setLayoutData(gd_integerScale);
		myToolkit.adapt(myIntegerScale, true, true);

		myToolkit.createLabel(integersComposite, "Slider", SWT.NONE);

		myIntegerSlider = new Slider(integersComposite, SWT.NONE);
		final GridData gd_integerSlider = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myIntegerSlider.setLayoutData(gd_integerSlider);
		myToolkit.adapt(myIntegerSlider, true, true);
	}

	private void createStringsSection(final Composite body) {
		final Section stringsSection = myToolkit.createSection(body, ExpandableComposite.TITLE_BAR
				| ExpandableComposite.EXPANDED | ExpandableComposite.TWISTIE);
		stringsSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		stringsSection.setText("Strings");

		final Composite stringsComposite = myToolkit.createComposite(stringsSection, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		stringsComposite.setLayout(gridLayout);
		myToolkit.paintBordersFor(stringsComposite);
		stringsSection.setClient(stringsComposite);

		myToolkit.createLabel(stringsComposite, "Label", SWT.NONE);

		myStringLabel = myToolkit.createLabel(stringsComposite, "new Forms Label", SWT.NONE);

		final Label textLabel_1 = myToolkit.createLabel(stringsComposite, "Text (SINGLE)", SWT.NONE);
		final GridData gd_textLabel_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		textLabel_1.setLayoutData(gd_textLabel_1);

		myNameSingleText = myToolkit.createText(stringsComposite, null, SWT.NONE);
		final GridData gd_stringText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myNameSingleText.setLayoutData(gd_stringText);

		final Label textLabel_2 = myToolkit.createLabel(stringsComposite, "Text (MULTI)", SWT.MULTI);
		final GridData gd_textLabel_2 = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		textLabel_2.setLayoutData(gd_textLabel_2);

		myNameMultiText = myToolkit.createText(stringsComposite, null, SWT.NONE);
		final GridData gd_stringMultiText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_stringMultiText.heightHint = 60;
		myNameMultiText.setLayoutData(gd_stringMultiText);

		myToolkit.createLabel(stringsComposite, "Link", SWT.NONE);

		myStringLink = new Link(stringsComposite, SWT.NONE);
		myToolkit.adapt(myStringLink, true, true);
	}

	private void bindUI() {
		final IBindingContext ctx = IBindingContext.Factory.createContext(myForm);

		EStructuralFeature feature;

		final IObservableList list = UIBindingsEMFObservables.observeList(ctx.getEditingDomain(), myTestContainer,
				TestModelPackage.Literals.TEST_CONTAINER__CHILDREN);

		feature = TestModelPackage.Literals.TEST_CONTAINER__CURRENT;
		ctx.addBinding(myReferenceLabel, myTestContainer, feature).arg(Constants.ARG_VALID_VALUES, list);
		ctx.addBinding(myReferenceText, myTestContainer, feature).arg(Constants.ARG_VALID_VALUES, list);
		ctx.addBinding(myReferenceCombo, myTestContainer, feature).arg(Constants.ARG_VALID_VALUES, list);
		ctx.addBinding(myReferenceCCombo, myTestContainer, feature).arg(Constants.ARG_VALID_VALUES, list);
		ctx.addBinding(myReferenceList, myTestContainer, feature).arg(Constants.ARG_VALID_VALUES, list);

		feature = TestModelPackage.Literals.TEST_OBJECT__TEXT;
		ctx.addBinding(myStringLabel, myTestObject, feature);
		ctx.addBinding(myNameSingleText, myTestObject, feature);
		ctx.addBinding(myNameMultiText, myTestObject, feature);
		ctx.addBinding(myStringLink, myTestObject, feature);

		feature = TestModelPackage.Literals.TEST_OBJECT__NUMBER;
		ctx.addBinding(myIntegerLabel, myTestObject, feature);
		ctx.addBinding(myIntegerText, myTestObject, feature);
		ctx.addBinding(myIntegerSpinner, myTestObject, feature);
		ctx.addBinding(myIntegerScale, myTestObject, feature);
		ctx.addBinding(myIntegerSlider, myTestObject, feature);

		feature = TestModelPackage.Literals.TEST_OBJECT__BYTE;
		ctx.addBinding(myByteLabel, myTestObject, feature);
		ctx.addBinding(myByteText, myTestObject, feature);
		ctx.addBinding(myByteSpinner, myTestObject, feature);
		ctx.addBinding(myByteScale, myTestObject, feature);
		ctx.addBinding(myByteSlider, myTestObject, feature);

		feature = TestModelPackage.Literals.TEST_OBJECT__B;
		ctx.addBinding(myBooleanLabel, myTestObject, feature);
		ctx.addBinding(myBooleanText, myTestObject, feature);
		ctx.addBinding(myBooleanCheckbox, myTestObject, feature);

		feature = TestModelPackage.Literals.TEST_OBJECT__DATE;
		ctx.addBinding(myDatesLabel, myTestObject, feature);
		ctx.addBinding(myDatesText, myTestObject, feature);
		ctx.addBinding(myDatesDate, myTestObject, feature);

		feature = TestModelPackage.Literals.TEST_OBJECT__UNIT;
		ctx.addBinding(myEnumerationLabel, myTestObject, feature);
		ctx.addBinding(myEnumerationText, myTestObject, feature);
		ctx.addBinding(myEnumerationCombo, myTestObject, feature);
		ctx.addBinding(myEnumerationCCombo, myTestObject, feature);
		ctx.addBinding(myEnumerationList, myTestObject, feature);

		ctx.finish();
	}

	private void bindUI2() {
		final IBindingContext ctx = IBindingContext.Factory.createContext(myForm);

		ctx.addBinding(myNameSingleText, myTestObject, TestModelPackage.Literals.TEST_OBJECT__TEXT).arg(
				Constants.ARG_TOOL_TIP_TEXT, "The full name of the contact");
		ctx.finish();
	}

	// private void bindUI2() {
	// IBindingContext ctx = IBindingContext.Factory.createContext(myToolkit,
	// myForm);
	//
	// ctx.addBinding(myNameText, myPerson,
	// TestModelPackage.Literals.PERSON__NAME);
	// ctx.addBinding(mySexCombo, myPerson,
	// TestModelPackage.Literals.PERSON__SEX);
	// ctx.addBinding(myJobTypeText, myPerson,
	// TestModelPackage.Literals.PERSON__JOB_TYPE);
	//
	// IViewerInputBinding input = ctx.addViewerInput(myJobViewer, myPerson,
	// TestModelPackage.Literals.PERSON__JOBS);
	// ctx.addColumn(input, myJobTitleColumn,
	// TestModelPackage.Literals.JOB__TITLE);
	// ctx.addColumn(input, myJobCurrentColumn,
	// TestModelPackage.Literals.JOB__CURRENT);
	// ctx.addColumn(input, myJobStartDateColumn,
	// TestModelPackage.Literals.JOB__START_DATE);
	// ctx.addColumn(input, myJobEndDateColumn,
	// TestModelPackage.Literals.JOB__END_DATE);
	//
	// ctx.finish();
	// }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void initializeToolBar() {
		final IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
	}
}
