package com.rcpcompany.uibindings.observables;

/**
 * This interface is used to map the values in one list to the new values in a new parallel list.
 * 
 * @see EMFListAttributeList
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IObservableListMapper {
	/**
	 * Maps the specified value to a new value
	 * 
	 * @param value the original value
	 * @return the new value
	 */
	public Object map(Object value);
}
