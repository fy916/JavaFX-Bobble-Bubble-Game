package com.fy916.bubblebobble.gaming.world;

import com.fy916.bubblebobble.gaming.elements.GameObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.*;

import java.util.ArrayList;

/**
 * WorldElements includes the {@link GameObject} type of different elements like
 * {@link CeilingUnit}, {@link FloorUnit}, {@link WallUnit}, {@link Enemy},
 * {@link Projectile}, {@link Fruit}, {@link GameObject}, {@link Bubble},
 * {@link ScoreIndicator} in a {@link ArrayList}.<br/>
 * It also includes a {@link Hero} Object since the hero is only single in the game.<br/>
 * In addition, it also includes some helper like {@link ElementsAdder}, {@link ElementsRemover}.
 * @author fy916
 */
public class WorldElements {
    private ElementsAdder elementsAdder;
    private ElementsRemover elementsRemover;
    private InteractableWorld world;

    private ArrayList<CeilingUnit> ceilingUnits;
    private ArrayList<FloorUnit> floorUnits;
    private ArrayList<WallUnit> wallUnits;
    private Hero hero;
    private ArrayList<Enemy> enemies;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Fruit> fruits;
    private ArrayList<GameObject> toBeRemoved;
    private ArrayList<Bubble> bubbles;
    private ArrayList<ScoreIndicator> scoreIndicators;

    /**
     * Initialize the WorldElements to with empty Arraylist and null Hero identity
     * @param world the {@link InteractableWorld} this WorldElements is used in
     * @author fy916
     */
    public WorldElements(InteractableWorld world) {
        //initialize the Arraylist
        ceilingUnits = new ArrayList<CeilingUnit>();
        floorUnits = new ArrayList<FloorUnit>();
        wallUnits = new ArrayList<WallUnit>();
        enemies = new ArrayList<Enemy>();
        projectiles = new ArrayList<Projectile>();
        fruits = new ArrayList<Fruit>();
        toBeRemoved = new ArrayList<GameObject>();
        bubbles = new ArrayList<Bubble>();
        scoreIndicators = new ArrayList<ScoreIndicator>();
        //initialize the tools
        elementsAdder = new ElementsAdder(this);
        elementsRemover = new ElementsRemover(this);
        this.world = world;
    }


    /**
     * Getter of the field
     * @return {@link ElementsAdder} type of elementsAdder field
     * @author fy916
     */
    public ElementsAdder getElementsAdder() {return elementsAdder;}

    /**
     * Getter of the field
     * @return {@link ElementsRemover} type of elementsRemover field
     * @author fy916
     */
    public ElementsRemover getElementsRemover() {return elementsRemover;}

    /**
     * Getter of the field
     * @return {@link InteractableWorld} type of the world player in
     * @author fy916
     */
    public InteractableWorld getWorld() {return world;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of ceilingUnits
     * @author fy916
     */
    public ArrayList<CeilingUnit> getCeilingUnits() {return ceilingUnits;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of floorUnits
     * @author fy916
     */
    public ArrayList<FloorUnit> getFloorUnits() {return floorUnits;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of wallUnits
     * @author fy916
     */
    public ArrayList<WallUnit> getWallUnits() {return wallUnits;}

    /**
     * Getter of the field
     * @return {@link Hero} hero
     * @author fy916
     */
    public Hero getHero() {return hero;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of enemies
     * @author fy916
     */
    public ArrayList<Enemy> getEnemies() {return enemies;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of projectiles
     * @author fy916
     */
    public ArrayList<Projectile> getProjectiles() {return projectiles;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of fruits
     * @author fy916
     */
    public ArrayList<Fruit> getFruits() {return fruits;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of toBeRemoved
     * @author fy916
     */
    public ArrayList<GameObject> getToBeRemoved() {return toBeRemoved;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of bubbles
     * @author fy916
     */
    public ArrayList<Bubble> getBubbles() {return bubbles;}

    /**
     * Getter of the field
     * @return {@link ArrayList} of scoreIndicators
     * @author fy916
     */
    public ArrayList<ScoreIndicator> getScoreIndicators() {return scoreIndicators;}

    /**
     * Setter of the field
     * @param world the new {@link InteractableWorld}
     * @author fy916
     */
    public void setWorld(InteractableWorld world) {this.world = world;}

    /**
     * Setter of the field
     * @param hero the new {@link Hero}
     * @author fy916
     */
    public void setHero(Hero hero) {this.hero = hero;}
}
