package example.networking.tcp.DateServer.client;

import example.networking.tcp.DateServer.server.DateMessage;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by USER on 28.11.2017.
 */
public class DateClient {
    Socket clientSocket;
    ObjectInputStream in;
    DateMessage message;

    DateClient(){
        try {
            clientSocket = new Socket("localhost", 8080);
            in = new ObjectInputStream(clientSocket.getInputStream());
            message = (DateMessage)in.readObject();
            System.out.println(message.getMessage() + ", " + message.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DateClient();
    }
}
