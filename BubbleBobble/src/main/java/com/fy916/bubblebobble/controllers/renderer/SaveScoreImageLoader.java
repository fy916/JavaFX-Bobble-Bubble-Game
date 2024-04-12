package com.fy916.bubblebobble.controllers.renderer;

import javafx.scene.image.ImageView;

import static com.fy916.bubblebobble.controllers.renderer.PageImageLoaderUtilities.RenderOuterBackground;

/**
 * The helper of the {@link com.fy916.bubblebobble.controllers.SaveScoreController} to facilitate the rendering process of the save score page.<br/>
 * Realizes Single Responsibility Principle and FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class SaveScoreImageLoader {

    /**
     * Render the background according to the status of the game
     * @param background the background to be rendered
     * @param page  the different outcome of the game finish page like You Lose!, You Win!, Level Passed!
     * @param type the int value when 0 represents gameover; 1 represents level passed; 2 represents victory
     * @author fy916
     */
    public static void renderGameFinishPageBackground(ImageView background, ImageView page, int type) {
        RenderOuterBackground(background);
        if (type == 0) {  // if the game is lose
            page.setImage(PageImageLoader.getImg_game_over());
        } else if (type == 1) { //if this level is passed
            page.setImage(PageImageLoader.getImg_next_level());
        } else { //if passed all levels
            page.setImage(PageImageLoader.getImg_game_passed());
        }
    }

    /**
     * Render of the the buttons in the game finish scene
     * @param back_button the {@link javafx.scene.image.ImageView} type of button of "back to main" button
     * @param next_level the  {@link javafx.scene.image.ImageView} type of button of "next level" button
     * @param focus_back a Boolean type that indicates whether the back button is focused by the user
     * @param focus_next a Boolean type that indicates whether the continue button is focused by the user
     * @author fy916
     */
    public static void renderGameFinishPageButton(ImageView back_button, ImageView next_level, boolean focus_back, boolean focus_next) {
        PageImageLoaderUtilities.renderBackButton(back_button, focus_back);
        if (focus_next) {  //if the user is focusing on the next button
            next_level.setImage(PageImageLoader.getImg_continue_selected());
        } else { // if the user releases the button
            next_level.setImage(PageImageLoader.getImg_continue());
        }
    }

    /**
     * Render the game save page background according to the choice of the background image of the user
     * @param background the background to be rendered
     * @param foreground  the image placeholder for the game save page
     * @author fy916
     */
    public static void renderGameSavePage(ImageView background, ImageView foreground) {
        RenderOuterBackground(background);
        foreground.setImage(PageImageLoader.getImg_save_score());
    }

    /**
     * Render the game save page button
     * @param back_button back_button  {@link javafx.scene.image.ImageView} placeholder is used to load images and serve as a back button of the page
     * @param focus_back If the user is focusing on the back button
     * @author fy916
     */
    public static void renderGameSavePageButton(ImageView back_button, boolean focus_back) {
        PageImageLoaderUtilities.renderBackButton(back_button, focus_back);
    }
}
