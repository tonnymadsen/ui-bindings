package com.rcpcompany.uibindings.utils;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IArgumentValue;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.participants.IDeleteParticipant;
import com.rcpcompany.uibindings.participants.IDeleteParticipantContext;

/**
 * Miscellaneous utilities for {@link IDeleteParticipant} and {@link IEditParticipant}
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class ParticipantUtils {
	/**
	 * Prevent construction...
	 */
	private ParticipantUtils() {
	}

	/**
	 * Checks whether the specified element can be delete according to any registered
	 * {@link IDeleteParticipant}.
	 * 
	 * @param element the element to test
	 * @return <code>true</code> if the element can be deleted, <code>false</code> otherwise
	 */
	public static boolean canDeleteAccordingToParticipants(final EObject element) {
		final IBindingDataType dataType = IBindingDataType.Factory.create(null, element.getClass());
		if (dataType == null) return true;
		final List<IArgumentValue<IDeleteParticipant>> participants = dataType.getArguments(
				Constants.ARG_DELETE_PARTICIPANT, null, IDeleteParticipant.class, false);

		IDeleteParticipantContext context = null;
		for (final IArgumentValue<IDeleteParticipant> dp : participants) {
			if (context == null) {
				context = new IDeleteParticipantContext() {
					@Override
					public EObject getElement() {
						return element;
					}
				};
			}
			if (!dp.getValue().canDelete(context)) return false;
		}
		return true;
	}

	/**
	 * Runs any registered {@link IDeleteParticipant} for pre ad post delete.
	 * 
	 * @param element the element to test
	 * @param pre <code>true</code> for pre and false for post
	 */
	public static void runPPDeleteParticipants(final EObject element, boolean pre) {
		final IBindingDataType dataType = IBindingDataType.Factory.create(null, element.getClass());
		if (dataType == null) return;
		final List<IArgumentValue<IDeleteParticipant>> participants = dataType.getArguments(
				Constants.ARG_DELETE_PARTICIPANT, null, IDeleteParticipant.class, false);

		IDeleteParticipantContext context = null;
		for (final IArgumentValue<IDeleteParticipant> dp : participants) {
			if (context == null) {
				context = new IDeleteParticipantContext() {
					@Override
					public EObject getElement() {
						return element;
					}
				};
			}
			if (pre) {
				dp.getValue().preDelete(context);
			} else {
				dp.getValue().postDelete(context);
			}
		}
	}

}
