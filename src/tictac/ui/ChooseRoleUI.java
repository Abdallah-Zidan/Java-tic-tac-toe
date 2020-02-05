package tictac.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import tictac.controllers.EventController;

public class ChooseRoleUI extends BorderPane {
    protected final Pane pane;
    protected final Button btnServer;
    protected final Button btnClient;

    public ChooseRoleUI() {
        pane = new Pane();
        btnServer = new Button();
        btnClient = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);

        btnServer.setLayoutX(176.0);
        btnServer.setLayoutY(194.0);
        btnServer.setMnemonicParsing(false);
        btnServer.setText("Server");
        btnServer.setOnAction(EventController.ChooseHost.serverOnAction());

        btnClient.setLayoutX(347.0);
        btnClient.setLayoutY(194.0);
        btnClient.setMnemonicParsing(false);
        btnClient.setText("Client");
        btnClient.setOnAction(EventController.ChooseHost.clientOnAction());
        setCenter(pane);

        pane.getChildren().add(btnServer);
        pane.getChildren().add(btnClient);
    }
    
    public Button btnServer(){
        return btnServer;
    }

    public Button btnClient(){
        return btnClient;
    }
}
