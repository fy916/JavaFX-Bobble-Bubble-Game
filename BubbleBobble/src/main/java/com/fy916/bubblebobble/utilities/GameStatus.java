package com.fy916.bubblebobble.utilities;

import java.util.ArrayList;

/**
 * This class includes some utilities that facilitate saving the game status such as the level, difficulty, background choice, bubble color,
 * player lives, total player lives and the total levels the game has. <br/>
 * Demonstrates Single Responsibility, SINGLETON Design Pattern.
 * @author fy916
 */
public class GameStatus {
    //static fields saving the data
    private static int level;
    private static int difficulty;
    private static int backgroundChoice;
    private static int bubbleColor;
    private static int lives;
    private static int totalLives;
    private static int totalLevels;
    private static double difficultyCoefficient;

    //the only instance of the class
    private static  final GameStatus INSTANCE = new GameStatus();

    /**
     * Private constructor which initializes the game status data. <br/>
     * Demonstrates SINGLETON Design Pattern.
     * @author fy916
     */
    private GameStatus() {
        //default values for the fields
        refreshLives();
        setLevel(1);
        setBackgroundChoice(1);
        setDifficulty(1);
        setBubbleColor(1);
    }

    /**
     * Static Method to reset left lives, total lives, place, scores, levels of the player in the game. <br/>
     * @author fy916
     */
    public static void refreshLives() {
        LevelStatus.resetWinningStatus();
        GameScores.setScorePlace(-1);
        GameScores.resetScore();
        GameStatus.setLevel(1);
        GameStatus.setLives(5 - GameStatus.getDifficulty());
        GameStatus.setTotalLives(5 - GameStatus.getDifficulty());//according to the difficulty, the player has different lives left
    }


    /**
     * Static Getter of the Class Instance itself since the constructor is private.<br/>
     * Demonstrates SINGLETON Design Pattern.
     * @return an Instance of the {@link GameStatus}
     * @author fy916
     */
    public static GameStatus getGameStatus(){
        return INSTANCE;
    }



    /**
     * Static Getter of the field
     * @return integer type of level field
     * @author fy916
     */
    public static int getLevel() {
        return level;
    }

    /**
     * Static Getter of the field
     * @return integer type of difficulty field
     * @author fy916
     */
    public static int getDifficulty() {
        return difficulty;
    }

    /**
     * Static Getter of the field
     * @return integer type of backgroundChoice field
     * @author fy916
     */
    public static int getBackgroundChoice() {
        return backgroundChoice;
    }

    /**
     * Static Getter of the field
     * @return integer type of bubbleColor field
     * @author fy916
     */
    public static int getBubbleColor() {
        return bubbleColor;
    }

    /**
     * Static Getter of the field
     * @return int type of lives field
     * @author fy916
     */
    public static int getLives() {
        return lives;
    }

    /**
     * Static Getter of the field
     * @return int type of totalLives field
     * @author fy916
     */
    public static int getTotalLives() {
        return totalLives;
    }

    /**
     * Static Getter of the field
     * @return int type of totalLevels field
     * @author fy916
     */
    public static int getTotalLevel() {
        return totalLevels;
    }

    /**
     * Static Getter of the field
     * @return double type of difficultyCoefficient field
     * @author fy916
     */
    public static double getDifficultyCoefficient() {
        return difficultyCoefficient;
    }



    /**
     * Static Method to set the lives field <br/>
     * @param lives The new lives to be saved in the field
     * @author fy916
     */
    public static void setLives(int lives) {
        GameStatus.lives = lives;
    }

    /**
     * Static Method to set the backgroundChoice field <br/>
     * @param backgroundChoice The new backgroundChoice to be saved in the field
     * @author fy916
     */
    public static void setBackgroundChoice(int backgroundChoice) {
        GameStatus.backgroundChoice = backgroundChoice;
    }

    /**
     * Static Method to set the bubbleColor field <br/>
     * @param bubbleColor The new bubbleColor to be saved in the field
     * @author fy916
     */
    public static void setBubbleColor(int bubbleColor) {
        GameStatus.bubbleColor = bubbleColor;
    }

    /**
     * Static Method to set the totalLives field <br/>
     * @param totalLives The new totalLives to be saved in the field
     * @author fy916
     */
    public static void setTotalLives(int totalLives) {
        GameStatus.totalLives = totalLives;
    }

    /**
     * Static Method to set the difficulty field <br/>
     * @param difficulty The new difficulty to be saved in the field
     * @author fy916
     */
    public static void setDifficulty(int difficulty) {
        GameStatus.difficulty = difficulty;
        GameStatus.setDifficultyCoefficient((GameStatus.getDifficulty()) * 0.33);
    }

    /**
     * Static Method to set the level field <br/>
     * @param level The new level to be saved in the field
     * @author fy916
     */
    public static void setLevel(int level) {
        GameStatus.level = level;
    }

    /**
     * Static Method to set the temp field <br/>
     * @param temp The new temp to be saved in the field
     * @author fy916
     */
    public static void setTotalLevels(int temp) {
        totalLevels = temp;
    }

    /**
     * Static Method to set the difficultyCoefficient field <br/>
     * @param difficultyCoefficient The new difficultyCoefficient to be saved in the field
     * @author fy916
     */
    public static void setDifficultyCoefficient(double difficultyCoefficient) {
        GameStatus.difficultyCoefficient = difficultyCoefficient;
    }
}