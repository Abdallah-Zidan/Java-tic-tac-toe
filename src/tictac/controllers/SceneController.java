/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.controllers;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Tarek
 */
public class SceneController {
    private Stage stage;
    private Scene scene;
    private boolean isPrimaryStage;
    private StageStyle stageStyle;
    private double width;
    private double height;
    private boolean fullScreen;
    private boolean resizable;
    private String title;

    public SceneController(Stage stage, Scene scene) {
        this(stage, scene, false);
    }
    public SceneController(Stage stage, Scene scene, boolean primary) {
        this.stage = stage;
        this.scene = scene;
        this.isPrimaryStage = primary;
        stageStyle = StageStyle.DECORATED;
        width = 500;
        height = 400;
        fullScreen = true;
        resizable = true;
        title = "Tic Tac Toe";
    }

    public void setScene(Scene scene) { this.scene = scene; }
    public void setStageStyle(StageStyle stageStyle) { this.stageStyle = stageStyle; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
    public void setFullScreen(boolean fullScreen) { this.fullScreen = fullScreen; }
    public void setResizable(boolean resizable) { this.resizable = resizable; }
    public void setTitle(String title) { this.title = title; }

    public Scene getScene() { return scene; }
    public StageStyle getStageStyle() { return stageStyle; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public boolean getFullScreen() { return fullScreen; }
    public boolean getResizable() { return resizable; }
    public String getTitle() { return title; }

    public void initializeScene() {
        stage.setScene(scene);
    }

    public void showScene() {
        if (isPrimaryStage)
            stage.show();
        else
            stage.showAndWait();
    }
}
