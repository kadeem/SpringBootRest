package de.pifrasso.ui;


/**
 *
 */
@FunctionalInterface
public interface LoginService {
    boolean check(String login, String password);
}
