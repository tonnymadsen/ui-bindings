package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.rcpcompany.uibindings.IChildCreationSpecification;

/**
 * Generic {@link IChildCreationSpecification}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ChildCreationSpecification implements IChildCreationSpecification {
	private final EObject myParent;
	private final EReference myReference;
	private final EClass myChildType;

	/**
	 * Creates and returns a new specification.
	 * 
	 * @param parent the parent of the specification
	 * @param reference the reference of the specification
	 * @param childType the child type of the specification
	 */
	public ChildCreationSpecification(EObject parent, EReference reference, EClass childType) {
		myParent = parent;
		myReference = reference;
		myChildType = childType;
	}

	@Override
	public EObject getParent() {
		return myParent;
	}

	@Override
	public EReference getReference() {
		return myReference;
	}

	@Override
	public EClass getChildType() {
		return myChildType;
	}

	@Override
	public String getId() {
		return System.identityHashCode(getParent()) + ":" + getReference().getName() + ":" + getChildType().getName();
	}
}
