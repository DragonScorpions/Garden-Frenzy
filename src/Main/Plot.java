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
    public Tile[] tiles = new Tile[9];
    
    public Plot()
    {
        for(int i=0;i<9;i++)
        {
            tiles[i] = new Tile();
        }
    }
    
    
    
}
