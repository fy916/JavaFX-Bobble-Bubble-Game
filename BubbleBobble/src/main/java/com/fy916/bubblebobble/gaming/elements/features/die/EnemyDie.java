package com.fy916.bubblebobble.gaming.elements.features.die;

import com.fy916.bubblebobble.gaming.elements.features.collision.Collision;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.world.ElementsAdder;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Fruit;

/**
 * A subclass of {@link Die} which is used for {@link Enemy} to die.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class EnemyDie implements Die {
    private Enemy enemy; //the enemy to die
    private InteractableWorld world;
    private ElementsAdder elementsAdder;

    /**
     * @param world current game {@link InteractableWorld}
     * @param enemy the {@link Enemy} object that dies
     * @author fy916
     */
    public EnemyDie(Enemy enemy, InteractableWorld world){
        this.enemy = enemy;
        this.world= world;
        elementsAdder = world.getWorldElements().getElementsAdder();
    }

    /**
     * Method which perform the die action of the enemy
     * @author fy916
     */
    @Override
    public void die() {
        elementsAdder.addFruit(new Fruit(enemy.getX(), enemy.getY(), world));
        //if the enemy is boss, add more fruits
        if (enemy.check_isBoss()) {
            elementsAdder.addFruit(new Fruit(enemy.getX(), enemy.getY(), world));
            elementsAdder.addFruit(new Fruit(enemy.getX(), enemy.getY(), world));
        }
        enemy.markToRemove(); //now can be removed
    }
}
