package com.fy916.bubblebobble;


import com.fy916.bubblebobble.controllers.MainController;
import com.fy916.bubblebobble.utilities.FileReader;
import com.fy916.bubblebobble.utilities.GameStatus;
import com.fy916.bubblebobble.controllers.renderer.PageImageLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main provides an entrance to the game. Main class is extended from the {@link Application} superclass, which provides the javafx GUI implementation basis.
 * @author fy916
 * @version 1.0
 */
public class Main extends Application {
    /**
     * The constructor initialize the game data such as difficulty, bubble color, background color, total levels, history high scores from the outside file, along with initializing the page photos.
     * @author fy916
     */
    public Main() {
        PageImageLoader pageImageLoader = new PageImageLoader();
        FileReader.loadData();
        GameStatus.refreshLives();
    }

    /**
     * Invoke the javafx application
     * @author fy916
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start show the screen and load Main.fxml from the resources
     * @author fy916
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("UI_files/Main.fxml").openStream());//load files from external files
        MainController firstController = loader.getController();
        firstController.setStage(primaryStage);
        firstController.render_page(0);
        primaryStage.setTitle("Stage");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}