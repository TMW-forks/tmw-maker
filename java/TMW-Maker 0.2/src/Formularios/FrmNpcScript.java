/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmNpcScript.java
 *
 * Created on Apr 12, 2010, 8:22:51 PM
 */

package Formularios;


import Classes.NPCclass;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmNpcScript extends javax.swing.JDialog {  
    public FrmNpcScript(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
//#####################################################################################################
    public NPCclass NPC[];
//#####################################################################################################
    public String NPCsArray2String(NPCclass[] NPCs){
        String Codigo="";
        for(int i=0;i<NPCs.length;i++){
            //008.gat,108,23,0	script	Roger	308,{
            Codigo+=
            NPCs[i].getMapa()+".gat,"+NPCs[i].getX()+","+NPCs[i].getY()+",0\tscript\t"+NPCs[i].getNome()+"\t"+NPCs[i].getImagem()+",{\n"+
                NPCs[i].getScript()+"\n"+
            "}";
            if(i<(NPCs.length-1)){Codigo+="\n\n";}//<<<< Cria uma linha em branco antes de por o 2º NPC
        }
        return Codigo;
    }
    public void ExemploDeConteudo(){
        try {
            NPC= new NPCclass[2]; // Diz que são 2 NPCs

            NPC[0] = new NPCclass();// Cria o NPC nº0
            NPC[0].setNome("Elias");
            NPC[0].setMapa("008");
            NPC[0].setX(107);
            NPC[0].setY(32);
            NPC[0].setImagem(0);
            NPC[0].setScript(
                "//Editando os Arquivo do NPC!\n"+
                "//Pode Ficar Tranquilo... (T_T)"
            );

            NPC[1] = new NPCclass();// Cria o NPC nº1
            NPC[1].setNome("Roger");
            NPC[1].setMapa("008");
            NPC[1].setX(108);
            NPC[1].setY(2);
            NPC[1].setImagem(0);
            NPC[1].setScript(""+
            "     mes \"[Roger (Guarda da Torre)]\";\n"+
            "     mes \"ZzzZzzZ...\";\n"+
            "     next;\n"+
            "     mes \"Hã!!! Eu não estava dormindo.\";\n"+
            "     close;");/**/
        }catch(Exception e){
            Mensagem_Erro("Ocorreu um Erro durante instanciação do exemplo de Script!","ERRO");
        }
    }
    public void novoNPC(){
        ExemploDeConteudo();
        //TxtScript.setEnabled(true);
        //CmbScript.setEnabled(true);
        BtnSalvarScript.setEnabled(true);
        //CmbScript.setEnabled(true);
        TxtScript.setEnabled(true);
    }
    public boolean salvarNPC(String Endereco){
        //ExemploDeConteudo();
        try {
            /*int i = CmbScript.getSelectedIndex();
            this.setTitle(Integer.toString(i));
            String Cod= NPC[i].getScript().toString();
            TxtScript.setText(Cod.toString());/**/
            /*NPC= new NPCclass[CmbScript.getItemCount()];
            for(i=0;i<CmbScript.getItemCount();i++){
                NPC[i] = new NPCclass();// Cria o NPC nº0
            }/**/


            int i = CmbScript.getSelectedIndex();
            NPC[i].setScript(TxtScript.getText().toString());
            FileWriter out = new FileWriter(Endereco);
            out.write(NPCsArray2String(NPC));
            out.close();
            //T1.setText("Arquivo gravado com sucesso !");
            CmbScript.setEnabled(true);
            TxtScript.setEnabled(true);
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
    public void abrirNPC(String Endereco){
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
                NPC= new NPCclass[blocos]; // Diz que são 2 NPCs
                
                StringBuffer Manipulador = new StringBuffer(Conteudo);
                for(int i=0;i<blocos;i++){
                    AbreBloco=FechaBloco;
                    //if(i==0){
                        NPC[i] = new NPCclass();// Cria o NPC nº0
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
                        NPC[i].setScript(Bloco);
                        if(CmbScript.getSelectedIndex()==i){
                            CmbScript.setSelectedItem(i);
                            CmbScript.setActionCommand(Cabecalho);
                            TxtScript.setText(Bloco.substring(0,Bloco.length()));
                        }

                        /*Mensagem_Erro(
                            "PontaDeBloco="+PontaDeBloco+", "+
                            "AbreBloco="+AbreBloco+", "+
                            "FechaBloco="+FechaBloco+", "+
                            "\n\""+
                            Cabecalho+"\"\n"
                        , "Nota de Programador");/**/
                    /*}else{
                        NPC[i] = new NPCclass();// Cria o NPC nº0
                        NPC[i].setScript("");
                        Mensagem_Erro("ERRO: Bloco nº"+(i+1)+" não aproveitado pelo TMW-Maker!", "ERRO");
                    }/**/
                }
                TxtScript.setEnabled(true);
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
//#####################################################################################################
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TxtScript = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        BtnNovoScript = new javax.swing.JButton();
        BtnSalvarScript = new javax.swing.JButton();
        BtnAbrirScript = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        CmbScript = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Scripts");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TxtScript.setColumns(20);
        TxtScript.setFont(new java.awt.Font("Monospaced", 0, 14));
        TxtScript.setRows(5);
        TxtScript.setText("     mes \"[Roger (Guarda da Torre)]\";\n     mes \"ZzzZzzZ...\";\n     next;\n     mes \"Hã!!! Eu não estava dormindo.\";\n     close;");
        TxtScript.setEnabled(false);
        TxtScript.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtScriptKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TxtScript);

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

        CmbScript.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "001º Elias  (008:107,32)", "002º Roger (008:108,23)" }));
        CmbScript.setSelectedIndex(1);
        CmbScript.setEnabled(false);
        CmbScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbScriptActionPerformed(evt);
            }
        });
        jToolBar1.add(CmbScript);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//#####################################################################################################
    private void CmbScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbScriptActionPerformed
        int i = CmbScript.getSelectedIndex();
        //this.setTitle(Integer.toString(i));
        abrirNPC("ScriptNPC.txt");
        //String Cod= NPC[i].getScript().toString();
        //TxtScript.setText(Cod.toString());/**/
    }//GEN-LAST:event_CmbScriptActionPerformed
    private void TxtScriptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtScriptKeyPressed
        //int i = CmbScript.getSelectedIndex();
        //NPC[i].setScript(TxtScript.getText().toString());

        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_T && evt.isControlDown()){
            ExemploDeConteudo();
        }else  if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_S && evt.isControlDown()){
            salvarNPC("ScriptNPC.txt");
        }else if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_O && evt.isControlDown()){
            abrirNPC("ScriptNPC.txt");
        }else{
            CmbScript.setEnabled(false);
            BtnSalvarScript.setEnabled(true);
        }
    }//GEN-LAST:event_TxtScriptKeyPressed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //ExemploDeConteudo();
        abrirNPC("ScriptNPC.txt");
    }//GEN-LAST:event_formWindowOpened
    private void BtnAbrirScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirScriptActionPerformed
        abrirNPC("ScriptNPC.txt");
        /*try {
            String Conteudo="";
            FileReader CapsulaDeLer = new FileReader("ScriptNPC.txt");
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
        salvarNPC("ScriptNPC.txt");
    }//GEN-LAST:event_BtnSalvarScriptActionPerformed
    private void BtnNovoScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoScriptActionPerformed
        novoNPC();
    }//GEN-LAST:event_BtnNovoScriptActionPerformed
//#####################################################################################################

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmNpcScript dialog = new FrmNpcScript(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox CmbScript;
    private javax.swing.JTextArea TxtScript;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
