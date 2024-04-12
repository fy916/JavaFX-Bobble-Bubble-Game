package com.fy916.bubblebobble.gaming.elements.mapelements;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionCeilingUnit;


/**
 * The CeilingUnit class creates ceiling units to be used for the world.<br/>
 * It extends {@link MapObject}.<br/>
 * A ceiling unit is a unit shaped like a square that is treated as a ceiling, with collision on all four sides.
 * The ceiling collides with any kind of game object.
 * Even if a game object is on top of a ceiling, the game object will be pushed down.
 */
public class CeilingUnit extends MapObject {
    //current game world
    private InteractableWorld world;

    /**
     * to initialize a CeilingUnit
     * @param world current game world
     * @param colNum the column of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @author fy916
     */
    public CeilingUnit(InteractableWorld world, int colNum, int rowNum) {
        super(world, colNum, rowNum, world.getUNIT_SIZE(), world.getUNIT_SIZE());
        setCollision(new CollisionCeilingUnit(this, world));
    }
}
