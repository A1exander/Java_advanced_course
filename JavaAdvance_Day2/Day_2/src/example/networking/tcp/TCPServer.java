package example.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by USER on 28.11.2017.
 */
public class TCPServer extends Thread {
    ServerSocket serverSocket;

    TCPServer() {
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server has been started: " + serverSocket.toString());
            start();
        } catch (IOException e) {
            System.out.println("Could not start server: " + e);
        }
    }

    public void run(){
        while(true){
            try {
                System.out.println("Waiting for client...");
                Socket client = serverSocket.accept();
                System.out.println("Client accepted!");
                Connection conn = new Connection(client);
            } catch (IOException e) {
                System.out.println("клиент отсоединился");
            }
        }
    }

    class Connection extends Thread{
        Socket netClient;
        BufferedReader fromClient;
        PrintStream toClient;
        Connection(Socket socket){
            netClient = socket;
            try {
                fromClient = new BufferedReader(new InputStreamReader(netClient.getInputStream()));
                toClient = new PrintStream(netClient.getOutputStream());
            } catch (IOException e) {
                try {
                    netClient.close();
                } catch (IOException e1) {
                    System.err.println("Unable to set up streams: " + e1);
                    return;
                }
            }
            this.start();
        }

        public void run(){
            String login, password;
            try {
                while (true) {
                    System.out.println("Client login request...");
                    toClient.println("Login: ");
                    login = fromClient.readLine();
                    if(login == null || login.equals("Bye")){
                        System.out.println("client exit");
                        return;
                    }else {
                        System.out.println("login accepted: " + login);
                        System.out.println("Client password request...");
                        toClient.println("Paswword: ");
                        password = fromClient.readLine();
                        System.out.println("Client password accepted: " + password);
                        System.out.println("User has been autorized");
                        String clientMessage = fromClient.readLine();
//                        while(!fromClient.equals("Exit")) {
                            System.out.println("from client:" + clientMessage);
//                            clientMessage = fromClient.readLine();
//                        }
                    }
                }
            }catch (IOException e){

            }finally {
                try{
                    netClient.close();
                }catch (IOException e ){

                }
            }
        }
    }

    public static void main(String[] args) {
        new TCPServer();
    }
}
