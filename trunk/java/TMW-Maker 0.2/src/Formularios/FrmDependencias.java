
package Formularios;

import Classes.ConfigClass;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmDependencias extends javax.swing.JDialog {
    public FrmDependencias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TblDependencias = new javax.swing.JTable();
        BtnResolver = new javax.swing.JButton();
        BtnAjuda = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dependencias de Funcionamento");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        TblDependencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Configuração", "Pendente", "Configurações do TMW-Maker"},
                {"SVN", "Pendente", "Baixa repositório tipo Subversion"},
                {"Localhost", "Pendente", "Cópia de um servidor TMW"},
                {"GCC", "Pendente", "Executa aplicativos C++"},
                {"Montagem", "Pendente", "Localhost pronto para uso"},
                {"Cliente", "Pendente", "Aplicativo do Jogo \"The Mana World\""}
            },
            new String [] {
                "Dependencia", "Estatus", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblDependencias.setFocusable(false);
        TblDependencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDependenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblDependencias);

        BtnResolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/tmw-br.png"))); // NOI18N
        BtnResolver.setMnemonic('R');
        BtnResolver.setText("Resolver");
        BtnResolver.setEnabled(false);
        BtnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResolverActionPerformed(evt);
            }
        });

        BtnAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ajuda.gif"))); // NOI18N
        BtnAjuda.setMnemonic('J');
        BtnAjuda.setText("Ajudar");
        BtnAjuda.setFocusable(false);
        BtnAjuda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        BtnCancelar.setMnemonic('C');
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAjuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(BtnResolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCancelar, BtnResolver});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAjuda)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnResolver))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        VerificarPendencias();
    }//GEN-LAST:event_formWindowActivated
    private void TblDependenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDependenciasMouseClicked
        //setTitle("Linha: "+TblDependencias.getSelectedRow());
        if(TblDependencias.getSelectedRow()==0 && !FrmPrincipal.Config.getSeDependenciaDeConfiguracao()){
            BtnResolver.setEnabled(true);
        }else if(
            TblDependencias.getSelectedRow()==2 &&
            FrmPrincipal.Config.getSeDependenciaDeConfiguracao() &&
            FrmPrincipal.Config.getSeDependenciaDeSVN() &&
            !FrmPrincipal.Config.getSeDependenciaDeLocalhost()
        ){
            BtnResolver.setEnabled(true);
        }else if(
            TblDependencias.getSelectedRow()==4 &&
            FrmPrincipal.Config.getSeDependenciaDeConfiguracao() &&
            FrmPrincipal.Config.getSeDependenciaDeSVN() &&
            FrmPrincipal.Config.getSeDependenciaDeLocalhost() &&
            !FrmPrincipal.Config.getSeDependenciaDeMontagem()
        ){
            BtnResolver.setEnabled(true);
        }else if(
            TblDependencias.getSelectedRow()==5 &&
            FrmPrincipal.Config.getSeDependenciaDeConfiguracao() &&
            FrmPrincipal.Config.getSeDependenciaDeSVN() &&
            FrmPrincipal.Config.getSeDependenciaDeLocalhost() &&
            FrmPrincipal.Config.getSeDependenciaDeMontagem() &&
            FrmPrincipal.Config.getDependenciaEmFalta()==6
        ){
            BtnResolver.setEnabled(true);
        }else{
            BtnResolver.setEnabled(false);
        }

    }//GEN-LAST:event_TblDependenciasMouseClicked
    private void BtnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResolverActionPerformed
        // TODO add your handling code here:
        if(TblDependencias.getSelectedRow()==0) {

                FrmPrincipal.Config.ConfiguracoesGravar();
                BtnResolver.setEnabled(false);
                FrmPrincipal.setAvisoEmEstatus("Definida configuração padrão com sucesso!");
                VerificarPendencias();
                if(!FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
                    int R = JOptionPane.YES_OPTION;
                    Object[] options = {"Baixar", "Cancelar"};
                    R = JOptionPane.showOptionDialog(
                        null, "<html>" +
                        "Você ainda não possuir um localhost para editar.<br/>" +
                        "Deseja que o tmw-maker baixe o seu localhost?",
                        "BAIXAR LOCALHOST",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]
                    );
                    if(R == JOptionPane.YES_OPTION) BaixarLocalhost();

                }
            /*} catch (IOException ex) {
                //Logger.getLogger(FrmDependencias.class.getName()).log(Level.SEVERE, null, ex);
                ConfigClass.Mensagem_Erro("Não foi possível salvar as configurações!", "ERRO");
            }/**/
        }else if(TblDependencias.getSelectedRow()==2){
            BaixarLocalhost();
        }else if(TblDependencias.getSelectedRow()==4){
            MontarLocalhost();
        }else if(TblDependencias.getSelectedRow()==5){
            ProcurarCliente();
        }
    }//GEN-LAST:event_BtnResolverActionPerformed
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDependencias dialog = new FrmDependencias(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnAjuda;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnResolver;
    private javax.swing.JTable TblDependencias;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    static String Barra = System.getProperty("file.separator");

    public void VerificarPendencias(){
        String Cabecalho[] = new String [] { "Dependencias", "Estatus", "Descrição"};
        Object CorpoDePendencias= new Object [][] {
            {"Configuração", (FrmPrincipal.Config.getSeDependenciaDeConfiguracao()?"Configurado":"<html><font color=\"#FF0000\">Pendente"), "Configurações do TMW-Maker"},
            {"SVN", (FrmPrincipal.Config.getSeDependenciaDeSVN()?"Instalado":"<html><font color=\"#FF0000\">Pendente"), "Baixa repositório tipo Subversion"},
            {"Localhost", (FrmPrincipal.Config.getSeDependenciaDeLocalhost()?"Baixado":"<html><font color=\"#FF0000\">Pendente"), "Cópia de um servidor TMW"},
            {"GCC", (FrmPrincipal.Config.getSeDependenciaDeGCC()?"Instalado":"<html><font color=\"#FF0000\">Pendente"), "Executa aplicativos C++"},
            {"Montagem", (FrmPrincipal.Config.getSeDependenciaDeMontagem()?"Montado":"<html><font color=\"#FF0000\">Pendente"), "Localhost pronto para uso"},
            {"Cliente",((FrmPrincipal.Config.SeComandoProcede(FrmPrincipal.Config.getExecucaoComando()+" --help"))?(FrmPrincipal.Config.getExecucaoComando().toUpperCase()):"<html><font color=\"#FF0000\">Pendente"), "Aplicativo do Jogo \"The Mana World\""}
        };
        TblDependencias.setModel(new javax.swing.table.DefaultTableModel((Object[][]) CorpoDePendencias,Cabecalho) {
            boolean[] canEdit = new boolean [] {false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });

        TblDependencias.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
        TblDependencias.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);

        TblDependencias.getTableHeader().getColumnModel().getColumn(1).setMinWidth(80);
        TblDependencias.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(80);
    }
    public void BaixarLocalhost(){
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

                    BtnResolver.setEnabled(false);
                    BtnCancelar.setEnabled(false);
                    TblDependencias.setEnabled(false);

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
                        //TxtEstatus.setText("Preparando para baixar...");
                        FrmPrincipal.LblEstatus.setText("Preparando para baixar...");
                        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        // operacao demorada


                        Comando ="svn checkout "+FrmPrincipal.Config.getConexaoRepositorio()+" "+FrmPrincipal.Config.getConexaoLocalhost();
                        //if(ChkForcar.isSelected()){Comando+=" --force";}
                        //TxtEstatus.setText(TxtEstatus.getText()+"\n     "+Comando);
                        if(Partes.length>1 && Partes[0].toLowerCase().equals("https")){
                            Comando+=" --username "+FrmPrincipal.Config.getConexaoUsuario()+" --password "+FrmPrincipal.Config.getConexaoSenha();
                        }

                        try {
                            Process Retorno=Executador.exec(Comando);
                            BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                            while ((line = in.readLine()) != null) {
                                System.out.println(line);
                                FrmPrincipal.LblEstatus.setText("<html>BAIXANDO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                                Arquivos++;
                                FrmPrincipal.PgbBarra.setString("nº"+Arquivos);
                                //TxtEstatus.setText(TxtEstatus.getText()+"\n     "+Arquivos+": "+line);
                                //Partes=line.split("/");
                                //FrmPrincipal.PgbBarra.setString(Partes[Partes.length-1]);
                            }
                            //ConfigClass.Mensagem_Erro("Repositório \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" recebido com sucesso!", "AVISO");
                            FrmPrincipal.LblEstatus.setText("<html>Repositório \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" recebido com sucesso!");
                            //TxtEstatus.setText(TxtEstatus.getText()+"\nRepositório \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" recebido com sucesso!");
                            FrmPrincipal.PgbBarra.setString("Concluido!");
                        } catch (IOException e) {
                            //TxtEstatus.setText(TxtEstatus.getText()+"\nFalha ao receber o repositório \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!");
                            //ConfigClass.Mensagem_Erro("<html><font color=\"#FF0000\">Falha ao receber o repositório \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!", "ERRO");
                            FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">Falha ao receber o repositório \"<b>"+FrmPrincipal.Config.getConexaoUsuario()+"</b>\"!");
                            FrmPrincipal.PgbBarra.setString("ERRO!");
                        }/**/
                        FrmPrincipal.PgbBarra.setIndeterminate(false);
                        BtnCancelar.setEnabled(true);
                        TblDependencias.setEnabled(true);
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                        VerificarPendencias();
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
                            if(R == JOptionPane.YES_OPTION) MontarLocalhost();
                        }
                    }
                }
            });
            tThread.start();
        }
    }
    public void MontarLocalhost() {
        if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o windows!", "Descupe!");
        } else if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
        } else if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {
            int R = JOptionPane.YES_OPTION;
            if(FrmPrincipal.Config.getSeDependenciaDeGCC()){
                if (FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "char-server") ||
                    FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "login-server") ||
                    FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "map-server")) {
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
                            BtnResolver.setEnabled(false);
                            BtnCancelar.setEnabled(false);
                            TblDependencias.setEnabled(false);
                            FrmPrincipal.PgbBarra.setEnabled(true);
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
                            if (FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins")) {
                                FrmPrincipal.Config.Apagar(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins");
                            }
                            FrmPrincipal.Config.Apagar(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "char-server");
                            FrmPrincipal.Config.Apagar(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "login-server");
                            FrmPrincipal.Config.Apagar(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "map-server");

                            FrmPrincipal.PgbBarra.setString("Preparando...");
                            FrmPrincipal.setAvisoEmEstatus("Preparando para baixar binários novos...");
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
                                    FrmPrincipal.PgbBarra.setString("Baixando nº" + Baixados + "...");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                                ConfigClass.Mensagem_Erro(
                                    "<html><b>O TMW-Maker não conseguiu baixar os binários:</b><br/><br/>" +
                                    "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                    "</html>",
                                    "ERRO DE EXECUÇÃO"
                                );
                            }
                            if (BinariosEspecificos == true) {
                                FrmPrincipal.PgbBarra.setString("Deslocando...");
                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "char-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins" +Barra+ "char-server",
                                            FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "char-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">char-server</font>...");
                                }
                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "login-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins" +Barra+ "login-server",
                                            FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "login-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">login-server</font>...");
                                }
                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "map-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins" +Barra+ "map-server",
                                            FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "map-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">map-server</font>...");
                                }
                            } else {
                                //Desconpactar para usar
                            }

                            /*
                            mv -uv conf/atcommand_local.conf.example conf/atcommand_local.conf
                            mv -uv conf/battle_local.conf.example conf/battle_local.conf
                            mv -uv conf/char_local.conf.example conf/char_local.conf
                            mv -uv conf/eathena-monitor.conf.example conf/eathena-monitor.conf
                            mv -uv conf/gm_account.txt.example conf/gm_account.txt
                            mv -uv conf/help.txt.example conf/help.txt
                            mv -uv conf/ladmin_local.conf.example conf/ladmin_local.conf
                            mv -uv conf/login_local.conf.example conf/login_local.conf
                            mv -uv conf/map_local.conf.example conf/map_local.conf
                            mv -uv conf/motd.txt.example conf/motd.txt
                            mv -uv save/account.txt.example save/account.txt
                            /**/

                            FrmPrincipal.setAvisoEmEstatus("Renomeando banco de dados...");
                            FrmPrincipal.PgbBarra.setString("Renomeando...");
                            String Pasta[] = new String[]{
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "save"
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
                                if (FrmPrincipal.Config.SeExiste(Pasta[r] +Barra+ De[r])) {
                                    if (FrmPrincipal.Config.SeExiste(Pasta[r] +Barra+ Para[r])) {
                                        FrmPrincipal.Config.Apagar(Pasta[r] +Barra+ Para[r]);
                                        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>Apagando:</b></font> \"" + Para[r] + "\"!");
                                    }
                                    FrmPrincipal.setAvisoEmEstatus("<html><b>Renomeando:</b> \"" + De[r] + "\" -> \"" + Para[r] + "\"...");
                                    FrmPrincipal.Config.MoverArquivo(Pasta[r] +Barra+ De[r], Pasta[r] +Barra+ Para[r]);
                                }
                            }

                            if(!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "log")) {
                                FrmPrincipal.setAvisoEmEstatus("<html><b>Criando Pasta:</b> \"" + FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "log\"...");
                                FrmPrincipal.Config.CriarPasta(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "log");
                            }

                            /*
                            Criar pasta de ~/tmw-br/eathena-data/log
                            gcc -o eathena-monitor eathena-monitor.c
                            /**/
                            if(!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "eathena-monitor")) {
                                FrmPrincipal.PgbBarra.setString("Copilando...");
                                FrmPrincipal.setAvisoEmEstatus("Copilando binário \"eathena-monitor\"...");
                                Comando="gcc -o "+
                                    FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "eathena-monitor "+
                                    FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "eathena-monitor.c";
                                System.out.println(Comando);
                                try {
                                    Process Retorno = Executador.exec(Comando);
                                    BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                    while ((line = in.readLine()) != null) {
                                        System.out.println(line);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
                                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                                    ConfigClass.Mensagem_Erro(
                                        "<html><b>O TMW-Maker não conseguiu copilar o binário de monitor:</b><br/><br/>" +
                                        "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                        "</html>",
                                        "ERRO DE EXECUÇÃO"
                                    );
                                }
                            }

                            /*
                            rm $HOME/tmwserver // Apaga Link
                            ln -s $PWD $HOME/tmwserver //Recria Link
                            /**/
                            if(FrmPrincipal.Config.SeExiste(System.getProperty("user.home")+Barra+"tmwserver")) {
                                FrmPrincipal.Config.Apagar(System.getProperty("user.home")+Barra+"tmwserver");
                            }
                            FrmPrincipal.PgbBarra.setString("Coligando...");
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
                                //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                                ConfigClass.Mensagem_Erro(
                                    "<html><b>O TMW-Maker não conseguiu criar link:</b><br/><br/>" +
                                    "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                    "</html>",
                                    "ERRO DE EXECUÇÃO"
                                );
                            }

                            FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#0000FF\">Locahost montado com sucesso!");
                            FrmPrincipal.PgbBarra.setString("Concluido!");

                            FrmPrincipal.PgbBarra.setIndeterminate(false);
                            BtnCancelar.setEnabled(true);
                            TblDependencias.setEnabled(true);
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                            if(FrmPrincipal.Config.getSeDependenciaDeMana() || FrmPrincipal.Config.getSeDependenciaDeTMW()){
                                VerificarPendencias();
                                ConfigClass.Mensagem_Erro("<html>"+
                                    "Locahost <font color=\"#0000FF\">montado com sucesso</font>!<br/>"+
                                    "Para executar o tmw-maker <b>pressione tecla F9</b> de "+
                                    "crie uma nova conta de jogador no servidor \"localhost\"."
                                    , "AVISO"
                                );
                            }
                            
                        }
                    });
                    tThread.start();
                } else {
                    FrmPrincipal.setAvisoEmEstatus("Remontagem cancelada!");
                    FrmPrincipal.PgbBarra.setString("");
                }
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#0000FF\">CANCELADO:</font> Existe uma dependencia de GCC para você resolver!");
                ConfigClass.Mensagem_Erro("<html>"+
                    "Esta função possui a <font face=\"monospace\" color=\"#FF0000\">dependencia</font> do comando GCC!",
                    "ERRO DE EXECUÇÃO"
                );
            }
        }
    }
    private void ProcurarCliente() {
        if(FrmPrincipal.Config.getExecucaoComando().equals("mana") && !FrmPrincipal.Config.getSeDependenciaDeMana() && FrmPrincipal.Config.getSeDependenciaDeTMW()){
            FrmPrincipal.Config.setExecucaoComando("tmw");
            FrmPrincipal.Config.ConfiguracoesGravar();
            VerificarPendencias();
            BtnResolver.setEnabled(false);
        }else if(FrmPrincipal.Config.getExecucaoComando().equals("tmw") && FrmPrincipal.Config.getSeDependenciaDeMana() && !FrmPrincipal.Config.getSeDependenciaDeTMW()){
            FrmPrincipal.Config.setExecucaoComando("mana");
            FrmPrincipal.Config.ConfiguracoesGravar();
            VerificarPendencias();
            BtnResolver.setEnabled(false);
        }else if(
            (!FrmPrincipal.Config.getExecucaoComando().equals("mana") && !FrmPrincipal.Config.getExecucaoComando().equals("tmw")) &&
            (FrmPrincipal.Config.getSeDependenciaDeMana() || FrmPrincipal.Config.getSeDependenciaDeTMW())
        ){
            if(FrmPrincipal.Config.getSeDependenciaDeMana()){
                FrmPrincipal.Config.setExecucaoComando("mana");
                FrmPrincipal.Config.ConfiguracoesGravar();
                VerificarPendencias();
                BtnResolver.setEnabled(false);
            }else if(FrmPrincipal.Config.getSeDependenciaDeTMW()){
                FrmPrincipal.Config.setExecucaoComando("tmw");
                FrmPrincipal.Config.ConfiguracoesGravar();
                VerificarPendencias();
                BtnResolver.setEnabled(false);
            }
        }else{
            ConfigClass.Mensagem_Erro(
                "<html>O TMW-Maker não conseguiu encontrar o programa <font color=\"#FF0000\">"+FrmPrincipal.Config.getExecucaoComando()+"</font>!"
                , "Dependencia não resolvida!"
            );
            VerificarPendencias();
        }
    }
}
