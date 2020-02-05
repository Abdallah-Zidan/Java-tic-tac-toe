package tictac.ui;

//import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class RecordGameB extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button withR;
    protected final Button withoutR;
    protected final Button jFXButton;

    public RecordGameB() {

        pane = new Pane();
        imageView = new ImageView();
        withR = new Button();
        withoutR = new Button();
        jFXButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(592.0);
        setPrefWidth(318.0);

        pane.setPrefHeight(590.0);
        pane.setPrefWidth(317.0);
        pane.setStyle("-fx-background-color: #fffff6;;");

        imageView.setFitHeight(225.0);
        imageView.setFitWidth(232.0);
        imageView.setLayoutX(44.0);
        imageView.setLayoutY(82.0);
        imageView.setImage(new Image(getClass().getResource("filast.png").toExternalForm()));

        withR.setLayoutX(22.0);
        withR.setLayoutY(389.0);
        withR.setStyle("-fx-background-color: #930a0a;");
        withR.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));
        withR.setText("Record");
//        withR.setOnAction(EventController.RecordGame.withROnAction());

        withoutR.setLayoutX(169.0);
        withoutR.setLayoutY(389.0);
        withoutR.setStyle("-fx-background-color: #930a0a;");
        withoutR.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));
        withoutR.setText("Without record");
//        withoutR.setOnAction(EventController.RecordGame.withoutROnAction());

        jFXButton.setLayoutX(121.0);
        jFXButton.setLayoutY(468.0);
//        jFXButton.setOnAction(EventController.RecordGame.jFXButtonOnAction());

        pane.getChildren().add(imageView);
        pane.getChildren().add(withR);
        pane.getChildren().add(withoutR);
        pane.getChildren().add(jFXButton);
        getChildren().add(pane);

    }
}
