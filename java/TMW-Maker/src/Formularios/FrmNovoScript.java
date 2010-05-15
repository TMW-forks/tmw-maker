
package Formularios;

import java.awt.Color;
import java.io.File;
import javax.swing.DefaultComboBoxModel;


public class FrmNovoScript extends javax.swing.JDialog {
    static String Barra = System.getProperty("file.separator");
    static String PastaDeScripts = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"npc";
    static String PastaDeMapas = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"maps";
    public FrmNovoScript(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrpTipoDeArquivo = new javax.swing.ButtonGroup();
        GrpTipoDePasta = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        OptTipoFuncao = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        OptTipoScript = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        CmbPastaDeScript = new javax.swing.JComboBox();
        BtnFechar = new javax.swing.JButton();
        BtnCriar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        javax.swing.text.MaskFormatter MskNomeSimples = null;
        try{
            MskNomeSimples = new javax.swing.text.MaskFormatter("*****************************");
            MskNomeSimples.setValidCharacters(" _-()0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }catch(java.text.ParseException Erro){}
        TxtNomeSimplesArquivo = new javax.swing.JFormattedTextField(MskNomeSimples);
        OptPastaAntiga = new javax.swing.JRadioButton();
        OptPastaNova = new javax.swing.JRadioButton();
        try{
            MskNomeSimples = new javax.swing.text.MaskFormatter("*****************************");
            MskNomeSimples.setValidCharacters(" _-()0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }catch(java.text.ParseException Erro){}
        TxtNomeSimplesPasta = new javax.swing.JFormattedTextField(MskNomeSimples);
        ChkSeLigarAoMapa = new javax.swing.JCheckBox();
        CmbMapa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Script");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_script.png"))); // NOI18N
        jLabel1.setText("Nome do Script:");

        jLabel2.setText(".conf");

        GrpTipoDeArquivo.add(OptTipoFuncao);
        OptTipoFuncao.setSelected(true);
        OptTipoFuncao.setText("Função");

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        jLabel3.setText("Tipo de Script:");

        GrpTipoDeArquivo.add(OptTipoScript);
        OptTipoScript.setText("Personagem ou Objeto");
        OptTipoScript.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                OptTipoScriptStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        jLabel4.setText("Pasta do Script:");

        CmbPastaDeScript.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbPastaDeScript.setEnabled(false);
        CmbPastaDeScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbPastaDeScriptActionPerformed(evt);
            }
        });

        BtnFechar.setMnemonic('F');
        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        BtnCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_script.png"))); // NOI18N
        BtnCriar.setMnemonic('C');
        BtnCriar.setText("Criar");
        BtnCriar.setEnabled(false);

        TxtNomeSimplesArquivo.setFont(new java.awt.Font("Monospaced", 0, 14));
        TxtNomeSimplesArquivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtNomeSimplesArquivoFocusLost(evt);
            }
        });
        TxtNomeSimplesArquivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNomeSimplesArquivoKeyReleased(evt);
            }
        });

        GrpTipoDePasta.add(OptPastaAntiga);
        OptPastaAntiga.setSelected(true);
        OptPastaAntiga.setText("Antiga:");
        OptPastaAntiga.setEnabled(false);
        OptPastaAntiga.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                OptPastaAntigaStateChanged(evt);
            }
        });

        GrpTipoDePasta.add(OptPastaNova);
        OptPastaNova.setText("Nova:");
        OptPastaNova.setEnabled(false);
        OptPastaNova.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                OptPastaNovaStateChanged(evt);
            }
        });

        TxtNomeSimplesPasta.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveForeground"));
        TxtNomeSimplesPasta.setEnabled(false);
        TxtNomeSimplesPasta.setFont(new java.awt.Font("Monospaced", 0, 14));
        TxtNomeSimplesPasta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtNomeSimplesPastaFocusLost(evt);
            }
        });
        TxtNomeSimplesPasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNomeSimplesPastaKeyReleased(evt);
            }
        });

        ChkSeLigarAoMapa.setText("Ligar ao Mapa:");
        ChkSeLigarAoMapa.setEnabled(false);
        ChkSeLigarAoMapa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ChkSeLigarAoMapaStateChanged(evt);
            }
        });

        CmbMapa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbMapa.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnCriar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OptPastaAntiga)
                            .addComponent(OptPastaNova))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNomeSimplesPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CmbPastaDeScript, 0, 248, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ChkSeLigarAoMapa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CmbMapa, 0, 109, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OptTipoFuncao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(OptTipoScript))
                            .addComponent(TxtNomeSimplesArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCriar, BtnFechar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CmbPastaDeScript, TxtNomeSimplesPasta});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNomeSimplesArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptTipoScript)
                    .addComponent(OptTipoFuncao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptPastaAntiga)
                    .addComponent(CmbPastaDeScript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNomeSimplesPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptPastaNova))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(ChkSeLigarAoMapa)
                    .addComponent(CmbMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(BtnCriar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbPastaDeScript, TxtNomeSimplesArquivo, TxtNomeSimplesPasta, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnCriar, BtnFechar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
///////////////////////////////////////////////////////////////////////////////////////////////////
        String Pasta[] = FrmPrincipal.Config.ListarPastas(PastaDeScripts);
        String PastaDeScript[] = new String[Pasta.length];
        //Object[] TituloDeBloco= new java.lang.Object[blocos];
        int ContPastas=0;
        for(int p=0; p<Pasta.length; p++){
            if(!Pasta[p].equals(".svn") && !Pasta[p].equals("functions")){
                ContPastas++;
                PastaDeScript[ContPastas-1]=Pasta[p];

            }
        }
        Object[] TituloDePasta= new java.lang.Object[ContPastas];
        for(int p=0; p<ContPastas; p++){
            TituloDePasta[p]=PastaDeScript[p];
            if(p==0) TxtNomeSimplesPasta.setText(PastaDeScript[p]+"(Copia)");
        }
        if(ContPastas>=1) CmbPastaDeScript.setModel(new DefaultComboBoxModel(TituloDePasta));

///////////////////////////////////////////////////////////////////////////////////////////////////
        String Arquivo[] = FrmPrincipal.Config.ListarArquivos(PastaDeMapas);
        String ArquivoDeMapas[] = new String[Arquivo.length];
        //Object[] Mapa= new java.lang.Object[Arquivo.length];
        int ContMapas=0;
        for(int a=0; a<Arquivo.length; a++){
            if(Arquivo[a].indexOf(".tmx")>=0){
                ContMapas++;
                ArquivoDeMapas[ContMapas-1]=Arquivo[a];

            }
        }
        Object[] TituloDeMapa= new java.lang.Object[ContMapas];
        for(int m=0; m<ContMapas; m++){
            TituloDeMapa[m]=ArquivoDeMapas[m];
        }
        if(ContMapas>=1) CmbMapa.setModel(new DefaultComboBoxModel(TituloDeMapa));
///////////////////////////////////////////////////////////////////////////////////////////////////
        AtivarComponente();
    }//GEN-LAST:event_formWindowOpened
    private void OptTipoScriptStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_OptTipoScriptStateChanged
        AtivarComponente();
        ValidarNomeDeScript();
    }//GEN-LAST:event_OptTipoScriptStateChanged
    private void TxtNomeSimplesArquivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNomeSimplesArquivoKeyReleased
        ValidarNomeDeScript();
    }//GEN-LAST:event_TxtNomeSimplesArquivoKeyReleased
    private void TxtNomeSimplesArquivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtNomeSimplesArquivoFocusLost
        String Nome=TxtNomeSimplesArquivo.getText();
        Nome = Nome.replace(" ", "");
        TxtNomeSimplesArquivo.setText(Nome);
    }//GEN-LAST:event_TxtNomeSimplesArquivoFocusLost
    private void TxtNomeSimplesPastaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtNomeSimplesPastaFocusLost
        String Nome=TxtNomeSimplesPasta.getText();
        Nome = Nome.replace(" ", "");
        TxtNomeSimplesPasta.setText(Nome);
    }//GEN-LAST:event_TxtNomeSimplesPastaFocusLost
    private void TxtNomeSimplesPastaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNomeSimplesPastaKeyReleased
        ValidarNomeDeScript();
    }//GEN-LAST:event_TxtNomeSimplesPastaKeyReleased
    private void OptPastaAntigaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_OptPastaAntigaStateChanged
        AtivarComponente();
    }//GEN-LAST:event_OptPastaAntigaStateChanged
    private void OptPastaNovaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_OptPastaNovaStateChanged
        AtivarComponente();
        ValidarNomeDeScript();
    }//GEN-LAST:event_OptPastaNovaStateChanged
    private void ChkSeLigarAoMapaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ChkSeLigarAoMapaStateChanged
        AtivarComponente();
    }//GEN-LAST:event_ChkSeLigarAoMapaStateChanged

    private void CmbPastaDeScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbPastaDeScriptActionPerformed
        String Item=CmbPastaDeScript.getItemAt(CmbPastaDeScript.getSelectedIndex()).toString().trim();
        TxtNomeSimplesPasta.setText(Item+"(Copia)");
        ValidarNomeDeScript();
    }//GEN-LAST:event_CmbPastaDeScriptActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmNovoScript dialog = new FrmNovoScript(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton BtnCriar;
    private javax.swing.JButton BtnFechar;
    private javax.swing.JCheckBox ChkSeLigarAoMapa;
    private javax.swing.JComboBox CmbMapa;
    private javax.swing.JComboBox CmbPastaDeScript;
    private javax.swing.ButtonGroup GrpTipoDeArquivo;
    private javax.swing.ButtonGroup GrpTipoDePasta;
    private javax.swing.JRadioButton OptPastaAntiga;
    private javax.swing.JRadioButton OptPastaNova;
    private javax.swing.JRadioButton OptTipoFuncao;
    private javax.swing.JRadioButton OptTipoScript;
    private javax.swing.JFormattedTextField TxtNomeSimplesArquivo;
    private javax.swing.JFormattedTextField TxtNomeSimplesPasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void AtivarComponente() {
        OptPastaAntiga.setEnabled(OptTipoScript.isSelected());
        OptPastaNova.setEnabled(OptTipoScript.isSelected());
        CmbPastaDeScript.setEnabled((OptTipoScript.isSelected() && OptPastaAntiga.isSelected()));
        CmbPastaDeScript.setBackground(CmbPastaDeScript.isEnabled()?java.awt.SystemColor.text:java.awt.SystemColor.window);
        TxtNomeSimplesPasta.setEnabled((OptTipoScript.isSelected() && OptPastaNova.isSelected()));
        TxtNomeSimplesPasta.setBackground(TxtNomeSimplesPasta.isEnabled()?java.awt.SystemColor.text:java.awt.SystemColor.window);
        ChkSeLigarAoMapa.setEnabled(OptPastaNova.isSelected() && OptPastaNova.isEnabled());
        CmbMapa.setEnabled(ChkSeLigarAoMapa.isSelected() && ChkSeLigarAoMapa.isEnabled());
        CmbMapa.setBackground(CmbMapa.isEnabled()?java.awt.SystemColor.text:java.awt.SystemColor.window);
    }
    private void ValidarNomeDeScript() {
        if(!TxtNomeSimplesArquivo.getText().equals("")){
            //String Editado=CmbPastaDeScript.getEditor().getItem().toString();
            String PastaDeTeste="";
            if(OptTipoScript.isSelected()){
                if(OptPastaAntiga.isSelected()){
                    PastaDeTeste=PastaDeScripts+Barra+CmbPastaDeScript.getItemAt(CmbPastaDeScript.getSelectedIndex()).toString();
                }else{
                    PastaDeTeste=PastaDeScripts+Barra+TxtNomeSimplesPasta.getText().trim();
                    if(!FrmPrincipal.Config.SeExiste(PastaDeTeste)){
                        TxtNomeSimplesPasta.setForeground(java.awt.SystemColor.textText);
                    }else{
                        TxtNomeSimplesPasta.setForeground(Color.red);
                        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Não é possivel criar uma pasta nova com o mesmo nome de uma pasta antiga!");
                    }
                }
            }else{
                PastaDeTeste=PastaDeScripts+Barra+"functions";
            }
            if(FrmPrincipal.Config.SeExiste(PastaDeTeste)){
                String EndereçoDeArquivo=PastaDeTeste+Barra+TxtNomeSimplesArquivo.getText().trim()+".conf";
                if(!FrmPrincipal.Config.SeExiste(EndereçoDeArquivo)){
                    try{
                        File Capsula = new File(EndereçoDeArquivo);
                        boolean SeNomeValido = Capsula.createNewFile();
                        if(SeNomeValido){
                            Capsula.delete(); //Apagar o arquivo porque é criado para a verificação de validação
                            TxtNomeSimplesArquivo.setForeground(java.awt.SystemColor.textText);
                            FrmPrincipal.setAvisoEmEstatus("");
                            if(OptTipoScript.isSelected()){
                                if(!OptPastaAntiga.isSelected()){
                                   if(!FrmPrincipal.Config.SeExiste(PastaDeTeste)){
                                        TxtNomeSimplesPasta.setForeground(java.awt.SystemColor.textText);
                                    }else{
                                        TxtNomeSimplesPasta.setForeground(Color.red);
                                        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Não é possivel criar uma pasta nova com o mesmo nome de uma pasta antiga!");
                                    }
                                }
                            }
                        }else{
                            TxtNomeSimplesArquivo.setForeground(Color.red);
                            FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Não é possivel criar um arquivo de script novo em uma área somente de leitura!");
                        }
                    }catch(Exception Erro){
                        TxtNomeSimplesArquivo.setForeground(Color.red);
                        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO INESPERADO...</font>");
                    }
                }else{
                    TxtNomeSimplesArquivo.setForeground(Color.red);
                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Não é possivel criar um arquivo de script novo como o mesmo nome e local de um arquivo de script antigo!");
                }
            }else{
                TxtNomeSimplesPasta.setForeground(java.awt.SystemColor.textText);
                TxtNomeSimplesArquivo.setForeground(java.awt.SystemColor.textText);
                FrmPrincipal.setAvisoEmEstatus("");
            }
        }
    }

}
