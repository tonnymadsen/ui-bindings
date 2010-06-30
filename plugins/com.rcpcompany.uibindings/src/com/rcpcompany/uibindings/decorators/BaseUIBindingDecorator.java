package com.rcpcompany.uibindings.decorators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.ObservableTracker;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.util.Policy;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.internal.databinding.BindingMessages;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeImageDecoration;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl;
import com.rcpcompany.uibindings.internal.observables.DelayedChangeEvent;
import com.rcpcompany.uibindings.internal.observables.IDelayedChangeListener;
import com.rcpcompany.uibindings.internal.observables.IDelayedChangeObservable;
import com.rcpcompany.uibindings.internal.utils.MyEMFUpdateValueStrategy;
import com.rcpcompany.uibindings.observables.MessageFormatObservableValue;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This is an abstract implementation of {@link IUIBindingDecorator} used to isolate implementations
 * of the interface from backward extensions of the interface.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BaseUIBindingDecorator extends UIBindingDecoratorImpl {

	/**
	 * The observable value for the display value.
	 */
	private IObservableValue myDisplayValue = null;

	/**
	 * The observable value for the display value if not the same as the model value. Disposed when
	 * the decorator is disposed.
	 */
	private IObservableValue myDisposeDisplayValue = null;

	/**
	 * The change listener for the display value. Removed when the decorator is disposed.
	 */
	private IChangeListener myDisposeDisplayChangeListener = null;

	/**
	 * Listener used to trigger an update of the UIToModel strategy, in case, the valid UI List
	 * changes.
	 */
	private IChangeListener myUIListChangeListener = null;

	/**
	 * Change listener for the current value if set.
	 */
	protected IValueChangeListener myValueChangeListener;

	/**
	 * DelayedChange listener for the current value, if set.
	 */
	protected IDelayedChangeListener myDelayedChangeListener = null;

	private FocusListener myFocusOutListener;

	/**
	 * Common Identity update strategy. Saves lots of identical objects.
	 */
	protected static final UpdateValueStrategy IDENTITY_UPDATE_STRATEGY = new UpdateValueStrategy(false,
			UpdateValueStrategy.POLICY_UPDATE);

	/**
	 * Common Identity update strategy. Saves lots of identical objects.
	 */
	protected static final UpdateValueStrategy IDENTITY_NEVER_UPDATE_STRATEGY = new UpdateValueStrategy(false,
			UpdateValueStrategy.POLICY_NEVER);

	@Override
	public void init(IValueBinding binding) {
		setBinding(binding);
	}

	@Override
	public void dispose() {
		if (myDisposeDisplayChangeListener != null) {
			myDisplayValue.removeChangeListener(myDisposeDisplayChangeListener);
			myDisposeDisplayChangeListener = null;
		}
		if (myDisposeDisplayValue != null) {
			myDisposeDisplayValue.dispose();
			myDisposeDisplayValue = null;
		}

		if (myUIListChangeListener != null) {
			getValidUIList().removeChangeListener(myUIListChangeListener);
			myUIListChangeListener = null;
		}
		final IUIAttribute uiAttribute = getBinding().getUIAttribute();
		if (uiAttribute != null) {
			final IObservableValue currentValue = uiAttribute.getCurrentValue();
			if (myValueChangeListener != null) {
				currentValue.removeValueChangeListener(myValueChangeListener);
			}
			if (myDelayedChangeListener != null) {
				((IDelayedChangeObservable) currentValue).removeDelayedChangeListener(myDelayedChangeListener);
			}
		}
		if (myFocusOutListener != null) {
			getBinding().getControl().removeFocusListener(myFocusOutListener);
			myFocusOutListener = null;
		}
		if (myFormattedValue != null) {
			myFormattedValue.dispose();
			myFormattedValue = null;
		}
		myDisplayValue = null;
		myDecoratedValue = null;
		setBinding(null);
	}

	@Override
	public IValueBinding getBinding() {
		return super.getBinding();
	}

	@Override
	public boolean isChangeable() {
		return super.isChangeable();
	}

	protected IObservableList myValidUIList = null;
	protected boolean calculatedValidUIList = false;

	@Override
	public IObservableList getValidUIList() {
		if (getBinding() == null) return null;
		if (!calculatedValidUIList) {
			myValidUIList = getBinding().getArgument(Constants.ARG_VALID_VALUES, IObservableList.class, null);
			calculatedValidUIList = true;
		}

		return myValidUIList;
	}

	@Override
	public IConverter getModelToUIConverter() {
		return null;
	}

	@Override
	public IValidator getUIToModelAfterConvertValidator() {
		return null;
	}

	@Override
	public IConverter getUIToModelConverter() {
		return null;
	}

	@Override
	public void decorate() {
		final IValueBinding binding = getBinding();
		final Control control = binding.getControl();
		final IUIAttribute attribute = binding.getUIAttribute();

		final IObservableValue modelValue = binding.getModelObservableValue();

		final UpdateValueStrategy modelToUIUpdateStrategy = new MyEMFUpdateValueStrategy(false,
				UpdateValueStrategy.POLICY_UPDATE);
		modelToUIUpdateStrategy.setConverter(getModelToUIConverter());

		/*
		 * Must be called before the binding to insure the internals of the decorator is properly
		 * setup...
		 */
		final IObservableList decoratorUIList = getValidUIList();

		// TODO TMTM Move
		final boolean changeable = getBinding().isChangeable();
		UpdateValueStrategy uiToModelUpdateStrategy;
		if (changeable) {
			uiToModelUpdateStrategy = new MyEMFUpdateValueStrategy(UpdateValueStrategy.POLICY_ON_REQUEST);

			final IConverter converter = getUIToModelConverter();
			if (converter != null) {
				uiToModelUpdateStrategy.setAfterGetValidator(new IValidator() {
					@Override
					public IStatus validate(Object value) {
						try {
							converter.convert(value);
						} catch (final IllegalArgumentException ex) {
							return ValidationStatus.error(ex.getMessage());
						}
						return Status.OK_STATUS;
					}
				});
				uiToModelUpdateStrategy.setConverter(converter);
			}
			uiToModelUpdateStrategy.setAfterConvertValidator(getUIToModelAfterConvertValidator());

			if (binding.getDataType().isRequired() || binding.getArgument(Constants.ARG_REQUIRED, Boolean.class, false)) {
				uiToModelUpdateStrategy.setBeforeSetValidator(new IValidator() {
					@Override
					public IStatus validate(Object value) {
						if (value == null || "".equals(value)) return ValidationStatus.error("Value is required"); //$NON-NLS-1$
						return Status.OK_STATUS;
					}
				});
			}
		} else {
			uiToModelUpdateStrategy = IDENTITY_NEVER_UPDATE_STRATEGY;

			if (attribute.isChangeable() && control != null) {
				if (control instanceof Button) {
					if (control.isEnabled()) {
						getBinding().addErrorCondition("Binding cannot be changed, but widget is enabled"); //$NON-NLS-1$
						control.setEnabled(false);
					}
				} else {
					if ((control.getStyle() & SWT.READ_ONLY) != SWT.READ_ONLY) {
						getBinding().addErrorCondition(
								"Binding cannot be changed, but widget does not have style SWT.READ_ONLY"); //$NON-NLS-1$
						control.setEnabled(false);
					}
				}
			}
		}

		/*
		 * Bind the list of possible values...
		 */
		final IObservableList attributeUIList = attribute.getPossibleValuesList();

		if (attributeUIList != null && decoratorUIList != null) {
			binding.bindList(attributeUIList, decoratorUIList, null, null, false);
		}

		/*
		 * Then bind the value
		 * 
		 * Note that if we have to do two bindings, then we need to bind the model side first as the
		 * ui side will otherwise always be null the first time, which may not be a valid value
		 */
		final IObservableValue uiAttributeValue = attribute.getCurrentValue();
		myDecoratedValue = null;
		final Binding uiToDecoratedDB;
		if (uiAttributeValue.getValueType() == String.class) {
			myDecoratedValue = WritableValue.withValueType(String.class);
			myDecoratedValue.setValue(""); //$NON-NLS-1$
			myFormattedValue = new MessageFormatObservableValue(myDecoratedValue, null);
			uiToDecoratedDB = binding.bindValue(uiAttributeValue, myFormattedValue, IDENTITY_UPDATE_STRATEGY,
					IDENTITY_UPDATE_STRATEGY, false);
		} else {
			myDecoratedValue = uiAttributeValue;
			uiToDecoratedDB = null;
		}
		final Binding decoratedToModelDB = new MyValueBinding(myDecoratedValue, modelValue, uiToModelUpdateStrategy,
				modelToUIUpdateStrategy);
		decoratedToModelDB.init(binding.getContext().getDbContext());
		binding.addDBBinding(decoratedToModelDB, true);

		/*
		 * Changes are updated directly...
		 */
		if (changeable) {
			myValueChangeListener = new IValueChangeListener() {
				@Override
				public void handleValueChange(ValueChangeEvent event) {
					final Object oldValue = event.diff.getOldValue();
					final Object newValue = event.diff.getNewValue();
					if (oldValue == newValue) return;
					if (oldValue != null && oldValue.equals(newValue)) return;
					if (uiToDecoratedDB != null) {
						uiToDecoratedDB.updateTargetToModel();
					}
					decoratedToModelDB.updateTargetToModel();
				}
			};
			uiAttributeValue.addValueChangeListener(myValueChangeListener);

			if (control != null) {
				myFocusOutListener = new FocusListener() {
					@Override
					public void focusLost(FocusEvent e) {
						control.getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								if (control.isDisposed()) return;
								binding.updateUI();
							}
						});
					}

					@Override
					public void focusGained(FocusEvent e) {

					}
				};
				control.addFocusListener(myFocusOutListener);
			}
		}

		/*
		 * If the UI observable supports delayed changes, then validate the value. Used by
		 * TextObservableValue.
		 */
		if (changeable && (uiAttributeValue instanceof IDelayedChangeObservable)) {
			myDelayedChangeListener = new IDelayedChangeListener() {
				@Override
				public void handleDelayedChange(DelayedChangeEvent staleEvent) {
					if (uiToDecoratedDB != null) {
						uiToDecoratedDB.updateTargetToModel();
					}
					decoratedToModelDB.validateTargetToModel();
				}
			};
			((IDelayedChangeObservable) uiAttributeValue).addDelayedChangeListener(myDelayedChangeListener);
		}

		/*
		 * If the decoration is changeable AND a valid UI List exists for the decoration, then make
		 * sure the databinding is updated when changes are made to list
		 * 
		 * TODO TEST and separate method
		 */
		if (changeable && decoratorUIList != null) {
			myUIListChangeListener = new IChangeListener() {
				@Override
				public void handleChange(ChangeEvent event) {
					decoratedToModelDB.updateModelToTarget();
					runExtenders();
				}
			};
			decoratorUIList.addChangeListener(myUIListChangeListener);
		}

		myDisplayValue = getDisplayObservableValue(modelValue);
		if (myDisplayValue != modelValue) {
			myDisposeDisplayValue = myDisplayValue;
			myDisposeDisplayChangeListener = new IChangeListener() {
				@Override
				public void handleChange(ChangeEvent event) {
					// TODO See if we can prevent the update from happening multiple times...
					decoratedToModelDB.updateModelToTarget();
					runExtenders();
				}
			};
			myDisplayValue.addChangeListener(myDisposeDisplayChangeListener);
		} else {
			myDisposeDisplayChangeListener = new IChangeListener() {
				@Override
				public void handleChange(ChangeEvent event) {
					runExtenders();
				}
			};
			myDisplayValue.addChangeListener(myDisposeDisplayChangeListener);
		}

		/*
		 * Bind more...
		 */
		decorateMisc();
		decorateAssist();

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				runExtenders();
			}
		});
	}

	/**
	 * Decorates the binding with misc things like help, tooltip, etc.
	 */
	public void decorateMisc() {
		final IValueBinding binding = getBinding();
		final Control control = binding.getControl();

		/**
		 * The following is only relevant if an control exists!
		 */
		if (control != null) {
			// bind help ID
			String value;
			value = binding.getArgument(Constants.ARG_HELP_ID, String.class, null);
			if (value != null) {
				PlatformUI.getWorkbench().getHelpSystem().setHelp(control, value);
			}

			// bind tool tip
			value = binding.getArgument(Constants.ARG_TOOL_TIP_TEXT, String.class, null);
			if (value != null) {
				control.setToolTipText(value);
			}
		}
	}

	/**
	 * Sets up the specified content proposal provider.
	 * 
	 * @param proposalProvider the proposal provider
	 */
	public void setupContentProposalProvider(IContentProposalProvider proposalProvider) {
		final IValueBinding binding = getBinding();
		/*
		 * The following is only relevant if an control exists!
		 */
		final Control control = binding.getControl();
		if (control == null) return;

		/*
		 * Bind field assist
		 */
		final IUIAttribute attribute = binding.getUIAttribute();
		final IControlContentAdapter fieldAssistAdapter = attribute.getFieldAssistAdapter();
		if (fieldAssistAdapter == null) return;

		final ContentProposalAdapter adapter = new ContentAssistCommandAdapter(control, fieldAssistAdapter,
				proposalProvider, null, null);
		// Replace text field contents with accepted proposals
		adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
	}

	/**
	 * Decorates the binding with all relevant field assist.
	 */
	public void decorateAssist() {
		/*
		 * Must be called before the binding to insure the internals of the decorator is properly
		 * setup...
		 */
		final IObservableList decoratorUIList = getValidUIList();
		if (decoratorUIList == null) return;

		/*
		 * Bind field assist
		 */
		final SimpleContentProposalProvider proposalProvider = new SimpleContentProposalProvider(new String[0]) {
			@Override
			public IContentProposal[] getProposals(String contents, int position) {
				setProposals((String[]) getValidUIList().toArray(new String[0]));
				return super.getProposals(contents, position);
			}
		};
		proposalProvider.setFiltering(true);

		setupContentProposalProvider(proposalProvider);
	}

	/**
	 * Runs all known extenders.
	 */
	protected void runExtenders() {
		/*
		 * The decorator can have been disposed...
		 */
		if (getBinding() == null) return;
		// LogUtils.debug(this, getClass().getSimpleName()
		// + "["
		// + hashCode()
		// + "]: binding="
		// + getBinding()
		// + (getBinding() != null ? "\n" +
		// getBinding().getModelFeature().getEContainingClass().getName() + "."
		// + getBinding().getModelFeature().getName() : ""));
		// Assert.isNotNull(getBinding());
		// if (getBinding() == null)
		// return;
		if (myExtenderContext == null) {
			myExtenderContext = new MyExtenderContext();
		}

		myExtenderContext.reset();
		for (final IUIBindingDecoratorExtenderDescriptor d : IManager.Factory.getManager().getDecoratorExtenders()) {
			final CEObjectHolder<IUIBindingDecoratorExtender> factory = d.getFactory();
			final IUIBindingDecoratorExtender extender = factory.getObject();
			if (extender == null) {
				LogUtils.error(factory.getConfigurationElement(), "Cannot create extender"); //$NON-NLS-1$
				continue;
			}

			try {
				if (!extender.isEnabled(getBinding())) {
					continue;
				}
				extender.extend(myExtenderContext);
			} catch (final Exception ex) {
				LogUtils.error(factory.getConfigurationElement(), ex);
			}
		}
		myExtenderContext.applyValues();
	}

	/**
	 * The extender used by this decorator.
	 */
	protected final class MyExtenderContext implements IUIBindingDecoratorExtenderContext {
		private String myMessageFormat;
		private boolean myMessageFormatSet;

		private String myTooltip;
		private boolean myTooltipSet;
		private IObservableValue myTooltipValue;

		private int myMin;
		private boolean myMinSet;
		private IObservableValue myMinValue;

		private int myMax;
		private boolean myMaxSet;
		private IObservableValue myMaxValue;

		private Image myImage;
		private boolean myImageSet;
		private IObservableValue myImageValue;

		private Color myForeground;
		private boolean myForegroundSet;
		private IObservableValue myForegroundValue;

		private Color myBackground;
		private boolean myBackgroundSet;
		private IObservableValue myBackgroundValue;

		private Font myFont;
		private boolean myFontSet;
		private IObservableValue myFontValue;

		private Cursor myCursor;
		private boolean myCursorSet;
		private IObservableValue myCursorValue;

		private boolean myEnabled;
		private boolean myEnabledSet;
		private IObservableValue myEnabledValue;

		private boolean myStyleRangesSet;
		private List<StyleRange> myStyleRanges;
		private IObservableList myStyleRangesList;

		protected class ID {
			public DecorationPosition position;
			public boolean outside;
			public Image image;
			public String tooltip;
		}

		private Set<ID> myImageDecorations;

		/**
		 * Resets the context.
		 */
		public void reset() {
			myTooltip = null;
			myMessageFormat = null;
			myMin = Integer.MIN_VALUE;
			myMax = Integer.MAX_VALUE;
			myImage = null;
			myForeground = null;
			myBackground = null;
			myFont = null;
			myCursor = null;
			myEnabled = true;
			if (myStyleRanges != null) {
				myStyleRanges.clear();
			}
			if (myImageDecorations != null) {
				for (final ID id : myImageDecorations) {
					id.image = null;
					id.tooltip = null;
				}
			}
		}

		/**
		 * Applies the current values to the UI attribute.
		 */
		public void applyValues() {
			if (myMessageFormatSet && myFormattedValue != null) {
				myFormattedValue.setMessageFormat(myMessageFormat);
			}
			if (myTooltipSet) {
				if (myTooltipValue == null) {
					myTooltipValue = getAttribute().getTooltipValue();
				}
				if (myTooltipValue != null) {
					myTooltipValue.setValue(myTooltip);
				}
			}
			if (myMinSet) {
				if (myMinValue == null) {
					myMinValue = getAttribute().getMinValue();
				}
				if (myMinValue != null) {
					myMinValue.setValue(myMin);
				}
			}
			if (myMaxSet) {
				if (myMaxValue == null) {
					myMaxValue = getAttribute().getMaxValue();
				}
				if (myMaxValue != null) {
					myMaxValue.setValue(myMax);
				}
			}
			if (myImageSet) {
				if (myImageValue == null) {
					myImageValue = getAttribute().getImageValue();
				}
				if (myImageValue != null) {
					myImageValue.setValue(myImage);
				}
			}
			if (myForegroundSet) {
				if (myForegroundValue == null) {
					myForegroundValue = getAttribute().getForegroundValue();
				}
				if (myForegroundValue != null) {
					myForegroundValue.setValue(myForeground);
				}
			}
			if (myBackgroundSet) {
				if (myBackgroundValue == null) {
					myBackgroundValue = getAttribute().getBackgroundValue();
				}
				if (myBackgroundValue != null) {
					myBackgroundValue.setValue(myBackground);
				}
			}
			if (myFontSet) {
				if (myFontValue == null) {
					myFontValue = getAttribute().getFontValue();
				}
				if (myFontValue != null) {
					myFontValue.setValue(myFont);
				}
			}
			if (myCursorSet) {
				if (myCursorValue == null) {
					myCursorValue = getAttribute().getCursorValue();
				}
				if (myCursorValue != null) {
					myCursorValue.setValue(myCursor);
				}
			}
			if (myEnabledSet) {
				if (myEnabledValue == null) {
					myEnabledValue = getAttribute().getEnabledValue();
				}
				if (myEnabledValue != null) {
					myEnabledValue.setValue(myEnabled);
				}
			}
			if (myStyleRangesSet) {
				if (myStyleRangesList == null) {
					myStyleRangesList = getAttribute().getStyleRangeList();
				}
				if (myStyleRangesList != null) {
					myStyleRangesList.clear();
					myStyleRangesList.addAll(myStyleRanges);
				}
			}

			if (myImageDecorations != null) {
				for (final ID eid : myImageDecorations) {
					final IUIAttributeImageDecoration id = getAttribute().getImageDecoration(eid.position, eid.outside);
					id.getImageValue().setValue(eid.image);
					id.getTooltipValue().setValue(eid.tooltip);
				}
			}
		}

		@Override
		public IObservableValue getDecoratedValue() {
			return myDecoratedValue;
		}

		@Override
		public IValueBinding getBinding() {
			return BaseUIBindingDecorator.this.getBinding();
		}

		/**
		 * Returns the UI attribute of this binding
		 * 
		 * @return the attribute
		 */
		protected IUIAttribute getAttribute() {
			return getBinding().getUIAttribute();
		}

		@Override
		public void setMessageFormat(String format) {
			myMessageFormat = format;
			myMessageFormatSet = true;
		}

		@Override
		public void appendTooltip(String tooltip) {
			if (myTooltip == null) {
				myTooltip = tooltip;
			} else {
				myTooltip += "\n" + tooltip; //$NON-NLS-1$
			}
			myTooltipSet = true;
		}

		@Override
		public void setMin(int min) {
			myMin = min;
			myMinSet = true;
		}

		@Override
		public void setMax(int max) {
			myMax = max;
			myMaxSet = true;
		}

		@Override
		public Image getImage() {
			if (myImageSet) return myImage;
			if (myImageValue == null) {
				myImageValue = getAttribute().getImageValue();
			}
			if (myImageValue != null) return (Image) myImageValue.getValue();
			return null;
		}

		@Override
		public void setImage(Image image) {
			myImage = image;
			myImageSet = true;
		}

		@Override
		public void setForegound(Color color) {
			myForeground = color;
			myForegroundSet = true;
		}

		@Override
		public void setBackgound(Color color) {
			myBackground = color;
			myBackgroundSet = true;
		}

		@Override
		public void setFont(Font font) {
			myFont = font;
			myFontSet = true;
		}

		@Override
		public void setCursor(Cursor c) {
			myCursor = c;
			myCursorSet = true;
		}

		@Override
		public void setEnabled(boolean enabled) {
			myEnabled = enabled;
			myEnabledSet = true;
		}

		@Override
		public void addStyleRange(StyleRange range) {
			if (myStyleRanges == null) {
				myStyleRanges = new ArrayList<StyleRange>();
			}
			myStyleRanges.add(range);
			myStyleRangesSet = true;
		}

		@Override
		public void setDecoratingImage(DecorationPosition position, boolean outside, Image image, String tooltip) {
			if (myImageDecorations == null) {
				myImageDecorations = new HashSet<ID>();
			}
			ID found = null;
			for (final ID eid : myImageDecorations) {
				if (eid.position == position && eid.outside == outside) {
					found = eid;
					break;
				}
			}
			if (found == null) {
				found = new ID();
				found.position = position;
				found.outside = outside;
				myImageDecorations.add(found);
			}
			found.image = image;
			found.tooltip = tooltip;
		}
	}

	/**
	 * Abstract base class suitable for most model-to-UI converters.
	 * <p>
	 * Make sure that {@link #convert(Object)} never returns <code>null</code>!
	 * 
	 * @see BaseUIBindingDecorator#getModelToUIConverter()
	 */
	public abstract class AbstractModelToUIConverter implements IConverter {
		@Override
		public Object getFromType() {
			return getBinding().getModelType();
		}

		@Override
		public Object getToType() {
			return getBinding().getUIType();
		}

		@Override
		public abstract Object convert(Object fromObject);
	};

	/**
	 * Abstract base class suitable for most model-to-UI converters.
	 * <p>
	 * Make sure that {@link #convert(Object)} never returns <code>null</code>!
	 * 
	 * @see BaseUIBindingDecorator#getModelToUIConverter()
	 */
	public abstract class AbstractUIToModelConverter implements IConverter {
		@Override
		public Object getFromType() {
			return getBinding().getUIType();
		}

		@Override
		public Object getToType() {
			return getBinding().getModelType();
		}

		@Override
		public abstract Object convert(Object fromObject);
	}

	@Override
	public IObservableValue getDisplayObservableValue(IObservableValue value) {
		return value;
	}

	/**
	 * The context used for all extenders...
	 */
	/* package */MyExtenderContext myExtenderContext = null;

	/**
	 * The formatted value in case it is a String.
	 */
	/* package */MessageFormatObservableValue myFormattedValue;

	/**
	 * Observable value for value as converted by the decorator...
	 */
	/* package */IObservableValue myDecoratedValue;

	@Override
	public void update() {
		// TODO force update of all bindings?
		runExtenders();
	}

	/**
	 * UI Bindings version of org.eclipse.core.databinding.ValueBinding.
	 * <p>
	 * This version is changed compared to the original in the following points:
	 * <ul>
	 * <li>in {@link #updateModelToTarget()}, the resulting status is only saved if not OK.</li>
	 * <li>{@link UpdateValueStrategy#doSet()} has been inlined as it is package protected.</li>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 */
	protected static class MyValueBinding extends Binding {
		protected final UpdateValueStrategy targetToModel;
		protected final UpdateValueStrategy modelToTarget;
		protected WritableValue validationStatusObservable;
		protected IObservableValue target;
		protected IObservableValue model;

		protected boolean updatingTarget;
		protected boolean updatingModel;
		private IValueChangeListener targetChangeListener = new IValueChangeListener() {
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				if (!updatingTarget && !UIBindingsUtils.equals(event.diff.getOldValue(), event.diff.getNewValue())) {
					doUpdate(target, model, targetToModel, false, false);
				}
			}
		};
		private IValueChangeListener modelChangeListener = new IValueChangeListener() {
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				if (!updatingModel && !UIBindingsUtils.equals(event.diff.getOldValue(), event.diff.getNewValue())) {
					doUpdate(model, target, modelToTarget, false, false);
				}
			}
		};

		/**
		 * @param targetObservableValue
		 * @param modelObservableValue
		 * @param targetToModel
		 * @param modelToTarget
		 */
		public MyValueBinding(IObservableValue targetObservableValue, IObservableValue modelObservableValue,
				UpdateValueStrategy targetToModel, UpdateValueStrategy modelToTarget) {
			super(targetObservableValue, modelObservableValue);
			this.target = targetObservableValue;
			this.model = modelObservableValue;
			this.targetToModel = targetToModel;
			this.modelToTarget = modelToTarget;
			if ((targetToModel.getUpdatePolicy() & (UpdateValueStrategy.POLICY_CONVERT | UpdateValueStrategy.POLICY_UPDATE)) != 0) {
				target.addValueChangeListener(targetChangeListener);
			} else {
				targetChangeListener = null;
			}
			if ((modelToTarget.getUpdatePolicy() & (UpdateValueStrategy.POLICY_CONVERT | UpdateValueStrategy.POLICY_UPDATE)) != 0) {
				model.addValueChangeListener(modelChangeListener);
			} else {
				modelChangeListener = null;
			}
		}

		@Override
		protected void preInit() {
			ObservableTracker.runAndIgnore(new Runnable() {
				@Override
				public void run() {
					validationStatusObservable = new WritableValue(context.getValidationRealm(), Status.OK_STATUS,
							IStatus.class);
				}
			});
		}

		@Override
		protected void postInit() {
			if (modelToTarget.getUpdatePolicy() == UpdateValueStrategy.POLICY_UPDATE) {
				updateModelToTarget();
			} else if (modelToTarget.getUpdatePolicy() == UpdateValueStrategy.POLICY_CONVERT) {
				validateModelToTarget();
			}
			if (targetToModel.getUpdatePolicy() == UpdateValueStrategy.POLICY_UPDATE
					|| targetToModel.getUpdatePolicy() == UpdateValueStrategy.POLICY_CONVERT) {
				validateTargetToModel();
			}
		}

		@Override
		public IObservableValue getValidationStatus() {
			return validationStatusObservable;
		}

		@Override
		public void updateTargetToModel() {
			/*
			 * If we are already updating the target (=model-to-UI), then don't allow an update of
			 * the model (= UI-to-model), but we still want to validate.
			 */
			doUpdate(target, model, targetToModel, true, updatingTarget);
		}

		@Override
		public void updateModelToTarget() {
			doUpdate(model, target, modelToTarget, true, false);
		}

		/**
		 * Incorporates the provided <code>newStats</code> into the <code>multieStatus</code>.
		 * 
		 * @param multiStatus
		 * @param newStatus
		 * @return <code>true</code> if the update should proceed
		 */
		/* package */boolean mergeStatus(MultiStatus multiStatus, IStatus newStatus) {
			if (!newStatus.isOK()) {
				multiStatus.add(newStatus);
				return !UIBindingsUtils.isFatalError(multiStatus);
			}
			return true;
		}

		/*
		 * This method may be moved to UpdateValueStrategy in the future if clients need more
		 * control over how the source value is copied to the destination observable.
		 */
		protected void doUpdate(final IObservableValue source, final IObservableValue destination,
				final UpdateValueStrategy updateValueStrategy, final boolean explicit, final boolean validateOnly) {

			final int policy = updateValueStrategy.getUpdatePolicy();
			if (policy == UpdateValueStrategy.POLICY_NEVER) return;
			if (policy == UpdateValueStrategy.POLICY_ON_REQUEST && !explicit) return;

			source.getRealm().exec(new Runnable() {
				@Override
				public void run() {
					boolean destinationRealmReached = false;
					final MultiStatus multiStatus = BindingStatus.ok();
					try {
						// Get value
						final Object value = source.getValue();

						// Validate after get
						IStatus status = updateValueStrategy.validateAfterGet(value);
						if (!mergeStatus(multiStatus, status)) return;

						// Convert value
						final Object convertedValue = updateValueStrategy.convert(value);

						// Validate after convert
						status = updateValueStrategy.validateAfterConvert(convertedValue);
						if (!mergeStatus(multiStatus, status)) return;
						if (policy == UpdateValueStrategy.POLICY_CONVERT && !explicit) return;

						// Validate before set
						status = updateValueStrategy.validateBeforeSet(convertedValue);
						if (!mergeStatus(multiStatus, status)) return;
						if (validateOnly) return;

						// Set value
						destinationRealmReached = true;
						destination.getRealm().exec(new Runnable() {
							@Override
							public void run() {
								if (destination == target) {
									updatingTarget = true;
								} else {
									updatingModel = true;
								}
								try {
									IStatus setterStatus;
									try {
										destination.setValue(convertedValue);
										setterStatus = Status.OK_STATUS;
									} catch (final Exception ex) {
										setterStatus = ValidationStatus.error(BindingMessages
												.getString(BindingMessages.VALUEBINDING_ERROR_WHILE_SETTING_VALUE), ex);
									}

									mergeStatus(multiStatus, setterStatus);
								} finally {
									if (destination == target) {
										updatingTarget = false;
									} else {
										updatingModel = false;
									}
									// LogUtils.debug(this, "dest=" + destination + "\nstatus=" +
									// multiStatus);
									if (destination == model || !multiStatus.isOK()) {
										setValidationStatus(multiStatus);
									}
								}
							}
						});
					} catch (final Exception ex) {
						// This check is necessary as in 3.2.2 Status
						// doesn't accept a null message (bug 177264).
						final String message = (ex.getMessage() != null) ? ex.getMessage() : ""; //$NON-NLS-1$

						mergeStatus(multiStatus, new Status(IStatus.ERROR, Policy.JFACE_DATABINDING, IStatus.ERROR,
								message, ex));
					} finally {
						if (!destinationRealmReached) {
							setValidationStatus(multiStatus);
						}

					}
				}
			});
		}

		@Override
		public void validateModelToTarget() {
			doUpdate(model, target, modelToTarget, true, true);
		}

		@Override
		public void validateTargetToModel() {
			doUpdate(target, model, targetToModel, true, true);
		}

		protected void setValidationStatus(final IStatus status) {
			validationStatusObservable.getRealm().exec(new Runnable() {
				@Override
				public void run() {
					validationStatusObservable.setValue(status);
				}
			});
		}

		@Override
		public void dispose() {
			if (targetChangeListener != null) {
				target.removeValueChangeListener(targetChangeListener);
				targetChangeListener = null;
			}
			if (modelChangeListener != null) {
				model.removeValueChangeListener(modelChangeListener);
				modelChangeListener = null;
			}
			target = null;
			model = null;
			super.dispose();
		}

	}
}
