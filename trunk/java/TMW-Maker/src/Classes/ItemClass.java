package Classes;

public class ItemClass {

    private int ID=0;
    private String NomeSumonico="";
    private String NomeTitulo=""; //"name" em item.xml
    private String Descricao=""; //"description" em item.xml
    private String IconePNG=""; //"image" em item.xml
    private String IconeCor=""; //"image" em item.xml
    private String Sprite=""; //item.xml
    private String AudiosTipos=""; //"sound event" em item.xml
    private String AudiosOGGs=""; //"sound" em item.xml
    private String TipoNome=""; //"Type" em item.xml
    private int TipoObjeto=0; // 0:Healing, 2:Usable, 3:Misc, 4:Weapon, 5:Armor, 6:Card, 7:Pet egg, 8:petequip, 10:arrow,
    //11:Usable with delayed consumption (all items with script "pet" or "itemskill": Lures, Scrolls, Magnifier, Yggdrasil Leaf)
    private String AnimacaoNome=""; //"weapon-type" em item.xml
    private int AnimacaoNumero=0; //"weapon_type" em item.xml
    //OBS: "weapon-type" é diferente de "weapon_type"
    private int PrecoDeCompra=0; //Price/Buy
    private int PrecoDeVenda=0; //Sell
    private int Peso=0; //Width
    private int PoderAtaque=0;
    private int PoderDefesa=0;
    private int PoderAlcance=0; //Range
    private int PoderBonusMagico=0; //MBonus
    private int PoderHP=0; //"HP" em item.xml
    private String PoderEfeito=""; //"effect" em item.xml
    private int OcupacaoDeLote=0; //Slot (Quanto espaço ocupa em um único Lote que é espaço ocupado por de ícone)
    private int Trabalho=0; // Job
    private int Genero=2; //Sexo
    private int LocalEquipavel=0;
        // 1: Pernas(Calças), 2: MãoDireita(Arma), 4: Mãos(Luvas), 16: Torso1(Limalhas),
        // 32: MãoEsqueda(Escudo), 64: Pés(Sapatos), 128: Acessórios, 256: Cabeça(Chapeus),
        // 512: Torso2(Armaduras)
        //        OBS:  Se quise ocupar as 2 mãos(MãoDireita[2] + MãoEsqueda[32] ponha 2+32="34")
        //        DÚVIDA: Pq o nº8 e o nº16 não estão sendo usados em nada?
    private int PoderRefinavel=0; //Refinamento(wLV): O nível de refinamento da arma. Pode ser 0, 1, 2, 3 ou 4 por padrão.
    private int PoderElemental=0; //Elements(eLV): 0:Nada, 1:Água, 2:Terra, 3:Fogo, 4:Vento, 5:Veneno, 6:Sagrado, 7:Escuridão, 8:Percepção, 9:Imortalidade
    private int Aparencia=0; //Aparencia(View): Número da imagem que irá aparecer no inventário. (Não é usado no TMW. Padrão é "")
    private String ScriptAoConsulmir="";
    private String ScriptAoEquipar="";

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

    public void setID(int NovoID){ID=NovoID;}
    public void setNomeSumonico(String NovoNomeSumonico){NomeSumonico=NovoNomeSumonico.toString();}
    public void setNomeTitulo(String NovoNomeTitulo){NomeTitulo=NovoNomeTitulo.toString();}
    public void setDescricao(String NovoDescricao){Descricao=NovoDescricao.toString();}
    public void setIconePNG(String NovoIconePNG){IconePNG=NovoIconePNG.toString();}
    public void setIconeCor(String NovoIconeCor){IconeCor=NovoIconeCor.toString();}
    public void setSprite(String NovoSprite){Sprite=NovoSprite.toString();}
    public void setAudiosTipos(String NovoAudiosTipos){AudiosTipos=NovoAudiosTipos.toString();}
    public void setAudiosOGGs(String NovoAudiosOGGs){AudiosOGGs=NovoAudiosOGGs.toString();}
    public void setTipoNome(String NovoTipoNome){TipoNome=NovoTipoNome.toString();}
    public void setTipoObjeto(int NovoTipoObjeto){TipoObjeto=NovoTipoObjeto;}
    public void setAnimacaoNumero(int NovoAnimacaoNumero){AnimacaoNumero=NovoAnimacaoNumero;}
    public void setAnimacaoNome(String NovoAnimacaoNome){AnimacaoNome=NovoAnimacaoNome.toString();}
    public void setPrecoDeCompra(int NovoPrecoDeCompra){PrecoDeCompra=NovoPrecoDeCompra;}
    public void setPrecoDeVenda(int NovoPrecoDeVenda){PrecoDeVenda=NovoPrecoDeVenda;}
    public void setPeso(int NovoPeso){Peso=NovoPeso;}
    public void setPoderAtaque(int NovoPoderAtaque){PoderAtaque=NovoPoderAtaque;}
    public void setPoderDefesa(int NovoPoderDefesa){PoderDefesa=NovoPoderDefesa;}
    public void setPoderAlcance(int NovoPoderAlcance){PoderAlcance=NovoPoderAlcance;}
    public void setPoderBonusMagico(int NovoBonusMagico){PoderBonusMagico=NovoBonusMagico;}
    public void setPoderHP(int NovoPoderHP){PoderHP=NovoPoderHP;}
    public void setPoderEfeito(String NovoPoderEfeito){PoderEfeito=NovoPoderEfeito.toString();}
    public void setOcupacaoDeLote(int NovoOcupacaoDeLote){OcupacaoDeLote=NovoOcupacaoDeLote;}
    public void setTrabalho(int NovoTrabalho){Trabalho=NovoTrabalho;}
    public void setGenero(int NovoGenero){Genero=NovoGenero;}
    public void setLocalEquipavel(int NovoLocalEquipavel){LocalEquipavel=NovoLocalEquipavel;}
    public void setPoderRefinavel(int NovoPoderRefinavel){PoderRefinavel=NovoPoderRefinavel;}
    public void setPoderElemental(int NovoPoderElemental){PoderElemental=NovoPoderElemental;}
    public void setAparencia(int NovoAparencia){Aparencia=NovoAparencia;}
    public void setScriptAoConsulmir(String NovoScriptAoConsulmir){ScriptAoConsulmir=NovoScriptAoConsulmir.toString();}
    public void setScriptAoEquipar(String NovoScriptAoEquipar){ScriptAoEquipar=NovoScriptAoEquipar.toString();}

    public int getID(){return ID;}
    public String getNomeSumonico(){return NomeSumonico.toString();}
    public String getNomeTitulo(){return NomeTitulo.toString();}
    public String getDescricao(){return Descricao.toString();}
    public String getIconePNG(){return IconePNG.toString();}
    public String getIconeCor(){return IconeCor.toString();}
    public String getSprite(){return Sprite.toString();}
    public String getAudiosTipos(){return AudiosTipos.toString();}
    public String getAudiosOGGs(){return AudiosOGGs.toString();}
    public String getTipoNome(){return TipoNome.toString();}
    public int getTipoObjeto(){return TipoObjeto;}
    public String getAnimacaoNome(){return AnimacaoNome.toString();}
    public int getAnimacaoNumero(){return AnimacaoNumero;}
    public int getPrecoDeCompra(){return PrecoDeCompra;}
    public int getPrecoDeVenda(){return PrecoDeVenda;}
    public int getPeso(){return Peso;}
    public int getPoderAtaque(){return PoderAtaque;}
    public int getPoderDefesa(){return PoderDefesa;}
    public int getPoderAlcance(){return PoderAlcance;}
    public int getPoderBonusMagico(){return PoderBonusMagico;}
    public int getPoderHP(){return PoderHP;}
    public String getPoderEfeito(){return PoderEfeito.toString();}
    public int getOcupacaoDeLote(){return OcupacaoDeLote;}
    public int getTrabalho(){return Trabalho;}
    public int getGenero(){return Genero;}
    public int getLocalEquipavel(){return LocalEquipavel;}
    public int getPoderRefinavel(){return PoderRefinavel;}
    public int getPoderElemental(){return PoderElemental;}
    public int getAparencia(){return Aparencia;}
    public String getScriptAoConsulmir(){return ScriptAoConsulmir.toString();}
    public String getScriptAoEquipar(){return ScriptAoEquipar.toString();}

}
