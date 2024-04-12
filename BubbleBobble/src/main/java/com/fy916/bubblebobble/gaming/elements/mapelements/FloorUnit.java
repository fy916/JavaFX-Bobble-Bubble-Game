package com.fy916.bubblebobble.gaming.elements.mapelements;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionFloorUnit;


/**
 * The FloorUnit class creates floor units to be used for the world.<br/>
 * It extends {@link MapObject}.<br/>
 * A floor unit is a unit shaped like a square that is treated as a floor,
 * with collision on the top, left, and right sides.
 * The floor collides with any kind of game object.
 * When an enemy is bubbled, the enemy will still be stopped by a floor unit above it.
 */
public class FloorUnit extends MapObject {
    //current game world
    private InteractableWorld world;

    /**
     * initialize a FloorUnit
     * @param world current game world
     * @param colNum the column of location of the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location of the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @author fy916
     */
    public FloorUnit(InteractableWorld world, int colNum, int rowNum) {
        super(world, colNum, rowNum, world.getUNIT_SIZE(), world.getUNIT_SIZE());
        setCollision(new CollisionFloorUnit(this, world));
    }




}
