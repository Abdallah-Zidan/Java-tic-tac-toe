package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class LoginScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final TextField username;
    protected final Label label1;
    protected final PasswordField pass;
    protected final Label validator;
    protected final Button logGo;
    protected final Button arrow;
    protected final ImageView imageView0;

    public LoginScreen() {
        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        username = new TextField();
        label1 = new Label();
        pass = new PasswordField();
        validator = new Label();
        logGo = new Button();
        arrow = new Button();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        getStylesheets().add(getClass().getResource("style.css").toString());
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(700.0);
        imageView.setImage(new Image(getClass().getResource("images/tex3.jpeg").toExternalForm()));

        label.setLayoutX(154.0);
        label.setPrefHeight(125.0);
        label.setPrefWidth(378.0);
        label.setText("Are you Ready");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
     //   label.setFont(Font.loadFont(getClass().getResource("fonts/BrushKing.otf").toExternalForm(), 31.0));

        label0.setLayoutX(242.0);
        label0.setLayoutY(137.0);
        label0.setPrefHeight(57.0);
        label0.setPrefWidth(222.0);
        label0.setText("Enter Your username");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
       // label0.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 24.0));

        username.setLayoutX(202.0);
        username.setLayoutY(194.0);
        username.setPrefHeight(38.0);
        username.setPrefWidth(296.0);
        username.getStyleClass().add("txt");
       // username.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(),18.0));

        label1.setLayoutX(242.0);
        label1.setLayoutY(248.0);
        label1.setPrefHeight(57.0);
        label1.setPrefWidth(222.0);
        label1.setText("Enter Your Password");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
//        label1.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(),24.0));

        pass.setLayoutX(202.0);
        pass.setLayoutY(305.0);
        pass.setPrefHeight(43.0);
        pass.setPrefWidth(296.0);
        pass.getStyleClass().add("txt");
        pass.setFont(new Font("system", 18.0));

        validator.setLayoutX(255.0);
        validator.setLayoutY(381.0);
        validator.setPrefHeight(16.0);
        validator.setPrefWidth(190.0);
        validator.setTextFill(javafx.scene.paint.Color.valueOf("#f2f2f2"));

        logGo.setDefaultButton(true);
        logGo.setLayoutX(279.0);
        logGo.setLayoutY(421.0);
        logGo.setMnemonicParsing(false);
        logGo.setPrefHeight(57.0);
        logGo.setPrefWidth(128.0);
        logGo.getStyleClass().add("btn");
        logGo.setText("Go");
        logGo.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
//        logGo.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(),24.0));
        logGo.setCursor(Cursor.HAND);
        logGo.setOnAction(EventController.Login.loginOnAction(this));

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.Login.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(username);
        getChildren().add(label1);
        getChildren().add(pass);
        getChildren().add(validator);
        getChildren().add(logGo);
        getChildren().add(arrow);
    }

    public void setValidator(String message) {
        validator.setText(message);
    }

    public TextField getUsername() {
        return username;
    }

    public PasswordField getPassword() {
        return pass;
    }
}
