
package Classes;

import Formularios.FrmPrincipal;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Banco_NPCs {
//####################### COSTRUTORES #########################################
    public Banco_NPCs() {AbrirGeral();} // Só executa de for instaciado como objeto
//####################### PRIVADOS #########################################
    private static Dados_NPC NPCs[]; //Não deve ser instaciado agora!!!!
    private SpriteDados getSpriteDeXML(String Endereco) {
        String Linha="";
        StringClass XML_Geral = new StringClass();
        try {
            FileInputStream stream = new FileInputStream(Endereco);
            InputStreamReader streamReader = new InputStreamReader(stream,"UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);
            while ((Linha = reader.readLine()) != null) {
                if(!Linha.equals("")){
                    XML_Geral.setTesto(XML_Geral.getTesto()+"\n"+Linha.trim());
                }
            }
            reader.close();
            streamReader.close();
            stream.close();
        } catch (IOException ex) {
            ConfigClass.Mensagem_Erro("Não foi possivel abrir \""+Endereco+"\"!","AVISO");
        }

        SpriteDados Sprite = new SpriteDados(FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+XML_Geral.ExtrairEntre("src=\"", "\""));
        Sprite.setSpriteColunas(Sprite.getSpriteLargura()/Integer.parseInt(XML_Geral.ExtrairEntre("width=\"", "\"")));
        Sprite.setSpriteLinhas(Sprite.getSpriteAltura()/Integer.parseInt(XML_Geral.ExtrairEntre("height=\"", "\"")));
        return Sprite;
    }
//####################### PUBLICOS #########################################
    public static String Barra = System.getProperty("file.separator");
    public static String EnderecoPastaDeSprites = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"sprites";
    public static String EnderecoXMLdeNPCs = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"npcs.xml";
    public void AbrirGeral() {
        String Linha="";
        StringClass XML_Geral = new StringClass();
        try {
            FileInputStream stream = new FileInputStream(EnderecoXMLdeNPCs);
            InputStreamReader streamReader = new InputStreamReader(stream,"UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);
            while ((Linha = reader.readLine()) != null) {
                if(Linha.indexOf("<npc ")>=0 && Linha.indexOf("id=\"")>=0 && Linha.indexOf("</npc>")>=0){
                    XML_Geral.setTesto(XML_Geral.getTesto()+"\n"+Linha.trim());
                }
            }
            reader.close();
            streamReader.close();
            stream.close();
        } catch (IOException ex) {
            ConfigClass.Mensagem_Erro("Não foi possivel abrir \""+EnderecoXMLdeNPCs+"\"!","AVISO");
            return; // em caso de falha
        }

        NPCs = new Dados_NPC[XML_Geral.getContLinhas()];
        StringClass NPC = new StringClass();
        int ContNPCs=0;
        for(int l=0;l<XML_Geral.getContLinhas();l++){
            NPC.setTesto(XML_Geral.getLinha(l));
            if(!NPC.getTesto().equals("")){
                ContNPCs++;
                NPCs[l-1] = new Dados_NPC();
                NPCs[l-1].setID(Integer.parseInt(NPC.ExtrairEntre("id=\"", "\"").equals("")?"0":NPC.ExtrairEntre("id=\"", "\"")));
                NPCs[l-1].setNome(NPC.ExtrairEntre("name=\"", "\""));
                NPCs[l-1].setVariante(Integer.parseInt(NPC.ExtrairEntre("variant=\"", "\"").equals("")?"0":NPC.ExtrairEntre("variant=\"", "\"")));
                NPCs[l-1].setXML(NPC.ExtrairEntre("<sprite variant=\""+NPCs[l-1].getVariante()+"\">", "</sprite>"));
                NPCs[l-1].setParticulaXML(NPC.ExtrairEntre("<particlefx>", "</particlefx>"));
                NPCs[l-1].setComentario(NPC.ExtrairEntre("<!--", "-->"));

                if(!NPCs[l-1].getXML().equals("") && FrmPrincipal.Config.SeExiste(EnderecoPastaDeSprites+Barra+NPCs[l-1].getXML())){
                    NPCs[l-1].setSprite(getSpriteDeXML(EnderecoPastaDeSprites+Barra+NPCs[l-1].getXML()));
                }
            }
        }

    }
    public int getContNPCs(){
        return NPCs.length;
    }
    public Dados_NPC getNPCporID(int ID){
        for(int n=0;n<NPCs.length;n++){
            if(NPCs[n].getID()==ID) return NPCs[n];
        }
        return null;
    }
    public Dados_NPC getNPCporOrdem(int Ordem){
        if(NPCs[Ordem]!=null) return NPCs[Ordem];
        return null;
    }
    public Dados_NPC[] getNPCs() {return NPCs;}
//##########################################################################
}
