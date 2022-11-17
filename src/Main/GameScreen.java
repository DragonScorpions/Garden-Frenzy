package Main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Julia
 */
public class GameScreen extends javax.swing.JFrame {
    private UIPlot[] plots;
   
    /**
     * Creates new form GameScreen
     */
    public GameScreen() {
        initComponents(); //Generated code
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // Reset selected seed to initial
        GlobalState.SelectedSeed = "None";
        
        //set UI layout of shop to the relevant (harvest) mode
        toggleSeedButtons();
        
        JButton seedbtns[] = new JButton[] {Pumpkin_Button, Corn_Button, Strawberry_Button};
        BorderHandler borderhandler = new BorderHandler();
        
        for (JButton btn: seedbtns){
            btn.setBackground(Color.decode("#ff8066")); // extra space
            btn.addMouseListener(new MouseAdapter(){
               @Override
               public void mouseEntered(java.awt.event.MouseEvent evt){
                   borderhandler.showBorder(btn, "#ff8066", 4);
               }
               
               @Override
               public void mouseExited(java.awt.event.MouseEvent evt){
                   borderhandler.hideBorder(btn);
               }
            });
        }
        
        // Populate UI with PlayerData
        plots = new UIPlot[] { uIPlot1, uIPlot2, uIPlot3, uIPlot4, uIPlot5, uIPlot6, uIPlot7, uIPlot8, uIPlot9 };
        for (int p = 0; p < Constants.NumPlots; p++)
            plots[p].SetPlot(GlobalState.Player.plots[p]);
        
        // Set up timer and start
        Timer.SetUpdateListener(this::Update);
        Timer.Start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        btnEndScreen = new javax.swing.JButton();
        uIPlot1 = new Main.UIPlot();
        uIPlot2 = new Main.UIPlot();
        uIPlot3 = new Main.UIPlot();
        uIPlot4 = new Main.UIPlot();
        uIPlot5 = new Main.UIPlot();
        uIPlot6 = new Main.UIPlot();
        uIPlot7 = new Main.UIPlot();
        uIPlot8 = new Main.UIPlot();
        uIPlot9 = new Main.UIPlot();
        btnSaveAndExit = new javax.swing.JButton();
        HarvestButton = new javax.swing.JButton();
        MoneyLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Strawberry_Button = new javax.swing.JButton();
        Pumpkin_Button = new javax.swing.JButton();
        Corn_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 640, 480));
        setMinimumSize(new java.awt.Dimension(557, 638));
        setResizable(false);

        btnEndScreen.setText("End Screen");
        btnEndScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndScreenActionPerformed(evt);
            }
        });

        btnSaveAndExit.setText("Save & Exit");
        btnSaveAndExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAndExitActionPerformed(evt);
            }
        });

        HarvestButton.setText("Stop planting");
        HarvestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HarvestButtonActionPerformed(evt);
            }
        });

        MoneyLabel.setText("$0");

        Strawberry_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/StrawberrySeed.png"))); // NOI18N
        Strawberry_Button.setPreferredSize(new java.awt.Dimension(89, 25));
        Strawberry_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Strawberry_ButtonActionPerformed(evt);
            }
        });

        Pumpkin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PumpkinSeeds.png"))); // NOI18N
        Pumpkin_Button.setPreferredSize(new java.awt.Dimension(89, 25));
        Pumpkin_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pumpkin_ButtonActionPerformed(evt);
            }
        });

        Corn_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CornSeed.png"))); // NOI18N
        Corn_Button.setPreferredSize(new java.awt.Dimension(89, 25));
        Corn_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Corn_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Strawberry_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pumpkin_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Corn_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Strawberry_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pumpkin_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Corn_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEndScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSaveAndExit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HarvestButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uIPlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(uIPlot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uIPlot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uIPlot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uIPlot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uIPlot6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uIPlot7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(uIPlot8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(uIPlot9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(MoneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(90, 90, 90)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(uIPlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uIPlot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uIPlot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uIPlot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uIPlot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uIPlot6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uIPlot7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uIPlot8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uIPlot9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSaveAndExit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEndScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MoneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(HarvestButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEndScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndScreenActionPerformed
        endGame();
    }//GEN-LAST:event_btnEndScreenActionPerformed

    private void endGame()
    {
        Timer.Stop();
        
        EndScreen endScreen = new EndScreen();
        endScreen.setVisible(true);
        
        dispose();
    }
    
    private void toggleSeedButtons()
    {
        if(GlobalState.SelectedSeed.equals("None")) //if player is harvesting
        {
            //hide the harvest button, and show all the shop buttons
            HarvestButton.setVisible(false);
        }
        else //if player is planting seeds
        {
            //hide each shop button and display the button to return to harvest
            //mode
            HarvestButton.setVisible(true);
        }
    }
    
    private void btnSaveAndExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAndExitActionPerformed
        GlobalState.Player.SaveToFile();
        
        Timer.Stop();
        
        StartScreen startScreen = new StartScreen();
        startScreen.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_btnSaveAndExitActionPerformed

    //Triggered when harvest button clicked, returns player to harvest mode
    //then toggles the UI to harvest layout
    private void HarvestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HarvestButtonActionPerformed
        System.out.println("GameScreen: Player is harvesting!");
        GlobalState.SelectedSeed = "None";
        toggleSeedButtons();
    }//GEN-LAST:event_HarvestButtonActionPerformed

    private void Strawberry_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Strawberry_ButtonActionPerformed
        System.out.println("Strawberry planted!");
        GlobalState.SelectedSeed = "Strawberry";
        toggleSeedButtons(); //then hide the shop buttons, and show harvest button
    }//GEN-LAST:event_Strawberry_ButtonActionPerformed

    private void Pumpkin_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pumpkin_ButtonActionPerformed
        System.out.println("Pumpkin planted!");
        GlobalState.SelectedSeed = "Pumpkin";
        toggleSeedButtons(); //then hide the shop buttons, and show harvest button
    }//GEN-LAST:event_Pumpkin_ButtonActionPerformed

    private void Corn_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Corn_ButtonActionPerformed
        System.out.println("Corn planted!");
        GlobalState.SelectedSeed = "Corn";
        toggleSeedButtons(); //then hide the shop buttons, and show harvest button
    }//GEN-LAST:event_Corn_ButtonActionPerformed
    
    /**
     * The update function of the game
     * @param time Time since the beginning of the game in seconds
     */
    private void Update(float time) {
        updatePlots(time);
        updateMoneyLabel();
        //If 10 minutes have passed, forcibly end the game.
        if(time >= 600)
        {
            System.out.println("Game end");
            endGame();
        }
    }

    private void updateMoneyLabel()
    {
        MoneyLabel.setText("$" + GlobalState.Player.getMoney());
    }
    
    private void updatePlots(float time)
    {
        for (UIPlot plot : plots) {
            plot.Update(time);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Corn_Button;
    private javax.swing.JButton HarvestButton;
    private javax.swing.JLabel MoneyLabel;
    private javax.swing.JButton Pumpkin_Button;
    private javax.swing.JButton Strawberry_Button;
    private javax.swing.JButton btnEndScreen;
    private javax.swing.JButton btnSaveAndExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private Main.UIPlot uIPlot1;
    private Main.UIPlot uIPlot2;
    private Main.UIPlot uIPlot3;
    private Main.UIPlot uIPlot4;
    private Main.UIPlot uIPlot5;
    private Main.UIPlot uIPlot6;
    private Main.UIPlot uIPlot7;
    private Main.UIPlot uIPlot8;
    private Main.UIPlot uIPlot9;
    // End of variables declaration//GEN-END:variables
}
