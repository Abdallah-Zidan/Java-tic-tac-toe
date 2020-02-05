/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Scene Controller that controls the behaviour of the scene
 * @author Tarek
 */
public class SceneController {
    private Stage stage;
    private Scene scene;
    private boolean isPrimaryStage;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Create Scene Controller given the stage to work on
     * @param stage the stage to work on
     */
    public SceneController(Stage stage) {
        this(stage, null);
    }

    /**
     * Create Scene Controller given the stage to work on and the scene
     * @param stage the stage to work on
     * @param scene the scene to work on
     */
    public SceneController(Stage stage, Scene scene) {
        this(stage, scene, false);
    }

    /**
     * Create Scene Controller given the stage to work on, the scene, and the primary flag
     * @param stage the stage to work on
     * @param scene the scene to work on
     * @param primary flag indicates whether it is the primary stage or not
     */
    public SceneController(Stage stage, Scene scene, boolean primary) {
        this.stage = stage;
        this.scene = scene;
        this.isPrimaryStage = primary;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Set stage
     * @param stage the stage to be set
     */
    public void setStage(Stage stage) { this.stage = stage; }

    /**
     * Set scene
     * @param scene the scene to be set
     */
    public void setScene(Scene scene) { this.scene = scene; }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Get stage
     * @return returns the stage
     */
    public Stage getStage() { return stage; }

    /**
     * Get scene
     * @return returns the scene
     */
    public Scene getScene() { return scene; }
    // </editor-fold>

    /**
     * Initialize the stage with the given scene
     */
    public void initializeScene() {
        stage.setScene(scene);
    }

    /**
     * Show the given scene
     */
    public void showScene() {
        if (isPrimaryStage)
            stage.show();
        else
            stage.showAndWait();
    }
}
