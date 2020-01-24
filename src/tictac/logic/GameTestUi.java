package tictac.logic;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public  class GameTestUi extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected  Button zeroZero;
    protected  Button zeroOne;
    protected Button zeroTwo;
    protected  Button oneZero;
    protected  Button oneOne;
    protected  Button oneTwo;
    protected Button twoZero;
    protected  Button twoOne;
    protected  Button twoTwo;

    public GameTestUi() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        zeroZero = new Button();
        zeroOne = new Button();
        zeroTwo = new Button();
        oneZero = new Button();
        oneOne = new Button();
        oneTwo = new Button();
        twoZero = new Button();
        twoOne = new Button();
        twoTwo = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        gridPane.setPrefHeight(403.0);
        gridPane.setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        zeroZero.setMnemonicParsing(false);
        zeroZero.setPrefHeight(134.0);
        zeroZero.setPrefWidth(221.0);

        GridPane.setColumnIndex(zeroOne, 1);
        zeroOne.setMnemonicParsing(false);
        zeroOne.setPrefHeight(134.0);
        zeroOne.setPrefWidth(215.0);

        GridPane.setColumnIndex(zeroTwo, 2);
        zeroTwo.setMnemonicParsing(false);
        zeroTwo.setPrefHeight(136.0);
        zeroTwo.setPrefWidth(201.0);

        GridPane.setRowIndex(oneZero, 1);
        oneZero.setMnemonicParsing(false);
        oneZero.setPrefHeight(131.0);
        oneZero.setPrefWidth(208.0);

        GridPane.setColumnIndex(oneOne, 1);
        GridPane.setRowIndex(oneOne, 1);
        oneOne.setMnemonicParsing(false);
        oneOne.setPrefHeight(141.0);
        oneOne.setPrefWidth(201.0);

        GridPane.setColumnIndex(oneTwo, 2);
        GridPane.setRowIndex(oneTwo, 1);
        oneTwo.setMnemonicParsing(false);
        oneTwo.setPrefHeight(131.0);
        oneTwo.setPrefWidth(203.0);

        GridPane.setRowIndex(twoZero, 2);
        twoZero.setMnemonicParsing(false);
        twoZero.setPrefHeight(150.0);
        twoZero.setPrefWidth(216.0);

        GridPane.setColumnIndex(twoOne, 1);
        GridPane.setRowIndex(twoOne, 2);
        twoOne.setMnemonicParsing(false);
        twoOne.setPrefHeight(154.0);
        twoOne.setPrefWidth(208.0);

        GridPane.setColumnIndex(twoTwo, 2);
        GridPane.setRowIndex(twoTwo, 2);
        twoTwo.setMnemonicParsing(false);
        twoTwo.setPrefHeight(137.0);
        twoTwo.setPrefWidth(215.0);
        setTop(gridPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(zeroZero);
        gridPane.getChildren().add(zeroOne);
        gridPane.getChildren().add(zeroTwo);
        gridPane.getChildren().add(oneZero);
        gridPane.getChildren().add(oneOne);
        gridPane.getChildren().add(oneTwo);
        gridPane.getChildren().add(twoZero);
        gridPane.getChildren().add(twoOne);
        gridPane.getChildren().add(twoTwo);

    }
    public void setText(Button btn , char sign){
        btn.setFont(Font.font("verdana", 40));
        btn.setText(String.valueOf(sign));
    }
    public char getButtonSign(Button btn){
        return btn.getText().charAt(0);
    }
    public Button[][] getBoardButtons(){
        
       // ArrayList<Button> buttons = new ArrayList<Button>();
        Button [][] buttons = new  Button[3][3];
        buttons[0][0] = zeroZero;
        buttons[0][1] = zeroOne;
        buttons[0][2] = zeroTwo;
        
        buttons[1][0] = oneZero;
        buttons[1][1] = oneOne;
        buttons[1][2] = oneTwo;
        
        buttons[2][0] = twoZero;
        buttons[2][1] = twoOne;
        buttons[2][2] = twoTwo;
        
        return buttons;
    }
    
    public void resetButtons(){
        Button[][] buttons = getBoardButtons();
        for(int i=0;i<3;i++){
            for(int j=0 ; j<3;j++){
                buttons[i][j].setText("");
            }
        }
    }
    
    public void highLight(Button btn){
        btn.setStyle(" -fx-background-color: red;-fx-text-fill: white;");
    }
}
