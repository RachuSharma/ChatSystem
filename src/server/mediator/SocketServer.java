package server.mediator;

import server.model.LogIn;
import server.model.LoginManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private LogIn loginManager;
    public SocketServer() {
        this.loginManager = new LoginManager();
    }

    public void startServer() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);

            while (true) {
                Socket socket = welcomeSocket.accept();
                new Thread(new SocketHandler(socket, loginManager)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
