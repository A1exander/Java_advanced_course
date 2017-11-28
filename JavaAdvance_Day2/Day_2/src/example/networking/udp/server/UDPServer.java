package example.networking.udp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by USER on 28.11.2017.
 */
public class UDPServer {
    DatagramSocket socket = null;
    DatagramPacket packet;
    InetAddress adress;
    int port;

    String str;
    byte[]buffer;
    BufferedReader in;

    UDPServer()throws IOException{
        socket = new DatagramSocket(8080);
        call();
    }

    private void call() throws  IOException{
        try {
            System.out.println("Server has been started");
            while (true) {
                buffer = new byte[256];
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println("Connect with client is done");
                if(packet == null)break;
                System.out.println("Request string for sending to client");
                in = new BufferedReader(new InputStreamReader(System.in));
                str = in.readLine();

                buffer = str.getBytes();
                adress = packet.getAddress();
                port = packet.getPort();
                packet = new DatagramPacket(buffer, buffer.length, adress, port);
                socket.send(packet);
                System.out.println("Packet has ben sent to adress:" + adress +
                                    ", port: " + port);
            }
        }catch (Exception e){
            System.out.println("что-то пошло не так " + e);
        }
        in.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            new UDPServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
