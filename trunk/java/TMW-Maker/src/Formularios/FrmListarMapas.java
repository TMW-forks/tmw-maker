
package Formularios;

import Classes.ConfigClass;
import Classes.DialogClass;
import Classes.FileClass;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import javax.lang.model.element.Element;

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Fortaleza", "<html>005.tmx<br/>005.tmx<br/>005.tmx<br/>005.tmx", "200x140t"}
            },
            new String [] {
                "Mapa", "Arquivo", "Tamanho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(65);
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
        if(FrmPrincipal.Config.SeComandoProcede("tiled --help") || FileClass.seExiste(Tiled)){
            if(FileClass.seExiste(Endereco)){
                String Comando="";
                Runtime Executador = Runtime.getRuntime();
                Process Retorno=null;
                String line="";
                try {
                    if(FrmPrincipal.Config.SeComandoProcede("tiled --help")){
                        Comando = "tiled "+Endereco;/**/
                    }else{
                        Comando = "java -jar "+Tiled+" "+Endereco;
                    }
                    System.out.println(Comando);
                    Retorno=Executador.exec(Comando);
                    BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                        FrmPrincipal.setAvisoEmEstatus("<html>ENVIADO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                    }
                    if(FrmPrincipal.Config.SeComandoProcede("tiled --help")){
                        FrmPrincipal.setAvisoEmEstatus("Tiled Qt: "+Endereco);
                    }else{
                        FrmPrincipal.setAvisoEmEstatus("Tiled Java: "+Endereco);
                    }
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
        //String Arquivo=jTable1.getModel().getValueAt(jTable1.getSelectedRow(),1).toString();
        String Arquivo=FrmPrincipal.Mundo.getMapaPorOrdem(jTable1.getSelectedRow()).getArquivo();
        AbrirMapa(PastaDeMapas+Barra+Arquivo);
    }//GEN-LAST:event_BtnAbrirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Vector Mapa = new Vector();

        for(int M=0;M<FrmPrincipal.Mundo.getContMapas();M++){
            Vector Linha = new Vector();
            Linha.addElement(FrmPrincipal.Mundo.getMapaPorOrdem(M).getNome());
            Linha.addElement("<html>"+
                "<b>Mapa:</b> "+FrmPrincipal.Mundo.getMapaPorOrdem(M).getArquivo()+"<br/>"+
                "<b>Colisão:</b> "+FrmPrincipal.Mundo.getMapaPorOrdem(M).getColisao()+"<br/>"+
                "<b>Miniatura:</b> "+FrmPrincipal.Mundo.getMapaPorOrdem(M).getMiniatura()+"<br/>"+
                "<b>Música:</b> "+FrmPrincipal.Mundo.getMapaPorOrdem(M).getMusica()
            );
            Linha.addElement(
                FrmPrincipal.Mundo.getMapaPorOrdem(M).getLargura()+"x"+
                FrmPrincipal.Mundo.getMapaPorOrdem(M).getAltura()
            );
            Mapa.add(Linha);
        }
        //Vector Cabecalho[] = ;
        Vector Cabecalho = new Vector();
        Cabecalho.addElement("Mapa");
        Cabecalho.addElement("Arquivo");
        Cabecalho.addElement("Tamanho");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(Mapa,Cabecalho) {
            boolean[] canEdit = new boolean [] {false, true, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }//GEN-LAST:event_formWindowOpened

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
