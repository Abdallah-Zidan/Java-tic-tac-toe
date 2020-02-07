package tictac.animation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;

public class GameOver extends AnchorPane {

    protected final ImageView image;
    protected Image win;
    protected Image loss;
    protected Image tie;
    AudioClip audio;

    public GameOver() {

        image = new ImageView();

        setId("AnchorPane");
        setPrefHeight(456.0);
        setPrefWidth(598.0);

        image.setFitHeight(437.0);
        image.setFitWidth(591.0);
        image.setLayoutX(3.0);
        image.setLayoutY(9.0);
        image.setPickOnBounds(true);
        image.setPreserveRatio(true);
        win = new Image(getClass().getResourceAsStream("Win.gif"));
        loss = new Image(getClass().getResourceAsStream("lossgame.gif"));
        tie = new Image(getClass().getResourceAsStream("tie.gif"));
        getChildren().add(image);

    }

    public void setState(int state) {
        if (state == 1) {
            image.setImage(win);
            audio = new AudioClip(getClass().getResource("win.mp3").toString());
        } else if (state == 2) {
            image.setImage(loss);
            audio = new AudioClip(getClass().getResource("lose.wav").toString());
        } else if (state == 3) {
            image.setImage(tie);
            audio = new AudioClip(getClass().getResource("sad.mp3").toString());
        }
    }

    public void playSound() {
        audio.play();
    }
    public void stopSound() {
        audio.stop();
    }


}
