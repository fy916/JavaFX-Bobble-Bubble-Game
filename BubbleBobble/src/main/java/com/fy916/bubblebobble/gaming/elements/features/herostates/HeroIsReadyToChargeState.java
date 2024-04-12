package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.features.enemystates.EnemyBubbledState;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;

/**
 * A subclass of {@link HeroChargeState} which is used for {@link Hero} to be in the state of ready to charge.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroIsReadyToChargeState implements HeroChargeState{
    private Hero hero;

    /**
     * @param hero the {@link Hero} object that is ready to charge
     * @author fy916
     */
    public HeroIsReadyToChargeState(Hero hero) {
        this.hero = hero;
    }

    /**
     * Method which updates the {@link Hero} when in ready to charge state
     * @param hero the hero in the state
     * @author fy916
     */
    @Override
    public void stateUpdate(Hero hero) {
        //do nothing
    }
}
