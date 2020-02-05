package tictac.game;

import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictac.controllers.GameController;
import tictac.database.User;
import tictac.ui.PrimaryB;

public class MainGame extends Application {
    public static GameController game;
    public static GameInfo gameInfo;

    public class GameInfo {
        public int id;
        public String username;
        public String password;
        public ServerSocket serverSocket;
        public Socket socket;
        public boolean isServer = false;

        public void setUser(User user) {
            id = user.getId();
            username = user.getUsername();
            password = user.getPassword();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest((e) -> {
            System.exit(0);
        });
        
        Scene scene = new Scene(new PrimaryB());

        gameInfo = new GameInfo();
        game = new GameController(primaryStage);
        game.setParentScene(scene);
        game.initializeGame();
        game.showScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
