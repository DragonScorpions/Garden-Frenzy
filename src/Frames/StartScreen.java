package Frames;

import GameModel.GlobalState;
import GameModel.HighScore;
import GameModel.PlayerData;
import UIHelpers.BorderHandler;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 * The screen that shows the main menu to the player
 * @author Julia
 */
public class StartScreen extends javax.swing.JFrame{

    private final HighScore highscore;
    
    /**
     * Creates new form StartScreen
     */
    public StartScreen() {
   
        /* create blank player */
        highscore = new HighScore();
        GlobalState.Player = new PlayerData();
        
        /* Load highscore from file if it exists */
        if (highscore.FileExists())
            highscore.LoadFromFile();
        
        initComponents();
        
        /* settings for JFrame */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center frame to screen
        getContentPane().setBackground(Color.decode("#f0c066"));
        
        /* no backgrounds for panels */
        jPanel1.setBackground(null);
        jPanel2.setBackground(null);
        jPanel3.setBackground(null);
        
        /* center text for displaying high score */
        displayHighScore.setHorizontalAlignment(SwingConstants.CENTER);
        displayHighScore.setVerticalAlignment(SwingConstants.CENTER);
        
        /* print highscore */
        displayHighScore.setText("<html>"
                                    + "<div style='text-align: center;'>"
                                                + "<font size = +3> HIGH SCORE </font><br/>"
                                                + "Amount made: " + highscore.getMoney() + "<br/>"
                                                + "Crops Grown: " + highscore.getPlantsGrown()
                                    + "</div>"
                                + "</html>");
       
        /* Saved file exist */
        btnContinue.setEnabled(GlobalState.Player.FileExists());
        
        JButton[] btns = {btnNewGame, btnContinue, btnQuit};
        BorderHandler borderhandler = new BorderHandler();
        
        /* Hover events for buttons New Game, Continue, Quit */
        for(JButton btn: btns){
            if (btn.isEnabled())
                borderhandler.showBorder(btn, "#ff8066", 5);
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnContinue = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnNewGame = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        displayHighScore = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(30, 30, 30, 30));

        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnContinue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ContinueButton.png"))); // NOI18N
        btnContinue.setBorder(null);
        btnContinue.setIconTextGap(-1);
        btnContinue.setPreferredSize(new java.awt.Dimension(293, 99));
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -37;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 25, 0, 25);
        jPanel1.add(btnContinue, gridBagConstraints);

        btnQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ExitBtn.png"))); // NOI18N
        btnQuit.setBorder(null);
        btnQuit.setIconTextGap(-1);
        btnQuit.setPreferredSize(new java.awt.Dimension(293, 99));
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = -37;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 25, 13, 25);
        jPanel1.add(btnQuit, gridBagConstraints);

        btnNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/StartBtn.png"))); // NOI18N
        btnNewGame.setBorder(null);
        btnNewGame.setIconTextGap(-1);
        btnNewGame.setMaximumSize(new java.awt.Dimension(283, 99));
        btnNewGame.setMinimumSize(new java.awt.Dimension(283, 99));
        btnNewGame.setPreferredSize(new java.awt.Dimension(293, 99));
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -37;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 25, 0, 25);
        jPanel1.add(btnNewGame, gridBagConstraints);

        displayHighScore.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(displayHighScore, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayHighScore, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameLogo .png"))); // NOI18N
        jLabel1.setText("GAME LOGO/ TITLE PLACEHOLDER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Continue button - set as disabled in constructor if a game does not currently exist
     * @param evt 
     */
    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        // player is continuing old session
        // load old gamestate from file
        GlobalState.Player.LoadFromFile();
        GameScreen gameScreen = new GameScreen(true);
        gameScreen.show();
        
        dispose();
    }//GEN-LAST:event_btnContinueActionPerformed

    /* Quit Button - exits game */
    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        dispose();
    }//GEN-LAST:event_btnQuitActionPerformed

    /* New Game button - begins a new game session */
    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        // Creating new session
        GameScreen gameScreen = new GameScreen(false);
        gameScreen.show();

        dispose();
    }//GEN-LAST:event_btnNewGameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            new StartScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnQuit;
    private javax.swing.JLabel displayHighScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
