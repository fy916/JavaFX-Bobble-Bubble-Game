package com.fy916.bubblebobble.controllers;

import com.fy916.bubblebobble.controllers.renderer.ControllerFileReader;
import com.fy916.bubblebobble.utilities.FileReader;
import com.fy916.bubblebobble.utilities.GameStatus;
import com.fy916.bubblebobble.controllers.renderer.MainPageImageLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
/**
 * This class is extended from {@link Controller}.<br/>
 * This class utilize the {@link MainPageImageLoader} to facilitate the rendering process.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * In charge of rendering the main page, which is the entrance of the game, is the controller of the FXML based scene.
 * @author fy916
 * @version 1.0
 */
public class MainController extends Controller {
    /**
     * components contained in the FXML
     * @author fy916
     */
    @FXML
    private ImageView Image_background;
    @FXML
    private ImageView Tittle;
    @FXML
    private ImageView Start_game_button;
    @FXML
    private ImageView Quit_Game;
    @FXML
    private ImageView Controls;
    @FXML
    private ImageView LeaderBoard;
    @FXML
    private ImageView Game_settings;

    /**
     * FXML method that invokes the display of start of the game
     * @exception IOException may throw {@link IOException} since it fetches data from external files
     * @author fy916
     */
    @FXML
    void start_game(MouseEvent event) throws IOException {
        GameStatus.refreshLives();
        FXMLLoader loader = new FXMLLoader();
        Parent root = ControllerFileReader.loadFXML(loader, "Game");
        GameController game_controller = loader.getController();
        game_controller.setStage(mStage);
        mStage.setTitle("BubbleBobble Game");
        Scene gamescene = new Scene(root);
        mStage.setScene(gamescene);
        game_controller.renderGame(gamescene);
        mStage.show();
        root.requestFocus();
    }

    /**
     * FXML method that invokes the display of INFO page of the game
     * @author fy916
     */
    @FXML
    void controls(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = ControllerFileReader.loadFXML(loader, "Controls");
        InfoController infoController = loader.getController();
        infoController.setStage(mStage);
        infoController.renderdefault();
        mStage.setTitle("BubbleBobble Settings");
        Scene settingscene = new Scene(root);
        mStage.setScene(settingscene);
        mStage.show();
    }

    /**
     * FXML method that invokes the display of the settings page
     * @exception IOException may throw {@link IOException} since it fetches data from external files
     * @author fy916
     */
    @FXML
    void game_settings(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = ControllerFileReader.loadFXML(loader, "Settings");
        SettingsController settingsController = loader.getController();
        settingsController.setStage(mStage);
        settingsController.renderdefault();
        mStage.setTitle("BubbleBobble Settings");
        Scene settingscene = new Scene(root);
        mStage.setScene(settingscene);
        mStage.show();
    }

    /**
     * FXML method that invokes the display of the leader board page
     * @exception IOException may throw {@link IOException} since it fetches data from external files
     * @author fy916
     */
    @FXML
    void leader_board(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = ControllerFileReader.loadFXML(loader, "LeaderBoard");
        LeaderBoardController leaderboardController = loader.getController();
        leaderboardController.setStage(mStage);
        leaderboardController.updateLeaderBoard();
        mStage.setTitle("BubbleBobble Leader Board");
        Scene leaderBoardScene = new Scene(root);
        mStage.setScene(leaderBoardScene);
        mStage.show();
    }

    /**
     * FXML method that invokes the quit game action, the system will firstly save the settings and leaderboard infomation and then exit
     * @exception IOException may throw {@link IOException} since it fetches data from external files
     * @author fy916
     */
    @FXML
    void quit_Game(MouseEvent event) throws IOException {
        FileReader.saveData();
        System.exit(0);
    }

    /**
     * FXML method when the user focuses on the leader board page button
     * @author fy916
     */
    @FXML
    void focus_board(MouseEvent event) {
        render_page(4);
    }

    /**
     * FXML method when the user focuses on the INFO page button
     * @author fy916
     */
    @FXML
    void focus_controls(MouseEvent event) {
        render_page(3);
    }

    /**
     * FXML method when the user is not focusing on the buttons
     * @author fy916
     */
    @FXML
    void focus_main(MouseEvent event) {
        render_page(0);
    }

    /**
     * FXML method when the user focuses on the quit game button
     * @author fy916
     */
    @FXML
    void focus_quit(MouseEvent event) {
        render_page(2);
    }

    /**
     * FXML method when the user focuses on the settings button
     * @author fy916
     */
    @FXML
    void focus_settings(MouseEvent event) {
        render_page(5);
    }

    /**
     * FXML method when the user focuses on the settings button
     * @author fy916
     */
    @FXML
    void focus_start_game(MouseEvent event) {
        render_page(1);
    }

    /**
     * Render the main page, both its backgrounds and its buttons
     * @param focus The user's focus on the button
     * @author fy916
     */
    public void render_page(int focus) {
        MainPageImageLoader.renderMainPage(Image_background, Tittle, Start_game_button, Quit_Game, Controls, LeaderBoard, Game_settings, GameStatus.getBackgroundChoice(), focus);
    }
}

