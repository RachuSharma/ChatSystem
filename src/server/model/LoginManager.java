package server.model;

import share.transferObject.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginManager implements LogIn{
    private PropertyChangeSupport support;

    public LoginManager() {
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public String login(User user) {
        support.firePropertyChange("NewUserAdded" , null, user.getUserName());
        return user.getUserName().toUpperCase();
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
