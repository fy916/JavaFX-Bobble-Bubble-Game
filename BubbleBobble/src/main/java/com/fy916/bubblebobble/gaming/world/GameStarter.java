package com.fy916.bubblebobble.gaming.world;

import com.fy916.bubblebobble.Main;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.utilities.GameStatus;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This class is used to provide methods to read the files and start the game according to the level.
 * Demonstrates Single Responsibility. 
 * @author fy916
 * @version 1.0
 */
public class GameStarter {
    private WorldElements worldElements;  //the element list of the game elements

    /**
     * @param worldElements the {@link  WorldElements} list where elements are stored in
     * @author fy916
     */
    public GameStarter(WorldElements worldElements){
        this.worldElements = worldElements;
    }

    /**
     * @param level the level of the game to be read from the external files
     * @exception IOException may throw {@link  IOException} since the method reads from the external files.
     * @author fy916
     */
    public void startGame(int level) throws IOException {
        //initialize the input buffered reader
        InputStream input = Main.class.getResourceAsStream("world/World" + level + ".txt");
        Scanner scanner = new Scanner(input);
        worldElements.getElementsRemover().clearContents(); //clear the elements list
        boolean boss_added = false;
        //read data from the files to place the wall, ceiling, floor, hero and enemy
        for (int row = 0; row < worldElements.getWorld().getUNIT_HEIGHT(); row++) {
            String currentLine = scanner.next();
            for (int col = 0; col < worldElements.getWorld().getUNIT_WIDTH(); col++) {
                if (currentLine.charAt(col) == '*') {
                    worldElements.getElementsAdder().addFloorUnit(new FloorUnit(worldElements.getWorld(), col, row));
                } else if (currentLine.charAt(col) == 'H') {
                    worldElements.getElementsAdder().addHero(new Hero(worldElements.getWorld(), col, row));
                } else if (currentLine.charAt(col) == '|') {
                    worldElements.getElementsAdder().addWallUnit(new WallUnit(worldElements.getWorld(), col, row));
                } else if (currentLine.charAt(col) == '_') {
                    worldElements.getElementsAdder(). addCeilingUnit(new CeilingUnit(worldElements.getWorld(), col, row));
                } else if (currentLine.charAt(col) == 'M') {
                    //if the difficulty is high, make boss appear earlier
                    if (level > 4- GameStatus.getDifficulty() && !boss_added) {
                        worldElements.getElementsAdder().  addEnemy(new Enemy(worldElements.getWorld(), col, row, true));
                        boss_added = true;
                    } else {
                        worldElements.getElementsAdder().addEnemy(new Enemy(worldElements.getWorld(), col, row));
                    }
                }
            }
            if (scanner.hasNextLine()) {
                //keep reading
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
