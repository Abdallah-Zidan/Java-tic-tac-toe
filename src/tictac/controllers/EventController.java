/*
Single
Multi
Record
Fetch game, players from DB
Close socket on back
Handle play again
Audio not reloading
Handle all text areas values
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.controllers;

import java.io.IOException;
import java.net.Socket;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import tictac.animation.GameOver;
import tictac.database.Player;
import tictac.database.User;
import tictac.game.MainGame;
import tictac.logic.*;
import tictac.network.Client;
import tictac.network.Server;
import tictac.ui.ChooseRoleUI;
import tictac.ui.ChooseSymB;
import tictac.ui.GameBodyB;
import tictac.ui.LoginB;
import tictac.ui.PlayB;
import tictac.ui.PrimaryB;
import tictac.ui.RegisterB;

/**
 *
 * @author Tarek
 */
public class EventController {

    private EventController() {
    }

    public static class Primary {

        private Primary() {
        }

        public static EventHandler<ActionEvent> registerOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new RegisterB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> loginOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new LoginB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    // TODO: Register
    public static class Register {

        private Register() {
        }

        public static EventHandler<ActionEvent> registerOnAction(RegisterB pane) {
            return (event) -> {
                User user = new User(pane.getUsername().getText(), pane.getPassword().getText(), "Test", "Test");

                if (user.userExist(user.getUsername())) {
                    System.out.println("User exists");
                } else {
                    user.save();
                    MainGame.gameInfo.setUser(user);
                    MainGame.game.setParentScene(new Scene(new PlayB()));
                    MainGame.game.initializeScene();
                    MainGame.game.showScene();
                }
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PrimaryB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    // TODO: Login
    public static class Login {

        private Login() {
        }

        public static EventHandler<ActionEvent> loginOnAction(LoginB pane) {
            return (event) -> {
                User user = new User(pane.getUsername().getText(), "temp");

                if (!user.isAuthentic()) {
                    System.out.println("User is not valid");
                } else {
                    MainGame.gameInfo.setUser(user);
                    MainGame.game.setParentScene(new Scene(new PlayB()));
                    MainGame.game.initializeScene();
                    MainGame.game.showScene();
                }
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PrimaryB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    // TODO: Online
    // TODO: Replay
    public static class Play {

        private Play() {
        }

        public static EventHandler<ActionEvent> singleOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseSymB("single")));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> twoOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseSymB("two")));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> onlineOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseRoleUI()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> replayOnAction() {
            return (event) -> {
                // TODO: Replay
//                MainGame.game.setParentScene(new Scene(new RecordGameB()));
//                MainGame.game.initializeScene();
//                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PrimaryB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class ChooseHost {

        private ChooseHost() {
        }

        public static EventHandler<ActionEvent> serverOnAction() {
            return (event) -> {
                MainGame.gameInfo.isServer = true;
                MainGame.game.setParentScene(new Scene(new ChooseSymB("online")));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        public static EventHandler<ActionEvent> clientOnAction() {
            return (event) -> {
                MainGame.gameInfo.isServer = false;
                MainGame.game.setParentScene(new Scene(new ChooseSymB("online")));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    // TODO: Online
    public static class ChooseSymbol {

        private ChooseSymbol() {
        }
         static Game g;
        public static EventHandler<ActionEvent> xOnAction(String screen) {
            return (event) -> {
                startGame('X', screen);
            };
        }

        public static EventHandler<ActionEvent> oOnAction(String screen) {
            return (event) -> {
                startGame('O', screen);
            };
        }

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PlayB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }

        private static void startGame(char symbol, String screen) {
            // TODO: Online
            GameBodyB ui = new GameBodyB();
            GameOver endUi = new GameOver();
            User user = new User(MainGame.gameInfo.username, MainGame.gameInfo.password);
            user.getUserInfo();
            Player player = Player.getPlayer(1);

            if (screen.toLowerCase().equals("single")) {
               g = new SingleMode(false, player, user, symbol,Constants.HARD, ui);
                g.startActionHandling();
            } else if (screen.toLowerCase().equals("two")) {
                g = new TwoPlayersMode(false, player, user, symbol, ui);
                g.startActionHandling();
            } else if (screen.toLowerCase().equals("online")) {
                if (MainGame.gameInfo.isServer) {
                    Thread test = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Server server = new Server();
//                            Socket socket = server.getSocket();

                            if (MainGame.gameInfo.socket != null) {
                                g = new TwoPlayersNetwork(false, player, user, symbol, ui, MainGame.gameInfo.socket, true);
                                g.startActionHandling();
                            }
                        }
                    });

                    test.start();
                } else {
                    Thread test = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Client client = new Client("127.0.0.1");    // 172.16.1.221
//                            Socket socket = client.getSocket();

                            if (MainGame.gameInfo.socket != null) {
                                g = new TwoPlayersNetwork(false, player, user, symbol, ui, MainGame.gameInfo.socket, false);
                                g.startActionHandling();
                            }
                        }
                    });

                    test.start();
                }
            } else if (screen.toLowerCase().equals("replay")) {
                ReplayGame replay = new ReplayGame(player, user, symbol, 0, ui);
            }

            MainGame.game.setParentScene(new Scene(ui));
            MainGame.game.initializeScene();
            MainGame.game.showScene();
            ui.playSound();
        }
    }

    public static class GameBody {

        private GameBody() {
        }

        public static EventHandler<ActionEvent> playAgainOnAction() {
            return (event) -> {
//                MainGame.game.setParentScene(new Scene(new ChooseSymB("online")));
//                MainGame.game.initializeScene();
//                MainGame.game.showScene();
                ChooseSymbol.g.resetGame(ChooseSymbol.g.isMyTurn());
            };
                      
        }

        public static EventHandler<ActionEvent> backOnAction(GameBodyB pane) {
            return (event) -> {
                pane.stopSound();

                if (MainGame.gameInfo.socket != null) {
                    try {
                        MainGame.gameInfo.socket.close();
                        MainGame.gameInfo.socket=null;
                    } catch (IOException e) {
                        // TODO
                    }
                }
                if (MainGame.gameInfo.serverSocket != null) {
                    try {
                        MainGame.gameInfo.serverSocket.close();
                        MainGame.gameInfo.serverSocket = null;
                    } catch (IOException e) {
                        // TODO
                    }
                }

                MainGame.game.setParentScene(new Scene(new PlayB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }
}
