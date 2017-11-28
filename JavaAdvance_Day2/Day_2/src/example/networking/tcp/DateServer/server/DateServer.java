package example.networking.tcp.DateServer.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created by USER on 28.11.2017.
 */
public class DateServer extends Thread {
    ServerSocket serverSocket = null;

    public DateServer(){
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Date server has been started");
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            while (true) {
                System.out.println("Waiting for client");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted: " + clientSocket);
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                DateMessage dateMessage = new DateMessage(Calendar.getInstance().getTime(),
                                                        "current date on server");
                out.writeObject(dateMessage);
                System.out.println("Date has been sended");
                out.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DateServer();
    }
}
