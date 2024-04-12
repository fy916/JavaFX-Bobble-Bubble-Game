package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.gaming.elements.movingelements.Projectile;
import com.fy916.bubblebobble.utilities.SoundEffect;

/**
 * A subclass of {@link Collision} which is used for {@link Hero} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionHero implements Collision{
    private Hero hero;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param hero the {@link Hero} object that to collide with
     * @author fy916
     */
    public CollisionHero(Hero hero, InteractableWorld world){
        this.hero = hero;
        this.world = world;
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the Hero
     * @param movingObject the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingObject) {
        //if the hero is hit by the enemy projectile
        if (movingObject instanceof Projectile) {
            if (((Projectile) movingObject).getProjectile_Type() >= 1) {
                if (!hero.isShielding() && !hero.isInvincible_dead()) {
                    hero.getDie().die();
                }
            }
        }

        //if the hero collides with the enemy
        if (movingObject instanceof Enemy) {
            if (!hero.isShielding() && !hero.isInvincible_dead()) {
                hero.getDie().die();
            }
        }
    }

    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the Hero
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {
        //if the hero reaches the floor
        if (mapObject instanceof FloorUnit) {
            hero.set_yVelocity(0);
            if (!hero.isOnAPlatform()) {
                hero.setOnAPlatform(true);
                SoundEffect.play_Land();
            }
        }

        //if the hero collides with the wall
        if (mapObject instanceof WallUnit) {
            hero.set_xVelocity(0);
        }
    }
}
