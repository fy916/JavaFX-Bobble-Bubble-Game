package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;

/**
 * A subclass of {@link HeroShieldState} which is used for {@link Hero} to be in the state of shielding.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroIsShieldingState implements HeroShieldState{
    private Hero hero;

    /**
     * @param hero the {@link Hero} object that is shielding
     * @author fy916
     */
    public HeroIsShieldingState(Hero hero) {
        this.hero = hero;
    }

    /**
     * Method which updates the {@link Hero} when in shielding state
     * @param hero the hero in the state
     * @author fy916
     */
    @Override
    public void stateUpdate(Hero hero) {
        //update the timer
        hero.setShieldTimer(hero.getShieldTimer() - 1);
        if (hero.getShieldTimer() <= 0) {//if no longer shielding
            hero.setShieldTimer(0);
            hero.setShielding(false);
            hero.setStunned(true);//set the hero stunned for a while
        }
    }
}
