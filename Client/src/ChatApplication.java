import core.ClientFactory;
import core.ModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import mediator.Client;
import mediator.ClientHandler;
import view.ViewHandler;
import core.ViewModelFactory;

public class ChatApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory client = new ClientFactory();
        ModelFactory modelFactory = new ModelFactory(client);
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start();
    }
}
