/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

/**
 *
 * @author Julia
 */
public class BorderHandler{
    
    public void showBorder(JComponent comp, String color, int weight){
        if (comp.isEnabled()){
            comp.setBorder(BorderFactory.createLineBorder(Color.decode(color), weight));
        }
    }
    
    public void hideBorder(JComponent comp){
        if (comp.isEnabled()){
            comp.setBorder(null);
        }
    }
}
