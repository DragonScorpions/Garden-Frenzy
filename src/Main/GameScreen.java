package Main;


import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Rectangle;

/**
 *
 * @author Julia
 */
public class GameScreen extends javax.swing.JFrame {
    private UIPlot[] plots;
    private int lastMoney = GlobalState.Player.getMoney();
   
    /**
     * Creates new form GameScreen
     * @param continuedGame set to true in StartScreen() if the game is continued
     */
    public GameScreen(boolean continuedGame) {
        GlobalState.SelectedSeed = "None"; // Reset selected seed to initial
        
        initComponents();
        
        coin.setVisible(false);
        
        /* Settings for JFrame */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#f0c066"));
        
        /* Settings for JPanels */
        JPanel[] panels = new JPanel[] {PumpkinPanel, StrawberryPanel, CornPanel, buttonPanel, HarvestPanel, PlotsPanel};
        for (JPanel panel : panels){
            panel.setBackground(null);
        }

        //set UI layout of shop to the relevant (harvest) mode
        //toggleSeedButtons();
        
        JButton seedbtns[] = new JButton[] {Pumpkin_Button, Corn_Button, Strawberry_Button};
        BorderHandler borderhandler = new BorderHandler();
        
        /* set hover events for buttons PumpkinButton, CornButton, StrawberryButton */
        for (JButton btn: seedbtns){
            btn.setBackground(Color.decode("#ff8066")); 
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
        
        /* Populate UI with PlayerData */
        plots = new UIPlot[] { uIPlot1, uIPlot2, uIPlot3, uIPlot4, uIPlot5, uIPlot6, uIPlot7, uIPlot8, uIPlot9 };
        for (int p = 0; p < Constants.NumPlots; p++)
            plots[p].SetPlot(GlobalState.Player.plots[p]);
        
        
                
        /* Set up timer and start */
        Timer.SetUpdateListener(this::Update);
        
        /* Game is a continued session */
        if (continuedGame){
            final JPanel continueGlass = (JPanel) this.getGlassPane(); // create a glass panel
            JLabel cont = new JLabel(); // JLabel to display message
            ImageIcon GameOverIcon = new ImageIcon("src/Images/ClickToContinue.png");
            cont.setIcon(GameOverIcon);
            continueGlass.setLayout(new GridBagLayout()); // Set a GridBagLayout to center JLabel
            continueGlass.add(cont);
            continueGlass.setVisible(true);
            
            this.Update(Timer.GetTime()); // update more UI components while paused
            
            /* Add Mouse Listeners
               mouseEntered(), mouseExited() to override events of the UI to keep the user from interacting with the game
               mousePressed to start the time and continue
            */
            continueGlass.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt){
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt){
                }

                @Override
                public void mousePressed(java.awt.event.MouseEvent evt){
                    continueGlass.setVisible(false);
                    continueGlass.remove(cont);
                    Timer.Start();
                    continueGlass.removeMouseListener(this);
                }
            });
        }
        /* This is a new game - start time */
        else{
            Timer.Start();
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

        jProgressBar1 = new javax.swing.JProgressBar();
        btnEndScreen = new javax.swing.JButton();
        btnSaveAndExit = new javax.swing.JButton();
        MoneyLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        HarvestPanel = new javax.swing.JPanel();
        HarvestButton = new javax.swing.JButton();
        HarvestText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PumpkinPanel = new javax.swing.JPanel();
        Pumpkin_Button = new javax.swing.JButton();
        PumpkinText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        StrawberryPanel = new javax.swing.JPanel();
        StrawBerryText = new javax.swing.JLabel();
        Strawberry_Button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CornPanel = new javax.swing.JPanel();
        CornText = new javax.swing.JLabel();
        Corn_Button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        UITime = new javax.swing.JLabel();
        PlotsPanel = new javax.swing.JPanel();
        uIPlot1 = new Main.UIPlot();
        uIPlot4 = new Main.UIPlot();
        uIPlot2 = new Main.UIPlot();
        uIPlot6 = new Main.UIPlot();
        uIPlot3 = new Main.UIPlot();
        uIPlot9 = new Main.UIPlot();
        uIPlot8 = new Main.UIPlot();
        uIPlot5 = new Main.UIPlot();
        uIPlot7 = new Main.UIPlot();
        coin = new javax.swing.JLabel();

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

        MoneyLabel.setText("$0");

        HarvestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Scythe.png"))); // NOI18N
        HarvestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HarvestButtonActionPerformed(evt);
            }
        });

        HarvestText.setText("Harvest");

        jLabel1.setText("1");

        javax.swing.GroupLayout HarvestPanelLayout = new javax.swing.GroupLayout(HarvestPanel);
        HarvestPanel.setLayout(HarvestPanelLayout);
        HarvestPanelLayout.setHorizontalGroup(
            HarvestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HarvestPanelLayout.createSequentialGroup()
                .addGroup(HarvestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HarvestPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HarvestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HarvestPanelLayout.createSequentialGroup()
                        .addGroup(HarvestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HarvestPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(HarvestText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HarvestPanelLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        HarvestPanelLayout.setVerticalGroup(
            HarvestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HarvestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HarvestText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HarvestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pumpkin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PumpkinSeeds.png"))); // NOI18N
        Pumpkin_Button.setPreferredSize(new java.awt.Dimension(89, 25));
        Pumpkin_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pumpkin_ButtonActionPerformed(evt);
            }
        });

        PumpkinText.setText("Pumpkin - $1");

        jLabel2.setText("2");

        javax.swing.GroupLayout PumpkinPanelLayout = new javax.swing.GroupLayout(PumpkinPanel);
        PumpkinPanel.setLayout(PumpkinPanelLayout);
        PumpkinPanelLayout.setHorizontalGroup(
            PumpkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PumpkinPanelLayout.createSequentialGroup()
                .addGroup(PumpkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PumpkinPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(PumpkinText))
                    .addGroup(PumpkinPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Pumpkin_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PumpkinPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PumpkinPanelLayout.setVerticalGroup(
            PumpkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PumpkinPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PumpkinText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pumpkin_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        StrawBerryText.setText("Strawberry - $0");

        Strawberry_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/StrawberrySeed.png"))); // NOI18N
        Strawberry_Button.setPreferredSize(new java.awt.Dimension(89, 25));
        Strawberry_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Strawberry_ButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("3");

        javax.swing.GroupLayout StrawberryPanelLayout = new javax.swing.GroupLayout(StrawberryPanel);
        StrawberryPanel.setLayout(StrawberryPanelLayout);
        StrawberryPanelLayout.setHorizontalGroup(
            StrawberryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StrawberryPanelLayout.createSequentialGroup()
                .addGroup(StrawberryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StrawberryPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(StrawBerryText, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StrawberryPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StrawberryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Strawberry_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StrawberryPanelLayout.setVerticalGroup(
            StrawberryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StrawberryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StrawBerryText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Strawberry_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CornText.setText("Corn - $2");

        Corn_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CornSeed.png"))); // NOI18N
        Corn_Button.setPreferredSize(new java.awt.Dimension(89, 25));
        Corn_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Corn_ButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("4");

        javax.swing.GroupLayout CornPanelLayout = new javax.swing.GroupLayout(CornPanel);
        CornPanel.setLayout(CornPanelLayout);
        CornPanelLayout.setHorizontalGroup(
            CornPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CornPanelLayout.createSequentialGroup()
                .addComponent(Corn_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(CornPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(CornPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CornText)
                    .addGroup(CornPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CornPanelLayout.setVerticalGroup(
            CornPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CornPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CornText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Corn_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HarvestPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PumpkinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StrawberryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CornPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(StrawberryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HarvestPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PumpkinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CornPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        UITime.setText("jLabel5");

        PlotsPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        PlotsPanel.add(uIPlot7, gridBagConstraints);

        coin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/coin.png"))); // NOI18N
        coin.setAlignmentY(0.1F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEndScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSaveAndExit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(MoneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(coin)
                                .addGap(66, 66, 66)))
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(UITime, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PlotsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(UITime, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlotsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSaveAndExit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEndScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(coin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MoneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* TO BE DELETED */
    private void btnEndScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndScreenActionPerformed
        endGame(true);
    }//GEN-LAST:event_btnEndScreenActionPerformed
    
    /**
     * Ends the games - displays how the player lost
     * @param playerLost set to true if game ends due to player lost, false if time ran out
     */
    private void endGame(boolean playerLost) {
        Timer.Stop();
        
        ImageIcon GameOverIcon;
        final JPanel GameOverGlass = (JPanel) this.getGlassPane(); // create glass JPanel
        JLabel gameover = new JLabel(); // JLabel to display 
        GameOverGlass.setLayout(new GridBagLayout());
        
        /* Display icon based on if player lost or not */
        if (playerLost){
            GameOverIcon = new ImageIcon("src/Images/GameOverLost.png");
        }
        else{
            GameOverIcon = new ImageIcon("src/Images/GameOverTimesUp.png");
            
        }
        
        gameover.setIcon(GameOverIcon);
        gameover.setBackground(null);
        GameOverGlass.add(gameover);
        
        /* Add Mouse Listeners
            mouseEntered(), mouseExited() to override events of the UI to keep the user from interacting with the game
            mousePressed to continue to the endScreen
        */
        GameOverGlass.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt){
            }
       
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                EndScreen endScreen = new EndScreen();
                endScreen.setVisible(true);
                GameOverGlass.removeMouseListener(this);
                dispose();
            }
        });
        
        GameOverGlass.setVisible(true);
    }
    
    private void btnSaveAndExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAndExitActionPerformed
        GlobalState.Player.SaveToFile();
        
        Timer.Stop();
        
        StartScreen startScreen = new StartScreen();
        startScreen.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_btnSaveAndExitActionPerformed

    private void Strawberry_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Strawberry_ButtonActionPerformed
        System.out.println("GameScreen: Strawberry planted!");
        GlobalState.SelectedSeed = "Strawberry";
        //toggleSeedButtons(); //then hide the shop buttons, and show harvest button
    }//GEN-LAST:event_Strawberry_ButtonActionPerformed

    //Triggered when harvest button clicked, returns player to harvest mode
    //then toggles the UI to harvest layout
    private void HarvestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HarvestButtonActionPerformed
        System.out.println("GameScreen: Player is harvesting!");
        GlobalState.SelectedSeed = "None";
        //toggleSeedButtons();
    }//GEN-LAST:event_HarvestButtonActionPerformed

    private void Corn_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Corn_ButtonActionPerformed
        System.out.println("GameScreen: Corn planted!");
        GlobalState.SelectedSeed = "Corn";
        //toggleSeedButtons(); //then hide the shop buttons, and show harvest button
    }//GEN-LAST:event_Corn_ButtonActionPerformed

    private void Pumpkin_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pumpkin_ButtonActionPerformed
        System.out.println("GameScreen: Pumpkin planted!");
        GlobalState.SelectedSeed = "Pumpkin";
        //toggleSeedButtons(); //then hide the shop buttons, and show harvest button
    }//GEN-LAST:event_Pumpkin_ButtonActionPerformed

    /**
     * The update function of the game
     * @param time Time since the beginning of the game in seconds
     */
    private void Update(float time) {
        updatePlots(time);
        updateMoneyLabel();
        displayTime(time);
        
        // If 10 minutes have passed, forcibly end the game.
        if(time >= 600)
        {
            System.out.println("Game end due to time up");
            endGame(false);
        }
        // Check if the player has met the losing conditions
        else if (checkLose()){
            System.out.println("Game end due to player lose");
            endGame(true);
        }
    }
    
    /**
     * returns if the player loses if the player has no money and no seeds are planted
     * @return whether player loses or not
     */
    private boolean checkLose(){
        boolean PlotHasSeed = false;
        
        /* player has money, cannot lose */
        if (GlobalState.Player.hasMoney()){
            return false;
        }
        
        /* check if any plots have seeds planted */
        for (int p = 0; p < Constants.NumPlots; p++){
            PlotHasSeed = GlobalState.Player.plots[p].hasSeeds();
            /* found a seed */
            if (PlotHasSeed == true){
                return false;
            }
        }
        
        return !PlotHasSeed && !GlobalState.Player.hasMoney();
    }
    
    /**
     * Update the amount of money the player has
     */
    private void updateMoneyLabel()
    {
        int currentMoney = GlobalState.Player.getMoney();
        MoneyLabel.setText("$" + currentMoney);
        if (currentMoney > lastMoney) {
            Animation.animate(
                coin,
                coin.getBounds(),
                MoneyLabel.getBounds(),
                2000
            );
        }
        lastMoney = currentMoney;
    }
    
    /**
     * Update the plots according to time
     * @param time 
     */
    private void updatePlots(float time)
    {
        for (UIPlot plot : plots) {
            plot.Update(time);
        }
    }
    
    private void displayTime(float time){
        System.out.println(time);
        if (!UITime.getText().equals(Timer.GetTimeAsString())){
            UITime.setText("<html>"
                            + "<div style='text-align: center;'>"
                            + "<font size = +4>" + Timer.GetTimeAsString() + "</font>"
                            + "</div> </html>");
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CornPanel;
    private javax.swing.JLabel CornText;
    private javax.swing.JButton Corn_Button;
    private javax.swing.JButton HarvestButton;
    private javax.swing.JPanel HarvestPanel;
    private javax.swing.JLabel HarvestText;
    private javax.swing.JLabel MoneyLabel;
    private javax.swing.JPanel PlotsPanel;
    private javax.swing.JPanel PumpkinPanel;
    private javax.swing.JLabel PumpkinText;
    private javax.swing.JButton Pumpkin_Button;
    private javax.swing.JLabel StrawBerryText;
    private javax.swing.JPanel StrawberryPanel;
    private javax.swing.JButton Strawberry_Button;
    private javax.swing.JLabel UITime;
    private javax.swing.JButton btnEndScreen;
    private javax.swing.JButton btnSaveAndExit;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel coin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
