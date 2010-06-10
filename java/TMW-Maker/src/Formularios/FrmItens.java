package Formularios;

import Classes.ConfigClass;
import Classes.ItemClass;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.DefaultComboBoxModel;

public class FrmItens extends javax.swing.JDialog {
    public FrmItens(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    static String Barra = System.getProperty("file.separator");
    static String PastaDeItens = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"items";
    static String EnderecoItensXML = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"items.xml";
    static String EnderecoItensTXT = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"db"+Barra+"item_db.txt";

    public static ItemClass Itens[];

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TpnPaleta = new javax.swing.JTabbedPane();
        PneInformacao = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TxtNomeSumonico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtNomeTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CmbUtilidade = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        CmbGenero = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ChkEquipavelCabeça = new javax.swing.JCheckBox();
        ChkEquipavelPernas = new javax.swing.JCheckBox();
        ChkEquipavelMaos = new javax.swing.JCheckBox();
        ChkEquipavelPes = new javax.swing.JCheckBox();
        ChkEquipavelTorco1 = new javax.swing.JCheckBox();
        ChkEquipavelBraco2 = new javax.swing.JCheckBox();
        ChkEquipavelBraco1 = new javax.swing.JCheckBox();
        ChkEquipavelAcessorio = new javax.swing.JCheckBox();
        ChkEquipavelTorco2 = new javax.swing.JCheckBox();
        ChkEquipavelMunicao = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        SpnPoderAtaque = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        SpnPoderDefesa = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        SpnPoderAlcance = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        SpnPoderBonusMagico = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        SpnOculpacaoDeLote = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        PneComercio = new javax.swing.JPanel();
        SpnPrecoCompra = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        SpnPrecoVenda = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SpnPeso = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        PneAudio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PneEquipamento = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CmbIcone = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        CmbLocal = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        TxtScripAoConsulmir = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        TxtScripAoEquipar = new javax.swing.JTextField();
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
        PneVisualizacao = new javax.swing.JPanel();
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

        PneInformacao.setEnabled(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nome Sumônico:");

        TxtNomeSumonico.setEditable(false);
        TxtNomeSumonico.setText("verdadeirotrevo");
        TxtNomeSumonico.setMinimumSize(new java.awt.Dimension(76, 25));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nome Título:");

        TxtNomeTitulo.setEditable(false);
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

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descrição:");

        jTextField5.setEditable(false);
        jTextField5.setText("Trevo de 4 Folhas só encontrado na Cidade das Fadas.");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Efeito:");

        jTextField6.setEditable(false);
        jTextField6.setText("+10 Sorte, +25 Def.Mágica");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Utilidade:");

        CmbUtilidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0: Medicinal / Afetador", "2: Consumível", "3: Constável / Genérico", "4: Arma", "5: Proteção / Vestimenta", "6: Carta", "7: Ovo de Mascote", "8: Equipamento de Mascote,", "10: Flecha / Munição", "11: Consumível lentamente" }));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Gênero:");

        CmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0: Feminino", "1: Masculino", "2: Ambos" }));
        CmbGenero.setSelectedIndex(2);
        CmbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PneInformacaoLayout = new javax.swing.GroupLayout(PneInformacao);
        PneInformacao.setLayout(PneInformacaoLayout);
        PneInformacaoLayout.setHorizontalGroup(
            PneInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneInformacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PneInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(jLabel25))
                .addGap(5, 5, 5)
                .addGroup(PneInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbGenero, 0, 265, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(TxtNomeSumonico, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(TxtNomeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(CmbUtilidade, 0, 265, Short.MAX_VALUE))
                .addContainerGap())
        );
        PneInformacaoLayout.setVerticalGroup(
            PneInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneInformacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PneInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PneInformacaoLayout.createSequentialGroup()
                        .addComponent(TxtNomeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNomeSumonico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PneInformacaoLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PneInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(CmbUtilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PneInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(CmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        PneInformacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbGenero, CmbUtilidade, TxtNomeSumonico, TxtNomeTitulo, jLabel11, jLabel25, jLabel4, jLabel5, jLabel6, jLabel7, jTextField5, jTextField6});

        TpnPaleta.addTab("Informação", PneInformacao);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Local equipavel do corpo"));

        ChkEquipavelCabeça.setText("Cabeça (p/ Chapéus)");

        ChkEquipavelPernas.setText("Pernas (p/ Calças)");

        ChkEquipavelMaos.setText("Mãos (p/ Luvas)");

        ChkEquipavelPes.setText("Pés (p/ Sapatos)");

        ChkEquipavelTorco1.setText("Torço1 (p/ Vestimentas)");

        ChkEquipavelBraco2.setText("Braço 2 (p/ Escudos)");

        ChkEquipavelBraco1.setText("Braço 1 (p/ Armas)");

        ChkEquipavelAcessorio.setText("Acessório");

        ChkEquipavelTorco2.setText("Torço2 (p/ Armaduras)");

        ChkEquipavelMunicao.setText("Munição (p/ Flechas)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChkEquipavelTorco1)
                    .addComponent(ChkEquipavelTorco2)
                    .addComponent(ChkEquipavelCabeça)
                    .addComponent(ChkEquipavelBraco1)
                    .addComponent(ChkEquipavelBraco2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChkEquipavelMunicao)
                    .addComponent(ChkEquipavelAcessorio)
                    .addComponent(ChkEquipavelMaos)
                    .addComponent(ChkEquipavelPernas)
                    .addComponent(ChkEquipavelPes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkEquipavelCabeça)
                    .addComponent(ChkEquipavelMaos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkEquipavelTorco1)
                    .addComponent(ChkEquipavelPes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkEquipavelTorco2)
                    .addComponent(ChkEquipavelPernas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkEquipavelBraco1)
                    .addComponent(ChkEquipavelAcessorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkEquipavelBraco2)
                    .addComponent(ChkEquipavelMunicao))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        TpnPaleta.addTab("Equipamento", jPanel2);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Ataque:");

        SpnPoderAtaque.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 5));
        SpnPoderAtaque.setFocusable(false);

        jLabel16.setText("hits");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Defesa:");

        SpnPoderDefesa.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 5));
        SpnPoderDefesa.setFocusable(false);

        jLabel18.setText("hits");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Alcance:");

        SpnPoderAlcance.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        SpnPoderAlcance.setFocusable(false);

        jLabel20.setText("metros (tiles)");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Bonus Mágico:");

        SpnPoderBonusMagico.setModel(new javax.swing.SpinnerNumberModel(0, -1000, 1000, 5));
        SpnPoderBonusMagico.setFocusable(false);

        jLabel22.setText("pontos");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Espaço ocupado");

        SpnOculpacaoDeLote.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        SpnOculpacaoDeLote.setFocusable(false);

        jLabel24.setText("(extra no inventário)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SpnPoderAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SpnPoderDefesa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SpnPoderAlcance, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SpnPoderBonusMagico, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SpnOculpacaoDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel24)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpnPoderAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpnPoderDefesa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpnPoderBonusMagico, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpnPoderAlcance, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpnOculpacaoDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {SpnPoderAlcance, SpnPoderAtaque, SpnPoderDefesa, jLabel15, jLabel16});

        TpnPaleta.addTab("Poder", jPanel1);

        SpnPrecoCompra.setModel(new javax.swing.SpinnerNumberModel(50000, 0, 10000000, 1));
        SpnPrecoCompra.setFocusable(false);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Preço de compra:");

        SpnPrecoVenda.setModel(new javax.swing.SpinnerNumberModel(25000, 0, 10000000, 1));
        SpnPrecoVenda.setFocusable(false);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Preço de Venda:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Peso:");

        SpnPeso.setModel(new javax.swing.SpinnerNumberModel(10, 0, 100000, 1));
        SpnPeso.setFocusable(false);

        jLabel1.setText("gramas");

        jLabel3.setText("GP");

        jLabel14.setText("GP");

        javax.swing.GroupLayout PneComercioLayout = new javax.swing.GroupLayout(PneComercio);
        PneComercio.setLayout(PneComercioLayout);
        PneComercioLayout.setHorizontalGroup(
            PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneComercioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5)
                .addGroup(PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SpnPeso, 0, 0, Short.MAX_VALUE)
                    .addComponent(SpnPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(SpnPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel14))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        PneComercioLayout.setVerticalGroup(
            PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneComercioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PneComercioLayout.createSequentialGroup()
                        .addGroup(PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpnPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpnPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PneComercioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpnPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        TpnPaleta.addTab("Comércio", PneComercio);

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
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout PneAudioLayout = new javax.swing.GroupLayout(PneAudio);
        PneAudio.setLayout(PneAudioLayout);
        PneAudioLayout.setHorizontalGroup(
            PneAudioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneAudioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );
        PneAudioLayout.setVerticalGroup(
            PneAudioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneAudioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        TpnPaleta.addTab("Áudio", PneAudio);

        jLabel2.setText("Ícone do Inventário:");

        CmbIcone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "generic-4leafclover.png" }));
        CmbIcone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIconeActionPerformed(evt);
            }
        });

        jLabel9.setText("Movimento de Char:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<nenhum>", "1: weapon-dagger.xml", "10: weapon-bow.xml", "11: weapon-scythe.xml", "12: weapon-staff.xml" }));

        jScrollPane2.setEnabled(false);

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
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setEnabled(false);
        jScrollPane2.setViewportView(jTable2);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Local da Janela:");

        CmbLocal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "usable", "equip-1hand", "equip-2hand", "equip-ammo", "equip-arms", "equip-charm", "equip-feet", "equip-head", "equip-legs", "equip-ring", "equip-shield", "equip-torso" }));
        CmbLocal.setSelectedIndex(5);
        CmbLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbLocalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PneEquipamentoLayout = new javax.swing.GroupLayout(PneEquipamento);
        PneEquipamento.setLayout(PneEquipamentoLayout);
        PneEquipamentoLayout.setHorizontalGroup(
            PneEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneEquipamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PneEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PneEquipamentoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(PneEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addGap(4, 4, 4)
                        .addGroup(PneEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CmbIcone, 0, 248, Short.MAX_VALUE)
                            .addComponent(CmbLocal, 0, 248, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addGroup(PneEquipamentoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(jComboBox3, 0, 248, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PneEquipamentoLayout.setVerticalGroup(
            PneEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneEquipamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PneEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CmbIcone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PneEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PneEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        TpnPaleta.addTab("Animação", PneEquipamento);

        jLabel26.setText("Executar ao Consulmir:");

        TxtScripAoConsulmir.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N

        jLabel27.setText("Executar ao Equipar:");

        TxtScripAoEquipar.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtScripAoConsulmir, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(TxtScripAoEquipar, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtScripAoConsulmir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtScripAoEquipar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        TpnPaleta.addTab("Script", jPanel4);

        jToolBar1.setFloatable(false);

        BtnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_voltar.gif"))); // NOI18N
        BtnVoltar.setToolTipText("Anterior (Ctrl+Alt+?)");
        BtnVoltar.setEnabled(false);
        BtnVoltar.setFocusable(false);
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
        CmbIDs.setEnabled(false);
        CmbIDs.setMaximumSize(new java.awt.Dimension(67, 25));
        CmbIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIDsActionPerformed(evt);
            }
        });
        jToolBar1.add(CmbIDs);

        BtnAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_avancar.gif"))); // NOI18N
        BtnAvancar.setToolTipText("Próxima (Ctrl+Alt+?)");
        BtnAvancar.setEnabled(false);
        BtnAvancar.setFocusable(false);
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
        BtnCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCarregarActionPerformed(evt);
            }
        });
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

        LblEquipHand1.setBackground(java.awt.Color.lightGray);
        LblEquipHand1.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipHand1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipHand1.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipHand1.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipHand1.setOpaque(true);
        LblEquipHand1.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipArms.setBackground(java.awt.Color.lightGray);
        LblEquipArms.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipArms.setToolTipText("equip-arms");
        LblEquipArms.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipArms.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipArms.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipArms.setOpaque(true);
        LblEquipArms.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipAmmo.setBackground(java.awt.Color.lightGray);
        LblEquipAmmo.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
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
        LblEquipCharm.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipCharm.setIcon(new javax.swing.ImageIcon("/home/indigovox/localhost/tmwdata/graphics/items/generic-4leafclover.png")); // NOI18N
        LblEquipCharm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipCharm.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipCharm.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipCharm.setOpaque(true);
        LblEquipCharm.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipHand2.setBackground(java.awt.Color.lightGray);
        LblEquipHand2.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipHand2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipHand2.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipHand2.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipHand2.setOpaque(true);
        LblEquipHand2.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipHead.setBackground(java.awt.Color.lightGray);
        LblEquipHead.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipHead.setToolTipText("equip-charm");
        LblEquipHead.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipHead.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipHead.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipHead.setOpaque(true);
        LblEquipHead.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipTorso.setBackground(java.awt.Color.lightGray);
        LblEquipTorso.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipTorso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipTorso.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipTorso.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipTorso.setOpaque(true);
        LblEquipTorso.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipRing.setBackground(java.awt.Color.lightGray);
        LblEquipRing.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipRing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipRing.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipRing.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipRing.setOpaque(true);
        LblEquipRing.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipLegs.setBackground(java.awt.Color.lightGray);
        LblEquipLegs.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipLegs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipLegs.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipLegs.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipLegs.setOpaque(true);
        LblEquipLegs.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipFeet.setBackground(java.awt.Color.lightGray);
        LblEquipFeet.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipFeet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipFeet.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipFeet.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipFeet.setOpaque(true);
        LblEquipFeet.setPreferredSize(new java.awt.Dimension(32, 32));

        LblEquipShield.setBackground(java.awt.Color.lightGray);
        LblEquipShield.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 18));
        LblEquipShield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LblEquipShield.setMaximumSize(new java.awt.Dimension(32, 32));
        LblEquipShield.setMinimumSize(new java.awt.Dimension(32, 32));
        LblEquipShield.setOpaque(true);
        LblEquipShield.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout PneVisualizacaoLayout = new javax.swing.GroupLayout(PneVisualizacao);
        PneVisualizacao.setLayout(PneVisualizacaoLayout);
        PneVisualizacaoLayout.setHorizontalGroup(
            PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneVisualizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PneVisualizacaoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(LblEquipHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PneVisualizacaoLayout.createSequentialGroup()
                            .addComponent(LblEquipRing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(LblEquipTorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PneVisualizacaoLayout.createSequentialGroup()
                            .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LblEquipShield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblEquipHand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblEquipArms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LblMostruario3)
                                .addGroup(PneVisualizacaoLayout.createSequentialGroup()
                                    .addComponent(LblEquipLegs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblEquipFeet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblEquipAmmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEquipCharm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEquipHand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PneVisualizacaoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LblEquipAmmo, LblEquipArms, LblEquipCharm, LblEquipFeet, LblEquipHand1, LblEquipHand2, LblEquipHead, LblEquipLegs, LblEquipRing, LblEquipShield, LblEquipTorso});

        PneVisualizacaoLayout.setVerticalGroup(
            PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PneVisualizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblEquipHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblEquipTorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEquipRing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PneVisualizacaoLayout.createSequentialGroup()
                        .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblEquipAmmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEquipArms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblEquipHand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEquipHand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblEquipCharm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEquipShield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(LblMostruario3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PneVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblEquipFeet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEquipLegs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PneVisualizacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LblEquipAmmo, LblEquipArms, LblEquipCharm, LblEquipFeet, LblEquipHand1, LblEquipHand2, LblEquipHead, LblEquipLegs, LblEquipRing, LblEquipShield, LblEquipTorso});

        LblTitulo.setBackground(java.awt.Color.lightGray);
        LblTitulo.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 24));
        LblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LblTitulo.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(PneVisualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TpnPaleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TpnPaleta, 0, 0, Short.MAX_VALUE)
                    .addComponent(PneVisualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ListaIcone();
        AbrirItens();
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
    private void CmbLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbLocalActionPerformed
        AtualizarImagem();
    }//GEN-LAST:event_CmbLocalActionPerformed
    private void CmbIDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbIDsActionPerformed
        AbrirRegistro(CmbIDs.getSelectedIndex());
    }//GEN-LAST:event_CmbIDsActionPerformed
    private void BtnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAvancarActionPerformed
        if(CmbIDs.getSelectedIndex()<CmbIDs.getItemCount()-1) CmbIDs.setSelectedIndex(CmbIDs.getSelectedIndex()+1);
        AbrirRegistro(CmbIDs.getSelectedIndex());
    }//GEN-LAST:event_BtnAvancarActionPerformed
    private void BtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVoltarActionPerformed
        if(CmbIDs.getSelectedIndex()>0) CmbIDs.setSelectedIndex(CmbIDs.getSelectedIndex()-1);
        AbrirRegistro(CmbIDs.getSelectedIndex());
    }//GEN-LAST:event_BtnVoltarActionPerformed
    private void BtnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLocalizarActionPerformed
        javax.swing.JDialog FrmItemLocalizar = new FrmItemLocalizar(this, rootPaneCheckingEnabled);
        FrmItemLocalizar.setLocation(
            ((this.getWidth() - FrmItemLocalizar.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmItemLocalizar.getHeight()) / 2) + this.getY());
        FrmItemLocalizar.pack();
        FrmItemLocalizar.setModal(true);
        FrmItemLocalizar.setVisible(true);/**/
    }//GEN-LAST:event_BtnLocalizarActionPerformed
    private void BtnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCarregarActionPerformed
        AbrirItens();
    }//GEN-LAST:event_BtnCarregarActionPerformed
    private void CmbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbGeneroActionPerformed

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
    private javax.swing.JButton BtnAvancar;
    private javax.swing.JButton BtnCarregar;
    private javax.swing.JButton BtnLocalizar;
    private javax.swing.JButton BtnVoltar;
    private javax.swing.JCheckBox ChkEquipavelAcessorio;
    private javax.swing.JCheckBox ChkEquipavelBraco1;
    private javax.swing.JCheckBox ChkEquipavelBraco2;
    private javax.swing.JCheckBox ChkEquipavelCabeça;
    private javax.swing.JCheckBox ChkEquipavelMaos;
    private javax.swing.JCheckBox ChkEquipavelMunicao;
    private javax.swing.JCheckBox ChkEquipavelPernas;
    private javax.swing.JCheckBox ChkEquipavelPes;
    private javax.swing.JCheckBox ChkEquipavelTorco1;
    private javax.swing.JCheckBox ChkEquipavelTorco2;
    private javax.swing.JComboBox CmbGenero;
    public static javax.swing.JComboBox CmbIDs;
    private javax.swing.JComboBox CmbIcone;
    private javax.swing.JComboBox CmbLocal;
    private javax.swing.JComboBox CmbUtilidade;
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
    private javax.swing.JPanel PneAudio;
    private javax.swing.JPanel PneComercio;
    private javax.swing.JPanel PneEquipamento;
    private javax.swing.JPanel PneInformacao;
    private javax.swing.JPanel PneVisualizacao;
    private javax.swing.JSpinner SpnOculpacaoDeLote;
    private javax.swing.JSpinner SpnPeso;
    private javax.swing.JSpinner SpnPoderAlcance;
    private javax.swing.JSpinner SpnPoderAtaque;
    private javax.swing.JSpinner SpnPoderBonusMagico;
    private javax.swing.JSpinner SpnPoderDefesa;
    private javax.swing.JSpinner SpnPrecoCompra;
    private javax.swing.JSpinner SpnPrecoVenda;
    private javax.swing.JTabbedPane TpnPaleta;
    private javax.swing.JTextField TxtNomeSumonico;
    private javax.swing.JTextField TxtNomeTitulo;
    private javax.swing.JTextField TxtScripAoConsulmir;
    private javax.swing.JTextField TxtScripAoEquipar;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
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
        String LocalSelecionado=CmbLocal.getItemAt(CmbLocal.getSelectedIndex()).toString();
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
    private void AbrirItens() {
        Thread tThread = new Thread(new Runnable() {
            public void run() {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                FrmPrincipal.PgbBarra.setIndeterminate(true);
                FrmPrincipal.PgbBarra.setString("Carregando...");
                FrmPrincipal.setAvisoEmEstatus("Favor espere carregar o Banco de Dados de Itens...");
                TpnPaleta.setVisible(false);
                PneVisualizacao.setVisible(false);
                LblTitulo.setVisible(false);
                CmbIDs.setEnabled(false);
                BtnVoltar.setEnabled(false);
                BtnAvancar.setEnabled(false);
                BtnLocalizar.setEnabled(false);
                BtnCarregar.setEnabled(false);

                String Conteudo="", Linha="", PartesDaLinha[]=null;
                try {
                    FileInputStream stream = new FileInputStream(EnderecoItensTXT);
                    InputStreamReader streamReader = new InputStreamReader(stream,"UTF-8");
                    BufferedReader reader = new BufferedReader(streamReader);
                    while ((Linha = reader.readLine()) != null) {
                        PartesDaLinha=Linha.split(",");
                        if(
                            PartesDaLinha.length>=19 &&
                            !PartesDaLinha[0].equals("0") &&
                            !Linha.substring(0, 1).trim().equals("#") &&
                            !Linha.substring(0, 2).trim().equals("//")
                        ){
                            if(!Conteudo.equals("")){
                                Conteudo=Conteudo+"\n"+Linha;
                            }else{
                                Conteudo=Linha;
                            }

                        }
                    }
                    reader.close();
                    streamReader.close();
                    stream.close();
                } catch (IOException ex) {
                    FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">ERRO:</font> Não foi possivel abrir \""+FrmScript.EnderecoDoScript+"\"!");
                    ConfigClass.Mensagem_Erro("Não foi possivel abrir \""+FrmScript.EnderecoDoScript+"\"!","AVISO");
                    return; // em caso de falha
                }


                FrmPrincipal.PgbBarra.setIndeterminate(false);

                String Linhas[]=Conteudo.trim().split("\n");
                FrmPrincipal.PgbBarra.setMinimum(0);
                FrmPrincipal.PgbBarra.setMaximum(Linhas.length);
                FrmPrincipal.PgbBarra.setString("");
                Itens = new ItemClass[Linhas.length];
                Object[] ComboIDs= new java.lang.Object[Linhas.length];
                int Tag1=-1, Tag2=-1; String Script="";
                int Loc=0;
                for(int l=0;l<Linhas.length;l++){
                    FrmPrincipal.PgbBarra.setValue(Linhas.length+l);
                    FrmPrincipal.PgbBarra.setString(FrmPrincipal.PgbBarra.getValue()+"/"+FrmPrincipal.PgbBarra.getMaximum());
                    Linha=Linhas[l];
                    PartesDaLinha=Linha.split(",");
                    ComboIDs[l] = new Object();
                    ComboIDs[l] = PartesDaLinha[0];
                    Itens[l] = new ItemClass();
                    Itens[l].setID(Integer.parseInt(PartesDaLinha[0].trim()));
                    Itens[l].setNomeSumonico(PartesDaLinha[1].trim());
                    Itens[l].setNomeTitulo(PartesDaLinha[2].trim());
                    Itens[l].setTipoObjeto(Integer.parseInt(PartesDaLinha[3].trim()));
                    Itens[l].setPrecoDeCompra(Integer.parseInt(PartesDaLinha[4].trim()));
                    Itens[l].setPrecoDeVenda(Integer.parseInt(PartesDaLinha[5].trim()));
                    Itens[l].setPeso(Integer.parseInt(PartesDaLinha[6].trim()));

                    if(!PartesDaLinha[7].toString().equals("")) Itens[l].setPoderAtaque(Integer.parseInt(PartesDaLinha[7].trim()));
                    if(!PartesDaLinha[8].toString().equals("")) Itens[l].setPoderDefesa(Integer.parseInt(PartesDaLinha[8].toString()));
                    if(!PartesDaLinha[9].toString().equals("")) Itens[l].setPoderAlcance(Integer.parseInt(PartesDaLinha[9].trim()));
                    if(!PartesDaLinha[10].toString().equals("")) Itens[l].setPoderBonusMagico(Integer.parseInt(PartesDaLinha[10].trim()));
                    if(!PartesDaLinha[11].toString().equals("")) Itens[l].setOcupacaoDeLote(Integer.parseInt(PartesDaLinha[11].trim()));
                    if(!PartesDaLinha[12].toString().equals("")) Itens[l].setGenero(Integer.parseInt(PartesDaLinha[12].trim()));
                    if(!PartesDaLinha[13].toString().equals("")) Itens[l].setLocalEquipavel(Integer.parseInt(PartesDaLinha[13].trim()));
                    if(!PartesDaLinha[14].toString().equals("")) Itens[l].setPoderRefinavel(Integer.parseInt(PartesDaLinha[14].trim()));
                    if(!PartesDaLinha[15].toString().equals("")) Itens[l].setPoderElemental(Integer.parseInt(PartesDaLinha[15].trim()));
                    if(!PartesDaLinha[16].toString().equals("")) Itens[l].setAparencia(Integer.parseInt(PartesDaLinha[16].trim()));

                    Tag1=Linha.indexOf("{",0); Tag2=Linha.indexOf("},{",Tag1+1);
                    if(Tag1 >= 0 && Tag2 >= 0 && Tag2 >= Tag1) Itens[l].setScriptAoConsulmir(Linha.substring(Tag1+1, Tag2).trim());
                    Tag1=Linha.indexOf("},{",0); Tag2=Linha.indexOf("}",Tag1+3); 
                    if(Tag1>=0 && Tag2>=0 && Tag2>=Tag1) Itens[l].setScriptAoEquipar(Linha.substring(Tag1+3, Tag2).trim());
                }
                FrmPrincipal.PgbBarra.setString("Caregado!");
                FrmPrincipal.setAvisoEmEstatus("Banco de Dados de Itens carregado com sucesso!");
                CmbIDs.setModel(new DefaultComboBoxModel(ComboIDs));
                TpnPaleta.setVisible(true);
                PneVisualizacao.setVisible(true);
                LblTitulo.setVisible(true);
                CmbIDs.setEnabled(true);
                //BtnVoltar.setEnabled(true);
                BtnAvancar.setEnabled(true);
                BtnLocalizar.setEnabled(true);
                BtnCarregar.setEnabled(true);
                
                AbrirRegistro(CmbIDs.getSelectedIndex());
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });
        tThread.start();
    }
    private void AbrirRegistro() {
        AbrirRegistro(CmbIDs.getSelectedIndex());
    }
    private void AbrirRegistro(int Registro) {
        TxtNomeSumonico.setText(Itens[Registro].getNomeSumonico());
        TxtNomeTitulo.setText(Itens[Registro].getNomeTitulo());
        LblTitulo.setText(TxtNomeTitulo.getText());
        if(Itens[Registro].getTipoObjeto()==0) CmbUtilidade.setSelectedIndex(0);
        if(Itens[Registro].getTipoObjeto()==2) CmbUtilidade.setSelectedIndex(1);
        if(Itens[Registro].getTipoObjeto()==3) CmbUtilidade.setSelectedIndex(2);
        if(Itens[Registro].getTipoObjeto()==4) CmbUtilidade.setSelectedIndex(3);
        if(Itens[Registro].getTipoObjeto()==5) CmbUtilidade.setSelectedIndex(4);
        if(Itens[Registro].getTipoObjeto()==6) CmbUtilidade.setSelectedIndex(5);
        if(Itens[Registro].getTipoObjeto()==7) CmbUtilidade.setSelectedIndex(6);
        if(Itens[Registro].getTipoObjeto()==8) CmbUtilidade.setSelectedIndex(7);
        if(Itens[Registro].getTipoObjeto()==10) CmbUtilidade.setSelectedIndex(8);
        if(Itens[Registro].getTipoObjeto()==11) CmbUtilidade.setSelectedIndex(9);
        SpnPeso.setValue(Itens[Registro].getPeso());
        SpnPrecoCompra.setValue(Itens[Registro].getPrecoDeCompra());
        SpnPrecoVenda.setValue(Itens[Registro].getPrecoDeVenda());
        SpnPoderAtaque.setValue(Itens[Registro].getPoderAtaque());
        SpnPoderDefesa.setValue(Itens[Registro].getPoderDefesa());
        SpnPoderAlcance.setValue(Itens[Registro].getPoderAlcance());
        SpnPoderBonusMagico.setValue(Itens[Registro].getPoderBonusMagico());
        SpnOculpacaoDeLote.setValue(Itens[Registro].getOcupacaoDeLote());
        CmbGenero.setSelectedIndex(Itens[Registro].getGenero());

        int Loc=Itens[Registro].getLocalEquipavel();
        boolean SeEquipamento = (CmbUtilidade.getSelectedIndex()>=3 && CmbUtilidade.getSelectedIndex()<=8);
        ChkEquipavelMunicao.setSelected(Loc/32768>=1); if(Loc/32768>=1)Loc-=32768; ChkEquipavelMunicao.setEnabled(SeEquipamento);
        ChkEquipavelTorco2.setSelected(Loc/512>=1);    if(Loc/512>=1)  Loc-=512;   ChkEquipavelTorco2.setEnabled(SeEquipamento);
        ChkEquipavelCabeça.setSelected(Loc/256>=1);    if(Loc/256>=1)  Loc-=256;   ChkEquipavelCabeça.setEnabled(SeEquipamento);
        ChkEquipavelAcessorio.setSelected(Loc/128>=1); if(Loc/128>=1)  Loc-=128;   ChkEquipavelAcessorio.setEnabled(SeEquipamento);
        ChkEquipavelPes.setSelected(Loc/64>=1);        if(Loc/64>=1)   Loc-=64;    ChkEquipavelPes.setEnabled(SeEquipamento);
        ChkEquipavelBraco2.setSelected(Loc/32>=1);     if(Loc/32>=1)   Loc-=32;    ChkEquipavelBraco2.setEnabled(SeEquipamento);
        ChkEquipavelTorco1.setSelected(Loc/16>=1);     if(Loc/16>=1)   Loc-=16;    ChkEquipavelTorco1.setEnabled(SeEquipamento);
        ChkEquipavelMaos.setSelected(Loc/4>=1);        if(Loc/4>=1)    Loc-=4;     ChkEquipavelMaos.setEnabled(SeEquipamento);
        ChkEquipavelBraco1.setSelected(Loc/2>=1);      if(Loc/2>=1)    Loc-=2;     ChkEquipavelBraco1.setEnabled(SeEquipamento);
        ChkEquipavelPernas.setSelected(Loc/1>=1);      if(Loc/1>=1)    Loc-=1;     ChkEquipavelPernas.setEnabled(SeEquipamento);

        TxtScripAoConsulmir.setText(Itens[Registro].getScriptAoConsulmir().trim());
        TxtScripAoEquipar.setText(Itens[Registro].getScriptAoEquipar().trim());

        BtnAvancar.setEnabled((CmbIDs.isEnabled() && CmbIDs.getSelectedIndex()<(CmbIDs.getItemCount()-1)));
        BtnVoltar.setEnabled((CmbIDs.isEnabled() && CmbIDs.getSelectedIndex()>0));
        BtnLocalizar.setEnabled((CmbIDs.isEnabled() && CmbIDs.getItemCount()>=2));
    }

}
