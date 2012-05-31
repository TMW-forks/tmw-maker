/*
 * FrmPrincipal.java
 * Created on 30/05/2012, 16:34:09
 * @author lunovox
 */
package formularios;

import classes.ClassConfiguracao;
import classes.DialogClass;
import classes.FileClass;
import classes.SummarizerSVN;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import org.tmatesoft.svn.core.wc.SVNRevision;

public class FrmPrincipal extends javax.swing.JFrame {

	/** Creates new form FrmPrincipal */
	public FrmPrincipal() {
		try {
			super.setIconImage((new ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))).getImage());
		} catch (Exception e) {
			System.out.println("Icone erro:\n" + e.getMessage());
		}
		initComponents();
	}
	public static ClassConfiguracao conf = new ClassConfiguracao();
	SummarizerSVN svn;
	String bar = FileClass.getSeparadorDePastas();
	String sys = FileClass.getPastaDoSistema();

	private void addLinhaDeEstatus(String Linha) {
		Linha = Linha.replaceAll("<html>", "");
		Linha = Linha.replaceAll("<b>", "");
		Linha = Linha.replaceAll("</b>", "");
		Linha = Linha.replaceAll("<font color='#008800'>", "");
		Linha = Linha.replaceAll("<font color='#FF0000'>", "");
		Linha = Linha.replaceAll("<font color='#0000FF'>", "");
		Linha = Linha.replaceAll("</font>", "");
		System.out.println(Linha);
		txtStatus.setText(txtStatus.getText() + "\n" + Linha);
		txtStatus.setSelectionStart(txtStatus.getText().length() - 1);
		txtStatus.setSelectionEnd(txtStatus.getText().length() - 1);
	}
	public void setBarStatus(String Testo){
		addLinhaDeEstatus(Testo);
		lblStatus.setText(Testo);
	}
	public void doCheckoutHead(){
		Thread tThread = new Thread(new Runnable() {
			public void run() {
				mnpLocalhost.setEnabled(false);
				svn = new SummarizerSVN(conf.getConexaoRepositorio(),conf.getConexaoLocalhost());
				//setBarStatus("<html>Baixando repositório '<font color='#008800'>"+conf.getConexaoRepositorio()+"</font>'! <font color='#FF0000'>Espere um momento...");
				setBarStatus("");
				setBarStatus("<html>Baixando repositório...");
				addLinhaDeEstatus(" * Origem: " + conf.getConexaoRepositorio());
				addLinhaDeEstatus(" * Destino: " + conf.getConexaoLocalhost());
				pgbProgresso.setIndeterminate(true);
				pgbProgresso.setString("Baixando...");
				pgbProgresso.setMinimum(0);
				pgbProgresso.setMaximum(100);
				pgbProgresso.setValue(100);
				SVNRevision rev = svn.doCheckout();
				conf.doSalvar();
				if (rev.getNumber()>=0) {
					setBarStatus("<html>Repositório '<font color='#008800'>" + rev.getNumber() + "</font>' baixado com sucesso!");
					pgbProgresso.setString("Concluido!");
				} else {
					setBarStatus("<html><font color='#FF0000'>ERRO:</font>Falha ao baixar o repositório!");
					pgbProgresso.setString("Erro!");
				}
				conf.setAtualizacaoLocalhostUltimaAgora();
				conf.doSalvar();
				pgbProgresso.setIndeterminate(false);
				mnpLocalhost.setEnabled(true);
			}
		});
		tThread.start();
	}

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      lblStatus = new javax.swing.JLabel();
      pgbProgresso = new javax.swing.JProgressBar();
      jScrollPane1 = new javax.swing.JScrollPane();
      txtStatus = new javax.swing.JTextArea();
      jMenuBar1 = new javax.swing.JMenuBar();
      mnpArquivo = new javax.swing.JMenu();
      mnuConfigurar = new javax.swing.JMenuItem();
      mnuSair = new javax.swing.JMenuItem();
      mnpLocalhost = new javax.swing.JMenu();
      mnuSumeter = new javax.swing.JMenuItem();
      mnuLocalhostBaixar = new javax.swing.JMenuItem();
      jSeparator1 = new javax.swing.JPopupMenu.Separator();
      mnuLocalhostMontar = new javax.swing.JMenuItem();
      jSeparator2 = new javax.swing.JPopupMenu.Separator();
      mnuLocalhostExecutar = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("TMW-Maker Hope");
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
         }
      });

      jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

      lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      lblStatus.setText("Bem Vindo!");

      pgbProgresso.setStringPainted(true);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(pgbProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(pgbProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblStatus))
            .addGap(0, 0, 0))
      );

      jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblStatus, pgbProgresso});

      txtStatus.setBackground(new java.awt.Color(0, 92, 0));
      txtStatus.setColumns(20);
      txtStatus.setEditable(false);
      txtStatus.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
      txtStatus.setForeground(java.awt.Color.white);
      txtStatus.setRows(5);
      txtStatus.setText("Tmw-Maker Hope");
      jScrollPane1.setViewportView(txtStatus);

      mnpArquivo.setText("Arquivo");

      mnuConfigurar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
      mnuConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_chaveinglesa.png"))); // NOI18N
      mnuConfigurar.setText("Configurar");
      mnuConfigurar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuConfigurarActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuConfigurar);

      mnuSair.setText("Sair");
      mnuSair.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSairActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuSair);

      jMenuBar1.add(mnpArquivo);

      mnpLocalhost.setText("Localhost");

      mnuSumeter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_UP, java.awt.event.InputEvent.CTRL_MASK));
      mnuSumeter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_upload.gif"))); // NOI18N
      mnuSumeter.setText("Submeter");
      mnuSumeter.setEnabled(false);
      mnpLocalhost.add(mnuSumeter);

      mnuLocalhostBaixar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_DOWN, java.awt.event.InputEvent.CTRL_MASK));
      mnuLocalhostBaixar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_download.gif"))); // NOI18N
      mnuLocalhostBaixar.setText("Baixar");
      mnuLocalhostBaixar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostBaixarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostBaixar);
      mnpLocalhost.add(jSeparator1);

      mnuLocalhostMontar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/puzzle.png"))); // NOI18N
      mnuLocalhostMontar.setText("Montar");
      mnuLocalhostMontar.setEnabled(false);
      mnpLocalhost.add(mnuLocalhostMontar);
      mnpLocalhost.add(jSeparator2);

      mnuLocalhostExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      mnuLocalhostExecutar.setText("Executar");
      mnuLocalhostExecutar.setEnabled(false);
      mnpLocalhost.add(mnuLocalhostExecutar);

      jMenuBar1.add(mnpLocalhost);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addGap(12, 12, 12))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

	private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		// TODO add your handling code here:
		Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(
			(Tela.width - this.getWidth()) / 2,
			(Tela.height - this.getHeight()) / 2,
			this.getWidth(), this.getHeight()
		);
		this.setExtendedState(MAXIMIZED_BOTH); //Maximiza a tela
		if(conf.getAtualizacaoLocalhostIntervalo() >= 0 && FileClass.getAgora() >= conf.getAtualizacaoLocalhostFutura()) {
			int resp = DialogClass.showOpcoes(
				"<html>O TMW-Maker é uma ferramenta de desenvolvimento colaborativa.<br>"+ 
				"Por esta razão, seu Localhost pode estar desatualizado.<br>"+ 
				"Deseja procurar atualização criada por outros DEVs via internet?",
				"ATUALIZAÇÃO DO LOCALHOST",
				new javax.swing.ImageIcon(getClass().getResource("/imagens/fundos/icon-tmw-96x96px.png")), //"/imagens/fundos/icon-tmw-96x96px.png",
				new Object[]{"Sim, atualize!","Não, depois!"},0
			);
			if(resp==0){doCheckoutHead();}
		}
	}//GEN-LAST:event_formWindowOpened
	private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
		// TODO add your handling code here:
		System.exit(0);
	}//GEN-LAST:event_mnuSairActionPerformed
	private void mnuLocalhostBaixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLocalhostBaixarActionPerformed
		// TODO add your handling code here:
		doCheckoutHead();
	}//GEN-LAST:event_mnuLocalhostBaixarActionPerformed

	private void mnuConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfigurarActionPerformed
		// TODO add your handling code here:
		javax.swing.JDialog FrmConfiguracao = new FrmConfiguracao(this, rootPaneCheckingEnabled);
        FrmConfiguracao.setLocation(
            ((this.getWidth() - FrmConfiguracao.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmConfiguracao.getHeight()) / 2) + this.getY());
        FrmConfiguracao.pack();
        FrmConfiguracao.setModal(true);
        FrmConfiguracao.setVisible(true);/**/
	}//GEN-LAST:event_mnuConfigurarActionPerformed
	

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new FrmPrincipal().setVisible(true);
			}
		});
	}
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JPopupMenu.Separator jSeparator1;
   private javax.swing.JPopupMenu.Separator jSeparator2;
   public static javax.swing.JLabel lblStatus;
   private javax.swing.JMenu mnpArquivo;
   private javax.swing.JMenu mnpLocalhost;
   private javax.swing.JMenuItem mnuConfigurar;
   private javax.swing.JMenuItem mnuLocalhostBaixar;
   private javax.swing.JMenuItem mnuLocalhostExecutar;
   private javax.swing.JMenuItem mnuLocalhostMontar;
   private javax.swing.JMenuItem mnuSair;
   private javax.swing.JMenuItem mnuSumeter;
   private javax.swing.JProgressBar pgbProgresso;
   private javax.swing.JTextArea txtStatus;
   // End of variables declaration//GEN-END:variables
}
