/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Rola
 */
public class ServerGUI extends JFrame {

    private int x, y, z;
    private int k;
    private String[] board = new String[9]; // tic-tac-toe board
    private JTextArea outputArea;
    private PlayerTest[] players;
    private Server server = new Server();
    private int currentPlayer;
    private final static int PLAYER_X = 0;
    private final static int PLAYER_O = 1;
    private final static String[] MARKS = {"X", "O"};
    private ExecutorService runGame;
    private Lock gameLock;
    private Condition otherPlayerConnected; // to wait for other player
    private Condition otherPlayerTurn; // to wait for other player's turn

    public ServerGUI() {
        super("Tic-Tac-Toe Server");
        runGame = Executors.newFixedThreadPool(2);
        gameLock = new ReentrantLock();
        otherPlayerConnected = gameLock.newCondition();
        otherPlayerTurn = gameLock.newCondition();
        for (int i = 0; i < 9; i++) {
            board[i] = new String("");
        }
        players = new PlayerTest[2];
        currentPlayer = PLAYER_X;
        server.setPort(12345);
        server.startServer();
        board[0] = "a";
        board[1] = "b";
        board[2] = "c";
        board[3] = "d";
        board[4] = "e";
        board[5] = "f";
        board[6] = "g";
        board[7] = "h";
        board[8] = "i";
        outputArea = new JTextArea();
        add(outputArea, BorderLayout.CENTER);
        outputArea.setText("Server awaiting connections\n");
        setSize(300, 300);
        setVisible(true);
    }

    public void execute() {
        for (int i = 0; i < players.length; i++) {
            try {
                players[i] = new PlayerTest(server.getListener().accept(), i);
                runGame.execute(players[i]);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }
        gameLock.lock();
        try {
            players[PLAYER_X].setSuspended(false);
            otherPlayerConnected.signal();
        } finally {
            gameLock.unlock(); // unlock game after signalling player X
        }
    }

    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                outputArea.append(messageToDisplay);
            }
        }
        );
    }

    // determine if move is valid
    public boolean validateAndMove(int location, int player) {
        // while not current player, must wait for turn
        while (player != currentPlayer) {
            gameLock.lock(); // lock game to wait for other player to go

            try {
                otherPlayerTurn.await(); // wait for player's turn
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                gameLock.unlock(); // unlock game after waiting
            }
        }

        if (!isOccupied(location)) {
            if (isGameOver()) {
                return false;
            }
            board[location] = MARKS[currentPlayer];

            players[currentPlayer].playermov(location);

            currentPlayer = (currentPlayer + 1) % 2; // change player

            // let new current player know that move occurred
            players[currentPlayer].otherPlayerMoved(location);

            gameLock.lock(); // lock game to signal other player to go

            try {
                otherPlayerTurn.signal(); // signal other player to continue
            } finally {
                if (!isGameOver()) {
                    gameLock.unlock(); // unlock game after signaling
                } else {
                    players[currentPlayer].output.format("Game over %s won\n", board[x]);
                    players[currentPlayer].output.flush();
                    gameLock.lock();

                }

            }
            return true;
        } else {
            return false;
        }
    }

    // determine whether location is occupied
    public boolean isOccupied(int location) {
        if (board[location].equals(MARKS[PLAYER_X])
                || board[location].equals(MARKS[PLAYER_O])) {
            return true; // location is occupied
        } else {
            return false;
        }
    }

    public boolean isGameOver() {

        x = 0;
        y = 1;
        z = 2;

        if (board[x].equals(board[y]) && board[x].equals(board[z])) {
            return true;
        }
        x = 0;
        y = 3;
        z = 6;
        if (board[x].equals(board[y]) && board[x].equals(board[z])) {
            return true;
        }
        x = 0;
        y = 4;
        z = 8;
        if (board[x].equals(board[y]) && board[x].equals(board[z])) {
            return true;
        }
        x = 1;
        y = 4;
        z = 7;
        if (board[x].equals(board[y]) && board[x].equals(board[z])) {
            return true;
        }
        x = 2;
        y = 5;
        z = 8;
        if (board[x].equals(board[y]) && board[x].equals(board[z])) {
            return true;
        }
        x = 3;
        y = 4;
        z = 5;
        if (board[x].equals(board[y]) && board[x].equals(board[z])) {
            return true;
        }
        x = 6;
        y = 7;
        z = 8;
        if (board[x].equals(board[y]) && board[x].equals(board[z])) {
            return true;
        }
        x = 2;
        y = 4;
        z = 6;
        if (board[x].equals(board[y]) && board[x].equals(board[z])) {
            return true;
        }

        return false;
    }

    // private inner class Player manages each Player as a runnable
    private class PlayerTest implements Runnable {

        private Socket connection;
        private Scanner input;
        private Formatter output;
        private int playerNumber;
        private String mark;
        private boolean suspended = true;

        public PlayerTest(Socket socket, int number) {
            playerNumber = number;
            mark = MARKS[playerNumber];
            connection = socket;
            try {
                input = new Scanner(connection.getInputStream());
                output = new Formatter(connection.getOutputStream());
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }

        public void playermov(int loc) {
            output.format("Your move is done" + "\n");
            output.format("%d\n", loc);
            output.flush();
        }
        // send message that other player moved

        public void otherPlayerMoved(int location) {
            output.format("Opponent moved\n");
            output.format("%d\n", location); // send location of move
            output.flush(); // flush output                            
        }

        public void run() {
            // send client its mark (X or O), process messages from client
            try {
                displayMessage("Player " + mark + " connected\n");
                output.format("%s\n", mark); // send player's mark
                output.flush(); // flush output                     

                if (playerNumber == PLAYER_X) {
                    output.format("%s\n%s", "Player X connected",
                            "Waiting for another player\n");
                    output.flush(); // flush output               

                    gameLock.lock(); // lock game to wait for second player

                    try {
                        while (suspended) {
                            otherPlayerConnected.await(); // wait for player O
                        }
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    } finally {
                        gameLock.unlock(); // unlock game after second player
                    }

                    // send message that other player connected
                    output.format("Other player connected. Your move.\n");
                    output.flush(); // flush output                         
                } // end if
                else {
                    output.format("Player O connected, please wait\n");
                    output.flush();
                }

                // while game not over
                while (!isGameOver()) {
                    int location = 0;

                    if (input.hasNext()) {
                        location = input.nextInt(); // get move location
                    }                  // check for valid move
                    if (validateAndMove(location, playerNumber)) {
                        displayMessage("\nlocation: " + location);
                        output.format("Valid move in %d\n", location);
                        output.flush();
                    } else {
                        output.format("Invalid move, try again\n");
                        output.flush();
                    }
                    if (isGameOver()) {
                        output.format("Game over  %s won\n", board[x]);
                        output.flush();
                    }
                }
            } finally {
                try {
                    connection.close();  // close connection to client
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.exit(1);
                }
            }
        }

        public void setSuspended(boolean status) {
            suspended = status;
        }
    }

}
