
package Formularios;

import Classes.FileClass;
import Classes.ConfigClass;
import Classes.DialogClass;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrmNovoScript extends javax.swing.JDialog {
    static String Barra = System.getProperty("file.separator");
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
        BtnFechar = new javax.swing.JButton();
        BtnCriar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        javax.swing.text.MaskFormatter MskNomeSimples = null;
        try{
            MskNomeSimples = new javax.swing.text.MaskFormatter("*****************************");
            MskNomeSimples.setValidCharacters(" _-()0123456789abcdefghijklmnopqrstuvwxyz");
        }catch(java.text.ParseException Erro){}
        TxtNomeSimplesArquivo = new javax.swing.JFormattedTextField(MskNomeSimples);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Script");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_script.png"))); // NOI18N
        jLabel1.setText("Nome do Script:");

        jLabel2.setText(".conf");

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
        BtnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCriarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnCriar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar))
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TxtNomeSimplesArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCriar, BtnFechar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNomeSimplesArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(BtnCriar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TxtNomeSimplesArquivo, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnCriar, BtnFechar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed
    private void TxtNomeSimplesArquivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNomeSimplesArquivoKeyReleased
        BtnCriar.setEnabled(
            !TxtNomeSimplesArquivo.getText().trim().equals("") &&
            !FileClass.seExiste(FrmScript.Base+Barra+FrmScript.PatasDoScript+Barra+TxtNomeSimplesArquivo.getText().trim()+".conf")
        );
        if(!TxtNomeSimplesArquivo.getText().trim().equals("")){
            if(!FileClass.seExiste(FrmScript.Base+Barra+FrmScript.PatasDoScript+Barra+TxtNomeSimplesArquivo.getText().trim()+".conf")){
                TxtNomeSimplesArquivo.setForeground(java.awt.SystemColor.textText);
                FrmPrincipal.setAvisoEmEstatus("<html>Pressione o botão \"<font color=\"#0000FF\">Criar</font>\" para gerar o arquivo no novo Scripr existente!");
            }else{
                TxtNomeSimplesArquivo.setForeground(Color.red);
                FrmPrincipal.setAvisoEmEstatus("<html>"+
                    "<font color=\"#FF0000\">AVISO:</font> Não é possivel criar novo arquivo como nome de um arquivo igual ao já existente!"
                );
            }
        }else{
            TxtNomeSimplesArquivo.setForeground(java.awt.SystemColor.textText);
            FrmPrincipal.setAvisoEmEstatus("Preencha o nome do novo Script!");
        }
    }//GEN-LAST:event_TxtNomeSimplesArquivoKeyReleased
    private void TxtNomeSimplesArquivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtNomeSimplesArquivoFocusLost
        String Nome=TxtNomeSimplesArquivo.getText();
        Nome = Nome.replace(" ", "");
        TxtNomeSimplesArquivo.setText(Nome);
    }//GEN-LAST:event_TxtNomeSimplesArquivoFocusLost
    private void BtnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCriarActionPerformed
        if(!TxtNomeSimplesArquivo.getText().trim().equals("")){
            if(!FileClass.seExiste(FrmScript.Base+Barra+FrmScript.PatasDoScript+Barra+TxtNomeSimplesArquivo.getText().trim()+".conf")){
                String Script=
                "///////////////////////////////////////////////////////////////////\n"+
                "//  IDE: TMW-Maker v"+FrmPrincipal.Config.getVersao()+"\n"+
                "//  MODIFICADO: "+ConfigClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+
                "//  UTILIDADES:\n"+
                "//    * Neste Arquivo ficarão Scripts de Pensonagens e de Funções\n"+
                "//      que serão editadas atraves do TMW-Maker!\n"+
                "///////////////////////////////////////////////////////////////////\n"+
                "\n";
                if(FileClass.arquivoSalvar(FrmScript.Base+Barra+FrmScript.PatasDoScript+Barra+TxtNomeSimplesArquivo.getText().trim()+".conf","")){
                    String Conteudo = FileClass.arquivoAbrir(FrmScript.Base+Barra+FrmScript.PatasDoScript+Barra+"_import.txt");
                    if(!Conteudo.isEmpty() && !Conteudo.trim().equals("")){
                        int loc1 = Conteudo.indexOf("map: ");
                        if(loc1>=0){
                            int loc2 = Conteudo.indexOf("\n", loc1);
                            if(loc2>=0){
                                String Parte1= Conteudo.substring(0, loc2+1);
                                String Parte2= Conteudo.substring(loc2+1, Conteudo.length());
                                if(
                                    FileClass.arquivoSalvar(
                                        FrmScript.Base+Barra+FrmScript.PatasDoScript+Barra+"_import.txt",
                                        Parte1+
                                        "npc: npc/"+FrmScript.PatasDoScript+Barra+TxtNomeSimplesArquivo.getText().trim()+".conf\n"+
                                        Parte2
                                    )
                                ){
                                    String Comando="";
                                    Runtime Executador = Runtime.getRuntime();
                                    Process Retorno=null;
                                    String line="";
                                    try {
                                        Comando = "svn add "+FrmScript.Base+Barra+FrmScript.PatasDoScript+Barra+TxtNomeSimplesArquivo.getText().trim()+".conf";/**/
                                        System.out.println(Comando);
                                        Retorno=Executador.exec(Comando);
                                        BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                        while ((line = in.readLine()) != null) {
                                            System.out.println(line);
                                            FrmPrincipal.setAvisoEmEstatus("<html>ENVIADO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                                        }
                                        FrmPrincipal.setAvisoEmEstatus("Arquivo Criado e Preparado para Compartilhar som Sucesso!");
                                    } catch (IOException e) {
                                        FrmPrincipal.setAvisoEmEstatus("<html>Falha ao preparar o compartilhamento de \"<font color=\"#FF0000\">"+TxtNomeSimplesArquivo.getText().trim()+".conf</font>\"!");
                                        DialogClass.showErro("<html>" +
                                            "Falha ao preparar o compartilhamento de \"<font color=\"#FF0000\">"+TxtNomeSimplesArquivo.getText().trim()+".conf</font>\"!<br/>"+
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
                        "<font color=\"#FF0000\">ERRO:</font> Ocorreu um erro ao criar o arquivo \"<font color=\"#FF0000\">"+TxtNomeSimplesArquivo.getText().trim()+"</font>\"!"
                    );
                }
            }else{
                TxtNomeSimplesArquivo.setForeground(Color.red);
                FrmPrincipal.setAvisoEmEstatus("<html>"+
                    "<font color=\"#FF0000\">AVISO:</font> Não é possivel criar novo arquivo como nome de um arquivo igual ao já existente!"
                );
            }
        }else{
            FrmPrincipal.setAvisoEmEstatus("Preencha o nome do novo Script!");
        }
    }//GEN-LAST:event_BtnCriarActionPerformed

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
    private javax.swing.ButtonGroup GrpTipoDeArquivo;
    private javax.swing.ButtonGroup GrpTipoDePasta;
    private javax.swing.JFormattedTextField TxtNomeSimplesArquivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
