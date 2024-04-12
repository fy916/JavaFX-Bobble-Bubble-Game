package com.fy916.bubblebobble.gaming.elements.movingelements;

import com.fy916.bubblebobble.gaming.elements.features.updater.ProjectileUpdater;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionProjectile;
import com.fy916.bubblebobble.utilities.GameStatus;


/**
 * The Projectile class handles the projectiles being shot
 * from a {@link Hero} or an {@link com.fy916.bubblebobble.gaming.elements.movingelements.Enemy}.<br/>
 * It extends {@link MovingObject}.<br/>
 * The type of the projectile determines whether a Hero or an Enemy will be hurt, along with different property.
 */
public class Projectile extends MovingObject {
    //projectile_Type = 1: EnemyProj
    //projectile_Type = 2: BossProj
    //projectile_Type = 0: HeroProj
    private static final int SIZE = 20; //the size of the Projectile
    private static final int SIZE_BOSS_PROJECTILE = 30;//the size of the Projectile shot by the boss
    private static final int SPEED_Hero = 15; // the speed of projectile shot from the hero
    private static final int SPEED_Enemy = 8; // the initial speed of the projectile shot from the enemy
    private static final int TERMINAL_VELOCITY_Y = 5;
    private final int activeFrames;  //determines the active time the projectile has
    private int projectile_Type;       //the type of the projectile
    private boolean isActive;           //if the projectile is hurt
    private int timer;                        //count active frames


    /**
     * Constructor that takes the coordinates of x and y of the projectile shot by a
     * {@link Hero} or an {@link com.fy916.bubblebobble.gaming.elements.movingelements.Enemy}
     * @param world current game world
     * @param x the x coordinate of the object to be initialized
     * @param y the y coordinate of the object to be initialized
     * @author fy916
     */
    public Projectile(InteractableWorld world, int x, int y, int direction, int type) {
        super(x + 5, y + 5, SIZE, SIZE, world); //initialize normal projecitle
        setProjectile_Type(type);
        initializeProjectile();
        this.setDirection(direction);
        activeFrames = 45;
        setTimer(getActiveFrames());
    }

    /**
     * Constructor that takes the coordinates of x and y of the projectile shot by a
     * Boss from {@link com.fy916.bubblebobble.gaming.elements.movingelements.Enemy}
     * @param world current game world
     * @param x the x coordinate of the object to be initialized
     * @param y the y coordinate of the object to be initialized
     * @param is_boss the boolean's truth doesn't matter since it only is used to distinguish the normal enemy and the boss
     * @author fy916
     */
    public Projectile(InteractableWorld world, int x, int y, int direction, int type, boolean is_boss) {
        super(x + 5, y, SIZE_BOSS_PROJECTILE, SIZE_BOSS_PROJECTILE, world); //initialize a boss projectile
        setProjectile_Type(type);
        this.setDirection(direction);
        initializeProjectile();
        set_xVelocity(1.1 * get_xVelocity());
        activeFrames = 70;
        setTimer(getActiveFrames());
    }


    /**
     * Initialize the projectile with some property
     * @author fy916
     */
    public void initializeProjectile() {
        setCollision(new CollisionProjectile(this, getWorld())); //initialize the Collision class, this shows Strategy Pattern
        setLocationUpdater(new ProjectileUpdater(this, getWorld()));//initialize the Collision class, this shows Strategy Pattern
        if (getProjectile_Type() == 0) {
            //if is hero projectile
            set_xVelocity(SPEED_Hero);
        } else {
            //if is enemy projecitle
            set_xVelocity(SPEED_Enemy + GameStatus.getDifficultyCoefficient() * 5);
        }
        setyAccel(0);
        setActive(true);
    }


    /**
     * Getter of the field
     * @return isActive field
     * @author fy916
     */
    public boolean check_isActive() {return isActive();}

    /**
     * Getter of the field
     * @return activeFrames field
     * @author fy916
     */
    public int getActiveFrames() {return activeFrames;}

    /**
     * Getter of the field
     * @return isActive field
     * @author fy916
     */
    public boolean isActive() {return isActive;}

    /**
     * Getter of the field
     * @return timer field
     * @author fy916
     */
    public int getTimer() {return timer;}

    /**
     * Getter of the field
     * @return TERMINAL_VELOCITY_Y field
     * @author fy916
     */
    public static int getTerminalVelocityY() {return TERMINAL_VELOCITY_Y;}

    /**
     * Getter of the field
     * @return projectile_Type field
     * @author fy916
     */
    public int getProjectile_Type() {return projectile_Type;}

    /**
     * Setter of the field
     * @param timer the new status of timer
     * @author fy916
     */
    public void setTimer(int timer) {this.timer = timer;}

    /**
     * Setter of the field
     * @param active the new status of active
     * @author fy916
     */
    public void setActive(boolean active) {isActive = active;}

    /**
     * Setter of the field
     * @param projectile_Type the new status of projectile_Type
     * @author fy916
     */
    public void setProjectile_Type(int projectile_Type) {this.projectile_Type = projectile_Type;}
}

