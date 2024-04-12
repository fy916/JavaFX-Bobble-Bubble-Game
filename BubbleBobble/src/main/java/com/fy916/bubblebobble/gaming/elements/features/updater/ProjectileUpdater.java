package com.fy916.bubblebobble.gaming.elements.features.updater;

import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.Projectile;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.utilities.GameStatus;

/**
 * A subclass of {@link GeneralLocationUpdater} which extends it to illustrate the {@link Projectile} location updater.<br/>
 * This shows the STRATEGY, STATES and TEMPLATE Design Pattern.
 * @author fy916
 */
public class ProjectileUpdater extends GeneralLocationUpdater{
    private Projectile projectile;

    /**
     * @param interactableWorld current game {@link InteractableWorld}
     * @param movingObject the {@link MovingObject} object that to have its location updated. (should be downcasted to {@link Projectile} later)
     * @author fy916
     */
    public ProjectileUpdater(MovingObject movingObject, InteractableWorld interactableWorld) {
        super(movingObject, interactableWorld);
        this.movingObject = movingObject;
        this.world = interactableWorld;
        projectile = (Projectile) movingObject;  //downcast the MovingObject to Projectile
    }

    /**
     * Method which perform the update action of the projectile, where it shows  STATES Design Pattern.
     * @author fy916
     */
    @Override
    public void update() {
        //update the Projectile states, this is not like the normal moving objects
        projectile.setY((int) (projectile.getY() + projectile.get_yVelocity()));
        projectile.setX((int) (projectile.getX() + projectile.get_xVelocity() * projectile.getDirection()));
        updateVelocity();
        //if the projectile active timer is up
        if (projectile.getTimer() < 0) {
            projectile.setActive(false);
        }
        //if the projectile stays inactive for a while, remove it
        if (projectile.getTimer() < -200) {
            projectile.markToRemove();
        }
        //update the timer
        projectile.setTimer(projectile.getTimer() - 1);
    }

    /**
     * Method used to help the update() method to update the projectile
     * @author fy916
     */
    private void updateVelocity() {
        if (projectile.get_xVelocity() > 0) {
            //if the projectile is still moving
            if (projectile.getProjectile_Type() == 0) {
                //if it is a hero projectile
                projectile.set_xVelocity(projectile.get_xVelocity() - 0.25);
            } else {
                //if it is an enemy or boss projectile
                projectile.set_xVelocity(projectile.get_xVelocity() - 0.1 - GameStatus.getDifficultyCoefficient() * 0.15);
            }
        } else {
            projectile.set_xVelocity(0);
        }
        //if the projectile is inactive, make it fly up
        if (Math.abs(projectile.get_yVelocity()) < Projectile.getTerminalVelocityY() && !projectile.isActive()) {
            projectile.set_yVelocity(projectile.get_yVelocity() - 0.1);
        }
    }
}
