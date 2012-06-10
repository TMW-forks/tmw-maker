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
 * @version → TMW-Maker(2012-05-25)
 * @description → Programa de tratamento de arquivos
 * @licence → GNU GPL v3: http://www.gnu.org/licenses/gpl.html
 * @skype → lunovox
 * @msn → rui.gravata@hotmail.com
 * @gTalk → rui.gravata@gmail.com
 */
package classes;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Adler32;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author lunovox
 */
public class FileClass {
	public static long getAgora() {
		// um calendar também é criado com a data atual
		GregorianCalendar calendar = new GregorianCalendar();
		Date data = calendar.getTime();
		return data.getTime();
	}
	public static String AGORAtoFORMATO(String Formato) {
		//Formato = "dd/MM/yyyy";
		//Formato = "h:mm - a";
		java.util.Date Agora = new java.util.Date();
		SimpleDateFormat Formatador = new SimpleDateFormat(Formato);
		return Formatador.format(Agora);
	}
	public static String getSeparadorDePastas() {
		return System.getProperty("file.separator");
	}
	public static String getPastaDoUsuario() {
		return System.getProperty("user.home");
	}
	public static String getPastaDoSistema() {
		try {
			int Loc1 = -1;
			String EnderecoReal = "";
			//EnderecoReal=this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath().replaceAll("TMW-Maker.jar", "");
			EnderecoReal = FileClass.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().replaceAll("/lib/FileClass.ja", "");
			EnderecoReal = EnderecoReal.substring(0, EnderecoReal.length() - 1);
			Loc1 = EnderecoReal.indexOf("build/classes");
			if (Loc1 >= 0) {
				return getPastaDoUsuario();
				//return EnderecoReal;
			} else {
				return EnderecoReal;
			}
		} catch (URISyntaxException ex) {
			//Logger.getLogger(ConfigClass.class.getName()).log(Level.SEVERE, null, ex);
			return "";
		}
	}

	public static void apagar(String PastaOuArquivo) {
		File Objeto = new File(PastaOuArquivo);
		Objeto.delete();
	}
	public static void arquivoCopiar(String De, String Para) {
		File CapsulaOrigem = new File(De);
		arquivoCopiar(CapsulaOrigem, Para);
	}
	public static void arquivoCopiar(File CapsulaOrigem, String Para) {
		File CapsulaDestino = new File(Para);
		CapsulaDestino.setExecutable(CapsulaOrigem.canExecute(), true);
		CapsulaDestino.setReadable(CapsulaOrigem.canRead());
		CapsulaDestino.setWritable(CapsulaOrigem.canWrite());
		try {
			FileChannel Origem = new FileInputStream(CapsulaOrigem).getChannel();
			FileChannel Destino = new FileOutputStream(CapsulaDestino).getChannel();
			Origem.transferTo(0, Origem.size(), Destino);
			if (Origem != null && Origem.isOpen()) {
				Origem.close();
			}
			if (Destino != null && Destino.isOpen()) {
				Destino.close();
			}
		} catch (IOException ex) {
			Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		}/**/
	}
	public static void arquivoMover(String De, String Para) {
		File Origem = new File(De);
		File Destino = new File(Para);
		Origem.renameTo(Destino);
	}
	public static void pastaCriar(String EnderecoDaNovaPasta) {
		File dir = new File(EnderecoDaNovaPasta);
		dir.mkdirs();
	}
	public static String[] listarPasta(String Endereco) {
		///home/indigovox/localhost/eathena-data/npc
		File Capsula = new File(Endereco);
		File[] Conteudo = Capsula.listFiles();
		int ContPastas = 0;
		for (int c = 0; c < Conteudo.length; c++) {
			if (Conteudo[c].isDirectory()) {
				ContPastas++;
			}
		}
		String Pasta[] = new String[ContPastas];
		ContPastas = 0;
		for (int p = 0; p < Conteudo.length; p++) {
			if (Conteudo[p].isDirectory()) {
				Pasta[ContPastas] = Conteudo[p].getName();
				//TxtScript.setText(TxtScript.getText()+Conteudo[c].getName()+"\n");
				ContPastas++;
			}
		}
		Arrays.sort(Pasta);
		return Pasta;
	}
	public static String[] listarArquivos(String Endereco) {
		///home/indigovox/localhost/eathena-data/npc
		File Capsula = new File(Endereco);
		File[] Conteudo = Capsula.listFiles();
		int ContArquivos = 0;
		for (int c = 0; c < Conteudo.length; c++) {
			if (Conteudo[c].isFile()) {
				ContArquivos++;
			}
		}
		String Arquivos[] = new String[ContArquivos];
		ContArquivos = 0;
		for (int a = 0; a < Conteudo.length; a++) {
			if (Conteudo[a].isFile()) {
				Arquivos[ContArquivos] = Conteudo[a].getName();
				ContArquivos++;
			}
		}
		Arrays.sort(Arquivos);
		return Arquivos;
	}
	public static boolean arquivoSeSimpleNome(File PastaPai, String NomDeArquivo) {
		/**
		 * Função Copiada de Site "http://forums.sun.com/thread.jspa?threadID=629458"
		 * Eu não entendo essa Função, mas tentei implementa-la para ver se serve.
		 */
		if (PastaPai == null || NomDeArquivo == null) {
			return false;
		}
		File Arquivo = new File(PastaPai, NomDeArquivo);
		if (!Arquivo.exists()) { //se o arquivo já existe, pode ser o nome do arquivo está correto
			try {
				boolean SeNomeValido = Arquivo.createNewFile();
				//apagar o arquivo porque é criado para a verificação de validação
				if (SeNomeValido) {
					Arquivo.delete();
				}
				//Se o pai do novo arquivo e o pai dado é diferente, então o nome do arquivo está errado
				if (!Arquivo.getParent().equals(PastaPai.getPath())) {
					return false;
				}
				return SeNomeValido;
			} catch (IOException ioe) {
				return false;
			}
		}
		//Se o pai do novo arquivo e o pai dado é diferente, então o nome do arquivo está errado
		return Arquivo.getParent().equals(PastaPai.getPath());
	}

	public static boolean seExiste(String PastaOuArquivo) {
		File Capsula;
		Capsula = new File(PastaOuArquivo);
		if (Capsula.exists()) {
			return true;
		} else {
			return false;
		}
	}
	public static Runtime doBash(Runtime Executador, String Comando) throws IOException {
		//Runtime Executador = Runtime.getRuntime();
		String line = "";
		System.out.println(Comando);
		Process Retorno = Executador.exec(Comando);
		BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		return Executador;
	}
	public static boolean doBash(String Comando) {
		try {
			Runtime Executador = Runtime.getRuntime();
			String line = "";
			Process Retorno = Executador.exec(Comando);
			BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			return true;
		} catch (IOException ex) {
			System.out.println("\tERRO → " + Comando);
			Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	public static String urlAbrir(String Endereco) {
		try {
			URL arquivo = new URL(Endereco);
			BufferedReader in = new BufferedReader(new InputStreamReader(arquivo.openStream()));
			String str, Conteudo = "";
			int contador = 0;
			while ((str = in.readLine()) != null) {
				contador += 1;
				Conteudo += (Conteudo.equals("") ? str : "\n" + str);
			}
			in.close();
			return Conteudo;
		} catch (IOException e) {
			return null;
		}
	}
	public static String arquivoAbrir_deprecado(String Endereco) {
		try {
			String Conteudo = "", Linha = "";
			BufferedReader Capsula = new BufferedReader(new InputStreamReader(new FileInputStream(Endereco), "UTF-8"));
			while ((Linha = Capsula.readLine()) != null) {
				if (!Conteudo.equals("")) {
					Conteudo = Conteudo + "\n" + Linha;
				} else {
					Conteudo = Linha;
				}
			}
			Capsula.close();
			return Conteudo;
		} catch (java.io.IOException exc) {
			return null;
		}
	}
	public static String arquivoAbrir(String Endereco) {
		String Conteudo = "";
		int Tamanho = 1024 * 1024 * 32;
		ByteBuffer buf = ByteBuffer.allocate(Tamanho); //create buffer with capacity of 48 bytes
		try {
			RandomAccessFile aFile = new RandomAccessFile(Endereco, "rw");
			FileChannel inChannel = aFile.getChannel();
			int bytesRead = inChannel.read(buf);
			char Letra = 0;
			byte[] bytearray = null;
			while (bytesRead != -1) {
				buf.flip();
				bytearray = new byte[buf.remaining()];
				while (buf.hasRemaining()) {
					buf.get(bytearray);
				}
				Conteudo += new String(bytearray);
				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			return Conteudo;
		} catch (IOException e) {
			return Conteudo;
		}
	}
	public static Element arquivoAbrirXML(String Endereco) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document Documento = db.parse(Endereco);
			return Documento.getDocumentElement();
		} catch (ParserConfigurationException ex) {
			//Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			//Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			//Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	public static boolean arquivoSalvar(String Endereco, String Conteudo) {
		try {
			BufferedWriter Capsula = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Endereco), "UTF-8"));
			String Cabecalho = "";
			Capsula.write(Conteudo);
			Capsula.flush();
			Capsula.close();
			return true;
		} catch (java.io.IOException exc) {
			return false;
		}
	}
	public static boolean arquivoSalvarXML(String Endereco, Document Doc) {
		return arquivoSalvarXML(Endereco, new DOMSource(Doc), "utf-8");
	}
	public static boolean arquivoSalvarXML(String Endereco, DOMSource Source) {
		return arquivoSalvarXML(Endereco, Source, "utf-8");
	}
	public static boolean arquivoSalvarXML(String Endereco, Document Doc, String Encoding) {
		return arquivoSalvarXML(Endereco, new DOMSource(Doc), Encoding);
	}
	public static boolean arquivoSalvarXML(String Endereco, DOMSource Source, String Encoding) {
		try {
			Transformer trans = TransformerFactory.newInstance().newTransformer();
			trans.setOutputProperty(OutputKeys.INDENT, "yes");//Saber se o XML será identado(terá espaços entre tags).
			trans.setOutputProperty(OutputKeys.STANDALONE, "yes");
			trans.setOutputProperty(OutputKeys.ENCODING, Encoding);
			trans.transform(
					  Source,
					  new StreamResult(new FileOutputStream(Endereco)));
			////////////////////////////////////////////////////////////////////////////////////////////////
			// Salva compactado.
			//trans.transform( new GZipStreamSource(new File("input.xml")), new StreamResult(System.out) );
			/////////////////////////////////////////////////////////////////////////////////////////////////
			return true;
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} catch (TransformerException ex) {
			Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public static int getAtributo(Element elem, String atributo, int padrao) {
		try {
			return Integer.parseInt(elem.getAttribute(atributo));
		} catch (Exception ex) {
			//Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		}
		return padrao;
	}
	public static long getAtributo(Element elem, String atributo, long padrao) {
		try {
			return Long.parseLong(elem.getAttribute(atributo));
		} catch (Exception ex) {
			//Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		}
		return padrao;
	}
	public static boolean getAtributo(Element elem, String atributo, boolean padrao) {
		try {
			return elem.getAttribute(atributo).trim().toLowerCase().equals("true") ? true : false;
		} catch (Exception ex) {
			//Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		}
		return padrao;
	}
	public static String getAtributo(Element elem, String atributo, String padrao) {
		String str = elem.getAttribute(atributo);
		if (str == null) {
			str = padrao;
		}
		return str;
	}/**/
	public static int getConteudo(Element elemento, String tag, int padrao) {
		try {
			NodeList children = elemento.getElementsByTagName(tag);
			if (children == null) {
				return padrao;
			}
			Element child = (Element) children.item(0);
			if (child == null) {
				return padrao;
			}
			return Integer.parseInt(child.getFirstChild().getNodeValue());
		} catch (Exception ex) {
			//Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		}
		return padrao;
	}
	public static String getConteudo(Element elemento, String tag, String padrao) {
		try {
			NodeList children = elemento.getElementsByTagName(tag);
			if (children == null) {
				return padrao;
			}
			Element child = (Element) children.item(0);
			if (child == null) {
				return padrao;
			}
			return child.getFirstChild().getNodeValue();
		} catch (Exception ex) {
			//Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
		}
		return padrao;
	}/**/

    public static String getOS() {
        return System.getProperty("os.name").toLowerCase();
    }
    public static String getArquiteturaOS() {
        return System.getProperty("os.arch").toLowerCase();
    }
    public static String getVersaoOS() {
        return System.getProperty("os.version").toLowerCase();
    }

    public static void Esperar(int Milisegundos){
        long TempoInicio,TempoAtual;

        TempoInicio=System.currentTimeMillis();
        do{
            TempoAtual=System.currentTimeMillis();
        }
        while (TempoAtual-TempoInicio<Milisegundos);
    }
    public static boolean AbrirNavegador(String URL) {
        //minimizes the app

        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        Runtime Executador = Runtime.getRuntime();
        try {
            if (SistemaOperacional.indexOf("win") >= 0) {
                String[] cmd = new String[4];
                cmd[0] = "cmd.exe";
                cmd[1] = "/C";
                cmd[2] = "start";
                cmd[3] = URL;
                Executador.exec(cmd);
            } else if (SistemaOperacional.indexOf("mac") >= 0) {
                Executador.exec("open " + URL);
            } else {
                //prioritized 'guess' of users' preference
                String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror", "netscape", "opera", "links", "lynx"};
                StringBuffer cmd = new StringBuffer();
                for (int i = 0; i < browsers.length; i++) {
                   cmd.append((i == 0 ? "" : " || ") + browsers[i] + " \"" +
                           URL + "\" ");
                }
                Executador.exec(new String[]{"sh", "-c", cmd.toString()});
                //rt.exec("firefox http://www.google.com");
                //System.out.println(cmd.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            /*DialogClass.showErro(
                "\n\n O TMW-Maker não conseguiu abrir o seu navegador padrão ao tentar acessar: \n\n " + URL + "\n\n",
                "Erro de acesso ao Navegado"
            );/**/

            return false;
        }
        return true;
    }
    public static boolean SeComandoProcede(String Comando) {
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        Runtime Executador = Runtime.getRuntime();
        if (SistemaOperacional.indexOf("win") >= 0) {
            return false;
        } else if (SistemaOperacional.indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            //showAlerta("Este comando ainda não foi implementado para o MAC!","Descupe!");
            return false;
        } else {
            try {
                Executador.exec(Comando);
                return true;
            } catch (IOException e) {
                return false;
            }
        }
    }
	/**
	public static Document arquivoAbrirXML(String Endereco){
	if(seExiste(Endereco)){
	try {
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db=dbf.newDocumentBuilder();
	return db.parse(Endereco);
	// pega todos os elementos usuario do XML
	} catch (ParserConfigurationException ex) {
	Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SAXException ex) {
	Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
	}
	}
	return null;
	}
	public static Vector getNos(Document Documento,String Elemento){
	Element Elementos = Documento.getDocumentElement();
	NodeList nl = Elementos.getElementsByTagName(Elemento); //Elemento="usuario"
	// percorre cada elemento usuario encontrado
	Vector usuarios = new Vector();
	for (int i = 0; i < nl.getLength(); i++) {
	Element tagUsuario = (Element) nl.item(i);

	// pega os dados cadastrado para o usuario atual
	int id = Integer.parseInt(tagUsuario.getAttribute("id"));
	String nome = getChildTagValue(tagUsuario, "nome");
	Integer idade = new Integer(getChildTagValue(tagUsuario, "idade"));
	String email = getChildTagValue(tagUsuario, "email");

	// cria uma nova instancia do UsuarioGuj com os dados do xml
	UsuarioGUJ usuarioGuj = new UsuarioGUJ(id, nome, idade, email);

	// adiciona o usuario na coleção (vector) de usuários do guj
	usuarios.addElement(usuarioGuj);
	}

	return usuarios;
	}

	// este método lê e retorna o conteúdo (texto) de uma tag (elemento)
	// filho da tag informada como parâmetro. A tag filho a ser pesquisada
	// é a tag informada pelo nome (string)
	private String getChildTagValue(Element elem, String tagName){
	NodeList children = elem.getElementsByTagName(tagName);
	if (children == null) {
	return null;
	}
	Element child = (Element) children.item(0);
	if (child == null) {
	return null;
	}
	return child.getFirstChild().getNodeValue();
	}/**/

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
		System.out.println(" @author → lunovox");
		System.out.println(" @version → TMW-Maker(2012-05-25)");
		System.out.println(" @description → Biblioteca de tratamento de arquivos");
		System.out.println(" @licence → GNU GPL v3: http://www.gnu.org/licenses/gpl.html");
		System.out.println(" @skype → lunovox");
		System.out.println(" @msn → rui.gravata@hotmail.com");
		System.out.println(" @gTalk → rui.gravata@gmail.com");
	}
	public static void main(String[] args) {
		// TODO code application logic here
		printHelp();
	}
}
