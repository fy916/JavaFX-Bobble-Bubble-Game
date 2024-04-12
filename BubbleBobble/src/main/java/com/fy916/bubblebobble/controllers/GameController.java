package com.fy916.bubblebobble.controllers;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.controllers.renderer.ControllerFileReader;
import com.fy916.bubblebobble.controllers.renderer.GameRefresher;
import com.fy916.bubblebobble.controllers.renderer.PageImageLoaderUtilities;
import com.fy916.bubblebobble.utilities.RenderObjects;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;

/**
 * This class is extended from {@link Controller}.<br/>
 * This class utilize the {@link GameRefresher} to facilitate the rendering process.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * In charge of rendering the game page of the program, is the controller of the FXML based scene.<br/>
 * @author fy916
 * @version 1.0
 */
public class GameController extends Controller {


    private InteractableWorld world;
    private RenderObjects renderer;
    private Timeline tl;
    private GameRefresher gameRefresher;
    /**
     * Indicates if the game is running
     * @author fy916
     */
    private boolean gamerunning = true;

    /**
     * components contained in the FXML
     * @author fy916
     */
    @FXML
    private ImageView To_main_button;
    @FXML
    private Label Score_count;
    @FXML
    private Canvas canvas_game;
    @FXML
    private ImageView Image_background;
    @FXML
    private ImageView lives1;
    @FXML
    private ImageView lives5;
    @FXML
    private ImageView lives4;
    @FXML
    private ImageView lives3;
    @FXML
    private ImageView lives2;
    @FXML
    private ProgressIndicator Hero_time_indicator_red;
    @FXML
    private ProgressBar Boss_health_indicator;
    @FXML
    private ProgressIndicator Hero_time_indicator_green;
    @FXML
    private ProgressBar Hero_Ability_Indicator;

    /**
     * FXML method jumps to the main page
     * @exception IOException may throw {@link IOException} since it fetches data from external files
     * @author fy916
     */
    @FXML
    void Go_to_main(MouseEvent event) throws IOException {
        gamerunning = false;
        render_main();
    }

    /**
     * FXML method when the user focuses on the back button
     * @author fy916
     */
    @FXML
    void focus_back(MouseEvent event) {
        PageImageLoaderUtilities.renderBackButton(To_main_button, true);
    }

    /**
     * FXML method when the user focuses on the page instead of the button
     * @author fy916
     */
    @FXML
    void focus_page(MouseEvent event) {
        PageImageLoaderUtilities.renderBackButton(To_main_button, false);
    }

    /**
     * Render the game finish page when game ends
     * @param type the type of the status of the game, when 0 represents gameover; 1 represents level passed; 2 represents victory
     * @exception IOException May throw {@link IOException} since the method reads from the external files for the FXML files
     * @author fy916
     */
    public void goto_gameFinishPage(int type) throws IOException {
        gamerunning = false;
        FXMLLoader loader = new FXMLLoader();
        Parent root = ControllerFileReader.loadFXML(loader, "GameFinish"); //load the external files
        GameFinishController gameFinishController = loader.getController();
        gameFinishController.setStage(mStage);
        gameFinishController.setType(type);
        gameFinishController.renderdefault();
        mStage.setTitle("BubbleBobble");
        mStage.setScene(new Scene(root)); //switch to the scene
        mStage.show();
    }

    /**
     * Render the game and continously update within the {@link Timeline}
     * @param input_scene the Scene that the game to be rendered in
     * @exception IOException May throw {@link IOException} since the method contains {@link Timeline} play
     * @author fy916
     */
    public void renderGame(Scene input_scene) throws IOException {
        gameRefresher = new GameRefresher(this);        //initialize the game refresher
        world = new InteractableWorld(40, 34, 20);  //create a new world according to the size of the window
        GraphicsContext gc = canvas_game.getGraphicsContext2D();    // get the canvas to draw on
        renderer = new RenderObjects(world, gc);
        gameRefresher.runningPrep();
        gameRefresher.keyBindings(input_scene);

        //the game starts to be rendered and refresh within the timeline
        tl = new Timeline(new KeyFrame(Duration.millis(18), e -> {
            try {
                gameRefresher.run(gc);
                gameRefresher.statusChecker();
                gameRefresher.updateUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
    }


    /**
     * Getter of the returned field
     * @return the world stored in the Controller
     * @author fy916
     */
    public InteractableWorld getWorld() {return world;}

    /**
     * Getter of the returned field
     * @return the renderer of the game
     * @author fy916
     */
    public RenderObjects getRenderer() { return renderer;}

    /**
     * Getter of the returned field
     * @return the timeline that game rendered within
     * @author fy916
     */
    public Timeline getTl() { return tl; }

    /**
     * Getter of the returned field
     * @return the {@link javafx.scene.image.ImageView} type of button of "back to main" button
     * @author fy916
     */
    public ImageView getTo_main_button() { return To_main_button; }

    /**
     * Getter of the returned field
     * @return the {@link Label} type of the game score count Label
     * @author fy916
     */
    public Label getScore_count() { return Score_count; }

    /**
     * Getter of the returned field
     * @return the {@link Canvas} type that the game rendered on
     * @author fy916
     */
    public Canvas getCanvas_game() { return canvas_game; }

    /**
     * Getter of the returned field
     * @return the {@link javafx.scene.image.ImageView} type of the background image placeholder
     * @author fy916
     */
    public ImageView getImage_background() { return Image_background; }

    /**
     * Getter of the returned field
     * @return the {@link javafx.scene.image.ImageView} type of the health image placeholder, placeholder first
     * @author fy916
     */
    public ImageView getLives1() { return lives1; }

    /**
     * Getter of the returned field
     * @return the {@link javafx.scene.image.ImageView} type of the health image placeholder, placeholder second
     * @author fy916
     */
    public ImageView getLives2() { return lives2;}

    /**
     * Getter of the returned field
     * @return the {@link javafx.scene.image.ImageView} type of the health image placeholder, placeholder third
     * @author fy916
     */
    public ImageView getLives3() { return lives3; }

    /**
     * Getter of the returned field
     * @return the {@link javafx.scene.image.ImageView} type of the health image placeholder, placeholder forth
     * @author fy916
     */
    public ImageView getLives4() { return lives4; }

    /**
     * Getter of the returned field
     * @return the {@link javafx.scene.image.ImageView} type of the health image placeholder, placeholder fifth
     * @author fy916
     */
    public ImageView getLives5() { return lives5;}

    /**
     * Getter of the returned field
     * @return the {@link ProgressIndicator} type of indicator that represents the hero stunned time
     * @author fy916
     */
    public ProgressIndicator getHero_time_indicator_red() { return Hero_time_indicator_red;}

    /**
     * Getter of the returned field
     * @return the {@link ProgressIndicator} type of indicator that represents the hero shielding time
     * @author fy916
     */
    public ProgressIndicator getHero_time_indicator_green() { return Hero_time_indicator_green;}

    /**
     * Getter of the returned field
     * @return the {@link ProgressBar} type of indicator that represents the hero ability charge time
     * @author fy916
     */
    public ProgressBar getHero_Ability_Indicator() { return Hero_Ability_Indicator; }

    /**
     * Getter of the returned field
     * @return the {@link ProgressBar} type of indicator that represents the boss health
     * @author fy916
     */
    public ProgressBar getBoss_health_indicator() { return Boss_health_indicator;}

    /**
     * Setter of the game running variable
     * @param inp set if the game is running or not
     * @author fy916
     */
    public void set_if_game_running(Boolean inp) { gamerunning = inp;  }

    /**
     * Getter of the returned field
     * @return the gamerunning status
     * @author fy916
     */
    public boolean if_game_running() { return gamerunning; }
}


