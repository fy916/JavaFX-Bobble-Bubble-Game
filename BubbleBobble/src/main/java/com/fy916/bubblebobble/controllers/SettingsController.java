package com.fy916.bubblebobble.controllers;

import com.fy916.bubblebobble.controllers.renderer.MainPageImageLoader;
import com.fy916.bubblebobble.utilities.GameStatus;
import com.fy916.bubblebobble.controllers.renderer.PageImageLoaderUtilities;
import com.fy916.bubblebobble.controllers.renderer.SettingsPageImageLoader;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * This class is extended from {@link Controller}.<br/>
 * This class utilize the {@link SettingsPageImageLoader} to facilitate the rendering process.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * In charge of rendering the settings page, is the controller of the FXML based scene.
 * @author fy916
 * @version 1.0
 */
public class SettingsController extends Controller {
    /**
     * the difficulty of the game
     * @author fy916
     */
    private ImageView difficulty;

    /**
     * the color of the bubble
     * @author fy916
     */
    private ImageView color;

    /**
     * the color of the background
     * @author fy916
     */
    private ImageView background;

    /**
     * the last focused button
     * @author fy916
     */
    private ImageView lastFocused;

    /**
     * components contained in the FXML
     * @author fy916
     */
    @FXML
    private ImageView difficulty_0;
    @FXML
    private ImageView difficulty_1;
    @FXML
    private ImageView difficulty_2;
    @FXML
    private ImageView difficulty_3;

    @FXML
    private ImageView color_0;
    @FXML
    private ImageView color_1;
    @FXML
    private ImageView color_2;
    @FXML
    private ImageView color_3;
    @FXML
    private ImageView color_4;
    @FXML
    private ImageView color_5;
    @FXML
    private ImageView color_6;
    @FXML
    private ImageView color_7;

    @FXML
    private ImageView bg_0;
    @FXML
    private ImageView bg_1;
    @FXML
    private ImageView bg_2;
    @FXML
    private ImageView bg_3;
    @FXML
    private ImageView bg_4;
    @FXML
    private ImageView bg_5;
    @FXML
    private ImageView bg_6;
    @FXML
    private ImageView bg_7;
    @FXML
    private ImageView check_difficulty;
    @FXML
    private ImageView check_color;
    @FXML
    private ImageView check_background;
    @FXML
    private ImageView back_button;
    @FXML
    private ImageView Image_background;

    /**
     * Load the user last chosen settings and then render the default settings pages
     * @author fy916
     */
    public void renderdefault() {
        SettingsPageImageLoader.renderSettingsPageBackground(Image_background);
        SettingsPageImageLoader.renderSettingsPageDifficulty(difficulty_0, 0);
        SettingsPageImageLoader.renderSettingsPageDifficulty(difficulty_1, 1);
        SettingsPageImageLoader.renderSettingsPageDifficulty(difficulty_2, 2);
        SettingsPageImageLoader.renderSettingsPageDifficulty(difficulty_3, 3);
        PageImageLoaderUtilities.renderBackButton(back_button, false);
        SettingsPageImageLoader.renderSettingsPageColor(color_0, 0);
        SettingsPageImageLoader.renderSettingsPageColor(color_1, 1);
        SettingsPageImageLoader.renderSettingsPageColor(color_2, 2);
        SettingsPageImageLoader.renderSettingsPageColor(color_3, 3);
        SettingsPageImageLoader.renderSettingsPageColor(color_4, 4);
        SettingsPageImageLoader.renderSettingsPageColor(color_5, 5);
        SettingsPageImageLoader.renderSettingsPageColor(color_6, 6);
        SettingsPageImageLoader.renderSettingsPageColor(color_7, 7);
        SettingsPageImageLoader.renderSettingsPageBackgroundpreview(bg_0, 0);
        SettingsPageImageLoader.renderSettingsPageBackgroundpreview(bg_1, 1);
        SettingsPageImageLoader.renderSettingsPageBackgroundpreview(bg_2, 2);
        SettingsPageImageLoader.renderSettingsPageBackgroundpreview(bg_3, 3);
        SettingsPageImageLoader.renderSettingsPageBackgroundpreview(bg_4, 4);
        SettingsPageImageLoader.renderSettingsPageBackgroundpreview(bg_5, 5);
        SettingsPageImageLoader.renderSettingsPageBackgroundpreview(bg_6, 6);
        SettingsPageImageLoader.renderSettingsPageBackgroundpreview(bg_7, 7);
        syncWithMain();
        updatecheck();
    }

    /**
     * Sync with the user saved settings, read data from the static {@link GameStatus}
     * @author fy916
     */
    public void syncWithMain() {
        if (GameStatus.getDifficulty() == 0) difficulty = difficulty_0;
        if (GameStatus.getDifficulty() == 1) difficulty = difficulty_1;
        if (GameStatus.getDifficulty() == 2) difficulty = difficulty_2;
        if (GameStatus.getDifficulty() == 3) difficulty = difficulty_3;

        if (GameStatus.getBubbleColor() == 0) color = color_0;
        if (GameStatus.getBubbleColor() == 1) color = color_1;
        if (GameStatus.getBubbleColor() == 2) color = color_2;
        if (GameStatus.getBubbleColor() == 3) color = color_3;
        if (GameStatus.getBubbleColor() == 4) color = color_4;
        if (GameStatus.getBubbleColor() == 5) color = color_5;
        if (GameStatus.getBubbleColor() == 6) color = color_6;
        if (GameStatus.getBubbleColor() == 7) color = color_7;

        if (GameStatus.getBackgroundChoice() == 0) background = bg_0;
        if (GameStatus.getBackgroundChoice() == 1) background = bg_1;
        if (GameStatus.getBackgroundChoice() == 2) background = bg_2;
        if (GameStatus.getBackgroundChoice() == 3) background = bg_3;
        if (GameStatus.getBackgroundChoice() == 4) background = bg_4;
        if (GameStatus.getBackgroundChoice() == 5) background = bg_5;
        if (GameStatus.getBackgroundChoice() == 6) background = bg_6;
        if (GameStatus.getBackgroundChoice() == 7) background = bg_7;
    }

    /**
     * Update the check that indicates one selection is selected
     * @author fy916
     */
    public void updatecheck() {
        SettingsPageImageLoader.renderSettingsPageCheck(check_difficulty, check_color, check_background, difficulty, color, background);
    }

    /**
     * FXML method when the user clicks the back to main button and render main page
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
    void focus_back(MouseEvent event) {
        PageImageLoaderUtilities.renderBackButton(back_button, true);
        lastFocused = back_button;
    }

    /**
     * FXML method when the user focuses on the background photo 0
     * @author fy916
     */
    @FXML
    void focus_bg0(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(bg_0);
        lastFocused = bg_0;
    }

    /**
     * FXML method when the user focuses on the background photo 1
     * @author fy916
     */
    @FXML
    void focus_bg1(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(bg_1);
        lastFocused = bg_1;
    }

    /**
     * FXML method when the user focuses on the background photo 2
     * @author fy916
     */
    @FXML
    void focus_bg2(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(bg_2);
        lastFocused = bg_2;
    }

    /**
     * FXML method when the user focuses on the background photo 3
     * @author fy916
     */
    @FXML
    void focus_bg3(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(bg_3);
        lastFocused = bg_3;
    }

    /**
     * FXML method when the user focuses on the background photo 4
     * @author fy916
     */
    @FXML
    void focus_bg4(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(bg_4);
        lastFocused = bg_4;
    }

    /**
     * FXML method when the user focuses on the background photo 5
     * @author fy916
     */
    @FXML
    void focus_bg5(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(bg_5);
        lastFocused = bg_5;
    }

    /**
     * FXML method when the user focuses on the background photo 6
     * @author fy916
     */
    @FXML
    void focus_bg6(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(bg_6);
        lastFocused = bg_6;
    }

    /**
     * FXML method when the user focuses on the background photo 7
     * @author fy916
     */
    @FXML
    void focus_bg7(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(bg_7);
        lastFocused = bg_7;
    }

    /**
     * FXML method when the user focuses on the color photo 0
     * @author fy916
     */
    @FXML
    void focus_color0(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(color_0);
        lastFocused = color_0;
    }

    /**
     * FXML method when the user focuses on the color photo 1
     * @author fy916
     */
    @FXML
    void focus_color1(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(color_1);
        lastFocused = color_1;
    }

    /**
     * FXML method when the user focuses on the color photo 2
     * @author fy916
     */
    @FXML
    void focus_color2(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(color_2);
        lastFocused = color_2;
    }

    /**
     * FXML method when the user focuses on the color photo 3
     * @author fy916
     */
    @FXML
    void focus_color3(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(color_3);
        lastFocused = color_3;
    }

    /**
     * FXML method when the user focuses on the color photo 4
     * @author fy916
     */
    @FXML
    void focus_color4(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(color_4);
        lastFocused = color_4;
    }

    /**
     * FXML method when the user focuses on the color photo 5
     * @author fy916
     */
    @FXML
    void focus_color5(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(color_5);
        lastFocused = color_5;
    }

    /**
     * FXML method when the user focuses on the color photo 6
     * @author fy916
     */
    @FXML
    void focus_color6(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(color_6);
        lastFocused = color_6;
    }

    /**
     * FXML method when the user focuses on the color photo 7
     * @author fy916
     */
    @FXML
    void focus_color7(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(color_7);
        lastFocused = color_7;
    }

    /**
     * FXML method when the user focuses on the difficulty easy
     * @author fy916
     */
    @FXML
    void focus_easy(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(difficulty_0);
        lastFocused = difficulty_0;
    }

    /**
     * FXML method when the user focuses on the difficulty normal
     * @author fy916
     */
    @FXML
    void focus_normal(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(difficulty_1);
        lastFocused = difficulty_1;
    }

    /**
     * FXML method when the user focuses on the difficulty hard
     * @author fy916
     */
    @FXML
    void focus_hard(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(difficulty_2);
        lastFocused = difficulty_2;
    }

    /**
     * FXML method when the user focuses on the difficulty nightmare
     * @author fy916
     */
    @FXML
    void focus_nightmare(MouseEvent event) {
        PageImageLoaderUtilities.setButtonFocused(difficulty_3);
        lastFocused = difficulty_3;
    }

    @FXML
    void focus_main(MouseEvent event) {
        PageImageLoaderUtilities.setButtonReleased(lastFocused);
        PageImageLoaderUtilities.renderBackButton(back_button, false);
    }

    /**
     * FXML method when the user loses focus on the background photo 0
     * @author fy916
     */
    @FXML
    void select_bg_0(MouseEvent event) {
        background = bg_0;
        updatecheck();
        GameStatus.setBackgroundChoice(0);
    }

    /**
     * FXML method when the user loses focus on the background photo 1
     * @author fy916
     */
    @FXML
    void select_bg_1(MouseEvent event) {
        background = bg_1;
        updatecheck();
        GameStatus.setBackgroundChoice(1);
    }

    /**
     * FXML method when the user loses focus on the background photo 2
     * @author fy916
     */
    @FXML
    void select_bg_2(MouseEvent event) {
        background = bg_2;
        updatecheck();
        GameStatus.setBackgroundChoice(2);
    }

    /**
     * FXML method when the user loses focus on the background photo 3
     * @author fy916
     */
    @FXML
    void select_bg_3(MouseEvent event) {
        background = bg_3;
        updatecheck();
        GameStatus.setBackgroundChoice(3);
    }

    /**
     * FXML method when the user loses focus on the background photo 4
     * @author fy916
     */
    @FXML
    void select_bg_4(MouseEvent event) {
        background = bg_4;
        updatecheck();
        GameStatus.setBackgroundChoice(4);
    }

    /**
     * FXML method when the user loses focus on the background photo 5
     * @author fy916
     */
    @FXML
    void select_bg_5(MouseEvent event) {
        background = bg_5;
        updatecheck();
        GameStatus.setBackgroundChoice(5);
    }

    /**
     * FXML method when the user loses focus on the background photo 6
     * @author fy916
     */
    @FXML
    void select_bg_6(MouseEvent event) {
        background = bg_6;
        updatecheck();
        GameStatus.setBackgroundChoice(6);
    }

    /**
     * FXML method when the user loses focus on the background photo 7
     * @author fy916
     */
    @FXML
    void select_bg_7(MouseEvent event) {
        background = bg_7;
        updatecheck();
        GameStatus.setBackgroundChoice(7);
    }

    /**
     * FXML method when the user loses focuse on the color photo 0
     * @author fy916
     */
    @FXML
    void select_color_0(MouseEvent event) {
        color = color_0;
        updatecheck();
        GameStatus.setBubbleColor(0);
    }

    /**
     * FXML method when the user loses focuse on the color photo 1
     * @author fy916
     */
    @FXML
    void select_color_1(MouseEvent event) {
        color = color_1;
        updatecheck();
        GameStatus.setBubbleColor(1);
    }

    /**
     * FXML method when the user loses focuse on the color photo 2
     * @author fy916
     */
    @FXML
    void select_color_2(MouseEvent event) {
        color = color_2;
        updatecheck();
        GameStatus.setBubbleColor(2);
    }

    /**
     * FXML method when the user loses focuse on the color photo 3
     * @author fy916
     */
    @FXML
    void select_color_3(MouseEvent event) {
        color = color_3;
        updatecheck();
        GameStatus.setBubbleColor(3);
    }

    /**
     * FXML method when the user loses focuse on the color photo 4
     * @author fy916
     */
    @FXML
    void select_color_4(MouseEvent event) {
        color = color_4;
        updatecheck();
        GameStatus.setBubbleColor(4);
    }

    /**
     * FXML method when the user loses focuse on the color photo 5
     * @author fy916
     */
    @FXML
    void select_color_5(MouseEvent event) {
        color = color_5;
        updatecheck();
        GameStatus.setBubbleColor(5);
    }

    /**
     * FXML method when the user loses focuse on the color photo 6
     * @author fy916
     */
    @FXML
    void select_color_6(MouseEvent event) {
        color = color_6;
        updatecheck();
        GameStatus.setBubbleColor(6);
    }

    /**
     * FXML method when the user loses focuse on the color photo 7
     * @author fy916
     */
    @FXML
    void select_color_7(MouseEvent event) {
        color = color_7;
        updatecheck();
        GameStatus.setBubbleColor(7);
    }

    /**
     * FXML method when the user loses focus on the difficulty easy
     * @author fy916
     */
    @FXML
    void select_difficulty_0(MouseEvent event) {
        difficulty = difficulty_0;
        updatecheck();
        GameStatus.setDifficulty(0);
    }

    /**
     * FXML method when the user loses focus on the difficulty normal
     * @author fy916
     */
    @FXML
    void select_difficulty_1(MouseEvent event) {
        difficulty = difficulty_1;
        updatecheck();
        GameStatus.setDifficulty(1);
    }

    /**
     * FXML method when the user loses focus on the difficulty hard
     * @author fy916
     */
    @FXML
    void select_difficulty_2(MouseEvent event) {
        difficulty = difficulty_2;
        updatecheck();
        GameStatus.setDifficulty(2);
    }

    /**
     * FXML method when the user loses focus on the difficulty nightmare
     * @author fy916
     */
    @FXML
    void select_difficulty_3(MouseEvent event) {
        difficulty = difficulty_3;
        updatecheck();
        GameStatus.setDifficulty(3);
    }


}
