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
 * @version ? TMW-Maker(2012-05-25)
 * @description ? Programa de tratamento de arquivos
 * @licence ? GNU GPL v3: http://www.gnu.org/licenses/gpl.html
 * @skype ? lunovox
 * @msn ? rui.gravata@hotmail.com
 * @gTalk ? rui.gravata@gmail.com
 * @source: http://code.google.com/p/svntask/source/browse/trunk/src/com/googlecode/svntask/command/
 */

package Classes;

//import com.googlecode.svntask.Command;
//import org.apache.tools.ant.BuildException;
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
import org.tmatesoft.svn.core.wc.SVNCommitClient;


public final class Subversion2 {
	public Subversion2(String url, String pasta){
		setURL(url);
		setEndereco(pasta);
	}
	public Subversion2(String url, String pasta, String Revisao){
		setURL(url);
		setEndereco(pasta);
		setRevisao(Revisao);
	}
	public Subversion2(String url, String pasta, String Revisao, boolean Sobrescrever){
		setURL(url);
		setEndereco(pasta);
		setRevisao(Revisao);
		setSobrescrever(Sobrescrever);
	}
	public Subversion2(String $URL, String $Pasta, String $Revisao, boolean $Sobrescrever, String $Usuário, String $Senha){
		setURL($URL);
		setEndereco($Pasta);
		setRevisao($Revisao);
		setSobrescrever($Sobrescrever);
		setUsuario($Usuário);
		setSenha($Senha);
	}
	private String url;
	private String endereco; //path
	private boolean bloqueado = false; //Bloqueio de Submissão
	private String mensagem = "Submetido por "+this.getClass().getName(); //Mensagem de Submissão
	private SVNDepth intensidade = SVNDepth.INFINITY; //depth
	private boolean recursivo = true; //recursive
	private boolean sobrescrever = false; //force
	private String usuario; //user
	private String senha; //password
	private SVNRevision pagRevisao = SVNRevision.HEAD; //pegRevision
	private SVNRevision revisao = SVNRevision.HEAD; //revision
	private SVNClientManager cm = SVNClientManager.newInstance();

	public void setURL(String $URL) {
		this.url = $URL;
	}
	public void setEndereco(String $Endereco) {
		this.endereco = $Endereco;
	}
	public void setBloqueado(boolean $Bloqueado) {
		this.bloqueado = $Bloqueado;
	}
	public void setMensagem(String $Mensagem) {
		this.mensagem = $Mensagem;
	}
	public void setIntensidade(String $Intensidade) {
		this.intensidade = SVNDepth.fromString($Intensidade);
	}
	public void setRecursivo(boolean $Recursivo) {
		this.recursivo = $Recursivo;
	}
	public void setSobrescrever(boolean $Sobrescrever) {
		this.sobrescrever = $Sobrescrever;
	}
	public void setUsuario(String $Usuario) {
		this.usuario = $Usuario;
	}
	public void setSenha(String $Senha) {
		this.senha = $Senha;
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
	public SVNRevision getRevisao() {
		return this.revisao;
	}
	public void doCheckout() throws Exception {
		try {
			SVNURL $SVN_URL = SVNURL.parseURIDecoded(url);
			//cm = SVNClientManager.newInstance();
			if (this.usuario != null && !this.usuario.equals("") && this.senha != null && this.senha.equals("")) {
				ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(this.usuario, this.senha);
				cm.setAuthenticationManager(authManager);
			}
			// Get the Update Client
			File $destino = new File(endereco);
			SVNUpdateClient updateClient = cm.getUpdateClient();
			//long r = updateClient.doCheckout($SVN_URL, $destino, pagRevisao, revisao, intensidade, sobrescrever);
			revisao=SVNRevision.create(updateClient.doCheckout($SVN_URL, $destino, pagRevisao, revisao, intensidade, sobrescrever));
			//this.getProject().setProperty(this.revisionProperty, new Long(r).toString());
		} catch (Exception ex) {
			Logger.getLogger(Subversion2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void doCommit(){
		try {
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
			SVNCommitInfo info = commitClient.doCommit(filePaths, this.bloqueado, this.mensagem, null, null, true, this.sobrescrever, this.intensidade);

			long $NovaRevisao = info.getNewRevision();
			if ($NovaRevisao >= 0) {
				revisao=SVNRevision.create($NovaRevisao);
				System.out.println("Sucesso de submissão : nova revisão = " + revisao.getNumber());
			} else {
				System.out.println("Submissão não realizada (operação de submissão retornou nova revisão <0)");
			}
		} catch (Exception ex) {
			Logger.getLogger(Subversion2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void doUpdate() throws Exception {
		File filePath = new File(this.endereco);

		//this.getTask().log("update " + filePath.getCanonicalPath());

		// Get the Update Client
		//SVNUpdateClient client = this.getTask().getSvnClient().getUpdateClient();
		//SVNUpdateClient client = this.getTask().getSvnClient().getUpdateClient();
		//SVNUpdateClient client = SVNUpdateClient.

		//cm = SVNClientManager.newInstance();
		SVNUpdateClient client = cm.getUpdateClient();


		// Execute svn info
		revisao=SVNRevision.create(client.doUpdate(filePath, this.revisao, this.intensidade, this.recursivo, this.sobrescrever));

		// Set the computed properties in ant
		//this.getProject().setProperty(this.revisionProperty, new Long(revision).toString());
	}

}
