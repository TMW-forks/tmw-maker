/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autocomplete;
import Classes.DialogClass;
import classes.FileClass;
import java.net.URISyntaxException;
import java.util.List;  
  
import com.thoughtworks.xstream.XStream;  
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
  
/**
 *
 * @author vanderson
 */
public class DocComando {
    XStream xstream = new XStream();  
      
    public List resgatarXML() throws URISyntaxException{
        /*O ARQUIVO COMANDOS.XML DEVE QUE ESTAR DO LADO DO .JAR, OU SEJA NA MESMA PASTA*/
        //File file = new File(DocComando.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().replaceAll("JQuestEdit.jar", "")+"comandos.xml");
        File file = null;
        String Endereco="";
        Endereco=DocComando.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().replaceAll("TMW-Maker.jar", "") + "comandos.xml";
        if(!FileClass.seExiste(Endereco)) Endereco="src/autocomplete/comandos.xml"; //vai buscar o arquivo comando na raiz do projeto. (Como uma segunda auternativa ao endereço não encontrado!)
        try {
            //PROBLEMA
            file = new File(Endereco);
            //Este comando file só funciona se o arquivo comando.xml estiver na pasta do .jar

            FileReader reader = new FileReader(file);
            BufferedReader leitor = new BufferedReader(reader);

            String linha = "";
            String linha1 = "";
            while ((linha1 = leitor.readLine()) != null) {
                linha = linha + linha1;
            }

            List comandos = (List) xstream.fromXML(linha);

            return comandos;
        } catch (Exception ioe) {
            DialogClass.showErro(
                "<HTML>O autocompletar da janela Palco só funcionará com o arquivo: \n"+Endereco,
                "ERRO DE COMANDO AUTOCOMPLETAR"
            );
            List<Comandos> list = new ArrayList<Comandos>();

            list.add(new Comandos());

            return list;
        }
        
    }
}
