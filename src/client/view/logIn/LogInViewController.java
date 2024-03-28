package client.view.logIn;


import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class LogInViewController implements ViewController {
    @FXML
    private TextField userNameField;
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
        boolean bool  = logInViewModel.logIn(userNameField.getText());
        if (bool){
            viewHandler.openChatView();
        }
        else {
            System.out.println("shut up ");
        }
    }

    //VMF - login method
}
