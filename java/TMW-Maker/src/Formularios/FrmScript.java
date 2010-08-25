
package Formularios;

import Classes.ConfigClass;


public class FrmScript extends javax.swing.JDialog {
    public FrmScript(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    static String Barra = System.getProperty("file.separator");
    public static String Base=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"npc";
    public static String EnderecoDoScript="";
    public static String PatasDoScript="";
    public static String TipoDeCodigo = "";

    public static void ListarArquivos(){
        javax.swing.tree.DefaultMutableTreeNode No1 = new javax.swing.tree.DefaultMutableTreeNode("localhost");
        javax.swing.tree.DefaultMutableTreeNode No2 = null;

        if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
            javax.swing.tree.DefaultMutableTreeNode No3 = null;
            javax.swing.tree.DefaultMutableTreeNode No4 = null;
            String Pasta[] = FrmPrincipal.Config.ListarPastas(Base);
            String Arquivo[] = null;
            int ContArquivos=0;
            No2 = new javax.swing.tree.DefaultMutableTreeNode("Scripts");
            for(int p=0; p<Pasta.length; p++){
                if(!Pasta[p].equals(".svn") && !Pasta[p].equals("functions")){
                    //TxtScript.setText(TxtScript.getText()+Pasta[p]+"\n");
                    No3 = new javax.swing.tree.DefaultMutableTreeNode(Pasta[p]);
                    No2.add(No3);

                    ContArquivos=0;
                    Arquivo = FrmPrincipal.Config.ListarArquivos(Base+Barra+Pasta[p]);
                    for(int a=0; a<Arquivo.length; a++){
                        if(
                            !Arquivo[a].substring(Arquivo[a].toString().length()-1, Arquivo[a].toString().length()).equals("~") &&
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
            Arquivo = FrmPrincipal.Config.ListarArquivos(Base+Barra+"functions");
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TreScripts = new javax.swing.JTree();
        jToolBar1 = new javax.swing.JToolBar();
        BtnNovo = new javax.swing.JButton();
        BtnAbrir = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();

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

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        BtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_script.png"))); // NOI18N
        BtnNovo.setMnemonic('N');
        BtnNovo.setText("Novo");
        BtnNovo.setEnabled(false);
        BtnNovo.setFocusable(false);
        BtnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnNovo);

        BtnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        BtnAbrir.setMnemonic('A');
        BtnAbrir.setText("Abrir");
        BtnAbrir.setEnabled(false);
        BtnAbrir.setFocusable(false);
        BtnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAbrir);

        BtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lixeira.png"))); // NOI18N
        BtnExcluir.setMnemonic('E');
        BtnExcluir.setText("Excluir");
        BtnExcluir.setEnabled(false);
        BtnExcluir.setFocusable(false);
        BtnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnExcluir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TreScriptsValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_TreScriptsValueChanged
        if(evt.getPath().getPathCount()==3 && evt.getPath().getPathComponent(1).toString().equals("Scripts")){
            PatasDoScript=evt.getPath().getPathComponent(2).toString();
            //EnderecoDoScript=PatasDoScript+Barra+evt.getPath().getLastPathComponent().toString();
            BtnNovo.setEnabled(true);
            TipoDeCodigo="Scripts";
        }else if(evt.getPath().getPathCount()==2 && evt.getPath().getPathComponent(1).toString().equals("Funções")){
            PatasDoScript="functions";
            //EnderecoDoScript=PatasDoScript+Barra+evt.getPath().getLastPathComponent().toString();
            BtnNovo.setEnabled(true);
            TipoDeCodigo="Funções";
        }else{
            BtnNovo.setEnabled(false);
            TipoDeCodigo="";
        }
        
        if(evt.getPath().getPathCount()==4){
            TipoDeCodigo="Scripts";
            BtnAbrir.setEnabled(true);
            BtnExcluir.setEnabled(true);
            String Endereco = evt.getPath().toString().substring(1, evt.getPath().toString().length()-1);
            String PartesDoEndereco[]=Endereco.split(", ");
            EnderecoDoScript=Base;
            for(int t=2;t<PartesDoEndereco.length;t++){
                EnderecoDoScript+=Barra+evt.getPath().getPathComponent(t).toString();
            }
            //setTitle("EnderecoDoScript = \""+EnderecoDoScript+"\"");
            setTitle("Script - "+evt.getPath().getLastPathComponent().toString());
        }else if(evt.getPath().getPathCount()==3 && evt.getPath().getPathComponent(1).toString().equals("Funções")){
            TipoDeCodigo="Funções";
            BtnAbrir.setEnabled(true);
            BtnExcluir.setEnabled(true);
            String Endereco = evt.getPath().toString().substring(1, evt.getPath().toString().length()-1);
            String PartesDoEndereco[]=Endereco.split(", ");
            EnderecoDoScript=Base+Barra+"functions";
            for(int t=2;t<PartesDoEndereco.length;t++){
                EnderecoDoScript+=Barra+evt.getPath().getPathComponent(t).toString();
            }
            //setTitle("EnderecoDoScript = \""+EnderecoDoScript+"\"");
            setTitle("Script - "+evt.getPath().getLastPathComponent().toString());
        }else{
            BtnAbrir.setEnabled(false);
            BtnExcluir.setEnabled(false);
            setTitle("Árvore de Scripts");
        }/**/
        
        //setTitle("getPathCount() = \""+evt.getPath().getPathCount()+"\" getPathComponent(1) = \""+evt.getPath().getPathComponent(1).toString()+"\"");

        //EnderecoDoScript
        //TxtScript.setText(evt.getPath().toString());

        //setTitle("Endereco = \""+Endereco+"\"");

        //setTitle("lenght - "+evt.getPaths().length);
    }//GEN-LAST:event_TreScriptsValueChanged
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ListarArquivos();
    }//GEN-LAST:event_formWindowOpened
    private void BtnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirActionPerformed
        javax.swing.JDialog FrmPalco = new FrmPalco(this, rootPaneCheckingEnabled);
        FrmPalco.setLocation(
            ((this.getWidth() - FrmPalco.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmPalco.getHeight()) / 2) + this.getY());
        FrmPalco.pack();
        FrmPalco.setModal(true);
        FrmPalco.setVisible(true);
    }//GEN-LAST:event_BtnAbrirActionPerformed
    private void BtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoActionPerformed
        javax.swing.JDialog FrmNovoScript = new FrmNovoScript2(this, rootPaneCheckingEnabled);
        FrmNovoScript.setLocation(
            ((this.getWidth() - FrmNovoScript.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmNovoScript.getHeight()) / 2) + this.getY());
        FrmNovoScript.pack();
        FrmNovoScript.setModal(true);
        FrmNovoScript.setVisible(true);
    }//GEN-LAST:event_BtnNovoActionPerformed
    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        ConfigClass.Mensagem_Erro("Esse função ainda não foi implementada!", "Desculpe");
    }//GEN-LAST:event_BtnExcluirActionPerformed
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
    private javax.swing.JButton BtnAbrir;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnNovo;
    public static javax.swing.JTree TreScripts;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
