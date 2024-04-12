package com.fy916.bubblebobble.utilities;

import com.fy916.bubblebobble.Main;
import com.fy916.bubblebobble.gaming.elements.GameObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.*;
import com.fy916.bubblebobble.gaming.world.ElementsAdder;
import com.fy916.bubblebobble.gaming.world.ElementsRemover;
import com.fy916.bubblebobble.gaming.world.WorldElements;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class includes some utilities that facilitate the usage of loading from external files.<br/>
 * Demonstrates Single Responsibility and FACTORY Design Pattern.
 * @author fy916
 */
public class FileReader {

    /**
     * Static Method to Get the audio clip from external file. <br/>
     * Demonstrates FACTORY Design Pattern.
     * @param fileName The {@link String} type of file name of the audio that to be fetched from "sfx" folder.
     * @return the {@link AudioClip} type of audio
     * @author fy916
     */
    public static AudioClip getAudioClip(String fileName){
        return new AudioClip(Main.class.getResource("sfx/"+fileName+".wav").toExternalForm());
    }

    /**
     * Static Method to Get the background image from external file. <br/>
     * Demonstrates FACTORY Design Pattern.
     * @param filename The {@link String} type of file name of the image that to be fetched from "background" folder.
     * @return the {@link Image} type of image
     * @author fy916
     */
    public static Image fetch_Image_background(String filename) {
        String file = "background/+" + filename + ".png";
        return new Image(Main.class.getResourceAsStream("background/" + filename + ".png"));
    }

    /**
     * Static Method to Load data from external file "game_data.txt" and then load the settings and scores into the memory. <br/>
     * Note that in this game, SIX levels have been set and if you'd like to add levels, please ensure that you
     * edit the gama_data.txt's first line to the total levels you want. <br/>
     * The First line of the file is total lives. <br/>
     * The Second line of the file is the difficulty selection. <br/>
     * The Third line of the file is the bubble color user selects. <br/>
     * The forth line of the file is the background image user selects. <br/>
     * The following lines of the file are the history top 10 scores with names and the score in seperated two lines.<br/>
     * The Game will displays the names and scores' place (1#, 2#) only when there is a person in this place. <br/>
     * Demonstrates FACTORY Design Pattern.
     * @author fy916
     */
    public static void loadData() {
        //Initialize the reader
        InputStream input = Main.class.getResourceAsStream("game_data.txt");
        Scanner scanner = new Scanner(input);
        if (scanner.hasNextLine()) { //read the Total Levels
            String currentLine = scanner.nextLine();
            try {
                int temp = Integer.valueOf(currentLine).intValue();
                if (temp >= 0) { //set the total levels
                    GameStatus.setTotalLevels(temp);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (scanner.hasNextLine()) { //read the Difficulty selection
            String currentLine = scanner.nextLine();
            try {
                int temp = Integer.valueOf(currentLine).intValue();
                if (temp >= 0 && temp <= 3) {
                    GameStatus.setDifficulty(temp);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (scanner.hasNextLine()) {//read the bubble color selection
            String currentLine = scanner.nextLine();
            try {
                int temp = Integer.valueOf(currentLine).intValue();
                if (temp >= 0 && temp <= 7) {
                    GameStatus.setBubbleColor(temp);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (scanner.hasNextLine()) {//read the background color selection
            String currentLine = scanner.nextLine();
            try {
                int temp = Integer.valueOf(currentLine).intValue();
                if (temp >= 0 && temp <= 7) {
                    GameStatus.setBackgroundChoice(temp);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        while (scanner.hasNextLine()) {//read the game scores
            String currentLine = scanner.nextLine();
            GameScores.getScoreBoardName().add(currentLine);//add the names
            if (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                try {
                    int temp = Integer.valueOf(currentLine).intValue();
                    GameScores.getScoreBoardScore().add(temp);//add the scores
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Static Method to Save data from the memory to external files.<br/>
     * Save sequence: <br/>
     * 1. Total levels<br/>
     * 2. Difficulty selection <br/>
     * 3. Bubble color<br/>
     * 4. Background image choice<br/>
     * 5. Leaderboard Name+Score<br/>
     * Note that only top10 will be saved.<br/>
     * Demonstrates FACTORY Design Pattern.
     * @throws IOException may throw {@link IOException} since the method writes to the files
     * @author fy916
     */
    public static void saveData() throws IOException {
        //new buffered writer
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/com/fy916/bubblebobble/game_data.txt"));
        writer.write(String.valueOf(GameStatus.getTotalLevel())); //save total levels
        writer.write("\n");
        writer.write(String.valueOf(GameStatus.getDifficulty())); //save difficulty
        writer.write("\n");
        writer.write(String.valueOf(GameStatus.getBubbleColor()));//save bubble color
        writer.write("\n");
        writer.write(String.valueOf(GameStatus.getBackgroundChoice())); //save background choice
        writer.write("\n");
        int counter = GameScores.getScoreBoardScore().size();
        if (counter > 10) { //only save the top10
            counter = 10;
        }
        for (int i = 0; i < counter; i++) {//save game scores and names
            writer.write(GameScores.getScoreBoardName().get(i));
            writer.write("\n");
            writer.write(String.valueOf(GameScores.getScoreBoardScore().get(i)));
            writer.write("\n");
        }
        writer.close();
    }

    /**
     * Static Method to Get the game object image from external file. <br/>
     * Demonstrates FACTORY Design Pattern.
     * @param filename The {@link String} type of file name of the image that to be fetched from "img" folder.
     * @return the {@link Image} type of image
     * @author fy916
     */
    public static Image fetch_Image_objects(String filename) {
        return new Image(Main.class.getResourceAsStream("img/" + filename + ".png"));
    }
}
