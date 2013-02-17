/**
 * @author Danilo
 */
package forms;

public class FrmScriptNovo extends javax.swing.JDialog {

	public FrmScriptNovo(FrmScriptEditor2 parent, boolean modal) {
		super(parent, modal);
		this.frmScriptEditor2 = parent;
		initComponents();
	}
	FrmScriptEditor2 frmScriptEditor2;

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      nomePersonagem = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      CoordX = new javax.swing.JTextField();
      CoordY = new javax.swing.JTextField();
      jComboBox1 = new javax.swing.JComboBox();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      mapaNPC = new javax.swing.JTextField();
      jLabel6 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      descricaoNPC = new javax.swing.JTextArea();
      jLabel7 = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      autorNPC = new javax.swing.JTextField();
      jComboBox2 = new javax.swing.JComboBox();
      jLabel9 = new javax.swing.JLabel();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Novo Script");

      jLabel1.setText("Nome do NPC:");

      jLabel2.setText("Coordenada X:");

      jLabel3.setText("Coordenada Y:");
      jLabel3.setToolTipText("");

      jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Script", "Função" }));
      jComboBox1.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jComboBox1ItemStateChanged(evt);
         }
      });

      jLabel4.setText("Formato de NPC:");

      jLabel5.setText("Mapa:");

      jLabel6.setText(".gat");

      descricaoNPC.setColumns(20);
      descricaoNPC.setRows(5);
      jScrollPane1.setViewportView(descricaoNPC);

      jLabel7.setText("Descrição:");

      jLabel8.setText("Autor:");

      jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

      jLabel9.setText("Imagem do NPC:");

      jButton1.setText("Salvar");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setText("Cancelar");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jLabel1)
                     .addComponent(nomePersonagem)
                     .addComponent(jLabel2)
                     .addComponent(jLabel3)
                     .addComponent(CoordX)
                     .addComponent(CoordY)
                     .addComponent(jLabel4)
                     .addComponent(jComboBox1, 0, 87, Short.MAX_VALUE)
                     .addComponent(mapaNPC))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel6)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel7)
                           .addComponent(jLabel8)
                           .addComponent(autorNPC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(186, 186, 186))
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(jLabel9)
                           .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel5)
                  .addContainerGap(409, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jButton2)
                  .addGap(0, 294, Short.MAX_VALUE))))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(jLabel8))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(nomePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(autorNPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(mapaNPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel6))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(CoordX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel3)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(CoordY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel4)
                     .addComponent(jLabel9))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton1)
               .addComponent(jButton2))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		 if (jComboBox1.getSelectedIndex() == 0) {
			 String nomeNPC = nomePersonagem.getText();
			 String autorScript = autorNPC.getText();
			 String descricao = descricaoNPC.getText();
			 String mapa = mapaNPC.getText();
			 String x = CoordX.getText();
			 String y = CoordY.getText();

			 String texto =
						  "/////////////////////////////////////////////////////\n"
						+ "// TMW-Script-Editor Versao 2.0\n"
						+ "// Criado por: " + autorScript + "            \n"
						+ "// Descriçao: " + descricao + "           \n"
						+ "/////////////////////////////////////////////////////\n"
						+ "\n"
						+ "" + mapa + ".gat," + x + "," + y + ",0\tscript\t" + nomeNPC + " 0, {\n"
						+ "\n"
						+ "//Insira seu código aqui...\n"
						+ "\n"
						+ "}\n";
			 frmScriptEditor2.atsPalco.setText(texto);
			 frmScriptEditor2.lblBarraDeEstatus.setText("Script gerado com sucesso!");
		 } else {
			 String nomeNPC = nomePersonagem.getText();
			 String autorScript = autorNPC.getText();
			 String descricao = descricaoNPC.getText();

			 String texto =
						"/////////////////////////////////////////////////////\n"
						+ "// IDE: TMW-Script-Editor Versao 1.0\n"
						+ "// @author " + autorScript + "            \n"
						+ "// Descriçao: " + descricao + "           \n"
						+ "/////////////////////////////////////////////////////\n"
						+ "\n"
						+ "function\t" + nomeNPC + "\t{\n"
						+ "\n"
						+ "}\n";
			 frmScriptEditor2.atsPalco.setText(texto);
			 frmScriptEditor2.lblBarraDeEstatus.setText("Script gerado com sucesso!");
		 }
		 dispose();
		 frmScriptEditor2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		 dispose();
		 frmScriptEditor2.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
		 if (jComboBox1.getSelectedIndex() == 1) {
			 mapaNPC.setEnabled(false);
			 CoordX.setEnabled(false);
			 CoordY.setEnabled(false);
			 jComboBox2.setEnabled(false);
		 } else {
			 mapaNPC.setEnabled(true);
			 CoordX.setEnabled(true);
			 CoordY.setEnabled(true);
			 jComboBox2.setEnabled(true);
		 }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		System.out.println("Fechando janela...");
		frmScriptEditor2.setEnabled(true);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FrmScriptNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrmScriptNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrmScriptNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmScriptNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new FrmScriptNovo(null, false).setVisible(true);
			}
		});
	}
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField CoordX;
   private javax.swing.JTextField CoordY;
   private javax.swing.JTextField autorNPC;
   private javax.swing.JTextArea descricaoNPC;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JComboBox jComboBox1;
   private javax.swing.JComboBox jComboBox2;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextField mapaNPC;
   private javax.swing.JTextField nomePersonagem;
   // End of variables declaration//GEN-END:variables
}
