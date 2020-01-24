/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.controllers;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Tarek
 */
public class StageController {
    private Stage stage;
    private Stage parentStage;
    private StageStyle stageStyle;
    private double width;
    private double height;
    private boolean fullScreen;
    private boolean resizable;
    private String title;

    public StageController() {
        this(null, null);
    }
    public StageController(Stage stage) {
        this(stage, null);
    }
    public StageController(Stage stage, Stage parentStage) {
        this.stage = stage;
        this.parentStage = parentStage;
        stageStyle = StageStyle.DECORATED;
        width = 500;
        height = 400;
        fullScreen = true;
        resizable = true;
        title = "Tic Tac Toe";
    }

    public void setStage(Stage stage) { this.stage = stage; }
    public void setStageStyle(StageStyle stageStyle) { this.stageStyle = stageStyle; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
    public void setFullScreen(boolean fullScreen) { this.fullScreen = fullScreen; }
    public void setResizable(boolean resizable) { this.resizable = resizable; }
    public void setTitle(String title) { this.title = title; }

    public Stage getStage() { return stage; }
    public StageStyle getStageStyle() { return stageStyle; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public boolean getFullScreen() { return fullScreen; }
    public boolean getResizable() { return resizable; }
    public String getTitle() { return title; }

    public void initializeStage() {
        if (stage == null) {
            stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(parentStage);
        }

        stage.initStyle(stageStyle);

        stage.setWidth(width);
        stage.setHeight(height);
        stage.setFullScreen(fullScreen);
        stage.setResizable(resizable);
        stage.setTitle(title);
    }
}
