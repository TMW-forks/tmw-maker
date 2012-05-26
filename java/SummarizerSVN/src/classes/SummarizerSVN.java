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
 * @adaptation: Lunovox <rui.gravata@gmail.com>
 * @version → 2012.0526
 * @description → Biblioteca simplificadora de administração de repositório Subversion
 * @libraries → svnkit.jar
 * @licence → GNU GPL v3: http://www.gnu.org/licenses/gpl.html
 * @skype → lunovox
 * @msn → rui.gravata@hotmail.com
 * @gTalk → rui.gravata@gmail.com
 * @source: http://code.google.com/p/svntask/source/browse/trunk/src/com/googlecode/svntask/command/
 */

package classes;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNErrorMessage;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNCommitClient;
import org.tmatesoft.svn.core.wc.SVNWCClient;

public final class SummarizerSVN {
	public SummarizerSVN(){
		// Vai especificae os parâmetros depois!
	}
	public SummarizerSVN(String url, String pasta){
		setURL(url);
		setEndereco(pasta);
	}
	public SummarizerSVN(String url, String pasta, String Revisao){
		setURL(url);
		setEndereco(pasta);
		setRevisao(Revisao);
	}
	public SummarizerSVN(String $URL, String $Pasta, String $Usuário, String $Senha){
		setURL($URL);
		setEndereco($Pasta);
		setUsuario($Usuário);
		setSenha($Senha);
	}
	public SummarizerSVN(String url, String pasta, String Revisao, Boolean Sobrescrever){
		setURL(url);
		setEndereco(pasta);
		setRevisao(Revisao);
		setSobrescrever(Sobrescrever);
	}
	public SummarizerSVN(String $URL, String $Pasta, String $Revisao, String $Usuário, String $Senha){
		setURL($URL);
		setEndereco($Pasta);
		setRevisao($Revisao);
		setUsuario($Usuário);
		setSenha($Senha);
	}
	public SummarizerSVN(String $URL, String $Pasta, String $Revisao, Boolean $Sobrescrever, String $Usuário, String $Senha){
		setURL($URL);
		setEndereco($Pasta);
		setRevisao($Revisao);
		setSobrescrever($Sobrescrever);
		setUsuario($Usuário);
		setSenha($Senha);
	}
	private String url;
	private String endereco = System.getProperty("user.home") + System.getProperty("file.separator") + "SummarizerSVN"; //path
	private boolean bloqueado = false; //keepLocks
	private String mensagem = "Submetido por "+this.getClass().getName(); //Mensagem de Submissão
	//private SVNDepth intensidade = SVNDepth.INFINITY; //depth
	private SVNDepth intensidade = SVNDepth.INFINITY; //depth
	private boolean inclusaoIgnorada = false; //includeIgnored
   private boolean criarPaternidade = false; //makeParents
	private boolean recursivo = true; //recursive
	private boolean sobrescrever = true; //force
	private boolean criarPasta = false; //mkdir
	private boolean apagarArquivos = true; //deleteFiles
	private boolean execucaoSeca = false; //dryRun
	private boolean submeterPaternidadeDesversionada = false; //climbUnversionedParents
	private String usuario; //user
	private String senha; //password
	private SVNRevision pagRevisao = SVNRevision.HEAD; //pegRevision
	private SVNRevision revisao = SVNRevision.HEAD; //revision
	private SVNClientManager cm = SVNClientManager.newInstance();

	/*private boolean force = true;
	private boolean mkdir = false;
	private boolean climbUnversionedParents = true;
	private SVNDepth depth = SVNDepth.INFINITY;
	private boolean includeIgnored = true;
	private boolean makeParents = true;/**/

	public void setURL(String $URL) {
		this.url = $URL;
	}
	public void setEndereco(String $Endereco) {
		this.endereco = $Endereco;
	}
	public void setUsuario(String $Usuario) {
		this.usuario = $Usuario;
	}
	public void setSenha(String $Senha) {
		this.senha = $Senha;
	}
	public void setMensagem(String $Mensagem) {
		this.mensagem = $Mensagem;
	}
	public void setBloqueado(boolean $Bloqueado) {
		this.bloqueado = $Bloqueado;
	}
	public void setIntensidade(String $Intensidade) {
		this.intensidade = SVNDepth.fromString($Intensidade);
	}
	public void setInclusaoIgnorada(boolean $InclusaoIgnorada) {
		this.inclusaoIgnorada = $InclusaoIgnorada;
	}
	public void setCriarPaternidade(boolean $CriarPaternidade) {
		this.criarPaternidade = $CriarPaternidade;
	}
	public void setRecursivo(boolean $Recursivo) {
		this.recursivo = $Recursivo;
	}
	public void setSobrescrever(boolean $Sobrescrever) {
		this.sobrescrever = $Sobrescrever;
	}
	public void setCriarPasta(boolean $CriarPasta) {
		this.criarPasta = $CriarPasta;
	}
	public void setApagarArquivos(boolean $ApagarArquivos) {
		this.apagarArquivos = $ApagarArquivos;
	}
	public void setExecucaoSeca(boolean $ExecucaoSeca) {
		this.execucaoSeca = $ExecucaoSeca;
	}
	public void setSubmeterPaternidadeDesversionada(boolean $SubmeterPaternidadeDesversionada) {
		this.submeterPaternidadeDesversionada = $SubmeterPaternidadeDesversionada;
	}
	public void setPagRevisao(long $PagRevisao) {
		this.pagRevisao = SVNRevision.create($PagRevisao);
	}
	public void setPagRevisao(String $PagRevisao) {
		this.pagRevisao = SVNRevision.parse($PagRevisao);
	}
	public void setRevisao(long $Revisao) {
		this.revisao = SVNRevision.create($Revisao);
	}
	public void setRevisao(String $Revisao) {
		this.revisao = SVNRevision.parse($Revisao);
	}

	public String getURL(){return this.url;}
	public String getEndereco(){return this.endereco;}
	public String getUsuario(){return this.usuario;}
	public String getSenha(){return this.senha;}
	public SVNRevision getRevisao(){return this.revisao;}
	
	public SVNRevision doCheckout(){
		try {
			//Diz que ira usar um repositório com http:// ou https://
          DAVRepositoryFactory.setup();

			SVNURL $url = SVNURL.parseURIDecoded(url);
			//cm = SVNClientManager.newInstance();
			if (this.usuario != null && !this.usuario.equals("") && this.senha != null && this.senha.equals("")) {
				ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(this.usuario, this.senha);
				cm.setAuthenticationManager(authManager);
			}
			// Get the Update Client
			File $destino = new File(endereco);
			SVNUpdateClient updateClient = cm.getUpdateClient();
			//long r = updateClient.doCheckout($SVN_URL, $destino, pagRevisao, revisao, intensidade, sobrescrever);
			revisao=SVNRevision.create(updateClient.doCheckout($url, $destino, pagRevisao, revisao, intensidade, sobrescrever));
			
			//this.getProject().setProperty(this.revisionProperty, new Long(r).toString());
			return revisao;
		} catch (Exception ex) {
			Logger.getLogger(SummarizerSVN.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
	public SVNCommitInfo doCommit(){
		SVNCommitInfo $Info = null;
		try {
			DAVRepositoryFactory.setup();

			File[] filePaths = new File[1];
			filePaths[0] = new File(this.endereco);

			//this.getTask().log("commit " + filePaths[0].getCanonicalPath());

			//SVNClientManager cm = this.getTask().getSvnClient();
			//cm = SVNClientManager.newInstance();


			if (this.usuario != null && this.senha != null) {
				ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(this.usuario, this.senha);
				cm.setAuthenticationManager(authManager);
			}

			// Get the commit client
			SVNCommitClient commitClient = cm.getCommitClient();
			// Execute SVN commit
			//SVNCommitInfo info = commitClient.doCommit(filePaths, this.bloqueado, this.mensagem, null, null, true, this.sobrescrever, this.intensidade);
			/*long $NovaRevisao = info.getNewRevision();
			if ($NovaRevisao >= 0) {
				revisao=SVNRevision.create($NovaRevisao);
				System.out.println("Sucesso de submissão: Nova revisão=" + revisao.getNumber());
			} else {
				System.out.println("Submissão não realizada (operação de submissão retornou nova revisão <0)");
			}/**/
			$Info = commitClient.doCommit(filePaths, this.bloqueado, this.mensagem, null, null, true, this.sobrescrever, this.intensidade);
			//$Info = commitClient.doCommit(filePaths, this.keepLocks, this.commitMessage, null, null, true, this.force, this.depth);

			revisao = SVNRevision.create($Info.getNewRevision());
		} catch (Exception ex) {
			Logger.getLogger(SummarizerSVN.class.getName()).log(Level.SEVERE, null, ex);
		}
		return $Info;
	}
	public boolean doUpdate() {
		try {
			DAVRepositoryFactory.setup();

			File filePath = new File(this.endereco);

			//this.getTask().log("update " + filePath.getCanonicalPath());

			// Get the Update Client
			SVNUpdateClient client = cm.getUpdateClient();

			// Execute svn info
			revisao = SVNRevision.create(client.doUpdate(filePath, this.revisao, this.intensidade, this.recursivo, this.sobrescrever));

			// Set the computed properties in ant
			//this.getProject().setProperty(this.revisionProperty, new Long(revision).toString());
			return true;
		} catch (Exception ex) {
			Logger.getLogger(SummarizerSVN.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	public boolean doAdd(String $Endereço){
		try {
			File filePath = new File($Endereço);
			SVNWCClient wcClient = cm.getWCClient();
			wcClient.doAdd(
				filePath,
				this.sobrescrever,
				this.criarPasta,
				this.submeterPaternidadeDesversionada,
				this.intensidade,
				this.inclusaoIgnorada,
				this.criarPaternidade
			);
			return true;
		} catch (Exception ex) {
			Logger.getLogger(SummarizerSVN.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	public boolean doDelete(String $Endereço){
		try {
			File filePath = new File($Endereço);
			SVNWCClient wcClient = cm.getWCClient();
			wcClient.doDelete(filePath, sobrescrever, apagarArquivos, execucaoSeca);
			return true;
		} catch (Exception ex) {
			Logger.getLogger(SummarizerSVN.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public static void showHelp() {
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
		System.out.println("");
		System.out.println("#### CRÉDITOS #####################################################################");
		System.out.println(" @description → Biblioteca simplificadora de administração de repositório Subversion");
		System.out.println(" @adaptation: Lunovox <rui.gravata@gmail.com>");
		System.out.println(" @version → 2012.0526.1)");
		System.out.println(" @libraries → svnkit.jar");
		System.out.println(" @licence → GNU GPL v3: http://www.gnu.org/licenses/gpl.html");
		System.out.println(" @skype → lunovox");
		System.out.println(" @msn → rui.gravata@hotmail.com");
		System.out.println(" @gTalk → rui.gravata@gmail.com");
		System.out.println("###################################################################################");
		System.out.println("");
		System.out.println("#### CONFIGURAÇÃO #################################################################");
		System.out.println(" --url <repositório> → Especifica o endereço do repositório na internet.");
		System.out.println(" --endereco <pasta>  → Especifica a pasta local que será correspondida.");
		System.out.println(" --login <usuario>   → Especifica o login do usuário.");
		System.out.println(" --senha <password>  → Especifica a senha do usuário.");
		System.out.println(" --mensagem <testo>  → Especifica uma mensagem ao alterar o repoistório.");
		System.out.println(" --revisao <numero> → Prepara correspondencia com uma determianada revisão.");
		System.out.println("###################################################################################");
		System.out.println("");
		System.out.println("#### ALTERAÇÕES ###################################################################");
		System.out.println(" --add <arquivo>    → Prepara arquivo para ser adicionado.");
		System.out.println(" --delete <arquivo> → Prepara arquivo para ser excluido.");
		System.out.println("###################################################################################");
		System.out.println("");
		System.out.println("#### AÇÕES ########################################################################");
		System.out.println(" --sobrescrever → Prepara par sobrescrever arquivos submetidos.");
		System.out.println(" --checkout     → Baixa o repositório especificado.");
		System.out.println(" --commit       → Submete as alterações ao repositório especificado.");
		System.out.println("###################################################################################");
	}
	public static void main(String[] args) {
		//--url "http://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Testos" --endereco "/home/lunovox/Área de Trabalho/delete-me" --checkout
		//--url "https://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Testos" --endereco "/home/lunovox/Área de Trabalho/delete-me" --login "rui.gravata@gmail.com" --senha "" --checkout
		//--url "https://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Testos" --endereco "/home/lunovox/Área de Trabalho/delete-me" --login "rui.gravata@gmail.com" --senha "" --commit
		//--url "https://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Testos" --endereco "/home/lunovox/Área de Trabalho/delete-me" --login "rui.gravata@gmail.com" --senha "" --mensagem "TESTE JAVA: Teste de Adição por uma classe Java!" --add "/home/lunovox/Área de Trabalho/delete-me/delete-me.txt" --commit
		//--url "https://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Testos" --endereco "/home/lunovox/Área de Trabalho/delete-me" --login "rui.gravata@gmail.com" --senha "" --mensagem "TESTE JAVA: Teste de Exclusão por uma classe Java!" --delete "/home/lunovox/Área de Trabalho/delete-me/delete-me.txt" --commit
		if(args.length>=1){
			SummarizerSVN svn = new SummarizerSVN();
			for(int $i=0;$i<args.length;$i++){
				if(args[$i].trim().equals("--help") || args[$i].trim().equals("-h")){
					showHelp();
				}else if(args[$i].trim().equals("--url") && $i+1<args.length && !args[$i+1].equals("")){
					svn.setURL(args[$i+1]);
				}else if(args[$i].trim().equals("--endereco") && $i+1<args.length && !args[$i+1].equals("")){
					svn.setEndereco(args[$i+1]);
				}else if(args[$i].trim().equals("--login") && $i+1<args.length && !args[$i+1].equals("")){
					svn.setUsuario(args[$i+1]);
				}else if(args[$i].trim().equals("--senha") && $i+1<args.length && !args[$i+1].equals("")){
					svn.setSenha(args[$i+1]);
				}else if(args[$i].trim().equals("--mensagem") && $i+1<args.length && !args[$i+1].equals("")){
					svn.setMensagem(args[$i+1]);
				}else if(args[$i].trim().equals("--checkout")){
					if(svn.doCheckout()!=null){System.out.println("Checkout realizado com sucesso: nova revisão=" + svn.getRevisao().getNumber());}
				}else if(args[$i].trim().equals("--commit")){
					SVNCommitInfo $Info = svn.doCommit();
					if ($Info.getNewRevision()>=0) {
						System.out.println("Submissão realizada com sucesso: nova revisão=" + $Info.getNewRevision()+".");
					} else {
						System.out.println("");
						System.out.println("Submissão não realizada!!!");
					}
				}else if(args[$i].trim().equals("--sobrescrever")){
					svn.setSobrescrever(true);
				}else if(args[$i].trim().equals("--revisao") && $i+1<args.length && !args[$i+1].equals("")){
					svn.setRevisao(args[$i+1]);
				}else if(args[$i].trim().equals("--add") && $i+1<args.length && !args[$i+1].equals("")){
					svn.setMensagem(args[$i+1]);
					String $arq = args[$i+1];
					if (svn.doAdd($arq)) {
						System.out.println(" → '"+$arq+"' adicionado com sucesso!");
					} else {
						System.out.println("Adição não realizada!!!");
					}
				}else if(args[$i].trim().equals("--delete") && $i+1<args.length && !args[$i+1].equals("")){
					String $arq = args[$i+1];
					if (svn.doDelete($arq)) {
						System.out.println(" → '"+$arq+"' removido com sucesso!");
					} else {
						System.out.println("Remoção não realizada!!!");
					}
				}
			}
		}else{
			showHelp();
		}
	}

}
