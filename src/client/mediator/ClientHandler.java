package client.mediator;

import share.model.Request;
import share.model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientHandler implements Client {

    public ClientHandler (){

    }
    public void startClient(){
        try {
            Socket socket = new Socket("localhost",2910);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            new Thread(()-> listenToServer(outputStream, inputStream)).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listenToServer(ObjectOutputStream outputStream, ObjectInputStream inputStream) {

        try {
            while (true){
                Request request = (Request) inputStream.readObject();


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean logIn(String username, String password) {
        User user = new User(username,password);
        Socket socket = null;
        try {
            socket = new Socket("localhost",2910);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("In login");
            outputStream.writeObject(new Request("User",user));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
