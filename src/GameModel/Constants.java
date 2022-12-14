package GameModel;

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
     * Note: seed is new Seed(worth,time,stages,price)
     */
    public static final Map<String, Seed> Seeds = Map.of(
        "None", new Seed(0, 999, 999,0),
        "Pumpkin", new Seed(2, 3, 2, 1),
        "Strawberry", new Seed(2, 10, 2, 0),
        "Corn", new Seed(3, 10, 2, 1)
    );
    
    /**
     * The cost to unlock a plot
     */
    public static final int PlotCost = 12;
    
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
