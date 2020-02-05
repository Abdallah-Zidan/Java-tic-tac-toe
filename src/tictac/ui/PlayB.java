package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class PlayB extends Pane {
    protected final ImageView imageView;
    protected final Button singlePlayer;
    protected final Button twoPlayer;
    protected final Button playOnline;
    protected final Button replay;
    protected final Button button;
    protected final ImageView arrow;

    public PlayB() {
        imageView = new ImageView();
        singlePlayer = new Button();
        twoPlayer = new Button();
        playOnline = new Button();
        replay = new Button();
        button = new Button();
        arrow = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(325.0);
        getStylesheets().add(getClass().getResource("style.css").toString());
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(254.0);
        imageView.setFitWidth(248.0);
        imageView.setLayoutX(39.0);
        imageView.setLayoutY(14.0);
        imageView.setImage(new Image(getClass().getResource("images/filast.png").toExternalForm()));

        singlePlayer.setLayoutX(75.0);
        singlePlayer.setLayoutY(287.0);
        singlePlayer.setMnemonicParsing(false);
        singlePlayer.setPrefHeight(55.0);
        singlePlayer.setPrefWidth(175.0);
        singlePlayer.getStyleClass().add("btn");
        singlePlayer.setText("Single Player");
        singlePlayer.setTextFill(Color.valueOf("#930a0a"));
        singlePlayer.setFont(new Font("Cookie Dough", 17.0));
        singlePlayer.setOnAction(EventController.Play.singleOnAction());

        twoPlayer.setLayoutX(76.0);
        twoPlayer.setLayoutY(362.0);
        twoPlayer.setMnemonicParsing(false);
        twoPlayer.setPrefHeight(55.0);
        twoPlayer.setPrefWidth(175.0);
        twoPlayer.getStyleClass().add("btn");
        twoPlayer.setText("Two Player");
        twoPlayer.setTextFill(Color.valueOf("#930a0a"));
        twoPlayer.setFont(new Font("Cookie Dough", 17.0));
        twoPlayer.setOnAction(EventController.Play.twoOnAction());

        playOnline.setLayoutX(76.0);
        playOnline.setLayoutY(435.0);
        playOnline.setMnemonicParsing(false);
        playOnline.setPrefHeight(55.0);
        playOnline.setPrefWidth(175.0);
        playOnline.getStyleClass().add("btn");
        playOnline.setText("Play Online");
        playOnline.setTextFill(Color.valueOf("#930a0a"));
        playOnline.setFont(new Font("Cookie Dough", 18.0));
        playOnline.setOnAction(EventController.Play.onlineOnAction());

        replay.setLayoutX(77.0);
        replay.setLayoutY(511.0);
        replay.setMnemonicParsing(false);
        replay.setPrefHeight(55.0);
        replay.setPrefWidth(175.0);
        replay.getStyleClass().add("btn");
        replay.setText("Replay Old");
        replay.setTextFill(Color.valueOf("#930a0a"));
        replay.setFont(new Font("Cookie Dough", 20.0));
        replay.setOnAction(EventController.Play.replayOnAction());

        button.setLayoutX(13.0);
        button.setLayoutY(544.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(34.0);
        button.setPrefWidth(38.0);
        button.getStyleClass().add("arrow");
        button.setOnAction(EventController.Play.backOnAction());

        arrow.setFitHeight(32.0);
        arrow.setFitWidth(33.0);
        arrow.getStyleClass().add("arrow");
        arrow.setImage(new Image(getClass().getResource("images/arrow.png").toExternalForm()));
        arrow.setCursor(Cursor.HAND);
        button.setGraphic(arrow);
        button.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(singlePlayer);
        getChildren().add(twoPlayer);
        getChildren().add(playOnline);
        getChildren().add(replay);
        getChildren().add(button);
    }
}
