package tictac.logic;

import java.io.*;
import java.net.Socket;
import tictac.database.*;
import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.util.Duration;
import tictac.animation.GameOver;
import tictac.ui.GameBodyB;

/*
this is an abstract class thatcontains the main attributes and methods of the game
regardless of it type
 */
public abstract class Game {

    protected Board board;
    protected boolean gameEnded;
    protected boolean myTurn;
    protected boolean isRecorded; // if the player wants to record the game or not 
    protected String game_type;
    protected Player oppenent;
    protected User user;
    protected char oppenentMark; // ( x or o)
    protected char myMark;  // ( x or o )
    protected ArrayList<Step> steps; // the moves in order to replay them later if the game is recorded
    protected Button[][] buttons; // board buttons in the game play
    protected GameBodyB ui; // simple ui for testing
    protected int gameId;

    Game(boolean isRecorded, String gameType, Player oppenent, User user, char myMark, GameBodyB ui) {
        this.ui = ui;
        buttons = ui.getBoardButtons();
        gameEnded = false;
        myTurn = true;
        board = new Board();
        this.isRecorded = isRecorded;
        this.game_type = gameType;
        this.oppenent = oppenent;
        this.user = user;
        this.myMark = myMark;
        if (myMark == Constants.Circle) {
            oppenentMark = Constants.Cross;
        } else {
            oppenentMark = Constants.Circle;
        }
        if (isRecorded) {
            steps = new ArrayList<>();
        }

    }

    public boolean isMyTurn() {
        return myTurn;
    }

    /*
    this method is responsible for adding action events on the game buttons
     */
    public void startActionHandling() {
        buttons[0][0].setOnAction((ActionEvent event) -> {play(0, 0);});
        buttons[0][1].setOnAction((ActionEvent event) -> {play(0, 1);});
        buttons[0][2].setOnAction((ActionEvent event) -> {play(0, 2);});
        buttons[1][0].setOnAction((ActionEvent event) -> {play(1, 0);});
        buttons[1][1].setOnAction((ActionEvent event) -> {play(1, 1);});
        buttons[1][2].setOnAction((ActionEvent event) -> {play(1, 2);});
        buttons[2][0].setOnAction((ActionEvent event) -> {play(2, 0);});
        buttons[2][1].setOnAction((ActionEvent event) -> {play(2, 1);});
        buttons[2][2].setOnAction((ActionEvent event) -> {play(2, 2);});
    }

    // disable the game buttons when game ends
    public void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(true);
            }
        }
    }

    public void enableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(false);
            }

        }
    }

    protected int evaluateGame() {
        GameState gameState = board.getGameState(myMark, oppenentMark);
        int retval = 4;
        gameEnded = true;
        switch (gameState) {
            case YouWin:
                System.out.println("You Won!");
                retval = 1;
                break;
            case OppWin:
                System.out.println("openent Won!");
                retval = 2;
                break;
            case Draw:
                System.out.println("Draw!");
                retval = 3;
                break;
            default:
                gameEnded = false;
                retval = 4;
                break;
        }
        return retval;
    }

    // check if clicked position is available or not ... if available return it
    Position makeMove(int x, int y) {
        Position position = null;
        position = new Position(y, x);
        if (board.isMarked(position)) {
            position = null;
        }
        return position;
    }

    // draw the marks on the buttons X or O after each move
    public void drawBoardOnButtons(Board board) {
        ui.resetButtons();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char sign = board.getBoard()[j][i];
                if (sign != 'e') {
                    if (isRecorded) {
                        boolean recorded = false;
                        for (Step step : steps) {
                            if (step.getX() == i && step.getY() == j) {
                                recorded = true;
                                break;
                            }
                        }
                        if (!recorded) {
                            recordStep(i, j, "oponent");
                        }
                    }

                    ui.setText(buttons[i][j], sign);
                }

            }
        }
    }

    private void highlightTrio(Button btn1, Button btn2, Button btn3, int state) {
        ui.highLight(btn1, state);
        ui.highLight(btn2, state);
        ui.highLight(btn3, state);
    }

    // highlight the winning buttons at the end of the game
    public void highlightButtons(int state) {

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText())) {
            highlightTrio(buttons[0][0], buttons[1][1], buttons[2][2], state);
        } else if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText())) {
            highlightTrio(buttons[0][2], buttons[1][1], buttons[2][0], state);
        } else {
            for (int x = 0; x < 3; x++) {
                String st1 = buttons[x][0].getText(), st2 = buttons[x][1].getText(), st3 = buttons[x][2].getText();
                if (st1.equals(st2) && st1.equals(st3) && st1.equals("X") || st1.equals(st2) && st1.equals(st3) && st1.equals("O")) {
                    highlightTrio(buttons[x][0], buttons[x][1], buttons[x][2], state);
                    break;
                }
            }
            for (int y = 0; y < 3; y++) {
                String st1 = buttons[0][y].getText(), st2 = buttons[1][y].getText(), st3 = buttons[2][y].getText();
                if (st1.equals(st2) && st1.equals(st3) && st1.equals("X") || st1.equals(st2) && st1.equals(st3) && st1.equals("O")) {
                    highlightTrio(buttons[0][y], buttons[1][y], buttons[2][y], state);
                    break;
                }
            }
        }
    }

    // show the game end results to the user
    public void showResult(int result) {
        GameOver showEnd;
        showEnd = new GameOver();
        final Stage endStage = showEnd.prepareEndStage(ui);
        PauseTransition delay;
        switch (result) {
            case 1:
                 highlightButtons(1);
                showEnd.showStage(1, endStage , ui);
                user.victory();
                saveGame("victory");
                break;
            case 2:
                 highlightButtons(2);
                showEnd.showStage(2, endStage,ui);
                saveGame("loss");
                break;
            case 3:
                showEnd.showStage(3, endStage,ui);
                saveGame("draw");
                user.draw();
                break;
        }
        delay = new PauseTransition(Duration.seconds(4));
        delay.setOnFinished(event -> {
            endStage.close();
        });
        delay.play();
       
    }

    // save the game if recorded into the database using GameModel
    public void saveGame(String result) {
        if (isRecorded) {
            GameModel game = new GameModel(game_type, myMark, oppenent.getId(), user.getId(), 3, result);
            game.save();
            gameId = game.getId();
            saveSteps();
        }
    }

    // record Step
    public void recordStep(int x, int y, String turn) {
        if (isRecorded) {
            steps.add(new Step(x, y, 5, turn));
        }

    }

    // save the steps at the end of the game
    public void saveSteps() {
        for (Step step : steps) {
            step.save();
        }
    }

    public void closeGame(Socket socket, DataInputStream dis, PrintStream ps) {
        try {
            ps.close();
            dis.close();
            if (socket != null) {
                socket.close();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void clearButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                ui.highLight(buttons[i][j], 11);
            }
        }
    }

    public void closeGame(DataInputStream dis, PrintStream ps) {
        try {
            ps.close();
            dis.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void resetGame(boolean enabled) {
        board = new Board();
        myTurn = true;
        clearButtons();
        gameEnded = false;
        enableButtons();
        ui.playSound();
    }

    // abstract method that should be implemented to specify how the game is played in single or two players mode
    abstract public void play(int x, int y);
}
