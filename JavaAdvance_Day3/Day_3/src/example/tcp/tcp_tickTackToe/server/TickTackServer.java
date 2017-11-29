package example.tcp.tcp_tickTackToe.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by USER on 29.11.2017.
 */
public class TickTackServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("TickTack server has been started: " + server);
            while (true) {
                GameBoard gameBoard = new GameBoard(server);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GameBoard {
    Player currentPlayer;
    Player[] board = {null, null, null,
                      null, null, null,
                      null, null, null};

    GameBoard(ServerSocket server) throws IOException{
        System.out.println("Gameboard has been created;");
        System.out.println("Waiting for players...");
        Player playerX = new Player(server.accept(), 'X');
        Player playerO = new Player(server.accept(), 'O');
        System.out.println("Players accepted!");
        playerX.setOpponent(playerO);
        playerO.setOpponent(playerX);
        currentPlayer = playerX;
        playerX.start();
        playerO.start();
        System.out.println("Game start");
    }

    public synchronized boolean legalMove(int location, Player player){
        if(player == currentPlayer && board[location] == null){
            board[location] = currentPlayer;
            currentPlayer = currentPlayer.opponent;
            currentPlayer.opponentMove(location);
            return true;
        }
        return false;
    }

    public boolean boardIsFilled(){
        for(int i = 0; i < board.length; i++){
            if(board[i] == null){
                return  false;
            }
        }
        return true;
    }

    public  boolean hasWinner(){
        return(board[0] != null && board[0] == board[1] && board[0] == board[2]) ||
                (board[3] != null && board[3] == board[4] && board[3] == board[5]) ||
                (board[6] != null && board[6] == board[7] && board[7] == board[8]) ||
                (board[0] != null && board[0] == board[3] && board[0] == board[6]) ||
                (board[1] != null && board[1] == board[4] && board[1] == board[7]) ||
                (board[2] != null && board[2] == board[5] && board[2] == board[8]) ||
                (board[0] != null && board[0] == board[4] && board[0] == board[8]) ||
                (board[2] != null && board[2] == board[4] && board[2] == board[6]);
    }

    private class Player extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private char mark;
        private Player opponent;


        Player(Socket socket, char mark) {
            this.socket = socket;
            this.mark = mark;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("WELCOME " + mark);
                out.println("MESSAGE Waiting for opponent");
            } catch (IOException e) {
                System.out.println("Disconnect player: " + mark);
            }
        }

        public void setOpponent(Player opponent) {
            this.opponent = opponent;
        }

        public void opponentMove(int location){
            out.println("OPPONENT_MOVED " + location);
            out.println(hasWinner() ? "DEFEAT" : boardIsFilled() ? "TIE" : "");
        }

        public void run() {
            try {
                out.println("All players has been connected");
                if (mark == 'X') {
                    out.println("MESSAGE X: your move");
                }
                while (true) {
                    String command = in.readLine();
                    if (command.startsWith("MOVE")) {
                        int location = Integer.parseInt(command.substring(5));
                        if(legalMove(location, this)){
                            out.println("VALID_MOVE");
                            out.println(hasWinner() ? "VICTORY" : boardIsFilled() ? "TIE" : "");
                        }else{
                            out.println("MESSAGE Move is not valid, try again");
                        }
                    }else if(command.startsWith("QUIT")){
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("Disconnect player: " + mark);
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
