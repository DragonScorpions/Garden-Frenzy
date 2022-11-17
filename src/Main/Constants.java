package Main;

import java.util.Map;

/**
 * Contains the constants of the program
 * @author Xander
 */
public final class Constants {
    /**
     * The file where the player data is saved
     */
    public static final String SaveFile = "save";
    
    /**
     * The file where the high score is saved
     */
    public static final String HighScoreFile = "hs";
    
    /**
     * All the available seeds of the game organized by name
     * Note: seed is new Seed(worth,time,stages)
     */
    public static final Map<String, Seed> Seeds = Map.of(
        "None", new Seed(0, 999, 999),
        "Pumpkin", new Seed(1, 3, 2),
        "Wheat", new Seed(2, 10, 2),
        "Corn", new Seed(3, 10, 2)
    );
    
    /**
     * The number of plots in a game
     */
    public static final int NumPlots = 9;
    
    /**
     * The number of tiles per plot
     */
    public static final int TilesPerPlot = 4;
    
    // Static class, don't make instances of this class
    private Constants() {}
}
