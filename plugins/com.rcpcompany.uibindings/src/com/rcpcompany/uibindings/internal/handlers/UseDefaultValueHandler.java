package com.rcpcompany.uibindings.internal.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.ui.ISourceProviderListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Handler for the command <code>com.rcpcompany.uibindings.commands.UseDefaultValue</code>.
 * <p>
 * Keeps track of the current binding and updates the state appropriately.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UseDefaultValueHandler extends AbstractHandler implements IHandler, IElementUpdater {

	/**
	 * The binding source provider...
	 */
	private final BindingSourceProvider myProvider;

	/**
	 * The current "checked" state of the handler.
	 */
	private boolean myUnset = false;

	/**
	 * Listener that tracks the {@link EObject#eIsSet(org.eclipse.emf.ecore.EStructuralFeature)}
	 * state of the current binding when {@link Constants#SOURCES_ACTIVE_BINDING_UNSETTABLE} is
	 * <code>true</code>.
	 */
	private final ISourceProviderListener myProviderListener = new ISourceProviderListener() {

		@Override
		public void sourceChanged(int sourcePriority, String sourceName, Object sourceValue) {
			if (sourceName.equals(Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE)) {
				updateUnset();
			}
		}

		@Override
		public void sourceChanged(int sourcePriority, Map sourceValuesByName) {
			if (sourceValuesByName.containsKey(Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE)) {
				updateUnset();
			}
		}
	};

	/**
	 * The global command service.
	 */
	private final ICommandService myCommandService;

	/**
	 * Constructs and returns a new handler.
	 */
	public UseDefaultValueHandler() {
		final IServiceLocator locator = PlatformUI.getWorkbench();

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);
		myCommandService = (ICommandService) locator.getService(ICommandService.class);

		myProvider = (BindingSourceProvider) sourceProviders.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);

		myProvider.addSourceProviderListener(myProviderListener);
	}

	/**
	 * Calculates any new {@link #myUnset}.
	 */
	protected void updateUnset() {
		final Map<String, Object> currentState = myProvider.getCurrentState();
		final Object b = currentState.get(Constants.SOURCES_ACTIVE_BINDING);
		if (!(b instanceof IValueBinding)) {
			setUnset(false);
			return;
		}
		final IValueBinding binding = (IValueBinding) b;
		final Boolean unsettable = (Boolean) currentState.get(Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE);
		if (!unsettable) {
			setUnset(false);
			return;
		}

		final EObject obj = binding.getModelObject();
		final EStructuralFeature feature = binding.getModelFeature();
		if (obj == null || feature == null) {
			setUnset(false);
			return;
		}

		setUnset(!obj.eIsSet(feature));
	}

	/**
	 * Sets the new value of {@link #myUnset}.
	 * 
	 * @param newState the new state
	 */
	protected void setUnset(boolean newState) {
		if (myUnset == newState) return;
		myUnset = newState;
		myCommandService.refreshElements(Constants.USE_DEFAULT_TOGGLE_COMMAND, null);
	}

	@Override
	public void dispose() {
		myProvider.removeSourceProviderListener(myProviderListener);
		super.dispose();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}

		final IValueBinding binding = (IValueBinding) HandlerUtil.getVariableChecked(event,
				Constants.SOURCES_ACTIVE_BINDING);
		final Boolean unsettable = (Boolean) HandlerUtil.getVariableChecked(event,
				Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE);
		if (binding == null || !unsettable) return null;

		final EObject obj = binding.getModelObject();
		final EStructuralFeature feature = binding.getModelFeature();
		if (obj == null || feature == null) return null;

		final Command command = new ChangeCommand(obj) {
			@Override
			protected void doExecute() {
				if (obj.eIsSet(feature)) {
					obj.eUnset(feature);
				} else {
					obj.eSet(feature, obj.eGet(feature));
				}
			}
		};
		binding.getEditingDomain().getCommandStack().execute(command);
		updateUnset();

		return null;
	}

	@Override
	public void updateElement(UIElement element, Map parameters) {
		element.setChecked(myUnset);
	}
}
