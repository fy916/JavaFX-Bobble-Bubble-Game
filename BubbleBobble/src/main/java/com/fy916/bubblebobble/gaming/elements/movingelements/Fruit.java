package com.fy916.bubblebobble.gaming.elements.movingelements;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionFruit;


/**
 * The Fruit class handles how the fruit is created and interacts with the {@link Hero}.<br/>
 * It extends {@link MovingObject}.<br/>
 * The fruits are created after a bubble containing an {@link Enemy} is popped.
 */
public class Fruit extends MovingObject {
    private static final int SIZE = 20; //the size of the Fruit
    private static final int TERMINAL_VELOCITY_Y = 10;
    private static final int TERMINAL_VELOCITY_X = 10;
    private final int fruit_type;   // type of the fruit
    private boolean readyToCollect; // if the fruit is ready to be collected

    /**
     * Constructor that takes x, y coordinates to initialize the fruit, the location should be the dead enemy coordinates
     * @param world current game world
     * @param x the x coordinate of the object to be initialized
     * @param y the y coordinate of the object to be initialized
     * @author fy916
     */
    public Fruit(int x, int y, InteractableWorld world) {
        //initializes fruit
        super(x, y, SIZE, SIZE, world);
        setCollision(new CollisionFruit(this, world)); //initialize the Collision class, this shows Strategy Pattern
        //initialize the fruit property
        setTerminal_yVelocity(TERMINAL_VELOCITY_Y);
        setTerminal_xVelocity(TERMINAL_VELOCITY_X);
        setyAccel(InteractableWorld.getGRAVITY());
        set_yVelocity(-10);
        //the fruit direction is as the same as the hero when enemy is killed
        if (world.getWorldElements().getHero().get_xVelocity() > 0) {
            setxAccel(1.0 + 0.5 * Math.random());
        } else {
            setxAccel(-(1.0 + 0.5 * Math.random()));
        }
        setReadyToCollect(false);

        //randomly choose the outlook and type of the fruit
        if (Math.random() < 0.1) {
            fruit_type = 0;
        } else if (Math.random() < 0.3) {
            fruit_type = 1;
        } else if (Math.random() < 0.65) {
            fruit_type = 2;
        } else {
            fruit_type = 3;
        }
    }

    /**
     * Getter of the field
     * @return fruit_type field
     * @author fy916
     */
    public int get_fruit_type() { return fruit_type;}

    /**
     * Getter of the field
     * @return readyToCollect field
     * @author fy916
     */
    public boolean isReadyToCollect() {return readyToCollect;}

    /**
     * Setter of the field
     * @param readyToCollect the new status of readyToCollect
     * @author fy916
     */
    public void setReadyToCollect(boolean readyToCollect) {this.readyToCollect = readyToCollect;}
}
