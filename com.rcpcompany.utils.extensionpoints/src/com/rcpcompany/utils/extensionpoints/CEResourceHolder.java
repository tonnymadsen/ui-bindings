/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.extensionpoints;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

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
	 * @param ce
	 *            the configuration element
	 */
	public CEResourceHolder(IConfigurationElement ce) {
		this(ce, "image");
	}

	/**
	 * Constructs and returns a new holder object for the specified configuration element.
	 * 
	 * @param ce
	 *            the configuration element
	 * @param attrName
	 *            the attribute name
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
			if (imageName == null)
				return null;
			final Bundle bundle = Platform.getBundle(myCE.getContributor().getName());
			URL url = FileLocator.find(bundle, new Path(imageName), null);
			if (url == null) {
				try {
					url = new URL(imageName);
				} catch (final MalformedURLException e) {
					return null;
				}

			}
			if (url == null)
				return null;

			myImageDescriptor = ImageDescriptor.createFromURL(url);
			;

		}
		return myImageDescriptor;
	}
}
