package de.pifrasso.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path = "/ui/login")
@Theme("valo")
public class MainUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        setContent(new LoginComponent());
        setSizeFull();
    }
}
