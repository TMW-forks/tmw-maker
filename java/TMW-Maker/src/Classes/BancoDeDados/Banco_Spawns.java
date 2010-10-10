package Classes.BancoDeDados;

import Classes.FileClass;
import Classes.SpriteXML;
import Classes.StringClass;
import Formularios.FrmPrincipal;
import java.util.Vector;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Banco_Spawns {
    public Banco_Spawns() {
        abrirBanco(EnderecoTXT, EnderecoXML);
    }
    /*******************************************************************************************************
     * ID,Name,Jname,
     * LV,HP,SP,EXP,JEXP,
     * Range1,ATK1,ATK2,DEF,MDEF,
     * STR,AGI,VIT,INT,DEX,LUK,
     * Range2,Range3,Scale,Race,Element,Mode,Speed,Adelay,
     * Amotion,Dmotion,
     * Drop1id,Drop1per,Drop2id,Drop2per,Drop3id,Drop3per,Drop4id,Drop4per,Drop5id,Drop5per,Drop6id,Drop6per,Drop7id,Drop7per,Drop8id,Drop8per,
     * Item1,Item2,MEXP,ExpPer,MVP1id,MVP1per,MVP2id,MVP2per,MVP3id,MVP3per,mutation count,mutation strength
     *******************************************************************************************************/
    public static String Barra = System.getProperty("file.separator");
    public static String EnderecoTXT = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"db"+Barra+"mob_db.txt";
    public static String EnderecoXML = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"monsters.xml";
    public static String PastaDeSprites = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"sprites";

    private static Dados_Spawns Spawns[]=null;
    public void abrirBanco(String mobTXT, String mobXML){
        if(FileClass.seExiste(mobTXT) && FileClass.seExiste(mobXML)){
            StringClass ConteudoTXT = new StringClass(FileClass.arquivoAbrir(mobTXT));
            FrmPrincipal.PgbBarra.setIndeterminate(false);
            FrmPrincipal.PgbBarra.setEnabled(true);
            FrmPrincipal.PgbBarra.setMinimum(0);
            FrmPrincipal.PgbBarra.setValue(0);
            FrmPrincipal.PgbBarra.setMaximum(ConteudoTXT.getContLinhas()-1);
            for(int l=0;l<ConteudoTXT.getContLinhas();l++){
                FrmPrincipal.PgbBarra.setValue(l);
                FrmPrincipal.PgbBarra.setString((int)(((l+1)*100)/ConteudoTXT.getContLinhas())+"%");
                if(
                    !ConteudoTXT.getLinha(l).trim().equals("") &&
                    !ConteudoTXT.getLinha(l).trim().substring(0, 2).equals("//") &&
                    !ConteudoTXT.getLinha(l).trim().substring(0, 1).equals("#")
                ){
                    String Partes[]=ConteudoTXT.getLinha(l).trim().split(",");
                    if(Partes.length>=47){
                        addSpawn(
                            Integer.parseInt(Partes[0]),
                            Partes[1], Partes[2]
                        );
                        FrmPrincipal.setAvisoEmEstatus("<html>"+
                            "Carregando Monstro: \"<font color=\"#0000FF\">"+Partes[0]+": "+Partes[2]+"</font>\"!",
                            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_caveira.png"))
                        );
                        int c=3;
                        getSpawnPorOrdem(getContSpawns()-1).setNivel(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setHP(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setSP(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setExp(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setJob(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setRange1(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setAtaque1(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setAtaque2(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setDefesaFisica(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setDefesaMagica(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setEstatusForca(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setEstatusAgilidade(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setEstatusVitalidade(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setEstatusInteligencia(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setEstatusDestresa(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setEstatusSorte(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setRange2(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setRange3(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setScale(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setRace(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setElement(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setMode(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setSpeed(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setAdelay(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setAMotion(Integer.parseInt(Partes[c++]));
                        getSpawnPorOrdem(getContSpawns()-1).setDMotion(Integer.parseInt(Partes[c++]));

                        for(int d=29;d<=46;d+=2){
                            try{
                                if(Integer.parseInt(Partes[d+0])>0){
                                    getSpawnPorOrdem(getContSpawns()-1).addDrop(
                                        Integer.parseInt(Partes[d+0]),
                                        Integer.parseInt(Partes[d+1])
                                    );
                                }
                            }catch(NumberFormatException ex){ }
                        }

                        Element Elementos=FileClass.arquivoAbrirXML(mobXML);
                        NodeList noMonster = Elementos.getElementsByTagName("monster");
                        for (int Ms = (getContSpawns()-1); Ms < noMonster.getLength(); Ms++) {
                            Element tagMonster = (Element) noMonster.item(Ms);
                            if((FileClass.getAtributo(tagMonster,"id",-1)+1002)==getSpawnPorOrdem(getContSpawns()-1).getID()){
                                NodeList noSound = tagMonster.getElementsByTagName("sound");
                                for (int Sn = 0; Sn < noSound.getLength(); Sn++) {
                                    Element tagSound = (Element) noSound.item(Sn);
                                    getSpawnPorOrdem(getContSpawns()-1).addSom(
                                        FileClass.getAtributo(tagSound,"event",""),
                                        tagSound.getFirstChild().getTextContent()
                                    );
                                }

                                NodeList noSprite = tagMonster.getElementsByTagName("sprite");
                                for (int Sp = 0; Sp < noSprite.getLength(); Sp++) {
                                    Element tagSprite = (Element) noSprite.item(Sp);
                                    String Sexo=FileClass.getAtributo(tagSprite,"gender","");
                                    String Arquivo="", Recolor="";
                                    if(tagSprite.getFirstChild().getTextContent().indexOf("|")>=0){
                                        String Partes2[]=tagSprite.getFirstChild().getTextContent().split("\\|");
                                        if(Partes2.length==2){
                                            Arquivo=Partes2[0];
                                            Recolor=Partes2[1];
                                        }else if(Partes2.length>=3){
                                            Arquivo=Partes2[0];
                                        }
                                    }else{
                                        Arquivo=tagSprite.getFirstChild().getTextContent();
                                    }
                                    if(FileClass.seExiste(PastaDeSprites+Barra+Arquivo)){
                                        getSpawnPorOrdem(getContSpawns()-1).addSprite(Sexo,Arquivo,Recolor);
                                    }
                                }
                                Ms=noMonster.getLength();
                            }
                        }
                    }
                }
            }
        }
    }
    private String darCabecalhoMobTXT(){
        return
        "///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"+
        "//\n"+
        "//     ** ID,NomeSumonico,NomeTítulo,\n"+
        "//     ** LVL,HP,SP,EXP,JobEXP,\n"+
        "//     ** Alcance1,AtaqMin,AtaqMax,DEF,MagDEF,\n"+
        "//     ** Força,Agilidade,Vitalidade,Inteligência,Destresa,Sorte,\n"+
        "//     ** Alcance2,Alcance3,Escala,Raça,Elemento,Modo,Velocidade,IntervaloAtaque,\n"+
        "//     ** Amotion,Dmotion,\n"+
        "//     ** Drop1id,Drop1per,Drop2id,Drop2per,Drop3id,Drop3per,Drop4id,Drop4per,Drop5id,Drop5per,Drop6id,Drop6per,Drop7id,Drop7per,Drop8id,Drop8per,\n"+
        "//     ** Item1,Item2,MEXP,ExpPer,MVP1id,MVP1per,MVP2id,MVP2per,MVP3id,MVP3per,mutiation count,mutation strength\n"+
        "//\n"+
        "//		 * NomeSumonico: Sem espaço e nem caracteres especiais. Exemplo: \"CapitaoDaGuarda\"\n"+
        "//		 * NomeTítulo: Pode haver espaço e caracteres especiais noformato UTF-8. Exemplo: \"Capitão da Guarda\"\n"+
        "//		 * LVL: Qual o nível do monstros. Exemplo: É preferivel que Jogadores LVL30 enfrente Monstros LVL30.\n"+
        "//				  Monstros acima de nível maximo (LVL99) são BOSS.\n"+
        "//		 * HP: São os pontos de saúde do monstro.\n"+
        "//		 * SP: São os pontos de magia do monstro, que definem quantas vezes o monstro pode usar uma determinada magia.\n"+
        "//		 * EXP: Quanto de Experiencia o Monstro dará ao jogador quando for vencido.\n"+
        "//				  Se for 0 a experiencia oferecida é calculada automaticamente.\n"+
        "//		 * Escala: 0 se a sua pequena, 1 se a sua média, 2 se o seu grande\n"+
        "//		 * Raça:  0 = sem forma, 1 = mortos-vivos, 2 = animais, 3 = planta, 4 = inseto, 5 = peixe, 6 = demônio, 7 Demihuman = 8 = anjo, 9 = dragão.\n"+
        "//		 * Elemento: Esta é a parte complicada. O número de elementos tem 2 partes, vamos chamá-los:\n"+
        "//				 XY: X = nível do elemento, e Y = número do elemento\n"+
        "//				     X: 2 = LVL1, 4 = LVL2, 6 = LVL3, 8 = LVL4.\n"+
        "//					  Y: 0 = Neutro, 1 = Água, 2 = Terra, 3 = Fogo, 4 = Vento, 5 = Venenoso, 6 = Sagrado, 7 = Sombra, 8 = Fantasma, 9 = Imortal\n"+
        "//					  * E agora, para tornar o elemento, basta pegar o número do lvl que você quer ser, e\n"+
        "//						 o número do elemento que você quer que seja. Vamos dizer que queremos um Monstros de fogo lvl 3.\n"+
        "//						 Capturamos o 6 para o primeiro número e os 3 para o segundo, sendo 6=lvl3, e 3=fogo.\n"+
        "//						 Será algo como = 63\n"+
        "//		 * Modo: Define o comportamento do Monstro. Os números são estes:\n"+
        "//				1=SeMovimeta, 2=ColetaNoChão, 4=Agressivo, 8=AuxiliaEspecie, 16=MultiAdversario, 32=Boss, 64=Planta, 128=PodeRevidar, 256=Detector, 512=EscolheAlvo\n"+
        "//				Exemplos:\n"+
        "//					* 133(A Morte)=128(PodeRevidar)+4(Agressivo)+1(SeMovimeta).\n"+
        "//					* 135(LimoVermelho)=128(PodeRevidar)+4(Agressivo)+2(ColetaNoChão)+1(SeMovimeta)\n"+
        "//					* 137(FadaGuardia)=128(PodeRevidar)+8(AuxiliaEspecie)+1(SeMovimeta)\n"+
        "//		 * Velocidade: Velocidade de caminhada da mob. 1 é o mais rápido, 3000 é o menor. 1000 é o caminhar normal de velocidade.\n"+
        "///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////";
    }
    public void salvarBanco(String mobTXT, String mobXML){

    }
    public int getContSpawns(){
        if(Spawns != null){
            return Spawns.length;
        }else{
            return 0;
        }
    }
    public Vector getVectorIDs(){
        Vector IDs = new Vector();
        for(int v=0;v<getContSpawns();v++){
            IDs.addElement(getSpawnPorOrdem(v).getID());
        }
        return IDs;
    }
    public Dados_Spawns getSpawnPorOrdem(int ordem){
        if(Spawns != null){
            return Spawns[ordem];
        }else{
            return null;
        }
    }
    public Dados_Spawns getSpawnPorID(int ID){
        if(Spawns != null){
            for(int ordem=0;ordem<Spawns.length;ordem++){
                if(Spawns[ordem].getID()==ID){
                    return Spawns[ordem];
                }
            }
        }
        return null;
    }
    public void addSpawn(int ID, String NomeSumonico, String NameTitulo){
        if(Spawns != null){
            Dados_Spawns novosSpawns[] = new Dados_Spawns[Spawns.length+1];
            for(int b=0;b<Spawns.length;b++){
                novosSpawns[b]=getSpawnPorOrdem(b);
            }
            novosSpawns[Spawns.length] = new Dados_Spawns(ID, NomeSumonico, NameTitulo);
            Spawns = novosSpawns;
        }else{
            Dados_Spawns novosSpawns[] = new Dados_Spawns[1];
            novosSpawns[0] = new Dados_Spawns(ID, NomeSumonico, NameTitulo);
            Spawns = novosSpawns;
        }
    }

    public class Dados_Spawns {
        public Dados_Spawns(int novoID, String novoNomeSumonico, String novoNameTitulo){
            ID=novoID;
            NomeSumonico=novoNomeSumonico;
            NameTitulo=novoNameTitulo;
        }

        //######### mobTXT #####################################################################
        private int ID=0;
        private String NomeSumonico="", NameTitulo="";
        private int Nível=0, HP=0, SP=0,Exp=0, Job=0, Range1=0, Ataque1=0, Ataque2=0, DefesaFisica=0, DefesaMagica=0;
        private int Stt_STR=0, Stt_AGI=0, Stt_VIT=0, Stt_INT=0, Stt_DEX=0, Stt_LUK=0;
        private int Range2=0, Range3=0, Scale=0, Race=0, Element=0, Mode=0, Speed=0, Adelay=0;
        private int AMotion=0, DMotion=0; //Motion(Movimento de Animação), DMotion(MovimrntoDeDano)

        //######### mobXML #####################################################################
        private String targetCursor="";
        //######################################################################################

        private Banco_Drops Drops[]=null;
        private Banco_Sounds Sons[]=null;
        private Banco_Sprites Sprites[]=null;

        public int getID(){return ID;}
        public String getNomeSumonico(){return NomeSumonico;}
        public String getNomeTitulo(){return NameTitulo;}
        public int getNivel(){return Nível;}
        public int getHP(){return HP;}
        public int getSP(){return SP;}
        public int getExp(){return Exp;}
        public int getJob(){return Job;}
        public int getRange1(){return Range1;}
        public int getAtaque1(){return Ataque1;}
        public int getAtaque2(){return Ataque2;}
        public int getDefesaFisica(){return DefesaFisica;}
        public int getDefesaMagica(){return DefesaMagica;}
        public int getEstatusForca(){return Stt_STR;}
        public int getEstatusAgilidade(){return Stt_AGI;}
        public int getEstatusVitalidade(){return Stt_VIT;}
        public int getEstatusInteligencias(){return Stt_INT;}
        public int getEstatusDestresa(){return Stt_DEX;}
        public int getEstatusSorte(){return Stt_LUK;}
        public int getRange2(){return Range2;}
        public int getRange3(){return Range3;}
        public int getScale(){return Scale;}
        public int getRace(){return Race;}
        public int getElement(){return Element;}
        public int getMode(){return Mode;}
        public int getSpeed(){return Speed;}
        public int getAdelay(){return Adelay;}
        public int getAMotion(){return AMotion;}
        public int getDMotion(){return DMotion;}

        public void setID(int novoID){ID=novoID;}
        public void setNomeSumonico(String novoNomeSumonico){NomeSumonico=novoNomeSumonico;}
        public void setNameTitulo(String novoNameTitulo){NameTitulo=novoNameTitulo;}
        public void setNivel(int novoNível){Nível=novoNível;}
        public void setHP(int novoHP){HP=novoHP;}
        public void setSP(int novoSP){SP=novoSP;}
        public void setExp(int novoExp){Exp=novoExp;}
        public void setJob(int novoJob){Job=novoJob;}
        public void setRange1(int novoRange1){Range1=novoRange1;}
        public void setAtaque1(int novoAtaque1){Ataque1=novoAtaque1;}
        public void setAtaque2(int novoAtaque2){Ataque2=novoAtaque2;}
        public void setDefesaFisica(int novoDefesaFisica){DefesaFisica=novoDefesaFisica;}
        public void setDefesaMagica(int novoDefesaMagica){DefesaMagica=novoDefesaMagica;}
        public void setEstatusForca(int novoStt_STR){Stt_STR=novoStt_STR;}
        public void setEstatusAgilidade(int novoStt_AGI){Stt_AGI=novoStt_AGI;}
        public void setEstatusVitalidade(int novoStt_VIT){Stt_VIT=novoStt_VIT;}
        public void setEstatusInteligencia(int novoStt_STR){Stt_STR=novoStt_STR;}
        public void setEstatusDestresa(int novoStt_DEX){Stt_DEX=novoStt_DEX;}
        public void setEstatusSorte(int novoStt_LUK){Stt_LUK=novoStt_LUK;}
        public void setRange2(int novoRange2){Range2=novoRange2;}
        public void setRange3(int novoRange3){Range3=novoRange3;}
        public void setScale(int novoScale){Scale=novoScale;}
        public void setRace(int novoRace){Race=novoRace;}
        public void setElement(int novoElement){Element=novoElement;}
        public void setMode(int novoMode){Mode=novoMode;}
        public void setSpeed(int novoSpeed){Speed=novoSpeed;}
        public void setAdelay(int novoAdelay){Adelay=novoAdelay;}
        public void setAMotion(int novoAMotion){AMotion=novoAMotion;}
        public void setDMotion(int novoDMotion){DMotion=novoDMotion;}

        public int getContDrops(){
            if(Drops != null){
                return Drops.length;
            }else{
                return 0;
            }
        }
        public Banco_Drops getDropPorOrdem(int ordem){
            if(Drops != null){
                return Drops[ordem];
            }else{
                return null;
            }
        }
        public void addDrop(int novoIDitem, int novoPercentual){
            if(Drops != null){
                Banco_Drops novosDrops[] = new Banco_Drops[Drops.length+1];
                for(int b=0;b<Drops.length;b++){
                    novosDrops[b]=getDropPorOrdem(b);
                }
                novosDrops[Drops.length] = new Banco_Drops(novoIDitem, novoPercentual);
                Drops = novosDrops;
            }else{
                Banco_Drops novosDrops[] = new Banco_Drops[1];
                novosDrops[0] = new Banco_Drops(novoIDitem, novoPercentual);
                Drops = novosDrops;
            }
        }

        public int getContSons(){
            if(Sons != null){
                return Sons.length;
            }else{
                return 0;
            }
        }
        public Banco_Sounds getSomPorOrdem(int ordem){
            if(Sons != null){
                return Sons[ordem];
            }else{
                return null;
            }
        }
        public void addSom(String novoEvent, String novoEndereco){
            if(Sons != null){
                Banco_Sounds novosSons[] = new Banco_Sounds[Sons.length+1];
                for(int b=0;b<Sons.length;b++){
                    novosSons[b]=getSomPorOrdem(b);
                }
                novosSons[Sons.length] = new Banco_Sounds(novoEvent, novoEndereco);
                Sons = novosSons;
            }else{
                Banco_Sounds novosSons[] = new Banco_Sounds[1];
                novosSons[0] = new Banco_Sounds(novoEvent, novoEndereco);
                Sons = novosSons;
            }
        }

        public int getContSprites(){
            if(Sprites != null){
                return Sprites.length;
            }else{
                return 0;
            }
        }
        public Banco_Sprites getSpritePorOrdem(int ordem){
            if(Sprites != null){
                return Sprites[ordem];
            }else{
                return null;
            }
        }
        public void addSprite(String novoSexo, String novoArquivo, String novoRecolor){
            if(Sprites != null){
                Banco_Sprites novosSprites[] = new Banco_Sprites[Sprites.length+1];
                for(int b=0;b<Sprites.length;b++){
                    novosSprites[b]=getSpritePorOrdem(b);
                }
                novosSprites[Sprites.length] = new Banco_Sprites(novoSexo, novoArquivo, novoRecolor);
                Sprites = novosSprites;
            }else{
                Banco_Sprites novosSprites[] = new Banco_Sprites[1];
                novosSprites[0] = new Banco_Sprites(novoSexo, novoArquivo, novoRecolor);
                Sprites = novosSprites;
            }
        }


        public class Banco_Sounds {
            public Banco_Sounds(String novoEvent, String novoEndereco) {
                evento=novoEvent;
                endereco=novoEndereco;
            }
            private String evento="";
            private String endereco="";
            public String getEvent(){return evento;}
            public String getEndereco(){return endereco;}
            public void setEvent(String novoEvent){evento=novoEvent;}
            public void setEndereco(String novoEndereco){endereco=novoEndereco;}
        }
        public class Banco_Drops {
            public Banco_Drops(int novoID, int novoPercentual) {
                id=novoID;
                percentual=novoPercentual;
            }
            private int id=0;
            private int percentual=0;
            public int getID(){return id;}
            public int getpercentual(){return percentual;}
            public void setID(int novoID){id=novoID;}
            public void setPercentual(int novoPercentual){percentual=novoPercentual;}
        }
        public class Banco_Sprites {
            public Banco_Sprites(String novoSexo, String novoArquivoXML, String novoRecolor) {
                sexo=novoSexo;
                arquivoXML=novoArquivoXML;
                recolor=novoRecolor;
            }
            private String sexo="";
            private String arquivoXML="";
            private String recolor="";
            public String geSexo(){return sexo;}
            public String getArquivoXML(){return arquivoXML;}
            public SpriteXML getClassXML(){
                return new SpriteXML(PastaDeSprites+Barra+arquivoXML);
            }
            public String getEnderecoPNG(){
                return (new SpriteXML(PastaDeSprites+Barra+arquivoXML)).getEnderecoPNG();
            }/**/

            public String getRecolor(){return recolor;}

            public void setSexo(String novoSexo){sexo=novoSexo;}
            public void setArquivo(String novoArquivoXML){arquivoXML=novoArquivoXML;}
            public void setRecolor(String novoRecolor){recolor=novoRecolor;}
        }
    }
}
