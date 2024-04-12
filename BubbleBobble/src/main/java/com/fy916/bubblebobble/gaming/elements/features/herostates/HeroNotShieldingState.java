package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;


/**
 * A subclass of {@link HeroShieldState} which is used for {@link Hero} to be in the state of NOT shielding.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroNotShieldingState implements HeroShieldState{
    private Hero hero;

    /**
     * @param hero the {@link Hero} object that is NOT shielding
     * @author fy916
     */
    public HeroNotShieldingState(Hero hero) {
        this.hero = hero;
    }

    /**
     * Method which updates the {@link Hero} when in NOT shielding state
     * @param hero the hero in the state
     * @author fy916
     */
    @Override
    public void stateUpdate(Hero hero) {
        //if not shielding, reset the timer slowly
        if (hero.getShieldTimer() < Hero.getSHIELD_TIME() && !hero.isStunned()) {
            hero.setShieldTimer(hero.getShieldTimer() + 1);
        }
    }
}
