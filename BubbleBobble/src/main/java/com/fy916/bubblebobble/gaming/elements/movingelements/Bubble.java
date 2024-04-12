package com.fy916.bubblebobble.gaming.elements.movingelements;

import com.fy916.bubblebobble.gaming.elements.features.updater.BubbleUpdater;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionBubble;


/**
 * The Bubble class handles everything with the Hero's special ability, named the bubble.<br/>
 * It extends {@link MovingObject}.<br/>
 * It begins at the {@link Hero}, and grows covering the whole screen.
 * Once it collides with an {@link Enemy}, that enemy is bubbled.
 */
public class Bubble extends MovingObject {
    //the acceleration of enlarging the bubble
    private int accel;

    /**
     * to initialize a Bubble
     * @param world current game world
     * @param x the x coordinate of the object to be initialized
     * @param y the y coordinate of the object to be initialized
     * @author fy916
     */
    public Bubble(InteractableWorld world, int x, int y) {
        super(x, y, 0, 0, world);
        setLocationUpdater(new BubbleUpdater(this, world)); //initialize location updater
        setCollision(new CollisionBubble(this, world)); //initialize collider
        setAccel(1);
    }

    /**
     * Getter of the field accel
     * @return field accel
     * @author fy916
     */
    public int getAccel() {return accel;}

    /**
     * Setter of the field accel
     * @param accel new acceleration to be set
     * @author fy916
     */
    public void setAccel(int accel) { this.accel = accel;}
}
