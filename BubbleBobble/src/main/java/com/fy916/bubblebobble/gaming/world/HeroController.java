package com.fy916.bubblebobble.gaming.world;

import com.fy916.bubblebobble.gaming.elements.movingelements.Bubble;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.utilities.SoundEffect;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This class is used to deal with the key inputs bind from
 * {@link com.fy916.bubblebobble.controllers.renderer.GameRefresher}
 * to control the {@link Hero} in {@link WorldElements}.<br/>
 * Demonstrates Single Responsibility. 
 * @author fy916
 * @version 1.0
 */
public class HeroController {
    private WorldElements worldElements;

    /**
     * @param worldElements the {@link  WorldElements} to provide the {@link Hero} to be controlled
     * @author fy916
     */
    public HeroController(WorldElements worldElements){
        this.worldElements = worldElements;
    }

    /**
     * Handles the hero movement when the key is released on the keyboard
     * @param e The released key event fetched from the keyboard.
     * @author fy916
     */
    public void control_hero_released(KeyEvent e) {
        //if the hero is moving right and right key is released
        if (e.getCode() == KeyCode.RIGHT && worldElements.getHero().get_xAccel() > 0) {
            worldElements.getHero().set_xAccel(0);
        }
        //if the hero is moving left and left key is released
        if (e.getCode() == KeyCode.LEFT && worldElements.getHero().get_xAccel() < 0) {
            worldElements.getHero().set_xAccel(0);
        }
        //reset the dashing status when space is released
        if (e.getCode() == KeyCode.SPACE) {
            worldElements.getHero().set_terminal_xVelocity(Hero.getWALK_SPEED());
        }
        //reset the shoot delay when shoot key is released
        if (e.getCode() == KeyCode.E) {
            worldElements.getHero().setShootDelay(0);
        }
        //reset the shielding status when shielding key is released
        if (e.getCode() == KeyCode.Q) {
            worldElements.getHero().setShielding(false);
        }
    }

    /**
     * Handles the hero movement when the key is pressed on the keyboard
     * @param e The pressed key event fetched from the keyboard.
     * @author fy916
     */
    public void control_hero_pressd(KeyEvent e) {
        //Let the hero move right
        if (e.getCode() == KeyCode.RIGHT) {
            //if the hero is not shielding or stunned
            if (!worldElements.getHero().isShielding() && !worldElements.getHero().isStunned()) {
                worldElements.getHero().set_xAccel(Hero.getRunAccel());
                worldElements.getHero().set_direction(1);
            }
        }
        //let the hero move left
        if (e.getCode() == KeyCode.LEFT) {
            //if the hero is not shielding or stunned
            if (!worldElements.getHero().isShielding() && !worldElements.getHero().isStunned()) {
                worldElements.getHero().set_xAccel(-Hero.getRunAccel());
                worldElements.getHero().set_direction(-1);
            }
        }
        //Let the hero jump
        if (e.getCode() == KeyCode.UP) {
            //if the hero is not shielding or stunned
            if (!worldElements.getHero().isShielding() && !worldElements.getHero().isStunned()) {
                worldElements.getHero().getJump().jump();
            }
        }
        //Set the hero dash speed
        if (e.getCode() == KeyCode.SPACE) {
            worldElements.getHero().set_terminal_xVelocity(Hero.getRUN_SPEED());
        }
        //Let the hero shoot projectile
        if (e.getCode() == KeyCode.E) {
            //if the hero is not shielding or stunned
            if (!worldElements.getHero().isShielding() && !worldElements.getHero().isStunned()) {
                worldElements.getHero().setShootDelay(worldElements.getHero().getShootDelay() - 1);
                //if the hero shooting interval is reached
                if (worldElements.getHero().getShootDelay() <= 0) {
                    worldElements.getHero().shootProjectile();
                    worldElements.getHero().setShootDelay(10);
                }
            }
        }
        //Let the hero shield
        if (e.getCode() == KeyCode.Q) {
            //if the hero is not stunned
            if (!worldElements.getHero().isStunned()) {
                worldElements.getHero().set_xVelocity(0);
                worldElements.getHero().set_xAccel(0);
                worldElements.getHero().setShielding(true);
            }
        }
        //Let the hero use special ability
        if (e.getCode() == KeyCode.W) {
            //if the hero is ready to charge
            if (worldElements.getHero().isReadyToCharge()) {
                //add the bubble
                worldElements.getElementsAdder().addBubble
                        (new Bubble(worldElements.getWorld(), worldElements.getHero().getX(), worldElements.getHero().getY()));
                //play the sound
                SoundEffect.play_Explode();
                worldElements.getHero().setReadyToCharge(false);
            }
        }
    }
}
