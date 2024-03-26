package client.core;


import client.model.LogInModel;
import client.model.LogInModelManager;

public class ModelFactory {
    private ClientFactory client;
    private LogInModel logInModel;
    public ModelFactory(ClientFactory client) {
        this.client = client;
    }

    public LogInModel getLogInModel(){
        if ( logInModel == null){
            logInModel = new LogInModelManager(client.getClient());
        }
        return logInModel;
    }
}
