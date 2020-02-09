/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.database;

/**
 *
 * @author Tarek
 */
public class SavedGameModel {
    private int id;
    private String timestamp;
    private String gameType;
    private String playerName;
    private String result;
    private char symbol;

    public SavedGameModel() {}

    public SavedGameModel(int id, String timestamp, String gameType, String playerName, String result, char symbol) {
        this.id = id;
        this.timestamp = timestamp;
        this.gameType = gameType;
        this.playerName = playerName;
        this.result = result;
        this.symbol = symbol;
    }

    public void setId(int id) { this.id = id; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public void setGameType(String gameType) { this.gameType = gameType; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public void setResult(String result) { this.result = result; }
    public void setSymbol(char symbol) { this.symbol = symbol; }

    public int getId() { return id; }
    public String getTimestamp() { return timestamp; }
    public String getGameType() { return gameType; }
    public String getPlayerName() { return playerName; }
    public String getResult() { return result; }
    public char getSymbol() { return symbol; }
}
