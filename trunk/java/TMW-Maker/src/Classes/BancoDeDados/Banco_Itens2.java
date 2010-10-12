package Classes.BancoDeDados;

import Classes.FileClass;
import Classes.DialogClass;
import Classes.StringClass;
import Formularios.FrmPrincipal;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

//import Classes.FileClass;
import Classes.ImagemClass;
//import Formularios.FrmPrincipal;
import java.awt.image.BufferedImage;


public class Banco_Itens2 {
//####################### COSTRUTORES #########################################
    public Banco_Itens2() {AbrirItens();} // Só executa de for instaciado como objeto
//####################### PRIVADOS #########################################
    private static Dados_Item Itens[]; //Não deve ser instaciado agora!!!!
//####################### PUBLICOS #########################################
    public static String Barra = System.getProperty("file.separator");
    public static String PastaDeItens = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"items";
    public static String EnderecoItensXML = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"items.xml";
    public static String EnderecoItensTXT = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"db"+Barra+"item_db.txt";

    public void AbrirItens() {

        //String ConteudoTotal=ConfigClass.arquivoAbrir(EnderecoItensTXT);
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
            DialogClass.showErro("Não foi possivel abrir \""+EnderecoItensTXT+"\"!","AVISO");
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
            DialogClass.showErro("Não foi possivel abrir \""+EnderecoItensXML+"\"!","AVISO");
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
            Itens[l].setPrecoDeVenda(Integer.parseInt(PartesDaLinha[4].trim()));
            Itens[l].setPrecoDeCompra(Integer.parseInt(PartesDaLinha[5].trim()));
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


            Propriedades=ConteudoXML.extrairEntre("<item id=\""+PartesDaLinha[0].trim()+"\"", ">");
            Itens[l].setNomeTitulo(ConteudoXML.extrairEntre(Propriedades,"name=\"","\""));
            Itens[l].setDescricao(ConteudoXML.extrairEntre(Propriedades,"description=\"","\""));
            Itens[l].setPoderEfeito(ConteudoXML.extrairEntre(Propriedades,"effect=\"","\""));
            ParteDoIcone=ConteudoXML.extrairEntre(Propriedades,"image=\"","\"").split("\\|"); // Não é só "|" nem "\|", tem q ser "\\|"
            Itens[l].setIconePNG(ParteDoIcone[0]);
            if(ParteDoIcone.length==2) Itens[l].setIconeCor(ParteDoIcone[1]);
            Itens[l].setTipoNome(ConteudoXML.extrairEntre(Propriedades,"type=\"","\""));
        }
    }
    public void AbrirItens_deprecado() {
        //String ConteudoTotal=ConfigClass.arquivoAbrir(EnderecoItensTXT);
        StringClass ConteudoTotal = new StringClass();
        ConteudoTotal.setTesto(FileClass.arquivoAbrir(EnderecoItensXML));
        int Part01=0;
        StringClass ItemXML = new StringClass();
        Dados_Item ItensA[] = new Dados_Item[0];
        Dados_Item ItensB[] = null;
        String ID="",TipoNome="";
        do{
            Part01=ConteudoTotal.getTesto().indexOf("<item ", Part01+ItemXML.getTesto().length());
            if(Part01>=0){
                ItemXML.setTesto(ConteudoTotal.extrairEntre("<item ", "</item>",Part01));
                ItensB = new Dados_Item[ItensA.length+1];
                ID=ItemXML.extrairEntre("id=\"", "\"");
                TipoNome=ItemXML.extrairEntre("type=\"", "\"");
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
    public Vector getIDs() {
        Vector Lista = new Vector();
        for(int I=0;I<getContItens();I++){
            Lista.addElement(Itens[I].getID());
        }
        return Lista;
    }
    public Dados_Item[] getItens() {return Itens;}
    public Vector getReferencias() {
        Vector Lista = new Vector();
        for(int I=0;I<getContItens();I++){
            Lista.addElement(Itens[I].getID()+": "+Itens[I].getNomeTitulo());
        }
        return Lista;
    }
    public Vector getTitutos() {
        Vector Lista = new Vector();
        for(int I=0;I<getContItens();I++){
            Lista.addElement("<html>"+
                "<table><tr><td><img align=\"middle\" src=\"file://"+
                    Itens[I].getIconeEndereco()+
                "\"></td><td>"+
                    "<b>"+Itens[I].getID()+":</b> "+Itens[I].getNomeTitulo()+"<br/>"+
                    "<small>"+
                    "V:"+Itens[I].getPrecoDeVenda()+"GP "+
                    "C:"+Itens[I].getPrecoDeCompra()+"GP "+
                    "("+Itens[I].getPoderEfeito()+")"+
                    "</small>"+
                "</td></tr></table>"
            );
        }
        return Lista;
    }
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
    public void addMonstro(Dados_Item Item){
        if(Itens != null){
            Dados_Item novosItens[] = new Dados_Item[getContItens()+1];
            for(int b=0;b<getContItens();b++){
                novosItens[b]=getItemPorOrdem(b);
            }
            novosItens[getContItens()] = Item;
            Itens = novosItens;
        }else{
            Dados_Item novosItens[] = new Dados_Item[1];
            novosItens[0] = Item;
            Itens = novosItens;
        }
    }
    public void addMonstro(int novoID, String novoNomeTitulo, String novoNomeSumonico){
        if(Itens != null){
            Dados_Item novosItens[] = new Dados_Item[getContItens()+1];
            for(int b=0;b<getContItens();b++){
                novosItens[b]=getItemPorOrdem(b);
            }
            novosItens[getContItens()] = new Dados_Item(novoID, novoNomeTitulo, novoNomeSumonico);
            Itens = novosItens;
        }else{
            Dados_Item novosItens[] = new Dados_Item[1];
            novosItens[0] = new Dados_Item(novoID, novoNomeTitulo, novoNomeSumonico);
            Itens = novosItens;
        }
    }
//##########################################################################
    public class Dados_Item {
        public Dados_Item(){ }
        public Dados_Item(int novoID, String novoNomeTitulo, String novoNomeSumonico){
            ID = novoID;
            NomeSumonico = novoNomeTitulo;
            NomeTitulo = novoNomeSumonico; //"name" em item.xml
        }
        //private static String Barra = System.getProperty("file.separator");
        //private static String PastaDeItens = FrmPrincipal.Config.getConexaoLocalhost() + Barra + "tmwdata" + Barra + "graphics" + Barra + "items";
        private int ID = 0;
        private String NomeSumonico = "";
        private String NomeTitulo = ""; //"name" em item.xml
        private String Descricao = ""; //"description" em item.xml
        private String IconePNG = ""; //"image" em item.xml
        private String IconeCor = ""; //"image" em item.xml
        private String Sprite = ""; //item.xml
        private String AudiosTipos = ""; //"sound event" em item.xml
        private String AudiosOGGs = ""; //"sound" em item.xml
        private String TipoNome = ""; //"Type" em item.xml
        private int TipoObjeto = 0; // 0:Healing, 2:Usable, 3:Misc, 4:Weapon, 5:Armor, 6:Card, 7:Pet egg, 8:petequip, 10:arrow,
        //11:Usable with delayed consumption (all items with script "pet" or "itemskill": Lures, Scrolls, Magnifier, Yggdrasil Leaf)
        private String AnimacaoNome = ""; //"weapon-type" em item.xml
        private int AnimacaoNumero = 0; //"weapon_type" em item.xml
        //OBS: "weapon-type" é diferente de "weapon_type"
        private int PrecoDeCompra = 0; //Price/Buy
        private int PrecoDeVenda = 0; //Sell
        private int Peso = 0; //Width
        private int PoderAtaque = 0;
        private int PoderDefesa = 0;
        private int PoderAlcance = 0; //Range
        private int PoderBonusMagico = 0; //MBonus
        private int PoderHP = 0; //"HP" em item.xml
        private String PoderEfeito = ""; //"effect" em item.xml
        private int OcupacaoDeLote = 0; //Slot (Quanto espaço ocupa em um único Lote que é espaço ocupado por de ícone)
        private int Trabalho = 0; // Job
        private int Genero = 2; //Sexo
        private int LocalEquipavel = 0;
        // 1: Pernas(Calças), 2: MãoDireita(Arma), 4: Mãos(Luvas), 16: Torso1(Limalhas),
        // 32: MãoEsqueda(Escudo), 64: Pés(Sapatos), 128: Acessórios, 256: Cabeça(Chapeus),
        // 512: Torso2(Armaduras)
        //        OBS:  Se quise ocupar as 2 mãos(MãoDireita[2] + MãoEsqueda[32] ponha 2+32="34")
        //        DÚVIDA: Pq o nº8 e o nº16 não estão sendo usados em nada?
        private int PoderRefinavel = 0; //Refinamento(wLV): O nível de refinamento da arma. Pode ser 0, 1, 2, 3 ou 4 por padrão.
        private int PoderElemental = 0; //Elements(eLV): 0:Nada, 1:Água, 2:Terra, 3:Fogo, 4:Vento, 5:Veneno, 6:Sagrado, 7:Escuridão, 8:Percepção, 9:Imortalidade
        private int Aparencia = 0; //Aparencia(View): Número da imagem que irá aparecer no inventário. (Não é usado no TMW. Padrão é "")
        private String ScriptAoConsulmir = "";
        private String ScriptAoEquipar = "";

        /************************************************************
         * Propriedades desconhecidas de item.xml
         ************************************************************
         * attack-min="8"
         * attack-delta="2"
         * attack-target="multi"
         * attack-shape="cone"
         * attack-range="32"
         * attack-angle="135"
         * view="521"
         ************************************************************
         * OBSSERVAÇÃO: Estas propriedades foram ignoradas nesta
         * classe, talves mais tarde sejam adicionadas.
         ************************************************************
         */
        public void setID(int NovoID) {ID = NovoID;}
        public void setNomeSumonico(String NovoNomeSumonico) {NomeSumonico = NovoNomeSumonico.toString();}
        public void setNomeTitulo(String NovoNomeTitulo) {NomeTitulo = NovoNomeTitulo.toString();}
        public void setDescricao(String NovoDescricao) {Descricao = NovoDescricao.toString();}
        public void setIconePNG(String NovoIconePNG) {IconePNG = NovoIconePNG.toString();}
        public void setIconeCor(String NovoIconeCor) {IconeCor = NovoIconeCor.toString();}
        public void setSprite(String NovoSprite) {Sprite = NovoSprite.toString();}
        public void setAudiosTipos(String NovoAudiosTipos) {AudiosTipos = NovoAudiosTipos.toString();}
        public void setAudiosOGGs(String NovoAudiosOGGs) {AudiosOGGs = NovoAudiosOGGs.toString();}
        public void setTipoNome(String NovoTipoNome) {TipoNome = NovoTipoNome.toString();}
        public void setTipoObjeto(int NovoTipoObjeto) {TipoObjeto = NovoTipoObjeto;}
        public void setAnimacaoNumero(int NovoAnimacaoNumero) {AnimacaoNumero = NovoAnimacaoNumero;}
        public void setAnimacaoNome(String NovoAnimacaoNome) {AnimacaoNome = NovoAnimacaoNome.toString();}
        public void setPrecoDeCompra(int NovoPrecoDeCompra) {PrecoDeCompra = NovoPrecoDeCompra;}
        public void setPrecoDeVenda(int NovoPrecoDeVenda) {PrecoDeVenda = NovoPrecoDeVenda;}
        public void setPeso(int NovoPeso) {Peso = NovoPeso;}
        public void setPoderAtaque(int NovoPoderAtaque) {PoderAtaque = NovoPoderAtaque;}
        public void setPoderDefesa(int NovoPoderDefesa) {PoderDefesa = NovoPoderDefesa;}
        public void setPoderAlcance(int NovoPoderAlcance) {PoderAlcance = NovoPoderAlcance;}
        public void setPoderBonusMagico(int NovoBonusMagico) {PoderBonusMagico = NovoBonusMagico;}
        public void setPoderHP(int NovoPoderHP) {PoderHP = NovoPoderHP;}
        public void setPoderEfeito(String NovoPoderEfeito) {PoderEfeito = NovoPoderEfeito.toString();}
        public void setOcupacaoDeLote(int NovoOcupacaoDeLote) {OcupacaoDeLote = NovoOcupacaoDeLote;}
        public void setTrabalho(int NovoTrabalho) {Trabalho = NovoTrabalho;}
        public void setGenero(int NovoGenero) {Genero = NovoGenero;}
        public void setLocalEquipavel(int NovoLocalEquipavel) {LocalEquipavel = NovoLocalEquipavel;}
        public void setPoderRefinavel(int NovoPoderRefinavel) {PoderRefinavel = NovoPoderRefinavel;}
        public void setPoderElemental(int NovoPoderElemental) {PoderElemental = NovoPoderElemental;}
        public void setAparencia(int NovoAparencia) {Aparencia = NovoAparencia;}
        public void setScriptAoConsulmir(String NovoScriptAoConsulmir) {ScriptAoConsulmir = NovoScriptAoConsulmir.toString();}
        public void setScriptAoEquipar(String NovoScriptAoEquipar) {ScriptAoEquipar = NovoScriptAoEquipar.toString();}

        public int getID() {return ID;}
        public String getNomeSumonico() {return NomeSumonico.toString();}
        public String getNomeTitulo() {return NomeTitulo.toString();}
        public String getDescricao() {return Descricao.toString();}
        public String getIconePNG() {return IconePNG.toString();}
        public String getIconePasta() {return PastaDeItens;}
        public String getIconeEndereco() {return PastaDeItens + Barra + IconePNG;}
        public BufferedImage getIconeImagem() {
            if (FileClass.seExiste(PastaDeItens + Barra + IconePNG)) {
                ImagemClass Imagem = new ImagemClass(PastaDeItens + Barra + IconePNG);
                return Imagem.getImage();
            }
            return null;
        }
        public String getIconeCor() {return IconeCor.toString();}
        public String getSprite() {return Sprite.toString();}
        public String getAudiosTipos() {return AudiosTipos.toString();}
        public String getAudiosOGGs() {return AudiosOGGs.toString();}
        public String getTipoNome() {return TipoNome.toString();        }
        public int getTipoObjeto() {return TipoObjeto;}
        public String getAnimacaoNome() {return AnimacaoNome.toString();}
        public int getAnimacaoNumero() {return AnimacaoNumero;}
        public int getPrecoDeCompra() {return PrecoDeCompra;}
        public int getPrecoDeVenda() {return PrecoDeVenda;}
        public int getPeso() {return Peso;}
        public int getPoderAtaque() {return PoderAtaque;}
        public int getPoderDefesa() {return PoderDefesa;}
        public int getPoderAlcance() {return PoderAlcance;}
        public int getPoderBonusMagico() {return PoderBonusMagico;}
        public int getPoderHP() {return PoderHP;}
        public String getPoderEfeito() {return PoderEfeito.toString();}
        public int getOcupacaoDeLote() {return OcupacaoDeLote;}
        public int getTrabalho() {return Trabalho;}
        public int getGenero() {return Genero;}
        public int getLocalEquipavel() {return LocalEquipavel;}
        public int getPoderRefinavel() {return PoderRefinavel;}
        public int getPoderElemental() {return PoderElemental;}
        public int getAparencia() {return Aparencia;}
        public String getScriptAoConsulmir() {return ScriptAoConsulmir.toString();}
        public String getScriptAoEquipar() {return ScriptAoEquipar.toString();}
    }
}
