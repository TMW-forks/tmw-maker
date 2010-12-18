package Formularios;

import Classes.ConfigClass;

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
        TxpNavegador.setText("<html>\n    <!--\n    <head>\n        <title></title>\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n    </head>\n    -->\n    <body style=\"margin-left:15; margin-right:15\">\n        <font face=\"verdana\">\n            <center>\n                <a href=\"http://code.google.com/p/tmw-maker\">\n                    <img\n                        src=\"http://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Imagem/Fundos/icon-tmwmaker-96x96px.png\"\n                        border=\"0\"\n                        >\n                </a>\n                <h1><a href=\"http://code.google.com/p/tmw-maker\">TMW-MAKER</a></h1>\n                <b>VERSÃO JAVA</b> (GLP-v3)<br><br>\n            </center>\n            <hr>\n            <p align=\"justify\">\n                <font face=\"verdana\">\n\t\t\t\t\tO TMW-Maker é um software tipo Engine, que ajudará no desenvolvimento do jogo MMORPG\n                    <a href=\"http://code.google.com/p/tmw-maker/wiki/opensource\">Open Source</a>\n                    <a href=\"http://sites.google.com/site/tmwbrasil\">The Mana World</a>, facilitando\n\t\t\t\t\ta inclusão e edição códigos de NPCs(Eathena Script), MOBs(monstros), WARPs(Portais),\n\t\t\t\tXML(Itens) até por leigos em programação através de menus intuitivos.<br/>\n                </font>\n            </p>\n            <hr>\n            <center>\n                <font face=\"verdana\">\n                    <h2>COLABORADORES</h2>\n                    <marquee>\n                        <a href=\"mailto:Vanderson Martins do Rosario<vandersonmr2@gmail.com>\"><b>Vanderson</b></a>,\n                        <a href=\"mailto:Ablankzim<ablankzinhu@hotmail.com>\"><b>Ablankzim</b></a>,\n                        <a href=\"mailto:DiogoRBG<diogorbg@gmail.com>\"><b>DiogoRBG</b></a>,\n                        <b>Eugenio Favalli</b>, \n                        <a href=\"mailto:Lunovox<rui.gravata@hotmail.com>\"><b>Lunovox</b></a>\n                    </marquee><br/>\n                    <a href=\"http://code.google.com/p/tmw-maker/wiki/opensource\">\n                        <img\n                            align=\"center\" src=\"http://driblog.blogs.dri.pt/files/2010/05/opensource-400x345-t.png\"\n                            width=\"100\" height=\"85\" border=\"0\"\n                            >\n                    </a>\n                </font>\n            </center>\n        </font>\n    </body>\n</html>");
        TxpNavegador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setTitle("Sobre o TMW-Maker JAVA ("+FrmPrincipal.Config.getOS()+":"+FrmPrincipal.Config.getArquiteturaOS()+":"+FrmPrincipal.Config.getIdiomaDoSistema()+")");
    }//GEN-LAST:event_formWindowOpened
    private void TxpNavegadorHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_TxpNavegadorHyperlinkUpdate
        if(evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED ){
            ConfigClass.AbrirNavegador(evt.getURL().toString());
            FrmPrincipal.setAvisoEmEstatus(
                "<HTML><b>Abrindo:</b> <u><font color=\"#0000FF\">"+evt.getURL().toString()+"</u></font>",
                new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))
            );
        }else if(evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ENTERED){
            FrmPrincipal.setAvisoEmEstatus(
                evt.getURL().toString(),
                new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))
            );
        }else if(evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.EXITED){
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
