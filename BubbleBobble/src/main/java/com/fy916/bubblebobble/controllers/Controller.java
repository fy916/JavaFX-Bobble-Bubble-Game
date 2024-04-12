package com.fy916.bubblebobble.controllers;

import com.fy916.bubblebobble.controllers.renderer.ControllerFileReader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A superclass of the javafx controllers that includes some basic properities that is used by all controllers
 * @author fy916
 * @version 1.0
 */
public class Controller {
    protected Stage mStage;

    /**Set the mStage in the Controller to be used
     * @param mStage the current javafx stage, which is used widely for switching scenes
     * @author fy916
     */
    public void setStage(Stage mStage) { this.mStage = mStage; }

    /**
     * Renders the main entrance of the game, which is widely used by all kinds of controllers since they may need to jump to the main page
     * @throws IOException May throw {@link IOException} since it reads from the disk to load the FXML files
     * @author fy916
     */
    protected void render_main() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = ControllerFileReader.loadFXML(loader, "Main");    //load files
        MainController mainController = loader.getController();
        mainController.setStage(mStage);
        mainController.render_page(0);  //set the user focus to the page
        mStage.setTitle("BubbleBobble");
        mStage.setScene(new Scene(root));
        mStage.show();
    }
}
