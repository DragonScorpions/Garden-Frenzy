package Main;

import java.util.Arrays;

/**
 * Stores the player's values
 * @author Julia and Xander
 */
public class PlayerData extends FileData {
    private int money;
    private int plants_grown;
    private int plots_unlocked;
    
    /**
     * Plots in the game session and their associated tiles
     */
    public Plot[] plots = new Plot[Constants.NumPlots];
    
    /**
     * Default constructor for blank PlayerData
     */
    public PlayerData() {
        money = 2;
        plants_grown = 0;
        plots_unlocked = 0;
        //initialize plots - make this a function later
        for(int i =0;i<9;i++)
            plots[i] = new Plot(i != 0);
    }
    
    /**
     * Gets the money of the player
     * @return The amount
     */
    public int getMoney() {
        return money;
    }
     
    /**
     * adds specified amount to the player's money
     * @param amount the amount of money to be added.
     */
    public void addMoney(int amount) {
        money+=amount;
    }
    
    /**
     * Checks if the player has
     * @return player has money
     */
    public boolean hasMoney(){
        return money > 0;
    }
    
    /**
     * Adds 1 to the amount of plants grown
     */
    public void addPlantGrown(){ 
        plants_grown += 1;
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
        
        for(int p = 0; p < Constants.NumPlots; p++)
            fileString += plots[p].ToSaveString();
            
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
        
        for(int p = 0, line = 1; p < Constants.NumPlots; p++)
            line += plots[p].FromPropertyList(Arrays.copyOfRange(properties, line, properties.length));
    }

    @Override
    protected String GetFileName() {
        return Constants.SaveFile;
    }
}
