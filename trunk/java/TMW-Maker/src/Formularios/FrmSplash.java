/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmSplash.java
 *
 * Created on Apr 9, 2010, 1:19:42 PM
 */

package Formularios;

import Classes.ConfigClass;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

/**
 *
 * @author indigovox
 */
public class FrmSplash extends javax.swing.JDialog {

    /** Creates new form FrmSplash */
    public FrmSplash(java.awt.Frame parent, boolean modal) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnSplashOk = new javax.swing.JButton();
        LblDesenvolvedora = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LblLunovox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre o TMW-Maker");
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/splash.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 36));
        jLabel2.setText("TMW MAKER");

        jLabel3.setText("<html><b>VERS�O 0.2</b> (GLP Open Source)");

        BtnSplashOk.setText("OK");
        BtnSplashOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSplashOkActionPerformed(evt);
            }
        });

        LblDesenvolvedora.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        LblDesenvolvedora.setForeground(java.awt.Color.blue);
        LblDesenvolvedora.setText("<html><u>http://code.google.com/p/tmw-maker");
        LblDesenvolvedora.setInheritsPopupMenu(false);
        LblDesenvolvedora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblDesenvolvedoraMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LblDesenvolvedoraMouseExited(evt);
            }
        });
        LblDesenvolvedora.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                LblDesenvolvedoraMouseMoved(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        jLabel5.setText("DESENVOLVEDORA:");

        jLabel6.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        jLabel6.setText("CONTATOS:");

        LblLunovox.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        LblLunovox.setForeground(java.awt.Color.blue);
        LblLunovox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblLunovox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Animacoes/lunovox.gif"))); // NOI18N
        LblLunovox.setText("<html><u>General Alquimista Lunovox");
        LblLunovox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        LblLunovox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblLunovoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LblLunovoxMouseExited(evt);
            }
        });
        LblLunovox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                LblLunovoxMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel2)
                                .addComponent(LblDesenvolvedora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(30, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LblLunovox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(BtnSplashOk, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblDesenvolvedora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblLunovox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSplashOk))
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSplashOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSplashOkActionPerformed
       // TODO add your handling code here:
       this.dispose();
    }//GEN-LAST:event_BtnSplashOkActionPerformed

    private void LblDesenvolvedoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblDesenvolvedoraMouseClicked
       // TODO add your handling code here:
       ConfigClass.AbrirNavegador("http://code.google.com/p/tmw-maker");
       LblDesenvolvedora.setForeground(Color.GRAY);
       Toolkit.getDefaultToolkit().beep();
    }//GEN-LAST:event_LblDesenvolvedoraMouseClicked

    private void LblDesenvolvedoraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblDesenvolvedoraMouseMoved
        // TODO add your handling code here:
        LblDesenvolvedora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LblDesenvolvedora.setForeground(Color.RED);
    }//GEN-LAST:event_LblDesenvolvedoraMouseMoved

    private void LblDesenvolvedoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblDesenvolvedoraMouseExited
        // TODO add your handling code here:
        LblDesenvolvedora.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        LblDesenvolvedora.setForeground(Color.BLUE);
    }//GEN-LAST:event_LblDesenvolvedoraMouseExited

    private void LblLunovoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblLunovoxMouseClicked
        // TODO add your handling code here:
        ConfigClass.AbrirNavegador("mailto:Lunovox<rui.gravata@hotmail.com>?subject=Usu�rio do TMW-Maker v"+FrmPrincipal.Config.getVersao());
        LblLunovox.setForeground(Color.GRAY);
        Toolkit.getDefaultToolkit().beep();
    }//GEN-LAST:event_LblLunovoxMouseClicked

    private void LblLunovoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblLunovoxMouseMoved
        // TODO add your handling code here:
        LblLunovox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LblLunovox.setForeground(Color.RED);
    }//GEN-LAST:event_LblLunovoxMouseMoved

    private void LblLunovoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblLunovoxMouseExited
        // TODO add your handling code here:
        LblLunovox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        LblLunovox.setForeground(Color.BLUE);
    }//GEN-LAST:event_LblLunovoxMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setTitle("Sobre o TMW-Maker v"+FrmPrincipal.Config.getVersao()+" ("+FrmPrincipal.Config.getOS()+":"+FrmPrincipal.Config.getArquiteturaOS()+")");
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmSplash dialog = new FrmSplash(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnSplashOk;
    private javax.swing.JLabel LblDesenvolvedora;
    private javax.swing.JLabel LblLunovox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
