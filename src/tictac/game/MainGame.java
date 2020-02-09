package tictac.game;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictac.controllers.GameController;
import tictac.database.User;
import tictac.ui.PrimaryScreen;
import tictac.ui.SavedGameScreen;

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
        public String IpAddress;

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

        gameInfo = new GameInfo();
        Scene scene = new Scene(new SavedGameScreen());
        game = new GameController(primaryStage);
        game.setParentScene(scene);
        game.initializeGame();
        game.showScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
