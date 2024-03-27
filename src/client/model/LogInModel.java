package client.model;

import share.util.Subject;

public interface LogInModel extends Subject {
    void logIn(String username, String password);
}
