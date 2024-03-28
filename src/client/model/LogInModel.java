package client.model;

import share.util.Subject;

public interface LogInModel extends Subject {
    boolean logIn(String username);
}
