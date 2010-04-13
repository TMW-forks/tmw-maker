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
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class FrmNpcScript extends javax.swing.JDialog {  
    public FrmNpcScript(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    NPCclass NPC[] = null;

    public void ExemploDeConteudo(){
        try {
            //NPCclass NovoNPC = new NPCclass;
            NPC[0].setNome("Elias");
            NPC[0].setMapa("008");
            NPC[0].setX(107);
            NPC[0].setY(32);
            NPC[0].setImagem(0);
            NPC[0].setScript(" ");

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
            Mensagem_Erro("Ocorreu um Erro durante instanciação!","ERRO");
        }
    }
    public String NPCsArray2String(NPCclass NPCs[]){
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
    public String NPCsArray2String(NPCclass NPCs){
        String Codigo="";
        Codigo+=
        NPCs.getMapa()+".gat,"+NPCs.getX()+","+NPCs.getY()+",0\tscript\t"+NPCs.getNome()+"\t"+NPCs.getImagem()+",{\n"+
            NPCs.getScript()+"\n"+
        "}";
        return Codigo;
    }
    public boolean salvarNPC(String Endereco){
        //ExemploDeConteudo();
        try {
            FileWriter out = new FileWriter(Endereco);
            out.write(NPCsArray2String(NPC));
            out.close();
            //T1.setText("Arquivo gravado com sucesso !");
            Mensagem_Erro("Arquivo gravado com sucesso !","AVISO");
            return true;
        } catch (java.io.IOException exc) {
            Mensagem_Erro("Não foi possivel gravar o arquivo!","AVISO");
            return false;
        }

    }
    public static void abrirNPC(){
        /*FileReader fr;
        BufferedReader br;
        String result="";
        String word= new String();
        String target = "friend";


        try{ //read one text file
            fr = new FileReader ("C:/Users/user/Desktop/java/test.txt");
            br = new BufferedReader(fr);
            Scanner scan = new Scanner(br);


            while(scan.hasNext()){
                result = scan.findWithinHorizon(target,0);

                if(result!=null) {
                    word = (scan.next() + scan.findWithinHorizon("", 0));

                    ArrayList<String> names = new ArrayList<String>();
                    names.add(word);
                    for (int i=0; i< names.size() ; i++) {
                            System.out.println(names.get(i));
                    }
                }
            }
        } catch(Exception e){
            //
        }/**/
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
        CmbScript = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editando NPC /008_Ilha_Fortaleza/guardas.conf]");

        TxtScript.setColumns(20);
        TxtScript.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TxtScript.setRows(5);
        TxtScript.setText("     mes \"[Roger (Guarda da Torre)]\";\n     mes \"ZzzZzzZ...\";\n     next;\n     mes \"Hã!!! Eu não estava dormindo.\";\n     close;");
        jScrollPane1.setViewportView(TxtScript);

        CmbScript.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elias  (008:107,32)", "Roger (008:108,23)" }));
        CmbScript.setSelectedIndex(1);
        CmbScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbScriptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addComponent(CmbScript, javax.swing.GroupLayout.Alignment.LEADING, 0, 506, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CmbScript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmbScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbScriptActionPerformed
        // TODO add your handling code here:
        //NPC[0].setNome("Elias");

        //ExemploDeConteudo();
        //int i = CmbScript.getSelectedIndex();
        //this.setTitle(Integer.toString(i));
        //String Cod= NPC[i].getScript().toString();
        //TxtScript.setText(Cod.toString());/**/

    }//GEN-LAST:event_CmbScriptActionPerformed

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
    private javax.swing.JComboBox CmbScript;
    private javax.swing.JTextArea TxtScript;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
