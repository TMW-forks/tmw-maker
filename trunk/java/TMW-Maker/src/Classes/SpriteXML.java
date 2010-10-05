package Classes;

import Formularios.FrmPrincipal;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SpriteXML {
    private static String Barra = System.getProperty("file.separator");
    private static String TMWData=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata";

    public SpriteXML(String Endereco){
        if(FileClass.seExiste(Endereco)){
            Element Elementos=FileClass.arquivoAbrirXML(Endereco);
            NodeList noImageset = Elementos.getElementsByTagName("imageset"); //elemento="usuario"
            Element tagImageset = (Element) noImageset.item(0);
            Banco_Nome=FileClass.getAtributo(tagImageset,"name","");

            String src=TMWData+Barra+FileClass.getAtributo(tagImageset,"src","");
            String Arquivo="", Recolor="";
            if(src.indexOf("|")>=0){
                String Partes2[]=src.split("\\|");
                if(Partes2.length==2){
                    Arquivo=Partes2[0];
                    Recolor=Partes2[1];
                }else if(Partes2.length>=3){
                    Arquivo=Partes2[0];
                }
            }else{
                Arquivo=src;
            }

            ImagemClass Imagem = new ImagemClass(Arquivo);
            SpriteDados = new SpritePNG(
                Arquivo,
                Imagem.getAltura()/FileClass.getAtributo(tagImageset,"height",0),
                Imagem.getLargura()/FileClass.getAtributo(tagImageset,"width",0)
            );

            NodeList noAction = Elementos.getElementsByTagName("action"); //elemento="usuario"
            for (int Ac = 0; Ac < noAction.getLength(); Ac++) {
                //Vector Registro = new Vector();
                Element tagAction = (Element) noAction.item(Ac);
                addAcao(
                    FileClass.getAtributo(tagAction,"name",""),
                    FileClass.getAtributo(tagAction,"imageset","")
                );
                //NodeList noAnimacao = noAction.item(Ac).getChildNodes(); //elemento="usuario"
                NodeList noAnimacao = tagAction.getElementsByTagName("animation");
                for (int An = 0; An < noAnimacao.getLength(); An++) {
                    Element tagAnimacao = (Element) noAnimacao.item(An);
                    getAcao(Ac).addAnimacao(FileClass.getAtributo(tagAnimacao,"direction",""));

                    //NodeList noFrame = noAnimacao.item(An).getChildNodes(); //elemento="usuario"
                    NodeList noFrame = tagAnimacao.getElementsByTagName("*");
                    //NodeList noFrame = tagAnimacao.getChildNodes();
                    for (int Fr = 0; Fr < noFrame.getLength(); Fr++) {
                        Element tagComando = (Element) noFrame.item(Fr); // Comando = Frame ou Sequence
                        if(tagComando.getTagName().toLowerCase().equals("frame")){
                            getAcao(Ac).getAnimacao(An).addFrame(
                                FileClass.getAtributo(tagComando,"index",0),
                                FileClass.getAtributo(tagComando,"offsetX",0),
                                FileClass.getAtributo(tagComando,"offsetY",0),
                                FileClass.getAtributo(tagComando,"delay",0)
                            );
                        }else if(tagComando.getTagName().toLowerCase().equals("frame")){
                            getAcao(Ac).getAnimacao(An).addSequencia(
                                FileClass.getAtributo(tagComando,"start",0),
                                FileClass.getAtributo(tagComando,"end",0),
                                FileClass.getAtributo(tagComando,"offsetX",0),
                                FileClass.getAtributo(tagComando,"offsetY",0),
                                FileClass.getAtributo(tagComando,"delay",0)
                            );
                        }
                    }
                }
            }
        }
    }
    public SpriteXML(String Nome, String Endereco, int Linhas, int Colunas){
        Banco_Nome=Nome;
        SpriteDados = new SpritePNG(Endereco, Linhas, Colunas);
    }
    public SpriteXML(String Nome, SpritePNG Sprite){
        Banco_Nome=Nome;
        SpriteDados = Sprite;
    }
    public SpriteXML(String Nome, String Endereco, int Linhas, int Colunas, XmlAcao Acoes[]){
        Banco_Nome=Nome;
        SpriteDados = new SpritePNG(Endereco, Linhas, Colunas);
        Banco_Acoes= Acoes;
    }
    public SpriteXML(String Nome, SpritePNG Sprite, XmlAcao Acoes[]){
        Banco_Nome=Nome;
        SpriteDados = Sprite;
        Banco_Acoes= Acoes;
    }

    private String Banco_Nome="";
    private SpritePNG SpriteDados = null;
    private XmlAcao Banco_Acoes[]; //Não deve ser instaciado agora!!!!

    public String getNome(){return Banco_Nome;}
    public SpritePNG getDadosPNG(){return SpriteDados;}
    public String getEnderecoPNG(){return SpriteDados.getEnderecoPNG();}
    public XmlAcao[] getAcoes(){return Banco_Acoes;}
    public XmlAcao getAcao(int Ordem){
        if(Banco_Acoes != null){
            return Banco_Acoes[Ordem];
        }else{
            return null;
        }
    }
    public XmlAcao getAcao(String Nome){
        if(Banco_Acoes != null){
            for(int a=0;a<Banco_Acoes.length;a++){
                if(Banco_Acoes[a].getNome().equals(Nome)){
                   return Banco_Acoes[a];
                }
            }
        }
        return null;
    }
    public boolean haAcao(String Nome){
        if(Banco_Acoes != null){
            for(int a=0;a<Banco_Acoes.length;a++){
                if(Banco_Acoes[a].getNome().equals(Nome)){
                   return true;
                }
            }
        }
        return false;
    }
    public int getOrdem(String Nome){
        if(Banco_Acoes != null){
            for(int a=0;a<Banco_Acoes.length;a++){
                if(Banco_Acoes[a].getNome().equals(Nome)){
                   return a;
                }
            }
            return -1;
        }else{
            return -1;
        }
    }
    public int getContAcoes(){
        if(Banco_Acoes != null){
            return Banco_Acoes.length;
        }else{
            return 0;
        }
    }

    public void setNome(String NovoNome){Banco_Nome=NovoNome;}
    public void setSpriteDados(SpritePNG NovoSpriteDados){SpriteDados=NovoSpriteDados;}
    public void setAcoes(XmlAcao NovasAcoes[]){Banco_Acoes=NovasAcoes;}
    public void setAcao(int Ordem, XmlAcao NovaAcao){
        Banco_Acoes[Ordem]=NovaAcao;
    }
    public void addAcao(String NomeAcao){
        addAcao(new XmlAcao(NomeAcao));
    }
    public void addAcao(String NomeAcao, String novaImageSet){
        if(Banco_Acoes != null){
            XmlAcao Novas_Acoes[] = new XmlAcao[Banco_Acoes.length+1];
            for(int b=0;b<Banco_Acoes.length;b++){
                //Novas_Acoes[b] = new XmlAcao(Banco_Acoes[b].getNome(),Banco_Acoes[b].getAnimacoes());
                Novas_Acoes[b] = getAcao(b);
            }
            Novas_Acoes[Banco_Acoes.length] = new XmlAcao(NomeAcao, novaImageSet);
            Banco_Acoes = Novas_Acoes;
        }else{
            XmlAcao Novo_Banco_Acoes[] = new XmlAcao[1];
            Novo_Banco_Acoes[0] = new XmlAcao(NomeAcao, novaImageSet);
            Banco_Acoes = Novo_Banco_Acoes;
        }
    }
    public void addAcao(XmlAcao NovaAcao){
        if(Banco_Acoes != null){
            XmlAcao Novo_Banco_Acoes[] = new XmlAcao[Banco_Acoes.length+1];
            for(int b=0;b<Banco_Acoes.length;b++){
                Novo_Banco_Acoes[b] = new XmlAcao(Banco_Acoes[b].getNome(),Banco_Acoes[b].getAnimacoes());
            }
            Novo_Banco_Acoes[Banco_Acoes.length] = new XmlAcao(NovaAcao.getNome(), NovaAcao.getAnimacoes());
            Banco_Acoes = Novo_Banco_Acoes;
        }else{
            XmlAcao Novo_Banco_Acoes[] = new XmlAcao[1];
            Novo_Banco_Acoes[0] = new XmlAcao(NovaAcao.getNome(), NovaAcao.getAnimacoes());
            Banco_Acoes = Novo_Banco_Acoes;
        }
    }
//#################################################################################################
    //package Classes.XmlDeEquip;
    public class XmlAcao {
        public XmlAcao(String Nome){this.Nome=Nome;}
        public XmlAcao(String novoNome, String novaImageSet){
            Nome=novoNome;
            ImageSet=novaImageSet;
        }
        public XmlAcao(String Nome, XmlAnimacao Animacoes[]){
            this.Nome=Nome;
            Banco_Animacoes = Animacoes;
        }

        private String Nome="";
        private String ImageSet="";
        private XmlAnimacao Banco_Animacoes[]; //Não deve ser instaciado agora!!!!


        public String getNome(){return Nome;}
        public XmlAnimacao[] getAnimacoes(){return Banco_Animacoes;}
        public XmlAnimacao getAnimacao(int Ordem){
            if(Banco_Animacoes != null){
                return Banco_Animacoes[Ordem];
            }else{
                return null;
            }
        }
        public XmlAnimacao getAnimacao(String Direcao){
            if(Banco_Animacoes != null){
                for(int d=0;d<Banco_Animacoes.length;d++){
                    if(Banco_Animacoes[d].getNome().equals(Direcao)){
                       return Banco_Animacoes[d];
                    }
                }
            }
            return null;
        }
        public boolean haAnimacao(String Direcao){
            if(Banco_Animacoes != null){
                for(int d=0;d<Banco_Animacoes.length;d++){
                    if(Banco_Animacoes[d].getNome().equals(Direcao)){
                       return true;
                    }
                }
            }
            return false;
        }
        public int getOrdem(String Nome){
            if(Banco_Animacoes != null){
                for(int d=0;d<Banco_Animacoes.length;d++){
                    if(Banco_Animacoes[d].getNome().equals(Nome)){
                       return d;
                    }
                }
                return -1;
            }else{
                return -1;
            }
        }
        public int getContAnimacoes(){
            if(Banco_Animacoes != null){
                return Banco_Animacoes.length;
            }else{
                return 0;
            }
        }

        public void setNome(String NovoNome){Nome=NovoNome;}
        public void setAnimacoes(XmlAnimacao Animacoes[]){Banco_Animacoes = Animacoes;}
        public void setAnimacao(int Ordem, XmlAnimacao Animacao){
            Banco_Animacoes[Ordem]=Animacao;
        }
        public void addAnimacao(String NomeDirecao){
            //addAnimacao(new XmlAnimacao(NomeDirecao));
            if(Banco_Animacoes != null){
                XmlAnimacao Novas_Animacoes[] = new XmlAnimacao[Banco_Animacoes.length+1];
                for(int b=0;b<Banco_Animacoes.length;b++){
                    //Novas_Animacoes[b] = new XmlAnimacao(Banco_Animacoes[b].getNome(),Banco_Animacoes[b].getFrames());
                    Novas_Animacoes[b]=getAnimacao(b);
                }
                Novas_Animacoes[Banco_Animacoes.length] = new XmlAnimacao(NomeDirecao);
                Banco_Animacoes = Novas_Animacoes;
            }else{
                XmlAnimacao Novas_Animacoes[] = new XmlAnimacao[1];
                Novas_Animacoes[0] = new XmlAnimacao(NomeDirecao);
                Banco_Animacoes = Novas_Animacoes;
            }
        }
        public void addAnimacao(XmlAnimacao NovaAnimacao){
            if(Banco_Animacoes != null){
                XmlAnimacao Novo_Banco_Animacoes[] = new XmlAnimacao[Banco_Animacoes.length+1];
                for(int b=0;b<Banco_Animacoes.length;b++){
                    Novo_Banco_Animacoes[b] = new XmlAnimacao(Banco_Animacoes[b].getNome(),Banco_Animacoes[b].getFrames());
                }
                Novo_Banco_Animacoes[Banco_Animacoes.length] = new XmlAnimacao(NovaAnimacao.getNome(), NovaAnimacao.getFrames());
                Banco_Animacoes = Novo_Banco_Animacoes;
            }else{
                XmlAnimacao Novo_Banco_Animacoes[] = new XmlAnimacao[1];
                Novo_Banco_Animacoes[0] = new XmlAnimacao(NovaAnimacao.getNome(), NovaAnimacao.getFrames());
                Banco_Animacoes = Novo_Banco_Animacoes;
            }
        }

        //package Classes.XmlDeEquip;
        public class XmlAnimacao {
            public XmlAnimacao(String Nome){Banco_Nome=Nome;}
            public XmlAnimacao(String Nome, XmlFrame Frames[]){
                Banco_Nome=Nome;
                Banco_Frames = Frames;
                /*Banco_Frames = new Frame[Frames.length];
                for(int b=0;b<Frames.length;b++){
                    Banco_Frames[b] = new Frame();
                    Banco_Frames[b].setIndex(Frames[b].getIndex());
                    Banco_Frames[b].setOffsetX(Frames[b].getOffsetX());
                    Banco_Frames[b].setOffsetY(Frames[b].getOffsetY());
                    Banco_Frames[b].setDelay(Frames[b].getDelay());
                }/**/
            }

            private String Banco_Nome="";
            private XmlFrame Banco_Frames[]; //Não deve ser instaciado agora!!!!

            public String getNome(){return Banco_Nome;}
            public XmlFrame[] getFrames(){return Banco_Frames;}
            public XmlFrame getFrame(int Ordem){
                if(Banco_Frames != null){
                    return Banco_Frames[Ordem];
                }else{
                    return null;
                }
            }
            public int getContFrames(){
                if(Banco_Frames != null){
                    return Banco_Frames.length;
                }else{
                    return 0;
                }
            }

            public void setNome(String NovoNome){Banco_Nome=NovoNome;}
            public void setFrames(XmlFrame Frames[]){Banco_Frames = Frames;}
            public void setFrame(int Ordem, XmlFrame Frame){
                Banco_Frames[Ordem]=Frame;
            }
            public void addFrame(int Index, int OffsetX, int OffsetY, int Delay){
                addFrame(new XmlFrame(Index, OffsetX, OffsetY, Delay));
            }
            public void addFrame(XmlFrame NovoFrame){
                if(Banco_Frames != null){
                    XmlFrame Novo_Banco_Frames[] = new XmlFrame[Banco_Frames.length+1];
                    for(int b=0;b<Banco_Frames.length;b++){
                        Novo_Banco_Frames[b] = new XmlFrame(
                            Banco_Frames[b].getIndex(),
                            Banco_Frames[b].getOffsetX(),
                            Banco_Frames[b].getOffsetY(),
                            Banco_Frames[b].getDelay()
                        );
                    }
                    Novo_Banco_Frames[Banco_Frames.length] = new XmlFrame(
                        NovoFrame.getIndex(),
                        NovoFrame.getOffsetX(),
                        NovoFrame.getOffsetY(),
                        NovoFrame.getDelay()
                    );
                    Banco_Frames = Novo_Banco_Frames;
                }else{
                    XmlFrame Novo_Banco_Frames[] = new XmlFrame[1];

                    Novo_Banco_Frames[0] = new XmlFrame(
                        NovoFrame.getIndex(),
                        NovoFrame.getOffsetX(),
                        NovoFrame.getOffsetY(),
                        NovoFrame.getDelay()
                    );
                    Banco_Frames = Novo_Banco_Frames;
                }
            }
            public void addSequencia(int IndexInicio, int IndexFinal, int OffsetX, int OffsetY, int Delay){
                for(int f=IndexInicio;f<=IndexFinal;f++){
                    addFrame(f, OffsetX, OffsetY, Delay);
                }
            }

            //package Classes.XmlDeEquip;
            public class XmlFrame {
                public XmlFrame(int NovoIndex){
                    index=NovoIndex;
                }
                public XmlFrame(int NovoIndex, int NovoOffsetX, int NovoOffsetY, int NovoDelay){
                    index=NovoIndex;
                    offsetX=NovoOffsetX;
                    offsetY=NovoOffsetY;
                    delay=NovoDelay;
                }

                private int index = 0;
                private int offsetX = 0;
                private int offsetY = 0;
                private int delay = 0;

                public int getIndex(){return index;}
                public int getOffsetX(){return offsetX;}
                public int getOffsetY(){return offsetY;}
                public int getDelay(){return delay;}

                public void setIndex(int NovoIndex){index=NovoIndex;}
                public void setOffsetX(int NovoOffsetX){offsetX=NovoOffsetX;}
                public void setOffsetY(int NovoOffsetY){offsetY=NovoOffsetY;}
                public void setDelay(int NovoDelay){delay=NovoDelay;}
            }

        }

    }

}