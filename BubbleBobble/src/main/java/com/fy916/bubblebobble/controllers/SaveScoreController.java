package com.fy916.bubblebobble.controllers;

import com.fy916.bubblebobble.utilities.GameScores;
import com.fy916.bubblebobble.controllers.renderer.SaveScoreImageLoader;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * This class is extended from {@link Controller}.<br/>
 * This class utilize the {@link SaveScoreImageLoader} to facilitate the rendering process.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * In charge of rendering the save score page, is the controller of the FXML based scene.
 * @author fy916
 * @version 1.0
 */
public class SaveScoreController extends Controller {

    /**
     * the place of the player in the leader board
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
    private TextField textFiled;
    @FXML
    private ImageView Save_button;

    /**
     * Renders the main entrance of the game
     * @throws IOException May throw {@link IOException} since it reads from the disk to load the FXML files
     * @author fy916
     */
    @FXML
    void back_to_main(MouseEvent event) throws IOException {
        GameScores.getScoreBoardName().set(place, textFiled.getText());
        render_main();
    }

    /**
     * FXML method when the user focuses on the page instead of the button
     * @author fy916
     */
    @FXML
    void focus_page(MouseEvent event) {
        SaveScoreImageLoader.renderGameSavePageButton(Save_button, false);
    }

    /**
     * FXML method when the user focuses on the save button
     * @author fy916
     */
    @FXML
    void focus_save(MouseEvent event) {
        SaveScoreImageLoader.renderGameSavePageButton(Save_button, true);
    }

    /**
     * Listener which is used to limit the user input when input the name in the game save page
     * @param maxLength the allowed max input into the text box
     * @author fy916
     */
    public void addTextLimiter(final int maxLength) {
        //add the listener to the textFiled
        textFiled.textProperty().addListener((ov, oldValue, newValue) -> {
            if (textFiled.getText().length() > maxLength) {
                String s = textFiled.getText().substring(0, maxLength);
                textFiled.setText(s);
            }
        });
    }

    /**
     * Render the save score page with both backgrounds and its buttons
     * @author fy916
     */
    public void render_page() {
        SaveScoreImageLoader.renderGameSavePage(Image_background, page);
        SaveScoreImageLoader.renderGameSavePageButton(Save_button, false);
    }


    /**
     * The image setter
     * @param place the player place in the leader board
     * @author fy916
     */
    public void LBplace(int place) {
        this.place = place;
    }
}
