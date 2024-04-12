package com.fy916.bubblebobble.gaming.elements.features.enemystates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Projectile;
import com.fy916.bubblebobble.utilities.GameStatus;

/**
 * A subclass of {@link EnemyBubbledState} which is used for {@link Enemy} to be NOT in the state of bubbled.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class EnemyNotBubbledState implements EnemyBubbledState {
    private Enemy enemy;

    /**
     * @param enemy the {@link Enemy} object that in the NOT bubbled state
     * @author fy916
     */
    public EnemyNotBubbledState(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * Method which updates the enemy when NOT bubbled.
     * @param enemy the enemy in the NOT bubbled state
     * @return always return true
     * @author fy916
     */
    @Override
    public boolean stateUpdate( Enemy enemy) {
        //randomly jump
        if (Math.random() < Enemy.getChangeMovementChance() && enemy.isOnAPlatform()) {
            enemy.getJump().jump();
        }
        //randomly reverse direction
        if (Math.random() < Enemy. getChangeMovementChance()) {
            enemy.reverseDirection();
        }
        //randomly shoot projectile
        if (Math.random() < (GameStatus.getDifficultyCoefficient() + 1) * 0.004 && enemy.isOnAPlatform()) {
            //choose the type of the projectile to shoot
            if (enemy.isIs_boss()) {
                enemy.getWorld().getWorldElements().getElementsAdder().addProjectile(new Projectile(enemy.getWorld(), enemy.getX(), enemy.getY(), enemy.getDirection(), 2, true));
            } else {
                enemy.getWorld().getWorldElements().getElementsAdder().addProjectile(new Projectile(enemy.getWorld(), enemy.getX(), enemy.getY(), enemy.getDirection(), 1));
            }
        }
        return true;
    }
}
