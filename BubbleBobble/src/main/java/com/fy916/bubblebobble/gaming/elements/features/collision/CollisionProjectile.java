package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.gaming.elements.movingelements.Projectile;

/**
 * A subclass of {@link Collision} which is used for {@link Projectile} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionProjectile implements Collision{
    private Projectile projectile;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param projectile the {@link Projectile} object that to collide with
     * @author fy916
     */
    public CollisionProjectile(Projectile projectile, InteractableWorld world){
        this.projectile = projectile;
        this.world = world;
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the projectile
     * @param movingObject the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingObject) {
        //if the hero projectile collides with the enemy
        if (projectile.getProjectile_Type() == 0) {
            if (movingObject instanceof Enemy) {
                if (projectile.overlaps(movingObject) && projectile.check_isActive()) {
                    movingObject.getCollision().collideWith(projectile);
                    projectile.markToRemove();
                }
            }
        } else { // if the enemy projectile collides with the hero
            if (movingObject instanceof Hero) {
                if (projectile.overlaps(movingObject) &&projectile.check_isActive()) {
                    movingObject.getCollision().collideWith(projectile);
                    projectile.markToRemove();
                }
            }
        }
    }

    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the projectile
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {
        //if the projectile hits the ceiling
        if (mapObject instanceof CeilingUnit) {
            projectile.markToRemove();
        }
        if (mapObject instanceof WallUnit) {
            //if the projectile hits the wall
            projectile.setActive(false);
        }
    }
}
