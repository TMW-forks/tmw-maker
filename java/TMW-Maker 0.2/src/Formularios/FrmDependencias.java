
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

                    BtnAplicar.setEnabled(false);

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
                        BtnAplicar.setEnabled(true);
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            });
            tThread.start();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TblDependencias = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        BtnInstalar = new javax.swing.JButton();
        BtnDesinstalar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BtnAplicar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        BtnAjuda = new javax.swing.JButton();

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
                {"Mana", "Pendente", "Jogo TMW de estilo 4144"},
                {"TMW", "Facultativo", "Jogo TMW de estilo antigo"}
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

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        BtnInstalar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_download.gif"))); // NOI18N
        BtnInstalar.setMnemonic('I');
        BtnInstalar.setText("Instalar");
        BtnInstalar.setEnabled(false);
        BtnInstalar.setFocusable(false);
        BtnInstalar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToolBar1.add(BtnInstalar);

        BtnDesinstalar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_upload.gif"))); // NOI18N
        BtnDesinstalar.setMnemonic('D');
        BtnDesinstalar.setText("Desinstalar");
        BtnDesinstalar.setEnabled(false);
        BtnDesinstalar.setFocusable(false);
        BtnDesinstalar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToolBar1.add(BtnDesinstalar);
        jToolBar1.add(jSeparator1);

        BtnAplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/tmw-br.png"))); // NOI18N
        BtnAplicar.setMnemonic('A');
        BtnAplicar.setText("Aplicar");
        BtnAplicar.setEnabled(false);
        BtnAplicar.setFocusable(false);
        BtnAplicar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAplicarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAplicar);
        jToolBar1.add(jSeparator2);

        BtnAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ajuda.gif"))); // NOI18N
        BtnAjuda.setMnemonic('J');
        BtnAjuda.setText("Ajudar");
        BtnAjuda.setFocusable(false);
        BtnAjuda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToolBar1.add(BtnAjuda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        String Cabecalho[] = new String [] { "Dependencias", "Estatus", "Descrição"};
        Object CorpoDePendencias= new Object [][] {
            {"Configuração", (FrmPrincipal.Config.getSeDependenciaDeConfiguracao()?"Configurado":"<html><font color=\"#FF0000\">Pendente"), "Configurações do TMW-Maker"},
            {"SVN", (FrmPrincipal.Config.getSeDependenciaDeSVN()?"Instalado":"<html><font color=\"#FF0000\">Pendente"), "Baixa repositório tipo Subversion"},
            {"Localhost", (FrmPrincipal.Config.getSeDependenciaDeLocalhost()?"Baixado":"<html><font color=\"#FF0000\">Pendente"), "Cópia de um servidor TMW"},
            {"GCC", (FrmPrincipal.Config.getSeDependenciaDeGCC()?"Instalado":"<html><font color=\"#FF0000\">Pendente"), "Executa aplicativos C++"},
            {"Montagem", (FrmPrincipal.Config.getSeDependenciaDeMontagem()?"Montado":"<html><font color=\"#FF0000\">Pendente"), "Localhost pronto para uso"},
            {"Mana", (FrmPrincipal.Config.getSeDependenciaDeMana()?"Instalado":"<html><font color=\"#FF0000\">Pendente"), "Jogo TMW de estilo 4144"},
            {"TMW", (FrmPrincipal.Config.getSeDependenciaDeTMW()?"Instalado":"Facultativo"), "Jogo TMW de estilo antigo"}
        };
        TblDependencias.setModel(new javax.swing.table.DefaultTableModel((Object[][]) CorpoDePendencias,Cabecalho) {
            boolean[] canEdit = new boolean [] {false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });

        TblDependencias.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
        TblDependencias.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);

        TblDependencias.getTableHeader().getColumnModel().getColumn(1).setMinWidth(80);
        TblDependencias.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(80);
    }//GEN-LAST:event_formWindowActivated
    private void TblDependenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDependenciasMouseClicked
        //setTitle("Linha: "+TblDependencias.getSelectedRow());
        if(TblDependencias.getSelectedRow()==0 && !FrmPrincipal.Config.getSeDependenciaDeConfiguracao()){
            BtnInstalar.setEnabled(false);
            BtnDesinstalar.setEnabled(false);
            BtnAplicar.setEnabled(true);
            BtnAplicar.setText("Configurar");
            BtnAplicar.setMnemonic('C');
        }else{
            BtnInstalar.setEnabled(false);
            BtnDesinstalar.setEnabled(false);
            BtnAplicar.setEnabled(false);
        }
        if(
            TblDependencias.getSelectedRow()==2 &&
            FrmPrincipal.Config.getSeDependenciaDeConfiguracao() &&
            !FrmPrincipal.Config.getSeDependenciaDeLocalhost()
        ){
            BtnInstalar.setEnabled(false);
            BtnDesinstalar.setEnabled(false);
            BtnAplicar.setEnabled(true);
            BtnAplicar.setText("Baixar");
            BtnAplicar.setMnemonic('B');
        }else{
            BtnInstalar.setEnabled(false);
            BtnDesinstalar.setEnabled(false);
            BtnAplicar.setEnabled(false);
        }
    }//GEN-LAST:event_TblDependenciasMouseClicked

    private void BtnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAplicarActionPerformed
        // TODO add your handling code here:
        if(TblDependencias.getSelectedRow()==0) {
            try {
                FrmPrincipal.Config.ConfiguracoesGravar();
                BtnAplicar.setEnabled(false);
                ConfigClass.Mensagem_Erro("Configuração concluida com sucesso!", "CONFIGURAÇÃO");
            } catch (IOException ex) {
                //Logger.getLogger(FrmDependencias.class.getName()).log(Level.SEVERE, null, ex);
                ConfigClass.Mensagem_Erro("Não foi possível salvar as configurações!", "ERRO");
            }
        }else if(TblDependencias.getSelectedRow()==2){
            BaixarLocalhost();
        }
    }//GEN-LAST:event_BtnAplicarActionPerformed

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
    private javax.swing.JButton BtnAplicar;
    private javax.swing.JButton BtnDesinstalar;
    private javax.swing.JButton BtnInstalar;
    private javax.swing.JTable TblDependencias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
