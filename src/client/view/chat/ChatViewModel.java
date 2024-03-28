package client.view.chat;

import client.core.ModelFactory;
import client.model.ChatModel;

import java.beans.PropertyChangeEvent;

public class ChatViewModel {
    private ChatModel chatModel;

    public ChatViewModel(ModelFactory modelFactory) {
        this.chatModel = modelFactory.getChatModel();
        chatModel.addListener("NewMessageAdded",this::onNewChatAdded);
    }

    private void onNewChatAdded(PropertyChangeEvent propertyChangeEvent) {
        System.out.println(propertyChangeEvent.getNewValue() + " in view model ");
    }


    public void sendMessage(String text) {
        chatModel.sendMessage(text);
    }
}
