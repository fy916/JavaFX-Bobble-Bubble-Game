package com.fy916.bubblebobble.gaming.elements.features.updater;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.features.herostates.*;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;

/**
 * A subclass of {@link GeneralLocationUpdater} which extends it to illustrate the {@link Hero} location updater.<br/>
 * This shows the STRATEGY, STATES and TEMPLATE Design Pattern.
 * @author fy916
 */
public class HeroUpdater extends GeneralLocationUpdater{
    private Hero hero;
    private InteractableWorld world;
    private HeroStunnedState heroStunnedState;      //various states of the hero
    private HeroInvincibleState heroInvincibleState;
    private HeroShieldState heroShieldState;
    private HeroChargeState heroChargeState;

    /**
     * @param interactableWorld current game {@link InteractableWorld}
     * @param movingObject the {@link MovingObject} object that to have its location updated.
     *                     (should be downcasted to {@link Hero} later).
     * @author fy916
     */
    public HeroUpdater(MovingObject movingObject, InteractableWorld interactableWorld) {
        super(movingObject, interactableWorld);
        this.movingObject = movingObject;
        this.world = interactableWorld;
        hero = (Hero) movingObject;
        this.heroChargeState = new HeroIsReadyToChargeState(this.hero);
        this.heroInvincibleState = new HeroNotInvincibleState(this.hero);
        this.heroShieldState = new HeroNotShieldingState(this.hero);
        this.heroStunnedState = new HeroNotStunnedState(this.hero);
    }

    /**
     * Method which perform the update action of the hero, where it shows  STATES Design Pattern.
     * @author fy916
     */
    @Override
    public void update() {
        //updates position of hero first
        super.update();

        //update the charge states
        if (hero.isReadyToCharge() && heroChargeState instanceof  HeroNotReadyToChargeState) {
            //if it was in NOT ready to charge state but now it is ready to charge, switch states
            this.heroChargeState = new HeroIsReadyToChargeState(this.hero);
        } else if (!hero.isReadyToCharge() && heroChargeState instanceof HeroIsReadyToChargeState){
            //if it was in ready to charge state but now it is not ready to charge, switch states
            this.heroChargeState = new HeroNotReadyToChargeState(this.hero);
        }
        heroChargeState.stateUpdate(this.hero);

        //update the invincible states
        if (hero.isInvincible_dead() && heroInvincibleState instanceof  HeroNotInvincibleState) {
            //if it was in NOT invincible state but now it is invincible, switch states
            this.heroInvincibleState = new HeroIsInvincibleState(this.hero);
        } else if (!hero.isInvincible_dead() && heroInvincibleState instanceof HeroIsInvincibleState){
            //if it was in invincible state but now it is NOT invincible, switch states
            this.heroInvincibleState = new HeroNotInvincibleState(this.hero);
        }
        heroInvincibleState.stateUpdate(this.hero);

        //update the shielding states
        if (hero.isShielding() && heroShieldState instanceof HeroNotShieldingState) {
            //if it was in NOT shielding state but now it is shielding, switch states
            this.heroShieldState = new HeroIsShieldingState(this.hero);
        } else if (!hero.isShielding() && heroShieldState instanceof HeroIsShieldingState){
            //if it was in shielding state but now it is NOT shielding, switch states
            this.heroShieldState = new HeroNotShieldingState(this.hero);
        }
        heroShieldState.stateUpdate(this.hero);

        //update the stunned states
        if (hero.isStunned() && heroStunnedState instanceof HeroNotStunnedState) {
            //if it was in NOT stunned state but now it is stunned, switch states
            this.heroStunnedState = new HeroIsStunnedState(this.hero);
        } else if (!hero.isStunned() && heroStunnedState instanceof HeroIsStunnedState){
            //if it was in stunned state but now it is NOT stunned, switch states
            this.heroStunnedState = new HeroNotStunnedState(this.hero);
        }
        heroStunnedState.stateUpdate(this.hero);


    }
}
