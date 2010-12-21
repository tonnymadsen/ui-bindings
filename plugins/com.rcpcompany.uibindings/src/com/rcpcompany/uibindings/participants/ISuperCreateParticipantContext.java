package com.rcpcompany.uibindings.participants;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.utils.IClipboardConverterManager.IResult;

/**
 * Context for {@link ISuperCreateParticipant#createNeededRows(ISuperCreateParticipantContext)}.
 * <p>
 * Remember that new objects can be (partly) initialized using
 * {@link IManager#initializeObject(EObject, EReference, EObject)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ISuperCreateParticipantContext {
	/**
	 * The viewer that should have the new added rows.
	 * 
	 * @return the viewer
	 */
	IViewerBinding getViewer();

	/**
	 * Returns the parent object of the viewer, if known.
	 * 
	 * @return the parent object or <code>null</code>
	 */
	EObject getParent();

	/**
	 * Returns the list reference of the viewer, if known.
	 * 
	 * @return the list reference or <code>null</code>
	 */
	EReference getReference();

	/**
	 * The data to be copied from the clipboard.
	 * <p>
	 * The size of the data can be found as <code>getClipboardContent().getRows()</code>.
	 * 
	 * @return the clipboard data
	 */
	IResult getClipboardContent();

	/**
	 * The editing domain to be used for the creation of all the needed rows.
	 * <p>
	 * And whatever initialization that might be needed.
	 * 
	 * @return the editing domain
	 */
	EditingDomain getEditingDomain();
}
