package com.rcpcompany.uibindings.internal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;

import com.rcpcompany.uibindings.utils.IAutoFormCreator;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Implementation of {@link IAutoFormCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class AutoFormCreator implements IAutoFormCreator {
	/**
	 * The form used to create fields.
	 */
	private final IFormCreator myForm;

	/**
	 * The base {@link EClass} of the form.
	 */
	private final EClass myEClass;

	/**
	 * The value of the form.
	 */
	private final IObservableValue myValue;

	private final IValueChangeListener myValueChangeListener = new IValueChangeListener() {
		@Override
		public void handleValueChange(ValueChangeEvent event) {
			updateFields();
		}
	};

	/**
	 * Section used for identification fields.
	 */
	private final IFormCreator myIdentificationSection;

	/**
	 * Section used for identification fields.
	 */
	private final IFormCreator myBaseSection;

	/**
	 * Section used for identification fields.
	 */
	private final IFormCreator myOptionalSection;

	/**
	 * Constructs and returns a new auto form.
	 * 
	 * @param value the value currently shown
	 * @param title title used for the form
	 * @param parent the parent composite
	 * @param part the view part
	 */
	public AutoFormCreator(IObservableValue value, String title, Composite parent, IWorkbenchPart part) {
		myValue = value;
		final Object valueType = value.getValueType();
		if (!(valueType instanceof EClass)) {
			myForm = null;
			myEClass = null;
			myIdentificationSection = null;
			myBaseSection = null;
			myOptionalSection = null;
			final Label label = new Label(parent, SWT.NONE);
			label.setText("Value type of IAutoFormCreator not subclass of EClass: " + valueType);
			// TODO: button for details

			return;
		}
		myEClass = (EClass) valueType;
		myForm = IFormCreator.Factory.createScrolledForm(value, parent, title);

		myIdentificationSection = myForm.addSection("Identification");
		myBaseSection = myForm.addSection("Base Information");
		myOptionalSection = myForm.addSection("Optional");

		IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(), part.getSite());

		myValue.addValueChangeListener(myValueChangeListener);
		if (myValue.getValue() != null) {
			updateFields();
		}
	}

	@Override
	public void dispose() {
		myValue.removeValueChangeListener(myValueChangeListener);
		myForm.dispose();
	}

	@Override
	public IFormCreator getForm() {
		return myForm;
	}

	/**
	 * Updates the fields of the form.
	 */
	protected void updateFields() {
		final Object value = myValue.getValue();
		getFields(myEClass);
	}

	/**
	 * Returns the fields for the specified class.
	 * 
	 * @param eclass the class to find
	 * @return the fields of the class
	 */
	public static ClassFieldData getFields(EClass eclass) {
		ClassFieldData d = theFields.get(eclass);
		if (d == null) {
			d = new ClassFieldData(eclass);
			theFields.put(eclass, d);
		}
		return d;
	}

	/**
	 * Map with all the field data on a per class basis.
	 */
	public static final Map<EClass, ClassFieldData> theFields = new HashMap<EClass, ClassFieldData>();

	/**
	 * Data structure used to save information about fields in a specific class.
	 */
	public static class ClassFieldData {
		/**
		 * Constructs and returns a new data object for the specified class.
		 * 
		 * @param eclass the class of the object
		 */
		public ClassFieldData(EClass eclass) {
			myEClass = eclass;

			for (final EStructuralFeature sf : myEClass.getEAllStructuralFeatures()) {
				boolean required = false;
				if (sf.isRequired()) {
					required = true;
				}
				if (!required && sf instanceof EReference) {
					final EReference ref = (EReference) sf;
					if (ref.isContainer()) {
						required = true;
					}
				}
				if (required) {
					myRequiredFeatures.add(sf);
				} else {
					myOptionalFeatures.add(sf);
				}
			}
		}

		/**
		 * @return the class
		 */
		public EClass getEClass() {
			return myEClass;
		}

		/**
		 * List of all required features.
		 */
		private final List<EStructuralFeature> myRequiredFeatures = new ArrayList<EStructuralFeature>();

		/**
		 * List of all optional features.
		 */
		private final List<EStructuralFeature> myOptionalFeatures = new ArrayList<EStructuralFeature>();

		private final EClass myEClass;
	}
}
