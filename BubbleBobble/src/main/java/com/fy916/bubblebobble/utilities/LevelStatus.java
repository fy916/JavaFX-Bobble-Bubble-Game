package com.fy916.bubblebobble.utilities;

/**
 * This class includes some utilities that facilitate noting the game winning status such as win, lose and victory,
 * along with some methods that provides to set the field. <br/>
 * Demonstrates Single Responsibility, SINGLETON Design Pattern.
 * @author fy916
 */
public class LevelStatus {
    //static fields saving the data
    private static boolean win;
    private static boolean lose;
    private static boolean victory;

    //the only instance of the class
    private static  final LevelStatus INSTANCE = new LevelStatus();
    private LevelStatus(){
        resetWinningStatus();
    }

    /**
     * Private constructor which initializes the winning status data. <br/>
     * Demonstrates SINGLETON Design Pattern.
     * @author fy916
     */
    public static void resetWinningStatus(){
        //set not win, lose or victory
        setWin(false);
        setLose(false);
        setVictory(false);
    }

    /**
     * Static Method to Get the status of the game winning states.<br/>
     * @return 2 if victory, 1 if win, 0 if lose and -1 if the game should continue.<br/>
     * Demonstrates SINGLETON Design Pattern.
     * @return an Instance of the {@link GameStatus}
     * @author fy916
     */
    public static int getGameWinningStatus(){
        //if the player reaches the top level
        if (win && GameStatus.getLevel() == GameStatus.getTotalLevel()){
            victory = true;
        }
        //if victory, then reset the status
        if (victory) {
            LevelStatus.resetWinningStatus();
            return 2;
        }
        //if win, then level +1
        if (win) {
            LevelStatus.resetWinningStatus();
            GameStatus.setLevel(GameStatus.getLevel() + 1);
            return 1;
        }
        //if lose, then reset the status
        if (lose) {
            LevelStatus.resetWinningStatus();
            return 0;
        }
        //if the game should continue
        return -1;
    }

    /**
     * Static Method to Notify the status that the hero is dead. <br/>
     * If the hero still has lives left, the lives will be deducted 1, otherwise the player loses
     * @author fy916
     */
    public static void hero_dead() {
        //the lives -1
        GameStatus.setLives(GameStatus.getLives() - 1);
        if (GameStatus.getLives() == 0) { //if the player has no lives left
            setLose(true);
        }
    }

    /**
     * Static Method to set the win field <br/>
     * @param win The new win status to be saved in the field
     * @author fy916
     */
    public static void setWin(boolean win) {
        LevelStatus.win = win;
    }

    /**
     * Static Method to set the lose field <br/>
     * @param lose The lose win status to be saved in the field
     * @author fy916
     */
    public static void setLose(boolean lose) {
        LevelStatus.lose = lose;
    }

    /**
     * Static Method to set the victory field <br/>
     * @param victory The new victory status to be saved in the field
     * @author fy916
     */
    public static void setVictory(boolean victory) {
        LevelStatus.victory = victory;
    }

}


