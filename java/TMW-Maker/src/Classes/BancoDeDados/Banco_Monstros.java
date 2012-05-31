package Classes.BancoDeDados;

import Classes.ConfigClass;
import classes.FileClass;
import Classes.SpriteXML;
import Classes.StringClass;
import Formularios.FrmPrincipal;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Banco_Monstros {
    public Banco_Monstros() {
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
    public static String PastaDeParticulas = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"particles";
    public static String PastaDeTMWdata = FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata";

    private Dados_Monstro Monstros[]=null;
    public void abrirBanco(String mobTXT, String mobXML){
        if(FileClass.seExiste(mobTXT) && FileClass.seExiste(mobXML)){
            Monstros=null;
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
                        addMonstro(
                            Integer.parseInt(Partes[0]),
                            Partes[1], Partes[2]
                        );
                        FrmPrincipal.setAvisoEmEstatus(
                            FrmPrincipal.traducao.getTraducaoNormatizada(
                                "FrmSplash", "bdMOBs.getSpawn(%)",
                                "[html]Carregando Monstro: \"[color[#0000FF]color]%1: %2[/color]\"!",
                                Partes[0]+"&&"+Partes[2]
                            ),
                            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_caveira.png"))
                        );
                        getMonstroPorOrdem(getContMonstros()-1).setNivel(Integer.parseInt(Partes[3]));
                        getMonstroPorOrdem(getContMonstros()-1).setHP(Integer.parseInt(Partes[4]));
                        getMonstroPorOrdem(getContMonstros()-1).setSP(Integer.parseInt(Partes[5]));
                        getMonstroPorOrdem(getContMonstros()-1).setExp(Integer.parseInt(Partes[6]));
                        getMonstroPorOrdem(getContMonstros()-1).setJob(Integer.parseInt(Partes[7]));
                        getMonstroPorOrdem(getContMonstros()-1).setRange1(Integer.parseInt(Partes[8]));
                        getMonstroPorOrdem(getContMonstros()-1).setAtaque1(Integer.parseInt(Partes[9]));
                        getMonstroPorOrdem(getContMonstros()-1).setAtaque2(Integer.parseInt(Partes[10]));
                        getMonstroPorOrdem(getContMonstros()-1).setDefesaFisica(Integer.parseInt(Partes[11]));
                        getMonstroPorOrdem(getContMonstros()-1).setDefesaMagica(Integer.parseInt(Partes[12]));
                        getMonstroPorOrdem(getContMonstros()-1).setEstatusForca(Integer.parseInt(Partes[13]));
                        getMonstroPorOrdem(getContMonstros()-1).setEstatusAgilidade(Integer.parseInt(Partes[14]));
                        getMonstroPorOrdem(getContMonstros()-1).setEstatusVitalidade(Integer.parseInt(Partes[15]));
                        getMonstroPorOrdem(getContMonstros()-1).setEstatusInteligencia(Integer.parseInt(Partes[16]));
                        getMonstroPorOrdem(getContMonstros()-1).setEstatusDestresa(Integer.parseInt(Partes[17]));
                        getMonstroPorOrdem(getContMonstros()-1).setEstatusSorte(Integer.parseInt(Partes[18]));
                        getMonstroPorOrdem(getContMonstros()-1).setRange2(Integer.parseInt(Partes[19]));
                        getMonstroPorOrdem(getContMonstros()-1).setRange3(Integer.parseInt(Partes[20]));
                        getMonstroPorOrdem(getContMonstros()-1).setEscala(Integer.parseInt(Partes[21]));
                        getMonstroPorOrdem(getContMonstros()-1).setRace(Integer.parseInt(Partes[22]));
                        getMonstroPorOrdem(getContMonstros()-1).setElement(Integer.parseInt(Partes[23]));
                        getMonstroPorOrdem(getContMonstros()-1).setComportamento(Integer.parseInt(Partes[24]));
                        getMonstroPorOrdem(getContMonstros()-1).setSpeed(Integer.parseInt(Partes[25]));
                        getMonstroPorOrdem(getContMonstros()-1).setAdelay(Integer.parseInt(Partes[26]));
                        getMonstroPorOrdem(getContMonstros()-1).setAMotion(Integer.parseInt(Partes[27]));
                        getMonstroPorOrdem(getContMonstros()-1).setDMotion(Integer.parseInt(Partes[28]));

                        getMonstroPorOrdem(getContMonstros()-1).setMutationCount(Integer.parseInt(Partes[55]));
                        getMonstroPorOrdem(getContMonstros()-1).setMutationStrength(Integer.parseInt(Partes[56]));

                        for(int d=29;d<=46;d+=2){
                            try{
                                if(Integer.parseInt(Partes[d+0])>0){
                                    getMonstroPorOrdem(getContMonstros()-1).addDrop(
                                        Integer.parseInt(Partes[d+0]),
                                        Integer.parseInt(Partes[d+1])
                                    );
                                }
                            }catch(NumberFormatException ex){ }
                        }

                        Element Elementos=FileClass.arquivoAbrirXML(mobXML);
                        NodeList noMonster = Elementos.getElementsByTagName("monster");
                        for (int Ms = (getContMonstros()-1); Ms < noMonster.getLength(); Ms++) {
                            Element tagMonster = (Element) noMonster.item(Ms);
                            if((FileClass.getAtributo(tagMonster,"id",-1)+1002)==getMonstroPorOrdem(getContMonstros()-1).getID()){
                                String TargetCursor = FileClass.getAtributo(tagMonster,"targetCursor","");
                                if(!TargetCursor.equals("")) getMonstroPorOrdem(getContMonstros()-1).setTargetCursor(TargetCursor);
                                
                                NodeList noDescription = tagMonster.getElementsByTagName("description");
                                String Comentario="";
                                if(noDescription.getLength()>=1){
                                    for (int Ds = 0; Ds < noDescription.getLength(); Ds++) {
                                        Element tagDescription = (Element) noDescription.item(Ds);
                                        Comentario += tagDescription.getFirstChild().getTextContent();
                                    }
                                    getMonstroPorOrdem(getContMonstros()-1).setDescricao(Comentario);
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
                                        getMonstroPorOrdem(getContMonstros()-1).addSprite(Sexo,Arquivo,Recolor);
                                    }
                                }

                                NodeList noSound = tagMonster.getElementsByTagName("sound");
                                for (int Sn = 0; Sn < noSound.getLength(); Sn++) {
                                    Element tagSound = (Element) noSound.item(Sn);
                                    getMonstroPorOrdem(getContMonstros()-1).addSom(
                                        FileClass.getAtributo(tagSound,"event",""),
                                        tagSound.getFirstChild().getTextContent()
                                    );
                                }

                                NodeList noParticula = tagMonster.getElementsByTagName("particlefx");
                                for (int Pfx = 0; Pfx < noParticula.getLength(); Pfx++) {
                                    Element tagParticula = (Element) noParticula.item(Pfx);
                                    //String Sexo=FileClass.getAtributo(tagParticula,"gender","");
                                    String Arquivo="";
                                    Arquivo=tagParticula.getFirstChild().getTextContent();
                                    if(FileClass.seExiste(PastaDeTMWdata+Barra+Arquivo)){
                                        getMonstroPorOrdem(getContMonstros()-1).addParticula(Arquivo);
                                    }
                                }

                                NodeList noEfeitosDeAtaque = tagMonster.getElementsByTagName("attack");
                                for (int Atk = 0; Atk < noEfeitosDeAtaque.getLength(); Atk++) {
                                    Element tagEfeitosDeAtaque = (Element) noEfeitosDeAtaque.item(Atk);
                                    int ataqueID=FileClass.getAtributo(tagEfeitosDeAtaque,"id",0);
                                    String ataqueParticula=FileClass.getAtributo(tagEfeitosDeAtaque,"particle-effect","");
                                    if(FileClass.seExiste(PastaDeTMWdata+Barra+ataqueParticula)){
                                        getMonstroPorOrdem(getContMonstros()-1).addEfeitosDeAtaque(ataqueID, ataqueParticula);
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
    private String getCabecalhoMobTXT(){
        return
        "///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"+
        "//  IDE: TMW-Maker - Ferramenta Editora de Banco de Dados de Monstros\n"+
        "//  MODIFICADO: "+ConfigClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+
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
        "//		 * NomeTítulo: Pode haver espaço e caracteres especiais no formato UTF-8. Exemplo: \"Capitão da Guarda\"\n"+
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
    public void salvarBanco(){
        salvarBanco(EnderecoTXT, EnderecoXML);
    }
    public void salvarBanco(String mobTXT, String mobXML){
        StringClass ConteudoTXT = new StringClass(getCabecalhoMobTXT());
        ConteudoTXT.setTesto(ConteudoTXT.getTesto()+"\n");
        try {
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            Factory.setNamespaceAware(true);
            Factory.setIgnoringElementContentWhitespace(false);
            Factory.setValidating(true);
            DocumentBuilder Builder = Factory.newDocumentBuilder();
            Document Doc = Builder.newDocument();
            Element Monsters = Doc.createElement("monsters");
            Monsters.setAttribute("offset", "1002");

            for(int m=0;m<getContMonstros();m++){
                ConteudoTXT.setTesto(ConteudoTXT.getTesto()+
                    "\n"+getMonstroPorOrdem(m).getID()+
                    ","+getMonstroPorOrdem(m).getNomeSumonico()+
                    ","+getMonstroPorOrdem(m).getNomeTitulo()+

                    ","+getMonstroPorOrdem(m).getNivel()+
                    ","+getMonstroPorOrdem(m).getHP()+
                    ","+getMonstroPorOrdem(m).getSP()+
                    ","+getMonstroPorOrdem(m).getExp()+
                    ","+getMonstroPorOrdem(m).getJob()+

                    ","+getMonstroPorOrdem(m).getRange1()+
                    ","+getMonstroPorOrdem(m).getAtaque1()+
                    ","+getMonstroPorOrdem(m).getAtaque2()+
                    ","+getMonstroPorOrdem(m).getDefesaFisica()+
                    ","+getMonstroPorOrdem(m).getDefesaMagica()+

                    ","+getMonstroPorOrdem(m).getEstatusForca()+
                    ","+getMonstroPorOrdem(m).getEstatusAgilidade()+
                    ","+getMonstroPorOrdem(m).getEstatusVitalidade()+
                    ","+getMonstroPorOrdem(m).getEstatusInteligencias()+
                    ","+getMonstroPorOrdem(m).getEstatusDestresa()+
                    ","+getMonstroPorOrdem(m).getEstatusSorte()+

                    ","+getMonstroPorOrdem(m).getRange2()+
                    ","+getMonstroPorOrdem(m).getRange3()+
                    ","+getMonstroPorOrdem(m).getEscala()+
                    ","+getMonstroPorOrdem(m).getRace()+
                    ","+getMonstroPorOrdem(m).getElement()+
                    ","+getMonstroPorOrdem(m).getComportamento()+
                    ","+getMonstroPorOrdem(m).getSpeed()+
                    ","+getMonstroPorOrdem(m).getAdelay()+

                    ","+getMonstroPorOrdem(m).getAMotion()+
                    ","+getMonstroPorOrdem(m).getDMotion()
                );
                for(int i=0;i<8;i++){
                    if(i<getMonstroPorOrdem(m).getDropsCont()){
                        ConteudoTXT.setTesto(ConteudoTXT.getTesto()+
                            ","+getMonstroPorOrdem(m).getDropPorOrdem(i).getID()+
                            ","+getMonstroPorOrdem(m).getDropPorOrdem(i).getPercentual()
                        );
                    }else{
                        ConteudoTXT.setTesto(ConteudoTXT.getTesto()+",0,0");
                    }
                }
                ConteudoTXT.setTesto(ConteudoTXT.getTesto()+
                    ",,,,,,,,,,"+
                    ","+getMonstroPorOrdem(m).getMutationCount()+
                    ","+getMonstroPorOrdem(m).getMutationStrength()
                );

                Element Monster = Doc.createElement("monster");
                Monster.setAttribute("id", String.valueOf(getMonstroPorOrdem(m).getID()-1002));
                Monster.setAttribute("name", getMonstroPorOrdem(m).getNomeTitulo());
                Monster.setAttribute("summon", getMonstroPorOrdem(m).getNomeSumonico());
                if(!getMonstroPorOrdem(m).getTargetCursor().equals("")) Monster.setAttribute("targetCursor", getMonstroPorOrdem(m).getTargetCursor());
                //if(!getMonstroPorOrdem(m).getDescricao().equals("")) Monster.setAttribute("comment", getMonstroPorOrdem(m).getDescricao());

                String Descricao=getMonstroPorOrdem(m).getDescricao();
                if(!Descricao.trim().equals("")){
                    Element Description = Doc.createElement("description");
                    Description.appendChild(Doc.createTextNode(getMonstroPorOrdem(m).getDescricao()));
                    Monster.appendChild(Description);
                }
                
                for(int Spt=0;Spt<getMonstroPorOrdem(m).getContSprites();Spt++){
                    Element Sprite = Doc.createElement("sprite");
                    String Genero = getMonstroPorOrdem(m).getSpritePorOrdem(Spt).geSexo();
                    if(!Genero.equals("")) Sprite.setAttribute("gender", Genero);
                    String Recolor=getMonstroPorOrdem(m).getSpritePorOrdem(Spt).getRecolor();
                    Sprite.appendChild(
                        Doc.createTextNode(
                            getMonstroPorOrdem(m).getSpritePorOrdem(Spt).getArquivoXML()+
                            (!Recolor.equals("")?"|"+Recolor:"")
                        )
                    );
                    Monster.appendChild(Sprite);
                }
                for(int Sfx=0;Sfx<getMonstroPorOrdem(m).getContSons();Sfx++){
                    Element Sound = Doc.createElement("sound");
                    Sound.setAttribute("event", getMonstroPorOrdem(m).getSomPorOrdem(Sfx).getEvent());
                    //Sound.
                    Sound.appendChild(Doc.createTextNode(getMonstroPorOrdem(m).getSomPorOrdem(Sfx).getEndereco()));
                    Monster.appendChild(Sound);
                }
                for(int Pfx=0;Pfx<getMonstroPorOrdem(m).getContParticulas();Pfx++){
                    Element ParticleFX = Doc.createElement("particlefx");
                    ParticleFX.appendChild(Doc.createTextNode(getMonstroPorOrdem(m).getParticulaPorOrdem(Pfx).getEndereco()));
                    Monster.appendChild(ParticleFX);
                }
                for(int Atk=0;Atk<getMonstroPorOrdem(m).getContEfeitosDeAtaque();Atk++){
                    Element EfeitoDeAtaque = Doc.createElement("attack");
                    EfeitoDeAtaque.setAttribute("id", String.valueOf(getMonstroPorOrdem(m).getEfeitosDeAtaquePorOrdem(Atk).getID()));
                    EfeitoDeAtaque.setAttribute("particle-effect", getMonstroPorOrdem(m).getEfeitosDeAtaquePorOrdem(Atk).getParticleEffect());
                    Monster.appendChild(EfeitoDeAtaque);
                }
                Monsters.appendChild(Monster);
            }
            Comment Comentario = Doc.createComment("\n"+
                "\tIDE: TMW-Maker - Ferramenta Editora de Monstros\n"+
                "\tMODIFICADO: "+ConfigClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"
            );
            Doc.appendChild(Comentario);
            Doc.appendChild(Monsters);
            ConteudoTXT.setTesto(ConteudoTXT.getTesto()+"\n"+"\n");
            FileClass.arquivoSalvar(mobTXT, ConteudoTXT.getTesto());
            FileClass.arquivoSalvarXML(mobXML, Doc);

            /*Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");//Saber se o XML será identado(terá espaços entre tags).
            trans.setOutputProperty(OutputKeys.STANDALONE, "yes");
            trans.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            trans.transform(
                new javax.xml.transform.dom.DOMSource(Doc),
                new StreamResult(new FileOutputStream(mobXML))
            );/**/
            ////////////////////////////////////////////////////////////////////////////////////////////////
            // Salva compactado.
            //trans.transform( new GZipStreamSource(new File("input.xml")), new StreamResult(System.out) );
            /////////////////////////////////////////////////////////////////////////////////////////////////
        
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Banco_Monstros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public int getContMonstros(){
        if(Monstros != null) return Monstros.length;
        return 0;
    }
    public Vector getVectorIDs(){
        Vector LIstarIDs = new Vector();
        for(int v=0;v<getContMonstros();v++){
            LIstarIDs.addElement(getMonstroPorOrdem(v).getID()+": "+getMonstroPorOrdem(v).getNomeTitulo());
        }
        return LIstarIDs;
    }
    public Dados_Monstro getMonstroPorOrdem(int ordem){
        if(Monstros != null)return Monstros[ordem];
        return null;
    }
    public Dados_Monstro getMonstroPorID(int ID){
        if(Monstros != null){
            for(int ordem=0;ordem<Monstros.length;ordem++){
                if(Monstros[ordem].getID()==ID){
                    return Monstros[ordem];
                }
            }
        }
        return null;
    }
    public void addMonstro(Dados_Monstro Monstro){
        if(Monstros != null){
            Dados_Monstro novosSpawns[] = new Dados_Monstro[getContMonstros()+1];
            for(int b=0;b<getContMonstros();b++){
                novosSpawns[b]=getMonstroPorOrdem(b);
            }
            novosSpawns[Monstros.length] = Monstro;
            Monstros = novosSpawns;
        }else{
            Dados_Monstro novosSpawns[] = new Dados_Monstro[1];
            novosSpawns[0] = Monstro;
            Monstros = novosSpawns;
        }
    }
    public void addMonstro(int ID, String NomeSumonico, String NameTitulo){
        if(Monstros != null){
            Dados_Monstro novosSpawns[] = new Dados_Monstro[getContMonstros()+1];
            for(int b=0;b<getContMonstros();b++){
                novosSpawns[b]=getMonstroPorOrdem(b);
            }
            novosSpawns[Monstros.length] = new Dados_Monstro(ID, NomeSumonico, NameTitulo);
            Monstros = novosSpawns;
        }else{
            Dados_Monstro novosSpawns[] = new Dados_Monstro[1];
            novosSpawns[0] = new Dados_Monstro(ID, NomeSumonico, NameTitulo);
            Monstros = novosSpawns;
        }
    }

    public class Dados_Monstro {
        public Dados_Monstro(int novoID, String novoNomeSumonico, String novoNameTitulo){
            ID=novoID;
            NomeSumonico=novoNomeSumonico;
            NameTitulo=novoNameTitulo;
        }

        //######### mobTXT #####################################################################
        private int ID=0;
        private String NomeSumonico="", NameTitulo="";
        private int Nível=1, HP=1, SP=0,Exp=0, Job=0, Range1=1, Ataque1=1, Ataque2=1, DefesaFisica=0, DefesaMagica=0;
        private int Stt_STR=1, Stt_AGI=1, Stt_VIT=1, Stt_INT=1, Stt_DEX=1, Stt_LUK=1;
        private int Range2=1, Range3=1, Scale=1, Race=0, Element=20, Mode=0, Speed=1000, Adelay=500;
        private int AMotion=700, DMotion=500; //Motion(Movimento de Animação), DMotion(MovimrntoDeDano)
        private int MutationCount=0, MutationStrength=0;

        //######### mobXML #####################################################################
        private String Descricao="";
        private String targetCursor="";
        //######################################################################################

        private Banco_Drops Drops[]=null;
        private Banco_Sounds Sons[]=null;
        private Banco_Sprites Sprites[]=null;
        private Banco_Particulas Particulas[]=null;
        private Banco_AttackEffects EfeitosDeAtaque[]=null;

        public int getID(){return ID;}
        public String getNomeSumonico(){return NomeSumonico;}
        public String getNomeTitulo(){return NameTitulo;}
        public String getTargetCursor(){return targetCursor;}
        public String getDescricao(){return Descricao;}
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
        public int getEscala(){return Scale;}
        public int getRace(){return Race;}
        public int getElement(){return Element;}
        public int getComportamento(){return Mode;}
        public int getSpeed(){return Speed;}
        public int getAdelay(){return Adelay;}
        public int getAMotion(){return AMotion;}
        public int getDMotion(){return DMotion;}
        public int getMutationCount(){return MutationCount;}
        public int getMutationStrength(){return MutationStrength;}

        public void setID(int novoID){ID=novoID;}
        public void setNomeSumonico(String novoNomeSumonico){NomeSumonico=novoNomeSumonico;}
        public void setNomeTitulo(String novoNameTitulo){NameTitulo=novoNameTitulo;}
        public void setTargetCursor(String novoTargetCursor){targetCursor=novoTargetCursor;}
        public void setDescricao(String novoDescricao){Descricao=novoDescricao;}
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
        public void setEstatusInteligencia(int novoStt_INT){Stt_INT=novoStt_INT;}
        public void setEstatusDestresa(int novoStt_DEX){Stt_DEX=novoStt_DEX;}
        public void setEstatusSorte(int novoStt_LUK){Stt_LUK=novoStt_LUK;}
        public void setRange2(int novoRange2){Range2=novoRange2;}
        public void setRange3(int novoRange3){Range3=novoRange3;}
        public void setEscala(int novaEscala){Scale=novaEscala;}
        public void setRace(int novoRace){Race=novoRace;}
        public void setElement(int novoElement){Element=novoElement;}
        public void setComportamento(int novoMode){Mode=novoMode;}
        public void setSpeed(int novoSpeed){Speed=novoSpeed;}
        public void setAdelay(int novoAdelay){Adelay=novoAdelay;}
        public void setAMotion(int novoAMotion){AMotion=novoAMotion;}
        public void setDMotion(int novoDMotion){DMotion=novoDMotion;}
        public void setMutationCount(int novoMutationCount){MutationCount=novoMutationCount;}
        public void setMutationStrength(int novoMutationStrength){MutationStrength=novoMutationStrength;}

        public void setDropsReset(){
            Drops=null;
        }
        public int getDropsCont(){
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

        public void setSonsReset(){
            Sons=null;
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

        public void setSpritesReset(){
            Sprites=null;
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

        public void setParticulaReset(){
            Particulas=null;
        }
        public int getContParticulas(){
            if(Particulas != null){
                return Particulas.length;
            }else{
                return 0;
            }
        }
        public Banco_Particulas getParticulaPorOrdem(int ordem){
            if(Particulas != null){
                return Particulas[ordem];
            }else{
                return null;
            }
        }
        public void addParticula(String Enderco){
            if(Particulas != null){
                Banco_Particulas novasParticulas[] = new Banco_Particulas[Particulas.length+1];
                for(int p=0;p<Particulas.length;p++){
                    novasParticulas[p]=getParticulaPorOrdem(p);
                }
                novasParticulas[Particulas.length] = new Banco_Particulas(Enderco);
                Particulas = novasParticulas;
            }else{
                Banco_Particulas novasParticulas[] = new Banco_Particulas[1];
                novasParticulas[0] = new Banco_Particulas(Enderco);
                Particulas = novasParticulas;
            }
        }

        public void setEfeitosDeAtaqueReset(){
            EfeitosDeAtaque=null;
        }
        public int getContEfeitosDeAtaque(){
            if(EfeitosDeAtaque != null){
                return EfeitosDeAtaque.length;
            }else{
                return 0;
            }
        }
        public Banco_AttackEffects getEfeitosDeAtaquePorOrdem(int ordem){
            if(EfeitosDeAtaque != null){
                return EfeitosDeAtaque[ordem];
            }else{
                return null;
            }
        }
        public void addEfeitosDeAtaque(int novoID, String novoEfeitosDeAtaque){
            if(EfeitosDeAtaque != null){
                Banco_AttackEffects novosEfeitosDeAtaque[] = new Banco_AttackEffects[EfeitosDeAtaque.length+1];
                for(int p=0;p<EfeitosDeAtaque.length;p++){
                    novosEfeitosDeAtaque[p]=getEfeitosDeAtaquePorOrdem(p);
                }
                novosEfeitosDeAtaque[EfeitosDeAtaque.length] = new Banco_AttackEffects(novoID, novoEfeitosDeAtaque);
                EfeitosDeAtaque = novosEfeitosDeAtaque;
            }else{
                Banco_AttackEffects novosEfeitosDeAtaque[] = new Banco_AttackEffects[1];
                novosEfeitosDeAtaque[0] = new Banco_AttackEffects(novoID, novoEfeitosDeAtaque);
                EfeitosDeAtaque = novosEfeitosDeAtaque;
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
        public class Banco_Particulas {
            public Banco_Particulas(String novoEndereco) {
                endereco=novoEndereco;
            }
            private String endereco="";
            public String getEndereco(){return endereco;}
            public void setEndereco(String novoEndereco){endereco=novoEndereco;}
        }
        public class Banco_AttackEffects {
            public Banco_AttackEffects(int novoID, String novoParticleEffect) {
                ID=novoID;
                ParticleEffect=novoParticleEffect;
            }
            private int ID=0;
            private String ParticleEffect="";
            public int getID(){return ID;}
            public void setID(int novoID){ID=novoID;}
            public String getParticleEffect(){return ParticleEffect;}
            public void setParticleEffect(String novoParticleEffect){ParticleEffect=novoParticleEffect;}
        }
        public class Banco_Drops {
            public Banco_Drops(int novoID, int novoPercentual) {
                id=novoID;
                percentual=novoPercentual;
            }
            private int id=0;
            private int percentual=0;
            public int getID(){return id;}
            public int getPercentual(){return percentual;}
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
                return (new SpriteXML(PastaDeSprites+Barra+arquivoXML)).getSpritePNGendereco();
            }/**/

            public String getRecolor(){return recolor;}

            public void setSexo(String novoSexo){sexo=novoSexo;}
            public void setArquivo(String novoArquivoXML){arquivoXML=novoArquivoXML;}
            public void setRecolor(String novoRecolor){recolor=novoRecolor;}
        }
    }
}
