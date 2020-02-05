package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tictac.controllers.EventController;
import tictac.database.User;

public class LoginB extends Pane {
    protected final ImageView imageView;
    protected final TextField textField;
    protected final Label label;
    protected final Button logGo;
    protected final Button button;
    protected final ImageView arrow;

    public LoginB() {
        imageView = new ImageView();
        textField = new TextField();
        label = new Label();
        logGo = new Button();
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

        imageView.setFitHeight(326.0);
        imageView.setFitWidth(325.0);
        imageView.setImage(new Image(getClass().getResource("images/filast.png").toExternalForm()));

        textField.setLayoutX(34.0);
        textField.setLayoutY(446.0);
        textField.setPrefHeight(38.0);
        textField.setPrefWidth(257.0);

        label.setLayoutX(57.0);
        label.setLayoutY(391.0);
        label.setText("Enter Your Name");
        label.setTextFill(Color.valueOf("#930a0a"));
        label.setFont(new Font("THORN", 30.0));

        logGo.setLayoutX(124.0);
        logGo.setLayoutY(541.0);
        logGo.setMnemonicParsing(false);
        logGo.setPrefHeight(38.0);
        logGo.setPrefWidth(77.0);
        logGo.getStyleClass().add("btn");
        logGo.setText("Go");
        logGo.setTextFill(Color.valueOf("#930a0a"));
        logGo.setFont(new Font("Cookie Dough", 24.0));
        logGo.setOnAction(EventController.Login.loginOnAction(this));

        button.setLayoutX(31.0);
        button.setLayoutY(542.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(34.0);
        button.setPrefWidth(38.0);
        button.getStyleClass().add("arrow");
        button.setOnAction(EventController.Login.backOnAction());

        arrow.setFitHeight(32.0);
        arrow.setFitWidth(33.0);
        arrow.getStyleClass().add("arrow");
        arrow.setImage(new Image(getClass().getResource("images/arrow.png").toExternalForm()));
        arrow.setCursor(Cursor.HAND);
        button.setGraphic(arrow);
        button.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(textField);
        getChildren().add(label);
        getChildren().add(logGo);
        getChildren().add(button);
    }

    public TextField getUsername() {
        return textField;
    }
}
