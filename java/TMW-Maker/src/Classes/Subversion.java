package Classes;
import java.io.File;
import org.tmatesoft.svn.core.*;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.wc.*;

/**
 * @author Ablankzin(Romulo Pires <romulo.pires123@gmail.com>)
 * @param Data 22-08-2010 23:26:28
 */


public class Subversion {
    public static String darCheckout(String urlRepositorio,String pastaDestino) {
        return darCheckout(urlRepositorio,pastaDestino,"HEAD","","");
    }
    public static String darCheckout(String urlRepositorio,String pastaDestino,String Revisao) {
        return darCheckout(urlRepositorio,pastaDestino,Revisao,"","");
    }
    public static String darCheckout(String urlRepositorio,String pastaDestino,String Revisao,String Usuario,String Senha) {
        if(urlRepositorio.trim().equals("")) urlRepositorio="https://127.0.0.1/svn/Example/exemplo/";
        if(pastaDestino.trim().equals("")) pastaDestino="~/Desktop/wiki";
        if(Revisao.trim().equals("")) Revisao="HEAD";
        //if(Usuario.trim().equals("")) Usuario="user";
        //if(Senha.trim().equals("")) Senha="pass";


        try {
            //Diz que ira usar um reposit�rio com http:// ou https://
            DAVRepositoryFactory.setup();
            //Cria a url
            SVNURL url = SVNURL.parseURIEncoded(urlRepositorio);
            //Aqui vai o caminho da pasta onde ele vai baixar
            //ele esta baixando na raiz do projeto
            File dst = new File(pastaDestino);


            //Instancia o Objeto ClientManager
            SVNClientManager clm = SVNClientManager.newInstance();

            if(!Usuario.trim().equals("") && !Senha.trim().equals("")){
                //Cria autentica��o
                ISVNAuthenticationManager authManager = new BasicAuthenticationManager(Usuario, Senha);
                //Seta no cliente o metodo de autentica��o criado anteriormente
                clm.setAuthenticationManager(authManager);
            }
            
            //Diz qual revis�o ser� baixada
            //HEAD � a revis�o mais nova
            SVNRevision revision = SVNRevision.parse(Revisao);
            //esecuta o checkout e tamb�m pega o numero da revis�o que foi baixada!
            long rev = clm.getUpdateClient().doCheckout(url, dst, revision, revision, true);
            //System.err.println();
            return "Revis�o "+rev+" concluida com sucesso!";
        } catch (SVNException e) {
            //e.printStackTrace();
            return e.getErrorMessage().getFullMessage();
        }
    }
    public static String darCommit(String urlRepositorio,String pastaOrigem,String Usuario,String Senha,String Mensagem) {
        if(urlRepositorio.trim().equals("")) urlRepositorio="https://127.0.0.1/svn/Example/exemplo/";
        if(pastaOrigem.trim().equals("")) pastaOrigem="~/Desktop/wiki";
        if(Usuario.trim().equals("")) Usuario="user";
        if(Senha.trim().equals("")) Senha="pass";

        try {
            //Diz que ira usar um reposit�rio com http:// ou https://
            DAVRepositoryFactory.setup();
            //Instancia o Objeto ClientManager
            SVNClientManager clm = SVNClientManager.newInstance();

            //Cria autentica��o
            ISVNAuthenticationManager authManager = new BasicAuthenticationManager(Usuario, Senha);
            //Seta no cliente o metodo de autentica��o criado anteriormente
            clm.setAuthenticationManager(authManager);

            //Cria a url
            SVNURL url = SVNURL.parseURIEncoded(urlRepositorio);
            //Cria repositorio
            clm.createRepository(url, true);

            //Aqui vai o caminho da pasta onde ele vai baixar
            //ele esta baixando na raiz do projeto
            //Para funcionar esse diretorio tem que ter sido alvo de um checkout
            //Aqui ele exige um vetor do tipo File
            //como eu queria uma coisa pratica eu coloquei um vetor com apenas um elemento
            File[] Capsula = new File[1];
            Capsula[0] = new File(pastaOrigem);

            //Prepara o diretorio para dar o commit
            //esse era a pe�a chave do meu problema auehiuhae
            SVNWCClient wcClient = new SVNWCClient(authManager, null);
            wcClient.doAdd(Capsula[0], true, false, false, SVNDepth.INFINITY, false, false, false);

            //da o commit juntamente com isso ele pega o numero da nova revis�o
            //se n�o forem feitas altera��es ele retorna -1, se forem feitas altera��es ele retorna a nova revis�o
            //o "a" � a msg que vai aparecer como msg das altera��es
            //System.err.println();
            return "Nova Revis�o: " + clm.getCommitClient().doCommit(Capsula, false, Mensagem, null, null, false, true, SVNDepth.INFINITY).getNewRevision();
        } catch (SVNException e) {
            //e.printStackTrace();
            return e.getErrorMessage().getFullMessage();
        }
    }
}
