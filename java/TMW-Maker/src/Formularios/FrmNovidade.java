
package Formularios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FrmNovidade extends javax.swing.JDialog {
    public FrmNovidade(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void CarregarDaInternet(){
        try {
            // Create a URL for the desired page
            String Endereco = "http://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Testos/news.html";
            URL arquivo = new URL(Endereco);
            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(arquivo.openStream()));
            String str, Conteudo="";
            int contador=0;
            while ((str = in.readLine()) != null) {
                contador += 1;
                Conteudo+=(Conteudo.equals("")?str:"\n"+str);
            }
            in.close();
            LblNovidades.setText(Conteudo);
        } catch (IOException e) {
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblNovidades = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novidades desta atualização...");
        setIconImage(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        LblNovidades.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        LblNovidades.setText("<html>\n    <body>\n        <font face=\"SansSerif\" size=\"2\">\n            <h1><font color=\"#0000FF\">TMW-MAKER versão 0.2</font></h1>\n            <h2><font color=\"#000088\">O que o TMW-MAKER já faz?</font></h2>\n            <ul>\n                <li>Baixa códigos do Jogo.</li>\n                <li>Instala códigos do Jogo.</li>\n                <li>Executa códigos do Jogo.</li>\n                <li>Baixa auto-update.</li>\n                <li>Exibe Itens do Jogo.</li>\n                <li>Edita pode GM de conta.</li>\n            </ul>\n            <h2><font color=\"#000088\">O que o TMW-Maker fará no futuro?</font></h2>\n            <ul>\n                <li>Adicionar novos Sprites de Equipamentos.</li>\n                <li>Adicionar novos Sprites de Personagens.</li>\n                <li>Adicionar novos Icones de Equipamentos.</li>\n                <li>Adicionar novos Scripts de Equipamentos.</li>\n                <li>Adicionar novos Scripts de Personagens.</li>\n            </ul>\n            <font color=\"#0000FF\"><b>OBSERVAÇÃO:</b></font> Não é possivel predizer com precisão o que o TMW-Maker fará nem quando será concluído, pois estamos com poucos programadores responsáveis pelo desenvolvimento deste programa.\n        </font>\n    </body>\n</html>");
        LblNovidades.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblNovidades, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblNovidades, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //CarregarDaInternet();
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JLabel LblNovidades;
    // End of variables declaration//GEN-END:variables

}
