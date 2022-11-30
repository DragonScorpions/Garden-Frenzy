package UIControlComponents;
import GameModel.Constants;
import GameModel.GlobalState;
import GameModel.Tile;
import UIHelpers.BorderHandler;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;

/**
 * GUI Representation of a Tile
 * @author extre
 */
public class UITile extends javax.swing.JPanel {

    /**
     * Creates new form UITile
     */
    private Tile tile;
    
    /**
     * Creates a new UITile
     */
    public UITile() {
        
        initComponents(); //auto-generated, dont mess with me
        setBackground(null); // no background for Tiles
        ImageIcon NoSeed = new ImageIcon(getClass().getResource("/Images/EmptyTile.png"));
        CenterLabel.setIcon(NoSeed);
        
        BorderHandler borderhandler = new BorderHandler();
        CenterLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
                borderhandler.showBorder((UITile) CenterLabel.getParent(), "#ff8066", 1);
            } 
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt){
                borderhandler.hideBorder((UITile) CenterLabel.getParent());
                setErrorText(""); //Reset whatever error was previously shown.
            }
        });
          
    }
    
    /**
     * Ties the UITile to the underlying Tile class
     * @param tile The Tile instance
     */
    public void SetTile(Tile tile) {
        this.tile = tile;
        UpdatePlantImage();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ErrorPane = new javax.swing.JLayeredPane();
        ErrorText = new javax.swing.JLabel();
        CenterLabel = new javax.swing.JLabel();
        seedProgressBar = new javax.swing.JProgressBar();

        setMaximumSize(new java.awt.Dimension(75, 75));
        setMinimumSize(new java.awt.Dimension(75, 75));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(75, 75));

        ErrorText.setFocusable(false);

        ErrorPane.setLayer(ErrorText, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout ErrorPaneLayout = new javax.swing.GroupLayout(ErrorPane);
        ErrorPane.setLayout(ErrorPaneLayout);
        ErrorPaneLayout.setHorizontalGroup(
            ErrorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorPaneLayout.createSequentialGroup()
                .addComponent(ErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        ErrorPaneLayout.setVerticalGroup(
            ErrorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorPaneLayout.createSequentialGroup()
                .addComponent(ErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        CenterLabel.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        CenterLabel.setText("jLabel1");
        CenterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CenterLabelMouseReleased(evt);
            }
        });

        seedProgressBar.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(seedProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ErrorPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(CenterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(seedProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ErrorPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(CenterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 31, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void CenterLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CenterLabelMouseReleased
        PlantSeed();
    }//GEN-LAST:event_CenterLabelMouseReleased

    private void setErrorText(String text) {
        ErrorText.setText(text);
    }
    
    /**
     * Plants the seed currently selected by the user
     */
    private void PlantSeed() {
        //If the player is actually planting
        if(!GlobalState.SelectedSeed.equals("None")) { 
            // If the tile does not already have a plant on it
            if (!tile.isFilled()) { 
                // Test if has enough money to buy seed
                int seedPrice = Constants.Seeds.get(GlobalState.SelectedSeed).GetPrice();
                if(GlobalState.Player.getMoney() >= seedPrice) {   
                    //if player has enough money
                    GlobalState.Player.addMoney(-seedPrice);
                    ImageIcon plantedSeed = new ImageIcon(getClass().getResource("/Images/growth_1.png"));
                    CenterLabel.setIcon(plantedSeed);
                    tile.Plant(GlobalState.SelectedSeed);
                    seedProgressBar.setValue(0);
                } else //player doesn't have enough money
                    setErrorText("No Money!");
            } else
                setErrorText("Has Plant!");
        } else
            HarvestSeed();
    }
    
    /**
     * Harvests the plant within the tile and adds its value to player balance
     */
    private void HarvestSeed() {
        ImageIcon emptyTile = new ImageIcon(getClass().getResource("/Images/EmptyTile.png"));

        //reset seed tile while adding its worth to player's money amount
        int worth = tile.Harvest();
        GlobalState.Player.addMoney(worth);  
        GlobalState.Player.addPlantGrown();
        CenterLabel.setIcon(emptyTile);
        seedProgressBar.setValue(0);
        
    }
    
    /**
     * Update's plant's growth status based on elapsed time
     * @param time current game time
     */
    public void Update(float time) {
        if(tile.Update(time)) { //If the growth state has been advanced.
            UpdatePlantImage();
            if (tile.isRotten())
                seedProgressBar.setValue(0);
        }
         
        //only update the bar if there is a seed planted in the tile
        //and if the current tile is not rotten 
        if(!tile.getCurrentSeed().equals("None") && !tile.isRotten())
            updateProgressBar(time); 
    }
    
    /**
     * Update the progress bar of time until next growth state
     * @param time current game time
     */
    private void updateProgressBar(float time) {
        float percent;
        //Note: progress bar is between 0 and 100%, so set value should be from 0 to 100
        if (tile.getGrowthStage() == 2) // decrease progress bar when fully grown
            percent = 100 - (tile.calcDifference(time) / Constants.Seeds.get(tile.getCurrentSeed()).GetTime() * 100);
        else // update progress bar when growing
            percent = tile.calcDifference(time) / Constants.Seeds.get(tile.getCurrentSeed()).GetTime() * 100;
        
        seedProgressBar.setValue((int)Math.ceil(percent));
    }
    
    /**
     * Updates the plant icon based on the Tile 
     */
    private void UpdatePlantImage() {
        String seedIcon = "/Images/";
        if (tile.isRotten() || tile.getCurrentSeed().equals("None"))
            seedIcon += "EmptyTile";
        else if (tile.getGrowthStage() < 2) {
            seedIcon += "growth_";
            seedIcon += tile.getGrowthStage() + 1;
        } else if (tile.getGrowthStage() == 2)
            seedIcon += tile.getCurrentSeed();
        seedIcon += ".png";
        ImageIcon plantedSeed = new ImageIcon(getClass().getResource(seedIcon));
        CenterLabel.setIcon(plantedSeed);
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CenterLabel;
    private javax.swing.JLayeredPane ErrorPane;
    private javax.swing.JLabel ErrorText;
    private javax.swing.JProgressBar seedProgressBar;
    // End of variables declaration//GEN-END:variables
}