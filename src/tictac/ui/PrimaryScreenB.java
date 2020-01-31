package tictac.ui;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class PrimaryScreenB extends AnchorPane {

    protected final Pane pane;
    protected final JFXButton singlePlayer;
    protected final ImageView imageView;
    protected final JFXButton replayOld;
    protected final JFXButton twoPlayer;
    protected final JFXButton quitGame;

    public PrimaryScreenB() {

        pane = new Pane();
        singlePlayer = new JFXButton();
        imageView = new ImageView();
        replayOld = new JFXButton();
        twoPlayer = new JFXButton();
        quitGame = new JFXButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(592.0);
        setPrefWidth(318.0);

        pane.setPrefHeight(590.0);
        pane.setPrefWidth(317.0);
        pane.setStyle("-fx-background-color: #fffff6;");

        singlePlayer.setLayoutX(94.0);
        singlePlayer.setLayoutY(280.0);
        singlePlayer.setStyle("-fx-background-color: #930a0a;");
        singlePlayer.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));
        singlePlayer.setOnAction(EventController.PrimaryScreen.singlePlayerOnAction());

        imageView.setFitHeight(225.0);
        imageView.setFitWidth(232.0);
        imageView.setLayoutX(43.0);
        imageView.setLayoutY(24.0);
        imageView.setImage(new Image(getClass().getResource("filast.png").toExternalForm()));

        replayOld.setLayoutX(94.0);
        replayOld.setLayoutY(429.0);
        replayOld.setStyle("-fx-background-color: #930a0a;");
        replayOld.setFont(new Font("Bubbleboddy Neue Trial Regular", 15.0));
        replayOld.setOnAction(EventController.PrimaryScreen.replayOldOnAction());

        twoPlayer.setLayoutX(94.0);
        twoPlayer.setLayoutY(354.0);
        twoPlayer.setStyle("-fx-background-color: #930a0a;");
        twoPlayer.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));
        twoPlayer.setOnAction(EventController.PrimaryScreen.twoPlayerOnAction());

        quitGame.setLayoutX(94.0);
        quitGame.setLayoutY(505.0);
        quitGame.setStyle("-fx-background-color: #930a0a;");
        quitGame.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));
        quitGame.setOnAction(EventController.PrimaryScreen.quitGameOnAction());

        pane.getChildren().add(singlePlayer);
        pane.getChildren().add(imageView);
        pane.getChildren().add(replayOld);
        pane.getChildren().add(twoPlayer);
        pane.getChildren().add(quitGame);
        getChildren().add(pane);

    }
}
