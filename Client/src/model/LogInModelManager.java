package model;

import core.ClientFactory;
import mediator.Client;

public class LogInModelManager implements LogInModel{
    private Client client;
    public LogInModelManager(Client client) {
        this.client = client;
    }

    @Override
    public void logIn(String username, String password) {
        client.logIn(username,password);
    }
}
