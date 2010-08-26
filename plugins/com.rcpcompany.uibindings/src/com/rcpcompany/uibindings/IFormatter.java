package com.rcpcompany.uibindings;

/**
 * This interface is used to format a set of objects with a formatter.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IFormatter {
	/**
	 * Formats the the specified arguments according to the formatting specification of this
	 * formatter.
	 * 
	 * @param args the arguments
	 */
	void format(Object... args);
}
