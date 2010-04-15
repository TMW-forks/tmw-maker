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
import Formularios.FrmPrincipal;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmScript extends javax.swing.JDialog {
    public FrmScript(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
//#####################################################################################################
    public BlocoDeScript Instancia[];
//#####################################################################################################
    public String InstanciasArray2String(BlocoDeScript[] Instancias){
        String Codigo="";
        for(int i=0;i<Instancias.length;i++){
            //008.gat,108,23,0	script	Roger	308,{
            if(Instancias[i].getTipo()=="script"){
                Codigo+=
                Instancias[i].getMapa()+".gat,"+Instancias[i].getX()+","+Instancias[i].getY()+",0\tscript\t"+Instancias[i].getNome()+"\t"+Instancias[i].getImagem()+",{\n"+
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
    public void ExemploDeConteudo(){
        try {
            Instancia= new BlocoDeScript[2]; // Diz que são 2 Instancias

            Instancia[0] = new BlocoDeScript();// Cria o Instancia nº0
            Instancia[0].setNome("ExemploDeFuncao");
            Instancia[0].setTipo("function\tscript");
            Instancia[0].setScript(
                "_inicio:\n"+
                "     //Editando os Arquivo do Instancia!\n"+
                "     //Pode Ficar Tranquilo... (T_T)\n"+
                "_retorno:"
            );

            Instancia[1] = new BlocoDeScript();// Cria o Instancia nº1
            Instancia[1].setNome("Roger");
            Instancia[1].setTipo("script");
            Instancia[1].setMapa("008");
            Instancia[1].setX(108);
            Instancia[1].setY(2);
            Instancia[1].setImagem(0);
            Instancia[1].setScript(""+
            "_inicio:\n"+
            "     mes \"[Roger (Guarda da Torre)]\";\n"+
            "     mes \"ZzzZzzZ...\";\n"+
            "     next;\n"+
            "     mes \"Hã!!! Eu não estava dormindo.\";\n"+
            "close;");/**/

            TxtScriptPalco.setText(Instancia[(int)CmbScript.getSelectedIndex()].getScript());
            //TxtScriptPalco.setEditable(true);
        }catch(Exception e){
            Mensagem_Erro("Ocorreu um Erro durante instanciação do exemplo de Script!","ERRO");
        }
    }
    public void novoInstancia(){
        ExemploDeConteudo();
        //TxtScript.setEnabled(true);
        //CmbScript.setEnabled(true);
        BtnSalvarScript.setEnabled(true);
        //CmbScript.setEnabled(true);
        TxtScriptPalco.setEnabled(true);
        BarraDeCodigos(true);
    }
    public boolean salvarInstancia(String Endereco){
        //ExemploDeConteudo();
        try {
            /*int i = CmbScript.getSelectedIndex();
            this.setTitle(Integer.toString(i));
            String Cod= Instancia[i].getScript().toString();
            TxtScript.setText(Cod.toString());/**/
            /*Instancia= new BlocoDeScript[CmbScript.getItemCount()];
            for(i=0;i<CmbScript.getItemCount();i++){
                Instancia[i] = new BlocoDeScript();// Cria o Instancia nº0
            }/**/


            int i = CmbScript.getSelectedIndex();
            Instancia[i].setScript(TxtScriptPalco.getText().toString());
            FileWriter out = new FileWriter(Endereco);
            out.write(InstanciasArray2String(Instancia));
            out.close();
            //T1.setText("Arquivo gravado com sucesso !");
            CmbScript.setEnabled(true);
            TxtScriptPalco.setEnabled(true);
            BarraDeCodigos(true);
            BtnSalvarScript.setEnabled(false);
            BtnAbrirScript.setEnabled(true);
            this.setTitle("Editor de Scripts ["+Endereco+"]");
            //Mensagem_Erro("Arquivo gravado com sucesso !","AVISO");
            return true;
        } catch (java.io.IOException exc) {
            Mensagem_Erro("Não foi possivel gravar o arquivo!","AVISO");
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
                
                StringBuffer Manipulador = new StringBuffer(Conteudo);
                for(int i=0;i<blocos;i++){
                    AbreBloco=FechaBloco;
                    //if(i==0){
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
                         //Mensagem_Erro(Conteudo.substring(PontaDeBloco,AbreBloco), "ERRO");
                        Cabecalho=Conteudo.substring(PontaDeBloco,AbreBloco);
                        FechaBloco= Conteudo.indexOf("}",AbreBloco);//Só adiciona +1 pq foi feito o teste de existencia de blocos;
                        Bloco=Conteudo.substring(AbreBloco+1,FechaBloco-1);
                        //Mensagem_Erro(Bloco, "Nota de Programador");
                        //Mensagem_Erro(CmbScript.getItemAt(i), "Nota de Programador");
                        Instancia[i].setScript(Bloco);
                        if(CmbScript.getSelectedIndex()==i){
                            CmbScript.setSelectedItem(i);
                            CmbScript.setActionCommand(Cabecalho);
                            TxtScriptPalco.setText(Bloco.substring(0,Bloco.length()));
                        }

                        /*Mensagem_Erro(
                            "PontaDeBloco="+PontaDeBloco+", "+
                            "AbreBloco="+AbreBloco+", "+
                            "FechaBloco="+FechaBloco+", "+
                            "\n\""+
                            Cabecalho+"\"\n"
                        , "Nota de Programador");/**/
                    /*}else{
                        Instancia[i] = new BlocoDeScript();// Cria o Instancia nº0
                        Instancia[i].setScript("");
                        Mensagem_Erro("ERRO: Bloco nº"+(i+1)+" não aproveitado pelo TMW-Maker!", "ERRO");
                    }/**/
                }
                TxtScriptPalco.setEnabled(true);
                BarraDeCodigos(true);
                CmbScript.setEnabled(true);
                this.setTitle("Editor de Scripts ["+Endereco+"]");
                //Mensagem_Erro("Arquivo possui "+blocos+" blocos!", "AVISO");
            }else{
                //TxtScript.setText(Conteudo.toString());
                Mensagem_Erro("O arquivo possui conteúdo incompatível com o Eathena Script!", "ERRO");
            }
        } catch (java.io.IOException exc) {
            //Mensagem_Erro("Não foi possivel abrir o arquivo!","AVISO");
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
        BtnScriptMes.setEnabled(SeAtivo);
        BtnScriptNext.setEnabled(SeAtivo);
        BtnScriptClose.setEnabled(SeAtivo);
    }
    public void showMes() {
        javax.swing.JDialog FrmMes = new FrmMes(this,false);
        FrmMes.setLocation(
            ((this.getWidth() - FrmMes.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmMes.getHeight()) / 2) + this.getY());
        FrmMes.pack();
        FrmMes.setModal(true);
        FrmMes.setVisible(true);/**/
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
        BtnScriptMes = new javax.swing.JButton();
        BtnScriptNext = new javax.swing.JButton();
        BtnScriptClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Scripts");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TxtScriptPalco.setColumns(20);
        TxtScriptPalco.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TxtScriptPalco.setRows(5);
        TxtScriptPalco.setEnabled(false);
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
        BtnAbrirScript.setEnabled(false);
        BtnAbrirScript.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnAbrirScript.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        BtnAbrirScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbrirScriptActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAbrirScript);
        jToolBar1.add(jSeparator1);

        CmbScript.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "001º ExemploDeFuncao", "002º Roger (008:108,23)" }));
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

        BtnScriptMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_comentario.gif"))); // NOI18N
        BtnScriptMes.setToolTipText("<html><b>MES:</b> Fala de pesonagem");
        BtnScriptMes.setEnabled(false);
        BtnScriptMes.setFocusable(false);
        BtnScriptMes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnScriptMes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnScriptMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScriptMesActionPerformed(evt);
            }
        });
        TbrComandos.add(BtnScriptMes);

        BtnScriptNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/pausa.png"))); // NOI18N
        BtnScriptNext.setToolTipText("<html><b>NEXT:</b> Intervalo entre falas de personagem");
        BtnScriptNext.setEnabled(false);
        BtnScriptNext.setFocusable(false);
        BtnScriptNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnScriptNext.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnScriptNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScriptNextActionPerformed(evt);
            }
        });
        TbrComandos.add(BtnScriptNext);

        BtnScriptClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/fechar.png"))); // NOI18N
        BtnScriptClose.setToolTipText("<html><b>CLOSE:</b> Fecha janela de dialogo do personagem");
        BtnScriptClose.setEnabled(false);
        BtnScriptClose.setFocusable(false);
        BtnScriptClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnScriptClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnScriptClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScriptCloseActionPerformed(evt);
            }
        });
        TbrComandos.add(BtnScriptClose);

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
        int i = CmbScript.getSelectedIndex();
        //this.setTitle(Integer.toString(i));
        abrirInstancia("ScriptExemplo.conf");
        //String Cod= Instancia[i].getScript().toString();
        //TxtScript.setText(Cod.toString());/**/
    }//GEN-LAST:event_CmbScriptActionPerformed
    private void TxtScriptPalcoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtScriptPalcoKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_F1 && evt.isControlDown()){
            ExemploDeConteudo();
        }else if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_T && evt.isControlDown()){
            ExemploDeConteudo();
        }else if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_S && evt.isControlDown()){
            salvarInstancia("ScriptExemplo.conf");
        }else if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_O && evt.isControlDown()){
            abrirInstancia("ScriptExemplo.conf");
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
        abrirInstancia("ScriptExemplo.conf");
    }//GEN-LAST:event_formWindowOpened
    private void BtnAbrirScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirScriptActionPerformed
        abrirInstancia("ScriptExemplo.conf");
        /*try {
            String Conteudo="";
            FileReader CapsulaDeLer = new FileReader("ScriptExemplo.conf");
            int Caracater = CapsulaDeLer.read();
            while (Caracater!=-1) {
                Conteudo = Conteudo + (char) Caracater;
                Caracater = CapsulaDeLer.read();
            }
            TxtScript.setText(Conteudo.toString());
            CapsulaDeLer.close();
            Mensagem_Erro("Arquivo Aberto com sucesso!", "AVISO");
        } catch (java.io.IOException exc) {Mensagem_Erro("Não foi possivel abrir o arquivo!","AVISO");}/**/
    }//GEN-LAST:event_BtnAbrirScriptActionPerformed
    private void BtnSalvarScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarScriptActionPerformed
        salvarInstancia("ScriptExemplo.conf");
    }//GEN-LAST:event_BtnSalvarScriptActionPerformed
    private void BtnNovoScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoScriptActionPerformed
        novoInstancia();
    }//GEN-LAST:event_BtnNovoScriptActionPerformed

    private void BtnScriptMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnScriptMesActionPerformed
        if(TxtScriptPalco.isEnabled() && TxtScriptPalco.isFocusable()){
            showMes();
        }
    }//GEN-LAST:event_BtnScriptMesActionPerformed

    private void BtnScriptNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnScriptNextActionPerformed
        if(TxtScriptPalco.isEnabled() && TxtScriptPalco.isFocusable()){
            addScript("next;\n");
            /*String Conteudo=FrmScript.TxtScriptPalco.getText();
            String TxtInicio=Conteudo.substring(0,FrmScript.TxtScriptPalco.getSelectionStart());
            String TxtFinal=Conteudo.substring(FrmScript.TxtScriptPalco.getSelectionStart(),FrmScript.TxtScriptPalco.getText().length());
            String Codigo="next;";
            FrmScript.TxtScriptPalco.setText(TxtInicio+Codigo+TxtFinal+"\n");/**/
        }
    }//GEN-LAST:event_BtnScriptNextActionPerformed

    private void BtnScriptCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnScriptCloseActionPerformed
        if(TxtScriptPalco.isEnabled() && TxtScriptPalco.isFocusable()){
            addScript("close;\n");
            /*String Conteudo=FrmScript.TxtScriptPalco.getText();
            String TxtInicio=Conteudo.substring(0,FrmScript.TxtScriptPalco.getSelectionStart());
            String TxtFinal=Conteudo.substring(FrmScript.TxtScriptPalco.getSelectionStart(),FrmScript.TxtScriptPalco.getText().length());
            String Codigo="close;";
            FrmScript.TxtScriptPalco.setText(TxtInicio+Codigo+TxtFinal+"\n");
            dispose();/**/
        }
    }//GEN-LAST:event_BtnScriptCloseActionPerformed
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
    private javax.swing.JButton BtnScriptClose;
    private javax.swing.JButton BtnScriptMes;
    private javax.swing.JButton BtnScriptNext;
    private javax.swing.JComboBox CmbScript;
    private javax.swing.JToolBar TbrComandos;
    public static javax.swing.JTextArea TxtScriptPalco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
