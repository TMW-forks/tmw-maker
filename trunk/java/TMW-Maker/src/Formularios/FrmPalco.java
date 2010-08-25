
package Formularios;


import Classes.BlocoDeScript;
import Classes.ConfigClass;
import Classes.BancoDeDados.Dados_NPC;
import Classes.ImagemTratavel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.DefaultComboBoxModel;

public class FrmPalco extends javax.swing.JDialog {
    public FrmPalco(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public static BlocoDeScript Instancia[];

    public String InstanciasArray2String(BlocoDeScript[] Instancias){
        String Codigo=
        "///////////////////////////////////////////////////////////////////\n"+
        "//  IDE: TMW-Maker v"+FrmPrincipal.Config.getVersao()+"\n"+
        "//  MODIFICADO: "+ConfigClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+
        "///////////////////////////////////////////////////////////////////\n"+
        "\n";
        for(int i=0;i<Instancias.length;i++){
            //008.gat,108,23,0	script	Roger	308,{
            if(Instancias[i].getTipo()=="script"){
                Codigo+=Instancias[i].getMapa()+".gat,"+Instancias[i].getX()+","+Instancias[i].getY()+",0\tscript\t"+Instancias[i].getNome()+"\t"+Instancias[i].getImagem()+",";
                if(Instancias[i].getLarguraDeGatilho()>=1 || Instancias[i].getAlturaDeGatilho()>=1){
                    Codigo+=Instancias[i].getLarguraDeGatilho()+","+Instancias[i].getAlturaDeGatilho()+",";
                }
                Codigo+="{\n"+
                    Instancias[i].getScript()+"\n"+
                "}";
            }else if(Instancias[i].getTipo()=="function"){
                Codigo+=
                "function\tscript\t"+Instancias[i].getNome()+"\t{\n"+
                    Instancias[i].getScript()+"\n"+
                "}";
            }
            if(i<(Instancias.length-1)){Codigo+="\n\n";}//<<<< Cria uma linha em branco antes de por o 2� Instancia
        }
        return Codigo;
    }
    public boolean salvarInstancia(String Endereco){
        try {
            int i = CmbScript.getSelectedIndex();
            Instancia[i].setScript(TxtScriptPalco.getText().toString());
            BufferedWriter Capsula = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Endereco),"UTF-8"));
            Capsula.write(InstanciasArray2String(Instancia));
            Capsula.flush();
            Capsula.close();  
            
            CmbScript.setEnabled(true);
            TxtScriptPalco.setEnabled(true);
            BarraDeCodigos(true);
            BtnSalvarBloco.setEnabled(false);
            BtnAbrirBloco.setEnabled(true);
            this.setTitle("Editor de Scripts ["+Endereco+"]");
            FrmPrincipal.LblEstatus.setText("Arquivo gravado com sucesso !");
            //Mensagem_Erro("Arquivo gravado com sucesso !","AVISO");
            return true;
        } catch (java.io.IOException exc) {
            FrmPrincipal.LblEstatus.setText("<font color=\"#FF0000\">ERRO:</font> Falha ao gravar arquivo!");
            Mensagem_Erro("N�o foi possivel gravar \""+FrmScript.EnderecoDoScript+"\"!","AVISO");
            return false;
        }

    }
    public void abrirInstancia(String Endereco){
        try {
            String Conteudo="", Linha="", Cabecalho="", Bloco="";
            FileInputStream stream = new FileInputStream(Endereco);
            InputStreamReader streamReader = new InputStreamReader(stream,"UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);
            while ((Linha = reader.readLine()) != null) {
                if(!Conteudo.equals("")){
                    Conteudo=Conteudo+"\n"+Linha;
                }else{
                    Conteudo=Linha;
                }
            }
            reader.close();
            streamReader.close();
            stream.close();

            if(!Conteudo.isEmpty() && !Conteudo.trim().equals("")){
                int blocos = 0, AbreBloco=0, PontaDeBloco=0, FechaBloco=0;
                do{
                    AbreBloco= Conteudo.indexOf("{",AbreBloco+1);
                    if(AbreBloco>=1) blocos++;
                }while(AbreBloco>=1);
                if(blocos>=1){
                    Instancia= new BlocoDeScript[blocos]; // Diz que s�o 2 Instancias
                    Object[] TituloDeBloco= new java.lang.Object[blocos];
                    StringBuffer Manipulador = null;
                    String[] ParteDeSessao= null;
                    String[] ParteDoMapa= null;
                    String[] ParteDaPosicao= null;
                    String[] ParteFacutativa= null;
                    int Sel=-1;

                    for(int i=0;i<blocos;i++){
                        AbreBloco=FechaBloco;
                        Manipulador = new StringBuffer(Conteudo);
                        Instancia[i] = new BlocoDeScript();// Cria o Instancia n�0

                        AbreBloco= Conteudo.indexOf("{",AbreBloco)+1;//S� adiciona +1 pq foi feito o teste de existencia de blocos;
                        Manipulador.reverse();
                        PontaDeBloco=0;
                        PontaDeBloco= Manipulador.indexOf("\n",Conteudo.length()-AbreBloco);
                        if(PontaDeBloco>=1){
                            Manipulador.reverse();
                            PontaDeBloco= Conteudo.length()-PontaDeBloco;//Recolaliza ponta de Bloco ao Inverter String
                        }else{
                            PontaDeBloco=0;//P�e a Ponta de Bloco no inicio do c�digo
                        }

                        Cabecalho=Conteudo.substring(PontaDeBloco,AbreBloco-1);
                        FechaBloco= Conteudo.indexOf("}",AbreBloco);//S� adiciona +1 pq foi feito o teste de existencia de blocos;
                        Bloco=Conteudo.substring(AbreBloco+1,FechaBloco-1);

                        ParteDeSessao = Cabecalho.split("\t");
                        if(ParteDeSessao.length>=2){
                            if(ParteDeSessao[0].equals("function") && ParteDeSessao[1].equals("script")){
                                Instancia[i].setTipo("function");
                                Instancia[i].setNome(ParteDeSessao[2].toString());
                                Instancia[i].setMapa("");
                                Instancia[i].setX(0);
                                Instancia[i].setY(0);
                                Instancia[i].setLarguraDeGatilho(0);
                                Instancia[i].setAlturaDeGatilho(0);
                                TituloDeBloco[i] = new Object();
                                TituloDeBloco[i] = "<html><font color=\"#888888\">"+(i+1) + "� function</font> " +Instancia[i].getNome()+"<font color=\"#888888\">( )</font>";
                            }else if(!ParteDeSessao[0].equals("function") && ParteDeSessao[1].equals("script")){
                                Instancia[i].setTipo("script");
                                Instancia[i].setNome(ParteDeSessao[2].toString());

                                ParteDaPosicao = ParteDeSessao[0].split(",");
                                ParteDoMapa = ParteDaPosicao[0].split("\\.");
                                //Mensagem_Erro("ParteDoMapa=\""+ParteDoMapa[0].toString()+"\"", "Nota de Programador");
                                Instancia[i].setMapa(ParteDoMapa[0].toString());
                                Instancia[i].setX(Integer.parseInt(ParteDaPosicao[1].toString()));
                                Instancia[i].setY(Integer.parseInt(ParteDaPosicao[2].toString()));

                                ParteFacutativa = ParteDeSessao[3].split(",");
                                Instancia[i].setImagem(Integer.parseInt(ParteFacutativa[0].toString()));
                                if(ParteFacutativa.length>=2) {
                                    if(!ParteFacutativa[1].equals("")) {
                                        Instancia[i].setLarguraDeGatilho(Integer.parseInt(ParteFacutativa[1].equals("")?"0":ParteFacutativa[1]));
                                    }
                                }
                                if(ParteFacutativa.length>=3) {
                                    if(!ParteFacutativa[2].equals("")) {
                                        //Instancia[i].setAlturaDeGatilho(Integer.parseInt(ParteFacutativa[2].toString()));
                                        Instancia[i].setLarguraDeGatilho(Integer.parseInt(ParteFacutativa[2].equals("")?"0":ParteFacutativa[2]));
                                    }
                                }
                                TituloDeBloco[i] = new Object();
                                TituloDeBloco[i] = "<html>" +
                                    "<font color=\"#888888\">"+(i+1) + "� script</font> " +
                                    Instancia[i].getNome()+
                                    " <font color=\"#888888\">"+
                                        "("+Instancia[i].getMapa()+":"+Instancia[i].getX()+","+Instancia[i].getY()+")"+
                                        " [img "+Instancia[i].getImagem()+":"+Instancia[i].getLarguraDeGatilho()+","+Instancia[i].getAlturaDeGatilho()+"]"+
                                    "</font>";
                            }
                            Instancia[i].setScript(Bloco);

                            if(i==blocos-1){
                                Sel=CmbScript.getSelectedIndex();
                                CmbScript.setModel(new DefaultComboBoxModel(TituloDeBloco));

                                if(Sel<0 || Sel>CmbScript.getItemCount()-1)  Sel=CmbScript.getItemCount()-1;

                                CmbScript.setSelectedIndex(Sel);
                                TxtScriptPalco.setText(Instancia[Sel].getScript());

                                /*Dados_NPC NPC = FrmPrincipal.NPCs.getNPCporID(Instancia[Sel].getImagem());
                                ImagemTratavel Imagem = new ImagemTratavel(NPC.getImagem());
                                Imagem.setZoom(24/Imagem.getAltura());
                                LblAparencia.setIcon(new javax.swing.ImageIcon(Imagem.getImage()));
                                LblAparencia.setToolTipText("<html><font size=\"+1\">"+
                                    "<b>Apar�ncia(ID:"+NPC.getID()+"):</b> " + NPC.getNome()+"<br/>"+
                                    "<b>Imagem:</b> " + NPC.getXML()+"?img="+NPC.getVariante()+" ("+NPC.getImagem().getWidth()+"x"+NPC.getImagem().getHeight()+"px)"+"<br/>"+
                                    "<b>Coment�rio:</b> " + NPC.getComentario()+"<br/>"
                                );/**/
                            }
                            
                        }else{
                            FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">ERRO:</font> Cabe�alho de Bloco com formato inv�lido!");
                            Mensagem_Erro(
                                "Cabe�alho de Bloco com formato inv�lido!\n"+
                                "<html><font color=\"#FF0000\">"+Cabecalho,
                                "ERRO"
                            );
                        }
                        TxtScriptPalco.setEnabled(true);
                        BarraDeCodigos(true);
                        CmbScript.setEnabled(true);
                        BtnSalvarBloco.setEnabled(false);
                    }
                    this.setTitle("Editor de Scripts ["+Endereco+"]");
                }else{
                    FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">ERRO:</font> O arquivo possui conte�do incompat�vel com o Eathena Script!");
                    Mensagem_Erro("O arquivo possui conte�do incompat�vel com o Eathena Script!", "ERRO");
                }
            }else{
                FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">AVISO:</font> O arquivo est� vazio!");
                Mensagem_Erro("O arquivo est� vazio!", "AVISO");
            }
        } catch (java.io.IOException exc) {
            FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">ERRO:</font> N�o foi possivel abrir \""+FrmScript.EnderecoDoScript+"\"!");
            Mensagem_Erro("N�o foi possivel abrir \""+FrmScript.EnderecoDoScript+"\"!","AVISO");
        }
    }
    public static void Mensagem_Erro(String Aviso, String Titulo) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,Aviso,Titulo,JOptionPane.WARNING_MESSAGE);
    }
    public void addScript(String Codigo){
        String Conteudo=FrmPalco.TxtScriptPalco.getText();
        String TxtInicio=Conteudo.substring(0,FrmPalco.TxtScriptPalco.getSelectionStart());
        String TxtFinal=Conteudo.substring(FrmPalco.TxtScriptPalco.getSelectionStart(),FrmPalco.TxtScriptPalco.getText().length());
        FrmPalco.TxtScriptPalco.setText(TxtInicio+Codigo+TxtFinal);
    }
    public void BarraDeCodigos(boolean SeAtivo){
        BtnScriptComandoMes.setEnabled(SeAtivo);
        BtnScriptComandoIF.setEnabled(SeAtivo);
    }

//#####################################################################################################
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TxtScriptPalco = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        BtnNovoBloco = new javax.swing.JButton();
        BtnSalvarBloco = new javax.swing.JButton();
        BtnAbrirBloco = new javax.swing.JButton();
        BtnExcluirBloco = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        CmbScript = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        BtnScriptComandoIF = new javax.swing.JButton();
        BtnScriptComandoMes = new javax.swing.JButton();
        LblAparencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Scripts");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        TxtScriptPalco.setColumns(20);
        TxtScriptPalco.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TxtScriptPalco.setRows(5);
        TxtScriptPalco.setEnabled(false);
        TxtScriptPalco.setSelectedTextColor(java.awt.Color.black);
        TxtScriptPalco.setSelectionColor(new java.awt.Color(145, 254, 124));
        TxtScriptPalco.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtScriptPalcoCaretUpdate(evt);
            }
        });
        TxtScriptPalco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtScriptPalcoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TxtScriptPalco);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        BtnNovoBloco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_script_bloco.gif"))); // NOI18N
        BtnNovoBloco.setText("Novo");
        BtnNovoBloco.setToolTipText("Cria novo script (Ctrl+N)");
        BtnNovoBloco.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnNovoBloco.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BtnNovoBloco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNovoBlocoActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnNovoBloco);

        BtnSalvarBloco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"))); // NOI18N
        BtnSalvarBloco.setText("Salvar");
        BtnSalvarBloco.setToolTipText("Salvar script (Ctrl+S)");
        BtnSalvarBloco.setEnabled(false);
        BtnSalvarBloco.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnSalvarBloco.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BtnSalvarBloco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarBlocoActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnSalvarBloco);

        BtnAbrirBloco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        BtnAbrirBloco.setText("Abrir");
        BtnAbrirBloco.setToolTipText("Abrir script salvo (Ctrl+O)");
        BtnAbrirBloco.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnAbrirBloco.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BtnAbrirBloco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbrirBlocoActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAbrirBloco);

        BtnExcluirBloco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lixeira.png"))); // NOI18N
        BtnExcluirBloco.setMnemonic('E');
        BtnExcluirBloco.setText("Excluir");
        BtnExcluirBloco.setEnabled(false);
        BtnExcluirBloco.setFocusable(false);
        BtnExcluirBloco.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnExcluirBloco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BtnExcluirBloco);
        jToolBar1.add(jSeparator1);

        CmbScript.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<sem blocos>" }));
        CmbScript.setEnabled(false);
        CmbScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbScriptActionPerformed(evt);
            }
        });
        jToolBar1.add(CmbScript);

        jPanel1.setLayout(new java.awt.BorderLayout());

        BtnScriptComandoIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/losangulo.gif"))); // NOI18N
        BtnScriptComandoIF.setText("IF");
        BtnScriptComandoIF.setToolTipText("<html><b>IF:</b> Teste de Condi��o");
        BtnScriptComandoIF.setEnabled(false);
        BtnScriptComandoIF.setFocusable(false);
        BtnScriptComandoIF.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnScriptComandoIF.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnScriptComandoIF.setPreferredSize(new java.awt.Dimension(60, 28));
        BtnScriptComandoIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScriptComandoIFActionPerformed(evt);
            }
        });
        jPanel1.add(BtnScriptComandoIF, java.awt.BorderLayout.PAGE_END);

        BtnScriptComandoMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_comentario.gif"))); // NOI18N
        BtnScriptComandoMes.setText("MES");
        BtnScriptComandoMes.setToolTipText("<html><b>MES:</b> Fala de pesonagem");
        BtnScriptComandoMes.setEnabled(false);
        BtnScriptComandoMes.setFocusable(false);
        BtnScriptComandoMes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnScriptComandoMes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnScriptComandoMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScriptComandoMesActionPerformed(evt);
            }
        });
        jPanel1.add(BtnScriptComandoMes, java.awt.BorderLayout.CENTER);

        LblAparencia.setBackground(java.awt.Color.lightGray);
        LblAparencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png"))); // NOI18N
        LblAparencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LblAparencia.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblAparencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LblAparencia, jPanel1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LblAparencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//#####################################################################################################
    private void CmbScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbScriptActionPerformed
        //abrirInstancia(FrmScript.EnderecoDoScript);
        //this.setTitle(Integer.toString(i));
        String Cod= Instancia[CmbScript.getSelectedIndex()].getScript().toString();
        TxtScriptPalco.setText(Cod.toString());/**/

        Dados_NPC NPC = FrmPrincipal.NPCs.getNPCporID(Instancia[CmbScript.getSelectedIndex()].getImagem());
        ImagemTratavel Imagem = new ImagemTratavel(NPC.getImagem());
        double Escala = 96.0/(double)Imagem.getLargura();
        //double Escala = 1.0;
        Imagem.setZoom(Escala);
        LblAparencia.setIcon(new javax.swing.ImageIcon(Imagem.getImage()));
        LblAparencia.setToolTipText("<html><font size=\"+1\">"+
            "<b>Apar�ncia(ID:"+NPC.getID()+"):</b> " + NPC.getNome()+"<br/>"+
            "<b>Imagem:</b> " + NPC.getXML()+"?img="+NPC.getVariante()+" ("+NPC.getImagem().getWidth()+"x"+NPC.getImagem().getHeight()+"px)"+"<br/>"+
            "<b>Coment�rio:</b> " + NPC.getComentario()+"<br/>"
        );
    }//GEN-LAST:event_CmbScriptActionPerformed
    private void TxtScriptPalcoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtScriptPalcoKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F1 && evt.isControlDown()){
            //ExemploDeConteudo();
        }else if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_T && evt.isControlDown()){
            //ExemploDeConteudo();
        }else if(BtnSalvarBloco.isEnabled() && evt.getKeyCode()==java.awt.event.KeyEvent.VK_S && evt.isControlDown()){
            salvarInstancia(FrmScript.EnderecoDoScript);
        }else if(BtnAbrirBloco.isEnabled() && evt.getKeyCode()==java.awt.event.KeyEvent.VK_O && evt.isControlDown()){
            abrirInstancia(FrmScript.EnderecoDoScript);
        }else if(!evt.isControlDown() && !evt.isAltDown() && !evt.isShiftDown() &&

                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_CAPS_LOCK &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_ESCAPE &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_LEFT &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_RIGHT &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_UP &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_DOWN &&

                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_PAGE_UP &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_PAGE_DOWN &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_INSERT &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_HOME &&
                    evt.getKeyCode()!=java.awt.event.KeyEvent.VK_END &&
                    
                    1==1
                ){
            CmbScript.setEnabled(false);
            BtnSalvarBloco.setEnabled(true);
        }/**/
    }//GEN-LAST:event_TxtScriptPalcoKeyPressed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //ExemploDeConteudo();
        abrirInstancia(FrmScript.EnderecoDoScript);
    }//GEN-LAST:event_formWindowOpened
    private void BtnAbrirBlocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirBlocoActionPerformed
        abrirInstancia(FrmScript.EnderecoDoScript);
    }//GEN-LAST:event_BtnAbrirBlocoActionPerformed
    private void BtnSalvarBlocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarBlocoActionPerformed
        salvarInstancia(FrmScript.EnderecoDoScript);
    }//GEN-LAST:event_BtnSalvarBlocoActionPerformed
    private void BtnNovoBlocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoBlocoActionPerformed
        if(BtnNovoBloco.isEnabled()){
            javax.swing.JDialog FrmNovoBloco = new FrmNovoBloco(this,false);
            FrmNovoBloco.setLocation(
                ((this.getWidth() - FrmNovoBloco.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmNovoBloco.getHeight()) / 2) + this.getY());
            FrmNovoBloco.pack();
            FrmNovoBloco.setModal(true);
            FrmNovoBloco.setVisible(true);/**/
        }
    }//GEN-LAST:event_BtnNovoBlocoActionPerformed
    private void BtnScriptComandoMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnScriptComandoMesActionPerformed
        if(TxtScriptPalco.isEnabled() && TxtScriptPalco.isFocusable()){
            javax.swing.JDialog FrmMes = new FrmMes(this,false);
            FrmMes.setLocation(
                ((this.getWidth() - FrmMes.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmMes.getHeight()) / 2) + this.getY());
            FrmMes.pack();
            FrmMes.setModal(true);
            FrmMes.setVisible(true);/**/
        }
    }//GEN-LAST:event_BtnScriptComandoMesActionPerformed
    private void TxtScriptPalcoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtScriptPalcoCaretUpdate
        int linha = 0, coluna = 0;
        if(FrmPalco.TxtScriptPalco.getCaretPosition()>=0){
            try {
                linha = FrmPalco.TxtScriptPalco.getLineOfOffset(FrmPalco.TxtScriptPalco.getCaretPosition());
                coluna = (FrmPalco.TxtScriptPalco.getCaretPosition()-FrmPalco.TxtScriptPalco.getLineStartOffset(linha));
            } catch (BadLocationException ex) {
                Logger.getLogger(FrmPalco.class.getName()).log(Level.SEVERE, null, ex);
            }
            FrmPrincipal.LblEstatus.setText("Linha:"+Integer.toString(linha+1)+" Coluna:"+Integer.toString(coluna));
        }else{
            FrmPrincipal.LblEstatus.setText("");
        }
    }//GEN-LAST:event_TxtScriptPalcoCaretUpdate

    private void BtnScriptComandoIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnScriptComandoIFActionPerformed
        if(TxtScriptPalco.isEnabled() && TxtScriptPalco.isFocusable()){
            javax.swing.JDialog FrmIF = new FrmIF(this,false);
            FrmIF.setLocation(
                ((this.getWidth() - FrmIF.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmIF.getHeight()) / 2) + this.getY());
            FrmIF.pack();
            FrmIF.setModal(true);
            FrmIF.setVisible(true);/**/
        }
    }//GEN-LAST:event_BtnScriptComandoIFActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
        /*this.setBounds(
                (Tela.width - this.getWidth()) / 2,
                (Tela.height - this.getHeight()) / 2,
                this.getWidth(),
                this.getHeight());/**/
        this.setBounds(0,70,Tela.width,Tela.height-120);/**/
        //this.setExtendedState(MAXIMIZED_BOTH); //Maximiza a tela
    }//GEN-LAST:event_formComponentShown
//#####################################################################################################

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPalco dialog = new FrmPalco(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton BtnAbrirBloco;
    public static javax.swing.JButton BtnExcluirBloco;
    public static javax.swing.JButton BtnNovoBloco;
    public static javax.swing.JButton BtnSalvarBloco;
    public static javax.swing.JButton BtnScriptComandoIF;
    public static javax.swing.JButton BtnScriptComandoMes;
    public static javax.swing.JComboBox CmbScript;
    private javax.swing.JLabel LblAparencia;
    public static javax.swing.JTextArea TxtScriptPalco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
