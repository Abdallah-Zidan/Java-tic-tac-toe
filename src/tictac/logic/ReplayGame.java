
package tictac.logic;
import java.util.ArrayList;
import tictac.database.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;

public class ReplayGame  {
    int counter ;
    ReplayTimer timer;
    int gameId ;
    GameTestUi ui;
    char myMark;
    char oppenentMark;
    User user;
    Player oppenent;
    Button[][] buttons;
    ArrayList<Step> steps;
    public ReplayGame(Player oppenent , User user, char myMark ,int gameId, GameTestUi ui ){
        counter =0;
        
        this.user = user;
        this.oppenent = oppenent;
        this.myMark = myMark;
        if(myMark ==PlayerSign.Cross){
            oppenentMark = PlayerSign.Circle;
        }
        else{
            oppenentMark = PlayerSign.Cross;
        }
        this.buttons = ui.getBoardButtons();
        this.steps = GameModel.getSteps(gameId);
        this.ui = ui;
        timer =new ReplayTimer();
        timer.start();
    }
    public void startReplay(){
            SingleMode sm = new SingleMode(false, null, null, 'c', ui, null);
            ui.setText(buttons[steps.get(counter).getX()][steps.get(counter).getY()],steps.get(counter).getTurn().equals("mine")?myMark:oppenentMark);
            counter ++;
            if (counter >= steps.size()){
                timer.stop();
                sm.highlightButtons();
            }
             
    }
   class ReplayTimer extends AnimationTimer{

        @Override
        public void handle(long now) {
            startReplay();
           try{
               Thread.sleep(700); 
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            
        }
       
   }
  
}
