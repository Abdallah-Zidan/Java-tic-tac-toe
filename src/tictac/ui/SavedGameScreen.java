package tictac.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictac.controllers.EventController;
import tictac.database.GameModel;
import tictac.database.SavedGameModel;
import tictac.database.User;
import tictac.game.MainGame;

public class SavedGameScreen extends Pane {
    protected final ImageView imageView;
    protected final TableView<SavedGameModel> tableView;
    protected final TableColumn<SavedGameModel, String> tableColumn;
    protected final TableColumn<SavedGameModel, String> tableColumn0;
    protected final TableColumn<SavedGameModel, String> tableColumn1;
    protected final TableColumn<SavedGameModel, String> tableColumn2;
    protected final Button replay;
    protected final Button arrow;
    protected final ImageView imageView0;

    public SavedGameScreen() {
        imageView = new ImageView();
        tableView = new TableView<>();
        tableColumn = new TableColumn<>("Date/Time");
        tableColumn0 = new TableColumn<>("Game Type");
        tableColumn1 = new TableColumn<>("Player Name");
        tableColumn2 = new TableColumn<>("Result");
        replay = new Button();
        arrow = new Button();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        getStylesheets().add(getClass().getResource("style.css").toString());

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(700.0);
        imageView.setImage(new Image(getClass().getResource("images/tex3.jpeg").toExternalForm()));

        tableView.setLayoutX(253.0);
        tableView.setLayoutY(51.0);
        tableView.setPrefHeight(398.0);
        tableView.setPrefWidth(425.0);

        tableColumn.setPrefWidth(87.0);
        tableColumn.getStyleClass().add("col");
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("timestamp"));

        tableColumn0.setPrefWidth(108.0);
        tableColumn0.getStyleClass().add("col");
        tableColumn0.setCellValueFactory(new PropertyValueFactory<>("gameType"));

        tableColumn1.setPrefWidth(118.0);
        tableColumn1.getStyleClass().add("col");
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        tableColumn2.setPrefWidth(111.0);
        tableColumn2.getStyleClass().add("col");
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("result"));

        replay.setLayoutX(64.0);
        replay.setLayoutY(250.0);
        replay.setMnemonicParsing(false);
        replay.setPrefHeight(64.0);
        replay.setPrefWidth(131.0);
        replay.getStyleClass().add("btn");
        replay.setText("Replay");
        replay.setFont(Font.loadFont(getClass().getResource("fonts/BubbleboddyNeueTrialRegular.ttf").toExternalForm(), 24.0));
        replay.setOnAction(EventController.SavedGame.replayOnAction(this));

        arrow.setLayoutX(52.0);
        arrow.setLayoutY(410.0);
        arrow.setMnemonicParsing(false);
        arrow.setPrefHeight(39.0);
        arrow.setPrefWidth(29.0);
        arrow.getStyleClass().add("arrow");
        arrow.setCursor(Cursor.HAND);
        arrow.setOnAction(EventController.SavedGame.backOnAction());

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(63.0);
        imageView0.setImage(new Image(getClass().getResource("images/imgar.png").toExternalForm()));
        arrow.setGraphic(imageView0);

        getChildren().add(imageView);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        tableView.getColumns().add(tableColumn1);
        tableView.getColumns().add(tableColumn2);
        getChildren().add(tableView);
        getChildren().add(replay);
        getChildren().add(arrow);

        loadSavedGames();
    }

    private void loadSavedGames() {
        User user = new User(MainGame.gameInfo.username, MainGame.gameInfo.password);
        user.getUserInfo();

        for (GameModel game : user.games())
            tableView.getItems().add(new SavedGameModel(game.getId(),
                                                        game.getTimestamp(),
                                                        game.getType(),
                                                        game.getPlayerId(),
                                                        game.getResult(),
                                                        game.getSympol()));
    }

    public TableView getTable() {
        return tableView;
    }
}
