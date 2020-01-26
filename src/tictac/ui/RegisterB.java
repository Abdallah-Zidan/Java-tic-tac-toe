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

public class RegisterB extends AnchorPane {

    protected final Pane pane;
    protected final JFXTextField name;
    protected final JFXTextField userName;
    protected final JFXPasswordField password;
    protected final JFXButton nextPage;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final ImageView imageView;
    protected final Label label2;

    public RegisterB() {

        pane = new Pane();
        name = new JFXTextField();
        userName = new JFXTextField();
        password = new JFXPasswordField();
        nextPage = new JFXButton();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        imageView = new ImageView();
        label2 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(590.0);
        setPrefWidth(318.0);

        pane.setPrefHeight(590.0);
        pane.setPrefWidth(317.0);
        pane.setStyle("-fx-background-color: #fffff6;");

        name.setLayoutX(115.0);
        name.setLayoutY(382.0);

        userName.setLayoutX(115.0);
        userName.setLayoutY(431.0);

        password.setLayoutX(115.0);
        password.setLayoutY(477.0);

        nextPage.setLayoutX(117.0);
        nextPage.setLayoutY(533.0);
        nextPage.setStyle("-fx-background-color: #930a0a;");
        nextPage.setFont(new Font("Bubbleboddy Neue Trial Regular", 15.0));

        label.setLayoutX(19.0);
        label.setLayoutY(386.0);
        label.setPrefHeight(26.0);
        label.setPrefWidth(70.0);
        label.setText("Name");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));

        label0.setLayoutX(19.0);
        label0.setLayoutY(433.0);
        label0.setPrefHeight(26.0);
        label0.setPrefWidth(70.0);
        label0.setText("Username");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label0.setFont(new Font("Bubbleboddy Neue Trial Regular", 14.0));

        label1.setLayoutX(20.0);
        label1.setLayoutY(480.0);
        label1.setPrefHeight(26.0);
        label1.setPrefWidth(70.0);
        label1.setText("Password");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label1.setFont(new Font("Bubbleboddy Neue Trial Regular", 15.0));

        imageView.setFitHeight(318.0);
        imageView.setFitWidth(317.0);
        imageView.setImage(new Image(getClass().getResource("filast.png").toExternalForm()));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setLayoutX(50.0);
        label2.setLayoutY(328.0);
        label2.setPrefHeight(26.0);
        label2.setPrefWidth(214.0);
        label2.setText("Register New Player");
        label2.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label2.setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
        label2.setWrapText(true);
        label2.setFont(new Font("Bubbleboddy Neue Trial Regular", 23.0));

        pane.getChildren().add(name);
        pane.getChildren().add(userName);
        pane.getChildren().add(password);
        pane.getChildren().add(nextPage);
        pane.getChildren().add(label);
        pane.getChildren().add(label0);
        pane.getChildren().add(label1);
        pane.getChildren().add(imageView);
        pane.getChildren().add(label2);
        getChildren().add(pane);

    }
}
