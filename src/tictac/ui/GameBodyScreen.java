package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class GameBodyScreen extends Pane {
    protected final ImageView imageView;
    protected final Label osym;
    protected final Label p1name;
    protected final Label score;
    protected final Label scorenum;
    protected final Label xsym;
    protected final Label p2name;
    protected final Button firstB;
    protected final Button secB;
    protected final Button thirdB;
    protected final Button forthB;
    protected final Button centerB;
    protected final Button sixB;
    protected final Button sevB;
    protected final Button eightB;
    protected final Button lastB;
    protected final ImageView imageView0;
    protected final Button arrow;
    protected final ImageView imageView1;
    protected final Button playagain;
    protected final ImageView imageView2;
    protected AudioClip audio;

    public GameBodyScreen() {
        imageView = new ImageView();
        osym = new Label();
        p1name = new Label();
        score = new Label();
        scorenum = new Label();
        xsym = new Label();
        p2name = new Label();
        firstB = new Button();
        secB = new Button();
        thirdB = new Button();
        forthB = new Button();
        centerB = new Button();
        sixB = new Button();
        sevB = new Button();
        eightB = new Button();
        lastB = new Button();
        imageView0 = new ImageView();
        arrow = new Button();
        imageView1 = new ImageView();
        playagain = new Button();
        imageView2 = new ImageView();

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

        osym.setLayoutX(20.0);
        osym.setLayoutY(1.0);
        osym.setPrefHeight(107.0);
        osym.setPrefWidth(63.0);
        osym.setText("O");
        osym.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        osym.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 83.0));

        p1name.setLayoutX(100.0);
        p1name.setLayoutY(37.0);
        p1name.setText("Ahmed");
        p1name.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        p1name.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 27.0));

        score.setLayoutX(23.0);
        score.setLayoutY(121.0);
        score.setText("Score: ");
        score.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        score.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 30.0));

        scorenum.setLayoutX(126.0);
        scorenum.setLayoutY(107.0);
        scorenum.setText("20");
        scorenum.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        scorenum.setFont(Font.loadFont(getClass().getResource("fonts/BoughiesDemo.ttf").toExternalForm(), 27.0));

        xsym.setLayoutX(23.0);
        xsym.setLayoutY(240.0);
        xsym.setPrefHeight(95.0);
        xsym.setPrefWidth(63.0);
        xsym.setText("X");
        xsym.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        xsym.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 83.0));

        p2name.setLayoutX(100.0);
        p2name.setLayoutY(273.0);
        p2name.setText("Ahmed");
        p2name.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        p2name.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 27.0));

        firstB.setDepthTest(javafx.scene.DepthTest.DISABLE);
        firstB.setLayoutX(319.0);
        firstB.setLayoutY(93.0);
        firstB.setMnemonicParsing(false);
        firstB.setPrefHeight(103.0);
        firstB.setPrefWidth(103.0);
        firstB.getStyleClass().add("sym");
        firstB.setTextFill(javafx.scene.paint.Color.valueOf("#030000"));
        firstB.setCursor(Cursor.HAND);
        firstB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 81.0));

        secB.setLayoutX(440.0);
        secB.setLayoutY(93.0);
        secB.setMnemonicParsing(false);
        secB.setPrefHeight(103.0);
        secB.setPrefWidth(92.0);
        secB.getStyleClass().add("sym");
        secB.setTextFill(javafx.scene.paint.Color.valueOf("#110000"));
        secB.setCursor(Cursor.HAND);
        secB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 80.0));

        thirdB.setLayoutX(549.0);
        thirdB.setLayoutY(93.0);
        thirdB.setMnemonicParsing(false);
        thirdB.setPrefHeight(103.0);
        thirdB.setPrefWidth(103.0);
        thirdB.getStyleClass().add("sym");
        thirdB.setTextFill(javafx.scene.paint.Color.valueOf("#140000"));
        thirdB.setCursor(Cursor.HAND);
        thirdB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 80.0));

        forthB.setLayoutX(319.0);
        forthB.setLayoutY(214.0);
        forthB.setMnemonicParsing(false);
        forthB.setPrefHeight(92.0);
        forthB.setPrefWidth(103.0);
        forthB.getStyleClass().add("sym");
        forthB.setCursor(Cursor.HAND);
        forthB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 80.0));

        centerB.setLayoutX(440.0);
        centerB.setLayoutY(214.0);
        centerB.setMnemonicParsing(false);
        centerB.setPrefHeight(92.0);
        centerB.setPrefWidth(92.0);
        centerB.getStyleClass().add("sym");
        centerB.setCursor(Cursor.HAND);
        centerB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 80.0));

        sixB.setLayoutX(549.0);
        sixB.setLayoutY(214.0);
        sixB.setMnemonicParsing(false);
        sixB.setPrefHeight(92.0);
        sixB.setPrefWidth(103.0);
        sixB.getStyleClass().add("sym");
        sixB.setCursor(Cursor.HAND);
        sixB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 80.0));

        sevB.setLayoutX(319.0);
        sevB.setLayoutY(325.0);
        sevB.setMnemonicParsing(false);
        sevB.setPrefHeight(100.0);
        sevB.setPrefWidth(103.0);
        sevB.getStyleClass().add("sym");
        sevB.setCursor(Cursor.HAND);
        sevB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 80.0));

        eightB.setLayoutX(440.0);
        eightB.setLayoutY(325.0);
        eightB.setMnemonicParsing(false);
        eightB.setPrefHeight(100.0);
        eightB.setPrefWidth(91.0);
        eightB.getStyleClass().add("sym");
        eightB.setCursor(Cursor.HAND);
        eightB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 80.0));

        lastB.setLayoutX(549.0);
        lastB.setLayoutY(325.0);
        lastB.setMnemonicParsing(false);
        lastB.setPrefHeight(100.0);
        lastB.setPrefWidth(103.0);
        lastB.getStyleClass().add("sym");
        lastB.setCursor(Cursor.HAND);
        lastB.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 80.0));

        imageView0.setFitHeight(349.0);
        imageView0.setFitWidth(350.0);
        imageView0.setLayoutX(310.0);
        imageView0.setLayoutY(83.0);
        imageView0.setImage(new Image(getClass().getResource("images/Tic-tac-toe.png").toExternalForm()));

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.GameBody.backOnAction(this));

        imageView1.setFitHeight(67.0);
        imageView1.setFitWidth(63.0);
        imageView1.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView1);

        playagain.setLayoutX(193.0);
        playagain.setLayoutY(400.0);
        playagain.setMnemonicParsing(false);
        playagain.getStyleClass().add("arrow");
        playagain.setOnAction(EventController.GameBody.playAgainOnAction());

        imageView2.setFitHeight(74.0);
        imageView2.setFitWidth(74.0);
        imageView2.setImage(new Image(getClass().getResource("images/replay.png").toExternalForm()));
        playagain.setGraphic(imageView2);
        playagain.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(osym);
        getChildren().add(p1name);
        getChildren().add(score);
        getChildren().add(scorenum);
        getChildren().add(xsym);
        getChildren().add(p2name);
        getChildren().add(firstB);
        getChildren().add(secB);
        getChildren().add(thirdB);
        getChildren().add(forthB);
        getChildren().add(centerB);
        getChildren().add(sixB);
        getChildren().add(sevB);
        getChildren().add(eightB);
        getChildren().add(lastB);
        getChildren().add(imageView0);
        getChildren().add(arrow);
        getChildren().add(playagain);

        audio = new AudioClip(getClass().getResource("gameloop.mp3").toString());
        audio.setCycleCount(1000);
    }

    public void setText(Button btn, char sign) {
//        btn.setFont(Font.font("verdana", 40));
        btn.setText(String.valueOf(sign));
    }

    public char getButtonSign(Button btn) {
        return btn.getText().charAt(0);
    }

    public Button[][] getBoardButtons() {
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
        switch (state) {
            case 1:
                btn.setStyle("-fx-background-color: yellow;-fx-text-fill: transparent;");
                break;
            case 11:
                btn.setStyle("-fx-background-color: white;");
                break;
            default:
                btn.setStyle("-fx-background-color: red;-fx-text-fill: white;");
                break;
        }
    }

    public void stopSound(){
        audio.stop();
    }

    public void playSound(){
        audio.play();
    }

    public void setFirstName(String name) {
        p1name.setText(name);
    }

    public void setSecondName(String name) {
        p2name.setText(name);
    }

    public void setFirstSymbol(char symbol) {
        osym.setText(String.valueOf(symbol).toUpperCase());
    }

    public void setSecondSymbol(char symbol) {
        xsym.setText(String.valueOf(symbol).toUpperCase());
    }

    public void setScore(int score) {
        scorenum.setText(Integer.toString(score));
    }

    public void changeTurn() {
        if (xsym.getTextFill().equals(Color.valueOf("#cd1515"))) {
            xsym.setTextFill(Color.valueOf("#fbfbfb"));
            osym.setTextFill(Color.valueOf("#cd1515"));
        }
        else {
            xsym.setTextFill(Color.valueOf("#cd1515"));
            osym.setTextFill(Color.valueOf("#fbfbfb"));
        }
    }
    
        public Button getPlayAgainBtn(){return playagain;}
    public void disableButtons() {
        Button[][] buttons = getBoardButtons();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(true);
            }
        }
    }

    public void enableButtons() {
        Button[][] buttons = getBoardButtons();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(false);
            }

        }
    }

    public void clearButtons() {
        Button[][] buttons = getBoardButtons();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                highLight(buttons[i][j], 11);
            }
        }
    }

    private void highlightTrio(Button btn1, Button btn2, Button btn3, int state) {
        highLight(btn1, state);
        highLight(btn2, state);
        highLight(btn3, state);
    }

    // highlight the winning buttons at the end of the game
    public void highlightButtons(int state) {
        Button[][] buttons = getBoardButtons();
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText())) {
            highlightTrio(buttons[0][0], buttons[1][1], buttons[2][2], state);
        } else if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText())) {
            highlightTrio(buttons[0][2], buttons[1][1], buttons[2][0], state);
        } else {
            for (int x = 0; x < 3; x++) {
                String st1 = buttons[x][0].getText(), st2 = buttons[x][1].getText(), st3 = buttons[x][2].getText();
                if (st1.equals(st2) && st1.equals(st3) && st1.equals("X") || st1.equals(st2) && st1.equals(st3) && st1.equals("O")) {
                    highlightTrio(buttons[x][0], buttons[x][1], buttons[x][2], state);
                    break;
                }
            }
            for (int y = 0; y < 3; y++) {
                String st1 = buttons[0][y].getText(), st2 = buttons[1][y].getText(), st3 = buttons[2][y].getText();
                if (st1.equals(st2) && st1.equals(st3) && st1.equals("X") || st1.equals(st2) && st1.equals(st3) && st1.equals("O")) {
                    highlightTrio(buttons[0][y], buttons[1][y], buttons[2][y], state);
                    break;
                }
            }
        }
    }
}
