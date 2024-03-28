package client.core;


import client.model.ChatModel;
import client.model.ChatModelManager;
import client.model.LogInModel;
import client.model.LogInModelManager;

public class ModelFactory {
    private ClientFactory client;
    private LogInModel logInModel;
    private ChatModel chatModel;
    public ModelFactory(ClientFactory client) {
        this.client = client;
    }

    public LogInModel getLogInModel(){
        if ( logInModel == null){
            logInModel = new LogInModelManager(client.getClient());
        }
        return logInModel;
    }

    public ChatModel getChatModel() {
        if (chatModel == null){
            chatModel = new ChatModelManager(client.getClient());
        }
        return chatModel;
    }
}
