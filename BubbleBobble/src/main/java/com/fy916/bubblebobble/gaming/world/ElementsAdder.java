package com.fy916.bubblebobble.gaming.world;

import com.fy916.bubblebobble.controllers.Controller;
import com.fy916.bubblebobble.controllers.renderer.LeaderBoardImageLoader;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.*;
import com.fy916.bubblebobble.utilities.GameScores;

/**
 * This class is used to provide methods to add elements in the {@link WorldElements}.<br/>
 * Demonstrates Single Responsibility. 
 * @author fy916
 * @version 1.0
 */
public class ElementsAdder {
    private WorldElements worldElements; //the element list to be added

    /**
     * @param worldElements the {@link  WorldElements} that objects are added to
     * @author fy916
     */
    public ElementsAdder(WorldElements worldElements){
        this.worldElements = worldElements;
    }

    /**
     * @param ceilingUnit the {@link  CeilingUnit} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addCeilingUnit(CeilingUnit ceilingUnit) {
        worldElements.getCeilingUnits().add(ceilingUnit);
    }

    /**
     * @param floorUnit the {@link  FloorUnit} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addFloorUnit(FloorUnit floorUnit) {
        worldElements.getFloorUnits().add(floorUnit);
    }

    /**
     * @param wallUnit the {@link  WallUnit} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addWallUnit(WallUnit wallUnit) {
        worldElements.getWallUnits().add(wallUnit);
    }

    /**
     * @param enemy the {@link  Enemy} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addEnemy(Enemy enemy) {
        //adds a mook to the map
        worldElements.getEnemies().add(enemy);
    }

    /**
     * @param projectile the {@link  Projectile} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addProjectile(Projectile projectile) {
        //adds a projectile to where necessary
        worldElements.getProjectiles().add(projectile);
    }

    /**
     * @param fruit the {@link  Fruit} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addFruit(Fruit fruit) {
        //adds fruit on bubble pop
        worldElements.getFruits().add(fruit);
    }

    /**
     * @param bubble the {@link  Bubble} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addBubble(Bubble bubble) {
        //adds special bubble
        worldElements.getBubbles().add(bubble);
    }

    /**
     * @param indicator the {@link  ScoreIndicator} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addScoreIndicator(ScoreIndicator indicator) {
        worldElements.getScoreIndicators().add(indicator);
    }

    /**
     * @param hero the {@link  Hero} that added to the {@link WorldElements}
     * @author fy916
     */
    public void addHero(Hero hero) {
        //adds a mook to the map
        worldElements.setHero(hero);
    }

}
