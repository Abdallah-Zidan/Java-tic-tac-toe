package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class PrimaryScreen extends Pane {
    protected final ImageView imageView;
    protected final Button register;
    protected final Button login;
    protected final Button about;
    protected final ImageView imageView0;
    static AudioClip audio;
    public PrimaryScreen() {
        imageView = new ImageView();
        register = new Button();
        login = new Button();
        about = new Button();
        imageView0 = new ImageView();

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
        imageView.setImage(new Image(getClass().getResource("images/pri.png").toExternalForm()));

        register.setLayoutX(84.0);
        register.setLayoutY(377.0);
        register.setMnemonicParsing(false);
        register.setPrefHeight(62.0);
        register.setPrefWidth(196.0);
        register.getStyleClass().add("btn");
        register.setText("New User");
        register.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        register.setWrapText(true);
        register.setCursor(Cursor.HAND);
        register.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 25.0));
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
        login.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 25.0));
        login.setOnAction(EventController.Primary.loginOnAction());
        
        about.setLayoutX(20.0);
        about.setLayoutY(14.0);
        about.setMnemonicParsing(false);
        about.getStyleClass().add("arrow");

        imageView0.setFitHeight(42.0);
        imageView0.setFitWidth(44.0);
        imageView0.setImage(new Image(getClass().getResource("images/about.png").toExternalForm()));
        about.setGraphic(imageView0);
        about.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(register);
        getChildren().add(login);
        getChildren().add(about);
         if(audio == null){
              audio = new AudioClip(getClass().getResource("maintheme.mp3").toString());
              audio.setCycleCount(1000);
        }
      
        if(!audio.isPlaying()){
            playSound();
        }
    }

    public static void stopSound() {
        audio.stop();
    }

    public static void playSound() {
        audio.play();
    }
    public static AudioClip getAudio(){return audio;}
}
