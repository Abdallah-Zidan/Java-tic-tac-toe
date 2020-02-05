package tictac.ui;

//import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;

public class TwoPlayerB extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final Button createRoom;
    protected final Button selectRoom;

    public TwoPlayerB() {

        pane = new Pane();
        label = new Label();
        createRoom = new Button();
        selectRoom = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(592.0);
        setPrefWidth(318.0);

        pane.setPrefHeight(590.0);
        pane.setPrefWidth(317.0);
        pane.setStyle("-fx-background-color: #fffff6;;");

        label.setLayoutX(11.0);
        label.setLayoutY(63.0);
        label.setPrefHeight(136.0);
        label.setPrefWidth(296.0);
        label.setText("Choose Playing Room");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#930a0a"));
        label.setWrapText(true);
        label.setFont(new Font("Bubbleboddy Neue Trial Regular", 39.0));

        createRoom.setLayoutX(94.0);
        createRoom.setLayoutY(257.0);
        createRoom.setStyle("-fx-background-color: #930a0a;");
        createRoom.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));
//        createRoom.setOnAction(EventController.TwoPlayer.createRoomOnAction());

        selectRoom.setLayoutX(94.0);
        selectRoom.setLayoutY(387.0);
        selectRoom.setStyle("-fx-background-color: #930a0a;");
        selectRoom.setFont(new Font("Bubbleboddy Neue Trial Regular", 16.0));
//        selectRoom.setOnAction(EventController.TwoPlayer.selectRoomOnAction());

        pane.getChildren().add(label);
        pane.getChildren().add(createRoom);
        pane.getChildren().add(selectRoom);
        getChildren().add(pane);

    }
}
