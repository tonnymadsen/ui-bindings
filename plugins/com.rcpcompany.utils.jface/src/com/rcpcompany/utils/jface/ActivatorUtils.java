package com.rcpcompany.utils.jface;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Utility function for use in activators.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ActivatorUtils {
	/**
	 * Adds a single image to JFaceResources.
	 * 
	 * @param name
	 *            the name of the image
	 * @param id
	 *            the id of the plug-in
	 * @param image
	 *            the image name including the extension
	 */
	public static void addImage(final String name, final String id,
			final String image) {
		asyncExec(new Runnable() {
			public void run() {
				ImageRegistry ir = JFaceResources.getImageRegistry();
				ir.put(name, AbstractUIPlugin.imageDescriptorFromPlugin(id,
						image));
			}
		});
	}

	/**
	 * Removes a single image from JFaceResources.
	 * 
	 * @param name
	 *            the name of the image
	 */
	public static void removeImage(final String name) {
		asyncExec(new Runnable() {
			public void run() {
				ImageRegistry ir = JFaceResources.getImageRegistry();
				ir.remove(name);
			}
		});
	}

	/**
	 * The same as {@link Display#asyncExec(Runnable)}, only that
	 * <ul>
	 * <li>it is intelligent about how to get a Display,</li>
	 * <li>and if the current thread is the event thread, the runnable is
	 * executed immediately.</li>
	 * </ul>
	 * <p>
	 * This method is safe to use even in activators.
	 * 
	 * @param runnable
	 *            the runnable
	 */
	public static void asyncExec(Runnable runnable) {
		Display current = getDisplay();

		if (current.getThread() == Thread.currentThread()) {
			runnable.run();
		} else {
			current.asyncExec(runnable);
		}
	}

	/**
	 * Returns the current display. Creates a new display using
	 * {@link PlatformUI}, if no current display exist.
	 * 
	 * @return the display
	 */
	public static Display getDisplay() {
		Display current = Display.getCurrent();
		if (current == null) {
			current = PlatformUI.createDisplay();
		}
		return current;
	}

	/**
	 * Computes and returns the ID for the Activator.
	 * <p>
	 * Assumes that the activator is either in...
	 * 
	 * @param clazz
	 *            the activator class
	 * @return the ID
	 */
	public static String getID(Class<? extends Plugin> clazz) {
		String id = clazz.getPackage().getName();
		if (id.endsWith(".internal")) { //$NON-NLS-1$
			id = id.substring(0, id.indexOf(".internal")); //$NON-NLS-1$
		}
		return id;
	}

}
