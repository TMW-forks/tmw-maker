/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmScript.java
 *
 * Created on Apr 12, 2010, 8:22:51 PM
 */

package Formularios;


import Classes.BlocoDeScript;
import java.awt.Toolkit;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.DefaultComboBoxModel;

public class FrmScript extends javax.swing.JDialog {

    public FrmScript(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
//#####################################################################################################
    public static BlocoDeScript Instancia[];
    public static String EnderecoDoScript=System.getProperty("user.home")+System.getProperty("file.separator")+"ScriptExemplo.conf";
//#####################################################################################################
    public String InstanciasArray2String(BlocoDeScript[] Instancias){
        String Codigo="";
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
            }else if(Instancias[i].getTipo()=="function\tscript"){
                Codigo+=
                "function\tscript\t"+Instancias[i].getNome()+"\t{\n"+
                    Instancias[i].getScript()+"\n"+
                "}";
            }
            if(i<(Instancias.length-1)){Codigo+="\n\n";}//<<<< Cria uma linha em branco antes de por o 2º Instancia
        }
        return Codigo;
    }
    public boolean salvarInstancia(String Endereco){
        try {
            int i = CmbScript.getSelectedIndex();
            Instancia[i].setScript(TxtScriptPalco.getText().toString());
            FileWriter out = new FileWriter(Endereco);
            out.write(InstanciasArray2String(Instancia));
            out.close();
            
            CmbScript.setEnabled(true);
            TxtScriptPalco.setEnabled(true);
            BarraDeCodigos(true);
            BtnSalvarScript.setEnabled(false);
            BtnAbrirScript.setEnabled(true);
            this.setTitle("Editor de Scripts ["+Endereco+"]");
            FrmPrincipal.LblEstatus.setText("Arquivo gravado com sucesso !");
            //Mensagem_Erro("Arquivo gravado com sucesso !","AVISO");
            return true;
        } catch (java.io.IOException exc) {
            FrmPrincipal.LblEstatus.setText("<font color=\"#FF0000\">ERRO:</font> Falha ao gravar arquivo!");
            Mensagem_Erro("Não foi possivel gravar \""+EnderecoDoScript+"\"!","AVISO");
            return false;
        }

    }
    public void abrirInstancia(String Endereco){
        try {
            String Conteudo="", Cabecalho="", Bloco="";
            FileReader CapsulaDeLer = new FileReader(Endereco);
            int Caracater = CapsulaDeLer.read();
            while (Caracater!=-1) {
                Conteudo = Conteudo + (char) Caracater;
                Caracater = CapsulaDeLer.read();
            }
            CapsulaDeLer.close();
            
            int blocos = 0, AbreBloco=0, PontaDeBloco=0, FechaBloco=0;
            do{
                AbreBloco= Conteudo.indexOf("{",AbreBloco+1);
                if(AbreBloco>=1) blocos++;
            }while(AbreBloco>=1);
            if(blocos>=1){
                Instancia= new BlocoDeScript[blocos]; // Diz que são 2 Instancias
                Object[] TituloDeBloco= new java.lang.Object[blocos];
                StringBuffer Manipulador = null;
                String[] ParteDeSessao= null;
                String[] ParteDoMapa= null;
                String[] ParteDaPosicao= null;
                String[] ParteFacutativa= null;
                javax.swing.ImageIcon Icone = null;
                
                for(int i=0;i<blocos;i++){
                    AbreBloco=FechaBloco;
                    Manipulador = new StringBuffer(Conteudo);
                    Instancia[i] = new BlocoDeScript();// Cria o Instancia nº0
                    //System.out.println(sb);

                    AbreBloco= Conteudo.indexOf("{",AbreBloco)+1;//Só adiciona +1 pq foi feito o teste de existencia de blocos;
                    Manipulador.reverse();
                    PontaDeBloco=0;
                    PontaDeBloco= Manipulador.indexOf("\n",Conteudo.length()-AbreBloco);
                    if(PontaDeBloco>=1){
                        Manipulador.reverse();
                        PontaDeBloco= Conteudo.length()-PontaDeBloco;//Recolaliza ponta de Bloco ao Inverter String
                    }else{
                        PontaDeBloco=0;//Põe a Ponta de Bloco no inicio do código
                    }
                    
                    Cabecalho=Conteudo.substring(PontaDeBloco,AbreBloco-1);
                    FechaBloco= Conteudo.indexOf("}",AbreBloco);//Só adiciona +1 pq foi feito o teste de existencia de blocos;
                    Bloco=Conteudo.substring(AbreBloco+1,FechaBloco-1);


                    ParteDeSessao = Cabecalho.split("\t");
                    if(ParteDeSessao.length>=2){
                        if(ParteDeSessao[1].equals("script")){
                            Instancia[i].setTipo("script");
                            Instancia[i].setNome(ParteDeSessao[2].toString());

                            ParteDaPosicao = ParteDeSessao[0].split(",");
                            ParteDoMapa = ParteDaPosicao[0].split("\\.");
                            //Mensagem_Erro("ParteDoMapa=\""+ParteDoMapa[0].toString()+"\"", "Nota de Programador");
                            Instancia[i].setMapa(ParteDoMapa[0].toString());
                            Instancia[i].setX(Integer.parseInt(ParteDaPosicao[1].toString()));
                            Instancia[i].setY(Integer.parseInt(ParteDaPosicao[2].toString()));

                            ParteFacutativa = ParteDeSessao[3].split(",");
                            //Mensagem_Erro("ParteFacutativa=\""+ParteFacutativa.length+"\"", "Nota de Programador");
                            Instancia[i].setImagem(Integer.parseInt(ParteFacutativa[0].toString()));
                            if(ParteFacutativa.length>=2) {
                                if(!ParteFacutativa[1].equals("")) {
                                    //Mensagem_Erro("ParteFacutativa[1]=\""+ParteFacutativa[1]+"\"", "Nota de Programador");
                                    Instancia[i].setLarguraDeGatilho(Integer.parseInt(ParteFacutativa[1].toString()));
                                }
                            }
                            if(ParteFacutativa.length>=3) {
                                if(!ParteFacutativa[2].equals("")) {
                                    Instancia[i].setAlturaDeGatilho(Integer.parseInt(ParteFacutativa[2].toString()));
                                }
                            }

                            //BtnSalvarScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"))); // NOI18N
                            Icone=new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"));
                            TituloDeBloco[i] = new Object();
                            TituloDeBloco[i] = "<html><font color=\"#888888\">"+(i+1) + "º </font>" +
                                ""+Instancia[i].getNome()+
                                " <font color=\"#888888\">"+
                                    "("+Instancia[i].getMapa()+":"+Instancia[i].getX()+","+Instancia[i].getY()+")"+
                                    " [img "+Instancia[i].getImagem()+":"+Instancia[i].getLarguraDeGatilho()+","+Instancia[i].getAlturaDeGatilho()+"]"+
                                "</font>";
                        }

                        Instancia[i].setScript(Bloco);
                        CmbScript.setModel(new DefaultComboBoxModel(TituloDeBloco));
                        if(CmbScript.getSelectedIndex()==i){
                            CmbScript.setSelectedItem(i);
                            TxtScriptPalco.setText(Bloco.substring(0,Bloco.length()));
                        }
                    }else{
                        //TxtScript.setText(Conteudo.toString());
                        FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">ERRO:</font> Cabeçalho de Bloco com formato inválido!");
                        Mensagem_Erro(
                            "Cabeçalho de Bloco com formato inválido!\n"+
                            "<html><font color=\"#FF0000\">"+Cabecalho,
                            "ERRO"
                        );
                    }
                }
                TxtScriptPalco.setEnabled(true);
                BarraDeCodigos(true);
                CmbScript.setEnabled(true);
                this.setTitle("Editor de Scripts ["+Endereco+"]");
                //Mensagem_Erro("Arquivo possui "+blocos+" blocos!", "AVISO");
            }else{
                //TxtScript.setText(Conteudo.toString());
                FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">ERRO:</font> O arquivo possui conteúdo incompatível com o Eathena Script!");
                Mensagem_Erro("O arquivo possui conteúdo incompatível com o Eathena Script!", "ERRO");
            }
        } catch (java.io.IOException exc) {
            FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">ERRO:</font> Não foi possivel abrir \""+EnderecoDoScript+"\"!");
            Mensagem_Erro("Não foi possivel abrir \""+EnderecoDoScript+"\"!","AVISO");
            //ExemploDeConteudo();
            //TxtScript.setEnabled(true);
            //CmbScript.setEnabled(true);
        }
    }
    public static void Mensagem_Erro(String Aviso, String Titulo) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,Aviso,Titulo,JOptionPane.WARNING_MESSAGE);
    }
    public void addScript(String Codigo){
        String Conteudo=FrmScript.TxtScriptPalco.getText();
        String TxtInicio=Conteudo.substring(0,FrmScript.TxtScriptPalco.getSelectionStart());
        String TxtFinal=Conteudo.substring(FrmScript.TxtScriptPalco.getSelectionStart(),FrmScript.TxtScriptPalco.getText().length());
        FrmScript.TxtScriptPalco.setText(TxtInicio+Codigo+TxtFinal);
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
        BtnNovoScript = new javax.swing.JButton();
        BtnSalvarScript = new javax.swing.JButton();
        BtnAbrirScript = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        CmbScript = new javax.swing.JComboBox();
        TbrComandos = new javax.swing.JToolBar();
        BtnScriptComandoMes = new javax.swing.JButton();
        BtnScriptComandoIF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Scripts");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TxtScriptPalco.setColumns(20);
        TxtScriptPalco.setFont(new java.awt.Font("Monospaced", 0, 14));
        TxtScriptPalco.setRows(5);
        TxtScriptPalco.setEnabled(false);
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

        BtnNovoScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/tmw-br.png"))); // NOI18N
        BtnNovoScript.setText("Novo");
        BtnNovoScript.setToolTipText("Cria novo script (Ctrl+N)");
        BtnNovoScript.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnNovoScript.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BtnNovoScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNovoScriptActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnNovoScript);

        BtnSalvarScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"))); // NOI18N
        BtnSalvarScript.setText("Salvar");
        BtnSalvarScript.setToolTipText("Salvar script (Ctrl+S)");
        BtnSalvarScript.setEnabled(false);
        BtnSalvarScript.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnSalvarScript.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BtnSalvarScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarScriptActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnSalvarScript);

        BtnAbrirScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        BtnAbrirScript.setText("Abrir");
        BtnAbrirScript.setToolTipText("Abrir script salvo (Ctrl+O)");
        BtnAbrirScript.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnAbrirScript.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BtnAbrirScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbrirScriptActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAbrirScript);
        jToolBar1.add(jSeparator1);

        CmbScript.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<sem blocos>" }));
        CmbScript.setEnabled(false);
        CmbScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbScriptActionPerformed(evt);
            }
        });
        jToolBar1.add(CmbScript);

        TbrComandos.setFloatable(false);
        TbrComandos.setOrientation(javax.swing.SwingConstants.VERTICAL);
        TbrComandos.setRollover(true);

        BtnScriptComandoMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_comentario.gif"))); // NOI18N
        BtnScriptComandoMes.setToolTipText("<html><b>MES:</b> Fala de pesonagem");
        BtnScriptComandoMes.setEnabled(false);
        BtnScriptComandoMes.setFocusable(false);
        BtnScriptComandoMes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnScriptComandoMes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnScriptComandoMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScriptComandoMesActionPerformed(evt);
            }
        });
        TbrComandos.add(BtnScriptComandoMes);

        BtnScriptComandoIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/losangulo.gif"))); // NOI18N
        BtnScriptComandoIF.setToolTipText("<html><b>IF:</b> Teste de Condição");
        BtnScriptComandoIF.setEnabled(false);
        BtnScriptComandoIF.setFocusable(false);
        BtnScriptComandoIF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnScriptComandoIF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnScriptComandoIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScriptComandoIFActionPerformed(evt);
            }
        });
        TbrComandos.add(BtnScriptComandoIF);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TbrComandos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(TbrComandos, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//#####################################################################################################
    private void CmbScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbScriptActionPerformed
        //abrirInstancia(EnderecoDoScript);
        //this.setTitle(Integer.toString(i));
        int i = CmbScript.getSelectedIndex();
        String Cod= Instancia[i].getScript().toString();
        TxtScriptPalco.setText(Cod.toString());/**/
    }//GEN-LAST:event_CmbScriptActionPerformed
    private void TxtScriptPalcoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtScriptPalcoKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F1 && evt.isControlDown()){
            //ExemploDeConteudo();
        }else if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_T && evt.isControlDown()){
            //ExemploDeConteudo();
        }else if(BtnSalvarScript.isEnabled() && evt.getKeyCode()==java.awt.event.KeyEvent.VK_S && evt.isControlDown()){
            salvarInstancia(EnderecoDoScript);
        }else if(BtnAbrirScript.isEnabled() && evt.getKeyCode()==java.awt.event.KeyEvent.VK_O && evt.isControlDown()){
            abrirInstancia(EnderecoDoScript);
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
            BtnSalvarScript.setEnabled(true);
        }/**/
    }//GEN-LAST:event_TxtScriptPalcoKeyPressed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //ExemploDeConteudo();
        //abrirInstancia(EnderecoDoScript);
    }//GEN-LAST:event_formWindowOpened
    private void BtnAbrirScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirScriptActionPerformed
        abrirInstancia(EnderecoDoScript);
    }//GEN-LAST:event_BtnAbrirScriptActionPerformed
    private void BtnSalvarScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarScriptActionPerformed
        salvarInstancia(EnderecoDoScript);
    }//GEN-LAST:event_BtnSalvarScriptActionPerformed
    private void BtnNovoScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoScriptActionPerformed
        if(BtnNovoScript.isEnabled()){
            javax.swing.JDialog FrmNovoBloco = new FrmNovoBloco(this,false);
            FrmNovoBloco.setLocation(
                ((this.getWidth() - FrmNovoBloco.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmNovoBloco.getHeight()) / 2) + this.getY());
            FrmNovoBloco.pack();
            FrmNovoBloco.setModal(true);
            FrmNovoBloco.setVisible(true);/**/
        }
    }//GEN-LAST:event_BtnNovoScriptActionPerformed
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
        if(FrmScript.TxtScriptPalco.getCaretPosition()>=0){
            try {
                linha = FrmScript.TxtScriptPalco.getLineOfOffset(FrmScript.TxtScriptPalco.getCaretPosition());
                coluna = (FrmScript.TxtScriptPalco.getCaretPosition()-FrmScript.TxtScriptPalco.getLineStartOffset(linha));
            } catch (BadLocationException ex) {
                Logger.getLogger(FrmScript.class.getName()).log(Level.SEVERE, null, ex);
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
//#####################################################################################################

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmScript dialog = new FrmScript(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnAbrirScript;
    private javax.swing.JButton BtnNovoScript;
    private javax.swing.JButton BtnSalvarScript;
    public static javax.swing.JButton BtnScriptComandoIF;
    public static javax.swing.JButton BtnScriptComandoMes;
    public static javax.swing.JComboBox CmbScript;
    private javax.swing.JToolBar TbrComandos;
    public static javax.swing.JTextArea TxtScriptPalco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
