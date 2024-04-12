package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;

/**
 * A subclass of {@link Collision} which is used for {@link WallUnit} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionWallUnit implements Collision{
    private WallUnit wallUnit;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param wallUnit the {@link WallUnit} object that to collide with
     * @author fy916
     */
    public CollisionWallUnit(WallUnit wallUnit, InteractableWorld world){
        this.wallUnit = wallUnit;
        this.world = world;
    }

    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the wall
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the wall
     * @param movingobj the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingobj) {
        double inp_x_center = (movingobj.getHitbox().getMaxX() + movingobj.getHitbox().getMinX()) / 2;
        double this_x_center = (wallUnit.getHitbox().getMaxX() + wallUnit.getHitbox().getMinX()) / 2;

        //if any moving object collides with the wall, move it back
        if (wallUnit.overlaps(movingobj)) {
            if (inp_x_center > this_x_center) {
                wallUnit.moveRightOfUnit(movingobj);
                movingobj.getCollision().collideWith(wallUnit);
            } else if (inp_x_center < this_x_center) {
                wallUnit.moveLeftOfUnit(movingobj);
                movingobj.getCollision().collideWith(wallUnit);
            } else {
                wallUnit.moveBelowUnit(movingobj);
                movingobj.getCollision().collideWith(wallUnit);
            }
        }
    }











}
