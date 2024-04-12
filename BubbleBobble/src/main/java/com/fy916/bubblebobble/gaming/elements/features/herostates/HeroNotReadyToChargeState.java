package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;

/**
 * A subclass of {@link HeroChargeState} which is used for {@link Hero} to be in the state of NOT ready to charge.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroNotReadyToChargeState implements HeroChargeState {
    private Hero hero;

    /**
     * @param hero the {@link Hero} object that is NOT ready to charge
     * @author fy916
     */
    public HeroNotReadyToChargeState(Hero hero) {
        this.hero = hero;
    }

    /**
     * Method which updates the {@link Hero} when in NOT ready to charge state
     * @param hero the hero in the state
     * @author fy916
     */
    @Override
    public void stateUpdate(Hero hero) {
        //update the timer
        hero.setChargeTimer(hero.getChargeTimer() - 1);
        if (hero.getChargeTimer() < 0) {//if now is ready to charge
            hero.setChargeTimer(hero.getORIGINAL_CHARGE_TIME());
            hero.setReadyToCharge(true);
        }
    }
}
