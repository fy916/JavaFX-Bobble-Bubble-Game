package com.fy916.bubblebobble.gaming.elements;

import com.fy916.bubblebobble.gaming.elements.features.collision.Collision;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

/**
 * An abstract class which is extended from the {@link ObjectFeature},<br/>
 * this is intended to show the common features both a {@link com.fy916.bubblebobble.gaming.elements.mapelements.MapObject}
 * and a {@link com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject} have.
 * @author fy916
 * @version 1.0
 */
public abstract class GameObject extends ObjectFeature {
    private InteractableWorld world;
    private Collision collision; // Collision class since all elements can collide with others, this shows Strategy Pattern

    /**
     * Constructor that takes unit column and rows to initialize the object
     * @param world current game world
     * @param colNum the column of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param objectheight the height of the object
     * @param objectwidth the width of the object
     * @author fy916
     */
    public GameObject(InteractableWorld world, int colNum, int rowNum, int objectwidth, int objectheight) {
        //initialize the object
        this.world = world;
        setX( colNum * world.getUNIT_SIZE());
        setY( rowNum * world.getUNIT_SIZE());
        setObjectwidth(objectwidth);
        setObjectheight(objectheight); 
    }

    /**
     * Constructor that takes the coordinates of x and y of the object to initialize it
     * @param world current game world
     * @param x the x coordinate of the object to be initialized
     * @param y the y coordinate of the object to be initialized
     * @param objectheight the height of the object
     * @param objectwidth the width of the object
     * @author fy916
     */
    public GameObject(int x, int y, int objectwidth, int objectheight, InteractableWorld world) {
        //initializes the game object
        this.world = world;
        setX(x);
        setY(y);
        setObjectwidth(objectwidth);
        setObjectheight(objectheight);
    }

    /**
     * Sets that this object can be removed
     * @author fy916
     */
    public void markToRemove() {
        setCanRemove(true);
    }

    /**
     * Get a hitbox of the current objects, which is the rectangle that bounds the object itself
     * @return The hitbox of {@link Rectangle2D}
     * @author fy916
     */
    public Rectangle2D getHitbox() {
        //sets hitbox for each game object
        return new Rectangle2D(getX(), getY(), getObjectwidth(), getObjectheight());
    }

    /**
     * Check if the given object overlaps with the object itself
     * @param obj the given object
     * @return if or not they overlap
     * @author fy916
     */
    public boolean overlaps(GameObject obj) {
        //checks if two objects overlap or collide
        return getHitbox().intersects(obj.getHitbox());
    }

    /**
     * Check if the object itself is off the screen
     * @return if or not it is off the screen
     * @author fy916
     */
    public boolean isOffScreen() {
        //checks if something is offscreen
        boolean xLow = getX() + getObjectwidth() < 0;
        boolean xHigh = getX()  > world.getWidth();
        boolean yLow = getY()  + getObjectheight()< 0;
        boolean yHigh = getY() > world.getHeight();
        return xLow || xHigh || yLow || yHigh;
    }

    /**
     * Move the object to the new coordinates
     * @param point the {@link Point2D} point
     * @author fy916
     */
    public void moveTo(Point2D point) {
        //moves object to a point
        setX((int) point.getX());
        setY((int) point.getY());
    }


    /**
     * Getter of the field
     * @return collision field
     * @author fy916
     */
    public Collision getCollision() { return collision;}

    /**
     * Getter of the field
     * @return world field
     * @author fy916
     */
    public InteractableWorld getWorld() {return world;}

    /**
     * Setter of the field
     * @param world the game world
     * @author fy916
     */
    public void setWorld(InteractableWorld world) { this.world = world; }

    /**
     * Setter of the field
     * @param collision the game collision
     * @author fy916
     */
    public void setCollision(Collision collision) { this.collision = collision; }

}
