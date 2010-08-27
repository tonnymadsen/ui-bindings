package com.rcpcompany.uibindings.moao.util;

import java.util.*;

import org.eclipse.core.databinding.observable.list.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.*;

import com.rcpcompany.uibindings.*;
import com.rcpcompany.uibindings.bindingMessages.*;
import com.rcpcompany.uibindings.moao.*;
import com.rcpcompany.uibindings.validators.*;

/**
 * This validation adaptor will handle {@link IMOAOMessage} objects.
 * @author Tonny Madsen, The RCP Company
 */
public class MOAOMessageValidatorAdapter extends AbstractValidatorAdapter {

  @SuppressWarnings("unchecked")
  @Override
  public void validateObjectTree(EObject root, IObservableList messages) {
    List<IMOAOMessage> foundStatus = new ArrayList<IMOAOMessage>();

    collectStatus(root, foundStatus);

    final List<Message> toRemoveList = new ArrayList<Message>(messages);
    final List<Message> toAddList = new ArrayList<Message>();

    for (final IMOAOMessage s : foundStatus) {
      boolean old = false;
      for (final Object o : messages) {
        final Message f = (Message) o;
        if (f.getStatus().equals(s)) {
          old = true;
          toRemoveList.remove(f);
        }
      }
      if (old) {
        continue;
      }
      toAddList.add(new Message(s));
    }

    messages.removeAll(toRemoveList);
    messages.addAll(toAddList);
  }

  /**
   * Collects all status objects from the root down
   * @param root the root of the tree
   * @param foundStatus the list to be updated
   */
  private void collectStatus(EObject root, List<IMOAOMessage> foundStatus) {
    TreeIterator<Object> allContents = EcoreUtil.getAllContents(root, false);

    while (allContents.hasNext()) {
      Object c = allContents.next();
      if (c instanceof IMOAO) {
        IMOAO m = (IMOAO) c;

        foundStatus.addAll(m.getMessages());
      }
    }
  }

  /**
   * Adaption from {@link IMOAOMessage} to {@link IBindingMessage}.
   */
  private static class Message extends AbstractBindingMessage {

    private final IMOAOMessage myStatus;

    public Message(IMOAOMessage diagnostic) {
      super(null);
      myStatus = diagnostic;

      addTarget(myStatus.getObject(), myStatus.getFeature());
    }

    @Override
    public String getSource() {
      return IMOAOPackage.eNS_URI;
    }

    @Override
    public int getCode() {
      return 0;
    }

    @Override
    public Object getData() {
      return myStatus;
    }

    @Override
    public String getMessage() {
      return myStatus.getDescription();
    }

    @Override
    public BindingMessageSeverity getSeverity() {
      switch (myStatus.getSeverity()) {
        case COMMENT:
        case INFO:
          return BindingMessageSeverity.INFORMATION;
        case WARNING:
          return BindingMessageSeverity.WARNING;
        case ERROR:
          return BindingMessageSeverity.ERROR;
      }
      return BindingMessageSeverity.NONE;
    }

    public IMOAOMessage getStatus() {
      return myStatus;
    }
  }
}
