package com.rcpcompany.uibindings.internal.utils;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IBindingHighlightContext;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link IBindingHighlightContext}.
 * <p>
 * Includes a manager, that keeps track of all the current contexts, and a binding extender that
 * acts on the information and colors the relevant bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingHighlightContext implements IBindingHighlightContext {

	/**
	 * The list of all current contexts.
	 */
	private static List<BindingHighlightContext> theContexts = new ArrayList<BindingHighlightContext>();

	/**
	 * Constructs and returns a new highlight context.
	 */
	public BindingHighlightContext() {
		theContexts.add(this);
	}

	@Override
	public void dispose() {
		setStage(STAGE.DISPOSED);
		myBindings.clear();

		/*
		 * Update all bindings
		 */
		IManager.Factory.getManager().updateBindings(null);

		theContexts.remove(this);
	}

	/**
	 * The default color to use.
	 */
	private final Color myDefaultBackgroundColor = JFaceResources.getColorRegistry().get(
			Constants.COLOR_DEFINITIONS_DEFAULT_HIGHLIGHT_BACKGROUND);

	/**
	 * The default color to use.
	 */
	private final Color myBackgroundColor = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);

	/**
	 * The bindings of this context, when it is active...
	 */
	private final Set<IValueBinding> myBindings = new HashSet<IValueBinding>();

	private final Adapter myAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;

			if (msg.getFeature() == IUIBindingsPackage.Literals.BINDING__STATE) {
				final IValueBinding vb = (IValueBinding) msg.getNotifier();

				if (vb.getState() == BindingState.DISPOSED) {
					myBindings.remove(vb);
				}
			}
		};
	};

	@Override
	public void activate() {
		if (myStage != STAGE.INIT) throw new IllegalStateException("Not in initialization state");
		if (myEffect == null) {
			setEffect(myDefaultBackgroundColor); // TODO preference
		}

		/*
		 * Calculate the bindings of the context
		 */
		for (final IBindingContext bc : IManager.Factory.getManager().getContexts()) {
			BINDING: for (final IBinding b : bc.getBindings()) {
				if (!(b instanceof IValueBinding)) {
					continue;
				}
				final IValueBinding vb = (IValueBinding) b;
				for (final IDetail d : myDetails) {
					if (d.isAffected(vb)) {
						myBindings.add(vb);
						vb.eAdapters().add(myAdapter);
						continue BINDING;
					}
				}
			}
		}

		myDetails.clear();

		setStage(STAGE.FADE_IN);
	}

	@Override
	public void deactivate() {
		switch (myStage) {
		case DISPOSED:
			break;
		case INIT:
		case FADE_OUT:
			dispose();
			break;
		case FADE_IN:
		case ACTIVE:
			setStage(STAGE.FADE_OUT);
		}
	}

	/**
	 * Sets the stage of the context.
	 * 
	 * @param newStage the new stage
	 */
	protected void setStage(STAGE newStage) {
		myStage = newStage;
		myStageStartTime = System.currentTimeMillis();
		switch (myStage) {
		case INIT:
		case DISPOSED:
			myStageLength = 0;
			break;
		case FADE_IN:
			myStageLength = myFadeInTime;
			break;
		case ACTIVE:
			myStageLength = (myDeactivationPolicy == DEACTIVATION_POLICY.TIMED) ? myDeactivationTime : 0;
			break;
		case FADE_OUT:
			myStageLength = myFadeOutTime;
			break;
		}

		update();
	}

	/**
	 * The current stage of this context.
	 */
	private STAGE myStage = STAGE.INIT;

	@Override
	public STAGE getStage() {
		return myStage;
	}

	/**
	 * The start time for the current stage. Only relevant for {@link STAGE#FADE_IN},
	 * {@link STAGE#ACTIVE} and {@link STAGE#FADE_OUT}.
	 */
	private long myStageStartTime;

	/**
	 * The length of the current stage. Only relevant for {@link STAGE#FADE_IN},
	 * {@link STAGE#ACTIVE} and {@link STAGE#FADE_OUT}.
	 */
	private long myStageLength;

	@Override
	public void setDeactivatePolicy(DEACTIVATION_POLICY policy) {
		if (myStage != STAGE.INIT) throw new IllegalStateException("Not in initialization state");
		myDeactivationPolicy = policy;
	}

	private final Runnable myUpdateRunnable = new Runnable() {
		@Override
		public void run() {
			update();
		}
	};

	/**
	 * Updates this context.
	 */
	public void update() {
		LogUtils.debug(this, "");
		/*
		 * Check if the previous stage is over.
		 * 
		 * If so, change stage and return...
		 */
		if (myStageLength != 0 && myStageStartTime + myStageLength <= System.currentTimeMillis()) {
			/*
			 * New stage
			 */
			switch (myStage) {
			case INIT:
			case DISPOSED:
				break;
			case FADE_IN:
				setStage(STAGE.ACTIVE);
				break;
			case ACTIVE:
				setStage(STAGE.FADE_OUT);
				break;
			case FADE_OUT:
				dispose();
				break;
			}
			return;
		}

		for (final IValueBinding vb : myBindings) {
			vb.updateBinding();
		}

		/*
		 * Set-up timer if needed
		 */
		final Display display = PlatformUI.getWorkbench().getDisplay();
		switch (myStage) {
		case INIT:
		case DISPOSED:
			break;
		case FADE_IN:
		case FADE_OUT:
			display.timerExec(FADE_TICK, myUpdateRunnable);
			break;
		case ACTIVE:
			switch (myDeactivationPolicy) {
			case MANUAL:
				break;
			case FIRST_CHANGE:
				final EditingDomain ed = IManager.Factory.getManager().getEditingDomain();
				ed.getCommandStack().addCommandStackListener(new CommandStackListener() {
					@Override
					public void commandStackChanged(EventObject event) {
						ed.getCommandStack().removeCommandStackListener(this);
						setStage(STAGE.FADE_OUT);
					}
				});
				break;
			case TIMED:
				display.timerExec(myDeactivationTime, myUpdateRunnable);
				break;
			case RUNNABLE:
				try {
					if (myDeactivationRunnable != null) {
						myDeactivationRunnable.run();
					}
				} catch (final Exception ex) {
					LogUtils.error(myDeactivationRunnable, ex);
				}
				setStage(STAGE.FADE_OUT);
				return;
			}
			break;
		}
	}

	/**
	 * The list of details that are affected by this context.
	 */
	private final List<IDetail> myDetails = new ArrayList<IDetail>();
	private IEffect myEffect = null;
	private DEACTIVATION_POLICY myDeactivationPolicy = DEACTIVATION_POLICY.TIMED;
	private int myFadeInTime = DEFAULT_FADE_IN_TIME;
	private int myFadeOutTime = DEFAULT_FADE_OUT_TIME;
	private int myDeactivationTime = DEFAULT_ACTIVE_TIME;

	private Runnable myDeactivationRunnable;

	/**
	 * Returns a list of all the highlight contexts that can affect the specified binding.
	 * 
	 * @param binding the binding to test
	 * @return a list of the contexts that affects the binding or <code>null</code>
	 */
	public static List<BindingHighlightContext> findAffectedContexts(IValueBinding binding) {
		List<BindingHighlightContext> ctx = null;
		for (final BindingHighlightContext c : theContexts) {
			if (c.myBindings.contains(binding)) {
				if (ctx == null) {
					ctx = new ArrayList<BindingHighlightContext>();
				}
				ctx.add(c);
			}
		}

		return ctx;
	}

	@Override
	public void add(IDetail detail) {
		if (myStage != STAGE.INIT) throw new IllegalStateException("Not in initialization state");
		myDetails.add(detail);
	}

	@Override
	public void add(final IValueBinding binding) {
		add(new IDetail() {
			@Override
			public boolean isAffected(IValueBinding b) {
				return binding == b;
			}
		});
	}

	@Override
	public void add(final EObject obj, final EStructuralFeature feature) {
		add(new IDetail() {
			@Override
			public boolean isAffected(IValueBinding b) {
				return (b.getModelObject() == obj && b.getModelFeature() == feature);
			}
		});
	}

	@Override
	public void setEffect(IEffect effect) {
		if (myStage != STAGE.INIT) throw new IllegalStateException("Not in initialization state");
		myEffect = effect;
	}

	@Override
	public void setEffect(final Color background) {
		setEffect(new IEffect() {
			@Override
			public void doEffect(IUIBindingDecoratorExtenderContext context, double fadeFactor) {
				Color origBackround = context.getBackground();
				if (origBackround == null) {
					origBackround = myBackgroundColor;
				}
				final RGB rgb = new RGB(0, 0, 0);
				rgb.red = (int) (origBackround.getRed() * (1.0 - fadeFactor) + background.getRed() * fadeFactor);
				rgb.green = (int) (origBackround.getGreen() * (1.0 - fadeFactor) + background.getGreen() * fadeFactor);
				rgb.blue = (int) (origBackround.getBlue() * (1.0 - fadeFactor) + background.getBlue() * fadeFactor);

				final Color color = Activator.getDefault().getResourceManager().createColor(rgb);

				context.setBackgound(color);
			}
		});
	}

	/**
	 * Performs the effect of this highlight context.
	 * 
	 * @param context the extender context
	 */
	public void doEffect(IUIBindingDecoratorExtenderContext context) {
		double fadeFactor = 1.0;
		switch (getStage()) {
		case FADE_IN:
			if (myStageLength != 0) {
				fadeFactor = ((double) (System.currentTimeMillis() - myStageStartTime)) / myStageLength;
			}
			break;
		case ACTIVE:
			fadeFactor = 1.0;
			break;
		case FADE_OUT:
			if (myStageLength != 0) {
				fadeFactor = 1.0 - ((double) (System.currentTimeMillis() - myStageStartTime)) / myStageLength;
			}
		}
		myEffect.doEffect(context, fadeFactor);
	}

	@Override
	public void setFadeInTime(int ms) {
		if (myStage != STAGE.INIT) throw new IllegalStateException("Not in initialization state");
		myFadeInTime = ms;
	}

	@Override
	public void setFadeOutTime(int ms) {
		if (myStage != STAGE.INIT) throw new IllegalStateException("Not in initialization state");
		myFadeOutTime = ms;
	}

	@Override
	public void setDeactivationTime(int ms) {
		if (myStage != STAGE.INIT) throw new IllegalStateException("Not in initialization state");
		myDeactivationTime = ms;
	}

	@Override
	public void setDeactivationRunnable(Runnable runnnable) {
		if (myStage != STAGE.INIT) throw new IllegalStateException("Not in initialization state");
		myDeactivationRunnable = runnnable;
	}

	/**
	 * Extender used to highlight bindings based on the current contexts.
	 */
	public static class Extender extends AbstractUIBindingDecoratorExtender {
		private List<BindingHighlightContext> myAffectedContexts;

		@Override
		public boolean isEnabled(IValueBinding binding) {
			myAffectedContexts = findAffectedContexts(binding);
			return myAffectedContexts != null && !myAffectedContexts.isEmpty();
		}

		@Override
		public void extend(IUIBindingDecoratorExtenderContext context) {
			if (myAffectedContexts == null || myAffectedContexts.isEmpty()) return;
			for (final BindingHighlightContext c : myAffectedContexts) {
				switch (c.getStage()) {
				case INIT:
				case DISPOSED:
					break;
				case FADE_IN:
				case ACTIVE:
				case FADE_OUT:
					c.doEffect(context);
					break;
				}
			}
		}
	}

}
