package example.networking.TCPSimpleChat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by USER on 28.11.2017.
 */
public class ChatClient {
    public static void main(String[] args) {
        new ChatClient();
    }
    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private BufferedReader in;
    private PrintWriter out;

    ChatClient(){
        initGUI();
        initLogic();
    }

    private String getServerAdress(){
        return JOptionPane.showInputDialog(frame, "Input host IP",
                            "Server chooser", JOptionPane.QUESTION_MESSAGE);
    }

    private String getName(){
        return JOptionPane.showInputDialog(frame, "Choose name", "Name chooser", JOptionPane.PLAIN_MESSAGE);
    }

    private void initLogic() {
        String serverAdress = getServerAdress();
        try {
            Socket socket = new Socket(serverAdress, 8080);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            while (true){
                String line = in.readLine();
                if(line.startsWith("submit name")){
                    String name = getName();
                    out.println(name);
                    frame.setTitle(name);
                }else if(line.startsWith("name accepted")){
                    textField.setEditable(true);
                }else if(line.startsWith("message ")){
                    textArea.append(line.substring(8) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initGUI() {
        frame = new JFrame("SimpleChat");
        textArea = new JTextArea(10,40);
        textField = new JTextField(40);
        textArea.setEditable(false);
        textField.setEditable(false);

        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((1920 / 2) - (frame.getWidth() / 2),
                        (1080 / 2) - (frame.getWidth() / 2));
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
        frame.setVisible(true);
    }


}
