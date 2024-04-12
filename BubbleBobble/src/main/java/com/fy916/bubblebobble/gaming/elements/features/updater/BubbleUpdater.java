package com.fy916.bubblebobble.gaming.elements.features.updater;

import com.fy916.bubblebobble.gaming.elements.movingelements.Bubble;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;

/**
 * A subclass of {@link GeneralLocationUpdater} which extends it to illustrate the {@link Bubble} location updater.<br/>
 * This shows the STRATEGY, STATES and TEMPLATE Design Pattern.
 * @author fy916
 */
public class BubbleUpdater extends GeneralLocationUpdater{
    private Bubble bubble;

    /**
     * @param interactableWorld current game {@link InteractableWorld}
     * @param movingObject the {@link MovingObject} object that to have its location updated.
     *                     (should be downcasted to {@link Bubble} later).
     * @author fy916
     */
    public BubbleUpdater(MovingObject movingObject, InteractableWorld interactableWorld) {
        super(movingObject, interactableWorld);//call the super to construct the general location updater
        this.movingObject = movingObject;//set the moving object
        this.world = interactableWorld;
        bubble = (Bubble) movingObject;//downcast the MovingObject to Bubble
    }

    /**
     * Method which perform the update action of the bubble, where it shows  STATES Design Pattern.
     * @author fy916
     */
    @Override
    public void update() {
        //if the bubbke fills the screen, remove it
        if (bubble.getObjectwidth() >= 2500) {
            bubble.markToRemove();
        }
        //enlarge the bubble
        bubble.setX(bubble.getX()-bubble.getAccel()/2);
        bubble.setY(bubble.getY()-bubble.getAccel()/2);
        bubble.setObjectwidth(bubble.getObjectwidth()+ bubble.getAccel());
        bubble.setObjectheight(bubble.getObjectheight()+bubble.getAccel());
        bubble.setAccel(bubble.getAccel()+1);
    }
}
