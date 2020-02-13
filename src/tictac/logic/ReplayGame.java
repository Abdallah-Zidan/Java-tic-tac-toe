package tictac.logic;

import java.util.ArrayList;
import tictac.database.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import tictac.ui.GameBodyScreen;
import tictac.ui.PrimaryScreen;

public class ReplayGame {

    int counter;
    ReplayTimer timer;
    int gameId;
    GameBodyScreen ui;
    char myMark;
    char oppenentMark;
    User user;
    Player oppenent;
    Button[][] buttons;
    ArrayList<Step> steps = null;

    public ReplayGame(Player oppenent, User user, char myMark, int gameId, GameBodyScreen ui) {
        counter = 0;
        this.gameId = gameId;
        this.user = user;
        this.oppenent = oppenent;
        this.myMark = myMark;
        if (myMark == Constants.CROSS) {
            oppenentMark = Constants.CIRCLE;
        } else {
            oppenentMark = Constants.CROSS;
        }
        this.buttons = ui.getBoardButtons();
        this.steps = GameModel.getSteps(gameId);
        this.ui = ui;
        if (steps != null && steps.size() > 0) {
            timer = new ReplayTimer();
            timer.start();
        }
        ui.getPlayAgainBtn().setVisible(false);
        PrimaryScreen.stopSound();

    }

    public void startReplay() {
       
        if (counter >= steps.size()) {
            timer.stop();
            if (steps.size() >= 5) {
                ui.highlightButtons(1);
            }

        } else {
            ui.setText(buttons[steps.get(counter).getX()][steps.get(counter).getY()], steps.get(counter).getTurn().equals("mine") ? myMark : oppenentMark);
            counter++;
        }

    }

    class ReplayTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
            if (steps != null && steps.size() > 0) {
                startReplay();
            }
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

}
