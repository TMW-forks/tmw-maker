package Classes;

public class XMLdeEquip {
    public XMLdeEquip(String Endereco, int Linhas, int Colunas){
        SpriteDados = new SpriteDados(Endereco, Linhas, Colunas);
    }
    public XMLdeEquip(String Endereco, int Linhas, int Colunas, Acao Acoes[]){
        SpriteDados = new SpriteDados(Endereco, Linhas, Colunas);
        Banco_Acoes= Acoes;
    }

    private static String Banco_Nome="";
    private static SpriteDados SpriteDados = null;
    private static Acao Banco_Acoes[]; //Não deve ser instaciado agora!!!!

    public String getNome(){return Banco_Nome;}
    public SpriteDados getSpriteDados(){return SpriteDados;}
    public Acao[] getAcoes(){return Banco_Acoes;}
    public Acao getAcao(int Ordem){return Banco_Acoes[Ordem];}
    public Acao getAcao(String Nome){
        for(int a=0;a<Banco_Acoes.length;a++){
            if(Banco_Acoes[a].getNome().equals(Nome)){
               return Banco_Acoes[a];
            }
        }
        return null;
    }
    public int getOrdem(String Nome){
        for(int a=0;a<Banco_Acoes.length;a++){
            if(Banco_Acoes[a].getNome().equals(Nome)){
               return a;
            }
        }
        return -1;
    }
    public int getContAcoes(){return Banco_Acoes.length;}

    public void setNome(String NovoNome){Banco_Nome=NovoNome;}
    public void setSpriteDados(SpriteDados NovoSpriteDados){SpriteDados=NovoSpriteDados;}
    public void setAcoes(Acao NovasAcoes[]){Banco_Acoes=NovasAcoes;}
    public void setAcao(int Ordem, Acao NovaAcao){
        Banco_Acoes[Ordem]=NovaAcao;
    }
    public void setNovaAnimacao(Acao NovaAcao){
        Acao Novo_Banco_Acoes[] = new Acao[Banco_Acoes.length+1];
        for(int b=0;b<Banco_Acoes.length;b++){
            Novo_Banco_Acoes[b] = new Acao(Banco_Acoes[b].getNome(),Banco_Acoes[b].getAnimacoes());
        }
        Novo_Banco_Acoes[Banco_Acoes.length] = new Acao(NovaAcao.getNome(), NovaAcao.getAnimacoes());
        Banco_Acoes = Novo_Banco_Acoes;
    }

}

class Acao {
    public Acao(String Nome){Banco_Nome=Nome;}
    public Acao(String Nome, Animacao Animacoes[]){
        Banco_Nome=Nome;
        Banco_Animacoes = Animacoes;
    }

    private static String Banco_Nome="";
    private static Animacao Banco_Animacoes[]; //Não deve ser instaciado agora!!!!

    public String getNome(){return Banco_Nome;}
    public Animacao[] getAnimacoes(){return Banco_Animacoes;}
    public Animacao getAnimacao(int Ordem){return Banco_Animacoes[Ordem];}
    public Animacao getAnimacao(String Nome){
        for(int d=0;d<Banco_Animacoes.length;d++){
            if(Banco_Animacoes[d].getNome().equals(Nome)){
               return Banco_Animacoes[d];
            }
        }
        return null;
    }
    public int getOrdem(String Nome){
        for(int d=0;d<Banco_Animacoes.length;d++){
            if(Banco_Animacoes[d].getNome().equals(Nome)){
               return d;
            }
        }
        return -1;
    }
    public int getContAnimacoes(){return Banco_Animacoes.length;}

    public void setNome(String NovoNome){Banco_Nome=NovoNome;}
    public void setAnimacoes(Animacao Animacoes[]){Banco_Animacoes = Animacoes;}
    public void setAnimacao(int Ordem, Animacao Animacao){
        Banco_Animacoes[Ordem]=Animacao;
    }
    public void setNovaAnimacao(Animacao NovaAnimacao){
        Animacao Novo_Banco_Animacoes[] = new Animacao[Banco_Animacoes.length+1];
        for(int b=0;b<Banco_Animacoes.length;b++){
            Novo_Banco_Animacoes[b] = new Animacao(Banco_Animacoes[b].getNome(),Banco_Animacoes[b].getFrames());
        }
        Novo_Banco_Animacoes[Banco_Animacoes.length] = new Animacao(NovaAnimacao.getNome(), NovaAnimacao.getFrames());
        Banco_Animacoes = Novo_Banco_Animacoes;
    }
}
class Animacao {
    public Animacao(String Nome){Banco_Nome=Nome;}
    public Animacao(String Nome, Frame Frames[]){
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

    private static String Banco_Nome="";
    private static Frame Banco_Frames[]; //Não deve ser instaciado agora!!!!

    public String getNome(){return Banco_Nome;}
    public Frame[] getFrames(){return Banco_Frames;}
    public Frame getFrame(int Ordem){return Banco_Frames[Ordem];}
    public int getContFrames(){return Banco_Frames.length;}

    public void setNome(String NovoNome){Banco_Nome=NovoNome;}
    public void setFrames(Frame Frames[]){Banco_Frames = Frames;}
    public void setFrame(int Ordem, Frame Frame){
        Banco_Frames[Ordem]=Frame;
    }
    public void setNovoFrame(Frame NovoFrame){
        Frame Novo_Banco_Frames[] = new Frame[Banco_Frames.length+1];
        for(int b=0;b<Banco_Frames.length;b++){
            Novo_Banco_Frames[b] = new Frame(
                Banco_Frames[b].getIndex(),
                Banco_Frames[b].getOffsetX(),
                Banco_Frames[b].getOffsetY(),
                Banco_Frames[b].getDelay()
            );
        }
        Novo_Banco_Frames[Banco_Frames.length] = new Frame(
            NovoFrame.getIndex(),
            NovoFrame.getOffsetX(),
            NovoFrame.getOffsetY(),
            NovoFrame.getDelay()
        );
        Banco_Frames = Novo_Banco_Frames;
    }
}
class Frame {
    public Frame(){ }
    public Frame(int NovoIndex, int NovoOffsetX, int NovoOffsetY, int NovoDelay){
        index=NovoIndex;
        offsetX=NovoOffsetX;
        offsetY=NovoOffsetY;
        delay=NovoDelay;
    }/**/

    private static int index = 0;
    private static int offsetX = 0;
    private static int offsetY = 0;
    private static int delay = 0;

    public int getIndex(){return index;}
    public int getOffsetX(){return offsetX;}
    public int getOffsetY(){return offsetY;}
    public int getDelay(){return delay;}

    public void setIndex(int NovoIndex){index=NovoIndex;}
    public void setOffsetX(int NovoOffsetX){offsetX=NovoOffsetX;}
    public void setOffsetY(int NovoOffsetY){offsetY=NovoOffsetY;}
    public void setDelay(int NovoDelay){delay=NovoDelay;}
}
