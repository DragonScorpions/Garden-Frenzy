package UIHelpers;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

/**
 * A handler class to show borders around components
 * @author Julia
 */
public class BorderHandler{
    
    /**
     * Adds a border around a component
     * @param comp The component
     * @param color The color of the border
     * @param weight The width of the border
     */
    public void showBorder(JComponent comp, String color, int weight){
        if (comp.isEnabled())
            comp.setBorder(BorderFactory.createLineBorder(Color.decode(color), weight));
    }
    
    /**
     * Removes the border around a component
     * @param comp The component
     */
    public void hideBorder(JComponent comp){
        if (comp.isEnabled())
            comp.setBorder(null);
    }
}
