package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class GameBodyB extends Pane {
    protected final Button lastB;
    protected final Button eightB;
    protected final Button sevB;
    protected final Button sixB;
    protected final Button centerB;
    protected final Button forthB;
    protected final Button thirdB;
    protected final Button secB;
    protected final Button firstB;
    protected final ImageView imageView;
    protected final Button arrow;
    protected final ImageView imageView0;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected AudioClip audio;
    protected final Button playAgain;

    public GameBodyB() {
        lastB = new Button();
        eightB = new Button();
        sevB = new Button();
        sixB = new Button();
        centerB = new Button();
        forthB = new Button();
        thirdB = new Button();
        secB = new Button();
        firstB = new Button();
        imageView = new ImageView();
        arrow = new Button();
        imageView0 = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        playAgain = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(325.0);
        getStylesheets().add(getClass().getResource("style.css").toString());
        setStyle("-fx-background-color: white;");

        lastB.setLayoutX(208.0);
        lastB.setLayoutY(358.0);
        lastB.setMnemonicParsing(false);
        lastB.setPrefHeight(87.0);
        lastB.setPrefWidth(103.0);
        lastB.getStyleClass().add("btnplay");
        lastB.setCursor(Cursor.HAND);
        
        /*lastB.setOnAction((ActionEvent e) -> {
            lastB.setText("x");
        });*/

        eightB.setLayoutX(112.0);
        eightB.setLayoutY(358.0);
        eightB.setMnemonicParsing(false);
        eightB.setPrefHeight(87.0);
        eightB.setPrefWidth(103.0);
        eightB.getStyleClass().add("btnplay");
        eightB.setCursor(Cursor.HAND);

        sevB.setLayoutX(10.0);
        sevB.setLayoutY(358.0);
        sevB.setMnemonicParsing(false);
        sevB.setPrefHeight(87.0);
        sevB.setPrefWidth(103.0);
        sevB.getStyleClass().add("btnplay");
        sevB.setCursor(Cursor.HAND);

        sixB.setLayoutX(208.0);
        sixB.setLayoutY(267.0);
        sixB.setMnemonicParsing(false);
        sixB.setPrefHeight(80.0);
        sixB.setPrefWidth(103.0);
        sixB.getStyleClass().add("btnplay");
        sixB.setCursor(Cursor.HAND);

        centerB.setLayoutX(111.0);
        centerB.setLayoutY(267.0);
        centerB.setMnemonicParsing(false);
        centerB.setPrefHeight(80.0);
        centerB.setPrefWidth(103.0);
        centerB.getStyleClass().add("btnplay");
        centerB.setCursor(Cursor.HAND);

        forthB.setLayoutX(10.0);
        forthB.setLayoutY(267.0);
        forthB.setMnemonicParsing(false);
        forthB.setPrefHeight(80.0);
        forthB.setPrefWidth(103.0);
        forthB.getStyleClass().add("btnplay");
        forthB.setCursor(Cursor.HAND);

        thirdB.setLayoutX(208.0);
        thirdB.setLayoutY(165.0);
        thirdB.setMnemonicParsing(false);
        thirdB.setPrefHeight(95.0);
        thirdB.setPrefWidth(103.0);
        thirdB.getStyleClass().add("btnplay");
        thirdB.setCursor(Cursor.HAND);

        secB.setLayoutX(112.0);
        secB.setLayoutY(165.0);
        secB.setMnemonicParsing(false);
        secB.setPrefHeight(95.0);
        secB.setPrefWidth(103.0);
        secB.getStyleClass().add("btnplay");
        secB.setCursor(Cursor.HAND);

        firstB.setLayoutX(10.0);
        firstB.setLayoutY(165.0);
        firstB.setMnemonicParsing(false);
        firstB.setPrefHeight(95.0);
        firstB.setPrefWidth(103.0);
        firstB.getStyleClass().add("btnplay");
        firstB.setCursor(Cursor.HAND);

        imageView.setFitHeight(285.0);
        imageView.setFitWidth(310.0);
        imageView.setLayoutX(8.0);
        imageView.setLayoutY(164.0);
        imageView.setImage(new Image(getClass().getResource("images/Tic-tac-toe.png").toExternalForm()));

        arrow.setLayoutX(14.0);
        arrow.setLayoutY(542.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(34.0);
        arrow.setPrefWidth(38.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.GameBody.backOnAction(this));

        imageView0.setFitHeight(32.0);
        imageView0.setFitWidth(33.0);
        imageView0.getStyleClass().add("arrow");
        imageView0.setImage(new Image(getClass().getResource("images/arrow.png").toExternalForm()));
        imageView0.setCursor(Cursor.HAND);
        arrow.setGraphic(imageView0);

        label.setLayoutX(185.0);
        label.setLayoutY(522.0);
        label.setPrefHeight(71.0);
        label.setPrefWidth(47.0);
        label.setText("X");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label.setFont(new Font("Bubbleboddy Neue Trial Regular", 58.0));

        label0.setLayoutX(20.0);
        label0.setLayoutY(1.0);
        label0.setPrefHeight(71.0);
        label0.setPrefWidth(47.0);
        label0.setText("O");
        label0.setFont(new Font("Bubbleboddy Neue Trial Regular", 58.0));

        label1.setLayoutX(73.0);
        label1.setLayoutY(21.0);
        label1.setText("Player");
        label1.setFont(new Font("THORN", 24.0));

        label2.setLayoutX(238.0);
        label2.setLayoutY(542.0);
        label2.setText("Player");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label2.setFont(new Font("THORN", 24.0));
        
        playAgain.setLayoutX(60.0);
        playAgain.setLayoutY(542.0);
        playAgain.setMnemonicParsing(false);
        playAgain.setPrefHeight(34.0);
        playAgain.setPrefWidth(38.0);
        playAgain.setCursor(Cursor.HAND);
        playAgain.setText("Play Again");
        playAgain.setOnAction(EventController.GameBody.playAgainOnAction());

        getChildren().add(lastB);
        getChildren().add(eightB);
        getChildren().add(sevB);
        getChildren().add(sixB);
        getChildren().add(centerB);
        getChildren().add(forthB);
        getChildren().add(thirdB);
        getChildren().add(secB);
        getChildren().add(firstB);
        getChildren().add(imageView);
        getChildren().add(arrow);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(playAgain);

        audio = new AudioClip(getClass().getResource("spyloop.mp3").toString());
        audio.setCycleCount(1000);
//        audio.play();
    }

    public void setText(Button btn, char sign) {
        btn.setFont(Font.font("verdana", 40));
        btn.setText(String.valueOf(sign));
    }

    public char getButtonSign(Button btn) {
        return btn.getText().charAt(0);
    }

    public Button[][] getBoardButtons() {

        // ArrayList<Button> buttons = new ArrayList<Button>();
        Button[][] buttons = new Button[3][3];
        buttons[0][0] = firstB;
        buttons[0][1] = secB;
        buttons[0][2] = thirdB;

        buttons[1][0] = forthB;
        buttons[1][1] = centerB;
        buttons[1][2] = sixB;

        buttons[2][0] = sevB;
        buttons[2][1] = eightB;
        buttons[2][2] = lastB;

        return buttons;
    }

    public void resetButtons() {
        Button[][] buttons = getBoardButtons();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    public void highLight(Button btn ,int state) {
        if(state == 1){
              btn.setStyle("-fx-background-color: yellow;-fx-text-fill: white;");
        }else if(state==11){
            btn.setStyle("-fx-background-color: transparent;hoverProperty(-fx-background-color: #930a0a;-fx-border-radius: 25;)");
        }
        else{
            btn.setStyle("-fx-background-color: red;-fx-text-fill: white;");
        }
      
    }
    public void stopSound(){
        audio.stop();
    }
    public void playSound(){
        audio.play();
    }
}
