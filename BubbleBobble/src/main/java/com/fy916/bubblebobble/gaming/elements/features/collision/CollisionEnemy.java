package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.Bubble;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.gaming.elements.movingelements.Projectile;
import com.fy916.bubblebobble.utilities.GameStatus;
import com.fy916.bubblebobble.utilities.SoundEffect;

/**
 * A subclass of {@link Collision} which is used for {@link Enemy} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionEnemy implements Collision{
    private Enemy enemy;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param enemy the {@link Enemy} object that to collide with
     * @author fy916
     */
    public CollisionEnemy(Enemy enemy, InteractableWorld world){
        this.enemy = enemy;
        this.world = world;
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the enemy
     * @param movingObject the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingObject) {
        //if collide with the hero
        if (movingObject instanceof Hero) {
            if (enemy.overlaps(movingObject)) {
                //handles collision with hero and what to do
                if (!enemy.isBubbled()) {
                    //if the enemy is not bubbled, hero will be hurt
                    movingObject.getCollision().collideWith(enemy);
                    //if the hero is shielding, turn away from it
                    if (((Hero) movingObject).isShielding() && !enemy.isTurningAwayFromShield()) {
                        enemy.setTurningAwayFromShield(true);
                        enemy.reverseDirection();
                    }
                } else if (!enemy.isCanRemove()) { //if the hero is dead
                    SoundEffect.play_Pop();
                    enemy.getDie().die();
                }
            }
            //if enemy is leaving the shield, keep the timer counting
            if (enemy.isTurningAwayFromShield()) {
                if (enemy.getTurningAwayCount() <= 0) {
                    enemy.setTurningAwayCount(10);
                    enemy.setTurningAwayFromShield(false);
                }
                enemy.setTurningAwayCount(enemy.getTurningAwayCount() - 1);
            }
        }

        if (movingObject instanceof Projectile) {
            //if the enemy collides with the projectile
            if (((Projectile) movingObject).getProjectile_Type() == 0) {
                //handles what to do if hit with a projectile by the hero
                if (!enemy.isBubbled() && !enemy.isIs_boss()) { // bubble the enemy
                    SoundEffect.play_Bubbled();
                    enemy.setBubbled(true);
                    enemy.set_xVelocity(0);
                    enemy.set_yVelocity(0);
                    enemy.setxAccel(0);
                    enemy.setyAccel(0);
                }
                if (!enemy.isBubbled() && enemy.isIs_boss() && enemy.getBoss_health() > 0) { //projectile hits the boss
                    enemy.setBoss_health((int) (enemy.getBoss_health() - (10 - 5 * GameStatus.getDifficultyCoefficient())));
                }
            }
        }
        //if the enemy is hit by the bubble
        if (movingObject instanceof Bubble) {
            enemy.setBubbled(true);
            enemy.set_xVelocity(0);
            enemy.set_yVelocity(-5);
            enemy.setxAccel(0);
            enemy.setyAccel(0);
        }
    }

    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the enemy
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {
        if (!enemy.isFreeze()) {
            //if the enemy hits the ceiling
            if (mapObject instanceof CeilingUnit) {
                if (enemy.isBubbled()) {
                    enemy.set_yVelocity(0);
                    enemy.setyAccel(0);
                }
            }

            //if the enemy hits the floor
            if (mapObject instanceof FloorUnit) {
                //handles unit collision
                enemy.set_yVelocity(0);
                if (enemy.isBubbled()) {
                    enemy.setFreeze(true);
                }
                if (!enemy.isOnAPlatform()) {// mark is on the platform
                    enemy.setOnAPlatform(true);
                }
            }

            //if the enemy hits the wall, change direction
            if (mapObject instanceof WallUnit) {
                enemy.reverseDirection();
            }
        }
    }
}
