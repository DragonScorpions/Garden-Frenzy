package GameModel;

/**
 * Encapsulates the behavior of a tile in the game, where seeds are planted and
 * plants grow and are harvested.
 * @author Julia
 */
public class Tile {
    
    private String currentSeed; //The current seed this tile holds
    private int growth_stage; //What state of growth is the seed in?
    private float timeAtGrowth; //When was the last time growth stage was updated?
                                //In seconds from game start
                                //(min=0=game start, max=game end time in seconds)
    private boolean rotten; //is the tile rotten?
    
    /**
     * The default constructor
     */
    public Tile() {
        currentSeed = "None";
        growth_stage = 0;
        timeAtGrowth = 0;
        rotten = false;
    }
    
    /**
     * Gets the current seed planted
     * @return The planted seed
     */
    public String getCurrentSeed() {
        return currentSeed;
    }
    
    /**
     * Gets whether or not the current seed is rotten
     * @return True if rotten
     */
    public boolean isRotten() {
        return rotten;
    }
    
    /**
     * Gets whether or not the current tile has a seed planted
     * @return True if there is a seed planted
     */
    public boolean isFilled(){
        return !"None".equals(currentSeed);
    }
    
    /**
     * Gets the current growth stage of the tile
     * @return The current growth stage
     */
    public int getGrowthStage(){
        return growth_stage;
    }
    
    /**
     * Gets the game time that the last growth stage was achieved
     * @return The game time
     */
    public float getTimeAtGrowth(){
        return timeAtGrowth;
    }
    
   /**
   * Harvests the seed, giving money to player and resetting tile.
   * Checks the seed against the seed dictionary, and gives money to the player
   * based on the growth state. Then resets the tile.
   * @return money How much money the seed was worth.
   */
    public int Harvest() {
        int worth;
        //If growth state is equal to the ripe time, give player full money
        if(growth_stage == Constants.Seeds.get(currentSeed).GetStages())
            worth = Constants.Seeds.get(currentSeed).GetWorth(); //Get the worth of the current seed
        else //If it is not ripe yet, or has spoiled, return no money. 
            worth = 0;
        
        Plant("None");
        return worth; // return money gained - based on growth stage
    }
    
    /**
   * Plants the given seed.
   * Sets the tile's seed equal to the received seed.
   * @param seed (string) What seed is being planted?
   */
    public void Plant(String seed) {
        currentSeed = seed;
        growth_stage = 0;
        timeAtGrowth = Timer.GetTime();
        rotten = false;
    }
    
    /**
   * Updates the growth stage of the tile
   * Advances tile's growth stage by one if it has not spoiled.
   * 
   */
    private void updateGrowthState() {
        //Check if the current seed is ripe or is still growing
        if(growth_stage <= Constants.Seeds.get(currentSeed).GetStages())
            growth_stage++;
        
        //Else, don't update. If this doesn't trigger,
        //then the growth stage will be equal to one HIGHER than its ripe stage.
        //This is intentional.
        
        //set seed to rotten if its growth stage passed the ripe stage
        if(growth_stage > Constants.Seeds.get(currentSeed).GetStages())
            rotten = true;
    }
    
    /**
   * Calculates if seed's stage should be increases.
   * Takes the time and increases seed's growth state if enough time
   * has passed.
   * @param cur_time (float) How many seconds have passed since the game started
   * @return boolean if the tile's stage was increased
   */
    private boolean calcProgress(float cur_time) {
        //Calculate the difference between time since the last growth update  and the current time.
        float time_difference = calcDifference(cur_time);
        
        //If the difference is equal to seed_time value, then update the current growth stage
        //and reset time_since_growth.
        if(Constants.Seeds.get(currentSeed).GetTime() <= time_difference) {
            updateGrowthState();
            timeAtGrowth = cur_time;
            return true;
        }
        return false;
    }
    
    /**
     * Calculates how much time there will be between growth stages.
     * @param cur_time the current time
     * @return how long it has been since the seed jumped stages.
    */
    public float calcDifference(float cur_time) {
        return cur_time-timeAtGrowth;
    }
    
    /**
   * Updates the tile
   * Takes the time and increases seed's growth state if enough time
   * has passed.
   * @return Boolean if the growth stage was advanced
   * @param cur_time (float) How many seconds have passed since the game started.
   */
    public boolean Update(float cur_time){
        return calcProgress(cur_time);
    }
    
    /**
     * Makes a string from the Tile state that can be recovered from later
     * @return Tile as a string
     */
    public String ToSaveString() {
        return currentSeed + ", " + growth_stage + ", " + timeAtGrowth + ", " + rotten;
    }
    
    /**
     * Recovers state of Tile from string
     * @param data The string to recover from
     */
    public void FromSaveString(String data) {
        String[] fields = data.split(", ");
        currentSeed = fields[0];
        growth_stage = Integer.parseInt(fields[1]);
        timeAtGrowth = Float.parseFloat(fields[2]);
        rotten = Boolean.parseBoolean(fields[3]);
    }
}
