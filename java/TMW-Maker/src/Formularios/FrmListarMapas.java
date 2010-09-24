
package Formularios;

import Classes.DialogClass;
import Classes.FileClass;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrmListarMapas extends javax.swing.JDialog {
    public FrmListarMapas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    static String Barra = System.getProperty("file.separator");
    public static String Tiled=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmw-maker"+Barra+"tiled.jar";
    public static String PastaDeMapas=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"maps";
    public static String PastaDeMiniaturas=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"minimaps";
    public static String PastaDeColisoes=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"data";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        BtnAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Fortaleza", "<html>005.tmx<br/>005.wlk<br/>005.pnp", "200x140t", "400x280px", "Magick - Real.ogg"}
            },
            new String [] {
                "Mapa", "Arquivo", "Tamanho", "Miniatura", "Musica"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(46);
        jScrollPane1.setViewportView(jTable1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        BtnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        BtnAbrir.setText("Abrir");
        BtnAbrir.setFocusable(false);
        BtnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAbrir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void AbrirMapa(String Endereco){
        if(FileClass.seExiste(Tiled)){
            if(FileClass.seExiste(Endereco)){
                String Comando="";
                Runtime Executador = Runtime.getRuntime();
                Process Retorno=null;
                String line="";
                try {
                    Comando = "java -jar "+Tiled+" "+Endereco;/**/
                    System.out.println(Comando);
                    Retorno=Executador.exec(Comando);
                    BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                        FrmPrincipal.setAvisoEmEstatus("<html>ENVIADO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                    }
                    FrmPrincipal.setAvisoEmEstatus("Mapa: "+Endereco);
                } catch (IOException e) {
                    FrmPrincipal.setAvisoEmEstatus("<html>Falha ao abrir o mapa no programa \"<font color=\"#FF0000\">tiled.jar</font>\"!");
                    DialogClass.showErro("<html>" +
                        "Falha ao abrir o mapa no programa \"<font color=\"#FF0000\">tiled.jar</font>\"!<br/>"
                        , "ERRO"
                    );
                }
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html>Arquivo inexistente:\"<font color=\"#FF0000\">"+Endereco+"</font>\"!");
                DialogClass.showErro("<html>" +
                    "Arquivo inexistente:<br/>" +
                    "\"<font color=\"#FF0000\">"+Endereco+"</font>\"!!<br/>"
                    , "ERRO"
                );
            }
        }
    }

    private void BtnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirActionPerformed
        AbrirMapa(PastaDeMapas+Barra+"005.tmx");
    }//GEN-LAST:event_BtnAbrirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmListarMapas dialog = new FrmListarMapas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnAbrir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
