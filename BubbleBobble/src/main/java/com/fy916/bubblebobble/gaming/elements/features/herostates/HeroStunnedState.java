package com.fy916.bubblebobble.gaming.elements.features.herostates;

import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;


/**
 * An Interface which offers the stunned state method framework for {@link Hero}.<br/>
 * This shows the STATE and TEMPLATE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public interface HeroStunnedState {

    /**
     * Abstract Method which updates the state of the {@link Hero} when in stunned state or not.
     * @author fy916
     */
    abstract void stateUpdate(Hero hero);

}
