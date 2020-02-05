package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class PrimaryB extends Pane {
    protected final ImageView imageView;
    protected final Button register;
    protected final Button login;

    public PrimaryB() {
        imageView = new ImageView();
        register = new Button();
        login = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(325.0);
        getStylesheets().add(getClass().getResource("style.css").toString());
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(327.0);
        imageView.setFitWidth(325.0);
        imageView.setImage(new Image(getClass().getResource("images/filast.png").toExternalForm()));

        register.setLayoutX(65.0);
        register.setLayoutY(377.0);
        register.setMnemonicParsing(false);
        register.setPrefHeight(62.0);
        register.setPrefWidth(196.0);
        register.getStyleClass().add("btn");
        register.setText("Register New Player");
        register.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        register.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        register.setWrapText(true);
        register.setFont(new Font("Cookie Dough", 20.0));
        register.setCursor(Cursor.HAND);
        register.setOnAction(EventController.Primary.registerOnAction());

        login.setLayoutX(65.0);
        login.setLayoutY(480.0);
        login.setMnemonicParsing(false);
        login.setPrefHeight(62.0);
        login.setPrefWidth(196.0);
        login.getStyleClass().add("btn");
        login.setText("Login");
        login.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        login.setCursor(Cursor.HAND);
        login.setFont(new Font("Cookie Dough", 20.0));
        login.setOnAction(EventController.Primary.loginOnAction());

        setCursor(Cursor.DEFAULT);

        getChildren().add(imageView);
        getChildren().add(register);
        getChildren().add(login);
    }
}
