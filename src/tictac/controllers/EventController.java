/*
Fetch game, players from DB, Store new players to DB on connect
Function in gamebody to disable play again
send levels
X & O font change from the Game class, missing with the design font
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.controllers;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import tictac.animation.GameOver;
import tictac.database.Player;
import tictac.database.SavedGameModel;
import tictac.database.User;
import tictac.game.MainGame;
import tictac.logic.*;
import tictac.network.Client;
import tictac.network.Server;
import tictac.ui.*;

/**
 *
 * @author Tarek
 */
public class EventController {
    private EventController() {}

    public static class Primary {
        private Primary() {}

        public static EventHandler<ActionEvent> registerOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new RegisterScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> loginOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new LoginScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class Register {
        private Register() {}

        public static EventHandler<ActionEvent> registerOnAction(RegisterScreen pane) {
            return (event) -> {
                String username = pane.getUsername().getText();
                String password = pane.getPassword().getText();
                String fname = pane.getFirstName().getText();
                String lname = pane.getLastName().getText();

                if (username.isEmpty() || password.isEmpty() || fname.isEmpty() || lname.isEmpty())
                    pane.setValidator("Enter missing info");
                else {
                    User user = new User(username, password, fname, lname);

                    if (user.userExist(username))
                        pane.setValidator("Username already exists");
                    else {
                        user.save();
                        MainGame.gameInfo.setUser(user);
                        MainGame.game.setParentScene(new Scene(new PlayScreen()));
                        MainGame.game.initializeScene();
                        MainGame.game.showScene();
                    }
                }
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PrimaryScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class Login {
        private Login() {}

        public static EventHandler<ActionEvent> loginOnAction(LoginScreen pane) {
            return (event) -> {
                String username = pane.getUsername().getText();
                String password = pane.getPassword().getText();

                if (username.isEmpty() || password.isEmpty())
                    pane.setValidator("Enter missing data");
                else {
                    User user = new User(username, password);

                    if (!user.isAuthentic())
                        pane.setValidator("Invalid username or password");
                    else {
                        MainGame.gameInfo.setUser(user);
                        MainGame.game.setParentScene(new Scene(new PlayScreen()));
                        MainGame.game.initializeScene();
                        MainGame.game.showScene();
                    }
                }
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PrimaryScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class Play {
        private Play() {}

        public static EventHandler<ActionEvent> singleOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseSymbolScreen("single")));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> twoOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseSymbolScreen("two")));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> onlineOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseHostScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> savedOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new SavedGameScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PrimaryScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class SavedGame {
        private SavedGame() {}

        public static EventHandler<ActionEvent> replayOnAction(SavedGameScreen pane) {
            return (event) -> {
                GameBodyScreen ui = new GameBodyScreen();
                SavedGameModel game = (SavedGameModel)pane.getTable().getSelectionModel().getSelectedItem();
                User user = new User(MainGame.gameInfo.username, MainGame.gameInfo.password);
                user.getUserInfo();
                Player player = Player.getPlayer(1);

                ReplayGame replay = new ReplayGame(player, user, game.getSymbol(), game.getId(), ui);

                MainGame.game.setParentScene(new Scene(ui));
                MainGame.game.initializeScene();
                MainGame.game.showScene();

                ui.playSound();
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PlayScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class ChooseHost {
        private ChooseHost() {}

        public static EventHandler<ActionEvent> createOnAction() {
            return (event) -> {
                String ip = "";
                try {
                    ip = InetAddress.getLocalHost().getHostAddress();
                }
                catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                CreateRoomScreen pane = new CreateRoomScreen();
                pane.setIpAddress(ip);

                MainGame.gameInfo.isServer = true;
                MainGame.game.setParentScene(new Scene(pane));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> joinOnAction() {
            return (event) -> {
                MainGame.gameInfo.isServer = false;
                MainGame.game.setParentScene(new Scene(new JoinRoomScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PlayScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class CreateRoom {
        private CreateRoom() {}

        public static EventHandler<ActionEvent> createOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseSymbolScreen("online")));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseHostScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class JoinRoom {
        private JoinRoom() {}

        public static EventHandler<ActionEvent> connectOnAction(JoinRoomScreen pane) {
            return (event) -> {
                String ip = pane.getIpAddress().getText();

                if (ip.isEmpty())
                    pane.setValidator("Enter ip address");
                else {
                    MainGame.gameInfo.IpAddress = ip;
                    MainGame.game.setParentScene(new Scene(new ChooseSymbolScreen("online")));
                    MainGame.game.initializeScene();
                    MainGame.game.showScene();
                }
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseHostScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class ChooseSymbol {
        static Game game;

        private ChooseSymbol() {}

        public static EventHandler<ActionEvent> xOnAction(String screen, ChooseSymbolScreen pane) {
            return (event) -> {
                startGame('X', screen, pane);
            };
        }

        public static EventHandler<ActionEvent> oOnAction(String screen, ChooseSymbolScreen pane) {
            return (event) -> {
                startGame('O', screen, pane);
            };
        }

        public static EventHandler<ActionEvent> recordOnAction(ChooseSymbolScreen pane) {
            return (event) -> {
                pane.changeRecord();
            };
        }

        public static EventHandler<ActionEvent> easyOnAction(ChooseSymbolScreen pane) {
            return (event) -> {
                pane.changeDifficulty("easy");
            };
        }

        public static EventHandler<ActionEvent> mediumOnAction(ChooseSymbolScreen pane) {
            return (event) -> {
                pane.changeDifficulty("medium");
            };
        }

        public static EventHandler<ActionEvent> hardOnAction(ChooseSymbolScreen pane) {
            return (event) -> {
                pane.changeDifficulty("hard");
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PlayScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        private static void startGame(char symbol, String screen, ChooseSymbolScreen pane) {
            Pane ui = new GameBodyScreen();
            GameOver endUi = new GameOver();
            User user = new User(MainGame.gameInfo.username, MainGame.gameInfo.password);
            user.getUserInfo();
            Player player = Player.getPlayer(1);

            if (screen.toLowerCase().equals("single")) {
                game = new SingleMode(pane.getRecord(), player, user, symbol, (GameBodyScreen)ui);
                game.startActionHandling();
            }
            else if (screen.toLowerCase().equals("two")) {
                game = new TwoPlayersMode(pane.getRecord(), player, user, symbol, (GameBodyScreen)ui);
                game.startActionHandling();
            }
            else if (screen.toLowerCase().equals("online")) {
                ui = new WaitRoomScreen();

                if (MainGame.gameInfo.isServer) {
                    Thread test = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new Server();
                            Platform.runLater(() -> {
                                showOnlineGame(pane.getRecord(), player, user, symbol, true);
                            });
                        }
                    });

                    test.start();
                }
                else {
                    Thread test = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new Client(MainGame.gameInfo.IpAddress);    // 172.16.1.221
                            Platform.runLater(() -> {
                                showOnlineGame(pane.getRecord(), player, user, symbol, false);
                            });
                        }
                    });

                    test.start();
                }
            }

            MainGame.game.setParentScene(new Scene(ui));
            MainGame.game.initializeScene();
            MainGame.game.showScene();

            if (!screen.toLowerCase().equals("online"))
                ((GameBodyScreen)ui).playSound();
        }

        private static void showOnlineGame(boolean isRecord, Player player, User user, char symbol, boolean isServer) {
            GameBodyScreen ui = new GameBodyScreen();
            MainGame.game.setParentScene(new Scene(ui));
            MainGame.game.initializeScene();
            MainGame.game.showScene();
            ui.playSound();

            if (MainGame.gameInfo.socket != null) {
                game = new TwoPlayersNetwork(isRecord, player, user, symbol, ui, MainGame.gameInfo.socket, isServer);
                game.startActionHandling();
            }
        }
    }

    public static class WaitRoom {
        private WaitRoom() {}

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                if (MainGame.gameInfo.socket != null) {
                    try {
                        MainGame.gameInfo.socket.close();
                        MainGame.gameInfo.socket = null;
                    }
                    catch (IOException e) {}
                }
                if (MainGame.gameInfo.serverSocket != null) {
                    try {
                        MainGame.gameInfo.serverSocket.close();
                        MainGame.gameInfo.serverSocket = null;
                    }
                    catch (IOException e) {}
                }

                MainGame.game.setParentScene(new Scene(new ChooseHostScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class GameBody {
        private GameBody() {}

        public static EventHandler<ActionEvent> playAgainOnAction() {
            return (event) -> {
                ChooseSymbol.game.resetGame(ChooseSymbol.game.isMyTurn());
            };
        }

        public static EventHandler<ActionEvent> backOnAction(GameBodyScreen pane) {
            return (event) -> {
                pane.stopSound();

                if (MainGame.gameInfo.socket != null) {
                    try {
                        MainGame.gameInfo.socket.close();
                        MainGame.gameInfo.socket = null;
                    }
                    catch (IOException e) {}
                }
                if (MainGame.gameInfo.serverSocket != null) {
                    try {
                        MainGame.gameInfo.serverSocket.close();
                        MainGame.gameInfo.serverSocket = null;
                    }
                    catch (IOException e) {}
                }

                MainGame.game.setParentScene(new Scene(new PlayScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }
}
