package Classes;

public class XMLdeEquip {
    public XMLdeEquip(String Endereco, int Linhas, int Colunas){
        SpriteDados = new SpriteDados(Endereco, Linhas, Colunas);
    }
    static SpriteDados SpriteDados = null;
    public SpriteDados getSpriteDados(){return SpriteDados;}
    public void setSpriteDados(SpriteDados NovoSpriteDados){SpriteDados=NovoSpriteDados;}
}

class Banco_Animacoes {
    static SpriteDados SpriteDados = null;
    public SpriteDados getSpriteDados(){return SpriteDados;}
    public void setSpriteDados(SpriteDados NovoSpriteDados){SpriteDados=NovoSpriteDados;}
}
class Banco_Direcoes {
    public Banco_Direcoes(){
        Banco_Blocos = new Banco_Blocos();
    }
    static Banco_Blocos Banco_Blocos = null;
}
class Banco_Blocos {
    static int Index = 0;
    static int OffsetX = 0;
    static int OffsetY = 0;
    static int Delay = 0;
}
