package Main;

/**
 * Encapsulates the behavior of a tile in the game, where seeds are planted and
 * plants grow and are harvested.
 * @author Julia
 */
public class Tile {
    
    public String currentSeed; //The current seed this tile holds
    private boolean enabled; //Can the user interact with this tile?
    private int growth_stage; //What state of growth is the seed in?
    private float time_since_growth; //When was the last time growth stage was updated?
                      //In seconds from game start
                      //(min=0=game start, max=game end time in seconds)
    
    public Tile()
    {
        currentSeed = "None";
        enabled = false;
        growth_stage = 0;
        time_since_growth = 0;
    }
    
    public void disable(){
        enabled = false;
    }
    
    public void enable()
    {
        enabled= true;
    }
    
    public boolean getEnabled(){
        return enabled;
    }
    
    public int getGrowthStage(){
        return growth_stage;
    }
    
    public float getTimeSinceGrowth(){
        return time_since_growth;
    }
    
   /**
   * Harvests the seed, giving money to player and resetting tile.
   * Checks the seed against the seed dictionary, and gives money to the player
   * based on the growth state. Then resets the tile.
   * @return money How much money the seed was worth.
   */
    public int Harvest()
    {
        int worth;
        //If growth state is equal to the ripe time, give player full money
        if(growth_stage == Constants.Seeds.get(currentSeed).GetStages())
        {
            worth = Constants.Seeds.get(currentSeed).GetWorth(); //Get the worth of the current seed
        }
        else //If it is not ripe yet, or has spoiled, return no money. 
        {
            worth = 0;
        }
        //TODO: Add sound effect to play? Or return sound effect?
        currentSeed = " "; //Remove the seed
        growth_stage = 0; //reset the growth stage
        return worth; // return money gained - based on growth stage
    }
    
    /**
   * Plants the given seed.
   * Sets the tile's seed equal to the received seed.
   * @param seed (string) What seed is being planted?
   * @param time (float) How many seconds from game start did planting occur?
   */
    public void Plant(String seed, float time)
    {
        if(enabled)
        {
            currentSeed = seed;
            time_since_growth = time;
        }
    }
    
    /**
   * Updates the growth stage of the tile
   * Advances tile's growth stage by one if it has not spoiled.
   * 
   */
    private void updateGrowthState()
    {
        //Check if the current seed is ripe or is still growing
        if(growth_stage <= Constants.Seeds.get(currentSeed).GetStages())
            growth_stage++;
        //Else, don't update. If this doesn't trigger,
        //then the growth stage will be equal to one HIGHER than its ripe stage.
        //This is intentional.
        //TODO: Maybe return the state it is in and its associated image?
    }
    
    /**
   * Calculates if seed's stage should be increases.
   * Takes the time and increases seed's growth state if enough time
   * has passed.
   * @param cur_time (float) How many seconds have passed since the game started
   */
    private void calcProgress(float cur_time)
    {
        //Calculate the difference between time since the last growth update  and the current time.
        float time_difference = cur_time-time_since_growth;
        
        //If the difference is equal to seed_time value, then update the current growth stage
        //and reset time_since_growth.
        if(Constants.Seeds.get(currentSeed).GetTime() >= time_difference)
        {
            updateGrowthState();
            time_since_growth = cur_time;
        }
    }
    
    /**
   * Updates the tile
   * Takes the time and increases seed's growth state if enough time
   * has passed.
   * @param cur_time (float) How many seconds have passed since the game started.
   */
    public void Update(float cur_time){
        calcProgress(cur_time);
    }
}
