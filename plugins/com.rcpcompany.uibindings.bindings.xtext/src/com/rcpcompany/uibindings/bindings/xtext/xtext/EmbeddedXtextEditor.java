package com.rcpcompany.uibindings.bindings.xtext.xtext;

/**
 * Copyright (c) 2010 ProxiAD
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *    itemis AG - source viewer configuration
 *    Sebastian Zarnekow (itemis AG) - synthetic resource creation and source viewer configuration 
 *    Cedric Vidal (ProxiAD) - integration with global scope
 *    Tonny Madsen (The RCP Company) - adaption to UI Bindings
 */

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.AnnotationPainter;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.IVerticalRulerColumn;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer;
import org.eclipse.xtext.ui.editor.bracketmatching.CharacterPairMatcher;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindings.xtext.UIBXTextContants;

/**
 * Embedded Xtest editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EmbeddedXtextEditor {

	private static final String XTEXT_UI_FORMAT_ACTION = "org.eclipse.xtext.ui.FormatAction";
	private static final String XTEXT_UI_TOGGLE_SL_COMMENT_ACTION = "org.eclipse.xtext.ui.ToggleCommentAction";

	private final IValueBinding myBinding;
	private final int myStyle;

	/**
	 * Internal resource used for the editor
	 */
	private XtextResource myResource;

	/**
	 * Document representation of the content of the editor.
	 */
	private XtextDocument myDocument;

	private XtextSourceViewer mySourceViewer;
	/**
	 * Used to create internal resource for the text of the editor
	 */
	@Inject
	@Named(org.eclipse.xtext.Constants.FILE_EXTENSIONS)
	private String myFileExtension;

	private XtextSourceViewerConfiguration myViewerConfiguration;

	@Inject
	private HighlightingHelper myHighlightingHelper;

	@Inject
	private IResourceSetProvider myResourceSetProvider;

	@Inject
	private IGrammarAccess myGrammarAccess;

	@Inject
	private XtextSourceViewer.Factory mySourceViewerFactory;

	@Inject
	private Provider<XtextSourceViewerConfiguration> mySourceViewerConfigurationProvider;

	@Inject
	private Provider<XtextDocument> myDocumentProvider;

	@Inject
	private Provider<XtextResource> myXtextResourceProvider;
	@Inject
	private IResourceValidator myResourceValidator;

	@Inject
	private IPreferenceStoreAccess myPreferenceStoreAccess;

	@Inject
	private CharacterPairMatcher myCharacterPairMatcher;

	@Inject(optional = true)
	private AnnotationPainter.IDrawingStrategy myProjectionAnnotationDrawingStrategy;

	private final EmbeddedFoldingStructureProvider myFoldingStructureProvider;

	private IOverviewRuler myOverviewRuler;
	private IVerticalRuler myVerticalRuler;

	private IAnnotationAccess myAnnotationAccess;

	/**
	 * Creates a new EmbeddedXtextEditor. It must have the SWT.V_SCROLL style at least not to throw NPE when computing
	 * overview ruler.
	 * 
	 * @param binding the parent composite that will contain the editor
	 * @param injector the Guice injector to get Xtext configuration elements
	 * @param style the SWT style of the {@link SourceViewer} of this editor.
	 */
	public EmbeddedXtextEditor(IValueBinding binding, Injector injector, int style) {
		myBinding = binding;
		myStyle = style;

		myAnnotationPreferences = EditorsPlugin.getDefault().getMarkerAnnotationPreferences(); // TODO: ???
		myFoldingStructureProvider = new EmbeddedFoldingStructureProvider();

		injector.injectMembers(this);

		createEditor();
	}

	/**
	 * Returns the parent composite for the editor itself.
	 * 
	 * @return the parent composite
	 */
	public Composite getParent() {
		return (Composite) myBinding.getControl();
	}

	/**
	 * Returns the {@link StyledText} of the editor itself.
	 * 
	 * @return
	 */
	public StyledText getControl() {
		return getViewer().getTextWidget();
	}

	/**
	 * Returns the source viewer of the editor itself.
	 * 
	 * @return the source viewer
	 */
	public XtextSourceViewer getViewer() {
		return mySourceViewer;
	}

	/**
	 * Returns the artificial resource for this editor.
	 * 
	 * @return the resource
	 */
	public XtextResource getResource() {
		return myResource;
	}

	/**
	 * Returns the document of the editor itself.
	 * 
	 * @return
	 */
	public IXtextDocument getDocument() {
		return myDocument;
	}

	/**
	 * Should be called only once, during initialization.
	 */
	protected void createDocument() {
		// document.set(text);
		// TODO ???
		myResource = createResource("");
		myDocument.setInput(myResource);
		final AnnotationModel annotationModel = new AnnotationModel();
		if (getDocument() instanceof ISynchronizable) {
			Object lock = ((ISynchronizable) getDocument()).getLockObject();
			if (lock == null) {
				lock = new Object();
				((ISynchronizable) getDocument()).setLockObject(lock);
			}
			((ISynchronizable) annotationModel).setLockObject(lock);
		}
		getViewer().setDocument(getDocument(), annotationModel);
	}

	private XtextResource createResource(String content) {
		final XtextResource result = createResource();
		try {
			result.load(new StringInputStream(content, result.getEncoding()), Collections.emptyMap());
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	private void createEditor() {
		final Composite c = getParent();
		c.setLayout(new FillLayout());
		createSourceViewer(c);

		installFoldingSupport(mySourceViewer);
		createDocument();
		myHighlightingHelper.install(myViewerConfiguration, mySourceViewer);

		createActions();
	}

	/**
	 * Creates the vertical ruler to be used by this editor. Subclasses may re-implement this method.
	 * 
	 * @return the vertical ruler
	 */
	private IVerticalRuler createVerticalRuler() {
		return new CompositeRuler();
	}

	/** The editor's vertical ruler. */
	private IVerticalRuler fVerticalRuler;

	/**
	 * Creates the annotation ruler column. Subclasses may re-implement or extend.
	 * 
	 * @param ruler the composite ruler that the column will be added
	 * @return an annotation ruler column
	 * @since 3.2
	 */
	protected IVerticalRulerColumn createAnnotationRulerColumn(CompositeRuler ruler) {
		return new AnnotationRulerColumn(VERTICAL_RULER_WIDTH, getAnnotationAccess());
	}

	private void createSourceViewer(Composite parent) {
		fVerticalRuler = createVerticalRuler();
		mySourceViewer = mySourceViewerFactory.createSourceViewer(parent, fVerticalRuler, getOverviewRuler(), true,
				myStyle);

		/*
		 * Borders..
		 */
		final FormToolkit formToolkit = IManager.Factory.getManager().getFormToolkit();
		formToolkit.adapt(mySourceViewer.getTextWidget(), true, true);
		formToolkit.paintBordersFor(mySourceViewer.getTextWidget().getParent());

		myViewerConfiguration = mySourceViewerConfigurationProvider.get();
		mySourceViewer.configure(myViewerConfiguration);

		fProjectionSupport = installProjectionSupport(mySourceViewer);

		// make sure the source viewer decoration support is initialized
		getSourceViewerDecorationSupport(mySourceViewer);

		getControl().addFocusListener(new SourceViewerFocusListener());

		fSourceViewerDecorationSupport.install(myPreferenceStoreAccess.getPreferenceStore());
		parent.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				fSourceViewerDecorationSupport.dispose();
			}
		});
		myDocument = myDocumentProvider.get();
		final ValidationJob job = new ValidationJob(myResourceValidator, getDocument(),
				new IValidationIssueProcessor() {
					private AnnotationIssueProcessor annotationIssueProcessor;

					@Override
					public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
						if (annotationIssueProcessor == null) {
							annotationIssueProcessor = new AnnotationIssueProcessor(getDocument(),
									mySourceViewer.getAnnotationModel(), new IssueResolutionProvider.NullImpl());
						}
						if (annotationIssueProcessor != null) {
							annotationIssueProcessor.processIssues(issues, monitor);
						}
					}
				}, CheckMode.FAST_ONLY);
		myDocument.setValidationJob(job);

		mySourceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateSelectionDependentActions();
			}
		});
	}

	private ProjectionSupport fProjectionSupport;

	private static final String ERROR_ANNOTATION_TYPE = "org.eclipse.xtext.ui.editor.error";
	private static final String WARNING_ANNOTATION_TYPE = "org.eclipse.xtext.ui.editor.warning";

	// TODO ???
	private ProjectionSupport installProjectionSupport(ProjectionViewer projectionViewer) {
		final ProjectionSupport projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(),
				EditorsUI.getSharedTextColors());
		projectionSupport.addSummarizableAnnotationType(WARNING_ANNOTATION_TYPE);
		projectionSupport.addSummarizableAnnotationType(ERROR_ANNOTATION_TYPE);
		projectionSupport.setAnnotationPainterDrawingStrategy(myProjectionAnnotationDrawingStrategy);
		projectionSupport.install();
		return projectionSupport;
	}

	private void installFoldingSupport(ProjectionViewer projectionViewer) {
		myFoldingStructureProvider.install(this, projectionViewer);
		projectionViewer.doOperation(ProjectionViewer.TOGGLE);
		myFoldingStructureProvider.initialize();
	}

	private SourceViewerDecorationSupport fSourceViewerDecorationSupport;

	/**
	 * Returns the source viewer decoration support.
	 * 
	 * @param viewer the viewer for which to return a decoration support
	 * @return the source viewer decoration support
	 */
	private SourceViewerDecorationSupport getSourceViewerDecorationSupport(ISourceViewer viewer) {
		if (fSourceViewerDecorationSupport == null) {
			fSourceViewerDecorationSupport = new SourceViewerDecorationSupport(viewer, getOverviewRuler(),
					getAnnotationAccess(), EditorsUI.getSharedTextColors());
			configureSourceViewerDecorationSupport(fSourceViewerDecorationSupport);
		}
		return fSourceViewerDecorationSupport;
	}

	/**
	 * Configures the decoration support for this editor's source viewer. Subclasses may override this method, but
	 * should call their superclass' implementation at some point.
	 * 
	 * @param support the decoration support to configure
	 */
	private void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		final Iterator<AnnotationPreference> e = Iterators.filter(myAnnotationPreferences.getAnnotationPreferences()
				.iterator(), AnnotationPreference.class);
		while (e.hasNext()) {
			support.setAnnotationPreference(e.next());
		}

		support.setCursorLinePainterPreferenceKeys(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE,
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE_COLOR);
		support.setMarginPainterPreferenceKeys(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN,
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLOR,
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLUMN);
		// support.setSymbolicFontName(getFontPropertyPreferenceKey());

		if (myCharacterPairMatcher != null) {
			support.setCharacterPairMatcher(myCharacterPairMatcher);
			support.setMatchingCharacterPainterPreferenceKeys(BracketMatchingPreferencesInitializer.IS_ACTIVE_KEY,
					BracketMatchingPreferencesInitializer.COLOR_KEY);
		}
	}

	/**
	 * Returns the overview ruler.
	 * 
	 * @return the overview ruler
	 */
	private IOverviewRuler getOverviewRuler() {
		if (myOverviewRuler == null && (myStyle & SWT.V_SCROLL) != 0) {
			myOverviewRuler = createOverviewRuler(EditorsUI.getSharedTextColors());
		}
		return myOverviewRuler;
	}

	/**
	 * Returns the vertical ruler.
	 * 
	 * @return the vertical ruler
	 */
	private IVerticalRuler getVerticalRuler() {
		if (myVerticalRuler == null && (myStyle & SWT.V_SCROLL) != 0) {
			myVerticalRuler = new VerticalRuler(VERTICAL_RULER_WIDTH);
		}
		return myVerticalRuler;
	}

	/** The width of the vertical ruler. */
	private static final int VERTICAL_RULER_WIDTH = 12;

	/**
	 * Returns the annotation access.
	 * 
	 * @return the annotation access
	 */
	private IAnnotationAccess getAnnotationAccess() {
		if (myAnnotationAccess == null) {
			myAnnotationAccess = createAnnotationAccess();
		}
		return myAnnotationAccess;
	}

	/**
	 * Creates the annotation access for this editor.
	 * 
	 * @return the created annotation access
	 */
	private IAnnotationAccess createAnnotationAccess() {
		return new DefaultMarkerAnnotationAccess() {
			@Override
			public int getLayer(Annotation annotation) {
				if (annotation.isMarkedDeleted())
					return IAnnotationAccessExtension.DEFAULT_LAYER;
				return super.getLayer(annotation);
			}
		};
	}

	/**
	 * The annotation preferences.
	 */
	private final MarkerAnnotationPreferences myAnnotationPreferences;

	private IOverviewRuler createOverviewRuler(ISharedTextColors sharedColors) {
		final IOverviewRuler ruler = new OverviewRuler(getAnnotationAccess(), VERTICAL_RULER_WIDTH, sharedColors);

		final Iterator<?> e = myAnnotationPreferences.getAnnotationPreferences().iterator();
		while (e.hasNext()) {
			final AnnotationPreference preference = (AnnotationPreference) e.next();
			if (preference.contributesToHeader()) {
				ruler.addHeaderAnnotationType(preference.getAnnotationType());
			}
		}
		return ruler;
	}

	private void createActions() {
		{
			final TextViewerAction action = new TextViewerAction(getViewer(), ITextOperationTarget.CUT);
			action.setText("Cut");
			setAction(ITextEditorActionConstants.CUT, action);
			setAsSelectionDependantAction(action);
		}

		{
			final TextViewerAction action = new TextViewerAction(getViewer(), ITextOperationTarget.COPY);
			action.setText("Copy");
			setAction(ITextEditorActionConstants.COPY, action);
			setAsSelectionDependantAction(action);
		}

		{
			final TextViewerAction action = new TextViewerAction(getViewer(), ITextOperationTarget.PASTE);
			action.setText("Paste");
			setAction(ITextEditorActionConstants.PASTE, action);
			setAsSelectionDependantAction(action);
		}

		{
			final TextViewerAction action = new TextViewerAction(getViewer(), ISourceViewer.CONTENTASSIST_PROPOSALS);
			action.setText("Content Assist");
			setAction(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS, action);
			setAsContextDependantAction(action);
		}

		if (myViewerConfiguration.getContentFormatter(getViewer()) != null) {
			final TextViewerAction action = new TextViewerAction(getViewer(), ISourceViewer.FORMAT);
			action.setText("Format");
			setAction(XTEXT_UI_FORMAT_ACTION, action);
			setAsContextDependantAction(action);
		}

		{
			final ToggleSLCommentAction action = new ToggleSLCommentAction(getViewer());
			setAction(XTEXT_UI_TOGGLE_SL_COMMENT_ACTION, action);
			setAsContextDependantAction(action);
			action.configure(getViewer(), myViewerConfiguration);
		}
	}

	private void setAction(String actionID, IAction action) {
		if (action.getId() == null) {
			action.setId(actionID); // make sure the action ID has been set
		}

		myActions.put(actionID, action);
	}

	private void setAsContextDependantAction(IAction action) {
		myActionHandlers.add(new ActionHandler(action));
	}

	private void setAsSelectionDependantAction(IAction action) {
		mySelectionDependentActions.add(action);
	}

	private void updateSelectionDependentActions() {
		for (final IAction action : mySelectionDependentActions) {
			if (action instanceof IUpdate) {
				((IUpdate) action).update();
			}
		}
	}

	private final Map<String, IAction> myActions = Maps.newHashMap();
	private final List<IAction> mySelectionDependentActions = Lists.newArrayList();
	private final List<ActionHandler> myActionHandlers = Lists.newArrayList();

	/**
	 * Source viewer focus listener that activates/deactivates action handlers on focus state change.
	 * 
	 * @author Mikaël Barbero
	 * @auther Tonny Madsen, The RCP Company
	 */
	private final class SourceViewerFocusListener implements FocusListener {
		private final List<IHandlerActivation> myHandlerActivations;
		private IContextActivation myContextActivation;

		public SourceViewerFocusListener() {
			myHandlerActivations = Lists.newArrayList();

			getViewer().getControl().addDisposeListener(new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent e) {
					final IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getAdapter(
							IHandlerService.class);
					handlerService.deactivateHandlers(myHandlerActivations);
					myHandlerActivations.clear();
				}
			});
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (myBinding.isDisposed())
				return;
			final IServiceLocator sl = myBinding.getContext().getServiceLocator();

			final IContextService contextService = (IContextService) sl.getService(IContextService.class);
			myContextActivation = contextService.activateContext(UIBXTextContants.XTEXT_EDITOR_CONTEXT_ID);

			final IHandlerService hs = (IHandlerService) sl.getService(IHandlerService.class);

			for (final ActionHandler actionHandler : myActionHandlers) {
				myHandlerActivations.add(hs.activateHandler(actionHandler.getAction().getId(), actionHandler,
						Constants.TRUE_EXPRESSION));
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			final IServiceLocator sl = myBinding.getContext().getServiceLocator();
			if (myContextActivation != null) {
				final IContextService contextService = (IContextService) sl.getService(IContextService.class);
				contextService.deactivateContext(myContextActivation);
				myContextActivation = null;
			}

			final IHandlerService hs = (IHandlerService) sl.getService(IHandlerService.class);
			hs.deactivateHandlers(myHandlerActivations);
			myHandlerActivations.clear();
		}
	}

	protected XtextResource createResource() {
		final ResourceSet resourceSet = myResourceSetProvider.get(null);
		// XtextResource result = (XtextResource) resourceSet.createResource(
		// URI.createURI(fGrammarAccess.getGrammar().getName() + "." + fFileExtension));
		final XtextResource result = myXtextResourceProvider.get();
		result.setURI(URI.createURI(myGrammarAccess.getGrammar().getName() + "." + myFileExtension));
		resourceSet.getResources().add(result);
		return result;
	}
}
