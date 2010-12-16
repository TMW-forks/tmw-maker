package Classes.BancoDeDados;

import Classes.DialogClass;
import Classes.FileClass;
import Classes.StringClass;
import Formularios.FrmPrincipal;
import java.util.Vector;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Banco_Mapas {
    private static String Barra = System.getProperty("file.separator");
    private static String Tiled=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmw-maker"+Barra+"tiled.jar";
    private static String PastaDeMapas=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"maps";
    private static String PastaDeMiniaturas=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"minimaps";
    private static String PastaDeColisoes=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"data";
    private static String baseScripts=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"npc";
    private Dados_Mapas Mundo[]=null; //Não deve ser instaciado agora!!!!
    public Banco_Mapas(){
        //DialogClass.showAlerta("Esse comando ainda não foi implementado!", "Copilador", null);

        //String PastaDeMapas=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"maps";

        FrmPrincipal.PgbBarra.setIndeterminate(false);
        FrmPrincipal.PgbBarra.setEnabled(true);
        FrmPrincipal.PgbBarra.setMinimum(0);

        /*FrmPrincipal.setAvisoEmEstatus(
            "Listando Mapas...",
            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))
        );/**/

        if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
            String pasta[] = FileClass.listarPasta(baseScripts);
            String arquivo[] = null;
            String importador="", warps="", mobs="", mapaNome="", mapaTMX="";
            StringClass importacao = new StringClass();
            StringClass mapaConteudo = new StringClass();
            StringClass warpConteudo = new StringClass();
            StringClass mobConteudo = new StringClass();
            FrmPrincipal.PgbBarra.setMaximum(pasta.length);
            for(int p=0; p<pasta.length; p++){
                FrmPrincipal.PgbBarra.setValue(p);
                FrmPrincipal.PgbBarra.setString((((p+1)*100)/pasta.length)+"%");
                if(
                    !pasta[p].equals(".svn") &&
                    !pasta[p].equals("functions")
                ){
                    importador=baseScripts+Barra+pasta[p]+Barra+"_import.txt";
                    warps=baseScripts+Barra+pasta[p]+Barra+"_warps.txt";
                    mobs=baseScripts+Barra+pasta[p]+Barra+"_mobs.txt";
                    if(FileClass.seExiste(importador)){
                        if(FileClass.seExiste(warps)){
                            if(FileClass.seExiste(mobs)){
                                importacao.setTesto("\n"+FileClass.arquivoAbrir(importador));// esse \n tem que ser add pq a linha q tem "map:" pode está comentada!
                                mapaNome=importacao.extrairEntre("\nmap: ", ".gat").trim();
                                if(!mapaNome.equals("")){
                                    mapaTMX=PastaDeMapas+Barra+mapaNome+".tmx";
                                    if(FileClass.seExiste(mapaTMX)){
//////////////////////////////////////////////////////// PARA COLPILAR ////////////////////////////////////////////////////////////
                                        FrmPrincipal.setAvisoEmEstatus("<html>"+
                                            "Carregando Mapa: \"<font color=\"#0000FF\">"+mapaNome+".tmx</font>\"!",
                                            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_globo.gif"))
                                        );

                                        //Vector Prop_Tiles = importMapaXML(mapaTMX);

                                                
                                        mapaConteudo.setTesto(FileClass.arquivoAbrir(mapaTMX));
                                        mapaConteudo.setKeyCode("ISO-8859-1");//Transforma UTF-8 ? ISO-8859-1
                                        //String Cabecalho = <map
                                        StringClass Cabecalho = new StringClass(
                                            mapaConteudo.extrairEntre("<map", ">")
                                        );
                                        int Largura = Integer.parseInt(Cabecalho.extrairEntre("width=\"", "\""));
                                        int Altura = Integer.parseInt(Cabecalho.extrairEntre("height=\"", "\""));
                                        String Nome = mapaConteudo.extrairEntre(
                                            "<property name=\"name\" value=\"", "\""
                                        );
                                        String Miniatura = mapaConteudo.extrairEntre(
                                            "<property name=\"minimap\" value=\"/graphics/minimaps/", "\""
                                        );
                                        String Musica = mapaConteudo.extrairEntre(
                                            "<property name=\"music\" value=\"", "\""
                                        );
                                        addMapa(Nome,Miniatura,mapaNome+".tmx",mapaNome+".wlk",Musica,Largura,Altura);
                                        //warpConteudo.setTesto(FileClass.arquivoAbrir(warps));
                                        //warpConteudo.setKeyCode("ISO-8859-1");
                                        //mobConteudo.setTesto(FileClass.arquivoAbrir(mobs));
                                        //mobConteudo.setKeyCode("ISO-8859-1");
                                        /**/

























//////////////////////////////////////////////////////// PARA COLPILAR ////////////////////////////////////////////////////////////

                                    }else{
                                        FrmPrincipal.setAvisoEmEstatus("<html>"+
                                            "<font color=\"#FF0000\">ERRO:</font> Não foi possivel encontrar o mapa\"<font color=\"#FF0000\">"+mapaNome+".tmx</font>\"!",
                                            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png"))
                                        );
                                        DialogClass.showErro("<html>Não foi possivel encontrar o mapa \"<font color=\"#FF0000\">"+mapaNome+".tmx</font>\"!", "Copilador");
                                        FrmPrincipal.PgbBarra.setString("ERRO!");
                                        return;
                                    }
                                }//else{DialogClass.showErro("Arquivo\""+importador+"\" bloqueado!", "Copilador");}
                            }else{
                                FrmPrincipal.setAvisoEmEstatus("<html>"+
                                    "<font color=\"#FF0000\">ERRO:</font> Não foi possivel encontrar os spawns:<br/>"+
                                    "\"<font color=\"#FF0000\">"+mobs+".tmx</font>\"",
                                    new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png"))
                                );
                                DialogClass.showErro("<html>Não foi possivel encontrar o mapa \"<font color=\"#FF0000\">"+warps+".tmx</font>\"!", "Copilador");
                                FrmPrincipal.PgbBarra.setString("ERRO!");
                                return;
                            }
                        }else{
                            FrmPrincipal.setAvisoEmEstatus("<html>"+
                                "<font color=\"#FF0000\">ERRO:</font> Não foi possivel encontrar os portais:<br/>"+
                                "\"<font color=\"#FF0000\">"+warps+".tmx</font>\"!",
                                new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png"))
                            );
                            DialogClass.showErro("<html>Não foi possivel encontrar o mapa \"<font color=\"#FF0000\">"+warps+".tmx</font>\"!", "Copilador");
                            FrmPrincipal.PgbBarra.setString("ERRO!");
                            return;
                        }
                    }//else{DialogClass.showErro("Não foi possivel encontrar o arquivo\""+importador+"\"!", "Copilador");}
                }
            }
        }
        FrmPrincipal.PgbBarra.setString("Concluido!");
        FrmPrincipal.setAvisoEmEstatus("<html>"+
            "Copilação semi-concluida! (<font color=\"#FF0000\">Função Deprecada</font>)",
            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))
        );
    }

    private Vector importMapaXML(String Endereco) {
        if(FileClass.seExiste(Endereco)){
            try {
                /*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db=dbf.newDocumentBuilder();
                Document Documento =db.parse(Endereco);
                Element Elementos = Documento.getDocumentElement();/**/
                Element Elementos=FileClass.arquivoAbrirXML(Endereco);

                NodeList noPropriedades = Elementos.getElementsByTagName("property"); //elemento="usuario"
                Vector Propriedades = new Vector();
                for (int i = 0; i < noPropriedades.getLength(); i++) {
                    Vector Registro = new Vector();
                    Element tagPropriedade = (Element) noPropriedades.item(i);
                    Registro.addElement(FileClass.getAtributo(tagPropriedade,"name",""));
                    Registro.addElement(FileClass.getAtributo(tagPropriedade,"value",""));
                    Propriedades.add(Registro);
                }

                NodeList noTileset = Elementos.getElementsByTagName("tileset"); //elemento="usuario"
                Vector Tilesets = new Vector();
                for (int i = 0; i < noTileset.getLength(); i++) {
                    Vector Registro = new Vector();
                    Element tagTileset = (Element) noTileset.item(i);
                    Registro.addElement(FileClass.getAtributo(tagTileset,"firstgid",0));
                    Registro.addElement(FileClass.getAtributo(tagTileset,"name",""));
                    Registro.addElement(FileClass.getAtributo(tagTileset,"tilewidth",0));
                    Registro.addElement(FileClass.getAtributo(tagTileset,"tileheight",0));
                    NodeList noImagem = noTileset.item(i).getChildNodes(); //elemento="usuario"
                    Element tagImagem = (Element) noImagem.item(0);
                    Registro.addElement(FileClass.getAtributo(tagImagem,"source",0));
                    Tilesets.add(Registro);
                }

                NodeList noLayer = Elementos.getElementsByTagName("layer"); //elemento="usuario"
                Vector Layers = new Vector();
                for (int i = 0; i < noLayer.getLength(); i++) {
                    Vector Registro = new Vector();
                    Element tagLayer = (Element) noLayer.item(i);
                    Registro.addElement(FileClass.getAtributo(tagLayer,"name",""));
                    Registro.addElement(FileClass.getAtributo(tagLayer,"width",0));
                    Registro.addElement(FileClass.getAtributo(tagLayer,"height",0));
                    Registro.addElement(FileClass.getConteudo(tagLayer,"data",""));
                    NodeList data = noLayer.item(i).getChildNodes(); //elemento="usuario"
                    Element tagData = (Element) data.item(0);
                    Registro.addElement(FileClass.getAtributo(tagData,"encoding",""));
                    Registro.addElement(FileClass.getAtributo(tagData,"compression",""));

                    Layers.add(Registro);
                }
                
                Vector Mapa = new Vector();
                Mapa.add(Propriedades);
                Mapa.add(Tilesets);
                Mapa.add(Layers);

                return Mapa;
                // pega todos os elementos usuario do XML
            //} catch (ParserConfigurationException ex) {
                //Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            //} catch (IOException ex) {
                //Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            //} catch (SAXException ex) {
                //Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassCastException ex) {
                //Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            }

            /**/
        }
        return null;
    }

    public void addMapa(String Nome, String Miniatura, String Arquivo, String Colisao, String Musica, int Largura, int Altura){
        if(Mundo != null){
            Dados_Mapas novoMundo[] = new Dados_Mapas[Mundo.length+1];
            for(int b=0;b<Mundo.length;b++){
                novoMundo[b] = new Dados_Mapas(
                    Mundo[b].getNome(),
                    Mundo[b].getMiniatura(),
                    Mundo[b].getArquivo(),
                    Mundo[b].getColisao(),
                    Mundo[b].getMusica(),
                    Mundo[b].getLargura(),
                    Mundo[b].getAltura()
                );
            }
            novoMundo[Mundo.length] = new Dados_Mapas(Nome, Miniatura, Arquivo, Colisao, Musica, Largura, Altura);
            Mundo = novoMundo;
        }else{
            Dados_Mapas novoMundo[] = new Dados_Mapas[1];
            novoMundo[0] = new Dados_Mapas(Nome, Miniatura, Arquivo, Colisao, Musica, Largura, Altura);
            Mundo = novoMundo;
        }
    }
    public void delMapaPorArquivo(String Arquivo){
        if(Mundo != null){
            Dados_Mapas novoMundo[] = new Dados_Mapas[Mundo.length-1];
            int contLojas=0;
            for(int b=0;b<Mundo.length;b++){
                if(Mundo[b].getArquivo().equals(Arquivo)){
                    contLojas++;
                    novoMundo[contLojas-1]=getMapaPorOrdem(b);
                }
            }
            Mundo = novoMundo;
        }
    }
    public void delMapaPorOrdem(int ordem){
        if(Mundo != null){
            Dados_Mapas novoMundo[] = new Dados_Mapas[Mundo.length-1];
            int contLojas=0;
            for(int b=0;b<Mundo.length;b++){
                if(b!=ordem){
                    contLojas++;
                    novoMundo[contLojas-1]=getMapaPorOrdem(b);
                }
            }
            Mundo = novoMundo;
        }
    }
    public int getContMapas(){
         if(Mundo != null){
             return Mundo.length;
         }else{
             return 0;
         }
    }
    public Dados_Mapas[] getMapas(){
        if(getContMapas()>=1){
            return Mundo;
        }else{
            return null;
        }
    }
    public Dados_Mapas getMapaPorOrdem(int ordem){
        if(Mundo != null){
            return Mundo[ordem];
        }else{
            return null;
        }
    }
    public Dados_Mapas getMapaPorNome(String nomeMapa){
        if(Mundo != null){
            for(int ordem=0;ordem<Mundo.length;ordem++){
                if(Mundo[ordem].getNome().equals(nomeMapa)){
                    return Mundo[ordem];
                }
            }
        }
        return null;
    }
    public Dados_Mapas getMapaPorArquivo(String arquivoTMX){
        if(Mundo != null){
            for(int ordem=0;ordem<Mundo.length;ordem++){
                if(Mundo[ordem].getArquivo().equals(arquivoTMX)){
                    return Mundo[ordem];
                }
            }
        }
        return null;
    }

    public class Dados_Mapas {
        public Dados_Mapas(String novaNome, String novaMiniatura, String novoArquivo, String novaColisao, String novaMusica, int novaLargura, int novaAltura){
            Nome=novaNome;
            Arquivo=novoArquivo;
            Miniatura=novaMiniatura;
            Colisao=novaColisao;
            Musica=novaMusica;
            Largura=novaLargura;
            Altura=novaAltura;
        }
        private String Nome = "";
        private String Miniatura = "";
        private String Arquivo = "";
        private String Colisao = "";
        private String Musica = "";
        private int Largura = 0;
        private int Altura = 0;

        public String getNome(){return Nome;}
        public String getArquivo(){return Arquivo;}
        public String getMiniatura(){return Miniatura;}
        public String getColisao(){return Colisao;}
        public String getMusica(){return Musica;}
        public int getLargura(){return Largura;}
        public int getAltura(){return Altura;}

        public void setNome(String novoNome){Nome=novoNome;}
        public void setMiniatura(String novaMiniatura){Miniatura=novaMiniatura;}
        public void setArquivo(String novoArquivo){Arquivo=novoArquivo;}
        public void setColisao(String novaColisao){Colisao=novaColisao;}
        public void setMusica(String novaMusica){Musica=novaMusica;}
        public void setLargura(int novaLargura){Largura=novaLargura;}
        public void setAltura(int novaAltura){Altura=novaAltura;}
    }
}

