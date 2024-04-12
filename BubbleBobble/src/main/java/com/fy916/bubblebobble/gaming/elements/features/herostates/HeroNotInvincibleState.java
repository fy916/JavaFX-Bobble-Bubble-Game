package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;

/**
 * A subclass of {@link HeroInvincibleState} which is used for {@link Hero} to be in the state of NOT invincible.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroNotInvincibleState implements HeroInvincibleState {
    private Hero hero;

    /**
     * @param hero the {@link Hero} object that is NOT invincible
     * @author fy916
     */
    public HeroNotInvincibleState(Hero hero) {
        this.hero = hero;
    }

    /**
     * Method which updates the {@link Hero} when in NOT invincible state
     * @param hero the hero in the state
     * @author fy916
     */
    @Override
    public void stateUpdate(Hero hero) {
        //do nothing
    }
}
