
package tictac.logic;

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
      
       SingleMode tp= new SingleMode(false, 1,1, PlayerSign.Cross,ui  , endUi );
      // TwoPlayersMode tp = new TwoPlayersMode(false, 1, PlayerSign.Circle, ui,endUi);
       tp.startActionHandling();
 
       Scene scene = new Scene(ui);
       primaryStage.setScene(scene);
       primaryStage.show();
    }
    
    
}
