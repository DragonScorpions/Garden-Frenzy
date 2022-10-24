/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Julia
 */
public class HighScore {
    
    private int money;
    private int plots_grown;
    
    
    // Added by Julian as a placeholder - Used in the StartScreen constructor
    public HighScore(){
        money = 100;
        plots_grown = 0;
    }
    
    public HighScore(int rmoney, int rplotsgrown){
        money = 100;
        plots_grown = rplotsgrown;
    }
    
    public int getMoney(){
        money = 5;
        return money;
    }
    
    public int getPlotsGrown(){
        return plots_grown;
    }
    
    
    
}
