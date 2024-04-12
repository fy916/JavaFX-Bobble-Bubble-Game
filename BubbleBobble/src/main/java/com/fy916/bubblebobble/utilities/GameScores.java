package com.fy916.bubblebobble.utilities;

import com.fy916.bubblebobble.gaming.world.GameUpdater;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;

/**
 * This class includes some utilities that facilitate the control of leader board names and scores, along with saving the current game scores.<br/>
 * Demonstrates Single Responsibility, SINGLETON and FACTORY Design Pattern.
 * @author fy916
 */
public class GameScores {
    private static ArrayList<String> scoreBoardName;
    private static ArrayList<Integer> scoreBoardScore ;
    private static int scoreCounter;
    private static int scorePlace;

    //the only instance of the class
    private static final GameScores gameScores = new GameScores();


    /**
     * Private constructor which initializes the leader board data. <br/>
     * Demonstrates SINGLETON Design Pattern.
     * @author fy916
     */
    private GameScores() {
        scoreCounter = 0;
        setScorePlace(-1);
        scoreBoardName = new ArrayList<String>();
        scoreBoardScore = new ArrayList<Integer>();
    }

    /**
     * Static Getter of the field
     * @return {@link ArrayList} type of scoreBoardName field
     * @author fy916
     */
    public static ArrayList<String> getScoreBoardName() {
        return scoreBoardName;
    }

    /**
     * Static Getter of the field
     * @return {@link ArrayList} type of scoreBoardScore field
     * @author fy916
     */
    public static ArrayList<Integer> getScoreBoardScore() {
        return scoreBoardScore;
    }

    /**
     * Static Getter of the field
     * @return integer type of current score
     * @author fy916
     */
    public static int getScoreCounter() {
        return scoreCounter;
    }

    /**
     * Static Method to Insert a score and the name into the leaderboard. <br/>
     * Demonstrates FACTORY Design Pattern.
     * Only if when the score is top10 will be added. <br/>
     * @param name The name for the player
     * @param score The score the player gets
     * @return the place of the user
     * @author fy916
     */
    public static int save_score(String name, int score) {
        //if scorePlace is -1, means that the player hasn't saved the score into the leaderboard yet
        //This check is to avoid repeating
        if(scorePlace > -1){
            //if the user already saved the score into the leaderboard, refresh it
            scoreBoardScore.remove(scorePlace);
            scoreBoardName.remove(scorePlace);
        }
        for (int i = 0; i < scoreBoardScore.size(); i++) {
            //add the score and name to the board
            if (scoreBoardScore.get(i) < score) {
                if (i > 0 && scoreBoardScore.get(i - 1) >= score || i == 0) {
                    scoreBoardScore.add(i, score);
                    scoreBoardName.add(i, name);
                    scorePlace = i; //note the user place in the score board
                    return i;
                }
            }
        }
        scoreBoardName.add(name);
        scoreBoardScore.add(score);
        scorePlace = scoreBoardScore.size() - 1; //if the user is not the top 10, add and return the place.
        return scorePlace;
    }

    /**
     * Static Method to add the score to the existing score. <br/>
     * @param score The score to be added to the original score.
     * @author fy916
     */
    public static void addScore(int score) {
        scoreCounter += score;
    }

    /**
     * Static Method to set the current player place in the leader board. <br/>
     * @param scorePlace The new place of the user in the leader board
     * @author fy916
     */
    public static void setScorePlace(int scorePlace) {
        GameScores.scorePlace = scorePlace;
    }

    /**
     * Static Method to reset the user score. <br/>
     * @author fy916
     */
    public static void resetScore() {
        scoreCounter=0;
    }
}
