package org.vaadin.combobox;

import java.util.Collection;

import org.vaadin.elements.ElementIntegration;
import org.vaadin.elements.Root;

import com.vaadin.annotations.HtmlImport;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomField;

@HtmlImport("vaadin://bower_components/vaadin-combo-box/vaadin-combo-box.html")
public class ComboBox<T> extends CustomField<T> {

  private ComboBoxElement element;

  public ComboBox() {
    element = ComboBoxElement.create();
    element.setLabel("Vaadin combo-box element");
  }

  @Override
  protected Component initContent() {
    CssLayout wrapper = new CssLayout();
    Root root = ElementIntegration.getRoot(wrapper);
    root.appendChild(element);
    return wrapper;
  }

  @Override
  public void setValue(T value) {
    doSetValue(value);
  }

  @Override
  public T getValue() {
    final String valueStr = element.getValue();
    // TODO converter
    return (T)valueStr;
  }

  @Override
  protected void doSetValue(T value) {
    // TODO converter
    element.setValue(value.toString());
  }

  @Override
  public void attach() {
    super.attach();
    // TODO set items again
  }

  /**
   * Collection of items to be shown in the combo box,
   * Note: toString is called to make a String representation of the items
   * @param items
   */
  public void setItems(Collection<T> items) {
    final String[] strItems = new String[items.size()];
    final int[] idx = { 0 };
    // TODO converter
    items.forEach(item -> {strItems[idx[0]++]=item.toString();});
    element.eval("e.items = $0",  new Object[] {strItems});
  }

}
