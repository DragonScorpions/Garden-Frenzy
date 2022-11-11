package Main;

/**
 * Stores the player's values
 *
 * @author Julia and Xander
 */
public class PlayerData extends FileData {
    private int money;
    private int plants_grown;
    private int plots_unlocked;
    public Plot[] plots = new Plot[Constants.NumPlots];
    
    /**
     * Default constructor for blank PlayerData
     */
    public PlayerData() {
        money = 0;
        plants_grown = 0;
        plots_unlocked = 0;
        //initialize plots - make this a function later
        for(int i =0;i<9;i++)
            plots[i] = new Plot();
    }
    
    /**
     * Gets the money of the player
     * @return The amount
     */
    public int getMoney() {
        return money;
    }

    /**
     * Gets the player's plants grown
     * @return The number
     */
    public int getPlantsGrown() {
        return plants_grown;
    }
    
    /**
     * Transforms this PlayerData into a HighScore to be compared and replace the old one
     * @return This PlayerData as a HighScore
     */
    public HighScore ToHighScore() {
        return new HighScore(money, plants_grown);
    }

    @Override
    protected String ToFileString() {
        String fileString = money + ", " + plants_grown + ", " + plots_unlocked + ", " + Timer.GetTime() + "\n";
        
        for(int p = 0; p < Constants.NumPlots; p++) {
            for(int t = 0; t < Constants.TilesPerPlot; t++) {
                fileString += plots[p].tiles[t].ToSaveString() + "\n";
            }
        }
            
        return fileString;
    }

    @Override
    protected void ParseFileString(String data) {
        String[] properties = data.split("\n");
        
        String[] fields = properties[0].split(", ");
        money = Integer.parseInt(fields[0]);
        plants_grown = Integer.parseInt(fields[1]);
        plots_unlocked = Integer.parseInt(fields[2]);
        Timer.SetTime(Float.parseFloat(fields[3]));
        
        for(int p = 0, i = 1; p < Constants.NumPlots; p++) {
            for(int t = 0; t < Constants.TilesPerPlot; t++) {
                plots[p].tiles[t].FromSaveString(properties[i++]);
            }
        }
    }

    @Override
    protected String GetFileName() {
        return Constants.SaveFile;
    }
}
