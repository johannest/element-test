package org.vaadin;

import java.util.Arrays;

import javax.servlet.annotation.WebServlet;

import org.vaadin.combobox.ComboBox;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@JavaScript("vaadin://bower_components/webcomponentsjs/webcomponents.js")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        ComboBox<String> cb = new ComboBox();
        cb.setItems(Arrays.asList(new String[]{"asdsdas", "qwewqeqw", "zxczxczxc"}));
        layout.addComponent(cb);

        Button b1 = new Button("Set value to: qwewqeqw", clickEvent -> {
            cb.setValue("qwewqeqw");
        });
        Button b2 = new Button("Get and show value", clickEvent -> {
            Notification.show(cb.getValue());
        });

        layout.addComponents(b1, b2);
        setContent(layout);
    }

    @WebServlet(value = "/*", asyncSupported = true, loadOnStartup = 1)
    @VaadinServletConfiguration(productionMode = false, ui = MyUI.class)
    public static class Servlet extends VaadinServlet {
    }
}
