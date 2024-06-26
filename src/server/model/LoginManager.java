package server.model;

import share.transferObject.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class LoginManager implements LogIn{
    private PropertyChangeSupport support;
    private ArrayList<User> users;

    public LoginManager() {
        users = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public boolean login(User user) {
        users.add(user);
        support.firePropertyChange("NewUserAdded" , null, users.size());
        return true;
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
