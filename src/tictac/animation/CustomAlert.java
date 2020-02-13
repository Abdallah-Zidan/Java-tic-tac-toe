/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.animation;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import tictac.game.MainGame;
import tictac.ui.PlayScreen;

/**
 *
 * @author zidan
 */
public class CustomAlert extends Alert {
    
    public CustomAlert(AlertType alertType) {
        super(alertType);
        this.setTitle("Connection closed");
        this.setHeaderText("No longer coonnected");
        this.setContentText("Connection between you and your friend was closed!");
        
        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource("myDialogs.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        
        this.showAndWait();
        
        MainGame.game.setParentScene(new Scene(new PlayScreen()));
        MainGame.game.initializeScene();
        MainGame.game.showScene();
    }
    
}
