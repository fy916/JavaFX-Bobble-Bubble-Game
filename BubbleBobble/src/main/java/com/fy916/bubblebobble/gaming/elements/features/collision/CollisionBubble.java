package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.Bubble;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;

/**
 * A subclass of {@link Collision} which is used for {@link Bubble} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionBubble implements Collision{
    private Bubble bubble;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param bubble the {@link Bubble} object that to collide with
     * @author fy916
     */
    public CollisionBubble(Bubble bubble, InteractableWorld world){
        this.bubble = bubble;
        this.world = world;
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the Bubble
     * @param movingObject the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingObject) {
        //if the bubble hits an enemy, bubble the enemy
        if (movingObject instanceof Enemy) {
            if (bubble.overlaps(movingObject)) {
                movingObject.getCollision().collideWith(bubble);
            }
        }
    }

    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the Bubble
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {

    }
}
