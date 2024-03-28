package client.model;


import client.mediator.Client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LogInModelManager implements LogInModel{
    private Client client;
    PropertyChangeSupport support = new PropertyChangeSupport(this);
    public LogInModelManager(Client client) {
        this.client = client;
        client.startClient();
        client.addListener("NewUserAdded" , this::onNewUserAdded);
    }

    private void onNewUserAdded(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }

    @Override
    public void logIn(String username, String password) {
        client.logIn(username,password);
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
