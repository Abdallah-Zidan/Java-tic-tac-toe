package tictac.animation;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import tictac.ui.GameBodyScreen;

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
        switch (state) {
            case 1:
                image.setImage(win);
                audio = new AudioClip(getClass().getResource("win.mp3").toString());
                break;
            case 2:
                image.setImage(loss);
                audio = new AudioClip(getClass().getResource("lose.wav").toString());
                break;
            case 3:
                image.setImage(tie);
                audio = new AudioClip(getClass().getResource("tie.mp3").toString());
                break;
            default:
                break;
        }
    }

    public void playSound() {
        audio.play();
    }

    public void stopSound() {
        audio.stop();
    }

    public Stage prepareEndStage(GameBodyScreen ui) {
        final Stage endStage = new Stage();
        endStage.initModality(Modality.WINDOW_MODAL);
        endStage.initStyle(StageStyle.UNDECORATED);
        Window window = ui.getScene().getWindow();
        double width = window.getWidth();
        double height = window.getHeight();
        endStage.initOwner(window);
        endStage.setX(window.getX());
        endStage.setY(window.getY());
        endStage.setWidth(width);
        endStage.setHeight(height);
        image.setFitWidth(width);
        image.setFitHeight(height);
        endStage.setResizable(false);
        return endStage;
    }
    
    public void showStage(int state, Stage stage  ,GameBodyScreen ui) {
        ui.stopSound();
        this.setState(state);
        this.playSound();
        Scene endScene = new Scene(this);
        stage.setScene(endScene);
        stage.show();
    }
}
