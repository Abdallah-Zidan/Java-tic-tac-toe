/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.database;

import java.util.Random;

/**
 *
 * @author al-haitham
 */
public class Seeds {
    Random rand = new Random();
    
    public void createRandomUsers(int limit){
        for(int i=0; i<limit; i++){
            User user = new User(randomString(), "password", randomString(), randomString());
            user.save();
        }
    }
    public void createRandomPlayers(int limit, int user_id){
        for(int i=0; i<limit; i++){
            Player player = new Player(randomString(), randomString(), generateIPAddress());
            player.save();
        }
    }
    public void createRandomGames(int limit, int user_id){
        String g, r, l;
        char s;
        int n;
        for(int i=0; i<limit; i++){
            g = GameType.random().toString();
            s = Sympol.random().toString().charAt(0);
            r = Result.random().toString();
            l = Level.random().toString();
            n = rand.nextInt(limit)+1;
            GameModel game = new GameModel(g, s, n, user_id, r, l);
            game.save();
        }
    }
    public void createRandomSteps(int limit, int game_id){
        int x, y;
        String turn;
        for(int i=0; i<limit; i++){
            turn = Turn.random().toString();
            x = rand.nextInt(3);
            y = rand.nextInt(3);
            Step step = new Step(x, y, game_id, turn);
            step.save();
        }
    }
    
    public enum Turn {
        mine, oponent;
        public static Turn random(){
            Turn[] turns = Turn.values();
            Random generator = new Random();
            return turns[generator.nextInt(turns.length)];
        }
    }
    public enum GameType {
        solo, dual;
        public static GameType random(){
            GameType[] types = GameType.values();
            Random generator = new Random();
            return types[generator.nextInt(types.length)];
        }
    }
    public enum Sympol {
        x, o;
        public static Sympol random(){
            Sympol[] sympols = Sympol.values();
            Random generator = new Random();
            return sympols[generator.nextInt(sympols.length)];
        }
    }
    public enum Result {
        victory, loss;
        public static Result random(){
            Result[] results = Result.values();
            Random generator = new Random();
            return results[generator.nextInt(results.length)];
        }
    }
    public enum Level {
        easy, medium, hard;
        public static Level random(){
            Level[] levels = Level.values();
            Random generator = new Random();
            return levels[generator.nextInt(levels.length)];
        }
    }
    public String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        String generatedString = rand.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        //System.out.println(generatedString);
        return generatedString;
    }
    private String generateIPAddress() {
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }
}
