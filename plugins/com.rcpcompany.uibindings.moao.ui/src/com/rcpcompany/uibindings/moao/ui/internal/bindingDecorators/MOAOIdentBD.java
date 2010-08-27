package com.rcpcompany.uibindings.moao.ui.internal.bindingDecorators;


import org.eclipse.emf.ecore.*;

import com.rcpcompany.uibindings.*;
import com.rcpcompany.uibindings.decorators.*;
import com.rcpcompany.utils.basic.*;

/**
 * Identity type decorator for {@link MOAO} objects.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MOAOIdentBD extends SimpleUIBindingDecorator implements IUIBindingDecorator {

  public MOAOIdentBD() {
  }

  /*
   * At least for now.
   */
  @Override
  public boolean isChangeable() {
    return false;
  }

  /**
   * Returns the label for the class of specified object based on
   * <ul>
   * <li>the {@link IBindingDataType data type} {@link IBinding#ARG_LABEL}.</li>
   * <li>a human readable version of the class name</li>
   * </ul>
   * 
   * @param o the object
   * @return the label
   */
  protected String getClassLabel(Object o) {
    if (o == null) {
      return "null";
    }
    final Class<? extends Object> cls = o.getClass();

    final IBindingDataType dataType = IBindingDataType.Factory.create(cls);
    if (dataType != null) {
      final String l = dataType.getArgument(getBinding(), Constants.ARG_LABEL, String.class);
      if (l != null) {
        return l;
      }
    }

    String l = cls.getSimpleName();
    if (o instanceof EObject && l.endsWith("Impl")) {
      l = l.substring(0, l.length() - 4);
    }
    return ToStringUtils.formatHumanReadable(l);
  }

  @Override
  protected Object convertModelToUI(Object fromObject) {
    if (fromObject == null) {
      return "";
    }

    // TODO TM implement
    // if(fromObject instanceof MOAO){
    // MOAO moao = (MOAO) fromObject;
    // String name = NamedObjectUtil.getScriptableName(moao);
    // return name;
    // }
    return fromObject.getClass().getSimpleName();
  }

  @Override
  protected Object convertUIToModel(Object fromObject) {
    return null;
  }
}
