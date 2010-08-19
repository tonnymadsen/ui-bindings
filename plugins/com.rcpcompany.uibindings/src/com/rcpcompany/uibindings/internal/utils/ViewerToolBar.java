package com.rcpcompany.uibindings.internal.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.CommandEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.ICommandListener;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.SerializationException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.commands.ICommandImageService;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IViewerToolBar;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link IViewerToolBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerToolBar implements IViewerToolBar, IDisposable {
	/**
	 * The viewer of this toolbar.
	 */
	private final IViewerBinding myViewer;

	/**
	 * The style of this toolbar.
	 */
	private final int myStyle;

	public ViewerToolBar(IViewerBinding viewer, int style) {
		myViewer = viewer;
		myStyle = style;

		// TODO: Check style

		myViewer.registerService(this);

		final IManager manager = IManager.Factory.getManager();
		myToolkit = manager.getFormToolkit();

		final IServiceLocator serviceLocator = getViewer().getContext().getServiceLocator();
		myCommandService = (ICommandService) serviceLocator.getService(ICommandService.class);
		myHandlerService = (IHandlerService) serviceLocator.getService(IHandlerService.class);
		myCommandImageService = (ICommandImageService) serviceLocator.getService(ICommandImageService.class);

		/*
		 * Find the control of the viewer (a Table or Tree).
		 * 
		 * Find the parent Composite.
		 * 
		 * Add a new Composite (with a GridLayout) and reparent the control
		 * 
		 * Then add the toolbar itself on the correct side of the control
		 */
		final Control control = myViewer.getViewer().getControl();
		final Composite parent = control.getParent();

		myComposite = myToolkit.createComposite(parent);
		myComposite.setLayoutData(control.getLayoutData());
		final GridLayout compLayout = new GridLayout(1, false);
		myComposite.setLayout(compLayout);

		control.setParent(myComposite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		myToolBar = new ToolBar(myComposite, SWT.FLAT | (style & (VERTICAL | HORIZONTAL)));
		if ((style & VERTICAL) != 0) {
			myToolBar.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, false));
			compLayout.numColumns = 2;
		} else {
			myToolBar.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
		}
		/*
		 * Inlined from FormToolkit.adapt(Composite composite). Do not set focus though.
		 */
		myToolBar.setBackground(myComposite.getBackground());
		myToolBar.setMenu(myComposite.getMenu());

		myViewer.registerWidget(myToolBar);

		/*
		 * Add standard items
		 */
		if ((style & ADD) != 0) {
			// addItem(ADD, "");
		}
		if ((style & DELETE) != 0) {
			addItem(DELETE, "org.eclipse.ui.edit.delete");
		}
		if ((style & UP) != 0) {
			addItem(UP, "com.rcpcompany.uibindings.commands.moveItemUp");
		}
		if ((style & DOWN) != 0) {
			addItem(DOWN, "com.rcpcompany.uibindings.commands.moveItemDown");
		}

		myComposite.layout(true);
	}

	@Override
	public void dispose() {
		myViewer.unregisterService(this);
		if (myToolBar != null && !myToolBar.isDisposed()) {
			myViewer.unregisterWidget(myToolBar);
			myToolBar.dispose();
		}
	}

	public static IViewerToolBar addToolBar(IViewerBinding viewer, int style) {
		IViewerToolBar bb = viewer.getService(IViewerToolBar.class);
		if (bb != null) return bb;

		bb = new ViewerToolBar(viewer, style);

		return bb;
	}

	private static Image getImage(String path) {
		final ImageRegistry imageRegistry = Activator.getDefault().getImageRegistry();
		if (imageRegistry.getDescriptor(path) == null) {
			imageRegistry.put(path, AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID, path));
		}
		return imageRegistry.get(path);

	}

	private final Composite myComposite;

	private final ToolBar myToolBar;

	@Override
	public IViewerBinding getViewer() {
		return myViewer;
	}

	@Override
	public int getStyle() {
		return myStyle;
	}

	@Override
	public ToolBar getToolBar() {
		return myToolBar;
	}

	private final Map<Integer, ToolItem> myItems = new HashMap<Integer, ToolItem>();

	private final ICommandService myCommandService;

	private final IHandlerService myHandlerService;

	private final ICommandImageService myCommandImageService;

	private final FormToolkit myToolkit;

	@Override
	public void addItem(int id, String commandId) {
		final ToolItemCommandAdapter a = new ToolItemCommandAdapter(commandId);
		addItem(id, a.getItem());
	}

	/**
	 * Mapping of keys to images... An image can be <code>null</code>.
	 */
	private static final Map<String, Image> TOOLBAR_IMAGES = new HashMap<String, Image>();

	/**
	 * Returns the mapping of keys to images... An image can be <code>null</code>.
	 * 
	 * @return the map
	 */
	private Map<String, Image> getToolBarImages() {
		return TOOLBAR_IMAGES;
	}

	/**
	 * An adapter for Commands to TiilItem.
	 */
	private class ToolItemCommandAdapter implements Listener, ICommandListener {
		private final String myCommandId;
		private final ToolItem myItem;
		private ParameterizedCommand myCommand = null;

		/**
		 * The {@link ToolBar} item for this adapter.
		 * 
		 * @return the item
		 */
		public ToolItem getItem() {
			return myItem;
		}

		public ToolItemCommandAdapter(String commandId) {
			myCommandId = commandId;
			myItem = new ToolItem(getToolBar(), SWT.PUSH);
			try {
				myCommand = myCommandService.deserialize(commandId);
				myCommand.getCommand().addCommandListener(this);

				myItem.setImage(getImage(ICommandImageService.TYPE_DEFAULT));
				myItem.setDisabledImage(getImage(ICommandImageService.TYPE_DISABLED));
				myItem.setHotImage(getImage(ICommandImageService.TYPE_HOVER));

				commandChanged(null);
			} catch (final NotDefinedException ex) {
				LogUtils.error(this, ex);
			} catch (final SerializationException ex) {
				LogUtils.error(this, ex);
			}

			myItem.addListener(SWT.Dispose, this);
			myItem.addListener(SWT.Selection, this);
		}

		private void dispose() {
			myCommand.getCommand().removeCommandListener(this);
		}

		@Override
		public void handleEvent(Event event) {
			switch (event.type) {
			case SWT.Selection:
				try {
					myHandlerService.executeCommand(myCommand, event);
				} catch (final ExecutionException ex) {
					LogUtils.error(this, ex);
				} catch (final NotDefinedException ex) {
					LogUtils.error(this, ex);
				} catch (final NotEnabledException ex) {
					LogUtils.error(this, ex);
				} catch (final NotHandledException ex) {
					LogUtils.error(this, ex);
				}
				break;
			case SWT.Dispose:
				dispose();
				break;
			default:
				break;
			}
		}

		/**
		 * Returns the specified type of image.
		 * <p>
		 * All images are registered in the image registry of the {@link Activator}.
		 * 
		 * @param type either {@link ICommandImageService#TYPE_DEFAULT} or
		 *            {@link ICommandImageService#TYPE_DISABLED}
		 * @return the image
		 */
		private Image getImage(int type) {
			String key = myCommandId;
			switch (type) {
			case ICommandImageService.TYPE_DEFAULT:
				key += "-default";
				break;
			case ICommandImageService.TYPE_DISABLED:
				key += "-disabled";
				break;
			case ICommandImageService.TYPE_HOVER:
				key += "-hover";
				break;
			default:
				LogUtils.error(this, "Unknown type: " + type);
				break;
			}
			if (getToolBarImages().containsKey(key)) return getToolBarImages().get(key);

			final ImageDescriptor id = myCommandImageService.getImageDescriptor(myCommandId, type,
					ICommandImageService.IMAGE_STYLE_TOOLBAR);
			if (id == null) {
				getToolBarImages().put(key, null);
				return null;
			}
			final ImageRegistry imageRegistry = Activator.getDefault().getImageRegistry();
			imageRegistry.put(key, id);
			final Image image = imageRegistry.get(key);

			TOOLBAR_IMAGES.put(key, image);
			return image;
		}

		@Override
		public void commandChanged(CommandEvent commandEvent) {
			myItem.setEnabled(myCommand.getCommand().isEnabled());
			try {
				myItem.setToolTipText(myCommand.getCommand().getDescription());
			} catch (final NotDefinedException ex) {
				LogUtils.error(this, ex);
			}
		}
	}

	@Override
	public void addItem(int id, ToolItem item) {
		if (item.getParent() != myToolBar) {
			LogUtils.error(this, "Item does nopt have the correct toolbar as parent. Disposed.");
			item.dispose();
			return;
		}
		if (myItems.containsKey(id)) {
			LogUtils.error(this, "item ID " + id + " already used. Item Disposed.");
			item.dispose();
			return;
		}

		myItems.put(id, item);
	}

	@Override
	public ToolItem getItem(int id) {
		return myItems.get(id);
	}
}
