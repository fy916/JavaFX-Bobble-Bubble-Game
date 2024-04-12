package com.fy916.bubblebobble.controllers.renderer;

import javafx.scene.image.ImageView;

/**
 * The helper of the {@link com.fy916.bubblebobble.controllers.InfoController} to facilitate the rendering process of the info page.<br/>
 * Realizes Single Responsibility Principle and FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */

public class InfoPageImageLoader {
    /**
     * Render the background of the game info page
     * @param imagePlaceholder The image placeholder of the background to be rendered
     * @param back_button  {@link javafx.scene.image.ImageView} placeholder is used to load images and serve as a back button of the page
     * @param focus_back If the user is focusing on the back button
     * @author fy916
     */
    public static void renderControlsBackground(ImageView imagePlaceholder, ImageView back_button, boolean focus_back) {
        PageImageLoaderUtilities.renderBackButton(back_button, focus_back);
        imagePlaceholder.setImage(PageImageLoader.getImg_ControlsBackground());
    }
}
