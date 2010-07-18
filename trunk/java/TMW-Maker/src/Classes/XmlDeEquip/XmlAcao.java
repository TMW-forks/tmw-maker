package Classes.XmlDeEquip;

public class XmlAcao {
    public XmlAcao(String Nome){Banco_Nome=Nome;}
    public XmlAcao(String Nome, XmlAnimacao Animacoes[]){
        Banco_Nome=Nome;
        Banco_Animacoes = Animacoes;
    }

    private static String Banco_Nome="";
    private static XmlAnimacao Banco_Animacoes[]; //Não deve ser instaciado agora!!!!


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
