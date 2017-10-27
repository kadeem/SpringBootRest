package de.pifrasso.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class SecondView extends VerticalLayout implements View{


    public static final String NAME = "second";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Label label = new Label("Second View");
        addComponent(label);
    }
}
