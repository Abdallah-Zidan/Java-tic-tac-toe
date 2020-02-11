/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Game Controller that controls the behaviour of the game
 * @author Tarek
 */
public class GameController {
    private StageController parentStageController;
    private StageController childStageController;
    private Scene parentScene;
    private Scene childScene;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Create Game Controller given the primary stage to work on
     * @param primaryStage the primary stage to work on
     */
    public GameController(Stage primaryStage) {
        parentStageController = new StageController(primaryStage, null, true);
        parentScene = null;
        childScene = null;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Set parent working scene
     * @param scene the scene to be set
     */
    public void setParentScene(Scene scene) { this.parentScene = scene; }

    /**
     * Set child scene to work
     * @param scene the scene to be set
     */
    public void setChildScene(Scene scene) { this.childScene = scene; }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Get parent scene
     * @return returns the parent working scene
     */
    public Scene getParentScene() { return parentScene; }

    /**
     * Get child scene
     * @return returns the child scene to work
     */
    public Scene getChildScene() { return childScene; }
    // </editor-fold>

    /**
     * Initialize the game by setting up the stage and the scene
     */
    public void initializeGame() {
        parentStageController.setScene(parentScene);
        parentStageController.initializeStage();
        parentStageController.initializeScene();
    }

    /**
     * Initialize the parent scene
     */
    public void initializeScene() {
        parentStageController.setScene(parentScene);
        parentStageController.initializeScene();
    }

    /**
     * Show the parent scene
     */
    public void showScene() {
        parentStageController.showScene();
    }

    /**
     * Initialize the child stage
     * @param parentStage the parent stage to attach to
     */
    public void initializeChildStage(Stage parentStage) {
        childStageController = new StageController(null, parentStage);
        childStageController.setScene(childScene);
        childStageController.initializeStage();
        childStageController.initializeScene();
    }

    /**
     * Show the child stage
     */
    public void showChildStage() {
        childStageController.showScene();
    }
}
