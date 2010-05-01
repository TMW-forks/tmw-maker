
package Formularios;

import java.io.File;
import java.util.Arrays;


public class FrmScript extends javax.swing.JDialog {
    public FrmScript(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    static String Barra = System.getProperty("file.separator");

    private String[] ListarPastas(String Endereco){
        ///home/indigovox/localhost/eathena-data/npc
        File Capsula = new File(Endereco);
        File[] Conteudo = Capsula.listFiles();
        int ContPastas=0;
        for(int c=0; c<Conteudo.length; c++){
            if(Conteudo[c].isDirectory()){
                ContPastas++;
            }
        }
        String Pasta[] = new String[ContPastas];
        ContPastas=0;
        for(int p=0; p<Conteudo.length; p++){
            if(Conteudo[p].isDirectory()){
                Pasta[ContPastas]=Conteudo[p].getName();
                //TxtScript.setText(TxtScript.getText()+Conteudo[c].getName()+"\n");
                ContPastas++;
            }
        }
        Arrays.sort(Pasta);
        return Pasta;
    }
    private String[] ListarArquivos(String Endereco){
        ///home/indigovox/localhost/eathena-data/npc
        File Capsula = new File(Endereco);
        File[] Conteudo = Capsula.listFiles();
        int ContArquivos=0;
        for(int c=0; c<Conteudo.length; c++){
            if(Conteudo[c].isFile()){
                ContArquivos++;
            }
        }
        String Arquivos[] = new String[ContArquivos];
        ContArquivos=0;
        for(int a=0; a<Conteudo.length; a++){
            if(Conteudo[a].isFile()){
                Arquivos[ContArquivos]=Conteudo[a].getName();
                ContArquivos++;
            }
        }
        Arrays.sort(Arquivos);
        return Arquivos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TreScripts = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtScript = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Árvore de Scripts");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Scripts");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("005");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("elric.conf");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("007");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("gismo.conf");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("008");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("jack.conf");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Funções");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("makehorcrux.conf");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("gettime.conf");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("banker.conf");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        TreScripts.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        TreScripts.setFocusCycleRoot(true);
        TreScripts.setInheritsPopupMenu(true);
        TreScripts.setLargeModel(true);
        TreScripts.setScrollsOnExpand(true);
        TreScripts.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                TreScriptsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(TreScripts);

        TxtScript.setColumns(20);
        TxtScript.setRows(5);
        TxtScript.setWrapStyleWord(true);
        jScrollPane2.setViewportView(TxtScript);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TreScriptsValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_TreScriptsValueChanged
        setTitle("Script - "+evt.getPath().getLastPathComponent().toString());
        TxtScript.setText(evt.getPath().toString());
    }//GEN-LAST:event_TreScriptsValueChanged
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        javax.swing.tree.DefaultMutableTreeNode No1 = new javax.swing.tree.DefaultMutableTreeNode("localhost");
        javax.swing.tree.DefaultMutableTreeNode No2 = null;

        if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
            javax.swing.tree.DefaultMutableTreeNode No3 = null;
            javax.swing.tree.DefaultMutableTreeNode No4 = null;
            String Pasta[] = ListarPastas(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"npc");
            String Arquivo[] = null;
            int ContArquivos=0;
            No2 = new javax.swing.tree.DefaultMutableTreeNode("Scripts");
            for(int p=0; p<Pasta.length; p++){
                if(!Pasta[p].equals(".svn") && !Pasta[p].equals("functions")){
                    //TxtScript.setText(TxtScript.getText()+Pasta[p]+"\n");
                    No3 = new javax.swing.tree.DefaultMutableTreeNode(Pasta[p]);
                    No2.add(No3);

                    ContArquivos=0;
                    Arquivo = ListarArquivos(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"npc"+Barra+Pasta[p]);
                    for(int a=0; a<Arquivo.length; a++){
                        if(
                            !Arquivo[a].equals("_import.txt") &&
                            !Arquivo[a].equals("_mobs.txt") &&
                            !Arquivo[a].equals("_warps.txt")
                        ){
                            ContArquivos++;
                            //TxtScript.setText(TxtScript.getText()+Arquivo[a]+"\n");
                            No4 = new javax.swing.tree.DefaultMutableTreeNode(Arquivo[a]);
                            No3.add(No4);
                        }
                    }
                    if(ContArquivos==0){
                        No4 = new javax.swing.tree.DefaultMutableTreeNode("<vazio>");
                        No3.add(No4);
                    }
                }
            }
            No1.add(No2);

            ContArquivos=0;
            No2 = new javax.swing.tree.DefaultMutableTreeNode("Funções");
            Arquivo = ListarArquivos(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"npc"+Barra+"functions");
            for(int a=0; a<Arquivo.length; a++){
                ContArquivos++;
                //TxtScript.setText(TxtScript.getText()+Arquivo[a]+"\n");
                No3 = new javax.swing.tree.DefaultMutableTreeNode(Arquivo[a]);
                No2.add(No3);
            }
            if(ContArquivos==0){
                No3 = new javax.swing.tree.DefaultMutableTreeNode("<vazio>");
                No2.add(No3);
            }
            No1.add(No2);

        }else{
            No2 = new javax.swing.tree.DefaultMutableTreeNode("<localhost-pendente>");
            No1.add(No2);
        }
        
        TreScripts.setModel(new javax.swing.tree.DefaultTreeModel(No1));
    }//GEN-LAST:event_formWindowOpened
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
    private javax.swing.JTree TreScripts;
    private javax.swing.JTextArea TxtScript;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
