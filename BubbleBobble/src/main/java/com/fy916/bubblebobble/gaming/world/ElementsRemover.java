package com.fy916.bubblebobble.gaming.world;

import com.fy916.bubblebobble.gaming.elements.GameObject;

/**
 * This class is used to provide methods to remove elements from the {@link WorldElements}.<br/>
 * Demonstrates Single Responsibility. 
 * @author fy916
 * @version 1.0
 */
public class ElementsRemover {
    private WorldElements worldElements;//the element list the element to be removed from

    /**
     * @param worldElements the {@link  WorldElements} list where element to be removed from
     * @author fy916
     */
    public ElementsRemover(WorldElements worldElements){
        this.worldElements = worldElements;
    }

    /**
     * Remove elements that are to be removed in the ToBeRemoved {@link java.util.ArrayList} in {@link WorldElements}
     * @author fy916
     */
    void removeElements(){
    // Removing...
    for (GameObject obj : worldElements.getToBeRemoved()) { // remove element from the arraylist
        remove(obj);
    }
        worldElements.getToBeRemoved().removeAll(worldElements.getToBeRemoved()); //empty the toBeRemoved arraylist
    }

    /**
     * Remove all elements in {@link WorldElements}
     * @author fy916
     */
    void clearContents() {
        //clears everything from the screen
        worldElements.getCeilingUnits().removeAll(worldElements.getCeilingUnits());
        worldElements.getFloorUnits().removeAll(worldElements.getFloorUnits());
        worldElements.getWallUnits().removeAll(worldElements.getWallUnits());
        worldElements.setHero(null);
        worldElements.getEnemies().removeAll(worldElements.getEnemies());
        worldElements.getProjectiles().removeAll(worldElements.getProjectiles());
        worldElements.getFruits().removeAll(worldElements.getFruits());
    }

    /**
     * Remove single element from {@link WorldElements}
     * @param obj the object to be moved
     * @author fy916
     */
    public void remove(GameObject obj) {
        //removes a single object from the screen
        worldElements.getCeilingUnits().remove(obj);
        worldElements.getFloorUnits().remove(obj);
        worldElements.getWallUnits().remove(obj);
        worldElements.getEnemies().remove(obj);
        worldElements.getProjectiles().remove(obj);
        worldElements.getFruits().remove(obj);
        worldElements.getBubbles().remove(obj);
        worldElements.getScoreIndicators().remove(obj);
    }
}
