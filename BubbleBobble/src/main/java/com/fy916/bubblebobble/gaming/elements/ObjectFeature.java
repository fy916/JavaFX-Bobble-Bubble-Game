package com.fy916.bubblebobble.gaming.elements;

/**
 * A superclass intended to show the basic feature of any object in the game.
 * Includes the location and size of the object, and whether it can be removed.
 * @author fy916
 * @version 1.0
 */
public class ObjectFeature {
    private int x;
    private int y;        //coordinates of the object itself
    private int objectwidth;
    private int objectheight;  //object size
    private boolean canRemove;                  //if the object can be moved



    /**
     * Getter of the field
     * @return x field
     * @author fy916
     */
    public int getX() { return x; }

    /**
     * Getter of the field
     * @return y field
     * @author fy916
     */
    public int getY() { return y; }


    /**
     * Getter of the field
     * @return objectwidth field
     * @author fy916
     */
    public int getObjectwidth() { return objectwidth; }

    /**
     * Getter of the field
     * @return objectheight field
     * @author fy916
     */
    public int getObjectheight() { return objectheight; }

    /**
     * Getter of the field
     * @return canRemove field
     * @author fy916
     */
    public boolean isCanRemove() { return canRemove; }


    /**
     * Setter of the field
     * @param canRemove the new status of canRemove
     * @author fy916
     */
    public void setCanRemove(boolean canRemove) { this.canRemove = canRemove;}

    /**
     * Setter of the field
     * @param y the new status of y
     * @author fy916
     */
    public void setY(int y) { this.y = y;}

    /**
     * Setter of the field
     * @param x the new status of x
     * @author fy916
     */
    public void setX(int x) { this.x = x; }

    /**
     * Setter of the field
     * @param objectheight the new status of objectheight
     * @author fy916
     */
    public void setObjectheight(int objectheight) { this.objectheight = objectheight; }

    /**
     * Setter of the field
     * @param objectwidth the new status of objectwidth
     * @author fy916
     */
    public void setObjectwidth(int objectwidth) { this.objectwidth = objectwidth; }
}

