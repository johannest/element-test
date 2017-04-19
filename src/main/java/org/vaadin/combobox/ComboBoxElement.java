package org.vaadin.combobox;

import org.vaadin.elements.Element;
import org.vaadin.elements.Elements;
import org.vaadin.elements.Tag;
import org.vaadin.elements.UpdatedBy;

@Tag("vaadin-combo-box")
public interface ComboBoxElement extends Element {

  public static ComboBoxElement create() {
    return Elements.create(ComboBoxElement.class);
  }

  public void setLabel(String label);

  public String getLabel();

  public void setItems(String[] items);

  public String[] getItems();

  public void setValue(String value);

  @UpdatedBy("core-change")
  public String getValue();

}
