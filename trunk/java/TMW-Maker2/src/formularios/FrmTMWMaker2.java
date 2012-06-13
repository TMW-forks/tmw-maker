/*
 * FrmTMWMaker2.java
 * Created on 30/05/2012, 16:34:09
 * @author lunovox
 */
package formularios;
import classes.ClassConfiguracao;
import classes.DialogClass;
import classes.FileClass;
import classes.ImagemClass;
import classes.SummarizerSVN;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.tmatesoft.svn.core.wc.SVNRevision;

public class FrmTMWMaker2 extends javax.swing.JFrame {
	public FrmTMWMaker2() {
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

	private static void addLinhaPainel(String Linha) {
		Linha = Linha.replaceAll("<html>", "");
		Linha = Linha.replaceAll("<b>", "");
		Linha = Linha.replaceAll("</b>", "");
		Linha = Linha.replaceAll("<font color='#008800'>", "");
		Linha = Linha.replaceAll("<font color=\"#008800\">", "");
		Linha = Linha.replaceAll("<font color='#FF0000'>", "");
		Linha = Linha.replaceAll("<font color=\"#FF0000\">", "");
		Linha = Linha.replaceAll("<font color='#0000FF'>", "");
		Linha = Linha.replaceAll("<font color=\"#0000FF\">", "");
		Linha = Linha.replaceAll("</font>", "");
		Linha = Linha.replaceAll("<br/>", "\n");
		Linha = Linha.replaceAll("<br>", "\n");
		System.out.println(Linha);
		txtPainel.setText(txtPainel.getText() + "\n" + Linha);
		txtPainel.setSelectionStart(txtPainel.getText().length() - 1);
		txtPainel.setSelectionEnd(txtPainel.getText().length() - 1);
	}
	public static void setAvisoEstatus(String Aviso) {
		lblStatusTexto.setText(Aviso.toString());
		lblStatusTexto.setIcon(null);
	}
	public static void setAvisoEstatus(String Aviso, Icon Icone) {
		lblStatusTexto.setText(Aviso.toString());
		lblStatusTexto.setIcon(Icone);
	}
	public static void setAvisoEstatus(String Aviso, String EnderecoOuResource) {
		lblStatusTexto.setText(Aviso.toString());
		lblStatusTexto.setIcon((new ImagemClass(EnderecoOuResource)).getIcone());
	}
	public static void setAvisoEstatusPainel(String Linha) {
		addLinhaPainel(Linha);
		setAvisoEstatus(Linha);
	}
	public static Runtime doBash(Runtime Executador, String[] $Comandos) throws IOException {
		//Runtime Executador = Runtime.getRuntime();
		String line = "";
		for(int $c=0;$c<$Comandos.length;$c++){
			setAvisoEstatusPainel($Comandos[$c]);
		}
		Process Retorno = Executador.exec($Comandos);
		BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
		while ((line = in.readLine()) != null){ setAvisoEstatusPainel(line); }
		return Executador;
	}
	public static Runtime doBash(Runtime Executador, String Comando) throws IOException {
		//Runtime Executador = Runtime.getRuntime();
		String line = "";
		setAvisoEstatusPainel(Comando);
		Process Retorno = Executador.exec(Comando);
		BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
		while ((line = in.readLine()) != null){ setAvisoEstatusPainel(line); }
		return Executador;
	}/**/
	public static Runtime doBash(String Comando) throws IOException {
		//Runtime Executador = new Runtime();
		Runtime Executador = Runtime.getRuntime();
		Executador = doBash(Executador, Comando);
		return Executador;
	}

	public void doCheckoutHead(){
		Thread tThread = new Thread(new Runnable() {
			public void run() {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				svn = new SummarizerSVN(conf.getConexaoRepositorio(),conf.getConexaoLocalhost());
				//setAvisoEstatusPainel("<html>Baixando repositório '<font color='#008800'>"+conf.getConexaoRepositorio()+"</font>'! <font color='#FF0000'>Espere um momento...");
				setAvisoEstatusPainel("<html>Baixando repositório...");
				addLinhaPainel(" * Origem: " + conf.getConexaoRepositorio());
				addLinhaPainel(" * Destino: " + conf.getConexaoLocalhost());
				mnpSistema.setEnabled(false);
				mnpRepositorio.setEnabled(false);
				mnpLocalhost.setEnabled(false);
				pgbStatusProgresso.setIndeterminate(true);
				pgbStatusProgresso.setString("Baixando...");
				pgbStatusProgresso.setMinimum(0);
				pgbStatusProgresso.setMaximum(100);
				pgbStatusProgresso.setValue(100);
				SVNRevision rev = svn.doCheckout();
				conf.doSalvar();
				if (rev.getNumber()>=0) {
					mnuRepositorioMontar.setEnabled(true);
					setAvisoEstatusPainel("<html>Repositório '<font color='#008800'>" + rev.getNumber() + "</font>' baixado com sucesso!");
					pgbStatusProgresso.setString("Concluido!");
				} else {
					mnuRepositorioMontar.setEnabled(false);
					setAvisoEstatusPainel("<html><font color='#FF0000'>ERRO:</font>Falha ao baixar o repositório!");
					pgbStatusProgresso.setString("Erro!");
				}
				conf.setAtualizacaoLocalhostUltimaAgora();
				conf.doSalvar();
				pgbStatusProgresso.setIndeterminate(false);
				mnpSistema.setEnabled(true);
				mnpRepositorio.setEnabled(true);
				mnpLocalhost.setEnabled(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

				if(
					FileClass.getSysName().toLowerCase().indexOf("linux") >= 0 &&
					(
						!FileClass.seExiste(conf.getEathenaData() + bar + "char-server") ||
						!FileClass.seExiste(conf.getEathenaData() + bar + "login-server") ||
						!FileClass.seExiste(conf.getEathenaData() + bar + "map-server") ||
						!FileClass.seExiste(FileClass.getPastaDoUsuario() + bar + "tmwserver") ||
						!FileClass.seExiste(conf.getEathenaData()+bar+"tmw-maker-depure.sh")
					)
				){
					int R = 0; //0 = "Cancelar"
					if (
						FileClass.seExiste(conf.getEathenaData() + bar + "char-server") ||
						FileClass.seExiste(conf.getEathenaData() + bar + "login-server") ||
						FileClass.seExiste(conf.getEathenaData() + bar + "map-server") ||
						FileClass.seExiste(FileClass.getPastaDoUsuario() + bar + "tmwserver") ||
						FileClass.seExiste(conf.getEathenaData()+bar+"tmw-maker-depure.sh")
					) {
						setAvisoEstatusPainel("Deseja montar o localhost agora?");
						R = DialogClass.showOpcoes(
							"<html>"+
							"O seu localhost não está montado.<br/>"+
							"É necessário montá-lo para executar o modo offline!<br/>"+
							"<font color='#0000FF'>Deseja montá-lo agora?</font>",
							"MONTAGEM DE LOCALHOST",
							new javax.swing.ImageIcon(getClass().getResource("/imagens/fundos/icon-tmw-96x96px.png")),
							new Object[] {"Montar", "Cancelar"},
							1
						);
					}
					if (R == 0) {
						doMontarLinux();
					} else {
						setAvisoEstatusPainel("Montagem cancelada!");
						pgbStatusProgresso.setString("");
					}
				}
			}
		});
		tThread.start();
	}
	public void doMontar(){
		if ( FileClass.getSysName().toLowerCase().indexOf("win") >= 0) {
			DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
		} else if (FileClass.getSysName().toLowerCase().indexOf("mac") >= 0) {
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else if (FileClass.getSysName().toLowerCase().indexOf("linux") >= 0) {
			doMontarLinux();
		}
	}
	public void doMontarLinux(){
		Thread tThread = new Thread(new Runnable() {
			public void run() {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				mnpSistema.setEnabled(false);
				mnpRepositorio.setEnabled(false);
				mnpLocalhost.setEnabled(false);
				mnpAjuda.setEnabled(false);
				pgbStatusProgresso.setEnabled(true);
				pgbStatusProgresso.setValue(0);
				pgbStatusProgresso.setIndeterminate(true);
				if(
					!FileClass.seExiste(conf.getEathenaData() + bar + "char-server") ||
					!FileClass.seExiste(conf.getEathenaData() + bar + "login-server") ||
					!FileClass.seExiste(conf.getEathenaData() + bar + "map-server")
				){
					pgbStatusProgresso.setString("Apagando...");
					setAvisoEstatusPainel("Apagando binários...");
					if(FileClass.seExiste(conf.getConexaoLocalhost() + bar + "bins")){FileClass.apagar(conf.getConexaoLocalhost() + bar + "bins");}
					if(FileClass.seExiste(conf.getEathenaData() + bar + "char-server")){FileClass.apagar(conf.getEathenaData() + bar + "char-server");}
					if(FileClass.seExiste(conf.getEathenaData() + bar + "login-server")){FileClass.apagar(conf.getEathenaData() + bar + "login-server");}
					if(FileClass.seExiste(conf.getEathenaData() + bar + "map-server")){FileClass.apagar(conf.getEathenaData() + bar + "map-server");}

					String $URL = "http://tmw-maker.googlecode.com/svn/bins/"+FileClass.getSysName();
					String $PastaBins = FrmTMWMaker2.conf.getConexaoLocalhost() + bar + "bins";

					if(FileClass.getSysName().indexOf("linux") >= 0) {
						SummarizerSVN svnBinarios = new SummarizerSVN($URL, $PastaBins);
						pgbStatusProgresso.setString("Baixando...");
						setAvisoEstatusPainel("Preparando para baixar binários novos...");
						addLinhaPainel(" * Origem: " + $URL);
						addLinhaPainel(" * Destino: " + $PastaBins);
						SVNRevision rev = svnBinarios.doCheckout();
						if (rev.getNumber()>=0) {
							setAvisoEstatusPainel("<html>Binários '<font color='#008800'>" + rev.getNumber() + "</font>' baixados com sucesso!");
							pgbStatusProgresso.setString("Concluido!");
						} else {
							setAvisoEstatusPainel("<html><font color='#FF0000'>ERRO:</font>Falha ao baixar os binários!");
							pgbStatusProgresso.setString("!!!ERRO!!!");
							pgbStatusProgresso.setIndeterminate(false);
							mnpSistema.setEnabled(false);
							mnpRepositorio.setEnabled(false);
							mnpLocalhost.setEnabled(false);
							mnpAjuda.setEnabled(false);
							setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
							return;
						}
					} else {
						FrmTMWMaker2.setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>ERRO:</b></font> O seu sistema operacional <font face=\"monospace\" color=\"#FF0000\">não possui os binários</font> necessários para montar o localhost do TMW-Maker!");
						DialogClass.showErro(
							"<html><b>O seu sistema operacional <font face=\"monospace\" color=\"#FF0000\">não possui os binários</font> necessários para montar o localhost do TMW-Maker!</html>",
							"ERRO DE EXECUÇÃO"
						);
						pgbStatusProgresso.setString("!!!ERRO!!!");
						pgbStatusProgresso.setIndeterminate(false);
						mnpSistema.setEnabled(false);
						mnpRepositorio.setEnabled(false);
						mnpLocalhost.setEnabled(false);
						mnpAjuda.setEnabled(false);
						setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						return;
					}/**/
					pgbStatusProgresso.setString("Deslocando...");
					if (!FileClass.seExiste(conf.getEathenaData() + bar + "char-server")) {
						FileClass.arquivoMover($PastaBins + bar + "char-server", conf.getEathenaData() + bar + "char-server");
						setAvisoEstatusPainel("<html>Deslocando <font color=\"#0000FF\">char-server</font>...");
					}
					if (!FileClass.seExiste(conf.getEathenaData() + bar + "login-server")) {
						FileClass.arquivoMover($PastaBins + bar + "login-server", conf.getEathenaData() + bar + "login-server");
						setAvisoEstatusPainel("<html>Deslocando <font color=\"#0000FF\">login-server</font>...");
					}
					if (!FileClass.seExiste(conf.getEathenaData() + bar + "map-server")) {
						FileClass.arquivoMover($PastaBins + bar + "map-server", conf.getEathenaData() + bar + "map-server");
						setAvisoEstatusPainel("<html>Deslocando <font color=\"#0000FF\">map-server</font>...");
					}
				}

				/*
				mv -uv conf/atcommand_local.conf.example conf/atcommand_local.conf
				mv -uv conf/battle_local.conf.example conf/battle_local.conf
				mv -uv conf/char_local.conf.example conf/char_local.conf
				mv -uv conf/eathena-monitor.conf.example conf/eathena-monitor.conf
				mv -uv conf/gm_account.txt.example conf/gm_account.txt
				mv -uv conf/help.txt.example conf/help.txt
				mv -uv conf/ladmin_local.conf.example conf/ladmin_local.conf
				mv -uv conf/login_local.conf.example conf/login_local.conf
				mv -uv conf/map_local.conf.example conf/map_local.conf
				mv -uv conf/motd.txt.example conf/motd.txt
				mv -uv save/account.txt.example save/account.txt
				/**/

				String $PastaSaves[] = new String[]{
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "conf",
					conf.getEathenaData() + bar + "save"
				};
				String $NomeOriginal[] = new String[]{
					"atcommand_local.conf.example",
					"battle_local.conf.example",
					"char_local.conf.example",
					"eathena-monitor.conf.example",
					"gm_account.txt.example",
					"help.txt.example",
					"ladmin_local.conf.example",
					"login_local.conf.example",
					"map_local.conf.example",
					"motd.txt.example",
					"account.txt.example"
				};
				String $NomeUtil[] = new String[]{
					"atcommand_local.conf",
					"battle_local.conf",
					"char_local.conf",
					"eathena-monitor.conf",
					"gm_account.txt",
					"help.txt",
					"ladmin_local.conf",
					"login_local.conf",
					"map_local.conf",
					"motd.txt",
					"account.txt"
				};

				for (int $File = 0; $File < $NomeOriginal.length; $File++) {
					if (FileClass.seExiste($PastaSaves[$File] + bar + $NomeOriginal[$File])) {
						/*if(FileClass.seExiste($PastaSaves[$File] + bar + $NomeUtil[$File])) {
							FileClass.apagar($PastaSaves[$File] + bar + $NomeUtil[$File]);
							setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>Apagando:</b></font> \"" + $NomeUtil[$File] + "\"!");
						}/**/
						if(!FileClass.seExiste($PastaSaves[$File]+bar+$NomeUtil[$File])) {
							pgbStatusProgresso.setString("Renomeando...");
							setAvisoEstatusPainel("<html><b>Renomeando:</b> \""+$NomeOriginal[$File]+"\" → \""+$NomeUtil[$File]+"\"");
							FileClass.arquivoMover(
								$PastaSaves[$File]+bar+$NomeOriginal[$File],
								$PastaSaves[$File]+bar+$NomeUtil[$File]
							);
						}
					}
				}

				if (!FileClass.seExiste(conf.getEathenaData() + bar + "log")) {
					/**   Será que é realmente necessário esta pasta "LOG"?
					* Ela serve para os logs do binário "eathena-monitor".
					* Mas o TMwe-Maker2 não usa o binário "eathena-monitor".
					* Mas será que são todos logs do binário "eathena-monitor" ou tem logs de outro sistema?.
					* Em todo caso botarei o códig oabaixo e verificarei mais tarde se realmente é necessário.
					*/
					setAvisoEstatusPainel("<html><b>Criando Pasta:</b> \"" + conf.getEathenaData() + bar + "log\"...");
					FileClass.pastaCriar(conf.getEathenaData() + bar + "log");
				}

				/*
				rm $HOME/tmwserver // Apaga Link
				ln -s $PWD $HOME/tmwserver //Recria Link
				/**/
				String $link = FileClass.getPastaDoUsuario() + bar + "tmwserver";
				if (FileClass.seExiste($link)) {
					pgbStatusProgresso.setString("Excluindo...");
					setAvisoEstatusPainel("Apagando link \""+$link+"\"...");
					FileClass.apagar($link);
				}
				pgbStatusProgresso.setString("Coligando...");
				setAvisoEstatusPainel("Recriando link \""+$link+"\"...");
				//String $Bash = "ln -s \""+ conf.getEathenaData()+"\" \""+$link+"\"";
				//String $Bash = "ln -s \""+ conf.getEathenaData()+"\" "+$link;
				String $Bash = "ln -s "+ conf.getEathenaData()+" "+$link;
				System.out.println($Bash);
				try{
					doBash($Bash);
				} catch (IOException ex) {
					//Logger.getLogger(FrmTMWMaker2.class.getName()).log(Level.SEVERE, null, ex);
					setAvisoEstatusPainel("<html><font color='#FF0000'>ERRO:</font> "+$Bash);
					pgbStatusProgresso.setString("!!!ERRO!!!");
					pgbStatusProgresso.setIndeterminate(false);
					mnpSistema.setEnabled(false);
					mnpRepositorio.setEnabled(false);
					mnpLocalhost.setEnabled(false);
					mnpAjuda.setEnabled(false);
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					return;
				}

				//
				String $Depurador = conf.getEathenaData()+bar+"tmw-maker-depure.sh";
				if(!FileClass.seExiste($Depurador)){
					setAvisoEstatusPainel("<html><b>Criando Depurador:</b> \"<font color='#FF0000'>"+$Depurador +"</font>\"...");
					FileClass.arquivoSalvar(
						$Depurador,
						"#!/bin/bash\n"+
						"\n"+
						"cd $HOME/tmwserver\n"+
						"./login-server &\n"+
						"./char-server &\n"+
						"./map-server &"
					);
					//$Comando="chmod +x \""+$Depurador +"\"";
					$Bash="chmod +x "+$Depurador;
					try{
						doBash($Bash);
					} catch (IOException ex) {
						//Logger.getLogger(FrmTMWMaker2.class.getName()).log(Level.SEVERE, null, ex);
						setAvisoEstatusPainel("<html><font color='#FF0000'>ERRO:</font> "+$Bash);
						pgbStatusProgresso.setString("!!!ERRO!!!");
						pgbStatusProgresso.setIndeterminate(false);
						mnpSistema.setEnabled(false);
						mnpRepositorio.setEnabled(false);
						mnpLocalhost.setEnabled(false);
						mnpAjuda.setEnabled(false);
						setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						return;
					}
				}
				setAvisoEstatusPainel("<html><font color=\"#0000FF\">Locahost montado com sucesso!");
				pgbStatusProgresso.setString("Concluido!");
				DialogClass.showAlerta(
					"<html>"+
					"<font color=\"#0000FF\">Locahost montado com sucesso!</font><br/>"+
					"<br/>"+
					"Precione F7 para ativar o localhost, e<br/>"+
					"depois F5 para executar o softcliente!",
					"MONTAGEM CONCLUIDA",
					new javax.swing.ImageIcon(getClass().getResource("/imagens/fundos/icon-tmw-96x96px.png"))
				);
				pgbStatusProgresso.setIndeterminate(false);
				mnpSistema.setEnabled(true);
				mnpRepositorio.setEnabled(true);
				mnpLocalhost.setEnabled(true);
				mnpAjuda.setEnabled(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		tThread.start();
	}
	public void ServerPlay() {
		if (FileClass.getSysName().indexOf("win") >= 0) {
			/*String[] cmd = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "start";
			cmd[3] = URL;
			Executador.exec(cmd);/**/
			DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
		} else if (FileClass.getSysName().indexOf("mac") >= 0) {
			//Executador.exec("open " + URL);
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else if (FileClass.getSysName().indexOf("linux") >= 0) {
			Thread tThread = new Thread(new Runnable() {
				public void run() {
					ServerPlayLinux();
				}
			});
			tThread.start();
		} else {
			DialogClass.showErro("Este comando ainda não foi implementado para o sistema operacional "+FileClass.getSysName()+"!", "Descupe!");
		}
	}
	public void ServerPlayLinux() {
		pgbStatusProgresso.setEnabled(true);
		pgbStatusProgresso.setValue(0);
		pgbStatusProgresso.setMinimum(0);
		pgbStatusProgresso.setMaximum(5);
		txtPainel.setText("");
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		Runtime Executador = Runtime.getRuntime();
		String line = "", $ServerDepurador = conf.getEathenaData()+bar+"tmw-maker-depure.sh";
		if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
			if(FileClass.seExiste($ServerDepurador)){
				$ServerDepurador = $ServerDepurador.replaceAll(" ", "\\\\ ");
				pgbStatusProgresso.setString("Ativando...");
				setAvisoEstatusPainel("Ativando Servidor Local...");
				try {
					pgbStatusProgresso.setIndeterminate(true);
					Executador = doBash(Executador, $ServerDepurador);
					pgbStatusProgresso.setIndeterminate(false);
					setAvisoEstatusPainel("<html>Eathena reiniciado com sucesso!");
					if(mncTestarAposAtivacao.isSelected()){ServerExecutar();}
				} catch (IOException e) {
					e.printStackTrace();
					setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + $ServerDepurador);
					DialogClass.showErro(
						"<html><b>O TMW-Maker não conseguiu reiniciar o eathena:</b><br/><br/>"
						+ "01: <font face=\"monospace\" color=\"#FF0000\">" + $ServerDepurador + "</font><br/>"
						+ "</html>",
						"ERRO DE EXECUÇÃO"
					);
				}
			}else{
				setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>ERRO:</b></font> Não foi possível encontrar o depurador!");
				DialogClass.showErro(
					"<html><b>O TMW-Maker não conseguiu encontrar o depurador!</b><br/><br/>"
					+ "01: <font face=\"monospace\" color=\"#FF0000\">" + $ServerDepurador + "</font><br/>"
					+ "</html>",
					"ERRO DE EXECUÇÃO"
				);
			}
		}
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	public void ServerStop() {
		if (FileClass.getSysName().indexOf("win") >= 0) {
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
		} else if (FileClass.getSysName().indexOf("mac") >= 0) {
			//Executador.exec("open " + URL);
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else {
			Thread tThread = new Thread(new Runnable() {

				public void run() {
					//mnpArquivo.setEnabled(false);
					//mnpRepositorio.setEnabled(false);
					//mnuLocalhostDesativar.setEnabled(false);
					//VerificarbarDeFerramentas();

					pgbStatusProgresso.setEnabled(true);
					pgbStatusProgresso.setValue(0);
					pgbStatusProgresso.setMinimum(0);
					pgbStatusProgresso.setMaximum(5);
					pgbStatusProgresso.setIndeterminate(false);

					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					Runtime Executador = Runtime.getRuntime();
					String line = "", Comando = "";

					if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
						pgbStatusProgresso.setString("Desativando...");
						setAvisoEstatusPainel("Desativando localhost...");
						//TxtEstatus.setText("Reiniciando localhost...");
						try {
							Executador = doBash(Executador, "pkill map-server");
							Executador = doBash(Executador, "pkill char-server");
							Executador = doBash(Executador, "pkill login-server");
							setAvisoEstatusPainel("Localhost desativado com sucesso!");
							pgbStatusProgresso.setString("Desativado!");
						} catch (IOException e) {
							pgbStatusProgresso.setString("ERRO");
							e.printStackTrace();
							//TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
							setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
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
	public void ServerExecutar() {
		if (FileClass.getSysName().indexOf("win") >= 0) {
			/*String[] cmd = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "start";
			cmd[3] = URL;
			Executador.exec(cmd);/**/
			DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
		} else if (FileClass.getSysName().indexOf("mac") >= 0) {
			//Executador.exec("open " + URL);
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else {
			Thread tThread = new Thread(new Runnable() {
				public void run() {
					//mnpArquivo.setEnabled(false);
					//mnpRepositorio.setEnabled(false);
					//VerificarbarDeFerramentas();


					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					Runtime Executador = Runtime.getRuntime();
					String line = "", Comando = "";

					pgbStatusProgresso.setEnabled(true);
					pgbStatusProgresso.setMinimum(0);
					pgbStatusProgresso.setMaximum(5);
					pgbStatusProgresso.setValue(5);
					pgbStatusProgresso.setIndeterminate(false);
					setAvisoEstatusPainel("<html>Contagem de 5 segundos antes da execução...");
					long TempoInicio = 0, TempoAtual = 0, Milisegundos = 5500, Segundos = 0;
					TempoInicio = System.currentTimeMillis();
					do {
						TempoAtual = System.currentTimeMillis();
						Segundos = (TempoAtual - TempoInicio) / 1000;
						pgbStatusProgresso.setValue((int) Segundos);
						pgbStatusProgresso.setString("00:00:0" + (5 - ((int) Segundos)));
					} while (TempoAtual - TempoInicio < Milisegundos);
					pgbStatusProgresso.setIndeterminate(true);

					//TxtEstatus.setText(TxtEstatus.getText()+"\nAbrindo aplicativo \""+conf.getExecucaoComando()+"\"...");
					setAvisoEstatusPainel("Abrindo aplicativo \"" + conf.getExecucaoComando() + "\"...");
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
							setAvisoEstatusPainel("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\": " + line);
							pgbStatusProgresso.setString("Executando...");
						}
						pgbStatusProgresso.setString("Fechado!");
						setAvisoEstatusPainel("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\" fechando!");
						if(mncDesativarAposTestes.isSelected()){ServerStop();}
						//pgbProgresso.setIndeterminate(false);
					} catch (IOException e) {
						//pgbProgresso.setIndeterminate(false);
						e.printStackTrace();
						//pgbProgresso.setValue(5);
						//mnpArquivo.setEnabled(true);
						//mnpRepositorio.setEnabled(true);
						//VerificarbarDeFerramentas();
						//setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						//return;
					}
					pgbStatusProgresso.setIndeterminate(false);
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
			});
			tThread.start();
		}
	}

	public void ExecutarJogo_deprecado() {
		if (FileClass.getSysName().indexOf("win") >= 0) {
			/*String[] cmd = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "start";
			cmd[3] = URL;
			Executador.exec(cmd);/**/
			DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
		} else if (FileClass.getSysName().indexOf("mac") >= 0) {
			//Executador.exec("open " + URL);
			DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
		} else {
			Thread tThread = new Thread(new Runnable() {

				public void run() {
					mnpSistema.setEnabled(false);
					mnpRepositorio.setEnabled(false);
					//VerificarbarDeFerramentas();

					pgbStatusProgresso.setEnabled(true);
					pgbStatusProgresso.setValue(0);
					pgbStatusProgresso.setMinimum(0);
					pgbStatusProgresso.setMaximum(5);

					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					Runtime Executador = Runtime.getRuntime();
					String line = "", Comando = "";

					if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
						pgbStatusProgresso.setString("Reiniciando...");
						setAvisoEstatusPainel("Reiniciando localhost...");
						//TxtEstatus.setText("Reiniciando localhost...");
						try {
							/*Comando = conf.getConexaoLocalhost() + "/eathena-data/eathena.sh restart";
							setAvisoEstatus(Comando);
							//TxtEstatus.setText(TxtEstatus.getText()+"\n"+Comando);
							Process Retorno = Executador.exec(Comando);
							BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
							while ((line = in.readLine()) != null) {
								setAvisoEstatus(line);
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
							setAvisoEstatusPainel("<html>Eathena reiniciado (<font color=\"#0000FF\"><b>Espere 5 segundos...</b></font>)");
							long TempoInicio = 0, TempoAtual = 0, Milisegundos = 5500, Segundos = 0;
							TempoInicio = System.currentTimeMillis();
							do {
								TempoAtual = System.currentTimeMillis();
								Segundos = (TempoAtual - TempoInicio) / 1000;
								//setAvisoEstatusPainel("Espere "+Segundos+"/5 segundos...");
								pgbStatusProgresso.setValue((int) Segundos);
								pgbStatusProgresso.setString("00:00:0" + (5 - ((int) Segundos)));
							} while (TempoAtual - TempoInicio < Milisegundos);
						} catch (IOException e) {
							e.printStackTrace();
							//TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
							setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
							DialogClass.showErro("<html><b>O TMW-Maker não conseguiu reiniciar o eathena:</b><br/><br/>"
									  + "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>"
									  + "</html>",
									  "ERRO DE EXECUÇÃO");
							pgbStatusProgresso.setValue(5);
							mnpSistema.setEnabled(true);
							mnpRepositorio.setEnabled(true);
							setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
							//VerificarbarDeFerramentas();
							return;
						}
					}
					pgbStatusProgresso.setIndeterminate(true);
					//TxtEstatus.setText(TxtEstatus.getText()+"\nAbrindo aplicativo \""+conf.getExecucaoComando()+"\"...");
					setAvisoEstatusPainel("Abrindo aplicativo \"" + conf.getExecucaoComando() + "\"...");
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
							setAvisoEstatusPainel("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\": " + line);
							pgbStatusProgresso.setString("Executando...");
						}
						pgbStatusProgresso.setString("Fechado!");
						setAvisoEstatusPainel("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\" fechando!");
						pgbStatusProgresso.setIndeterminate(false);
					} catch (IOException e) {
						pgbStatusProgresso.setIndeterminate(false);
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
							setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>ERRO DE EXECUÇÃO:</b></font> " + Comando);
							DialogClass.showErro(
									  "<html>O TMW-Maker <font color=\"#FF0000\">não conseguiu abrir</font> nenhum <br/>"
									  + "aplicativo cliente(jogo) de THE MANA WORLD!<br/>"
									  + "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font>", "ERRO DE EXECUÇÃO");
						}/**/
						pgbStatusProgresso.setValue(5);
						mnpSistema.setEnabled(true);
						mnpRepositorio.setEnabled(true);
						//VerificarbarDeFerramentas();
						setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						return;
					}

					if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
						pgbStatusProgresso.setString("Desligando...");
						setAvisoEstatusPainel("Desligando localhost...");
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
 
							setAvisoEstatusPainel("<html><font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font> e <font color=\"#0000FF\"><b>eathena</b></font> executados e encerrados com sucesso!");
							pgbStatusProgresso.setString("Encerrado!");
						} catch (IOException e) {
							e.printStackTrace();
							//TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);

							setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
							DialogClass.showErro("<html><b>O TMW-Maker não conseguiu desligar o eathena:</b><br/><br/>"
									  + "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>"
									  + "</html>",
									  "ERRO DE EXECUÇÃO");
							pgbStatusProgresso.setValue(5);
							mnpSistema.setEnabled(true);
							mnpRepositorio.setEnabled(true);
							//VerificarbarDeFerramentas();
							setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
							return;
						}
					}

					pgbStatusProgresso.setValue(5);
					mnpSistema.setEnabled(true);
					mnpRepositorio.setEnabled(true);
					//VerificarbarDeFerramentas();
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
			});
			tThread.start();
		}
	}

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      pnlBarraDeStatus = new javax.swing.JPanel();
      lblStatusTexto = new javax.swing.JLabel();
      pgbStatusProgresso = new javax.swing.JProgressBar();
      scpPainel = new javax.swing.JScrollPane();
      txtPainel = new javax.swing.JTextArea();
      mbrBarraDeMenu = new javax.swing.JMenuBar();
      mnpSistema = new javax.swing.JMenu();
      mnuSistemaLimparPainel = new javax.swing.JMenuItem();
      jSeparator6 = new javax.swing.JPopupMenu.Separator();
      mnuSistemaAtualizar = new javax.swing.JMenuItem();
      mnuSistemaConfigurar = new javax.swing.JMenuItem();
      jSeparator5 = new javax.swing.JPopupMenu.Separator();
      mnuSistemaSair = new javax.swing.JMenuItem();
      mnpRepositorio = new javax.swing.JMenu();
      mnuRepositorioEnviar = new javax.swing.JMenuItem();
      mnuRepositorioReceber = new javax.swing.JMenuItem();
      jSeparator1 = new javax.swing.JPopupMenu.Separator();
      mnuRepositorioHistorico = new javax.swing.JMenuItem();
      jSeparator4 = new javax.swing.JPopupMenu.Separator();
      mnuRepositorioMontar = new javax.swing.JMenuItem();
      mnpLocalhost = new javax.swing.JMenu();
      mnuLocalhostAtivar = new javax.swing.JMenuItem();
      mnuLocalhostDesativar = new javax.swing.JMenuItem();
      jSeparator2 = new javax.swing.JPopupMenu.Separator();
      mncTestarAposAtivacao = new javax.swing.JCheckBoxMenuItem();
      mncDesativarAposTestes = new javax.swing.JCheckBoxMenuItem();
      jSeparator3 = new javax.swing.JPopupMenu.Separator();
      mnuLocalhostExecutar = new javax.swing.JMenuItem();
      mnpAjuda = new javax.swing.JMenu();
      mnuAjudaInformarDefeito = new javax.swing.JMenuItem();
      mnuAjudaForum = new javax.swing.JMenuItem();
      jSeparator7 = new javax.swing.JPopupMenu.Separator();
      mnuAjudaSobre = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("TMW-Maker II Java");
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
         }
      });

      pnlBarraDeStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

      lblStatusTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      lblStatusTexto.setText("Bem Vindo!");

      pgbStatusProgresso.setValue(100);
      pgbStatusProgresso.setString("");
      pgbStatusProgresso.setStringPainted(true);

      javax.swing.GroupLayout pnlBarraDeStatusLayout = new javax.swing.GroupLayout(pnlBarraDeStatus);
      pnlBarraDeStatus.setLayout(pnlBarraDeStatusLayout);
      pnlBarraDeStatusLayout.setHorizontalGroup(
         pnlBarraDeStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraDeStatusLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblStatusTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(pgbStatusProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      pnlBarraDeStatusLayout.setVerticalGroup(
         pnlBarraDeStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pnlBarraDeStatusLayout.createSequentialGroup()
            .addGroup(pnlBarraDeStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblStatusTexto)
               .addComponent(pgbStatusProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, 0))
      );

      pnlBarraDeStatusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblStatusTexto, pgbStatusProgresso});

      txtPainel.setBackground(new java.awt.Color(0, 92, 0));
      txtPainel.setColumns(20);
      txtPainel.setEditable(false);
      txtPainel.setFont(new java.awt.Font("Courier New", 0, 15));
      txtPainel.setForeground(java.awt.Color.white);
      txtPainel.setRows(5);
      txtPainel.setText("\n     → Bem Vindos ao TMW-Maker Java versão II...\n");
      scpPainel.setViewportView(txtPainel);

      mnpSistema.setText("Arquivo");

      mnuSistemaLimparPainel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
      mnuSistemaLimparPainel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_borracha.png"))); // NOI18N
      mnuSistemaLimparPainel.setText("Limpar Painel");
      mnuSistemaLimparPainel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSistemaLimparPainelActionPerformed(evt);
         }
      });
      mnpSistema.add(mnuSistemaLimparPainel);
      mnpSistema.add(jSeparator6);

      mnuSistemaAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_update.gif"))); // NOI18N
      mnuSistemaAtualizar.setText("Atualizar Engine");
      mnuSistemaAtualizar.setEnabled(false);
      mnpSistema.add(mnuSistemaAtualizar);

      mnuSistemaConfigurar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
      mnuSistemaConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_chaveinglesa.png"))); // NOI18N
      mnuSistemaConfigurar.setText("Configurar...");
      mnuSistemaConfigurar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSistemaConfigurarActionPerformed(evt);
         }
      });
      mnpSistema.add(mnuSistemaConfigurar);
      mnpSistema.add(jSeparator5);

      mnuSistemaSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_exit.png"))); // NOI18N
      mnuSistemaSair.setText("Sair");
      mnuSistemaSair.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSistemaSairActionPerformed(evt);
         }
      });
      mnpSistema.add(mnuSistemaSair);

      mbrBarraDeMenu.add(mnpSistema);

      mnpRepositorio.setText("Repositório");

      mnuRepositorioEnviar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_UP, java.awt.event.InputEvent.SHIFT_MASK));
      mnuRepositorioEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_upload.gif"))); // NOI18N
      mnuRepositorioEnviar.setText("Enviar");
      mnuRepositorioEnviar.setEnabled(false);
      mnpRepositorio.add(mnuRepositorioEnviar);

      mnuRepositorioReceber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_DOWN, java.awt.event.InputEvent.SHIFT_MASK));
      mnuRepositorioReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_download.gif"))); // NOI18N
      mnuRepositorioReceber.setText("Receber");
      mnuRepositorioReceber.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuRepositorioReceberActionPerformed(evt);
         }
      });
      mnpRepositorio.add(mnuRepositorioReceber);
      mnpRepositorio.add(jSeparator1);

      mnuRepositorioHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
      mnuRepositorioHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_file_rss.gif"))); // NOI18N
      mnuRepositorioHistorico.setText("Histórico...");
      mnuRepositorioHistorico.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuRepositorioHistoricoActionPerformed(evt);
         }
      });
      mnpRepositorio.add(mnuRepositorioHistorico);
      mnpRepositorio.add(jSeparator4);

      mnuRepositorioMontar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_puzzle.png"))); // NOI18N
      mnuRepositorioMontar.setText("Montar");
      mnuRepositorioMontar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuRepositorioMontarActionPerformed(evt);
         }
      });
      mnpRepositorio.add(mnuRepositorioMontar);

      mbrBarraDeMenu.add(mnpRepositorio);

      mnpLocalhost.setText("Localhost");

      mnuLocalhostAtivar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
      mnuLocalhostAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_play.png"))); // NOI18N
      mnuLocalhostAtivar.setText("Ativar");
      mnuLocalhostAtivar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostAtivarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostAtivar);

      mnuLocalhostDesativar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
      mnuLocalhostDesativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_parar.png"))); // NOI18N
      mnuLocalhostDesativar.setText("Desativar");
      mnuLocalhostDesativar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostDesativarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostDesativar);
      mnpLocalhost.add(jSeparator2);

      mncTestarAposAtivacao.setText("Testar após ativação");
      mnpLocalhost.add(mncTestarAposAtivacao);

      mncDesativarAposTestes.setSelected(true);
      mncDesativarAposTestes.setText("Desativar após testes");
      mnpLocalhost.add(mncDesativarAposTestes);
      mnpLocalhost.add(jSeparator3);

      mnuLocalhostExecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
      mnuLocalhostExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      mnuLocalhostExecutar.setText("Executar...");
      mnuLocalhostExecutar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostExecutarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostExecutar);

      mbrBarraDeMenu.add(mnpLocalhost);

      mnpAjuda.setText("Ajuda");

      mnuAjudaInformarDefeito.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
      mnuAjudaInformarDefeito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_broken.png"))); // NOI18N
      mnuAjudaInformarDefeito.setText("Informar defeito...");
      mnuAjudaInformarDefeito.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuAjudaInformarDefeitoActionPerformed(evt);
         }
      });
      mnpAjuda.add(mnuAjudaInformarDefeito);

      mnuAjudaForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_forum.png"))); // NOI18N
      mnuAjudaForum.setText("Forum TMW-BR");
      mnuAjudaForum.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuAjudaForumActionPerformed(evt);
         }
      });
      mnpAjuda.add(mnuAjudaForum);
      mnpAjuda.add(jSeparator7);

      mnuAjudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
      mnuAjudaSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_informacao.png"))); // NOI18N
      mnuAjudaSobre.setText("Sobre...");
      mnuAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuAjudaSobreActionPerformed(evt);
         }
      });
      mnpAjuda.add(mnuAjudaSobre);

      mbrBarraDeMenu.add(mnpAjuda);

      setJMenuBar(mbrBarraDeMenu);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(pnlBarraDeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(scpPainel, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
            .addGap(12, 12, 12))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(scpPainel, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pnlBarraDeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
	private void mnuSistemaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSistemaSairActionPerformed
		// TODO add your handling code here:
		System.exit(0);
	}//GEN-LAST:event_mnuSistemaSairActionPerformed
	private void mnuRepositorioReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRepositorioReceberActionPerformed
		// TODO add your handling code here:
		doCheckoutHead();
	}//GEN-LAST:event_mnuRepositorioReceberActionPerformed
	private void mnuSistemaConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSistemaConfigurarActionPerformed
		// TODO add your handling code here:
		javax.swing.JDialog frmConfiguracao = new FrmConfiguracao(this, rootPaneCheckingEnabled);
		frmConfiguracao.setLocation(
			((this.getWidth() - frmConfiguracao.getWidth()) / 2) + this.getX(),
			((this.getHeight() - frmConfiguracao.getHeight()) / 2) + this.getY()
		);
		frmConfiguracao.pack();
		frmConfiguracao.setModal(true);
		frmConfiguracao.setVisible(true);/**/
	}//GEN-LAST:event_mnuSistemaConfigurarActionPerformed
	private void mnuLocalhostExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLocalhostExecutarActionPerformed
		//ExecutarJogo_deprecado();
		ServerExecutar();
	}//GEN-LAST:event_mnuLocalhostExecutarActionPerformed
	private void mnuLocalhostAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLocalhostAtivarActionPerformed
		ServerPlay();
	}//GEN-LAST:event_mnuLocalhostAtivarActionPerformed
	private void mnuLocalhostDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLocalhostDesativarActionPerformed
		 ServerStop();
	}//GEN-LAST:event_mnuLocalhostDesativarActionPerformed
	private void mnuAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAjudaSobreActionPerformed
		Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
		javax.swing.JDialog frmSobre = new FrmSobre(this, rootPaneCheckingEnabled);
		frmSobre.setModal(true);
		frmSobre.pack();
		int x = ((int)Tela.getWidth() - frmSobre.getWidth()) / 2;
		int y = ((int)Tela.getHeight() - frmSobre.getHeight()) / 2;
		frmSobre.setLocation(x,y);
		frmSobre.setVisible(true);/**/
	}//GEN-LAST:event_mnuAjudaSobreActionPerformed
	private void mnuRepositorioMontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRepositorioMontarActionPerformed
		// TODO add your handling code here:
		doMontar();
	}//GEN-LAST:event_mnuRepositorioMontarActionPerformed
	private void mnuSistemaLimparPainelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSistemaLimparPainelActionPerformed
		// TODO add your handling code here:
		if(!txtPainel.getText().equals("")){
			if(
			  DialogClass.showOpcoes(
					"Deseja realmente limpar os dados do painel?",
					"LIMPEZA DE PAINEL",
					new javax.swing.ImageIcon(getClass().getResource("/imagens/fundos/icon-tmwmaker-96x96px.png")),
					new Object[] {"Limpar", "Cancelar"},
					1
				)==0
			){txtPainel.setText("");}
		}
	}//GEN-LAST:event_mnuSistemaLimparPainelActionPerformed
	private void mnuRepositorioHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRepositorioHistoricoActionPerformed
		// TODO add your handling code here:
		FileClass.AbrirNavegador("https://code.google.com/p/themanaworld-br/source/list");
	}//GEN-LAST:event_mnuRepositorioHistoricoActionPerformed
	private void mnuAjudaInformarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAjudaInformarDefeitoActionPerformed
		// TODO add your handling code here:
		FileClass.AbrirNavegador("mailto:Lunovox%20Heavenfinder<rui.gravata@gmail.com>?subject=Defeito%20no%20TMW-Maker%20versão%202");
	}//GEN-LAST:event_mnuAjudaInformarDefeitoActionPerformed
	private void mnuAjudaForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAjudaForumActionPerformed
		// TODO add your handling code here:
		FileClass.AbrirNavegador("http://forums.themanaworld.com.br");
	}//GEN-LAST:event_mnuAjudaForumActionPerformed

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new FrmTMWMaker2().setVisible(true);
			}
		});
	}
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JPopupMenu.Separator jSeparator1;
   private javax.swing.JPopupMenu.Separator jSeparator2;
   private javax.swing.JPopupMenu.Separator jSeparator3;
   private javax.swing.JPopupMenu.Separator jSeparator4;
   private javax.swing.JPopupMenu.Separator jSeparator5;
   private javax.swing.JPopupMenu.Separator jSeparator6;
   private javax.swing.JPopupMenu.Separator jSeparator7;
   public static javax.swing.JLabel lblStatusTexto;
   private javax.swing.JMenuBar mbrBarraDeMenu;
   private javax.swing.JCheckBoxMenuItem mncDesativarAposTestes;
   private javax.swing.JCheckBoxMenuItem mncTestarAposAtivacao;
   private javax.swing.JMenu mnpAjuda;
   private javax.swing.JMenu mnpLocalhost;
   private javax.swing.JMenu mnpRepositorio;
   private javax.swing.JMenu mnpSistema;
   private javax.swing.JMenuItem mnuAjudaForum;
   private javax.swing.JMenuItem mnuAjudaInformarDefeito;
   private javax.swing.JMenuItem mnuAjudaSobre;
   private javax.swing.JMenuItem mnuLocalhostAtivar;
   private javax.swing.JMenuItem mnuLocalhostDesativar;
   private javax.swing.JMenuItem mnuLocalhostExecutar;
   private javax.swing.JMenuItem mnuRepositorioEnviar;
   private javax.swing.JMenuItem mnuRepositorioHistorico;
   private javax.swing.JMenuItem mnuRepositorioMontar;
   private javax.swing.JMenuItem mnuRepositorioReceber;
   private javax.swing.JMenuItem mnuSistemaAtualizar;
   private javax.swing.JMenuItem mnuSistemaConfigurar;
   private javax.swing.JMenuItem mnuSistemaLimparPainel;
   private javax.swing.JMenuItem mnuSistemaSair;
   private javax.swing.JProgressBar pgbStatusProgresso;
   private javax.swing.JPanel pnlBarraDeStatus;
   private javax.swing.JScrollPane scpPainel;
   public static javax.swing.JTextArea txtPainel;
   // End of variables declaration//GEN-END:variables
}
