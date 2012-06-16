 /**
	* @author lunovox
	* @created 10/06/2012 07:16:20
	*/

package formularios;

import classes.FileClass;

public class FrmSobre extends javax.swing.JDialog {

    /** Creates new form FrmSobre */
	 public FrmSobre(java.awt.Frame parent, boolean modal) {
			 /*try {
				 super.setIconImage((new ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))).getImage());
			 } catch (Exception e) {
				 System.out.println("Icone erro:\n" + e.getMessage());
			 }/**/
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      txpNavegador = new javax.swing.JTextPane();

      setTitle("Sobre o TMW-Maker 2");
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
         }
      });

      jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundos/banner-II.png"))); // NOI18N
      jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

      txpNavegador.setBorder(null);
      txpNavegador.setContentType("text/html");
      txpNavegador.setEditable(false);
      txpNavegador.setFont(txpNavegador.getFont());
      txpNavegador.setText("<html>\n<body bgcolor=\"#edeceb\"  style=\"margin-left:10; margin-right:10\">\n<font face=\"arial\" size=\"3\">\n<h1>O TMW-Maker II Java</h1> \n\n<p align=\"justify\">\nEste é um software Java tipo Engine-Portatil compatível com Windows e Linux, que ajudará no desenvolvimento do jogo MMORPG  \n<a href=\"http://code.google.com/p/tmw-maker/wiki/opensource\">Open Source (GPL-v3)</a> de  \n<a href=\"https://sites.google.com/site/tmwbrasil/\">The Mana World Brasil</a>, facilitando a  \ninclusão, edição e teste de Personagens, Monstros,  Portais, Itens até por \nleigos em programação Eathena Script através de menus intuitivos.<br><br> \n\n<b>Site:</b> <a href=\"http://tmw-maker.googlecode.com\">tmw-maker.googlecode.com</a><br><br> \n\n<h2>COLABORADORES</h2> \n<a href=\"mailto:Lunovox%20Heavenfinder<rui.gravata@gmail.com>\">Lunovox</a>, \n<a href=\"mailto:Vanderson%20Martins%20do%20Rosario<vandersonmr2@gmail.com>\">VandersonMR</a>, \n<a href=\"mailto:Ablankzim<ablankzinhu@hotmail.com>\">Ablankzim</a>, \n<a href=\"mailto:DiogoRBG<diogorbg@gmail.com>\">DiogoRBG</a>, \n<a href=\"http://it.wikipedia.org/wiki/The_Mana_World\">Eugenio Favalli</a>, \n<a href=\"http://www.mapeditor.org\">Adam Turk</a>, \n<a href=\"http://www.mapeditor.org\">Bjorn Lindeijer</a>");
      txpNavegador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      txpNavegador.setMargin(new java.awt.Insets(0, 0, 0, 0));
      txpNavegador.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
         public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
            txpNavegadorHyperlinkUpdate(evt);
         }
      });
      jScrollPane1.setViewportView(txpNavegador);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addGap(12, 12, 12))
         .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, Short.MAX_VALUE)
      );
   }// </editor-fold>//GEN-END:initComponents

	 private void txpNavegadorHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_txpNavegadorHyperlinkUpdate
		 if (evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
			FileClass.AbrirNavegador(evt.getURL().toString());
			FrmTMWMaker2.setAvisoEstatus(
				"<HTML><b>Abrindo:</b> <u><font color=\"#0000FF\">" + evt.getURL().toString() + "</u></font>",
				new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))
			);/**/
		 } else if (evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ENTERED) {
			txpNavegador.setToolTipText(evt.getURL().toString());
			FrmTMWMaker2.setAvisoEstatus(
			evt.getURL().toString(),
			new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))
			);
		 } else if (evt.getEventType() == javax.swing.event.HyperlinkEvent.EventType.EXITED) {
			 txpNavegador.setToolTipText("");
			 FrmTMWMaker2.setAvisoEstatus("");
		 }
}//GEN-LAST:event_txpNavegadorHyperlinkUpdate

	 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		 setTitle("Sobre o TMW-Maker 2 JAVA ("+
				FileClass.getSysName()+":"+
				FileClass.getSysArquitetura()+":"+
				//FileClass.getSysVersao()+":"+ // ← Desnecessário
				FileClass.getSysLanguage()+")"
			);
	 }//GEN-LAST:event_formWindowOpened


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextPane txpNavegador;
   // End of variables declaration//GEN-END:variables

}
