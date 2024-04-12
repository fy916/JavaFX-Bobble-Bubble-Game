package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.Fruit;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.utilities.SoundEffect;

/**
 * A subclass of {@link Collision} which is used for {@link Fruit} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionFruit implements Collision{
    private Fruit fruit;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param fruit the {@link Fruit} object that to collide with
     * @author fy916
     */
    public CollisionFruit(Fruit fruit, InteractableWorld world){
            this.fruit = fruit;
            this.world = world;
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the fruit
     * @param movingObject the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingObject) {
        if (movingObject instanceof Hero){//if collected by the hero
            if (fruit.overlaps(movingObject) && fruit.isReadyToCollect()) {
                SoundEffect.play_Fruit();
                fruit.setReadyToCollect(false);
                fruit.markToRemove();
            }
        }
    }

    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the fruit
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {
        if (mapObject instanceof FloorUnit) {
            //if the fruit falls on the ground, make it to be picked
            fruit.set_xVelocity(0);
            fruit.set_xAccel(0);
            fruit.set_yVelocity(0);
            if (!fruit.isCanRemove()) {
                fruit.setReadyToCollect(true);
            }
        }
    }
}
