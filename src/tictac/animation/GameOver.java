package tictac.animation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public  class GameOver extends AnchorPane {

    protected final ImageView image;
   protected Image win;
    protected Image loss;
    public GameOver() {

        image = new ImageView();

        setId("AnchorPane");
        setPrefHeight(456.0);
        setPrefWidth(598.0);

        image.setFitHeight(437.0);
        image.setFitWidth(591.0);
        image.setLayoutX(3.0);
        image.setLayoutY(9.0);
        image.setPickOnBounds(true);
        image.setPreserveRatio(true);
         win = new Image(getClass().getResourceAsStream("Win.gif"));
         loss = new Image(getClass().getResourceAsStream("lossgame.gif"));
        //image.setImage(win);
        getChildren().add(image);

    }
    public void setState(int state){
        if(state==1){
            image.setImage(win);
        }else{
            image.setImage(loss);
        }
    }
            
}
