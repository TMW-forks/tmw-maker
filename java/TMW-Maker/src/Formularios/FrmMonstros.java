package Formularios;

import Classes.ImagemClass;
import Classes.SpritePNG;
import Classes.SpriteXML;

public class FrmMonstros extends javax.swing.JDialog {
    public FrmMonstros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jToolBar1 = new javax.swing.JToolBar();
        BtnVoltar = new javax.swing.JButton();
        CmbIDs = new javax.swing.JComboBox();
        BtnAvancar = new javax.swing.JButton();
        BtnLocalizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BtnCarregar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        lblVisualizacao = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomeSumonico = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblNivel = new javax.swing.JLabel();
        sldNivel = new javax.swing.JSlider();
        lblHP = new javax.swing.JLabel();
        lblRanger1 = new javax.swing.JLabel();
        lblEXP = new javax.swing.JLabel();
        lblJob = new javax.swing.JLabel();
        sldHP = new javax.swing.JSlider();
        sldRanger1 = new javax.swing.JSlider();
        sldEXP = new javax.swing.JSlider();
        sldJob = new javax.swing.JSlider();
        lblSP = new javax.swing.JLabel();
        sldSP = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Monstros");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);

        BtnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_voltar.gif"))); // NOI18N
        BtnVoltar.setToolTipText("Anterior (Ctrl+Alt+?)");
        BtnVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnVoltar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVoltarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnVoltar);

        CmbIDs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3046" }));
        CmbIDs.setToolTipText("Número ID");
        CmbIDs.setMaximumSize(new java.awt.Dimension(67, 25));
        CmbIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIDsActionPerformed(evt);
            }
        });
        jToolBar1.add(CmbIDs);

        BtnAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_avancar.gif"))); // NOI18N
        BtnAvancar.setToolTipText("Próxima (Ctrl+Alt+?)");
        BtnAvancar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAvancar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAvancarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAvancar);

        BtnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lupa.gif"))); // NOI18N
        BtnLocalizar.setEnabled(false);
        BtnLocalizar.setFocusable(false);
        BtnLocalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnLocalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLocalizarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnLocalizar);
        jToolBar1.add(jSeparator1);

        BtnCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        BtnCarregar.setToolTipText("Abrir (Ctrl+O)");
        BtnCarregar.setEnabled(false);
        BtnCarregar.setFocusable(false);
        BtnCarregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnCarregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BtnCarregar);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"))); // NOI18N
        jButton5.setToolTipText("Salvar (Ctrl+S)");
        jButton5.setEnabled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lixeira.png"))); // NOI18N
        jButton6.setToolTipText("Excluir (Ctrl+Del)");
        jButton6.setEnabled(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);
        jToolBar1.add(jSeparator2);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ajuda.gif"))); // NOI18N
        jButton7.setToolTipText("Ajudar (F1)");
        jButton7.setEnabled(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jToolBar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);

        lblVisualizacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVisualizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png"))); // NOI18N
        lblVisualizacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblVisualizacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(lblVisualizacao);

        jLabel2.setText("Nome Título:");

        jLabel3.setText("Nome Sumonico:");

        txtNomeSumonico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeSumonicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeSumonico, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtNomeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeSumonico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblNivel.setText("Nível: (21)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblNivel, gridBagConstraints);

        sldNivel.setMajorTickSpacing(80);
        sldNivel.setMaximum(255);
        sldNivel.setMinimum(1);
        sldNivel.setMinorTickSpacing(20);
        sldNivel.setPaintTicks(true);
        sldNivel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldNivelStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(sldNivel, gridBagConstraints);

        lblHP.setText("HP: (1)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblHP, gridBagConstraints);

        lblRanger1.setText("Visão: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblRanger1, gridBagConstraints);

        lblEXP.setText("Exp: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblEXP, gridBagConstraints);

        lblJob.setText("Job: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblJob, gridBagConstraints);

        sldHP.setMajorTickSpacing(5000);
        sldHP.setMaximum(25000);
        sldHP.setMinimum(1);
        sldHP.setMinorTickSpacing(1000);
        sldHP.setPaintTicks(true);
        sldHP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldHPStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel3.add(sldHP, gridBagConstraints);

        sldRanger1.setMajorTickSpacing(10);
        sldRanger1.setMaximum(30);
        sldRanger1.setMinorTickSpacing(2);
        sldRanger1.setPaintTicks(true);
        sldRanger1.setValue(0);
        sldRanger1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldRanger1StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 100;
        jPanel3.add(sldRanger1, gridBagConstraints);

        sldEXP.setMajorTickSpacing(5000);
        sldEXP.setMaximum(25000);
        sldEXP.setMinorTickSpacing(1000);
        sldEXP.setPaintTicks(true);
        sldEXP.setValue(100);
        sldEXP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldEXPStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(sldEXP, gridBagConstraints);

        sldJob.setMajorTickSpacing(5000);
        sldJob.setMaximum(25000);
        sldJob.setMinorTickSpacing(1000);
        sldJob.setPaintTicks(true);
        sldJob.setValue(0);
        sldJob.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldJobStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(sldJob, gridBagConstraints);

        lblSP.setText("SP: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblSP, gridBagConstraints);

        sldSP.setMajorTickSpacing(2000);
        sldSP.setMaximum(10000);
        sldSP.setMinorTickSpacing(500);
        sldSP.setPaintTicks(true);
        sldSP.setValue(0);
        sldSP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldSPStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(sldSP, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informação", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirRegistro(int Ordem) {
        txtNomeTitulo.setText(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getNomeTitulo());
        txtNomeSumonico.setText(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getNomeSumonico());
        sldNivel.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getNivel());
        sldRanger1.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getRange1());
        sldHP.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getHP());
        sldSP.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getSP());
        sldEXP.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getExp());
        sldJob.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getJob());
    }


    private void BtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVoltarActionPerformed
        if(CmbIDs.getSelectedIndex()>0) CmbIDs.setSelectedIndex(CmbIDs.getSelectedIndex()-1);
        AbrirRegistro(CmbIDs.getSelectedIndex());
}//GEN-LAST:event_BtnVoltarActionPerformed
    private void CmbIDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbIDsActionPerformed
        AbrirRegistro(CmbIDs.getSelectedIndex());
}//GEN-LAST:event_CmbIDsActionPerformed
    private void BtnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAvancarActionPerformed
        if(CmbIDs.getSelectedIndex()<CmbIDs.getItemCount()-1) CmbIDs.setSelectedIndex(CmbIDs.getSelectedIndex()+1);
        AbrirRegistro(CmbIDs.getSelectedIndex());
        BtnAvancar.grabFocus();
        //MnuSistemaAtualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.CTRL_MASK))
}//GEN-LAST:event_BtnAvancarActionPerformed
    private void BtnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLocalizarActionPerformed
        javax.swing.JDialog FrmItemLocalizar = new FrmItemLocalizar(this, rootPaneCheckingEnabled);
        FrmItemLocalizar.setLocation(
                ((this.getWidth() - FrmItemLocalizar.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmItemLocalizar.getHeight()) / 2) + this.getY());
        FrmItemLocalizar.pack();
        FrmItemLocalizar.setModal(true);
        FrmItemLocalizar.setVisible(true);/**/
}//GEN-LAST:event_BtnLocalizarActionPerformed
    private void txtNomeSumonicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeSumonicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeSumonicoActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(FrmPrincipal.Monstros.getContSpawns()>=1){
            CmbIDs.setModel(new javax.swing.DefaultComboBoxModel(FrmPrincipal.Monstros.getVectorIDs()));
            AbrirRegistro(CmbIDs.getSelectedIndex());
            
            //SpriteXML spriteXML = new SpriteXML("/home/indigovox/localhost/tmwdata/graphics/sprites/monstro-fada.xml");
            //lblVisualizacao.setIcon(new javax.swing.ImageIcon(spriteXML.getSpriteDados().getBloco(0)));

            /*SpritePNG spritePNG = new SpritePNG("/home/indigovox/localhost/tmwdata/graphics/sprites/monstro-fada.png",6,9);
            ImagemClass imgTradadora = new ImagemClass(spritePNG.getBloco(0));
            imgTradadora.setZoom(((double)imgTradadora.getLargura())/100.0);
            //lblVisualizacao.setIcon(new javax.swing.ImageIcon());
            lblVisualizacao.setIcon(imgTradadora.getIcone());/**/
        }
    }//GEN-LAST:event_formWindowOpened
    private void sldRanger1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldRanger1StateChanged
        lblRanger1.setText("Visão: ("+sldRanger1.getValue()+")");
    }//GEN-LAST:event_sldRanger1StateChanged
    private void sldSPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSPStateChanged
        lblSP.setText("SP: ("+sldSP.getValue()+")");
    }//GEN-LAST:event_sldSPStateChanged
    private void sldJobStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldJobStateChanged
        lblJob.setText("Job: ("+sldJob.getValue()+")");
    }//GEN-LAST:event_sldJobStateChanged
    private void sldNivelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldNivelStateChanged
        lblNivel.setText("Nível: ("+sldNivel.getValue()+")");
    }//GEN-LAST:event_sldNivelStateChanged
    private void sldHPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldHPStateChanged
        lblHP.setText("HP: ("+sldHP.getValue()+")");
    }//GEN-LAST:event_sldHPStateChanged
    private void sldEXPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEXPStateChanged
        lblEXP.setText("Exp: ("+sldEXP.getValue()+")");
    }//GEN-LAST:event_sldEXPStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMonstros dialog = new FrmMonstros(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAvancar;
    private javax.swing.JButton BtnCarregar;
    private javax.swing.JButton BtnLocalizar;
    private javax.swing.JButton BtnVoltar;
    public static javax.swing.JComboBox CmbIDs;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblEXP;
    private javax.swing.JLabel lblHP;
    private javax.swing.JLabel lblJob;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblRanger1;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblVisualizacao;
    private javax.swing.JSlider sldEXP;
    private javax.swing.JSlider sldHP;
    private javax.swing.JSlider sldJob;
    private javax.swing.JSlider sldNivel;
    private javax.swing.JSlider sldRanger1;
    private javax.swing.JSlider sldSP;
    private javax.swing.JTextField txtNomeSumonico;
    private javax.swing.JTextField txtNomeTitulo;
    // End of variables declaration//GEN-END:variables

}
