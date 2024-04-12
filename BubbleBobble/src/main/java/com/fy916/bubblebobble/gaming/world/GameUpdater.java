package com.fy916.bubblebobble.gaming.world;

import com.fy916.bubblebobble.utilities.LevelStatus;

import java.io.IOException;

/**
 * This class is used to call different methods from {@link ElementsRemover}, {@link ElementsUpdater} ,
 * {@link ElementsColliders} to update the location of {@link  com.fy916.bubblebobble.gaming.elements.GameObject}
 * from the {@link WorldElements}.<br/>
 * Demonstrates the FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class GameUpdater{
    private ElementsColliders elementsColliders;
    private ElementsUpdater elementsUpdater;
    private WorldElements worldElements;
    private ElementsRemover elementsRemover;

    /**
     * @param worldElements the {@link  WorldElements} list where the elements inside are updated
     * @author fy916
     */
    public GameUpdater (WorldElements worldElements){
        this.worldElements = worldElements;
        this.elementsRemover = worldElements.getElementsRemover();
        this.elementsColliders = new ElementsColliders(worldElements);
        this.elementsUpdater = new ElementsUpdater(worldElements);
    }

    /**
     * Update the position of {@link  com.fy916.bubblebobble.gaming.elements.GameObject} in {@link WorldElements}
     * @author fy916
     */
    public void updatePosition() {
        //updates positions of everything on screen
        elementsUpdater.updateElements(); //call elementsUpdater
        elementsColliders.collideElements(); //call elementsCollider
        elementsRemover.removeElements(); //call elementsRemover
        if (worldElements.getEnemies().isEmpty() && worldElements.getFruits().isEmpty() && worldElements.getScoreIndicators().isEmpty()) {
            //if there is no enemy, no boss and the fruits are picked, the player is win
            LevelStatus.setWin(true);
        }
    }

}
