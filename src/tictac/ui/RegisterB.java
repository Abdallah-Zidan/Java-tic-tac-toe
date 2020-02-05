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

public class RegisterB extends Pane {
    protected final ImageView imageView;
    protected final TextField textField;
    protected final Label label;
    protected final Label label0;
    protected final Button regGo;
    protected final PasswordField passwordField;
    protected final Button button;
    protected final ImageView arrow;

    public RegisterB() {
        imageView = new ImageView();
        textField = new TextField();
        label = new Label();
        label0 = new Label();
        regGo = new Button();
        passwordField = new PasswordField();
        button = new Button();
        arrow = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        getStylesheets().add(getClass().getResource("style.css").toString());

        setPrefHeight(600.0);
        setPrefWidth(325.0);
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(295.0);
        imageView.setFitWidth(301.0);
        imageView.setLayoutX(13.0);
        imageView.setImage(new Image(getClass().getResource("images/filast.png").toExternalForm()));

        textField.setLayoutX(22.0);
        textField.setLayoutY(375.0);
        textField.setPrefHeight(34.0);
        textField.setPrefWidth(284.0);

        label.setLayoutX(44.0);
        label.setLayoutY(321.0);
        label.setText("Enter Your Name");
        label.setTextFill(Color.valueOf("#930a0a"));
        label.setFont(new Font("THORN", 34.0));

        label0.setLayoutX(33.0);
        label0.setLayoutY(432.0);
        label0.setText("Enter Your Password");
        label0.setTextFill(Color.valueOf("#930a0a"));
        label0.setFont(new Font("THORN", 28.0));

        regGo.setLayoutX(125.0);
        regGo.setLayoutY(532.0);
        regGo.setMnemonicParsing(false);
        regGo.getStyleClass().add("btn");
        regGo.setText("Go");
        regGo.setTextFill(Color.valueOf("#930a0a"));
        regGo.setFont(new Font("Cookie Dough", 25.0));
        regGo.setOnAction(EventController.Register.registerOnAction(this));

        passwordField.setLayoutX(22.0);
        passwordField.setLayoutY(475.0);
        passwordField.setPrefHeight(34.0);
        passwordField.setPrefWidth(284.0);

        button.setLayoutX(21.0);
        button.setLayoutY(531.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(34.0);
        button.setPrefWidth(38.0);
        button.getStyleClass().add("arrow");
        button.setOnAction(EventController.Register.backOnAction());

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
        getChildren().add(label0);
        getChildren().add(regGo);
        getChildren().add(passwordField);
        getChildren().add(button);
    }

    public TextField getUsername() {
        return textField;
    }

    public PasswordField getPassword() {
        return passwordField;
    }
}
