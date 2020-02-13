package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class JoinRoomScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final TextField typeip;
    protected final Label validator;
    protected final Button connect;
    protected final Button arrow;
    protected final ImageView imageView0;

    public JoinRoomScreen() {
        imageView = new ImageView();
        label = new Label();
        typeip = new TextField();
        validator = new Label();
        connect = new Button();
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
        imageView.setImage(new Image(getClass().getResource("images/connect.png").toExternalForm()));

        typeip.setLayoutX(315.0);
        typeip.setLayoutY(244.0);
        typeip.setPrefHeight(43.0);
        typeip.setPrefWidth(239.0);
        typeip.setText("127.0.0.1");
        typeip.getStyleClass().add("txt");
//        typeip.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 18.0));

        label.setLayoutX(135.0);
        label.setLayoutY(244.0);
        label.setText("Ip address");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        label.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 35.0));

        validator.setLayoutX(290.0);
        validator.setLayoutY(320.0);
        validator.setPrefHeight(16.0);
        validator.setPrefWidth(190.0);
        validator.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        validator.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(),12.0));

        connect.setLayoutX(284.0);
        connect.setLayoutY(357.0);
        connect.setMnemonicParsing(false);
        connect.setPrefHeight(59.0);
        connect.setPrefWidth(132.0);
        connect.getStyleClass().add("btn");
        connect.setText("Start");
        connect.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 25.0));
        connect.setOnAction(EventController.JoinRoom.connectOnAction(this));

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.JoinRoom.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(typeip);
        getChildren().add(validator);
        getChildren().add(connect);
        getChildren().add(arrow);
    }

    public void setValidator(String message) {
        validator.setText(message);
    }

    public TextField getIpAddress() {
        return typeip;
    }
}
