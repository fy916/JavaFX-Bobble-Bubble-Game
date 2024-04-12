package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;

/**
 * An Interface which offers the colliding methods framework, since the objects in the game world all can collide with each other.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public interface Collision {
    /**
     * Abstract method which takes an {@link MapObject} type of object and perform colliding actions.
     * @param mapObject the {@link MapObject} type of object to be collided.
     * @author fy916
     */
    abstract void collideWith(MapObject mapObject);

    /**
     * Abstract method which takes an {@link MovingObject} type of object and perform colliding actions.
     * @param movingObject the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    abstract void collideWith(MovingObject movingObject);
}
