package com.rcpcompany.uibindings.initializers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IInitializer;
import com.rcpcompany.uibindings.IInitializerContext;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Default object initializer for {@link EObject}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DefaultEObjectInitializer implements IInitializer {

	@Override
	public void initialize(IInitializerContext context, Object facet) {
		if (!(facet instanceof EClass)) return;
		final EClass cls = (EClass) facet;

		for (final EStructuralFeature sf : cls.getEAllStructuralFeatures()) {
			final IBindingDataType dt = IBindingDataType.Factory.create(context.getObject().eClass(), sf);

			final IInitializer initializer = dt.getArgument(Constants.ARG_INITIALIZER, null, IInitializer.class, null);
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
