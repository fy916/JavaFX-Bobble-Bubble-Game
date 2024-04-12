package com.fy916.bubblebobble.gaming.elements.movingelements;

import com.fy916.bubblebobble.gaming.elements.GameObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.features.updater.GeneralLocationUpdater;
import com.fy916.bubblebobble.gaming.elements.features.updater.LocationUpdater;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.die.Die;
import com.fy916.bubblebobble.gaming.elements.features.jump.Jump;

/**
 * An abstract class which is extended from the {@link GameObject},
 * this is intended for the objects that will be moving around within the game world (unlinke {@link MapObject}).<br/>
 * This class contains some ability that the moving objects will have like velocity, acceleration, direction, {@link Die}, {@link Jump}, these properties shows the Stragety Design pattern.
 * @author fy916
 * @version 1.0
 */
public abstract class MovingObject extends GameObject {
    private double xVelocity;
    private double yVelocity;     //current speed
    private double xAccel;
    private double yAccel;             //acceleration
    private double terminal_xVelocity;
    private double terminal_yVelocity;   //the final speed the object will reach
    private int direction;                          //move direction

    private Die die; //Die class, which can be initialized by the hero or enemy
    private Jump jump;//Jump class, which can be initialized by the hero or enemy
    private LocationUpdater locationUpdater;//location updater, which can be initialized by the different subclass

    /**
     * Constructor that takes unit column and rows to initialize the object
     * @param world current game world
     * @param colNum the column of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param objectheight the height of the object
     * @param objectwidth the width of the object
     * @author fy916
     */
    public MovingObject(InteractableWorld world, int colNum, int rowNum, int objectwidth, int objectheight) {
        super(world, colNum, rowNum, objectwidth, objectheight);
        initializeValues();
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
    public MovingObject(int x, int y, int objectwidth, int objectheight, InteractableWorld world) {
        super(x, y, objectwidth, objectheight, world);
        initializeValues();
    }

    /**
     * Initialize the movingObject with some default property
     * @author fy916
     */
    public void initializeValues() {
        locationUpdater = new GeneralLocationUpdater(this, getWorld()); //set the location updater
        xVelocity = 0;
        yVelocity = 0;
        xAccel = 0;
        yAccel = InteractableWorld.getGRAVITY();
        terminal_xVelocity = 0;
        //object freefall
        terminal_yVelocity = InteractableWorld.getTerminalFallSpeed();
        setCanRemove(false);
        direction = -1;
    }

    /**
     * Reverse the direction of a moving object
     * @author fy916
     */
    public void reverseDirection() {
        //reverses game object's direction
        xAccel *= -1;
        direction *= -1;
    }


    /**
     * Getter of the field
     * @return xAccel field
     * @author fy916
     */
    public double get_xAccel() {return xAccel;}

    /**
     * Getter of the field
     * @return die field
     * @author fy916
     */
    public Die getDie() { return die; }

    /**
     * Getter of the field
     * @return jump field
     * @author fy916
     */
    public Jump getJump() {return jump;}

    /**
     * Getter of the field
     * @return yVelocity field
     * @author fy916
     */
    public double get_yVelocity() {return yVelocity;}

    /**
     * Getter of the field
     * @return xVelocity field
     * @author fy916
     */
    public double get_xVelocity() {return xVelocity;}

    /**
     * Getter of the field
     * @return xAccel field
     * @author fy916
     */
    public double getxAccel() {return xAccel;}

    /**
     * Getter of the field
     * @return yAccel field
     * @author fy916
     */
    public double getyAccel() {return yAccel;}

    /**
     * Getter of the field
     * @return terminal_xVelocity field
     * @author fy916
     */
    public double getTerminal_xVelocity() {return terminal_xVelocity;}

    /**
     * Getter of the field
     * @return terminal_yVelocity field
     * @author fy916
     */
    public double getTerminal_yVelocity() {return terminal_yVelocity;}

    /**
     * Getter of the field
     * @return direction field
     * @author fy916
     */
    public int getDirection() {return direction;}

    /**
     * Getter of the field
     * @return locationUpdater field
     * @author fy916
     */
    public LocationUpdater getLocationUpdater() {return locationUpdater;}

    /**
     * Setter of the field
     * @param locationUpdater the new status of locationUpdater
     * @author fy916
     */
    public void setLocationUpdater(LocationUpdater locationUpdater) {this.locationUpdater = locationUpdater;}

    /**
     * Setter of the field
     * @param inp the new status of xAccel
     * @author fy916
     */
    public void set_xAccel(double inp) {xAccel = inp;}

    /**
     * Setter of the field
     * @param inp the new status of terminal_xVelocity
     * @author fy916
     */
    public void set_terminal_xVelocity(double inp) {terminal_xVelocity = inp;}

    /**
     * Setter of the field
     * @param inp the new status of direction
     * @author fy916
     */
    public void set_direction(int inp) {direction = inp;}

    /**
     * Setter of the field
     * @param direction the new status of direction
     * @author fy916
     */
    public void setDirection(int direction) {this.direction = direction;}

    /**
     * Setter of the field
     * @param terminal_yVelocity the new status of terminal_yVelocity
     * @author fy916
     */
    public void setTerminal_yVelocity(double terminal_yVelocity) {this.terminal_yVelocity = terminal_yVelocity;}

    /**
     * Setter of the field
     * @param terminal_xVelocity the new status of terminal_xVelocity
     * @author fy916
     */
    public void setTerminal_xVelocity(double terminal_xVelocity) {this.terminal_xVelocity = terminal_xVelocity;}

    /**
     * Setter of the field
     * @param xVelocity the new status of xVelocity
     * @author fy916
     */
    public void set_xVelocity(double xVelocity) {this.xVelocity = xVelocity;}

    /**
     * Setter of the field
     * @param yAccel the new status of yAccel
     * @author fy916
     */
    public void setyAccel(double yAccel) {this.yAccel = yAccel;}

    /**
     * Setter of the field
     * @param xAccel the new status of xAccel
     * @author fy916
     */
    public void setxAccel(double xAccel) {this.xAccel = xAccel;}

    /**
     * Setter of the field
     * @param yVelocity the new status of yVelocity
     * @author fy916
     */
    public void set_yVelocity(double yVelocity) {this.yVelocity = yVelocity;}

    /**
     * Setter of the field
     * @param jump the new status of jump
     * @author fy916
     */
    public void setJump(Jump jump) {this.jump = jump;}

    /**
     * Setter of the field
     * @param die the new status of die
     * @author fy916
     */
    public void setDie(Die die) {this.die = die;}
}
