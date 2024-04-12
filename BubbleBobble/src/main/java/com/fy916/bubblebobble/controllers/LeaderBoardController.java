package com.fy916.bubblebobble.controllers;

import com.fy916.bubblebobble.controllers.renderer.ControllerFileReader;
import com.fy916.bubblebobble.utilities.GameScores;
import com.fy916.bubblebobble.controllers.renderer.LeaderBoardImageLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * This class is extended from {@link Controller}.<br/>
 * This class utilize the {@link LeaderBoardImageLoader} to facilitate the rendering process.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * In charge of rendering the leader board from the main, is the controller of the FXML based scene.
 * @author fy916
 * @version 1.0
 */
public class LeaderBoardController extends Controller {
    /**
     * components contained in the FXML
     * @author fy916
     */
    @FXML
    private Label no1;
    @FXML
    private Label no2;
    @FXML
    private Label no3;
    @FXML
    private Label no4;
    @FXML
    private Label no5;
    @FXML
    private Label no6;
    @FXML
    private Label no7;
    @FXML
    private Label no8;
    @FXML
    private Label no9;
    @FXML
    private Label no10;

    @FXML
    private ImageView Image_background;
    @FXML
    private TextArea score_content_left;
    @FXML
    private TextArea score_content_right;
    @FXML
    private ImageView back_button;

    /**
     * FXML method jumps to the main page
     * @exception IOException may throw {@link IOException} since it fetches data from external files
     * @author fy916
     */
    @FXML
    void back_to_main(MouseEvent event) throws IOException {
        render_main();
    }

    /**
     * FXML method when the user focuses on the back button
     * @author fy916
     */
    @FXML
    void focus_back_button(MouseEvent event) {
        LeaderBoardImageLoader.renderLBBackground(Image_background, back_button, true);
    }

    /**
     * FXML method when the user focuses on the page instead of the button
     * @author fy916
     */
    @FXML
    void focus_page(MouseEvent event) {
        LeaderBoardImageLoader.renderLBBackground(Image_background, back_button, false);
    }

    /**
     * Updates the leader board names and scores from the static class {@link GameScores}
     * @author fy916
     */
    public void updateLeaderBoard() {
        LeaderBoardImageLoader.renderLBBackground(Image_background, back_button, false);    //render the leader board background
        ControllerFileReader.loadCSS(score_content_left,"LeaderBoardTextCSS" );     // load the css file for the style of  the leaderboard
        ControllerFileReader.loadCSS(score_content_right,"LeaderBoardTextCSS" );
        //if the leader board is less than 10 people, hide the missing places' Prompts like"1# 2#.."
        int length = GameScores.getScoreBoardName().size();
        if (length <= 0) no1.setOpacity(0);
        if (length <= 1) no2.setOpacity(0);
        if (length <= 2) no3.setOpacity(0);
        if (length <= 3) no4.setOpacity(0);
        if (length <= 4) no5.setOpacity(0);
        if (length <= 5) no6.setOpacity(0);
        if (length <= 6) no7.setOpacity(0);
        if (length <= 7) no8.setOpacity(0);
        if (length <= 8) no9.setOpacity(0);
        if (length <= 9) no10.setOpacity(0);

        if (length >= 10) {
            length = 10;
        }
        String tempString = "";
        String tempString2 = "";

        //render only the left side of the leader board
        if (length <= 5) {
            for (int i = 0; i < length; i++) {
                tempString = tempString + GameScores.getScoreBoardName().get(i) + "\n";
                tempString = tempString + GameScores.getScoreBoardScore().get(i) + "\n\n";
            }
            score_content_left.appendText(tempString);
        } else {        //render both sides of the leader board
            for (int i = 0; i < 5; i++) {
                tempString = tempString + GameScores.getScoreBoardName().get(i) + "\n";
                tempString = tempString + GameScores.getScoreBoardScore().get(i) + "\n\n";
            }
            for (int i = 5; i < length; i++) {
                tempString2 = tempString2 + GameScores.getScoreBoardName().get(i) + "\n";
                tempString2 = tempString2 + GameScores.getScoreBoardScore().get(i) + "\n\n";
            }
            score_content_left.appendText(tempString);
            score_content_right.appendText(tempString2);
        }
    }
}
