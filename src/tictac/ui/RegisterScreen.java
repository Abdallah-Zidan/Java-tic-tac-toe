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

public class RegisterScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final TextField fname;
    protected final Label label1;
    protected final TextField lname;
    protected final Label label2;
    protected final TextField username;
    protected final PasswordField pass;
    protected final Label validator;
    protected final Button regGo;
    protected final Button arrow;
    protected final ImageView imageView0;

    public RegisterScreen() {
        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        fname = new TextField();
        label1 = new Label();
        lname = new TextField();
        label2 = new Label();
        username = new TextField();
        pass = new PasswordField();
        validator = new Label();
        regGo = new Button();
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
        imageView.setImage(new Image(getClass().getResource("images/reg.png").toExternalForm()));

        label.setLayoutX(160.0);
        label.setLayoutY(153.0);
        label.setText("First Name");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        label.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 24.0));

        fname.setLayoutX(303.0);
        fname.setLayoutY(153.0);
        fname.setPrefHeight(34.0);
        fname.setPrefWidth(245.0);
        fname.getStyleClass().add("txt");
        fname.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 22.0));

        label0.setLayoutX(160.0);
        label0.setLayoutY(205.0);
        label0.setText("Last Name");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        label0.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 25.0));

        lname.setLayoutX(303.0);
        lname.setLayoutY(206.0);
        lname.setPrefHeight(34.0);
        lname.setPrefWidth(245.0);
        lname.getStyleClass().add("txt");
        lname.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 22.0));

        label1.setLayoutX(160.0);
        label1.setLayoutY(259.0);
        label1.setText("Username");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        label1.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 25.0));

        username.setLayoutX(303.0);
        username.setLayoutY(261.0);
        username.setPrefHeight(34.0);
        username.setPrefWidth(245.0);
        username.getStyleClass().add("txt");
        username.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 22.0));

        label2.setLayoutX(160.0);
        label2.setLayoutY(317.0);
        label2.setText("Password");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        label2.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 25.0));

        pass.setLayoutX(303.0);
        pass.setLayoutY(315.0);
        pass.setPrefHeight(34.0);
        pass.setPrefWidth(245.0);
        pass.getStyleClass().add("txt");
        pass.setFont(new Font("system", 22.0));

        validator.setLayoutX(280.0);
        validator.setLayoutY(381.0);
        validator.setPrefHeight(16.0);
        validator.setPrefWidth(190.0);
        validator.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        validator.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(),12.0));

        regGo.setDefaultButton(true);
        regGo.setLayoutX(279.0);
        regGo.setLayoutY(421.0);
        regGo.setMnemonicParsing(false);
        regGo.setPrefHeight(57.0);
        regGo.setPrefWidth(128.0);
        regGo.getStyleClass().add("btn");
        regGo.setText("Go");
        regGo.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        regGo.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 24.0));
        regGo.setCursor(Cursor.HAND);
        regGo.setOnAction(EventController.Register.registerOnAction(this));

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.Register.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(fname);
        getChildren().add(label1);
        getChildren().add(lname);
        getChildren().add(label2);
        getChildren().add(username);
        getChildren().add(pass);
        getChildren().add(validator);
        getChildren().add(regGo);
        getChildren().add(arrow);
    }

    public void setValidator(String message) {
        validator.setText(message);
    }

    public TextField getFirstName() {
        return fname;
    }

    public TextField getLastName() {
        return lname;
    }

    public TextField getUsername() {
        return username;
    }

    public PasswordField getPassword() {
        return pass;
    }
}
