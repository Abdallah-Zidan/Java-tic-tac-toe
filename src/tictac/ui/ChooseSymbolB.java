package tictac.ui;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class ChooseSymbolB extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final RadioButton xBtn;
    protected final RadioButton oBtn;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final JFXButton contBtn;

    public ChooseSymbolB() {

        pane = new Pane();
        label = new Label();
        xBtn = new RadioButton();
        oBtn = new RadioButton();
        imageView = new ImageView();
        imageView0 = new ImageView();
        contBtn = new JFXButton();

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

        label.setLayoutX(64.0);
        label.setLayoutY(66.0);
        label.setText("Pic your Side");
        label.setFont(new Font("Bubbleboddy Neue Trial Regular", 35.0));

        xBtn.setLayoutX(80.0);
        xBtn.setLayoutY(378.0);
        xBtn.setMnemonicParsing(false);

        oBtn.setLayoutX(231.0);
        oBtn.setLayoutY(378.0);
        oBtn.setMnemonicParsing(false);

        imageView.setFitHeight(157.0);
        imageView.setFitWidth(145.0);
        imageView.setLayoutX(23.0);
        imageView.setLayoutY(190.0);
        imageView.setImage(new Image(getClass().getResource("x.png").toExternalForm()));

        imageView0.setFitHeight(238.0);
        imageView0.setFitWidth(224.0);
        imageView0.setLayoutX(128.0);
        imageView0.setLayoutY(144.0);
        imageView0.setImage(new Image(getClass().getResource("o.png").toExternalForm()));

        contBtn.setLayoutX(111.0);
        contBtn.setLayoutY(490.0);
        contBtn.setStyle("-fx-background-color: #930a0a;");
        contBtn.setFont(new Font("Bubbleboddy Neue Trial Regular", 15.0));

        pane.getChildren().add(label);
        pane.getChildren().add(xBtn);
        pane.getChildren().add(oBtn);
        pane.getChildren().add(imageView);
        pane.getChildren().add(imageView0);
        pane.getChildren().add(contBtn);
        getChildren().add(pane);

    }
}
