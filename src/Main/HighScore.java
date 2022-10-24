package Main;

/**
 * Stores the high score data
 * @author Julia
 */
public class HighScore extends FileData {
    
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

    @Override
    protected String ToFileString() {
        return money + ", " + plots_grown;
    }

    @Override
    protected void ParseFileString(String data) {
        String[] properties = data.split(", ");
        money = Integer.parseInt(properties[0]);
        plots_grown = Integer.parseInt(properties[1]);
    }
}
