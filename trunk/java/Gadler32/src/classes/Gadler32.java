/**
 *###################################################################################
 *##///////////////////////////////////////////////////////////////////////////////##
 *##|        ___       ___       ___       ___       ___        ___       ___     |##
 *##|       /\__\     /\__\     /\__\     /\  \     /\__\      /\  \     /\__\    |##
 *##|      /:/  /    /:/ _/_   /:| _|_   /::\  \   /:/  /__   /::\  \   /:/  /__  |##
 *##|     /:/  /    /:/ /\__\ /::|/\  \ /:/\:\__\ /:/  /\  \ /:/\:\__\ _|:|_/\__\ |##
 *##|    /:/  /    /:/ /:/  //:::::/  //:/ /:/  / |:| /:/  //:/ /:/  //:__::_/__/ |##
 *##|    \:\  \    \:\/:/  / \/|::/  / \:\/:/  /  |:|/:/  / \:\/:/  / \/_|:|__\   |##
 *##|     \:\__\    \::/  /    |:/  /   \::/  /   |:::/  /   \::/  /     /:/  /   |##
 *##|      \/__/     \/__/     \/__/     \/__/    \__/__/     \/__/      \/__/    |##
 *##|                                                                             |##
 *##///////////////////////////////////////////////////////////////////////////////##
 *###################################################################################
 * @author → Lunovox <rui.gravata@gmail.com>
 * @version → 2012-06-01
 * @description → Programa/Biblioteca geradora de checksum adller32
 * @licence → GNU GPL v3: http://www.gnu.org/licenses/gpl.html
 * @msn → rui.gravata@hotmail.com
 * @gTalk → rui.gravata@gmail.com
 * @skype → lunovox
 * @PhoneIP: sip:lunovox@ekiga.net
 */
package classes;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Adler32;


public class Gadler32 extends javax.swing.JFrame {
	public Gadler32() {
		super.setIconImage((new ImageIcon(getClass().getResource("/imagens/keys_small.gif"))).getImage());
		initComponents();
	}
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      btnSelecionar = new javax.swing.JButton();
      lblArquivo1 = new javax.swing.JLabel();
      txtCheckSum = new javax.swing.JTextField();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Grafic Adler32");
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
         }
      });

      btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/open16.png"))); // NOI18N
      btnSelecionar.setText("Selecionar");
      btnSelecionar.setToolTipText("Selecione um arquivo para gerar o numero Checksum Adler32");
      btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSelecionarActionPerformed(evt);
         }
      });

      lblArquivo1.setText("CheckSum:");

      txtCheckSum.setBackground(java.awt.SystemColor.controlHighlight);
      txtCheckSum.setEditable(false);
      txtCheckSum.setFont(new java.awt.Font("Ubuntu", 0, 18));
      txtCheckSum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      txtCheckSum.setText("-----------");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblArquivo1)
            .addGap(6, 6, 6)
            .addComponent(txtCheckSum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSelecionar)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
               .addComponent(txtCheckSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblArquivo1)
               .addComponent(btnSelecionar))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSelecionar, lblArquivo1, txtCheckSum});

      pack();
   }// </editor-fold>//GEN-END:initComponents

	public static String getAdler32CheckSumHexadecimal(String $Endereco) {
		return Long.toHexString( // ← Transforma Long em Hexadecimal
				  getAdler32CheckSumLong($Endereco));
	}
	public static long getAdler32CheckSumLong(String $Endereco) {
		Adler32 adler32 = new Adler32();
		adler32.reset();
		try {
			FileInputStream $Capsula = new FileInputStream($Endereco);
			while ($Capsula.available() > 0) {
				byte[] buffer = new byte[262144];	// buffer de 256 Kb
				int $Parte = $Capsula.read(buffer);
				if ($Parte > 0) {
					adler32.update(buffer, 0, $Parte);
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(Gadler32.class.getName()).log(Level.SEVERE, null, ex);
		}
		return adler32.getValue(); // ← Faz do Checksum
	}

	 private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
		 // TODO add your handling code here:
		 /**
		  * Material Pesquisado em:
		  * http://java.sun.com/docs/books/tutorial/uiswing/components/filechooser.html
		  * http://www.koders.com/java/fid3C76E6EFEBC0827517FB14397E0D8E9E5126DD92.aspx
		  */
		 //Handle open button action.
		 //evt.getSource() == openButton
		 //Create a file chooser
		 final JFileChooser Dialogo = new JFileChooser();
		 //Dialogo.setFileFilter(new FileNameExtensionFilter("Arquivo PNG", "png"));
		 //Dialogo.addChoosableFileFilter(new FileNameExtensionFilter("Arquivo JPG", "jpg"));
		 Dialogo.setAcceptAllFileFilterUsed(false);

		 int Teste = Dialogo.showOpenDialog(this);
		 if (Teste == JFileChooser.APPROVE_OPTION) {
			 //txtEndereco.setText(Dialogo.getCurrentDirectory().getPath()+Dialogo.getSelectedFile().getName());
			 txtCheckSum.setText(getAdler32CheckSumHexadecimal(Dialogo.getSelectedFile().toString()));
			 txtCheckSum.setToolTipText("CheckSum Adllder32 do arquivo '" + Dialogo.getSelectedFile().toString() + "'.");
		 } else {
			 //log.append("Open command cancelled by user." + newline);
		 }
}//GEN-LAST:event_btnSelecionarActionPerformed
	 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		 // TODO add your handling code here:
		 Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
		 this.setBounds(
					(Tela.width - this.getWidth()) / 2,
					(Tela.height - this.getHeight()) / 2,
					this.getWidth(),
					this.getHeight());
		 //this.setExtendedState(MAXIMIZED_BOTH); //Maximiza a tela
	 }//GEN-LAST:event_formWindowOpened

	/**
	 * @param args the command line arguments
	 */
	private static void printHelp() {
		System.out.println("###################################################################################");
		System.out.println("##///////////////////////////////////////////////////////////////////////////////##");
		System.out.println("##|        ___       ___       ___       ___       ___        ___       ___     |##");
		System.out.println("##|       /\\__\\     /\\__\\     /\\__\\     /\\  \\     /\\__\\      /\\  \\     /\\__\\    |##");
		System.out.println("##|      /:/  /    /:/ _/_   /:| _|_   /::\\  \\   /:/  /__   /::\\  \\   /:/  /__  |##");
		System.out.println("##|     /:/  /    /:/ /\\__\\ /::|/\\  \\ /:/\\:\\__\\ /:/  /\\  \\ /:/\\:\\__\\ _|:|_/\\__\\ |##");
		System.out.println("##|    /:/  /    /:/ /:/  //:::::/  //:/ /:/  / |:| /:/  //:/ /:/  //:__::_/__/ |##");
		System.out.println("##|    \\:\\  \\    \\:\\/:/  / \\/|::/  / \\:\\/:/  /  |:|/:/  / \\:\\/:/  / \\/_|:|__\\   |##");
		System.out.println("##|     \\:\\__\\    \\::/  /    |:/  /   \\::/  /   |:::/  /   \\::/  /     /:/  /   |##");
		System.out.println("##|      \\/__/     \\/__/     \\/__/     \\/__/    \\__/__/     \\/__/      \\/__/    |##");
		System.out.println("##|                                                                             |##");
		System.out.println("##///////////////////////////////////////////////////////////////////////////////##");
		System.out.println("###################################################################################");
		System.out.println(" @author → Lunovox <rui.gravata@gmail.com>");
		System.out.println(" @version → 2012-06-01");
		System.out.println(" @description → Programa/Biblioteca geradora de checksum adller32");
		System.out.println(" @licence → GNU GPL v3: http://www.gnu.org/licenses/gpl.html");
		System.out.println(" @msn → rui.gravata@hotmail.com");
		System.out.println(" @gTalk → rui.gravata@gmail.com");
		System.out.println(" @skype → lunovox");
		System.out.println(" @PhoneIP → sip:lunovox@ekiga.net");
		System.out.println("###################################################################################");
	}
	public static void main(String args[]) {
		printHelp();
		//System.out.println(" → " + getAdler32CheckSumHexadecimal("/home/lunovox/Desenvolvimento/TMW/updates/musicas_2010-11-13.zip"));
		//System.out.println(" → " + Long.toHexString(getAdler32CheckSumLong("/home/lunovox/Desenvolvimento/TMW/updates/musicas_2010-11-13.zip")));
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new Gadler32().setVisible(true);
			}
		});/**/
	}
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnSelecionar;
   private javax.swing.JLabel lblArquivo1;
   private javax.swing.JTextField txtCheckSum;
   // End of variables declaration//GEN-END:variables
}
