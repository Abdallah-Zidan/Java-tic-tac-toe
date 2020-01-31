/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import tictac.game.MainGame;
import tictac.ui.ChooseSymbolB;
import tictac.ui.GameBodyB;
import tictac.ui.RecordGameB;
import tictac.ui.RegisterB;
import tictac.ui.TwoPlayerB;
import tictac.ui.loginB;

/**
 *
 * @author Tarek
 */
public class EventController {
    private EventController() {}

    public static class ChooseSymbol {
        private ChooseSymbol() {}

        public static EventHandler<ActionEvent> xOnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> oOnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> contOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new GameBodyB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class GameBody {
        private GameBody() {}

        public static EventHandler<ActionEvent> btn00OnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> btn01OnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> btn02OnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> btn10OnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> btn11OnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> btn12OnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> btn20OnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> btn21OnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> btn22OnAction() {
            return (event) -> {};
        }
    }

    public static class PrimaryScreen {
        private PrimaryScreen() {}

        public static EventHandler<ActionEvent> singlePlayerOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new ChooseSymbolB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
        public static EventHandler<ActionEvent> replayOldOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new RecordGameB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
        public static EventHandler<ActionEvent> twoPlayerOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new TwoPlayerB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
        public static EventHandler<ActionEvent> quitGameOnAction() {
            return (event) -> {
                Platform.exit();
            };
        }
    }

    public static class RecordGame {
        private RecordGame() {}

        public static EventHandler<ActionEvent> withROnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> withoutROnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> jFXButtonOnAction() {
            return (event) -> {};
        }
    }

    public static class Register {
        private Register() {}

        public static EventHandler<ActionEvent> nextPageOnAction() {
            return (event) -> {};
        }
    }

    public static class RegisterLogin {
        private RegisterLogin() {}

        public static EventHandler<ActionEvent> registerNewOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new RegisterB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
        public static EventHandler<ActionEvent> loginOldOnAction() {
            return (event) -> {
                MainGame.game.setParentScene(new Scene(new loginB()));
                MainGame.game.initializeScene();
                MainGame.game.showScene();
            };
        }
    }

    public static class TwoPlayer {
        private TwoPlayer() {}

        public static EventHandler<ActionEvent> createRoomOnAction() {
            return (event) -> {};
        }
        public static EventHandler<ActionEvent> selectRoomOnAction() {
            return (event) -> {};
        }
    }

    public static class Login {
        private Login() {}

        public static EventHandler<ActionEvent> jFXButtonOnAction() {
            return (event) -> {};
        }
    }
}
