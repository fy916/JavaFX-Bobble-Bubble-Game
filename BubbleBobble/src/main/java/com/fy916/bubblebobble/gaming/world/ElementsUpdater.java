package com.fy916.bubblebobble.gaming.world;

import com.fy916.bubblebobble.gaming.elements.movingelements.*;
import com.fy916.bubblebobble.utilities.GameScores;

/**
 * This class is used to provide methods to update elements location from the {@link WorldElements}.<br/>
 * Demonstrates Single Responsibility. 
 * @author fy916
 * @version 1.0
 */
public class ElementsUpdater {
    private WorldElements worldElements;//the element list to be updated

    /**
     * @param worldElements the {@link  WorldElements} list be updated
     * @author fy916
     */
    public ElementsUpdater(WorldElements worldElements){
        this.worldElements = worldElements;
    }

    /**
     * Update all elements' locations in the given {@link WorldElements}
     * @author fy916
     */
    void updateElements(){
        //update hero
        worldElements.getHero().getLocationUpdater().update();

        //update enemy
        for (Enemy enemy : worldElements.getEnemies()) {
            enemy.getLocationUpdater().update();
            if (enemy.isCanRemove()) {
                //if enemy can be removed
                worldElements.getToBeRemoved().add(enemy);
            }
        }
        //update projectiles
        for (Projectile projectile : worldElements.getProjectiles()) {
            projectile.getLocationUpdater().update();
            if (projectile.isCanRemove()) {
                //if projectile can be removed
                worldElements.getToBeRemoved().add(projectile);
            }
        }
        //update fruits
        for (Fruit fruit : worldElements.getFruits()) {
            fruit.getLocationUpdater().update();
            if (fruit.isCanRemove()) {
                //if fruits can be removed
                worldElements.getToBeRemoved().add(fruit);
                //add scores and the score indicators
                if (fruit.get_fruit_type() == 0) {
                    worldElements.getElementsAdder().addScoreIndicator(new ScoreIndicator(fruit.getX(), fruit.getY(), worldElements.getWorld(), 0));
                    GameScores.addScore(10);
                } else if (fruit.get_fruit_type() == 1) {
                    worldElements.getElementsAdder().addScoreIndicator(new ScoreIndicator(fruit.getX(), fruit.getY(), worldElements.getWorld(), 1));
                    GameScores.addScore(20);
                } else if (fruit.get_fruit_type() == 2) {
                    worldElements.getElementsAdder().addScoreIndicator(new ScoreIndicator(fruit.getX(), fruit.getY(), worldElements.getWorld(), 2));
                    GameScores.addScore(30);
                } else {
                    worldElements.getElementsAdder().addScoreIndicator(new ScoreIndicator(fruit.getX(), fruit.getY(), worldElements.getWorld(), 3));
                    GameScores.addScore(40);
                }
            }
        }
        //update bubbles
        for (Bubble bubble : worldElements.getBubbles()) {
            //charge = 0;
            bubble.getLocationUpdater().update();
            if (bubble.isCanRemove()) {
                //if bubbles can be removed
                worldElements.getToBeRemoved().add(bubble);
            }
        }
        //update scoreIndicators
        for (ScoreIndicator scoreIndicator : worldElements.getScoreIndicators()) {
            scoreIndicator.getLocationUpdater().update();
            if (scoreIndicator.isCanRemove()) {
                //if scoreIndicators can be removed
                worldElements.getToBeRemoved().add(scoreIndicator);
            }
        }

    }

}
