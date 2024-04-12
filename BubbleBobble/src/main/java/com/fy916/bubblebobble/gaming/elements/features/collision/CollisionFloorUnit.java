package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;

/**
 * A subclass of {@link Collision} which is used for {@link FloorUnit} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionFloorUnit implements Collision{
    private FloorUnit floorUnit;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param floorUnit the {@link FloorUnit} object that to collide with
     * @author fy916
     */
    public CollisionFloorUnit(FloorUnit floorUnit, InteractableWorld world){
            this.floorUnit = floorUnit;
            this.world = world;
    }


    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the floor unit
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {//empty method, overrides the superclass method
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the floor unit
     * @param movingobj the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingobj) {
        double top = movingobj.getY();
        double bottom = top + movingobj.getObjectheight();
        //if the object is on the floor, move it on the top of the unit
        if (floorUnit.overlaps(movingobj) && movingobj.get_yVelocity() >= 0) {
            if (bottom <= floorUnit.getY() + floorUnit.getObjectheight()) {
                floorUnit.moveAboveUnit(movingobj);
                movingobj.getCollision().collideWith(floorUnit);
            }
            if (top > floorUnit.getY()) {
                floorUnit.moveBelowUnit(movingobj);
                movingobj.getCollision().collideWith(floorUnit);
            }
        }
        //if the object is coming from the bottom of the floor, only stops the bubbled enemy
        if (movingobj instanceof Enemy && ((Enemy) movingobj).isBubbled() && !((Enemy) movingobj).isFreeze()) {
            if (floorUnit.overlaps(movingobj)) {
                movingobj.getCollision().collideWith(floorUnit);
                floorUnit.moveBelowUnit(movingobj);
            }
        }
    }
}
