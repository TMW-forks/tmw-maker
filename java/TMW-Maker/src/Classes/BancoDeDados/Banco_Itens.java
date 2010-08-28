package Classes.BancoDeDados;

import Classes.ConfigClass;
import Classes.StringClass;
import Formularios.FrmPrincipal;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Banco_Itens {
//####################### COSTRUTORES #########################################
    public Banco_Itens() {AbrirItens();} // Só executa de for instaciado como objeto
//####################### PRIVADOS #########################################
    private static Dados_Item Itens[]; //Não deve ser instaciado agora!!!!
//####################### PUBLICOS #########################################
    public static String Barra = System.getProperty("file.separator");
    public static String PastaDeItens = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"items";
    public static String EnderecoItensXML = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"items.xml";
    public static String EnderecoItensTXT = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"db"+Barra+"item_db.txt";
    public Dados_Item[] getItens() {return Itens;}
    public Dados_Item getItemPorOrdem(int Ordem) {return Itens[Ordem];}
    public Dados_Item getItemPorID(int ID) {
        for(int i=0;i<Itens.length;i++){
            if(Itens[i].getID()==ID) return Itens[i];
        }
        return null;
    }
    public int getContItens() {
        try{
            return Itens.length;
        }catch(Exception e){
            return 0;
        }
    }
    public void AbrirItens() {

        //String ConteudoTotal=ConfigClass.ArquivoAbrir(EnderecoItensTXT);
        String ConteudoTXT="";
        String Linha="", PartesDaLinha[]=null;
        try {
            FileInputStream stream = new FileInputStream(EnderecoItensTXT);
            InputStreamReader streamReader = new InputStreamReader(stream,"UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);
            while ((Linha = reader.readLine()) != null) {
                PartesDaLinha=Linha.split(",");
                if(
                    PartesDaLinha.length>=19 &&
                    !PartesDaLinha[0].equals("0") &&
                    !Linha.substring(0, 1).trim().equals("#") &&
                    !Linha.substring(0, 2).trim().equals("//")
                ){
                    if(!ConteudoTXT.equals("")){
                        ConteudoTXT=ConteudoTXT+"\n"+Linha;
                    }else{
                        ConteudoTXT=Linha;
                    }

                }
            }
            reader.close();
            streamReader.close();
            stream.close();
        } catch (IOException ex) {
            ConfigClass.Mensagem_Erro("Não foi possivel abrir \""+EnderecoItensTXT+"\"!","AVISO");
            return; // em caso de falha
        }/**/

        StringClass ConteudoXML = new StringClass();
        try {
            FileInputStream stream = new FileInputStream(EnderecoItensXML);
            InputStreamReader streamReader = new InputStreamReader(stream,"UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);
            while ((Linha = reader.readLine()) != null) {
                ConteudoXML.setTesto(ConteudoXML.getTesto()+"\n"+Linha);
            }
            reader.close();
            streamReader.close();
            stream.close();
        } catch (IOException ex) {
            ConfigClass.Mensagem_Erro("Não foi possivel abrir \""+EnderecoItensXML+"\"!","AVISO");
            return; // em caso de falha
        }

        String Linhas[]=ConteudoTXT.trim().split("\n");
        Itens = new Dados_Item[Linhas.length];
        Object[] ComboIDs=new java.lang.Object[Linhas.length];
        int Tag1=-1, Tag2=-1; String Script="";
        int Loc=0;
        String Propriedades="",ParteDoIcone[]=null;
        for(int l=0;l<Linhas.length;l++){
            Linha=Linhas[l];
            PartesDaLinha=Linha.split(",");
            ComboIDs[l] = new Object();
            ComboIDs[l] = PartesDaLinha[0];
            Itens[l] = new Dados_Item();
            Itens[l].setID(Integer.parseInt(PartesDaLinha[0].trim()));
            Itens[l].setNomeSumonico(PartesDaLinha[1].trim());
            Itens[l].setNomeTitulo(PartesDaLinha[2].trim());
            Itens[l].setTipoObjeto(Integer.parseInt(PartesDaLinha[3].trim()));
            Itens[l].setPrecoDeCompra(Integer.parseInt(PartesDaLinha[4].trim()));
            Itens[l].setPrecoDeVenda(Integer.parseInt(PartesDaLinha[5].trim()));
            Itens[l].setPeso(Integer.parseInt(PartesDaLinha[6].trim()));

            if(!PartesDaLinha[7].toString().equals("")) Itens[l].setPoderAtaque(Integer.parseInt(PartesDaLinha[7].trim()));
            if(!PartesDaLinha[8].toString().equals("")) Itens[l].setPoderDefesa(Integer.parseInt(PartesDaLinha[8].toString()));
            if(!PartesDaLinha[9].toString().equals("")) Itens[l].setPoderAlcance(Integer.parseInt(PartesDaLinha[9].trim()));
            if(!PartesDaLinha[10].toString().equals("")) Itens[l].setPoderBonusMagico(Integer.parseInt(PartesDaLinha[10].trim()));
            if(!PartesDaLinha[11].toString().equals("")) Itens[l].setOcupacaoDeLote(Integer.parseInt(PartesDaLinha[11].trim()));
            if(!PartesDaLinha[12].toString().equals("")) Itens[l].setGenero(Integer.parseInt(PartesDaLinha[12].trim()));
            if(!PartesDaLinha[13].toString().equals("")) Itens[l].setLocalEquipavel(Integer.parseInt(PartesDaLinha[13].trim()));
            if(!PartesDaLinha[14].toString().equals("")) Itens[l].setPoderRefinavel(Integer.parseInt(PartesDaLinha[14].trim()));
            if(!PartesDaLinha[15].toString().equals("")) Itens[l].setPoderElemental(Integer.parseInt(PartesDaLinha[15].trim()));
            if(!PartesDaLinha[16].toString().equals("")) Itens[l].setAparencia(Integer.parseInt(PartesDaLinha[16].trim()));

            Tag1=Linha.indexOf("{",0); Tag2=Linha.indexOf("},{",Tag1+1);
            if(Tag1 >= 0 && Tag2 >= 0 && Tag2 >= Tag1) Itens[l].setScriptAoConsulmir(Linha.substring(Tag1+1, Tag2).trim());
            Tag1=Linha.indexOf("},{",0); Tag2=Linha.indexOf("}",Tag1+3);
            if(Tag1>=0 && Tag2>=0 && Tag2>=Tag1) Itens[l].setScriptAoEquipar(Linha.substring(Tag1+3, Tag2).trim());


            Propriedades=ConteudoXML.ExtrairEntre("<item id=\""+PartesDaLinha[0].trim()+"\"", ">");
            Itens[l].setNomeTitulo(ConteudoXML.ExtrairEntre(Propriedades,"name=\"","\""));
            Itens[l].setDescricao(ConteudoXML.ExtrairEntre(Propriedades,"description=\"","\""));
            Itens[l].setPoderEfeito(ConteudoXML.ExtrairEntre(Propriedades,"effect=\"","\""));
            ParteDoIcone=ConteudoXML.ExtrairEntre(Propriedades,"image=\"","\"").split("\\|"); // Não é só "|" nem "\|", tem q ser "\\|"
            Itens[l].setIconePNG(ParteDoIcone[0]);
            if(ParteDoIcone.length==2) Itens[l].setIconeCor(ParteDoIcone[1]);
            Itens[l].setTipoNome(ConteudoXML.ExtrairEntre(Propriedades,"type=\"","\""));
        }
    }
    public void AbrirItens_deprecado() {
        //String ConteudoTotal=ConfigClass.ArquivoAbrir(EnderecoItensTXT);
        StringClass ConteudoTotal = new StringClass();
        ConteudoTotal.setTesto(ConfigClass.ArquivoAbrir(EnderecoItensXML));
        int Part01=0;
        StringClass ItemXML = new StringClass();
        Dados_Item ItensA[] = new Dados_Item[0];
        Dados_Item ItensB[] = null;
        String ID="",TipoNome="";
        do{
            Part01=ConteudoTotal.getTesto().indexOf("<item ", Part01+ItemXML.getTesto().length());
            if(Part01>=0){
                ItemXML.setTesto(ConteudoTotal.ExtrairEntre("<item ", "</item>",Part01));
                ItensB = new Dados_Item[ItensA.length+1];
                ID=ItemXML.ExtrairEntre("id=\"", "\"");
                TipoNome=ItemXML.ExtrairEntre("type=\"", "\"");
                if(!ID.equals("")){
                    ItensB[ItensA.length] = new Dados_Item();
                    ItensB[ItensA.length].setID(Integer.parseInt(ID));
                    ItensB[ItensA.length].setTipoNome(TipoNome);
                }
                ItensA = new Dados_Item[ItensB.length];
                ItensA = ItensB;
            }
        }while(Part01>=0);
        Itens = new Dados_Item[ItensA.length];
        Itens=ItensA;

        

        

        
    }
//##########################################################################
}
