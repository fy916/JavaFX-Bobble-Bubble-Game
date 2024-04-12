package com.fy916.bubblebobble.controllers;

import com.fy916.bubblebobble.controllers.renderer.InfoPageImageLoader;
import com.fy916.bubblebobble.controllers.renderer.SaveScoreImageLoader;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * This class is extended from {@link Controller}.<br/>
 * This class utilize the {@link InfoPageImageLoader} to facilitate the rendering process.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * In charge of rendering the INFO page from the main page, is the controller of the FXML based scene.
 * @author fy916
 * @version 1.0
 */
public class InfoController extends Controller {

    /**
     * components contained in the FXML
     * @author fy916
     */
    @FXML
    private ImageView Image_background;
    @FXML
    private ImageView back_button;

    /**
     * Renders the main entrance of the game
     * @throws IOException May throw {@link IOException} since it reads from the disk to load the FXML files
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
        InfoPageImageLoader.renderControlsBackground(Image_background, back_button, true);
    }

    /**
     * FXML method when the user focuses on the page instead of the button
     * @author fy916
     */
    @FXML
    void focus_page(MouseEvent event) {
        InfoPageImageLoader.renderControlsBackground(Image_background, back_button, false);
    }

    /**
     * Render the default display outlook of the page itself
     * @author fy916
     */
    public void renderdefault() {
        InfoPageImageLoader.renderControlsBackground(Image_background, back_button, false);
    }
}
