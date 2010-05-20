package com.rcpcompany.uibindings.quixkfixes;

import com.rcpcompany.uibindings.internal.QuickfixProposalImpl;

/**
 * Abstract quick fix implementation
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public abstract class AbstractQuickfixProposal extends QuickfixProposalImpl {

	/**
	 * Constructs and returns a new proposal with the specified relevance.
	 * 
	 * @param title the title for the proposal
	 * @param type the basic type of the proposal
	 * @param rel the wanted relevance
	 */
	public AbstractQuickfixProposal(String title, Type type, int rel) {
		setLabel(title);
		switch (type) {
		case ADD:
			setImage(ADD_IMAGE);
			break;
		case CHANGE:
			setImage(CHANGE_IMAGE);
			break;
		case REMOVE:
			setImage(REMOVE_IMAGE);
			break;
		}
		setRelevance(rel);
	}

	/**
	 * The basic type of the proposal.
	 */
	public enum Type {
		/**
		 * The proposal basically adds to the information in the binding in question.
		 */
		ADD,
		/**
		 * The proposal basically rearranges the information already in the binding in question.
		 */
		CHANGE,
		/**
		 * The proposal basically removes from the information in the binding in question.
		 */
		REMOVE
	}

	@Override
	public abstract void apply();

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[" + hashCode() + "]: '" + getLabel() + "'";
	}
}
