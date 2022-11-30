package GameModel;

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
     * How much does this seed cost to plant?
     */
    private final int price;
    
    /**
     * Creates a new seed with the given values
     * @param worth The amount of money gotten from harvesting the plant
     * @param time The amount of time it takes the seed to grow
     * @param stages The amount of growth stages that the plant has
     * @param price The amount of money a seed a cost
     */
    public Seed(int worth, int time, int stages, int price) {
        this.worth = worth;
        this.time = time;
        this.stages = stages;
        this.price = price;
    }
    
    /**
     * Gets the amount of money gotten from harvesting the plant
     * @return amount of money
     */
    public int GetWorth() { return worth; }
    
    /**
     * Gets the price of the seed the user must pay
     * @return cost of seed
     */
    public int GetPrice() { return price; }
    
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
