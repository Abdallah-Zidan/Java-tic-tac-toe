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
 * Stage Controller that controls the behaviour of the stage
 * @author Tarek
 */
public class StageController {
    private SceneController sceneController;
    private Stage stage;
    private Stage parentStage;
    private StageStyle stageStyle;
    private double width;
    private double height;
    private boolean fullScreen;
    private boolean resizable;
    private String title;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Default constructor
     */
    public StageController() {
        this(null, null);
    }

    /**
     * Create Stage Controller given the stage to work on
     * @param stage the stage to work on
     */
    public StageController(Stage stage) {
        this(stage, null);
    }

    /**
     * Create Stage Controller given the stage to work on and it's parent stage
     * @param stage the stage to work on
     * @param parentStage the parent stage to attach to
     */
    public StageController(Stage stage, Stage parentStage) {
        this(stage, parentStage, false);
    }

    /**
     * Create Stage Controller given the stage to work on, it's parent stage, and the primary flag
     * @param stage the stage to work on
     * @param parentStage the parent stage to attach to
     * @param primary flag indicates whether it is the primary stage or not
     */
    public StageController(Stage stage, Stage parentStage, boolean primary) {
        sceneController = new SceneController(stage, null, primary);
        this.stage = stage;
        this.parentStage = parentStage;
        stageStyle = StageStyle.DECORATED;
//        width = 500;
//        height = 400;
//        fullScreen = false;
        resizable = false;
        title = "Tic Tac Toe";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Set stage
     * @param stage the stage to be set
     */
    public void setStage(Stage stage) { this.stage = stage; sceneController.setStage(stage); }

    /**
     * Set parent stage
     * @param stage the parent stage to attach to
     */
    public void setParentStage(Stage stage) { this.parentStage = stage; }

    /**
     * Set stage style
     * @param stageStyle the style of the stage
     */
    public void setStageStyle(StageStyle stageStyle) { this.stageStyle = stageStyle; }

    /**
     * Set stage width
     * @param width the width of the stage
     */
    public void setWidth(double width) { this.width = width; }

    /**
     * Set stage height
     * @param height the height of the stage
     */
    public void setHeight(double height) { this.height = height; }

    /**
     * Set full screen flag
     * @param fullScreen the full screen flag for the stage
     */
    public void setFullScreen(boolean fullScreen) { this.fullScreen = fullScreen; }

    /**
     * Set resize flag
     * @param resizable the resize flag for the stage
     */
    public void setResizable(boolean resizable) { this.resizable = resizable; }

    /**
     * Set stage title
     * @param title the title of the stage
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Set scene
     * @param scene the scene to be set
     */
    public void setScene(Scene scene) { sceneController.setScene(scene); }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Get scene controller of the stage
     * @return returns the scene controller
     */
    public SceneController getSceneController() { return sceneController; }

    /**
     * Get stage
     * @return returns the stage
     */
    public Stage getStage() { return stage; }

    /**
     * Get parent stage
     * @return returns the parent stage
     */
    public Stage getParentStage() { return parentStage; }

    /**
     * Get stage style
     * @return returns the style of the stage
     */
    public StageStyle getStageStyle() { return stageStyle; }

    /**
     * Get stage width
     * @return returns the width of the stage
     */
    public double getWidth() { return width; }

    /**
     * Get stage height
     * @return returns the height of the stage
     */
    public double getHeight() { return height; }

    /**
     * Get full screen flag
     * @return returns the full screen flag for the stage
     */
    public boolean getFullScreen() { return fullScreen; }

    /**
     * Get resize flag
     * @return returns the resize flag for the stage
     */
    public boolean getResizable() { return resizable; }

    /**
     * Get stage title
     * @return returns the title of the stage
     */
    public String getTitle() { return title; }

    /**
     * Get scene
     * @return returns the scene
     */
    public Scene getScene() { return sceneController.getScene(); }
    // </editor-fold>

    /**
     * Initialize the stage by setting its properties
     */
    public void initializeStage() {
        if (stage == null) {
            setStage(new Stage());

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(parentStage);
        }

        stage.initStyle(stageStyle);

//        stage.setWidth(width);
//        stage.setHeight(height);
//        stage.setFullScreen(fullScreen);
        stage.setResizable(resizable);
        stage.setTitle(title);
    }

    /**
     * Initialize the scene
     */
    public void initializeScene() {
        sceneController.initializeScene();
    }

    /**
     * Show the given scene
     */
    public void showScene() {
        sceneController.showScene();
    }
}
