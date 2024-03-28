package client.mediator;

import share.transferObject.Request;
import share.transferObject.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Client {

    private PropertyChangeSupport support;

    public ClientHandler() {
        this.support = new PropertyChangeSupport(this);
    }

    public void startClient() {
        try {
            Socket socket = new Socket("localhost", 2910);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            new Thread(() -> listenToServer(outputStream, inputStream)).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listenToServer(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        User a = new User("sdd","dfs");
        try {
            outputStream.writeObject(new Request("Listener",a));
            while (true) {
                Request response = (Request) inputStream.readObject();
                support.firePropertyChange(response.getType(),null,response.getObject());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean logIn(String username, String password) {
        User user = new User(username, password);
        Request req = new Request("UserLogin", user);
        try {
            Request response = request(req);
            return true;

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Request request (Request request) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("localhost", 2910);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        outputStream.writeObject(request);
        return  (Request) inputStream.readObject();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }
}
