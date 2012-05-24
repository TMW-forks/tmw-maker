package Classes;

import autocomplete.DocComando;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ConfigClass {
	 //Endecrypt myEndecrypt  = new Endecrypt("OpenWorld");

    private String Versao = "0.2";
    private String  Barra = System.getProperty("file.separator");

    private String  ConexaoRepositorio =            "http://themanaworld-br.googlecode.com/svn/trunk";
	 //private String  ConexaoLocalhost =              getPastaDoUsuario()+Barra+"localhost";
    private String  ConexaoLocalhost =              getPastaDoSistema()+Barra+"localhost";
	 
    private String  ConexaoUsuario =                "";
    private String  ConexaoSenha =                  "";
    private String  ExecucaoComando =               "manaplus";
    private String  ExecucaoParametroTMWData =      ConexaoLocalhost+Barra+"tmwdata";
    private String  ExecucaoParametroServidor =     "localhost";
    private String  ExecucaoParametroConta =        ""; //Inicia sem valor
    private String  ExecucaoParametroSenha =        ""; //Inicia sem valor
    private String  ExecucaoParametroPersonagem =   ""; //Inicia sem valor
    private boolean ExecucaoParametroSemopengl =    true; //Inicia Sem OpenGL
    private String  DocumentacaoAlteracoes =        "http://code.google.com/p/themanaworld-br/source/list";
    private String  DocumentacaoComponentes =       "http://code.google.com/p/tmw-maker/wiki";
    private String  DocumentacaoComentarios =       "http://code.google.com/p/tmw-maker/issues/entry";
    private String  DocumentacaoTraducoes =         "";

    private long    ComportAtualizacaoEngineUltima =        0;
    private int     ComportAtualizacaoEngineIntervalo =     7; // Semanalmente (Cada 7 Dias)
    private long    ComportAtualizacaoLocalhostUltima =     0;
    private int     ComportAtualizacaoLocalhostIntervalo =  0; // Sempre (Ao abrir)

    //private String  ConfiguracaoURL = getPastaDoUsuario()+Barra+".tmw-maker.ini";
    private boolean SeExecutandoCodigofonte = false;
    private String  ConfiguracaoURL = getPastaDoSistema()+Barra+".tmw-maker.ini";


    public String getPastaDoUsuario(){
        return System.getProperty("user.home");
    }
    public String getPastaDoSistema(){
        try {
            int Loc1=-1;
            String EnderecoReal="";
            EnderecoReal=DocComando.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().replaceAll("TMW-Maker.jar", "");
            EnderecoReal=EnderecoReal.substring(0, EnderecoReal.length()-1);
            Loc1=EnderecoReal.indexOf("build/classes");
            if(Loc1>=0){
                SeExecutandoCodigofonte=true;
					 return "/usr/share/TMW-Maker";
					 //return EnderecoReal+"/../../dist";
            }else{
                SeExecutandoCodigofonte=false;
                return EnderecoReal;
            }
        } catch (URISyntaxException ex) {
            //Logger.getLogger(ConfigClass.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    public boolean getSeExecutandoCodigofonte(){
        return SeExecutandoCodigofonte;
    }
    public String getIdiomaDoSistema(){
        if(!getSeExecutandoCodigofonte()){
            return System.getProperty("user.language");
        }else{
            return "en";
        }
        //return Locale.getDefault().getDisplayLanguage();
        //return Locale.getDefault().getLanguage();
    }
    public String getVersao(){return Versao;}
    public long getAtualizacaoEngineUltima(){return ComportAtualizacaoEngineUltima;}
    public long getAtualizacaoEngineIntervaloReal(){
        /**
          * 1000 = Milisegundos
          * 60 = Segundos
          * 60 = Minutos
          * 24 = horas
          **/
        return 1000*60*60*24*ComportAtualizacaoEngineIntervalo; //Intervalo de 1 dias
    }
    public int  getAtualizacaoEngineIntervalo(){
        return ComportAtualizacaoEngineIntervalo; //Intervalo de 1 dias
    }
    public long getAtualizacaoEngineFutura(){
        /**
         * Se ComportAtualizacaoEngineIntervalo for <= -1 ? Nunca
         * Se ComportAtualizacaoEngineIntervalo for ==  0 ? Sempre ao Iniciar
         * Se ComportAtualizacaoEngineIntervalo for >= +1 ? Espera
         */
        if(ComportAtualizacaoEngineIntervalo>=0){
            return ComportAtualizacaoEngineUltima+getAtualizacaoEngineIntervaloReal(); //Intervalo de 1 dias
        }else{
            return -1;
        }
    }
    public long getAtualizacaoLocalhostUltima(){return ComportAtualizacaoLocalhostUltima;}
    public long getAtualizacaoLocalhostIntervaloReal(){
        /**
          * 1000 = Milisegundos
          * 60 = Segundos
          * 60 = Minutos
          * 24 = horas
          **/
        return 1000*60*60*24*ComportAtualizacaoLocalhostIntervalo; //Intervalo de 1 dias
    }
    public int  getAtualizacaoLocalhostIntervalo(){
        return ComportAtualizacaoLocalhostIntervalo; //Intervalo de 1 dias
    }
    public long getAtualizacaoLocalhostFutura(){
        /**
         * Se ComportAtualizacaoLocalhostIntervalo for <= -1 ? Nunca
         * Se ComportAtualizacaoLocalhostIntervalo for ==  0 ? Sempre ao Iniciar
         * Se ComportAtualizacaoLocalhostIntervalo for >= +1 ? Espera
         */
        if(ComportAtualizacaoLocalhostIntervalo>=0){
            return ComportAtualizacaoLocalhostUltima+getAtualizacaoLocalhostIntervaloReal(); //Intervalo de 1 dias
        }else{
            return -1;
        }
    }

    public static long getAgora(){
        // um calendar também é criado com a data atual
        GregorianCalendar calendar = new GregorianCalendar();
        Date data = calendar.getTime();
        return data.getTime();
    }
    public static String AGORAtoFORMATO(String Formato){
        //Formato = "dd/MM/yyyy";
        //Formato = "h:mm - a";
        java.util.Date Agora = new java.util.Date();
        SimpleDateFormat Formatador = new SimpleDateFormat(Formato);
        return Formatador.format(Agora);
    }
    public String  getConexaoRepositorio(){return ConexaoRepositorio;}
    public String  getConexaoLocalhost(){return ConexaoLocalhost;}
    public String  getConexaoUsuario(){return ConexaoUsuario;}
    public String  getConexaoSenha(){return ConexaoSenha;}
    public String  getExecucaoComando(){return ExecucaoComando;}
    public String  getExecucaoParametroServidor(){return ExecucaoParametroServidor;}
    public String  getExecucaoParametroConta(){return ExecucaoParametroConta;}
    public String  getExecucaoParametroSenha(){return ExecucaoParametroSenha;}
    public String  getExecucaoParametroPersonagem(){return ExecucaoParametroPersonagem;}
    public boolean getExecucaoParametroSemopengl(){return ExecucaoParametroSemopengl;}
    public String  getDocumentacaoAlteracoes(){return DocumentacaoAlteracoes;}
    public String  getDocumentacaoComponentes(){return DocumentacaoComponentes;}
    public String  getDocumentacaoComentarios(){return DocumentacaoComentarios;}
    public String  getDocumentacaoTraducoes(){return DocumentacaoTraducoes;}

    public void setAtualizacaoEngineIntervalo(int Dias){ComportAtualizacaoEngineIntervalo=Dias;}
    public void setAtualizacaoEngineUltima(long Quando){ComportAtualizacaoEngineUltima=Quando;}
    public void setAtualizacaoEngineUltimaAgora(){ComportAtualizacaoEngineUltima=getAgora();}
    public void setAtualizacaoLocalhostIntervalo(int Dias){ComportAtualizacaoLocalhostIntervalo=Dias;}
    public void setAtualizacaoLocalhostUltima(long Quando){ComportAtualizacaoLocalhostUltima=Quando;}
    public void setAtualizacaoLocalhostUltimaAgora(){ComportAtualizacaoLocalhostUltima=getAgora();}

    public void setConexaoRepositorio(String URL){ConexaoRepositorio=URL ;}
    public void setConexaoLocalhost(String EnderecoDaPasta){ConexaoLocalhost=EnderecoDaPasta ;}
    public void setConexaoUsuario(String Usuario){ConexaoUsuario=Usuario ;}
    public void setConexaoSenha(String Senha){ConexaoSenha=Senha ;}
    public void setExecucaoComando(String Comando){ExecucaoComando=Comando ;}
    //public void setExecucaoParametroTMWData(String PastaTMWData){ExecucaoParametroTMWData=PastaTMWData ;}
    public void setExecucaoParametroServidor(String Servidor){ExecucaoParametroServidor=Servidor ;}
    public void setExecucaoParametroConta(String Conta){ExecucaoParametroConta=Conta ;}
    public void setExecucaoParametroSenha(String Senha){ExecucaoParametroSenha=Senha ;}
    public void setExecucaoParametroPersonagem(String Personagem){ExecucaoParametroPersonagem=Personagem ;}
    public void setExecucaoParametroSemopengl(boolean SemOpenGL){ExecucaoParametroSemopengl=SemOpenGL;}
    public void setDocumentacaoAlteracoes(String URLdeAlteracoes){DocumentacaoAlteracoes=URLdeAlteracoes ;}
    public void setDocumentacaoComponentes(String URLdeComponentes){DocumentacaoComponentes=URLdeComponentes ;}
    public void setDocumentacaoComentarios(String URLdeComentarios){DocumentacaoComentarios=URLdeComentarios ;}
    public void setDocumentacaoTraducoes(String URLdeTraducoes){DocumentacaoTraducoes=URLdeTraducoes ;}

    public void Esperar(int Milisegundos){
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
            DialogClass.showErro(
                "\n\n O TMW-Maker não conseguiu abrir o seu navegador padrão ao tentar acessar: \n\n " + URL + "\n\n",
                "Erro de acesso ao Navegado"
            );

            return false;
        }
        return true;
    }
    public boolean SeComandoProcede(String Comando) {
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
    public boolean SeComandoProcede() {
        return SeComandoProcede(getExecucaoComando()+" --help");
    }

    public String getPropriedade(String Conteudo, String Propriedade) {
        int OndeEncontrado= Conteudo.indexOf("\n"+Propriedade+":",0);
        int FinalDeLinha= Conteudo.indexOf("\n",OndeEncontrado+Propriedade.length()+1);
        if(OndeEncontrado>=1){
            String Resultado=Conteudo.substring(OndeEncontrado+Propriedade.length()+3, FinalDeLinha).toString();
            //showAlerta("\""+Resultado+"\"","Aviso de Programador");
            return Resultado;
        }else{
            return "";
        }
    }

    public String  getEathenaData(){return ConexaoLocalhost+Barra+"eathena-data";}
    public String  getTMWData(){return ConexaoLocalhost+Barra+"tmwdata";}

    public void ConfiguracoesGravar(){ConfiguracoesGravar(ConfiguracaoURL);}
    public void ConfiguracoesGravar(String Endereco) {
		//keyEndecript

		//Endecrypt aaa

		//Endecrypt endecrypt = new Endecrypt($sqlUser + "@" + $sqlServer + "/" + $sqlDB);
		//$sqlPass = endecrypt.decriptar(FileClass.getAtributo($tagMySQL, "password", $sqlPass));


		try {
			String Corpo =
			  "////////////////////////////////\n"+
			  "// Configurações do TMW-Maker //\n"+
			  "////////////////////////////////\n"+
			  "\n"
			  + "Versao: " + getVersao() + "\n"
			  + "ConexaoRepositorio: " + getConexaoRepositorio() + "\n"
			  + "ConexaoLocalhost: " + getConexaoLocalhost() + "\n"
			  + "ConexaoUsuario: " + getConexaoUsuario() + "\n"
			  //+ "ConexaoSenha: " + myEndecrypt.encriptar(getConexaoSenha()) + "\n"
			  + "ConexaoSenha: " + getConexaoSenha() + "\n"
			  + "ExecucaoComando: " + getExecucaoComando() + "\n"
			  + //"ExecucaoParametroTMWData: "+getExecucaoParametroTMWData()+"\n"+
			  "ExecucaoParametroServidor: " + getExecucaoParametroServidor() + "\n"
			  + "ExecucaoParametroConta: " + getExecucaoParametroConta() + "\n"
			  //+ "ExecucaoParametroSenha: " + myEndecrypt.encriptar(getExecucaoParametroSenha()) + "\n"
			  + "ExecucaoParametroSenha: " + getExecucaoParametroSenha() + "\n"
			  + "ExecucaoParametroPersonagem: " + getExecucaoParametroPersonagem() + "\n"
			  + "ExecucaoParametroSemopengl: " + (getExecucaoParametroSemopengl() ? "true" : "false") + "\n"
			  + "DocumentacaoAlteracoes: " + getDocumentacaoAlteracoes() + "\n"
			  + "DocumentacaoComponentes: " + getDocumentacaoComponentes() + "\n"
			  + "DocumentacaoComentarios: " + getDocumentacaoComentarios() + "\n"
			  + "DocumentacaoTraducoes: " + getDocumentacaoTraducoes() + "\n"
			  + "AtualizacaoEngineUltima: " + getAtualizacaoEngineUltima() + "\n"
			  + "AtualizacaoEngineIntervalo: " + getAtualizacaoEngineIntervalo() + "\n"
			  + "AtualizacaoLocalhostUltima: " + getAtualizacaoLocalhostUltima() + "\n"
			  + "AtualizacaoLocalhostIntervalo: " + getAtualizacaoLocalhostIntervalo() + "\n"
			  + "\n//Fim de Configuração";

			/*FileWriter out = new FileWriter(Endereco);
			out.write(Corpo);
			out.close();/**/
			BufferedWriter Capsula = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Endereco), "UTF-8"));
			Capsula.write(Corpo);
			Capsula.flush();
			Capsula.close();
		} catch (java.io.IOException exc) {
			DialogClass.showErro("Não foi possível salvar as configurações!", "ERRO");
		}
	}
    public void ConfiguracoesAbrir(){ConfiguracoesAbrir(ConfiguracaoURL);}
    public void ConfiguracoesAbrir(String Endereco){
        //Rotina de Abrir Configuracões
        String Conteudo="";
        try {
            String Linha="";
            FileInputStream stream = new FileInputStream(Endereco);
            InputStreamReader streamReader = new InputStreamReader(stream,"UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);
            while ((Linha = reader.readLine()) != null) {
                if(!Conteudo.equals("")){
                    Conteudo=Conteudo+"\n"+Linha;
                }else{
                    Conteudo=Linha;
                }
            }
            reader.close();
            streamReader.close();
            stream.close();

            setConexaoRepositorio(getPropriedade(Conteudo,"ConexaoRepositorio"));
            setConexaoLocalhost(getPropriedade(Conteudo,"ConexaoLocalhost"));
            setConexaoUsuario(getPropriedade(Conteudo,"ConexaoUsuario"));
            setConexaoSenha(getPropriedade(Conteudo,"ConexaoSenha"));
            setExecucaoComando(getPropriedade(Conteudo,"ExecucaoComando"));
            //setExecucaoParametroTMWData(getPropriedade(Conteudo,"ExecucaoParametroTMWData"));
            setExecucaoParametroServidor(getPropriedade(Conteudo,"ExecucaoParametroServidor"));
            setExecucaoParametroConta(getPropriedade(Conteudo,"ExecucaoParametroConta"));
            setExecucaoParametroSenha(getPropriedade(Conteudo,"ExecucaoParametroSenha"));
            setExecucaoParametroPersonagem(getPropriedade(Conteudo,"ExecucaoParametroPersonagem"));
            setExecucaoParametroSemopengl(getPropriedade(Conteudo,"ExecucaoParametroSemopengl").equals("true"));
            setDocumentacaoAlteracoes(getPropriedade(Conteudo,"DocumentacaoAlteracoes"));
            setDocumentacaoComentarios(getPropriedade(Conteudo,"DocumentacaoComentarios"));
            setDocumentacaoComponentes(getPropriedade(Conteudo,"DocumentacaoComponentes"));
            setDocumentacaoTraducoes(getPropriedade(Conteudo,"DocumentacaoTraducoes"));

            setAtualizacaoEngineUltima(Long.parseLong(getPropriedade(Conteudo,"AtualizacaoEngineUltima").equals("")?"0":getPropriedade(Conteudo,"AtualizacaoEngineUltima")));
            setAtualizacaoEngineIntervalo(Integer.parseInt(getPropriedade(Conteudo,"AtualizacaoEngineIntervalo").equals("")?"1":getPropriedade(Conteudo,"AtualizacaoEngineIntervalo")));

            setAtualizacaoLocalhostUltima(Long.parseLong(getPropriedade(Conteudo,"AtualizacaoLocalhostUltima").equals("")?"0":getPropriedade(Conteudo,"AtualizacaoLocalhostUltima")));
            setAtualizacaoLocalhostIntervalo(Integer.parseInt(getPropriedade(Conteudo,"AtualizacaoLocalhostIntervalo").equals("")?"1":getPropriedade(Conteudo,"AtualizacaoLocalhostIntervalo")));

} catch (java.io.IOException exc) {
            //showAlerta("Não foi possivel abrir o arquivo!","AVISO");
            //ExemploDeConteudo();
            //TxtScript.setEnabled(true);
            //CmbScript.setEnabled(true);
        }
    }

    public boolean getSeDependenciaDeConfiguracao() {
        if(FileClass.seExiste(ConfiguracaoURL)){
            return true;
        }else{
            return false;
        }
    }
    public boolean getSeDependenciaDeSVN(){
        return SeComandoProcede("svn --help");
    }
    public boolean getSeDependenciaDeLocalhost(){
        return FileClass.seExiste(getConexaoLocalhost());
    }
    public boolean getSeDependenciaDeGCC(){
        return SeComandoProcede("gcc --help");
    }
    public boolean getSeDependenciaDeMontagem(){
        if(
            FileClass.seExiste(
                getConexaoLocalhost().toString()+
                System.getProperty("file.separator")+"eathena-data"+
                System.getProperty("file.separator")+"char-server"
            )
            &&
            FileClass.seExiste(
                getConexaoLocalhost().toString()+
                System.getProperty("file.separator")+"eathena-data"+
                System.getProperty("file.separator")+"login-server"
            )
            &&
            FileClass.seExiste(
                getConexaoLocalhost().toString()+
                System.getProperty("file.separator")+"eathena-data"+
                System.getProperty("file.separator")+"map-server"
            )
            &&
            FileClass.seExiste(
                getConexaoLocalhost().toString()+
                System.getProperty("file.separator")+"eathena-data"+
                System.getProperty("file.separator")+"save"+
                System.getProperty("file.separator")+"account.txt"
            )
            &&
            FileClass.seExiste(
                ConexaoLocalhost+
                System.getProperty("file.separator")+"eathena-data"+
                System.getProperty("file.separator")+"conf"+
                System.getProperty("file.separator")+"gm_account.txt"
            )
        ){
            return true;
        }else{
            return false;
        }
    }
    public boolean getSeDependenciaDeManaplus(){
        return SeComandoProcede("manaplus --help");
    }
    public boolean getSeDependenciaDeTMW(){
        return SeComandoProcede("tmw --help");
    }
    public boolean getSeDependenciaDeTiled(){
        return SeComandoProcede("tiled --help");
    }
    public int getDependenciaEmFalta(){
        if(!getSeDependenciaDeConfiguracao()){
            return 1;
        }else if(!getSeDependenciaDeSVN()){
            return 2;
        }else if(!getSeDependenciaDeLocalhost()){
            return 3;
        }else if(!getSeDependenciaDeGCC()){
            return 4;
        }else if(!getSeDependenciaDeMontagem()){
            return 5;
        }else if(
            (getExecucaoComando().equals("manaplus") && !getSeDependenciaDeManaplus()) ||
            (getExecucaoComando().equals("tmw") && !getSeDependenciaDeTMW()) ||
            (!getExecucaoComando().equals("manaplus") && !getExecucaoComando().equals("tmw") && !SeComandoProcede(ExecucaoComando+" --help"))
        ){
            return 6;
        /*}else if(!getSeDependenciaDeTiled()){
            return 7;/**/
        }else{
            return 0;
        }
    }

    public String getOS() {
        return System.getProperty("os.name").toLowerCase();
    }
    public String getArquiteturaOS() {
        return System.getProperty("os.arch").toLowerCase();
    }
    public String getVersaoOS() {
        return System.getProperty("os.version").toLowerCase();
    }

    public void Descompactar(String Arquivo, String EmPasta) {
        Enumeration entries;
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(Arquivo);
            entries = zipFile.entries();
            InputStream Entrada=null;
            OutputStream Saida=null;
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                if (entry.isDirectory()) {
                    System.err.println("Descompactando diretório: " + EmPasta+Barra+entry.getName());
                    (new File(EmPasta+Barra+entry.getName())).mkdir();
                    continue;
                }
                System.out.println("Descompactando arquivo:" + EmPasta+Barra+entry.getName());
                
                Entrada=zipFile.getInputStream(entry);
                Saida=new BufferedOutputStream(new FileOutputStream(EmPasta+Barra+entry.getName()));
                byte[] buffer = new byte[1024];
                int len;
                while ((len = Entrada.read(buffer)) >= 0) {
                    Saida.write(buffer, 0, len);
                }
                Entrada.close();
                Saida.close();
            }
            zipFile.close();
        } catch (IOException ioe) {
            System.err.println("Erro ao descompactar:" + ioe.getMessage());
            return;
        }
    }


}
