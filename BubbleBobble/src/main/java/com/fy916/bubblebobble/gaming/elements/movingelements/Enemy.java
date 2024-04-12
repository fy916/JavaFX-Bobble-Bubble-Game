package com.fy916.bubblebobble.gaming.elements.movingelements;

import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionEnemy;
import com.fy916.bubblebobble.gaming.elements.features.die.EnemyDie;
import com.fy916.bubblebobble.gaming.elements.features.jump.EnemyJump;
import com.fy916.bubblebobble.gaming.elements.features.updater.EnemyUpdater;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.utilities.GameStatus;


/**
 * An Enemy is a non-controllable element which kills the Hero whenever it or its projectile comes in contact.<br/>
 * It extends {@link MovingObject}.<br/>
 * Enemies are able to be bubbled and free themselves from these bubbles after a period of time.
 * Enemies change direction at random intervals, when hitting a wall, and when hitting the {@link Hero}'s shield.
 * Enemies jump at random intervals as well.
 */
public class Enemy extends MovingObject {
    private static final int SIZE = 25;    //the size of the enemy

    private static final int JUMP_SPEED = 18;    //the jump speed of the enemy

    private static final int BUBBLED_FRAMES = 300;    //frames that will last when an enemy is bubbled

    private static final double CHANGE_MOVEMENT_CHANCE = 0.01;    //the chance that the enmey will change behabiour

    private final boolean is_boss;  //whether an enemy is a boss
    private final int looktype; //the outlook of the enemy
    private boolean freeze; //if the enemy cannot move
    private double jumpSpeed;   //the current jump speed of the hero
    private boolean isBubbled;  //if the enemy is bubbled
    private int timer;  //set the timer
    private boolean turningAwayFromShield;  //if the enemy will turn away from the shield
    private int turningAwayCount;   //count the time when the enemy will stay not turnning away
    private boolean isOnAPlatform; //if the enemy is on the platfrom
    private int boss_health;   //the health of the boss

    /**
     * Constructor that takes unit column and rows to initialize the normal enemy
     * @param world current game world
     * @param colNum the column of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @author fy916
     */
    public Enemy(InteractableWorld world, int colNum, int rowNum) {
        //initializes enemy
        super(world, colNum, rowNum, SIZE, SIZE);//call the super constructor for basic property
        enemy_initialization(); //initialize the enemy
        //if it is not boss, randomly select looktype from 0-2
        is_boss = false;
        if (Math.random() < 0.5) {
            looktype = 0;
        } else if (Math.random() > 0.5) {
            looktype = 1;
        } else {
            looktype = 2;
        }
    }

    /**
     * Constructor that takes unit column and rows to initialize the BOSS
     * @param world current game world
     * @param colNum the column of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param ifboss the boolean's truth doesn't matter since it only is used to distinguish the normal enemy and the boss
     * @author fy916
     */
    public Enemy(InteractableWorld world, int colNum, int rowNum, boolean ifboss) {
        //initializes enemy
        super(world, colNum, rowNum, 2 * SIZE, 2 * SIZE);//call the super constructor for basic property
        enemy_initialization();
        is_boss = true;
        //if it is boss, randomly select looktype from 3-4
        boss_health = 100;
        if (Math.random() < 0.1) {
            looktype = 3;
        } else {
            looktype = 4;
        }
    }

    /**
     * Initialize the enemy with some property
    * @author fy916
     */
    private void enemy_initialization() {
        setDie(new EnemyDie(this, getWorld())); //initialize the Die class, this shows Strategy Pattern
        setJump(new EnemyJump(this, getWorld()));//initialize the Jump class, this shows Strategy Pattern
        setCollision(new CollisionEnemy(this, getWorld())); //initialize the Collision class, this shows Strategy Pattern
        setLocationUpdater(new EnemyUpdater(this, getWorld())); //initialize the Collision class, this shows Strategy Pattern
        freeze = false;
        //set the initial status
        setOnAPlatform(false);
        setJumpSpeed(JUMP_SPEED);
        setTerminal_xVelocity(2 + GameStatus.getDifficultyCoefficient() * 2.5);
        setxAccel(1.5);
        setDirection(1);
        if (Math.random() < 0.5) {
            reverseDirection();
        }
        isBubbled = false;
        timer = BUBBLED_FRAMES;
        turningAwayFromShield = false;
        turningAwayCount = 10;
    }


    /**
     * Getter of the field
     * @return is_boss field
     * @author fy916
     */
    public boolean check_isBoss() { return is_boss; }

    /**
     * Getter of the field
     * @return boss_health field
     * @author fy916
     */
    public double get_health() { return boss_health; }

    /**
     * Getter of the field
     * @return isOnAPlatform field
     * @author fy916
     */
    public boolean isOnAPlatform() { return isOnAPlatform; }

    /**
     * Setter of the field
     * @param onAPlatform the new status of isOnAPlatform
     * @author fy916
     */
    public void setOnAPlatform(boolean onAPlatform) { isOnAPlatform = onAPlatform; }

    /**
     * Getter of the field
     * @return jumpSpeed field
     * @author fy916
     */
    public double getJumpSpeed() { return jumpSpeed; }


    /**
     * Setter of the field
     * @param jumpSpeed the new status of jumpSpeed
     * @author fy916
     */
    public void setJumpSpeed(double jumpSpeed) { this.jumpSpeed = jumpSpeed; }

    /**
     * Getter of the field
     * @return looktype field
     * @author fy916
     */
    public int get_render_type() { return looktype; }

    /**
     * Getter of the field
     * @return is_boss field
     * @author fy916
     */
    public boolean isIs_boss() { return is_boss; }

    /**
     * Getter of the field
     * @return freeze field
     * @author fy916
     */
    public boolean isFreeze() { return freeze; }

    /**
     * Setter of the field
     * @param freeze the new status of freeze
     * @author fy916
     */
    public void setFreeze(boolean freeze) { this.freeze = freeze; }

    /**
     * Getter of the field
     * @return isBubbled field
     * @author fy916
     */
    public boolean isBubbled() { return isBubbled; }

    /**
     * Setter of the field
     * @param bubbled the new status of isBubbled
     * @author fy916
     */
    public void setBubbled(boolean bubbled) { isBubbled = bubbled; }

    /**
     * Getter of the field
     * @return timer field
     * @author fy916
     */
    public int getTimer() { return timer; }

    /**
     * Setter of the field
     * @param timer the new status of timer
     * @author fy916
     */
    public void setTimer(int timer) { this.timer = timer; }

    /**
     * Getter of the field
     * @return turningAwayFromShield field
     * @author fy916
     */
    public boolean isTurningAwayFromShield() { return turningAwayFromShield; }

    /**
     * Setter of the field
     * @param turningAwayFromShield the new status of turningAwayFromShield
     * @author fy916
     */
    public void setTurningAwayFromShield(boolean turningAwayFromShield) { this.turningAwayFromShield = turningAwayFromShield;}

    /**
     * Getter of the field
     * @return turningAwayCount field
     * @author fy916
     */
    public int getTurningAwayCount() { return turningAwayCount; }

    /**
     * Setter of the field
     * @param turningAwayCount the new status of turningAwayCount
     * @author fy916
     */
    public void setTurningAwayCount(int turningAwayCount) { this.turningAwayCount = turningAwayCount; }

    /**
     * Getter of the field
     * @return boss_health field
     * @author fy916
     */
    public int getBoss_health() { return boss_health; }

    /**
     * Setter of the field
     * @param boss_health the new status of boss_health
     * @author fy916
     */
    public void setBoss_health(int boss_health) { this.boss_health = boss_health; }

    /**
     * Getter of the field
     * @return BUBBLED_FRAMES field
     * @author fy916
     */
    public static int getBubbledFrames() { return BUBBLED_FRAMES; }

    /**
     * Getter of the field
     * @return CHANGE_MOVEMENT_CHANCE field
     * @author fy916
     */
    public static double getChangeMovementChance() { return CHANGE_MOVEMENT_CHANCE; }
}

