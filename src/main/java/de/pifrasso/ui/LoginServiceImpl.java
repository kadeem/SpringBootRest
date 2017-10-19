package de.pifrasso.ui;

import java.util.Objects;
/**
 *
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean check(String login, String password) {
        return ! Objects.isNull(login) && ! Objects.isNull(password)
                && (
                (login.equals("admin") && password.equals("admin"))
                        || (login.equals("max") && password.equals("max"))

        );
    }
}
