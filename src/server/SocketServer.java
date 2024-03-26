package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class SocketServer {
    void startServer() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);

            while (true) {
                Socket socket = welcomeSocket.accept();
                System.out.println("New Client added ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
