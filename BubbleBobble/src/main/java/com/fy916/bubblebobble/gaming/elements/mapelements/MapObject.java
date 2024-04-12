package com.fy916.bubblebobble.gaming.elements.mapelements;

import com.fy916.bubblebobble.gaming.elements.GameObject;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import javafx.geometry.Point2D;

/**
 * An abstract class which is extended from the {@link GameObject}, this is intended for the objects that will not moving around within the game world (unlinke {@link com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject}).
 * This class contains some ability that the MapObject will have when colliding that to move the collided object to its side to avoid intersections.
 * @author fy916
 * @version 1.0
 */
public abstract class MapObject extends GameObject {

    /**
     * Constructor that takes unit column and rows to initialize the object
     * @param world current game world
     * @param colNum the column of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param objectheight the height of the object
     * @param objectwidth the width of the object
     * @author fy916
     */
    public MapObject(InteractableWorld world, int colNum, int rowNum, int objectwidth, int objectheight) {
        super(world, colNum, rowNum, objectwidth, objectheight);
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
    public MapObject(int x, int y, int objectwidth, int objectheight, InteractableWorld world) {
        super(x, y, objectwidth, objectheight, world);
    }

    /**
     * Move the object of parameter to the top of the object itself
     * @param obj the object to be moved
     * @author fy916
     * @version 1.0
     */
    public void moveAboveUnit(GameObject obj) {obj.moveTo(new Point2D(obj.getX(), getY() - obj.getObjectheight()));}

    /**
     * Move the object of parameter to the bottom of the object itself
     * @param obj the object to be moved
     * @author fy916
     * @version 1.0
     */
    public void moveBelowUnit(GameObject obj) {obj.moveTo(new Point2D(obj.getX(), getY() + this.getObjectheight()));}

    /**
     * Move the object of parameter to the left of the object itself
     * @param obj the object to be moved
     * @author fy916
     * @version 1.0
     */
    public void moveLeftOfUnit(GameObject obj) {obj.moveTo(new Point2D(getX() - obj.getObjectwidth(), obj.getY()));}

    /**
     * Move the object of parameter to the right of the object itself
     * @param obj the object to be moved
     * @author fy916
     * @version 1.0
     */
    public void moveRightOfUnit(GameObject obj) {obj.moveTo(new Point2D(getX() + obj.getObjectwidth(), obj.getY()));}
}
