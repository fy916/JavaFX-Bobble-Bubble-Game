package com.fy916.bubblebobble.controllers.renderer;

import com.fy916.bubblebobble.controllers.GameController;
import com.fy916.bubblebobble.utilities.GameScores;
import com.fy916.bubblebobble.utilities.GameStatus;
import com.fy916.bubblebobble.utilities.LevelStatus;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;

/**
 * The helper of the {@link GameController} to facilitate the rendering process of the game.<br/>
 * This realizes the FACADE Design Pattern as it provides a simple intro for the caller while in charge of the complicated tasks of decorating the rendered component.
 * @author fy916
 * @version 1.0
 */
public class GameRefresher {
    private GameController gameController;
    /**
     * to store the gameController into the field
     * @author fy916
     */
    public GameRefresher(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * The running prepation for the game rendering, start the game in the world and then load the stylesheet for the UIs.
     * @author fy916
     */
    public void runningPrep() throws IOException {
        //start to run the game
        gameController.set_if_game_running(true);
        gameController.getWorld().getGameStarter().startGame(GameStatus.getLevel());
        PageImageLoaderUtilities.renderBackButton(gameController.getTo_main_button(), false);
        ControllerFileReader.loadCSS(gameController.getHero_time_indicator_red(), "ProgressIndicatorCSS");//load the external files
        ControllerFileReader.loadCSS(gameController.getHero_time_indicator_green(), "ProgressIndicatorCSS");//load the external files
    }

    /**
     * Running process, this will be repeated everytime the frame refreshes
     * @param gc The {@link GraphicsContext} Object that provides the ability to draw on the canvas
     * @exception IOException Since the elements will continous refresh and the rendering images may be read along the process, may throw {@link IOException}
     * @author fy916
     */
    public void run(GraphicsContext gc) throws IOException {
        //reset the renderer of the last frame
        gc.restore();
        gc.clearRect(0, 0, gameController.getCanvas_game().getWidth(), gameController.getCanvas_game().getHeight());
        //update the elements locations
        gameController.getWorld().getGameUpdater().updatePosition();
        gameController.getRenderer().renderOnScreen();
    }
    /**
     * Check the game status like if the game is losing or winning, if so the function will access the {@link javafx.animation.Timeline} and then stop the frame from playing
     * @author fy916
     */
    public void statusChecker() throws IOException {
        //check if the game is winning, losing or total victory
        if (!gameController.if_game_running()) {
            gameController.getTl().stop();
        }
        int status = LevelStatus.getGameWinningStatus();
        if (status>=0){
            gameController.getTl().stop();
            gameController.goto_gameFinishPage(status);
        }
    }

    /**
     * Update the UI of the game like score counts, backgrounds, lives, etc. 
     * @author fy916
     */
    public void updateUI(){
        //update the backgrounds and scores
        gameController.getScore_count().setText("Score: " + GameScores.getScoreCounter());
        PageImageLoaderUtilities.RenderOuterBackground(gameController.getImage_background());
        //update the indicators and lives
        GamePageImageLoader.updateUIIndicators(gameController.getWorld(), gameController.getHero_time_indicator_red(), gameController.getHero_time_indicator_green(), gameController.getHero_Ability_Indicator(), gameController.getBoss_health_indicator());
        GamePageImageLoader.render_all_lives(gameController.getLives1(), gameController.getLives2(), gameController.getLives3(), gameController.getLives4(), gameController.getLives5(), GameStatus.getLives(), GameStatus.getTotalLives());
    }

    /**
     * Binds the keys with the controller
     * @param input_scene The scene of the game, which gets the user keyinput
     * @author fy916
     */
    public void keyBindings(Scene input_scene){
        //set the key pressed event
        input_scene.setOnKeyPressed(
                e -> {
                    gameController.getWorld().getHeroController().control_hero_pressd(e);
                });
        //set the key released event
        input_scene.setOnKeyReleased(
                e -> {
                    gameController.getWorld().getHeroController().control_hero_released(e);
                });
    }
}
