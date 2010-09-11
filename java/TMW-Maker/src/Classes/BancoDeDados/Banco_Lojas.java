package Classes.BancoDeDados;

public class Banco_Lojas {
    private static Dados_Lojas galeria[]; //Não deve ser instaciado agora!!!!
    public Banco_Lojas(String Arquivo){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void addLoja(String nomeLoja, int imagemILoja, String mapa, int coordX, int coordY){
        if(galeria != null){
            Dados_Lojas novaGaleria[] = new Dados_Lojas[galeria.length+1];
            for(int b=0;b<galeria.length;b++){
                novaGaleria[b] = new Dados_Lojas(
                    galeria[b].getNomeLoja(),
                    galeria[b].getImagemLoja(),
                    galeria[b].getMapa(),
                    galeria[b].getCoordX(),
                    galeria[b].getCoordY()
                );
            }
            novaGaleria[galeria.length] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            galeria = novaGaleria;
        }else{
            Dados_Lojas novaGaleria[] = new Dados_Lojas[1];
            novaGaleria[0] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            galeria = novaGaleria;
        }
    }
    public void addLoja(String nomeLoja, int imagemILoja, String mapa, int coordX, int coordY, Dados_LojaProduto NovosProdutos[]){
        if(galeria != null){
            Dados_Lojas novaGaleria[] = new Dados_Lojas[galeria.length+1];
            for(int b=0;b<galeria.length;b++){
                novaGaleria[b] = new Dados_Lojas(
                    galeria[b].getNomeLoja(),
                    galeria[b].getImagemLoja(),
                    galeria[b].getMapa(),
                    galeria[b].getCoordX(),
                    galeria[b].getCoordY(),
                    galeria[b].getProdutos()
                );
            }
            novaGaleria[galeria.length] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            galeria = novaGaleria;
        }else{
            Dados_Lojas novaGaleria[] = new Dados_Lojas[1];
            novaGaleria[0] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            galeria = novaGaleria;
        }
    }
    public void delLojaPorNome(String nomeLoja){
        if(galeria != null){
            Dados_Lojas novaGaleria[] = new Dados_Lojas[galeria.length-1];
            int contLojas=0;
            for(int b=0;b<galeria.length;b++){
                if(galeria[b].getNomeLoja().equals(nomeLoja)){
                    contLojas++;
                    novaGaleria[contLojas-1] = new Dados_Lojas(
                        galeria[b].getNomeLoja(),
                        galeria[b].getImagemLoja(),
                        galeria[b].getMapa(),
                        galeria[b].getCoordX(),
                        galeria[b].getCoordY(),
                        galeria[b].getProdutos()
                    );
                }
            }
            galeria = novaGaleria;
        }
    }
    public void delLojaPorOrdem(int ordem){
        if(galeria != null){
            Dados_Lojas novaGaleria[] = new Dados_Lojas[galeria.length-1];
            int contLojas=0;
            for(int b=0;b<galeria.length;b++){
                if(b!=ordem){
                    contLojas++;
                    novaGaleria[contLojas-1] = new Dados_Lojas(
                        galeria[b].getNomeLoja(),
                        galeria[b].getImagemLoja(),
                        galeria[b].getMapa(),
                        galeria[b].getCoordX(),
                        galeria[b].getCoordY(),
                        galeria[b].getProdutos()
                    );
                }
            }
            galeria = novaGaleria;
        }
    }
    public void delGaleria(){galeria=null;}

    public Dados_Lojas[] getLojas(){return galeria;}
    public int getContLojas(){
         if(galeria != null){
             return galeria.length;
         }else{
             return 0;
         }
    }
    public void setLojas(Dados_Lojas NovasLojas[]){galeria=NovasLojas;}
}
