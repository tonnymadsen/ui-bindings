package com.rcpcompany.utils.extensionpoints;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Simple holder pattern for images in the extension registry.
 * <p>
 * Used to hold a reference to a resource that is created via the extension registry.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CEResourceHolder {
	private final IConfigurationElement myCE;
	private Image myImage = null;
	private final String myAttrName;

	/**
	 * Constructs and returns a new holder object for the specified configuration element.
	 * <p>
	 * Short for <code>CEObjectHolder(ce, "image")</code>
	 * 
	 * @param ce the configuration element
	 */
	public CEResourceHolder(IConfigurationElement ce) {
		this(ce, "image");
	}

	/**
	 * Constructs and returns a new holder object for the specified configuration element.
	 * 
	 * @param ce the configuration element
	 * @param attrName the attribute name
	 */
	public CEResourceHolder(IConfigurationElement ce, String attrName) {
		myCE = ce;
		myAttrName = attrName;
	}

	/**
	 * Returns the image for the holder object.
	 * 
	 * @return the image or <code>null</code>
	 */
	public Image getImage() {
		if (myImage == null) {
			final ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(myCE.getContributor()
					.getName(), myCE.getAttribute(myAttrName));
			myImage = descriptor.createImage();
		}
		return myImage;
	}
}
