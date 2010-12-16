package com.rcpcompany.uibindings.initializers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IInitializationParticipant;
import com.rcpcompany.uibindings.IInitializationParticipantContext;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Default object initializer for {@link EObject}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DefaultEObjectInitializer implements IInitializationParticipant {

	@Override
	public void initialize(IInitializationParticipantContext context, Object facet) {
		if (!(facet instanceof EClass)) return;
		final EClass cls = (EClass) facet;

		for (final EStructuralFeature sf : cls.getEAllStructuralFeatures()) {
			final IBindingDataType dt = IBindingDataType.Factory.create(context.getObject().eClass(), sf);

			final IInitializationParticipant initializer = dt.getArgument(Constants.ARG_INITIALIZER, null,
					IInitializationParticipant.class, null);
			if (initializer != null) {
				try {
					initializer.initialize(context, sf);
				} catch (final Exception ex) {
					LogUtils.error(initializer, ex);
				}
			}
		}
	}
}
