package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class PrimaryScreen extends Pane {
    protected final ImageView imageView;
    protected final Button register;
    protected final Button login;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;

    public PrimaryScreen() {
        imageView = new ImageView();
        register = new Button();
        login = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setCursor(Cursor.DEFAULT);
        getStylesheets().add(getClass().getResource("style.css").toString());
        getStyleClass().add("pan");

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(700.0);
        imageView.setImage(new Image(getClass().getResource("images/tex3.jpeg").toExternalForm()));

        register.setLayoutX(84.0);
        register.setLayoutY(377.0);
        register.setMnemonicParsing(false);
        register.setPrefHeight(62.0);
        register.setPrefWidth(196.0);
        register.getStyleClass().add("btn");
        register.setText("New Player");
        register.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        register.setWrapText(true);
        register.setCursor(Cursor.HAND);
//        register.setFont(Font.loadFont(getClass().getResource("/tictac/ui/fonts/RushinkDemo.ttf").toExternalForm(), 25.0));
        register.setOnAction(EventController.Primary.registerOnAction());

        login.setLayoutX(414.0);
        login.setLayoutY(377.0);
        login.setMnemonicParsing(false);
        login.setPrefHeight(62.0);
        login.setPrefWidth(196.0);
        login.getStyleClass().add("btn");
        login.setText("Login");
        login.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        login.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        login.setWrapText(true);
        login.setCursor(Cursor.HAND);
//        login.setFont(Font.loadFont(getClass().getResource("/tictac/ui/fonts/RushinkDemo.ttf").toExternalForm(), 25.0));
        login.setOnAction(EventController.Primary.loginOnAction());

        label.setLayoutX(93.0);
        label.setLayoutY(-33.0);
        label.setPrefHeight(253.0);
        label.setPrefWidth(177.0);
        label.setText("Tic ");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
//        label.setFont(Font.loadFont(getClass().getResource("/tictac/ui/fonts/BrushKing.otf").toExternalForm(), 63.0));

        label0.setLayoutX(250.0);
        label0.setLayoutY(140.0);
        label0.setText("Game");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
//        label0.setFont(Font.loadFont(getClass().getResource("/tictac/ui/fonts/BrushKing.otf").toExternalForm(), 63.0));

        label1.setLayoutX(446.0);
        label1.setLayoutY(-33.0);
        label1.setPrefHeight(253.0);
        label1.setPrefWidth(177.0);
        label1.setText("Toe");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
//        label1.setFont(Font.loadFont(getClass().getResource("/tictac/ui/fonts/BrushKing.otf").toExternalForm(), 63.0));

        label2.setLayoutX(259.0);
        label2.setLayoutY(-33.0);
        label2.setPrefHeight(253.0);
        label2.setPrefWidth(177.0);
        label2.setText("Tac");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
//        label2.setFont(Font.loadFont(getClass().getResource("/tictac/ui/fonts/BrushKing.otf").toExternalForm(), 63.0));

        getChildren().add(imageView);
        getChildren().add(register);
        getChildren().add(login);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
    }
}
