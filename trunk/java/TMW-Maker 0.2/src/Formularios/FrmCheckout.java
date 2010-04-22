/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmCheckout.java
 *
 * Created on Apr 21, 2010, 8:10:29 PM
 */

package Formularios;

import Classes.ConfigClass;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author indigovox
 */
public class FrmCheckout extends javax.swing.JDialog {

    /** Creates new form FrmCheckout */
    public FrmCheckout(java.awt.Frame parent, boolean modal) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        TxtEstatus.setColumns(20);
        TxtEstatus.setEditable(false);
        TxtEstatus.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 14)); // NOI18N
        TxtEstatus.setRows(5);
        TxtEstatus.setWrapStyleWord(true);
        TxtEstatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        TxtEstatus.setFocusCycleRoot(true);
        TxtEstatus.setOpaque(false);
        jScrollPane1.setViewportView(TxtEstatus);

        ChkForcar.setMnemonic('F');
        ChkForcar.setText("Baixar for�ado");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ChkForcar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                        .addComponent(BtnBaixar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnBaixar, BtnFechar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(BtnBaixar)
                    .addComponent(ChkForcar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnBaixar, BtnFechar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBaixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBaixarActionPerformed
        int R = JOptionPane.NO_OPTION;
        if(ChkForcar.isSelected()){
            Object[] options = {"Sobrescrever", "Cancelar"};
            R = JOptionPane.showOptionDialog(
                null,
                "<html>Baixar for�ado <font color=\"#FF0000\">sobrescrever� todos os seus trabalhos</font> em \""+FrmPrincipal.Config.getConexaoLocalhost()+"\".<br/>"+
                "Tem certeza que deseja baixar for�ado?",
                "BAIXAR FOR�ADO?",
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
                ConfigClass.Mensagem_Erro("Este comando ainda n�o foi implementado para o WINDOWS!","Descupe!");
            } else if (SistemaOperacional.indexOf("mac") >= 0) {
                /*Executador.exec("open " + URL);/**/
                ConfigClass.Mensagem_Erro("Este comando ainda n�o foi implementado para o MAC!","Descupe!");
            } else {
                Thread tThread = new Thread(new Runnable() {
                    public void run() {
                        FrmPrincipal.PgbBarra.setEnabled(true);
                        BtnFechar.setEnabled(false);
                        BtnBaixar.setEnabled(false);
                        ChkForcar.setEnabled(false);
                        FrmPrincipal.PgbBarra.setIndeterminate(true);
                        FrmPrincipal.PgbBarra.setString("Preparando...");
                        TxtEstatus.setText("Preparando para baixar...");
                        FrmPrincipal.LblEstatus.setText("Preparando para baixar...");
                        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        // operacao demorada
                        boolean SeConclui=false;
                        Runtime Executador = Runtime.getRuntime();
                        String line="", Partes[];
                        String Comando ="";
                        int Arquivos=0;

                        Comando ="svn checkout "+FrmPrincipal.Config.getConexaoRepositorio()+" "+FrmPrincipal.Config.getConexaoLocalhost();
                        if(ChkForcar.isSelected()){Comando+=" --force";}
                        Partes = FrmPrincipal.Config.getConexaoRepositorio().split(":");
                        TxtEstatus.setText(TxtEstatus.getText()+"\n     "+Comando);
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
                                TxtEstatus.setText(TxtEstatus.getText()+"\n     "+Arquivos+": "+line);
                                //Partes=line.split("/");
                                //FrmPrincipal.PgbBarra.setString(Partes[Partes.length-1]);
                            }
                            //ConfigClass.Mensagem_Erro("Reposit�rio \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" recebido com sucesso!", "AVISO");
                            FrmPrincipal.LblEstatus.setText("<html>Reposit�rio \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" recebido com sucesso!");
                            TxtEstatus.setText(TxtEstatus.getText()+"\nReposit�rio \""+FrmPrincipal.Config.getConexaoLocalhost()+"\" recebido com sucesso!");
                            FrmPrincipal.PgbBarra.setString("Concluido!");
                        } catch (IOException e) {
                            TxtEstatus.setText(TxtEstatus.getText()+"\nFalha ao receber o reposit�rio \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!");
                            //ConfigClass.Mensagem_Erro("<html><font color=\"#FF0000\">Falha ao receber o reposit�rio \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!", "ERRO");
                            FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">Falha ao receber o reposit�rio \"<b>"+FrmPrincipal.Config.getConexaoUsuario()+"</b>\"!");
                            FrmPrincipal.PgbBarra.setString("ERRO!");
                        }/**/
                        FrmPrincipal.PgbBarra.setIndeterminate(false);
                        BtnFechar.setEnabled(true);
                        BtnBaixar.setEnabled(true);
                        ChkForcar.setEnabled(true);
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    }
                });
                tThread.start();
            }
        }
    }//GEN-LAST:event_BtnBaixarActionPerformed
    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setTitle("svn checkout "+FrmPrincipal.Config.getConexaoRepositorio());
    }//GEN-LAST:event_formWindowActivated

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCheckout dialog = new FrmCheckout(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnFechar;
    private javax.swing.JCheckBox ChkForcar;
    private javax.swing.JTextArea TxtEstatus;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
