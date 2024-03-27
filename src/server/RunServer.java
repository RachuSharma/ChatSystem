package server;

import server.mediator.SocketServer;

public class RunServer {
    public static void main(String[] args) {

        SocketServer ss = new SocketServer();
        ss.startServer();
    }
}
