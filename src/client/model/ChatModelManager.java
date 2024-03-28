package client.model;

import client.mediator.Client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatModelManager implements ChatModel{
    private final Client client;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ChatModelManager(Client client) {
        this.client = client;
        client.addListener("NewMessageAdded",this::onNewMessageAdded);
    }

    private void onNewMessageAdded(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);

    }


    @Override
    public String sendMessage(String text) {
        return  client.sendMessage(text);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }

}
