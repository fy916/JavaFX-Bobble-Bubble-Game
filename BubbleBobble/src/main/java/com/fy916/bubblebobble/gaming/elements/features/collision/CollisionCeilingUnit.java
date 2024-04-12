package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;

/**
 * A subclass of {@link Collision} which is used for {@link CeilingUnit} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionCeilingUnit implements Collision{
    private CeilingUnit ceilingUnit;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param ceilingUnit the {@link CeilingUnit} object that to collide with
     * @author fy916
     */
    public CollisionCeilingUnit(CeilingUnit ceilingUnit, InteractableWorld world){
            this.ceilingUnit = ceilingUnit;
            this.world = world;
    }

    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the ceilingUnit
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the ceilingUnit
     * @param movingobj the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingobj) {
        //if other moving objects hits the ceiling, move it below the ceiling
        if (ceilingUnit.overlaps(movingobj)) {
            movingobj.getCollision().collideWith(ceilingUnit);
            ceilingUnit.moveBelowUnit(movingobj);
        }
    }
}
