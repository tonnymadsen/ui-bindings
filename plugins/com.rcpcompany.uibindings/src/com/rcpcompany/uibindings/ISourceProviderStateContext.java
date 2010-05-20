package com.rcpcompany.uibindings;

import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Event;

import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;

/**
 * State object used when updating the source provider state in {@link BindingSourceProvider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ISourceProviderStateContext {
	/**
	 * The current state.
	 * 
	 * @return a map with the current state
	 */
	public Map<String, Object> getState();

	/**
	 * Sets the specified source to the specified value.
	 * 
	 * @param name the name of the source - e.g. {@link Constants#SOURCES_ACTIVE_BINDING_FEATURE}
	 * @param value the new value
	 */
	public void setSourceValue(String name, Object value);

	/**
	 * The event that triggered the re-evaluatio of the state.
	 * <p>
	 * Can be <code>null</code>.
	 * 
	 * @return the event or <code>null</code>
	 */
	public Event getEvent();

	/**
	 * Adds a new {@link IObservableValue} which value must be observed. If the observed value changes value, then the
	 * state must be re-evaluated.
	 * 
	 * @param value the new observed value
	 */
	public void addObservedValue(IObservableValue value);
}
