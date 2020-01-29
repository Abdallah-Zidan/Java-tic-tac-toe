
package tictac.logic;
import tictac.database.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTest extends Application {
    public static void main(String[] args){      
           launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameTestUi ui = new GameTestUi();
        final Stage endStage = new Stage();
        EndGameUi endUi = new EndGameUi();
        Player p = Player.getPlayer(1);
        User u = new User("test","test");
        u.getUserInfo();
      // SingleMode tp= new SingleMode(true, p,u, PlayerSign.Cross,ui  , endUi );
      // TwoPlayersMode tp = new TwoPlayersMode(false, 1, PlayerSign.Circle, ui,endUi);
        ArrayList<Step> steps = GameModel.getSteps(5);
     // tp.startActionHandling();
       ReplayGame replay = new ReplayGame( null, null, PlayerSign.Cross,5 ,ui);
      
     
     
 
       Scene scene = new Scene(ui);
       primaryStage.setScene(scene);
       primaryStage.show();
  
     // replay.startReplay();
    }
    
    
}
