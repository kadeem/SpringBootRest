package de.pifrasso.ui;


import static com.vaadin.ui.UI.getCurrent;
import com.vaadin.ui.*;

import java.util.Objects;

public class LoginComponent extends Panel {

    private final TextField login = new TextField();
    private final PasswordField password = new PasswordField();
    private final Button ok = new Button();
    private final Button cancel = new Button();
    private final HorizontalLayout buttons = new HorizontalLayout(ok, cancel);

    private final VerticalLayout layout = new VerticalLayout(login, password, buttons);

    public LoginComponent() {
        setCaption("Login required");
        setContent(layout);
        setSizeFull();

        login.setId("login");
        login.setCaption("Login");

        password.setId("password");
        password.setCaption("Password");

        ok.setId("ok");
        ok.setCaption("Ok");
        ok.addClickListener((Button.ClickListener) event -> {
            boolean isValid = checkLoginData(login.getValue(), password.getValue());
            clearInputFields();
            getCurrent().setContent((isValid) ? mainView() : this);
        });

        cancel.setId("cancel");
        cancel.setCaption("Cancel");
        cancel.addClickListener((Button.ClickListener) event -> clearInputFields());
    }

    private void clearInputFields() {
        login.setValue("");
        password.setValue("");
    }

    private boolean checkLoginData(String login, String password) {
        return ! (Objects.isNull(login) || Objects.isNull(password))
                && (! (login.isEmpty() || password.isEmpty())
                && (login.equals("admin") && password.equals("admin")));
    }

    private Component mainView() {
        Button logOut = new Button("LogOut");
        logOut.addClickListener(e -> {
            getCurrent().getSession().close();
            getCurrent().getPage().setLocation("/");
        });
        return logOut;
    }
}
