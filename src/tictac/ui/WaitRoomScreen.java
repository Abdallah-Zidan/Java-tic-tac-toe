package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class WaitRoomScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final ImageView imageView0;
    protected final Button arrow;
    protected final ImageView imageView1;

    public WaitRoomScreen() {
        imageView = new ImageView();
        label = new Label();
        imageView0 = new ImageView();
        arrow = new Button();
        imageView1 = new ImageView();

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

        label.setLayoutX(104.0);
        label.setText("Wait For Connecting");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        label.setFont(Font.loadFont(getClass().getResource("fonts/BrushKing.otf").toExternalForm(), 30.0));

        imageView0.setFitHeight(409.0);
        imageView0.setFitWidth(542.0);
        imageView0.setLayoutX(79.0);
        imageView0.setLayoutY(77.0);
        imageView0.setImage(new Image(getClass().getResource("images/3g.gif").toExternalForm()));

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.WaitRoom.backOnAction());

        imageView1.setFitHeight(67.0);
        imageView1.setFitWidth(63.0);
        imageView1.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView1);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(imageView0);
        getChildren().add(arrow);

    }
}
