
package Formularios;

import Classes.ConfigClass;
import Classes.FileClass;

public class FrmNovidade extends javax.swing.JDialog {
    public FrmNovidade(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TxpNovidades = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novidades desta atualização...");
        setIconImage(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TxpNovidades.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TxpNovidades.setContentType("text/html");
        TxpNovidades.setEditable(false);
        TxpNovidades.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TxpNovidades.setText("<html>\n\t<body\n\t\tstyle=\"margin-left:15; margin-right:15\"\n\t>\n\t\t<font face=\"verdana\">\n\t\t\t<center>\n\t\t\t\t<a href=\"http://code.google.com/p/tmw-maker\">\n\t\t\t\t\t<img\n\t\t\t\t\t\tsrc=\"http://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Imagem/Fundos/icon-tmwmaker-96x96px.png\"\n\t\t\t\t\t\tborder=\"0\"\n\t\t\t\t\t>\n\t\t\t\t</a>\n\t\t\t\t<h1><a href=\"http://code.google.com/p/tmw-maker\">TMW-MAKER</a></h1>\n\t\t\t\t<b>VERSÃO 0.2</b> (GLP-v3)\n\t\t\t</center>\n\t\t\t<hr>\n\t\t\t<p align=\"justify\">\n                            <font face=\"Verdade\">\n                                <h2><font color=\"#000088\">O que o TMW-MAKER já faz?</font></h2>\n                                <ul>\n                                    <li>Baixa códigos do Jogo.</li>\n                                    <li>Instala códigos do Jogo.</li>\n                                    <li>Executa códigos do Jogo.</li>\n                                    <li>Baixa auto-update.</li>\n                                    <li>Exibe Itens do Jogo.</li>\n                                    <li>Edita pode GM de conta.</li>\n                                </ul>\n                                <h2><font color=\"#000088\">O que o TMW-Maker fará no futuro?</font></h2>\n                                <ul>\n                                    <li>Adicionar novos Sprites de Equipamentos.</li>\n                                    <li>Adicionar novos Sprites de Personagens.</li>\n                                    <li>Adicionar novos Icones de Equipamentos.</li>\n                                    <li>Adicionar novos Scripts de Equipamentos.</li>\n                                    <li>Adicionar novos Scripts de Personagens.</li>\n                                </ul>\n                                <font color=\"#0000FF\"><b>OBSERVAÇÃO:</b></font> Não é possivel predizer com precisão o que o\n                                TMW-Maker fará nem quando será concluído, pois estamos com poucos programadores responsáveis\n                                pelo desenvolvimento deste programa.\n                            </font>\n\t\t\t</p>\n\t\t\t<hr>\n\t\t\t<center>\n\t\t\t\t<font face=\"verdana\">\n\t\t\t\t\t<h2>COLABORADORES</h2>\n\t\t\t\t\t<marquee>\n\t\t\t\t\t\t<a href=\"mailto:Lunovox<rui.gravata@hotmail.com>\"><b>Lunovox</b></a>,\n\t\t\t\t\t\t<b>Ablankzim</b>,\n\t\t\t\t\t\t<b>DiogoRBG</b>,\n\t\t\t\t\t\t<b>Eugenio Favalli</b>\n\t\t\t\t\t</marquee><br/>\n\t\t\t\t\t<a href=\"http://code.google.com/p/tmw-maker/wiki/opensource\">\n\t\t\t\t\t\t<img\n\t\t\t\t\t\t\talign=\"center\" src=\"http://driblog.blogs.dri.pt/files/2010/05/opensource-400x345-t.png\"\n\t\t\t\t\t\t\twidth=\"100\" height=\"85\" border=\"0\"\n\t\t\t\t\t\t>\n\t\t\t\t\t</a>\n\t\t\t\t</font>\n\t\t\t</center>\n\t\t</font>\n\t</body>\n</html>");
        TxpNovidades.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                TxpNovidadesHyperlinkUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(TxpNovidades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String Endereco = "http://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Testos/news.html";
        TxpNovidades.setText(FileClass.urlAbrir(Endereco));

    }//GEN-LAST:event_formWindowOpened

    private void TxpNovidadesHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_TxpNovidadesHyperlinkUpdate
        if (evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED ){
            ConfigClass.AbrirNavegador(evt.getURL().toString());
            FrmPrincipal.setAvisoEmEstatus("evt.getURL().toString()");
        }else{
            FrmPrincipal.setAvisoEmEstatus("");
        }
}//GEN-LAST:event_TxpNovidadesHyperlinkUpdate

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmNovidade dialog = new FrmNovidade(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextPane TxpNovidades;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
