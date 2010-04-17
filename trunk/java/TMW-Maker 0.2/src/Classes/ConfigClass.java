package Classes;

import Formularios.FrmPrincipal;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


public class ConfigClass {
    private String Versao = "0.2";
    private String EnderecoPadrao = "config.ini";

    private String  ConexaoRepositorio =            "http://themanaworld-br.googlecode.com/svn/trunk";
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

    public void Esperar(int Milisegundos){
        long TempoInicio,TempoAtual;

        TempoInicio=System.currentTimeMillis();
        do{
            TempoAtual=System.currentTimeMillis();
        }
        while (TempoAtual-TempoInicio<Milisegundos);
    }
    public static void Mensagem_Erro(String Aviso, String Titulo) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,Aviso,Titulo,JOptionPane.WARNING_MESSAGE);
    }
    public boolean SeComandoProcede(String Comando) {
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        Runtime Executador = Runtime.getRuntime();
        if (SistemaOperacional.indexOf("win") >= 0) {
            return false;
        } else if (SistemaOperacional.indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            //Mensagem_Erro("Este comando ainda não foi implementado para o MAC!","Descupe!");
            return false;
        } else {
            try {
                Executador.exec(Comando+" --help");
                return true;
            } catch (IOException e) {
                return false;
            }
        }
    }
    public boolean SeComandoProcede() {
        return SeComandoProcede(getExecucaoComando()+" --help");
    }
    public static String getPropriedade(String Conteudo, String Propriedade) {
        int OndeEncontrado= Conteudo.indexOf("\n"+Propriedade+":",0);
        int FinalDeLinha= Conteudo.indexOf("\n",OndeEncontrado+Propriedade.length()+1);
        if(OndeEncontrado>=1){
            String Resultado=Conteudo.substring(OndeEncontrado+Propriedade.length()+3, FinalDeLinha).toString();
            //Mensagem_Erro("\""+Resultado+"\"","Aviso de Programador");
            return Resultado;
        }else{
            return "";
        }
    }
    public void ConfiguracoesGravar() throws IOException{ConfiguracoesGravar(EnderecoPadrao);}
    public void ConfiguracoesGravar(String Endereco) throws IOException{
        String Corpo=
        "////////////////////////////////\n"+
        "// Configurações do TMW-Maker //\n"+
        "////////////////////////////////\n"+
        "\n"+
        "Versao: "+getVersao()+"\n"+

        "ConexaoRepositorio: "+getConexaoRepositorio()+"\n"+
        "ConexaoLocalhost: "+getConexaoLocalhost()+"\n"+
        "ConexaoUsuario: "+getConexaoUsuario()+"\n"+
        "ConexaoSenha: "+getConexaoSenha()+"\n"+

        "ExecucaoComando: "+getExecucaoComando()+"\n"+
        "ExecucaoParametroTMWData: "+getExecucaoParametroTMWData()+"\n"+
        "ExecucaoParametroServidor: "+getExecucaoParametroServidor()+"\n"+
        "ExecucaoParametroConta: "+getExecucaoParametroConta()+"\n"+
        "ExecucaoParametroSenha: "+getExecucaoParametroSenha()+"\n"+
        "ExecucaoParametroPersonagem: "+getExecucaoParametroPersonagem()+"\n"+
        "ExecucaoParametroSemopengl: "+(getExecucaoParametroSemopengl()?"true":"false")+"\n"+

        "DocumentacaoAlteracoes: "+getDocumentacaoAlteracoes()+"\n"+
        "DocumentacaoComponentes: "+getDocumentacaoComponentes()+"\n"+
        "DocumentacaoComentarios: "+getDocumentacaoComentarios()+"\n"+
        "DocumentacaoTraducoes: "+getDocumentacaoTraducoes()+"\n"+
        "\n"+
        "//Fim de Configuração";
        try {
            FileWriter out = new FileWriter(Endereco);
            out.write(Corpo);
            out.close();
        } catch (java.io.IOException exc) {
            Mensagem_Erro("Não foi possivel gravar o arquivo!","AVISO");
        }
    }
    public void ConfiguracoesAbrir() throws FileNotFoundException, IOException{ConfiguracoesAbrir(EnderecoPadrao);}
    public void ConfiguracoesAbrir(String Endereco) throws FileNotFoundException, IOException{
        //Rotina de Abrir Configuracões
        String Conteudo="";
        try {
            FileReader CapsulaDeLer = new FileReader(Endereco);
            int Caracater = CapsulaDeLer.read();
            while (Caracater!=-1) {
                Conteudo = Conteudo + (char) Caracater;
                Caracater = CapsulaDeLer.read();
            }
            CapsulaDeLer.close();
            setConexaoRepositorio(getPropriedade(Conteudo,"ConexaoRepositorio"));
            setConexaoLocalhost(getPropriedade(Conteudo,"ConexaoLocalhost"));
            setConexaoUsuario(getPropriedade(Conteudo,"ConexaoUsuario"));
            setConexaoSenha(getPropriedade(Conteudo,"ConexaoSenha"));
            setExecucaoComando(getPropriedade(Conteudo,"ExecucaoComando"));
            setExecucaoParametroTMWData(getPropriedade(Conteudo,"ExecucaoParametroTMWData"));
            setExecucaoParametroServidor(getPropriedade(Conteudo,"ExecucaoParametroServidor"));
            setExecucaoParametroConta(getPropriedade(Conteudo,"ExecucaoParametroConta"));
            setExecucaoParametroSenha(getPropriedade(Conteudo,"ExecucaoParametroSenha"));
            setExecucaoParametroPersonagem(getPropriedade(Conteudo,"ExecucaoParametroPersonagem"));
            setExecucaoParametroSemopengl(getPropriedade(Conteudo,"ExecucaoParametroSemopengl").equals("true"));
            setDocumentacaoAlteracoes(getPropriedade(Conteudo,"DocumentacaoAlteracoes"));
            setDocumentacaoComentarios(getPropriedade(Conteudo,"DocumentacaoComentarios"));
            setDocumentacaoComponentes(getPropriedade(Conteudo,"DocumentacaoComponentes"));
            setDocumentacaoTraducoes(getPropriedade(Conteudo,"DocumentacaoTraducoes"));
        } catch (java.io.IOException exc) {
            //Mensagem_Erro("Não foi possivel abrir o arquivo!","AVISO");
            //ExemploDeConteudo();
            //TxtScript.setEnabled(true);
            //CmbScript.setEnabled(true);
        }
    }
    
}
