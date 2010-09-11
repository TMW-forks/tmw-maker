package Classes.BancoDeDados;

public class Banco_Lojas {
    private static Dados_Lojas Lojas[]; //Não deve ser instaciado agora!!!!
    public Banco_Lojas(String Arquivo){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void addLoja(String nomeLoja, int imagemILoja, String mapa, int coordX, int coordY){
        if(Lojas != null){
            Dados_Lojas NovaGaleria[] = new Dados_Lojas[Lojas.length+1];
            for(int b=0;b<Lojas.length;b++){
                NovaGaleria[b] = new Dados_Lojas(
                    Lojas[b].getNomeLoja(),
                    Lojas[b].getImagemLoja(),
                    Lojas[b].getMapa(),
                    Lojas[b].getCoordX(),
                    Lojas[b].getCoordY()
                );
            }
            NovaGaleria[Lojas.length] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            Lojas = NovaGaleria;
        }else{
            Dados_Lojas NovaGaleria[] = new Dados_Lojas[1];
            NovaGaleria[0] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            Lojas = NovaGaleria;
        }
    }
    public void addLoja(String nomeLoja, int imagemILoja, String mapa, int coordX, int coordY, Dados_LojaProduto NovosProdutos[]){
        if(Lojas != null){
            Dados_Lojas NovaGaleria[] = new Dados_Lojas[Lojas.length+1];
            for(int b=0;b<Lojas.length;b++){
                NovaGaleria[b] = new Dados_Lojas(
                    Lojas[b].getNomeLoja(),
                    Lojas[b].getImagemLoja(),
                    Lojas[b].getMapa(),
                    Lojas[b].getCoordX(),
                    Lojas[b].getCoordY(),
                    Lojas[b].getProdutos()
                );
            }
            NovaGaleria[Lojas.length] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            Lojas = NovaGaleria;
        }else{
            Dados_Lojas NovaGaleria[] = new Dados_Lojas[1];
            NovaGaleria[0] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            Lojas = NovaGaleria;
        }
    }
    public void delLojaPorNome(String nomeLoja){
        if(Lojas != null){
            Dados_Lojas NovaGaleria[] = new Dados_Lojas[Lojas.length-1];
            int contLojas=0;
            for(int b=0;b<Lojas.length;b++){
                if(Lojas[b].getNomeLoja().equals(nomeLoja)){
                    contLojas++;
                    NovaGaleria[contLojas-1] = new Dados_Lojas(
                        Lojas[b].getNomeLoja(),
                        Lojas[b].getImagemLoja(),
                        Lojas[b].getMapa(),
                        Lojas[b].getCoordX(),
                        Lojas[b].getCoordY(),
                        Lojas[b].getProdutos()
                    );
                }
            }
            Lojas = NovaGaleria;
        }
    }
    public void delLojaPorOrdem(int ordem){
        if(Lojas != null){
            Dados_Lojas NovaGaleria[] = new Dados_Lojas[Lojas.length-1];
            int contLojas=0;
            for(int b=0;b<Lojas.length;b++){
                if(b!=ordem){
                    contLojas++;
                    NovaGaleria[contLojas-1] = new Dados_Lojas(
                        Lojas[b].getNomeLoja(),
                        Lojas[b].getImagemLoja(),
                        Lojas[b].getMapa(),
                        Lojas[b].getCoordX(),
                        Lojas[b].getCoordY(),
                        Lojas[b].getProdutos()
                    );
                }
            }
            Lojas = NovaGaleria;
        }
    }

    public Dados_Lojas[] getLojas(){return Lojas;}
    public void setLojas(Dados_Lojas NovasLojas[]){Lojas=NovasLojas;}
}
