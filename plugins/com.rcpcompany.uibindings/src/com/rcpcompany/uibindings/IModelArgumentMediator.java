package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EClassifier;

/**
 * A Model Argument Mediator as declared in the uibindings/modelArgumentMediator element. Model Argument Mediators are
 * used to add additional arguments to model classes and features based on 3rd party information.
 * <p>
 * A specific mediator must add arguments to the Manager for a specific class (and all included features). Super-classes
 * are handled automatically based on the super-class hierarchy found in IBindingDataType.
 * <p>
 * A specific mediator wil only be invoked once for a specific class. *
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IModelArgumentMediator {
	/**
	 * Mediate (or translate) arguments for the specific model EClassifier to the provided {@link IModelClassInfo}.
	 * 
	 * @param classifier the source EClassifier
	 */
	public void mediateArguments(EClassifier classifier);
}
