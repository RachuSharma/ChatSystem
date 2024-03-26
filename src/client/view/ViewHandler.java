package client.view;


import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage stage;
    private Scene logInScene;
    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start() {
        stage = new Stage();
        openLogin();
    }

    private void openLogin() {
        if (logInScene == null){
            try {
                Parent root = loadFXML("./login/LoginView.fxml");
                logInScene = new Scene(root);
                stage.setTitle("Login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        stage.setScene(logInScene);
        stage.show();
    }

    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController controller = loader.getController();
        controller.init(viewModelFactory, this);
        return root;
    }
}
