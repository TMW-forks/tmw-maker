/*
 * FrmTMWMaker2.java
 * Created on 30/05/2012, 16:34:09
 * @author lunovox
 */
package formularios;
import Formularios.FrmSpawnEditor;
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
		onAtivacao();
	}/**/
	public static ClassConfiguracao conf = new ClassConfiguracao();
	SummarizerSVN svn;
	String bar = FileClass.getSeparadorDePastas();
	//String sys = FileClass.getPastaDoSistema();

	public void setAtivacao(boolean SeAtivo){
		mnpSistema.setEnabled(SeAtivo);
		mnpRepositorio.setEnabled(SeAtivo);
		mnpEditar.setEnabled(SeAtivo);
		mnpLocalhost.setEnabled(SeAtivo);
		onAtivacao();
	}
	public void onAtivacao(){
		btnSistemaImportarArquivo.setEnabled(mnpSistema.isEnabled() && mnuSistemaImportarArquivo.isEnabled());
		btnSistemaLimparPainel.setEnabled(mnpSistema.isEnabled() && mnuSistemaLimparPainel.isEnabled());
		btnSistemaConfigurar.setEnabled(mnpSistema.isEnabled() && mnuSistemaConfigurar.isEnabled());

		btnRepositorioReceber.setEnabled(mnpRepositorio.isEnabled() && mnuRepositorioReceber.isEnabled());
		//btnRepositorioEnviar.setEnabled(mnpRepositorio.isEnabled() && mnuRepositorioEnviar.isEnabled());
		btnRepositorioHistorico.setEnabled(mnpRepositorio.isEnabled() && mnuRepositorioHistorico.isEnabled());
		btnRepositorioMontar.setEnabled(mnpRepositorio.isEnabled() && mnuRepositorioMontar.isEnabled());

		btnEditarMonstros.setEnabled(mnpEditar.isEnabled() && mnuEditarMonstros.isEnabled());
		btnEditarSequencia.setEnabled(mnpEditar.isEnabled() && mnuEditarSequencia.isEnabled());

		btnLocalhostAtivar.setEnabled(mnpLocalhost.isEnabled() && mnuLocalhostAtivar.isEnabled());
		btnLocalhostDesativar.setEnabled(mnpLocalhost.isEnabled() && mnuLocalhostDesativar.isEnabled());
		btnLocalhostExecutar.setEnabled(mnpLocalhost.isEnabled() && mnuLocalhostExecutar.isEnabled());

		btnAjudaInformarDefeito.setEnabled(mnpAjuda.isEnabled() && mnuAjudaInformarDefeito.isEnabled());
		btnAjudaForum.setEnabled(mnpAjuda.isEnabled() && mnuAjudaForum.isEnabled());
		btnAjudaSobre.setEnabled(mnpAjuda.isEnabled() && mnuAjudaSobre.isEnabled());

	}
	public static void addLinhaPainel(String Linha) throws IllegalArgumentException {
		Linha = Linha.replaceAll("<html>", "");
		Linha = Linha.replaceAll("<b>", "");
		Linha = Linha.replaceAll("</b>", "");
		Linha = Linha.replaceAll("<i>", "");
		Linha = Linha.replaceAll("</i>", "");
		Linha = Linha.replaceAll("<u>", "");
		Linha = Linha.replaceAll("</u>", "");
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
		if(!txtPainel.getText().trim().equals("")){
			txtPainel.setSelectionStart(txtPainel.getText().length() - 1);
			txtPainel.setSelectionEnd(txtPainel.getText().length() - 1);
		}
	}
	public static void setAvisoEstatus(String Aviso) {
		lblStatusTexto.setText(Aviso.toString());
	}
	public static void setAvisoEstatus(String Aviso, Icon Icone) {
		lblStatusTexto.setText(Aviso.toString());
		lblStatusTexto.setIcon(Icone);
	}
	public static void setAvisoEstatus(String Aviso, String EnderecoOuResource) {
		lblStatusTexto.setText(Aviso.toString());
		lblStatusTexto.setIcon((new ImagemClass(EnderecoOuResource)).getIcone());
	}
	public void setAvisoEstatusPainel(String Linha) {
		addLinhaPainel(Linha);
		//setAvisoEstatus(Linha, new ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png")));/**/
		setAvisoEstatus(Linha);/**/
	}
	public static Runtime doBash(Runtime Executador, String[] $Comandos) throws IOException {
		//Runtime Executador = Runtime.getRuntime();
		String line = "";
		for(int $c=0;$c<$Comandos.length;$c++){
			addLinhaPainel($Comandos[$c]);
		}
		Process Retorno = Executador.exec($Comandos);
		BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
		while ((line = in.readLine()) != null){ addLinhaPainel(line); }
		return Executador;
	}
	public static Runtime doBash(Runtime Executador, String Comando) throws IOException {
		//Runtime Executador = Runtime.getRuntime();
		String line = "";
		addLinhaPainel(Comando);
		Process Retorno = Executador.exec(Comando);
		BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
		while ((line = in.readLine()) != null){ addLinhaPainel(line); }
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
				setAtivacao(false);
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
				setAtivacao(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

				if(
					(
					FileClass.getSysName().toLowerCase().indexOf("linux") >= 0 &&
						(
							!FileClass.seExiste(conf.getEathenaData() + bar + "char-server") ||
							!FileClass.seExiste(conf.getEathenaData() + bar + "login-server") ||
							!FileClass.seExiste(conf.getEathenaData() + bar + "map-server") ||
							!FileClass.seExiste(FileClass.getPastaDoUsuario() + bar + "tmwserver") ||
							!FileClass.seExiste(conf.getEathenaData()+bar+"tmw-maker-depure.sh")
						)
					) || (
					FileClass.getSysName().toLowerCase().indexOf("win") >= 0 &&
						(
							!FileClass.seExiste(conf.getEathenaData() + bar + "char-server.exe") ||
							!FileClass.seExiste(conf.getEathenaData() + bar + "login-server.exe") ||
							!FileClass.seExiste(conf.getEathenaData() + bar + "map-server.exe") ||
							!FileClass.seExiste(conf.getEathenaData()+bar+"tmw-maker-depure.bat")
						)
					)
				){
					int R = 0; //0 = "Cancelar"
					setAvisoEstatusPainel("Deseja montar o localhost agora?");
					R = DialogClass.showOpcoes(
						"<html>"+
						"O seu localhost não está montado.<br/>"+
						"É necessário montá-lo para executar o modo offline!<br/>"+
						"<font color='#0000FF'>Deseja montá-lo agora?</font>",
						"MONTAGEM DE LOCALHOST",
						new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png")),
						new Object[] {"Montar", "Cancelar"},
						1
					);
					if (R == 0) {
						doMontar();
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
		if (FileClass.getSysName().toLowerCase().indexOf("win") >= 0) {
			//DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			Thread tThread = new Thread(new Runnable() {public void run() {doMontarWindows();}});
			tThread.start();
		} else if (FileClass.getSysName().toLowerCase().indexOf("linux") >= 0) {
			Thread tThread = new Thread(new Runnable() {public void run() {doMontarLinux();}});
			tThread.start();
		} else {
			DialogClass.showErro("A Montagem ainda não foi implementado para o sistema operacional "+FileClass.getSysName()+"!", "Descupe!");
		}
	}
	public void doMontarLinux(){
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setAtivacao(false);
		pgbStatusProgresso.setEnabled(true);
		pgbStatusProgresso.setValue(0);
		pgbStatusProgresso.setIndeterminate(true);
		String $Binario[] = {"login-server","char-server","map-server"};
		if(
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[0]) ||
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[1]) ||
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[2])
		){
			String $URL = "http://tmw-maker.googlecode.com/svn/bins/linux";
			String $PastaBins = FrmTMWMaker2.conf.getConexaoLocalhost() + bar + "bins";
			SummarizerSVN svnBinarios = new SummarizerSVN($URL, $PastaBins);
			pgbStatusProgresso.setString("Baixando...");
			addLinhaPainel("Preparando para baixar binários novos...");
			addLinhaPainel(" * Origem: " + $URL);
			addLinhaPainel(" * Destino: " + $PastaBins);
			setAvisoEstatusPainel("Baixando binários novos...");
			SVNRevision rev = svnBinarios.doCheckout();
			if (rev.getNumber()>=0) {
				setAvisoEstatusPainel("<html>Binários '<font color='#008800'>" + rev.getNumber() + "</font>' baixados com sucesso!");
				pgbStatusProgresso.setString("Concluido!");
			} else {
				setAvisoEstatusPainel("<html><font color='#FF0000'>ERRO:</font>Falha ao baixar os binários!");
				pgbStatusProgresso.setString("!!!ERRO!!!");
				pgbStatusProgresso.setIndeterminate(false);
				setAtivacao(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				return;
			}
			pgbStatusProgresso.setString("Deslocando...");
			for(int $f=0;$f<$Binario.length;$f++){
				if (FileClass.seExiste($PastaBins + bar + $Binario[$f]) && !FileClass.seExiste(conf.getEathenaData() + bar + $Binario[$f])) {
					FileClass.arquivoMover($PastaBins + bar + $Binario[$f], conf.getEathenaData() + bar + $Binario[$f]);
					setAvisoEstatusPainel("<html>Deslocando <font color=\"#0000FF\">"+$Binario[$f]+"</font>...");
				}
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
			setAtivacao(true);
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
				setAtivacao(true);
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
			"Precione F5 para ativar o localhost e executar o softcliente!",
			"MONTAGEM CONCLUIDA",
			new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png"))
		);
		pgbStatusProgresso.setIndeterminate(false);
		setAtivacao(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	public void doMontarWindows(){
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setAtivacao(false);
		pgbStatusProgresso.setEnabled(true);
		pgbStatusProgresso.setValue(0);
		pgbStatusProgresso.setIndeterminate(true);
		String $Binario[] = {"cyggcc_s-1.dll","cygwin1.dll","cygz.dll","ladmin.exe","login-server.exe","char-server.exe","map-server.exe"};
		if(
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[0]) ||
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[1]) ||
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[2]) ||
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[3]) ||
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[4]) ||
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[5]) ||
			!FileClass.seExiste(conf.getEathenaData() + bar + $Binario[6])
		){
			String $URL = "http://tmw-maker.googlecode.com/svn/bins/win";
			String $PastaBins = FrmTMWMaker2.conf.getConexaoLocalhost() + bar + "bins";
			SummarizerSVN svnBinarios = new SummarizerSVN($URL, $PastaBins);
			pgbStatusProgresso.setString("Baixando...");
			addLinhaPainel("Preparando para baixar binários novos...");
			addLinhaPainel(" * Origem: " + $URL);
			addLinhaPainel(" * Destino: " + $PastaBins);
			setAvisoEstatusPainel("Baixando binários novos...");
			SVNRevision rev = svnBinarios.doCheckout();
			if (rev.getNumber()>=0) {
				setAvisoEstatusPainel("<html>Binários '<font color='#008800'>" + rev.getNumber() + "</font>' baixados com sucesso!");
				pgbStatusProgresso.setString("Concluido!");
			} else {
				setAvisoEstatusPainel("<html><font color='#FF0000'>ERRO:</font>Falha ao baixar os binários!");
				pgbStatusProgresso.setString("!!!ERRO!!!");
				pgbStatusProgresso.setIndeterminate(false);
				setAtivacao(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				return;
			}
			pgbStatusProgresso.setString("Deslocando...");
			for(int $f=0;$f<$Binario.length;$f++){
				if (FileClass.seExiste($PastaBins + bar + $Binario[$f]) && !FileClass.seExiste(conf.getEathenaData() + bar + $Binario[$f])) {
					FileClass.arquivoMover($PastaBins + bar + $Binario[$f], conf.getEathenaData() + bar + $Binario[$f]);
					setAvisoEstatusPainel("<html>Deslocando <font color=\"#0000FF\">"+$Binario[$f]+"</font>...");
				}
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

		/*String $PastaSaves[] = new String[]{
			conf.getEathenaData() + bar + "conf", conf.getEathenaData() + bar + "conf", conf.getEathenaData() + bar + "conf", conf.getEathenaData() + bar + "conf",
			conf.getEathenaData() + bar + "conf", conf.getEathenaData() + bar + "conf", conf.getEathenaData() + bar + "conf", conf.getEathenaData() + bar + "conf",
			conf.getEathenaData() + bar + "conf", conf.getEathenaData() + bar + "conf", conf.getEathenaData() + bar + "save"
		};
		String $NomeOriginal[] = new String[]{
			"atcommand_local.conf.example","battle_local.conf.example",	"char_local.conf.example",	"eathena-monitor.conf.example", "gm_account.txt.example",
			"help.txt.example", "ladmin_local.conf.example", "login_local.conf.example", "map_local.conf.example", "motd.txt.example",	"account.txt.example"
		};
		String $NomeUtil[] = new String[]{
			"atcommand_local.conf", "battle_local.conf",	"char_local.conf", "eathena-monitor.conf", "gm_account.txt", "help.txt", "ladmin_local.conf", "login_local.conf",
			"map_local.conf", "motd.txt", "account.txt"};
		for (int $File = 0; $File < $NomeOriginal.length; $File++) {
			if (FileClass.seExiste($PastaSaves[$File] + bar + $NomeOriginal[$File])) {
				if(!FileClass.seExiste($PastaSaves[$File]+bar+$NomeUtil[$File])) {
					pgbStatusProgresso.setString("Renomeando...");
					setAvisoEstatusPainel("<html><b>Renomeando:</b> \""+$NomeOriginal[$File]+"\" → \""+$NomeUtil[$File]+"\"");
					FileClass.arquivoMover(
						$PastaSaves[$File]+bar+$NomeOriginal[$File],
						$PastaSaves[$File]+bar+$NomeUtil[$File]
					);
				}
			}
		}/**/
		String $Endereco[] = new String[]{
			conf.getEathenaData()+bar+"conf"+bar+"atcommand_local.conf.example",
			conf.getEathenaData()+bar+"conf"+bar+"battle_local.conf.example",
			conf.getEathenaData()+bar+"conf"+bar+"char_local.conf.example",
			conf.getEathenaData()+bar+"conf"+bar+"eathena-monitor.conf.example",
			conf.getEathenaData()+bar+"conf"+bar+"gm_account.txt.example",
			conf.getEathenaData()+bar+"conf"+bar+"help.txt.example",
			conf.getEathenaData()+bar+"conf"+bar+"ladmin_local.conf.example",
			conf.getEathenaData()+bar+"conf"+bar+"login_local.conf.example",
			conf.getEathenaData()+bar+"conf"+bar+"map_local.conf.example",
			conf.getEathenaData()+bar+"conf"+bar+"motd.txt.example",
			conf.getEathenaData()+bar+"save"+bar+"account.txt.example"
		};
		for (int $f = 0; $f < $Endereco.length; $f++) {
			if (FileClass.seExiste($Endereco[$f])) {
				String $Destino = $Endereco[$f].replaceAll(".example","");
				if(!FileClass.seExiste($Destino)) {
					pgbStatusProgresso.setString("Renomeando...");
					setAvisoEstatusPainel("<html><b>Renomeando:</b> \""+$Endereco[$f]+"\" → \""+$Destino+"\"");
					FileClass.arquivoMover($Endereco[$f], $Destino);
				}
			}
		}/**/

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

		String $Depurador = conf.getEathenaData()+bar+"tmw-maker-depure.bat";
		if(!FileClass.seExiste($Depurador)){
			setAvisoEstatusPainel("<html><b>Criando Depurador:</b> \"<font color='#FF0000'>"+$Depurador +"</font>\"...");
			FileClass.arquivoSalvar(
				$Depurador,
				"\n"+
				//"@echo off\n"+"cls\n"+
				"cd "+conf.getEathenaData()+bar+"\n"+
				"start login-server.exe &\n"+
				"start char-server.exe &\n"+
				"start map-server.exe &"
			);
		}/**/

		setAvisoEstatusPainel("<html><font color=\"#0000FF\">Locahost montado com sucesso!");
		pgbStatusProgresso.setString("Concluido!");
		DialogClass.showAlerta(
			"<html>"+
			"<font color=\"#0000FF\">Locahost montado com sucesso!</font><br/>"+
			"<br/>"+
			"Precione F5 para ativar o localhost e executar o softcliente!",
			"MONTAGEM CONCLUIDA",
			new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png"))
		);
		pgbStatusProgresso.setIndeterminate(false);
		setAtivacao(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	public void ServerPlay() {
		if (FileClass.getSysName().indexOf("win") >= 0) {
			/*String[] cmd = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "start";
			cmd[3] = URL;
			Executador.exec(cmd);/**/
			//DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
			Thread tThread = new Thread(new Runnable() {
				public void run() {
					ServerPlayWindows();
				}
			});
			tThread.start();
			if(mncExecutarAposAtivacao.isSelected()){ServerExecutar();}
		} else if (FileClass.getSysName().indexOf("linux") >= 0) {
			Thread tThread = new Thread(new Runnable() {
				public void run() {
					ServerPlayLinux();
				}
			});
			tThread.start();
			if(mncExecutarAposAtivacao.isSelected()){ServerExecutar();}
		} else {
			//MAC → Executador.exec("open " + URL);
			//MAC → DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
			DialogClass.showErro("A execuçãoEste comando ainda não foi implementado para o sistema operacional "+FileClass.getSysName()+"!", "Descupe!");
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
	public void ServerPlayWindows() {
		pgbStatusProgresso.setEnabled(true);
		pgbStatusProgresso.setValue(0);
		pgbStatusProgresso.setMinimum(0);
		pgbStatusProgresso.setMaximum(5);
		txtPainel.setText("");
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		Runtime Executador = Runtime.getRuntime();
		String line = "";

		if (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("localhost")) {
			String $ServerDepurador = conf.getEathenaData()+bar+"tmw-maker-depure.bat";
			if(FileClass.seExiste($ServerDepurador)){
				//$ServerDepurador = $ServerDepurador.replaceAll(" ", "\\\\ "); //← Essa linha é inconveniente no windows
				pgbStatusProgresso.setString("Ativando...");
				setAvisoEstatusPainel("Ativando Servidor Local...");
				try {
					pgbStatusProgresso.setIndeterminate(true);
					Executador = doBash(Executador, $ServerDepurador);
					pgbStatusProgresso.setIndeterminate(false);
					setAvisoEstatusPainel("<html>Eathena reiniciado com sucesso!");
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
			}/**/
			/*String[] $Comandos = new String[4];
			$Comandos[0] = "cmd.exe";
			$Comandos[1] = "/C";
			$Comandos[2] = "start";
			$Comandos[3] = URL;/**/
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
			//DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
			//C:\cygwin\cygwin.exe
			//C:\Arquivos de programas\Mana\mana.exe
			Thread tThread = new Thread(new Runnable() {
				public void run() {ServerStopWindows();}
			});
			tThread.start();
		} else if (FileClass.getSysName().indexOf("linux") >= 0) {
			Thread tThread = new Thread(new Runnable() {
				public void run() {ServerStopLinux();}
			});
			tThread.start();
		} else {
			//Executador.exec("open " + URL);
			//DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
			DialogClass.showErro("Este comando ainda não foi implementado para o sistema operacional "+FileClass.getSysName()+"!", "Descupe!");
		}
	}
	public void ServerStopLinux() {
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
				if(mncFechaClienteAposDesativar.isSelected()){
					Executador = doBash(Executador, "pkill manaplus");
				}
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
	public void ServerStopWindows() {
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
				//Executador = doBash(Executador, "taskkill /im map-server.exe");
				//Executador = doBash(Executador, "taskkill /im char-server.exe");
				//Executador = doBash(Executador, "taskkill /im login-server.exe");
				//taskkill /im "login-server.exe" -f
				Executador = doBash(Executador, "taskkill /im \"map-server.exe\" -f");
				Executador = doBash(Executador, "taskkill /im \"char-server.exe\" -f");
				Executador = doBash(Executador, "taskkill /im \"login-server.exe\" -f");
				if(mncFechaClienteAposDesativar.isSelected()){
					Executador = doBash(Executador, "taskkill /im \"manaplus.exe\" -f");// ← atendendo a pedidos dos usuários. (não sei se funcionará!)
				}
				setAvisoEstatusPainel("Localhost desativado com sucesso!");
				pgbStatusProgresso.setString("Desativado!");
			} catch (IOException e) {
				pgbStatusProgresso.setString("ERRO");
				e.printStackTrace();
				setAvisoEstatusPainel("<html><font color=\"#FF0000\"><b>ERRO:</b></font> O TMW-Maker não conseguiu reiniciar o eathena!");
				DialogClass.showErro("O TMW-Maker não conseguiu reiniciar o eathena!","ERRO DE EXECUÇÃO");
			}
		}
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	public void ServerExecutar() {
			/*String[] cmd = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "start";
			cmd[3] = URL;
			Executador.exec(cmd);/**/
		if (FileClass.getSysName().indexOf("win") >= 0) {
			Thread tThread = new Thread(new Runnable(){public void run() {ServerExecutarWindows();}});
			tThread.start();
		} else if (FileClass.getSysName().indexOf("linux") >= 0) {
			Thread tThread = new Thread(new Runnable(){public void run() {ServerExecutarLinux();}});
			tThread.start();
		} else {
			//Executador.exec("open " + URL);
			//DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
			DialogClass.showErro("Este comando ainda não foi implementado para o sistema operacional "+FileClass.getSysName()+"!", "Descupe!");
		}
	}
	public void ServerExecutarLinux() {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		Runtime Executador = Runtime.getRuntime();
		String line = "", Comando = "";
		pgbStatusProgresso.setEnabled(true);
		pgbStatusProgresso.setMinimum(0);
		pgbStatusProgresso.setMaximum(5);
		pgbStatusProgresso.setValue(5);
		pgbStatusProgresso.setIndeterminate(false);
		long TempoInicio = System.currentTimeMillis(), TempoAtual = 0, Milisegundos = 5500, Segundos = 0;
		setAvisoEstatusPainel("<html>Contagem de "+((int)(Milisegundos/1000))+" segundos antes da execução...");
		do {
			TempoAtual = System.currentTimeMillis();
			Segundos = (TempoAtual - TempoInicio) / 1000;
			pgbStatusProgresso.setValue((int) Segundos);
			pgbStatusProgresso.setString("00:00:0" + (((int)(Milisegundos/1000)) - ((int) Segundos)));
		} while (TempoAtual - TempoInicio < Milisegundos);
		pgbStatusProgresso.setIndeterminate(true);
		pgbStatusProgresso.setString("Executando...");

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
			if(!conf.getExecucaoParametroSenha().equals("")){addLinhaPainel(Comando.replaceAll(conf.getExecucaoParametroSenha(), "********"));}
			Process Retorno = Executador.exec(Comando);
			BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
			while ((line = in.readLine()) != null) {
				addLinhaPainel(line);
			}
			pgbStatusProgresso.setString("Fechado!");
			setAvisoEstatusPainel("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\" fechando!");
			if(mncDesativarAposExecucao.isSelected()){ServerStop();}
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
	public void ServerExecutarWindows() {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		pgbStatusProgresso.setEnabled(true);
		pgbStatusProgresso.setMinimum(0);
		pgbStatusProgresso.setMaximum(5);
		pgbStatusProgresso.setValue(5);
		pgbStatusProgresso.setIndeterminate(false);
		if(FileClass.seExiste(conf.getExecucaoComando())){
			Runtime Executador = Runtime.getRuntime();
			String line = "", Comando = "";
			long TempoInicio = System.currentTimeMillis(), TempoAtual = 0, Milisegundos = 5500, Segundos = 0;
			setAvisoEstatusPainel("<html>Contagem de "+((int)(Milisegundos/1000))+" segundos antes da execução...");
			do {
				TempoAtual = System.currentTimeMillis();
				Segundos = (TempoAtual - TempoInicio) / 1000;
				pgbStatusProgresso.setValue((int) Segundos);
				pgbStatusProgresso.setString("00:00:0" + (((int)(Milisegundos/1000)) - ((int) Segundos)));
			} while (TempoAtual - TempoInicio < Milisegundos);
			pgbStatusProgresso.setIndeterminate(true);
			pgbStatusProgresso.setString("Executando...");

			//TxtEstatus.setText(TxtEstatus.getText()+"\nAbrindo aplicativo \""+conf.getExecucaoComando()+"\"...");
			setAvisoEstatusPainel("Abrindo aplicativo \"" + conf.getExecucaoComando() + "\"...");
			// "C:\Arquivos de programas\Mana\manaplus.exe" "-udC:\Documents and Settings\Administrador\localhost\tmwdata"
			Comando = conf.getExecucaoComando() + " "+
					  "--update-host -D " + //<-- O Manaplus só roda corretamente com essa linha...
					  ((!conf.getTMWData().isEmpty() && (conf.getExecucaoParametroServidor().equals("localhost") || conf.getExecucaoParametroServidor().equals("127.0.0.1"))) ? ("-ud \"" + conf.getTMWData() + "\" ") : "") +
					  (conf.getExecucaoParametroServidor().isEmpty() ? "" : ("-s \"" + conf.getExecucaoParametroServidor() + "\" "))+ 
					  (conf.getExecucaoParametroConta().isEmpty() ? "" : ("-U \"" + conf.getExecucaoParametroConta() + "\" "))+
					  (conf.getExecucaoParametroSenha().isEmpty() ? "" : ("-P \"" + conf.getExecucaoParametroSenha() + "\" "))+
					  (conf.getExecucaoParametroPersonagem().isEmpty() ? "" : ("-c \"" + conf.getExecucaoParametroPersonagem() + "\" "))+
					  (conf.getExecucaoParametroSemOpenGL() == true ? "--no-opengl" : "");
			//DialogClass.showAlerta("<html>Comando:<br/>"+Comando,"TESTE DE PROGRAMADOR");
			try {
				if(!conf.getExecucaoParametroSenha().equals("")){addLinhaPainel(Comando.replaceAll(conf.getExecucaoParametroSenha(), "********"));}
				Process Retorno = Executador.exec(Comando);
				BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
				while ((line = in.readLine()) != null) {
					addLinhaPainel(line);
				}
				pgbStatusProgresso.setString("Fechado!");
				setAvisoEstatusPainel("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + conf.getExecucaoComando() + "</b></font>\" fechando!");
				if(mncDesativarAposExecucao.isSelected()){ServerStop();}
				//pgbProgresso.setIndeterminate(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			setAvisoEstatusPainel("<html><font color=\"#0000FF\">ERRO:</font> Softcliente não encontrado → "+conf.getExecucaoComando());
			DialogClass.showErro("<html>Softcliente não encontrado:<br/> → "+conf.getExecucaoComando(), "ERRO");
		}
		pgbStatusProgresso.setIndeterminate(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      scpPainel = new javax.swing.JScrollPane();
      txtPainel = new javax.swing.JTextArea();
      jToolBar1 = new javax.swing.JToolBar();
      btnSistemaImportarArquivo = new javax.swing.JButton();
      btnSistemaLimparPainel = new javax.swing.JButton();
      btnSistemaConfigurar = new javax.swing.JButton();
      jSeparator8 = new javax.swing.JToolBar.Separator();
      btnRepositorioReceber = new javax.swing.JButton();
      btnRepositorioEnviar = new javax.swing.JButton();
      btnRepositorioHistorico = new javax.swing.JButton();
      btnRepositorioMontar = new javax.swing.JButton();
      jSeparator9 = new javax.swing.JToolBar.Separator();
      btnEditarMonstros = new javax.swing.JButton();
      btnEditarSequencia = new javax.swing.JButton();
      jSeparator10 = new javax.swing.JToolBar.Separator();
      btnLocalhostAtivar = new javax.swing.JButton();
      btnLocalhostDesativar = new javax.swing.JButton();
      btnLocalhostExecutar = new javax.swing.JButton();
      jSeparator12 = new javax.swing.JToolBar.Separator();
      btnAjudaInformarDefeito = new javax.swing.JButton();
      btnAjudaForum = new javax.swing.JButton();
      btnAjudaSobre = new javax.swing.JButton();
      jToolBar2 = new javax.swing.JToolBar();
      pgbStatusProgresso = new javax.swing.JProgressBar();
      jSeparator3 = new javax.swing.JToolBar.Separator();
      lblStatusTexto = new javax.swing.JLabel();
      mbrBarraDeMenu = new javax.swing.JMenuBar();
      mnpSistema = new javax.swing.JMenu();
      mnuSistemaImportarArquivo = new javax.swing.JMenuItem();
      jSeparator6 = new javax.swing.JPopupMenu.Separator();
      mnuSistemaAtualizar = new javax.swing.JMenuItem();
      mnuSistemaConfigurar = new javax.swing.JMenuItem();
      mnuSistemaLimparPainel = new javax.swing.JMenuItem();
      jSeparator5 = new javax.swing.JPopupMenu.Separator();
      mnuSistemaSair = new javax.swing.JMenuItem();
      mnpRepositorio = new javax.swing.JMenu();
      mnuRepositorioReceber = new javax.swing.JMenuItem();
      mnuRepositorioEnviar = new javax.swing.JMenuItem();
      jSeparator1 = new javax.swing.JPopupMenu.Separator();
      mnuRepositorioHistorico = new javax.swing.JMenuItem();
      jSeparator4 = new javax.swing.JPopupMenu.Separator();
      mnuRepositorioMontar = new javax.swing.JMenuItem();
      mnpEditar = new javax.swing.JMenu();
      mnuEditarMonstros = new javax.swing.JMenuItem();
      mnuEditarSequencia = new javax.swing.JMenuItem();
      mnpLocalhost = new javax.swing.JMenu();
      mnuLocalhostAtivar = new javax.swing.JMenuItem();
      mnuLocalhostDesativar = new javax.swing.JMenuItem();
      jSeparator11 = new javax.swing.JPopupMenu.Separator();
      mnuLocalhostExecutar = new javax.swing.JMenuItem();
      jSeparator2 = new javax.swing.JPopupMenu.Separator();
      mncExecutarAposAtivacao = new javax.swing.JCheckBoxMenuItem();
      mncDesativarAposExecucao = new javax.swing.JCheckBoxMenuItem();
      mncFechaClienteAposDesativar = new javax.swing.JCheckBoxMenuItem();
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

      txtPainel.setBackground(new java.awt.Color(0, 92, 0));
      txtPainel.setColumns(20);
      txtPainel.setEditable(false);
      txtPainel.setFont(new java.awt.Font("Courier New", 0, 15));
      txtPainel.setForeground(java.awt.Color.white);
      txtPainel.setRows(5);
      txtPainel.setText("\n     → Bem Vindos ao TMW-Maker Java versão II...\n");
      txtPainel.setWrapStyleWord(true);
      txtPainel.setAutoscrolls(true);
      txtPainel.setMargin(new java.awt.Insets(5, 5, 5, 5));
      scpPainel.setViewportView(txtPainel);

      jToolBar1.setFloatable(false);
      jToolBar1.setRollover(true);

      btnSistemaImportarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_pasta.gif"))); // NOI18N
      btnSistemaImportarArquivo.setToolTipText("Importar Arquivo (Ctrl+I)");
      btnSistemaImportarArquivo.setFocusable(false);
      btnSistemaImportarArquivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnSistemaImportarArquivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnSistemaImportarArquivo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSistemaImportarArquivoActionPerformed(evt);
         }
      });
      jToolBar1.add(btnSistemaImportarArquivo);

      btnSistemaLimparPainel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_borracha.png"))); // NOI18N
      btnSistemaLimparPainel.setToolTipText("Limpar Painel (F8)");
      btnSistemaLimparPainel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSistemaLimparPainelActionPerformed(evt);
         }
      });
      jToolBar1.add(btnSistemaLimparPainel);

      btnSistemaConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_chaveinglesa.png"))); // NOI18N
      btnSistemaConfigurar.setToolTipText("Configurar... (Ctrl+G)");
      btnSistemaConfigurar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSistemaConfigurarActionPerformed(evt);
         }
      });
      jToolBar1.add(btnSistemaConfigurar);
      jToolBar1.add(jSeparator8);

      btnRepositorioReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_download.gif"))); // NOI18N
      btnRepositorioReceber.setToolTipText("Receber Repositório (Shift+PgDown)");
      btnRepositorioReceber.setFocusable(false);
      btnRepositorioReceber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnRepositorioReceber.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnRepositorioReceber.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRepositorioReceberActionPerformed(evt);
         }
      });
      jToolBar1.add(btnRepositorioReceber);

      btnRepositorioEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_upload.gif"))); // NOI18N
      btnRepositorioEnviar.setToolTipText("Enviar Repositório (Shift+PgUp)");
      btnRepositorioEnviar.setEnabled(false);
      btnRepositorioEnviar.setFocusable(false);
      btnRepositorioEnviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnRepositorioEnviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnRepositorioEnviar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRepositorioEnviarActionPerformed(evt);
         }
      });
      jToolBar1.add(btnRepositorioEnviar);

      btnRepositorioHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_file_rss.gif"))); // NOI18N
      btnRepositorioHistorico.setToolTipText("Exibir Histórico (F9)");
      btnRepositorioHistorico.setFocusable(false);
      btnRepositorioHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnRepositorioHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnRepositorioHistorico.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRepositorioHistoricoActionPerformed(evt);
         }
      });
      jToolBar1.add(btnRepositorioHistorico);

      btnRepositorioMontar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_puzzle.png"))); // NOI18N
      btnRepositorioMontar.setToolTipText("Montar Repositório");
      btnRepositorioMontar.setFocusable(false);
      btnRepositorioMontar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnRepositorioMontar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnRepositorioMontar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRepositorioMontarActionPerformed(evt);
         }
      });
      jToolBar1.add(btnRepositorioMontar);
      jToolBar1.add(jSeparator9);

      btnEditarMonstros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_halloween.png"))); // NOI18N
      btnEditarMonstros.setToolTipText("Editar Monstros (Ctrl+M)");
      btnEditarMonstros.setFocusable(false);
      btnEditarMonstros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnEditarMonstros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnEditarMonstros.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditarMonstrosActionPerformed(evt);
         }
      });
      jToolBar1.add(btnEditarMonstros);

      btnEditarSequencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_good.gif"))); // NOI18N
      btnEditarSequencia.setToolTipText("Editar Sequência de Animação de Sprite (Ctrl+Q)");
      btnEditarSequencia.setFocusable(false);
      btnEditarSequencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnEditarSequencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnEditarSequencia.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditarSequenciaActionPerformed(evt);
         }
      });
      jToolBar1.add(btnEditarSequencia);
      jToolBar1.add(jSeparator10);

      btnLocalhostAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_play.png"))); // NOI18N
      btnLocalhostAtivar.setToolTipText("Ativar Localhost (F5)");
      btnLocalhostAtivar.setFocusable(false);
      btnLocalhostAtivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnLocalhostAtivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnLocalhostAtivar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLocalhostAtivarActionPerformed(evt);
         }
      });
      jToolBar1.add(btnLocalhostAtivar);

      btnLocalhostDesativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_parar.png"))); // NOI18N
      btnLocalhostDesativar.setToolTipText("Desativar Localhost (F6)");
      btnLocalhostDesativar.setFocusable(false);
      btnLocalhostDesativar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnLocalhostDesativar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnLocalhostDesativar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLocalhostDesativarActionPerformed(evt);
         }
      });
      jToolBar1.add(btnLocalhostDesativar);

      btnLocalhostExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      btnLocalhostExecutar.setToolTipText("Executar Softcliente(F7)");
      btnLocalhostExecutar.setFocusable(false);
      btnLocalhostExecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnLocalhostExecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnLocalhostExecutar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLocalhostExecutarActionPerformed(evt);
         }
      });
      jToolBar1.add(btnLocalhostExecutar);
      jToolBar1.add(jSeparator12);

      btnAjudaInformarDefeito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_broken.png"))); // NOI18N
      btnAjudaInformarDefeito.setToolTipText("Informar Defeito (F3)");
      btnAjudaInformarDefeito.setFocusable(false);
      btnAjudaInformarDefeito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnAjudaInformarDefeito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnAjudaInformarDefeito.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAjudaInformarDefeitoActionPerformed(evt);
         }
      });
      jToolBar1.add(btnAjudaInformarDefeito);

      btnAjudaForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_forum.png"))); // NOI18N
      btnAjudaForum.setToolTipText("Exibir Fórum TMW-BR");
      btnAjudaForum.setFocusable(false);
      btnAjudaForum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnAjudaForum.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnAjudaForum.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAjudaForumActionPerformed(evt);
         }
      });
      jToolBar1.add(btnAjudaForum);

      btnAjudaSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_informacao.png"))); // NOI18N
      btnAjudaSobre.setToolTipText("Sobre esta Engine (F1)");
      btnAjudaSobre.setFocusable(false);
      btnAjudaSobre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnAjudaSobre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAjudaSobreActionPerformed(evt);
         }
      });
      jToolBar1.add(btnAjudaSobre);

      jToolBar2.setFloatable(false);

      pgbStatusProgresso.setBackground(new java.awt.Color(0, 64, 0));
      pgbStatusProgresso.setForeground(new java.awt.Color(0, 128, 0));
      pgbStatusProgresso.setValue(100);
      pgbStatusProgresso.setFocusable(false);
      pgbStatusProgresso.setMaximumSize(new java.awt.Dimension(130, 23));
      pgbStatusProgresso.setMinimumSize(new java.awt.Dimension(130, 23));
      pgbStatusProgresso.setPreferredSize(new java.awt.Dimension(130, 23));
      pgbStatusProgresso.setString("");
      pgbStatusProgresso.setStringPainted(true);
      jToolBar2.add(pgbStatusProgresso);
      jToolBar2.add(jSeparator3);

      lblStatusTexto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
      lblStatusTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      lblStatusTexto.setText("Bem Vindo!");
      lblStatusTexto.setAutoscrolls(true);
      lblStatusTexto.setFocusable(false);
      lblStatusTexto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
      lblStatusTexto.setPreferredSize(new java.awt.Dimension(700, 18));
      jToolBar2.add(lblStatusTexto);

      mnpSistema.setMnemonic('S');
      mnpSistema.setText("Sistema");

      mnuSistemaImportarArquivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
      mnuSistemaImportarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_pasta.gif"))); // NOI18N
      mnuSistemaImportarArquivo.setText("Importar...");
      mnuSistemaImportarArquivo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSistemaImportarArquivoActionPerformed(evt);
         }
      });
      mnpSistema.add(mnuSistemaImportarArquivo);
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

      mnuSistemaLimparPainel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
      mnuSistemaLimparPainel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_borracha.png"))); // NOI18N
      mnuSistemaLimparPainel.setText("Limpar Painel");
      mnuSistemaLimparPainel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSistemaLimparPainelActionPerformed(evt);
         }
      });
      mnpSistema.add(mnuSistemaLimparPainel);
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

      mnpRepositorio.setMnemonic('R');
      mnpRepositorio.setText("Repositório");

      mnuRepositorioReceber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_DOWN, java.awt.event.InputEvent.SHIFT_MASK));
      mnuRepositorioReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_download.gif"))); // NOI18N
      mnuRepositorioReceber.setMnemonic('R');
      mnuRepositorioReceber.setText("Receber");
      mnuRepositorioReceber.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuRepositorioReceberActionPerformed(evt);
         }
      });
      mnpRepositorio.add(mnuRepositorioReceber);

      mnuRepositorioEnviar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_UP, java.awt.event.InputEvent.SHIFT_MASK));
      mnuRepositorioEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_upload.gif"))); // NOI18N
      mnuRepositorioEnviar.setText("Enviar");
      mnuRepositorioEnviar.setEnabled(false);
      mnpRepositorio.add(mnuRepositorioEnviar);
      mnpRepositorio.add(jSeparator1);

      mnuRepositorioHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
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

      mnpEditar.setMnemonic('E');
      mnpEditar.setText("Editar");

      mnuEditarMonstros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
      mnuEditarMonstros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_halloween.png"))); // NOI18N
      mnuEditarMonstros.setText("Monstros");
      mnuEditarMonstros.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuEditarMonstrosActionPerformed(evt);
         }
      });
      mnpEditar.add(mnuEditarMonstros);

      mnuEditarSequencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
      mnuEditarSequencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_good.gif"))); // NOI18N
      mnuEditarSequencia.setText("Sequências");
      mnuEditarSequencia.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuEditarSequenciaActionPerformed(evt);
         }
      });
      mnpEditar.add(mnuEditarSequencia);

      mbrBarraDeMenu.add(mnpEditar);

      mnpLocalhost.setMnemonic('L');
      mnpLocalhost.setText("Localhost");

      mnuLocalhostAtivar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
      mnuLocalhostAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_play.png"))); // NOI18N
      mnuLocalhostAtivar.setText("Ativar");
      mnuLocalhostAtivar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostAtivarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostAtivar);

      mnuLocalhostDesativar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
      mnuLocalhostDesativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_parar.png"))); // NOI18N
      mnuLocalhostDesativar.setText("Desativar");
      mnuLocalhostDesativar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostDesativarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostDesativar);
      mnpLocalhost.add(jSeparator11);

      mnuLocalhostExecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
      mnuLocalhostExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      mnuLocalhostExecutar.setText("Executar Softcliente...");
      mnuLocalhostExecutar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuLocalhostExecutarActionPerformed(evt);
         }
      });
      mnpLocalhost.add(mnuLocalhostExecutar);
      mnpLocalhost.add(jSeparator2);

      mncExecutarAposAtivacao.setSelected(true);
      mncExecutarAposAtivacao.setText("Executar após ativação");
      mncExecutarAposAtivacao.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            mncExecutarAposAtivacaoStateChanged(evt);
         }
      });
      mnpLocalhost.add(mncExecutarAposAtivacao);

      mncDesativarAposExecucao.setSelected(true);
      mncDesativarAposExecucao.setText("Desativar após Execução");
      mncDesativarAposExecucao.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            mncDesativarAposExecucaoStateChanged(evt);
         }
      });
      mnpLocalhost.add(mncDesativarAposExecucao);

      mncFechaClienteAposDesativar.setText("Fechar Cliente ao desativar");
      mncFechaClienteAposDesativar.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            mncFechaClienteAposDesativarStateChanged(evt);
         }
      });
      mnpLocalhost.add(mncFechaClienteAposDesativar);

      mbrBarraDeMenu.add(mnpLocalhost);

      mnpAjuda.setMnemonic('A');
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
      mnuAjudaForum.setText("Fórum TMW-BR");
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
         .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
         .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
         .addComponent(scpPainel, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(scpPainel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addGap(0, 0, 0)
            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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

		mncExecutarAposAtivacao.setSelected(conf.getSeExecutarAposAtivacao());
		mncDesativarAposExecucao.setSelected(conf.getSeDesativarAposExecucao());
		mncFechaClienteAposDesativar.setSelected(conf.getSeFecharClienteAposDesativacao());

		if(conf.getAtualizacaoLocalhostIntervalo() >= 0 && FileClass.getAgora() >= conf.getAtualizacaoLocalhostFutura()) {
			int resp = DialogClass.showOpcoes(
				"<html>O TMW-Maker é uma ferramenta de desenvolvimento colaborativa.<br>"+ 
				"Por esta razão, seu Localhost pode estar desatualizado.<br>"+ 
				"Deseja procurar atualização criada por outros DEVs via internet?",
				"ATUALIZAÇÃO DO LOCALHOST",
				new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png")), //"/imagens/simbolos/icon-tmw-maker-fenix-96x119.png",
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
					new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png")),
					new Object[] {"Limpar", "Cancelar"},
					0
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
	private void mnuEditarMonstrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditarMonstrosActionPerformed
		// TODO add your handling code here:
		FrmSpawnEditor.main(new String[]{"--localhost",conf.getConexaoLocalhost()});
	}//GEN-LAST:event_mnuEditarMonstrosActionPerformed
	private void mnuSistemaImportarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSistemaImportarArquivoActionPerformed
		// TODO add your handling code here:
		javax.swing.JDialog frmImportador = new FrmImportador(this, rootPaneCheckingEnabled,conf.getConexaoLocalhost());
		frmImportador.pack();
		frmImportador.setModal(true);
		frmImportador.setLocation(
			((this.getWidth() - frmImportador.getWidth()) / 2) + this.getX(),
			((this.getHeight() - frmImportador.getHeight()) / 2) + this.getY()
		);
		frmImportador.setVisible(true);/**/
	}//GEN-LAST:event_mnuSistemaImportarArquivoActionPerformed
	private void mncExecutarAposAtivacaoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mncExecutarAposAtivacaoStateChanged
		conf.setSeExecutarAposAtivacao(mncExecutarAposAtivacao.isSelected());
		conf.doSalvar();
	}//GEN-LAST:event_mncExecutarAposAtivacaoStateChanged
	private void mncDesativarAposExecucaoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mncDesativarAposExecucaoStateChanged
		conf.setSeDesativarAposExecucao(mncDesativarAposExecucao.isSelected());
		conf.doSalvar();
	}//GEN-LAST:event_mncDesativarAposExecucaoStateChanged
	private void mncFechaClienteAposDesativarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mncFechaClienteAposDesativarStateChanged
		conf.setSeFecharClienteAposDesativacao(mncFechaClienteAposDesativar.isSelected());
		conf.doSalvar();
	}//GEN-LAST:event_mncFechaClienteAposDesativarStateChanged
	private void btnSistemaLimparPainelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaLimparPainelActionPerformed
		if(mnpSistema.isEnabled() && mnuSistemaLimparPainel.isEnabled()){mnuSistemaLimparPainelActionPerformed(evt);}
	}//GEN-LAST:event_btnSistemaLimparPainelActionPerformed
	private void btnSistemaConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaConfigurarActionPerformed
		if(mnpSistema.isEnabled() && mnuSistemaConfigurar.isEnabled()){mnuSistemaConfigurarActionPerformed(evt);}
	}//GEN-LAST:event_btnSistemaConfigurarActionPerformed
	private void btnRepositorioReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepositorioReceberActionPerformed
		if(mnpRepositorio.isEnabled() && mnuRepositorioReceber.isEnabled()){mnuRepositorioReceberActionPerformed(evt);}
	}//GEN-LAST:event_btnRepositorioReceberActionPerformed
	private void btnSistemaImportarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaImportarArquivoActionPerformed
		if(mnpSistema.isEnabled() && mnuSistemaImportarArquivo.isEnabled()){mnuSistemaImportarArquivoActionPerformed(evt);}
	}//GEN-LAST:event_btnSistemaImportarArquivoActionPerformed
	private void btnRepositorioEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepositorioEnviarActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_btnRepositorioEnviarActionPerformed
	private void btnRepositorioHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepositorioHistoricoActionPerformed
		if(mnpRepositorio.isEnabled() && mnuRepositorioHistorico.isEnabled()){mnuRepositorioHistoricoActionPerformed(evt);}
	}//GEN-LAST:event_btnRepositorioHistoricoActionPerformed
	private void btnRepositorioMontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepositorioMontarActionPerformed
		// TODO add your handling code here:
		if(mnpRepositorio.isEnabled() && mnuRepositorioMontar.isEnabled()){mnuRepositorioMontarActionPerformed(evt);}
	}//GEN-LAST:event_btnRepositorioMontarActionPerformed
	private void btnEditarMonstrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMonstrosActionPerformed
		if(mnpEditar.isEnabled() && mnuEditarMonstros.isEnabled()){mnuEditarMonstrosActionPerformed(evt);}
	}//GEN-LAST:event_btnEditarMonstrosActionPerformed
	private void btnLocalhostAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalhostAtivarActionPerformed
		if(mnpLocalhost.isEnabled() && mnuLocalhostAtivar.isEnabled()){mnuLocalhostAtivarActionPerformed(evt);}
	}//GEN-LAST:event_btnLocalhostAtivarActionPerformed
	private void btnLocalhostDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalhostDesativarActionPerformed
		if(mnpLocalhost.isEnabled() && mnuLocalhostDesativar.isEnabled()){mnuLocalhostDesativarActionPerformed(evt);}
	}//GEN-LAST:event_btnLocalhostDesativarActionPerformed
	private void btnLocalhostExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalhostExecutarActionPerformed
		if(mnpLocalhost.isEnabled() && mnuLocalhostExecutar.isEnabled()){mnuLocalhostExecutarActionPerformed(evt);}
	}//GEN-LAST:event_btnLocalhostExecutarActionPerformed
	private void btnAjudaInformarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaInformarDefeitoActionPerformed
		if(mnpAjuda.isEnabled() && mnuAjudaInformarDefeito.isEnabled()){mnuAjudaInformarDefeitoActionPerformed(evt);}
	}//GEN-LAST:event_btnAjudaInformarDefeitoActionPerformed
	private void btnAjudaForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaForumActionPerformed
		if(mnpAjuda.isEnabled() && mnuAjudaForum.isEnabled()){mnuAjudaForumActionPerformed(evt);}
	}//GEN-LAST:event_btnAjudaForumActionPerformed
	private void btnAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaSobreActionPerformed
		if(mnpAjuda.isEnabled() && mnuAjudaSobre.isEnabled()){mnuAjudaSobreActionPerformed(evt);}
	}//GEN-LAST:event_btnAjudaSobreActionPerformed
	private void btnEditarSequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSequenciaActionPerformed
		if(mnpEditar.isEnabled() && mnuEditarSequencia.isEnabled()){mnuEditarSequenciaActionPerformed(evt);}
	}//GEN-LAST:event_btnEditarSequenciaActionPerformed
	private void mnuEditarSequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditarSequenciaActionPerformed
		FrmAnimationEditor.main(new String[]{"--localhost",conf.getConexaoLocalhost()});
	}//GEN-LAST:event_mnuEditarSequenciaActionPerformed

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrmTMWMaker2().setVisible(true);
			}
		});
	}
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAjudaForum;
   private javax.swing.JButton btnAjudaInformarDefeito;
   private javax.swing.JButton btnAjudaSobre;
   private javax.swing.JButton btnEditarMonstros;
   private javax.swing.JButton btnEditarSequencia;
   private javax.swing.JButton btnLocalhostAtivar;
   private javax.swing.JButton btnLocalhostDesativar;
   private javax.swing.JButton btnLocalhostExecutar;
   private javax.swing.JButton btnRepositorioEnviar;
   private javax.swing.JButton btnRepositorioHistorico;
   private javax.swing.JButton btnRepositorioMontar;
   private javax.swing.JButton btnRepositorioReceber;
   private javax.swing.JButton btnSistemaConfigurar;
   private javax.swing.JButton btnSistemaImportarArquivo;
   private javax.swing.JButton btnSistemaLimparPainel;
   private javax.swing.JPopupMenu.Separator jSeparator1;
   private javax.swing.JToolBar.Separator jSeparator10;
   private javax.swing.JPopupMenu.Separator jSeparator11;
   private javax.swing.JToolBar.Separator jSeparator12;
   private javax.swing.JPopupMenu.Separator jSeparator2;
   private javax.swing.JToolBar.Separator jSeparator3;
   private javax.swing.JPopupMenu.Separator jSeparator4;
   private javax.swing.JPopupMenu.Separator jSeparator5;
   private javax.swing.JPopupMenu.Separator jSeparator6;
   private javax.swing.JPopupMenu.Separator jSeparator7;
   private javax.swing.JToolBar.Separator jSeparator8;
   private javax.swing.JToolBar.Separator jSeparator9;
   private javax.swing.JToolBar jToolBar1;
   private javax.swing.JToolBar jToolBar2;
   public static javax.swing.JLabel lblStatusTexto;
   private javax.swing.JMenuBar mbrBarraDeMenu;
   private javax.swing.JCheckBoxMenuItem mncDesativarAposExecucao;
   private javax.swing.JCheckBoxMenuItem mncExecutarAposAtivacao;
   private javax.swing.JCheckBoxMenuItem mncFechaClienteAposDesativar;
   private javax.swing.JMenu mnpAjuda;
   private javax.swing.JMenu mnpEditar;
   private javax.swing.JMenu mnpLocalhost;
   private javax.swing.JMenu mnpRepositorio;
   private javax.swing.JMenu mnpSistema;
   private javax.swing.JMenuItem mnuAjudaForum;
   private javax.swing.JMenuItem mnuAjudaInformarDefeito;
   private javax.swing.JMenuItem mnuAjudaSobre;
   private javax.swing.JMenuItem mnuEditarMonstros;
   private javax.swing.JMenuItem mnuEditarSequencia;
   private javax.swing.JMenuItem mnuLocalhostAtivar;
   private javax.swing.JMenuItem mnuLocalhostDesativar;
   private javax.swing.JMenuItem mnuLocalhostExecutar;
   private javax.swing.JMenuItem mnuRepositorioEnviar;
   private javax.swing.JMenuItem mnuRepositorioHistorico;
   private javax.swing.JMenuItem mnuRepositorioMontar;
   private javax.swing.JMenuItem mnuRepositorioReceber;
   private javax.swing.JMenuItem mnuSistemaAtualizar;
   private javax.swing.JMenuItem mnuSistemaConfigurar;
   private javax.swing.JMenuItem mnuSistemaImportarArquivo;
   private javax.swing.JMenuItem mnuSistemaLimparPainel;
   private javax.swing.JMenuItem mnuSistemaSair;
   private javax.swing.JProgressBar pgbStatusProgresso;
   private javax.swing.JScrollPane scpPainel;
   public static javax.swing.JTextArea txtPainel;
   // End of variables declaration//GEN-END:variables
}
