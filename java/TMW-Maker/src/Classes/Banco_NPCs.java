
package Classes;

import Formularios.FrmPrincipal;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Banco_NPCs {
    public Banco_NPCs() {AbrirNPCs();} // Só executa de for instaciado como objeto

    public static String Barra = System.getProperty("file.separator");
    public static String EnderecoXMLdeNPCs = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"npcs.xml";

    public static Dados_NPC NPCs[]; //Não deve ser instaciado agora!!!!

    private void AbrirNPCs() {
        String Linha="";
        StringClass ConteudoXML = new StringClass();
        int ContNPCs=0;
        try {
            FileInputStream stream = new FileInputStream(EnderecoXMLdeNPCs);
            InputStreamReader streamReader = new InputStreamReader(stream,"UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);
            while ((Linha = reader.readLine()) != null) {
                if(Linha.indexOf("<npc ")>=0){
                    ConteudoXML.setTesto(ConteudoXML.getTesto()+"\n"+Linha.trim());
                    ContNPCs++;
                }
            }
            reader.close();
            streamReader.close();
            stream.close();
        } catch (IOException ex) {
            ConfigClass.Mensagem_Erro("Não foi possivel abrir \""+EnderecoXMLdeNPCs+"\"!","AVISO");
            return; // em caso de falha
        }

        NPCs = new Dados_NPC[ConteudoXML.getContLinhas()];
        StringClass XMLdeNPC = new StringClass();
        for(int l=0;l<ConteudoXML.getContLinhas();l++){
            XMLdeNPC.setTesto(ConteudoXML.getLinha(l));
            NPCs[l] = new Dados_NPC();
            NPCs[l].setID(Integer.parseInt(XMLdeNPC.ExtrairEntre("id=\"", "\"")));
            NPCs[l].setNome(XMLdeNPC.ExtrairEntre("name=\"", "\""));
            NPCs[l].setVariante(Integer.parseInt(XMLdeNPC.ExtrairEntre("variant=\"", "\"")));
            NPCs[l].setXML(XMLdeNPC.ExtrairEntre("<sprite variant=\""+NPCs[l].getVariante()+"\">", "</sprite>"));
            NPCs[l].setComentario(XMLdeNPC.ExtrairEntre("<!--", "-->"));

            

            
        }

    }
}
