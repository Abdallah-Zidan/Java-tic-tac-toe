package tictac.logic;

import tictac.database.*;
import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tictac.animation.GameOver;


/*
this is an abstract class thatcontains the main attributes and methods of the game
regardless of it type
 */
public abstract class Game {

    protected Board board;
    protected boolean gameEnded;
    protected boolean myTurn;
    protected boolean isRecorded; // if the player wants to record the game or not 
    // game type : Solo or dual (using Constants.SOLO || Constant.DUAL)
    protected String game_type;
    protected Player oppenent;
    protected User user;
    protected char oppenentMark; // ( x or o)
    protected char myMark;  // ( x or o )
    protected ArrayList<Step> steps; // the moves in order to replay them later if the game is recorded
    protected Button[][] buttons; // board buttons in the game play
    protected GameTestUi ui; // simple ui for testing
    protected GameOver endUi; // what will be shown to the player at the end of the game
    protected int gameId;

    Game(boolean isRecorded, String gameType, Player oppenent, User user, char myMark, GameTestUi ui, GameOver endUi) {
        this.ui = ui;
        this.endUi = endUi;
        buttons = ui.getBoardButtons();
        gameEnded = false;
        myTurn = true;
        board = new Board();
        this.isRecorded = isRecorded;
        this.game_type = gameType;
        this.oppenent = oppenent;
        this.user = user;
        this.myMark = myMark;
        if (myMark == PlayerSign.Circle) {
            oppenentMark = PlayerSign.Cross;
        } else {
            oppenentMark = PlayerSign.Circle;
        }
        if (isRecorded) {
            steps = new ArrayList<>();
        }

    }

    /*
    this method is responsible for adding action events on the game buttons
     */
    public void startActionHandling() {
        buttons[0][0].setOnAction((ActionEvent event) -> {
            play(0, 0);
        });

        buttons[0][1].setOnAction((ActionEvent event) -> {
            play(0, 1);
        });

        buttons[0][2].setOnAction((ActionEvent event) -> {
            play(0, 2);
        });

        buttons[1][0].setOnAction((ActionEvent event) -> {
            play(1, 0);
        });
        buttons[1][1].setOnAction((ActionEvent event) -> {
            play(1, 1);
        });
        buttons[1][2].setOnAction((ActionEvent event) -> {
            play(1, 2);
        });
        buttons[2][0].setOnAction((ActionEvent event) -> {
            play(2, 0);
        });
        buttons[2][1].setOnAction((ActionEvent event) -> {
            play(2, 1);
        });
        buttons[2][2].setOnAction((ActionEvent event) -> {
            play(2, 2);
        });
    }

    // disable the game buttons when game ends
    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(true);
            }

        }
    }

    // check if someone won or there is a draw 
    protected int evaluateGame() {
        GameState gameState = board.getGameState(myMark, oppenentMark);
        int retval = 4;
        gameEnded = true;
        switch (gameState) {
            case YouWin:
                System.out.println("You Won!");
                retval = 1;
                disableButtons();
                break;
            case OppWin:
                System.out.println("openent Won!");
                retval = 2;
                disableButtons();
                break;
            case Draw:
                System.out.println("Draw!");
                retval = 3;
                disableButtons();
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

    // highlight the winning buttons at the end of the game
    public void highlightButtons() {
        // check diagonal 
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText())) {
            ui.highLight(buttons[0][0]);
            ui.highLight(buttons[1][1]);
            ui.highLight(buttons[2][2]);
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText())) {
            ui.highLight(buttons[0][2]);
            ui.highLight(buttons[1][1]);
            ui.highLight(buttons[2][0]);

        }
        //Check row
        for (int x = 0; x < 3; x++) {
            if (buttons[x][0].getText().equals(buttons[x][1].getText()) && buttons[x][0].getText().equals(buttons[x][2].getText())) {
                ui.highLight(buttons[x][0]);
                ui.highLight(buttons[x][1]);
                ui.highLight(buttons[x][2]);
                break;
            }
        }

        //Check col
        for (int y = 0; y < 3; y++) {
            if (buttons[0][y].getText().equals(buttons[1][y].getText()) && buttons[0][y].getText().equals(buttons[2][y].getText())) {
                ui.highLight(buttons[0][y]);
                ui.highLight(buttons[1][y]);
                ui.highLight(buttons[2][y]);
                break;
            }
        }
    }

    // show the game end results to the user
    public void showResult(int result) {
        final Stage endStage = new Stage();
        endStage.initModality(Modality.WINDOW_MODAL);
        endStage.initStyle(StageStyle.UNDECORATED);
        endStage.initOwner(ui.getScene().getWindow());
        endStage.setResizable(false);
        Scene endScene;
        PauseTransition delay;
        switch (result) {
            case 1:
                highlightButtons();
                endUi.setState(1);
                saveGame("victory");
                user.victory();
                endScene = new Scene(endUi);
                endStage.setScene(endScene);
                endStage.show();
                break;
            case 2:
                highlightButtons();
                saveGame("loss");
                endUi.setState(2);
                endScene = new Scene(endUi);
                endStage.setScene(endScene);
                endStage.show();
                break;
            case 3:
                saveGame("draw");
                user.draw();
                endUi.setState(3);
                endScene = new Scene(endUi);
                endStage.setScene(endScene);
                endStage.show();
                break;
        }
        delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(event -> endStage.close());
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
        steps.add(new Step(x, y, 5, turn));
    }
    // save the steps at the end of the game
    public void saveSteps() {
        for (Step step : steps) {
            step.save();
        }
    }

    // abstract method that should be implemented to specify how the game is played in single or two players mode
    abstract public void play(int x, int y);
}
