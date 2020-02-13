package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class AboutScreen extends Pane {
    protected final ImageView imageView;
    protected final Label label;
    protected final Pane pane;
    protected final Label abd;
    protected final Label tarek;
    protected final Label nour;
    protected final Label haitham;
    protected final Label rola;
    protected final Button arrow;
    protected final ImageView imageView0;

    public AboutScreen() {
        imageView = new ImageView();
        label = new Label();
        pane = new Pane();
        abd = new Label();
        tarek = new Label();
        nour = new Label();
        haitham = new Label();
        rola = new Label();
        arrow = new Button();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        getStylesheets().add(getClass().getResource("style.css").toString());

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(700.0);
        imageView.setImage(new Image(getClass().getResource("images/aboutus.png").toExternalForm()));

        label.setLayoutX(68.0);
        label.setLayoutY(130.0);
        label.setPrefHeight(85.0);
        label.setPrefWidth(565.0);
        label.setText("Tic Tac Toe game is made in 2020 by an ItI team of Open Source track intake 40, the team are:");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        label.setWrapText(true);
        label.setFont(Font.loadFont(getClass().getResource("fonts/BoughiesDemo.ttf").toExternalForm(), 16.0));

        pane.setLayoutX(226.0);
        pane.setLayoutY(472.0);
        pane.setPrefHeight(336.0);
        pane.setPrefWidth(248.0);

        abd.setLayoutX(35.0);
        abd.setLayoutY(-205.0);
        abd.getStyleClass().add("name");
        abd.setText("Abdallah Zidan");
        abd.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        abd.setFont(Font.loadFont(getClass().getResource("fonts/BoughiesDemo.ttf").toExternalForm(), 20.0));

        tarek.setLayoutX(30.0);
        tarek.setLayoutY(-150.0);
        tarek.getStyleClass().add("name");
        tarek.setText("Tarek Ibraheem");
        tarek.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        tarek.setFont(Font.loadFont(getClass().getResource("fonts/BoughiesDemo.ttf").toExternalForm(), 20.0));

        nour.setLayoutX(26.0);
        nour.setLayoutY(-95.0);
        nour.getStyleClass().add("name");
        nour.setText("Nourhan Ayman");
        nour.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        nour.setFont(Font.loadFont(getClass().getResource("fonts/BoughiesDemo.ttf").toExternalForm(), 20.0));

        haitham.setLayoutX(15.0);
        haitham.setLayoutY(-40.0);
        haitham.getStyleClass().add("name");
        haitham.setText("AL-Haitham Kamal");
        haitham.setTextFill(javafx.scene.paint.Color.valueOf("#fbfbfb"));
        haitham.setFont(Font.loadFont(getClass().getResource("fonts/BoughiesDemo.ttf").toExternalForm(), 20.0));

        rola.setLayoutX(53.0);
        rola.setLayoutY(10.0);
        rola.getStyleClass().add("name");
        rola.setText("Rola Ahmed");
        rola.setTextFill(javafx.scene.paint.Color.valueOf("#cd1515"));
        rola.setFont(Font.loadFont(getClass().getResource("fonts/BoughiesDemo.ttf").toExternalForm(), 20.0));
        
        arrow.setLayoutX(82.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(20.0);
        arrow.setPrefWidth(10.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.About.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        getChildren().add(imageView);
        getChildren().add(label);
        pane.getChildren().add(abd);
        pane.getChildren().add(tarek);
        pane.getChildren().add(nour);
        pane.getChildren().add(haitham);
        pane.getChildren().add(rola);
        getChildren().add(pane);
        getChildren().add(arrow);
    }
    
    public Pane getPane() {
        return pane;
    }
}
