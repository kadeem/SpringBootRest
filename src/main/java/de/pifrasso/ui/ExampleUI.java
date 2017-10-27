package de.pifrasso.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.Binder;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import de.pifrasso.model.Workorder;

@SpringUI(path = "/ui/example")
@Title("Example Page")
@Theme("valo")
public class ExampleUI extends UI {


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout root = new VerticalLayout();

        Button b1 = new Button("To First View");
        Button b2 = new Button("To Second View");

        Panel viewContainer = new Panel();

        Navigator navigator = new Navigator(this, viewContainer);

        navigator.addView(FirstView.NAME, new FirstView());

        navigator.addView(SecondView.NAME, new SecondView());

        root.addComponent(new HorizontalLayout(b1, b2));
        root.addComponent(viewContainer);

        navigator.navigateTo(FirstView.NAME);

        b1.addClickListener(event -> navigator.navigateTo(FirstView.NAME));


        b2.addClickListener(event -> navigator.navigateTo(SecondView.NAME));

        setContent(root);
    }
}
