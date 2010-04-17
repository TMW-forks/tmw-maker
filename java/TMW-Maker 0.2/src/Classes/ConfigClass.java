package Classes;


public class ConfigClass {
    private String Versao = "0.2";

    private String  ConexaoRepositorio = "          http://themanaworld-br.googlecode.com/svn/trunk";
    private String  ConexaoLocalhost =              System.getProperty("user.home")+"/tmw-br";
    private String  ConexaoUsuario =                "";
    private String  ConexaoSenha =                  "";
    private String  ExecucaoComando =               "mana";
    private String  ExecucaoParametroTMWData =      ConexaoLocalhost+"/tmwdata";
    private String  ExecucaoParametroServidor =     "localhost";
    private String  ExecucaoParametroConta =        ""; //Inicia sem valor
    private String  ExecucaoParametroSenha =        ""; //Inicia sem valor
    private String  ExecucaoParametroPersonagem =   ""; //Inicia sem valor
    private boolean ExecucaoParametroSemopengl =    true; //Inicia Sem OpenGL
    private String  DocumentacaoAlteracoes =        "http://code.google.com/p/tmw-maker/source/list";
    private String  DocumentacaoComponentes =       "http://code.google.com/p/tmw-maker/wiki/";
    private String  DocumentacaoComentarios =       "http://code.google.com/p/tmw-maker/issues/entry";
    private String  DocumentacaoTraducoes =         "";

    public String getVersao(){return Versao.toString();}

    public String  getConexaoRepositorio(){return ConexaoRepositorio.toString();}
    public String  getConexaoLocalhost(){return ConexaoLocalhost.toString();}
    public String  getConexaoUsuario(){return ConexaoUsuario.toString();}
    public String  getConexaoSenha(){return ConexaoSenha.toString();}
    public String  getExecucaoComando(){return ExecucaoComando.toString();}
    public String  getExecucaoParametroTMWData(){return ExecucaoParametroTMWData.toString();}
    public String  getExecucaoParametroServidor(){return ExecucaoParametroServidor.toString();}
    public String  getExecucaoParametroConta(){return ExecucaoParametroConta.toString();}
    public String  getExecucaoParametroSenha(){return ExecucaoParametroSenha.toString();}
    public String  getExecucaoParametroPersonagem(){return ExecucaoParametroPersonagem.toString();}
    public boolean getExecucaoParametroSemopengl(){return ExecucaoParametroSemopengl;}
    public String  getDocumentacaoAlteracoes(){return DocumentacaoAlteracoes.toString();}
    public String  getDocumentacaoComponentes(){return DocumentacaoComponentes.toString();}
    public String  getDocumentacaoComentarios(){return DocumentacaoComentarios.toString();}
    public String  getDocumentacaoTraducoes(){return DocumentacaoTraducoes.toString();}

    public void setConexaoRepositorio(String URL){ConexaoRepositorio=URL.toString();}
    public void setConexaoLocalhost(String EnderecoDaPasta){ConexaoLocalhost=EnderecoDaPasta.toString();}
    public void setConexaoUsuario(String Usuario){ConexaoUsuario=Usuario.toString();}
    public void setConexaoSenha(String Senha){ConexaoSenha=Senha.toString();}
    public void setExecucaoComando(String Comando){ExecucaoComando=Comando.toString();}
    public void setExecucaoParametroTMWData(String PastaTMWData){ExecucaoParametroTMWData=PastaTMWData.toString();}
    public void setExecucaoParametroServidor(String Servidor){ExecucaoParametroServidor=Servidor.toString();}
    public void setExecucaoParametroConta(String Conta){ExecucaoParametroConta=Conta.toString();}
    public void setExecucaoParametroSenha(String Senha){ExecucaoParametroSenha=Senha.toString();}
    public void setExecucaoParametroPersonagem(String Personagem){ExecucaoParametroPersonagem=Personagem.toString();}
    public void setExecucaoParametroSemopengl(boolean SemOpenGL){ExecucaoParametroSemopengl=SemOpenGL;}
    public void setDocumentacaoAlteracoes(String URLdeAlteracoes){DocumentacaoAlteracoes=URLdeAlteracoes.toString();}
    public void setDocumentacaoComponentes(String URLdeComponentes){DocumentacaoComponentes=URLdeComponentes.toString();}
    public void setDocumentacaoComentarios(String URLdeComentarios){DocumentacaoComentarios=URLdeComentarios.toString();}
    public void setDocumentacaoTraducoes(String URLdeTraducoes){DocumentacaoTraducoes=URLdeTraducoes.toString();}

    public void ConfiguracoesGravar(String Endereco){
        //Rotina de Salvar Configuracões
    }
    public void ConfiguracoesAbrir(String Endereco){
        //Rotina de Abrir Configuracões
    }
}
