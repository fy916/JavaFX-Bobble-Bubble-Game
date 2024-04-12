package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;

/**
 * A subclass of {@link HeroInvincibleState} which is used for {@link Hero} to be in the state of invincible.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroIsInvincibleState implements HeroInvincibleState {
    private Hero hero;

    /**
     * @param hero the {@link Hero} object that is invincible
     * @author fy916
     */
    public HeroIsInvincibleState(Hero hero) {
        this.hero = hero;
    }

    /**
     * Method which updates the {@link Hero} when in invincible state
     * @param hero the hero in the state
     * @author fy916
     */
    @Override
    public void stateUpdate(Hero hero) {
        //update the timer
        hero.setDeadFlashTimer(hero.getDeadFlashTimer() - 1);
        hero.setInvincibleTimer(hero.getInvincibleTimer() - 1);
        //if the hero is no longer invincible
        if (hero.getInvincibleTimer() < 0) {
            hero. setInvincible_dead(false);
            hero.setFlash(false);
        }
        //if the hero is invincible, flash the hero image
        if (hero.getDeadFlashTimer() < 0) {
            hero.setFlash(!hero.isFlash());
            hero.setDeadFlashTimer(Hero.getFlashInterval());
        }
    }
}
