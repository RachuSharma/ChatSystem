package core;

import mediator.Client;
import mediator.ClientHandler;

public class ClientFactory {
    private Client client;

    public Client getClient(){
        if ( client == null){
            client = new ClientHandler();
        }
        return client;
    }

}
