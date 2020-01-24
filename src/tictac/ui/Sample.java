/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author nour
 */
public class Sample extends Application {
    @Override
    public void start(Stage primaryStage) {

        //NoteBase nb = new NoteBase(primaryStage);        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("NotePad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
