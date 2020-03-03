package tictac.animation;

import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NoConnection extends AnchorPane {

     protected final Text text;
    protected final Glow glow;
    protected final Button button;
    protected final Text text0;
    protected final Glow glow0;
    protected final ImageView imageView;

    public NoConnection() {

        text = new Text();
        glow = new Glow();
        button = new Button();
        text0 = new Text();
        glow0 = new Glow();
        imageView = new ImageView();

        setId("AnchorPane");
        setPrefHeight(442.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #666633;");

        text.setFill(javafx.scene.paint.Color.valueOf("#f50c0c"));
        text.setLayoutX(36.0);
        text.setLayoutY(66.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("No longer connected");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(529.6708984375);
        text.setFont(new Font("System Bold", 41.0));

        glow.setLevel(0.6);
        text.setEffect(glow);

        button.setLayoutX(236.0);
        button.setLayoutY(341.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(55.0);
        button.setPrefWidth(129.0);
        button.setText("OK");
        button.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        button.setFont(new Font("System Bold", 29.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#570505"));
        text0.setLayoutX(35.0);
        text0.setLayoutY(263.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Connection between you and the other player is closed");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(529.6708984375);
        text0.setFont(new Font("System Bold", 30.0));

        glow0.setLevel(0.6);
        text0.setEffect(glow0);

        imageView.setFitHeight(132.0);
        imageView.setFitWidth(175.0);
        imageView.setLayoutX(213.0);
        imageView.setLayoutY(89.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("disconnected.png").toExternalForm()));

        getChildren().add(text);
        getChildren().add(button);
        getChildren().add(text0);
        getChildren().add(imageView); 
        button.setOnAction((e)->{
          Stage parent =  (Stage)this.getScene().getWindow();
          parent.close();
        });
    }
}
