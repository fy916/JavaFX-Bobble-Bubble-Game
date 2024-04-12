package com.fy916.bubblebobble.gaming.elements.features.updater;

import com.fy916.bubblebobble.gaming.elements.features.die.Die;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.features.enemystates.EnemyIsBubbedState;
import com.fy916.bubblebobble.gaming.elements.features.enemystates.EnemyNotBubbledState;
import com.fy916.bubblebobble.gaming.elements.features.enemystates.EnemyBubbledState;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.utilities.SoundEffect;

/**
 * A subclass of {@link GeneralLocationUpdater} which extends it to illustrate the {@link Enemy} location updater.<br/>
 * This shows the STRATEGY, STATES and TEMPLATE Design Pattern.
 * @author fy916
 */
public class EnemyUpdater extends GeneralLocationUpdater{
    private Enemy enemy;
    private EnemyBubbledState enemyBubbledStates;   // the states of the enemy

    /**
     * @param interactableWorld current game {@link InteractableWorld}
     * @param movingObject the {@link MovingObject} object that to have its location updated.
     *                     (should be downcasted to {@link Enemy} later).
     * @author fy916
     */
    public EnemyUpdater(MovingObject movingObject, InteractableWorld interactableWorld) {
        super(movingObject, interactableWorld); //call the super to construct the general location updater
        this.movingObject = movingObject;      //set the moving object
        this.world = interactableWorld;
        enemy = (Enemy) movingObject;          //downcast the MovingObject to Enemy
        this.enemyBubbledStates = new EnemyNotBubbledState(this.enemy);
    }

    /**
     * Method which perform the update action of the enemy, where it shows  STATES Design Pattern.
     * @author fy916
     */
    @Override
    public void update() {
        //updates enemy, handling movement
        if (!enemy.isFreeze()) { //if it is not freeze, can update the location
            super.update();
        }
        //update the bubbled states
        enemyBubbledStates.stateUpdate(this.enemy);
        if (enemy.isBubbled() && enemyBubbledStates instanceof EnemyNotBubbledState) {
            //if it was in NOT bubbled state but now it should be bubbled, switch states
            enemyBubbledStates = new EnemyIsBubbedState(this.enemy);
        }else if (!enemy.isBubbled() && enemyBubbledStates instanceof EnemyIsBubbedState){
            //if it was in bubbled state but now it should NOT be buubbled, switch states
            enemyBubbledStates = new EnemyNotBubbledState(this.enemy);
        }

        if (enemy.getBoss_health() <= 0 && enemy.isIs_boss()) { //if the enemy is boss and run out of health
            SoundEffect.play_Pop();
            enemy.getDie().die();
        }
    }
}
