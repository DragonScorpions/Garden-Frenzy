package Main;

/**
 * Contains the global state of the game
 * @author Xander
 */
public final class GlobalState {
    /**
     * The name of the currently selected seed
     */
    public static String SelectedSeed = "Harvest";
    
    /**
     * The player data of the currently running game
     */
    public static PlayerData Player = null;
    
    // Static class, don't make instances of this class
    private GlobalState() {}
}
