package client.view.chat;

import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ChatViewController implements ViewController {
    @FXML
    private TextField messageTextArea;
    @FXML
    private TextField random;
    private ViewHandler viewHandler;
    private ChatViewModel chatViewModel;

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) {
        this.chatViewModel = viewModelFactory.getChatViewModel();
        this.viewHandler = viewHandler;
    }

    @FXML
    private void sendMessage(ActionEvent actionEvent) {
        chatViewModel.sendMessage(messageTextArea.getText());
    }
}
