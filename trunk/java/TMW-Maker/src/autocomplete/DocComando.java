/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autocomplete;
import java.net.URISyntaxException;
import java.util.List;  
  
import com.thoughtworks.xstream.XStream;  
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
  
/**
 *
 * @author vanderson
 */
public class DocComando {
    XStream xstream = new XStream();  
      
    public List resgatarXML() throws URISyntaxException{
       
        /*O ARQUIVO COMANDOS.XML DEVE QUE ESTAR DO LADO DO .JAR, OU SEJA NA MESMA PASTA*/
        //File file = new File(DocComando.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().replaceAll("JQuestEdit.jar", "")+"comandos.xml");
      File file =null;


      
        try {
            //PROBLEMA
             file = new File(DocComando.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().replaceAll("TMW-Maker.jar", "")+"comandos.xml");
             //Este comando file só funciona se o arquivo comando.xml estiver na pasta do .jar
             
             FileReader reader = new FileReader(file);  
               BufferedReader leitor = new BufferedReader(reader);  
               
            String linha = "";  
            String linha1="";
            while((linha1 = leitor.readLine())!=null) {  
                linha = linha+linha1;
            }  
            
            List comandos = (List) xstream.fromXML(linha);  

            return comandos;
        } catch (Exception ioe) {
            System.out.println("Bug na leitura "+ioe+"\n\n"+file.getAbsolutePath()+"\n");
            return null;
        }
        
    }
}
