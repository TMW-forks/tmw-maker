
package Formularios;

import Classes.ConfigClass;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtEstatus = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dependencias de Funcionamento");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TblDependencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Configura��o", "Pendente", "Configura��es do TMW-Maker"},
                {"SVN", "Pendente", "Baixa reposit�rio tipo Subversion"},
                {"Localhost", "Pendente", "C�pia de um servidor TMW"},
                {"GCC", "Pendente", "Executa aplicativos C++"},
                {"Montagem", "Pendente", "Localhost pronto para uso"},
                {"Cliente", "Pendente", "Aplicativo do Jogo \"The Mana World\""}
            },
            new String [] {
                "Dependencia", "Estatus", "Descri��o"
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
        TblDependencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TblDependenciasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TblDependencias);

        BtnResolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_tmw.png"))); // NOI18N
        BtnResolver.setMnemonic('R');
        BtnResolver.setText("Resolver");
        BtnResolver.setEnabled(false);
        BtnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResolverActionPerformed(evt);
            }
        });
        BtnResolver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnResolverKeyPressed(evt);
            }
        });

        BtnAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ajuda.gif"))); // NOI18N
        BtnAjuda.setMnemonic('J');
        BtnAjuda.setText("Ajuda (F1)");
        BtnAjuda.setEnabled(false);
        BtnAjuda.setFocusable(false);
        BtnAjuda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjudaActionPerformed(evt);
            }
        });
        BtnAjuda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAjudaKeyPressed(evt);
            }
        });

        BtnCancelar.setMnemonic('C');
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        BtnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCancelarKeyPressed(evt);
            }
        });

        TxtEstatus.setBackground(java.awt.Color.darkGray);
        TxtEstatus.setColumns(20);
        TxtEstatus.setEditable(false);
        TxtEstatus.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        TxtEstatus.setForeground(java.awt.Color.white);
        TxtEstatus.setRows(5);
        jScrollPane2.setViewportView(TxtEstatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnAjuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                        .addComponent(BtnResolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCancelar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCancelar, BtnResolver});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAjuda)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnResolver))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void TblDependenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDependenciasMouseClicked
        //setTitle("Linha: "+TblDependencias.getSelectedRow());
        if(TblDependencias.getSelectedRow()>=0) {
            BtnAjuda.setEnabled(true);
            if(TblDependencias.getSelectedRow()==0) {
                //ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeConfiguracao");
                FrmPrincipal.setAvisoEmEstatus("<html>" +
                    "<font color=\"#0000FF\">NOTA:</font> " +
                    "Clique no bot�o ajudar para saber como resolver a " +
                    "\"<font color=\"#0000FF\">Dependencia de Configuracao</font>\"!"
                );
                BtnAjuda.setText("Ajuda sobre Configura��o (F1)");
                BtnResolver.setText("Configurar");
                BtnResolver.setMnemonic('C');
                if(!FrmPrincipal.Config.getSeDependenciaDeConfiguracao()) {
                    BtnResolver.setEnabled(true);
                }else{
                    BtnResolver.setEnabled(false);
                }
            }else if(TblDependencias.getSelectedRow()==1) {
                //ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeSVN");
                FrmPrincipal.setAvisoEmEstatus("<html>" +
                    "<font color=\"#0000FF\">NOTA:</font> " +
                    "Clique no bot�o ajudar para saber como resolver a " +
                    "\"<font color=\"#0000FF\">Dependencia de SVN</font>\"!"
                );
                BtnAjuda.setText("Ajuda sobre SVN (F1)");
                BtnResolver.setText("Resolver");
                BtnResolver.setMnemonic('R');
                BtnResolver.setEnabled(false);
            }else if(TblDependencias.getSelectedRow()==2) {
                //ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeLocalhost");
                FrmPrincipal.setAvisoEmEstatus("<html>" +
                    "<font color=\"#0000FF\">NOTA:</font> " +
                    "Clique no bot�o ajudar para saber como resolver a " +
                    "\"<font color=\"#0000FF\">Dependencia de Localhost</font>\"!"
                );
                BtnAjuda.setText("Ajuda sobre Localhost (F1)");
                BtnResolver.setText("Baixar");
                BtnResolver.setMnemonic('B');
                if(
                    FrmPrincipal.Config.getSeDependenciaDeConfiguracao() &&
                    FrmPrincipal.Config.getSeDependenciaDeSVN()
                ){
                    BtnResolver.setEnabled(true);
                }else{
                    BtnResolver.setEnabled(false);
                }
            }else if(TblDependencias.getSelectedRow()==3) {
                //ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeGCC");
                FrmPrincipal.setAvisoEmEstatus("<html>" +
                    "<font color=\"#0000FF\">NOTA:</font> " +
                    "Clique no bot�o ajudar para saber como resolver a " +
                    "\"<font color=\"#0000FF\">Dependencia de GCC</font>\"!"
                );
                BtnAjuda.setText("Ajuda sobre GCC (F1)");
                BtnResolver.setText("Resolver");
                BtnResolver.setMnemonic('R');
                BtnResolver.setEnabled(false);
            }else if(TblDependencias.getSelectedRow()==4) {
                //ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeMontagem");
                FrmPrincipal.setAvisoEmEstatus("<html>" +
                    "<font color=\"#0000FF\">NOTA:</font> " +
                    "Clique no bot�o ajudar para saber como resolver a " +
                    "\"<font color=\"#0000FF\">Dependencia de Montagem</font>\"!"
                );
                BtnAjuda.setText("Ajuda sobre Montagem (F1)");
                if(
                    FrmPrincipal.Config.getSeDependenciaDeConfiguracao() &&
                    FrmPrincipal.Config.getSeDependenciaDeSVN() &&
                    FrmPrincipal.Config.getSeDependenciaDeLocalhost()
                ){
                    if(!FrmPrincipal.Config.getSeDependenciaDeMontagem()){
                        BtnResolver.setText("Montar");
                        BtnResolver.setMnemonic('M');
                    }else{
                        BtnResolver.setText("Re-montar");
                        BtnResolver.setMnemonic('R');
                    }
                    BtnResolver.setEnabled(true);
                }else{
                    BtnResolver.setEnabled(false);
                }
            }else if(TblDependencias.getSelectedRow()==5) {
                //ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeCliente");
                FrmPrincipal.setAvisoEmEstatus("<html>" +
                    "<font color=\"#0000FF\">NOTA:</font> " +
                    "Clique no bot�o ajudar para saber como resolver a " +
                    "\"<font color=\"#0000FF\">Dependencia de Cliente</font>\"!"
                );
                BtnAjuda.setText("Ajuda sobre Cliente (F1)");
                BtnResolver.setText("Resolver");
                BtnResolver.setMnemonic('R');
                if(
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
            }
        }
        

        /*{
            
        }elseelse if(
            TblDependencias.getSelectedRow()==4 &&
            FrmPrincipal.Config.getSeDependenciaDeConfiguracao() &&
            FrmPrincipal.Config.getSeDependenciaDeSVN() &&
            FrmPrincipal.Config.getSeDependenciaDeLocalhost() &&
            !FrmPrincipal.Config.getSeDependenciaDeMontagem()
        ){
            BtnResolver.setEnabled(true);
        }else else{
            BtnResolver.setEnabled(false);
        }/**/


    }//GEN-LAST:event_TblDependenciasMouseClicked
    private void BtnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResolverActionPerformed
        // TODO add your handling code here:
        if(TblDependencias.getSelectedRow()==0) {

                FrmPrincipal.Config.ConfiguracoesGravar();
                BtnResolver.setEnabled(false);
                FrmPrincipal.setAvisoEmEstatus("Definida configura��o padr�o com sucesso!");
                VerificarPendencias();
                if(!FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
                    int R = JOptionPane.YES_OPTION;
                    Object[] options = {"Baixar", "Cancelar"};
                    R = JOptionPane.showOptionDialog(
                        null, "<html>" +
                        "Voc� ainda n�o possuir um localhost para editar.<br/>" +
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
                ConfigClass.Mensagem_Erro("N�o foi poss�vel salvar as configura��es!", "ERRO");
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
    private void BtnAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjudaActionPerformed
        showAjuda();
    }//GEN-LAST:event_BtnAjudaActionPerformed
    private void TblDependenciasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblDependenciasKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F1) showAjuda();
    }//GEN-LAST:event_TblDependenciasKeyPressed
    private void BtnAjudaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAjudaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F1) showAjuda();
    }//GEN-LAST:event_BtnAjudaKeyPressed
    private void BtnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCancelarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F1) showAjuda();
    }//GEN-LAST:event_BtnCancelarKeyPressed
    private void BtnResolverKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnResolverKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F1) showAjuda();
    }//GEN-LAST:event_BtnResolverKeyPressed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        VerificarPendencias();
    }//GEN-LAST:event_formWindowOpened
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
    private javax.swing.JTextArea TxtEstatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    static String Barra = System.getProperty("file.separator");

    public void VerificarPendencias(){
        String Cabecalho[] = new String [] { "Dependencias", "Estatus", "Descri��o"};
        Object CorpoDePendencias= new Object [][] {
            {"Configura��o", (FrmPrincipal.Config.getSeDependenciaDeConfiguracao()?"Configurado":"<html><font color=\"#FF0000\">Pendente"), "Configura��es do TMW-Maker"},
            {"SVN", (FrmPrincipal.Config.getSeDependenciaDeSVN()?"Instalado":"<html><font color=\"#FF0000\">Pendente"), "Baixa reposit�rio tipo Subversion"},
            {"Localhost", (FrmPrincipal.Config.getSeDependenciaDeLocalhost()?"Baixado":"<html><font color=\"#FF0000\">Pendente"), "C�pia de um servidor TMW"},
            {"GCC", (FrmPrincipal.Config.getSeDependenciaDeGCC()?"Instalado":"<html><font color=\"#FF0000\">Pendente"), "Executa aplicativos C++"},
            {"Montagem", (FrmPrincipal.Config.getSeDependenciaDeMontagem()?"Montado":"<html><font color=\"#FF0000\">Pendente"), "Localhost pronto para uso"},
            {"Cliente",((FrmPrincipal.Config.SeComandoProcede(FrmPrincipal.Config.getExecucaoComando()+" --help"))?(FrmPrincipal.Config.getExecucaoComando().toUpperCase()):"<html><font color=\"#FF0000\">Pendente"), "Aplicativo do Jogo \"The Mana World\""}
        };
        TblDependencias.setModel(new javax.swing.table.DefaultTableModel((Object[][]) CorpoDePendencias,Cabecalho) {
            boolean[] canEdit = new boolean [] {false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });

        TblDependencias.getTableHeader().getColumnModel().getColumn(0).setMinWidth(120);
        TblDependencias.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(120);

        TblDependencias.getTableHeader().getColumnModel().getColumn(1).setMinWidth(100);
        TblDependencias.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(100);
    }
    public void BaixarLocalhost(){
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        if (SistemaOperacional.indexOf("win") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda n�o foi implementado para o WINDOWS!","Descupe!");
        } else if (SistemaOperacional.indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            ConfigClass.Mensagem_Erro("Este comando ainda n�o foi implementado para o MAC!","Descupe!");
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
                            "<html>Voc� est� tentando baixar o reposit�rio sem identificar <font color=\"#FF0000\">Usu�rio</font> e <font color=\"#FF0000\">Senha</font> nas configura��es.<br/>"+
                            "Posteriormente n�o ser� poss�vel enviar suas altera��o ao reposit�rio.<br/>"+
                            "Tem certeza que deseja fazer uma <font color=\"#FF0000\">C�pia somente de leitura</font> do reposit�rio?",
                            "C�PIA SOMENTE LEITURA?",
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
                        addLinhaDeEstatus("Preparando para baixar...");
                        FrmPrincipal.LblEstatus.setText("Preparando para baixar...");
                        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        // operacao demorada


                        Comando ="svn checkout "+FrmPrincipal.Config.getConexaoRepositorio()+" "+FrmPrincipal.Config.getConexaoLocalhost();
                        //if(ChkForcar.isSelected()){Comando+=" --force";}
                        addLinhaDeEstatus("     svn checkout "+FrmPrincipal.Config.getConexaoRepositorio());
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
                                FrmPrincipal.PgbBarra.setString("n�"+Arquivos);
                                addLinhaDeEstatus("     "+Arquivos+": "+line);
                                //Partes=line.split("/");
                                //FrmPrincipal.PgbBarra.setString(Partes[Partes.length-1]);
                            }
                            //ConfigClass.Mensagem_Erro("Reposit�rio \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" recebido com sucesso!", "AVISO");
                            FrmPrincipal.LblEstatus.setText("<html>Reposit�rio \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" recebido com sucesso!");
                            addLinhaDeEstatus("Reposit�rio \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" recebido com sucesso!");
                            FrmPrincipal.PgbBarra.setString("Concluido!");
                        } catch (IOException e) {
                            addLinhaDeEstatus("Falha ao receber o reposit�rio \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!");
                            //ConfigClass.Mensagem_Erro("<html><font color=\"#FF0000\">Falha ao receber o reposit�rio \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!", "ERRO");
                            FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">Falha ao receber o reposit�rio \"<b>"+FrmPrincipal.Config.getConexaoUsuario()+"</b>\"!");
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
                                "O seu localhost n�o funcionar� enquanto n�o for montado.<br/>" +
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
            ConfigClass.Mensagem_Erro("Este comando ainda n�o foi implementado para o windows!", "Descupe!");
        } else if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda n�o foi implementado para o MAC!", "Descupe!");
        } else if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {
            int R = JOptionPane.YES_OPTION;
            if(FrmPrincipal.Config.getSeDependenciaDeGCC()){
                if (FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "char-server") ||
                    FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "login-server") ||
                    FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "map-server")) {
                    Object[] options = {"Remontar", "Cancelar"};
                    R = JOptionPane.showOptionDialog(
                        null, "<html>" +
                        "O seu localhost j� est� montado. Ao remontar voc�<br/>" +
                        "<font color=\"#FF0000\">peder� todas as contas</font> de jogadores deste localhost.<br/>" +
                        "Deseja realmente for�ar uma remontagem?",
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
                            FrmPrincipal.setAvisoEmEstatus("Apagando bin�rios...");
                            addLinhaDeEstatus("Apagando bin�rios...");
                            if (FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins")) {
                                FrmPrincipal.Config.Apagar(FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins");
                            }
                            FrmPrincipal.Config.Apagar(FrmPrincipal.Config.getEathenaData() +Barra+ "char-server");
                            FrmPrincipal.Config.Apagar(FrmPrincipal.Config.getEathenaData() +Barra+ "login-server");
                            FrmPrincipal.Config.Apagar(FrmPrincipal.Config.getEathenaData() +Barra+ "map-server");

                            FrmPrincipal.PgbBarra.setString("Abaixando...");
                            FrmPrincipal.setAvisoEmEstatus("Baixando bin�rios novos...");
                            addLinhaDeEstatus("Baixando bin�rios novos...");
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
                                    FrmPrincipal.PgbBarra.setString("Baixando n�" + Baixados + "...");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                addLinhaDeEstatus("ERRO: "+Comando);
                                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                                ConfigClass.Mensagem_Erro(
                                    "<html><b>O TMW-Maker n�o conseguiu baixar os bin�rios:</b><br/><br/>" +
                                    "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                    "</html>",
                                    "ERRO DE EXECU��O"
                                );
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnCancelar.setEnabled(true);
                                TblDependencias.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }
                            if (BinariosEspecificos == true) {
                                FrmPrincipal.PgbBarra.setString("Deslocando...");
                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getEathenaData()+Barra+"char-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"char-server",
                                            FrmPrincipal.Config.getEathenaData()+Barra+"char-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">char-server</font>...");
                                    addLinhaDeEstatus("     Deslocando char-server...");
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">char-server</font>\"!");
                                    addLinhaDeEstatus("ERRO: Falha ao deslocar \"char-server\"!");
                                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                                    BtnCancelar.setEnabled(true);
                                    TblDependencias.setEnabled(true);
                                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                    return;
                                }
                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getEathenaData()+Barra+"login-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"login-server",
                                            FrmPrincipal.Config.getEathenaData()+Barra+"login-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">login-server</font>...");
                                    addLinhaDeEstatus("     Deslocando login-server...");
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">login-server</font>\"!");
                                    addLinhaDeEstatus("ERRO: Falha ao deslocar \"login-server\"!");
                                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                                    BtnCancelar.setEnabled(true);
                                    TblDependencias.setEnabled(true);
                                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                    return;
                                }
                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getEathenaData()+Barra+"map-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins"+Barra+"map-server",
                                            FrmPrincipal.Config.getEathenaData()+Barra+"map-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">map-server</font>...");
                                    addLinhaDeEstatus("     Deslocando map-server...");
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">map-server</font>\"!");
                                    addLinhaDeEstatus("ERRO: Falha ao deslocar \"map-server\"!");
                                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                                    BtnCancelar.setEnabled(true);
                                    TblDependencias.setEnabled(true);
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

                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "char-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "char-server",
                                            FrmPrincipal.Config.getEathenaData()+Barra+"char-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">char-server</font>...");
                                    addLinhaDeEstatus("     Deslocando char-server...");
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">char-server</font>\"!");
                                    addLinhaDeEstatus("ERRO: Falha ao deslocar \"char-server\"!");
                                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                                    BtnCancelar.setEnabled(true);
                                    TblDependencias.setEnabled(true);
                                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                    return;
                                }
                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "login-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "login-server",
                                            FrmPrincipal.Config.getEathenaData()+Barra+"login-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">login-server</font>...");
                                    addLinhaDeEstatus("     Deslocando login-server...");
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">login-server</font>\"!");
                                    addLinhaDeEstatus("ERRO: Falha ao deslocar \"login-server\"!");
                                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                                    BtnCancelar.setEnabled(true);
                                    TblDependencias.setEnabled(true);
                                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                    return;
                                }
                                if (!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "map-server")) {
                                    FrmPrincipal.Config.MoverArquivo(
                                            FrmPrincipal.Config.getConexaoLocalhost()+Barra+"bins"+Barra+"eathena"+Barra+ "map-server",
                                            FrmPrincipal.Config.getEathenaData()+Barra+"map-server");
                                    FrmPrincipal.setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">map-server</font>...");
                                    addLinhaDeEstatus("     Deslocando map-server...");
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">ERRO:</font> Falha ao deslocar \"<font color=\"#0000FF\">map-server</font>\"!");
                                    addLinhaDeEstatus("ERRO: Falha ao deslocar \"map-server\"!");
                                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                                    BtnCancelar.setEnabled(true);
                                    TblDependencias.setEnabled(true);
                                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                    return;
                                }

                                
                                FrmPrincipal.setAvisoEmEstatus("PARADA FOR�ADA...");
                                addLinhaDeEstatus("PARADA FOR�ADA...");
                                FrmPrincipal.PgbBarra.setString("BLOQUEIO!!!");
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnCancelar.setEnabled(true);
                                TblDependencias.setEnabled(true);
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
                                if (FrmPrincipal.Config.SeExiste(Pasta[r] +Barra+ De[r])) {
                                    if (FrmPrincipal.Config.SeExiste(Pasta[r] +Barra+ Para[r])) {
                                        FrmPrincipal.Config.Apagar(Pasta[r] +Barra+ Para[r]);
                                        addLinhaDeEstatus("     Apagando: \"" + Para[r] + "\"!");
                                        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>Apagando:</b></font> \"" + Para[r] + "\"!");
                                    }
                                    addLinhaDeEstatus("     Renomeando: \"" + De[r] + "\" -> \"" + Para[r] + "\"...");
                                    FrmPrincipal.setAvisoEmEstatus("<html><b>Renomeando:</b> \"" + De[r] + "\" -> \"" + Para[r] + "\"...");
                                    FrmPrincipal.Config.MoverArquivo(Pasta[r] +Barra+ De[r], Pasta[r] +Barra+ Para[r]);
                                }
                            }

                            if(!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "log")) {
                                addLinhaDeEstatus("     Criando Pasta: \"" + FrmPrincipal.Config.getEathenaData()  +Barra+ "log\"...");
                                FrmPrincipal.setAvisoEmEstatus("<html><b>Criando Pasta:</b> \"" + FrmPrincipal.Config.getEathenaData()  +Barra+ "log\"...");
                                FrmPrincipal.Config.CriarPasta(FrmPrincipal.Config.getEathenaData()  +Barra+ "log");
                            }

                            /*
                            Criar pasta de ~/localhost/eathena-data/log
                            gcc -o eathena-monitor eathena-monitor.c
                            /**/
                            if(!FrmPrincipal.Config.SeExiste(FrmPrincipal.Config.getEathenaData()  +Barra+ "eathena-monitor")) {
                                FrmPrincipal.PgbBarra.setString("Copilando...");
                                addLinhaDeEstatus("     Copilando bin�rio \"eathena-monitor\"...");
                                FrmPrincipal.setAvisoEmEstatus("Copilando bin�rio \"eathena-monitor\"...");
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
                                        "<html><b>O TMW-Maker n�o conseguiu copilar o bin�rio de monitor:</b><br/><br/>" +
                                        "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                        "</html>",
                                        "ERRO DE EXECU��O"
                                    );
                                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                                    BtnCancelar.setEnabled(true);
                                    TblDependencias.setEnabled(true);
                                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                    return;
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
                                    "<html><b>O TMW-Maker n�o conseguiu criar link:</b><br/><br/>" +
                                    "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                    "</html>",
                                    "ERRO DE EXECU��O"
                                );
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnCancelar.setEnabled(true);
                                TblDependencias.setEnabled(true);
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                return;
                            }
                            addLinhaDeEstatus("Localhost montado com sucesso! (Pressione F9 para Executar)");
                            FrmPrincipal.setAvisoEmEstatus("<html>Locahost montado com sucesso! (<font color=\"#0000FF\">Pressione F9 para Executar</font>)");
                            FrmPrincipal.PgbBarra.setString("Concluido!");

                            FrmPrincipal.PgbBarra.setIndeterminate(false);
                            BtnCancelar.setEnabled(true);
                            TblDependencias.setEnabled(true);
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                            if(FrmPrincipal.Config.getSeDependenciaDeManaplus() || FrmPrincipal.Config.getSeDependenciaDeTMW()){
                                VerificarPendencias();
                                ConfigClass.Mensagem_Erro("<html>"+
                                    "Locahost <font color=\"#0000FF\">montado com sucesso</font>!<br/>"+
                                    "Para executar o tmw-maker <b>pressione tecla F9</b>.<br/>"+
                                    "Crie uma nova conta de jogador no servidor \"localhost\"!"
                                    , "AVISO"
                                );
                                FrmPrincipal.PgbBarra.setIndeterminate(false);
                                BtnCancelar.setEnabled(true);
                                TblDependencias.setEnabled(true);
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
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#0000FF\">CANCELADO:</font> Existe uma dependencia de GCC para voc� resolver!");
                addLinhaDeEstatus("CANCELADO: Existe uma dependencia de GCC para voc� resolver!");
                ConfigClass.Mensagem_Erro("<html>"+
                    "Esta fun��o possui a <font face=\"monospace\" color=\"#FF0000\">dependencia</font> do comando GCC!",
                    "ERRO DE EXECU��O"
                );
            }
        }
    }
    private void ProcurarCliente() {
        if(FrmPrincipal.Config.getExecucaoComando().equals("manaplus") && !FrmPrincipal.Config.getSeDependenciaDeManaplus() && FrmPrincipal.Config.getSeDependenciaDeTMW()){
            FrmPrincipal.Config.setExecucaoComando("tmw");
            FrmPrincipal.Config.ConfiguracoesGravar();
            VerificarPendencias();
            BtnResolver.setEnabled(false);
            addLinhaDeEstatus("Auto-selecionando cliente\"TMW\"!");
        }else if(FrmPrincipal.Config.getExecucaoComando().equals("tmw") && FrmPrincipal.Config.getSeDependenciaDeManaplus() && !FrmPrincipal.Config.getSeDependenciaDeTMW()){
            FrmPrincipal.Config.setExecucaoComando("manaplus");
            FrmPrincipal.Config.ConfiguracoesGravar();
            VerificarPendencias();
            BtnResolver.setEnabled(false);
            addLinhaDeEstatus("Auto-selecionando cliente\"MANAPLUS\"!");
        }else if(
            (!FrmPrincipal.Config.getExecucaoComando().equals("manaplus") && !FrmPrincipal.Config.getExecucaoComando().equals("tmw")) &&
            (FrmPrincipal.Config.getSeDependenciaDeManaplus() || FrmPrincipal.Config.getSeDependenciaDeTMW())
        ){
            if(FrmPrincipal.Config.getSeDependenciaDeManaplus()){
                FrmPrincipal.Config.setExecucaoComando("manaplus");
                FrmPrincipal.Config.ConfiguracoesGravar();
                VerificarPendencias();
                BtnResolver.setEnabled(false);
                addLinhaDeEstatus("Auto-selecionando cliente\"TMW\"!");
            }else if(FrmPrincipal.Config.getSeDependenciaDeTMW()){
                FrmPrincipal.Config.setExecucaoComando("tmw");
                FrmPrincipal.Config.ConfiguracoesGravar();
                VerificarPendencias();
                BtnResolver.setEnabled(false);
                addLinhaDeEstatus("Auto-selecionando cliente\"MANAPLUS\"!");
            }
        }else{
            addLinhaDeEstatus("ERRO: Programa "+FrmPrincipal.Config.getExecucaoComando()+" n�o encontrado!");
            ConfigClass.Mensagem_Erro(
                "<html>O TMW-Maker n�o conseguiu encontrar o programa <font color=\"#FF0000\">"+FrmPrincipal.Config.getExecucaoComando()+"</font>!"
                , "Dependencia n�o resolvida!"
            );
            VerificarPendencias();
        }
    }

    private void showAjuda() {
        if(TblDependencias.getSelectedRow()==0) {
            ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeConfiguracao");
        }else if(TblDependencias.getSelectedRow()==1) {
            ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeSVN");
        }else if(TblDependencias.getSelectedRow()==2) {
            ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeLocalhost");
        }else if(TblDependencias.getSelectedRow()==3) {
            ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeGCC");
        }else if(TblDependencias.getSelectedRow()==4) {
            ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeMontagem");
        }else if(TblDependencias.getSelectedRow()==5) {
            ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+"DependenciaDeCliente");
        }
    }

    private void addLinhaDeEstatus(String Linha) {
        TxtEstatus.setText(TxtEstatus.getText()+"\n"+Linha);
        TxtEstatus.setSelectionStart(TxtEstatus.getText().length()-1);
        TxtEstatus.setSelectionEnd(TxtEstatus.getText().length()-1);
    }
}
