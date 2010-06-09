package Formularios;

import javax.swing.DefaultComboBoxModel;

public class FrmItens extends javax.swing.JDialog {
    public FrmItens(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    static String Barra = System.getProperty("file.separator");
    static String PastaDeItens = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"items";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CmbIcone = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtNomeTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CmbTipo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LblEquipHand1 = new javax.swing.JLabel();
        LblEquipArms = new javax.swing.JLabel();
        LblEquipAmmo = new javax.swing.JLabel();
        LblMostruario3 = new javax.swing.JLabel();
        LblEquipCharm = new javax.swing.JLabel();
        LblEquipHand2 = new javax.swing.JLabel();
        LblEquipHead = new javax.swing.JLabel();
        LblEquipTorso = new javax.swing.JLabel();
        LblEquipRing = new javax.swing.JLabel();
        LblEquipLegs = new javax.swing.JLabel();
        LblEquipFeet = new javax.swing.JLabel();
        LblEquipShield = new javax.swing.JLabel();
        LblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Itens");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setText("Ícone do Inventário:");

        CmbIcone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "generic-4leafclover.png" }));
        CmbIcone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIconeActionPerformed(evt);
            }
        });

        jLabel9.setText("Movimento de Char:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<nenhum>", "1: weapon-dagger.xml", "10: weapon-bow.xml", "11: weapon-scythe.xml" }));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Unisex", ""},
                {"Masculino", ""},
                {"Feminino", ""}
            },
            new String [] {
                "Equipamento", "Arquivo do Sprite XML"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Danificar (hit)", ""},
                {"Falhar (strike)", ""},
                {"Lançar (swing)", ""}
            },
            new String [] {
                "Áudio", "Arquivo de Áudio OGG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CmbIcone, 0, 219, Short.MAX_VALUE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CmbIcone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Imagem & Áudio", jPanel2);

        jLabel4.setText("Nome Sumônico:");

        jTextField3.setText("verdadeirotrevo");
        jTextField3.setMinimumSize(new java.awt.Dimension(76, 25));

        jLabel5.setText("Nome Título:");

        TxtNomeTitulo.setText("Verdadeiro Trevo");
        TxtNomeTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomeTituloActionPerformed(evt);
            }
        });
        TxtNomeTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNomeTituloKeyReleased(evt);
            }
        });

        jLabel6.setText("Descrição:");

        jTextField5.setText("Trevo de 4 Folhas só encontrado na Cidade das Fadas.");

        jLabel7.setText("Efeito:");

        jTextField6.setText("+10 Sorte, +25 Def.Mágica");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel8.setText("Peso:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(10, 0, 100000, 1));

        jLabel1.setText("gramas");

        jLabel10.setText("Tipo:");

        CmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "usable", "equip-1hand", "equip-2hand", "equip-ammo", "equip-arms", "equip-charm", "equip-feet", "equip-head", "equip-legs", "equip-ring", "equip-shield", "equip-torso" }));
        CmbTipo.setSelectedIndex(5);
        CmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbTipoActionPerformed(evt);
            }
        });

        jLabel11.setText("Movimentos:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1: knife", "2: sword", "10: bow", "11: polearm" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addComponent(jTextField5, 0, 0, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNomeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtNomeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbTipo, TxtNomeTitulo, jComboBox4, jLabel1, jLabel10, jLabel11, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jSpinner1, jTextField3, jTextField5, jTextField6});

        jTabbedPane1.addTab("Informação", jPanel1);

        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_voltar.gif"))); // NOI18N
        jButton2.setToolTipText("Anterior (Ctrl+Alt+?)");
        jButton2.setEnabled(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3046" }));
        jComboBox2.setToolTipText("Número ID");
        jComboBox2.setEnabled(false);
        jComboBox2.setMaximumSize(new java.awt.Dimension(67, 25));
        jToolBar1.add(jComboBox2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_avancar.gif"))); // NOI18N
        jButton3.setToolTipText("Próxima (Ctrl+Alt+?)");
        jButton3.setEnabled(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        jButton4.setToolTipText("Abrir (Ctrl+O)");
        jButton4.setEnabled(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

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

        LblEquipHand1.setBackground(java.awt.Color.lightGray);
        LblEquipHand1.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipHand1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipHand1.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipHand1.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipHand1.setOpaque(true);
        LblEquipHand1.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipArms.setBackground(java.awt.Color.lightGray);
        LblEquipArms.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipArms.setToolTipText("equip-arms");
        LblEquipArms.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipArms.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipArms.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipArms.setOpaque(true);
        LblEquipArms.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipAmmo.setBackground(java.awt.Color.lightGray);
        LblEquipAmmo.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipAmmo.setToolTipText("equip-ammo");
        LblEquipAmmo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipAmmo.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipAmmo.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipAmmo.setOpaque(true);
        LblEquipAmmo.setPreferredSize(new java.awt.Dimension(32, 32));

        LblMostruario3.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblMostruario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Animacoes/visualizacao-maculina.png"))); // NOI18N
        LblMostruario3.setToolTipText("Verdadeiro Trevo");
        LblMostruario3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LblEquipCharm.setBackground(java.awt.Color.lightGray);
        LblEquipCharm.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipCharm.setIcon(new javax.swing.ImageIcon("/home/indigovox/localhost/tmwdata/graphics/items/generic-4leafclover.png")); // NOI18N
        LblEquipCharm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipCharm.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipCharm.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipCharm.setOpaque(true);
        LblEquipCharm.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipHand2.setBackground(java.awt.Color.lightGray);
        LblEquipHand2.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipHand2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipHand2.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipHand2.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipHand2.setOpaque(true);
        LblEquipHand2.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipHead.setBackground(java.awt.Color.lightGray);
        LblEquipHead.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipHead.setToolTipText("equip-charm");
        LblEquipHead.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipHead.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipHead.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipHead.setOpaque(true);
        LblEquipHead.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipTorso.setBackground(java.awt.Color.lightGray);
        LblEquipTorso.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipTorso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipTorso.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipTorso.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipTorso.setOpaque(true);
        LblEquipTorso.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipRing.setBackground(java.awt.Color.lightGray);
        LblEquipRing.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipRing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipRing.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipRing.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipRing.setOpaque(true);
        LblEquipRing.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipLegs.setBackground(java.awt.Color.lightGray);
        LblEquipLegs.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipLegs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipLegs.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipLegs.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipLegs.setOpaque(true);
        LblEquipLegs.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipFeet.setBackground(java.awt.Color.lightGray);
        LblEquipFeet.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipFeet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipFeet.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipFeet.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipFeet.setOpaque(true);
        LblEquipFeet.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipShield.setBackground(java.awt.Color.lightGray);
        LblEquipShield.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18)); // NOI18N
        LblEquipShield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipShield.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipShield.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipShield.setOpaque(true);
        LblEquipShield.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(LblEquipHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(LblEquipRing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(LblEquipTorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LblEquipShield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblEquipHand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblEquipArms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LblMostruario3)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(LblEquipLegs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblEquipFeet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblEquipAmmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEquipCharm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEquipHand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LblEquipAmmo, LblEquipArms, LblEquipCharm, LblEquipFeet, LblEquipHand1, LblEquipHand2, LblEquipHead, LblEquipLegs, LblEquipRing, LblEquipShield, LblEquipTorso});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblEquipHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblEquipTorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEquipRing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblEquipAmmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEquipArms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblEquipHand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEquipHand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblEquipCharm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEquipShield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(LblMostruario3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblEquipFeet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEquipLegs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LblEquipAmmo, LblEquipArms, LblEquipCharm, LblEquipFeet, LblEquipHand1, LblEquipHand2, LblEquipHead, LblEquipLegs, LblEquipRing, LblEquipShield, LblEquipTorso});

        LblTitulo.setBackground(java.awt.Color.lightGray);
        LblTitulo.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 24)); // NOI18N
        LblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblTitulo.setIcon(new javax.swing.ImageIcon("/home/indigovox/localhost/tmwdata/graphics/items/generic-4leafclover.png")); // NOI18N
        LblTitulo.setText("Verdadeiro Trevo");
        LblTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LblTitulo.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(LblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField6ActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ListaIcone();
    }//GEN-LAST:event_formWindowOpened
    private void CmbIconeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbIconeActionPerformed
        AtualizarImagem();
    }//GEN-LAST:event_CmbIconeActionPerformed
    private void TxtNomeTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomeTituloActionPerformed
        LblTitulo.setText(TxtNomeTitulo.getText());
    }//GEN-LAST:event_TxtNomeTituloActionPerformed
    private void TxtNomeTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNomeTituloKeyReleased
        LblTitulo.setText(TxtNomeTitulo.getText());
    }//GEN-LAST:event_TxtNomeTituloKeyReleased
    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void CmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbTipoActionPerformed
        AtualizarImagem();
    }//GEN-LAST:event_CmbTipoActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmItens dialog = new FrmItens(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox CmbIcone;
    private javax.swing.JComboBox CmbTipo;
    private javax.swing.JLabel LblEquipAmmo;
    private javax.swing.JLabel LblEquipArms;
    private javax.swing.JLabel LblEquipCharm;
    private javax.swing.JLabel LblEquipFeet;
    private javax.swing.JLabel LblEquipHand1;
    private javax.swing.JLabel LblEquipHand2;
    private javax.swing.JLabel LblEquipHead;
    private javax.swing.JLabel LblEquipLegs;
    private javax.swing.JLabel LblEquipRing;
    private javax.swing.JLabel LblEquipShield;
    private javax.swing.JLabel LblEquipTorso;
    private javax.swing.JLabel LblMostruario3;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JTextField TxtNomeTitulo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private void ListaIcone() {
        if(FrmPrincipal.Config.SeExiste(PastaDeItens)){
            String[] Arquivos = FrmPrincipal.Config.ListarArquivos(PastaDeItens);
            //setTitle(""+Arquivos.length);
            if(Arquivos.length>=1){

                String AgrupamentoDeArquivos[] = new String[Arquivos.length];
                int ContArquivos=0;
                for(int a=0;a<Arquivos.length;a++){
                    if(Arquivos[a].substring(Arquivos[a].length()-4, Arquivos[a].length()).equals(".png")){
                        ContArquivos++;
                        AgrupamentoDeArquivos[ContArquivos-1]=Arquivos[a];
                    }
                }
                Object[] CapsulaDeArquivos= new java.lang.Object[ContArquivos];
                int Selecionado = -1;
                for(int a=0; a<ContArquivos; a++){
                    CapsulaDeArquivos[a]=AgrupamentoDeArquivos[a];
                    if(CapsulaDeArquivos[a].equals("generic-4leafclover.png")) Selecionado=a;
                }
                if(ContArquivos>=1){
                    CmbIcone.setModel(new DefaultComboBoxModel(CapsulaDeArquivos));
                    if(Selecionado>=0) CmbIcone.setSelectedIndex(Selecionado);
                }
            }
        }
    }

    private void AtualizarImagem() {
        String ImagemSelecionada=CmbIcone.getItemAt(CmbIcone.getSelectedIndex()).toString();
        String LocalSelecionado=CmbTipo.getItemAt(CmbTipo.getSelectedIndex()).toString();
        String Endereco=PastaDeItens+Barra+ImagemSelecionada;
        //setTitle("\""+LocalSelecionado+"\"");
        LblTitulo.setIcon(new javax.swing.ImageIcon(Endereco));
        
        if(LocalSelecionado.equals("equip-ammo"))  {LblEquipAmmo.setIcon(new javax.swing.ImageIcon(Endereco));  }else{LblEquipAmmo.setIcon(null);}
        if(LocalSelecionado.equals("equip-arms"))  {LblEquipArms.setIcon(new javax.swing.ImageIcon(Endereco));  }else{LblEquipArms.setIcon(null);}
        if(LocalSelecionado.equals("equip-charm")) {LblEquipCharm.setIcon(new javax.swing.ImageIcon(Endereco)); }else{LblEquipCharm.setIcon(null);}
        if(LocalSelecionado.equals("equip-1hand")) {LblEquipHand1.setIcon(new javax.swing.ImageIcon(Endereco)); }else{LblEquipHand1.setIcon(null);}
        if(LocalSelecionado.equals("equip-2hand")) {LblEquipHand2.setIcon(new javax.swing.ImageIcon(Endereco)); }else{LblEquipHand2.setIcon(null);}
        if(LocalSelecionado.equals("equip-feet"))  {LblEquipFeet.setIcon(new javax.swing.ImageIcon(Endereco));  }else{LblEquipFeet.setIcon(null);}
        if(LocalSelecionado.equals("equip-head"))  {LblEquipHead.setIcon(new javax.swing.ImageIcon(Endereco));  }else{LblEquipHead.setIcon(null);}
        if(LocalSelecionado.equals("equip-legs"))  {LblEquipLegs.setIcon(new javax.swing.ImageIcon(Endereco));  }else{LblEquipLegs.setIcon(null);}
        if(LocalSelecionado.equals("equip-ring"))  {LblEquipRing.setIcon(new javax.swing.ImageIcon(Endereco));  }else{LblEquipRing.setIcon(null);}
        if(LocalSelecionado.equals("equip-shield")){LblEquipShield.setIcon(new javax.swing.ImageIcon(Endereco));}else{LblEquipShield.setIcon(null);}
        if(LocalSelecionado.equals("equip-torso")) {LblEquipTorso.setIcon(new javax.swing.ImageIcon(Endereco)); }else{LblEquipTorso.setIcon(null);}
    }

}
