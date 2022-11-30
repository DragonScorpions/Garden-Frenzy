package UIControlComponents;

import GameModel.Constants;
import GameModel.GlobalState;
import GameModel.Plot;
import UIControlComponents.UITile;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The UI representation of a plot
 * @author extre
 */
public class UIPlot extends javax.swing.JPanel {

    private final UITile[] tiles;
    
    private Plot plot;
    
    /**
     * Creates new form UIPlot
     */
    public UIPlot() {
        
        //AutoGenerated
        initComponents();
        setBackground(null); // no background for plots
        
        tiles = new UITile[] { uITile1, uITile2, uITile3, uITile4 };
    }
    
    /**
     * Ties the UIPlot to the underlying Plot class
     * @param plot The Plot instance
     */
    public void SetPlot(Plot plot) {
        this.plot = plot;
        
        for(int t = 0; t < Constants.TilesPerPlot; t++)
            tiles[t].SetTile(plot.tiles[t]);
        
        if (plot.IsLocked())
            AddLockedImage();
    }
    
    /**
     * Updates the plot and its tiles
     * @param time The time since game start
     */
    public void Update(float time) {
        UpdateTiles(time);
    }
    
    /**
     * Updates every tile
     * @param time The time since game start
     */
    private void UpdateTiles(float time) {
        for (UITile tile : tiles)
            tile.Update(time);
    }
    
    /**
     * Adds an overlay image to indicate that the plot is locked
     */
    private void AddLockedImage() {
        // Add locked image on top of tiles
        JButton lockedImage = new JButton();
        lockedImage.setSize(168, 168);
        ImageIcon lockIcon = new ImageIcon(getClass().getResource("/Images/lock.png"));
        lockedImage.setIcon(lockIcon);
        layeredPane.add(lockedImage);
        layeredPane.setLayer(lockedImage, 1);
        
        // When click, if have enough money, unlock, remove lock, and deduct money
        lockedImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                if (GlobalState.Player.getMoney() >= Constants.PlotCost) {
                    GlobalState.Player.addMoney(-12);
                    plot.SetLocked(false);
                    layeredPane.remove(lockedImage);
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layeredPane = new javax.swing.JLayeredPane();
        uITile1 = new UIControlComponents.UITile();
        uITile2 = new UIControlComponents.UITile();
        uITile3 = new UIControlComponents.UITile();
        uITile4 = new UIControlComponents.UITile();

        layeredPane.setLayer(uITile1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(uITile2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(uITile3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(uITile4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredPaneLayout = new javax.swing.GroupLayout(layeredPane);
        layeredPane.setLayout(layeredPaneLayout);
        layeredPaneLayout.setHorizontalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layeredPaneLayout.createSequentialGroup()
                        .addComponent(uITile1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uITile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layeredPaneLayout.createSequentialGroup()
                        .addComponent(uITile3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uITile4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layeredPaneLayout.setVerticalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uITile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uITile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uITile3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uITile4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layeredPane;
    private UIControlComponents.UITile uITile1;
    private UIControlComponents.UITile uITile2;
    private UIControlComponents.UITile uITile3;
    private UIControlComponents.UITile uITile4;
    // End of variables declaration//GEN-END:variables
}
