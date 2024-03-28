package client.view.logIn;


import client.core.ModelFactory;
import client.model.LogInModel;

import java.beans.PropertyChangeEvent;

public class LogInViewModel {
    LogInModel logInModel;

    public LogInViewModel(ModelFactory modelFactory) {
        this.logInModel = modelFactory.getLogInModel();
        logInModel.addListener("NewUserAdded",this::onNewUserAdded);
    }

    private void onNewUserAdded(PropertyChangeEvent propertyChangeEvent) {
        System.out.println(propertyChangeEvent.getNewValue() + " ..--..--....... ");
    }

    public void logIn(String username, String password){
        logInModel.logIn(username,password);
    }
}
