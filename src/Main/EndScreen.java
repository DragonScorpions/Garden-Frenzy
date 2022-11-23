package Main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

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
        this.getContentPane().setBackground(Color.decode("#f0c066")); // set background
        
        // Saves the current HighScore to file
        HighScore prevHighscore = new HighScore();
        prevHighscore.LoadFromFile();
        HighScore curH = DetermineHighScore(GlobalState.Player);
        curH.SaveToFile();
        
        // Delete 
        GlobalState.Player.DeleteFile();
        
        jPanel1.setBackground(null); 
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        // add hover events for buttons
        JButton[] btns = {btnPlayAgain, btnStartScreen, btnQuit};
        BorderHandler borderhandler = new BorderHandler();
        for(JButton btn: btns){
            if (btn.isEnabled()){
                borderhandler.showBorder(btn, "#ff8066", 5);
            }
            btn.setContentAreaFilled(false);
            btn.addMouseListener(new MouseAdapter(){
                @Override
               public void mouseEntered(java.awt.event.MouseEvent evt){
                   borderhandler.showBorder(btn, "#ff8066", 10);
               }
               
               @Override
               public void mouseExited(java.awt.event.MouseEvent evt){
                   borderhandler.showBorder(btn, "#ff8066", 5);
               }
            });
        }
        
    }
    
    
    // print highscore
    private void printHighScore(HighScore highscore){ 
        jLabel1.setText("<html>"
                        + "<div style='text-align: center;'>"
                                    + "<font size = +3> YOU MADE $" + highscore.getMoney() + "</font><br/>"
                                    + "Crops Grown: " + highscore.getPlantsGrown()
                        + "</div>"
                    + "</html>");
    }
    
    
    /**
     * Compares new to old HighScore, the higher one being the one that has the 
     * most money, or most plants grown if money is equal.
     * @param player The current PlayerData to get the potential new HighScore from
     * @return The current HighScore
     */
    private HighScore DetermineHighScore(PlayerData player){
        HighScore currentScore = player.ToHighScore();
        HighScore oldHS = new HighScore();
        
        oldHS.LoadFromFile();
        if (currentScore.getMoney() > oldHS.getMoney()){
            // new highscore text
            jLabel1.setText("<html>"
                        + "<div style='text-align: center;'>"
                        + "<font size = +10> <b> NEW HIGHSCORE </b> </font><br/>"
                        + "<font size = +3> YOUR MADE $" + currentScore.getMoney() + "</font><br/>"
                        + "Crops Grown: " + currentScore.getPlantsGrown()
                        + "</div>"
                    + "</html>");
            return currentScore;
        }
        
        //if (newHS.getPlantsGrown() > oldHS.getPlantsGrown())
           // return newHS;
           
        printHighScore(currentScore); // highscore to be determined
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnQuit = new javax.swing.JButton();
        btnPlayAgain = new javax.swing.JButton();
        btnStartScreen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(573, 677));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ExitBtn.png"))); // NOI18N
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = -33;
        gridBagConstraints.ipady = -10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 37, 13, 0);
        jPanel1.add(btnQuit, gridBagConstraints);

        btnPlayAgain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PlayAgainbtn.png"))); // NOI18N
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = -31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 37, 0, 37);
        jPanel1.add(btnPlayAgain, gridBagConstraints);

        btnStartScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/StartScreenbtn.png"))); // NOI18N
        btnStartScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartScreenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 37, 0, 0);
        jPanel1.add(btnStartScreen, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        
        GlobalState.Player = new PlayerData(); // create blank player data
        GameScreen gameScreen = new GameScreen(false);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
