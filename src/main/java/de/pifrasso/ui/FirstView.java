package de.pifrasso.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class FirstView extends VerticalLayout implements View {

    public static final String NAME = "first";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Label label = new Label("FistView");
        addComponent(label);
    }
}
