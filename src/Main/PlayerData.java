/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Julia
 */
public class PlayerData {
    
    private int money;
    private int plants_grown;
    private int plots_unlocked;
   /**
   * The default constructor of Playerdata.
   * Sets all init values to zero
   * @param money (int) How much money the player has.  
   * @param plants_grown  (int) How many plants total has the player grown.
   * @param plots_unlocked (int) How many plots has the player unlocked
   */
    public PlayerData(int money, int plants_grown, int plots_unlocked){
            this.money = money;
            this.plants_grown = plants_grown;
            this.plots_unlocked = plots_unlocked;
    }
    
    public int getMoney()
    {
        return money;
    }
    
    public int getPlantsGrown()
    {
        return plants_grown;
    }
   
}
