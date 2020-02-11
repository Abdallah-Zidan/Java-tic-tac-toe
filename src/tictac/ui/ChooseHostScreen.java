package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class ChooseHostScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final Button createRoom;
    protected final Button joinRoom;
    protected final Button arrow;
    protected final ImageView imageView0;

    public ChooseHostScreen() {
        imageView = new ImageView();
        label = new Label();
        createRoom = new Button();
        joinRoom = new Button();
        arrow = new Button();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        getStylesheets().add(getClass().getResource("style.css").toString());

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(700.0);
        imageView.setImage(new Image(getClass().getResource("images/tex3.jpeg").toExternalForm()));

        label.setLayoutX(198.0);
        label.setLayoutY(53.0);
        label.setText("Play Online");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
//        label.setFont(Font.loadFont(getClass().getResource("fonts/BrushKing.otf").toExternalForm(), 35.0));

        createRoom.setLayoutX(122.0);
        createRoom.setLayoutY(297.0);
        createRoom.setMnemonicParsing(false);
        createRoom.setPrefHeight(56.0);
        createRoom.setPrefWidth(164.0);
        createRoom.getStyleClass().add("btn");
        createRoom.setText("Create Room");
  //      createRoom.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 21.0));
        createRoom.setOnAction(EventController.ChooseHost.createOnAction());

        joinRoom.setLayoutX(415.0);
        joinRoom.setLayoutY(297.0);
        joinRoom.setMnemonicParsing(false);
        joinRoom.setPrefHeight(56.0);
        joinRoom.setPrefWidth(164.0);
        joinRoom.getStyleClass().add("btn");
        joinRoom.setText("Enter Room");
    //    joinRoom.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 19.0));
        joinRoom.setOnAction(EventController.ChooseHost.joinOnAction());

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.ChooseHost.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(createRoom);
        getChildren().add(joinRoom);
        getChildren().add(arrow);
    }
}
