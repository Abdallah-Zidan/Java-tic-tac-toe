package tictac.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class GameBodyB extends AnchorPane {

    protected final Pane pane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button btn00;
    protected final Button btn01;
    protected final Button btn02;
    protected final Button btn10;
    protected final Button btn11;
    protected final Button btn12;
    protected final Button btn20;
    protected final Button btn21;
    protected final Button btn22;
    protected final Label label;
    protected final Label label0;
    protected final ImageView imageView;
    protected final ImageView imageView0;

    public GameBodyB() {

        pane = new Pane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        btn00 = new Button();
        btn01 = new Button();
        btn02 = new Button();
        btn10 = new Button();
        btn11 = new Button();
        btn12 = new Button();
        btn20 = new Button();
        btn21 = new Button();
        btn22 = new Button();
        label = new Label();
        label0 = new Label();
        imageView = new ImageView();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(590.0);
        setPrefWidth(318.0);

        pane.setLayoutX(-7.0);
        pane.setLayoutY(-8.0);
        pane.setPrefHeight(598.0);
        pane.setPrefWidth(328.0);
        pane.setStyle("-fx-background-color: #fffff6;");

        gridPane.setLayoutX(16.0);
        gridPane.setLayoutY(174.0);
        gridPane.setPrefHeight(239.0);
        gridPane.setPrefWidth(302.0);

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

        btn00.setMnemonicParsing(false);
        btn00.setPrefHeight(166.0);
        btn00.setPrefWidth(256.0);
        btn00.setOnAction(EventController.GameBody.btn00OnAction());

        GridPane.setColumnIndex(btn01, 1);
        btn01.setMnemonicParsing(false);
        btn01.setPrefHeight(89.0);
        btn01.setPrefWidth(103.0);
        btn01.setOnAction(EventController.GameBody.btn01OnAction());

        GridPane.setColumnIndex(btn02, 2);
        btn02.setMnemonicParsing(false);
        btn02.setPrefHeight(89.0);
        btn02.setPrefWidth(103.0);
        btn02.setOnAction(EventController.GameBody.btn02OnAction());

        GridPane.setRowIndex(btn10, 1);
        btn10.setMnemonicParsing(false);
        btn10.setPrefHeight(89.0);
        btn10.setPrefWidth(103.0);
        btn10.setOnAction(EventController.GameBody.btn10OnAction());

        GridPane.setColumnIndex(btn11, 1);
        GridPane.setRowIndex(btn11, 1);
        btn11.setMnemonicParsing(false);
        btn11.setPrefHeight(89.0);
        btn11.setPrefWidth(103.0);
        btn11.setOnAction(EventController.GameBody.btn11OnAction());

        GridPane.setColumnIndex(btn12, 2);
        GridPane.setRowIndex(btn12, 1);
        btn12.setMnemonicParsing(false);
        btn12.setPrefHeight(89.0);
        btn12.setPrefWidth(103.0);
        btn12.setOnAction(EventController.GameBody.btn12OnAction());

        GridPane.setRowIndex(btn20, 2);
        btn20.setMnemonicParsing(false);
        btn20.setPrefHeight(89.0);
        btn20.setPrefWidth(103.0);
        btn20.setOnAction(EventController.GameBody.btn20OnAction());

        GridPane.setColumnIndex(btn21, 1);
        GridPane.setRowIndex(btn21, 2);
        btn21.setMnemonicParsing(false);
        btn21.setPrefHeight(89.0);
        btn21.setPrefWidth(103.0);
        btn21.setOnAction(EventController.GameBody.btn21OnAction());

        GridPane.setColumnIndex(btn22, 2);
        GridPane.setRowIndex(btn22, 2);
        btn22.setMnemonicParsing(false);
        btn22.setPrefHeight(89.0);
        btn22.setPrefWidth(103.0);
        btn22.setOnAction(EventController.GameBody.btn22OnAction());

        label.setLayoutX(227.0);
        label.setLayoutY(39.0);
        label.setPrefHeight(26.0);
        label.setPrefWidth(74.0);
        label.setText("Player");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label.setWrapText(true);
        label.setFont(new Font("Bubbleboddy Neue Trial Regular", 25.0));

        label0.setLayoutX(86.0);
        label0.setLayoutY(508.0);
        label0.setPrefHeight(26.0);
        label0.setPrefWidth(74.0);
        label0.setText("Player");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label0.setWrapText(true);
        label0.setFont(new Font("Bubbleboddy Neue Trial Regular", 25.0));

        imageView.setFitHeight(44.0);
        imageView.setFitWidth(54.0);
        imageView.setLayoutX(164.0);
        imageView.setLayoutY(30.0);
        imageView.setImage(new Image(getClass().getResource("x.png").toExternalForm()));

        imageView0.setFitHeight(80.0);
        imageView0.setFitWidth(82.0);
        imageView0.setLayoutX(14.0);
        imageView0.setLayoutY(476.0);
        imageView0.setImage(new Image(getClass().getResource("o.png").toExternalForm()));

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(btn00);
        gridPane.getChildren().add(btn01);
        gridPane.getChildren().add(btn02);
        gridPane.getChildren().add(btn10);
        gridPane.getChildren().add(btn11);
        gridPane.getChildren().add(btn12);
        gridPane.getChildren().add(btn20);
        gridPane.getChildren().add(btn21);
        gridPane.getChildren().add(btn22);
        pane.getChildren().add(gridPane);
        pane.getChildren().add(label);
        pane.getChildren().add(label0);
        pane.getChildren().add(imageView);
        pane.getChildren().add(imageView0);
        getChildren().add(pane);

    }
}
