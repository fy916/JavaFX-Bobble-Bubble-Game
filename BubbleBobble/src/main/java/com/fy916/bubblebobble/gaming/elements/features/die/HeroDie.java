package com.fy916.bubblebobble.gaming.elements.features.die;

import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.utilities.LevelStatus;
import com.fy916.bubblebobble.utilities.SoundEffect;

/**
 * A subclass of {@link Die} which is used for {@link Hero} to die.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroDie implements Die{
    private Hero hero;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param hero the {@link Hero} object that dies
     * @author fy916
     */
    public HeroDie(Hero hero, InteractableWorld world){
        this.hero = hero;
        this.world= world;
    }

    /**
     * Method which perform the die action of the hero.
     * @author fy916
     */
    @Override
    public void die() {
        //handles death
        SoundEffect.play_Death();
        LevelStatus.hero_dead();
        //if hero has lives left, death will lead to a short period of invincible time
        hero.setInvincible_dead(true);
        hero.setInvincibleTimer(hero.getShieldTimer());
    }

}
