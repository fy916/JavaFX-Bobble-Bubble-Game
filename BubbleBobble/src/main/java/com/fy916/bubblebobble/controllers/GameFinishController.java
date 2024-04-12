package com.fy916.bubblebobble.controllers;

import com.fy916.bubblebobble.controllers.renderer.ControllerFileReader;
import com.fy916.bubblebobble.utilities.GameScores;
import com.fy916.bubblebobble.controllers.renderer.SaveScoreImageLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * This class is extended from {@link Controller}.<br/>
 * This class utilize the {@link SaveScoreImageLoader} to facilitate the rendering process.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * In charge of rendering the page when game is finished, is the controller of the FXML based scene.
 * @author fy916
 * @version 1.0
 */
public class GameFinishController extends Controller {
    /**
     * The type of the page, when 0 represents gameover; 1 represents level passed; 2 represents victory
     * @author fy916
     */
    private int type;

    /**
     * The place of the player in the leader board
     * @author fy916
     */
    private int place;

    /**
     * components contained in the FXML
     * @author fy916
     */
    @FXML
    private ImageView Image_background;
    @FXML
    private ImageView page;
    @FXML
    private Label no3;
    @FXML
    private Label no2;
    @FXML
    private Label no4;
    @FXML
    private TextArea score_board;
    @FXML
    private ImageView save_score_button;
    @FXML
    private ImageView next_level_button;

    /**
     * FXML method when the user focuses on the back button
     * @author fy916
     */
    @FXML
    void focus_back(MouseEvent event) {
        SaveScoreImageLoader.renderGameFinishPageButton(save_score_button, next_level_button, true, false);
    }

    /**
     * FXML method when the user focuses on the "continue to the next level" button
     * @author fy916
     */
    @FXML
    void focus_next_level(MouseEvent event) {
        SaveScoreImageLoader.renderGameFinishPageButton(save_score_button, next_level_button, false, true);
    }

    /**
     * FXML method when the user focuses on the page instead of the button
     * @author fy916
     */
    @FXML
    void focus_page(MouseEvent event) {
        SaveScoreImageLoader.renderGameFinishPageButton(save_score_button, next_level_button, false, false);
    }

    /**
     * Render the page that asks the player to enter names and save the games
     * @exception IOException May throw {@link IOException} since the method reads from the external files for the FXML files
     * @author fy916
     */
    @FXML
    void save_score(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = ControllerFileReader.loadFXML(loader, "save_score");   //load the external files
        SaveScoreController saveScoreController = loader.getController();
        saveScoreController.setStage(mStage);
        saveScoreController.render_page();
        saveScoreController.LBplace(place); //save the user score
        saveScoreController.addTextLimiter(20); //set the text limit of the save score page
        mStage.setTitle("BubbleBobble Game");
        Scene savescene = new Scene(root);  //switch to the scene
        mStage.setScene(savescene);
        mStage.show();
    }

    /**
     * Render the game of the next level
     * @exception IOException May throw {@link IOException} since the method reads from the external files for the FXML files
     * @author fy916
     */
    @FXML
    void next_level(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = ControllerFileReader.loadFXML(loader, "Game");  //load the external files
        GameController game_controller = loader.getController();
        game_controller.setStage(mStage);
        mStage.setTitle("BubbleBobble Game");
        Scene gamescene = new Scene(root); //switch to the scene
        mStage.setScene(gamescene);
        game_controller.renderGame(gamescene);
        mStage.show();
        root.requestFocus();
    }

    /**
     * Render the default display outlook of the page itself
     * @author fy916
     */
    void renderdefault() {
        SaveScoreImageLoader.renderGameFinishPageBackground(Image_background, page, type);
        ControllerFileReader.loadCSS(score_board, "GameFinishCSS"); // load the css files
        int myscore = GameScores.getScoreCounter();
        SaveScoreImageLoader.renderGameFinishPageButton(save_score_button, next_level_button, false, false);
        this.place = GameScores.save_score("YOU", GameScores.getScoreCounter());
        //compare the user scores to the leader board, if the user is not the top4, make the user score display without the "4#" mark
        //if the total leader board is less than 3 people
        if (GameScores.getScoreBoardScore().size() <= 3) {
            for (int i = 0; i < GameScores.getScoreBoardScore().size(); i++) {
                score_board.appendText(GameScores.getScoreBoardName().get(i) + "\n");
                score_board.appendText(GameScores.getScoreBoardScore().get(i) + "\n\n");
            }
        } else if (this.place > 3) { // if the user is not within top4
            for (int i = 0; i < 3; i++) {
                score_board.appendText(GameScores.getScoreBoardName().get(i) + "\n");
                score_board.appendText(GameScores.getScoreBoardScore().get(i) + "\n\n");
            }
            no4.setOpacity(0);
            score_board.appendText("YOU" + "\n");
            score_board.appendText(myscore + "\n\n");
        } else {
            for (int i = 0; i < 4; i++) { //if the user is within the top 4
                score_board.appendText(GameScores.getScoreBoardName().get(i) + "\n");
                score_board.appendText(GameScores.getScoreBoardScore().get(i) + "\n\n");
            }
        }
    }


    /**
     * Set the page type since when the user loses or passed the whole levels, the user cannot continue anymore
     * @param inp The type of the page, when 0 represents gameover; 1 represents level passed; 2 represents victory
     * @author fy916
     */
    public void setType(int inp) {
        type = inp;
        //if the user cannot continue to play the next level because of passing all levels or lose the game, disable the next level button
        if (inp == 0 || inp == 2) {
            next_level_button.setDisable(true);
            next_level_button.setOpacity(0);
        }
    }
}
