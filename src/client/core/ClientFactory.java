package client.core;

import client.mediator.Client;
import client.mediator.ClientHandler;

public class ClientFactory {

    private Client client;
    public Client getClient(){
        if ( client == null){
            client = new ClientHandler();
        }
        return client;
    }

}
