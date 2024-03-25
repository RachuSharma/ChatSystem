package view.logIn;

import core.ModelFactory;
import model.LogInModel;

public class LogInViewModel {
    LogInModel logInModel;

    public LogInViewModel(ModelFactory modelFactory) {
        this.logInModel = modelFactory.getLogInModel();
    }

    public void logIn(String username, String password){
        logInModel.logIn(username,password);
    }
}
