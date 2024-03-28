package client.core;


import client.view.chat.ChatViewModel;
import client.view.logIn.LogInViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LogInViewModel logInViewModel;
    private ChatViewModel chatViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LogInViewModel getLogInViewModel() {
        if (logInViewModel == null){
            logInViewModel = new LogInViewModel(modelFactory);
        }
        return logInViewModel;
    }

    public ChatViewModel getChatViewModel() {
        if (chatViewModel == null){
            chatViewModel = new ChatViewModel(modelFactory);
        }
        return chatViewModel;
    }
}
