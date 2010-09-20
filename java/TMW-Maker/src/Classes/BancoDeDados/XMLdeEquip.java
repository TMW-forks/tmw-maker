package Classes.BancoDeDados;

import Classes.SpriteClass;

public class XMLdeEquip {
    public XMLdeEquip(String Nome, String Endereco, int Linhas, int Colunas){
        Banco_Nome=Nome;
        SpriteDados = new SpriteClass(Endereco, Linhas, Colunas);
    }
    public XMLdeEquip(String Nome, SpriteClass Sprite){
        Banco_Nome=Nome;
        SpriteDados = Sprite;
    }
    public XMLdeEquip(String Nome, String Endereco, int Linhas, int Colunas, XmlAcao Acoes[]){
        Banco_Nome=Nome;
        SpriteDados = new SpriteClass(Endereco, Linhas, Colunas);
        Banco_Acoes= Acoes;
    }
    public XMLdeEquip(String Nome, SpriteClass Sprite, XmlAcao Acoes[]){
        Banco_Nome=Nome;
        SpriteDados = Sprite;
        Banco_Acoes= Acoes;
    }

    private String Banco_Nome="";
    private SpriteClass SpriteDados = null;
    private XmlAcao Banco_Acoes[]; //Não deve ser instaciado agora!!!!

    public String getNome(){return Banco_Nome;}
    public SpriteClass getSpriteDados(){return SpriteDados;}
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
            return null;
        }else{
            return null;
        }
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
    public void setSpriteDados(SpriteClass NovoSpriteDados){SpriteDados=NovoSpriteDados;}
    public void setAcoes(XmlAcao NovasAcoes[]){Banco_Acoes=NovasAcoes;}
    public void setAcao(int Ordem, XmlAcao NovaAcao){
        Banco_Acoes[Ordem]=NovaAcao;
    }
    public void setNovaAcao(String NomeAcao){
        setNovaAcao(new XmlAcao(NomeAcao));
    }
    public void setNovaAcao(XmlAcao NovaAcao){
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
        public XmlAcao(String Nome){Banco_Nome=Nome;}
        public XmlAcao(String Nome, XmlAnimacao Animacoes[]){
            Banco_Nome=Nome;
            Banco_Animacoes = Animacoes;
        }

        private String Banco_Nome="";
        private XmlAnimacao Banco_Animacoes[]; //Não deve ser instaciado agora!!!!


        public String getNome(){return Banco_Nome;}
        public XmlAnimacao[] getAnimacoes(){return Banco_Animacoes;}
        public XmlAnimacao getAnimacao(int Ordem){
            if(Banco_Animacoes != null){
                return Banco_Animacoes[Ordem];
            }else{
                return null;
            }
        }
        public XmlAnimacao getAnimacao(String Nome){
            if(Banco_Animacoes != null){
                for(int d=0;d<Banco_Animacoes.length;d++){
                    if(Banco_Animacoes[d].getNome().equals(Nome)){
                       return Banco_Animacoes[d];
                    }
                }
                return null;
            }else{
                return null;
            }
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

        public void setNome(String NovoNome){Banco_Nome=NovoNome;}
        public void setAnimacoes(XmlAnimacao Animacoes[]){Banco_Animacoes = Animacoes;}
        public void setAnimacao(int Ordem, XmlAnimacao Animacao){
            Banco_Animacoes[Ordem]=Animacao;
        }
        public void setNovaAnimacao(String NomeAnimacao){
            setNovaAnimacao(new XmlAnimacao(NomeAnimacao));
        }
        public void setNovaAnimacao(XmlAnimacao NovaAnimacao){
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
        public void setNovoFrame(int Index, int OffsetX, int OffsetY, int Delay){
            setNovoFrame(new XmlFrame(Index, OffsetX, OffsetY, Delay));
        }
        public void setNovoFrame(XmlFrame NovoFrame){
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
        public void setNovaSequencia(int IndexInicio, int IndexFinal, int OffsetX, int OffsetY, int Delay){
            for(int f=IndexInicio;f<=IndexFinal;f++){
                setNovoFrame(f, OffsetX, OffsetY, Delay);
            }
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