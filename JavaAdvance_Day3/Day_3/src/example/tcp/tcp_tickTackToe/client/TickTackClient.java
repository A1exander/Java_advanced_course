package example.tcp.tcp_tickTackToe.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by USER on 29.11.2017.
 */
public class TickTackClient {

    public static void main(String[] args) {
        try {
            while (true) {
                TickTackClient client = new TickTackClient();
                if(!client.wantsToPlayAgain()){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JFrame frame;
    private ImageIcon icon, opponentIcon;
    private JLabel messageLabel;

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    Square[] board = new Square[9];
    Square currentSquare;

    TickTackClient() throws IOException {
        initGUI();
        initLogic();
        play();
    }

    public void play() throws IOException {
        String response = in.readLine();
        if (response.startsWith("WELCOME")) {
            char mark = response.charAt(8);
            icon = new ImageIcon(mark == 'X' ? "x.png" : "o.png");
            opponentIcon = new ImageIcon(mark == 'X' ? "o.png" : "x.png");
            frame.setTitle(frame.getTitle() + ": " + mark);
        }

        while (true) {
            response = in.readLine();
            if (response.startsWith("VALID_MOVE")) {
                messageLabel.setText("Valid move, please wait");
                currentSquare.setIcon(icon);
                currentSquare.repaint();
            } else if (response.startsWith("OPPONENT_MOVED")) {
                int loc = Integer.parseInt(response.substring(15));
                board[loc].setIcon(opponentIcon);
                board[loc].repaint();
                messageLabel.setText("Opponent moved, your turn");
            } else if (response.startsWith("VICTORY")) {
                messageLabel.setText("You win!");
                break;
            } else if (response.startsWith("DEFEAT")) {
                messageLabel.setText("You lose!");
                break;
            } else if (response.startsWith("TIE")) {
                messageLabel.setText("Tie!");
                break;
            } else if (response.startsWith("MESSAGE")) {
                messageLabel.setText(response.substring(8));
            }
        }
        out.println("QUIT");
        socket.close();
    }

    private boolean wantsToPlayAgain() {
        int response = JOptionPane.showConfirmDialog(frame, "Want to play again?", "Again?", JOptionPane.YES_NO_OPTION);
        frame.dispose();
        return response == JOptionPane.YES_OPTION;
    }

    private void initLogic() throws IOException {
        socket = new Socket("localhost", 8080);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    private void initGUI() {
        frame = new JFrame("TickTackToe");
        messageLabel = new JLabel("message label");
        messageLabel.setBackground(Color.lightGray);
        frame.getContentPane().add(messageLabel, BorderLayout.SOUTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3, 2, 2));
        for (int i = 0; i < board.length; i++) {
            final int j = i;
            board[i] = new Square();
            board[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentSquare = board[j];
                    out.println("MOVE " + j);
                }
            });
            boardPanel.add(board[i]);
        }
        frame.getContentPane().add(boardPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation((1920 / 2) - (frame.getWidth() / 2),
                (1080 / 2) - (frame.getHeight() / 2));
        frame.setVisible(true);
    }


    private class Square extends JPanel {
        JLabel label = new JLabel((Icon) null);

        Square() {
            setPreferredSize(new Dimension(128, 128));
            setBackground(Color.white);
            setLayout(new BorderLayout());
            add(label, BorderLayout.CENTER);
        }

        public void setIcon(Icon icon) {
            label.setIcon(icon);
        }
    }
}
