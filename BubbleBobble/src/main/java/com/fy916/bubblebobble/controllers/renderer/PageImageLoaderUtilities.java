package com.fy916.bubblebobble.controllers.renderer;

import com.fy916.bubblebobble.utilities.GameStatus;
import javafx.scene.image.ImageView;

/**
 * The ImageLoader facilitates the load of page images.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class PageImageLoaderUtilities {
    public static void renderBackButton(ImageView back_button, boolean focus_back) {
        if (!focus_back) { // if not focusing on the back button
            back_button.setImage(PageImageLoader.getImg_setting_back_button());
            setButtonReleased(back_button);
        } else {// if is focusing on the back button
            back_button.setImage(PageImageLoader.getImg_setting_back_button_selected());
            setButtonFocused(back_button);
        }
    }

    /**
     * Enlarge a button to 1.2x of its original size
     * @param imagePlaceholder the {@link javafx.scene.image.ImageView} placeholder that serves as a button that be enlarged
     * @author fy916
     */
    public static void setButtonFocused(ImageView imagePlaceholder) {
        imagePlaceholder.setScaleX(1.2);
        imagePlaceholder.setScaleY(1.2);
    }

    /**
     * Reset a button to its original size
     * @param imagePlaceholder imagePlaceholder the {@link javafx.scene.image.ImageView} placeholder that serves as a button that to be reset
     * @author fy916
     */
    public static void setButtonReleased(ImageView imagePlaceholder) {
        imagePlaceholder.setScaleY(1);
        imagePlaceholder.setScaleX(1);
    }

    /**
     * Render the background of the game, load the background that is selected by the user
     * @param background the background placeholder to be rendered
     * @author fy916
     */
    public static void RenderOuterBackground(ImageView background) {
        background.setImage(PageImageLoader.getImg_background_full().get(GameStatus.getBackgroundChoice()));
    }

}
