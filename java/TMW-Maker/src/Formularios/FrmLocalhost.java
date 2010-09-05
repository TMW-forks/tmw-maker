
package Formularios;

import Classes.Arquivamento;
import Classes.ConfigClass;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;


public class FrmLocalhost extends javax.swing.JDialog {
    public FrmLocalhost(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TxtEstatus = new javax.swing.JTextArea();
        ChkForcar = new javax.swing.JCheckBox();
        BtnFechar = new javax.swing.JButton();
        BtnBaixar = new javax.swing.JButton();
        BtnMontar = new javax.swing.JButton();
        BtnCompartilhar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Localhost Supervisionado");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        TxtEstatus.setBackground(new java.awt.Color(0, 104, 14));
        TxtEstatus.setColumns(20);
        TxtEstatus.setEditable(false);
        TxtEstatus.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 14));
        TxtEstatus.setForeground(java.awt.Color.white);
        TxtEstatus.setRows(5);
        TxtEstatus.setWrapStyleWord(true);
        TxtEstatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        TxtEstatus.setFocusCycleRoot(true);
        jScrollPane1.setViewportView(TxtEstatus);

        ChkForcar.setMnemonic('F');
        ChkForcar.setText("Forçar");

        BtnFechar.setMnemonic('F');
        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        BtnBaixar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_download.gif"))); // NOI18N
        BtnBaixar.setMnemonic('B');
        BtnBaixar.setText("Baixar");
        BtnBaixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBaixarActionPerformed(evt);
            }
        });

        BtnMontar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))); // NOI18N
        BtnMontar.setMnemonic('M');
        BtnMontar.setText("Montar");
        BtnMontar.setEnabled(false);

        BtnCompartilhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_upload.gif"))); // NOI18N
        BtnCompartilhar.setMnemonic('C');
        BtnCompartilhar.setText("Compartilhar");
        BtnCompartilhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCompartilharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ChkForcar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addComponent(BtnBaixar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCompartilhar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnMontar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnBaixar, BtnFechar, BtnMontar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(ChkForcar)
                    .addComponent(BtnMontar)
                    .addComponent(BtnCompartilhar)
                    .addComponent(BtnBaixar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnBaixar, BtnFechar, BtnMontar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBaixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBaixarActionPerformed
        LocalhostReceber();
    }//GEN-LAST:event_BtnBaixarActionPerformed
    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //setTitle("svn checkout "+FrmPrincipal.Config.getConexaoRepositorio());
        //BtnCompartilhar.setEnabled(FrmPrincipal.Config.getSeDependenciaDeMontagem());
        if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
            BtnBaixar.setMnemonic('A');
            BtnBaixar.setText("Atualizar");
        }else{
            BtnBaixar.setMnemonic('B');
            BtnBaixar.setText("Baixar");
        }
    }//GEN-LAST:event_formWindowActivated
    private void BtnCompartilharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCompartilharActionPerformed
        LocalhostCompartilhar();
    }//GEN-LAST:event_BtnCompartilharActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmLocalhost dialog = new FrmLocalhost(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBaixar;
    private javax.swing.JButton BtnCompartilhar;
    private javax.swing.JButton BtnFechar;
    private javax.swing.JButton BtnMontar;
    private javax.swing.JCheckBox ChkForcar;
    private javax.swing.JTextArea TxtEstatus;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    static String Barra = System.getProperty("file.separator");

    private void addLinhaDeEstatus(String Linha) {
        TxtEstatus.setText(TxtEstatus.getText()+"\n"+Linha);
        TxtEstatus.setSelectionStart(TxtEstatus.getText().length()-1);
        TxtEstatus.setSelectionEnd(TxtEstatus.getText().length()-1);
    }
    private void LocalhostReceber() {
        int R = JOptionPane.NO_OPTION;
        if(ChkForcar.isSelected()){
            Object[] options = {"Sobrescrever", "Cancelar"};
            R = JOptionPane.showOptionDialog(
                null,
                "<html>Baixar forçado <font color=\"#FF0000\">sobrescreverá todos os seus trabalhos</font> em \""+FrmPrincipal.Config.getConexaoLocalhost()+"\".<br/>"+
                "Tem certeza que deseja baixar forçado?",
                "BAIXAR FORÇADO?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
            );
        }
        if (R == JOptionPane.YES_OPTION || !ChkForcar.isSelected()) {
            String SistemaOperacional = System.getProperty("os.name").toLowerCase();
            if (SistemaOperacional.indexOf("win") >= 0) {
                ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o WINDOWS!","Descupe!");
            } else if (SistemaOperacional.indexOf("mac") >= 0) {
                /*Executador.exec("open " + URL);/**/
                ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!","Descupe!");
            } else {
                Thread tThread = new Thread(new Runnable() {
                    public void run() {
                        boolean SeConclui=false;
                        Runtime Executador = Runtime.getRuntime();
                        String line="", Partes[];
                        String Comando ="";
                        int Arquivos=0;
                        int R = JOptionPane.YES_OPTION;

                        FrmPrincipal.PgbBarra.setEnabled(true);
                        BtnBaixar.setEnabled(false);
                        BtnCompartilhar.setEnabled(false);
                        BtnMontar.setEnabled(false);
                        BtnFechar.setEnabled(false);
                        ChkForcar.setEnabled(false);

                        Partes = FrmPrincipal.Config.getConexaoRepositorio().split(":");
                        if(Partes.length>1 && Partes[0].toLowerCase().equals("http")){
                            Object[] options = {"Somente Leitura", "Cancelar"};

                            R = JOptionPane.showOptionDialog(
                                null,
                                "<html>Você está tentando baixar o repositório sem identificar <font color=\"#FF0000\">Usuário</font> e <font color=\"#FF0000\">Senha</font> nas configurações.<br/>"+
                                "Posteriormente não será possível enviar suas alteração ao repositório.<br/>"+
                                "Tem certeza que deseja fazer uma <font color=\"#FF0000\">Cópia somente de leitura</font> do repositório?",
                                "CÓPIA SOMENTE LEITURA?",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]
                            );
                        }

                        if (R == JOptionPane.YES_OPTION) {
                            FrmPrincipal.PgbBarra.setIndeterminate(true);
                            FrmPrincipal.PgbBarra.setString("Preparando...");
                            TxtEstatus.setText("Preparando para baixar...");
                            FrmPrincipal.setAvisoEmEstatus("Preparando para baixar...");
                            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            // operacao demorada


                            Comando ="svn checkout "+FrmPrincipal.Config.getConexaoRepositorio()+" "+FrmPrincipal.Config.getConexaoLocalhost();
                            if(ChkForcar.isSelected()){Comando+=" --force";}
                            TxtEstatus.setText(TxtEstatus.getText()+"\n     "+Comando);
                            if(Partes.length>1 && Partes[0].toLowerCase().equals("https") && !FrmPrincipal.Config.getConexaoUsuario().equals("") && !FrmPrincipal.Config.getConexaoSenha().equals("")){
                                Comando+=" --username "+FrmPrincipal.Config.getConexaoUsuario()+" --password "+FrmPrincipal.Config.getConexaoSenha();
                            }

                            try {
                                Process Retorno=Executador.exec(Comando);
                                BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                while ((line = in.readLine()) != null) {
                                    line=line.replaceAll(FrmPrincipal.Config.getConexaoLocalhost()+Barra, "");
                                    System.out.println(line);
                                    FrmPrincipal.setAvisoEmEstatus("<html>BAIXANDO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                                    Arquivos++;
                                    FrmPrincipal.PgbBarra.setString("nº"+Arquivos);
                                    TxtEstatus.setText(TxtEstatus.getText()+"\n     "+Arquivos+": "+line);
                                    //Partes=line.split("/");
                                    //FrmPrincipal.PgbBarra.setString(Partes[Partes.length-1]);
                                }
                                //ConfigClass.Mensagem_Erro("Repositório \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" recebido com sucesso!", "AVISO");
                                FrmPrincipal.setAvisoEmEstatus("<html>Repositório \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" recebido com sucesso!");
                                TxtEstatus.setText(TxtEstatus.getText()+"\nRepositório \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" recebido com sucesso!");
                                FrmPrincipal.PgbBarra.setString("Concluido!");
                                FrmPrincipal.Config.setAtualizacaoLocalhostUltimaAgora();
                                FrmPrincipal.Config.ConfiguracoesGravar();

                                if(!FrmPrincipal.Config.getSeDependenciaDeMontagem()){
                                    R = JOptionPane.YES_OPTION;
                                    Object[] options = {"Montar", "Cancelar"};
                                    R = JOptionPane.showOptionDialog(
                                        null, "<html>" +
                                        "O seu localhost não funcionará enquanto não for montado.<br/>" +
                                        "Deseja que o tmw-maker monte o seu localhost?",
                                        "MONTAR LOCALHOST",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        options,
                                        options[1]
                                    );
                                    if(R == JOptionPane.YES_OPTION) LocalhostMontar();
                                }
                            } catch (IOException e) {
                                TxtEstatus.setText(TxtEstatus.getText()+"\nFalha ao receber o repositório \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!");
                                //ConfigClass.Mensagem_Erro("<html><font color=\"#FF0000\">Falha ao receber o repositório \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!", "ERRO");
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">Falha ao receber o repositório \"<b>"+FrmPrincipal.Config.getConexaoUsuario()+"</b>\"!");
                                FrmPrincipal.PgbBarra.setString("ERRO!");
                            }/**/
                            FrmPrincipal.PgbBarra.setIndeterminate(false);
                            BtnBaixar.setEnabled(true);
                            BtnCompartilhar.setEnabled(true);
                            if(FrmPrincipal.Config.getSeDependenciaDeLocalhost() && !FrmPrincipal.Config.getSeDependenciaDeMontagem()) BtnMontar.setEnabled(true);
                            BtnFechar.setEnabled(true);
                            ChkForcar.setEnabled(true);
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        }
                    }
                });
                tThread.start();
            }
        }
    }
    private void LocalhostMontar() {
    if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
        ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o windows!", "Descupe!");
    } else if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
        ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
    } else if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {
        int R = JOptionPane.YES_OPTION;
        if(FrmPrincipal.Config.getSeDependenciaDeGCC()){
            if (Arquivamento.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "char-server") ||
                Arquivamento.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "login-server") ||
                Arquivamento.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "map-server")) {
                Object[] options = {"Remontar", "Cancelar"};
                R = JOptionPane.showOptionDialog(
                    null, "<html>" +
                    "O seu localhost já está montado. Ao remontar você<br/>" +
                    "<font color=\"#FF0000\">pederá todas as contas</font> de jogadores deste localhost.<br/>" +
                    "Deseja realmente forçar uma remontagem?",
                    "REMONTAGEM DE LOCALHOST",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]
                );
            }
            if (R == JOptionPane.YES_OPTION) {
                Thread tThread = new Thread(new Runnable() {
                    public void run() {
                        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        BtnBaixar.setEnabled(false);
                        BtnCompartilhar.setEnabled(false);
                        BtnMontar.setEnabled(false);
                        BtnFechar.setEnabled(false);
                        ChkForcar.setEnabled(false);
                        FrmPrincipal.PgbBarra.setValue(0);


                        Runtime Executador = Runtime.getRuntime();
                        String line = "", Comando = "";
                        String OS = System.getProperty("os.name").toLowerCase();
                        String Arch = System.getProperty("os.arch").toLowerCase();
                        boolean BinariosEspecificos = false;
                        int Baixados = 0;

                        FrmPrincipal.PgbBarra.setIndeterminate(true);
                        FrmPrincipal.PgbBarra.setString("Apagando...");
                        FrmPrincipal.setAvisoEmEstatus("Apagando binários...");
                        addLinhaDeEstatus("Apagando binários...");
                        if (Arquivamento.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins")) {
                            Arquivamento.Apagar(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins");
                        }
                        Arquivamento.Apagar(FrmPrincipal.Config.getEathenaData() +Barra+ "char-server");
                        Arquivamento.Apagar(FrmPrincipal.Config.getEathenaData() +Barra+ "login-server");
                        Arquivamento.Apagar(FrmPrincipal.Config.getEathenaData() +Barra+ "map-server");

                        FrmPrincipal.PgbBarra.setString("Abaixando...");
                        FrmPrincipal.setAvisoEmEstatus("Baixando binários novos...");
                        addLinhaDeEstatus("Baixando binários novos...");
                        if (OS.indexOf("linux") >= 0 && Arch.indexOf("i386") >= 0) {
                            Comando = "svn checkout " +
                                    "http://tmw-maker.googlecode.com/svn/bins/" + OS + "/" + Arch + " " +
                                    FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins";
                            BinariosEspecificos = true;
                            System.out.println(Comando);
                            //ConfigClass.Mensagem_Erro(Comando,"Nota de Programador");
                        } else {
                            Comando = "svn checkout " +
                                    "http://tmw-maker.googlecode.com/svn/bins/compiler " +
                                    FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins";
                            addLinhaDeEstatus("svn checkout http://tmw-maker.googlecode.com/svn/bins/compiler ");
                            BinariosEspecificos = false;
                            System.out.println(Comando);
                            //ConfigClass.Mensagem_Erro(Comando,"Nota de Programador");
                        }
                        try {
                            Process Retorno = Executador.exec(Comando);
                            BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                            while ((line = in.readLine()) != null) {
                                System.out.println(line);
                                Baixados++;
                                FrmPrincipal.setAvisoEmEstatus("<html>" + line + " (<font color=\"#FF0000\">Espere concluir...</font>)");
                                addLinhaDeEstatus("     "+line + " (Espere concluir...)");
                                FrmPrincipal.PgbBarra.setString("Baixando nº" + Baixados + "...");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            addLinhaDeEstatus("ERRO: "+Comando);
                            FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                            ConfigClass.Mensagem_Erro(
                                "<html><b>O TMW-Maker não conseguiu baixar os binários:</b><br/><br/>" +
                                "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                "</html>",
                                "ERRO DE EXECUÇÃO"
                            );
                            FrmPrincipal.PgbBarra.setIndeterminate(false);
                            BtnBaixar.setEnabled(true);
                            BtnCompartilhar.setEnabled(true);
                            BtnMontar.setEnabled(true);
                            BtnFechar.setEnabled(true);
                            ChkForcar.setEnabled(true);
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            return;
                        }
                        if (BinariosEspecificos == true) {
                            FrmPrincipal.PgbBarra.setString("Deslocando...");
                            if (!Arquivamento.SeExiste(FrmPrincipal.Config.getEathenaData()+Barra+"char-server")) {
                                Arquivamento.MoverArquivo(
                                        FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"char-server",
                                        FrmPrincipal.Config.getEathenaData()+Barra+"char-server");
                                FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">char-server</font>...");
                                addLinhaDeEstatus("     Deslocando char-server...");
                            }else{
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">char-server</font>\"!");
                                addLinhaDeEstatus("ERRO: Falha ao deslocar \"char-server\"!");
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnBaixar.setEnabled(true);
                                BtnCompartilhar.setEnabled(true);
                                BtnMontar.setEnabled(true);
                                BtnFechar.setEnabled(true);
                                ChkForcar.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }
                            if (!Arquivamento.SeExiste(FrmPrincipal.Config.getEathenaData()+Barra+"login-server")) {
                                Arquivamento.MoverArquivo(
                                        FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"login-server",
                                        FrmPrincipal.Config.getEathenaData()+Barra+"login-server");
                                FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">login-server</font>...");
                                addLinhaDeEstatus("     Deslocando login-server...");
                            }else{
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">login-server</font>\"!");
                                addLinhaDeEstatus("ERRO: Falha ao deslocar \"login-server\"!");
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnBaixar.setEnabled(true);
                                BtnCompartilhar.setEnabled(true);
                                BtnMontar.setEnabled(true);
                                BtnFechar.setEnabled(true);
                                ChkForcar.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }
                            if (!Arquivamento.SeExiste(FrmPrincipal.Config.getEathenaData()+Barra+"map-server")) {
                                Arquivamento.MoverArquivo(
                                        FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins"+Barra+"map-server",
                                        FrmPrincipal.Config.getEathenaData()+Barra+"map-server");
                                FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">map-server</font>...");
                                addLinhaDeEstatus("     Deslocando map-server...");
                            }else{
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">map-server</font>\"!");
                                addLinhaDeEstatus("ERRO: Falha ao deslocar \"map-server\"!");
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnBaixar.setEnabled(true);
                                BtnCompartilhar.setEnabled(true);
                                BtnMontar.setEnabled(true);
                                BtnFechar.setEnabled(true);
                                ChkForcar.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }
                        } else {
                            //Desconpactar para usar
                            FrmPrincipal.PgbBarra.setString("Descompactando...");
                            FrmPrincipal.setAvisoEmEstatus("Descompactando \"eathena.zip\"...");
                            addLinhaDeEstatus("     Descompactando \"eathena.zip\"...");
                            FrmPrincipal.Config.Descompactar(
                                FrmPrincipal.Config.getConexaoLocalhost()+Barra+ "bins"+Barra+ "eathena.zip",
                                FrmPrincipal.Config.getConexaoLocalhost()+Barra+ "bins"
                            );/**/

                            FrmPrincipal.PgbBarra.setString("Deslocando...");

                            if (!Arquivamento.SeExiste(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "char-server")) {
                                Arquivamento.MoverArquivo(
                                        FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "char-server",
                                        FrmPrincipal.Config.getEathenaData()+Barra+"char-server");
                                FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">char-server</font>...");
                                addLinhaDeEstatus("     Deslocando char-server...");
                            }else{
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">char-server</font>\"!");
                                addLinhaDeEstatus("ERRO: Falha ao deslocar \"char-server\"!");
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnBaixar.setEnabled(true);
                                BtnCompartilhar.setEnabled(true);
                                BtnMontar.setEnabled(true);
                                BtnFechar.setEnabled(true);
                                ChkForcar.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }
                            if (!Arquivamento.SeExiste(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "login-server")) {
                                Arquivamento.MoverArquivo(
                                        FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "login-server",
                                        FrmPrincipal.Config.getEathenaData()+Barra+"login-server");
                                FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">login-server</font>...");
                                addLinhaDeEstatus("     Deslocando login-server...");
                            }else{
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">login-server</font>\"!");
                                addLinhaDeEstatus("ERRO: Falha ao deslocar \"login-server\"!");
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnBaixar.setEnabled(true);
                                BtnCompartilhar.setEnabled(true);
                                BtnMontar.setEnabled(true);
                                BtnFechar.setEnabled(true);
                                ChkForcar.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }
                            if (!Arquivamento.SeExiste(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "map-server")) {
                                Arquivamento.MoverArquivo(
                                        FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "map-server",
                                        FrmPrincipal.Config.getEathenaData()+Barra+"map-server");
                                FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">map-server</font>...");
                                addLinhaDeEstatus("     Deslocando map-server...");
                            }else{
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">map-server</font>\"!");
                                addLinhaDeEstatus("ERRO: Falha ao deslocar \"map-server\"!");
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnBaixar.setEnabled(true);
                                BtnCompartilhar.setEnabled(true);
                                BtnMontar.setEnabled(true);
                                BtnFechar.setEnabled(true);
                                ChkForcar.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }


                            FrmPrincipal.setAvisoEmEstatus("PARADA FORÇADA...");
                            addLinhaDeEstatus("PARADA FORÇADA...");
                            FrmPrincipal.PgbBarra.setString("BLOQUEIO!!!");
                            FrmPrincipal.PgbBarra.setIndeterminate(false);
                            BtnBaixar.setEnabled(true);
                            BtnCompartilhar.setEnabled(true);
                            BtnMontar.setEnabled(true);
                            BtnFechar.setEnabled(true);
                            ChkForcar.setEnabled(true);
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            return;
                        }
                        addLinhaDeEstatus("Renomeando banco de dados...");
                        FrmPrincipal.setAvisoEmEstatus("Renomeando banco de dados...");
                        FrmPrincipal.PgbBarra.setString("Renomeando...");
                        String Pasta[] = new String[]{
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "conf",
                            FrmPrincipal.Config.getEathenaData()  +Barra+ "save"
                        };
                        String De[] = new String[]{
                            "atcommand_local.conf.example",
                            "battle_local.conf.example",
                            "char_local.conf.example",
                            "eathena-monitor.conf.example",
                            "gm_account.txt.example",
                            "help.txt.example",
                            "ladmin_local.conf.example",
                            "login_local.conf.example",
                            "map_local.conf.example",
                            "motd.txt.example",
                            "account.txt.example"
                        };
                        String Para[] = new String[]{
                            "atcommand_local.conf",
                            "battle_local.conf",
                            "char_local.conf",
                            "eathena-monitor.conf",
                            "gm_account.txt",
                            "help.txt",
                            "ladmin_local.conf",
                            "login_local.conf",
                            "map_local.conf",
                            "motd.txt",
                            "account.txt"
                        };

                        for (int r = 0; r < De.length; r++) {
                            if (Arquivamento.SeExiste(Pasta[r] +Barra+ De[r])) {
                                if (Arquivamento.SeExiste(Pasta[r] +Barra+ Para[r])) {
                                    Arquivamento.Apagar(Pasta[r] +Barra+ Para[r]);
                                    addLinhaDeEstatus("     Apagando: \"" + Para[r] + "\"!");
                                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>Apagando:</b></font> \"" + Para[r] + "\"!");
                                }
                                addLinhaDeEstatus("     Renomeando: \"" + De[r] + "\" -> \"" + Para[r] + "\"...");
                                FrmPrincipal.setAvisoEmEstatus("<html><b>Renomeando:</b> \"" + De[r] + "\" -> \"" + Para[r] + "\"...");
                                Arquivamento.MoverArquivo(Pasta[r] +Barra+ De[r], Pasta[r] +Barra+ Para[r]);
                            }
                        }

                        if(!Arquivamento.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "log")) {
                            addLinhaDeEstatus("     Criando Pasta: \"" + FrmPrincipal.Config.getEathenaData()  +Barra+ "log\"...");
                            FrmPrincipal.setAvisoEmEstatus("<html><b>Criando Pasta:</b> \"" + FrmPrincipal.Config.getEathenaData()  +Barra+ "log\"...");
                            Arquivamento.CriarPasta(FrmPrincipal.Config.getEathenaData()  +Barra+ "log");
                        }

                        /*
                        Criar pasta de ~/localhost/eathena-data/log
                        gcc -o eathena-monitor eathena-monitor.c
                        /**/
                        if(!Arquivamento.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "eathena-monitor")) {
                            FrmPrincipal.PgbBarra.setString("Copilando...");
                            addLinhaDeEstatus("     Copilando binário \"eathena-monitor\"...");
                            FrmPrincipal.setAvisoEmEstatus("Copilando binário \"eathena-monitor\"...");
                            Comando="gcc -o "+
                                FrmPrincipal.Config.getEathenaData()  +Barra+ "eathena-monitor "+
                                FrmPrincipal.Config.getEathenaData()  +Barra+ "eathena-monitor.c";
                            System.out.println(Comando);
                            try {
                                Process Retorno = Executador.exec(Comando);
                                BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                while ((line = in.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                addLinhaDeEstatus("ERRO: "+Comando);
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                                ConfigClass.Mensagem_Erro(
                                    "<html><b>O TMW-Maker não conseguiu copilar o binário de monitor:</b><br/><br/>" +
                                    "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                    "</html>",
                                    "ERRO DE EXECUÇÃO"
                                );
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnBaixar.setEnabled(true);
                                BtnCompartilhar.setEnabled(true);
                                BtnMontar.setEnabled(true);
                                BtnFechar.setEnabled(true);
                                ChkForcar.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }
                        }

                        /*
                        rm $HOME/tmwserver // Apaga Link
                        ln -s $PWD $HOME/tmwserver //Recria Link
                        /**/
                        if(Arquivamento.SeExiste(System.getProperty("user.home")+Barra+"tmwserver")) {
                            Arquivamento.Apagar(System.getProperty("user.home")+Barra+"tmwserver");
                        }
                        FrmPrincipal.PgbBarra.setString("Coligando...");
                        addLinhaDeEstatus("     Criando link \""+System.getProperty("user.home")+Barra+"tmwserver\"...");
                        FrmPrincipal.setAvisoEmEstatus("Criando link \""+System.getProperty("user.home")+Barra+"tmwserver\"...");
                        Comando="ln -s "+
                            FrmPrincipal.Config.getConexaoLocalhost()+Barra+ "eathena-data"+" "+
                            System.getProperty("user.home")+Barra+"tmwserver";
                        System.out.println(Comando);
                        try {
                            Process Retorno = Executador.exec(Comando);
                            BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                            while ((line = in.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            addLinhaDeEstatus("ERRO: "+Comando);
                            FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                            ConfigClass.Mensagem_Erro(
                                "<html><b>O TMW-Maker não conseguiu criar link:</b><br/><br/>" +
                                "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                "</html>",
                                "ERRO DE EXECUÇÃO"
                            );
                            FrmPrincipal.PgbBarra.setIndeterminate(false);
                            BtnBaixar.setEnabled(true);
                            BtnCompartilhar.setEnabled(true);
                            BtnMontar.setEnabled(true);
                            BtnFechar.setEnabled(true);
                            ChkForcar.setEnabled(true);
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            return;
                        }
                        addLinhaDeEstatus("Localhost montado com sucesso! (Pressione F9 para Executar)");
                        FrmPrincipal.setAvisoEmEstatus("<html>Locahost montado com sucesso! (<font color=\"#0000FF\">Pressione F9 para Executar</font>)");
                        FrmPrincipal.PgbBarra.setString("Concluido!");

                        FrmPrincipal.PgbBarra.setIndeterminate(false);
                        BtnBaixar.setEnabled(true);
                        BtnCompartilhar.setEnabled(true);
                        BtnMontar.setEnabled(true);
                        BtnFechar.setEnabled(true);
                        ChkForcar.setEnabled(true);
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                        if(FrmPrincipal.Config.getSeDependenciaDeManaplus() || FrmPrincipal.Config.getSeDependenciaDeTMW()){
                            ConfigClass.Mensagem_Erro("<html>"+
                                "Locahost <font color=\"#0000FF\">montado com sucesso</font>!<br/>"+
                                "Para executar o tmw-maker <b>pressione tecla F9</b>.<br/>"+
                                "Crie uma nova conta de jogador no servidor \"localhost\"!"
                                , "AVISO"
                            );
                            FrmPrincipal.PgbBarra.setIndeterminate(false);
                            BtnBaixar.setEnabled(true);
                            BtnCompartilhar.setEnabled(true);
                            BtnMontar.setEnabled(true);
                            BtnFechar.setEnabled(true);
                            ChkForcar.setEnabled(true);
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            return;
                        }

                    }
                });
                tThread.start();
            } else {
                FrmPrincipal.setAvisoEmEstatus("Remontagem cancelada!");
                addLinhaDeEstatus("Remontagem cancelada!");
                FrmPrincipal.PgbBarra.setString("");
            }
        }else{
            FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#0000FF\">CANCELADO:</font> Existe uma dependencia de GCC para você resolver!");
            addLinhaDeEstatus("CANCELADO: Existe uma dependencia de GCC para você resolver!");
            ConfigClass.Mensagem_Erro("<html>"+
                "Esta função possui a <font face=\"monospace\" color=\"#FF0000\">dependencia</font> do comando GCC!",
                "ERRO DE EXECUÇÃO"
            );
        }
    }
    }
    private void LocalhostCompartilhar() {
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        if (SistemaOperacional.indexOf("win") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o WINDOWS!","Descupe!");
        } else if (SistemaOperacional.indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!","Descupe!");
        } else {
            Thread tThread = new Thread(new Runnable() {
                public void run() {
                    boolean SeConclui=false;
                    Runtime Executador = Runtime.getRuntime();
                    String line="", Partes[];
                    String Comando ="";
                    //String[] Comando = new String[2];
                    int Arquivos=0;
                    int R = JOptionPane.YES_OPTION;

                    FrmPrincipal.PgbBarra.setEnabled(true);
                    BtnFechar.setEnabled(false);
                    BtnBaixar.setEnabled(false);
                    BtnCompartilhar.setEnabled(false);
                    ChkForcar.setEnabled(false);

                    Partes = FrmPrincipal.Config.getConexaoRepositorio().split(":");
                    if(Partes.length>1 && Partes[0].toLowerCase().equals("https") && !FrmPrincipal.Config.getConexaoUsuario().equals("") && !FrmPrincipal.Config.getConexaoSenha().equals("")){
                        Object[] options = {"Sim, Compartilhar!", "Não, Cancelar!"};
                        R = JOptionPane.showOptionDialog(
                            null, "<html>" +
                            "Se enviar algum <font color=\"#FF0000\">Script com Defeito</font> de seu Localhost para o Repositório, você <br/>" +
                            "poderá danificar o repositório, prejudicando trabalho de outros colaboradores.<br/>" +
                            "Tem certeza que seu localhost está funcionando corretamente?",
                            "COMPARTILHAMENTO DE LOCALHOST",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png")),
                            options,
                            options[1]
                        );
                        if (R == JOptionPane.YES_OPTION) {
                            FrmPrincipal.PgbBarra.setIndeterminate(true);
                            FrmPrincipal.PgbBarra.setString("Preparando...");
                            TxtEstatus.setText("Preparando para compartilhar...");
                            FrmPrincipal.setAvisoEmEstatus("Preparando para compartilhar...");
                            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            // operacao demorada


                            try {
                                Comando=
                                    "svn commit "+FrmPrincipal.Config.getConexaoLocalhost()+" --message " +
                                    "Autosincronizar_TMW-Maker_"+FrmPrincipal.Config.getVersao()+"_" +
                                    "("+FrmPrincipal.Config.getOS()+"-"+FrmPrincipal.Config.getArquiteturaOS()+")...";/**/

                                TxtEstatus.setText(TxtEstatus.getText()+"\n     "+Comando);
                                Process Retorno=Executador.exec(Comando);
                                BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                while ((line = in.readLine()) != null) {
                                    line=line.replaceAll(FrmPrincipal.Config.getConexaoLocalhost()+Barra, "");
                                    System.out.println(line);
                                    FrmPrincipal.setAvisoEmEstatus("<html>ENVIADO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                                    Arquivos++;
                                    FrmPrincipal.PgbBarra.setString("nº"+Arquivos);
                                    TxtEstatus.setText(TxtEstatus.getText()+"\n     "+Arquivos+": "+line);
                                }
                                if(Arquivos>=2){
                                    FrmPrincipal.setAvisoEmEstatus("<html>Repositório \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" compartilhado com sucesso!");
                                    TxtEstatus.setText(TxtEstatus.getText()+"\nRepositório \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" compartilhado com sucesso!");
                                    FrmPrincipal.PgbBarra.setString("Concluido!");
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html>Repositório \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" já está compartilhado!");
                                    TxtEstatus.setText(TxtEstatus.getText()+"\nRepositório \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" já está compartilhado!");
                                    FrmPrincipal.PgbBarra.setString("Concluido!");
                                }
                            } catch (IOException e) {
                                FrmPrincipal.setAvisoEmEstatus("Falha ao compartilhar o localhost \""+FrmPrincipal.Config.getConexaoLocalhost()+"\"!");
                                ConfigClass.Mensagem_Erro("<html>" +
                                    "Falha ao compartilhar o localhost:<br/> " +
                                    "<font color=\"#FF0000\"> <b>"+Comando+"</b>!"
                                    , "ERRO"
                                );
                                FrmPrincipal.PgbBarra.setString("ERRO!");
                            }
                        }else{
                            TxtEstatus.setText(TxtEstatus.getText()+"\n * Compartilhamento cancelado pelo Usuário!");
                            FrmPrincipal.setAvisoEmEstatus("Compartilhamento cancelado pelo usuário!");
                            FrmPrincipal.PgbBarra.setString("Cancelado!");
                            //ConfigClass.Mensagem_Erro("Compartilhamento cancelado pelo usuários!", "ERRO");
                        }
                    }else{
                        TxtEstatus.setText(TxtEstatus.getText()+
                            "\nVocê não possui identificação \"HTTPS\" em suas configurações.\n\n"+
                            "AVISO:  Antes de continuar configure a Conexão do Repositório como \n" +
                            "\"HTTPS\" e preencha a identificação com o \"Usuário\" e a \"Senha\"!"
                        );
                        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">PARADA CRÍTICA:</font> Você não identificação \"HTTPS\" em suas configurações!!");
                        FrmPrincipal.PgbBarra.setString("PARADA CRÍTICA");
                        ConfigClass.Mensagem_Erro("<html>" +
                            "<font color=\"#FF0000\">AVISO:</font>  Você não possui identificação \"HTTPS\" em suas configurações.<br/><br/>"+
                            "Antes de continuar configure a Conexão do Repositório como <br/>" +
                            "\"HTTPS\" e preencha a identificação com o \"Usuário\" e a \"Senha\"!"
                            , "PARADA CRÍTICA"
                        );
                    }
                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                    BtnFechar.setEnabled(true);
                    BtnBaixar.setEnabled(true);
                    BtnCompartilhar.setEnabled(true);
                    ChkForcar.setEnabled(true);
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
            tThread.start();
        }
    }


}
