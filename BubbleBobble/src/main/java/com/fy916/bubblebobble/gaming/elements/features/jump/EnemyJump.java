package com.fy916.bubblebobble.gaming.elements.features.jump;

import com.fy916.bubblebobble.gaming.elements.features.die.Die;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;

/**
 * A subclass of {@link Jump} which is used for {@link Enemy} to jump.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class EnemyJump implements  Jump{
    private Enemy enemy;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param enemy the {@link Enemy} object that jumps
     * @author fy916
     */
    public EnemyJump(Enemy enemy, InteractableWorld world){
        this.enemy = enemy;
        this.world= world;
    }

    /**
     * Method which perform the jump action of the enemy
     * @author fy916
     */
    @Override
    public void jump() {
        //handles jumping
        if (enemy.isOnAPlatform()) {
            enemy.setY(enemy.getY()-1);
            enemy.set_yVelocity(-enemy.getJumpSpeed());
            enemy.setOnAPlatform(false);
        }
    }
}
