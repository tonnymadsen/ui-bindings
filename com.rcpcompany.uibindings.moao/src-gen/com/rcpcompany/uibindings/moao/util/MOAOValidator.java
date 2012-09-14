/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.moao.util;

import com.rcpcompany.uibindings.moao.*;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;

import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.INamedObject;
import com.rcpcompany.uibindings.moao.Severity;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage
 * @generated
 */
public class MOAOValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final MOAOValidator INSTANCE = new MOAOValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.rcpcompany.uibindings.moao";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Valid' of 'MOAO'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MOAO__IS_VALID = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MOAOValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return IMOAOPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case IMOAOPackage.IADAPTABLE:
			return validateIAdaptable((IAdaptable) value, diagnostics, context);
		case IMOAOPackage.ESTRUCTURAL_FEATURE:
			return validateEStructuralFeature((EStructuralFeature) value, diagnostics, context);
		case IMOAOPackage.MOAO:
			return validateMOAO((IMOAO) value, diagnostics, context);
		case IMOAOPackage.MOAO_FACET:
			return validateMOAOFacet((IMOAOFacet) value, diagnostics, context);
		case IMOAOPackage.NAMED_OBJECT:
			return validateNamedObject((INamedObject) value, diagnostics, context);
		case IMOAOPackage.MOAO_MESSAGE:
			return validateMOAOMessage((IMOAOMessage) value, diagnostics, context);
		case IMOAOPackage.SEVERITY:
			return validateSeverity((Severity) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMOAO(IMOAO moao, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(moao, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(moao, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(moao, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(moao, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(moao, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(moao, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(moao, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(moao, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(moao, diagnostics, context);
		if (result || diagnostics != null) result &= validateMOAO_isValid(moao, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isValid constraint of '<em>MOAO</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public boolean validateMOAO_isValid(IMOAO moao, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return moao.isValid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMOAOFacet(IMOAOFacet moaoFacet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(moaoFacet, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(moaoFacet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(moaoFacet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(moaoFacet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(moaoFacet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(moaoFacet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(moaoFacet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(moaoFacet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(moaoFacet, diagnostics, context);
		if (result || diagnostics != null) result &= validateMOAO_isValid(moaoFacet, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedObject(INamedObject namedObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedObject, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(namedObject, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(namedObject, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(namedObject, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedObject, diagnostics, context);
		if (result || diagnostics != null) result &= validateMOAO_isValid(namedObject, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMOAOMessage(IMOAOMessage moaoMessage, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(moaoMessage, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(moaoMessage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(moaoMessage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(moaoMessage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(moaoMessage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(moaoMessage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(moaoMessage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(moaoMessage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(moaoMessage, diagnostics, context);
		if (result || diagnostics != null) result &= validateMOAO_isValid(moaoMessage, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSeverity(Severity severity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIAdaptable(IAdaptable iAdaptable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) iAdaptable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStructuralFeature(EStructuralFeature eStructuralFeature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) eStructuralFeature, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // MOAOValidator
