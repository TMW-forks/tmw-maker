package Classes;

public class XMLdeEquip {
    public XMLdeEquip(String Nome, String Endereco, int Linhas, int Colunas){
        Banco_Nome=Nome;
        SpriteDados = new SpriteDados(Endereco, Linhas, Colunas);
    }
    public XMLdeEquip(String Nome, SpriteDados Sprite){
        Banco_Nome=Nome;
        SpriteDados = Sprite;
    }
    public XMLdeEquip(String Nome, String Endereco, int Linhas, int Colunas, XmlAcao Acoes[]){
        Banco_Nome=Nome;
        SpriteDados = new SpriteDados(Endereco, Linhas, Colunas);
        Banco_Acoes= Acoes;
    }
    public XMLdeEquip(String Nome, SpriteDados Sprite, XmlAcao Acoes[]){
        Banco_Nome=Nome;
        SpriteDados = Sprite;
        Banco_Acoes= Acoes;
    }

    private String Banco_Nome="";
    private SpriteDados SpriteDados = null;
    private XmlAcao Banco_Acoes[]; //Não deve ser instaciado agora!!!!

    public String getNome(){return Banco_Nome;}
    public SpriteDados getSpriteDados(){return SpriteDados;}
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
    public void setSpriteDados(SpriteDados NovoSpriteDados){SpriteDados=NovoSpriteDados;}
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
}