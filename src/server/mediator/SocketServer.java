package server.mediator;

import server.model.ChatManager;
import server.model.LogIn;
import server.model.LoginManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ChatManager chatManager;
    private LogIn loginManager;
    public SocketServer() {
        this.loginManager = new LoginManager();
        this.chatManager = new ChatManager();
    }

    public void startServer() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);

            while (true) {
                Socket socket = welcomeSocket.accept();
                new Thread(new SocketHandler(socket, loginManager,chatManager)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
