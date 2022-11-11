package Main;

/**
 * Gets the data on a seed
 * @author xande
 */
public class Seed {
    /**
     * The amount of money gotten from harvesting the plant
     */
    private final int worth;
    
    /**
     * The amount of time it takes to finish a growth stage in seconds
     */
    private final int time;
    
    /**
     * The amount of growth stages that the plant has
     */
    private final int stages;
    
    /**
     * Creates a new seed with the given values
     * @param worth The amount of money gotten from harvesting the plant
     * @param time The amount of time it takes the seed to grow
     * @param stages The amount of growth stages that the plant has
     */
    public Seed(int worth, int time, int stages) {
        this.worth = worth;
        this.time = time;
        this.stages = stages;
    }
    
    /**
     * Gets the amount of money gotten from harvesting the plant
     * @return amount of money
     */
    public int GetWorth() { return worth; }
    
    /**
     * Gets the amount of time it takes to finish a growth stage in seconds
     * @return amount of time
     */
    public int GetTime() { return time; }
    
    /**
     * Gets the amount of growth stages that the plant has
     * @return amount of growth stages
     */
    public int GetStages() { return stages; }
}
