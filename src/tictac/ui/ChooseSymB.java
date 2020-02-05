package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import tictac.controllers.EventController;

public class ChooseSymB extends Pane {
    protected final Label label;
    protected final Button xPlayer;
    protected final Button oPlayer;
    protected final Button startPlay;
    protected final Button arrow;
    protected final ImageView imageView;

    public ChooseSymB(String screen) {
        label = new Label();
        xPlayer = new Button();
        oPlayer = new Button();
        startPlay = new Button();
        arrow = new Button();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(325.0);
        getStylesheets().add(getClass().getResource("style.css").toString());
        setStyle("-fx-background-color: white;");

        label.setLayoutX(22.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(188.0);
        label.setPrefWidth(289.0);
        label.setText("Choose Your Game Side");
        label.setTextAlignment(TextAlignment.CENTER);
        label.setTextFill(Color.valueOf("#930a0a"));
        label.setWrapText(true);
        label.setFont(new Font("THORN", 53.0));

        xPlayer.setLayoutX(-2.0);
        xPlayer.setLayoutY(257.0);
        xPlayer.setMnemonicParsing(false);
        xPlayer.setPrefHeight(166.0);
        xPlayer.setPrefWidth(204.0);
        xPlayer.getStyleClass().add("sym");
        xPlayer.setText("X");
        xPlayer.setTextFill(Color.valueOf("#930a0a"));
        xPlayer.setCursor(Cursor.HAND);
        xPlayer.setFont(new Font("Bubbleboddy Neue Trial Regular", 96.0));
        xPlayer.setOnAction(EventController.ChooseSymbol.xOnAction(screen));

        oPlayer.setLayoutX(132.0);
        oPlayer.setLayoutY(254.0);
        oPlayer.setMnemonicParsing(false);
        oPlayer.setPrefHeight(105.0);
        oPlayer.setPrefWidth(93.0);
        oPlayer.getStyleClass().add("sym");
        oPlayer.setText("O");
        oPlayer.setCursor(Cursor.HAND);
        oPlayer.setFont(new Font("Bubbleboddy Neue Trial Regular", 96.0));
        oPlayer.setOnAction(EventController.ChooseSymbol.oOnAction(screen));

        startPlay.setLayoutX(100.0);
        startPlay.setLayoutY(487.0);
        startPlay.setMnemonicParsing(false);
        startPlay.setPrefHeight(44.0);
        startPlay.setPrefWidth(87.0);
        startPlay.getStyleClass().add("btn");
        startPlay.setText("Start");
        startPlay.setTextFill(Color.valueOf("#930a0a"));
        startPlay.setFont(new Font("Cookie Dough", 24.0));

        arrow.setLayoutX(18.0);
        arrow.setLayoutY(532.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(34.0);
        arrow.setPrefWidth(38.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.ChooseSymbol.backOnAction());

        imageView.setFitHeight(32.0);
        imageView.setFitWidth(33.0);
        imageView.getStyleClass().add("arrow");
        imageView.setImage(new Image(getClass().getResource("images/arrow.png").toExternalForm()));
        imageView.setCursor(Cursor.HAND);
        arrow.setGraphic(imageView);

        getChildren().add(label);
        getChildren().add(xPlayer);
        getChildren().add(oPlayer);
        getChildren().add(startPlay);
        getChildren().add(arrow);
    }
}
