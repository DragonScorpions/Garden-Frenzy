package GameModel;

/**
 * Stores the high score data
 * @author Xander
 */
public class HighScore extends FileData {

    private int money;
    private int plants_grown;

    /**
     * Default constructor with for a blank highscore to be loaded
     */
    public HighScore() {
        money = 0;
        plants_grown = 0;
    }

    /**
     * Create new highscore with the given values
     * @param money The money in the highscore
     * @param plantsgrown The number of plots grown
     */
    public HighScore(int money, int plantsgrown) {
        this.money = money;
        this.plants_grown = plantsgrown;
    }

    /**
     * Gets the money of the highscore
     * @return The amount
     */
    public int getMoney() {
        return money;
    }

    /**
     * Get the number of plots grown
     * @return The number
     */
    public int getPlantsGrown() {
        return plants_grown;
    }

    /**
     * Return a string of the fields to be saved
     * @return string of the fields
     */
    @Override
    protected String ToFileString() {
        return money + ", " + plants_grown;
    }
    
    /**
     * Fill fields with fields from a file
     * @param data The data retrieves from a file
     */
    @Override
    protected void ParseFileString(String data) {
        String[] properties = data.split(", ");
        money = Integer.parseInt(properties[0]);
        plants_grown = Integer.parseInt(properties[1]);
    }
    
    /**
     * Return filename of file
     * @return filename
     */
    @Override
    protected String GetFileName() {
        return Constants.HighScoreFile;
    }
}
