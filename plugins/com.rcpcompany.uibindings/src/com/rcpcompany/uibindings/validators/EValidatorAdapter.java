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
package com.rcpcompany.uibindings.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;
import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This class provides an adapter interface between the {@link EValidator} interface of Ecore and
 * XXX
 * <p>
 * The validator is based on {@link Diagnostician} and will only run after a certain time of
 * inactivity.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EValidatorAdapter extends AbstractValidatorAdapter {

	/**
	 * The diagnostian used for the validation.
	 */
	private final Diagnostician myDiagnostician = new Diagnostician();
	private final Map<Object, Object> myContextEntries = new HashMap<Object, Object>();

	/**
	 * Constructs and returns a new adapter for {@link Diagnostician} based validation.
	 */
	public EValidatorAdapter() {
		myContextEntries.put(SubstitutionLabelProvider.class, new MySubstitutionLabelProvider());
	}

	@Override
	public void validateObjectTree(EObject root, IObservableList messages) {
		final Diagnostic diagnostic = myDiagnostician.validate(root, myContextEntries);
		final List<Message> toRemoveList = new ArrayList<Message>(messages);
		final List<Message> toAddList = new ArrayList<Message>();

		for (final Diagnostic d : diagnostic.getChildren()) {
			boolean old = false;
			for (final Object o : messages) {
				final Message f = (Message) o;
				if (f.getDiagnostic().equals(d)) {
					old = true;
					toRemoveList.remove(f);
				}
			}
			if (old) {
				continue;
			}
			final Message m = new Message(d);
			if (m.getTargets().isEmpty()) {
				continue;
			}
			toAddList.add(m);
		}

		messages.removeAll(toRemoveList);
		messages.addAll(toAddList);
	}

	/**
	 * The {@link IBindingMessage} used for {@link Diagnostic} based messages.
	 */
	private static class Message extends AbstractBindingMessage {
		private final Diagnostic myDiagnostic;

		private Message(Diagnostic diagnostic) {
			super(null);
			myDiagnostic = diagnostic;
			final List<?> data = diagnostic.getData();
			/*
			 * General case:
			 * 
			 * 1) two elements,
			 * 
			 * 2) first is EObject, and
			 * 
			 * 3) second is EStructuralFeature
			 */
			if (data.size() == 2 && data.get(0) instanceof EObject
					&& (data.get(1) == null || data.get(1) instanceof EStructuralFeature)) {
				addTarget((EObject) data.get(0), (EStructuralFeature) data.get(1), null);
				return;
			}

			/*
			 * General case:
			 * 
			 * 1) four elements,
			 * 
			 * 2) first and third are EObject, and
			 * 
			 * 3) second and fourth are EStructuralFeature
			 */
			if (data.size() == 4 && data.get(0) instanceof EObject
					&& (data.get(1) == null || data.get(1) instanceof EStructuralFeature)
					&& data.get(2) instanceof EObject
					&& (data.get(3) == null || data.get(3) instanceof EStructuralFeature)) {
				addTarget((EObject) data.get(0), (EStructuralFeature) data.get(1), null);
				addTarget((EObject) data.get(2), (EStructuralFeature) data.get(3), null);
				return;
			}

			/*
			 * Another General Case: here there are nothing to add
			 * 
			 * 1) one element, and
			 * 
			 * 2) first is Object (not EObject)
			 */
			if (data.size() >= 1 && !(data.get(0) instanceof EObject) && !data.get(0).getClass().isArray()) return;

			/*
			 * Special cases from EObjectValidator
			 */
			if (diagnostic.getSource() == EObjectValidator.DIAGNOSTIC_SOURCE) {
				/*
				 * Special Case: no data!
				 */
				if (data.size() == 0) return;

				/*
				 * Special case:
				 * 
				 * 1) two or three elements,
				 * 
				 * 2) first is EObject, and
				 * 
				 * 3) second is EStructuralFeature
				 */
				if ((data.size() == 2 || data.size() == 3) && data.get(0) instanceof EObject
						&& (data.get(1) == null || data.get(1) instanceof EStructuralFeature)) {
					addTarget((EObject) data.get(0), (EStructuralFeature) data.get(1), null);
					return;
				}

				/*
				 * Another Special case: here there are nothing to add
				 * 
				 * 1) two or more elements,
				 * 
				 * 2) first is Object (not EObject), and
				 * 
				 * 3) second is EDataType
				 */
				if (data.size() >= 2 && !(data.get(0) instanceof EObject) && data.get(1) instanceof EDataType) return;

				switch (diagnostic.getCode()) {
				case EObjectValidator.EOBJECT__UNIQUE_ID: // eObject, otherEObject, id
					addTarget((EObject) data.get(0), null, null);
					break;
				case EObjectValidator.EOBJECT__EVERY_KEY_UNIQUE: // eObject, eReference, value,
																	// otherValue
					addTarget((EObject) data.get(0), (EStructuralFeature) data.get(1), null);
					break;
				case EObjectValidator.EOBJECT__EVERY_BIDIRECTIONAL_REFERENCE_IS_PAIRED: // eObject,
																						// eReference,
																						// oppositeEObject,
																						// eOpposite
					addTarget((EObject) data.get(0), (EStructuralFeature) data.get(1), null);
					addTarget((EObject) data.get(2), (EStructuralFeature) data.get(3), null);
					break;
				case EObjectValidator.EOBJECT__EVERY_MAP_ENTRY_UNIQUE: // eObject, eReference,
																		// entry, eMap.get(index)
					addTarget((EObject) data.get(0), (EStructuralFeature) data.get(1), data.get(2));
					break;
				case EObjectValidator.DATA_VALUE__VALUE_IN_RANGE: // value, ...
				case EObjectValidator.DATA_VALUE__LENGTH_IN_RANGE: // value, ...
				case EObjectValidator.DATA_VALUE__TOTAL_DIGITS_IN_RANGE: // value, ...
				case EObjectValidator.DATA_VALUE__VALUE_IN_ENUMERATION: // value, ...
				case EObjectValidator.DATA_VALUE__MATCHES_PATTERN: // value, ...
				case EObjectValidator.DATA_VALUE__TYPE_CORRECT: // value, ...
					break;
				}
				return;
			}

			/*
			 * The normal case
			 */
			for (final Object o : data) {
				if (o == null) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					continue;
				}
				if (o instanceof EObject) {
					addTarget((EObject) o, null, null);
					continue;
				}

				if (!(o instanceof Object[])) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					continue;
				}
				final Object[] a = (Object[]) o;
				if (a.length < 1 || 3 < a.length) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					continue;
				}
				if (!(a[0] instanceof EObject)) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					continue;
				}
				if (a.length > 1 && !(a[1] == null || a[1] instanceof EStructuralFeature)) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					continue;
				}
				final EObject obj = (EObject) a[0];
				final EStructuralFeature feature = a.length > 1 ? (EStructuralFeature) a[1] : null;
				final Object key = a.length > 2 ? a[2] : null;

				if (feature != null && !obj.eClass().getEAllStructuralFeatures().contains(feature)) {
					LogUtils.DEBUG_STRACK_LEVELS = 4;
					LogUtils.error(obj, "Reported problem with feature " + feature.getContainerClass().getSimpleName()
							+ "." + feature.getName() + " which is not a feature of " + obj.getClass().getSimpleName());
					LogUtils.DEBUG_STRACK_LEVELS = 0;
					continue;
				}
				addTarget(obj, feature, key);
			}
		}

		@Override
		public String getSource() {
			return getDiagnostic().getSource();
		}

		@Override
		public int getCode() {
			return getDiagnostic().getCode();
		}

		@Override
		public Object getData() {
			return getDiagnostic();
		}

		@Override
		public String getMessage() {
			return getDiagnostic().getMessage();
		}

		@Override
		public BindingMessageSeverity getSeverity() {
			switch (getDiagnostic().getSeverity()) {
			case Diagnostic.OK:
				return BindingMessageSeverity.NONE;
			case Diagnostic.INFO:
				return BindingMessageSeverity.INFORMATION;
			case Diagnostic.WARNING:
				return BindingMessageSeverity.WARNING;
			case Diagnostic.ERROR:
				return BindingMessageSeverity.ERROR;
			default:
				LogUtils.error(this, "Unknown severity: " + getDiagnostic().getSeverity());
				break;
			}
			return BindingMessageSeverity.NONE;
		}

		public Diagnostic getDiagnostic() {
			return myDiagnostic;
		}

		@Override
		public boolean supersedes(IBindingMessage otherMessage) {
			if (otherMessage instanceof Message) {
				final Message m = (Message) otherMessage;
				if (m.getDiagnostic() == getDiagnostic()) return true;
			}
			return super.supersedes(otherMessage);
		}
	}

	/**
	 * {@link SubstitutionLabelProvider} based on {@link IBindingObjectInformation}.
	 */
	public class MySubstitutionLabelProvider implements SubstitutionLabelProvider {

		@Override
		public String getObjectLabel(EObject eObject) {
			return IBindingObjectInformation.Factory.getQualifiedName(eObject);
		}

		@Override
		public String getFeatureLabel(EStructuralFeature sf) {
			return ToStringUtils.formatHumanReadable(sf.getName());
		}

		@Override
		public String getValueLabel(EDataType eDataType, Object value) {
			return EcoreUtil.convertToString(eDataType, value);
		}
	}
}
