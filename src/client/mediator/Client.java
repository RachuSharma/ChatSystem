package client.mediator;

public interface Client {

    void startClient();

    boolean logIn(String username, String password);
}
