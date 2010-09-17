/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
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
	private ImageDescriptor myImageDescriptor = null;
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
			final ImageDescriptor descriptor = getImageDescriptor();
			if (descriptor != null) {
				myImage = descriptor.createImage();
			}
		}
		return myImage;
	}

	/**
	 * Returns the image descriptor for the holder object.
	 * 
	 * @return the image or <code>null</code>
	 */
	public ImageDescriptor getImageDescriptor() {
		if (myImageDescriptor == null) {
			final String imageName = myCE.getAttribute(myAttrName);
			if (imageName != null) {
				myImageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(myCE.getContributor().getName(),
						imageName);
			}
		}
		return myImageDescriptor;
	}
}
