/*
 * FrmImportador.java
 * @author lunovox
 * Created on 17/06/2012, 22:25:05
 */
package formularios;

import classes.FileClass;
import java.util.Vector;

public class FrmImportador extends javax.swing.JDialog {
	public FrmImportador(java.awt.Frame parent, boolean modal, String $PastaLocalhost) {
		super(parent, modal);
		pastaLocalhost=$PastaLocalhost;
		//baseScripts = pastaLocalhost + Barra + "eathena-data" + Barra + "npc";
		pastaDeMapas = pastaLocalhost + Barra + "tmwdata" + Barra + "maps";
		initComponents();
	}
	private static String Barra = System.getProperty("file.separator");
	String pastaLocalhost;
	private static String pastaDeMapas;
	private static Vector MapasFiltrados = new Vector();
	//bdWarps
	//static Banco_Mapas bdWarps;


	private void ListarMapas() {
		String $Mapas[] = FileClass.listarArquivos(pastaDeMapas);
		MapasFiltrados.clear();
		for (int $m = 0; $m < $Mapas.length; $m++) {
			if ($Mapas[$m].toLowerCase().indexOf(".tmx")>=0) {
				MapasFiltrados.add($Mapas[$m]);
			}
		}/**/
		lstMapas.setModel(new javax.swing.AbstractListModel() {
			public int getSize() { return MapasFiltrados.size(); }
			public Object getElementAt(int i) { return MapasFiltrados.get(i); }
		});/**/
	}

	/*public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {
	public void run() {
	FrmImportador dialog = new FrmImportador(new javax.swing.JFrame(), true,"");
	dialog.addWindowListener(new java.awt.event.WindowAdapter() {
	public void windowClosing(java.awt.event.WindowEvent e) {
	System.exit(0);
	}
	});
	dialog.setVisible(true);
	}
	});
	}/**/
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jTabbedPane1 = new javax.swing.JTabbedPane();
      jPanel1 = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      lstMapas = new javax.swing.JList();
      btnImportar = new javax.swing.JButton();
      btnCompilar = new javax.swing.JButton();
      lblMiniatura = new javax.swing.JLabel();
      btnAbrir = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();
      jTextField1 = new javax.swing.JTextField();

      setTitle("Importador");
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
         }
      });

      lstMapas.setModel(new javax.swing.AbstractListModel() {
         String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      lstMapas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            lstMapasValueChanged(evt);
         }
      });
      jScrollPane1.setViewportView(lstMapas);

      btnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_dependencias.gif"))); // NOI18N
      btnImportar.setText("Importar");

      btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_atomico.gif"))); // NOI18N
      btnCompilar.setText("Compilar");
      btnCompilar.setEnabled(false);

      lblMiniatura.setBackground(java.awt.Color.gray);
      lblMiniatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblMiniatura.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
      lblMiniatura.setOpaque(true);

      btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_pasta.gif"))); // NOI18N
      btnAbrir.setText("Abrir");
      btnAbrir.setEnabled(false);

      jLabel1.setText("Nome:");

      jTextField1.setEditable(false);
      jTextField1.setOpaque(false);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(lblMiniatura, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(btnImportar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnCompilar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnAbrir))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)))
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1)
                     .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(lblMiniatura, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btnImportar)
                     .addComponent(btnCompilar)
                     .addComponent(btnAbrir))))
            .addContainerGap())
      );

      jTabbedPane1.addTab("Mapas", jPanel1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
            .addContainerGap())
      );
   }// </editor-fold>//GEN-END:initComponents

	private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		// TODO add your handling code here:
		ListarMapas();
	}//GEN-LAST:event_formWindowOpened

	private void lstMapasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstMapasValueChanged
		// TODO add your handling code here:
		btnCompilar.setEnabled(true);
		btnAbrir.setEnabled(true);
		this.setTitle(lstMapas.getSelectedValue().toString());
	}//GEN-LAST:event_lstMapasValueChanged

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAbrir;
   private javax.swing.JButton btnCompilar;
   private javax.swing.JButton btnImportar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTabbedPane jTabbedPane1;
   private javax.swing.JTextField jTextField1;
   private javax.swing.JLabel lblMiniatura;
   private javax.swing.JList lstMapas;
   // End of variables declaration//GEN-END:variables

}
