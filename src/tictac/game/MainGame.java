//package tictac.game;
//
//// import tictac.ui.*;
//// import tictac.network.*;
//// import tictac.database.*;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//import tictac.controllers.SceneController;
//import tictac.controllers.StageController;
//
//public class MainGame extends Application {
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        // This is dummy code
//        Label label = new Label("Test");
//        TextArea text = new TextArea();
//        GridPane pane = new GridPane();
//        pane.addRow(0, label);
//        pane.addRow(1, text);
//        Scene s = new Scene(pane);
//        StageController stage = new StageController(primaryStage);
//        stage.setFullScreen(false);
//        stage.initializeStage();
//        SceneController scene = new SceneController(stage.getStage(), s, true);
//        scene.initializeScene();
//        scene.showScene();
//
//
//        TextArea text2 = new TextArea();
//        GridPane pane2 = new GridPane();
//        pane2.addRow(0, text2);
//        Scene s2 = new Scene(pane2);
//        StageController stage2 = new StageController(null, primaryStage);
//        stage2.setFullScreen(false);
//        stage2.setWidth(200);
//        stage2.setHeight(200);
//        stage2.initializeStage();
//        SceneController scene2 = new SceneController(stage2.getStage(), s2, false);
//        scene2.initializeScene();
//        scene2.showScene();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
