/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Ian
 */
public class Plot {
    public Tile[] tiles = new Tile[Constants.TilesPerPlot];
    
    public Plot()
    {
        for(int i=0;i<4;i++)
        {
            tiles[i] = new Tile();
        }
    }
    
    public boolean hasSeeds(){
        boolean hasSeeds = false;
        
        for (Tile tile : tiles){
            hasSeeds = tile.isFilled();
            if (hasSeeds == true){
                return true;
            }
        }
        
        return hasSeeds;
    }
}
