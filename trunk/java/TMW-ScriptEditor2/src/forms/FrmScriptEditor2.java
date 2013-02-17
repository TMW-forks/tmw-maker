/**
 *
 * @author Danilo
 */

package forms;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

public class FrmScriptEditor2 extends javax.swing.JFrame {
    public FrmScriptEditor2() {
		 try {
			 super.setIconImage((new ImageIcon(getClass().getResource("/imagens/botoes/sbl_grad.png"))).getImage());
		 } catch (Exception e) {
			 System.out.println("Icone erro:\n" + e.getMessage());
		 }
		 initComponents();
		 atsPalco.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
		 //atsPalco.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		 //atsPalco.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH);
		 //atsPalco.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
		 atsPalco.setTabSize(3);
    }
	 JFileChooser dialogo = new JFileChooser();

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      pnlBarraDeEstatus = new javax.swing.JPanel();
      lblBarraDeEstatus = new javax.swing.JLabel();
      jProgressBar1 = new javax.swing.JProgressBar();
      scpPalco = new javax.swing.JScrollPane();
      atsPalco = new org.fife.ui.rsyntaxtextarea.RSyntaxTextArea();
      jMenuBar1 = new javax.swing.JMenuBar();
      mnpArquivo = new javax.swing.JMenu();
      mnuArquivoNovo = new javax.swing.JMenuItem();
      mnuArquivoAbrir = new javax.swing.JMenuItem();
      mnuArquivoSalvar = new javax.swing.JMenuItem();
      mnuArquivoSalvarComo = new javax.swing.JMenuItem();
      jSeparator1 = new javax.swing.JPopupMenu.Separator();
      mnuArquivoSair = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("TMW Script Editor");

      pnlBarraDeEstatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

      lblBarraDeEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      lblBarraDeEstatus.setText("Bem vindo ao TMW-ScriptEditor!");

      javax.swing.GroupLayout pnlBarraDeEstatusLayout = new javax.swing.GroupLayout(pnlBarraDeEstatus);
      pnlBarraDeEstatus.setLayout(pnlBarraDeEstatusLayout);
      pnlBarraDeEstatusLayout.setHorizontalGroup(
         pnlBarraDeEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraDeEstatusLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblBarraDeEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      pnlBarraDeEstatusLayout.setVerticalGroup(
         pnlBarraDeEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pnlBarraDeEstatusLayout.createSequentialGroup()
            .addGroup(pnlBarraDeEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(lblBarraDeEstatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
               .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
      );

      atsPalco.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            atsPalcoCaretUpdate(evt);
         }
      });
      scpPalco.setViewportView(atsPalco);

      mnpArquivo.setMnemonic('A');
      mnpArquivo.setText("Arquivo");
      mnpArquivo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnpArquivoActionPerformed(evt);
         }
      });

      mnuArquivoNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
      mnuArquivoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_grad.png"))); // NOI18N
      mnuArquivoNovo.setText("Novo");
      mnuArquivoNovo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuArquivoNovoActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuArquivoNovo);

      mnuArquivoAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
      mnuArquivoAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_pasta.gif"))); // NOI18N
      mnuArquivoAbrir.setText("Abrir");
      mnuArquivoAbrir.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuArquivoAbrirActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuArquivoAbrir);

      mnuArquivoSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
      mnuArquivoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_disquete.gif"))); // NOI18N
      mnuArquivoSalvar.setText("Salvar");
      mnpArquivo.add(mnuArquivoSalvar);

      mnuArquivoSalvarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
      mnuArquivoSalvarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_disquete.gif"))); // NOI18N
      mnuArquivoSalvarComo.setText("Salvar Como...");
      mnuArquivoSalvarComo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuArquivoSalvarComoActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuArquivoSalvarComo);
      mnpArquivo.add(jSeparator1);

      mnuArquivoSair.setText("Sair");
      mnuArquivoSair.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuArquivoSairActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuArquivoSair);

      jMenuBar1.add(mnpArquivo);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(pnlBarraDeEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(scpPalco, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(scpPalco, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(pnlBarraDeEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

	 private void mnuArquivoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArquivoNovoActionPerformed
		FrmScriptNovo frmScriptNovo = new FrmScriptNovo(this, rootPaneCheckingEnabled);
		frmScriptNovo.setLocation(
			((this.getWidth() - frmScriptNovo.getWidth()) / 2) + this.getX(),
			((this.getHeight() - frmScriptNovo.getHeight()) / 2) + this.getY()
		);
		frmScriptNovo.pack();
		frmScriptNovo.setModal(true);
		frmScriptNovo.setVisible(true);
	 }//GEN-LAST:event_mnuArquivoNovoActionPerformed
	 private void mnuArquivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArquivoAbrirActionPerformed
		 dialogo.setDialogTitle("Abrir Código eAthena");
		 dialogo.resetChoosableFileFilters();
       dialogo.setFileFilter(new FileNameExtensionFilter("Todos os Scripts Suportados", new String[]{"npc","conf","txt"}));
		 dialogo.addChoosableFileFilter(new FileNameExtensionFilter("NPC do TMW (.npc)", "npc"));
		 dialogo.addChoosableFileFilter(new FileNameExtensionFilter("Script Genérico (.conf)", "conf"));
		 dialogo.addChoosableFileFilter(new FileNameExtensionFilter("Texto Simples (.txt)", "txt"));
		 dialogo.setAcceptAllFileFilterUsed(false);
       dialogo.setMultiSelectionEnabled(false);

		 if (dialogo.showOpenDialog(this) == dialogo.APPROVE_OPTION) {
			 try {
				 // What to do with the file, e.g. display it in a TextArea
				 atsPalco.read(new FileReader(dialogo.getSelectedFile().getAbsolutePath()), null);
				 //lblBarraDeEstatus.setText(String.format("Localizaçao do Mouse: [%d, %d]", evt.getX(), evt.getY()));
				 //lblBarraDeEstatus.setText(String.format("Localizaçao do Mouse: [%d, %d]", evt.getX(), evt.getY()));
				 this.setTitle("TMW Script Editor ["+dialogo.getSelectedFile().getName()+"]");
				 lblBarraDeEstatus.setText("Arquivo " + dialogo.getSelectedFile().getAbsolutePath() + " aberto");
			 } catch (IOException ex) {
				 lblBarraDeEstatus.setText("Problema ao acessar o arquivo " + dialogo.getSelectedFile().getAbsolutePath());
			 }
		 } else {
			 lblBarraDeEstatus.setText("Acesso ao arquivo cancelado pelo usuário.");
		 }
	 }//GEN-LAST:event_mnuArquivoAbrirActionPerformed
	 private void mnuArquivoSalvarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArquivoSalvarComoActionPerformed
		 dialogo.setDialogTitle("Salvar Código eAthena");
		 dialogo.resetChoosableFileFilters();
		 dialogo.setFileFilter(new FileNameExtensionFilter("NPC do TMW (.npc)", "npc"));
		 dialogo.addChoosableFileFilter(new FileNameExtensionFilter("Script Genérico (.conf)", "conf"));
		 dialogo.addChoosableFileFilter(new FileNameExtensionFilter("Texto Simples (.txt)", "txt"));
		 dialogo.setAcceptAllFileFilterUsed(false);
       dialogo.setMultiSelectionEnabled(false);

		 if (dialogo.showSaveDialog(this) == dialogo.APPROVE_OPTION) {
		 //if (dialogo.showSaveDialog(FrmScriptEditor2.this) == dialogo.APPROVE_OPTION) {
			 try {
				 if (dialogo.getSelectedFile().exists()) {
					 if (JOptionPane.showConfirmDialog(null, "Arquivo já existe. \n Deseja sobrescrever?", "Aviso!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						 BufferedWriter writer = new BufferedWriter(new FileWriter(dialogo.getSelectedFile()));
						 writer.write(atsPalco.getText());
						 writer.close();
						 this.setTitle("TMW Script Editor ["+dialogo.getSelectedFile().getName()+"]");
					 } else {
						 lblBarraDeEstatus.setText("Gravação do arquivo " + dialogo.getSelectedFile().getName() + " cancelado");
					 }
				 }
				 if (!dialogo.getSelectedFile().exists()) {
					 BufferedWriter writer = new BufferedWriter(new FileWriter(dialogo.getSelectedFile()));
					 writer.write(atsPalco.getText());
					 writer.close();
					 lblBarraDeEstatus.setText("Arquivo " + dialogo.getSelectedFile().getName() + " salvo com sucesso!");
				 }
			 } catch (IOException ex) {
				 Logger.getLogger(FrmScriptEditor2.class.getName()).log(Level.SEVERE, null, ex);
			 }
		 }
	 }//GEN-LAST:event_mnuArquivoSalvarComoActionPerformed
	 private void mnpArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnpArquivoActionPerformed
		 // TODO add your handling code here:
	 }//GEN-LAST:event_mnpArquivoActionPerformed
	 private void mnuArquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArquivoSairActionPerformed
		 this.dispose();
	 }//GEN-LAST:event_mnuArquivoSairActionPerformed

	 private void atsPalcoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_atsPalcoCaretUpdate
		 lblBarraDeEstatus.setText("Linha:" + atsPalco.getCaretLineNumber() + " Posição:" + atsPalco.getCaretOffsetFromLineStart());
	 }//GEN-LAST:event_atsPalcoCaretUpdate

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmScriptEditor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmScriptEditor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmScriptEditor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmScriptEditor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }/**/

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
					FrmScriptEditor2 frmScriptEditor = new FrmScriptEditor2();
					frmScriptEditor.setExtendedState(MAXIMIZED_BOTH);
					frmScriptEditor.setVisible(true);
            }
        });
    }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   public org.fife.ui.rsyntaxtextarea.RSyntaxTextArea atsPalco;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JProgressBar jProgressBar1;
   private javax.swing.JPopupMenu.Separator jSeparator1;
   public javax.swing.JLabel lblBarraDeEstatus;
   private javax.swing.JMenu mnpArquivo;
   private javax.swing.JMenuItem mnuArquivoAbrir;
   private javax.swing.JMenuItem mnuArquivoNovo;
   private javax.swing.JMenuItem mnuArquivoSair;
   private javax.swing.JMenuItem mnuArquivoSalvar;
   private javax.swing.JMenuItem mnuArquivoSalvarComo;
   private javax.swing.JPanel pnlBarraDeEstatus;
   private javax.swing.JScrollPane scpPalco;
   // End of variables declaration//GEN-END:variables
}
