package com.fy916.bubblebobble.gaming.world;


/**
 * InteractableWorld includes the {@link WorldElements} and the bacis property of the game world
 * such as friction, gravity, etc.
 */
public class InteractableWorld {
    private static final double STATIC_FRICTION = 0.1;
    private static final double GRAVITY = 0.9;
    private static final int TERMINAL_FALL_SPEED = 20;
    private int UNIT_WIDTH = 0;
    private int UNIT_HEIGHT = 0;
    private int UNIT_SIZE = 0;

    private WorldElements worldElements; //The world elements
    private GameStarter gameStarter;
    private GameUpdater gameUpdater;
    private HeroController heroController;


    /**
     * Initialize the game world for Objects to move and display in
     * @param input_unit_width The Unit Width of the game world, note this is not the exact window size but the relevant size
     * @param input_unit_height The Unit Height of the game world, note this is not the exact window size but the relevant size
     * @param input_unit_size The Unit Size of the game world, the window size is the unit width/height times the unit size
     * @author fy916
     */
    public InteractableWorld(int input_unit_width, int input_unit_height, int input_unit_size) {
        //set the values
        setUNIT_WIDTH(input_unit_width);
        setUNIT_HEIGHT(input_unit_height);
        setUNIT_SIZE(input_unit_size);
        //create a new world elements for Objects to be stored in
        this.worldElements = new WorldElements(this);
        this.gameStarter = new GameStarter(worldElements);
        this.gameUpdater = new GameUpdater(worldElements);
        this.heroController = new HeroController(worldElements);
    }


    /**
     * Getter of the field
     * @return STATIC_FRICTION field
     * @author fy916
     */
    public static double getStaticFriction() {
        return STATIC_FRICTION;
    }

    /**
     * Getter of the field
     * @return GRAVITY field
     * @author fy916
     */
    public static double getGRAVITY() {
        return GRAVITY;
    }

    /**
     * Getter of the field
     * @return TERMINAL_FALL_SPEED field
     * @author fy916
     */
    public static int getTerminalFallSpeed() {
        return TERMINAL_FALL_SPEED;
    }

    /**
     * Calculate the height coordinates
     * @return The calculated height which is get from the multiplication of UnitHeight and UnitSize
     * @author fy916
     */
    public int getHeight() {
        return getUNIT_HEIGHT() * getUNIT_SIZE();
    }

    /**
     * Calculate the width coordinates
     * @return The calculated width which is get from the multiplication of UnitWidth and UnitSize
     * @author fy916
     */
    public int getWidth() {
        return getUNIT_WIDTH() * getUNIT_SIZE();
    }

    /**
     * Getter of the field
     * @return UNIT_WIDTH field
     * @author fy916
     */
    public int getUNIT_WIDTH() {
        return UNIT_WIDTH;
    }

    /**
     * Getter of the field
     * @return UNIT_HEIGHT field
     * @author fy916
     */
    public int getUNIT_HEIGHT() {
        return UNIT_HEIGHT;
    }

    /**
     * Getter of the field
     * @return UNIT_SIZE field
     * @author fy916
     */
    public int getUNIT_SIZE() {
        return UNIT_SIZE;
    }

    /**
     * Getter of the field
     * @return {@link WorldElements} type of worldElements field
     * @author fy916
     */
    public WorldElements getWorldElements() {
        return worldElements;
    }

    /**
     * Getter of the field
     * @return {@link GameStarter} type of gameStarter field
     * @author fy916
     */
    public GameStarter getGameStarter() {
        return gameStarter;
    }

    /**
     * Getter of the field
     * @return {@link GameUpdater} type of gameUpdater field
     * @author fy916
     */
    public GameUpdater getGameUpdater() {
        return gameUpdater;
    }

    /**
     * Getter of the field
     * @return {@link HeroController} type of heroController field
     * @author fy916
     */
    public HeroController getHeroController() {
        return heroController;
    }


    /**
     * Setter of the field
     * @param UNIT_WIDTH the new value of UNIT_WIDTH
     * @author fy916
     */
    public void setUNIT_WIDTH(int UNIT_WIDTH) {
        this.UNIT_WIDTH = UNIT_WIDTH;
    }

    /**
     * Setter of the field
     * @param UNIT_HEIGHT the new value of UNIT_HEIGHT
     * @author fy916
     */
    public void setUNIT_HEIGHT(int UNIT_HEIGHT) {
        this.UNIT_HEIGHT = UNIT_HEIGHT;
    }

    /**
     * Setter of the field
     * @param UNIT_SIZE the new value of UNIT_SIZE
     * @author fy916
     */
    public void setUNIT_SIZE(int UNIT_SIZE) {
        this.UNIT_SIZE = UNIT_SIZE;
    }

}
