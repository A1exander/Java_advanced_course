package example.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by USER on 28.11.2017.
 */
public class TCPClient {
    Socket clientSocket;
    BufferedReader in, consoleIn;
    PrintStream out;

    TCPClient(){
        try {
            clientSocket = new Socket("localhost", 8080);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintStream(clientSocket.getOutputStream());

            consoleIn = new BufferedReader(new InputStreamReader(System.in));
            String login = in.readLine();
            System.out.println(login);
            String logName = consoleIn.readLine();
            out.println(logName);

            String pass = in.readLine();
            System.out.println(pass);
            String password = consoleIn.readLine();
            out.println(password);

            String str = in.readLine();
            System.out.println(str);

            while((str = consoleIn.readLine()) != null){
                out.println(str);
                if(str.equals("Bye")){
                    break;
                }
            }

            out.close();
            in.close();
            consoleIn.close();
        } catch (UnknownHostException e) {
            System.out.println("Unknown adress");
        }catch (IOException e){
            System.out.println("Something wrong");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new TCPClient();
    }
}
