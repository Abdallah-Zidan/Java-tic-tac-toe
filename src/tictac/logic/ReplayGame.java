
package tictac.logic;

import javafx.animation.AnimationTimer;

public class ReplayGame extends Game {
    int counter ;
    ReplayTimer timer;
    public ReplayGame(String gameType ,int  oppenent_id , int user_id, char myMark , GameTestUi ui , EndGameUi endUi){
        super(false , gameType , oppenent_id,user_id,myMark,ui,endUi);
        counter =0;
        timer =new ReplayTimer();
        timer.start();
        
    }
    public void startReplay(){
            
            ui.setText(buttons[steps.get(counter).getX()][steps.get(counter).getY()],steps.get(counter).getMark());
            counter ++;
            if (counter >= steps.size()){
                timer.stop();
            }
    }
   class ReplayTimer extends AnimationTimer{

        @Override
        public void handle(long now) {
            startReplay();
            try{
               Thread.sleep(1000); 
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            
        }
       
   }
    @Override
    public void play(int x , int y){}
    
}
