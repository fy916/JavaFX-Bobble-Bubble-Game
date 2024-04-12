package com.fy916.bubblebobble.controllers.renderer;

import com.fy916.bubblebobble.utilities.FileReader;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * The ImageLoader in charge of loading the external files, this is especially created to make the whole game modular so that the load of files will be facilitated and inspected at one place.<br/>
 * Realizes Single Responsibility Principle and FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class PageImageLoader {
    private static Image img_tittle = FileReader.fetch_Image_background("tittle");
    private static Image img_setting_background = FileReader.fetch_Image_background("settings");
    private static Image img_setting_back_button = FileReader.fetch_Image_background("back");
    private static Image img_setting_back_button_selected = FileReader.fetch_Image_background("back_focused");
    private static Image img_check = FileReader.fetch_Image_background("check");
    private static ArrayList<Image> img_background_full; //0-7
    private static ArrayList<Image> img_background_preview; //0-7
    private static ArrayList<Image> img_start_button; //0-4
    private static ArrayList<Image> img_start_button_selected; //0-4
    private static ArrayList<Image> img_difficulty;  //0-3
    private static ArrayList<Image> img_bubble;  //0-7

    private static Image img_leaderBoardBackground = FileReader.fetch_Image_background("LeaderBoard");
    private static Image img_ControlsBackground = FileReader.fetch_Image_background("controls");
    private static Image img_game_over = FileReader.fetch_Image_background("Game_over");
    private static Image img_game_passed = FileReader.fetch_Image_background("win");
    private static Image img_next_level = FileReader.fetch_Image_background("level_up");
    private static Image img_continue = FileReader.fetch_Image_background("continue");
    private static Image img_continue_selected = FileReader.fetch_Image_background("continue_selected");
    private static Image img_save_score = FileReader.fetch_Image_background("save_score");
    private static Image img_lives_alive = FileReader.fetch_Image_background("lives");
    private static Image img_lives_dead = FileReader.fetch_Image_background("lives_dead");

    /**
     * Constructor of the PageImageLoader, this constructor is intended for the ArrayList {@link Image} when it initializes the ArrayList and load the photos sequently into the Arrarlist using for loop
     * @author fy916
     * @version 1.0
     */
    public PageImageLoader() {
        img_background_full = new ArrayList<Image>();
        img_start_button = new ArrayList<Image>();
        img_start_button_selected = new ArrayList<Image>();
        img_difficulty = new ArrayList<Image>();
        img_background_preview = new ArrayList<Image>();
        img_bubble = new ArrayList<Image>();

        for (int i = 0; i < 4; i++) {
            img_difficulty.add(FileReader.fetch_Image_background("difficulty_" + i));
        }
        for (int i = 0; i < 8; i++) {
            img_bubble.add(FileReader.fetch_Image_background("bubble_" + i));
            img_background_preview.add(FileReader.fetch_Image_background("background_preview_" + i));
            img_background_full.add(FileReader.fetch_Image_background("background" + i + "_full"));
        }

        for (int i = 0; i < 5; i++) {
            img_start_button.add(FileReader.fetch_Image_background("start_button_" + i));
            img_start_button_selected.add(FileReader.fetch_Image_background("start_button_selected_" + i));
        }
    }

    /**
     * The image getter
     *@return  BubbleBobble logo image
     * @author fy916
     */
    public static Image getImg_tittle() {return img_tittle;}

    /**
     * The image getter
     *@return the settings page background
     * @author fy916
     */
    public static Image getImg_setting_background() {return img_setting_background;}

    /**
     * The image getter
     *@return the back button in the settings page
     * @author fy916
     */
    public static Image getImg_setting_back_button() {return img_setting_back_button;}

    /**
     * The image getter
     *@return the back button that looks to be focused in the settings page
     * @author fy916
     */
    public static Image getImg_setting_back_button_selected() {return img_setting_back_button_selected; }

    /**
     * The image getter
     *@return the check image in the settings page
     * @author fy916
     */
    public static Image getImg_check() {return img_check;}

    /**
     * The image getter
     *@return the background images ArrayList of the game
     * @author fy916
     */
    public static ArrayList<Image> getImg_background_full() {return img_background_full;}

    /**
     * The image getter
     *@return the background preview images ArrayList of the game used in settings
     * @author fy916
     */
    public static ArrayList<Image> getImg_background_preview() {return img_background_preview;}

    /**
     * The image getter
     *@return the button images ArrayList of the game start page
     * @author fy916
     */
    public static ArrayList<Image> getImg_start_button() {return img_start_button;}

    /**
     * The image getter
     *@return the button images ArrayList that are focused by the user in the game start page
     * @author fy916
     */
    public static ArrayList<Image> getImg_start_button_selected() {return img_start_button_selected;}

    /**
     * The image getter
     *@return the difficulty image ArrayList
     * @author fy916
     */
    public static ArrayList<Image> getImg_difficulty() {return img_difficulty;}

    /**
     * The image getter
     *@return the bubble image ArrayList
     * @author fy916
     */
    public static ArrayList<Image> getImg_bubble() {return img_bubble;}

    /**
     * The image getter
     *@return the leader board background image
     * @author fy916
     */
    public static Image getImg_leaderBoardBackground() {return img_leaderBoardBackground;}

    /**
     * The image getter
     *@return the INFO background image
     * @author fy916
     */
    public static Image getImg_ControlsBackground() {return img_ControlsBackground;}

    /**
     * The image getter
     *@return the gameover scene background image
     * @author fy916
     */
    public static Image getImg_game_over() {return img_game_over;}

    /**
     * The image getter
     *@return the victory scene background image
     * @author fy916
     */
    public static Image getImg_game_passed() {return img_game_passed;}

    /**
     * The image getter
     *@return the level passed scene background image
     * @author fy916
     */
    public static Image getImg_next_level() {return img_next_level;}

    /**
     * The image getter
     *@return the continue button image
     * @author fy916
     */
    public static Image getImg_continue() {return img_continue;}

    /**
     * The image getter
     *@return the continue button image that is focused by the player
     * @author fy916
     */
    public static Image getImg_continue_selected() {return img_continue_selected;}

    /**
     * The image getter
     *@return the save score page background
     * @author fy916
     */
    public static Image getImg_save_score() {return img_save_score;}

    /**
     * The image getter
     *@return the heart icon indicating lives of the hero
     * @author fy916
     */
    public static Image getImg_lives_alive() {return img_lives_alive;}

    /**
     * The image getter
     *@return the empty heart icon indicating lives of the hero
     * @author fy916
     */
    public static Image getImg_lives_dead() {return img_lives_dead;}
}













