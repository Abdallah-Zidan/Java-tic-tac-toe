package tictac.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class loginB extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final ImageView imageView;
    protected final JFXTextField jFXTextField;
    protected final JFXPasswordField jFXPasswordField;
    protected final Label label0;
    protected final Label label1;
    protected final JFXButton jFXButton;

    public loginB() {

        pane = new Pane();
        label = new Label();
        imageView = new ImageView();
        jFXTextField = new JFXTextField();
        jFXPasswordField = new JFXPasswordField();
        label0 = new Label();
        label1 = new Label();
        jFXButton = new JFXButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(590.0);
        setPrefWidth(318.0);

        pane.setPrefHeight(590.0);
        pane.setPrefWidth(318.0);
        pane.setStyle("-fx-background-color: #fffff6;");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(121.0);
        label.setLayoutY(332.0);
        label.setPrefHeight(26.0);
        label.setPrefWidth(70.0);
        label.setText("Login");
        label.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label.setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
        label.setWrapText(true);
        label.setFont(new Font("Bubbleboddy Neue Trial Regular", 20.0));

        imageView.setFitHeight(317.0);
        imageView.setFitWidth(317.0);
        imageView.setLayoutX(1.0);
        imageView.setImage(new Image(getClass().getResource("filast.png").toExternalForm()));

        jFXTextField.setLayoutX(115.0);
        jFXTextField.setLayoutY(386.0);

        jFXPasswordField.setLayoutX(115.0);
        jFXPasswordField.setLayoutY(436.0);

        label0.setLayoutX(26.0);
        label0.setLayoutY(391.0);
        label0.setPrefHeight(26.0);
        label0.setPrefWidth(70.0);
        label0.setText("Username");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label0.setFont(new Font("Bubbleboddy Neue Trial Regular", 14.0));

        label1.setLayoutX(27.0);
        label1.setLayoutY(445.0);
        label1.setPrefHeight(26.0);
        label1.setPrefWidth(70.0);
        label1.setText("Password");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label1.setFont(new Font("Bubbleboddy Neue Trial Regular", 15.0));

        jFXButton.setLayoutX(113.0);
        jFXButton.setLayoutY(514.0);
        jFXButton.setStyle("-fx-background-color: #930a0a;");
        jFXButton.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));

        pane.getChildren().add(label);
        pane.getChildren().add(imageView);
        pane.getChildren().add(jFXTextField);
        pane.getChildren().add(jFXPasswordField);
        pane.getChildren().add(label0);
        pane.getChildren().add(label1);
        pane.getChildren().add(jFXButton);
        getChildren().add(pane);

    }
}
