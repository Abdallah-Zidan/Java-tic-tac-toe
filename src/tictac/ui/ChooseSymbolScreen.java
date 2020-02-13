package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;
import tictac.logic.Constants;

public class ChooseSymbolScreen extends Pane {
    protected final ImageView imageView;
    protected final Button xPlayer;
    protected final Button oPlayer;
    protected final Button arrow;
    protected final ImageView imageView0;
    protected final Button record;
    protected final ImageView imageView1;
    protected final Button easy;
    protected final Button mid;
    protected final Button hard;
    protected boolean isRecord;
    protected int difficulty;

    public ChooseSymbolScreen(String screen) {
        imageView = new ImageView();
        xPlayer = new Button();
        oPlayer = new Button();
        arrow = new Button();
        imageView0 = new ImageView();
        record = new Button();
        imageView1 = new ImageView();
        easy = new Button();
        mid = new Button();
        hard = new Button();
        isRecord = false;
        difficulty = 1;

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
        imageView.setImage(new Image(getClass().getResource("images/choose.png").toExternalForm()));

        xPlayer.setLayoutX(184.0);
        xPlayer.setLayoutY(127.0);
        xPlayer.setMnemonicParsing(false);
        xPlayer.setPrefHeight(97.0);
        xPlayer.setPrefWidth(96.0);
        xPlayer.getStyleClass().add("symbol");
        xPlayer.setText("X");
        xPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        xPlayer.setCursor(Cursor.HAND);
        xPlayer.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 96.0));
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
        oPlayer.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 96.0));
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
        record.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));

        easy.setLayoutX(277.0);
        easy.setLayoutY(262.0);
        easy.setMnemonicParsing(false);
        easy.setPrefHeight(56.0);
        easy.setPrefWidth(125.0);
        easy.getStyleClass().add("btn");
        easy.setText("Easy");
        easy.setCursor(Cursor.HAND);
        easy.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 24.0));
        easy.setOnAction(EventController.ChooseSymbol.easyOnAction(this));

        mid.setLayoutX(277.0);
        mid.setLayoutY(337.0);
        mid.setMnemonicParsing(false);
        mid.setPrefHeight(56.0);
        mid.setPrefWidth(125.0);
        mid.getStyleClass().add("btn");
        mid.setText("Medium");
        mid.setCursor(Cursor.HAND);
        mid.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));
        mid.setOnAction(EventController.ChooseSymbol.mediumOnAction(this));

        hard.setLayoutX(277.0);
        hard.setLayoutY(410.0);
        hard.setMnemonicParsing(false);
        hard.setPrefHeight(56.0);
        hard.setPrefWidth(125.0);
        hard.getStyleClass().add("btn");
        hard.setText("Hard");
        hard.setCursor(Cursor.HAND);
        hard.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));
        hard.setOnAction(EventController.ChooseSymbol.hardOnAction(this));

        getChildren().add(imageView);
        getChildren().add(xPlayer);
        getChildren().add(oPlayer);
        getChildren().add(arrow);
        getChildren().add(record);

        if (screen.equals("single")) {
            getChildren().add(easy);
            getChildren().add(mid);
            getChildren().add(hard);
        }
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
            this.difficulty = Constants.EASY;
            easy.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 24.0));
            mid.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));
            hard.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));
        }
        else if (difficulty.equals("medium")) {
            this.difficulty = Constants.MEDIUM;
            easy.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));
            mid.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 24.0));
            hard.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));
        }
        else if (difficulty.equals("hard")) {
            this.difficulty = Constants.HARD;
            easy.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));
            mid.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 16.0));
            hard.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 24.0));
        }
    }

    public boolean getRecord() {
        return isRecord;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
