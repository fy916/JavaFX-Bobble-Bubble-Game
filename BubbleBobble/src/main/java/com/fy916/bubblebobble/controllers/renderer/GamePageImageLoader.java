package com.fy916.bubblebobble.controllers.renderer;

import com.fy916.bubblebobble.controllers.GameController;
import com.fy916.bubblebobble.gaming.elements.movingelements.Enemy;
import com.fy916.bubblebobble.gaming.elements.movingelements.Hero;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import javafx.scene.control.Control;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;

/**
 * A class combined with multiple methods to facilitate the usage of the {@link GameController}<br/>.
 * Demonstrates the FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class GamePageImageLoader  {
    /**
     * Render the total lives player will have at the top of the window, according to different gaming difficulties.
     * @param lives1  Image Placeholder for the first life rendered on the screen
     * @param lives2 Image Placeholder for the second life rendered on the screen
     * @param lives3 Image Placeholder for the third life rendered on the screen
     * @param lives4 Image Placeholder for the forth life rendered on the screen
     * @param lives5  Image Placeholder for the fifth life rendered on the screen
     * @param remaining The count of the remaning lives
     * @param total The count of the total lives
     * @author fy916
     */
    public static void  render_all_lives(ImageView lives1,ImageView lives2, ImageView lives3, ImageView lives4, ImageView lives5, int remaining, int total) {
        if (total < 2)  lives2.setOpacity(0);
        if (total < 3)  lives3.setOpacity(0);
        if (total < 4)  lives4.setOpacity(0);
        if (total < 5)  lives5.setOpacity(0);
        render_lives(lives1,lives2, lives3, lives4, lives5, remaining);
    }

    /**
     * Render the lives according to the left of the lives player has
     * @param lives1
     * to
     * @param lives5  Image Placeholder for the first to the fifth life rendered on the screen
     * @param remaining The count of the remaning lives
     * @author fy916
     */
    public static void render_lives(ImageView lives1,ImageView lives2, ImageView lives3, ImageView lives4, ImageView lives5,int remaining) {
        GamePageImageLoader.renderLives(lives1, remaining >= 1);
        GamePageImageLoader.renderLives(lives2, remaining >= 2);
        GamePageImageLoader.renderLives(lives3, remaining >= 3);
        GamePageImageLoader.renderLives(lives4, remaining >= 4);
        GamePageImageLoader.renderLives(lives5, remaining >= 5);
    }

    /**
     * Render the life placeholder according to the boolean type
     * @param livePlaceholders Image Placeholder to be rendered
     * @param is_alive Mark if the image is to be filled as alive picture
     * @author fy916
     */
    public static void renderLives(ImageView livePlaceholders, boolean is_alive) {
        if (is_alive) {
            livePlaceholders.setImage(PageImageLoader.getImg_lives_alive());
        } else {
            livePlaceholders.setImage(PageImageLoader.getImg_lives_dead());
        }
    }

    /**
     * Update the indicators for the game, which is fixed at the top of the {@link Hero} and {@link Enemy}
     * @param world Current game world, used to provide the coordinates of the indicators
     * @param Hero_time_indicator_green  The indicator for the hero shielding time
     * @param Hero_time_indicator_red The indicator for the hero stunning time
     * @param Boss_health_indicator The indicator for the health of the boss
     * @param Hero_Ability_Indicator The indicator for the charging time of the hero
     * @author fy916
     */
    public static void updateUIIndicators(InteractableWorld world, ProgressIndicator Hero_time_indicator_red,ProgressIndicator Hero_time_indicator_green, ProgressBar Hero_Ability_Indicator,  ProgressBar Boss_health_indicator) {
        //get the hero coordinates and status
        int indicatorX = world.getWorldElements().getHero().getX() + world.getWorldElements().getHero().getObjectwidth() / 2;
        int indicatorY = world.getWorldElements().getHero().getY() + world.getWorldElements().getHero().getObjectheight() / 2;
        boolean heroIsShielding = world.getWorldElements().getHero().isShielding();
        boolean heroIsStunned =  world.getWorldElements().getHero().isStunned();

        double heroChargePercent = (double) world.getWorldElements().getHero().getChargeTimer() / world.getWorldElements().getHero().getORIGINAL_CHARGE_TIME();
        double heroStunnedPercent = (double) world.getWorldElements().getHero().getShieldTimer() / Hero.getSHIELD_TIME();
        double heroShieldPercent = (double) world.getWorldElements().getHero().getStunTimer() / Hero.getSTUN_TIME();

        //update the hero and boss indicators
        updateHeroAbilityIndicator(Hero_Ability_Indicator,indicatorX , indicatorY , heroChargePercent, true);
        updateHeroProgressGreenIndicator(Hero_time_indicator_green,indicatorX , indicatorY, heroStunnedPercent, heroIsShielding);
        updateHeroProgressRedIndicator(Hero_time_indicator_red,indicatorX , indicatorY, heroShieldPercent, heroIsStunned);
        updateBossHealthIndicator(Boss_health_indicator, world);
    }

    /**
     * Fill the hero stunning time indicator
     * @param indicator The indicator to be rendered
     * @param x x coordinate of the hero
     * @param y y coordinate of the hero
     * @param percentage The filling percentage
     * @param display Whether to show the indicator
     * @author fy916
     */
    public static void updateHeroProgressRedIndicator(ProgressIndicator indicator, int x, int y, double percentage, boolean display) {
        setLayout(indicator, x+87, y+50, percentage, display);
    }

    /**
     * Fill the hero shielding time indicator
     * @param indicator The indicator to be rendered
     * @param x x coordinate of the hero
     * @param y y coordinate of the hero
     * @param percentage The filling percentage
     * @param display Whether to show the indicator
     * @author fy916
     */
    public static void updateHeroProgressGreenIndicator(ProgressIndicator indicator, int x, int y, double percentage, boolean display) {
        setLayout(indicator, x+87, y+50, percentage, display);
    }


/**
 * Fill the hero charging time indicator
 * @param indicator The indicator to be rendered
 * @param x x coordinate of the hero
 * @param y y coordinate of the hero
 * @param percentage The filling percentage
 * @param display Whether to show the indicator
 * @author fy916
 */
    public static void updateHeroAbilityIndicator(ProgressBar indicator, int x, int y, double percentage, boolean display) {
        setLayout(indicator, x + 63, y+70, percentage, true);
    }

    /**
     * @param indicator The indicator to be rendered
     * @param world The game world to provide the Boss coordinate
     * @author fy916
     */
    public static void updateBossHealthIndicator(ProgressBar indicator, InteractableWorld world) {
        if (!world.getWorldElements().getEnemies().isEmpty()) {
            Enemy boss = world.getWorldElements().getEnemies().get(0);
            //check if the enemy is boss and attach the health bar on the boss
            if (boss.check_isBoss() && boss.get_health() > 0) {
                setLayout(indicator, boss.getX() + 85, boss.getY() + 75, boss.get_health() / 100, true);
            } else {
                indicator.setOpacity(0);
            }
        } else {
            indicator.setOpacity(0);
        }
    }

    /**
     * Fill indicator according to the params
     * @param indicator The indicator to be rendered
     * @param xLayout Calcuated X of the indicator
     * @param yLayout Calcuated Y of the indicator
     * @param display Whether to show the indicator
     * @param percentage Filling percentage
     * @author fy916
     */
    public static void setLayout(Control indicator, int xLayout, int yLayout, double percentage, boolean display){
        double opacity;
        if (display) {
            opacity = 1;
        } else {
            opacity = 0;
        }
        indicator.setLayoutX(xLayout);
        indicator.setLayoutY(yLayout);
        indicator.setOpacity(opacity);
        //set the indicator percentage
        if (indicator instanceof ProgressIndicator || indicator instanceof ProgressBar){
            ((ProgressIndicator) indicator).setProgress(percentage);
        }
    }

}
