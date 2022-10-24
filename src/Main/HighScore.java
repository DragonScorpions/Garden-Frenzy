package Main;

/**
 * Stores the high score data
 * @author Julia
 */
public class HighScore extends FileData {
    
    private int money;
    private int plots_grown;
    
    
    public HighScore(int rmoney, int rplotsgrown){
        money = rmoney;
        plots_grown = rplotsgrown;
    }
    
    public int getMoney(){
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
