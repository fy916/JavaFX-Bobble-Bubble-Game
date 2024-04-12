package com.fy916.bubblebobble.gaming.world;

import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.*;

/**
 * This class is used to provide methods to collide elements in the {@link WorldElements}.<br/>
 * Demonstrates Single Responsibility. 
 * @author fy916
 * @version 1.0
 */
public class ElementsColliders {
    private WorldElements worldElements;//the element list to be collided in

    /**
     * @param worldElements the {@link  WorldElements} of objects to be collided
     * @author fy916
     */
    public ElementsColliders(WorldElements worldElements) {
        this.worldElements = worldElements;
    }

    /**
     * Collide the elements according to the given {@link WorldElements}
     * @author fy916
     */
    public void collideElements() {
        // Colliding...
        for (CeilingUnit ceilingUnit : worldElements.getCeilingUnits()) {
            //CeilingUnit collides with others
            ceilingUnit.getCollision().collideWith(worldElements.getHero());
            for (Enemy enemy : worldElements.getEnemies()) {
                ceilingUnit.getCollision().collideWith(enemy);
            }
            for (Fruit fruit : worldElements.getFruits()) {
                ceilingUnit.getCollision().collideWith(fruit);
            }
            for (Projectile projectile : worldElements.getProjectiles()) {
                ceilingUnit.getCollision().collideWith(projectile);
            }
            for (ScoreIndicator scoreIndicator : worldElements.getScoreIndicators()) {
                ceilingUnit.getCollision().collideWith(scoreIndicator);
            }
        }

        for (WallUnit wallUnit : worldElements.getWallUnits()) {
            //WallUnit collides with others
            wallUnit.getCollision().collideWith(worldElements.getHero());
            for (Enemy enemy : worldElements.getEnemies()) {
                wallUnit.getCollision().collideWith(enemy);
                enemy.getCollision().collideWith(wallUnit);
            }
            for (Fruit fruit : worldElements.getFruits()) {
                wallUnit.getCollision().collideWith(fruit);
            }
            for (Projectile projectile : worldElements.getProjectiles()) {
                wallUnit.getCollision().collideWith(projectile);
            }
        }

        for (FloorUnit floorUnit : worldElements.getFloorUnits()) {
            //FloorUnit collides with others
            floorUnit.getCollision().collideWith(worldElements.getHero());
            for (Enemy enemy : worldElements.getEnemies()) {
                floorUnit.getCollision().collideWith(enemy);
            }
            for (Fruit fruit : worldElements.getFruits()) {
                floorUnit.getCollision().collideWith(fruit);
            }
            for (Projectile projectile : worldElements.getProjectiles()) {
                floorUnit.getCollision().collideWith(projectile);
            }
        }


        // Enemies initiate collisions with Heroes
        for (Enemy enemy : worldElements.getEnemies()) {
            enemy.getCollision().collideWith(worldElements.getHero());
        }

        // HeroProjectiles initiate collisions with Heroes and Enemies
        for (Projectile projectile : worldElements.getProjectiles()) {
            projectile.getCollision().collideWith(worldElements.getHero());
            for (Enemy enemy : worldElements.getEnemies()) {
                projectile.getCollision().collideWith(enemy);
            }
        }
        // Fruits initiate collisions with Heroes
        for (Fruit fruit : worldElements.getFruits()) {
            fruit.getCollision().collideWith(worldElements.getHero());
        }

        // Bubble initiate collisions with Enemies
        for (Bubble bubble : worldElements.getBubbles()) {
            for (Enemy enemy : worldElements.getEnemies()) {
                bubble.getCollision().collideWith(enemy);
            }
        }

    }
}