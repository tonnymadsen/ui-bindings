package com.rcpcompany.uibindings.validators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This class provides an adapter interface between the {@link EValidator} interface of Ecore and
 * XXX
 * <p>
 * The validator is based on {@link Diagnostician} and will only run after a certain time of
 * inactivity.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public class EValidatorAdapter extends AbstractValidatorAdapter {
	/**
	 * Factory method for {@link EValidatorAdapter}.
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Adds a new diagnostic for the specified object and feature.
		 * 
		 * @param diagnostics the dianostics chain
		 * @param severity the severity - one of {@link Diagnostic#INFO}, {@link Diagnostic#WARNING}
		 *            or {@link Diagnostic#ERROR}
		 * @param message the message for the diagnostics
		 * @param obj the object
		 * @param feature the feature possible <code>null</code>
		 */
		public static void addDiagnostic(DiagnosticChain diagnostics, int severity, String message, EObject obj,
				EStructuralFeature feature) {
			addDiagnostic(diagnostics, null, 0, severity, message, obj, feature);
		}

		/**
		 * Adds a new diagnostic for the specified object and feature.
		 * <p>
		 * The data associated with the the diagnostic describes a set of objects, features and
		 * possibly keys of objects that are associated with the diagnostic. The data object is an
		 * array where each element is either an {@link EObject} - if the diagnostic is associated
		 * with the object - or an array with an {@link EObject}, a {@link EStructuralFeature} and
		 * optionally a key - if the diagnostic is associated with the specific feature of the
		 * object.
		 * <p>
		 * Thus, if data is
		 * 
		 * <pre>
		 * [obj1,
		 *  [obj2],
		 *  [obj3, sf3],
		 *  [obj4, sf4, key4]
		 *  ]
		 * </pre>
		 * 
		 * then the diagnostic is associated with the following data:
		 * <ul>
		 * <li>the object <code>obj1</code></li>
		 * <li>the object <code>obj2</code></li>
		 * <li>the structural feature <code>sf3</code> of the object <code>obj3</code></li>
		 * <li>the key <code>key4</code> of the structural feature <code>sf4</code> of the object
		 * <code>obj4</code></li>
		 * </ul>
		 * <p>
		 * The meaning of the key is opaque to the code.
		 * 
		 * @param diagnostics the diagnostics chain
		 * @param source the source name space
		 * @param code the code in the name space
		 * @param severity the severity - one of {@link Diagnostic#INFO}, {@link Diagnostic#WARNING}
		 *            or {@link Diagnostic#ERROR}
		 * @param message the message for the diagnostics
		 * @param data the data associated with the diagnostic
		 */
		public static void addDiagnostic(DiagnosticChain diagnostics, String source, int code, int severity,
				String message, Object[] data) {
			/*
			 * Checking the data object
			 */
			for (final Object o : data) {
				if (o == null) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					return;
				}
				if (o instanceof EObject) {
					continue;
				}
				if (!(o instanceof Object[])) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					return;
				}
				final Object[] a = (Object[]) o;
				if (a.length < 1 || 3 < a.length) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					return;
				}
				if (!(a[0] instanceof EObject)) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					return;
				}
				if (a.length > 1 && !(a[1] == null || a[1] instanceof EStructuralFeature)) {
					LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
					return;
				}
				final EObject obj = (EObject) a[0];
				final EStructuralFeature feature = a.length > 1 ? (EStructuralFeature) a[1] : null;

				if (feature != null && !obj.eClass().getEAllStructuralFeatures().contains(feature)) {
					LogUtils.DEBUG_STRACK_LEVELS = 4;
					LogUtils.error(obj, "Reported problem with feature " + feature.getContainerClass().getSimpleName()
							+ "." + feature.getName() + " which is not a feature of " + obj.getClass().getSimpleName());
					LogUtils.DEBUG_STRACK_LEVELS = 0;
					return;
				}
			}
			final BasicDiagnostic diagnostic = new BasicDiagnostic(severity, source, code, message, data);
			diagnostics.add(diagnostic);
		}

		/**
		 * Adds a new diagnostic for the specified object and feature.
		 * 
		 * @param diagnostics the diagnostics chain
		 * @param source the source name space
		 * @param code the code in the name space
		 * @param severity the severity - one of {@link Diagnostic#INFO}, {@link Diagnostic#WARNING}
		 *            or {@link Diagnostic#ERROR}
		 * @param message the message for the diagnostics
		 * @param obj the object
		 * @param feature the feature possible <code>null</code>
		 */
		public static void addDiagnostic(DiagnosticChain diagnostics, String source, int code, int severity,
				String message, EObject obj, EStructuralFeature feature) {
			addDiagnostic(diagnostics, source, code, severity, message, new Object[][] { { obj, feature } });
		}

		/**
		 * Adds a new error diagnostic for the specified object and feature.
		 * 
		 * @param diagnostics the dianostics chain
		 * @param source the source name space
		 * @param code the code in the name space
		 * @param message the message for the diagnostics
		 * @param obj the object
		 * @param feature the feature possible <code>null</code>
		 */
		public static void addError(DiagnosticChain diagnostics, String source, int code, String message, EObject obj,
				EStructuralFeature feature) {
			addDiagnostic(diagnostics, source, code, Diagnostic.ERROR, message, obj, feature);
		}

		/**
		 * Adds a new warning diagnostic for the specified object and feature.
		 * 
		 * @param diagnostics the dianostics chain
		 * @param source the source name space
		 * @param code the code in the name space
		 * @param message the message for the diagnostics
		 * @param obj the object
		 * @param feature the feature possible <code>null</code>
		 */
		public static void addWarning(DiagnosticChain diagnostics, String source, int code, String message,
				EObject obj, EStructuralFeature feature) {
			addDiagnostic(diagnostics, source, code, Diagnostic.WARNING, message, obj, feature);
		}
	}

	/**
	 * The diagnostian used for the validation
	 */
	protected Diagnostician myDiagnostician = new Diagnostician();

	@Override
	public void validateObjectTree(EObject root, IObservableList messages) {
		final Diagnostic diagnostic = myDiagnostician.validate(root);
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
			toAddList.add(new Message(d));
		}

		messages.removeAll(toRemoveList);
		messages.addAll(toAddList);
	}

	private static class Message extends AbstractBindingMessage {

		private final Diagnostic myDiagnostic;

		public Message(Diagnostic diagnostic) {
			super(null);
			myDiagnostic = diagnostic;
			final List<?> data = diagnostic.getData();
			/*
			 * Special case: 1) two elements, 2) first is EObject, 3) second is EStructuralFeature
			 */
			if (data.size() == 2 && data.get(0) instanceof EObject
					&& (data.get(1) == null || data.get(1) instanceof EStructuralFeature)) {
				addTarget((EObject) data.get(0), (EStructuralFeature) data.get(1), null);
				return;
			}
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
}
