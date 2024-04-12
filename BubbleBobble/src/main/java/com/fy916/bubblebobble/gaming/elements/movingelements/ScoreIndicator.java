package com.fy916.bubblebobble.gaming.elements.movingelements;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionScoreIndicator;

/**
 * A ScoreIndicator is the indicator that appears when a {@link Fruit} is picked by the hero showing the score this fruit provides.<br/>
 * It extends {@link MovingObject}.<br/>
 */
public class ScoreIndicator extends MovingObject {
    private static final int SIZE = 30;  //the size of the indicator
    private final int type;             //scores the indicator is showing

    /**
     * Constructor that takes x, y coordinates to initialize the fruit, the location should be the {@link Fruit} location
     * @param world current game world
     * @param x the x coordinate of the object to be initialized
     * @param y the y coordinate of the object to be initialized
     * @author fy916
     */
    public ScoreIndicator(int x, int y, InteractableWorld world, int fruit_type) {
        super(x, y, SIZE, SIZE, world);
        setCollision(new CollisionScoreIndicator(this, world)); //initialize the Collision class, this shows Strategy Pattern
        type = fruit_type;  //save the fruit type
        set_yVelocity(-5);
        setyAccel(0);
    }

    /**
     * Getter of the field
     * @return type field
     * @author fy916
     */
    public int get_type() {return type;}
}
