package Formularios;

import Classes.BancoDeDados.Banco_Monstros.Dados_Monstro;
import Classes.BancoDeDados.Banco_Monstros.Dados_Monstro.Banco_Sprites;
import Classes.DialogClass;
import Classes.FileClass;
import Classes.ImagemClass;
import Classes.Modificadoras.MyComboBoxEditor;
import Classes.SpriteXML;
import Classes.StringClass;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
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

        grpDirecao = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        btnRegistroInicio = new javax.swing.JButton();
        btnRegistroVoltar = new javax.swing.JButton();
        btnRegistroAvancar = new javax.swing.JButton();
        btnRegistroFinal = new javax.swing.JButton();
        cmbIDs = new javax.swing.JComboBox();
        BtnLocalizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAbrir = new javax.swing.JButton();
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
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAnimacoes = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAudios = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
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
        jPanel8 = new javax.swing.JPanel();
        lblForca = new javax.swing.JLabel();
        sldEstatusForca = new javax.swing.JSlider();
        lblAgilidade = new javax.swing.JLabel();
        sldEstatusAgilidade = new javax.swing.JSlider();
        lblVitalidade = new javax.swing.JLabel();
        sldEstatusVitalidade = new javax.swing.JSlider();
        lblInteligencia = new javax.swing.JLabel();
        sldEstatusInteligencia = new javax.swing.JSlider();
        lblDestreza = new javax.swing.JLabel();
        sldEstatusDestreza = new javax.swing.JSlider();
        lblSorte = new javax.swing.JLabel();
        sldEstatusSorte = new javax.swing.JSlider();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblVisualizacao = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        tgbDirecaoAcima = new javax.swing.JToggleButton();
        tgbDirecaoEsquerda = new javax.swing.JToggleButton();
        tgbDirecaoDireita = new javax.swing.JToggleButton();
        tgbDirecaoAbaixo = new javax.swing.JToggleButton();
        tgbDirecaoDireita1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Monstros (Modo Somento-Leitura)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);

        btnRegistroInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_inicio.gif"))); // NOI18N
        btnRegistroInicio.setFocusable(false);
        btnRegistroInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistroInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistroInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroInicioActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRegistroInicio);

        btnRegistroVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_voltar.gif"))); // NOI18N
        btnRegistroVoltar.setToolTipText("Anterior (Ctrl+Alt+?)");
        btnRegistroVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistroVoltar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistroVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroVoltarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRegistroVoltar);

        btnRegistroAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_avancar.gif"))); // NOI18N
        btnRegistroAvancar.setToolTipText("Próxima (Ctrl+Alt+?)");
        btnRegistroAvancar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistroAvancar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistroAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroAvancarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRegistroAvancar);

        btnRegistroFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_final.gif"))); // NOI18N
        btnRegistroFinal.setFocusable(false);
        btnRegistroFinal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistroFinal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistroFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroFinalActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRegistroFinal);

        cmbIDs.setToolTipText("ID dos Monstros");
        cmbIDs.setMaximumSize(new java.awt.Dimension(300, 25));
        cmbIDs.setMinimumSize(new java.awt.Dimension(200, 25));
        cmbIDs.setPreferredSize(new java.awt.Dimension(200, 25));
        cmbIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDsActionPerformed(evt);
            }
        });
        jToolBar1.add(cmbIDs);

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

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        btnAbrir.setToolTipText("Abrir (Ctrl+A)");
        btnAbrir.setEnabled(false);
        btnAbrir.setFocusable(false);
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbrir);

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

        jLabel2.setText("Nome Título:");

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
                    .addComponent(txtNomeSumonico, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(txtNomeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
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
                .addContainerGap(6, Short.MAX_VALUE))
        );

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
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
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

        jLabel5.setText("Áudios OGG:");

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addContainerGap(497, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Aparência", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNivel.setText("Nível: (21)");
        lblNivel.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldNivel.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblRanger1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRanger1.setText("Dist. Ataq.: (0)");
        lblRanger1.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldRanger1.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblHP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHP.setText("HP: (1)");
        lblHP.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldHP.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblSP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSP.setText("SP: (0)");
        lblSP.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldSP.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblEXP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEXP.setText("Exp: (0)");
        lblEXP.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldEXP.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblJob.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJob.setText("Job: (0)");
        lblJob.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldJob.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblAtaque1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAtaque1.setText("Min. Ataq: (0)");
        lblAtaque1.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldAtaque1.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblAtaque2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAtaque2.setText("Max. Ataq: (0)");
        lblAtaque2.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldAtaque2.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblDefFisico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDefFisico.setText("Def.Física: (0)");
        lblDefFisico.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldDefFisico.setMinimumSize(new java.awt.Dimension(38, 30));
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

        lblDefMagico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDefMagico.setText("Def.Mágica: (0)");
        lblDefMagico.setMinimumSize(new java.awt.Dimension(135, 15));
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
        sldDefMagico.setMinimumSize(new java.awt.Dimension(38, 30));
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

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        lblForca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblForca.setText("Força: (1)");
        lblForca.setMinimumSize(new java.awt.Dimension(135, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel8.add(lblForca, gridBagConstraints);

        sldEstatusForca.setMajorTickSpacing(20);
        sldEstatusForca.setMaximum(99);
        sldEstatusForca.setMinimum(1);
        sldEstatusForca.setMinorTickSpacing(5);
        sldEstatusForca.setPaintTicks(true);
        sldEstatusForca.setValue(1);
        sldEstatusForca.setMinimumSize(new java.awt.Dimension(38, 30));
        sldEstatusForca.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldEstatusForcaStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel8.add(sldEstatusForca, gridBagConstraints);

        lblAgilidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAgilidade.setText("Agilidade: (1)");
        lblAgilidade.setMinimumSize(new java.awt.Dimension(135, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel8.add(lblAgilidade, gridBagConstraints);

        sldEstatusAgilidade.setMajorTickSpacing(20);
        sldEstatusAgilidade.setMaximum(99);
        sldEstatusAgilidade.setMinimum(1);
        sldEstatusAgilidade.setMinorTickSpacing(5);
        sldEstatusAgilidade.setPaintTicks(true);
        sldEstatusAgilidade.setValue(1);
        sldEstatusAgilidade.setMinimumSize(new java.awt.Dimension(38, 30));
        sldEstatusAgilidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldEstatusAgilidadeStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel8.add(sldEstatusAgilidade, gridBagConstraints);

        lblVitalidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVitalidade.setText("Vitalidade: (1)");
        lblVitalidade.setMinimumSize(new java.awt.Dimension(135, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel8.add(lblVitalidade, gridBagConstraints);

        sldEstatusVitalidade.setMajorTickSpacing(20);
        sldEstatusVitalidade.setMaximum(99);
        sldEstatusVitalidade.setMinimum(1);
        sldEstatusVitalidade.setMinorTickSpacing(5);
        sldEstatusVitalidade.setPaintTicks(true);
        sldEstatusVitalidade.setValue(1);
        sldEstatusVitalidade.setMinimumSize(new java.awt.Dimension(38, 30));
        sldEstatusVitalidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldEstatusVitalidadeStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel8.add(sldEstatusVitalidade, gridBagConstraints);

        lblInteligencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInteligencia.setText("Inteligência: (1)");
        lblInteligencia.setMinimumSize(new java.awt.Dimension(135, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel8.add(lblInteligencia, gridBagConstraints);

        sldEstatusInteligencia.setMajorTickSpacing(20);
        sldEstatusInteligencia.setMaximum(99);
        sldEstatusInteligencia.setMinimum(1);
        sldEstatusInteligencia.setMinorTickSpacing(5);
        sldEstatusInteligencia.setPaintTicks(true);
        sldEstatusInteligencia.setValue(1);
        sldEstatusInteligencia.setMinimumSize(new java.awt.Dimension(38, 30));
        sldEstatusInteligencia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldEstatusInteligenciaStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel8.add(sldEstatusInteligencia, gridBagConstraints);

        lblDestreza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDestreza.setText("Destreza: (1)");
        lblDestreza.setMinimumSize(new java.awt.Dimension(135, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel8.add(lblDestreza, gridBagConstraints);

        sldEstatusDestreza.setMajorTickSpacing(20);
        sldEstatusDestreza.setMaximum(99);
        sldEstatusDestreza.setMinimum(1);
        sldEstatusDestreza.setMinorTickSpacing(5);
        sldEstatusDestreza.setPaintTicks(true);
        sldEstatusDestreza.setValue(1);
        sldEstatusDestreza.setMinimumSize(new java.awt.Dimension(38, 30));
        sldEstatusDestreza.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldEstatusDestrezaStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel8.add(sldEstatusDestreza, gridBagConstraints);

        lblSorte.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSorte.setText("Sorte: (1)");
        lblSorte.setMinimumSize(new java.awt.Dimension(135, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel8.add(lblSorte, gridBagConstraints);

        sldEstatusSorte.setMajorTickSpacing(20);
        sldEstatusSorte.setMaximum(99);
        sldEstatusSorte.setMinimum(1);
        sldEstatusSorte.setMinorTickSpacing(5);
        sldEstatusSorte.setPaintTicks(true);
        sldEstatusSorte.setValue(1);
        sldEstatusSorte.setMinimumSize(new java.awt.Dimension(38, 30));
        sldEstatusSorte.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldEstatusSorteStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel8.add(sldEstatusSorte, gridBagConstraints);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Poder", jPanel9);

        jLabel6.setText("Itens que o montro deixará cair ao morrer:");

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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        jTabbedPane1.addTab("Prêmios", jPanel6);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVisualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        grpDirecao.add(tgbDirecaoAcima);
        tgbDirecaoAcima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ceta-norte.png"))); // NOI18N
        tgbDirecaoAcima.setMaximumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoAcima.setMinimumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoAcima.setPreferredSize(new java.awt.Dimension(23, 23));
        tgbDirecaoAcima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbDirecaoAcimaActionPerformed(evt);
            }
        });

        grpDirecao.add(tgbDirecaoEsquerda);
        tgbDirecaoEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ceta-oeste.png"))); // NOI18N
        tgbDirecaoEsquerda.setMaximumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoEsquerda.setMinimumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoEsquerda.setPreferredSize(new java.awt.Dimension(23, 23));
        tgbDirecaoEsquerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbDirecaoEsquerdaActionPerformed(evt);
            }
        });

        grpDirecao.add(tgbDirecaoDireita);
        tgbDirecaoDireita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ceta-leste.png"))); // NOI18N
        tgbDirecaoDireita.setMaximumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoDireita.setMinimumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoDireita.setPreferredSize(new java.awt.Dimension(23, 23));
        tgbDirecaoDireita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbDirecaoDireitaActionPerformed(evt);
            }
        });

        grpDirecao.add(tgbDirecaoAbaixo);
        tgbDirecaoAbaixo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ceta-sul.png"))); // NOI18N
        tgbDirecaoAbaixo.setSelected(true);
        tgbDirecaoAbaixo.setMaximumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoAbaixo.setMinimumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoAbaixo.setPreferredSize(new java.awt.Dimension(23, 23));
        tgbDirecaoAbaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbDirecaoAbaixoActionPerformed(evt);
            }
        });

        grpDirecao.add(tgbDirecaoDireita1);
        tgbDirecaoDireita1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/cetas.png"))); // NOI18N
        tgbDirecaoDireita1.setEnabled(false);
        tgbDirecaoDireita1.setMaximumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoDireita1.setMinimumSize(new java.awt.Dimension(23, 23));
        tgbDirecaoDireita1.setPreferredSize(new java.awt.Dimension(23, 23));
        tgbDirecaoDireita1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbDirecaoDireita1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(tgbDirecaoEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgbDirecaoAbaixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgbDirecaoAcima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(tgbDirecaoDireita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tgbDirecaoDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(tgbDirecaoAcima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tgbDirecaoEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgbDirecaoDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgbDirecaoDireita1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tgbDirecaoAbaixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void darAuteracao(boolean Alterado){
        btnAbrir.setEnabled(Alterado);
        btnSalvar.setEnabled(Alterado);
        btnRegistroInicio.setEnabled(!Alterado);
        btnRegistroVoltar.setEnabled(!Alterado);
        btnRegistroAvancar.setEnabled(!Alterado);
        btnRegistroFinal.setEnabled(!Alterado);
        cmbIDs.setEnabled(!Alterado);
        BtnLocalizar.setEnabled(!Alterado);
    }
    private Vector addItemVector(int IDTem, double PerctDeDrops){
        Vector Linha = new Vector();
        //Linha.addElement(new ImageIcon(FrmPrincipal.Itens.getItemPorID(IDTem).getIconeImagem()));
        //Linha.addElement(IDTem);
        //Linha.addElement(FrmPrincipal.Itens.getItemPorID(IDTem).getNomeTitulo());//Se é um
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
        );//Se é um
        Linha.addElement(PerctDeDrops);
        return Linha;
    }
    private void exibirAparencia(int ordem, String acao, String direcao) {
    //#################### CONFIGURAÇÕES ######################################
        int MaxCamadas=1; // Mas que uma camada Esta dando erro
        int LarguraMaxima=150;
        int TipoDeAvisoDeErro=0; //0=Nada; 1=EmEstatus(Indisponível); 2=EmDialogo
    //#########################################################################
        
        Dados_Monstro Monstro = FrmPrincipal.Monstros.getMonstroPorOrdem(ordem);
        SpriteXML camBaseXML = Monstro.getSpritePorOrdem(0).getClassXML();
        tgbDirecaoAcima.setEnabled(false);
        tgbDirecaoAbaixo.setEnabled(false);
        tgbDirecaoEsquerda.setEnabled(false);
        tgbDirecaoDireita.setEnabled(false);
        if(FileClass.seExiste(camBaseXML.getSpritePNGdados().getEnderecoPNG())){
            int s1=0,x1=0,y1=0;
            if(camBaseXML.haAcao(acao)){
                if(camBaseXML.getAcao(acao).haAnimacao(direcao)){
                    if(camBaseXML.getAcao(acao).getAnimacao(direcao).getContFrames()>=1){
                        s1=camBaseXML.getAcao(acao).getAnimacao(direcao).getFrame(0).getIndex();
                        tgbDirecaoAcima.setEnabled(true);
                        tgbDirecaoAbaixo.setEnabled(true);
                        tgbDirecaoEsquerda.setEnabled(true);
                        tgbDirecaoDireita.setEnabled(true);
                    }else{
                        s1=0;
                        if(TipoDeAvisoDeErro==2) DialogClass.showErro("<html>"+
                            "Não foi possivel visualizar o frame \"<font color=\"#FF0000\">"+camBaseXML.getSpritePNGdados().getArquivoPNG()+":"+acao+":"+direcao+":"+0+"\"</font>!",
                            "ERRO DE CAMADA 0"
                        );
                    }
                }else{
                    s1=0;
                    if(TipoDeAvisoDeErro==2) DialogClass.showErro("<html>"+
                        "Não foi possivel visualizar o frame \"<font color=\"#FF0000\">"+camBaseXML.getSpritePNGdados().getArquivoPNG()+":"+acao+":"+direcao+"\"</font>!",
                        "ERRO DE CAMADA 0"
                    );
                }
            }else{
                s1=0;
                if(TipoDeAvisoDeErro==2) DialogClass.showErro("<html>"+
                    "Não foi possivel visualizar o frame \"<font color=\"#FF0000\">"+camBaseXML.getSpritePNGdados().getArquivoPNG()+":"+acao+"\"</font>!",
                    "ERRO DE CAMADA 0"
                );
            }
            ImagemClass camBasePNG = new ImagemClass(camBaseXML.getSpritePNGdados().getBloco(s1));
            x1=(int)(camBasePNG.getLargura()/2);
            y1=(int)(camBasePNG.getAltura()/2);

            int Camadas=(Monstro.getContSprites()>MaxCamadas?MaxCamadas:Monstro.getContSprites());
            for(int cam=1;cam<Camadas;cam++){
                tgbDirecaoAcima.setEnabled(false);
                tgbDirecaoAbaixo.setEnabled(false);
                tgbDirecaoEsquerda.setEnabled(false);
                tgbDirecaoDireita.setEnabled(false);
                SpriteXML camTopoXML = Monstro.getSpritePorOrdem(cam).getClassXML();
                String EnderecoCamadaPNG = camTopoXML.getSpritePNGdados().getEnderecoPNG();
                if(FileClass.seExiste(EnderecoCamadaPNG)){
                    int s2=0,x2=0,y2=0;
                    if(camTopoXML.haAcao(acao)){
                        if(camTopoXML.getAcao(acao).haAnimacao(direcao)){
                            if(camTopoXML.getAcao(acao).getAnimacao(direcao).getContFrames()>=1){
                                s2=camTopoXML.getAcao(acao).getAnimacao(direcao).getFrame(0).getIndex();
                            }else{
                                s2=0;
                                if(TipoDeAvisoDeErro==2) DialogClass.showErro("<html>"+
                                    "Não foi possivel visualizar o frame \"<font color=\"#FF0000\">"+camTopoXML.getSpritePNGdados().getArquivoPNG()+":"+acao+":"+direcao+":"+0+"\"</font>!",
                                    "ERRO DE CAMADA "+cam
                                );
                            }
                        }else{
                            s2=0;
                            if(TipoDeAvisoDeErro==2) DialogClass.showErro("<html>"+
                                "Não foi possivel visualizar o frame \"<font color=\"#FF0000\">"+camTopoXML.getSpritePNGdados().getArquivoPNG()+":"+acao+":"+direcao+"\"</font>!",
                                "ERRO DE CAMADA "+cam
                            );
                        }
                    }else{
                        s2=0;
                        if(TipoDeAvisoDeErro==2) DialogClass.showErro("<html>"+
                            "Não foi possivel visualizar o frame \"<font color=\"#FF0000\">"+camTopoXML.getSpritePNGdados().getArquivoPNG()+":"+acao+"\"</font>!",
                            "ERRO DE CAMADA "+cam
                        );
                    }

                    ImagemClass camTopoPNG = new ImagemClass(camTopoXML.getSpritePNGdados().getBloco(s2));

                    if(
                        camTopoXML.haAcao(acao) &&
                        camTopoXML.getAcao(acao).haAnimacao(direcao) &&
                        camTopoXML.getAcao(acao).getAnimacao(direcao).getContFrames()>=1
                    ){
                        x2=((int)(camTopoPNG.getLargura()/2))+camTopoXML.getAcao(acao).getAnimacao(direcao).getFrame(0).getOffsetX();
                        y2=((int)(camTopoPNG.getAltura()/2))+camTopoXML.getAcao(acao).getAnimacao(direcao).getFrame(0).getOffsetY();
                        tgbDirecaoAcima.setEnabled(true);
                        tgbDirecaoAbaixo.setEnabled(true);
                        tgbDirecaoEsquerda.setEnabled(true);
                        tgbDirecaoDireita.setEnabled(true);
                    }
                    camBasePNG.setMesclagem(camTopoPNG.getImage(),x1-x2,y1-y2);
                }
            }
            if(camBasePNG.getZoom(3.0).getWidth()<=LarguraMaxima){
                camBasePNG.setZoom(3.0);
            }else{
                double Zoom = ((double)(((double)LarguraMaxima)/((double)camBasePNG.getLargura())));
                camBasePNG.setZoom(Zoom);
            }
            //camBasePNG.setZoom(3.0);
            lblVisualizacao.setIcon(camBasePNG.getIcone());/**/
        }
        lblVisualizacao.setText(Monstro.getNomeTitulo());
    }
    private void AbrirRegistro(int Ordem) {
        if(Ordem<0) return;

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

        txtNomeTitulo.setText(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getNomeTitulo());
        txtNomeSumonico.setText(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getNomeSumonico());
        sldNivel.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getNivel());
        sldRanger1.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getRange1());
        sldHP.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getHP());
        sldSP.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getSP());
        sldEXP.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getExp());
        sldJob.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getJob());
        sldAtaque1.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getAtaque1());
        sldAtaque2.setMinimum(sldAtaque1.getValue());
        sldAtaque2.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getAtaque2());
        sldDefFisico.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getDefesaFisica());
        sldDefMagico.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getDefesaMagica());

        final Vector xmlAnimacoes = new Vector();
        //final Vector pngImagens = new Vector();
        for(int s=0;s<FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getContSprites();s++){
            Banco_Sprites Sprites =FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getSpritePorOrdem(s);
            xmlAnimacoes.addElement(
                Sprites.getArquivoXML()+
                (Sprites.getClassXML().getSpritePNGbaseRecolor().trim().equals("")?"":"|"+Sprites.getClassXML().getSpritePNGbaseRecolor())+
                (Sprites.getRecolor().trim().equals("")?"":"|"+Sprites.getRecolor())
            );
        }
        Vector oggAudios = new Vector();
        for(int s=0;s<FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getContSons();s++){
            Vector oggAudio = new Vector();
            oggAudio.addElement(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getSomPorOrdem(s).getEvent());
            oggAudio.addElement(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getSomPorOrdem(s).getEndereco());
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
        NomesDeColuna.addElement("Áudios");

        tblAudios.setModel(new DefaultTableModel(oggAudios,NomesDeColuna) {
            boolean[] canEdit = new boolean [] {false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        tblAudios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(75);
        tblAudios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(75);

        sldEstatusForca.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getEstatusForca());
        sldEstatusAgilidade.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getEstatusAgilidade());
        sldEstatusVitalidade.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getEstatusVitalidade());
        sldEstatusInteligencia.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getEstatusInteligencias());
        sldEstatusDestreza.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getEstatusDestresa());
        sldEstatusSorte.setValue(FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getEstatusSorte());







        

        int Prods = FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getContDrops();
        Vector NomesDeColuna2 = new Vector();
        NomesDeColuna2.addElement("<html><big>ID: Item");
        NomesDeColuna2.addElement("<html><b>Drops</b><br>(%)");

        Vector Dados = new Vector();
        if(Prods>=1){
            for(int P=0;P<Prods;P++){
                Dados.add(
                    addItemVector(
                        FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getDropPorOrdem(P).getID(),
                        ((double)FrmPrincipal.Monstros.getMonstroPorOrdem(Ordem).getDropPorOrdem(P).getpercentual())/100.0
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
                    FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).getDropPorOrdem(row).setID(ID);
                }else if(column==1){
                    int PercDeDrops= Integer.parseInt(aValue.toString().trim());
                    //Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(row).setPrecoDeVenda(PercDeDrops);
                    FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).getDropPorOrdem(row).setPercentual(PercDeDrops);
                }
                tblItens.setColumnSelectionInterval(X, X);
                tblItens.setRowSelectionInterval(Y, Y);

            }
        });
        tblItens.getTableHeader().getColumnModel().getColumn(0).setCellEditor(new MyComboBoxEditor(FrmPrincipal.Itens.getTitutos()));

        tblItens.getTableHeader().getColumnModel().getColumn(1).setMinWidth(64);
        tblItens.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(256);



        

        if(tgbDirecaoAbaixo.isSelected()) exibirAparencia(Ordem,"stand","down");
        if(tgbDirecaoAcima.isSelected()) exibirAparencia(Ordem,"stand","up");
        if(tgbDirecaoEsquerda.isSelected()) exibirAparencia(Ordem,"stand","left");
        if(tgbDirecaoDireita.isSelected()) exibirAparencia(Ordem,"stand","right");
        

        darAuteracao(false);
    }

    private void btnRegistroVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroVoltarActionPerformed
        if(cmbIDs.getSelectedIndex()>0){
            cmbIDs.setSelectedIndex(cmbIDs.getSelectedIndex()-1);
            AbrirRegistro(cmbIDs.getSelectedIndex());
        }
        btnRegistroVoltar.grabFocus();
}//GEN-LAST:event_btnRegistroVoltarActionPerformed
    private void cmbIDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDsActionPerformed
        AbrirRegistro(cmbIDs.getSelectedIndex());
}//GEN-LAST:event_cmbIDsActionPerformed
    private void btnRegistroAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroAvancarActionPerformed
        if(cmbIDs.getSelectedIndex()<cmbIDs.getItemCount()-1){
            cmbIDs.setSelectedIndex(cmbIDs.getSelectedIndex()+1);
            AbrirRegistro(cmbIDs.getSelectedIndex());
        }
        btnRegistroAvancar.grabFocus();
}//GEN-LAST:event_btnRegistroAvancarActionPerformed
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
        if(FrmPrincipal.Monstros!=null && FrmPrincipal.Monstros.getContMonstros()>=1){
            cmbIDs.setModel(new DefaultComboBoxModel(FrmPrincipal.Monstros.getVectorIDs()));
            AbrirRegistro(cmbIDs.getSelectedIndex());
        }
    }//GEN-LAST:event_formWindowOpened
    private void sldRanger1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldRanger1StateChanged
        lblRanger1.setText("Dist. Ataq.: ("+sldRanger1.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldRanger1StateChanged
    private void sldSPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSPStateChanged
        lblSP.setText("SP: ("+sldSP.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldSPStateChanged
    private void sldJobStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldJobStateChanged
        lblJob.setText("Job: ("+sldJob.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldJobStateChanged
    private void sldNivelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldNivelStateChanged
        lblNivel.setText("Nível: ("+sldNivel.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldNivelStateChanged
    private void sldHPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldHPStateChanged
        lblHP.setText("HP: ("+sldHP.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldHPStateChanged
    private void sldEXPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEXPStateChanged
        lblEXP.setText("Exp: ("+sldEXP.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldEXPStateChanged
    private void sldAtaque2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAtaque2StateChanged
        lblAtaque2.setText("Max. Ataq: ("+sldAtaque2.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldAtaque2StateChanged
    private void sldAtaque1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAtaque1StateChanged
        lblAtaque1.setText("Min. Ataq: ("+sldAtaque1.getValue()+")");
        sldAtaque2.setMinimum(sldAtaque1.getValue());
        darAuteracao(true);
    }//GEN-LAST:event_sldAtaque1StateChanged
    private void sldDefFisicoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldDefFisicoStateChanged
        lblDefFisico.setText("Def.Física: ("+sldDefFisico.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldDefFisicoStateChanged
    private void sldDefMagicoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldDefMagicoStateChanged
        lblDefMagico.setText("Def.Mágica: ("+sldDefMagico.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldDefMagicoStateChanged
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setNomeTitulo(txtNomeTitulo.getText().trim());
        lblVisualizacao.setText(txtNomeTitulo.getText().trim());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setNomeSumonico(txtNomeSumonico.getText().trim());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setNivel(sldNivel.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setRange1(sldRanger1.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setHP(sldHP.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setSP(sldSP.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setExp(sldEXP.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setJob(sldJob.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setAtaque1(sldAtaque1.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setAtaque2(sldAtaque2.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setDefesaFisica(sldDefFisico.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setDefesaMagica(sldDefMagico.getValue());

        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setEstatusForca(sldEstatusForca.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setEstatusAgilidade(sldEstatusAgilidade.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setEstatusVitalidade(sldEstatusVitalidade.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setEstatusInteligencia(sldEstatusInteligencia.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setEstatusDestresa(sldEstatusDestreza.getValue());
        FrmPrincipal.Monstros.getMonstroPorOrdem(cmbIDs.getSelectedIndex()).setEstatusSorte(sldEstatusSorte.getValue());

        FrmPrincipal.Monstros.salvarBanco();
        darAuteracao(false);
    }//GEN-LAST:event_btnSalvarActionPerformed
    private void txtNomeTituloCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeTituloCaretUpdate
        darAuteracao(true);
    }//GEN-LAST:event_txtNomeTituloCaretUpdate
    private void txtNomeSumonicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeSumonicoFocusLost
        String Nome = txtNomeSumonico.getText();
        Nome = Nome.replace(" ", "");
        txtNomeSumonico.setText(Nome);
        darAuteracao(true);
}//GEN-LAST:event_txtNomeSumonicoFocusLost
    private void txtNomeSumonicoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeSumonicoCaretUpdate
        darAuteracao(true);
    }//GEN-LAST:event_txtNomeSumonicoCaretUpdate
    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if(FrmPrincipal.Monstros!=null && FrmPrincipal.Monstros.getContMonstros()>=1){
            AbrirRegistro(cmbIDs.getSelectedIndex());
            darAuteracao(false);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed
    private void sldEstatusForcaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEstatusForcaStateChanged
        lblForca.setText("Força: ("+sldEstatusForca.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldEstatusForcaStateChanged
    private void sldEstatusAgilidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEstatusAgilidadeStateChanged
        lblAgilidade.setText("Agilidade: ("+sldEstatusAgilidade.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldEstatusAgilidadeStateChanged
    private void sldEstatusVitalidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEstatusVitalidadeStateChanged
        lblVitalidade.setText("Vitalidade: ("+sldEstatusVitalidade.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldEstatusVitalidadeStateChanged
    private void sldEstatusInteligenciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEstatusInteligenciaStateChanged
        lblInteligencia.setText("Inteligência: ("+sldEstatusInteligencia.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldEstatusInteligenciaStateChanged
    private void sldEstatusDestrezaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEstatusDestrezaStateChanged
        lblDestreza.setText("Destreza: ("+sldEstatusDestreza.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldEstatusDestrezaStateChanged
    private void sldEstatusSorteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEstatusSorteStateChanged
        lblSorte.setText("Sorte: ("+sldEstatusSorte.getValue()+")");
        darAuteracao(true);
    }//GEN-LAST:event_sldEstatusSorteStateChanged
    private void btnRegistroInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroInicioActionPerformed
        if(cmbIDs.getSelectedIndex()>0){
            cmbIDs.setSelectedIndex(0);
            AbrirRegistro(cmbIDs.getSelectedIndex());
        }
        btnRegistroInicio.grabFocus();
    }//GEN-LAST:event_btnRegistroInicioActionPerformed
    private void btnRegistroFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroFinalActionPerformed
        if(cmbIDs.getSelectedIndex()<cmbIDs.getItemCount()-1){
            cmbIDs.setSelectedIndex(cmbIDs.getItemCount()-1);
            AbrirRegistro(cmbIDs.getSelectedIndex());
        }
        btnRegistroFinal.grabFocus();
    }//GEN-LAST:event_btnRegistroFinalActionPerformed

    private void tgbDirecaoAbaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDirecaoAbaixoActionPerformed
        exibirAparencia(cmbIDs.getSelectedIndex(),"stand","down");
    }//GEN-LAST:event_tgbDirecaoAbaixoActionPerformed
    private void tgbDirecaoAcimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDirecaoAcimaActionPerformed
        exibirAparencia(cmbIDs.getSelectedIndex(),"stand","up");
    }//GEN-LAST:event_tgbDirecaoAcimaActionPerformed
    private void tgbDirecaoDireitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDirecaoDireitaActionPerformed
        exibirAparencia(cmbIDs.getSelectedIndex(),"stand","right");
    }//GEN-LAST:event_tgbDirecaoDireitaActionPerformed
    private void tgbDirecaoEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDirecaoEsquerdaActionPerformed
        exibirAparencia(cmbIDs.getSelectedIndex(),"stand","left");
    }//GEN-LAST:event_tgbDirecaoEsquerdaActionPerformed

    private void tgbDirecaoDireita1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDirecaoDireita1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgbDirecaoDireita1ActionPerformed

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
    private javax.swing.JButton BtnLocalizar;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnRegistroAvancar;
    private javax.swing.JButton btnRegistroFinal;
    private javax.swing.JButton btnRegistroInicio;
    private javax.swing.JButton btnRegistroVoltar;
    private javax.swing.JButton btnSalvar;
    public static javax.swing.JComboBox cmbIDs;
    private javax.swing.ButtonGroup grpDirecao;
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
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAgilidade;
    private javax.swing.JLabel lblAtaque1;
    private javax.swing.JLabel lblAtaque2;
    private javax.swing.JLabel lblDefFisico;
    private javax.swing.JLabel lblDefMagico;
    private javax.swing.JLabel lblDestreza;
    private javax.swing.JLabel lblEXP;
    private javax.swing.JLabel lblForca;
    private javax.swing.JLabel lblHP;
    private javax.swing.JLabel lblInteligencia;
    private javax.swing.JLabel lblJob;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblRanger1;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblSorte;
    private javax.swing.JLabel lblVisualizacao;
    private javax.swing.JLabel lblVitalidade;
    private javax.swing.JList lstAnimacoes;
    private javax.swing.JSlider sldAtaque1;
    private javax.swing.JSlider sldAtaque2;
    private javax.swing.JSlider sldDefFisico;
    private javax.swing.JSlider sldDefMagico;
    private javax.swing.JSlider sldEXP;
    private javax.swing.JSlider sldEstatusAgilidade;
    private javax.swing.JSlider sldEstatusDestreza;
    private javax.swing.JSlider sldEstatusForca;
    private javax.swing.JSlider sldEstatusInteligencia;
    private javax.swing.JSlider sldEstatusSorte;
    private javax.swing.JSlider sldEstatusVitalidade;
    private javax.swing.JSlider sldHP;
    private javax.swing.JSlider sldJob;
    private javax.swing.JSlider sldNivel;
    private javax.swing.JSlider sldRanger1;
    private javax.swing.JSlider sldSP;
    private javax.swing.JTable tblAudios;
    private javax.swing.JTable tblItens;
    private javax.swing.JToggleButton tgbDirecaoAbaixo;
    private javax.swing.JToggleButton tgbDirecaoAcima;
    private javax.swing.JToggleButton tgbDirecaoDireita;
    private javax.swing.JToggleButton tgbDirecaoDireita1;
    private javax.swing.JToggleButton tgbDirecaoEsquerda;
    private javax.swing.JFormattedTextField txtNomeSumonico;
    private javax.swing.JTextField txtNomeTitulo;
    // End of variables declaration//GEN-END:variables

}
