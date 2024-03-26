package client.core;


import client.view.logIn.LogInViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LogInViewModel logInViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LogInViewModel getLogInViewModel() {
        if (logInViewModel == null){
            logInViewModel = new LogInViewModel(modelFactory);
        }
        return logInViewModel;
    }
}
