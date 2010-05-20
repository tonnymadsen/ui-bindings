package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.rcpcompany.uibindings.internal.Activator;

/**
 * <!-- begin-user-doc --> The complete description of a single quick fix. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposal#getLabel <em>Label</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposal#getDescription <em>Description</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposal#getImage <em>Image</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposal#getRelevance <em>Relevance</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposal()
 * @generated
 */
public interface IQuickfixProposal extends EObject, IContentProposal {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The label is used to name this quickfix in the proposal lists. The label should be short - no more than 30
	 * characters.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposal_Label()
	 * @generated
	 */
	String getLabel();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The description is the extended description of the function of the quickfix and can include multiple lines.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposal_Description()
	 * @generated
	 */
	String getDescription();

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The image is shown with the label in quickfix lists. Also see {@link #ADD_IMAGE}, {@link #CHANGE_IMAGE} and
	 * {@link #REMOVE_IMAGE} for some default images.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposal_Image()
	 * @generated
	 */
	ImageDescriptor getImage();

	/**
	 * Returns the value of the '<em><b>Relevance</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The relevance is a number in the range [1; 100] is used to sort quickfixes when shown in lists. The more relevant
	 * a quickfix is, the higher the number.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Relevance</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposal_Relevance()
	 * @generated
	 */
	int getRelevance();

	/**
	 * Relevance used for proposals that are sure corrections for problems.
	 */
	public static final int SURE_PROPOSAL = 100;

	/**
	 * Relevance used for proposals that are very likely to be correct.
	 */
	public static final int LIKELY_PROPOSAL = 90;

	/**
	 * Relevance used for alternative proposals where there are other proposals that are more likely to be correct.
	 */
	public static final int ALTERNATIVE_PROPOSAL = 80;

	/**
	 * The default relevance used for proposals based on {@link ICompletionProposal}.
	 */
	public static final int DEFAULT_RELEVANCE = 50;

	/**
	 * The relevance used for template expansions.
	 */
	public static final int TEMPLATE = 50;

	/**
	 * Relevance used for proposals that are very unlikely to be correct.
	 */
	public static final int UNLIKELY_PROPOSAL = 0;

	/**
	 * Applies this proposal.
	 */
	public void apply();

	/**
	 * The image used when a proposal adds stuff.
	 */
	static final ImageDescriptor ADD_IMAGE = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID,
			"/images/quickfixes/add_correction.gif"); //$NON-NLS-1$

	/**
	 * The image used when a proposal changes stuff.
	 */
	static final ImageDescriptor CHANGE_IMAGE = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID,
			"/images/quickfixes/correction_change.gif"); //$NON-NLS-1$

	/**
	 * The image used when a proposal removes stuff.
	 */
	static final ImageDescriptor REMOVE_IMAGE = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID,
			"/images/quickfixes/remove_correction.gif"); //$NON-NLS-1$
} // IQuickfixProposal
