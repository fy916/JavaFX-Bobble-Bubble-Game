package com.fy916.bubblebobble.gaming.elements.features.jump;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.utilities.SoundEffect;
/**
 * A subclass of {@link Jump} which is used for {@link Hero} to jump.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class HeroJump implements Jump{
    private Hero hero;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param hero the {@link Hero} object that jumps
     * @author fy916
     */
    public HeroJump(Hero hero, InteractableWorld world){
        this.hero = hero;
        this.world= world;
    }

    /**
     * Method which perform the jump action of the hero
     * @author fy916
     */
    @Override
    public void jump() {
        //if the hero is on the platform, perform jumping
        if (hero.isOnAPlatform()) {
            hero.setY(hero.getY());
            hero.set_yVelocity(-Hero.getJumpSpeed());
            hero.setOnAPlatform(false);
            SoundEffect.play_Jump();
        }
    }
}

