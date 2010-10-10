package Formularios;

import Classes.BancoDeDados.Banco_Spawns.Dados_Spawns;
import Classes.BancoDeDados.Banco_Spawns.Dados_Spawns.Banco_Sprites;
import Classes.FileClass;
import Classes.ImagemClass;
import Classes.Modificadoras.MyComboBoxEditor;
import Classes.SpriteXML;
import Classes.StringClass;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

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
        btnSalvar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter MskNomeSimples = null;
        try{
            MskNomeSimples = new javax.swing.text.MaskFormatter("*****************************");
            MskNomeSimples.setValidCharacters(" 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }catch(java.text.ParseException Erro){}
        txtNomeSumonico = new javax.swing.JFormattedTextField(MskNomeSimples);
        jPanel3 = new javax.swing.JPanel();
        lblNivel = new javax.swing.JLabel();
        sldNivel = new javax.swing.JSlider();
        lblRanger1 = new javax.swing.JLabel();
        sldRanger1 = new javax.swing.JSlider();
        lblHP = new javax.swing.JLabel();
        sldHP = new javax.swing.JSlider();
        lblSP = new javax.swing.JLabel();
        sldSP = new javax.swing.JSlider();
        lblEXP = new javax.swing.JLabel();
        sldEXP = new javax.swing.JSlider();
        lblJob = new javax.swing.JLabel();
        sldJob = new javax.swing.JSlider();
        lblAtaque1 = new javax.swing.JLabel();
        sldAtaque1 = new javax.swing.JSlider();
        lblAtaque2 = new javax.swing.JLabel();
        sldAtaque2 = new javax.swing.JSlider();
        lblDefFisico = new javax.swing.JLabel();
        sldDefFisico = new javax.swing.JSlider();
        lblDefMagico = new javax.swing.JLabel();
        sldDefMagico = new javax.swing.JSlider();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAudios = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAnimacoes = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblVisualizacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Monstros (Modo Somento-Leitura)");
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
        CmbIDs.setToolTipText("N�mero ID");
        CmbIDs.setMaximumSize(new java.awt.Dimension(67, 25));
        CmbIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIDsActionPerformed(evt);
            }
        });
        jToolBar1.add(CmbIDs);

        BtnAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_avancar.gif"))); // NOI18N
        BtnAvancar.setToolTipText("Pr�xima (Ctrl+Alt+?)");
        BtnAvancar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAvancar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAvancarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAvancar);

        BtnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lupa.gif"))); // NOI18N
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

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"))); // NOI18N
        btnSalvar.setToolTipText("Salvar (Ctrl+S)");
        btnSalvar.setEnabled(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

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

        jLabel2.setText("Nome T�tulo:");

        txtNomeTitulo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeTituloCaretUpdate(evt);
            }
        });

        jLabel3.setText("Nome Sumonico:");

        txtNomeSumonico.setFont(new java.awt.Font("Monospaced", 0, 14));
        txtNomeSumonico.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeSumonicoCaretUpdate(evt);
            }
        });
        txtNomeSumonico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeSumonicoFocusLost(evt);
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
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeSumonico, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(txtNomeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeSumonico, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblNivel.setText("N�vel: (21)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(sldNivel, gridBagConstraints);

        lblRanger1.setText("Dist. Ataq.: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblRanger1, gridBagConstraints);

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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        jPanel3.add(sldRanger1, gridBagConstraints);

        lblHP.setText("HP: (1)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblHP, gridBagConstraints);

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

        lblEXP.setText("Exp: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblEXP, gridBagConstraints);

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
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(sldEXP, gridBagConstraints);

        lblJob.setText("Job: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblJob, gridBagConstraints);

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

        lblAtaque1.setText("Min. Ataq: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblAtaque1, gridBagConstraints);

        sldAtaque1.setMajorTickSpacing(200);
        sldAtaque1.setMaximum(1000);
        sldAtaque1.setMinorTickSpacing(50);
        sldAtaque1.setPaintTicks(true);
        sldAtaque1.setValue(0);
        sldAtaque1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAtaque1StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(sldAtaque1, gridBagConstraints);

        lblAtaque2.setText("Max. Ataq: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblAtaque2, gridBagConstraints);

        sldAtaque2.setMajorTickSpacing(200);
        sldAtaque2.setMaximum(1000);
        sldAtaque2.setMinorTickSpacing(50);
        sldAtaque2.setPaintTicks(true);
        sldAtaque2.setValue(0);
        sldAtaque2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAtaque2StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        jPanel3.add(sldAtaque2, gridBagConstraints);

        lblDefFisico.setText("Def.F�sica: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblDefFisico, gridBagConstraints);

        sldDefFisico.setMajorTickSpacing(200);
        sldDefFisico.setMaximum(1000);
        sldDefFisico.setMinorTickSpacing(50);
        sldDefFisico.setPaintTicks(true);
        sldDefFisico.setValue(0);
        sldDefFisico.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldDefFisicoStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(sldDefFisico, gridBagConstraints);

        lblDefMagico.setText("Def.M�gico: (0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(lblDefMagico, gridBagConstraints);

        sldDefMagico.setMajorTickSpacing(200);
        sldDefMagico.setMaximum(1000);
        sldDefMagico.setMinorTickSpacing(50);
        sldDefMagico.setPaintTicks(true);
        sldDefMagico.setValue(0);
        sldDefMagico.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldDefMagicoStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(sldDefMagico, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Informa��o", jPanel1);

        jLabel6.setText("Itens que o montro deixar� cair ao morrer:");

        tblItens.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID: Nome", "Drops(%)"
            }
        ));
        jScrollPane4.setViewportView(tblItens);

        jButton1.setText("Adicionar");
        jButton1.setEnabled(false);

        jButton2.setText("Remover");
        jButton2.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        jTabbedPane1.addTab("Drops", jPanel6);

        jLabel5.setText("�udios OGG:");

        tblAudios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"hits", "audio.ogg"}
            },
            new String [] {
                "Evento", "Arquivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblAudios);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Camada de XML:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLabel4, gridBagConstraints);

        lstAnimacoes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstAnimacoes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 160;
        gridBagConstraints.ipady = 61;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jScrollPane2, gridBagConstraints);

        jButton3.setText("Adicionar");
        jButton3.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel7.add(jButton3, gridBagConstraints);

        jButton4.setText("Remover");
        jButton4.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel7.add(jButton4, gridBagConstraints);

        jButton5.setText("Pintar");
        jButton5.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel7.add(jButton5, gridBagConstraints);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Arquivos", jPanel5);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblVisualizacao.setBackground(java.awt.Color.darkGray);
        lblVisualizacao.setForeground(new java.awt.Color(254, 254, 254));
        lblVisualizacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVisualizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png"))); // NOI18N
        lblVisualizacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblVisualizacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblVisualizacao.setMaximumSize(new java.awt.Dimension(146, 316));
        lblVisualizacao.setMinimumSize(new java.awt.Dimension(146, 316));
        lblVisualizacao.setOpaque(true);
        lblVisualizacao.setPreferredSize(new java.awt.Dimension(146, 316));
        lblVisualizacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVisualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVisualizacao, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public Vector addItemVector(int IDTem, double PerctDeDrops){
        Vector Linha = new Vector();
        //Linha.addElement(new ImageIcon(FrmPrincipal.Itens.getItemPorID(IDTem).getIconeImagem()));
        //Linha.addElement(IDTem);
        //Linha.addElement(FrmPrincipal.Itens.getItemPorID(IDTem).getNomeTitulo());//Se � um
        Linha.addElement("<html>"+
            "<table><tr><td><img align=\"middle\" src=\"file://"+
                FrmPrincipal.Itens.getItemPorID(IDTem).getIconeEndereco()+
            "\"></td><td>"+
                "<b>"+IDTem+":</b> "+FrmPrincipal.Itens.getItemPorID(IDTem).getNomeTitulo()+"<br/>"+
                "<small>"+
                "V:"+FrmPrincipal.Itens.getItemPorID(IDTem).getPrecoDeVenda()+"GP "+
                "C:"+FrmPrincipal.Itens.getItemPorID(IDTem).getPrecoDeCompra()+"GP "+
                "("+FrmPrincipal.Itens.getItemPorID(IDTem).getPoderEfeito()+")"+
                "</small>"+
            "</td></tr></table>"
        );//Se � um
        Linha.addElement(PerctDeDrops);
        return Linha;
    }
    private void AbrirRegistro(int Ordem) {
        /*******************************************************************************************************
         * ID,Name,Jname,
         * LV,HP,SP,EXP,JEXP,
         * Range1,ATK1,ATK2,DEF,MDEF,
         * STR,AGI,VIT,INT,DEX,LUK,
         * Range2,Range3,Scale,Race,Element,Mode,Speed,Adelay,
         * Amotion,Dmotion,
         * Drop1id,Drop1per,Drop2id,Drop2per,Drop3id,Drop3per,Drop4id,Drop4per,Drop5id,Drop5per,Drop6id,Drop6per,Drop7id,Drop7per,Drop8id,Drop8per,
         * Item1,Item2,MEXP,ExpPer,MVP1id,MVP1per,MVP2id,MVP2per,MVP3id,MVP3per,mutiation count,mutation strength
         *******************************************************************************************************/

        txtNomeTitulo.setText(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getNomeTitulo());
        txtNomeSumonico.setText(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getNomeSumonico());
        sldNivel.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getNivel());
        sldRanger1.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getRange1());
        sldHP.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getHP());
        sldSP.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getSP());
        sldEXP.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getExp());
        sldJob.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getJob());
        sldAtaque1.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getAtaque1());
        sldAtaque2.setMinimum(sldAtaque1.getValue());
        sldAtaque2.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getAtaque2());
        sldDefFisico.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getDefesaFisica());
        sldDefMagico.setValue(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getDefesaMagica());

        final Vector xmlAnimacoes = new Vector();
        //final Vector pngImagens = new Vector();
        for(int s=0;s<FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getContSprites();s++){
            Banco_Sprites Sprites =FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getSpritePorOrdem(s);
            xmlAnimacoes.addElement(Sprites.getArquivoXML());
        }
        Vector oggAudios = new Vector();
        for(int s=0;s<FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getContSons();s++){
            Vector oggAudio = new Vector();
            oggAudio.addElement(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getSomPorOrdem(s).getEvent());
            oggAudio.addElement(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getSomPorOrdem(s).getEndereco());
            oggAudios.add(oggAudio);
        }
        lstAnimacoes.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return xmlAnimacoes.size(); }
            public Object getElementAt(int i) { 
                return (xmlAnimacoes.size()>=1 && i<xmlAnimacoes.size())?xmlAnimacoes.elementAt(i).toString():null;
            }
        });
        Vector NomesDeColuna = new Vector();
        NomesDeColuna.addElement("Eventos");
        NomesDeColuna.addElement("�udios");

        tblAudios.setModel(new DefaultTableModel(oggAudios,NomesDeColuna) {
            boolean[] canEdit = new boolean [] {false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        tblAudios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(75);
        tblAudios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(75);







        

        int Prods = FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getContDrops();
        Vector NomesDeColuna2 = new Vector();
        NomesDeColuna2.addElement("<html><big>ID: Item");
        NomesDeColuna2.addElement("<html><b>Drops</b><br>(%)");

        Vector Dados = new Vector();
        if(Prods>=1){
            for(int P=0;P<Prods;P++){
                Dados.add(
                    addItemVector(
                        FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getDropPorOrdem(P).getID(),
                        ((double)FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getDropPorOrdem(P).getpercentual())/100.0
                    )
                );
            }
        }
        tblItens.setRowHeight(38);
        tblItens.setModel(new DefaultTableModel(Dados,NomesDeColuna2) {
            boolean[] canEdit = new boolean[]{false, false};
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
            @Override
            public void setValueAt(Object aValue, int row, int column) {
                int X=tblItens.getSelectedColumn(), Y=tblItens.getSelectedRow();
                if(column==0){
                    StringClass Item = new StringClass(aValue.toString());
                    int ID= Integer.parseInt(Item.extrairEntre("<td><b>", ":</b>"));
                    //Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(row).setID(ID);
                    FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).getDropPorOrdem(row).setID(ID);
                }else if(column==1){
                    int PercDeDrops= Integer.parseInt(aValue.toString().trim());
                    //Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(row).setPrecoDeVenda(PercDeDrops);
                    FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).getDropPorOrdem(row).setPercentual(PercDeDrops);
                }
                tblItens.setColumnSelectionInterval(X, X);
                tblItens.setRowSelectionInterval(Y, Y);

            }
        });
        tblItens.getTableHeader().getColumnModel().getColumn(0).setCellEditor(new MyComboBoxEditor(FrmPrincipal.Itens.getTitutos()));

        tblItens.getTableHeader().getColumnModel().getColumn(1).setMinWidth(64);
        tblItens.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(256);



        


        Dados_Spawns Monstro = FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem);

        String direcao="down";
        SpriteXML spriteXML = Monstro.getSpritePorOrdem(0).getClassXML();
        ImagemClass camadaFundo = new ImagemClass(spriteXML.getDadosPNG().getBloco(0));/**/
        /*int s1=0;
        if(spriteXML.haAcao("stand")){
            if(spriteXML.getAcao("stand").haAnimacao(direcao)){
                s1=spriteXML.getAcao("stand").getAnimacao(direcao).getFrame(0).getIndex();
            }else{
                s1=spriteXML.getAcao("stand").getAnimacao(0).getFrame(0).getIndex();
            }
        }
        ImagemClass camadaFundo = new ImagemClass(spriteXML.getDadosPNG().getBloco(s1));
        int x1=0,y1=0;
        x1=camadaFundo.getLargura()/2;
        y1=camadaFundo.getAltura()/2;
        int Camadas=Monstro.getContSprites();
        for(int s=1;s<Camadas;s++){
            String EnderecoCamadaPNG = Monstro.getSpritePorOrdem(s).getClassXML().getDadosPNG().getEnderecoPNG();
            if(FileClass.seExiste(EnderecoCamadaPNG)){
                SpriteXML novoSpriteXML = Monstro.getSpritePorOrdem(s).getClassXML();
                int x2=0, y2=0,  s2=novoSpriteXML.getAcao("stand").getAnimacao(direcao).getFrame(0).getIndex();
                ImagemClass camadaTopo = new ImagemClass(novoSpriteXML.getDadosPNG().getBloco(s2));
                x2=(camadaTopo.getLargura()/2)+novoSpriteXML.getAcao("stand").getAnimacao(direcao).getFrame(0).getOffsetX();
                y2=(camadaTopo.getAltura()/2)+novoSpriteXML.getAcao("stand").getAnimacao(direcao).getFrame(0).getOffsetY();
                camadaFundo.setMesclagem(camadaTopo.getImage(),x1-x2,y1-y2);
            }
        }/**/
        camadaFundo.setZoom(((double)(((double)150.0)/((double)camadaFundo.getLargura()))));
        //camadaFundo.setZoom(3.0);
        lblVisualizacao.setIcon(camadaFundo.getIcone());/**/
        lblVisualizacao.setText(FrmPrincipal.Monstros.getSpawnPorOrdem(Ordem).getNomeTitulo());
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
        javax.swing.JDialog FrmMonstrosLocalizar = new FrmMonstrosLocalizar(this, rootPaneCheckingEnabled);
        FrmMonstrosLocalizar.setLocation(
                ((this.getWidth() - FrmMonstrosLocalizar.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmMonstrosLocalizar.getHeight()) / 2) + this.getY());
        FrmMonstrosLocalizar.pack();
        FrmMonstrosLocalizar.setModal(true);
        FrmMonstrosLocalizar.setVisible(true);/**/
}//GEN-LAST:event_BtnLocalizarActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(FrmPrincipal.Monstros.getContSpawns()>=1){
            CmbIDs.setModel(new javax.swing.DefaultComboBoxModel(FrmPrincipal.Monstros.getVectorIDs()));
            AbrirRegistro(CmbIDs.getSelectedIndex());
            
            /*SpriteXML spriteXML = new SpriteXML("/home/indigovox/localhost/tmwdata/graphics/sprites/monstro-fada.xml");
            ImagemClass camadaFundo = new ImagemClass(spriteXML.getDadosPNG().getBloco(0));
            camadaFundo.setZoom(((double)(150/camadaFundo.getLargura())));
            lblVisualizacao.setIcon(camadaFundo.getIcone());/**/

            /*SpritePNG spritePNG = new SpritePNG("/home/indigovox/localhost/tmwdata/graphics/sprites/monstro-fada.png",6,9);
            ImagemClass camadaFundo = new ImagemClass(spritePNG.getBloco(0));
            camadaFundo.setZoom(((double)(100/camadaFundo.getLargura())));
            //lblVisualizacao.setIcon(new javax.swing.ImageIcon());
            lblVisualizacao.setIcon(camadaFundo.getIcone());/**/
        }
    }//GEN-LAST:event_formWindowOpened
    private void sldRanger1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldRanger1StateChanged
        lblRanger1.setText("Dist. Ataq.: ("+sldRanger1.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setRange1(sldRanger1.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldRanger1StateChanged
    private void sldSPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSPStateChanged
        lblSP.setText("SP: ("+sldSP.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setSP(sldSP.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldSPStateChanged
    private void sldJobStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldJobStateChanged
        lblJob.setText("Job: ("+sldJob.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setJob(sldJob.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldJobStateChanged
    private void sldNivelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldNivelStateChanged
        lblNivel.setText("N�vel: ("+sldNivel.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setNivel(sldNivel.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldNivelStateChanged
    private void sldHPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldHPStateChanged
        lblHP.setText("HP: ("+sldHP.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setHP(sldHP.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldHPStateChanged
    private void sldEXPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEXPStateChanged
        lblEXP.setText("Exp: ("+sldEXP.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setExp(sldEXP.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldEXPStateChanged
    private void sldAtaque2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAtaque2StateChanged
        lblAtaque2.setText("Max. Ataq: ("+sldAtaque2.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setAtaque2(sldAtaque2.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldAtaque2StateChanged
    private void sldAtaque1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAtaque1StateChanged
        lblAtaque1.setText("Min. Ataq: ("+sldAtaque1.getValue()+")");
        sldAtaque2.setMinimum(sldAtaque1.getValue());
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setAtaque1(sldAtaque1.getValue());
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setAtaque2(sldAtaque2.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldAtaque1StateChanged
    private void sldDefFisicoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldDefFisicoStateChanged
        lblDefFisico.setText("Def.F�sico: ("+sldDefFisico.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setDefesaFisica(sldDefFisico.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldDefFisicoStateChanged
    private void sldDefMagicoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldDefMagicoStateChanged
        lblDefMagico.setText("Def.M�gico: ("+sldDefMagico.getValue()+")");
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setDefesaMagica(sldDefMagico.getValue());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_sldDefMagicoStateChanged
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        FrmPrincipal.Monstros.salvarBanco();
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_btnSalvarActionPerformed
    private void txtNomeTituloCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeTituloCaretUpdate
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setNomeTitulo(txtNomeTitulo.getText().trim());
        lblVisualizacao.setText(txtNomeTitulo.getText().trim());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_txtNomeTituloCaretUpdate
    private void txtNomeSumonicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeSumonicoFocusLost
        String Nome = txtNomeSumonico.getText();
        Nome = Nome.replace(" ", "");
        txtNomeSumonico.setText(Nome);
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setNomeSumonico(txtNomeSumonico.getText());
        btnSalvar.setEnabled(true);
}//GEN-LAST:event_txtNomeSumonicoFocusLost
    private void txtNomeSumonicoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeSumonicoCaretUpdate
        FrmPrincipal.Monstros.getSpawnPorOrdem(CmbIDs.getSelectedIndex()).setNomeSumonico(txtNomeSumonico.getText().trim());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_txtNomeSumonicoCaretUpdate

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
    private javax.swing.JButton BtnLocalizar;
    private javax.swing.JButton BtnVoltar;
    public static javax.swing.JComboBox CmbIDs;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAtaque1;
    private javax.swing.JLabel lblAtaque2;
    private javax.swing.JLabel lblDefFisico;
    private javax.swing.JLabel lblDefMagico;
    private javax.swing.JLabel lblEXP;
    private javax.swing.JLabel lblHP;
    private javax.swing.JLabel lblJob;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblRanger1;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblVisualizacao;
    private javax.swing.JList lstAnimacoes;
    private javax.swing.JSlider sldAtaque1;
    private javax.swing.JSlider sldAtaque2;
    private javax.swing.JSlider sldDefFisico;
    private javax.swing.JSlider sldDefMagico;
    private javax.swing.JSlider sldEXP;
    private javax.swing.JSlider sldHP;
    private javax.swing.JSlider sldJob;
    private javax.swing.JSlider sldNivel;
    private javax.swing.JSlider sldRanger1;
    private javax.swing.JSlider sldSP;
    private javax.swing.JTable tblAudios;
    private javax.swing.JTable tblItens;
    private javax.swing.JFormattedTextField txtNomeSumonico;
    private javax.swing.JTextField txtNomeTitulo;
    // End of variables declaration//GEN-END:variables

}
