package com.fy916.bubblebobble.controllers.renderer;

import javafx.scene.image.ImageView;

/**
 * The helper of the {@link com.fy916.bubblebobble.controllers.MainController} to facilitate the rendering process of the main page.<br/>
 * Realizes Single Responsibility Principle and FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class MainPageImageLoader {
    /**
     * Render the background of the main page of the game
     * @param imagebackground The background image placeholder to be rendered
     * @param tittle The Bubble Bobble LOGO placeholder
     * @param button1  {@link javafx.scene.image.ImageView} placeholder is used to load images and serve as a Start game button
     * @param button2 {@link javafx.scene.image.ImageView} placeholder is used to load images and serve as a Quit game button
     * @param button3 {@link javafx.scene.image.ImageView} placeholder is used to load images and serve as an Info page button
     * @param button4 {@link javafx.scene.image.ImageView} placeholder is used to load images and serve as a Leader board button
     * @param button5 {@link javafx.scene.image.ImageView} placeholder is used to load images and serve as a Settings button
     * @param choice  The user choice
     * @param focus The user's focus on the button
     * @author fy916
     */
    public static void renderMainPage(ImageView imagebackground, ImageView tittle, ImageView button1, ImageView button2, ImageView button3, ImageView button4, ImageView button5, int choice, int focus) {
        //render the buttons
        imagebackground.setImage(PageImageLoader.getImg_background_full().get(choice));
        tittle.setImage(PageImageLoader.getImg_tittle());
        button1.setImage(PageImageLoader.getImg_start_button().get(0));
        button2.setImage(PageImageLoader.getImg_start_button().get(1));
        button3.setImage(PageImageLoader.getImg_start_button().get(2));
        button4.setImage(PageImageLoader.getImg_start_button().get(3));
        button5.setImage(PageImageLoader.getImg_start_button().get(4));
        if (focus == 0) {        //if the user is not focusing on the buttons
            zoomButton(button1, false);
            zoomButton(button2, false);
            zoomButton(button3, false);
            zoomButton(button4, false);
            zoomButton(button5, false);
        }else if (focus == 1){//if the user focuses on the start button
            button1.setImage(PageImageLoader.getImg_start_button_selected().get(0));
            zoomButton(button1, true);
        }else if (focus == 2){//if the user focuses on the quit game button
            button2.setImage(PageImageLoader.getImg_start_button_selected().get(1));
            zoomButton(button2, true);
        }else if (focus == 3){//if the user focuses on the INTO button
            button3.setImage(PageImageLoader.getImg_start_button_selected().get(2));
            zoomButton(button3, true);
        }else if (focus == 4){//if the user focuses on the leader board button
            button4.setImage(PageImageLoader.getImg_start_button_selected().get(3));
            zoomButton(button4, true);
        } else if (focus == 5){//if the user focuses on the settings button
            button5.setImage(PageImageLoader.getImg_start_button_selected().get(4));
            zoomButton(button5, true);
        }
    }

    /**
     * Choose if to zoom in the {@link javafx.scene.image.ImageView}
     * @param imageView The placeholder of the {@link javafx.scene.image.Image} that serves as a button
     * @param ifzoom If to enlarge the button
     * @author fy916
     * @version 1.0
     */
    public static void zoomButton(ImageView imageView, boolean ifzoom){
        if (!ifzoom){        //set the original button size
            imageView.setScaleX(1.2);
            imageView.setScaleY(1.2);
        }else { // enlarge the button
            imageView.setScaleX(1.4);
            imageView.setScaleY(1.4);
        }
    }
}

