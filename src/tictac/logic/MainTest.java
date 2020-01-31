package tictac.logic;

import tictac.database.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictac.animation.GameOver;

public class MainTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameTestUi ui = new GameTestUi();
        final Stage endStage = new Stage();
        // GameEndAnimation endUi = new GameEndAnimation();
        GameOver endUi = new GameOver();
        Player p = Player.getPlayer(1);
        User u = new User("test", "test");
        u.getUserInfo();
        // SingleMode tp= new SingleMode(false, p,u, PlayerSign.Cross,ui  , endUi );
        TwoPlayersMode tp = new TwoPlayersMode(false, p, u, PlayerSign.Cross, ui, endUi);
        //  ArrayList<Step> steps = GameModel.getSteps(10);
        tp.startActionHandling();
        //ReplayGame replay = new ReplayGame( null, null, PlayerSign.Cross,0 ,ui);
        Scene scene = new Scene(ui);
        primaryStage.setScene(scene);
        primaryStage.show();

        // replay.startReplay();
    }

}
