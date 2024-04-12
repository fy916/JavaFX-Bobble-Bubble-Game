package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;

/**
 * A subclass of {@link HeroStunnedState} which is used for {@link Hero} to be in the state of NOT stunned.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroNotStunnedState implements HeroStunnedState{
    private Hero hero;

    /**
     * @param hero the {@link Hero} object that is NOT stunned
     * @author fy916
     */
    public HeroNotStunnedState(Hero hero) {
        this.hero = hero;
    }

    /**
     * Method which updates the {@link Hero} when in NOT stunned state
     * @param hero the hero in the state
     * @author fy916
     */
    @Override
    public void stateUpdate(Hero hero) {
        //do nothing
    }
}
