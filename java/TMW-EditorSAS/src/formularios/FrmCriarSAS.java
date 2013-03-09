/**
 * FrmCriarSAS.java
 * Created on 04/02/2013, 19:51:09
 * @author lunovox
 */
package formularios;

import classes.DialogClass;
import classes.FileClass;
import classes.ImagemClass;
import java.io.File;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class FrmCriarSAS extends javax.swing.JDialog {

	public FrmCriarSAS(FrmEditorSAS parent, boolean modal) {
		super(parent, modal);
		frmAnimationEditor = parent;
		initComponents();
		ListarBases();
	}
	FrmEditorSAS frmAnimationEditor;
	JFileChooser dialogo = new JFileChooser();
	ImagemClass miniatura = null;
	private String bar = System.getProperty("file.separator");

	public void ListarBases() {
		/*Vector LIstarIDs = new Vector();
		for (int v = 0; v < getContMonstros(); v++) {
		LIstarIDs.addElement(getMonstroPorOrdem(v).getID() + ": " + getMonstroPorOrdem(v).getNomeTitulo());
		}/**/

		Vector $BasesFiltradas = new Vector();
		String $Bases[] = FileClass.listarArquivos(frmAnimationEditor.pastaDeSprites);
		$BasesFiltradas.clear();
		$BasesFiltradas.addElement("<NENHUMA>");
		int $xmlSelect = 0;
		for (int $b = 0; $b < $Bases.length; $b++) {
			if ($Bases[$b].toLowerCase().endsWith(".xml")
					  && ($Bases[$b].toLowerCase().startsWith("monster-")
					  || $Bases[$b].toLowerCase().startsWith("monstro-")
					  || $Bases[$b].toLowerCase().startsWith("player_"))) {
				//$BasesFiltradas.add($Bases[$b]);
				$BasesFiltradas.addElement($Bases[$b]);
				if($Bases[$b].equals("player_male_base.xml")){$xmlSelect = $BasesFiltradas.size()-1;}
			}
		}/**/
		if ($BasesFiltradas != null && $BasesFiltradas.size() > 0) {
			cmbBase.setModel(new javax.swing.DefaultComboBoxModel($BasesFiltradas.toArray()));
			cmbBase.setSelectedIndex($xmlSelect);
		}
	}

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      txtSpriteUrl = new javax.swing.JTextField();
      btnSelecionar = new javax.swing.JButton();
      jLabel2 = new javax.swing.JLabel();
      spnSpriteLinhas = new javax.swing.JSpinner();
      jLabel3 = new javax.swing.JLabel();
      spnSpriteColunas = new javax.swing.JSpinner();
      btnCancelar = new javax.swing.JButton();
      btnGerar = new javax.swing.JButton();
      lblVisualizar = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      cmbBase = new javax.swing.JComboBox();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Nova Sequência de Animação de Sprites");
      setResizable(false);

      txtSpriteUrl.setBackground(java.awt.Color.lightGray);
      txtSpriteUrl.setEditable(false);

      btnSelecionar.setMnemonic('S');
      btnSelecionar.setText("Selecionar");
      btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSelecionarActionPerformed(evt);
         }
      });

      jLabel2.setText("Linhas:");

      spnSpriteLinhas.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(8), Integer.valueOf(1), null, Integer.valueOf(1)));

      jLabel3.setText("Colunas:");

      spnSpriteColunas.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(9), Integer.valueOf(1), null, Integer.valueOf(1)));

      btnCancelar.setMnemonic('C');
      btnCancelar.setText("Cancelar");
      btnCancelar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelarActionPerformed(evt);
         }
      });

      btnGerar.setMnemonic('G');
      btnGerar.setText("Gerar");
      btnGerar.setEnabled(false);
      btnGerar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnGerarActionPerformed(evt);
         }
      });

      lblVisualizar.setBackground(java.awt.Color.gray);
      lblVisualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblVisualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
      lblVisualizar.setOpaque(true);

      jLabel4.setText("Base:");

      cmbBase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(txtSpriteUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnSelecionar))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel4)
                  .addGap(5, 5, 5)
                  .addComponent(cmbBase, 0, 382, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(spnSpriteLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(spnSpriteColunas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(lblVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(btnGerar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnCancelar)))
            .addContainerGap())
      );

      layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGerar});

      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtSpriteUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btnSelecionar))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(cmbBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel2)
                     .addComponent(spnSpriteLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel3)
                     .addComponent(spnSpriteColunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addComponent(lblVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnCancelar)
               .addComponent(btnGerar))
            .addContainerGap())
      );

      layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSelecionar, txtSpriteUrl});

      pack();
   }// </editor-fold>//GEN-END:initComponents

	 private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
		 dialogo.setDialogTitle("Selecionando Sprite");
		 dialogo.resetChoosableFileFilters();
		 dialogo.setFileFilter(new FileNameExtensionFilter("Sprite PNG", "png"));
		 //dialogo.addChoosableFileFilter(new FileNameExtensionFilter("Imagem JPG", "jpg"));
		 dialogo.setAcceptAllFileFilterUsed(false);
		 //dialogo.setCurrentDirectory(new File(FileClass.getPastaDoUsuario()));


		 int Teste = dialogo.showOpenDialog(this);
		 if (Teste == JFileChooser.APPROVE_OPTION) {
			 txtSpriteUrl.setText(dialogo.getSelectedFile().getPath());
			 miniatura = new ImagemClass(txtSpriteUrl.getText());
			 Double $Zoom = 1.0;
			 if (miniatura.getLargura() > miniatura.getAltura()) {
				 //$Zoom = Double.parseDouble(String.valueOf(lblVisualizar.getWidth() / miniatura.getLargura()));
				 //$Zoom = ((Double)lblVisualizar.getWidth()) / ((Double)miniatura.getLargura());
				 $Zoom = 297.0 / miniatura.getLargura();
				 miniatura.setZoom($Zoom);
				 //miniatura.setZoom(0.1);
			 } else {
				 //$Zoom = Double.parseDouble(String.valueOf(lblVisualizar.getHeight() / miniatura.getAltura()));
				 $Zoom = 297.0 / miniatura.getAltura();
				 miniatura.setZoom($Zoom);
				 //miniatura.setZoom(0.1);
			 }
			 //ArrayList s = new ArrayList();
			 //javax.swing.JComboBox;
			 lblVisualizar.setIcon(miniatura.getIcone());
			 btnGerar.setEnabled(!txtSpriteUrl.getText().isEmpty() && FileClass.seExiste(txtSpriteUrl.getText()));
		 } else {
			 //log.append("Open command cancelled by user.");
		 }
	 }//GEN-LAST:event_btnSelecionarActionPerformed
	 private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
		 this.dispose();
	 }//GEN-LAST:event_btnCancelarActionPerformed
	 private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
		 File $Main = new File(txtSpriteUrl.getText());
		 String $srcMain = "graphics" + bar + "sprites" + bar + $Main.getName();
		 //String $srcMain = "graphics" + bar + "sprites" + bar + dialogo.getSelectedFile().getName();
		 ImagemClass imgBase = new ImagemClass(txtSpriteUrl.getText());
		 int $LargMain = imgBase.getLargura() / Integer.parseInt(spnSpriteColunas.getValue().toString());
		 int $AltuMain = imgBase.getAltura() / Integer.parseInt(spnSpriteLinhas.getValue().toString());

		 frmAnimationEditor.sptMainUrl = txtSpriteUrl.getText();
		 //frmAnimationEditor.sptMainUrl = frmAnimationEditor.pastaDeTmwData +bar+ $ImageTag.getAttribute("src");
		 if (FileClass.seExiste(frmAnimationEditor.sptMainUrl)) {
			 frmAnimationEditor.sptMainImg = imgBase;
			 frmAnimationEditor.sptMainWidth = $LargMain;
			 frmAnimationEditor.sptMainHeight = $AltuMain;
			 frmAnimationEditor.sldFrameImagem.setValue(0);
			 frmAnimationEditor.sldFrameImagem.setMaximum((Integer.parseInt(spnSpriteColunas.getValue().toString())*Integer.parseInt(spnSpriteLinhas.getValue().toString()))-1);
			 frmAnimationEditor.sldSeqStart.setValue(0);
			 frmAnimationEditor.sldSeqStart.setMaximum(frmAnimationEditor.sldFrameImagem.getMaximum());
			 frmAnimationEditor.sldSeqEnd.setMinimum(frmAnimationEditor.sldSeqStart.getValue());
			 frmAnimationEditor.sldSeqEnd.setMaximum(frmAnimationEditor.sldFrameImagem.getMaximum());
			 if(frmAnimationEditor.sldSeqEnd.getValue()<frmAnimationEditor.sldSeqEnd.getMinimum()){frmAnimationEditor.sldSeqEnd.setValue(frmAnimationEditor.sldSeqEnd.getMinimum());}
			 frmAnimationEditor.sldFrameImagem.setMajorTickSpacing(frmAnimationEditor.sldFrameImagem.getMaximum() / 4);
			 frmAnimationEditor.sldSeqStart.setMajorTickSpacing(frmAnimationEditor.sldSeqStart.getMaximum() / 4);
			 frmAnimationEditor.sldSeqEnd.setMajorTickSpacing(frmAnimationEditor.sldSeqEnd.getMaximum() / 4);
			 frmAnimationEditor.tplFrameSeq.setSelectedIndex(0);
		 } else {
			 DialogClass.showErro(
						"<HTML>Não foi possÍvel encontrar a imagem principal declarada na XML.<br>"
						+ "'<font color='#FF0000'>" + frmAnimationEditor.sptBaseUrl + "</font>'", "URL INVÁLIDA");
			 frmAnimationEditor.sptMainUrl = "";
			 frmAnimationEditor.sptMainImg = null;
			 frmAnimationEditor.sptMainWidth = 0;
			 frmAnimationEditor.sptMainHeight = 0;
		 }

		 if (!cmbBase.getSelectedItem().toString().equals("<NENHUMA>")) {
			 Vector $Action = new Vector();
			 String $urlBase = frmAnimationEditor.pastaDeSprites + bar + cmbBase.getSelectedItem().toString();
			 frmAnimationEditor.xmlBase = FileClass.arquivoAbrirXML($urlBase);
			 frmAnimationEditor.xmlMain = FileClass.arquivoAbrirXML($urlBase);
			 NodeList $MainNode = frmAnimationEditor.xmlMain.getChildNodes();
			 for (int $ac = 0; $ac < frmAnimationEditor.xmlMain.getChildNodes().getLength(); $ac++) {
				 if ($MainNode.item($ac).getNodeName().equals("imageset")) {
					 Element $ImageTag = (Element) $MainNode.item($ac);
					 

					 //((Element)frmAnimationEditor.xmlBase.getChildNodes().item($a)).setAttribute("src", "graphics" +bar+ "sprites" +bar+ dialogo.getSelectedFile().getName());
					 //((Element)frmAnimationEditor.xmlBase.getChildNodes().item($a)).setAttribute("width", String.valueOf(miniatura.getLargura()/Integer.parseInt(spnSpriteColunas.getValue().toString())));
					 //((Element)frmAnimationEditor.xmlBase.getChildNodes().item($a)).setAttribute("height", String.valueOf(miniatura.getAltura()/Integer.parseInt(spnSpriteLinhas.getValue().toString())));
					 $ImageTag.setAttribute("src", $srcMain);
					 $ImageTag.setAttribute("width", String.valueOf($LargMain));
					 $ImageTag.setAttribute("height", String.valueOf($AltuMain));

					 frmAnimationEditor.sptBaseUrl = frmAnimationEditor.pastaDeTmwData +bar+ ((Element)frmAnimationEditor.xmlBase.getChildNodes().item($ac)).getAttribute("src").split("\\|")[0];
					 if (FileClass.seExiste(frmAnimationEditor.sptBaseUrl)) {
						 frmAnimationEditor.sptBaseImg = new ImagemClass(frmAnimationEditor.sptBaseUrl);
						 frmAnimationEditor.sptBaseWidth = Integer.parseInt(((Element)frmAnimationEditor.xmlBase.getChildNodes().item($ac)).getAttribute("width"));
						 frmAnimationEditor.sptBaseHeight = Integer.parseInt(((Element)frmAnimationEditor.xmlBase.getChildNodes().item($ac)).getAttribute("height"));
					 } else {
						 DialogClass.showErro(
									"<HTML>Não foi possÍvel encontrar a imagem base declarada na XML.<br>"
									+ "'<font color='#FF0000'>" + frmAnimationEditor.sptBaseUrl + "</font>'", "URL INVÁLIDA");
						 frmAnimationEditor.sptBaseUrl = "";
						 frmAnimationEditor.sptBaseImg = null;
						 frmAnimationEditor.sptBaseWidth = 0;
						 frmAnimationEditor.sptBaseHeight = 0;
					 }
				 } else if ($MainNode.item($ac).getNodeName().equals("action")) {
					 Element $ActionTag = (Element) $MainNode.item($ac);
					 $Action.addElement($ActionTag.getAttribute("name"));
					 NodeList $ActionNode = $ActionTag.getChildNodes();
					 for (int $an = 0; $an < $ActionNode.getLength(); $an++) {
						 if ($ActionNode.item($an).getNodeName().equals("animation")) {
							 Element $AnimationTag = (Element) $ActionNode.item($an);
							 NodeList $FrameSeqNode = $AnimationTag.getChildNodes();
							 for (int $fs = 0; $fs < $FrameSeqNode.getLength(); $fs++) {
								 if ($FrameSeqNode.item($fs).getNodeName().equals("frame")) {
									 Element $FrameSeqTag = (Element) $FrameSeqNode.item($fs);
									 $FrameSeqTag.setAttribute("index", "0");
								 } else if ($FrameSeqNode.item($fs).getNodeName().equals("sequence")) {
									 Element $FrameSeqTag = (Element) $FrameSeqNode.item($fs);
									 $FrameSeqTag.setAttribute("start", "0");
									 $FrameSeqTag.setAttribute("end", "0");
								 }
							 }
						 }
					 }
				 }
			 }
		 
			 frmAnimationEditor.cmbAction.setModel(new javax.swing.DefaultComboBoxModel($Action.toArray()));
			 frmAnimationEditor.cmbAction.setEnabled(true);
			 //frmAnimationEditor.btnActionNew.setEnabled(true);
			 //frmAnimationEditor.btnActionDel.setEnabled(true);
			 frmAnimationEditor.zoom = 1.0;
			 frmAnimationEditor.ListarAnimation();
			 frmAnimationEditor.ListarFrameSequence();
			 frmAnimationEditor.RedesenhaPalco();
		 } else {
			 frmAnimationEditor.sptBaseUrl = "";
			 frmAnimationEditor.sptBaseImg = null;
			 frmAnimationEditor.sptBaseWidth = 0;
			 frmAnimationEditor.sptBaseHeight = 0;

			 frmAnimationEditor.cmbAction.setModel(new javax.swing.DefaultComboBoxModel(new Vector()));
			 frmAnimationEditor.cmbAnimation.setModel(new javax.swing.DefaultComboBoxModel(new Vector()));
			 frmAnimationEditor.cmbFrameSeq.setModel(new javax.swing.DefaultComboBoxModel(new Vector()));
			 frmAnimationEditor.cmbAction.setEnabled(false);
			 frmAnimationEditor.cmbAnimation.setEnabled(false);
			 frmAnimationEditor.cmbFrameSeq.setEnabled(false);
			 frmAnimationEditor.tplFrameSeq.setEnabled(false);
			 frmAnimationEditor.lblFrameImagem.setEnabled(false);
			 frmAnimationEditor.lblSeqStart.setEnabled(false);
			 frmAnimationEditor.lblSeqEnd.setEnabled(false);
			 frmAnimationEditor.sldFrameImagem.setEnabled(false);
			 frmAnimationEditor.sldSeqStart.setEnabled(false);
			 frmAnimationEditor.sldSeqEnd.setEnabled(false);

			 //frmAnimationEditor.pnlFrame.setEnabled(false);
			 //frmAnimationEditor.pnlSequence.setEnabled(false);
			 //frmAnimationEditor.pnlEnd.setEnabled(false);
		 }
		 frmAnimationEditor.RedesenhaPalco();
		 this.dispose();
	 }//GEN-LAST:event_btnGerarActionPerformed

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				FrmCriarSAS dialog = new FrmCriarSAS(new FrmEditorSAS(), true);
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
   private javax.swing.JButton btnCancelar;
   private javax.swing.JButton btnGerar;
   private javax.swing.JButton btnSelecionar;
   private javax.swing.JComboBox cmbBase;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel lblVisualizar;
   private javax.swing.JSpinner spnSpriteColunas;
   private javax.swing.JSpinner spnSpriteLinhas;
   private javax.swing.JTextField txtSpriteUrl;
   // End of variables declaration//GEN-END:variables
}
