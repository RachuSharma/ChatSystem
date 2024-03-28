package server.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ChatManager implements Chat{
    private  PropertyChangeSupport support;
    private ArrayList<String> chats;

    public ChatManager() {
        this.chats = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);

    }

    @Override
    public String addMessage(String object) {
        chats.add(object);
        support.firePropertyChange("NewMessageAdded",null,object);
        return object;
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
