/**
 * @author lunovox
 */
package classes;

import Metodos.Endecrypt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class ClassConfiguracao {

	public ClassConfiguracao() {
		doAbrir();
	}
	private String bar = FileClass.getSeparadorDePastas();

	private String ConexaoRepositorio = "http://themanaworld-br.googlecode.com/svn/trunk";
	private String ConexaoLocalhost = FileClass.getPastaDoUsuario() /*FileClass.getPastaDoSistema()*/+ bar + "localhost"; // ← É melhor deixar q a pasta do localhost seja a HOME, pois o caminho não possui caracter-escpaço.
	private String ConexaoUsuario = "";
	private String ConexaoSenha = "";
	
	private String ExecucaoComando = "manaplus";
	private String ExecucaoParametroTMWData = ConexaoLocalhost + bar + "tmwdata";
	private String ExecucaoParametroServidor = "localhost";
	private String ExecucaoParametroConta = ""; //Inicia sem valor
	private String ExecucaoParametroSenha = ""; //Inicia sem valor
	private String ExecucaoParametroPersonagem = ""; //Inicia sem valor
	private boolean ExecucaoParametroSemopengl = true; //Inicia Sem OpenGL

	private long ComportAtualizacaoEngineUltima = 0;
	private int ComportAtualizacaoEngineIntervalo = 7; // Semanalmente (Cada 7 Dias)
	private long ComportAtualizacaoLocalhostUltima = 0;
	private int ComportAtualizacaoLocalhostIntervalo = 0; // Sempre (Ao abrir)

	private String  ConfiguracaoURL = FileClass.getPastaDoUsuario()+bar+".config-tmwmaker.xml"; // ← É melhor deixar q a pasta do localhost seja a HOME, pois o caminho não possui caracter-escpaço.

	public String  getEathenaData(){return ConexaoLocalhost+bar+"eathena-data";}
	public String  getTMWData(){return ConexaoLocalhost+bar+"tmwdata";}

	public String getConexaoRepositorio() {
		return ConexaoRepositorio;
	}
	public String getConexaoLocalhost() {
		return ConexaoLocalhost;
	}
	public String getConexaoUsuario() {
		return ConexaoUsuario;
	}
	public String getConexaoSenha() {
		return ConexaoSenha;
	}
	public String getExecucaoComando() {
		return ExecucaoComando;
	}
	public String getExecucaoParametroServidor() {
		return ExecucaoParametroServidor;
	}
	public String getExecucaoParametroConta() {
		return ExecucaoParametroConta;
	}
	public String getExecucaoParametroSenha() {
		return ExecucaoParametroSenha;
	}
	public String getExecucaoParametroPersonagem() {
		return ExecucaoParametroPersonagem;
	}
	public boolean getExecucaoParametroSemOpenGL() {
		return ExecucaoParametroSemopengl;
	}

	public long getAtualizacaoEngineUltima() {
		return ComportAtualizacaoEngineUltima;
	}
	public long getAtualizacaoEngineIntervaloReal() {
		/**
		 * 1000 = Milisegundos
		 * 60 = Segundos
		 * 60 = Minutos
		 * 24 = horas
		 **/
		return 1000 * 60 * 60 * 24 * ComportAtualizacaoEngineIntervalo; //Intervalo de 1 dias
	}
	public int getAtualizacaoEngineIntervalo() {
		return ComportAtualizacaoEngineIntervalo; //Intervalo de 1 dias
	}
	public long getAtualizacaoEngineFutura() {
		/**
		 * Se ComportAtualizacaoEngineIntervalo for <= -1 ? Nunca
		 * Se ComportAtualizacaoEngineIntervalo for ==  0 ? Sempre ao Iniciar
		 * Se ComportAtualizacaoEngineIntervalo for >= +1 ? Espera
		 */
		if (ComportAtualizacaoEngineIntervalo >= 0) {
			return ComportAtualizacaoEngineUltima + getAtualizacaoEngineIntervaloReal(); //Intervalo de 1 dias
		} else {
			return -1;
		}
	}
	public long getAtualizacaoLocalhostUltima() {
		return ComportAtualizacaoLocalhostUltima;
	}
	public long getAtualizacaoLocalhostIntervaloReal() {
		/**
		 * 1000 = Milisegundos
		 * 60 = Segundos
		 * 60 = Minutos
		 * 24 = horas
		 **/
		return 1000 * 60 * 60 * 24 * ComportAtualizacaoLocalhostIntervalo; //Intervalo de 1 dias
	}
	public int getAtualizacaoLocalhostIntervalo() {
		return ComportAtualizacaoLocalhostIntervalo; //Intervalo de 1 dias
	}
	public long getAtualizacaoLocalhostFutura() {
		/**
		 * Se ComportAtualizacaoLocalhostIntervalo for <= -1 ? Nunca
		 * Se ComportAtualizacaoLocalhostIntervalo for ==  0 ? Sempre ao Iniciar
		 * Se ComportAtualizacaoLocalhostIntervalo for >= +1 ? Espera
		 */
		if (ComportAtualizacaoLocalhostIntervalo >= 0) {
			return ComportAtualizacaoLocalhostUltima + getAtualizacaoLocalhostIntervaloReal(); //Intervalo de 1 dias
		} else {
			return -1;
		}
	}

	public void setConexaoRepositorio(String URL) {
		ConexaoRepositorio = URL;
	}
	public void setConexaoLocalhost(String EnderecoDaPasta) {
		ConexaoLocalhost = EnderecoDaPasta;
	}
	public void setConexaoUsuario(String Usuario) {
		ConexaoUsuario = Usuario;
	}
	public void setConexaoSenha(String Senha) {
		ConexaoSenha = Senha;
	}
	public void setExecucaoComando(String Comando) {
		ExecucaoComando = Comando;
	}
	public void setExecucaoParametroServidor(String Servidor) {
		ExecucaoParametroServidor = Servidor;
	}
	public void setExecucaoParametroConta(String Conta) {
		ExecucaoParametroConta = Conta;
	}
	public void setExecucaoParametroSenha(String Senha) {
		ExecucaoParametroSenha = Senha;
	}
	public void setExecucaoParametroPersonagem(String Personagem) {
		ExecucaoParametroPersonagem = Personagem;
	}
	public void setExecucaoParametroSemOpenGL(boolean SemOpenGL) {
		ExecucaoParametroSemopengl = SemOpenGL;
	}

	public void setAtualizacaoEngineIntervalo(int Dias) {
		ComportAtualizacaoEngineIntervalo = Dias;
	}
	public void setAtualizacaoEngineUltima(long Quando) {
		ComportAtualizacaoEngineUltima = Quando;
	}
	public void setAtualizacaoEngineUltimaAgora() {
		ComportAtualizacaoEngineUltima = FileClass.getAgora();
	}
	public void setAtualizacaoLocalhostIntervalo(int Dias) {
		ComportAtualizacaoLocalhostIntervalo = Dias;
	}
	public void setAtualizacaoLocalhostUltima(long Quando) {
		ComportAtualizacaoLocalhostUltima = Quando;
	}
	public void setAtualizacaoLocalhostUltimaAgora() {
		ComportAtualizacaoLocalhostUltima = FileClass.getAgora();
	}

	public void doSalvar(){doSalvar(ConfiguracaoURL);}
	public void doSalvar(String Endereco) {
		try {
			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			Factory.setNamespaceAware(true);
			Factory.setIgnoringElementContentWhitespace(false);
			Factory.setValidating(true);
			DocumentBuilder Builder = Factory.newDocumentBuilder();
			Document Doc = Builder.newDocument();
			Comment Comentario = Doc.createComment("\n\tConfigurações do TMW-Maker Hope \n\tConfigurado: "+ FileClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n");
			Doc.appendChild(Comentario);

			Element config = Doc.createElement("config");
			config.setAttribute("version", "hope");
			config.setAttribute("update", String.valueOf(getAtualizacaoEngineUltima()));
			config.setAttribute("upinterval", String.valueOf(getAtualizacaoEngineIntervalo()));

			Element conexao = Doc.createElement("conexao");
			conexao.setAttribute("repository", getConexaoRepositorio());
			conexao.setAttribute("localhost", getConexaoLocalhost());
			conexao.setAttribute("user", getConexaoUsuario());
			conexao.setAttribute("pass", Endecrypt.getEncriptado(getConexaoSenha()));
			conexao.setAttribute("update", String.valueOf(getAtualizacaoLocalhostUltima()));
			conexao.setAttribute("upinterval", String.valueOf(getAtualizacaoLocalhostIntervalo()));
			config.appendChild(conexao);

			Element execucao = Doc.createElement("execucao");
			execucao.setAttribute("softcliente", getExecucaoComando());
			Element parametros = Doc.createElement("parametros");
			parametros.setAttribute("server", getExecucaoParametroServidor());
			parametros.setAttribute("login", getExecucaoParametroConta());
			parametros.setAttribute("pass", Endecrypt.getEncriptado(getExecucaoParametroSenha()));
			parametros.setAttribute("char", getExecucaoParametroPersonagem());
			if (getExecucaoParametroSemOpenGL()) {
				parametros.setAttribute("noOpenGL", "true");
			}
			execucao.appendChild(parametros);
			config.appendChild(execucao);

			Doc.appendChild(config);
			//ConteudoTXT.setTesto(ConteudoTXT.getTesto() + "\n" + "\n");
			//FileClass.arquivoSalvar(mobTXT, ConteudoTXT.getTesto());
			FileClass.arquivoSalvarXML(Endereco, Doc);

		} catch (ParserConfigurationException exc) {
			//DialogClass.showErro("Não foi possível salvar as configurações!", "ERRO");
			Logger.getLogger(ClassConfiguracao.class.getName()).log(Level.SEVERE, null, exc);
		}

	}
	public void doAbrir() {
		if(FileClass.seExiste(ConfiguracaoURL)){doAbrir(ConfiguracaoURL);}
	}
	public void doAbrir(String Endereco) {
		try{
			Element Elementos=FileClass.arquivoAbrirXML(Endereco);
			NodeList nodConfig = Elementos.getElementsByTagName("config");
			Element tagConfig = (Element) nodConfig.item(0);
			setAtualizacaoEngineUltima(FileClass.getAtributo(tagConfig,"update",getAtualizacaoEngineUltima()));
			setAtualizacaoEngineIntervalo(FileClass.getAtributo(tagConfig,"upinterval",getAtualizacaoEngineIntervalo()));
			//setAtualizacaoEngineUltima(FileClass.getAtributo(tagConfig,"update",-1));
			//setAtualizacaoEngineIntervalo(FileClass.getAtributo(tagConfig,"upinterval",-1));

			NodeList nodConexao = Elementos.getElementsByTagName("conexao");
			Element tagConexao = (Element) nodConexao.item(0);
			setConexaoLocalhost(FileClass.getAtributo(tagConexao,"localhost",getConexaoLocalhost()));
			setConexaoRepositorio(FileClass.getAtributo(tagConexao,"repository",getConexaoRepositorio()));
			setConexaoUsuario(FileClass.getAtributo(tagConexao,"user",getConexaoUsuario()));
			setConexaoSenha(Endecrypt.getDecriptado(FileClass.getAtributo(tagConexao,"pass",getConexaoSenha())));
			setAtualizacaoLocalhostUltima(FileClass.getAtributo(tagConexao,"update",getAtualizacaoLocalhostUltima()));
			setAtualizacaoLocalhostIntervalo(FileClass.getAtributo(tagConexao,"upinterval",getAtualizacaoLocalhostIntervalo()));

			NodeList nodExecucao = Elementos.getElementsByTagName("execucao");
			Element tagExecucao = (Element) nodExecucao.item(0);
			setExecucaoComando(FileClass.getAtributo(tagExecucao,"softcliente",getExecucaoComando()));

			NodeList nodExecucaoParametros = Elementos.getElementsByTagName("parametros");
			Element tagExecucaoParametros = (Element) nodExecucaoParametros.item(0);
			setExecucaoParametroServidor(FileClass.getAtributo(tagExecucaoParametros,"server",getExecucaoParametroServidor()));
			setExecucaoParametroConta(FileClass.getAtributo(tagExecucaoParametros,"login",getExecucaoParametroConta()));
			setExecucaoParametroSenha(Endecrypt.getDecriptado(FileClass.getAtributo(tagExecucaoParametros,"pass",getExecucaoParametroSenha())));
			setExecucaoParametroPersonagem(FileClass.getAtributo(tagExecucaoParametros,"char",getExecucaoParametroPersonagem()));
			setExecucaoParametroSemOpenGL(FileClass.getAtributo(tagExecucaoParametros,"noOpenGL",getExecucaoParametroSemOpenGL()));
		}catch(Exception ex){
			Logger.getLogger(ClassConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
