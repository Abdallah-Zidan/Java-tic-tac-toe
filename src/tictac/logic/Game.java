package tictac.logic;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

class Player{
    
}

class Step{
    
}

public abstract class Game {
  
    protected Board board; //= new Board();
    protected boolean gameEnded; //= false;
    protected boolean myTurn;// = true;
    protected boolean isRecorded ;
    protected Player oppenent;
    protected char oppenentMark ;
    protected char myMark;
    protected ArrayList<Step> steps;
    protected Button[][] buttons;
    protected GameTestUi ui;
    protected Position[] winnigPositions = new Position[3];
    protected EndGameUi endUi;
    Game(boolean isRecorded , Player oppenent , char myMark , GameTestUi ui , EndGameUi endUi ){
        this.ui = ui;
        this.endUi = endUi;
        buttons = ui.getBoardButtons();
        gameEnded =false;
        myTurn = true;
        board = new Board();
        this.isRecorded = isRecorded;
        this.oppenent = oppenent;
        this.myMark = myMark;
        if(myMark == PlayerSign.Circle){
            oppenentMark =PlayerSign.Cross;
        }else{
             oppenentMark =PlayerSign.Circle;
        }
        if(isRecorded){
            steps = new ArrayList<>();
        }
       
    }
    
    /*
    this method is responsible for adding action events on the game buttons
    */
     public void startActionHandling(){
          buttons[0][0].setOnAction((ActionEvent event) -> {
                    play(0,0);
                     });
          
                 buttons[0][1].setOnAction((ActionEvent event) -> {
                    play(0,1);
                     });
                 
                 buttons[0][2].setOnAction((ActionEvent event) -> {
                    play(0,2);
                    });
                  
                 buttons[1][0].setOnAction((ActionEvent event) -> {
                    play(1,0);
                     });
                 buttons[1][1].setOnAction((ActionEvent event) -> {
                    play(1,1);
                      });
                 buttons[1][2].setOnAction((ActionEvent event) -> {
                    play(1,2);
                      });
                 buttons[2][0].setOnAction((ActionEvent event) -> {
                    play(2,0);
                     });
                 buttons[2][1].setOnAction((ActionEvent event) -> {
                    play(2,1);
                     });
                 buttons[2][2].setOnAction((ActionEvent event) -> {
                    play(2,2);
                      });
     }   
    
     // disable the game buttons when game ends
    private void disableButtons(){
        for(int i=0;i<3;i++){
                for(int j =0 ; j<3 ;j++){
                    buttons[i][j].setDisable(true);
                }
                
            }
    }
    // check if someone won or there is a draw 
    protected  int evaluateGame(){
        GameState gameState = board.getGameState(myMark , oppenentMark ,winnigPositions);
        int retval =4;
        gameEnded = true;
        switch(gameState){
            case YouWin: 
                System.out.println("You Won!");
                retval =1;
                  disableButtons();
                break;
            case OppWin : 
                System.out.println("openent Won!");
                retval =2;
                  disableButtons();
                break;
            case Draw : 
                System.out.println("Draw!");
                retval =3;
                disableButtons();
                break;
            default : gameEnded = false;
                retval =4;
                break;
        }
        return retval;
    }
    
    // check if clicked position is available or not ... if available return it
   Position makeMove(int x , int y){
        Position position = null;
        position = new Position(y, x);
        if(board.isMarked(position)){
           position = null;
        }
         return position;
    }

  // draw the marks on the buttons X or O after each move
    public void drawBoardOnButtons(Board board){
        ui.resetButtons();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char sign = board.getBoard()[j][i];
                if(sign!='e'){
                    ui.setText(buttons[i][j],sign);
                }
                
            }
        }
    }
    
    public void highlightButtons (){
        // check diagonal 
        if(buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText())){
              ui.highLight(buttons[0][0]);
              ui.highLight(buttons[1][1]);
              ui.highLight(buttons[2][2]);  
         
        } 
	if(buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText())){
              ui.highLight(buttons[0][2]);
              ui.highLight(buttons[1][1]);
              ui.highLight(buttons[2][0]);
          
        }
	//Check row
	for(int x=0;x<3;x++){
            if(buttons[x][0].getText().equals(buttons[x][1].getText()) && buttons[x][0].getText().equals(buttons[x][2].getText())){
              ui.highLight(buttons[x][0]);
              ui.highLight(buttons[x][1]);
              ui.highLight(buttons[x][2]); 
           
              break;
           }
	}

	//Check col
	for(int y=0;y<3;y++){
	     if(buttons[0][y].getText().equals(buttons[1][y].getText()) && buttons[0][y].getText().equals(buttons[2][y].getText())){
              ui.highLight(buttons[0][y]);
              ui.highLight(buttons[1][y]);
              ui.highLight(buttons[2][y]); 
              break;
           }
	}
    }
    
    public void showResult(int result){
         final Stage endStage = new Stage();
            endStage.initModality(Modality.APPLICATION_MODAL);
            endStage.initStyle(StageStyle.UTILITY);
             Scene  endScene;

           switch(result){
               case 1: 
                   highlightButtons();
                  endUi.setMsg("you won");
                   endScene = new Scene(endUi);
                  endStage.setScene(endScene);
                  endStage.show();
                   break;
               case 2:
                   highlightButtons();
                    endUi.setMsg("you lost");
                    endScene = new Scene(endUi);
                    endStage.setScene(endScene);
                   endStage.show();
                   break;
               case 3:       
                     endUi.setMsg("Draw");
                      endScene = new Scene(endUi);
                    endStage.setScene(endScene);
                   endStage.show();
                   break;
                   
           }
    }
    
    // abstract method that should be implemented to specify how the game is played in single or two players mode
    abstract public void play(int x , int y);
}





