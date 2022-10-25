/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Julia
 */
public class PlayerData extends FileData {
    
    private int money;
    private int plants_grown;
    private int plots_unlocked;
    
    /**
     * Default constructor for blank PlayerData
     */
    public PlayerData() {
        money = 0;
        plants_grown = 0;
        plots_unlocked = 0;
    }
    
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

    @Override
    protected String ToFileString() {
        return money + ", " + plants_grown + ", " + plots_unlocked;
    }

    @Override
    protected void ParseFileString(String data) {
        String[] properties = data.split(", ");
        money = Integer.parseInt(properties[0]);
        plants_grown = Integer.parseInt(properties[1]);
        plots_unlocked = Integer.parseInt(properties[2]);
    }
}
