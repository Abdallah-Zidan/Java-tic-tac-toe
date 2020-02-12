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
import tictac.ui.GameBodyScreen;
import tictac.ui.PrimaryScreen;

/*
this is an abstract class thatcontains the main attributes and methods of the game
regardless of it type
 */
public abstract class Game {
    protected Board board;
    protected boolean gameEnded;
    protected boolean myTurn;
    protected boolean isRecorded;
    protected String game_type;
    protected Player oppenent;
    protected User user;
    protected char oppenentMark;
    protected char myMark;
    protected ArrayList<Step> steps;
    protected Button[][] buttons;
    protected GameBodyScreen ui;
    protected int gameId;
    protected int level;

    Game(boolean isRecorded, String gameType, Player oppenent, User user, char myMark, int level, GameBodyScreen ui) {
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
        this.level = level;
        if (myMark == Constants.CIRCLE) {
            oppenentMark = Constants.CROSS;
        } else {
            oppenentMark = Constants.CIRCLE;
        }
        if (isRecorded) {
            steps = new ArrayList<>();
        }
        ui.getPlayAgainBtn().setVisible(false);
        PrimaryScreen.stopSound();
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    /*
    this method is responsible for adding action events on the game buttons
     */
    public void startActionHandling() {
        buttons[0][0].setOnAction((ActionEvent event) -> {play(0, 0); });
        buttons[0][1].setOnAction((ActionEvent event) -> {play(0, 1);});
        buttons[0][2].setOnAction((ActionEvent event) -> {play(0, 2);});
        buttons[1][0].setOnAction((ActionEvent event) -> {play(1, 0);});
        buttons[1][1].setOnAction((ActionEvent event) -> {play(1, 1);});
        buttons[1][2].setOnAction((ActionEvent event) -> {play(1, 2);});
        buttons[2][0].setOnAction((ActionEvent event) -> {play(2, 0);});
        buttons[2][1].setOnAction((ActionEvent event) -> {play(2, 1);});
        buttons[2][2].setOnAction((ActionEvent event) -> {play(2, 2);});
    }

    protected int evaluateGame() {
        GameState gameState = board.getGameState(myMark, oppenentMark);
        int retval;
        gameEnded = true;
        switch (gameState) {
            case YouWin:
                System.out.println("You Won!");
                retval = 1;
                break;
            case YouLose:
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
        if (gameEnded) {
            ui.getPlayAgainBtn().setVisible(true);
        }
        return retval;
    }

    // check if clicked position is available or not ... if available return it
    Position makeMove(int x, int y) {
        Position position;
        position = new Position(y, x);
        if (board.isMarked(position)) {
            position = null;
        }
        return position;
    }
    // show the game end results to the user

    public void showResult(int result) {
        GameOver showEnd;
        showEnd = new GameOver();
        final Stage endStage = showEnd.prepareEndStage(ui);
        PauseTransition delay;
        switch (result) {
            case 1:
                ui.highlightButtons(1);
                showEnd.showStage(1, endStage, ui);
                user.victory();
                saveGame("victory");
                break;
            case 2:
                ui.highlightButtons(2);
                showEnd.showStage(2, endStage, ui);
                saveGame("loss");
                break;
            case 3:
                showEnd.showStage(3, endStage, ui);
                saveGame("draw");
                user.draw();
                break;
        }
        delay = new PauseTransition(Duration.seconds(4));
        delay.setOnFinished(event -> {endStage.close();});
        delay.play();
    }

    // save the game if recorded into the database using GameModel
    public void saveGame(String result) {
        String nivel = "";
        if (isRecorded) {
            if (game_type.equals(Constants.SOLO)) {
                if (level == Constants.EASY) {
                    nivel = "easy";
                } else if (level == Constants.HARD) {
                    nivel = "hard";
                }
            } else {
                nivel = "no level";
            }
            GameModel game = new GameModel(game_type, myMark, oppenent.getId(), user.getId(), result, nivel);
            game = game.save();
            gameId = game.getId();
            saveSteps(gameId);
        }
    }

    // record Step
    public void recordStep(int x, int y, String turn) {
        if (isRecorded) {
            steps.add(new Step(x, y, turn));
        }

    }

    // save the steps at the end of the game
    public void saveSteps(int gameId) {
        steps.stream().map((step) -> {
            step.setGameId(gameId);
            return step;
        }).forEachOrdered((step) -> {
            step.save();
        });
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

    public void resetGame(boolean enabled) {
        board = new Board();
        myTurn = true;
        ui.clearButtons();
        if(isRecorded){
            steps = new ArrayList<>();
        }
        gameEnded = false;
        ui.enableButtons();
        ui.getPlayAgainBtn().setVisible(false);
        ui.playSound();
    }

    // abstract method that should be implemented to specify how the game is played in single or two players mode
    abstract public void play(int x, int y);
}
