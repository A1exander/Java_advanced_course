package example.networking.udp.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by USER on 28.11.2017.
 */
public class UDPClient {
    DatagramSocket socket;
    DatagramPacket packet;
    InetAddress adress;
    byte[]buffer;
    BufferedReader br;
    String str, str2;

    UDPClient() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            socket = new DatagramSocket();
            adress = InetAddress.getByName("localhost");
            buffer = new byte[256];
            packet = new DatagramPacket(buffer, buffer.length, adress, 8080);
            System.out.println("установка соединения...");
            socket.send(packet);
            System.out.println("Соединение установлено, ожидание ответа от сервера...");
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            System.out.println("Ответ пришел...");
            str = new String(packet.getData());
            System.out.println("Ответ: " + str.trim());

            System.out.println("Do you wanna continue?(yes/no)");
            str2 = br.readLine();

            if(str2.equals("no"))break;
        }
        socket.close();
    }

    public static void main(String[] args) {
        try {
            new UDPClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
