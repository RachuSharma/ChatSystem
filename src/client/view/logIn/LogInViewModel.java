package client.view.logIn;


import client.core.ModelFactory;
import client.model.LogInModel;

public class LogInViewModel {
    LogInModel logInModel;

    public LogInViewModel(ModelFactory modelFactory) {
        this.logInModel = modelFactory.getLogInModel();
    }

    public void logIn(String username, String password){
        logInModel.logIn(username,password);
    }
}
