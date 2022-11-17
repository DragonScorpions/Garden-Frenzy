package Main;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author extre
 */
public class UITile extends javax.swing.JPanel {

    /**
     * Creates new form UITile
     */
    private Tile tile;
    
    public UITile() {
        
        initComponents(); //auto-generated, dont mess with me
        this.setBackground(null); // no background for Tiles
        ImageIcon NoSeed = new ImageIcon("src/Images/EmptyTile.png");
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
            }
        });
          
    }
    
    //Init function that initializes the tile to be empty
    public void SetTile(Tile tile) {
        this.tile = tile;
        System.out.print(tile.getCurrentSeed() + " " + tile.getGrowthStage());
        UpdatePlantImage();
    }
    
    public void disable()
    {
        CenterLabel.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CenterLabel = new javax.swing.JLabel();
        seedProgressBar = new javax.swing.JProgressBar();

        setMaximumSize(new java.awt.Dimension(75, 75));
        setMinimumSize(new java.awt.Dimension(75, 75));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(75, 75));

        CenterLabel.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        CenterLabel.setText("jLabel1");
        CenterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CenterLabelMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CenterLabelMouseReleased(evt);
            }
        });

        seedProgressBar.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CenterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seedProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CenterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seedProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    //When the text is clicked, do what?
    private void CenterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CenterLabelMouseClicked

        
    }//GEN-LAST:event_CenterLabelMouseClicked

    private void CenterLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CenterLabelMouseReleased
       if(trySubtractMoney(Constants.Seeds.get(GlobalState.SelectedSeed).GetPrice()))
        {   
            //if player has enough money
            PlantSeed();
        }
    }//GEN-LAST:event_CenterLabelMouseReleased

    //Set the newest current seed
    private void PlantSeed() {
        if(!GlobalState.SelectedSeed.equals("None")) { //If the player is actually planting
            System.out.println("UITile: " + GlobalState.SelectedSeed + " planted!");
            ImageIcon plantedSeed = new ImageIcon("src/Images/growth_1.png");
            CenterLabel.setIcon(plantedSeed);
            tile.Plant(GlobalState.SelectedSeed);
            seedProgressBar.setValue(0);
        } else
            HarvestSeed();
    }
    
    //Harvest the current seed of the tile
    //TODO: get worth of seed and add to player wallet
    private void HarvestSeed()
    {
        System.out.println("UITile: " + tile.getCurrentSeed() + " would harvested!");
        ImageIcon emptyTile = new ImageIcon("src/Images/EmptyTile.png");

        //reset seed tile while adding its worth to player's money amount
        int worth = tile.Harvest();
        System.out.println("UITile: " + worth + " received!");
        GlobalState.Player.addMoney(worth);  
        GlobalState.Player.addPlantGrown();
        CenterLabel.setIcon(emptyTile);
        seedProgressBar.setValue(0);
        
    }
    
    public void Update(float time)
    {
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
    
    //Update the progress bar of time until next growth state
    private void updateProgressBar(float time)
    {
        float percent;
        
        //Note: progress bar is between 0 and 100%, so set value should be from 0 to 100
        if (tile.getGrowthStage() == 2){ // decrease progress bar when fully grown
            percent = 100 - (tile.calcDifference(time) / Constants.Seeds.get(tile.getCurrentSeed()).GetTime() * 100);
        }
        else{ // update progress bar when growing
            percent = tile.calcDifference(time) / Constants.Seeds.get(tile.getCurrentSeed()).GetTime() * 100;
        }
        
        seedProgressBar.setValue((int)Math.ceil(percent));
    }
    
    // Updates the plant icon based on the Tile 
    private void UpdatePlantImage() {
        String seedIcon = "src/Images/";
        if (tile.isRotten() || tile.getCurrentSeed().equals("None"))
            seedIcon += "EmptyTile";
        else if (tile.getGrowthStage() < 2) {
            seedIcon += "growth_";
            seedIcon += tile.getGrowthStage() + 1;
        } else if (tile.getGrowthStage() == 2)
            seedIcon += tile.getCurrentSeed();
        seedIcon += ".png";
        System.out.println(seedIcon);
        ImageIcon plantedSeed = new ImageIcon(seedIcon);
        CenterLabel.setIcon(plantedSeed);
    }
    
        /**
     * Attempt to subtract money from Playerdata. If money becomes negative,
     * it does not subtract and returns false. Else, goes through with the
     * subtraction and return true.
     * @param amount how much money to attempt to remove
     * @return worked was money >= 0 after subtraction?
     */
    private boolean trySubtractMoney(int amount)
    {
        //check if the subtraction would lead to negative money amount
        if(GlobalState.Player.getMoney()-amount < 0)
        {
            return false;
        }
        
        //otherwise actually subtract the money
        GlobalState.Player.addMoney(0-amount);
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CenterLabel;
    private javax.swing.JProgressBar seedProgressBar;
    // End of variables declaration//GEN-END:variables
}
