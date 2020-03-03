/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
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
        
        public static EventHandler<ActionEvent> aboutOnAction() {
            return (event) -> {
                AboutScreen pane = new AboutScreen();
                MainGame.game.setParentScene(new Scene(pane));
                MainGame.game.initializeScene();

                Duration d = Duration.millis(4500);
                TranslateTransition tr = new TranslateTransition(d, pane.getPane());
                tr.setByY(-300);
                tr.play();

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

        public static EventHandler<ActionEvent> exitOnAction() {
            return (event) -> {
                System.exit(0);
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
                Player player = game.getPlayer();

                ui.setFirstName(user.getFname());
                ui.setFirstSymbol(game.getSymbol());
                ui.setSecondName(player.getFname());
                ui.setSecondSymbol(Character.toLowerCase(game.getSymbol()) == 'x' ? 'o' : 'x');
                ui.setScore(user.getScore());

                ReplayGame replay = new ReplayGame(player, user, Character.toUpperCase(game.getSymbol()), game.getId(), ui);

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
                 if(!PrimaryScreen.getAudio().isPlaying()){
                    PrimaryScreen.playSound(); 
                }
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
                 if(!PrimaryScreen.getAudio().isPlaying()){
                    PrimaryScreen.playSound(); 
                }
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
                String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
                Pattern regex = Pattern.compile(pattern);
                Matcher match = regex.matcher(ip);

                if (!match.find())
                    pane.setValidator("Enter valid ip address");
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
                 if(!PrimaryScreen.getAudio().isPlaying()){
                    PrimaryScreen.playSound(); 
                }
            };
        }

        private static void startGame(char symbol, String screen, ChooseSymbolScreen pane) {
            Pane ui = new GameBodyScreen();
            GameOver endUi = new GameOver();
            User user = new User(MainGame.gameInfo.username, MainGame.gameInfo.password);
            user.getUserInfo();
            Player player;

            ((GameBodyScreen)ui).setFirstName(user.getFname());
            ((GameBodyScreen)ui).setFirstSymbol(symbol);
            ((GameBodyScreen)ui).setSecondSymbol(Character.toLowerCase(symbol) == 'x' ? 'o' : 'x');
            ((GameBodyScreen)ui).setScore(user.getScore());

            if (screen.toLowerCase().equals("single")) {
                player = Player.getPlayer(1);
                ((GameBodyScreen)ui).setSecondName(player.getFname());
                game = new SingleMode(pane.getRecord(), player, user, symbol, pane.getDifficulty(), (GameBodyScreen)ui);
                game.startActionHandling();
            }
            else if (screen.toLowerCase().equals("two")) {
                player = Player.getPlayer(2);
                ((GameBodyScreen)ui).setSecondName(player.getFname());
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

                            if (MainGame.gameInfo.socket != null && !MainGame.gameInfo.socket.isClosed()) {
                                User user = new User(MainGame.gameInfo.username, MainGame.gameInfo.password);
                                user.getUserInfo();
                                Player p = new Player();

                                String ip = "";
                                try {
                                    ip = InetAddress.getLocalHost().getHostAddress();
                                }
                                catch (UnknownHostException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    Player player = new Player(user.getFname(), user.getLname(), ip);
                                    ObjectOutputStream output = new ObjectOutputStream(MainGame.gameInfo.socket.getOutputStream());
                                    output.writeObject(player);
                                }
                                catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                try {
                                    ObjectInputStream input = new ObjectInputStream(MainGame.gameInfo.socket.getInputStream());
                                    p = (Player)input.readObject();
                                    p = addPlayer(p);
                                }
                                catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                catch (ClassNotFoundException ex) {
                                    System.out.println(ex.getMessage());
                                }

                                Platform.runLater(new ShowOnline(pane.getRecord(), p, user, symbol, true));
                            }
                        }
                    });

                    test.start();
                }
                else {
                    Thread test = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new Client(MainGame.gameInfo.IpAddress);

                            if (MainGame.gameInfo.socket != null && !MainGame.gameInfo.socket.isClosed()) {
                                User user = new User(MainGame.gameInfo.username, MainGame.gameInfo.password);
                                user.getUserInfo();
                                Player p = new Player();

                                String ip = "";
                                try {
                                    ip = InetAddress.getLocalHost().getHostAddress();
                                }
                                catch (UnknownHostException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    Player player = new Player(user.getFname(), user.getLname(), ip);
                                    ObjectOutputStream output = new ObjectOutputStream(MainGame.gameInfo.socket.getOutputStream());
                                    output.writeObject(player);
                                }
                                catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                try {
                                    ObjectInputStream input = new ObjectInputStream(MainGame.gameInfo.socket.getInputStream());
                                    p = (Player)input.readObject();
                                    p = addPlayer(p);
                                }
                                catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                catch (ClassNotFoundException ex) {
                                    System.out.println(ex.getMessage());
                                }

                                Platform.runLater(new ShowOnline(pane.getRecord(), p, user, symbol, false));
                            }
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

        private static Player addPlayer(Player player) {
            player = new Player(player.getFname(), player.getLname(), player.getIpAddress());

            if (!player.playerExist(player.getIpAddress()))
                player.save();

            return player.getPlayerInfo();
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
                    catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (MainGame.gameInfo.serverSocket != null) {
                    try {
                        MainGame.gameInfo.serverSocket.close();
                        MainGame.gameInfo.serverSocket = null;
                    }
                    catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
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
                    catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (MainGame.gameInfo.serverSocket != null) {
                    try {
                        MainGame.gameInfo.serverSocket.close();
                        MainGame.gameInfo.serverSocket = null;
                    }
                    catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }

                MainGame.game.setParentScene(new Scene(new PlayScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
                if(!PrimaryScreen.getAudio().isPlaying()){
                    PrimaryScreen.playSound(); 
                } 
            };
        }
    }
    
    public static class About {
        private About() {}

        public static EventHandler<ActionEvent> backOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new PlayScreen()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }
}

class ShowOnline implements Runnable {
    private boolean isRecord;
    private Player player;
    private User user;
    private char symbol;
    private boolean isServer;

    public ShowOnline(boolean isRecord, Player player, User user, char symbol, boolean isServer) {
        this.isRecord = isRecord;
        this.player = player;
        this.user = user;
        this.symbol = symbol;
        this.isServer = isServer;
    }

    @Override
    public void run() {
        GameBodyScreen ui = new GameBodyScreen();

        ui.setFirstName(user.getFname());
        ui.setFirstSymbol(symbol);
        ui.setSecondName(player.getFname());
        ui.setSecondSymbol(Character.toLowerCase(symbol) == 'x' ? 'o' : 'x');
        ui.setScore(user.getScore());

        MainGame.game.setParentScene(new Scene(ui));
        MainGame.game.initializeScene();
        MainGame.game.showScene();
        ui.playSound();

        EventController.ChooseSymbol.game = new TwoPlayersNetwork(isRecord, player, user, symbol, ui, MainGame.gameInfo.socket, isServer);
        EventController.ChooseSymbol.game.startActionHandling();
    }
}
