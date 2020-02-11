package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class PlayScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final Button singlePlayer;
    protected final Button twoPlayer;
    protected final Button playOnline;
    protected final Button savedgames;
    protected final Button arrow;
    protected final ImageView imageView0;

    public PlayScreen() {
        imageView = new ImageView();
        label = new Label();
        singlePlayer = new Button();
        twoPlayer = new Button();
        playOnline = new Button();
        savedgames = new Button();
        arrow = new Button();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        getStylesheets().add(getClass().getResource("style.css").toString());
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(507.0);
        imageView.setFitWidth(700.0);
        imageView.setImage(new Image(getClass().getResource("images/tex3.jpeg").toExternalForm()));

        label.setLayoutX(106.0);
        label.setLayoutY(-10.0);
        label.setPrefHeight(161.0);
        label.setPrefWidth(488.0);
        label.setText("Play New Game");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
//        label.setFont(Font.loadFont(getClass().getResource("fonts/BrushKing.otf").toExternalForm(), 40.0));

        singlePlayer.setLayoutX(225.0);
        singlePlayer.setLayoutY(179.0);
        singlePlayer.setMnemonicParsing(false);
        singlePlayer.setPrefHeight(55.0);
        singlePlayer.setPrefWidth(227.0);
        singlePlayer.getStyleClass().add("btn");
        singlePlayer.setText("Single Player");
        singlePlayer.setTextFill(javafx.scene.paint.Color.WHITE);
//        singlePlayer.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(),24.0));
        singlePlayer.setCursor(Cursor.HAND);
        singlePlayer.setOnAction(EventController.Play.singleOnAction());

        twoPlayer.setLayoutX(226.0);
        twoPlayer.setLayoutY(254.0);
        twoPlayer.setMnemonicParsing(false);
        twoPlayer.setPrefHeight(55.0);
        twoPlayer.setPrefWidth(227.0);
        twoPlayer.getStyleClass().add("btn");
        twoPlayer.setText("Two Player");
        twoPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
//        twoPlayer.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(),24.0));
        twoPlayer.setCursor(Cursor.HAND);
        twoPlayer.setOnAction(EventController.Play.twoOnAction());

        playOnline.setLayoutX(226.0);
        playOnline.setLayoutY(327.0);
        playOnline.setMnemonicParsing(false);
        playOnline.setPrefHeight(55.0);
        playOnline.setPrefWidth(227.0);
        playOnline.getStyleClass().add("btn");
        playOnline.setText("Play Online");
        playOnline.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
//        playOnline.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(),24.0));
        playOnline.setCursor(Cursor.HAND);
        playOnline.setOnAction(EventController.Play.onlineOnAction());

        savedgames.setLayoutX(227.0);
        savedgames.setLayoutY(403.0);
        savedgames.setMnemonicParsing(false);
        savedgames.setPrefHeight(55.0);
        savedgames.setPrefWidth(227.0);
        savedgames.getStyleClass().add("btn");
        savedgames.setText("Saved Games");
        savedgames.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
//        savedgames.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(),24.0));
        savedgames.setCursor(Cursor.HAND);
        savedgames.setOnAction(EventController.Play.savedOnAction());

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.Play.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(singlePlayer);
        getChildren().add(twoPlayer);
        getChildren().add(playOnline);
        getChildren().add(savedgames);
        getChildren().add(arrow);
    }
}
