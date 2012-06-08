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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		Linha = Linha.replaceAll("<font color=\"#0000FF\">", "");
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
				mnpRepositorio.setEnabled(false);
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
				mnpRepositorio.setEnabled(true);
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
      mnpRepositorio = new javax.swing.JMenu();
      mnuRepositorioSumeter = new javax.swing.JMenuItem();
      mnuRepositorioAtualizar = new javax.swing.JMenuItem();
      jSeparator1 = new javax.swing.JPopupMenu.Separator();
      mnuRepositorioMontar = new javax.swing.JMenuItem();
      mnpLocalhost = new javax.swing.JMenu();
      mnuLocalhostAtivar = new javax.swing.JMenuItem();
      mnuLocalhostDesativar = new javax.swing.JMenuItem();
      jSeparator3 = new javax.swing.JPopupMenu.Separator();
      mnuLocalhostTestar = new javax.swing.JMenuItem();

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
      txtStatus.setFont(new java.awt.Font("Courier New", 0, 15));
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

      mnpRepositorio.setText("Repositório");

      mnuRepositorioSumeter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_UP, java.awt.event.InputEvent.CTRL_MASK));
      mnuRepositorioSumeter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_upload.gif"))); // NOI18N
      mnuRepositorioSumeter.setText("Submeter");
      mnuRepositorioSumeter.setEnabled(false);
      mnpRepositorio.add(mnuRepositorioSumeter);

      mnuRepositorioAtualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_DOWN, java.awt.event.InputEvent.CTRL_MASK));
      mnuRepositorioAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_download.gif"))); // NOI18N
      mnuRepositorioAtualizar.setText("Atualizar");
      mnuRepositorioAtualizar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuRepositorioAtualizarActionPerformed(evt);
         }
      });
      mnpRepositorio.add(mnuRepositorioAtualizar);
      mnpRepositorio.add(jSeparator1);

      mnuRepositorioMontar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/puzzle.png"))); // NOI18N
      mnuRepositorioMontar.setText("Montar");
      mnuRepositorioMontar.setEnabled(false);
      mnpRepositorio.add(mnuRepositorioMontar);

      jMenuBar1.add(mnpRepositorio);

      mnpLocalhost.setText("Servidor");

      mnuLocalhostAtivar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_MASK));
      mnuLocalhostAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_play.png"))); // NOI18N
      mnuLocalhostAtivar.setText("Play");
      mnuLocalhostAtivar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostAtivarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostAtivar);

      mnuLocalhostDesativar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.CTRL_MASK));
      mnuLocalhostDesativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_parar.png"))); // NOI18N
      mnuLocalhostDesativar.setText("Stop");
      mnuLocalhostDesativar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostDesativarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostDesativar);
      mnpLocalhost.add(jSeparator3);

      mnuLocalhostTestar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
      mnuLocalhostTestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      mnuLocalhostTestar.setText("Testar");
      mnuLocalhostTestar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostTestarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostTestar);

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
	private void mnuRepositorioAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRepositorioAtualizarActionPerformed
		// TODO add your handling code here:
		doCheckoutHead();
	}//GEN-LAST:event_mnuRepositorioAtualizarActionPerformed

	private void mnuConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfigurarActionPerformed
		// TODO add your handling code here:
		javax.swing.JDialog frmConfiguracao = new FrmConfiguracao(this, rootPaneCheckingEnabled);
        frmConfiguracao.setLocation(
            ((this.getWidth() - frmConfiguracao.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - frmConfiguracao.getHeight()) / 2) + this.getY());
        frmConfiguracao.pack();
        frmConfiguracao.setModal(true);
        frmConfiguracao.setVisible(true);/**/
	}//GEN-LAST:event_mnuConfigurarActionPerformed
	public Runtime doBash(Runtime Executador, String[] $Comandos) throws IOException {
		//Runtime Executador = Runtime.getRuntime();
		String line = "";
		for(int $c=0;$c<$Comandos.length;$c++){
			setBarStatus($Comandos[$c]);
		}
		Process Retorno = Executador.exec($Comandos);
		BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
		while ((line = in.readLine()) != null){ setBarStatus(line); }
		return Executador;
	}
	public Runtime doBash(Runtime Executador, String Comando) throws IOException {
		//Runtime Executador = Runtime.getRuntime();
		String line = "";
		setBarStatus(Comando);
		Process Retorno = Executador.exec(Comando);
		BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
		while ((line = in.readLine()) != null){ setBarStatus(line); }
		return Executador;
	}

	public void ServerPlay() {
		if (FileClass.getOS().indexOf("win") >= 0) {
			/*String[] cmd = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "start";
			cmd[3] = URL;
			Executador.exec(cmd);/**/
			DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
		} else if (FileClass.getOS().indexOf("mac") >= 0) {
			//Executador.exec("open " + URL);
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else {
			Thread tThread = new Thread(new Runnable() {

				public void run() {
					//mnpArquivo.setEnabled(false);
					//mnpRepositorio.setEnabled(false);
					//mnuLocalhostAtivar.setEnabled(false);
					//VerificarBarraDeFerramentas();

					pgbProgresso.setEnabled(true);
					pgbProgresso.setValue(0);
					pgbProgresso.setMinimum(0);
					pgbProgresso.setMaximum(5);

					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					Runtime Executador = Runtime.getRuntime();
					String line = "", Comando = "";

					if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
						pgbProgresso.setString("Ativando...");
						setBarStatus("Ativando Servidor Local...");
						//TxtEstatus.setText("Reiniciando localhost...");
						try {
							pgbProgresso.setIndeterminate(true);
							Executador = doBash(Executador, conf.getConexaoLocalhost() + "/eathena-data/tmw-maker-depure.sh &");
							pgbProgresso.setIndeterminate(false);
							setBarStatus("<html>Eathena reiniciado (<font color=\"#0000FF\"><b>Espere 5 segundos...</b></font>)");
							long TempoInicio = 0, TempoAtual = 0, Milisegundos = 5500, Segundos = 0;
							TempoInicio = System.currentTimeMillis();
							do {
								TempoAtual = System.currentTimeMillis();
								Segundos = (TempoAtual - TempoInicio) / 1000;
								//setAvisoEmEstatus("Espere "+Segundos+"/5 segundos...");
								pgbProgresso.setValue((int) Segundos);
								pgbProgresso.setString("00:00:0" + (5 - ((int) Segundos)));
								pgbProgresso.setIndeterminate(true);
							} while (TempoAtual - TempoInicio < Milisegundos);
							//mnpArquivo.setEnabled(false);
							//mnpRepositorio.setEnabled(false);
							//mnuLocalhostDesativar.setEnabled(true);
							//mnuLocalhostCliente.setEnabled(true);
							//pgbProgresso.setIndeterminate(true);
						} catch (IOException e) {
							e.printStackTrace();
							setBarStatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
							DialogClass.showErro(
								"<html><b>O TMW-Maker não conseguiu reiniciar o eathena:</b><br/><br/>"
								+ "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>"
								+ "</html>",
								"ERRO DE EXECUÇÃO"
							);
						}
					}
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					
				}
			});
			tThread.start();
		}
	}
	public void ServerStop() {
		if (FileClass.getOS().indexOf("win") >= 0) {
			/*String cmd[] = {
				"cmd.exe",
				"/C",
				"start",
				"c:\\windows\\calc.exe"
			};
			Executador.exec(cmd);/**/
			DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
		} else if (FileClass.getOS().indexOf("mac") >= 0) {
			//Executador.exec("open " + URL);
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else {
			Thread tThread = new Thread(new Runnable() {

				public void run() {
					//mnpArquivo.setEnabled(false);
					//mnpRepositorio.setEnabled(false);
					//mnuLocalhostDesativar.setEnabled(false);
					//VerificarBarraDeFerramentas();

					pgbProgresso.setEnabled(true);
					pgbProgresso.setValue(0);
					pgbProgresso.setMinimum(0);
					pgbProgresso.setMaximum(5);
					pgbProgresso.setIndeterminate(false);

					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					Runtime Executador = Runtime.getRuntime();
					String line = "", Comando = "";

					if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
						pgbProgresso.setString("Desativando...");
						setBarStatus("Desativando localhost...");
						//TxtEstatus.setText("Reiniciando localhost...");
						try {
							Executador = doBash(Executador, "pkill map-server");
							Executador = doBash(Executador, "pkill char-server");
							Executador = doBash(Executador, "pkill login-server");
							setBarStatus("Localhost desativado com sucesso!");
						} catch (IOException e) {
							e.printStackTrace();
							//TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
							setBarStatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
							DialogClass.showErro("<html><b>O TMW-Maker não conseguiu reiniciar o eathena:</b><br/><br/>"
									  + "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>"
									  + "</html>",
									  "ERRO DE EXECUÇÃO");
						}
					}
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

				}
			});
			tThread.start();
		}
	}
	public void ServerTestar() {
		if (FileClass.getOS().indexOf("win") >= 0) {
			/*String[] cmd = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "start";
			cmd[3] = URL;
			Executador.exec(cmd);/**/
			DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
		} else if (FileClass.getOS().indexOf("mac") >= 0) {
			//Executador.exec("open " + URL);
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else {
			Thread tThread = new Thread(new Runnable() {

				public void run() {
					//mnpArquivo.setEnabled(false);
					//mnpRepositorio.setEnabled(false);
					//VerificarBarraDeFerramentas();

					//pgbProgresso.setEnabled(true);
					//pgbProgresso.setMinimum(0);
					//pgbProgresso.setMaximum(5);
					//pgbProgresso.setValue(5);
					//pgbProgresso.setIndeterminate(true);

					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					Runtime Executador = Runtime.getRuntime();
					String line = "", Comando = "";


					//TxtEstatus.setText(TxtEstatus.getText()+"\nAbrindo aplicativo \""+conf.getExecucaoComando()+"\"...");
					setBarStatus("Abrindo aplicativo \"" + conf.getExecucaoComando() + "\"...");
					Comando = conf.getExecucaoComando() + " "
							  + "--update-host --default " + //<-- O Manaplus só roda corretamente com essa linha...
							  ((!conf.getTMWData().isEmpty() && (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("127.0.0.1"))) ? ("--skip-update --data " + conf.getTMWData() + " ") : "")
							  + (conf.getExecucaoParametroServidor().isEmpty() ? "" : ("--server " + conf.getExecucaoParametroServidor() + " "))
							  + (conf.getExecucaoParametroConta().isEmpty() ? "" : ("--username " + conf.getExecucaoParametroConta() + " "))
							  + (conf.getExecucaoParametroSenha().isEmpty() ? "" : ("--password " + conf.getExecucaoParametroSenha() + " "))
							  + (conf.getExecucaoParametroPersonagem().isEmpty() ? "" : ("--character " + conf.getExecucaoParametroPersonagem() + " "))
							  + (conf.getExecucaoParametroSemOpenGL() == true ? "--no-opengl" : "");
					//DialogClass.showAlerta("<html>Comando:<br/>"+Comando,"TESTE DE PROGRAMADOR");
					try {
						Process Retorno = Executador.exec(Comando);
						System.out.println(Comando.replaceAll(conf.getExecucaoParametroSenha(), "********"));
						BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
						while ((line = in.readLine()) != null) {
							System.out.println(line);
							//TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
							setBarStatus("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\": " + line);
							//pgbProgresso.setString("Executando...");
						}
						//pgbProgresso.setString("Fechado!");
						setBarStatus("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\" fechando!");
						//pgbProgresso.setIndeterminate(false);
					} catch (IOException e) {
						//pgbProgresso.setIndeterminate(false);
						e.printStackTrace();
						//pgbProgresso.setValue(5);
						//mnpArquivo.setEnabled(true);
						//mnpRepositorio.setEnabled(true);
						//VerificarBarraDeFerramentas();
						//setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						//return;
					}



					//pgbProgresso.setValue(5);
					//mnpArquivo.setEnabled(true);
					//mnpRepositorio.setEnabled(true);
					//VerificarBarraDeFerramentas();
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
			});
			tThread.start();
		}
	}

	public void ExecutarJogo_deprecado() {
		if (FileClass.getOS().indexOf("win") >= 0) {
			/*String[] cmd = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "start";
			cmd[3] = URL;
			Executador.exec(cmd);/**/
			DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
		} else if (FileClass.getOS().indexOf("mac") >= 0) {
			//Executador.exec("open " + URL);
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else {
			Thread tThread = new Thread(new Runnable() {

				public void run() {
					mnpArquivo.setEnabled(false);
					mnpRepositorio.setEnabled(false);
					//VerificarBarraDeFerramentas();

					pgbProgresso.setEnabled(true);
					pgbProgresso.setValue(0);
					pgbProgresso.setMinimum(0);
					pgbProgresso.setMaximum(5);

					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					Runtime Executador = Runtime.getRuntime();
					String line = "", Comando = "";

					if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
						pgbProgresso.setString("Reiniciando...");
						setBarStatus("Reiniciando localhost...");
						//TxtEstatus.setText("Reiniciando localhost...");
						try {
							/*Comando = conf.getConexaoLocalhost() + "/eathena-data/eathena.sh restart";
							setBarStatus(Comando);
							//TxtEstatus.setText(TxtEstatus.getText()+"\n"+Comando);
							Process Retorno = Executador.exec(Comando);
							BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
							while ((line = in.readLine()) != null) {
								setBarStatus(line);
								//TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
							}/**/
							
							/*Executador = doBash(Executador, "cd "+conf.getConexaoLocalhost()+"/eathena-data/");
							Executador = doBash(Executador, "./login-server &");
							Executador = doBash(Executador, "./char-server &");
							Executador = doBash(Executador, "./map-server &");/**/
							/*String Comandos[]={
								"gnome-terminal", "-x", "bash", "-c",
								"cd "+conf.getConexaoLocalhost()+"/eathena-data/",
								//"cd "+conf.getEathenaData(),
								"./login-server &",
								"./char-server &",
								"./map-server &"
							};
							Executador = doBash(Executador, Comandos);/**/
							 //String cmd[] = {"gnome-terminal", "-x", "bash", "-c", "ls; echo '<enter>'; read" };
						    //proc = Runtime.getRuntime().exec(cmd, null, wd);

							/*String Comandos[]={
								//"gnome-terminal", "-x", "bash", "-c",
								//conf.getEathenaData()+"/eathena-monitor "+ conf.getEathenaData()+"/conf/eathena-monitor.conf"
								//conf.getEathenaData()+"/login-server &", conf.getEathenaData()+"/char-server &", conf.getEathenaData()+"/map-server &"
							};
							Executador = doBash(Executador, Comandos);/**/

							/*String Comandos[]={
								"gnome-terminal", "-x", "bash", "-c",
								"SRVHOMEDIR=$HOME/tmwserver",
								"cd ${SRVHOMEDIR}",
								"if [ -x ${SRVHOMEDIR}/eathena-monitor ]; ",
								"then echo \"Starting eathena monitor...\"",
								"${SRVHOMEDIR}/eathena-monitor ${SRVHOMEDIR}/conf/eathena-monitor.conf",
								"else echo \"Eathena monitor binary is not executable or not found.\"",
								 "fi"
								//conf.getEathenaData()+"/eathena-monitor "+ conf.getEathenaData()+"/conf/eathena-monitor.conf"
								//conf.getEathenaData()+"/login-server &", conf.getEathenaData()+"/char-server &", conf.getEathenaData()+"/map-server &"
							};
							Executador = doBash(Executador, Comandos);/**/

							/*String Comandos[]={
								"gnome-terminal", "-x", "bash", "-c",
								"cd /home/lunovox/tmwserver/",
								//"cd "+conf.getConexaoLocalhost()+"/eathena-data/",
								"./login-server &",
								"./char-server &",
								"./map-server &"
							};
							Executador = doBash(Executador, Comandos);/**/

							/*String $SoftCliente = conf.getExecucaoComando() + " "
							  + "--update-host --default " + //<-- O Manaplus só roda corretamente com essa linha...
							  ((!conf.getTMWData().isEmpty() && (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("127.0.0.1"))) ? ("--skip-update --data " + conf.getTMWData() + " ") : "")
							  + (conf.getExecucaoParametroServidor().isEmpty() ? "" : ("--server " + conf.getExecucaoParametroServidor() + " "))
							  + (conf.getExecucaoParametroConta().isEmpty() ? "" : ("--username " + conf.getExecucaoParametroConta() + " "))
							  + (conf.getExecucaoParametroSenha().isEmpty() ? "" : ("--password " + conf.getExecucaoParametroSenha() + " "))
							  + (conf.getExecucaoParametroPersonagem().isEmpty() ? "" : ("--character " + conf.getExecucaoParametroPersonagem() + " "))
							  + (conf.getExecucaoParametroSemOpenGL() == true ? "--no-opengl" : "");

							String Comandos[]={
								//"gnome-terminal", "-x",
								//"bash -c \"cd /home/lunovox/tmwserver/; ./login-server \\&; ./char-server \\&; ./map-server \\&\""
								"bash", "-c", "cd /home/lunovox/tmwserver/; ./login-server \\&; ./char-server \\&; ./map-server \\&; sleep 5; "+$SoftCliente
								//"bash", "-c", "cd /home/lunovox/tmwserver/; ./login-server \\&; ./char-server \\&; ./map-server \\&; "
							};
							Executador = doBash(Executador, Comandos);/**/
							//Executador = doBash(Executador, $SoftCliente);/**/
							
							/*Executador = doBash(Executador, conf.getConexaoLocalhost() + "/eathena-data/login-server &");
							Executador = doBash(Executador, conf.getConexaoLocalhost() + "/eathena-data/char-server &");
							Executador = doBash(Executador, conf.getConexaoLocalhost() + "/eathena-data/map-server &");/**/

							/*String Comandos[]={
								"cd /home/lunovox/tmwserver/",
								"/home/lunovox/tmwserver/login-server &",
								"/home/lunovox/tmwserver/map-server &",
								"/home/lunovox/tmwserver/char-server &"
							};
							Executador = doBash(Executador, Comandos);/**/

							//Executador = doBash(Executador, conf.getConexaoLocalhost() + "/eathena-data/eathena.sh restart");
							Executador = doBash(Executador, conf.getConexaoLocalhost() + "/eathena-data/tmw-maker-depure.sh");
							


							//TxtEstatus.setText(TxtEstatus.getText()+"\nEathena reiniciado (Espere 5 segundos...)\n");
							setBarStatus("<html>Eathena reiniciado (<font color=\"#0000FF\"><b>Espere 5 segundos...</b></font>)");
							long TempoInicio = 0, TempoAtual = 0, Milisegundos = 5500, Segundos = 0;
							TempoInicio = System.currentTimeMillis();
							do {
								TempoAtual = System.currentTimeMillis();
								Segundos = (TempoAtual - TempoInicio) / 1000;
								//setAvisoEmEstatus("Espere "+Segundos+"/5 segundos...");
								pgbProgresso.setValue((int) Segundos);
								pgbProgresso.setString("00:00:0" + (5 - ((int) Segundos)));
							} while (TempoAtual - TempoInicio < Milisegundos);
						} catch (IOException e) {
							e.printStackTrace();
							//TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
							setBarStatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
							DialogClass.showErro("<html><b>O TMW-Maker não conseguiu reiniciar o eathena:</b><br/><br/>"
									  + "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>"
									  + "</html>",
									  "ERRO DE EXECUÇÃO");
							pgbProgresso.setValue(5);
							mnpArquivo.setEnabled(true);
							mnpRepositorio.setEnabled(true);
							setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
							//VerificarBarraDeFerramentas();
							return;
						}
					}
					pgbProgresso.setIndeterminate(true);
					//TxtEstatus.setText(TxtEstatus.getText()+"\nAbrindo aplicativo \""+conf.getExecucaoComando()+"\"...");
					setBarStatus("Abrindo aplicativo \"" + conf.getExecucaoComando() + "\"...");
					Comando = conf.getExecucaoComando() + " "
							  + "--update-host --default " + //<-- O Manaplus só roda corretamente com essa linha...
							  ((!conf.getTMWData().isEmpty() && (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("127.0.0.1"))) ? ("--skip-update --data " + conf.getTMWData() + " ") : "")
							  + (conf.getExecucaoParametroServidor().isEmpty() ? "" : ("--server " + conf.getExecucaoParametroServidor() + " "))
							  + (conf.getExecucaoParametroConta().isEmpty() ? "" : ("--username " + conf.getExecucaoParametroConta() + " "))
							  + (conf.getExecucaoParametroSenha().isEmpty() ? "" : ("--password " + conf.getExecucaoParametroSenha() + " "))
							  + (conf.getExecucaoParametroPersonagem().isEmpty() ? "" : ("--character " + conf.getExecucaoParametroPersonagem() + " "))
							  + (conf.getExecucaoParametroSemOpenGL() == true ? "--no-opengl" : "");
					//DialogClass.showAlerta("<html>Comando:<br/>"+Comando,"TESTE DE PROGRAMADOR");
					try {
						Process Retorno = Executador.exec(Comando);
						System.out.println(Comando.replaceAll(conf.getExecucaoParametroSenha(), "********"));
						BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
						while ((line = in.readLine()) != null) {
							System.out.println(line);
							//TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
							setBarStatus("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\": " + line);
							pgbProgresso.setString("Executando...");
						}
						pgbProgresso.setString("Fechado!");
						setBarStatus("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\" fechando!");
						pgbProgresso.setIndeterminate(false);
					} catch (IOException e) {
						pgbProgresso.setIndeterminate(false);
						e.printStackTrace();
						/*if (conf.getExecucaoComando().equals("manaplus") && !conf.getSeDependenciaDeManaplus() && conf.getSeDependenciaDeTMW()) {
							conf.setExecucaoComando("tmw");
							conf.confuracoesGravar();
							DialogClass.showErro("<html>"
									  + "O TMW-Maker <b>não encotrou o aplicativo</b> \"<font face=\"monospace\" color=\"#FF0000\"><b>MANA</b></font>\".<br/>"
									  + "Substituindo por aplicativo \"<font face=\"monospace\" color=\"#0000FF\"><b>TMW</b></font>\"..."
									  + "</html>",
									  "ERRO DE EXECUÇÃO");
							ExecutarJogo_deprecado();
						} else if (conf.getExecucaoComando().equals("tmw") && !conf.getSeDependenciaDeTMW() && conf.getSeDependenciaDeManaplus()) {
							conf.setExecucaoComando("manaplus");
							conf.confuracoesGravar();
							DialogClass.showErro("<html>"
									  + "O TMW-Maker <b>não encotrou o aplicativo</b> \"<font face=\"monospace\" color=\"#FF0000\"><b>TMW</b></font>\".<br/>"
									  + "Substituindo por aplicativo \"<font face=\"monospace\" color=\"#0000FF\"><b>MANA</b></font>\"..."
									  + "</html>",
									  "ERRO DE EXECUÇÃO");
							ExecutarJogo_deprecado();
						} else {
							pgbProgresso.setString("ERRO...");
							//TxtEstatus.setText(TxtEstatus.getText()+"ERRO DE EXECUÇÃO: "+Comando);
							setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO DE EXECUÇÃO:</b></font> " + Comando);
							DialogClass.showErro(
									  "<html>O TMW-Maker <font color=\"#FF0000\">não conseguiu abrir</font> nenhum <br/>"
									  + "aplicativo cliente(jogo) de THE MANA WORLD!<br/>"
									  + "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font>", "ERRO DE EXECUÇÃO");
						}/**/
						pgbProgresso.setValue(5);
						mnpArquivo.setEnabled(true);
						mnpRepositorio.setEnabled(true);
						//VerificarBarraDeFerramentas();
						setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						return;
					}

					if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
						pgbProgresso.setString("Desligando...");
						setBarStatus("Desligando localhost...");
						//TxtEstatus.setText("Reiniciando localhost...");
						try {
							/*Comando = conf.getConexaoLocalhost() + "/eathena-data/eathena.sh stop";

							//TxtEstatus.setText(TxtEstatus.getText()+"\n"+Comando);
							Process Retorno = Executador.exec(Comando);
							BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
							while ((line = in.readLine()) != null) {
								System.out.println(line);
								//TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
							}/**/
							Executador = doBash(Executador, "pkill map-server");
							Executador = doBash(Executador, "pkill char-server");
							Executador = doBash(Executador, "pkill login-server");

							setBarStatus("<html><font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font> e <font color=\"#0000FF\"><b>eathena</b></font> executados e encerrados com sucesso!");
							pgbProgresso.setString("Encerrado!");
						} catch (IOException e) {
							e.printStackTrace();
							//TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);

							setBarStatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
							DialogClass.showErro("<html><b>O TMW-Maker não conseguiu desligar o eathena:</b><br/><br/>"
									  + "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>"
									  + "</html>",
									  "ERRO DE EXECUÇÃO");
							pgbProgresso.setValue(5);
							mnpArquivo.setEnabled(true);
							mnpRepositorio.setEnabled(true);
							//VerificarBarraDeFerramentas();
							setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
							return;
						}
					}

					pgbProgresso.setValue(5);
					mnpArquivo.setEnabled(true);
					mnpRepositorio.setEnabled(true);
					//VerificarBarraDeFerramentas();
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
			});
			tThread.start();
		}
	}

	private void mnuLocalhostTestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLocalhostTestarActionPerformed
		//ExecutarJogo_deprecado();
		ServerTestar();
	}//GEN-LAST:event_mnuLocalhostTestarActionPerformed
	private void mnuLocalhostAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLocalhostAtivarActionPerformed
		ServerPlay();
	}//GEN-LAST:event_mnuLocalhostAtivarActionPerformed
	private void mnuLocalhostDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLocalhostDesativarActionPerformed
		 ServerStop();
	}//GEN-LAST:event_mnuLocalhostDesativarActionPerformed
	

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
   private javax.swing.JPopupMenu.Separator jSeparator3;
   public static javax.swing.JLabel lblStatus;
   private javax.swing.JMenu mnpArquivo;
   private javax.swing.JMenu mnpLocalhost;
   private javax.swing.JMenu mnpRepositorio;
   private javax.swing.JMenuItem mnuConfigurar;
   private javax.swing.JMenuItem mnuLocalhostAtivar;
   private javax.swing.JMenuItem mnuLocalhostDesativar;
   private javax.swing.JMenuItem mnuLocalhostTestar;
   private javax.swing.JMenuItem mnuRepositorioAtualizar;
   private javax.swing.JMenuItem mnuRepositorioMontar;
   private javax.swing.JMenuItem mnuRepositorioSumeter;
   private javax.swing.JMenuItem mnuSair;
   private javax.swing.JProgressBar pgbProgresso;
   private javax.swing.JTextArea txtStatus;
   // End of variables declaration//GEN-END:variables
}
