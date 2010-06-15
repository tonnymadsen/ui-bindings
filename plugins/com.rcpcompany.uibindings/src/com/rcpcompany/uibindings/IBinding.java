package com.rcpcompany.uibindings;

import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.UpdateSetStrategy;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;
import com.rcpcompany.uibindings.utils.IBindingContextPersistence;

/**
 * <!-- begin-user-doc -->
 * <p>
 * The common binding attributes for values and columns.
 * </p>
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getContext <em>Context</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getState <em>State</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#isChangeable <em>Changeable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getCreationPoint <em>Creation Point</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getArguments <em>Arguments</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getType <em>Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getLabel <em>Label</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getStaticDataType <em>Static Data Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getDataType <em>Data Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getModelEType <em>Model EType</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getModelType <em>Model Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getUIType <em>UI Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getDBBindings <em>DB Bindings</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getMonitoredDBBindings <em>Monitored DB Bindings
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getErrorConditions <em>Error Conditions</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getWidget <em>Widget</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getControl <em>Control</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBinding#getExtraArgumentProviders <em>Extra Argument
 * Providers</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding()
 * @generated
 */
public interface IBinding extends IBaseObject, IArgumentProvider, IDisposable, Constants {
	/**
	 * Adds a new errors condition to the list of conditions already known for this binding.
	 * 
	 * @param error the new condition
	 */
	public void addErrorCondition(String error);

	/**
	 * Updates the binding.
	 */
	public void updateBinding();

	/**
	 * Updates the binding.
	 * 
	 * @param objects the changed objects or <code>null</code>
	 */
	public void updateBinding(Object[] objects);

	/**
	 * Sets the type of the binding. Defaults to the empty string.
	 * 
	 * @param type the type name
	 * @return <code>this</code>
	 */
	public IBinding type(String type);

	/**
	 * Sets an argument for the binding. Some arguments are deduced from the EMF binding.
	 * 
	 * @param name the argument name
	 * @param value the argument value
	 * 
	 * @return <code>this</code>
	 */
	public IBinding arg(String name, Object value);

	/**
	 * Sets a complete set of arguments for the binding.
	 * 
	 * @param arguments the arguments to set
	 * @return <code>this</code>
	 */
	public IBinding args(Map<String, Object> arguments);

	/**
	 * Sets a complete set of arguments for the binding.
	 * 
	 * @param arguments the arguments to set
	 * @return <code>this</code>
	 */
	public IBinding args(EMap<String, Object> arguments);

	/**
	 * Short for <code>arg(IBinding.ARG_READONLY, true)</code>.
	 * 
	 * @return <code>this</code>
	 */
	public IBinding readonly();

	/**
	 * Short for <code>arg({@link IBinding#ARG_DYNAMIC}, true)</code>.
	 * 
	 * @return <code>this</code>
	 */
	public IBinding dynamic();

	/**
	 * Short for <code>getId(id)</code>.
	 * 
	 * @param id the new id
	 * @return <code>this</code>
	 */
	public IBinding id(String id);

	/**
	 * Short for <code>arg({@link IBinding#ARG_LABEL}, label)</code>.
	 * 
	 * @param label the label to add
	 * @return <code>this</code>
	 */
	public IBinding label(String label);

	/**
	 * Short for <code>arg(IBinding.ARG_VALID_VALUES, list)</code>.
	 * 
	 * @param list the list of valid values
	 * 
	 * @return <code>this</code>
	 */
	public IBinding validValues(IObservableList list);

	/**
	 * This is the first phase of the finish process that will make the binding effective.
	 */
	public void finish1();

	/**
	 * This is the second phase of the finish process that will make the binding effective.
	 */
	public void finish2();

	/**
	 * This is the third phase of the finish process that will make the binding effective.
	 */
	public void finish3();

	/**
	 * Adds a new data bind to the set of bindings for this bound binding.
	 * 
	 * @param dataBinding the new data binding
	 * @param monitorStatus monitor the binding status
	 */
	public void addDBBinding(Binding dataBinding, boolean monitorStatus);

	/**
	 * See
	 * {@link DataBindingContext#bindList(IObservableList, IObservableList, UpdateListStrategy, UpdateListStrategy)}
	 * for a description.
	 * 
	 * @param monitorStatus monitor the binding status
	 */
	public void bindList(IObservableList targetObservableList, IObservableList modelObservableList,
			UpdateListStrategy targetToModel, UpdateListStrategy modelToTarget, boolean monitorStatus);

	/**
	 * See
	 * {@link DataBindingContext#bindSet(IObservableSet, IObservableSet, UpdateSetStrategy, UpdateSetStrategy)}
	 * for a description.
	 */
	public void bindSet(IObservableSet targetObservableSet, IObservableSet modelObservableSet,
			UpdateSetStrategy targetToModel, UpdateSetStrategy modelToTarget);

	/**
	 * See
	 * {@link DataBindingContext#bindValue(IObservableValue, IObservableValue, UpdateValueStrategy, UpdateValueStrategy)}
	 * for a description.
	 * 
	 * @param monitorStatus monitor the binding status
	 * 
	 * @return the databinding API binding object
	 */
	public Binding bindValue(IObservableValue targetObservableValue, IObservableValue modelObservableValue,
			UpdateValueStrategy targetToModel, UpdateValueStrategy modelToTarget, boolean monitorStatus);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference. It is bidirectional
	 * and its opposite is ' {@link com.rcpcompany.uibindings.IBindingContext#getBindings
	 * <em>Bindings</em>}'. <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(IBindingContext)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_Context()
	 * @see com.rcpcompany.uibindings.IBindingContext#getBindings
	 * @generated
	 */
	IBindingContext getContext();

	/**
	 * Returns the editing domain to use for all observables created for this binding.
	 * 
	 * @return the domain
	 */
	public EditingDomain getEditingDomain();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IBinding#getContext <em>Context</em>}
	 * ' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(IBindingContext value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute. The default value is
	 * <code>"INIT"</code>. The literals are from the enumeration
	 * {@link com.rcpcompany.uibindings.BindingState}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>State</em>' attribute.
	 * @see com.rcpcompany.uibindings.BindingState
	 * @see #setState(BindingState)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_State()
	 * @generated
	 */
	BindingState getState();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IBinding#getState <em>State</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see com.rcpcompany.uibindings.BindingState
	 * @see #getState()
	 * @generated
	 */
	void setState(BindingState value);

	/**
	 * Returns the value of the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Changeable</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_Changeable()
	 * @generated
	 */
	boolean isChangeable();

	/**
	 * Returns the value of the '<em><b>Creation Point</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The creation point specifies exactly where the specified binding has been created in terms of
	 * a {@link Throwable} with top stack entries.
	 * </p>
	 * <p>
	 * The number of entries in the stack trace is configurable. TODO
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creation Point</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_CreationPoint()
	 * @generated
	 */
	Throwable getCreationPoint();

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.Object}, <!--
	 * begin-user-doc -->
	 * <p>
	 * The returned map contains all the defined arguments for the binding.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Arguments</em>' map.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_Arguments()
	 * @generated
	 */
	EMap<String, Object> getArguments();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The id is used to identify the binding then data from the binding is persisted - see
	 * {@link IBindingContextPersistence}.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_Id()
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IBinding#getId <em>Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the named argument or <code>null</code> if not set.
	 * 
	 * @param name the name of the argument
	 * @return the value or <code>null</code> if not set.
	 */
	public Object getArgument(String name);

	/**
	 * Sets the specified arguments.
	 * 
	 * @param arguments the arguments to set - can be <code>null</code>
	 */
	public void setArguments(Map<String, Object> arguments);

	/**
	 * Returns the named argument or <code>null</code> if not set.
	 * <p>
	 * Will look for the argument among the arguments of the binding first and then among the
	 * annotations (declared arguments) of the data type.
	 * 
	 * @param <ArgumentType> the wanted argument type. Currently {@link String}, {@link Boolean} and
	 *            {@link Integer} is supported.
	 * 
	 * @param name the name of the argument
	 * @param argumentType the argument type of the wanted argument. Class value of
	 *            &lt;ArgumentType&gt;
	 * @param defaultValue the default value
	 * @return the value or <code>null</code> if not set.
	 */
	public <ArgumentType> ArgumentType getArgument(String name, Class<? extends ArgumentType> argumentType,
			ArgumentType defaultValue);

	/**
	 * Returns the named argument or <code>null</code> if not set.
	 * <p>
	 * Will look for the argument among the arguments of the binding first and then among the
	 * annotations (declared arguments) of the data type.
	 * 
	 * @param <ArgumentType> the wanted argument type
	 * 
	 * @param name the name of the argument
	 * @param argumentType the argument type of the wanted argument. Class value of
	 *            &lt;ArgumentType&gt;
	 * @param firstOnly if <code>true</code> only return the first found value, otherwise return all
	 *            found values
	 * @return the value or <code>null</code> if not set.
	 */
	public <ArgumentType> List<IArgumentValue<ArgumentType>> getArguments(String name,
			Class<? extends ArgumentType> argumentType, boolean firstOnly);

	/**
	 * Returns the named argument or <code>null</code> if not set.
	 * <p>
	 * Will look for the argument among the arguments of the binding first and then among the
	 * annotations (declared arguments) of the data type.
	 * 
	 * @param <ArgumentType> the wanted argument type
	 * 
	 * @param name the name of the argument
	 * @param ce the source configuration element or <code>null</code>
	 * @param attributeName the name of the attribute in ce
	 * @param value the value
	 * @param argumentType the argument type of the wanted argument. Class value of
	 *            &lt;ArgumentType&gt;
	 * @return the value or <code>null</code> if not set.
	 */
	public <ArgumentType> ArgumentType convertArgumentValue(String name, IConfigurationElement ce,
			String attributeName, String value, Class<? extends ArgumentType> argumentType);

	/**
	 * One argument value record as returned by
	 * 
	 * @param <ArgumentType> the wanted argument type
	 */
	public interface IArgumentValue<ArgumentType> {
		/**
		 * The source of the specific argument value.
		 * <p>
		 * In most cases, this is an {@link IArgumentProvider} object.
		 * 
		 * @return the source of the value - possibly in the form of an {@link IArgumentProvider}
		 */
		public Object getSource();

		/**
		 * The value returned by the source.
		 * 
		 * @return the value
		 */
		public ArgumentType getValue();
	}

	/**
	 * Handles any additions of arguments from {@link IArgumentProvider argument providers}.
	 * 
	 * @param <ArgumentType> the argument type
	 * @param results the result list
	 * @param name the name of the wanted argument
	 * @param provider the argument provider
	 * @param argumentType the argument type
	 * @param firstOnly <code>true</code> if only the first result is of interest
	 * @return <code>true</code> if ant results was found
	 */
	public <ArgumentType> boolean getArgumentProviderArguments(List<IArgumentValue<ArgumentType>> results, String name,
			IArgumentProvider provider, Class<? extends ArgumentType> argumentType, boolean firstOnly);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_Type()
	 * @generated
	 */
	String getType();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The label is calculated based on a
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_Label()
	 * @generated
	 */
	String getLabel();

	/**
	 * Returns the value of the '<em><b>Static Data Type</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Static Data Type</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_StaticDataType()
	 * @generated
	 */
	IBindingDataType getStaticDataType();

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * Returns the data type that forms the basis for the type data types of this binding.
	 * <p>
	 * For dynamic value bindings, this is based on the actual type of the current value. For all
	 * bindings it is based on the type of the static value - such as the feature or
	 * {@link IObservableValue}.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Data Type</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_DataType()
	 * @generated
	 */
	IBindingDataType getDataType();

	/**
	 * Returns the value of the '<em><b>Model EType</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model EType</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model EType</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_ModelEType()
	 * @generated
	 */
	EClassifier getModelEType();

	/**
	 * Returns the value of the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_ModelType()
	 * @generated
	 */
	Class<?> getModelType();

	/**
	 * Returns the value of the '<em><b>UI Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UI Type</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>UI Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_UIType()
	 * @generated
	 */
	Class<?> getUIType();

	/**
	 * Returns the value of the '<em><b>DB Bindings</b></em>' attribute list. The list contents are
	 * of type {@link org.eclipse.core.databinding.Binding}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DB Bindings</em>' attribute list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>DB Bindings</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_DBBindings()
	 * @generated
	 */
	EList<Binding> getDBBindings();

	/**
	 * Returns the value of the '<em><b>Monitored DB Bindings</b></em>' attribute list. The list
	 * contents are of type {@link org.eclipse.core.databinding.Binding}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitored DB Bindings</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Monitored DB Bindings</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_MonitoredDBBindings()
	 * @generated
	 */
	EList<Binding> getMonitoredDBBindings();

	/**
	 * Returns the value of the '<em><b>Error Conditions</b></em>' attribute list. The list contents
	 * are of type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Conditions</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Error Conditions</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_ErrorConditions()
	 * @generated
	 */
	EList<String> getErrorConditions();

	/**
	 * Returns the value of the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Widget</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_Widget()
	 * @generated
	 */
	Widget getWidget();

	/**
	 * Returns the value of the '<em><b>Control</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Control</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_Control()
	 * @generated
	 */
	Control getControl();

	/**
	 * Returns the value of the '<em><b>Extra Argument Providers</b></em>' reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.IArgumentProvider}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Extra Argument Providers</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Extra Argument Providers</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBinding_ExtraArgumentProviders()
	 * @generated
	 */
	EList<IArgumentProvider> getExtraArgumentProviders();

	/**
	 * Test an assertion and throws an exception if the assertion fails. The exception will include
	 * the {@link #getCreationPoint() creation point}.
	 * 
	 * @param b the test
	 * @param message the message of the exception
	 */
	void assertTrue(boolean b, String message);

	/**
	 * Updates the specified source provider state for this binding. Used in
	 * {@link BindingSourceProvider}.
	 * <p>
	 * All available state variables are found in {@link Constants} - e.g.
	 * {@link Constants#SOURCES_ACTIVE_BINDING}.
	 * <p>
	 * The method may return an {@link IObservableValue observable value} that must be monitored for
	 * changes. Whenever the value of the monitored observable value changes, the state is
	 * re-evaluated.
	 * 
	 * @param context TODO
	 */
	public void updateSourceProviderState(ISourceProviderStateContext context);
} // IBinding
