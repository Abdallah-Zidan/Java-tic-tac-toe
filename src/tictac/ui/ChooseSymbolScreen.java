package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class ChooseSymbolScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final Button xPlayer;
    protected final Button oPlayer;
    protected final Button arrow;
    protected final ImageView imageView0;
    protected final Button record;
    protected final ImageView imageView1;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected boolean isRecord;
    protected int difficulty;

    public ChooseSymbolScreen(String screen) {
        imageView = new ImageView();
        label = new Label();
        xPlayer = new Button();
        oPlayer = new Button();
        arrow = new Button();
        imageView0 = new ImageView();
        record = new Button();
        imageView1 = new ImageView();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        isRecord = false;
        difficulty = 2;

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

        label.setLayoutX(104.0);
        label.setLayoutY(-46.0);
        label.setPrefHeight(188.0);
        label.setPrefWidth(493.0);
        label.setText("Choose Your Game Side");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        label.setWrapText(true);
        //label.setFont(Font.loadFont(getClass().getResource("fonts/BrushKing.otf").toExternalForm(), 26.0));

        xPlayer.setLayoutX(184.0);
        xPlayer.setLayoutY(127.0);
        xPlayer.setMnemonicParsing(false);
        xPlayer.setPrefHeight(97.0);
        xPlayer.setPrefWidth(96.0);
        xPlayer.getStyleClass().add("symbol");
        xPlayer.setText("X");
        xPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        xPlayer.setCursor(Cursor.HAND);
        //xPlayer.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular-Vm1l.ttf").toExternalForm(), 96.0));
        xPlayer.setOnAction(EventController.ChooseSymbol.xOnAction(screen, this));

        oPlayer.setLayoutX(398.0);
        oPlayer.setLayoutY(127.0);
        oPlayer.setMnemonicParsing(false);
        oPlayer.setPrefHeight(87.0);
        oPlayer.setPrefWidth(96.0);
        oPlayer.getStyleClass().add("symbol");
        oPlayer.setText("O");
        oPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        oPlayer.setCursor(Cursor.HAND);
        //oPlayer.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular-Vm1l.ttf").toExternalForm(), 96.0));
        oPlayer.setOnAction(EventController.ChooseSymbol.oOnAction(screen, this));

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.ChooseSymbol.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        record.setLayoutX(520.0);
        record.setLayoutY(410.0);
        record.setMnemonicParsing(false);
        record.setPrefHeight(79.0);
        record.setPrefWidth(154.0);
        record.getStyleClass().add("arrow");
        record.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        record.setOnAction(EventController.ChooseSymbol.recordOnAction(this));

        imageView1.setFitHeight(62.0);
        imageView1.setFitWidth(68.0);
        imageView1.setImage(new Image(getClass().getResource("images/rec.png").toExternalForm()));
        record.setGraphic(imageView1);
        record.setCursor(Cursor.HAND);
        //record.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 17.0));

        if (!screen.equals("single"))
            button.setVisible(false);
        button.setLayoutX(280.0);
        button.setLayoutY(262.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(56.0);
        button.setPrefWidth(119.0);
        button.getStyleClass().add("btn");
        button.setText("Easy");
        button.setCursor(Cursor.HAND);
        //button.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 24.0));
        button.setOnAction(EventController.ChooseSymbol.easyOnAction(this));

        if (!screen.equals("single"))
            button0.setVisible(false);
        button0.setLayoutX(280.0);
        button0.setLayoutY(337.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(56.0);
        button0.setPrefWidth(119.0);
        button0.getStyleClass().add("btn");
        button0.setText("Medium");
        button0.setCursor(Cursor.HAND);
        //button0.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 16.0));
        button0.setOnAction(EventController.ChooseSymbol.mediumOnAction(this));

        if (!screen.equals("single"))
            button1.setVisible(false);
        button1.setLayoutX(280.0);
        button1.setLayoutY(410.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(56.0);
        button1.setPrefWidth(119.0);
        button1.getStyleClass().add("btn");
        button1.setText("Hard");
        button1.setCursor(Cursor.HAND);
       // button1.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 16.0));
        button1.setOnAction(EventController.ChooseSymbol.hardOnAction(this));

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(xPlayer);
        getChildren().add(oPlayer);
        getChildren().add(arrow);
        getChildren().add(record);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
    }

    public void changeRecord() {
        isRecord = !isRecord;

        if (isRecord)
            record.setText("Record");
        else
            record.setText("");
    }

    public void changeDifficulty(String difficulty) {
        if (difficulty.equals("easy")) {
            this.difficulty = 0;
         //   button.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 24.0));
           // button0.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 16.0));
           // button1.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 16.0));
        }
        else if (difficulty.equals("medium")) {
            this.difficulty = 1;
           // button.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 16.0));
           // button0.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 24.0));
           // button1.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 16.0));
        }
        else if (difficulty.equals("hard")) {
            this.difficulty = 2;
           // button.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 16.0));
           // button0.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 16.0));
          //  button1.setFont(Font.loadFont(getClass().getResource("fonts/RushinkDemo.ttf").toExternalForm(), 24.0));
        }
    }

    public boolean getRecord() {
        return isRecord;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
