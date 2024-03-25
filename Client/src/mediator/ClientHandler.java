package mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientHandler implements Client{
    @Override
    public boolean logIn(String username, String password) {
        User user = new User(username,password);
        try{
            try {
                Request response = request(user, "addUser");
                return (boolean) response.getObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void startListeningToServer(User user){
        try {
            Socket socket = new Socket("localhost", 9009);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("Starting connection with " + user);

            Thread thread = new Thread(() -> serverConnectionForEach(inputStream,outputStream,user) );
            thread.setDaemon(true);
            thread.start();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void serverConnectionForEach(ObjectInputStream inputStream, ObjectOutputStream outputStream, User user) {
        try {
            System.out.println("Starting connection with " + user);
            outputStream.writeObject(new Request("Listener",user));
            while (true){
                Request response = (Request) inputStream.readObject();
                System.out.println(response.getObject().toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private Request request(Object arg, String type) throws IOException, ClassNotFoundException {
        ObjectOutputStream outToServer;
        ObjectInputStream inFromServer;
        try (Socket socket = new Socket("localhost", 9009)) {
            outToServer = new ObjectOutputStream(socket.getOutputStream());
            inFromServer = new ObjectInputStream(socket.getInputStream());
        }
        outToServer.writeObject(new Request(type, arg));
        return (Request) inFromServer.readObject();
    }
}
