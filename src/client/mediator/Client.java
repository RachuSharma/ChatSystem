package client.mediator;

import share.util.Subject;

public interface Client extends Subject {

    void startClient();

    boolean logIn(String username, String password);

}
