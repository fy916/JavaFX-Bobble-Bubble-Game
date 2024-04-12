package com.fy916.bubblebobble.gaming.elements.features.enemystates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;

/**
 * An Interface which offers the Bubbled state method framework for {@link Enemy}.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public interface EnemyBubbledState {

    /**
     * Abstract Method which updates the state of the {@link Enemy} when bubbled or not.
     * @author fy916
     */
    abstract boolean stateUpdate(Enemy enemy);
}
