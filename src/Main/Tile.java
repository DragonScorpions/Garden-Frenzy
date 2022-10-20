/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.util.Map;

/**
 *
 * @author Julia
 */
public class Tile {
    
    String currentSeed; //The current seed this tile holds
    boolean enabled; //Can the user interact with this tile?
    int growth_stage; //What state of growth is the seed in?
    float time_since_growth; //When was the last time growth stage was updated?
                      //In seconds from game start
                      //(min=0=game start, max=game end time in seconds)
    
    //The seed map, with each name of the seed stored with its value
    Map<String, Integer> seed_worth = Map.of(
    "None", 0,
    "Pumpkin", 1,
    "Wheat", 2,
    "Corn", 3
     );
    
    //The seed map, with each name of the seed stored with how many stages it has
    Map<String, Integer> seed_stages = Map.of(
    "None", 999,
    "Pumpkin", 2,
    "Wheat", 2,
    "Corn", 2
     );
    
    //The seed map, with each name of the seed stored with how long a stage is
    //in seconds
    Map<String, Integer> seed_time = Map.of(
    "None", 999,
    "Pumpkin", 10,
    "Wheat", 10,
    "Corn", 10
     );
    
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
        if(growth_stage == seed_stages.get(currentSeed) )
        {
            worth = seed_worth.get(currentSeed); //Get the worth of the current seed
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
        if(growth_stage <= seed_stages.get(currentSeed))
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
        if(seed_time.get(currentSeed) >= time_difference)
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
