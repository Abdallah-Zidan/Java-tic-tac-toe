package tictac.game;

// import tictac.ui.*;
// import tictac.network.*;
// import tictac.database.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tictac.controllers.GameController;

public class MainGame extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // ******************** This is dummy code ********************
        Label label1 = new Label("First scene");
        TextArea text1 = new TextArea();
        Button showNextScene = new Button("Show next scene");
        Button showNextStage = new Button("Show next stage");
        GridPane pane = new GridPane();
        pane.addRow(0, label1);
        pane.addRow(1, text1);
        pane.addRow(2, showNextScene);
        pane.addRow(3, showNextStage);
        Scene scene1 = new Scene(pane);
        // ****************************************
        TextArea text2 = new TextArea();
        GridPane pane2 = new GridPane();
        pane2.addRow(0, text2);
        Scene scene2 = new Scene(pane2);
        // ****************************************
        Label label3 = new Label("This is next scene");
        Button showPrevScene = new Button("Show prev scene");
        GridPane pane3 = new GridPane();
        pane3.addRow(0, label3);
        pane3.addRow(1, showPrevScene);
        Scene scene3 = new Scene(pane3);
        // ****************************************
        GameController game = new GameController(primaryStage);

        showNextStage.setOnAction((event) -> {
            game.setChildScene(scene2);
            game.initializeChildStage(primaryStage);
            game.showChildStage();
        });
        showNextScene.setOnAction((event) -> {
            game.setParentScene(scene3);
            game.initializeScene();
            game.showScene();
        });
        showPrevScene.setOnAction((event) -> {
            game.setParentScene(scene1);
            game.initializeScene();
            game.showScene();
        });
        // ****************************************
        game.setParentScene(scene1);
        game.initializeGame();
        game.showScene();
        // ******************** This is dummy code ********************
    }

    public static void main(String[] args) {
        launch(args);
    }
}
