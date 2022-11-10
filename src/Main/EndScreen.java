package Main;

import javax.swing.JFrame;

/**
 *
 * @author Julia
 *
 */
public class EndScreen extends javax.swing.JFrame {

    /**
     * Creates new form EndScreen
     */
    public EndScreen() {
        initComponents();
        this.setLocationRelativeTo(null); // center screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Saves the current HighScore to file
        HighScore curH = DetermineHighScore(GlobalState.Player);
        curH.SaveToFile();
    }
    
    /**
     * Compares new to old HighScore, the higher one being the one that has the 
     * most money, or most plants grown if money is equal.
     * @param player The current PlayerData to get the potential new HighScore from
     * @return The current HighScore
     */
    private HighScore DetermineHighScore(PlayerData player){
        HighScore newHS = player.ToHighScore();
        HighScore oldHS = new HighScore();
        
        oldHS.LoadFromFile();
        
        if (newHS.getMoney() > oldHS.getMoney())
            return newHS;
        
        if (newHS.getPlantsGrown() > oldHS.getPlantsGrown())
            return newHS;
        
        return oldHS;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlayAgain = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnStartScreen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnPlayAgain.setText("Play Again");
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnStartScreen.setText("Start Screen");
        btnStartScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartScreenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnStartScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlayAgain, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(btnPlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnStartScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        
        GlobalState.Player = new PlayerData(); // create blank player data
        GameScreen gameScreen = new GameScreen();
        gameScreen.show();
        
        dispose();
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        dispose();
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnStartScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartScreenActionPerformed
        
        StartScreen startScreen = new StartScreen();
        startScreen.show();
        
        dispose();
    }//GEN-LAST:event_btnStartScreenActionPerformed


    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnStartScreen;
    // End of variables declaration//GEN-END:variables
}
