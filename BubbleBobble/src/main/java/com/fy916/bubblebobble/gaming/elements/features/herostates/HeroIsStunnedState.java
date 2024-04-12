package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;


/**
 * A subclass of {@link HeroStunnedState} which is used for {@link Hero} to be in the state of stunned.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroIsStunnedState implements HeroStunnedState{
    private Hero hero;

    /**
     * @param hero the {@link Hero} object that is stunned
     * @author fy916
     */
    public HeroIsStunnedState(Hero hero) {
        this.hero = hero;
    }

    /**
     * Method which updates the {@link Hero} when in stunned state
     * @param hero the hero in the state
     * @author fy916
     */
    @Override
    public void stateUpdate(Hero hero) {
        hero.set_xVelocity(0);
        //update the timer
        hero.setStunTimer(hero.getStunTimer() - 1);
        if (hero.getStunTimer() <= 0) { //if no longer stunned
            hero.setStunned(false);
            hero.setStunTimer(Hero.getSTUN_TIME()); //reset the stun time
            hero.setShieldTimer(Hero.getSHIELD_TIME()); // reset the shield time
        }
    }
}
