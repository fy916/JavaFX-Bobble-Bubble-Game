package com.fy916.bubblebobble.gaming.elements.features.updater;

import com.fy916.bubblebobble.gaming.elements.features.herostates.HeroInvincibleState;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;

/**
 * A general location updater for all {@link MovingObject}, implements the interface {@link LocationUpdater} <br/>
 * This shows the STRATEGY, STATES and TEMPLATE Design Pattern.
 * @author fy916
 */
public class GeneralLocationUpdater implements LocationUpdater {
    protected MovingObject movingObject;  //the movingobject to be updated
    protected InteractableWorld world;   //the current gameworld

    /**
     * @param interactableWorld current game {@link InteractableWorld}
     * @param movingObject the {@link MovingObject} object that to have its location updated
     * @author fy916
     */
    public GeneralLocationUpdater(MovingObject movingObject, InteractableWorld interactableWorld) {
        this.movingObject = movingObject;
        this.world = interactableWorld;
    }

    /**
     * Update the game elements according to its velocity, acceleration, etc.
     * @author fy916
     */
    @Override
    public void update() {
        //general update method of every game object
        movingObject.set_xVelocity(movingObject.get_xVelocity() + movingObject.getxAccel());
        //if the object can still accelerate on X axis
        if (Math.abs(movingObject.get_xVelocity()) <= movingObject.getTerminal_xVelocity()) {
            //if the object is moving, it will be affected by the static friction
            if (Math.abs(movingObject.get_xVelocity()) > InteractableWorld.getStaticFriction()) {
                //affect the speed according to different direction by the friction
                if (movingObject.get_xVelocity() < 0) {
                    movingObject.set_xVelocity(movingObject.get_xVelocity() + InteractableWorld.getStaticFriction() * 10);
                } else {
                    movingObject.set_xVelocity(movingObject.get_xVelocity() - InteractableWorld.getStaticFriction() * 10);
                }
                //if the speed of the object is small enough to be stopped by the friction
            } else {
                movingObject.set_xVelocity(0);
            }
            //if the object reaches the max speed
        } else {
            if (movingObject.get_xVelocity() > 0) {
                movingObject.set_xVelocity(movingObject.getTerminal_xVelocity());
            } else {
                movingObject.set_xVelocity(-movingObject.getTerminal_xVelocity());
            }
        }
        //update the X according to the speed
        movingObject.setX((int) (movingObject.get_xVelocity()+movingObject.getX()));

        //if the object can still accelerate on Y axis
        if (movingObject.get_yVelocity() < movingObject.getTerminal_yVelocity()) {
            movingObject.set_yVelocity(movingObject.get_yVelocity() + movingObject.getyAccel());
        }
        //update the Y according to the speed
        movingObject.setY((int) (movingObject.get_yVelocity()+movingObject.getY()));
        //if the object is out of the screen, place it back
        if (movingObject.isOffScreen()) {
            if (movingObject.getY() > movingObject.getWorld().getHeight()) {
                movingObject.setY(0);
            } else {
                movingObject.setY(movingObject.getWorld().getHeight());
            }
        }

    }
}
