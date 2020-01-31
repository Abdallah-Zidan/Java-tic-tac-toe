/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author nour
 */
public class TestUi extends Application {
    
    @Override
    public void start(Stage stage) {
        
//screens objects and scenes
        PrimaryB pb = new PrimaryB();
        Scene sc1 = new Scene(pb);
        
        RegisterB rb = new RegisterB();
        Scene sc2 = new Scene(rb);
        
        LoginB lb = new LoginB();
        Scene sc3 = new Scene(lb);
        
        PlayB pl = new PlayB();
        Scene sc4 = new Scene(pl);
        
        ChooseSymB cs = new ChooseSymB();
        Scene sc5 = new Scene(cs);
        
        GameBoodyB gb = new GameBoodyB();
        Scene sc6 = new Scene(gb);
// primary-----------------------       
        pb.register.setOnAction((ActionEvent e)-> {
            stage.setScene(sc2);
        
        });
        pb.login.setOnAction((ActionEvent e)-> {
            stage.setScene(sc3);
        
        });
// register-----------------------      
        rb.regGo.setOnAction((ActionEvent e) ->{
            stage.setScene(sc4);
        });
        rb.button.setOnAction((ActionEvent e)-> {
            stage.setScene(sc1);
        
        });
//login --------------------------        
        lb.logGo.setOnAction((ActionEvent e) ->{
            stage.setScene(sc4);
        });
        lb.button.setOnAction((ActionEvent e)-> {
            stage.setScene(sc1);
        
        });
//play -----------------------------
        pl.button.setOnAction((ActionEvent e)-> {
            stage.setScene(sc1);
        
        });
       pl.singlePlayer.setOnAction((ActionEvent e)-> {
            stage.setScene(sc5);
        
        });
        pl.twoPlayer.setOnAction((ActionEvent e)-> {
            stage.setScene(sc5);
        
        });
//choose -----------------------
        cs.arrow.setOnAction((ActionEvent e) -> {
            stage.setScene(sc4);
        });
        
        cs.startPlay.setOnAction((ActionEvent e) ->{
            stage.setScene(sc6);
        });
        
//game boody -------------------------------
        gb.arrow.setOnAction((ActionEvent e) -> {
            stage.setScene(sc4);
        });
//stylesheet ----------------------------------
        sc1.getStylesheets().add(getClass().getResource("style.css").toString());
        sc2.getStylesheets().add(getClass().getResource("style.css").toString());
        sc3.getStylesheets().add(getClass().getResource("style.css").toString());
        sc4.getStylesheets().add(getClass().getResource("style.css").toString());
        sc5.getStylesheets().add(getClass().getResource("style.css").toString());
        sc6.getStylesheets().add(getClass().getResource("style.css").toString());
        
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(sc1);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
