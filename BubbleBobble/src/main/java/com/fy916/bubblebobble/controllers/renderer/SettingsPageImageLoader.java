package com.fy916.bubblebobble.controllers.renderer;

import javafx.scene.image.ImageView;

/**
 * The helper of the {@link com.fy916.bubblebobble.controllers.SettingsController} to facilitate the rendering process of the settings page.<br/>
 * Realizes Single Responsibility Principle and FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class SettingsPageImageLoader {

    /**
     * Render the difficulties images that to be selected by the player
     * @param imageplaceholder the {@link ImageView} Image placeholder of difficulties image to be rendered
     * @param difficulty the difficulty {@link javafx.scene.image.Image} that fills the image placeholder
     * @author fy916
     */
    public static void renderSettingsPageDifficulty(ImageView imageplaceholder, int difficulty) {
        imageplaceholder.setImage(PageImageLoader.getImg_difficulty().get(difficulty));
    }

    /**
     * Render the background of the page
     * @param Image_background the background to be rendered
     * @author fy916
     */
    public static void renderSettingsPageBackground(ImageView Image_background) {
        Image_background.setImage(PageImageLoader.getImg_setting_background());
    }

    /**
     * Render the different color selections of the bubble of the game
     * @param imageplaceholder the {@link ImageView} Image placeholder of bubble colors to be rendered
     * @param color the color selection of the image placeholder
     * @author fy916
     */
    public static void renderSettingsPageColor(ImageView imageplaceholder, int color) {
        imageplaceholder.setImage(PageImageLoader.getImg_bubble().get(color));
    }

    /**
     * Render the available selection of the game backgrounds of the game
     * @param imageplaceholder the {@link ImageView} Image placeholder of the image previews that can be selected to be the background of the game
     * @param background the selection ID of the background
     * @author fy916
     */
    public static void renderSettingsPageBackgroundpreview(ImageView imageplaceholder, int background) {
        imageplaceholder.setImage(PageImageLoader.getImg_background_preview().get(background));
    }

    /**
     * Render green check that indicates the user selection on the screen
     * @param check_difficulty the {@link ImageView} Image placeholder of the check that indicates the selection of the difficulty
     * @param check_color the {@link ImageView} Image placeholder of the check that indicates the selection of the color
     * @param check_background the {@link ImageView} Image placeholder of the check that indicates the selection of the background of the game
     * @param difficulty the difficulty ID of the selection
     * @param color the color ID of the selection
     * @param background the background ID of the selection
     * @author fy916
     */
    public static void renderSettingsPageCheck(ImageView check_difficulty, ImageView check_color, ImageView check_background, ImageView difficulty, ImageView color, ImageView background) {
        //set the difficulty selections
        check_difficulty.setImage(PageImageLoader.getImg_check());
        check_difficulty.setLayoutX(difficulty.getLayoutX() + difficulty.getFitWidth() / 2 - check_difficulty.getFitHeight() / 2 - 10);
        check_difficulty.setLayoutY(difficulty.getLayoutY() + difficulty.getFitHeight() - 10);
        //set the color selection
        check_color.setImage(PageImageLoader.getImg_check());
        check_color.setLayoutX(color.getLayoutX() + color.getFitWidth() / 2 - check_color.getFitHeight() / 2 - 5);
        check_color.setLayoutY(color.getLayoutY() + color.getFitHeight() - 10);
        //set the background selection
        check_background.setImage(PageImageLoader.getImg_check());
        check_background.setLayoutX(background.getLayoutX() + background.getFitWidth() / 2 - check_background.getFitHeight() / 2 - 10);
        check_background.setLayoutY(background.getLayoutY() + background.getFitHeight() - 15);
    }
}
