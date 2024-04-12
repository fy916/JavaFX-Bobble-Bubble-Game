package com.fy916.bubblebobble.gaming.elements.features.collision;

import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.mapelements.MapObject;
import com.fy916.bubblebobble.gaming.elements.movingelements.MovingObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.ScoreIndicator;

/**
 * A subclass of {@link Collision} which is used for {@link ScoreIndicator} to collide with others.<br/>
 * This shows the STRATEGY and TEMPLATE Design Pattern. 
 * @author fy916
 */
public class CollisionScoreIndicator implements  Collision{
    private ScoreIndicator scoreIndicator;
    private InteractableWorld world;

    /**
     * @param world current game {@link InteractableWorld}
     * @param scoreIndicator the {@link ScoreIndicator} object that to collide with
     * @author fy916
     */
    public CollisionScoreIndicator(ScoreIndicator scoreIndicator, InteractableWorld world){
        this.scoreIndicator = scoreIndicator;
        this.world = world;
    }

    /**
     * Method which takes an {@link MovingObject} type of object and perform colliding actions with the scoreindicator
     * @param movingObject the {@link MovingObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MovingObject movingObject) {
    }

    /**
     * Method which takes an {@link MapObject} type of object and perform colliding actions with the scoreindicator
     * @param mapObject the {@link MapObject} type of object to be collided
     * @author fy916
     */
    @Override
    public void collideWith(MapObject mapObject) {
        if (mapObject instanceof CeilingUnit) {
            scoreIndicator.markToRemove();
        }
    }
}
