package com.rcpcompany.uibindings.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.graphics.Color;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.utils.BindingHighlightContext;

/**
 * This interface is used to highlight a number of bindings for a small period of time.
 * <p>
 * The highlighht context can have many potential uses; e.g. to show the effect of an operation
 * where the effect might otherwise be difficult to spot - e.g. for a super paste operation. Or to
 * show which cells have a specific property in a table.
 * <p>
 * To use this interface you must
 * <ul>
 * <li>create a new context</li>
 * <li>add all the relevant details to the context</li>
 * <li>specify the wanted highlight operation - e.g. set background or font</li>
 * <li>specify stop criteria - a specific period, at next change, at ENTER...</li>
 * <li>activate the context</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IBindingHighlightContext extends IDisposable {
	/**
	 * Factory methods...
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Constructs and returns a new empty highlight context.
		 * 
		 * @return the new context
		 */
		public static IBindingHighlightContext createContext() {
			return new BindingHighlightContext();
		}
	}

	/**
	 * Activate the context.
	 */
	void activate();

	/**
	 * De-activate the context.
	 */
	void deactivate();

	/**
	 * The policy for deactivation.
	 */
	void setDeactivatePolicy(DEACTIVATION_POLICY policy);

	/**
	 * Sets a runnable for use with the deactivation policy {@link DEACTIVATION_POLICY#RUNNABLE}.
	 * 
	 * @param runnnable
	 */
	void setDeactivationRunnable(Runnable runnnable);

	/**
	 * Adds the detail to the affected set of bindings.
	 * 
	 * @param detail the detail description
	 */
	void add(IBindingSelector detail);

	/**
	 * Adds the specified binding to the affected set of bindings.
	 * 
	 * @param binding the binding
	 */
	void add(IValueBinding binding);

	/**
	 * Adds all bindings for the specified object and feature to the affected set of bindings.
	 * 
	 * @param obj the object
	 * @param feature the feature
	 */
	void add(EObject obj, EStructuralFeature feature);

	/**
	 * Sets the specified highlight effect.
	 * 
	 * @param effect the wanted effect
	 */
	void setEffect(IEffect effect);

	/**
	 * Sets the specified highlight effect as a specific background color.
	 * 
	 * @param background the wanted background color
	 */
	void setEffect(Color background);

	/**
	 * The default fade-out time.
	 */
	int DEFAULT_FADE_OUT_TIME = 1000;

	/**
	 * The default fade-in time.
	 */
	int DEFAULT_FADE_IN_TIME = 500;

	/**
	 * The default active time.
	 */
	int DEFAULT_ACTIVE_TIME = 2000;

	/**
	 * The length of each "tick" when fading in or out.
	 */
	int FADE_TICK = 50;

	/**
	 * Sets the time it should take to fade in in milli-seconds.
	 * <p>
	 * <code>0</code> means instant.
	 * <p>
	 * Defaults to DEFAULT_FADE_IN_TIME.
	 * 
	 * @param ms the number of milli-seconds
	 */
	void setFadeInTime(int ms);

	/**
	 * Sets the time the effect should be active in milli-seconds.
	 * <p>
	 * Only relevant for xxx
	 * 
	 * @param ms the number of milli-seconds
	 */
	void setDeactivationTime(int ms);

	/**
	 * Sets the time it should take to fade out in milli-seconds.
	 * <p>
	 * <code>0</code> means instant.
	 * 
	 * @param ms the number of milli-seconds
	 */
	void setFadeOutTime(int ms);

	/**
	 * Returns the current stage of this context.
	 * 
	 * @return the current stage
	 */
	STAGE getStage();

	/**
	 * Interface used to make a very specific highlight effect.
	 */
	public interface IEffect {
		/**
		 * Highlight the specified binding (<code>context.getBinding()</code>).
		 * 
		 * @param context the context for the highlight.
		 * @param fadeFactor the degree of fading - <code>0.0</code> means completely faded out and
		 *            <code>1.0</code> means completely faded in
		 */
		void doEffect(IUIBindingDecoratorExtenderContext context, double fadeFactor);
	}

	/**
	 * The description of a single binding selector used to saelect the bindings to be highlighted
	 * by this highlight context.
	 */
	public interface IBindingSelector {
		/**
		 * Returns whether the specified binding should be highlighted.
		 * 
		 * @param binding the binding in question
		 * @return <code>true</code> if the binding should be highlighted, <code>false</code>
		 *         otherwise
		 */
		boolean isAffected(IValueBinding binding);
	}

	/**
	 * The possible stages of a context.
	 */
	public enum STAGE {
		INIT, FADE_IN, ACTIVE, FADE_OUT, DISPOSED
	}

	/**
	 * The possible de-activation policies.
	 * <p>
	 * These specifies when the deactivation of an active context should start.
	 */
	public enum DEACTIVATION_POLICY {
		/**
		 * The context is deactivated manually by calling
		 * {@link IBindingHighlightContext#deactivate()}.
		 */
		MANUAL,

		/**
		 * The context is deactivated after the time out set by
		 * {@link IBindingHighlightContext#setDeactivationTime(int)}.
		 */
		TIMED,

		/**
		 * The context is deactivated at the first change.
		 */
		FIRST_CHANGE,

		/**
		 * The context is deactivated when the {@link Runnable} set with
		 * {@link IBindingHighlightContext#setDeactivationRunnable(Runnable)} returns.
		 */
		RUNNABLE,
	}
}
