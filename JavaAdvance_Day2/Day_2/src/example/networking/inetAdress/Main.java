package example.networking.inetAdress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by USER on 28.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        try {
            InetAddress adress = InetAddress.getLocalHost();
            String adressHost = adress.getHostAddress();
            String hostName = adress.getHostName();
            System.out.println("IP_localhost " + adressHost + "\n host_name " + hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
