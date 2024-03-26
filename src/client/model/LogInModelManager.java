package client.model;


import client.mediator.Client;

public class LogInModelManager implements LogInModel{
    private Client client;
    public LogInModelManager(Client client) {
        this.client = client;
        //client.startClient();


    }

    @Override
    public void logIn(String username, String password) {
        client.logIn(username,password);
    }
}
