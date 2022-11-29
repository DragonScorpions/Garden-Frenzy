/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author willfreeman
 */

abstract class AnimationTimerTask extends TimerTask {
    long elapsedTime = 0L;
}

public class Animation {
    public static void animate(JComponent component, Rectangle startingBounds, Rectangle endingBounds, long timeMs) {
        final Timer timer = new Timer();
        final long interval = 100L;
        
        Rectangle originalComponentBounds = component.getBounds();
        double steps = timeMs / interval;
        
        int deltaX = (int) ((endingBounds.x - startingBounds.x) / steps);
        int deltaY = (int) ((endingBounds.y - startingBounds.y) / steps);
        
        // move component to starting position
        component.setBounds(
            startingBounds.x,
            startingBounds.y,
            originalComponentBounds.width,
            originalComponentBounds.height
        );
        
        component.setVisible(true);
        
        System.out.println(
            "Animieren der Münze von (" +
            startingBounds.x + "," + startingBounds.y +
            ") auf (" + endingBounds.x + "," + endingBounds.y + ")"
        );
        
        timer.scheduleAtFixedRate(new AnimationTimerTask(){            
            @Override
            public void run() {
                if (this.elapsedTime >= timeMs) {
                    this.cancel();
                    component.setVisible(false);
                } else {
                    Rectangle currentBounds = component.getBounds();
                    component.setBounds(
                        currentBounds.x + deltaX,
                        currentBounds.y + deltaY,
                        currentBounds.width,
                        currentBounds.height
                    );
                }
                this.elapsedTime += interval;
            }
        }, 0, interval);
        
        
    }
}
