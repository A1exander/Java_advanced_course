package example.networking.TCPSimpleChat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

/**
 * Created by USER on 28.11.2017.
 */
public class ChatServer {

    public static void main(String[] args) {
        new ChatServer();
    }

    private ServerSocket server;
    private HashSet<String>names;
    private HashSet<PrintWriter>writers;

    ChatServer(){
        try {
            names = new HashSet();
            writers = new HashSet();
            server = new ServerSocket(8080);
            System.out.println("Chat server has been started: " + server);
            while (true){
                System.out.println("Waiting for user...");
                Client client = new Client(server.accept());
                System.out.println("User connected: " + client.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class Client extends Thread{
        private String name, input;
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        Client(Socket socket){
            this.clientSocket = socket;
            this.start();
        }

        public void run(){
            try{
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                while (true){
                    System.out.println("waiting name");
                    out.println("submit name");
                    name = in.readLine();
                    if(name == null){
                        return;
                    }
                    synchronized (names) {
                        names.add(name);
                        break;
                    }
                }
                System.out.println("name accepted");
                out.println("name accepted");
                writers.add(out);

                while (true){
                    input = in.readLine();
                    if(input == null){
                        return;
                    }
                    for(PrintWriter writer : writers){
                        writer.println("message " + name + ": " + input);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            finally {
                if(name != null){
                    names.remove(name);
                }
                if(out != null){
                    writers.remove(out);
                }
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        @Override
        public String toString(){
            return name + ": " + clientSocket;
        }


    }
}
