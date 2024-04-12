package com.fy916.bubblebobble.gaming.elements.movingelements;

import com.fy916.bubblebobble.gaming.elements.features.updater.HeroUpdater;
import com.fy916.bubblebobble.gaming.world.InteractableWorld;
import com.fy916.bubblebobble.gaming.elements.features.collision.CollisionHero;
import com.fy916.bubblebobble.gaming.elements.features.die.HeroDie;
import com.fy916.bubblebobble.gaming.elements.features.jump.HeroJump;
import com.fy916.bubblebobble.utilities.GameStatus;
import com.fy916.bubblebobble.utilities.SoundEffect;


/**
 * A Hero is an element that is controllable by the player.<br/>
 * It extends {@link MovingObject}.<br/>
 * Hero can shoot {@link Projectile}, shield from attacks, trigger a special attack and
 * collect {@link Fruit} for points.
 */
public class Hero extends MovingObject {
    private static final int JUMP_SPEED = 18;//the jump speed of the hero
    private static final int SIZE = 30; //the size of the hero
    private static final int WALK = 4;//the walking speed of the hero
    private static final int RUN = 8;//the running speed of the hero
    private static final double RUN_ACCEL = 4;//running accelration of the hero
    private static final int TERMINAL_VELOCITY_X = 5;

    private static final int SHIELD_TIME = 150; //the original shielding time for the hero
    private static final int STUN_TIME = 150;//the original stunned time for the hero
    private static final int FLASH_INTERVAL = 15;//the flash interval when the hero is killed
    private final int ORIGINAL_CHARGE_TIME; //the default charging time

    private final double jumpSpeed; //the jumping speed of the hero
    private boolean isShielding;    //if the hero is shielding
    private int shieldTimer;            //the timer for shielding
    private boolean isStunned;      //if the hero is stunned
    private int chargeTimer;        //the timer for charging
    private int stunTimer;          //the timer for stunning
    private int shootDelay;           //the interval of time of shooting
    private boolean readyToCharge; //if the hero is ready to use special ability
    private boolean isOnAPlatform;  //if the hero is on the platfrom
    private boolean invincible_dead;//if the hero is dead and in invincible status
    private int invincibleTimer;        //the timer of hero in invincible status
    private int deadFlashTimer;         //the flash timer of the hero when it is dead
    private boolean flash;              //if it should flash now

    /**
     * Constructor that takes unit column and rows to initialize the normal hero
     * @param world current game world
     * @param colNum the column of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @param rowNum the row of location the unit in the game world, note this is not the exact coordinate but the relevant location of the objects without multiplying the unit size
     * @author fy916
     */
    public Hero(InteractableWorld world, int colNum, int rowNum) {
        //initializes hero
        super(world, colNum, rowNum, SIZE, SIZE); //call the super constructor for basic property
        setDie(new HeroDie(this,world));//initialize the Die class, this shows Strategy Pattern
        setJump(new HeroJump(this,world));//initialize the Jump class, this shows Strategy Pattern
        setCollision(new CollisionHero(this, world));//initialize the Collision class, this shows Strategy Pattern
        setLocationUpdater(new HeroUpdater(this, world));//initialize the Collision class, this shows Strategy Pattern
        //set the default property for the hero
        ORIGINAL_CHARGE_TIME = 300 + GameStatus.getDifficulty() * 50+ GameStatus.getLevel()*30;
        setOnAPlatform(false);
        setTerminal_xVelocity(TERMINAL_VELOCITY_X);
        jumpSpeed = JUMP_SPEED;
        setShielding(false);
        shieldTimer = SHIELD_TIME;
        isStunned = false;
        stunTimer = STUN_TIME;
        shootDelay = 0;
        readyToCharge = true;
        chargeTimer = ORIGINAL_CHARGE_TIME;
    }

    public void shootProjectile() {
        //makes hero shoot projectile
        SoundEffect.play_Shoot();
        getWorld().getWorldElements().getElementsAdder().addProjectile(new Projectile(getWorld(), getX(), getY(), getDirection(), 0)); //add the projectile to the world
    }


    /**
     * Getter of the field
     * @return JUMP_SPEED field
     * @author fy916
     */
    public static int getJumpSpeed() { return JUMP_SPEED; }

    /**
     * Getter of the field
     * @return WALK field
     * @author fy916
     */
    public static int getWALK_SPEED() { return WALK; }

    /**
     * Getter of the field
     * @return RUN field
     * @author fy916
     */
    public static int getRUN_SPEED() {return RUN;}

    /**
     * Getter of the field
     * @return RUN_ACCEL field
     * @author fy916
     */
    public static double getRunAccel() {return RUN_ACCEL;}

    /**
     * Getter of the field
     * @return SHIELD_TIME field
     * @author fy916
     */
    public static int getSHIELD_TIME() {return SHIELD_TIME;}

    /**
     * Getter of the field
     * @return STUN_TIME field
     * @author fy916
     */
    public static int getSTUN_TIME() {return STUN_TIME;}

    /**
     * Getter of the field
     * @return FLASH_INTERVAL field
     * @author fy916
     */
    public static int getFlashInterval() {return FLASH_INTERVAL;}

    /**
     * Getter of the field
     * @return ORIGINAL_CHARGE_TIME field
     * @author fy916
     */
    public int getORIGINAL_CHARGE_TIME() {return ORIGINAL_CHARGE_TIME;}

    /**
     * Getter of the field
     * @return isShielding field
     * @author fy916
     */
    public boolean isShielding() {return isShielding;}

    /**
     * Getter of the field
     * @return shieldTimer field
     * @author fy916
     */
    public int getShieldTimer() {return shieldTimer;}

    /**
     * Getter of the field
     * @return isStunned field
     * @author fy916
     */
    public boolean isStunned() {return isStunned;}

    /**
     * Getter of the field
     * @return chargeTimer field
     * @author fy916
     */
    public int getChargeTimer() {return chargeTimer;}

    /**
     * Getter of the field
     * @return stunTimer field
     * @author fy916
     */
    public int getStunTimer() {return stunTimer;}

    /**
     * Getter of the field
     * @return shootDelay field
     * @author fy916
     */
    public int getShootDelay() {return shootDelay;}

    /**
     * Getter of the field
     * @return readyToCharge field
     * @author fy916
     */
    public boolean isReadyToCharge() {return readyToCharge;}

    /**
     * Getter of the field
     * @return isOnAPlatform field
     * @author fy916
     */
    public boolean isOnAPlatform() {return isOnAPlatform;}

    /**
     * Getter of the field
     * @return invincible_dead field
     * @author fy916
     */
    public boolean isInvincible_dead() {return invincible_dead;}

    /**
     * Getter of the field
     * @return invincibleTimer field
     * @author fy916
     */
    public int getInvincibleTimer() {return invincibleTimer;}

    /**
     * Getter of the field
     * @return deadFlashTimer field
     * @author fy916
     */
    public int getDeadFlashTimer() {return deadFlashTimer;}

    /**
     * Getter of the field
     * @return flash field
     * @author fy916
     */
    public boolean isFlash() {return flash;}

    /**
     * Setter of the field
     * @param flash the new status of flash
     * @author fy916
     */
    public void setFlash(boolean flash) {this.flash = flash;}

    /**
     * Setter of the field
     * @param shielding the new status of shielding
     * @author fy916
     */
    public void setShielding(boolean shielding) {isShielding = shielding;}

    /**
     * Setter of the field
     * @param deadFlashTimer the new status of deadFlashTimer
     * @author fy916
     */
    public void setDeadFlashTimer(int deadFlashTimer) {this.deadFlashTimer = deadFlashTimer;}

    /**
     * Setter of the field
     * @param invincibleTimer the new status of invincibleTimer
     * @author fy916
     */
    public void setInvincibleTimer(int invincibleTimer) {this.invincibleTimer = invincibleTimer;}

    /**
     * Setter of the field
     * @param invincible_dead the new status of invincible_dead
     * @author fy916
     */
    public void setInvincible_dead(boolean invincible_dead) {this.invincible_dead = invincible_dead;}

    /**
     * Setter of the field
     * @param onAPlatform the new status of onAPlatform
     * @author fy916
     */
    public void setOnAPlatform(boolean onAPlatform) {isOnAPlatform = onAPlatform;}

    /**
     * Setter of the field
     * @param readyToCharge the new status of readyToCharge
     * @author fy916
     */
    public void setReadyToCharge(boolean readyToCharge) {this.readyToCharge = readyToCharge;}

    /**
     * Setter of the field
     * @param shootDelay the new status of shootDelay
     * @author fy916
     */
    public void setShootDelay(int shootDelay) {this.shootDelay = shootDelay;}

    /**
     * Setter of the field
     * @param stunned the new status of stunned
     * @author fy916
     */
    public void setStunned(boolean stunned) {isStunned = stunned;}

    /**
     * Setter of the field
     * @param shieldTimer the new status of shieldTimer
     * @author fy916
     */
    public void setShieldTimer(int shieldTimer) {this.shieldTimer = shieldTimer;}

    /**
     * Setter of the field
     * @param chargeTimer the new status of chargeTimer
     * @author fy916
     */
    public void setChargeTimer(int chargeTimer) {this.chargeTimer = chargeTimer;}

    /**
     * Setter of the field
     * @param stunTimer the new status of stunTimer
     * @author fy916
     */
    public void setStunTimer(int stunTimer) {this.stunTimer = stunTimer;}




}