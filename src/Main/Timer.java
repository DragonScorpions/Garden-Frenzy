package Main;

/**
 * Maintains the timings for the game
 * @author xande
 */
public final class Timer {
    // The milliseconds per update
    private static final int mpu = 17;
    // The seconds per update
    private static final float spu = mpu / 1000f;
    
    // The java timer that is used as the underlying implementation
    private static java.util.Timer javaTimer;
    
    // The update listeners that get called on update
    private static UpdateListener updateListener = null;
    
    // The time since the last timer start in seconds
    private static float time = 0;
    
    /**
     * Sets the listener that will be notified when the Timer updates
     * @param listener The listener that will be notified
     */
    public static void SetUpdateListener(UpdateListener listener) {
        updateListener = listener;
    }

    /**
     * Starts the timer loop
     */
    public static void Start() {
        // Need to create a new timer every time because a canceled timer can't
        // be started again.
        javaTimer = new java.util.Timer(true);

        javaTimer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                if (updateListener != null)
                    updateListener.Update(time += spu);
            }
        }, 0, mpu);
    }

    /**
     * Stops the timer, resets the time, and removes the listener, it won't
     * notify the listener any longer
     */
    public static void Stop() {
        updateListener = null;

        javaTimer.cancel();

        time = 0;
    }

    /**
     * Gets the time since timer start in seconds
     * @return Time since timer start in seconds
     */
    public static float GetTime() {
        return time;
    }

    /**
     * Sets the current time, useful for loading from save file
     * @param time The time since timer start to fake
     */
    public static void SetTime(float time) {
        Timer.time = time;
    }

    /**
     * A listener for the Timer updates
     */
    public static interface UpdateListener {
        /**
         * Calls this method when the Timer updates
         * @param time the time since the timer started in seconds
         */
        public void Update(float time);
    }
    
    // Static class, don't make instances of this class
    private Timer() {}
}
