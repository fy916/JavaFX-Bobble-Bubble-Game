package com.fy916.bubblebobble.utilities;

import com.fy916.bubblebobble.gaming.elements.GameObject;
import com.fy916.bubblebobble.gaming.elements.mapelements.CeilingUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.FloorUnit;
import com.fy916.bubblebobble.gaming.elements.mapelements.WallUnit;
import com.fy916.bubblebobble.gaming.elements.movingelements.*;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.world.WorldElements;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * The {@link GameObject} renderer which loads the images from external files and then render it on the screen.<br/>
 * Realizes Single Responsibility Principle and FACADE and FACTORY Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class RenderObjects {
    //load images or initialize the image arraylist
    private static Image img_hero_L = FileReader.fetch_Image_objects("Hero_L");
    private static Image img_hero_R = FileReader.fetch_Image_objects("Hero_R");
    private static Image img_hero_dead_L = FileReader.fetch_Image_objects("Hero_L_dead");
    private static Image img_hero_dead_R = FileReader.fetch_Image_objects("Hero_R_dead");
    private static Image img_hero_shielding = FileReader.fetch_Image_objects("Hero_Shielding");
    private static Image img_hero_stunned = FileReader.fetch_Image_objects("Hero_Stunned");
    private static Image img_hero_projectile_active;
    private static Image img_hero_projectile_inactive;
    private static Image img_enemy_projectile_active = FileReader.fetch_Image_objects("enemy_projectile");
    private static Image img_enemy_projectile_inactive;
    private static ArrayList<Image> img_fruit; //0-3
    private static ArrayList<Image> img_score; //0-3
    private static ArrayList<Image> img_wall; //0-7
    private static ArrayList<Image> img_bubble;  //0-7
    private static ArrayList<Image> img_enemy_bubbled; //0-7
    private static ArrayList<Image> img_enemy_L; //0-4
    private static ArrayList<Image> img_enemy_R; //0-4
    private InteractableWorld world;
    private GraphicsContext gc;
    private WorldElements worldElements;

    /**
     * Constructor of the RenderObjects, this constructor is intended to read {@link Image} into the initialized arraylists
     * @param world The current game world {@link  InteractableWorld}
     * @param g The current {@link GraphicsContext} that the renderer utilizes to render on
     * @author fy916
     * @version 1.0
     */
    public RenderObjects(InteractableWorld world, GraphicsContext g) {
        //set the fields
        this.gc = g;
        this.world = world;
        this.worldElements = world.getWorldElements();
        img_fruit = new ArrayList<Image>();
        img_wall = new ArrayList<Image>();
        img_bubble = new ArrayList<Image>();
        img_score = new ArrayList<Image>();
        img_enemy_bubbled = new ArrayList<Image>();
        img_enemy_L = new ArrayList<Image>();
        img_enemy_R = new ArrayList<Image>();

        //fetch images
        for (int i = 0; i < 4; i++) {
            img_fruit.add(FileReader.fetch_Image_objects("Fruit_" + i));
            img_score.add(FileReader.fetch_Image_objects("score_" + i));
        }
        for (int i = 0; i < 8; i++) {
            img_wall.add(FileReader.fetch_Image_objects("wall_" + i));
            img_bubble.add(FileReader.fetch_Image_objects("bubble_" + i));
            img_enemy_bubbled.add(FileReader.fetch_Image_objects("enemy_bubbled_" + i));
        }
        for (int i = 0; i < 5; i++) {
            img_enemy_L.add(FileReader.fetch_Image_objects("Enemy_" + i + "_L"));
            img_enemy_R.add(FileReader.fetch_Image_objects("Enemy_" + i + "_R"));
        }

        //set the images
        img_hero_projectile_active = img_bubble.get(GameStatus.getBubbleColor());
        img_hero_projectile_inactive = img_bubble.get(GameStatus.getBubbleColor());
        img_enemy_projectile_inactive = img_enemy_projectile_active;
    }

    /**
     * Render the objects on the screen, one by one from the {@link WorldElements}.
     * @author fy916
     * @version 1.0
     */
    public void renderOnScreen() {
        //paints everything on the world
        //paint ceiling
        for (CeilingUnit ceilingUnit : worldElements.getCeilingUnits()) {
            drawImg(img_wall, ceilingUnit, GameStatus.getBackgroundChoice());
        }
        //paint floor
        for (FloorUnit floorUnit : worldElements.getFloorUnits()) {
            drawImg(img_wall, floorUnit, GameStatus.getBackgroundChoice());
        }
        //Paint wall
        for (WallUnit wallUnit : worldElements.getWallUnits()) {
            drawImg(img_wall, wallUnit, GameStatus.getBackgroundChoice());
        }

        //Paint the hero
        if (worldElements.getHero().isShielding()) {
            drawImg(img_hero_shielding, worldElements.getHero());
        } else if (worldElements.getHero().isStunned()) {
            //paint the stunned hero
            drawImg(img_hero_stunned, worldElements.getHero());
        } else if (worldElements.getHero().get_xVelocity() < 0) {
            //if the hero is facing left
            if (worldElements.getHero().isFlash()) {
                //paint the flashing hero
                drawImg(img_hero_dead_L, worldElements.getHero());
            } else {
                drawImg(img_hero_L, worldElements.getHero());
            }
        } else {
            //if the hero is facing right
            if (worldElements.getHero().isFlash()) {
                //paint the flashing hero
                drawImg(img_hero_dead_R, worldElements.getHero());
            } else {
                drawImg(img_hero_R, worldElements.getHero());
            }
        }

        //Paint the enemy
        for (Enemy enemy : worldElements.getEnemies()) {
            if (enemy.isBubbled()) {
                //if the enemy is bubbled
                drawImg(img_enemy_bubbled, enemy, GameStatus.getBubbleColor());
            } else if (enemy.get_xVelocity() < 0) {
                //if the enemy is facing left
                drawImg(img_enemy_L, enemy, enemy.get_render_type());
            } else {
                //if the enemy is facing right
                drawImg(img_enemy_R, enemy, enemy.get_render_type());
            }
        }

        //Paint the projectile
        for (Projectile projectile : worldElements.getProjectiles()) {
            //if the projectile is active
            if (projectile.check_isActive()) {
                if (projectile.getProjectile_Type() == 0) {
                    drawImg(img_hero_projectile_active, projectile);
                } else {
                    drawImg(img_enemy_projectile_active, projectile);
                }
            } else {
                //if the proojectile is inactive
                gc.setGlobalAlpha(0.5);
                if (projectile.getProjectile_Type() == 0) {
                    drawImg(img_hero_projectile_inactive, projectile);
                } else {
                    drawImg(img_enemy_projectile_inactive, projectile);
                }
                gc.setGlobalAlpha(1);
            }
        }

        //Paint the fruits
        for (Fruit fruit : worldElements.getFruits()) {
            drawImg(img_fruit, fruit, fruit.get_fruit_type());
        }

        //Paint the score indicator
        for (ScoreIndicator scoreIndicator : worldElements.getScoreIndicators()) {
            drawImg(img_score, scoreIndicator, scoreIndicator.get_type());
        }

        //Paint the bubbles
        for (Bubble bubble : worldElements.getBubbles()) {
            if (bubble.getObjectwidth() <= 2500) {
                //when the bubble grows, it fades
                gc.setFill(Color.color(255 / 255, 204 / 255, 102 / 255, (1 - ((double) bubble.getObjectwidth() / 2500))));
            } else {
                gc.setFill(Color.color(255 / 255, 204 / 255, 102 / 255, 0));
            }
            gc.fillOval(bubble.getX(), bubble.getY(), bubble.getObjectwidth(), bubble.getObjectheight());
            gc.setFill(Color.BLACK);
        }
    }

    /**
     * Render single image on the screen by calling drawImage() provided {@link GraphicsContext}.<br/>
     * @param image The image to be rendered
     * @param gameObject the Game object that provides the location and size property.
     * @author fy916
     * @version 1.0
     */
    public void drawImg(Image image, GameObject gameObject) {
        gc.drawImage(image, gameObject.getX(), gameObject.getY(), gameObject.getObjectheight(), gameObject.getObjectwidth());
    }

    /**
     * Render the image in the {@link ArrayList} on the screen by calling drawImage() provided {@link GraphicsContext}.<br/>
     * @param image The image to be rendered
     * @param gameObject the Game object that provides the location and size property.
     * @param select The index selection of the image in the {@link ArrayList} of {@link Image}
     * @author fy916
     * @version 1.0
     */
    public void drawImg(ArrayList<Image> image, GameObject gameObject, int select) {
        gc.drawImage(image.get(select), gameObject.getX(), gameObject.getY(), gameObject.getObjectheight(), gameObject.getObjectwidth());
    }


}