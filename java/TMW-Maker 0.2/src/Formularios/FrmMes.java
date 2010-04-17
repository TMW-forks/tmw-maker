/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmMes.java
 *
 * Created on Apr 15, 2010, 2:52:02 PM
 */

package Formularios;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.text.BadLocationException;

/**
 *
 * @author indigovox
 */
public class FrmMes extends javax.swing.JDialog {

    /** Creates new form FrmMes */
    public FrmMes(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoDonoDaFala = new javax.swing.ButtonGroup();
        GrupoFinalDeFala = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtMensagem = new javax.swing.JTextArea();
        BtnAplicar = new javax.swing.JButton();
        BtnFechar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        OptFalaDeJogador = new javax.swing.JRadioButton();
        OptFalaDePersonagem = new javax.swing.JRadioButton();
        TxtNomeDoPersonagem = new javax.swing.JTextField();
        OptFalaDeNinguem = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        OptAoFinalContinuar = new javax.swing.JRadioButton();
        OptAoFinalPausar = new javax.swing.JRadioButton();
        OptAoFinalFechar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comando MES");
        setResizable(false);

        TxtMensagem.setColumns(20);
        TxtMensagem.setRows(5);
        TxtMensagem.setToolTipText("Digite aqui o que o NPC ir� dizer!");
        TxtMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtMensagemKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TxtMensagem);

        BtnAplicar.setMnemonic('A');
        BtnAplicar.setText("Aplicar");
        BtnAplicar.setEnabled(false);
        BtnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAplicarActionPerformed(evt);
            }
        });

        BtnFechar.setMnemonic('F');
        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dono da Fala"));
        jPanel1.setOpaque(false);

        GrupoDonoDaFala.add(OptFalaDeJogador);
        OptFalaDeJogador.setText("Jogador");

        GrupoDonoDaFala.add(OptFalaDePersonagem);
        OptFalaDePersonagem.setText("Personagem:");
        OptFalaDePersonagem.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                OptFalaDePersonagemStateChanged(evt);
            }
        });

        TxtNomeDoPersonagem.setBackground(java.awt.SystemColor.window);
        TxtNomeDoPersonagem.setEnabled(false);

        GrupoDonoDaFala.add(OptFalaDeNinguem);
        OptFalaDeNinguem.setSelected(true);
        OptFalaDeNinguem.setText("Ninguem");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OptFalaDeNinguem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptFalaDeJogador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptFalaDePersonagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNomeDoPersonagem, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptFalaDeNinguem)
                    .addComponent(OptFalaDeJogador)
                    .addComponent(TxtNomeDoPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptFalaDePersonagem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("No final da fala a caixa de dialogo ir�:"));
        jPanel2.setToolTipText("null");

        GrupoFinalDeFala.add(OptAoFinalContinuar);
        OptAoFinalContinuar.setSelected(true);
        OptAoFinalContinuar.setText("Continuar");

        GrupoFinalDeFala.add(OptAoFinalPausar);
        OptAoFinalPausar.setText("Pausar");
        OptAoFinalPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptAoFinalPausarActionPerformed(evt);
            }
        });

        GrupoFinalDeFala.add(OptAoFinalFechar);
        OptAoFinalFechar.setText("Fechar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(OptAoFinalContinuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptAoFinalPausar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptAoFinalFechar)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptAoFinalContinuar)
                    .addComponent(OptAoFinalPausar)
                    .addComponent(OptAoFinalFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(BtnAplicar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed
    private void BtnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAplicarActionPerformed
        String Conteudo=FrmScript.TxtScriptPalco.getText();
        String TxtInicio=Conteudo.substring(0,FrmScript.TxtScriptPalco.getSelectionStart());
        String TxtFinal=Conteudo.substring(FrmScript.TxtScriptPalco.getSelectionStart(),FrmScript.TxtScriptPalco.getText().length());
        String Codigo="",Tabulacao="";
        int linha = 0, coluna = 0;

        try {
            linha = FrmScript.TxtScriptPalco.getLineOfOffset(FrmScript.TxtScriptPalco.getCaretPosition());
            coluna = FrmScript.TxtScriptPalco.getCaretPosition() - FrmScript.TxtScriptPalco.getLineStartOffset(linha);
            for(int i=0;i<coluna;i++){
                Tabulacao+=" ";
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(FrmMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(OptFalaDeJogador.isSelected())Codigo+="mes \"[\"+ strcharinfo(0) +\"]\";\n";
        if(OptFalaDePersonagem.isSelected())Codigo+="mes \"["+ TxtNomeDoPersonagem.getText() +"]\";\n";

        this.TxtMensagem.setText(this.TxtMensagem.getText().trim());
        for(int i=0;i<this.TxtMensagem.getLineCount();i++){
            try {
                Codigo += (!Codigo.isEmpty()?Tabulacao:"")+
                "mes \"" +
                    this.TxtMensagem.getText().substring(
                        this.TxtMensagem.getLineStartOffset(i),
                        this.TxtMensagem.getLineEndOffset(i)-(i<(this.TxtMensagem.getLineCount()-1)?1:0)
                    ) +
                "\";\n";
            } catch (BadLocationException ex) {
                Logger.getLogger(FrmMes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(OptAoFinalPausar.isSelected())Codigo+=(!Codigo.isEmpty()?Tabulacao:"")+"next;";
        if(OptAoFinalFechar.isSelected())Codigo+=(!Codigo.isEmpty()?Tabulacao:"")+"close;";
        FrmScript.TxtScriptPalco.setText(TxtInicio+Codigo+TxtFinal);
        dispose();

    }//GEN-LAST:event_BtnAplicarActionPerformed
    private void OptAoFinalPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptAoFinalPausarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OptAoFinalPausarActionPerformed
    private void OptFalaDePersonagemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_OptFalaDePersonagemStateChanged
        TxtNomeDoPersonagem.setEnabled(OptFalaDePersonagem.isSelected());
        TxtNomeDoPersonagem.setBackground(TxtNomeDoPersonagem.isEnabled()?java.awt.SystemColor.text:java.awt.SystemColor.window);
    }//GEN-LAST:event_OptFalaDePersonagemStateChanged
    private void TxtMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtMensagemKeyReleased
        BtnAplicar.setEnabled(!TxtMensagem.getText().isEmpty());
    }//GEN-LAST:event_TxtMensagemKeyReleased

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMes dialog = new FrmMes(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton BtnAplicar;
    private javax.swing.JButton BtnFechar;
    private javax.swing.ButtonGroup GrupoDonoDaFala;
    private javax.swing.ButtonGroup GrupoFinalDeFala;
    private javax.swing.JRadioButton OptAoFinalContinuar;
    private javax.swing.JRadioButton OptAoFinalFechar;
    private javax.swing.JRadioButton OptAoFinalPausar;
    private javax.swing.JRadioButton OptFalaDeJogador;
    private javax.swing.JRadioButton OptFalaDeNinguem;
    private javax.swing.JRadioButton OptFalaDePersonagem;
    private javax.swing.JTextArea TxtMensagem;
    private javax.swing.JTextField TxtNomeDoPersonagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
