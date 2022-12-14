package UIHelpers;

import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Extension of TimerTask to support storing elapsed time
 * @author willfreeman
 */
abstract class AnimationTimerTask extends TimerTask {
    /**
     * time elapsed from start of animation
     */
    long elapsedTime = 0L;
}

/**
 * A class that handles the animation of a component
 * @author willfreeman
 */
public class Animation {
    /**
     * Translates a component from startingBounds to endingBounds
     * @param component component to animate
     * @param startingBounds start position
     * @param endingBounds end position
     * @param timeMs animation time
     */
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
