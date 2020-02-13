package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class CreateRoomScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final Label ipshow;
    protected final Button create;
    protected final Button arrow;
    protected final ImageView imageView0;

    public CreateRoomScreen() {
        imageView = new ImageView();
        label = new Label();
        ipshow = new Label();
        create = new Button();
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
        imageView.setImage(new Image(getClass().getResource("images/create.png").toExternalForm()));

        ipshow.setLayoutX(360.0);
        ipshow.setLayoutY(237.0);
        ipshow.setText("127.0.0.1");
        ipshow.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        ipshow.setFont(Font.loadFont(getClass().getResource("fonts/BoughiesDemo.ttf").toExternalForm(), 28.0));

        label.setLayoutX(172.0);
        label.setLayoutY(247.0);
        label.setText("IP Address");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        label.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 35.0));

        create.setLayoutX(275.0);
        create.setLayoutY(398.0);
        create.setMnemonicParsing(false);
        create.setPrefHeight(52.0);
        create.setPrefWidth(119.0);
        create.getStyleClass().add("btn");
        create.setText("Start");
        create.setCursor(Cursor.HAND);
        create.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 23.0));
        create.setOnAction(EventController.CreateRoom.createOnAction());

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.CreateRoom.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(ipshow);
        getChildren().add(create);
        getChildren().add(arrow);
    }

    public void setIpAddress(String ip) {
        ipshow.setText(ip);
    }
}
