/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.animation;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import tictac.game.MainGame;
import tictac.ui.PlayScreen;

/**
 *
 * @author zidan
 */
public class CustomAlert{
    
    
    public CustomAlert() {
        NoConnection noConnection = new NoConnection();
        Stage conStage = new Stage();
        Window parent = MainGame.game.getParentScene().getWindow();
        conStage.setTitle("Disconnected");
        conStage.initOwner(parent);
        conStage.initModality(Modality.WINDOW_MODAL);
        conStage.initStyle(StageStyle.UTILITY);
        conStage.setResizable(false);
        Scene scene = new Scene(noConnection);
        conStage.setScene(scene);
        conStage.centerOnScreen();
        conStage.showAndWait();
      
        MainGame.game.setParentScene(new Scene(new PlayScreen()));
        MainGame.game.initializeScene();
        MainGame.game.showScene();
    }
    
}
