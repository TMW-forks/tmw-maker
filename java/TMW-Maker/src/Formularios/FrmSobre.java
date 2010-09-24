package Formularios;

import Classes.ConfigClass;
import Classes.FileClass;

public class FrmSobre extends javax.swing.JDialog {

    /** Creates new form FrmSobre */
    public FrmSobre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    String LinkFocado="";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TxpNavegador = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre o TMW-Maker");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TxpNavegador.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TxpNavegador.setContentType("text/html");
        TxpNavegador.setEditable(false);
        TxpNavegador.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TxpNavegador.setText("<html>\n\t<body \n\t\tstyle=\"margin-left:15; margin-right:15\"\n\t>\n\t\t<font face=\"verdana\">\n\t\t\t<center>\n\t\t\t\t<a href=\"http://code.google.com/p/tmw-maker\">\n\t\t\t\t\t<img \n\t\t\t\t\t\tsrc=\"http://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Imagem/Fundos/icon-tmwmaker-96x96px.png\" \n\t\t\t\t\t\tborder=\"0\"\n\t\t\t\t\t>\n\t\t\t\t</a>\t   \t\n\t\t\t\t<h1><a href=\"http://code.google.com/p/tmw-maker\">TMW-MAKER</a></h1>\n\t\t\t\t<b>VERSÃO 0.2</b> (GLP-v3)\n\t\t\t</center>\n\t\t\t<hr>\n\t\t\t<p align=\"justify\">\n\t\t\t\t<font face=\"verdana\">\n\t\t\t\t\tO TMW-Maker é um software tipo Engine, que ajudará no desenvolvimento do jogo MMORPG \n\t\t\t\t\t<a href=\"http://code.google.com/p/tmw-maker/wiki/opensource\">Open Source</a> \n\t\t\t\t\t<a href=\"http://sites.google.com/site/tmwbrasil\">The Mana World</a>, facilitando \n\t\t\t\t\ta inclusão e edição códigos de NPCs(Eathena Script), MOBs(monstros), WARPs(Portais), \n\t\t\t\tXML(Itens) até por leigos em programação através de menus intuitivos.<br/>\n\t\t\t\t</font>\n\t\t\t</p>\n\t\t\t<hr>\n\t\t\t<center>\n\t\t\t\t<font face=\"verdana\">\n\t\t\t\t\t<h2>COLABORADORES</h2>\n\t\t\t\t\t<marquee>\n\t\t\t\t\t\t<a href=\"mailto:Lunovox<rui.gravata@hotmail.com>\"><b>Lunovox</b></a>, \n\t\t\t\t\t\t<b>Ablankzim</b>, \n\t\t\t\t\t\t<b>DiogoRBG</b>, \n\t\t\t\t\t\t<b>Eugenio Favalli</b>\n\t\t\t\t\t</marquee><br/>\n\t\t\t\t\t<a href=\"http://code.google.com/p/tmw-maker/wiki/opensource\">\n\t\t\t\t\t\t<img \n\t\t\t\t\t\t\talign=\"center\" src=\"http://driblog.blogs.dri.pt/files/2010/05/opensource-400x345-t.png\" \n\t\t\t\t\t\t\twidth=\"100\" height=\"85\" border=\"0\"\n\t\t\t\t\t\t>\n\t\t\t\t\t</a>\n\t\t\t\t</font>\n\t\t\t</center> \n\t\t</font>\n\t</body>\n</html>\n");
        TxpNavegador.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                TxpNavegadorHyperlinkUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(TxpNavegador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setTitle("Sobre o TMW-Maker v"+FrmPrincipal.Config.getVersao()+" ("+FrmPrincipal.Config.getOS()+":"+FrmPrincipal.Config.getArquiteturaOS()+")");
    }//GEN-LAST:event_formWindowOpened
    private void TxpNavegadorHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_TxpNavegadorHyperlinkUpdate
        if (evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED ){
            ConfigClass.AbrirNavegador(evt.getURL().toString());
            FrmPrincipal.setAvisoEmEstatus("evt.getURL().toString()");
        }else{
            FrmPrincipal.setAvisoEmEstatus("");
        }
    }//GEN-LAST:event_TxpNavegadorHyperlinkUpdate

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmSobre dialog = new FrmSobre(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextPane TxpNavegador;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
