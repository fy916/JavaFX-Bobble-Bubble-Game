package com.fy916.bubblebobble.gaming.elements.features.enemystates;

import com.fy916.bubblebobble.gaming.elements.features.die.Die;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;

/**
 * A subclass of {@link EnemyBubbledState} which is used for {@link Enemy} to be in the state of bubbled.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class EnemyIsBubbedState implements EnemyBubbledState {
    private Enemy enemy;

    /**
     * @param enemy the {@link Enemy} object that in the bubbled state
     * @author fy916
     */
    public EnemyIsBubbedState(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * Method which updates the enemy when bubbled.
     * @param enemy the enemy in the bubbled state
     * @return if continues in the states, return true, else false
     * @author fy916
     */
    @Override
    public boolean stateUpdate(Enemy enemy) {
        enemy.setTimer(enemy.getTimer() - 1);        //count the time when the enemy is bubbled
        //if the enemy is not bubbled anymore
        if (enemy.getTimer() <= 0) { //reset the states to a movable enemy
            enemy.setFreeze(false);
            enemy.setBubbled(false);
            enemy.setTimer(Enemy.getBubbledFrames());
            enemy.setxAccel(1.5);
            enemy.setDirection(1);
            if (Math.random() < 0.5) {
                enemy.reverseDirection();
            }
            enemy.setyAccel(InteractableWorld.getGRAVITY());
            return false;
        }
        return true;
    }



}
