package tictac.logic;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class EndGameUi extends Pane {

    protected final Text textMsg;

    public EndGameUi() {

        textMsg = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(357.0);
        setPrefWidth(395.0);

        textMsg.setFill(javafx.scene.paint.Color.valueOf("#e53715"));
        textMsg.setLayoutX(64.0);
        textMsg.setLayoutY(163.0);
        textMsg.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        textMsg.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textMsg.setStrokeWidth(5.0);
        textMsg.setText("End of the Game");
        textMsg.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textMsg.setWrappingWidth(286.6708984375);
        textMsg.setFont(new Font(60.0));

        getChildren().add(textMsg);

    }
    
    public void setMsg(String result){
        textMsg.setText(result);
    }
}
