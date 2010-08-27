package com.rcpcompany.uibindings.moao.ui.internal.handlers;

import org.eclipse.core.commands.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.handlers.*;

import com.rcpcompany.uibindings.*;
import com.rcpcompany.uibindings.moao.*;
import com.rcpcompany.uibindings.moao.ui.internal.dialogs.*;

public class EditCommentHandler extends AbstractHandler {
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    final Shell shell = HandlerUtil.getActiveShellChecked(event);
    /*
     * Find the binding and the object in question
     */
    final Object binding = HandlerUtil.getVariableChecked(event, Constants.SOURCES_ACTIVE_BINDING);
    if (!(binding instanceof IValueBinding)) {
      return null;
    }
    final IValueBinding vb = (IValueBinding) binding;
    if (!(vb.getModelObject() instanceof IMOAO)) {
      return null;
    }
    /*
     * The IMOAO and the feature
     */
    final IMOAO moao = (IMOAO) vb.getModelObject();
    final EStructuralFeature feature = vb.getModelFeature();

    String oldDescription = null;
    String oldDetails = null;
    /*
     * Find the comments Status Object or create a new
     */
    IMOAOMessage comment = null;
    for (final IMOAOMessage s : moao.getMessages()) {
      if (s.getSeverity() == Severity.COMMENT && s.getFeature() == feature) {
        comment = s;
        break;
      }
    }
    if (comment == null) {
      comment = IMOAOFactory.eINSTANCE.createMOAOMessage();
      comment.setOwner("TODO");
      comment.setSeverity(Severity.COMMENT);
      comment.setFeature(feature);
      comment.setDescription("Comment by " + System.getProperty("user.name"));
      comment.setDetails("");
      moao.getMessages().add(comment);
    } else {
      oldDescription = comment.getDescription();
      oldDetails = comment.getDetails();
    }

    /*
     * Create and open the dialog
     */
    final CommentEditorDialog dialog = new CommentEditorDialog(shell, comment);
    final int result = dialog.open();
    switch (result) {
      case Window.OK:
        break;
      case Window.CANCEL:
        if (oldDescription == null) {
          moao.getMessages().remove(comment);
        } else {
          comment.setDescription(oldDescription);
          comment.setDetails(oldDetails);
        }
        break;
      case CommentEditorDialog.DELETE:
        moao.getMessages().remove(comment);
        break;
    }

    vb.updateBinding();

    return null;
  }
}
