package Main;

/**
 * Contains several tiles and starts locked
 * @author Ian
 */
public class Plot {
    public Tile[] tiles = new Tile[Constants.TilesPerPlot];
    
    private boolean locked = true;
    
    /**
     * Constructs an empty plot with 4 tiles
     * @param locked Whether or not the plot is locked by default
     */
    public Plot(boolean locked) {
        this.locked = locked;
        
        for(int i=0;i<4;i++)
            tiles[i] = new Tile();
    }
    
    /**
     * Gets whether or not the plot is locked
     * @return True if locked
     */
    public boolean IsLocked() {
        return locked;
    }
    
    /**
     * Sets whether or not the plot is locked
     * @param locked True if locked
     */
    public void SetLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Makes a string from the Plot state that can be recovered from later
     * @return Tile as a string
     */
    public String ToSaveString() {
        String saveString = locked + "\n";
        for(int t = 0; t < Constants.TilesPerPlot; t++)
            saveString += tiles[t].ToSaveString() + "\n";
        return saveString;
    }

    /**
     * Recovers state of Plot from an array of strings
     * @param properties The strings to recover from
     * @return returns lines used
     */
    public int FromPropertyList(String[] properties) {
        locked = Boolean.parseBoolean(properties[0]);
        for(int t = 0; t < Constants.TilesPerPlot; t++)
            tiles[t].FromSaveString(properties[t + 1]);
        return 1 + Constants.TilesPerPlot;
    }
}
