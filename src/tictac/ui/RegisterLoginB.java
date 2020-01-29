package tictac.ui;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class RegisterLoginB extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final JFXButton registerNew;
    protected final JFXButton loginOld;

    public RegisterLoginB() {

        pane = new Pane();
        imageView = new ImageView();
        registerNew = new JFXButton();
        loginOld = new JFXButton();

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

        imageView.setFitHeight(317.0);
        imageView.setFitWidth(317.0);
        imageView.setLayoutX(7.0);
        imageView.setImage(new Image(getClass().getResource("filast.png").toExternalForm()));

        registerNew.setLayoutX(99.0);
        registerNew.setLayoutY(393.0);
        registerNew.setStyle("-fx-background-color: #930a0a;");
        registerNew.setFont(new Font("Bubbleboddy Neue Trial Regular", 15.0));

        loginOld.setLayoutX(99.0);
        loginOld.setLayoutY(487.0);
        loginOld.setStyle("-fx-background-color: #930a0a;");
        loginOld.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));

        pane.getChildren().add(imageView);
        pane.getChildren().add(registerNew);
        pane.getChildren().add(loginOld);
        getChildren().add(pane);

    }
}
