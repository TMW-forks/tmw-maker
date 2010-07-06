package Formularios;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

public class FrmSplash extends javax.swing.JDialog {
    public static String TipoDePai = "";
    public FrmSplash(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        TipoDePai="jFrame";
    }
    public FrmSplash(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        TipoDePai="jDialog";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        LblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/login_wallpaper 640x480.png"))); // NOI18N
        LblFundo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(
            (Tela.width - this.getWidth()) / 2,
            (Tela.height - this.getHeight()) / 2,
            this.getWidth(),
            this.getHeight()
        );
        Thread tThread = new Thread(new Runnable() {
            public void run() {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                FrmPrincipal.PgbBarra.setIndeterminate(true);
                FrmPrincipal.PgbBarra.setString("Carregando...");

                FrmPrincipal.setAvisoEmEstatus("<html>Carregando Banco de Dados de NPCs (<font color=#FF0000>Por favor espere!</font>)");
                FrmPrincipal.NPCs = new Classes.Banco_NPCs(); //Automaticamente abre npcs.xml e outros XMLs subrelacionados (Operação Demorada)
                FrmPrincipal.setAvisoEmEstatus("<html>Carregando Banco de Dados de Itens (<font color=#FF0000>Por favor espere!</font>)");
                FrmPrincipal.Itens = new Classes.Banco_Itens(); //Automaticamente abre item_db.txt e item.xml (Operação Demorada)

                FrmPrincipal.PgbBarra.setString("Concluído");
                FrmPrincipal.setAvisoEmEstatus("Banco de Dados Eathena carregado com sucesso!");
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                FrmPrincipal.PgbBarra.setIndeterminate(false);

                dispose();
            }
        });
        tThread.start();/**/
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmSplash dialog=null;
                if(TipoDePai.equals("JFrame")) dialog = new FrmSplash(new javax.swing.JFrame(), true);
                if(TipoDePai.equals("JDialog")) dialog = new FrmSplash(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel LblFundo;
    // End of variables declaration//GEN-END:variables

}
