package com.rcpcompany.uibindings;

/**
 * A piece of code to be run whenever a {@link IBindingContext} has been finalized.
 * <p>
 * Finalizers are added and removed via {@link IBindingContext#getFinalizers()}
 * <p>
 * Will be run multiple times if {@link IBindingContext#finish()} is called multiple times.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public interface IBindingContextFinalizer {
	/**
	 * Runs the finalizer.
	 * <p>
	 * Can uninstall itself via <code>context.getFinalizers().remove(this);</code>.
	 * 
	 * @param context
	 */
	void run(IBindingContext context);
}
