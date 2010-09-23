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
package com.rcpcompany.uibindings.internal.observables;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TreeColumn;

import com.rcpcompany.uibindings.Constants;

/**
 * 
 */
public class ItemObservableValue extends AbstractSWTObservableValue {

	private final Item item;
	private final String attribute;
	private Object valueType;

	private static final Map<String, Object> SUPPORTED_ATTRIBUTES = new HashMap<String, Object>();
	static {
		SUPPORTED_ATTRIBUTES.put(Constants.ATTR_TEXT, String.class);
		SUPPORTED_ATTRIBUTES.put(Constants.ATTR_IMAGE, Image.class);
		SUPPORTED_ATTRIBUTES.put(Constants.ATTR_TOOLTIP, String.class);
		SUPPORTED_ATTRIBUTES.put(Constants.ATTR_ALIGNMENT, Integer.TYPE);
		SUPPORTED_ATTRIBUTES.put(Constants.ATTR_ENABLED, Boolean.TYPE);
		SUPPORTED_ATTRIBUTES.put(Constants.ATTR_WIDTH, Integer.TYPE);
	}

	/**
	 * @param item
	 * @param attribute
	 */
	public ItemObservableValue(Item item, String attribute) {
		super(item);
		this.item = item;
		if ("".equals(attribute)) {
			attribute = Constants.ATTR_TEXT;
		}
		this.attribute = attribute;
		if (SUPPORTED_ATTRIBUTES.containsKey(attribute)) {
			valueType = SUPPORTED_ATTRIBUTES.get(attribute);
		} else
			throw new IllegalArgumentException("Attribute '" + attribute + "' not supported");
	}

	@Override
	public void doSetValue(Object value) {
		final Object oldValue = doGetValue();
		if (attribute.equals(Constants.ATTR_IMAGE)) {
			item.setImage((Image) value);
		} else if (attribute.equals(Constants.ATTR_TEXT)) {
			item.setText((String) value);
		} else if (attribute.equals(Constants.ATTR_TOOLTIP)) {
			if (item instanceof TableColumn) {
				((TableColumn) item).setToolTipText((String) value);
			}
			if (item instanceof TreeColumn) {
				((TreeColumn) item).setToolTipText((String) value);
			}
			if (item instanceof ToolItem) {
				((ToolItem) item).setToolTipText((String) value);
			}
			if (item instanceof TabItem) {
				((TabItem) item).setToolTipText((String) value);
			}
		} else if (attribute.equals(Constants.ATTR_ALIGNMENT)) {
			if (item instanceof TableColumn) {
				((TableColumn) item).setAlignment((Integer) value);
			}
			if (item instanceof TreeColumn) {
				((TreeColumn) item).setAlignment((Integer) value);
			}
		} else if (attribute.equals(Constants.ATTR_WIDTH)) {
			if (item instanceof TableColumn) {
				((TableColumn) item).setWidth((Integer) value);
			}
			if (item instanceof TreeColumn) {
				((TreeColumn) item).setWidth((Integer) value);
			}
			if (item instanceof ToolItem) {
				((ToolItem) item).setWidth((Integer) value);
			}
		} else if (attribute.equals(Constants.ATTR_ENABLED)) {
			if (item instanceof ToolItem) {
				((ToolItem) item).setEnabled(value == Boolean.TRUE);
			}
		}
		fireValueChange(Diffs.createValueDiff(oldValue, value));
	}

	@Override
	public Object doGetValue() {
		if (attribute.equals(Constants.ATTR_TEXT)) return item.getText();
		if (attribute.equals(Constants.ATTR_IMAGE)) return item.getImage();
		if (attribute.equals(Constants.ATTR_TOOLTIP)) {
			if (item instanceof TableColumn) return ((TableColumn) item).getToolTipText();
			if (item instanceof TreeColumn) return ((TreeColumn) item).getToolTipText();
			if (item instanceof ToolItem) return ((ToolItem) item).getToolTipText();
			if (item instanceof TabItem) return ((TabItem) item).getToolTipText();
		}
		if (attribute.equals(Constants.ATTR_ALIGNMENT)) {
			if (item instanceof TableColumn) return ((TableColumn) item).getAlignment();
			if (item instanceof TreeColumn) return ((TreeColumn) item).getAlignment();
		}
		if (attribute.equals(Constants.ATTR_WIDTH)) {
			if (item instanceof TableColumn) return ((TableColumn) item).getWidth();
			if (item instanceof TreeColumn) return ((TreeColumn) item).getWidth();
			if (item instanceof ToolItem) return ((ToolItem) item).getWidth();
		}
		if (attribute.equals(Constants.ATTR_ENABLED)) {
			if (item instanceof ToolItem) return ((ToolItem) item).getEnabled();
		}

		return null;
	}

	@Override
	public Object getValueType() {
		return valueType;
	}
}
