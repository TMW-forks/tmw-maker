
package Formularios;

import Classes.BlocoDeScript;
import Classes.ConfigClass;
import Classes.BancoDeDados.Dados_NPC;
import Classes.ImagemTratavel;
import java.lang.Object;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.BadLocationException;

public class FrmNovoBloco extends javax.swing.JDialog {
    public FrmNovoBloco(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TbpTipoDeBloco = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        LblImagem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SpnNovoBlocoScriptGatilhoLargura = new javax.swing.JSpinner();
        TxtNovoBlocoScriptMapa = new javax.swing.JTextField();
        SpnNovoBlocoScriptGatilhoAltura = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtNovoBlocoScriptNome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtNovoBlocoScriptUtilidade = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        SpnNovoBlocoScriptCoordY = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SpnNovoBlocoScriptCoordX = new javax.swing.JSpinner();
        CmbNovoBlocoScriptImagem = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TxtNovoBlocoFuncaoNome = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtNovoBlocoFunctionUtilidade = new javax.swing.JTextArea();
        BtnFechar = new javax.swing.JButton();
        BtnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Bloco de Script");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        LblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png"))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cabeçalho"));

        jLabel8.setText("Altu. Gatilho:");

        jLabel2.setText("Mapa:");

        SpnNovoBlocoScriptGatilhoLargura.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(-1), null, Integer.valueOf(1)));

        TxtNovoBlocoScriptMapa.setText("001");

        SpnNovoBlocoScriptGatilhoAltura.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(-1), null, Integer.valueOf(1)));

        jLabel1.setText("Nome:");

        jLabel9.setText(".gat");

        TxtNovoBlocoScriptNome.setText("Fulano");

        TxtNovoBlocoScriptUtilidade.setColumns(20);
        TxtNovoBlocoScriptUtilidade.setRows(3);
        TxtNovoBlocoScriptUtilidade.setText("Pegará XXX itens e YYYY de GP (dinheiro).\nDará um item Z.");
        jScrollPane2.setViewportView(TxtNovoBlocoScriptUtilidade);

        jLabel5.setText("Coord. Y:");

        SpnNovoBlocoScriptCoordY.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel13.setText("Descrição da Utilidade:");

        jLabel4.setText("Coord. X:");

        SpnNovoBlocoScriptCoordX.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(0), null, Integer.valueOf(1)));

        CmbNovoBlocoScriptImagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não (Script Intangível)", "048 (npc.xml?img=61)", "049 (npc.xml?img=49)", "100 (npc.xml?img=0)", "101 (npc.xml?img=1)", "102 (npc.xml?img=2)", "103 (npc.xml?img=3)", " " }));
        CmbNovoBlocoScriptImagem.setSelectedIndex(1);
        CmbNovoBlocoScriptImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbNovoBlocoScriptImagemActionPerformed(evt);
            }
        });

        jLabel7.setText("Larg. Gatilho:");

        jLabel6.setText("Imagem:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SpnNovoBlocoScriptGatilhoLargura, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(SpnNovoBlocoScriptCoordX, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(TxtNovoBlocoScriptMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8))
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SpnNovoBlocoScriptGatilhoAltura, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                            .addComponent(SpnNovoBlocoScriptCoordY, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))))
                            .addComponent(CmbNovoBlocoScriptImagem, javax.swing.GroupLayout.Alignment.LEADING, 0, 260, Short.MAX_VALUE)
                            .addComponent(TxtNovoBlocoScriptNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {SpnNovoBlocoScriptCoordX, SpnNovoBlocoScriptCoordY, SpnNovoBlocoScriptGatilhoAltura, SpnNovoBlocoScriptGatilhoLargura, TxtNovoBlocoScriptMapa});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNovoBlocoScriptNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNovoBlocoScriptMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SpnNovoBlocoScriptCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpnNovoBlocoScriptCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpnNovoBlocoScriptGatilhoLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(SpnNovoBlocoScriptGatilhoAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbNovoBlocoScriptImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {SpnNovoBlocoScriptCoordX, SpnNovoBlocoScriptCoordY, SpnNovoBlocoScriptGatilhoAltura, SpnNovoBlocoScriptGatilhoLargura, TxtNovoBlocoScriptMapa, jLabel2, jLabel4, jLabel5, jLabel7, jLabel8, jLabel9});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbNovoBlocoScriptImagem, jLabel6});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TxtNovoBlocoScriptNome, jLabel1});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblImagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblImagem))
                .addContainerGap())
        );

        TbpTipoDeBloco.addTab("Script", jPanel1);

        jLabel11.setText("Chamada:");

        TxtNovoBlocoFuncaoNome.setText("ExemploDeFuncao");

        jLabel12.setText("Descrição da Utilidade:");

        TxtNovoBlocoFunctionUtilidade.setColumns(20);
        TxtNovoBlocoFunctionUtilidade.setRows(5);
        TxtNovoBlocoFunctionUtilidade.setText("Coletar dados de parâmetros 1, 2 ... X,\ne retornar resultado na veriável Y.");
        jScrollPane1.setViewportView(TxtNovoBlocoFunctionUtilidade);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNovoBlocoFuncaoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TxtNovoBlocoFuncaoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        TbpTipoDeBloco.addTab("Função", jPanel2);

        BtnFechar.setMnemonic('F');
        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        BtnAdicionar.setMnemonic('A');
        BtnAdicionar.setText("Adicionar");
        BtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar))
                    .addComponent(TbpTipoDeBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnAdicionar, BtnFechar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TbpTipoDeBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(BtnAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnAdicionar, BtnFechar});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed
    private void BtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAdicionarActionPerformed
        if(TbpTipoDeBloco.getSelectedIndex()==0){
            String ImagemTXT = CmbNovoBlocoScriptImagem.getItemAt(CmbNovoBlocoScriptImagem.getSelectedIndex()).toString();
            String Partes[] = ImagemTXT.split(":");
            int ImagemInt=-1;
            if(Partes.length>=2) ImagemInt = Integer.parseInt(Partes[0]);
            

            int newSize=0;
            try{
                newSize = FrmPalco.Instancia.length + 1;
            } catch (Exception Er){
                newSize=1;
            }

            BlocoDeScript[] NovoInstancia = new BlocoDeScript[newSize];
            int i=0;
            Object[] Titulo= new java.lang.Object[newSize];
            if(newSize >= 2){
                for (i = 0; i<(newSize-1); i++) {
                    NovoInstancia[i] = FrmPalco.Instancia[i];
                    Titulo[i] = new Object();
                    Titulo[i] = (i+1) + "º " + FrmPalco.Instancia[i].getNome() + " (" + FrmPalco.Instancia[i].getMapa() + ":" + FrmPalco.Instancia[i].getX() + "," + FrmPalco.Instancia[i].getY() + ")";
                     Titulo[i] = "<html><font color=\"#888888\">"+(i+1) + "º </font>" +
                        ""+FrmPalco.Instancia[i].getNome()+
                        " <font color=\"#888888\">"+
                            "("+FrmPalco.Instancia[i].getMapa()+":"+FrmPalco.Instancia[i].getX()+","+FrmPalco.Instancia[i].getY()+")"+
                            " [img "+FrmPalco.Instancia[i].getImagem()+":"+FrmPalco.Instancia[i].getLarguraDeGatilho()+","+FrmPalco.Instancia[i].getAlturaDeGatilho()+"]"+
                        "</font>";
                }
            }
            Titulo[i] = new Object();
            Titulo[i] = "<html><font color=\"#888888\">"+(i+1)+"º script </font> "+
                TxtNovoBlocoScriptNome.getText().toString()+" "+
                "<font color=\"#888888\">"+
                    " ("+TxtNovoBlocoScriptMapa.getText().toString()+":"+SpnNovoBlocoScriptCoordX.getValue().toString()+","+SpnNovoBlocoScriptCoordY.getValue().toString()+")"+
                    " [img "+ ImagemInt +":"+ SpnNovoBlocoScriptGatilhoLargura.getValue() +","+ SpnNovoBlocoScriptGatilhoAltura.getValue() +"]"+
                "</font>";

            
            NovoInstancia[i] = new BlocoDeScript();
            NovoInstancia[i].setTipo("script");
            NovoInstancia[i].setNome(TxtNovoBlocoScriptNome.getText().toString());
            NovoInstancia[i].setMapa(TxtNovoBlocoScriptMapa.getText().toString());
            NovoInstancia[i].setX(Integer.parseInt(SpnNovoBlocoScriptCoordX.getValue().toString()));
            NovoInstancia[i].setY(Integer.parseInt(SpnNovoBlocoScriptCoordY.getValue().toString()));
            NovoInstancia[i].setImagem(ImagemInt);
            NovoInstancia[i].setLarguraDeGatilho(Integer.parseInt(SpnNovoBlocoScriptGatilhoLargura.getValue().toString()));
            NovoInstancia[i].setAlturaDeGatilho(Integer.parseInt(SpnNovoBlocoScriptGatilhoAltura.getValue().toString()));
    
            FrmPalco.Instancia = NovoInstancia;
            

            //FrmPalco.CmbScript.setModel(model);
            FrmPalco.CmbScript.setModel(new DefaultComboBoxModel(Titulo));

            String Utilidade="";
            TxtNovoBlocoScriptUtilidade.setText(TxtNovoBlocoScriptUtilidade.getText().trim());
            if(!TxtNovoBlocoScriptUtilidade.getText().trim().equals("")){
                for(int l=0;l<TxtNovoBlocoScriptUtilidade.getLineCount();l++){
                    try {
                        Utilidade += "//    * "+
                        TxtNovoBlocoScriptUtilidade.getText().substring(
                            TxtNovoBlocoScriptUtilidade.getLineStartOffset(l),
                            TxtNovoBlocoScriptUtilidade.getLineEndOffset(l)-(l<(TxtNovoBlocoScriptUtilidade.getLineCount()-1)?1:0)
                        ) +
                        "\n";
                    } catch (BadLocationException ex) {
                        Logger.getLogger(FrmNovoBloco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            NovoInstancia[i].setScript(
                "///////////////////////////////////////////////////////////////////\n"+
                "//  PROGRAMADOR: "+(FrmPrincipal.Config.getExecucaoParametroPersonagem().isEmpty()?"<Desconhecido>":FrmPrincipal.Config.getExecucaoParametroPersonagem())+"\n"+
                "//  ACRIAÇÃO: "+ConfigClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+
                (Utilidade.equals("")?"":"//  UTILIDADE DO SCRIPT:\n"+Utilidade)+
                "///////////////////////////////////////////////////////////////////\n"+
                "_inicio:\n"+
                "\n"+
                "     //Insira seu Eathena Script aqui...\n"+
                "\n"+
                "close;"
            );
            FrmPalco.TxtScriptPalco.setText(NovoInstancia[i].getScript());
        }else if(TbpTipoDeBloco.getSelectedIndex()==1){
            int newSize=0;
            try{
                newSize = FrmPalco.Instancia.length + 1;
            } catch (Exception Er){
                newSize=1;
            }

            BlocoDeScript[] NovoInstancia = new BlocoDeScript[newSize];
            int i=0;
            Object[] Titulo= new java.lang.Object[newSize];
            if(newSize >= 2){
                for (i = 0; i<(newSize-1); i++) {
                    NovoInstancia[i] = FrmPalco.Instancia[i];
                    Titulo[i] = new Object();
                    Titulo[i] = (i+1) + "º " + FrmPalco.Instancia[i].getNome() + " (" + FrmPalco.Instancia[i].getMapa() + ":" + FrmPalco.Instancia[i].getX() + "," + FrmPalco.Instancia[i].getY() + ")";
                     Titulo[i] = "<html><font color=\"#888888\">"+(i+1) + "º </font>" +
                        ""+FrmPalco.Instancia[i].getNome()+
                        " <font color=\"#888888\">"+
                            "("+FrmPalco.Instancia[i].getMapa()+":"+FrmPalco.Instancia[i].getX()+","+FrmPalco.Instancia[i].getY()+")"+
                            " [img "+FrmPalco.Instancia[i].getImagem()+":"+FrmPalco.Instancia[i].getLarguraDeGatilho()+","+FrmPalco.Instancia[i].getAlturaDeGatilho()+"]"+
                        "</font>";
                }
            }
            Titulo[i] = new Object();
            Titulo[i] = "<html><font color=\"#888888\">"+(i+1)+"º function</font> "+
                TxtNovoBlocoFuncaoNome.getText().toString()+"<font color=\"#888888\">( )</font>";


            NovoInstancia[i] = new BlocoDeScript();
            NovoInstancia[i].setTipo("function");
            NovoInstancia[i].setNome(TxtNovoBlocoFuncaoNome.getText().toString());
            NovoInstancia[i].setMapa("");
            NovoInstancia[i].setX(0);
            NovoInstancia[i].setY(0);
            NovoInstancia[i].setImagem(0);
            NovoInstancia[i].setLarguraDeGatilho(0);
            NovoInstancia[i].setAlturaDeGatilho(0);

            FrmPalco.Instancia = NovoInstancia;


            //FrmPalco.CmbScript.setModel(model);
            FrmPalco.CmbScript.setModel(new DefaultComboBoxModel(Titulo));

            String Utilidade="";
            TxtNovoBlocoFunctionUtilidade.setText(TxtNovoBlocoFunctionUtilidade.getText().trim());
            if(!TxtNovoBlocoFunctionUtilidade.getText().trim().equals("")){
                for(int l=0;l<TxtNovoBlocoFunctionUtilidade.getLineCount();l++){
                    try {
                        Utilidade += "//    * "+
                        TxtNovoBlocoFunctionUtilidade.getText().substring(
                            TxtNovoBlocoFunctionUtilidade.getLineStartOffset(l),
                            TxtNovoBlocoFunctionUtilidade.getLineEndOffset(l)-(l<(TxtNovoBlocoFunctionUtilidade.getLineCount()-1)?1:0)
                        ) +
                        "\n";
                    } catch (BadLocationException ex) {
                        Logger.getLogger(FrmNovoBloco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            NovoInstancia[i].setScript(
                "///////////////////////////////////////////////////////////////////\n"+
                "//  PROGRAMADOR: "+(FrmPrincipal.Config.getExecucaoParametroPersonagem().isEmpty()?"<Desconhecido>":FrmPrincipal.Config.getExecucaoParametroPersonagem())+"\n"+
                "//  ACRIAÇÃO: "+ConfigClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+
                (Utilidade.equals("")?"":"//  UTILIDADE DO SCRIPT:\n"+Utilidade)+
                "///////////////////////////////////////////////////////////////////\n"+
                "_inicio:\n"+
                "\n"+
                "     //Insira seu Eathena Script aqui...\n"+
                "\n"+
                "_fim:"
            );
            FrmPalco.TxtScriptPalco.setText(NovoInstancia[i].getScript());
        }
        FrmPalco.CmbScript.setSelectedIndex(FrmPalco.CmbScript.getItemCount()-1);
        FrmPalco.CmbScript.setEnabled(false);
        //FrmPalco.CmbScript.setVisible(true);
        FrmPalco.TxtScriptPalco.setEnabled(true);
        FrmPalco.BtnScriptComandoMes.setEnabled(true);
        FrmPalco.BtnScriptComandoIF.setEnabled(true);

        FrmPalco.BtnNovoBloco.setEnabled(true);
        FrmPalco.BtnAbrirBloco.setEnabled(true);
        FrmPalco.BtnSalvarBloco.setEnabled(true);
        //FrmPalco.BtnExcluirBloco.setEnabled(true);
        dispose();
    }//GEN-LAST:event_BtnAdicionarActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Dados_NPC NPC = null;
        Vector Lista = new Vector();
        Lista.add("Não (Script Intangível)");
        for(int n=0;n<FrmPrincipal.NPCs.getContNPCs();n++){
            NPC = FrmPrincipal.NPCs.getNPCporOrdem(n);
            if(NPC!=null){
                if(NPC.getSprite()!=null){
                    if(NPC.getID()>0) Lista.add(NPC.getID()+": "+(NPC.getNome().equals("")?"\""+NPC.getComentario().trim()+"\"":NPC.getNome()));
                }
            }
        }
        CmbNovoBlocoScriptImagem.setModel(new javax.swing.DefaultComboBoxModel(Lista));
    }//GEN-LAST:event_formWindowOpened
    private void CmbNovoBlocoScriptImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbNovoBlocoScriptImagemActionPerformed
        if(CmbNovoBlocoScriptImagem.getSelectedIndex()>=1){
            String Selecionado=CmbNovoBlocoScriptImagem.getItemAt(CmbNovoBlocoScriptImagem.getSelectedIndex()).toString();
            String Partes[] = Selecionado.split(":");
            if(Partes.length>=2){
                Dados_NPC NPC = FrmPrincipal.NPCs.getNPCporID(Integer.parseInt(Partes[0]));
                ImagemTratavel Imagem = new ImagemTratavel(NPC.getImagem());
                Imagem.setZoom(2.0);
                LblImagem.setIcon(new javax.swing.ImageIcon(Imagem.getImage()));
                LblImagem.setToolTipText("<html><font size=\"+1\">"+
                    "<b>Nome(ID:"+NPC.getID()+"):</b> " + NPC.getNome()+"<br/>"+
                    "<b>Imagem:</b> " + NPC.getXML()+"?img="+NPC.getVariante()+" ("+NPC.getImagem().getWidth()+"x"+NPC.getImagem().getHeight()+"px)"+"<br/>"+
                    "<b>Comentário:</b> " + NPC.getComentario()+"<br/>"
                );
            }else{
                LblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png")));
                LblImagem.setToolTipText(null);
            }
        }else{
            LblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png")));
            LblImagem.setToolTipText(null);
        }
    }//GEN-LAST:event_CmbNovoBlocoScriptImagemActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmNovoBloco dialog = new FrmNovoBloco(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton BtnAdicionar;
    private javax.swing.JButton BtnFechar;
    private javax.swing.JComboBox CmbNovoBlocoScriptImagem;
    private javax.swing.JLabel LblImagem;
    private javax.swing.JSpinner SpnNovoBlocoScriptCoordX;
    private javax.swing.JSpinner SpnNovoBlocoScriptCoordY;
    private javax.swing.JSpinner SpnNovoBlocoScriptGatilhoAltura;
    private javax.swing.JSpinner SpnNovoBlocoScriptGatilhoLargura;
    private javax.swing.JTabbedPane TbpTipoDeBloco;
    private javax.swing.JTextField TxtNovoBlocoFuncaoNome;
    private javax.swing.JTextArea TxtNovoBlocoFunctionUtilidade;
    private javax.swing.JTextField TxtNovoBlocoScriptMapa;
    private javax.swing.JTextField TxtNovoBlocoScriptNome;
    private javax.swing.JTextArea TxtNovoBlocoScriptUtilidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    // End of variables declaration//GEN-END:variables

}
