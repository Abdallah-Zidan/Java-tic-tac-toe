package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class PlayScreen extends Pane {
    protected final ImageView imageView;
    protected final Button singlePlayer;
    protected final Button twoPlayer;
    protected final Button playOnline;
    protected final Button savedgames;
    protected final Button arrow;
    protected final ImageView imageView0;
    protected final Button about;
    protected final ImageView imageView1;
    protected final Button exit;
    protected final ImageView imageView2;

    public PlayScreen() {
        imageView = new ImageView();
        singlePlayer = new Button();
        twoPlayer = new Button();
        playOnline = new Button();
        savedgames = new Button();
        arrow = new Button();
        imageView0 = new ImageView();
        about = new Button();
        imageView1 = new ImageView();
        exit = new Button();
        imageView2 = new ImageView();
        
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
        imageView.setImage(new Image(getClass().getResource("images/newgame.png").toExternalForm()));

        singlePlayer.setLayoutX(225.0);
        singlePlayer.setLayoutY(179.0);
        singlePlayer.setMnemonicParsing(false);
        singlePlayer.setPrefHeight(55.0);
        singlePlayer.setPrefWidth(227.0);
        singlePlayer.getStyleClass().add("btn");
        singlePlayer.setText("Single Player");
        singlePlayer.setTextFill(javafx.scene.paint.Color.WHITE);
        singlePlayer.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(),24.0));
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
        twoPlayer.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(),24.0));
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
        playOnline.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(),24.0));
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
        savedgames.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(),24.0));
        savedgames.setCursor(Cursor.HAND);
        savedgames.setOnAction(EventController.Play.savedOnAction());

        arrow.setLayoutX(82.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(20.0);
        arrow.setPrefWidth(10.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.Play.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);
        
        about.setLayoutX(20.0);
        about.setLayoutY(14.0);
        about.setMnemonicParsing(false);
        about.getStyleClass().add("arrow");
        about.setOnAction(EventController.Play.aboutOnAction());

        imageView1.setFitHeight(42.0);
        imageView1.setFitWidth(44.0);
        imageView1.setImage(new Image(getClass().getResource("images/about.png").toExternalForm()));
        about.setGraphic(imageView1);
        about.setCursor(Cursor.HAND);
        
        exit.setLayoutX(8.0);
        exit.setLayoutY(420.0);
        exit.setMnemonicParsing(false);
        exit.getStyleClass().add("exit");
        exit.setCursor(Cursor.HAND);
        exit.setOnAction(EventController.Play.exitOnAction());

        imageView2.setFitHeight(55.0);
        imageView2.setFitWidth(45.0);
        imageView2.setImage(new Image(getClass().getResource("images/exit.png").toExternalForm()));
        exit.setGraphic(imageView2);

        getChildren().add(imageView);
        getChildren().add(singlePlayer);
        getChildren().add(twoPlayer);
        getChildren().add(playOnline);
        getChildren().add(savedgames);
        getChildren().add(arrow);
        getChildren().add(about);
        getChildren().add(exit);
    }
}
