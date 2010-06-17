/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IArgumentProvider;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IEMFObservableFactory;
import com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IModelArgumentMediator;
import com.rcpcompany.uibindings.IModelClassInfo;
import com.rcpcompany.uibindings.IModelFeatureInfo;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IQuickfixProposalProcessor;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor;
import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.ITreeItemRelation;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingPreferences;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.internal.observableFactories.DefaultEMFObservableFactory;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Manager</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getEditingDomain <em>Editing Domain
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getFormToolkit <em>Form Toolkit</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getProviders <em>Providers</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getUiAttributeFactories <em>Ui
 * Attribute Factories</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getDecoratorExtenders <em>Decorator
 * Extenders</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getModelArgumentMediators <em>Model
 * Argument Mediators </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getModelArgumentMediatorClasses <em>
 * Model Argument Mediator Classes</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getTextCommitStrategy <em>Text Commit
 * Strategy</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getTextCommitStrategyDelay <em>Text
 * Commit Strategy Delay </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isEditCellAnyKey <em>Edit Cell Any Key
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isEditCellSingleClick <em>Edit Cell
 * Single Click</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getMessageDecorationPosition <em>
 * Message Decoration Position</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getMessageDecorationMinimumSeverity
 * <em>Message Decoration Minimum Severity</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getAlternativeDecorationPosition <em>
 * Alternative Decoration Position</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isAutoApplySingleQuickfix <em>Auto
 * Apply Single Quickfix </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isAlternateRowColors <em>Alternate Row
 * Colors</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isValidationErrorsAreFatal <em>
 * Validation Errors Are Fatal </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getValidationDelay <em>Validation Delay
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getValidationDelayWindow <em>Validation
 * Delay Window</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isRequiredVBImageDecorationShown <em>
 * Required VB Image Decoration Shown</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isAssistVBImageDecorationShown <em>
 * Assist VB Image Decoration Shown</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isQuickfixVBImageDecorationShown <em>
 * Quickfix VB Image Decoration Shown</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#isViewNavigationRecorded <em>View
 * Navigation Recorded</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getModelInfo <em>Model Info</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getTreeItems <em>Tree Items</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getClipboard <em>Clipboard</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getObservableFactories <em>Observable
 * Factories</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getQuickfixProposalProcessors <em>
 * Quickfix Proposal Processors</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ManagerImpl#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ManagerImpl extends BaseObjectImpl implements IManager {
	/**
	 * The key information for a binding provider in {@link Manager#myBindingCache}.
	 */
	private static class BindingProviderKey {
		/**
		 * Constructs and returns a new key object.
		 * 
		 * @param modelType the wanted model type
		 * @param uiType the wanted UI type
		 * @param type the wanted type (optional)
		 */
		public BindingProviderKey(Class<?> modelType, Class<?> uiType, String type) {
			this.modelType = modelType;
			this.uiType = uiType;
			this.type = type;
		}

		public Class<?> modelType;
		public Class<?> uiType;
		public String type;

		@Override
		public String toString() {
			return "getkey(" + modelType + ", " + uiType + ", " + type + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((modelType == null) ? 0 : modelType.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			result = prime * result + ((uiType == null) ? 0 : uiType.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			final BindingProviderKey other = (BindingProviderKey) obj;
			if (modelType == null) {
				if (other.modelType != null) return false;
			} else if (!modelType.equals(other.modelType)) return false;
			if (type == null) {
				if (other.type != null) return false;
			} else if (!type.equals(other.type)) return false;
			if (uiType == null) {
				if (other.uiType != null) return false;
			} else if (!uiType.equals(other.uiType)) return false;
			return true;
		}
	}

	@Override
	public IDecoratorProvider getProvider(Class<?> modelType, Class<?> uiType, String type) {
		if (type == null) {
			type = ""; //$NON-NLS-1$
		}
		if (Activator.getDefault().TRACE_DECORATORS) {
			LogUtils.debug(this, "getProvider(" + modelType + ", " + uiType + ", " + type + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}
		final BindingProviderKey key = new BindingProviderKey(modelType, uiType, type);
		IDecoratorProvider provider = myBindingCache.get(key);
		if (provider != null) return provider;

		/*
		 * Need to find a provider :-)
		 */
		final Class<?>[] modelTypeOrder = Platform.getAdapterManager().computeClassOrder(modelType);
		final Class<?>[] uiTypeOrder = Platform.getAdapterManager().computeClassOrder(uiType);

		final List<IDecoratorProvider> ps = new ArrayList<IDecoratorProvider>();
		int psPriority = 1000000;
		for (final IDecoratorProvider p : getProviders()) {
			if (!type.equals(p.getType())) {
				continue;
			}
			boolean found = false;
			int priority = 0;
			int prio = 0;
			if (p.getModelTypes().isEmpty()) {
				found = true;
			}
			for (final String t : p.getModelTypes()) {
				prio = 0;
				/*
				 * If exact model type matching is wanted when just test again the model type
				 * itself.
				 * 
				 * Otherwise test against model type order as found above.
				 */
				if (p.isExactModelTypeMatch()) {
					if (modelType.getName().equals(t)) {
						found = true;
					}
				} else {
					for (final Class<?> c : modelTypeOrder) {
						if (c.getName().equals(t)) {
							found = true;
							break;
						}
						prio++;
					}
				}
				if (found) {
					break;
				}
			}
			if (!found) {
				continue;
			}
			priority += prio;
			found = false;
			for (final String t : p.getUiTypes()) {
				prio = 0;
				for (final Class<?> c : uiTypeOrder) {
					if (c.getName().equals(t)) {
						found = true;
						break;
					}
				}
				if (found) {
					break;
				}
			}
			if (!found) {
				continue;
			}
			priority += prio;

			if (priority > psPriority) {
				continue;
			}
			if (priority < psPriority) {
				ps.clear();
				psPriority = priority;
			}

			ps.add(p);
		}

		/*
		 * Three cases: no match, one match, many matches
		 */
		switch (ps.size()) {
		case 0:
			if (Activator.getDefault().TRACE_DECORATORS) {
				LogUtils.error(this, "getProvider -- > null"); //$NON-NLS-1$
			}
			return null;
		default:
			/*
			 * Find the right match
			 */
			// TODO: Find the right match
			LogUtils.error(this, "TODO: find the right match, got priority " + psPriority + " (" //$NON-NLS-1$ //$NON-NLS-2$
					+ modelType.getSimpleName() + ", " + uiType.getSimpleName() + ", " + type + "): " + ps.size() //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ " matches:\n" + ps); //$NON-NLS-1$
			//$FALL-THROUGH$ fallthrough
		case 1:
			provider = ps.get(0);
			break;
		}
		myBindingCache.put(key, provider);

		if (Activator.getDefault().TRACE_DECORATORS) {
			LogUtils.debug(this, "getProvider -- > " + provider.getId()); //$NON-NLS-1$
		}
		return provider;
	}

	private IEMFObservableFactory theDefaultObservableFactory = null;

	/**
	 * A repository of all defined UI attribute factories.
	 */
	protected final Map<BindingProviderKey, IDecoratorProvider> myBindingCache = new HashMap<BindingProviderKey, IDecoratorProvider>();

	/**
	 * The default value of the '{@link #getEditingDomain() <em>Editing Domain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEditingDomain()
	 * @generated
	 * @ordered
	 */
	protected static final EditingDomain EDITING_DOMAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditingDomain() <em>Editing Domain</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEditingDomain()
	 * @generated
	 * @ordered
	 */
	protected EditingDomain editingDomain = EDITING_DOMAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormToolkit() <em>Form Toolkit</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormToolkit()
	 * @generated
	 * @ordered
	 */
	protected static final FormToolkit FORM_TOOLKIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormToolkit() <em>Form Toolkit</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormToolkit()
	 * @generated
	 * @ordered
	 */
	protected FormToolkit formToolkit = FORM_TOOLKIT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProviders() <em>Providers</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<IDecoratorProvider> providers;

	/**
	 * The cached value of the '{@link #getUiAttributeFactories() <em>Ui Attribute Factories</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUiAttributeFactories()
	 * @generated
	 * @ordered
	 */
	protected EList<IUIAttributeFactoryDescriptor> uiAttributeFactories;

	/**
	 * The cached value of the '{@link #getDecoratorExtenders() <em>Decorator Extenders</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDecoratorExtenders()
	 * @generated
	 * @ordered
	 */
	protected EList<IUIBindingDecoratorExtenderDescriptor> decoratorExtenders;

	/**
	 * The cached value of the '{@link #getModelArgumentMediators()
	 * <em>Model Argument Mediators</em>}' attribute list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getModelArgumentMediators()
	 * @generated
	 * @ordered
	 */
	protected EList<CEObjectHolder<IModelArgumentMediator>> modelArgumentMediators;

	/**
	 * The cached value of the '{@link #getModelArgumentMediatorClasses()
	 * <em>Model Argument Mediator Classes</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getModelArgumentMediatorClasses()
	 * @generated NOT
	 * @ordered
	 */
	protected Map<EClassifier, Object> modelArgumentMediatorClasses = new HashMap<EClassifier, Object>();

	/**
	 * The default value of the '{@link #getTextCommitStrategy() <em>Text Commit Strategy</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTextCommitStrategy()
	 * @generated
	 * @ordered
	 */
	protected static final TextCommitStrategy TEXT_COMMIT_STRATEGY_EDEFAULT = TextCommitStrategy.ON_MODIFY_DELAY;

	/**
	 * The cached value of the '{@link #getTextCommitStrategy() <em>Text Commit Strategy</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTextCommitStrategy()
	 * @generated
	 * @ordered
	 */
	protected TextCommitStrategy textCommitStrategy = TEXT_COMMIT_STRATEGY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextCommitStrategyDelay()
	 * <em>Text Commit Strategy Delay</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getTextCommitStrategyDelay()
	 * @generated
	 * @ordered
	 */
	protected static final int TEXT_COMMIT_STRATEGY_DELAY_EDEFAULT = 400;

	/**
	 * The cached value of the '{@link #getTextCommitStrategyDelay()
	 * <em>Text Commit Strategy Delay</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getTextCommitStrategyDelay()
	 * @generated
	 * @ordered
	 */
	protected int textCommitStrategyDelay = TEXT_COMMIT_STRATEGY_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #isEditCellAnyKey() <em>Edit Cell Any Key</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEditCellAnyKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EDIT_CELL_ANY_KEY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEditCellAnyKey() <em>Edit Cell Any Key</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEditCellAnyKey()
	 * @generated
	 * @ordered
	 */
	protected boolean editCellAnyKey = EDIT_CELL_ANY_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #isEditCellSingleClick() <em>Edit Cell Single Click</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEditCellSingleClick()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EDIT_CELL_SINGLE_CLICK_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEditCellSingleClick() <em>Edit Cell Single Click</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEditCellSingleClick()
	 * @generated
	 * @ordered
	 */
	protected boolean editCellSingleClick = EDIT_CELL_SINGLE_CLICK_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageDecorationPosition()
	 * <em>Message Decoration Position</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getMessageDecorationPosition()
	 * @generated
	 * @ordered
	 */
	protected static final DecorationPosition MESSAGE_DECORATION_POSITION_EDEFAULT = DecorationPosition.BOTTOM_LEFT;

	/**
	 * The cached value of the '{@link #getMessageDecorationPosition()
	 * <em>Message Decoration Position</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getMessageDecorationPosition()
	 * @generated
	 * @ordered
	 */
	protected DecorationPosition messageDecorationPosition = MESSAGE_DECORATION_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageDecorationMinimumSeverity()
	 * <em>Message Decoration Minimum Severity</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getMessageDecorationMinimumSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final BindingMessageSeverity MESSAGE_DECORATION_MINIMUM_SEVERITY_EDEFAULT = BindingMessageSeverity.WARNING;

	/**
	 * The cached value of the '{@link #getMessageDecorationMinimumSeverity()
	 * <em>Message Decoration Minimum Severity</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getMessageDecorationMinimumSeverity()
	 * @generated
	 * @ordered
	 */
	protected BindingMessageSeverity messageDecorationMinimumSeverity = MESSAGE_DECORATION_MINIMUM_SEVERITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlternativeDecorationPosition()
	 * <em>Alternative Decoration Position</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getAlternativeDecorationPosition()
	 * @generated
	 * @ordered
	 */
	protected static final DecorationPosition ALTERNATIVE_DECORATION_POSITION_EDEFAULT = DecorationPosition.TOP_LEFT;

	/**
	 * The cached value of the '{@link #getAlternativeDecorationPosition()
	 * <em>Alternative Decoration Position</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getAlternativeDecorationPosition()
	 * @generated
	 * @ordered
	 */
	protected DecorationPosition alternativeDecorationPosition = ALTERNATIVE_DECORATION_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #isAutoApplySingleQuickfix()
	 * <em>Auto Apply Single Quickfix</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isAutoApplySingleQuickfix()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_APPLY_SINGLE_QUICKFIX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoApplySingleQuickfix()
	 * <em>Auto Apply Single Quickfix</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isAutoApplySingleQuickfix()
	 * @generated
	 * @ordered
	 */
	protected boolean autoApplySingleQuickfix = AUTO_APPLY_SINGLE_QUICKFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #isAlternateRowColors() <em>Alternate Row Colors</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAlternateRowColors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALTERNATE_ROW_COLORS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAlternateRowColors() <em>Alternate Row Colors</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAlternateRowColors()
	 * @generated
	 * @ordered
	 */
	protected boolean alternateRowColors = ALTERNATE_ROW_COLORS_EDEFAULT;

	/**
	 * The default value of the '{@link #isValidationErrorsAreFatal()
	 * <em>Validation Errors Are Fatal</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isValidationErrorsAreFatal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALIDATION_ERRORS_ARE_FATAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValidationErrorsAreFatal()
	 * <em>Validation Errors Are Fatal</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isValidationErrorsAreFatal()
	 * @generated
	 * @ordered
	 */
	protected boolean validationErrorsAreFatal = VALIDATION_ERRORS_ARE_FATAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidationDelay() <em>Validation Delay</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValidationDelay()
	 * @generated
	 * @ordered
	 */
	protected static final int VALIDATION_DELAY_EDEFAULT = 200;

	/**
	 * The cached value of the '{@link #getValidationDelay() <em>Validation Delay</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValidationDelay()
	 * @generated
	 * @ordered
	 */
	protected int validationDelay = VALIDATION_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidationDelayWindow()
	 * <em>Validation Delay Window</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValidationDelayWindow()
	 * @generated
	 * @ordered
	 */
	protected static final int VALIDATION_DELAY_WINDOW_EDEFAULT = 25;

	/**
	 * The cached value of the '{@link #getValidationDelayWindow() <em>Validation Delay Window</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValidationDelayWindow()
	 * @generated
	 * @ordered
	 */
	protected int validationDelayWindow = VALIDATION_DELAY_WINDOW_EDEFAULT;

	/**
	 * The default value of the '{@link #isRequiredVBImageDecorationShown()
	 * <em>Required VB Image Decoration Shown</em>} ' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isRequiredVBImageDecorationShown()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_VB_IMAGE_DECORATION_SHOWN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRequiredVBImageDecorationShown()
	 * <em>Required VB Image Decoration Shown</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isRequiredVBImageDecorationShown()
	 * @generated
	 * @ordered
	 */
	protected boolean requiredVBImageDecorationShown = REQUIRED_VB_IMAGE_DECORATION_SHOWN_EDEFAULT;

	/**
	 * The default value of the '{@link #isAssistVBImageDecorationShown()
	 * <em>Assist VB Image Decoration Shown</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isAssistVBImageDecorationShown()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ASSIST_VB_IMAGE_DECORATION_SHOWN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAssistVBImageDecorationShown()
	 * <em>Assist VB Image Decoration Shown</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isAssistVBImageDecorationShown()
	 * @generated
	 * @ordered
	 */
	protected boolean assistVBImageDecorationShown = ASSIST_VB_IMAGE_DECORATION_SHOWN_EDEFAULT;

	/**
	 * The default value of the '{@link #isQuickfixVBImageDecorationShown()
	 * <em>Quickfix VB Image Decoration Shown</em>} ' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isQuickfixVBImageDecorationShown()
	 * @generated
	 * @ordered
	 */
	protected static final boolean QUICKFIX_VB_IMAGE_DECORATION_SHOWN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isQuickfixVBImageDecorationShown()
	 * <em>Quickfix VB Image Decoration Shown</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isQuickfixVBImageDecorationShown()
	 * @generated
	 * @ordered
	 */
	protected boolean quickfixVBImageDecorationShown = QUICKFIX_VB_IMAGE_DECORATION_SHOWN_EDEFAULT;

	/**
	 * The default value of the '{@link #isViewNavigationRecorded()
	 * <em>View Navigation Recorded</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isViewNavigationRecorded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VIEW_NAVIGATION_RECORDED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isViewNavigationRecorded()
	 * <em>View Navigation Recorded</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isViewNavigationRecorded()
	 * @generated
	 * @ordered
	 */
	protected boolean viewNavigationRecorded = VIEW_NAVIGATION_RECORDED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelInfo() <em>Model Info</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelInfo()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, IModelClassInfo> modelInfo;

	/**
	 * The cached value of the '{@link #getTreeItems() <em>Tree Items</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTreeItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ITreeItemDescriptor> treeItems;

	/**
	 * The default value of the '{@link #getClipboard() <em>Clipboard</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClipboard()
	 * @generated
	 * @ordered
	 */
	protected static final Clipboard CLIPBOARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClipboard() <em>Clipboard</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClipboard()
	 * @generated
	 * @ordered
	 */
	protected Clipboard clipboard = CLIPBOARD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getObservableFactories() <em>Observable Factories</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getObservableFactories()
	 * @generated
	 * @ordered
	 */
	protected EList<IEMFObservableFactoryDescriptor> observableFactories;

	/**
	 * The cached value of the '{@link #getQuickfixProposalProcessors()
	 * <em>Quickfix Proposal Processors</em>}' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getQuickfixProposalProcessors()
	 * @generated
	 * @ordered
	 */
	protected EList<IQuickfixProposalProcessorDescriptor> quickfixProposalProcessors;

	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<IBindingContext> contexts;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ManagerImpl() {
		super();

		extensionReader();
	}

	/**
	 * Reads all relevant information from the registry...
	 */
	private void extensionReader() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();

		final List<IConfigurationElement> relations = new ArrayList<IConfigurationElement>();
		for (final IConfigurationElement ce : registry
				.getConfigurationElementsFor(InternalConstants.UIBINDINGS_EXTENSION_POINT)) {
			final String elementName = ce.getName();
			if (InternalConstants.BINDING_DECORATOR_TAG.equals(elementName)) {
				String id = ce.getAttribute(InternalConstants.ID_TAG);
				if (id == null || id.length() == 0) {
					id = "<unspecified>"; //$NON-NLS-1$
				}

				final IConfigurationElement[] javaProviders = ce.getChildren(InternalConstants.JAVA_DECORATOR_TAG);
				final IConfigurationElement[] enumProviders = ce.getChildren(InternalConstants.ENUM_TAG);
				final IConfigurationElement[] numberProviders = ce.getChildren(InternalConstants.NUMBER_TAG);

				switch (javaProviders.length + enumProviders.length + numberProviders.length) {
				case 0:
					LogUtils.error(ce, id + ": Exactly one type decorator required. Provider ignored. Got none."); //$NON-NLS-1$
					continue;
				case 1:
					break;
				default:
					LogUtils.error(ce, id + ": Exactly one type decorator required. Provider ignored. Got " //$NON-NLS-1$
							+ Arrays.toString(javaProviders) + " and " + Arrays.toString(enumProviders)); //$NON-NLS-1$
					break;
				}
				if (javaProviders.length + enumProviders.length > 1) {
					LogUtils.error(ce, id + ": Exactly one type decorator required. Provider ignored. Got " //$NON-NLS-1$
							+ Arrays.toString(javaProviders) + " and " + Arrays.toString(enumProviders)); //$NON-NLS-1$
					continue;
				}
				IDecoratorProvider provider = null;
				if (javaProviders.length == 1) {
					provider = IUIBindingsFactory.eINSTANCE.createJavaDecoratorProvider();
					provider.providerReader(id, ce, javaProviders[0]);
				}
				if (enumProviders.length == 1) {
					provider = IUIBindingsFactory.eINSTANCE.createEnumDecoratorProvider();
					provider.providerReader(id, ce, enumProviders[0]);
				}
				if (numberProviders.length == 1) {
					provider = IUIBindingsFactory.eINSTANCE.createNumberDecoratorProvider();
					provider.providerReader(id, ce, numberProviders[0]);
				}
				readArguments(provider, ce);

				getProviders().add(provider);
			} else if (InternalConstants.UI_ATTRIBUTE_FACTORY_TAG.equals(elementName)) {
				// TODO: check for dups
				final IUIAttributeFactoryDescriptor descriptor = IUIBindingsFactory.eINSTANCE
						.createUIAttributeFactoryDescriptor();
				descriptor.setTypeName(ce.getAttribute(InternalConstants.WIDGET_TYPE_TAG));
				String attribute = ce.getAttribute(InternalConstants.ATTRIBUTE_TAG);
				if (attribute == null) {
					attribute = ""; //$NON-NLS-1$
				}
				descriptor.setAttribute(attribute);
				descriptor.setFactory(new CEObjectHolder<IUIAttributeFactory>(ce));

				getUiAttributeFactories().add(descriptor);
			} else if (InternalConstants.DECORATOR_EXTENDER_TAG.equals(elementName)) {
				// TODO: check for dups
				final IUIBindingDecoratorExtenderDescriptor descriptor = IUIBindingsFactory.eINSTANCE
						.createUIBindingDecoratorExtenderDescriptor();
				descriptor.setFactory(new CEObjectHolder<IUIBindingDecoratorExtender>(ce));

				getDecoratorExtenders().add(descriptor);
				readArguments(descriptor, ce);
			} else if (InternalConstants.MODEL_ARGUMENT_MEDIATOR_TAG.equals(elementName)) {
				// TODO: check for dups
				final CEObjectHolder<IModelArgumentMediator> mediator = new CEObjectHolder<IModelArgumentMediator>(ce);
				getModelArgumentMediators().add(mediator);
			} else if (InternalConstants.QUICKFIX_PROCESSOR_TAG.equals(elementName)) {
				final IQuickfixProposalProcessorDescriptor qi = IUIBindingsFactory.eINSTANCE
						.createQuickfixProposalProcessorDescriptor();

				final String code = ce.getAttribute(InternalConstants.CODE_TAG);
				if (code != null && code.length() > 0) {
					try {
						qi.setCode(Integer.parseInt(code));
					} catch (final NumberFormatException ex) {
						LogUtils.error(ce, ex);
						continue;
					}
				} else {
					qi.setCode(Integer.MIN_VALUE);
				}
				final String pattern = ce.getAttribute(InternalConstants.MESSAGE_PATTERN_TAG);
				if (pattern != null && pattern.length() > 0) {
					try {
						qi.setMessagePattern(Pattern.compile(pattern));
					} catch (final PatternSyntaxException ex) {
						LogUtils.error(ce, ex);
						continue;
					}
				}
				qi.setSource(ce.getAttribute(InternalConstants.SOURCE_TAG));
				qi.setFeature(ce.getAttribute(InternalConstants.FEATURE_TAG));
				qi.setModelType(ce.getAttribute(InternalConstants.MODEL_TYPE_TAG));
				qi.setProcessor(new CEObjectHolder<IQuickfixProposalProcessor>(ce, InternalConstants.PROCESSOR_TAG));
				getQuickfixProposalProcessors().add(qi);
			} else if (InternalConstants.OBSERVABLES_FACTORY_TAG.equals(elementName)) {
				final IEMFObservableFactoryDescriptor desc = IUIBindingsFactory.eINSTANCE
						.createEMFObservableFactoryDescriptor();
				desc.setPackagePrefix(ce.getAttribute(InternalConstants.PACKAGE_TAG));
				desc.setFactory(new CEObjectHolder<IEMFObservableFactory>(ce));
				getObservableFactories().add(desc);
			} else if (InternalConstants.MODEL_TAG.equals(elementName)) {
				final String className = ce.getAttribute(InternalConstants.CLASS_TAG);
				if (className == null || className.length() == 0) {
					LogUtils.error(ce, "Class name must be specified. Ignored"); //$NON-NLS-1$
					continue;
				}

				final String type = ce.getAttribute(InternalConstants.TARGET_TYPE_TAG);

				final IModelClassInfo cInfo = getModelClassInfo(className, type, true);
				readArguments(cInfo, ce);

				for (final IConfigurationElement childCE : ce.getChildren(InternalConstants.FEATURE_TAG)) {
					final String featureName = childCE.getAttribute(InternalConstants.NAME_TAG);
					if (featureName == null || featureName.length() == 0) {
						LogUtils.error(childCE, "Feature name must be specified. Ignored"); //$NON-NLS-1$
						continue;
					}

					final IModelFeatureInfo fInfo = getModelFeatureInfo(className, featureName, type, true);
					readArguments(fInfo, childCE);
				}
			} else if (InternalConstants.TREE_ITEM_TAG.equals(elementName)) {
				final String id = ce.getAttribute(InternalConstants.ID_TAG);
				if (id == null || id.length() == 0) {
					LogUtils.error(ce, InternalConstants.ID_TAG + " must be specified. Ignored"); //$NON-NLS-1$
					continue;
				}
				final ITreeItemDescriptor descriptor = IUIBindingsFactory.eINSTANCE.createTreeItemDescriptor();
				descriptor.setId(id);

				final EList<String> modelTypes = descriptor.getModelTypes();
				for (final IConfigurationElement child : ce.getChildren(InternalConstants.MODEL_TYPE_TAG)) {
					String attr = child.getAttribute(InternalConstants.ALSO_PRIMITIVE_TAG);
					final boolean alsoPrimitive = attr == null || Boolean.valueOf(attr).booleanValue();
					attr = child.getAttribute(InternalConstants.CLASS_TAG);
					if (attr == null || attr.length() == 0) {
						LogUtils.error(ce, "Required attribute class is empty. Ignored."); //$NON-NLS-1$
						break;
					}
					if (modelTypes.contains(attr)) {
						LogUtils.error(child, "Duplicate model type: '" + attr + "'. Ignored."); //$NON-NLS-1$ //$NON-NLS-2$
					}
					modelTypes.add(attr);
					if (alsoPrimitive) {
						final String primitiveType = DecoratorProviderImpl.myBoxed2Primitive.get(attr);
						if (primitiveType != null) {
							modelTypes.add(primitiveType);
						}
					}
				}
				readArguments(descriptor, ce);
				getTreeItems().add(descriptor);
			} else if (InternalConstants.TREE_ITEM_RELATION_TAG.equals(elementName)) {
				// Delayed...
				relations.add(ce);
			} else {
				LogUtils.error(ce, "Unknown element name: '" + elementName + "'"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		/*
		 * Now go through the relations
		 */
		for (final IConfigurationElement ce : relations) {
			final ITreeItemRelation rel = IUIBindingsFactory.eINSTANCE.createTreeItemRelation();
			String attr = ce.getAttribute(InternalConstants.PARENT_TAG);
			if (attr == null || attr.length() == 0) {
				LogUtils.error(ce, InternalConstants.PARENT_TAG + " must be specified. Ignored"); //$NON-NLS-1$
				continue;
			}
			final ITreeItemDescriptor parent = getTreeItem(attr);
			if (parent == null) {
				LogUtils.error(ce, InternalConstants.PARENT_TAG + " " + attr + " is unknown. Ignored."); //$NON-NLS-1$ //$NON-NLS-2$
				continue;
			}

			attr = ce.getAttribute(InternalConstants.PRIORITY_TAG);
			if (attr != null && attr.length() > 0) {
				try {
					rel.setPriority(Integer.parseInt(attr));
				} catch (final NumberFormatException ex) {
					LogUtils.error(ce, ex);
					continue;
				}
			} else {
				rel.setPriority(1000);
			}

			ITreeItemDescriptor desc = null;
			attr = ce.getAttribute(InternalConstants.ID_TAG);
			if (attr != null && attr.length() > 0) {
				desc = getTreeItem(attr);
				if (desc == null) {
					LogUtils.error(ce, InternalConstants.ID_TAG + " " + attr + " is unknown. Ignored."); //$NON-NLS-1$ //$NON-NLS-2$
					continue;
				}
				rel.setDescriptor(desc);
			}

			final String c = ce.getAttribute(InternalConstants.CLASS_TAG);
			final String f = ce.getAttribute(InternalConstants.FEATURE_NAME_TAG);
			if (c != null && c.length() > 0) {
				rel.setProcessor(new CEObjectHolder<IObservableFactory>(ce, InternalConstants.CLASS_TAG));
				if (f != null && f.length() > 0) {
					LogUtils.error(ce, "Both " + InternalConstants.CLASS_TAG + " " + InternalConstants.FEATURE_NAME_TAG //$NON-NLS-1$ //$NON-NLS-2$
							+ " may not by specified. Ignored."); //$NON-NLS-1$
					continue;
				}
			} else if (f != null && f.length() > 0) {
				rel.setFeatureName(f);
			} else {
				// Do nothing
			}
			rel.setParent(parent);
		}

		/*
		 * Sort the extenders.
		 */
		UIBindingsUtils.sort(getDecoratorExtenders(), new Comparator<IUIBindingDecoratorExtenderDescriptor>() {
			@Override
			public int compare(IUIBindingDecoratorExtenderDescriptor o1, IUIBindingDecoratorExtenderDescriptor o2) {
				return o2.getPriority() - o1.getPriority();
			}
		});

		/*
		 * Sort the relations of tree descriptors.
		 */
		final Comparator<ITreeItemRelation> comparator = new Comparator<ITreeItemRelation>() {
			@Override
			public int compare(ITreeItemRelation o1, ITreeItemRelation o2) {
				return o2.getPriority() - o1.getPriority();
			}
		};
		for (final ITreeItemDescriptor tid : getTreeItems()) {
			UIBindingsUtils.sort(tid.getChildren(), comparator);
		}
	}

	/**
	 * Reads argument information for the specified argument provider.
	 * 
	 * @param provider the argument provider
	 * @param ce the base configuration element
	 */
	protected void readArguments(IArgumentProvider provider, IConfigurationElement ce) {
		for (final IConfigurationElement childCE : ce.getChildren(InternalConstants.STANDARD_ARGUMENTS_TAG)) {
			for (final String name : Constants.EXT_POINT_ATTRIBUTE_NAMES) {
				final String value = childCE.getAttribute(name);
				if (value != null && value.length() > 0) {
					provider.getDeclaredArguments().put(name, childCE);
				}
			}
		}
		for (final IConfigurationElement childCE : ce.getChildren(InternalConstants.ARGUMENT_TAG)) {
			final String name = childCE.getAttribute(InternalConstants.NAME_TAG);
			if (name == null || name.length() == 0) {
				LogUtils.error(childCE, "Argument name must be specified. Ignored"); //$NON-NLS-1$
				continue;
			}
			provider.getDeclaredArguments().put(name, childCE);
		}
	}

	@Override
	public IUIAttribute createUIAttribute(Widget widget, String attribute) {
		final Class<?>[] classes = Platform.getAdapterManager().computeClassOrder(widget.getClass());
		CEObjectHolder<IUIAttributeFactory> holder = null;
		for (final Class<?> c : classes) {
			final String typeName = c.getName();
			for (final IUIAttributeFactoryDescriptor d : getUiAttributeFactories()) {
				if (!d.getTypeName().equals(typeName)) {
					continue;
				}
				if (!d.getAttribute().equals(attribute)) {
					continue;
				}
				holder = d.getFactory();
				break;
			}
			if (holder != null) {
				break;
			}
		}
		if (holder == null) {
			LogUtils.error(widget, "Widget, '" + widget.getClass().getName() + "', does not support attribute '" //$NON-NLS-1$ //$NON-NLS-2$
					+ attribute + "'. Ignored."); //$NON-NLS-1$
			return null;
		}

		final IUIAttributeFactory factory = holder.getObject();
		if (factory == null) {
			LogUtils.error(widget, "Widget, '" + widget.getClass().getName() //$NON-NLS-1$
					+ "', not supported. Cannot create IUIAttribute factory. Ignored."); //$NON-NLS-1$
			return null;
		}
		try {
			return factory.create(widget, attribute);
		} catch (final IllegalArgumentException ex) {
			LogUtils.error(factory, ex);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.MANAGER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IDecoratorProvider> getProviders() {
		if (providers == null) {
			providers = new EObjectContainmentWithInverseEList<IDecoratorProvider>(IDecoratorProvider.class, this,
					IUIBindingsPackage.MANAGER__PROVIDERS, IUIBindingsPackage.DECORATOR_PROVIDER__MANAGER);
		}
		return providers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IUIAttributeFactoryDescriptor> getUiAttributeFactories() {
		if (uiAttributeFactories == null) {
			uiAttributeFactories = new EObjectResolvingEList<IUIAttributeFactoryDescriptor>(
					IUIAttributeFactoryDescriptor.class, this, IUIBindingsPackage.MANAGER__UI_ATTRIBUTE_FACTORIES);
		}
		return uiAttributeFactories;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IUIBindingDecoratorExtenderDescriptor> getDecoratorExtenders() {
		if (decoratorExtenders == null) {
			decoratorExtenders = new EObjectResolvingEList<IUIBindingDecoratorExtenderDescriptor>(
					IUIBindingDecoratorExtenderDescriptor.class, this, IUIBindingsPackage.MANAGER__DECORATOR_EXTENDERS);
		}
		return decoratorExtenders;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<CEObjectHolder<IModelArgumentMediator>> getModelArgumentMediators() {
		if (modelArgumentMediators == null) {
			modelArgumentMediators = new EDataTypeUniqueEList<CEObjectHolder<IModelArgumentMediator>>(
					CEObjectHolder.class, this, IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATORS);
		}
		return modelArgumentMediators;
	}

	@Override
	public void runModelArgumentMediators(EClassifier classifier) {
		if (getModelArgumentMediatorClasses().containsKey(classifier)) return;
		getModelArgumentMediatorClasses().put(classifier, null);

		for (final CEObjectHolder<IModelArgumentMediator> holder : getModelArgumentMediators()) {
			final IModelArgumentMediator mediator = holder.getObject();
			if (mediator != null) {
				mediator.mediateArguments(classifier);
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Map<EClassifier, Object> getModelArgumentMediatorClasses() {
		return modelArgumentMediatorClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setModelArgumentMediatorClasses(Map<EClassifier, Object> newModelArgumentMediatorClasses) {
		final Map<EClassifier, Object> oldModelArgumentMediatorClasses = modelArgumentMediatorClasses;
		modelArgumentMediatorClasses = newModelArgumentMediatorClasses;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATOR_CLASSES, oldModelArgumentMediatorClasses,
					modelArgumentMediatorClasses));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TextCommitStrategy getTextCommitStrategy() {
		return textCommitStrategy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setTextCommitStrategy(TextCommitStrategy newTextCommitStrategy) {
		setTextCommitStrategyGen(newTextCommitStrategy);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_TEXT_COMMIT_STRATEGY, newTextCommitStrategy.name());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTextCommitStrategyGen(TextCommitStrategy newTextCommitStrategy) {
		final TextCommitStrategy oldTextCommitStrategy = textCommitStrategy;
		textCommitStrategy = newTextCommitStrategy == null ? TEXT_COMMIT_STRATEGY_EDEFAULT : newTextCommitStrategy;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY,
					oldTextCommitStrategy, textCommitStrategy));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getTextCommitStrategyDelay() {
		return textCommitStrategyDelay;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setTextCommitStrategyDelay(int newTextCommitStrategyDelay) {
		if (newTextCommitStrategyDelay < 1 || 1000000 < newTextCommitStrategyDelay)
			throw new IllegalArgumentException("delay " + newTextCommitStrategyDelay + " must be in range [1;1000000["); //$NON-NLS-1$ //$NON-NLS-2$
		setTextCommitStrategyDelayGen(newTextCommitStrategyDelay);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_TEXT_COMMIT_STRATEGY_DELAY, newTextCommitStrategyDelay);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTextCommitStrategyDelayGen(int newTextCommitStrategyDelay) {
		final int oldTextCommitStrategyDelay = textCommitStrategyDelay;
		textCommitStrategyDelay = newTextCommitStrategyDelay;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY_DELAY, oldTextCommitStrategyDelay,
					textCommitStrategyDelay));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isEditCellAnyKey() {
		return editCellAnyKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setEditCellAnyKey(boolean newEditCellAnyKey) {
		setEditCellAnyKeyGen(newEditCellAnyKey);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_EDIT_CELL_ANY_KEY, newEditCellAnyKey);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEditCellAnyKeyGen(boolean newEditCellAnyKey) {
		final boolean oldEditCellAnyKey = editCellAnyKey;
		editCellAnyKey = newEditCellAnyKey;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__EDIT_CELL_ANY_KEY,
					oldEditCellAnyKey, editCellAnyKey));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isEditCellSingleClick() {
		return editCellSingleClick;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setEditCellSingleClick(boolean newEditCellSingleClick) {
		setEditCellSingleClickGen(newEditCellSingleClick);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_EDIT_CELL_SINGLE_CLICK, newEditCellSingleClick);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEditCellSingleClickGen(boolean newEditCellSingleClick) {
		final boolean oldEditCellSingleClick = editCellSingleClick;
		editCellSingleClick = newEditCellSingleClick;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__EDIT_CELL_SINGLE_CLICK,
					oldEditCellSingleClick, editCellSingleClick));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public DecorationPosition getMessageDecorationPosition() {
		return messageDecorationPosition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setMessageDecorationPosition(DecorationPosition newMessageDecorationPosition) {
		setMessageDecorationPositionGen(newMessageDecorationPosition);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_MESSAGE_DECORATION_POSITION, newMessageDecorationPosition.name());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMessageDecorationPositionGen(DecorationPosition newMessageDecorationPosition) {
		final DecorationPosition oldMessageDecorationPosition = messageDecorationPosition;
		messageDecorationPosition = newMessageDecorationPosition == null ? MESSAGE_DECORATION_POSITION_EDEFAULT
				: newMessageDecorationPosition;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_POSITION, oldMessageDecorationPosition,
					messageDecorationPosition));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public BindingMessageSeverity getMessageDecorationMinimumSeverity() {
		return messageDecorationMinimumSeverity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setMessageDecorationMinimumSeverity(BindingMessageSeverity newMessageDecorationMinimumSeverity) {
		setMessageDecorationMinimumSeverityGen(newMessageDecorationMinimumSeverity);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY,
				newMessageDecorationMinimumSeverity.name());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMessageDecorationMinimumSeverityGen(BindingMessageSeverity newMessageDecorationMinimumSeverity) {
		final BindingMessageSeverity oldMessageDecorationMinimumSeverity = messageDecorationMinimumSeverity;
		messageDecorationMinimumSeverity = newMessageDecorationMinimumSeverity == null ? MESSAGE_DECORATION_MINIMUM_SEVERITY_EDEFAULT
				: newMessageDecorationMinimumSeverity;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY,
					oldMessageDecorationMinimumSeverity, messageDecorationMinimumSeverity));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public DecorationPosition getAlternativeDecorationPosition() {
		return alternativeDecorationPosition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setAlternativeDecorationPosition(DecorationPosition newAlternativeDecorationPosition) {
		setAlternativeDecorationPositionGen(newAlternativeDecorationPosition);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_ALTERNATIVE_DECORATION_POSITION, newAlternativeDecorationPosition.name());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAlternativeDecorationPositionGen(DecorationPosition newAlternativeDecorationPosition) {
		final DecorationPosition oldAlternativeDecorationPosition = alternativeDecorationPosition;
		alternativeDecorationPosition = newAlternativeDecorationPosition == null ? ALTERNATIVE_DECORATION_POSITION_EDEFAULT
				: newAlternativeDecorationPosition;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__ALTERNATIVE_DECORATION_POSITION, oldAlternativeDecorationPosition,
					alternativeDecorationPosition));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isAutoApplySingleQuickfix() {
		return autoApplySingleQuickfix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setAutoApplySingleQuickfix(boolean newAutoApplySingleQuickfix) {
		setAutoApplySingleQuickfixGen(newAutoApplySingleQuickfix);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_AUTO_APPLY_QUICKFIX, newAutoApplySingleQuickfix);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAutoApplySingleQuickfixGen(boolean newAutoApplySingleQuickfix) {
		final boolean oldAutoApplySingleQuickfix = autoApplySingleQuickfix;
		autoApplySingleQuickfix = newAutoApplySingleQuickfix;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__AUTO_APPLY_SINGLE_QUICKFIX, oldAutoApplySingleQuickfix,
					autoApplySingleQuickfix));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isAlternateRowColors() {
		return alternateRowColors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setAlternateRowColors(boolean newAlternateRowColors) {
		setAlternateRowColorsGen(newAlternateRowColors);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_ALTERNATE_ROW_COLORS, newAlternateRowColors);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAlternateRowColorsGen(boolean newAlternateRowColors) {
		final boolean oldAlternateRowColors = alternateRowColors;
		alternateRowColors = newAlternateRowColors;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__ALTERNATE_ROW_COLORS,
					oldAlternateRowColors, alternateRowColors));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isValidationErrorsAreFatal() {
		return validationErrorsAreFatal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setValidationErrorsAreFatal(boolean newValidationErrorsAreFatal) {
		setValidationErrorsAreFatalGen(newValidationErrorsAreFatal);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_VALIDATION_ERRORS_ARE_FATAL, newValidationErrorsAreFatal);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValidationErrorsAreFatalGen(boolean newValidationErrorsAreFatal) {
		final boolean oldValidationErrorsAreFatal = validationErrorsAreFatal;
		validationErrorsAreFatal = newValidationErrorsAreFatal;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__VALIDATION_ERRORS_ARE_FATAL, oldValidationErrorsAreFatal,
					validationErrorsAreFatal));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getValidationDelay() {
		return validationDelay;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setValidationDelay(int newValidationDelay) {
		if (newValidationDelay < 1 || 1000000 < newValidationDelay)
			throw new IllegalArgumentException("delay must be in range [1;1000000["); //$NON-NLS-1$
		setValidationDelayGen(newValidationDelay);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_VALIDATION_DELAY, newValidationDelay);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValidationDelayGen(int newValidationDelay) {
		final int oldValidationDelay = validationDelay;
		validationDelay = newValidationDelay;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__VALIDATION_DELAY,
					oldValidationDelay, validationDelay));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getValidationDelayWindow() {
		return validationDelayWindow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setValidationDelayWindow(int newValidationDelayWindow) {
		if (newValidationDelayWindow < 1 || 1000000 < newValidationDelayWindow)
			throw new IllegalArgumentException("delay must be in range [1;1000000["); //$NON-NLS-1$
		setValidationDelayWindowGen(newValidationDelayWindow);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_VALIDATION_DELAY_WINDOW, newValidationDelayWindow);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValidationDelayWindowGen(int newValidationDelayWindow) {
		final int oldValidationDelayWindow = validationDelayWindow;
		validationDelayWindow = newValidationDelayWindow;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__VALIDATION_DELAY_WINDOW,
					oldValidationDelayWindow, validationDelayWindow));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isRequiredVBImageDecorationShown() {
		return requiredVBImageDecorationShown;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setRequiredVBImageDecorationShown(boolean newRequiredVBImageDecorationShown) {
		setRequiredVBImageDecorationShownGen(newRequiredVBImageDecorationShown);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_REQUIRED_VBID_SHOWN, newRequiredVBImageDecorationShown);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRequiredVBImageDecorationShownGen(boolean newRequiredVBImageDecorationShown) {
		final boolean oldRequiredVBImageDecorationShown = requiredVBImageDecorationShown;
		requiredVBImageDecorationShown = newRequiredVBImageDecorationShown;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN, oldRequiredVBImageDecorationShown,
					requiredVBImageDecorationShown));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isAssistVBImageDecorationShown() {
		return assistVBImageDecorationShown;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setAssistVBImageDecorationShown(boolean newAssistVBImageDecorationShown) {
		setAssistVBImageDecorationShownGen(newAssistVBImageDecorationShown);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_ASSIST_VBID_SHOWN, newAssistVBImageDecorationShown);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAssistVBImageDecorationShownGen(boolean newAssistVBImageDecorationShown) {
		final boolean oldAssistVBImageDecorationShown = assistVBImageDecorationShown;
		assistVBImageDecorationShown = newAssistVBImageDecorationShown;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN, oldAssistVBImageDecorationShown,
					assistVBImageDecorationShown));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isQuickfixVBImageDecorationShown() {
		return quickfixVBImageDecorationShown;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setQuickfixVBImageDecorationShown(boolean newQuickfixVBImageDecorationShown) {
		setQuickfixVBImageDecorationShownGen(newQuickfixVBImageDecorationShown);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_QUICKFIX_VBID_SHOWN, newQuickfixVBImageDecorationShown);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setQuickfixVBImageDecorationShownGen(boolean newQuickfixVBImageDecorationShown) {
		final boolean oldQuickfixVBImageDecorationShown = quickfixVBImageDecorationShown;
		quickfixVBImageDecorationShown = newQuickfixVBImageDecorationShown;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN, oldQuickfixVBImageDecorationShown,
					quickfixVBImageDecorationShown));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isViewNavigationRecorded() {
		return viewNavigationRecorded;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setViewNavigationRecorded(boolean newViewNavigationRecorded) {
		setViewNavigationRecordedGen(newViewNavigationRecorded);
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(UIBindingPreferences.PREF_VIEW_NAVIGATION_RECORDED, newViewNavigationRecorded);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setViewNavigationRecordedGen(boolean newViewNavigationRecorded) {
		final boolean oldViewNavigationRecorded = viewNavigationRecorded;
		viewNavigationRecorded = newViewNavigationRecorded;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__VIEW_NAVIGATION_RECORDED,
					oldViewNavigationRecorded, viewNavigationRecorded));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, IModelClassInfo> getModelInfo() {
		if (modelInfo == null) {
			modelInfo = new EcoreEMap<String, IModelClassInfo>(
					IUIBindingsPackage.Literals.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY,
					StringToModelClassInfoMapEntryImpl.class, this, IUIBindingsPackage.MANAGER__MODEL_INFO);
		}
		return modelInfo;
	}

	@Override
	public IModelClassInfo getModelClassInfo(String className, String type, boolean create) {
		IModelClassInfo cInfo = getModelInfo().get(className);
		if (cInfo == null && create) {
			cInfo = IUIBindingsFactory.eINSTANCE.createModelClassInfo();
			cInfo.setClassName(className);
			getModelInfo().put(className, cInfo);
		}
		/*
		 * Handle the type part
		 */
		if (cInfo != null && type != null && type.length() > 0) {
			IModelClassInfo tInfo = cInfo.getTypes().get(type);
			if (tInfo == null && create) {
				tInfo = IUIBindingsFactory.eINSTANCE.createModelClassInfo();
				tInfo.setClassName(className);
				cInfo.getTypes().put(type, tInfo);
			}
			cInfo = tInfo;
		}

		return cInfo;
	}

	@Override
	public IModelFeatureInfo getModelFeatureInfo(String className, String featureName, String type, boolean create) {
		final IModelClassInfo cInfo = getModelClassInfo(className, type, true);
		if (cInfo == null) return null;

		IModelFeatureInfo fInfo = cInfo.getFeatures().get(featureName);
		if (fInfo == null && create) {
			fInfo = IUIBindingsFactory.eINSTANCE.createModelFeatureInfo();
			fInfo.setFeatureName(featureName);
			cInfo.getFeatures().put(featureName, fInfo);
		}

		return fInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ITreeItemDescriptor> getTreeItems() {
		if (treeItems == null) {
			treeItems = new EObjectContainmentEList<ITreeItemDescriptor>(ITreeItemDescriptor.class, this,
					IUIBindingsPackage.MANAGER__TREE_ITEMS);
		}
		return treeItems;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Clipboard getClipboard() {
		if (clipboard == null) {
			clipboard = new Clipboard(PlatformUI.getWorkbench().getDisplay());
		}
		return clipboard;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IEMFObservableFactoryDescriptor> getObservableFactories() {
		if (observableFactories == null) {
			observableFactories = new EObjectContainmentEList<IEMFObservableFactoryDescriptor>(
					IEMFObservableFactoryDescriptor.class, this, IUIBindingsPackage.MANAGER__OBSERVABLE_FACTORIES);
		}
		return observableFactories;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IQuickfixProposalProcessorDescriptor> getQuickfixProposalProcessors() {
		if (quickfixProposalProcessors == null) {
			quickfixProposalProcessors = new EObjectContainmentEList<IQuickfixProposalProcessorDescriptor>(
					IQuickfixProposalProcessorDescriptor.class, this,
					IUIBindingsPackage.MANAGER__QUICKFIX_PROPOSAL_PROCESSORS);
		}
		return quickfixProposalProcessors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IBindingContext> getContexts() {
		if (contexts == null) {
			contexts = new EObjectContainmentEList<IBindingContext>(IBindingContext.class, this,
					IUIBindingsPackage.MANAGER__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EditingDomain getEditingDomain() {
		if (editingDomain == null) {
			setEditingDomain(UIBindingsUtils.createEditingDomain());
		}
		return editingDomain;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setEditingDomain(EditingDomain newEditingDomain) {
		final EditingDomain oldEditingDomain = editingDomain;
		editingDomain = newEditingDomain;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__EDITING_DOMAIN,
					oldEditingDomain, editingDomain));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public FormToolkit getFormToolkit() {
		if (formToolkit == null) {
			formToolkit = new FormToolkit(Display.getCurrent());
		}
		return formToolkit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFormToolkit(FormToolkit newFormToolkit) {
		final FormToolkit oldFormToolkit = formToolkit;
		formToolkit = newFormToolkit;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MANAGER__FORM_TOOLKIT,
					oldFormToolkit, formToolkit));
		}
	}

	@Override
	public IEMFObservableFactory getObservableFactory(EObject object) {
		Assert.isNotNull(object, "observed object may not be null"); //$NON-NLS-1$
		final String packageName = object.getClass().getPackage().getName();
		IEMFObservableFactoryDescriptor desc = null;
		for (final IEMFObservableFactoryDescriptor d : getObservableFactories()) {
			if (packageName.startsWith(d.getPackagePrefix())) {
				desc = d;
				break;
			}
		}
		if (desc == null) {
			if (theDefaultObservableFactory == null) {
				theDefaultObservableFactory = new DefaultEMFObservableFactory();
			}
			return theDefaultObservableFactory;
		}
		return desc.getFactory().getObject();
	}

	@Override
	public void getQuickfixes(IBindingMessage message, final List<IQuickfixProposal> proposals) {
		final int code = message.getCode();
		final String source = message.getSource();
		final String messageMessage = message.getMessage();
		final IQuickfixProposalProcessorContext context = new QuickfixProposalProcessorContextImpl() {
			@Override
			public void addProposal(IQuickfixProposal proposal) {
				if (Activator.getDefault().TRACE_QUICK_FIXES) {
					LogUtils.debug(proposal, "Added " + proposal); //$NON-NLS-1$
				}
				proposals.add(proposal);
			}
		};
		/*
		 * For each quick fix test against the current message. Reject the quick fix if any of the
		 * conditions do not match.
		 */
		for (final IQuickfixProposalProcessorDescriptor qi : getQuickfixProposalProcessors()) {
			if (qi.getSource() != null && !qi.getSource().equals(source)) {
				continue;
			}
			if (qi.getCode() != Integer.MIN_VALUE && qi.getCode() != code) {
				continue;
			}
			if (qi.getModelType() != null || qi.getFeature() != null) {
				boolean matches = false;
				for (final IBindingMessageTarget target : message.getTargets()) {
					boolean found = false;
					final EObject modelObject = target.getModelObject();
					if (qi.getModelType() != null) {
						if (modelObject == null) {
							continue;
						}
						final Class<?>[] typeOrder = Platform.getAdapterManager().computeClassOrder(
								modelObject.getClass());
						for (final Class<?> c : typeOrder) {
							if (c.getName().equals(qi.getModelType())) {
								found = true;
								break;
							}
						}
						if (!found) {
							continue;
						}
					}
					if (qi.getFeature() != null) {
						final String feature = target.getModelFeature() != null ? target.getModelFeature().getName()
								: null;
						if (!qi.getFeature().equals(feature)) {
							found = false;
							continue;
						}
					}
					// We have a match on object and feature
					matches = true;
					break;
				}
				if (!matches) {
					continue;
				}
			}
			if (qi.getMessagePattern() != null) {
				if (messageMessage == null || messageMessage.length() == 0) {
					continue;
				}
				if (!qi.getMessagePattern().matcher(messageMessage).matches()) {
					continue;
				}
			}

			/*
			 * So we have a possible processor
			 */
			final IQuickfixProposalProcessor processor = qi.getProcessor().getObject();
			if (processor != null) {
				processor.getProposals(context, message);
			}
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
		case IUIBindingsPackage.MANAGER__PROVIDERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getProviders()).basicAdd(otherEnd, msgs);
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
		case IUIBindingsPackage.MANAGER__PROVIDERS:
			return ((InternalEList<?>) getProviders()).basicRemove(otherEnd, msgs);
		case IUIBindingsPackage.MANAGER__MODEL_INFO:
			return ((InternalEList<?>) getModelInfo()).basicRemove(otherEnd, msgs);
		case IUIBindingsPackage.MANAGER__TREE_ITEMS:
			return ((InternalEList<?>) getTreeItems()).basicRemove(otherEnd, msgs);
		case IUIBindingsPackage.MANAGER__OBSERVABLE_FACTORIES:
			return ((InternalEList<?>) getObservableFactories()).basicRemove(otherEnd, msgs);
		case IUIBindingsPackage.MANAGER__QUICKFIX_PROPOSAL_PROCESSORS:
			return ((InternalEList<?>) getQuickfixProposalProcessors()).basicRemove(otherEnd, msgs);
		case IUIBindingsPackage.MANAGER__CONTEXTS:
			return ((InternalEList<?>) getContexts()).basicRemove(otherEnd, msgs);
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
		case IUIBindingsPackage.MANAGER__EDITING_DOMAIN:
			return getEditingDomain();
		case IUIBindingsPackage.MANAGER__FORM_TOOLKIT:
			return getFormToolkit();
		case IUIBindingsPackage.MANAGER__PROVIDERS:
			return getProviders();
		case IUIBindingsPackage.MANAGER__UI_ATTRIBUTE_FACTORIES:
			return getUiAttributeFactories();
		case IUIBindingsPackage.MANAGER__DECORATOR_EXTENDERS:
			return getDecoratorExtenders();
		case IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATORS:
			return getModelArgumentMediators();
		case IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATOR_CLASSES:
			return getModelArgumentMediatorClasses();
		case IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY:
			return getTextCommitStrategy();
		case IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY_DELAY:
			return getTextCommitStrategyDelay();
		case IUIBindingsPackage.MANAGER__EDIT_CELL_ANY_KEY:
			return isEditCellAnyKey();
		case IUIBindingsPackage.MANAGER__EDIT_CELL_SINGLE_CLICK:
			return isEditCellSingleClick();
		case IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_POSITION:
			return getMessageDecorationPosition();
		case IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY:
			return getMessageDecorationMinimumSeverity();
		case IUIBindingsPackage.MANAGER__ALTERNATIVE_DECORATION_POSITION:
			return getAlternativeDecorationPosition();
		case IUIBindingsPackage.MANAGER__AUTO_APPLY_SINGLE_QUICKFIX:
			return isAutoApplySingleQuickfix();
		case IUIBindingsPackage.MANAGER__ALTERNATE_ROW_COLORS:
			return isAlternateRowColors();
		case IUIBindingsPackage.MANAGER__VALIDATION_ERRORS_ARE_FATAL:
			return isValidationErrorsAreFatal();
		case IUIBindingsPackage.MANAGER__VALIDATION_DELAY:
			return getValidationDelay();
		case IUIBindingsPackage.MANAGER__VALIDATION_DELAY_WINDOW:
			return getValidationDelayWindow();
		case IUIBindingsPackage.MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN:
			return isRequiredVBImageDecorationShown();
		case IUIBindingsPackage.MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN:
			return isAssistVBImageDecorationShown();
		case IUIBindingsPackage.MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN:
			return isQuickfixVBImageDecorationShown();
		case IUIBindingsPackage.MANAGER__VIEW_NAVIGATION_RECORDED:
			return isViewNavigationRecorded();
		case IUIBindingsPackage.MANAGER__MODEL_INFO:
			if (coreType)
				return getModelInfo();
			else
				return getModelInfo().map();
		case IUIBindingsPackage.MANAGER__TREE_ITEMS:
			return getTreeItems();
		case IUIBindingsPackage.MANAGER__CLIPBOARD:
			return getClipboard();
		case IUIBindingsPackage.MANAGER__OBSERVABLE_FACTORIES:
			return getObservableFactories();
		case IUIBindingsPackage.MANAGER__QUICKFIX_PROPOSAL_PROCESSORS:
			return getQuickfixProposalProcessors();
		case IUIBindingsPackage.MANAGER__CONTEXTS:
			return getContexts();
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
		case IUIBindingsPackage.MANAGER__EDITING_DOMAIN:
			setEditingDomain((EditingDomain) newValue);
			return;
		case IUIBindingsPackage.MANAGER__FORM_TOOLKIT:
			setFormToolkit((FormToolkit) newValue);
			return;
		case IUIBindingsPackage.MANAGER__PROVIDERS:
			getProviders().clear();
			getProviders().addAll((Collection<? extends IDecoratorProvider>) newValue);
			return;
		case IUIBindingsPackage.MANAGER__UI_ATTRIBUTE_FACTORIES:
			getUiAttributeFactories().clear();
			getUiAttributeFactories().addAll((Collection<? extends IUIAttributeFactoryDescriptor>) newValue);
			return;
		case IUIBindingsPackage.MANAGER__DECORATOR_EXTENDERS:
			getDecoratorExtenders().clear();
			getDecoratorExtenders().addAll((Collection<? extends IUIBindingDecoratorExtenderDescriptor>) newValue);
			return;
		case IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATORS:
			getModelArgumentMediators().clear();
			getModelArgumentMediators().addAll((Collection<? extends CEObjectHolder<IModelArgumentMediator>>) newValue);
			return;
		case IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATOR_CLASSES:
			setModelArgumentMediatorClasses((Map<EClassifier, Object>) newValue);
			return;
		case IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY:
			setTextCommitStrategy((TextCommitStrategy) newValue);
			return;
		case IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY_DELAY:
			setTextCommitStrategyDelay((Integer) newValue);
			return;
		case IUIBindingsPackage.MANAGER__EDIT_CELL_ANY_KEY:
			setEditCellAnyKey((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__EDIT_CELL_SINGLE_CLICK:
			setEditCellSingleClick((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_POSITION:
			setMessageDecorationPosition((DecorationPosition) newValue);
			return;
		case IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY:
			setMessageDecorationMinimumSeverity((BindingMessageSeverity) newValue);
			return;
		case IUIBindingsPackage.MANAGER__ALTERNATIVE_DECORATION_POSITION:
			setAlternativeDecorationPosition((DecorationPosition) newValue);
			return;
		case IUIBindingsPackage.MANAGER__AUTO_APPLY_SINGLE_QUICKFIX:
			setAutoApplySingleQuickfix((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__ALTERNATE_ROW_COLORS:
			setAlternateRowColors((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__VALIDATION_ERRORS_ARE_FATAL:
			setValidationErrorsAreFatal((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__VALIDATION_DELAY:
			setValidationDelay((Integer) newValue);
			return;
		case IUIBindingsPackage.MANAGER__VALIDATION_DELAY_WINDOW:
			setValidationDelayWindow((Integer) newValue);
			return;
		case IUIBindingsPackage.MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN:
			setRequiredVBImageDecorationShown((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN:
			setAssistVBImageDecorationShown((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN:
			setQuickfixVBImageDecorationShown((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__VIEW_NAVIGATION_RECORDED:
			setViewNavigationRecorded((Boolean) newValue);
			return;
		case IUIBindingsPackage.MANAGER__MODEL_INFO:
			((EStructuralFeature.Setting) getModelInfo()).set(newValue);
			return;
		case IUIBindingsPackage.MANAGER__TREE_ITEMS:
			getTreeItems().clear();
			getTreeItems().addAll((Collection<? extends ITreeItemDescriptor>) newValue);
			return;
		case IUIBindingsPackage.MANAGER__OBSERVABLE_FACTORIES:
			getObservableFactories().clear();
			getObservableFactories().addAll((Collection<? extends IEMFObservableFactoryDescriptor>) newValue);
			return;
		case IUIBindingsPackage.MANAGER__QUICKFIX_PROPOSAL_PROCESSORS:
			getQuickfixProposalProcessors().clear();
			getQuickfixProposalProcessors().addAll(
					(Collection<? extends IQuickfixProposalProcessorDescriptor>) newValue);
			return;
		case IUIBindingsPackage.MANAGER__CONTEXTS:
			getContexts().clear();
			getContexts().addAll((Collection<? extends IBindingContext>) newValue);
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
		case IUIBindingsPackage.MANAGER__EDITING_DOMAIN:
			setEditingDomain(EDITING_DOMAIN_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__FORM_TOOLKIT:
			setFormToolkit(FORM_TOOLKIT_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__PROVIDERS:
			getProviders().clear();
			return;
		case IUIBindingsPackage.MANAGER__UI_ATTRIBUTE_FACTORIES:
			getUiAttributeFactories().clear();
			return;
		case IUIBindingsPackage.MANAGER__DECORATOR_EXTENDERS:
			getDecoratorExtenders().clear();
			return;
		case IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATORS:
			getModelArgumentMediators().clear();
			return;
		case IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATOR_CLASSES:
			setModelArgumentMediatorClasses((Map<EClassifier, Object>) null);
			return;
		case IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY:
			setTextCommitStrategy(TEXT_COMMIT_STRATEGY_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY_DELAY:
			setTextCommitStrategyDelay(TEXT_COMMIT_STRATEGY_DELAY_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__EDIT_CELL_ANY_KEY:
			setEditCellAnyKey(EDIT_CELL_ANY_KEY_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__EDIT_CELL_SINGLE_CLICK:
			setEditCellSingleClick(EDIT_CELL_SINGLE_CLICK_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_POSITION:
			setMessageDecorationPosition(MESSAGE_DECORATION_POSITION_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY:
			setMessageDecorationMinimumSeverity(MESSAGE_DECORATION_MINIMUM_SEVERITY_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__ALTERNATIVE_DECORATION_POSITION:
			setAlternativeDecorationPosition(ALTERNATIVE_DECORATION_POSITION_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__AUTO_APPLY_SINGLE_QUICKFIX:
			setAutoApplySingleQuickfix(AUTO_APPLY_SINGLE_QUICKFIX_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__ALTERNATE_ROW_COLORS:
			setAlternateRowColors(ALTERNATE_ROW_COLORS_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__VALIDATION_ERRORS_ARE_FATAL:
			setValidationErrorsAreFatal(VALIDATION_ERRORS_ARE_FATAL_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__VALIDATION_DELAY:
			setValidationDelay(VALIDATION_DELAY_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__VALIDATION_DELAY_WINDOW:
			setValidationDelayWindow(VALIDATION_DELAY_WINDOW_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN:
			setRequiredVBImageDecorationShown(REQUIRED_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN:
			setAssistVBImageDecorationShown(ASSIST_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN:
			setQuickfixVBImageDecorationShown(QUICKFIX_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__VIEW_NAVIGATION_RECORDED:
			setViewNavigationRecorded(VIEW_NAVIGATION_RECORDED_EDEFAULT);
			return;
		case IUIBindingsPackage.MANAGER__MODEL_INFO:
			getModelInfo().clear();
			return;
		case IUIBindingsPackage.MANAGER__TREE_ITEMS:
			getTreeItems().clear();
			return;
		case IUIBindingsPackage.MANAGER__OBSERVABLE_FACTORIES:
			getObservableFactories().clear();
			return;
		case IUIBindingsPackage.MANAGER__QUICKFIX_PROPOSAL_PROCESSORS:
			getQuickfixProposalProcessors().clear();
			return;
		case IUIBindingsPackage.MANAGER__CONTEXTS:
			getContexts().clear();
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
		case IUIBindingsPackage.MANAGER__EDITING_DOMAIN:
			return EDITING_DOMAIN_EDEFAULT == null ? editingDomain != null : !EDITING_DOMAIN_EDEFAULT
					.equals(editingDomain);
		case IUIBindingsPackage.MANAGER__FORM_TOOLKIT:
			return FORM_TOOLKIT_EDEFAULT == null ? formToolkit != null : !FORM_TOOLKIT_EDEFAULT.equals(formToolkit);
		case IUIBindingsPackage.MANAGER__PROVIDERS:
			return providers != null && !providers.isEmpty();
		case IUIBindingsPackage.MANAGER__UI_ATTRIBUTE_FACTORIES:
			return uiAttributeFactories != null && !uiAttributeFactories.isEmpty();
		case IUIBindingsPackage.MANAGER__DECORATOR_EXTENDERS:
			return decoratorExtenders != null && !decoratorExtenders.isEmpty();
		case IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATORS:
			return modelArgumentMediators != null && !modelArgumentMediators.isEmpty();
		case IUIBindingsPackage.MANAGER__MODEL_ARGUMENT_MEDIATOR_CLASSES:
			return modelArgumentMediatorClasses != null;
		case IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY:
			return textCommitStrategy != TEXT_COMMIT_STRATEGY_EDEFAULT;
		case IUIBindingsPackage.MANAGER__TEXT_COMMIT_STRATEGY_DELAY:
			return textCommitStrategyDelay != TEXT_COMMIT_STRATEGY_DELAY_EDEFAULT;
		case IUIBindingsPackage.MANAGER__EDIT_CELL_ANY_KEY:
			return editCellAnyKey != EDIT_CELL_ANY_KEY_EDEFAULT;
		case IUIBindingsPackage.MANAGER__EDIT_CELL_SINGLE_CLICK:
			return editCellSingleClick != EDIT_CELL_SINGLE_CLICK_EDEFAULT;
		case IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_POSITION:
			return messageDecorationPosition != MESSAGE_DECORATION_POSITION_EDEFAULT;
		case IUIBindingsPackage.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY:
			return messageDecorationMinimumSeverity != MESSAGE_DECORATION_MINIMUM_SEVERITY_EDEFAULT;
		case IUIBindingsPackage.MANAGER__ALTERNATIVE_DECORATION_POSITION:
			return alternativeDecorationPosition != ALTERNATIVE_DECORATION_POSITION_EDEFAULT;
		case IUIBindingsPackage.MANAGER__AUTO_APPLY_SINGLE_QUICKFIX:
			return autoApplySingleQuickfix != AUTO_APPLY_SINGLE_QUICKFIX_EDEFAULT;
		case IUIBindingsPackage.MANAGER__ALTERNATE_ROW_COLORS:
			return alternateRowColors != ALTERNATE_ROW_COLORS_EDEFAULT;
		case IUIBindingsPackage.MANAGER__VALIDATION_ERRORS_ARE_FATAL:
			return validationErrorsAreFatal != VALIDATION_ERRORS_ARE_FATAL_EDEFAULT;
		case IUIBindingsPackage.MANAGER__VALIDATION_DELAY:
			return validationDelay != VALIDATION_DELAY_EDEFAULT;
		case IUIBindingsPackage.MANAGER__VALIDATION_DELAY_WINDOW:
			return validationDelayWindow != VALIDATION_DELAY_WINDOW_EDEFAULT;
		case IUIBindingsPackage.MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN:
			return requiredVBImageDecorationShown != REQUIRED_VB_IMAGE_DECORATION_SHOWN_EDEFAULT;
		case IUIBindingsPackage.MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN:
			return assistVBImageDecorationShown != ASSIST_VB_IMAGE_DECORATION_SHOWN_EDEFAULT;
		case IUIBindingsPackage.MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN:
			return quickfixVBImageDecorationShown != QUICKFIX_VB_IMAGE_DECORATION_SHOWN_EDEFAULT;
		case IUIBindingsPackage.MANAGER__VIEW_NAVIGATION_RECORDED:
			return viewNavigationRecorded != VIEW_NAVIGATION_RECORDED_EDEFAULT;
		case IUIBindingsPackage.MANAGER__MODEL_INFO:
			return modelInfo != null && !modelInfo.isEmpty();
		case IUIBindingsPackage.MANAGER__TREE_ITEMS:
			return treeItems != null && !treeItems.isEmpty();
		case IUIBindingsPackage.MANAGER__CLIPBOARD:
			return CLIPBOARD_EDEFAULT == null ? clipboard != null : !CLIPBOARD_EDEFAULT.equals(clipboard);
		case IUIBindingsPackage.MANAGER__OBSERVABLE_FACTORIES:
			return observableFactories != null && !observableFactories.isEmpty();
		case IUIBindingsPackage.MANAGER__QUICKFIX_PROPOSAL_PROCESSORS:
			return quickfixProposalProcessors != null && !quickfixProposalProcessors.isEmpty();
		case IUIBindingsPackage.MANAGER__CONTEXTS:
			return contexts != null && !contexts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (editingDomain: "); //$NON-NLS-1$
		result.append(editingDomain);
		result.append(", formToolkit: "); //$NON-NLS-1$
		result.append(formToolkit);
		result.append(", modelArgumentMediators: "); //$NON-NLS-1$
		result.append(modelArgumentMediators);
		result.append(", modelArgumentMediatorClasses: "); //$NON-NLS-1$
		result.append(modelArgumentMediatorClasses);
		result.append(", textCommitStrategy: "); //$NON-NLS-1$
		result.append(textCommitStrategy);
		result.append(", textCommitStrategyDelay: "); //$NON-NLS-1$
		result.append(textCommitStrategyDelay);
		result.append(", editCellAnyKey: "); //$NON-NLS-1$
		result.append(editCellAnyKey);
		result.append(", editCellSingleClick: "); //$NON-NLS-1$
		result.append(editCellSingleClick);
		result.append(", messageDecorationPosition: "); //$NON-NLS-1$
		result.append(messageDecorationPosition);
		result.append(", messageDecorationMinimumSeverity: "); //$NON-NLS-1$
		result.append(messageDecorationMinimumSeverity);
		result.append(", alternativeDecorationPosition: "); //$NON-NLS-1$
		result.append(alternativeDecorationPosition);
		result.append(", autoApplySingleQuickfix: "); //$NON-NLS-1$
		result.append(autoApplySingleQuickfix);
		result.append(", alternateRowColors: "); //$NON-NLS-1$
		result.append(alternateRowColors);
		result.append(", validationErrorsAreFatal: "); //$NON-NLS-1$
		result.append(validationErrorsAreFatal);
		result.append(", validationDelay: "); //$NON-NLS-1$
		result.append(validationDelay);
		result.append(", validationDelayWindow: "); //$NON-NLS-1$
		result.append(validationDelayWindow);
		result.append(", requiredVBImageDecorationShown: "); //$NON-NLS-1$
		result.append(requiredVBImageDecorationShown);
		result.append(", assistVBImageDecorationShown: "); //$NON-NLS-1$
		result.append(assistVBImageDecorationShown);
		result.append(", quickfixVBImageDecorationShown: "); //$NON-NLS-1$
		result.append(quickfixVBImageDecorationShown);
		result.append(", viewNavigationRecorded: "); //$NON-NLS-1$
		result.append(viewNavigationRecorded);
		result.append(", clipboard: "); //$NON-NLS-1$
		result.append(clipboard);
		result.append(')');
		return result.toString();
	}

	@Override
	public <T> T getService(Class<T> serviceClass) {
		for (final Object service : getServices()) {
			if (serviceClass.isInstance(service)) return (T) service;
		}
		return null;
	}

	@Override
	public void updateBindings(Object[] objects) {
		for (final IBindingContext c : getContexts()) {
			c.updateBindings(objects);
		}
	}

	@Override
	public boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event, IValueBindingCell cell) {
		Class<?> dataType = null;
		/*
		 * The tree column of a tree is special: mouse clicks does not work!
		 * 
		 * Otherwise, it will not be possible to click or double click on a item in the column to
		 * open and editor...
		 */
		boolean treeColumn = false;
		if (cell != null) {
			dataType = cell.getLabelBinding().getDataType().getDataType();
			final IColumnBinding column = cell.getColumnBinding();
			if (column != null) {
				final IViewerBinding vb = column.getViewerBinding();
				if (vb.getViewer() instanceof TreeViewer && (vb.getColumns().indexOf(column) == 0)) {
					treeColumn = true;
				}
			}
		}
		final boolean isBoolean = dataType == Boolean.class || dataType == Boolean.TYPE;
		switch (event.eventType) {
		case ColumnViewerEditorActivationEvent.TRAVERSAL:
			return true;
		case ColumnViewerEditorActivationEvent.MOUSE_CLICK_SELECTION:
			if (treeColumn) return false;
			/*
			 * Filter out the cases where a modifier - e.g. CTRL - has been pressed.
			 */
			final MouseEvent e = (MouseEvent) event.sourceEvent;
			if ((isEditCellSingleClick() || isBoolean) && (e.button == 1) && (e.stateMask == 0)) return true;
			return false;
		case ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION:
			if (treeColumn) return false;
			return true;
		case ColumnViewerEditorActivationEvent.KEY_PRESSED:
			if ((event.keyCode == SWT.CR || event.keyCode == SWT.F2) && (event.stateMask == 0)) return true;
			if (treeColumn) return false;
			if (isBoolean && (event.character == ' ')) return true;
			if (isEditCellAnyKey() && !isBoolean) {
				/*
				 * If auto-editing is enabled, every character - expect control characters - will
				 * start editing
				 */
				if (event.character != 0 && !Character.isISOControl(event.character)) return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Cache for {@link ITreeItemDescriptor} based on the {@link EObject}.
	 */
	private final Map<EObject, ITreeItemDescriptor> myTreeItemDescriptorCache = new HashMap<EObject, ITreeItemDescriptor>();

	@Override
	public ITreeItemDescriptor getTreeItem(EObject modelObject) {
		ITreeItemDescriptor descriptor = myTreeItemDescriptorCache.get(modelObject);
		if (descriptor != null) return descriptor;

		final Class<?>[] classes = Platform.getAdapterManager().computeClassOrder(modelObject.getClass());
		final Set<ITreeItemDescriptor> descriptors = new HashSet<ITreeItemDescriptor>();
		for (final Class<?> c : classes) {
			final String typeName = c.getName();
			for (final ITreeItemDescriptor d : getTreeItems()) {
				for (final String mt : d.getModelTypes()) {
					if (!mt.equals(typeName)) {
						continue;
					}
					descriptors.add(d);
				}
			}
			/*
			 * Depending on the numbe of found entries...
			 */
			switch (descriptors.size()) {
			case 0:
				continue;
			default:
				LogUtils.error(this, "Multiple ITreeItemDescriptors found for " + modelObject + ". Picking random."); //$NON-NLS-1$ //$NON-NLS-2$
				//$FALL-THROUGH$ fallthrough
			case 1:
				descriptor = descriptors.iterator().next();
				myTreeItemDescriptorCache.put(modelObject, descriptor);
				return descriptor;
			}
		}
		/*
		 * No descriptor found... Create one and put it into the cache
		 */
		return null;
	}

	@Override
	public ITreeItemDescriptor getTreeItem(String id) {
		for (final ITreeItemDescriptor d : getTreeItems()) {
			if (d.getId().equals(id)) return d;
		}
		return null;
	}
} // ManagerImpl
