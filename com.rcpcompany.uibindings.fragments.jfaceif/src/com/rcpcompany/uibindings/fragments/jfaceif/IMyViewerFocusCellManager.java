package com.rcpcompany.uibindings.fragments.jfaceif;

/**
 * Interface used to isolate the fragment additions from the base code in
 * ViewerBindingImpl.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IMyViewerFocusCellManager {

	void setFocusCell(Object element, int column);

	/**
	 * Updates the element part of the {@link ViewerCell}.
	 * <p>
	 * Part of our fix for SIMA-182.
	 */
	void updateFocusCell();
}
