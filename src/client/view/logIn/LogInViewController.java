package client.view.logIn;


import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class LogInViewController implements ViewController {
    private LogInViewModel logInViewModel;
    private ViewHandler viewHandler;


    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) {
        this.logInViewModel = viewModelFactory.getLogInViewModel();
        this.viewHandler = viewHandler;
    }

    // login (username, password )
    public void  buttonClicked(){
    }

    @FXML
    private void signInClicked(ActionEvent actionEvent) {
        logInViewModel.logIn("CHana","sdklnf");
    }

    //VMF - login method
}
