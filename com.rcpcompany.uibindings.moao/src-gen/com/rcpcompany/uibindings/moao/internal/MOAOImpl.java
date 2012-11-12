/**
 */
package com.rcpcompany.uibindings.moao.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.google.common.base.Objects;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.IMOAOPackage.Literals;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>MOAO</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.internal.MOAOImpl#getFacets <em>Facets</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MOAOImpl extends MinimalEObjectImpl.Container implements IMOAO {
	/**
	 * The cached value of the '{@link #getFacets() <em>Facets</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFacets()
	 * @generated
	 * @ordered
	 */
	protected EList<IMOAOFacet> facets;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MOAOImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IMOAOPackage.Literals.MOAO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IMOAOFacet> getFacets() {
		if (facets == null) {
			facets = new EObjectContainmentWithInverseEList<IMOAOFacet>(IMOAOFacet.class, this,
					IMOAOPackage.MOAO__FACETS, IMOAOPackage.MOAO_FACET__OBJECT);
		}
		return facets;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isValid(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void removeMessagesByOwner(final String owner) {
		final IMOAO _this = this;
		final TreeIterator<EObject> allContents = _this.eAllContents();
		final boolean _hasNext = allContents.hasNext();
		boolean _while = _hasNext;
		while (_while) {
			{
				final EObject next = allContents.next();
				boolean _matched = false;
				if (!_matched) {
					if (next instanceof IMOAO) {
						final IMOAO _iMOAO = (IMOAO) next;
						_matched = true;
						_iMOAO.removeMessagesByOwner(null, owner);
					}
				}
			}
			final boolean _hasNext_1 = allContents.hasNext();
			_while = _hasNext_1;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void removeMessagesByOwner(final EStructuralFeature feature, final String owner) {
		final IMOAO _this = this;
		final boolean _eIsSet = _this.eIsSet(Literals.MOAO__FACETS);
		final boolean _not = (!_eIsSet);
		if (_not) return;
		final IMOAO _this_1 = this;
		final EList<IMOAOFacet> _facets = _this_1.getFacets();
		final Iterator<IMOAOFacet> iterator = _facets.iterator();
		final boolean _hasNext = iterator.hasNext();
		boolean _while = _hasNext;
		while (_while) {
			{
				final IMOAOFacet next = iterator.next();
				boolean _matched = false;
				if (!_matched) {
					if (next instanceof IMOAOMessage) {
						final IMOAOMessage _iMOAOMessage = (IMOAOMessage) next;
						_matched = true;
						final IMOAOMessage m = (_iMOAOMessage);
						boolean _and = false;
						boolean _and_1 = false;
						final boolean _notEquals = (!Objects.equal(feature, null));
						if (!_notEquals) {
							_and_1 = false;
						} else {
							final EStructuralFeature _feature = m.getFeature();
							final boolean _equals = Objects.equal(feature, _feature);
							_and_1 = (_notEquals && _equals);
						}
						if (!_and_1) {
							_and = false;
						} else {
							final String _owner = m.getOwner();
							final boolean _equals_1 = Objects.equal(owner, _owner);
							_and = (_and_1 && _equals_1);
						}
						if (_and) {
							iterator.remove();
						}
					}
				}
			}
			final boolean _hasNext_1 = iterator.hasNext();
			_while = _hasNext_1;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IMOAOPackage.MOAO__FACETS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getFacets()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IMOAOPackage.MOAO__FACETS:
			return ((InternalEList<?>) getFacets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IMOAOPackage.MOAO__FACETS:
			return getFacets();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IMOAOPackage.MOAO__FACETS:
			getFacets().clear();
			getFacets().addAll((Collection<? extends IMOAOFacet>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case IMOAOPackage.MOAO__FACETS:
			getFacets().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case IMOAOPackage.MOAO__FACETS:
			return facets != null && !facets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case IMOAOPackage.MOAO___IS_VALID__DIAGNOSTICCHAIN_MAP:
			return isValid((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
		case IMOAOPackage.MOAO___REMOVE_MESSAGES_BY_OWNER__STRING:
			removeMessagesByOwner((String) arguments.get(0));
			return null;
		case IMOAOPackage.MOAO___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING:
			removeMessagesByOwner((EStructuralFeature) arguments.get(0), (String) arguments.get(1));
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}
} // MOAOImpl
