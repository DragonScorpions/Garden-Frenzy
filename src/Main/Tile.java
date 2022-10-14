/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Julia
 */
public class Tile {
    
    String currentSeed;
    boolean isEnabled = false;
    
    
    
    
    
    
    
    public void disable(){
        isEnabled = false;
    }
    
    public void enable(){

        isEnabled = true;
    }

    
    
    // Only harvest if enabled
    public int Harvest(){
        currentSeed = " ";
        
        return 0; // return money gained - based on dictionary - paceholder
    }
    
    
    public void setCurrentSeed(String rcurrentSeed){
        currentSeed = rcurrentSeed;
    
    }
    
    private void updateGrowthState(){
        
    }
    
    //Checks plant dictionary to see if amount of time has passed for seed to grow
    //Calls updateGrowthState if it is time for seed to grown
    private void calcProgress(){
        
        
    }
    
    //update seedstate - calls calcProgress
    public void Update(){
        
    }
}
