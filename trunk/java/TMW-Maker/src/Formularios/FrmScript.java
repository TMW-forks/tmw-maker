
package Formularios;

import Classes.Arquivamento;
import Classes.ConfigClass;
import Classes.ImagemTratavel;
import Classes.Mensagem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
            String Pasta[] = Arquivamento.listarPasta(Base);
            String Arquivo[] = null;
            int ContArquivos=0;
            No2 = new javax.swing.tree.DefaultMutableTreeNode("Scripts");
            for(int p=0; p<Pasta.length; p++){
                if(!Pasta[p].equals(".svn") && !Pasta[p].equals("functions")){
                    //TxtScript.setText(TxtScript.getText()+Pasta[p]+"\n");
                    No3 = new javax.swing.tree.DefaultMutableTreeNode(Pasta[p]);
                    No2.add(No3);

                    ContArquivos=0;
                    Arquivo = Arquivamento.listarArquivos(Base+Barra+Pasta[p]);
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
            Arquivo = Arquivamento.listarArquivos(Base+Barra+"functions");
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
        jMenuBar1 = new javax.swing.JMenuBar();
        MnuNovo = new javax.swing.JMenu();
        MnuNovoPersonagem = new javax.swing.JMenuItem();
        MnuNovaLojista = new javax.swing.JMenuItem();
        MnuScript = new javax.swing.JMenu();
        MnuScriptAbrir = new javax.swing.JMenuItem();
        MnuScriptExcluir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MnuScriptDesabilitar = new javax.swing.JMenuItem();
        MnuScriptHabilitar = new javax.swing.JMenuItem();

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
        TreScripts.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                TreScriptsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(TreScripts);

        MnuNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_arvore.png"))); // NOI18N
        MnuNovo.setMnemonic('N');
        MnuNovo.setText("Novo");

        MnuNovoPersonagem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        MnuNovoPersonagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pessoa.gif"))); // NOI18N
        MnuNovoPersonagem.setMnemonic('P');
        MnuNovoPersonagem.setText("Personagem");
        MnuNovoPersonagem.setEnabled(false);
        MnuNovoPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuNovoPersonagemActionPerformed(evt);
            }
        });
        MnuNovo.add(MnuNovoPersonagem);

        MnuNovaLojista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        MnuNovaLojista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_carrinho.gif"))); // NOI18N
        MnuNovaLojista.setMnemonic('L');
        MnuNovaLojista.setText("Lojista");
        MnuNovaLojista.setEnabled(false);
        MnuNovaLojista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuNovaLojistaActionPerformed(evt);
            }
        });
        MnuNovo.add(MnuNovaLojista);

        jMenuBar1.add(MnuNovo);

        MnuScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_script.png"))); // NOI18N
        MnuScript.setMnemonic('S');
        MnuScript.setText("Scrips");

        MnuScriptAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        MnuScriptAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        MnuScriptAbrir.setText("Abrir");
        MnuScriptAbrir.setToolTipText("A");
        MnuScriptAbrir.setEnabled(false);
        MnuScriptAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuScriptAbrirActionPerformed(evt);
            }
        });
        MnuScript.add(MnuScriptAbrir);

        MnuScriptExcluir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MnuScriptExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lixeira.png"))); // NOI18N
        MnuScriptExcluir.setMnemonic('E');
        MnuScriptExcluir.setText("Exckuir");
        MnuScriptExcluir.setEnabled(false);
        MnuScriptExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuScriptExcluirActionPerformed(evt);
            }
        });
        MnuScript.add(MnuScriptExcluir);
        MnuScript.add(jSeparator1);

        MnuScriptDesabilitar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        MnuScriptDesabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/pausa.png"))); // NOI18N
        MnuScriptDesabilitar.setMnemonic('D');
        MnuScriptDesabilitar.setText("Desabilitar");
        MnuScriptDesabilitar.setEnabled(false);
        MnuScript.add(MnuScriptDesabilitar);

        MnuScriptHabilitar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, java.awt.event.InputEvent.CTRL_MASK));
        MnuScriptHabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/cetas.png"))); // NOI18N
        MnuScriptHabilitar.setMnemonic('H');
        MnuScriptHabilitar.setText("Habilitar");
        MnuScriptHabilitar.setEnabled(false);
        MnuScript.add(MnuScriptHabilitar);

        jMenuBar1.add(MnuScript);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TreScriptsValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_TreScriptsValueChanged
        if(evt.getPath().getPathCount()==3 && evt.getPath().getPathComponent(1).toString().equals("Scripts")){
            PatasDoScript=evt.getPath().getPathComponent(2).toString();
            //EnderecoDoScript=PatasDoScript+barra+evt.getPath().getLastPathComponent().toString();
            MnuNovoPersonagem.setEnabled(true);

            String LojaLocal = Base+Barra+PatasDoScript+Barra+"_shops.txt";
            MnuNovaLojista.setEnabled(!Arquivamento.seExiste(LojaLocal));
            
            TipoDeCodigo="Scripts";
        }else if(evt.getPath().getPathCount()==2 && evt.getPath().getPathComponent(1).toString().equals("Funções")){
            PatasDoScript="functions";
            //EnderecoDoScript=PatasDoScript+barra+evt.getPath().getLastPathComponent().toString();
            MnuNovoPersonagem.setEnabled(true);
            TipoDeCodigo="Funções";
        }else{
            MnuNovoPersonagem.setEnabled(false);
            TipoDeCodigo="";
        }
        
        if(evt.getPath().getPathCount()==4){
            TipoDeCodigo="Scripts";
            MnuScriptAbrir.setEnabled(true);
            MnuScriptExcluir.setEnabled(true);
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
            MnuScriptAbrir.setEnabled(true);
            MnuScriptExcluir.setEnabled(true);
            String Endereco = evt.getPath().toString().substring(1, evt.getPath().toString().length()-1);
            String PartesDoEndereco[]=Endereco.split(", ");
            EnderecoDoScript=Base+Barra+"functions";
            for(int t=2;t<PartesDoEndereco.length;t++){
                EnderecoDoScript+=Barra+evt.getPath().getPathComponent(t).toString();
            }
            //setTitle("EnderecoDoScript = \""+EnderecoDoScript+"\"");
            setTitle("Script - "+evt.getPath().getLastPathComponent().toString());
        }else{
            MnuScriptAbrir.setEnabled(false);
            MnuScriptExcluir.setEnabled(false);
            setTitle("Árvore de Scripts");
        }/**/
    }//GEN-LAST:event_TreScriptsValueChanged
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ListarArquivos();
    }//GEN-LAST:event_formWindowOpened
    private void MnuNovoPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuNovoPersonagemActionPerformed
        javax.swing.JDialog FrmNovoScript = new FrmNovoScript(this, rootPaneCheckingEnabled);
        FrmNovoScript.setLocation(
            ((this.getWidth() - FrmNovoScript.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmNovoScript.getHeight()) / 2) + this.getY());
        FrmNovoScript.pack();
        FrmNovoScript.setModal(true);
        FrmNovoScript.setVisible(true);
    }//GEN-LAST:event_MnuNovoPersonagemActionPerformed
    private void MnuScriptExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuScriptExcluirActionPerformed
        Mensagem.showErro("Esse função ainda não foi implementada!", "Desculpe");
    }//GEN-LAST:event_MnuScriptExcluirActionPerformed
    private void MnuScriptAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuScriptAbrirActionPerformed
        javax.swing.JDialog frmJanela = null;
        if(
            TreScripts.getLeadSelectionPath().getPathCount()==4 && 
            TreScripts.getLeadSelectionPath().getPathComponent(3).toString().equals("_shops.txt")
        ){
            frmJanela = new FrmLojas(this, rootPaneCheckingEnabled);
        }else{
            frmJanela = new FrmPalco(this, rootPaneCheckingEnabled);
        }
        frmJanela.setLocation(
            ((this.getWidth() - frmJanela.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - frmJanela.getHeight()) / 2) + this.getY());
        frmJanela.pack();
        frmJanela.setModal(true);
        frmJanela.setVisible(true);
    }//GEN-LAST:event_MnuScriptAbrirActionPerformed
    private void MnuNovaLojistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuNovaLojistaActionPerformed
        if(
            TreScripts.getLeadSelectionPath().getPathCount()==3 &&
            TreScripts.getLeadSelectionPath().getPathComponent(1).toString().equals("Scripts")
        ){
            EnderecoDoScript = Base+Barra+PatasDoScript+Barra+"_shops.txt";
            String Import = Base+Barra+PatasDoScript+Barra+"_import.txt";
            int resposta=0;
            if(!Arquivamento.seExiste(EnderecoDoScript)){
                String Script=
                "///////////////////////////////////////////////////////////////////\n"+
                "//  IDE: TMW-Maker v"+FrmPrincipal.Config.getVersao()+"\n"+
                "//  MODIFICADO: "+ConfigClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+
                "//  UTILIDADES:\n"+
                "//    * Neste Arquivo ficarão todas as lojas que serão adicionadas\n"+
                "//      neste mapa atraves do TMW-Maker!\n"+
                "///////////////////////////////////////////////////////////////////\n"+
                "\n";
                if(Arquivamento.arquivoSalvar(EnderecoDoScript,Script)){
                    String Conteudo = Arquivamento.arquivoAbrir(Import);
                    if(!Conteudo.isEmpty() && !Conteudo.trim().equals("")){
                        int loc1 = Conteudo.indexOf("map: ");
                        if(loc1>=0){
                            int loc2 = Conteudo.indexOf("\n", loc1);
                            if(loc2>=0){
                                String Parte1= Conteudo.substring(0, loc2+1);
                                String Parte2= Conteudo.substring(loc2+1, Conteudo.length());
                                if(
                                    Arquivamento.arquivoSalvar(
                                        FrmScript.Base+Barra+FrmScript.PatasDoScript+Barra+"_import.txt",
                                        Parte1+
                                        "npc: npc/"+FrmScript.PatasDoScript+Barra+"_shops.txt\n"+
                                        Parte2
                                    )
                                ){
                                    String Comando="";
                                    Runtime Executador = Runtime.getRuntime();
                                    Process Retorno=null;
                                    String line="";
                                    try {
                                        Comando = "svn add "+EnderecoDoScript;/**/
                                        System.out.println(Comando);
                                        Retorno=Executador.exec(Comando);
                                        BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                        while ((line = in.readLine()) != null) {
                                            System.out.println(line);
                                            FrmPrincipal.setAvisoEmEstatus("<html>ENVIADO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                                        }
                                        FrmPrincipal.setAvisoEmEstatus("Arquivo Criado e Preparado para Compartilhar som Sucesso!");
                                        resposta=1;
                                    } catch (IOException e) {
                                        FrmPrincipal.setAvisoEmEstatus("<html>Falha ao preparar o compartilhamento de \"<font color=\"#FF0000\">_shops.txt</font>\"!");
                                        Mensagem.showErro("<html>" +
                                            "Falha ao preparar o compartilhamento de \"<font color=\"#FF0000\">_shops.txt</font>\"!<br/>"+
                                            " * Erro de execução de comando:<br/> " +
                                            " * <font color=\"#FF0000\"><b>"+Comando+"</b></font>!"
                                            , "ERRO"
                                        );
                                    }
                                    FrmScript.ListarArquivos();
                                    dispose();
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html>"+
                                        "<font color=\"#FF0000\">ERRO:</font> Ocorreu um erro ao alterar o arquivo \"<font color=\"#FF0000\">_import.txt</font>\"!"
                                    );
                                }
                            }
                        }else{
                            FrmPrincipal.setAvisoEmEstatus("<html>"+
                                "<font color=\"#FF0000\">ERRO:</font> Formato de conteúdo de \"<font color=\"#FF0000\">_import.txt</font>\" inválido!"
                            );
                        }
                    }else{
                        FrmPrincipal.setAvisoEmEstatus("<html>"+
                            "<font color=\"#FF0000\">ERRO:</font> O arquivo \"<font color=\"#FF0000\">_import.txt</font>\" está vazio!"
                        );
                    }
                }else{
                    FrmPrincipal.setAvisoEmEstatus("<html>"+
                        "<font color=\"#FF0000\">ERRO:</font> Ocorreu um erro ao criar o arquivo \"<font color=\"#FF0000\">_shops.txt</font>\"!"
                    );
                }
            }else{
                ImagemTratavel Icone = new ImagemTratavel("/Imagem/Botoes/sbl_carrinho.gif");
                Icone.setZoom(3.0);
                resposta = Mensagem.showOpcoes("<html>"+
                    "O arquivo que contém personagens Lojista já foi criado com sucesso.<br/>"+
                    "Deseja abrir o arquivo \"<font color=\"#0000FF\">_shops.txt</font>\"?",
                    "CRIAÇÃO DE ?ERSONAGEM LOJISTA",
                    Icone,
                    new Object[]{"SIM","NÃO"},
                    1
                );
            }
            if(resposta==1){
                javax.swing.JDialog frmJanela = null;
                frmJanela = new FrmLojas(this, rootPaneCheckingEnabled);

                frmJanela.setLocation(
                    ((this.getWidth() - frmJanela.getWidth()) / 2) + this.getX(),
                    ((this.getHeight() - frmJanela.getHeight()) / 2) + this.getY());
                frmJanela.pack();
                frmJanela.setModal(true);
                frmJanela.setVisible(true);
            }
        }else{
            FrmPrincipal.setAvisoEmEstatus("Selecione a pasta onde o lojista ficará!!");
        }
    }//GEN-LAST:event_MnuNovaLojistaActionPerformed
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
    private static javax.swing.JMenuItem MnuNovaLojista;
    private javax.swing.JMenu MnuNovo;
    private javax.swing.JMenuItem MnuNovoPersonagem;
    private javax.swing.JMenu MnuScript;
    private javax.swing.JMenuItem MnuScriptAbrir;
    private javax.swing.JMenuItem MnuScriptDesabilitar;
    private javax.swing.JMenuItem MnuScriptExcluir;
    private javax.swing.JMenuItem MnuScriptHabilitar;
    public static javax.swing.JTree TreScripts;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
