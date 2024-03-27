package server.mediator;

import server.model.LogIn;
import share.transferObject.Request;
import share.transferObject.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable {
    private Socket socket;
    private LogIn loginManager;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    public SocketHandler(Socket socket, LogIn loginManager) {
        this.socket = socket;
        this.loginManager = loginManager;
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
            if(request.getType().equals("UserLogin")){
                String result = loginManager.login((User) request.getObject());
                User user = new User(result, ((User) request.getObject()).getPassword());
                outToClient.writeObject(new Request("UserLogin", user ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
