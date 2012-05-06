package Classes.BancoDeDados;

import Classes.DialogClass;
import Classes.FileClass;
import Classes.StringClass;
import Formularios.FrmPrincipal;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        FrmPrincipal.PgbBarra.setIndeterminate(false);
        FrmPrincipal.PgbBarra.setEnabled(true);
        FrmPrincipal.PgbBarra.setMinimum(0);

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
													try {
	                                       Element tagMap = FileClass.arquivoAbrirXML(mapaTMX);
														NodeList noProperties = tagMap.getElementsByTagName("properties");
														if (noProperties.getLength() >= 1) {
															int Largura = 0, Altura = 0;
															String Nome = "", Miniatura = "", Musica = "";
															Largura = FileClass.getAtributo(tagMap, "width", 0);
															Altura = FileClass.getAtributo(tagMap, "height", 0);
															FrmPrincipal.setAvisoEmEstatus(
																	  FrmPrincipal.traducao.getTraducaoNormatizada(
																	  "FrmSplash", "bdWarps.getMap(%)",
																	  "[html]Carregando Mapa: \"[color[#0000FF]color]%1.tmx[/color]\" (%2x%3)!",
																	  mapaNome + "&&" + Largura + "&&" + Altura),
																	  new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_globo.gif")));
															Element tagProperties = (Element) noProperties.item(0);
															NodeList noProperty = tagProperties.getElementsByTagName("property");
															for (int Pr = 0; Pr < noProperty.getLength(); Pr++) {
																Element tagProperty = (Element) noProperty.item(Pr);
																String propName = FileClass.getAtributo(tagProperty, "name", "");
																String propValue = FileClass.getAtributo(tagProperty, "value", "");
																if (propName.equals("name")) {
																	Nome = propValue;
																}
																if (propName.equals("minimap")) {
																	Miniatura = propValue.replaceAll("/graphics/minimaps/", "");
																}
																if (propName.equals("music")) {
																	Musica = propValue;
																}
																if (!Nome.equals("") && !Miniatura.equals("") && !Musica.equals("")) {
																	Pr = noProperty.getLength();
																}
															}
															addMapa(Nome, Miniatura, mapaNome + ".tmx", mapaNome + ".wlk", Musica, Largura, Altura);
														}
													} catch (NullPointerException ex) {
														Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
														//DialogClass.showErro(ex.getMessage(), ex.getLocalizedMessage());
													} catch (Exception ex) {
														Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
														//DialogClass.showErro(ex.getMessage(), ex.getLocalizedMessage());
													}
                                        

                                        
                                        



























//////////////////////////////////////////////////////// PARA COLPILAR ////////////////////////////////////////////////////////////

                                    }else{
                                        String Testo=FrmPrincipal.traducao.getTraducaoNormatizada(
                                            "FrmSplash", "bdWarps.getErro(noFoundMap)",
                                            "[html][color[#FF0000]color]ERRO:[/color] Não foi possivel encontrar o mapa\"[color[#FF0000]color]%1.tmx[/color]\"!",
                                            mapaNome
                                        );
                                        FrmPrincipal.setAvisoEmEstatus(Testo,new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png")));
                                        DialogClass.showErro(Testo,FrmPrincipal.traducao.getTraducao("FrmSplash", "bdWarps.Compilador","Compilador"));
                                        FrmPrincipal.PgbBarra.setString(FrmPrincipal.traducao.getTraducao("FrmSplash", "PgbBarra(Erro)","ERRO!"));
                                        return;
                                    }
                                }//else{DialogClass.showErro("Arquivo\""+importador+"\" bloqueado!", "Copilador");}
                            }else{
                                String Testo=FrmPrincipal.traducao.getTraducaoNormatizada(
                                    "FrmSplash", "bdWarps.getErro(noFoundMob)",
                                    "[html][color[#FF0000]color]ERRO:[/color] Não foi possivel encontrar os spawns \"[color[#FF0000]color]%1.tmx[/color]\"!",
                                    mobs
                                );
                                FrmPrincipal.setAvisoEmEstatus(Testo,new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png")));
                                DialogClass.showErro(Testo,FrmPrincipal.traducao.getTraducao("FrmSplash", "bdWarps.Compilador","Compilador"));
                                FrmPrincipal.PgbBarra.setString(FrmPrincipal.traducao.getTraducao("FrmSplash", "PgbBarra(Erro)","ERRO!"));
                                return;
                            }
                        }else{
                            String Testo=FrmPrincipal.traducao.getTraducaoNormatizada(
                                "FrmSplash", "bdWarps.getErro(noFoundWarps)",
                                "[html][color[#FF0000]color]ERRO:[/color] Não foi possivel encontrar os portais \"[color[#FF0000]color]%1.tmx[/color]\"!",
                                warps
                            );
                            FrmPrincipal.setAvisoEmEstatus(Testo,new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png")));
                            DialogClass.showErro(Testo,FrmPrincipal.traducao.getTraducao("FrmSplash", "bdWarps.Compilador","Compilador"));
                            FrmPrincipal.PgbBarra.setString(FrmPrincipal.traducao.getTraducao("FrmSplash", "PgbBarra(Erro)","ERRO!"));
                            return;
                        }
                    }//else{DialogClass.showErro("Não foi possivel encontrar o arquivo\""+importador+"\"!", "Copilador");}
                }
            }
        }
        FrmPrincipal.PgbBarra.setString(FrmPrincipal.traducao.getTraducao("FrmSplash", "PgbBarra(Concluido)","Concluido!"));
        FrmPrincipal.setAvisoEmEstatus(
            FrmPrincipal.traducao.getTraducaoNormatizada(
                "FrmSplash", "bdWarps.End()",
                "[html]Compilação semi-concluida! ([color[#FF0000]color]Função Deprecada[/color])"
            ),
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
    public Vector getMapasVector(){
        Vector Mapas = new Vector();
        for(int l=0;l<getContMapas();l++){
            Mapas.addElement(getMapaPorOrdem(l).getArquivo().replaceAll(".tmx", ""));
        }
        return Mapas;
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

