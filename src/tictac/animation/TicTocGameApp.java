/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.animation;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 *
 * @author Dell
 */
public class TicTocGameApp extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
      
       GameOver root = new GameOver();
       root.setState(1);
        Scene scene = new Scene(root);
     
        stage.show();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setHeight(600);
        stage.setWidth(600);
        PauseTransition delay = new PauseTransition(Duration.seconds(7));
        delay.setOnFinished( event -> stage.close() );
        delay.play();

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        launch(args);
    }
    
}
