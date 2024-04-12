package com.fy916.bubblebobble.gaming.elements.mapelements;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionWallUnit;

/**
 * The WallUnit class creates wall units to be used for the world.<br/>
 * It extends {@link MapObject}.<br/>
 * A wall unit is an unit shaped like a square that is treated as a wall.
 * with collision on all four sides.
 * The wall collides with any kind of game object.
 */
public class WallUnit extends MapObject {
    private InteractableWorld world;

    /**
     * initialize a WallUnit
     * @param world current game world
     * @param colNum the column of location of the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location of the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @author fy916
     */
    public WallUnit(InteractableWorld world, int colNum, int rowNum) {
        super(world, colNum, rowNum, world.getUNIT_SIZE(), world.getUNIT_SIZE());
        setCollision(new CollisionWallUnit(this, world));
    }
}
