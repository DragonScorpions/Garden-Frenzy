package Main;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

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
       
    }

    //Changes the seed that will be planted when this tile is clicked
    public void prepareNewSeed(String seed)
    {
        //seedToPlant = seed;
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
        CButton = new javax.swing.JButton();

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

        CButton.setText("Click me!");
        CButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(CenterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CenterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CButtonActionPerformed
        CenterLabel.setText(
                "<html>" + 
                tile.currentSeed + "<br/>" +
                String.valueOf(tile.getEnabled()) + "<br/>"+
                String.valueOf(tile.getGrowthStage()) + "<br/>"+
                String.valueOf(tile.getTimeSinceGrowth()) + "</html>");
                
    }//GEN-LAST:event_CButtonActionPerformed

    
    //When the text is clicked, do what?
    private void CenterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CenterLabelMouseClicked

        
    }//GEN-LAST:event_CenterLabelMouseClicked

    private void CenterLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CenterLabelMouseReleased
        PlantSeed();
    }//GEN-LAST:event_CenterLabelMouseReleased

    //Set the newest current seed
    private void PlantSeed()
    {
        //reset the seed no matter wha.
        //yes this means if there is a seed already there, it will be harvested
        //This is intentional to prevent rapid clicking.
        HarvestSeed(); 
        
        if(!GlobalState.SelectedSeed.equals("None")) //If the player is actually planting
        {
            
            System.out.println("UITile: " + GlobalState.SelectedSeed + " planted!");
            ImageIcon plantedSeed = new ImageIcon("src/Images/growth_1.png");
            CenterLabel.setIcon(plantedSeed);
            tile.currentSeed = GlobalState.SelectedSeed;
        }
    }
    
    //Harvest the current seed of the tile
    //TODO: get worth of seed and add to player wallet
    private void HarvestSeed()
    {
        System.out.println("UITile: " + tile.currentSeed + " would harvested!");
        ImageIcon emptyTile = new ImageIcon("src/Images/EmptyTile.png");
        
        //reset seed tile while adding its worth to player's money amount
        int worth = tile.Harvest();
        System.out.println("UITile: " + worth + " received!");
        GlobalState.Player.addMoney(worth); 
        
        CenterLabel.setIcon(emptyTile);
        
        
    }
    
    public void Update(float time)
    {
        if(tile.Update(time)) //If the growth state has been advanced.
        {
            String seedIcon = "src/Images/";
            if (tile.currentSeed.equals("None"))
                seedIcon += "EmptyTile";
            else if (tile.getGrowthStage() < 2) {
                seedIcon += "growth_";
                seedIcon += tile.getGrowthStage() + 1;
            } else if (tile.getGrowthStage() == 2)
                seedIcon += tile.currentSeed;
            seedIcon += ".png";
            System.out.println(seedIcon);
            ImageIcon plantedSeed = new ImageIcon(seedIcon);
            CenterLabel.setIcon(plantedSeed);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CButton;
    private javax.swing.JLabel CenterLabel;
    // End of variables declaration//GEN-END:variables
}
