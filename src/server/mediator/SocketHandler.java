package server.mediator;

import server.model.Chat;
import server.model.LogIn;
import share.transferObject.Request;
import share.transferObject.User;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable {
    private Socket socket;
    private LogIn loginManager;
    private Chat chatManager;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    public SocketHandler(Socket socket, LogIn loginManager,Chat chatManager) {
        this.socket = socket;
        this.loginManager = loginManager;
        this.chatManager = chatManager;
        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            Request request = (Request) inFromClient.readObject();
            if (request.getType().equals("Listener")){
                loginManager.addListener("NewUserAdded",this::onNewUserAdded);
                chatManager.addListener("NewMessageAdded",this::onNewMessageAdded);

            }
            else if(request.getType().equals("UserLogin")){
                boolean wasLoginSuccessful = loginManager.login((User) request.getObject());
                outToClient.writeObject(new Request("LogIn", wasLoginSuccessful));

            } else if (request.getType().equals("NewMessage")) {
                String response = chatManager.addMessage((String)request.getObject());
                outToClient.writeObject(new Request("NewMessageAdded",(String)request.getObject()));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void onNewMessageAdded(PropertyChangeEvent propertyChangeEvent) {
        try {
            outToClient.writeObject(new Request(propertyChangeEvent.getPropertyName(),propertyChangeEvent.getNewValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void onNewUserAdded(PropertyChangeEvent propertyChangeEvent) {
        try {
            outToClient.writeObject(new Request(propertyChangeEvent.getPropertyName(),propertyChangeEvent.getNewValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
